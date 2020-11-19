package com.github.happyjiahui.wx.service.impl;

import com.github.happyjiahui.wx.config.WxButtonType;
import com.github.happyjiahui.wx.config.WxConfig;
import com.github.happyjiahui.wx.form.WxValidateForm;
import com.github.happyjiahui.wx.service.IWxService;
import com.github.happyjiahui.wx.vo.WxAccessTokenVO;
import com.github.happyjiahui.wx.vo.WxButtonVO;
import com.github.happyjiahui.wx.vo.WxCustomMenuVO;
import com.github.happyjiahui.wx.vo.WxResponseVO;
import com.github.happyjiahui.z.util.JsonUtils;
import com.github.happyjiahui.z.web.exception.BusinessException;
import com.google.common.collect.Lists;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
public class WxServiceImpl implements IWxService {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");


    @Resource
    private WxConfig wxConfig;

    @Override
    public String validate(WxValidateForm wxValidateForm) {
        List<String> list = Lists.newArrayList();
        list.add(wxConfig.getToken());
        list.add(String.valueOf(wxValidateForm.getTimestamp()));
        list.add(wxValidateForm.getNonce());

        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        for (String item : list) {
            builder.append(item);
        }
        String s1 = DigestUtils.sha1Hex(builder.toString());
        if (wxValidateForm.getSignature().equals(s1)) {
            return wxValidateForm.getEchostr();
        } else {
            return "";
        }
    }

    @Override
    public WxAccessTokenVO getAccessToken() {
        String appId = wxConfig.getAppId();
        String appSecret = wxConfig.getAppSecret();

        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return JsonUtils.parseObj(Objects.requireNonNull(response.body()).string(), WxAccessTokenVO.class);
        } catch (IOException e) {
            throw new BusinessException("url请求失败", e);
        }
    }

    @Override
    public Boolean createWxMenu() {
        List<WxButtonVO> buttonList = Lists.newArrayList();

        WxButtonVO button = new WxButtonVO();
        button.setName("测试1");
        button.setKey("test1");
        button.setType(WxButtonType.CLICK);
        buttonList.add(button);

        WxButtonVO button2 = new WxButtonVO();
        button2.setName("测试2");
        button2.setKey("test2");
        button2.setType(WxButtonType.VIEW);
        button2.setUrl("http://www.baidu.com");
        buttonList.add(button2);

        WxCustomMenuVO menu = new WxCustomMenuVO(buttonList);

        WxAccessTokenVO accessToken = this.getAccessToken();

        RequestBody body = RequestBody.create(JsonUtils.toString(menu), JSON);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + accessToken.getAccessToken();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        OkHttpClient client = new OkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            String s = Objects.requireNonNull(response.body()).string();
            WxResponseVO wxResp = JsonUtils.parseObj(s, WxResponseVO.class);
            return wxResp.getErrorCode() == 0;
        } catch (IOException e) {
            throw new BusinessException("url请求失败", e);
        }
    }
}

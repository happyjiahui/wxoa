package com.github.happyjiahui.wx.service;

import com.github.happyjiahui.wx.form.WxValidateForm;
import com.github.happyjiahui.wx.vo.WxAccessTokenVO;

public interface IWxService {

    /**
     * 验证消息的确来自微信服务器
     *
     * @param wxValidateForm
     * @return
     */
    String validate(WxValidateForm wxValidateForm);

    /**
     * 获取accessToken
     *
     * @return
     */
    WxAccessTokenVO getAccessToken();

    Boolean createWxMenu();

}

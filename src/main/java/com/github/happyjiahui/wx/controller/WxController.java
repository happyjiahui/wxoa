package com.github.happyjiahui.wx.controller;

import com.github.happyjiahui.wx.config.WxEventType;
import com.github.happyjiahui.wx.config.WxMsgType;
import com.github.happyjiahui.wx.form.WxMessageForm;
import com.github.happyjiahui.wx.form.WxValidateForm;
import com.github.happyjiahui.wx.service.IWxService;
import com.github.happyjiahui.wx.vo.WxTextMessageVO;
import com.github.happyjiahui.z.web.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@Api(tags = "微信")
@RestController
public class WxController {

    @Resource
    private IWxService wxService;

    @ApiOperation(value = "验证消息的确来自微信服务器")
    @GetMapping(value = "/wenxin")
    public String index(@Valid WxValidateForm wxValidateForm) {
        return wxService.validate(wxValidateForm);
    }

    @ApiOperation(value = "处理微信消息")
    @PostMapping(value = "/wenxin", produces = MediaType.APPLICATION_XML_VALUE)
    public WxTextMessageVO index(@RequestBody WxMessageForm wxMessage) {
        String msgType = wxMessage.getMsgType();
        switch (msgType) {
            case WxMsgType.TEXT:
                System.err.println("text");
                break;
            case WxMsgType.EVENT:
                String event = wxMessage.getEvent();
                switch (event) {
                    case WxEventType.CLICK:
                        System.err.println("click");
                        break;
                    case WxEventType.VIEW:
                        System.err.println("view");
                        break;
                    default:
                        break;
                }
            default:
                break;
        }
        return new WxTextMessageVO(wxMessage.getFromUser(), wxMessage.getToUser(),
                System.currentTimeMillis(), WxMsgType.TEXT, "hello world");
    }

    @ApiOperation(value = "创建公众号自定义菜单")
    @PostMapping(value = "createWxMenu")
    public ResponseResult<Boolean> createWxMenu() {
        Boolean result = wxService.createWxMenu();
        return ResponseResult.SUCCESS(result);
    }

}

package com.github.happyjiahui.wx.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WxValidateForm {
    @NotNull
    private String signature;
    @NotNull
    private Long timestamp;
    @NotNull
    private String nonce;
    @NotNull
    private String echostr;
}

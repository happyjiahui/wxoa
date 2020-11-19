package com.github.happyjiahui.wx.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxResponseVO {

    @JsonAlias(value = "errorcode")
    private int errorCode;
    @JsonAlias(value = "errmsg")
    private String errmsg;

}

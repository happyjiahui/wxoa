package com.github.happyjiahui.wx.vo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxAccessTokenVO {

    @JsonAlias(value = "access_token")
    private String accessToken;
    @JsonAlias(value = "expires_in")
    private long expiresIn;

}

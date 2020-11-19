package com.github.happyjiahui.wx.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class WxConfig {

    @Value("${app.token}")
    private String token;
    @Value("${app.id}")
    private String appId;
    @Value("${app.secret}")
    private String appSecret;

}

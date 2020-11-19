package com.github.happyjiahui.wx.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("用户视图")
public class UserVO {

    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("身份证")
    private String idCard;
    @ApiModelProperty("年龄")
    private int age;

}

package com.github.happyjiahui.wx.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 公众号自定义菜单
 */
@Getter
@Setter
@AllArgsConstructor
public class WxCustomMenuVO {
    private List<WxButtonVO> button;
}

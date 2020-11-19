package com.github.happyjiahui.wx.config;

public class WxEventType {

    /**
     * 用户未关注时，进行关注后的事件推送
     */
    public static final String SUBSCRIBE = "subscribe";
    /**
     * 用户已关注时的事件推送
     */
    public static final String SCAN = "SCAN";
    /**
     * 上报地理位置事件
     */
    public static final String LOCATION = "LOCATION";
    /**
     * 自定义菜单事件
     */
    public static final String CLICK = "CLICK";
    /**
     * 点击菜单跳转链接时的事件推送
     */
    public static final String VIEW = "VIEW";

}

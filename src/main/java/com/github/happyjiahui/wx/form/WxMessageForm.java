package com.github.happyjiahui.wx.form;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JacksonXmlRootElement(localName = "xml")
public class WxMessageForm {

    /**
     * 开发者微信号
     */
    @JacksonXmlProperty(localName = "ToUserName")
    private String toUser;
    /**
     * 发送方帐号（一个OpenID）
     */
    @JacksonXmlProperty(localName = "FromUserName")
    private String fromUser;
    /**
     * 消息创建时间 （整型）
     */
    @JacksonXmlProperty(localName = "CreateTime")
    private Long createTime;
    /**
     * 消息类型
     */
    @JacksonXmlProperty(localName = "MsgType")
    private String msgType;
    /**
     * 文本消息内容
     */
    @JacksonXmlProperty(localName = "Content")
    private String content;
    /**
     * 消息id，64位整型
     */
    @JacksonXmlProperty(localName = "MsgId")
    private Long msgId;
    /**
     * 图片链接（由系统生成）
     */
    @JacksonXmlProperty(localName = "PicUrl")
    private String picUrl;
    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据
     */
    @JacksonXmlProperty(localName = "MediaId")
    private String mediaId;
    /**
     * 语音格式，如amr，speex等
     */
    @JacksonXmlProperty(localName = "Format")
    private String format;
    /**
     * 语音识别结果，UTF8编码
     */
    @JacksonXmlProperty(localName = "Recognition")
    private String recognition;
    /**
     * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
     */
    @JacksonXmlProperty(localName = "ThumbMediaId")
    private String thumbMediaId;
    /**
     * 地理位置纬度
     */
    @JacksonXmlProperty(localName = "Location_X")
    private String locationX;
    /**
     * 地理位置经度
     */
    @JacksonXmlProperty(localName = "Location_Y")
    private String locationY;
    /**
     * 地图缩放大小
     */
    @JacksonXmlProperty(localName = "Scale")
    private int scale;
    /**
     * 地理位置信息
     */
    @JacksonXmlProperty(localName = "Label")
    private String label;
    /**
     * 消息标题
     */
    @JacksonXmlProperty(localName = "Title")
    private String title;
    /**
     * 消息描述
     */
    @JacksonXmlProperty(localName = "Description")
    private String description;
    /**
     * 消息链接
     */
    @JacksonXmlProperty(localName = "Url")
    private String url;
    /**
     * 事件
     */
    @JacksonXmlProperty(localName = "Event")
    private String event;
    /**
     * 事件KEY值
     */
    @JacksonXmlProperty(localName = "EventKey")
    private String eventKey;
    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @JacksonXmlProperty(localName = "Ticket")
    private String ticket;
    /**
     * 地理位置纬度
     */
    @JacksonXmlProperty(localName = "Latitude")
    private String latitude;
    /**
     * 地理位置经度
     */
    @JacksonXmlProperty(localName = "Longitude")
    private String longitude;
    /**
     * 地理位置精度
     */
    @JacksonXmlProperty(localName = "Precision")
    private String precision;

}

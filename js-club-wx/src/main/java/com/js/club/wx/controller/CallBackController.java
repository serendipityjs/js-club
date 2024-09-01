package com.js.club.wx.controller;

import com.js.club.wx.handler.WxChatMsgFactory;
import com.js.club.wx.handler.WxChatMsgHandler;
import com.js.club.wx.utils.MessageUtil;
import com.js.club.wx.utils.SHA1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Classname CallBackController
 * @Description
 * @Date 2024/8/21
 * @Created by jiaoshuai
 */
@RestController
@Slf4j
public class CallBackController {
    //接入微信公众号token
    public static final String token = "jiaoshuai";

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @Resource
    private WxChatMsgFactory wxChatMsgFactory;


    /**
     * 回调消息校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam("signature") String signature, @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce, @RequestParam("echostr") String echostr) {
        log.info("get验签请求参数:signature:{},timestamp:{},nonce:{},echostr:{}", signature, timestamp, nonce, echostr);
        String sha1 = SHA1.getSHA1(token, timestamp, nonce, "");
        if (signature.equals(sha1)) {
            return echostr;
        }
        return "unknown";
    }

    /**
     * 接受微信公众号信息
     *
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @param msgSignature
     * @return
     */
    @PostMapping(value = "callback", produces = "application/xml;charset=UTF-8")
    public String callback(
            @RequestBody String requestBody,
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam(value = "msg_signature", required = false) String msgSignature) {
        log.info("接收到微信消息：requestBody：{}", requestBody);
        Map<String, String> messageMap = MessageUtil.parseXml(requestBody);
        String msgType = messageMap.get("MsgType");
        String event = messageMap.get("Event") == null ? "" : messageMap.get("Event");
        log.info("msgType:{},event:{}", msgType, event);

        StringBuilder sb = new StringBuilder();
        sb.append(msgType);
        if (!StringUtils.isEmpty(event)) {
            sb.append(".");
            sb.append(event);
        }
        String msgTypeKey = sb.toString();
        WxChatMsgHandler wxChatMsgHandler = wxChatMsgFactory.getHandlerByMsgType(msgTypeKey);
        if (Objects.isNull(wxChatMsgHandler)) {
            return "unknown";
        }
        String replyContent = wxChatMsgHandler.dealMsg(messageMap);
        log.info("replyContent:{}", replyContent);
        return replyContent;
    }
}

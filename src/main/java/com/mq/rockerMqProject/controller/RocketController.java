package com.mq.rockerMqProject.controller;


import com.mq.rockerMqProject.config.producer.RocketMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : rocker-mq-project
 * @moduleName : rocker-mq-project
 * @className : com.mq.rockerMqProject.controller.RocketController
 * @date : 2024/4/9 14:41
 */
@RestController
public class RocketController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private RocketMQProducer rocketMQProducer;

    @RequestMapping(value = "/rocket", method = RequestMethod.GET)
    public void noTag() {
        // convertAndSend() 发送普通字符串消息
        rocketMQTemplate.convertAndSend("sendMessage_topic", "Hello Word");
    }

    @RequestMapping(value = "/tagA", method = RequestMethod.GET)
    public void tagA() {
        try {
            SendResult send = rocketMQProducer.send("xsj", "tag", "你好啊！");
            String msgId = send.getMsgId();
            System.out.println("msgId:"+msgId);
            String string = send.toString();
            System.out.println(string);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        rocketMQTemplate.asyncSend("xsj:tag", "hello world tagA",null);
    }
}

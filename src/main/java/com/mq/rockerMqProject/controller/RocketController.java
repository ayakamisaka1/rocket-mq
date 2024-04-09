package com.mq.rockerMqProject.controller;


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

    @RequestMapping(value = "/rocket", method = RequestMethod.GET)
    public void noTag() {
        // convertAndSend() 发送普通字符串消息
        rocketMQTemplate.convertAndSend("sendMessage_topic", "Hello Word");
    }

    @RequestMapping(value = "/tagA", method = RequestMethod.GET)
    public void tagA() {
        rocketMQTemplate.convertAndSend("test:tag", "hello world tagA");
    }
}

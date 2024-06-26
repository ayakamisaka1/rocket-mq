package com.mq.rockerMqProject.config.consumer;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import netscape.javascript.JSObject;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : rocker-mq-project
 * @moduleName : rocker-mq-project
 * @className : com.mq.rockerMqProject.config.consumer.Consumer
 * @date : 2024/4/10 17:01
 */

@Component
@RocketMQMessageListener(topic = "xsj",
        //selectorExpression = "tag1",
        messageModel = MessageModel.BROADCASTING,
        consumerGroup = "lyf-consumer-group")
@Slf4j
public class Consumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println(new String(messageExt.getBody()));
    }
}


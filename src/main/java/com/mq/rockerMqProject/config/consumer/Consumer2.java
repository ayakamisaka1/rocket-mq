package com.mq.rockerMqProject.config.consumer;

import lombok.extern.slf4j.Slf4j;
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
 * @className : com.mq.rockerMqProject.config.consumer.Consumer2
 * @date : 2024/4/11 10:13
 */
@Component
@RocketMQMessageListener(topic = "lyf",
        //selectorExpression = "tag1",
        messageModel = MessageModel.BROADCASTING,
        consumerGroup = "xsj-consumer-group")
@Slf4j
public class Consumer2 implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println(new String(messageExt.getBody()));
    }
}

package com.mq.rockerMqProject.config.consumer;

import lombok.extern.slf4j.Slf4j;
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
@RocketMQMessageListener(topic = "xsj",consumerGroup = "my-consumer-group")
@Slf4j
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println(message);
    }
}


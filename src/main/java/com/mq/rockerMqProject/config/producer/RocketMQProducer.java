package com.mq.rockerMqProject.config.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
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
 * @className : com.mq.rockerMqProject.config.producer.RocketMQProducer
 * @date : 2024/4/10 16:15
 */
@Component
public class RocketMQProducer {
    private DefaultMQProducer producer;

    public RocketMQProducer(DefaultMQProducer producer) {
        this.producer = producer;
    }

    public SendResult send(String topic, String tags, String body) throws Exception {
        Message message = new Message(topic, tags, body.getBytes());
        return producer.send(message);
    }
}

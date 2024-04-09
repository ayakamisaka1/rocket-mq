//package com.mq.rockerMqProject.config;
//
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * <p>
// * springboot 3.0 问题解决
// * </p>
// *
// * @author : ayaka
// * @version : 1.0
// * @appName : rocker-mq-project
// * @moduleName : rocker-mq-project
// * @className : com.mq.rockerMqProject.config.RocketMqConfig
// * @date : 2024/4/9 15:37
// */
//@Configuration
//public class RocketMqConfig {
//    @Value("${rocketmq.producer.group}")
//    private String producerGroup;
//
//    @Value("${rocketmq.name-server}")
//    private String nameServer;
//
//    /**
//     * 由于使用的Spring版本是3.0.0以上，与rocketMq不是很兼容，对于rocketMqTemplate
//     * 的自动注入存在差异，如果不采用这种方式注入则会报出缺少bean的信息
//     */
//    @Bean("RocketMqTemplate")
//    public RocketMQTemplate rocketMqTemplate(){
//        RocketMQTemplate rocketMqTemplate = new RocketMQTemplate();
//        DefaultMQProducer defaultMqProducer = new DefaultMQProducer();
//        defaultMqProducer.setProducerGroup(producerGroup);
//        defaultMqProducer.setNamesrvAddr(nameServer);
//        rocketMqTemplate.setProducer(defaultMqProducer);
//        return rocketMqTemplate;
//    }
//}

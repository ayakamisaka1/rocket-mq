//package com.mq.rockerMqProject.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.apache.rocketmq.spring.support.RocketMQMessageConverter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.messaging.converter.CompositeMessageConverter;
//import org.springframework.messaging.converter.MappingJackson2MessageConverter;
//import org.springframework.messaging.converter.MessageConverter;
//
//import java.util.List;
//
///**
// * <p>
// *
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
//
//    @Bean
//    @Primary
//    public RocketMQMessageConverter enhanceRocketMQMessageConverter(){
//        RocketMQMessageConverter converter = new RocketMQMessageConverter();
//        CompositeMessageConverter compositeMessageConverter = (CompositeMessageConverter) converter.getMessageConverter();
//        List<MessageConverter> messageConverterList = compositeMessageConverter.getConverters();
//        for (MessageConverter messageConverter : messageConverterList) {
//            if(messageConverter instanceof MappingJackson2MessageConverter){
//                MappingJackson2MessageConverter jackson2MessageConverter = (MappingJackson2MessageConverter) messageConverter;
//                ObjectMapper objectMapper = jackson2MessageConverter.getObjectMapper();
//                objectMapper.registerModules(new JavaTimeModule());
//            }
//        }
//        return converter;
//    }
//}

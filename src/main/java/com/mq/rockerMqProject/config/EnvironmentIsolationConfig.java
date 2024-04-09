//package com.mq.rockerMqProject.config;
//
//import org.apache.rocketmq.spring.support.DefaultRocketMQListenerContainer;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StringUtils;
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
// * @className : com.mq.rockerMqProject.config.EnvironmentIsolationConfig
// * @date : 2024/4/9 19:27
// */
//
//@Configuration
//public class EnvironmentIsolationConfig implements BeanPostProcessor {
//    @Value("${rocketmq.enhance.enabledIsolation:true}")
//    private boolean enabledIsolation;
//    @Value("${rocketmq.enhance.environment:''}")
//    private String environmentName;
//
//    /**
//     * 在装载Bean之前实现参数修改
//     */
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        if(bean instanceof DefaultRocketMQListenerContainer){
//
//            DefaultRocketMQListenerContainer container = (DefaultRocketMQListenerContainer) bean;
//            //拼接Topic
//            if(enabledIsolation && StringUtils.hasText(environmentName)){
//                container.setTopic(String.join("_", container.getTopic(),environmentName));
//            }
//            return container;
//        }
//        return bean;
//    }
//}

package com.demo.dubbo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
@ConditionalOnMissingClass
@PropertySource(value = "classpath:/application.properties")
public class AnnotationBeanConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(AnnotationBeanConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public AnnotationBean annotationBean(@Value("${dubbo.annotation.package-name}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        logger.info("=====>AnnotationBeanConfiguration packageName is{}", packageName);
        return annotationBean;
    }
}

package com.bytehonor.sdk.server.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.bytehonor.sdk.server.spring.web.advisor.ResponseExceptionAdvisor;
import com.bytehonor.sdk.server.spring.web.advisor.ResponseStandardAdvisor;

import jakarta.servlet.Servlet;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
@AutoConfigureAfter(ServerWebConfiguration.class)
public class ResponseStandardConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseStandardConfiguration.class);

    @Bean
    @ConditionalOnMissingBean(value = ResponseExceptionAdvisor.class)
    ResponseExceptionAdvisor responseExceptionAdvisor() {
        LOG.info("[Bytehonor] ResponseExceptionAdvisor");
        return new ResponseExceptionAdvisor();
    }

    @Bean
    @ConditionalOnMissingBean(value = ResponseStandardAdvisor.class)
    ResponseStandardAdvisor responseStandardAdvisor() {
        LOG.info("[Bytehonor] ResponseStandardAdvisor");
        return new ResponseStandardAdvisor();
    }
}
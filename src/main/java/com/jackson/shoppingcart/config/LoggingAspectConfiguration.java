package com.jackson.shoppingcart.config;

import com.jackson.shoppingcart.aop.logging.LoggingAspect;

import com.jackson.shoppingcart.config.ShoppingCartConstants;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @Profile(ShoppingCartConstants.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}

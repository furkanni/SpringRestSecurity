package com.innova.beantuto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class _02_BeanScope {

    @Bean
    @Scope("prototype")
    public BeanDto beanScope() {

        return BeanDto.builder().id(0L).beanData("Data").beanName("Adı 11245").build();
    }

}

package com.imooc.config;

import com.imooc.listener.ApplicationStartListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenhaitao on 2018/4/7.
 */
@Configuration
public class TestConfiguration {
    @Bean
    public ApplicationStartListener applicationStartListener(){
        return new ApplicationStartListener();
    }
}

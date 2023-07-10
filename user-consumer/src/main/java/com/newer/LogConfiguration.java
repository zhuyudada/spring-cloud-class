package com.newer;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class LogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

}

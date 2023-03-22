package cn.itcast.feign.feign;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class DefaultConfiguration {
    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.BASIC;
    }
}

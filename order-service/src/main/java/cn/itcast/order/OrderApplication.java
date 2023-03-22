package cn.itcast.order;

import cn.itcast.feign.clients.UserClients;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = UserClients.class,defaultConfiguration = FeignClientsConfiguration.class)  //配置全局feign日志配置
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    @LoadBalanced       // 负载均衡  默认为轮询
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /*
    @Bean       //随机
    public IRule randomrule(){
        return new RandomRule();
    }
     */

}
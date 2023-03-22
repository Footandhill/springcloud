package cn.itcast.feign.clients;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "userservice",configuration = FeignClientsConfiguration.class)  配置局部feign日志配置
@FeignClient("userservice")
public interface UserClients {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}

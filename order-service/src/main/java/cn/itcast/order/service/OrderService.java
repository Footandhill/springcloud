package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClients;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClients userClients;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.使用feign进行远程调用
        User user = userClients.findById(order.getUserId());
        // 3.封装user信息
        order.setUser(user);
        // 4.返回
        return order;
   }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2. TODO: 查询用户
//        String url = "http://userservice/user/" + order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        // 3.封装user信息
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }


}

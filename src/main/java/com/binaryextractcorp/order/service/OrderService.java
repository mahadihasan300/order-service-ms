package com.binaryextractcorp.order.service;

import com.binaryextractcorp.order.dto.OrderDTO;
import com.binaryextractcorp.order.dto.OrderDTOFromFE;
import com.binaryextractcorp.order.dto.UserDTO;
import com.binaryextractcorp.order.entity.Order;
import com.binaryextractcorp.order.mapper.OrderMapper;
import com.binaryextractcorp.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {

        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());

        Order orderToBeSave = new Order(newOrderId,orderDetails.getFoodItemList(),orderDetails.getRestaurant(),userDTO);

        orderRepo.save(orderToBeSave);

        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSave);
    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {

        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);

    }
}

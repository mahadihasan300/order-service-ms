package com.binaryextractcorp.order.entity;

import com.binaryextractcorp.order.dto.FoodItemDTO;
import com.binaryextractcorp.order.dto.Restaurant;
import com.binaryextractcorp.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {
    private Integer orderId;
    private List<FoodItemDTO> foodItemList;
    private Restaurant restaurant;
    private UserDTO userDTO;


}

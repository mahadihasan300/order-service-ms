package com.binaryextractcorp.order.mapper;

import com.binaryextractcorp.order.dto.OrderDTO;
import com.binaryextractcorp.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOtoOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);
}

package com.dhriti.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dhriti.orderservice.mapper.OrderLineItemsMapper;
import com.dhriti.orderservice.model.Order;
import com.dhriti.orderservice.model.OrderLineItems;
import com.dhriti.orderservice.orderDTO.OrderLineItemsDTO;
import com.dhriti.orderservice.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	private final OrderLineItemsMapper orderLineItemsMapper;
	

	private final OrderRepository orderRepository;
	
	public OrderService(OrderLineItemsMapper orderLineItemsMapper, OrderRepository orderRepository) {
		this.orderLineItemsMapper = orderLineItemsMapper;
		this.orderRepository = orderRepository;
	}
	
	public void createOrderRequest(List<OrderLineItemsDTO> orderLineItemsDTO) {
		List<OrderLineItems> orderLineItemsList = orderLineItemsMapper.OrderLineItemstEntityTOOrderLineItemsDTO(orderLineItemsDTO);
		Order order = new Order();
		order.setOrderLineItems(orderLineItemsList);
		orderRepository.save(order);
	}
	
}

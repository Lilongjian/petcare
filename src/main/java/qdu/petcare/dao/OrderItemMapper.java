package qdu.petcare.dao;

import java.util.List;

import qdu.petcare.pojo.Order;
import qdu.petcare.pojo.OrderItem;

public interface OrderItemMapper {
	
	List<OrderItem> findOrderItemByorder_no(Long orderNo);

	int addOrderItem(OrderItem orderItem);

	int add(Order order);

	List<Object> findorderByUser(Integer id);

	List<OrderItem> findByOrderNo(Long orderNo);

	Order selectById(String id);

}

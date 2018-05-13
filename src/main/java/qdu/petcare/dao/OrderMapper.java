package qdu.petcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import qdu.petcare.pojo.Order;
import qdu.petcare.pojo.OrderItem;
import qdu.petcare.pojo.Product;

public interface OrderMapper {
	
	List<Order> findOrder(Integer user_id);

	int getTotalCount();

	void deletById(int id);

	List<Product> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);

	boolean addOrder(Order order);

	boolean addOrderItem(OrderItem orderItem);

}

package qdu.petcare.service;

import java.util.List;

import qdu.petcare.pojo.Order;
import qdu.petcare.pojo.OrderItem;
import qdu.petcare.vo.PageBean;

public interface IOrderService {


	List<Order> findOrder(Integer user_id);

	PageBean getPageBean(Integer pageIndex, int pageSize);

	void deletById(int id);

	boolean addOrder(Order order);

	boolean addOrderItem(OrderItem orderItem);

}

package qdu.petcare.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qdu.petcare.dao.OrderItemMapper;
import qdu.petcare.pojo.Order;
import qdu.petcare.pojo.OrderItem;
import qdu.petcare.service.IOrderItemService;

@Service
public class OrderItemServiceImpl implements IOrderItemService {
	@Autowired
	private OrderItemMapper orderItemMapper;

	@Override
	public List<OrderItem> findOrderItemByorder_no(Long orderNo) {
		return orderItemMapper.findOrderItemByorder_no(orderNo);
	}

	@Override
	public boolean add(Order order) {
		int result = orderItemMapper.add(order);
		return result > 0 ? true : false;
	}

	@Override
	public int addOrderItem(OrderItem orderItem) {
		return orderItemMapper.addOrderItem(orderItem);
	}

	@Override
	public List<Object> findorderByUser(Integer id) {
		return orderItemMapper.findorderByUser(id);
	}

	@Override
	public List<OrderItem> findByOrder(Long orderNo) {
		return orderItemMapper.findByOrderNo(orderNo);
	}

	@Override
	public Order selectById(String id) {
		return orderItemMapper.selectById(id);
	}


	
}
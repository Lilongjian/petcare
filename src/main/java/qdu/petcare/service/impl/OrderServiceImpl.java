package qdu.petcare.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import qdu.petcare.dao.OrderMapper;
import qdu.petcare.pojo.Order;
import qdu.petcare.pojo.OrderItem;
import qdu.petcare.pojo.Product;
import qdu.petcare.service.IOrderService;
import qdu.petcare.vo.PageBean;

@Service("orderService")
public class OrderServiceImpl implements IOrderService{
	@Resource(name="orderDao")
	private OrderMapper orderMapper;
	


	@Override
	public List<Order> findOrder(Integer user_id) {
		return orderMapper.findOrder(user_id);
	}



	@Override
	public PageBean getPageBean(Integer pageIndex, int pageSize) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(pageIndex);
		//private Integer pageSize;
		pageBean.setPageSize(pageSize);
		//private Integer totalCount; 
		int totalCount = orderMapper.getTotalCount();
		//int totalCount = 7;
		pageBean.setTotalCount(totalCount);
		//private Integer totalPage;
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize); 
		pageBean.setTotalPage(totalPage);
		//private List<Student> list;
		int index = (pageIndex - 1) * pageSize;
		//SELECT * FROM student WHERE LIMIT 0,3;
		List<Product> list = orderMapper.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public void deletById(int id) {
		orderMapper.deletById(id);
		
	}



	@Override
	public boolean addOrder(Order order) {
		return orderMapper.addOrder(order);
	}



	@Override
	public boolean addOrderItem(OrderItem orderItem) {
		return orderMapper.addOrderItem(orderItem);
	}

}

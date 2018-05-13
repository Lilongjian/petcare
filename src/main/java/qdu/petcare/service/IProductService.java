package qdu.petcare.service;

import java.util.List;

import qdu.petcare.pojo.Category;
import qdu.petcare.pojo.Product;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

public interface IProductService {

	List<Product> findAll();

	void deletById(int id);

	PageBean<Product> searchByCondition(SearchCondition searchCondition);

	List<Category> findAllCategory();

	Product selectById(int id);

	List<Product> searchByCondition(Product product);

	void update(Product product);

	void add(Product product);

	PageBean<Product> getPageBean(int pageIndex, int pageSize);

	List<Product> findCategoryListById(int id);
	

}

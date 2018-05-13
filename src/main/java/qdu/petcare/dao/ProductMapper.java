package qdu.petcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import qdu.petcare.pojo.Category;
import qdu.petcare.pojo.Product;
import qdu.petcare.vo.SearchCondition;



public interface ProductMapper {
	
	List<Product> findAll();
	
	int getTotalCount();

	List<Product> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);
	
	int getTotalCount1(SearchCondition searchCondition);

	List<Product> findPageBeanList1(SearchCondition searchCondition);
	
	void add(Product product);
	
	void deletById(int id);
	
	void update(Product product);
	
	Product selectById(int id);
	
	List<Product> searchByCondition(Product product);

	List<Category> findAllCategory();

	List<Product> findCategoryListById(int id);

}

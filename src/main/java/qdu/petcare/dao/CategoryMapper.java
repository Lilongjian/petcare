package qdu.petcare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import qdu.petcare.pojo.Category;
import qdu.petcare.vo.SearchCondition;



public interface CategoryMapper {
	
	List<Category> findAll();
	
	int getTotalCount();
	
	List<Category> findPageBeanList(@Param("index")int index, @Param("pageSize")int pageSize);
	
	int getTotalCount1(SearchCondition searchCondition);

	List<Category> findPageBeanList1(SearchCondition searchCondition);
	
	void add(Category category);
	
	void deletById(int id);
	
	void update(Category category);
	
	Category selectById(int id);
	
	List<Category> findParentCategory();

}

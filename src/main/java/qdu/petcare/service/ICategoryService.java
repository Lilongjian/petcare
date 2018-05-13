package qdu.petcare.service;

import java.util.List;

import qdu.petcare.pojo.Category;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

public interface ICategoryService {

	List<Category> findAll();

	PageBean<Category> getPageBean(int pageIndex, int pageSize);

	PageBean<Category> searchByCondition(SearchCondition searchCondition);

	void add(Category category);

	void deletById(int id);

	void update(Category category);

	Category selectById(int id);
	
	List<Category> findParentCategory();

}

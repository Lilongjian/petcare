package qdu.petcare.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qdu.petcare.dao.CategoryMapper;
import qdu.petcare.pojo.Category;
import qdu.petcare.pojo.User;
import qdu.petcare.service.ICategoryService;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryMapper categoryMapper;

	@Override
	public List<Category> findAll() {
		return categoryMapper.findAll();
	}

	@Override
	public PageBean<Category> getPageBean(int pageIndex, int pageSize) {
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = categoryMapper.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Category> list = categoryMapper.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Category> searchByCondition(SearchCondition searchCondition) {
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean.setPageIndex(searchCondition.getPageIndex());
		System.out.println(searchCondition.getPageIndex());
		pageBean.setPageSize(searchCondition.getPageSize());
		int totalCount = categoryMapper.getTotalCount1(searchCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / searchCondition.getPageSize());
		pageBean.setTotalPage(totalPage);
		searchCondition.setPageIndex((searchCondition.getPageIndex() - 1) * searchCondition.getPageSize());
		List<Category> list = categoryMapper.findPageBeanList1(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void add(Category category) {
		categoryMapper.add(category);

	}

	@Override
	public void deletById(int id) {
		categoryMapper.deletById(id);
	}

	@Override
	public void update(Category category) {
		categoryMapper.update(category);

	}

	@Override
	public Category selectById(int id) {
		return categoryMapper.selectById(id);
	}

	@Override
	public List<Category> findParentCategory() {
		return	categoryMapper.findParentCategory();
	}
	
	

}

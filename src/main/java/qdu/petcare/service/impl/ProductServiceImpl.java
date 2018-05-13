package qdu.petcare.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qdu.petcare.dao.ProductMapper;
import qdu.petcare.pojo.Category;
import qdu.petcare.pojo.Product;
import qdu.petcare.service.IProductService;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

@Service("productService")
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ProductMapper productMapper;
	
	@Resource(name="staticPageService")
	private IStaticPageService staticPageService;
	@Override
	public List<Product> findAll() {
		return productMapper.findAll();
	}

	@Override
	public PageBean<Product> getPageBean(int pageIndex, int pageSize) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalCount = productMapper.getTotalCount();
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / pageSize); 
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<Product> list = productMapper.findPageBeanList(index, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	@Override
	public PageBean<Product> searchByCondition(SearchCondition searchCondition) {
		PageBean<Product> pageBean = new PageBean<Product>();
		pageBean.setPageIndex(searchCondition.getPageIndex());
		System.out.println(searchCondition.getPageIndex());
		pageBean.setPageSize(searchCondition.getPageSize());
		int totalCount = productMapper.getTotalCount1(searchCondition);
		pageBean.setTotalCount(totalCount);
		int totalPage = (int) Math.ceil(1.0 * totalCount / searchCondition.getPageSize()); 
		pageBean.setTotalPage(totalPage);
		searchCondition.setPageIndex((searchCondition.getPageIndex() - 1) * searchCondition.getPageSize());
		List<Product> list = productMapper.findPageBeanList1(searchCondition);
		pageBean.setList(list);
		return pageBean;
	}
	


	@Override
	public void deletById(int id) {
		productMapper.deletById(id);
	}

	@Override
	public void add(Product product) {
		productMapper.add(product);
		
	}

	@Override
	public Product selectById(int id) {
		return productMapper.selectById(id);
	}

	@Override
	public void update(Product product) {
		productMapper.update(product);
		
	}

	@Override
	public List<Product> searchByCondition(Product product) {
		return productMapper.searchByCondition(product);
	}



	@Override
	public List<Category> findAllCategory() {
		return productMapper.findAllCategory();
	}

	@Override
	public List<Product> findCategoryListById(int id) {
		return productMapper.findCategoryListById(id);
	}


}

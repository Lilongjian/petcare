package qdu.petcare.controller.back;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qdu.petcare.pojo.Category;
import qdu.petcare.service.ICategoryService;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private ICategoryService categoryService; 
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
    }
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Category> list = categoryService.findAll();
		model.addAttribute("list", list);
		for (Category category : list) {
			System.out.println(category);
		}
		return "category";
	}
	

	@RequestMapping(value="/findPageBeanList")
	private ModelAndView findPageBeanList( Integer pageIndex, String pageSizeStr){
		
		System.out.println(pageIndex);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 5;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean =  categoryService.getPageBean(pageIndex, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean",pageBean);
		modelAndView.setViewName("category_list");
		return modelAndView;
	}
	
	@RequestMapping("/searchByCondition")
	private ModelAndView searchByCondition(String pageIndex, String pageSize, String name, String status){
		int pageIndexInt = 1;
		if (pageIndex != null && !pageIndex.equals("")) {
			pageIndexInt = Integer.parseInt(pageIndex);
		}
		int pageSizeInt = 5;
		if (pageSize != null && !pageSize.equals("")) {
			pageSizeInt = Integer.parseInt(pageSize);
		} 
		SearchCondition searchCondition = new SearchCondition(pageIndexInt, pageSizeInt, name,status);
		System.out.println(searchCondition);
		PageBean<Category> pageBean = categoryService.searchByCondition(searchCondition);
		System.out.println(pageBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean",pageBean);
		modelAndView.addObject("searchCondition",searchCondition);
		modelAndView.setViewName("category_list");
		return modelAndView;
	}
	
		
	
	@RequestMapping("/deletById")
	public String deletById(int id) {
		categoryService.deletById(id);
		return "forward:/category/findPageBeanList.action?pageIndex=1";
	}
	
	@RequestMapping(value="/addCategoryServlet",method={RequestMethod.GET,RequestMethod.POST})
	public String addCategoryServlet(Model model,Integer parent_id, String name, Integer status,  Date create_time, Date update_time){
		Category category = new Category();
		category.setParent_id(parent_id);
        category.setName(name);
        category.setStatus(status);
        category.setCreate_time(create_time);
        category.setUpdate_time(update_time);
		categoryService.add(category);
		return "forward:/category/findPageBeanList.action?pageIndex=1";

		
	}
	
	
	
	@RequestMapping(value="/getAddPage", method={RequestMethod.GET, RequestMethod.POST})
	public String getAddPage(Model model){

		return "add_category";
	}
	
	@RequestMapping(value="/toUpdateCategoryServlet",method={RequestMethod.GET,RequestMethod.POST})
	public String toUpdateCategoryServlet(Model model,int id){
		Category category = categoryService.selectById(id);
		System.out.println(category);
		model.addAttribute("category", category);
		return "category_update";
	}

	@RequestMapping(value="/updateCategoryServlet",method={RequestMethod.GET,RequestMethod.POST})
	public String updateCategoryServlet(Category category){
		
		categoryService.update(category);
		return "forward:/category/findPageBeanList.action";
	}
	
	
	
	@RequestMapping(value="/getSearchPage", method={RequestMethod.GET, RequestMethod.POST})
	public String getSearchPage(Model model){
		return "category_search";
	}
	
}

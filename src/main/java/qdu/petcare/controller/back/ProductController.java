package qdu.petcare.controller.back;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import qdu.petcare.pojo.Category;
import qdu.petcare.pojo.Product;
import qdu.petcare.service.ICategoryService;
import qdu.petcare.service.IProductService;
import qdu.petcare.vo.PageBean;
import qdu.petcare.vo.SearchCondition;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;

	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Product> list = productService.findAll();
		model.addAttribute("list", list);
		for (Product product : list) {
			System.out.println(product);
		}
		return "product_list";
	}

	@RequestMapping(value = "/findPageBeanList")
	private ModelAndView findPageBeanList(Integer pageIndex, String pageSizeStr) {

		System.out.println(pageIndex);
		if (pageIndex == null) {
			pageIndex = 1;
		}
		int pageSize = 5;
		if (pageSizeStr != null && !pageSizeStr.equals("")) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		PageBean pageBean = productService.getPageBean(pageIndex, pageSize);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.setViewName("product_list");
		return modelAndView;
	}

	@RequestMapping("/searchByCondition")
	private ModelAndView searchByCondition(String name, String status, String pageIndex, String pageSize) {
		int pageIndexInt = 1;
		if (pageIndex != null && !pageIndex.equals("")) {
			pageIndexInt = Integer.parseInt(pageIndex);
		}
		int pageSizeInt = 5;
		if (pageSize != null && !pageSize.equals("")) {
			pageSizeInt = Integer.parseInt(pageSize);
		}
		SearchCondition searchCondition = new SearchCondition(pageIndexInt, pageSizeInt, name, status);
		System.out.println(searchCondition);

		PageBean<Product> pageBean = productService.searchByCondition(searchCondition);
		System.out.println(pageBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageBean", pageBean);
		modelAndView.addObject("searchCondition", searchCondition);
		modelAndView.setViewName("product_list");
		return modelAndView;
	}

	@RequestMapping("/deletById")
	public String deletById(int id) {
		productService.deletById(id);
		return "forward:/product/findPageBeanList.action?pageIndex=1";
	}

	@RequestMapping(value = "/addProductService")
	private String addProductService(Product product) {
		productService.add(product);
		return "redirect:/product/findPageBeanList.action";
	}

	@RequestMapping("/findAllCategory")
	public String findAllCategory(Model model) {
		List<Category> list = productService.findAllCategory();
		model.addAttribute("list", list);
		for (Category category : list) {
			System.out.println(category);
		}
		return "product_list";
	}

	@RequestMapping(value = "/getAddPage")
	private ModelAndView getAddPage(Product product) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("add_product");
		return modelAndView;
	}

	@RequestMapping(value = "/update")
	private ModelAndView update(int id) {
		Product product = productService.selectById(id);
		List<Category> list = categoryService.findParentCategory();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("product", product);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("product_update");
		return modelAndView;
	}

	@RequestMapping(value = "/updateProduct")
	private String updateProduct(Product product) {
		productService.update(product);
		return "redirect:/product/findPageBeanList.action";
	}

	@RequestMapping(value = "/getSearchPage", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSearchPage(Model model) {
		List<Category> list = productService.findAllCategory();
		model.addAttribute("category", list);
		return "product_search";
	}

	@RequestMapping(value = "/searchByCondition", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchByCondition(Model model, Product product) {
		List<Product> list = productService.searchByCondition(product);
		model.addAttribute("list", list);
		model.addAttribute("category", list);
		for (Product pro : list) {
			System.out.println(pro);
		}
		return "product_search";
	}


}

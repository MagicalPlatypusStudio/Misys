package com.rizomm.vibestemptation.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.rizomm.vibestemptation.bo.Product;
import com.rizomm.vibestemptation.service.BacklogService;

@Controller
public class ProductsController {

	@Autowired
	private BacklogService backlogService;

	@RequestMapping(value = "/productsList.do", method = RequestMethod.GET)
	public ModelAndView productsList() {
		ModelAndView mNv = new ModelAndView("products/productsList");

		mNv.addObject("productsList", this.backlogService.listProducts());
		mNv.addObject("clientsList", this.backlogService.listClients());

		return mNv;
	}

	@RequestMapping(value = "/addProduct.do", method = RequestMethod.GET)
	public ModelAndView addProduct() {
		ModelAndView mNv = new ModelAndView("products/addProduct");

		mNv.addObject("clientsList", this.backlogService.listClients());
		return mNv;
	}

	@RequestMapping(value = "/createProduct.do", method = RequestMethod.POST)
	public ModelAndView createProduct(@RequestParam("label") String _label,
			@RequestParam("description") String _description) {

		// creation of the bean
		Product product = new Product(_label, _description);

		// transmission to the backlog
		this.backlogService.createProduct(product);

		return new ModelAndView(new RedirectView("/productsList.do", true));

	}
	
	@RequestMapping(value = "/modifyProduct/{_id}.do", method = RequestMethod.GET)
	public ModelAndView modifyProduct(@PathVariable int _id) {
		ModelAndView mNv = new ModelAndView("products/modifyProduct");
		
		mNv.addObject("clientsList", this.backlogService.listClients());
		mNv.addObject("product", this.backlogService.getProduct(_id));
		
		return mNv;
	}
	
	@RequestMapping(value = "/modifyProduct/{_id}.do", method = RequestMethod.POST)
	public ModelAndView updateProduct(@RequestParam("label") String _label,
			@RequestParam("description") String _description,
			@PathVariable int _id) {
		
		// creation of the bean
		Product product = new Product(_label, _description, _id);
		
		// transmission to the backlog
		this.backlogService.updateProduct(product);
		
		return new ModelAndView(new RedirectView("/productsList.do", true));
	}
	
	@RequestMapping(value = "/deleteProduct/{_id}.do", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable int _id) {
		return new ModelAndView("products/deleteProduct", "product", this.backlogService.getProduct(_id));
	}
	
	@RequestMapping(value = "/deleteProduct/{_id}.do", method = RequestMethod.POST)
	public ModelAndView destroyProduct(@PathVariable int _id) {
		
		// transmission to the backlog
		this.backlogService.deleteProduct(this.backlogService.getProduct(_id));
		
		return new ModelAndView(new RedirectView("/productsList.do", true));
	}
}

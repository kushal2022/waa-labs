package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@GetMapping
	public String getProductForm(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "ProductForm";
	}

	@PostMapping
	public String saveProduct(Product product) {
		Category category = categoryService.getCategory(product.getCategory().getId());
		product.setCategory(category);
		productService.save(product);
		return "ProductDetails";
	}

	@RequestMapping( "/listproducts")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "ListProducts";
	}


	@RequestMapping("/productfind")
	public String findProduct(Model model, @RequestParam(value="id",required = false) Integer id) {
		if(id!=null){
			Product p= productService.getById(id);
			if(p!=null){
				model.addAttribute("product",p);
				return "SingleProduct";
			}
		}
		return "Find";
	}

	@RequestMapping("/welcome")
	public String welcomePage() {
		return "welcome";
	}
}

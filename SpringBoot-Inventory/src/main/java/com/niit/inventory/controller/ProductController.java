package com.niit.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.inventory.model.Product;
import com.niit.inventory.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listProduct = service.listAll();
		model.addAttribute("listProducts", listProduct);
		return "index";
	}
}

package org.example.springbootmvc.controller;

import org.example.springbootmvc.model.Product;
import org.example.springbootmvc.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //@GetMapping preferable
    // @RequestMapping("/products")
    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
//    @RequestMapping(value = "/products", method = RequestMethod.POST)
    //instead of using name and price requestparam, we can use Product directly, as
    //spring directly creates an object of Product if number of request params and their types
    //and name matches
    public String addProduct(Product p, Model model) {
        productService.addProduct(p);
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

}

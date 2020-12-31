/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ManufacturerEntity;
import entity.ProductEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.ManufacturerRepository;
import repository.ProductDetailsRepository;
import repository.ProductRepository;

/**
 *
 * @author DELL
 */
@Controller
public class SearchProduct {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @Autowired
    ManufacturerRepository manuRepo;

    @RequestMapping(value = "/product", method = RequestMethod.GET)

    public String showProduct(Model model, HttpSession session) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.getProduct();
        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
         List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();
       
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("productList", productList);
        model.addAttribute("manuList", manuList);
        return "listproductDetails";
    }

    @RequestMapping(value = "/search/manufacturer/{id}", method = RequestMethod.GET)
    public String searchShow(Model model, @PathVariable(value = "id") int id, HttpSession session) {

        List<ProductEntity> productList = (List<ProductEntity>) productRepo.getManuFac(id);
        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
         List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();
       
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("manuList", manuList);
        model.addAttribute("productList", productList);

        return "listproductDetails";
    }

    @RequestMapping(value = "/view-all-Product/{pageProductId}", method = RequestMethod.GET)
    public String showAllHotel(@PathVariable int pageProductId, Model model) {

        int countProduct = productRepo.getCountProduct();
        int limitProduct = 6;
        if (pageProductId == 1) {
        } else {
            pageProductId = (pageProductId - 1) * limitProduct + 1;
        }
        List<ProductEntity> productList = productRepo.getAllProduct((pageProductId - 1), limitProduct);
        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
         List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();
       
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("manuList", manuList);
        model.addAttribute("productList", productList);
        model.addAttribute("countProduct", countProduct);

        return "listproductDetails";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
    public String searchProduct(@RequestParam(name = "name") String name, Model model) {
        name = "%" + name + "%";
        List<ProductEntity> productList = productRepo.getSearchProduct(name);
        model.addAttribute("productList", productList);
         List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();
       
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
        model.addAttribute("manuList", manuList);
        return "listproductDetails";
    }
}

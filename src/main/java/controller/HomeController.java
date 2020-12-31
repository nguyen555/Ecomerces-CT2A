/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ProductEntity;
import entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ManufacturerRepository;
import repository.OrdersRepository;
import repository.PromotionRepository;
import repository.ProductRepository;
import repository.UserRepository;

/**
 *
 * @author DELL
 */
@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    PromotionRepository promotionRepo;
    
    @Autowired
    OrdersRepository orderRepo;
    
    @Autowired
    ManufacturerRepository manuRepo;

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showAllCity(Model model, HttpSession session) {
        List<ProductEntity> productDetailsList = (List<ProductEntity>) productRepo.getProductDetails();
        List<ProductEntity> productDetailList = (List<ProductEntity>) productRepo.getProductDetailsRe();
        List<ProductEntity> productDetailListted = (List<ProductEntity>) productRepo.getProductDetailsRepo();
        List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();
       
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("productDetailList", productDetailList);
        model.addAttribute("productDetailListted", productDetailListted);
        model.addAttribute("productDetailsList", productDetailsList);
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByUsername(userName);

        model.addAttribute("users", user);
        return "homepage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "homepage";
    }

     @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showAllHome(Model model) {
        
        int countProduct = productRepo.getCountProduct();
        int countManu = manuRepo.getCountmanu();
        int countUser = userRepo.getCountUser();
        int countOrder = orderRepo.getCountOrders();
        
        model.addAttribute("countProduct", countProduct);
        model.addAttribute("countManu", countManu);
        model.addAttribute("countUser", countUser);
        model.addAttribute("countOrder", countOrder);
         return "home";
    }
}

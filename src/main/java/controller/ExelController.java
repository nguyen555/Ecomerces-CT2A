/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ProductDetailsEntity;
import entity.ProductEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import repository.ProductRepository;

@Controller
public class ExelController {
    @Autowired
    ProductRepository productRepo;
    @RequestMapping(value = "/listexcel", method = RequestMethod.GET)
    public String getExcelProduct(Model model, HttpSession session) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        model.addAttribute("productList", productList);

        return "PdfView";
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView getExcel() {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
        return new ModelAndView("ProductListExcel", "productList", productList);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ColorEntity;
import entity.ManufacturerEntity;
import entity.ProductDetailsEntity;
import entity.ProductEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import repository.ColorRepository;
import repository.ManufacturerRepository;
import repository.ProductDetailsRepository;
import repository.ProductRepository;

/**
 *
 * @author LENOVO
 */
@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @Autowired
    ColorRepository colorRepo;

    @Autowired
    ManufacturerRepository manufacRepo;
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    //public String showAdminLoginPage(Model model) {
    //    return "login/loginPage";
    //}

    @RequestMapping(value = "/listProduct1", method = RequestMethod.GET)
    public String getListCustomer(Model model, HttpSession session) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.getProduct();
        model.addAttribute("productList", productList);

        return "listProduct_1";
    }

    //edit
    @RequestMapping(value = "/editProduct/{id}", method = RequestMethod.GET)
    public String showEditProduct(@PathVariable(value = "id") int id, Model model) {

        ProductEntity productdt = productRepo.findById(id);

        model.addAttribute("productdt", productdt);

        return "editproduct";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(ProductEntity product, Model model) {

        productRepo.save(product);
        productDetailsRepo.save(product.getProductdetails());

        return "listProduct_1";
    }
    //---------Search---------//

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchProcess(ProductEntity product, @RequestParam(name = "searchText") String searchText, String searchText1, Model model) {
        searchText = "%" + searchText + "%";
        searchText1 = searchText;
        List<ProductEntity> productdtList = productRepo.getByNameLikeOrCpuLike(searchText, searchText1);

        model.addAttribute("productList", productdtList);

        return "listProduct_1";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(value = "id") int id, Model model) {

        try {
            productRepo.deleteById(id);

            List<ProductEntity> productList = (List<ProductEntity>) productRepo.findAll();
            model.addAttribute("productList", productList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "listProduct_1";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    public String showAddNewForm(Model model) {

//        ProductEntity product = new ProductEntity();
        ProductDetailsEntity productdetails = new ProductDetailsEntity();
        model.addAttribute("productdetails", productdetails);

        String[] color = {"Black", "White", "Blue", "Green"};
        model.addAttribute("color", color);
        String[] manufac = {"SamSung", "Nokia", "Vsmart", "IPHONE", "Xiaomi", "OPPO"};
        model.addAttribute("color", manufac);

        return "addProduct";
    }

    private void setColor(Model model) {
        List<ColorEntity> colorList = (List<ColorEntity>) colorRepo.findAll();
        if (!colorList.isEmpty()) {
            Map<Integer, String> colorMap = new LinkedHashMap<>();

            for (ColorEntity color : colorList) {
                colorMap.put(color.getId(), color.getColor_type());
            }
            model.addAttribute("colorList", colorMap);
        }
    }

    private void setManufacture(Model model) {
        List<ManufacturerEntity> manufactureList = (List<ManufacturerEntity>) manufacRepo.findAll();
        if (!manufactureList.isEmpty()) {
            Map<Integer, String> manufactureMap = new LinkedHashMap<>();

            for (ManufacturerEntity manufacturer : manufactureList) {
                manufactureMap.put(manufacturer.getId(), manufacturer.getName());
            }
            model.addAttribute("manufactureList", manufactureMap);
        }
    }

    @RequestMapping(value = "/updateadd", method = RequestMethod.POST)
    public String updateAdd(ProductDetailsEntity productDetails,
            @RequestParam("file") MultipartFile file,
            @RequestParam("price") double price,
            @RequestParam("name") String name,
            Model model, HttpSession session) {

        productDetailsRepo.save(productDetails);
        try {
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "E:\\Ecomerces_shopPhone\\src\\main\\webapp\\img";
            File dir = new File(pathName);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Create the file on server
            String fileSource = dir.getAbsolutePath() + File.separator + file.getOriginalFilename();
            File serverFile = new File(fileSource);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            String fileName = file.getOriginalFilename();
            ProductEntity products = new ProductEntity();
            products.setImage(fileName);
            products.setDate(LocalDate.now());
            products.setName(name);
            products.setPrice(price);
            Random rd = new Random();
            int n = 1000000;
            int number = rd.nextInt(n);
            String number1 = Integer.toString(number);
            products.setNumberProduct(number1);
            int productss = productDetails.getId();
            ProductDetailsEntity productDetailss = productDetailsRepo.findById(productss);
            products.setProductdetails(productDetailss);
            productRepo.save(products);

            return "listProduct_1";
        } catch (Exception e) {
            System.out.println(e);
            String errorMessage = "Error when uploading file" + e;
            List<ProductEntity> productList = (List<ProductEntity>) productRepo.getProduct();
            model.addAttribute("productList", productList);
            return "listProduct_1";
        }

    }

    @RequestMapping(value = "/view-all-Product1/{pageProductId}", method = RequestMethod.GET)
    public String show(@PathVariable int pageProductId, Model model) {

        int countProduct = productRepo.getCountProduct();
        int limitProduct = 6;
        if (pageProductId == 1) {
        } else {
            pageProductId = (pageProductId - 1) * limitProduct + 1;
        }
        List<ProductEntity> productList = productRepo.getAllProduct((pageProductId - 1), limitProduct);

        model.addAttribute("productList", productList);
        model.addAttribute("countProduct", countProduct);

        return "listProduct_1";
    }
}

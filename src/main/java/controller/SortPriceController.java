package controller;

import entity.ManufacturerEntity;
import entity.ProductEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.ManufacturerRepository;
import repository.ProductRepository;

@Controller
public class SortPriceController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ManufacturerRepository manuRepo;

    //sort
    @RequestMapping(value = "/sort-by-evaluate-high-to-low", method = RequestMethod.GET)
    public String sortByRateHighToLow(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.sortByEvaluateHighToLow();
        model.addAttribute("productList", productList);
        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
        List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("manuList", manuList);
        return "listproductDetails";
    }

    @RequestMapping(value = "/sort-by-evaluate-low-to-high", method = RequestMethod.GET)
    public String sortByRateLowToHigh(Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.sortByEvaluateLowToHigh();

        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
        List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("manuList", manuList);
        model.addAttribute("productList", productList);

        return "listproductDetails";
    }

    @RequestMapping(value = "/findByPrice/{min}/{max}", method = RequestMethod.GET)
    public String findByPrice(@PathVariable(value = "min") double min, @PathVariable(value = "max") double max, Model model) {
        List<ProductEntity> productList = (List<ProductEntity>) productRepo.findByPrice(min, max);

        List<ManufacturerEntity> manuList = (List<ManufacturerEntity>) manuRepo.getManufacturer();
        List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("manuList", manuList);
        model.addAttribute("productList", productList);

        return "listproductDetails";
    }

    @RequestMapping(value = "/viewProduct/{id}", method = RequestMethod.GET)
    public String viewProduct(@PathVariable(value = "id") int id, Model model) {
        List<ProductEntity> productDetailsList = (List<ProductEntity>) productRepo.findProductById(id);

        model.addAttribute("productDetailsList", productDetailsList);
        return "ViewProduct";
    }
}

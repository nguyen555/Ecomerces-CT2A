package controller;

import entity.ProductEntity;
import entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import repository.CustomerRepository;
import repository.ManufacturerRepository;
import repository.OrdersRepository;
import repository.ProductRepository;
import repository.PromotionRepository;
import repository.UserRepository;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    UserRepository userRepo;
    
     @Autowired
    ManufacturerRepository manuRepo;
    
      @Autowired
    OrdersRepository orderRepo;
     
    @Autowired
    ProductRepository productRepo;

    @Autowired
    PromotionRepository promotionRepo;

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//            public String showStudentPage(Model model) {
//            //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            String Name = "";
//            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//            
//                        
//                CustomerEntity customer = customerRepo.getCustomerByUserName(userName);
//                Name = customer.getName();
//                
//          
//            model.addAttribute("Name", Name);
//            
//           //List<EmployerEntity> employerList = (List<EmployerEntity>) employerRepo.findAll();
//        
//        // model.addAttribute("employerList",employerList);
//        return "homepage";
//             }
    @RequestMapping(value = "/user/user", method = RequestMethod.GET)
    public String showInfomation(Model model, HttpSession session) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userRepo.findByUsername(userName);
        List<ProductEntity> productDetailsList = (List<ProductEntity>) productRepo.getProductDetails();
        List<ProductEntity> productDetailList = (List<ProductEntity>) productRepo.getProductDetailsRe();
        List<ProductEntity> productDetailListted = (List<ProductEntity>) productRepo.getProductDetailsRepo();
        List<ProductEntity> productDetails = (List<ProductEntity>) productRepo.getProductDetailsC();
        List<ProductEntity> productDetailsNew = (List<ProductEntity>) productRepo.getProductNew();

        model.addAttribute("productDetailsNew", productDetailsNew);
        model.addAttribute("productDetailsList", productDetailsList);
        model.addAttribute("productDetails", productDetails);
        model.addAttribute("productDetailList", productDetailList);
        model.addAttribute("productDetailListted", productDetailListted);

        model.addAttribute("users", user);

        return "user/user";
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String showHome(Model model) {
        
         int countProduct = productRepo.getCountProduct();
        int countManu = manuRepo.getCountmanu();
        int countUser = userRepo.getCountUser();
        int countOrder = orderRepo.getCountOrders();
        
        model.addAttribute("countProduct", countProduct);
        model.addAttribute("countManu", countManu);
        model.addAttribute("countUser", countUser);
        model.addAttribute("countOrder", countOrder);

        return "admin/home";
    }

}

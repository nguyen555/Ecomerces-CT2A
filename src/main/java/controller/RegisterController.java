package controller;

import entity.CustomerEntity;
import entity.ProductEntity;
import entity.UserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CustomerRepository;
import repository.ProductRepository;
import repository.PromotionRepository;
import repository.UserRepository;


@Controller
public class RegisterController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    PromotionRepository promotionRepo;

    @Autowired
    UserRepository userRepo;
    
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    //Register
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String showRegisterForm(Model model) {
//        model.addAttribute("users", new UsersEntity());
//        return "register/registerPage"; //return register.jsp
//    }


//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String createNewUser(@Valid @ModelAttribute("users") UserEntity users, CustomerEntity customer, BindingResult result,
//            HttpServletRequest request, HttpSession session) {
//
//        List<UserEntity> usersList = usersRepo.getAllUsers();
//        
//        users.setPassword(users.getPassword());
//        
//        
//        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
//
//        users.setEnabled(true);
//        UserEntity newUser = usersRepo.save(users);
//        
//        
//        userRoleRepo.save(users);
//        customerRepo.save(users);
//        session.setAttribute("users", users);
//
//        //send mail
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setTo(users.customers.getEmail());
//        msg.setSubject("Booking Hotel Web");
//        msg.setText("Congratulations! You have successfully registered for an account.");
//        javaMailSender.send(msg);
//
//        //return "homepage/home";
//        return "redirect:/";
//    }
    
@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model){
        CustomerEntity customer = new CustomerEntity();
        String[] sex={"Male","Female"};
        model.addAttribute("sex",sex);
        model.addAttribute("customer", customer);
        return "register";
    }
    
    
    @RequestMapping(value = "/addnew",method = RequestMethod.POST)
    public String saveNew(CustomerEntity customer, @RequestParam(value = "userName")String userName,@RequestParam(value = "password")String password, Model model){        
            customerRepo.save(customer);
            UserEntity user = new UserEntity();
            int customerId = customer.getId();
            CustomerEntity customers = customerRepo.findById(customerId);
            user.setCustomers(customers);
            user.setUserName(userName);
            user.setPassword(password);
            user.setEnabled(true);
            user.setRole("ROLE_USER");
            userRepo.save(user);
            
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
 
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(user.getCustomers().getEmail());
        msg.setSubject("Create account successfully");
        msg.setText("Congratulations! You have successfully registered for an account"
                  + "\n Your Account  "
                        + "\n        userName: " + user.getUserName()
                        + "\n        Password: " + user.getPassword()
                        + "\n        Name : " + user.getCustomers().getName());
        javaMailSender.send(msg);

          return "homepage";
    }
}

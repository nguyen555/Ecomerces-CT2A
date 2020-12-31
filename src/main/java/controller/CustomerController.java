/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.CustomerEntity;
import entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CustomerRepository;
import repository.UserRepository;

/**
 *
 * @author LENOVO
 */
@Controller
public class CustomerController {
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    UserRepository userRepo;
    
    @RequestMapping(value = "/listCustomer", method = RequestMethod.GET)
    public String getListCustomer(Model model, HttpSession session) {
        List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepo.findAll();
        model.addAttribute("customerList", customerList);

        return "listCustomer";
    }
    @RequestMapping(value = "/editCustomer/{id}", method = RequestMethod.GET)
    public String showEditCustomer(@PathVariable(value = "id") int id, Model model) {
        CustomerEntity customerList = customerRepo.findById(id);

        model.addAttribute("customerList", customerList);

        return "editCustomer";
    }
@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String update( CustomerEntity customerList, Model model) {
        customerRepo.save(customerList);
        
        return "redirect:/listCustomer";
    }
    @RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable(value ="id") int id,CustomerEntity customer, Model model) {
            UserEntity user = userRepo.getUsers(id);
            int users = user.getId();
            UserEntity userss = userRepo.findById(users);
            userRepo.delete(userss);
            CustomerEntity cus = customerRepo.findById(id);
        try {
            customerRepo.delete(cus);

            List<CustomerEntity> customerList = (List<CustomerEntity>) customerRepo.findAll();
            model.addAttribute("customerList", customerList);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "redirect:/listCustomer";
    }
    
      @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(Model model) {
       String [] sex1 = {"Male","Woman"};
       model.addAttribute("sex1",sex1);
        model.addAttribute("customer", new CustomerEntity());

        return "addCustomer";
    }
    @RequestMapping(value = "/updateaddCustomer", method = RequestMethod.POST)
    public String saveCustomer(@RequestParam(value = "userName")String userName,@RequestParam(value = "password")String password,CustomerEntity customer, Model model) {
        customerRepo.save(customer);
                    UserEntity user = new UserEntity();
            int customerId = customer.getId();
            CustomerEntity customers = customerRepo.findById(customerId);
            user.setCustomers(customers);
            user.setUserName(userName);
            user.setPassword(password);
            user.setEnabled(true);
            user.setRole("ROLE_ADMIN");
            userRepo.save(user);
        model.addAttribute("customer", new CustomerEntity());

        return "redirect:/listCustomer";
    }
    @RequestMapping(value = "/searchcustomer", method = RequestMethod.GET)
    public String searchProcess(@RequestParam(name = "searchText") String searchText, String searchText1, Model model) {

        searchText = "%" + searchText + "%";
        List<CustomerEntity> customerList = customerRepo.findByNameLikeOrEmailLikeOrPhoneLike(searchText, searchText, searchText);

        model.addAttribute("customerList", customerList);

        return "listCustomer";
    }
}

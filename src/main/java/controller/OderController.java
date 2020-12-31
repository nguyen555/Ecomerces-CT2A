package controller;

import entity.OrdersDetailsEntity;
import entity.OrdersEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.OrdersDetailsRepository;
import repository.OrdersRepository;

@Controller
public class OderController {

    @Autowired
    OrdersRepository oderRepo;
    @Autowired
    OrdersDetailsRepository oderDetailsRepo;

    @RequestMapping(value = "/listOrder", method = RequestMethod.GET)
    public String getListOder(Model model, HttpSession session) {
        List<OrdersEntity> OrderList = (List<OrdersEntity>) oderRepo.findAll();
        model.addAttribute("OrderList", OrderList);

        return "listOder";
    }

    @RequestMapping(value = "/viewOrderdetails/{id}", method = RequestMethod.GET)
    public String getListOrderdetails(@PathVariable(value = "id") int id, Model model) {
        List<OrdersDetailsEntity> OrderDetailsList = (List<OrdersDetailsEntity>) oderDetailsRepo.getOderDetails(id);
        model.addAttribute("OrderDetailsList", OrderDetailsList);

        return "viewOrderDetails";

    }

    @RequestMapping(value = "/deleteOder/{id}", method = RequestMethod.GET)
    public String deleteOder(@PathVariable(value = "id") int id, Model model) {
        OrdersEntity orderForm = oderRepo.findByid(id);
        try {
            oderRepo.delete(orderForm);
            List<OrdersEntity> OrderList = (List<OrdersEntity>) oderRepo.findAll();
            model.addAttribute("OrderList", OrderList);
        } catch (Exception e) {
            System.out.println(e);
        }
        return "listOder";
    }
    @RequestMapping(value = "/deleteOderdetails/{id}", method = RequestMethod.GET)
    public String deleteOderdt(@PathVariable(value = "id") int id, Model model) {
            OrdersDetailsEntity orderId = oderDetailsRepo.getOderDetailsF(id);
            int orders = orderId.getId();
             OrdersDetailsEntity orderss = oderDetailsRepo.findById(orders);
        try {
            oderDetailsRepo.delete(orderss);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "viewOrderDetails";
    }

    @RequestMapping(value = "/searchOrder", method = RequestMethod.GET)
    public String searchProcess(@RequestParam(name = "searchText") String searchText, String searchText1, Model model) {

        searchText = "%" + searchText + "%";
        List<OrdersEntity> orderList = oderRepo.getBycustomerNameLikeOrEmailLike(searchText, searchText);

        model.addAttribute("OrderList", orderList);

        return "listOder";
    }

    @RequestMapping(value = "/editOder/{id}", method = RequestMethod.GET)
    public String showEditCustomer(@PathVariable(value = "id") int id, Model model) {

        OrdersEntity oderList = oderRepo.findByid(id);

        model.addAttribute("oderList", oderList);

        return "editOder";
    }

    @RequestMapping(value = "/updateOder", method = RequestMethod.POST)
    public String update(OrdersEntity oderList, Model model) {
        oderRepo.save(oderList);

        return "listOder";
    }
}

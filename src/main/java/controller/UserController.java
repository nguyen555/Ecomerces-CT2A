/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserEntity;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import repository.UserRepository;

@Controller
public class UserController {
     @Autowired
     UserRepository userRepo;
     
     @RequestMapping(value = "/listUser", method = RequestMethod.GET)
    public String getListUser(Model model, HttpSession session) {
        List<UserEntity> userList = (List<UserEntity>) userRepo.findAll();
        model.addAttribute("userList", userList);

        return "listUSer";
}
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(value = "id") int id, Model model) {

        try {
           userRepo.deleteById(id);
            List<UserEntity> user = (List<UserEntity>) userRepo.findAll();
            model.addAttribute("user", user );
        } catch (Exception e) {
            System.out.println(e);
        }

        return "listUSer";
    }
}

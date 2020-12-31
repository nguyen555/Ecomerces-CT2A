/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ColorEntity;
import entity.ProductEntity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
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
import repository.ProductRepository;

@Controller
public class ColorController {

    @Autowired
    ColorRepository colorRepo;
    @Autowired
    ProductRepository productRepo;

    @RequestMapping(value = "/listColor", method = RequestMethod.GET)
    public String getListColor(Model model, HttpSession session) {

        List<ColorEntity> ColorList = (List<ColorEntity>) colorRepo.findAll();
        model.addAttribute("ColorList", ColorList);
        return "listColor";
    }

    @RequestMapping(value = "/viewColordetails/{id}", method = RequestMethod.GET)
    public String getListProductfindColor(@PathVariable(value = "id") int id, Model model, HttpSession session) {

        List<ProductEntity> ColorList = (List<ProductEntity>) productRepo.getColorfindProduct(id);
        model.addAttribute("ColorList", ColorList);
        return "viewColordetails";
    }

    @RequestMapping(value = "/editColor/{id}", method = RequestMethod.GET)
    public String showEditColor(@PathVariable(value = "id") int id, Model model) {
        ColorEntity colorList = colorRepo.findById(id);

        model.addAttribute("colorList", colorList);

        return "editColor";
    }

    @RequestMapping(value = "/updateColor", method = RequestMethod.POST)
    public String update(ColorEntity colorList, Model model) {
        colorRepo.save(colorList);

        return "redirect:/listColor";
    }

    @RequestMapping(value = "/addColor", method = RequestMethod.GET)
    public String showAddNewForm(Model model) {

        ColorEntity color = new ColorEntity();

        model.addAttribute("color", color);

        return "addColor";
    }

    @RequestMapping(value = "/updateaddColor", method = RequestMethod.POST)
    public String saveManufacture(@RequestParam("file") MultipartFile file, ColorEntity color, Model model) {
        try {
            byte[] bytes = file.getBytes();
            // Creating the directory to store file
            // Assume uploaded file location on web server is D:\file-upload
            String pathName = "E:\\do_an_thuc_nghiem\\doan\\Ecomerces_shopPhone\\src\\main\\webapp\\img";
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

            color.setImg(file.getOriginalFilename());
            model.addAttribute("color", color);
            List<ColorEntity> ColorList = (List<ColorEntity>) colorRepo.findAll();
            model.addAttribute("ColorList", ColorList);
            colorRepo.save(color);
            return "listColor";
        } catch (Exception e) {
            System.out.println(e);
            String errorMessage = "Error when uploading file" + e;
            List<ColorEntity> ColorList = (List<ColorEntity>) colorRepo.findAll();
            model.addAttribute("ColorList", ColorList);
            model.addAttribute("color", color);
            return "addColor";
        }

    }

    @RequestMapping(value = "/deleteColor/{id}", method = RequestMethod.GET)
    public String deleteColor(@PathVariable(value = "id") int id, Model model) {

        try {
            colorRepo.deleteById(id);
            List<ColorEntity> color = (List<ColorEntity>) colorRepo.findAll();
            List<ColorEntity> ColorList = (List<ColorEntity>) colorRepo.findAll();
            model.addAttribute("ColorList", ColorList);
            model.addAttribute("color", color);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "listColor";
    }
}

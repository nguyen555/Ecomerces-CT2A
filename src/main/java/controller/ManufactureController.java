
package controller;

import entity.ManufacturerEntity;
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
import repository.ManufacturerRepository;
import repository.ProductRepository;

@Controller
public class ManufactureController {
    @Autowired
    ManufacturerRepository manufactureRepo;
    @Autowired
    ProductRepository productRepo;
    
     @RequestMapping(value = "/listManufacture", method = RequestMethod.GET)
    public String getListColor(Model model, HttpSession session) {

        List<ManufacturerEntity> manufactureList = (List<ManufacturerEntity>) manufactureRepo.findAll();
        model.addAttribute("manufactureList", manufactureList);
        return "listManufacture";
    }
     @RequestMapping(value = "/viewManufacture/{id}", method = RequestMethod.GET)
    public String getListProductfindColor(@PathVariable(value = "id") int id,Model model, HttpSession session) {

        List<ProductEntity> productList = (List<ProductEntity>) productRepo.getManufacturefindProduct(id);
        model.addAttribute("productList", productList);
        return "viewManufacture";
    }
    @RequestMapping(value = "/addManufacture", method = RequestMethod.GET)
    public String showAddNewForm(Model model) {

        ManufacturerEntity manufacture = new ManufacturerEntity();

        model.addAttribute("manufacture",manufacture);


        return "addManufacture";
    }
    @RequestMapping(value = "/updateaddManufacture", method = RequestMethod.POST)
    public String saveManufacture(@RequestParam("file") MultipartFile file, ManufacturerEntity manufacture, Model model) {
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

            manufacture.setImages(file.getOriginalFilename());
            model.addAttribute("manufacture", manufacture);
            manufactureRepo.save(manufacture);
            return "listManufacture";
        } catch (Exception e) {
            System.out.println(e);
            String errorMessage = "Error when uploading file" + e;
            model.addAttribute("manufacture", manufacture);
            return "addManufacture";
        }

       
    }
     @RequestMapping(value = "/deletemanufacture/{id}", method = RequestMethod.GET)
    public String deleteManufacture(@PathVariable(value = "id") int id, Model model) {

        try {
            manufactureRepo.deleteById(id);
            List<ManufacturerEntity> manufacture = (List<ManufacturerEntity>) manufactureRepo.findAll();
            model.addAttribute("manufacture", manufacture);
        } catch (Exception e) {
            System.out.println(e);
        }

        return "listManufacture";
    }
        @RequestMapping(value = "/editManufacture", method = RequestMethod.GET)
    public String showEditForm(Model model) {

        ManufacturerEntity manufacture = new ManufacturerEntity();

        model.addAttribute("manufacture",manufacture);


        return "editManufacture";
    }
    @RequestMapping(value = "/updateEditManufacture", method = RequestMethod.POST)
    public String saveEditManufacture(@RequestParam("file") MultipartFile file, ManufacturerEntity manufacture, Model model) {
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

            manufacture.setImages(file.getOriginalFilename());
            model.addAttribute("manufacture", manufacture);
            manufactureRepo.save(manufacture);
            return "listManufacture";
        } catch (Exception e) {
            System.out.println(e);
            String errorMessage = "Error when uploading file" + e;
            model.addAttribute("manufacture", manufacture);
            return "editManufacture";
        }

       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import component.CartEntity;
import entity.CreditCardEntity;
import entity.OrdersDetailsEntity;
import entity.OrdersEntity;
import entity.ProductEntity;
import entity.UserEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CreditCardRepository;
import repository.OrdersDetailsRepository;
import repository.OrdersRepository;
import repository.ShippingRepository;
import repository.ProductDetailsRepository;
import repository.ProductRepository;
import java.util.Random;
import org.springframework.security.core.context.SecurityContextHolder;
import repository.UserRepository;

/**
 *
 * @author DELL
 */
@Controller
@Scope(value = "session")
public class CartController {

    @Autowired
    OrdersRepository orderRepo;

    @Autowired
    UserRepository userRepo;

    @Autowired
    ShippingRepository shippingRepo;

    @Autowired
    CartEntity cart;

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CreditCardRepository creditCardRepo;

    @Autowired
    ProductDetailsRepository productDetailsRepo;

    @Autowired
    OrdersDetailsRepository ordersDetailsRepo;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCarts(@PathVariable(value = "id") int id, Model model) {
        OrdersEntity orders = new OrdersEntity();
        ProductEntity product = (ProductEntity) productRepo.findById(id);
        cart.addProduct(product, id);

        model.addAttribute("orders", orders);
        model.addAttribute("product", product);
        model.addAttribute("cart", cart);

        return "cart"; //Return cart.jsp
    }

    @RequestMapping(value = "/update1", method = RequestMethod.POST)
    public String updateQuantity(Model model, @RequestParam(name = "id") int id,
            @RequestParam(name = "quantity") int quantity, ProductEntity productType) {
        List<OrdersDetailsEntity> ordersDetailsList = cart.getOrdersDetailsList();
        for (int i = 0; i < ordersDetailsList.size(); i++) {
            if (ordersDetailsList.get(i).getProduct().getId() == productType.getId()) {
                OrdersDetailsEntity ordersDetails = ordersDetailsList.get(i);
                ordersDetails.setQuantity(quantity);
                ordersDetailsList.set(i, ordersDetails);
                cart.setOrdersDetailsList(ordersDetailsList);
            }
        }
        model.addAttribute("cart", cart);
        return "cart";

    }

    @RequestMapping(value = "/remove1/{id}", method = RequestMethod.GET)
    public String removeItem(@PathVariable(value = "id") int id, Model model) {
        //Get Item
        ProductEntity productType = (ProductEntity) productRepo.findById(id);

        //Remove Item
        cart.removeItem(productType);

        //List lai trang Cart
        model.addAttribute("cart", cart);

        return "cart";

    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public String bookingForm(OrdersEntity orders, Model model) {
        model.addAttribute("cart", cart);
        /*String userName = getUserName();
        UsersEntity user = userRepo.findByUsername(userName);*/
        model.addAttribute("orders", new OrdersEntity());

        return "ordersForm";
    }

    @Transactional(rollbackOn = Exception.class)
    @RequestMapping(value = "/paymentProduct", method = RequestMethod.POST)
    public String savebooking(OrdersEntity orders, @RequestParam(name = "customerName") String customerName,
            @RequestParam(name = "customerAddress") String customerAddress,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "email") String email,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "card_Number") String card_Number,
            Model model, HttpSession session) {

        CreditCardEntity creditCard = creditCardRepo.findByCreditCardNumber(card_Number);
        if (card_Number == "") {
            double amount = cart.getTotal();
            orders.setDate(LocalDate.now());
            orders.setCustomerAddress(customerAddress);
            orders.setAmount(amount);
            orders.setEmail(email);
            orders.setPhone(phone);

            OrdersEntity newOrders = orderRepo.save(orders);

            List<OrdersDetailsEntity> ordersDetailsList = cart.getOrdersDetailsList();
            for (OrdersDetailsEntity ordersDetails : ordersDetailsList) {
                ordersDetails.setOrders(newOrders);
                //find room for booking
                int ordersDetailsID = ordersDetails.getProduct().getId();
                double price = ordersDetails.getProduct().getPrice() * ordersDetails.getQuantity();
                ordersDetails.setPrice(price);
                Random rd = new Random();
                int n = 1000000;
                int number = rd.nextInt(n);
                String number1 = Integer.toString(number);
                ordersDetails.setNumberOfOrders(number1);
                ordersDetails.setDate(LocalDate.now());
                ordersDetails.setPaymentMethod("thanh toán khi nhận hàng");
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(orders.getEmail());
                msg.setSubject("Booking successfully");
                msg.setText("Congratulations! You have successfully purchase."
                        + "\n Your Orders Details "
                        + "\n        Name: " + ordersDetails.getOrders().getCustomerName()
                        + "\n        Product: " + ordersDetails.getProduct().getName()
                        + "\n        Price: " + ordersDetails.getProduct().getPriceFormatted()
                        + "\n        Number of Order: " + ordersDetails.getNumberOfOrders()
                        + "\n        Date: " + ordersDetails.getDate()
                        + "\n Thank you Thank you for purchasing our products, have a nice day");
                javaMailSender.send(msg);
                ordersDetailsRepo.save(ordersDetails);
                cart.setOrdersDetailsList(new ArrayList<OrdersDetailsEntity>());

            }
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
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                UserEntity user = userRepo.findByUsername(userName);

                model.addAttribute("users", user);
            return "homepage";
        } else {
            Date expirationDate = new Date();
            LocalDate expiration = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(expirationDate));
            if (creditCard.getName().equals(name) && creditCard.getExpirationDate().equals(expirationDate)) {

                return "ordersForm";
            } else {
                double moneyBooking = cart.getTotal();
                double surplus = creditCard.getSurplus();

                if (moneyBooking <= surplus) {
                    double balance = surplus - moneyBooking;
                    creditCard.setSurplus(balance);
                    creditCardRepo.save(creditCard);

                } else {
                    if (moneyBooking > surplus) {
                        String erroMessage = "Bạn không đủ tiền";
                        model.addAttribute("erroMessage", erroMessage);
                        model.addAttribute("creditCard", creditCard);
                        model.addAttribute("cart", cart);
                        model.addAttribute("orders", new OrdersEntity());
                        return "ordersForm";
                    }
                }
                orders.setDate(LocalDate.now());
                orders.setCustomerAddress(customerAddress);
                orders.setEmail(email);
                orders.setPhone(phone);
//                int idCreditCard = creditCardRepo.findById(card_Number);
//              orders.setCreditcard(creditCard);
                OrdersEntity newOrders = orderRepo.save(orders);

                List<OrdersDetailsEntity> ordersDetailsList = cart.getOrdersDetailsList();
                for (OrdersDetailsEntity ordersDetails : ordersDetailsList) {
                    ordersDetails.setOrders(newOrders);
                    //find room for booking
                    int ordersDetailsID = ordersDetails.getProduct().getId();
                    double price = ordersDetails.getProduct().getPrice() * ordersDetails.getQuantity();
                    ordersDetails.setPrice(price);
                    Random rd = new Random();
                    int number = rd.nextInt(1000000);
                    String number1 = String.valueOf(number);
                    ordersDetails.setNumberOfOrders(number1);
                    ordersDetails.setDate(LocalDate.now());
                    ordersDetails.setPaymentMethod("thanh toán khi nhận hàng");
                    SimpleMailMessage msg = new SimpleMailMessage();
                    msg.setTo(orders.getEmail());
                    msg.setSubject("Booking Product Successfully");
                    msg.setText("Congratulations! You have successfully booked."
                            + "\n Your Orders Details "
                            + "\n        Name: " + ordersDetails.getOrders().getCustomerName()
                            + "\n        product: " + ordersDetails.getProduct().getName()
                            + "\n        price: " + ordersDetails.getProduct().getPriceFormatted()
                            + "\n        Number of Order: " + ordersDetails.getNumberOfOrders()
                            + "\n        Date: " + ordersDetails.getDate()
                            + "\n Thank you Thank you for purchasing our products, have a nice day");
                    javaMailSender.send(msg);
                    ordersDetailsRepo.save(ordersDetails);
                    cart.setOrdersDetailsList(new ArrayList<OrdersDetailsEntity>());
                }
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
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                UserEntity user = userRepo.findByUsername(userName);

                model.addAttribute("users", user);
                return "homepage";
            }
        }
    }

}

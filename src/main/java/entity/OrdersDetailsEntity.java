/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ordersdetails")
public class OrdersDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numberOfOrders;
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String paymentMethod;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")//khóa ngoại 
    private OrdersEntity orders;

    @ManyToOne
    @JoinColumn(name = "productDetails_id")//khóa ngoại 
    private ProductEntity product;

    public OrdersDetailsEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(String numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrdersEntity getOrders() {
        return orders;
    }

    public void setOrders(OrdersEntity orders) {
        this.orders = orders;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    
     public double getTotalAmount(){
        return  getQuantity() * product.getPrice();
    }
    
    public String getTotalFormatted(){
       Locale localeVN = new Locale("vi", "VN");
       NumberFormat totalFormat = NumberFormat.getCurrencyInstance(localeVN);
       return totalFormat.format(getTotalAmount());
    }
}

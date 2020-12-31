/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String customerName;
    private String customerAddress;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_id")//khóa ngoại 
    private UserEntity users;

     @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    List<OrdersDetailsEntity> ordersDetailsList;
    
    @ManyToOne
    @JoinColumn(name = "shipping_id")//khóa ngoại 
    private ShippingEntity shipping;

    @ManyToOne
    @JoinColumn(name = "creditCard_id")//khóa ngoại 
    private CreditCardEntity creditcard;

    public OrdersEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserEntity getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users = users;
    }

    public List<OrdersDetailsEntity> getOrdersDetailsList() {
        return ordersDetailsList;
    }

    public void setOrdersDetailsList(List<OrdersDetailsEntity> ordersDetailsList) {
        this.ordersDetailsList = ordersDetailsList;
    }

    public ShippingEntity getShipping() {
        return shipping;
    }

    public void setShipping(ShippingEntity shipping) {
        this.shipping = shipping;
    }

    public CreditCardEntity getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(CreditCardEntity creditcard) {
        this.creditcard = creditcard;
    }

     public String getPriceFormatted(){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat priceFormat = NumberFormat.getCurrencyInstance(localeVN);
        return priceFormat.format(amount);
    }  
    
    
  
    
}

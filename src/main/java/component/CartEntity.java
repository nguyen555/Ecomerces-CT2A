/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import entity.OrdersDetailsEntity;
import entity.ProductEntity;
import entity.ProductDetailsEntity;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author DELL
 */
@Component
@Scope(value = "session")
public class CartEntity {
    private int orders;
    List<OrdersDetailsEntity> ordersDetailsList;
    ProductDetailsEntity producDetails;
    ProductEntity product;
    CartEntity cart;
    private int quantity;

    public CartEntity() {
         ordersDetailsList = new ArrayList<>();
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public List<OrdersDetailsEntity> getOrdersDetailsList() {
        return ordersDetailsList;
    }

    public void setOrdersDetailsList(List<OrdersDetailsEntity> ordersDetailsList) {
        this.ordersDetailsList = ordersDetailsList;
    }

    public ProductDetailsEntity getProducDetails() {
        return producDetails;
    }

    public void setProducDetails(ProductDetailsEntity producDetails) {
        this.producDetails = producDetails;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getTotalFormatted(){
       Locale localeVN = new Locale("vi", "VN");
       NumberFormat totalFormat = NumberFormat.getCurrencyInstance(localeVN);
       return totalFormat.format(getTotal());
    }
   
//     
//    public String getTotalFormatted(){
//        Locale localeVN = new Locale("vi", "VN");
//        NumberFormat totalFormat = NumberFormat.getCurrencyInstance(localeVN);
//        return totalFormat.format(getTotal());
//    }
     
     //Add Item
    public void addProduct ( ProductEntity product, int quantity) {
        boolean t = false;
        for (int i = 0; i < ordersDetailsList.size(); i++) {
            if (ordersDetailsList.get(i).getProduct().getId() == product.getId()) {
                OrdersDetailsEntity ordersDetails = ordersDetailsList.get(i);
                ordersDetails.setQuantity(ordersDetails.getQuantity() + 1);
                ordersDetailsList.set(i, ordersDetails);
                t = true;
            }
        }
        if (!t) {
            OrdersDetailsEntity ordersDetails = new OrdersDetailsEntity();
            ordersDetails.setQuantity(quantity);
            ordersDetails.setProduct(product);
            ordersDetails.getProduct().getPrice();
            ordersDetailsList.add(ordersDetails);
        }
    }

    //Remove Item
    public void removeItem(ProductEntity product) {
        for (int i = 0; i < ordersDetailsList.size(); i++) {
            if (ordersDetailsList.get(i).getProduct().getId() == product.getId()) {
                ordersDetailsList.remove(i);
            }
        }
    }

//    Total Amount
    public double getTotal() {
        double sum = 0;
        for (int i = 0; i < ordersDetailsList.size(); i++) {
                double price = ordersDetailsList.get(i).getProduct().getPrice();
                int quantity = ordersDetailsList.get(i).getQuantity();
                sum = price * quantity;

        }
        return sum;
    }
   
}

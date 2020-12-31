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
@Table(name = "product")
public class ProductEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private double price;
      @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
      private String image;
      private String image1;
      private String image2;
      private String image3;
      private String image4;
      private String numberProduct;
      
      @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    List<OrdersDetailsEntity> ordersDetailsList;
      
      @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    List<CommentEntity> commentList;
      
       @ManyToOne
    @JoinColumn(name = "color_id")//khóa ngoại 
    private ColorEntity color;
       
        @ManyToOne
    @JoinColumn(name = "manufacture_id")//khóa ngoại 
    private ManufacturerEntity manufacturer;
        
         @ManyToOne
    @JoinColumn(name = "memory_id")//khóa ngoại 
    private InternalMemoryEntity internal_memory;
         
          @ManyToOne
    @JoinColumn(name = "promotion_id")//khóa ngoại 
    private PromotionEntity promotion;
          
           @ManyToOne
    @JoinColumn(name = "product_id")//khóa ngoại 
    private ProductDetailsEntity productdetails;

    public ProductEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getNumberProduct() {
        return numberProduct;
    }

    public void setNumberProduct(String numberProduct) {
        this.numberProduct = numberProduct;
    }

    public List<OrdersDetailsEntity> getOrdersDetailsList() {
        return ordersDetailsList;
    }

    public void setOrdersDetailsList(List<OrdersDetailsEntity> ordersDetailsList) {
        this.ordersDetailsList = ordersDetailsList;
    }

    public List<CommentEntity> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentEntity> commentList) {
        this.commentList = commentList;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public ManufacturerEntity getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerEntity manufacturer) {
        this.manufacturer = manufacturer;
    }

    public InternalMemoryEntity getInternal_memory() {
        return internal_memory;
    }

    public void setInternal_memory(InternalMemoryEntity internal_memory) {
        this.internal_memory = internal_memory;
    }

    public PromotionEntity getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionEntity promotion) {
        this.promotion = promotion;
    }

    public ProductDetailsEntity getProductdetails() {
        return productdetails;
    }

    public void setProductdetails(ProductDetailsEntity productdetails) {
        this.productdetails = productdetails;
    }
    
    

    
    
   public String getPriceFormatted(){
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat priceFormat = NumberFormat.getCurrencyInstance(localeVN);
        return priceFormat.format(price);
    }  
    
}

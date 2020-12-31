/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "customers")
public class CustomerEntity {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String name;
     private String email;
      @DateTimeFormat(pattern= "yyyy-MM-dd")
   private LocalDate  birthDate;
      private String sex;
      private String phone;
      private String address;
      @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY) //product(*) ben OrderDetailsEntity
      List<UserEntity> userList;
      
      @OneToMany(mappedBy = "customers", fetch = FetchType.LAZY) //product(*) ben OrderDetailsEntity
      List<CreditCardEntity> creditCardList;
      
      public CustomerEntity() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<UserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<UserEntity> userList) {
        this.userList = userList;
    }

    public List<CreditCardEntity> getCreditCardList() {
        return creditCardList;
    }

    public void setCreditCardList(List<CreditCardEntity> creditCardList) {
        this.creditCardList = creditCardList;
    }
    
      
}

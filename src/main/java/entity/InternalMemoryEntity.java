/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author DELL
 */@Entity
@Table(name = "internal_memory")
public class InternalMemoryEntity {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String memory_type;
     
     @OneToMany(mappedBy = "internal_memory", fetch = FetchType.LAZY)
    List<ProductEntity> productList;

    public InternalMemoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemory_type() {
        return memory_type;
    }

    public void setMemory_type(String memory_type) {
        this.memory_type = memory_type;
    }

    public List<ProductEntity> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductEntity> productList) {
        this.productList = productList;
    }

   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.CustomerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

    @Query(value = "select * from customers join users on customers.id= users.customer_id where users.userName=?1", nativeQuery = true)
    CustomerEntity getCustomerByUserName(String userName);


    @Query(value = "select * from customers join users on customers.id= users.customer_id where customers.id=?1", nativeQuery = true)
    CustomerEntity getCustomerByid(int id);

    List<CustomerEntity> findByNameLikeOrEmailLikeOrPhoneLike(String name, String email, String phone);

    CustomerEntity findById(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdersDetailsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface OrdersDetailsRepository extends CrudRepository<OrdersDetailsEntity, Integer> {
    
    OrdersDetailsEntity findById(int id);

    @Query(value = "SELECT * FROM ecomerce.orders join ecomerce.ordersdetails on orders.id = ordersdetails.order_id where orders.id = ?1", nativeQuery = true)
    List<OrdersDetailsEntity> getOderDetails(int id);
     @Query(value = "SELECT * FROM ecomerce.ordersdetails where ordersdetails.order_id = ?1", nativeQuery = true)
    OrdersDetailsEntity getOderDetailsF(int id);
}

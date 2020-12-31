/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.OrdersEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface OrdersRepository extends CrudRepository<OrdersEntity, Integer> {

    List<OrdersEntity> getBycustomerNameLikeOrEmailLike(String name, String email);
    OrdersEntity findByid(int id);
    
    @Query(value = "DELETE ord FROM ecomerce.orders o inner join ecomerce.ordersdetails ord on o.id = ord.order_id WHERE o.id = ?1", nativeQuery = true)
    List<OrdersEntity> getdeleteoder(int id);
    
    @Query(value = "select count(*) from orders ", nativeQuery = true)
    int getCountOrders();
    
    }

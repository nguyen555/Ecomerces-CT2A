/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.CustomerEntity;
import entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    UserEntity findById(int id);

    @Query(value = "select * FROM users ", nativeQuery = true)
    List<UserEntity> getAllUsers();

    @Query(value = "select count(*) from users", nativeQuery = true)
    int getCountUser();

    @Query(value = "select * FROM users where users.customer_id = ?1", nativeQuery = true)
    UserEntity getUsers(int id);

    @Query(value = "select * FROM users u join customers c on u.customer_id = c.id where u.userName = ?1", nativeQuery = true)
    UserEntity findByUsername(String username);

    @Query(value = "select * from customers join users on customers.id= users.customer_id where customers.id=?1", nativeQuery = true)
    CustomerEntity getCustomerByid(int id);
}

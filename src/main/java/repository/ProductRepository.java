/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    ProductEntity findById(int id);

    @Query(value = "select count(*) from product", nativeQuery = true)
    int getCountProduct();

    @Query(value = "select * from product limit 3", nativeQuery = true)
    List<ProductEntity> getProductDetails();

    @Query(value = "select * from product where name like ?1", nativeQuery = true)
    List<ProductEntity> getSearchProduct(String name);

    @Query(value = "select * from product limit 3,3", nativeQuery = true)
    List<ProductEntity> getProductDetailsRe();

    @Query(value = "select * from product limit 6,3", nativeQuery = true)
    List<ProductEntity> getProductDetailsRepo();

    @Query(value = "select * from product limit 3", nativeQuery = true)
    List<ProductEntity> getProductDetailsC();

    @Query(value = "select * from product ORDER BY id DESC limit 6", nativeQuery = true)
    List<ProductEntity> getProduct();

    @Query(value = "select * from product ORDER BY id DESC limit  ?1 , ?2 ", nativeQuery = true)
    List<ProductEntity> getAllProduct(int pageProductId, int limitProduct);
    
     @Query(value = "select * from product ORDER BY id DESC limit 1", nativeQuery = true)
    List<ProductEntity> getProductNew();

    @Query(value = "select * from product where manufacture_id = ?1 ORDER BY id DESC limit 6", nativeQuery = true)
    List<ProductEntity> getManuFac(int id);

    @Query(value = "SELECT p FROM ProductEntity p ORDER BY p.price DESC")
    List<ProductEntity> sortByEvaluateHighToLow();

    @Query(value = "SELECT p FROM ProductEntity p ORDER BY p.price ASC")
    List<ProductEntity> sortByEvaluateLowToHigh();

    @Query(value = "select p from ProductEntity p where p.price >= ?1 and p.price <= ?2 ORDER BY p.price asc")
    List<ProductEntity> findByPrice(double min, double max);

    @Query(value = "select * from product pr join product p on pr.product_id = p.id where pr.product_id = ?1 ", nativeQuery = true)
    List<ProductEntity> findProductById(int id);

    @Query(value = "SELECT * FROM ecomerce.product p join ecomerce.color cl on p.color_id = cl.id where cl.id = ?1", nativeQuery = true)
    List<ProductEntity> getColorfindProduct(int id);

    @Query(value = "SELECT * FROM ecomerce.product p join ecomerce.manufacturer manufac on p.manufacture_id = manufac.id where manufac.id = ?1", nativeQuery = true)
    List<ProductEntity> getManufacturefindProduct(int id);

    @Query(value = "SELECT * FROM ecomerce.product p join ecomerce.productdetails pr on p.product_id= pr.id where (p.name like ?1)  or (pr.cpu like ?2)", nativeQuery = true)
    List<ProductEntity> getByNameLikeOrCpuLike(String name, String cpu);
}

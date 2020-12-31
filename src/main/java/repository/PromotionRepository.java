/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.PromotionEntity;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface PromotionRepository extends CrudRepository<PromotionEntity, Integer>{
    List<PromotionEntity> findById(int id);
     @Query(value = " select p.* from promotion p "
            + " join productDetails po on po.promotion_id = p.id"
            + " where p.id = ?1", nativeQuery = true)
    List<PromotionEntity> getPromotion(int id);
}

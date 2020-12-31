/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.CreditCardEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Integer>{
 @Query("select cr FROM CreditCardEntity cr WHERE id = ?1")
    CreditCardEntity findById(int id);
    
    @Query("select cr FROM CreditCardEntity cr WHERE card_Number = ?1")
    CreditCardEntity findByCreditCardNumber(String card_Number);   
}

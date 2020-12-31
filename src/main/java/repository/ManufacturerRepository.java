/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import entity.ManufacturerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DELL
 */
@Repository
public interface ManufacturerRepository extends CrudRepository<ManufacturerEntity, Integer> {

    List<ManufacturerEntity> findById(int id);

    @Query(value = "select * from manufacturer", nativeQuery = true)
    List<ManufacturerEntity> getManufacturer();

    @Query(value = "select * "
            + "from manufacturer ma "
            + "	join productdetails p on ma.id = p.manufacture_id "
            + "where ma.id = '?1'", nativeQuery = true)
    List<ManufacturerEntity> getManu(int id);

    @Query(value = "select count(*) from manufacturer", nativeQuery = true)
    int getCountmanu();
}

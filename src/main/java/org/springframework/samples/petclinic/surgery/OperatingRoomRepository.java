package org.springframework.samples.petclinic.surgery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatingRoomRepository extends CrudRepository<OperatingRoom, Integer> {

    Optional<OperatingRoom> findById(Integer i);

    List<OperatingRoom> findAll();

    OperatingRoom save(OperatingRoom any);
    
}

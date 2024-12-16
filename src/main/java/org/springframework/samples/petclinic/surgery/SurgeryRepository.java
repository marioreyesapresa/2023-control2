package org.springframework.samples.petclinic.surgery;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepository extends CrudRepository<Surgery, Integer> {
    Optional<Surgery> findById(Integer i);

    List<Surgery> findAll();

    Surgery save(Surgery any);
    
}

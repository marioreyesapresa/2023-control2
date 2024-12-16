package org.springframework.samples.petclinic.surgery;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.vet.Vet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "surgeries") // ESTO ES MUY IMPORTANTE SI NO EL 3 NO LO HACES
public class Surgery extends NamedEntity {

    String description;

    @NotNull
    @Column(name = "surgery_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate date;
    
    @ManyToMany
    Set<Vet> surgeryTeam;  
      
    @NotNull
    @ManyToOne(optional = false)
    OperatingRoom room;
}

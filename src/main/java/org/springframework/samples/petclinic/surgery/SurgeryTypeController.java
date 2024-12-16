package org.springframework.samples.petclinic.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/surgerytypes")
public class SurgeryTypeController {

    private final SurgeryTypeService surgeryTypeService;

    @Autowired
    public SurgeryTypeController(SurgeryTypeService surgeryTypeService) {
        this.surgeryTypeService = surgeryTypeService;
    }


    @GetMapping()
    public List<SurgeryType> findAll() {
        return surgeryTypeService.findSurgeryTypes();
    }

    @GetMapping(value = "{id}")
    public SurgeryType findById(@PathVariable("id") int id) {
        SurgeryType surgeryType = surgeryTypeService.findSurgeryTypeById(id);
        if(surgeryType == null) {
            throw new ResourceNotFoundException("SurgeryType", "ID", id);
        }
        return surgeryType;
    }
    
}

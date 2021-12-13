package com.ipiecoles.java.mdd050.controller;

import com.ipiecoles.java.mdd050.model.Commercial;
import com.ipiecoles.java.mdd050.model.Employe;
import com.ipiecoles.java.mdd050.repository.CommercialRepository;
import com.ipiecoles.java.mdd050.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employes")
public class EmployeController {

    @Autowired
    private EmployeRepository employeRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/count")
    public String countEmploye() {
        return String.valueOf(employeRepository.count());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Optional<Employe> findById(@PathVariable(value = "id") Long id) {
        return employeRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "", params = "matricule")
    public Employe findByMatricule(@RequestParam(value = "matricule") String matricule) {
        return employeRepository.findByMatricule(matricule);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "")
    public Page<Employe> findEmployeesPagined(@RequestParam Integer page,
                                              @RequestParam Integer size,
                                              @RequestParam String sortProperty,
                                              @RequestParam Sort.Direction sortDirection) {
        PageRequest pageRequest = PageRequest.of(page, size, sortDirection, sortProperty);
        return employeRepository.findAll(pageRequest);
    }

    @RequestMapping(method = RequestMethod.POST, value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employe createCommercial(@RequestBody Employe employe) {
        return employeRepository.save(employe);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Employe updateEmploye(@RequestBody Employe employe) {
        return employeRepository.save(employe);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmploye(@PathVariable(value = "id") Long id) {
        employeRepository.deleteById(id);
    }
}

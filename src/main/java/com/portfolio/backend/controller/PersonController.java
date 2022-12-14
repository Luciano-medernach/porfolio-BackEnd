package com.portfolio.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.model.Person;
import com.portfolio.backend.service.IPersonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {
    @Autowired
    private IPersonService personService;

    @GetMapping ("/person")
    public Person getPerson(){
        return personService.getPerson();
    }

    @PostMapping ("/person/save")
    public Person savePerson(@RequestBody Person person){
        personService.savePerson(person);
        return person;
    }

    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personService.deletePerson(id);

        return "La persona fue eliminada correctamente";
    }

    @PutMapping("person/edit/{id}")
    public Person editPerson (@PathVariable Long id,
        @RequestBody Person per
    ) {
        Person person = personService.findPerson(id);

        person.setLastname(per.getLastname());
        person.setName(per.getName());
        person.setTitle(per.getTitle());
        person.setInfo(per.getInfo());

        personService.savePerson(person);

        return person; 
    }
}

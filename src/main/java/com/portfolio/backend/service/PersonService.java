package com.portfolio.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.model.Person;
import com.portfolio.backend.repository.PersonRepository;

@Service
public class PersonService implements IPersonService {
    
    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getPeople() {
        List<Person> peopleList = personRepository.findAll();
        return peopleList;
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }
}

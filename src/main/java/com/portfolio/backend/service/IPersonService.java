package com.portfolio.backend.service;

import java.util.List;

import com.portfolio.backend.model.Person;

public interface IPersonService {
    public List<Person> getPeople();

    public void savePerson(Person persona);
    public void deletePerson(Long id);
    public Person findPerson (Long id);
}

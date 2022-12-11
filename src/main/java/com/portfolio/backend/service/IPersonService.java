package com.portfolio.backend.service;

import com.portfolio.backend.model.Person;

public interface IPersonService {
    public Person getPerson();

    public void savePerson(Person persona);
    public void deletePerson(Long id);
    public Person findPerson (Long id);
}

package com.aod.aodmoney.api.service;

import com.aod.aodmoney.api.model.Person;
import com.aod.aodmoney.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  public Person update( Long id, Person person ) {
    Person updatedPerson = findPersonById( id );

    BeanUtils.copyProperties( person, updatedPerson, "id" );

    return personRepository.save( updatedPerson );
  }

  public void updateActiveStatus( Long id, Boolean activeStatus ) {
    Person updatedPerson = findPersonById( id );
    updatedPerson.setActive( activeStatus );
    personRepository.save( updatedPerson );
  }

  private Person findPersonById( Long id ) {
    Optional< Person > personSought = personRepository.findById( id );

    if ( personSought.isEmpty() ) {
      throw new EmptyResultDataAccessException( 1 );
    }
    return personSought.get();
  }
}

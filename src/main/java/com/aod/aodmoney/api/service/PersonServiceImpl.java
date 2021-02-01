package com.aod.aodmoney.api.service;

import com.aod.aodmoney.api.model.Person;
import com.aod.aodmoney.api.repository.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
  @Autowired
  private PersonRepository personRepository;

  public Person save( Person person ) {
    return personRepository.save( person );
  }

  public Person updateById( Long id, Person person ) {
    Optional< Person > updatedPerson = findById( id );

    BeanUtils.copyProperties( person, updatedPerson, "id" );

    return save( updatedPerson.get() );
  }

  public void updateActiveStatus( Long id, Boolean activeStatus ) {
    Person updatedPerson = findById( id ).get();
    updatedPerson.setActive( activeStatus );
    personRepository.save( updatedPerson );
  }

  @Override
  public void deleteById( Long id ) {
    personRepository.deleteById( id );
  }

  public Optional< Person > findById( Long id ) {
    Optional< Person > person = personRepository.findById( id );

    if ( person.isEmpty() ) {
      throw new EmptyResultDataAccessException( 1 );
    }
    return person;
  }
}

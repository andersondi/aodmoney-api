package com.aod.aodmoney.api.service;

import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.model.Person;
import com.aod.aodmoney.api.repository.EntryRepository;
import com.aod.aodmoney.api.repository.PersonRepository;
import com.aod.aodmoney.api.repository.filter.EntryFilter;
import com.aod.aodmoney.api.service.exception.InactivePersonException;
import com.aod.aodmoney.api.service.exception.PersonNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {

  @Autowired
  private EntryRepository entryRepository;

  @Autowired
  private PersonRepository personRepository;

  @Autowired
  private PersonService personService;

  @Override
  public List< Entry > filter( EntryFilter entryFilter ) {
    return entryRepository.filter( entryFilter );
  }

  @Override
  public Optional< Entry > findById( Long id ) {
    Optional< Entry > entry = entryRepository.findById( id );

    if ( entry.isEmpty() ) {
      throw new EmptyResultDataAccessException( 1 );
    }
    return entry;
  }

  @Override
  public Entry save( Entry entry ) {
    Optional< Person > person = personRepository.findById( entry.getPerson().getId() );
    if ( person.isEmpty() ) {
      throw new PersonNotExistsException();
    }

    if ( !person.get().getActive() ) {
      throw new InactivePersonException();
    }

    return entryRepository.save( entry );
  }
}

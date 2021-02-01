package com.aod.aodmoney.api.service;

import com.aod.aodmoney.api.model.Person;

import java.util.Optional;

public interface PersonService {
  Person save( Person person );

  Person updateById( Long id, Person person );

  void updateActiveStatus( Long id, Boolean activeStatus );

  Optional< Person > findById( Long id );

  void deleteById( Long id );
}

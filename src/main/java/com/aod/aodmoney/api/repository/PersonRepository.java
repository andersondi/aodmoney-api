package com.aod.aodmoney.api.repository;

import com.aod.aodmoney.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository< Person, Long > {
}

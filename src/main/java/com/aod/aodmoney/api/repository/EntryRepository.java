package com.aod.aodmoney.api.repository;

import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.repository.entry.EntryRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository< Entry, Long >, EntryRepositoryQuery {
}

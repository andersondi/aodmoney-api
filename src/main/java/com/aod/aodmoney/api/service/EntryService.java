package com.aod.aodmoney.api.service;

import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.repository.filter.EntryFilter;

import java.util.List;
import java.util.Optional;

public interface EntryService {
  List< Entry > filter( EntryFilter entryFilter );

  Optional< Entry > findById( Long id );

  Entry save( Entry entry );
}

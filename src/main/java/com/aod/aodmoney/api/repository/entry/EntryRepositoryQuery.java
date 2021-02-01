package com.aod.aodmoney.api.repository.entry;

import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.repository.filter.EntryFilter;

import java.util.List;

public interface EntryRepositoryQuery {
  List< Entry > filter( EntryFilter entryFilter );
}

package com.aod.aodmoney.api.repository.entry;

import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.repository.filter.EntryFilter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepositoryQuery {

  @PersistenceContext
  EntityManager manager;

  @Override
  public List< Entry > filter( EntryFilter entryFilter ) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery< Entry > criteria = builder.createQuery( Entry.class );
    Root< Entry > root = criteria.from( Entry.class );

    Predicate[] predicates = createConstraints( entryFilter, builder, root );
    criteria.where( predicates );

    TypedQuery< Entry > query = manager.createQuery( criteria );
    return query.getResultList();
  }

  private Predicate[] createConstraints( EntryFilter entryFilter, CriteriaBuilder builder, Root< Entry > root ) {

    List< Predicate > predicates = new ArrayList<>();

    if ( !StringUtils.isEmpty( entryFilter.getDescription() ) ) {
      predicates.add(
              builder.like( builder.lower( root.get( "description" ) ), "%" + entryFilter.getDescription() + "%" )
      );
    }

    if ( entryFilter.getExpirationDateStart() != null ) {
      predicates.add(
              builder.greaterThanOrEqualTo( root.get( "expirationDate" ), entryFilter.getExpirationDateStart() )
      );
    }

    if ( entryFilter.getExpirationDateEnd() != null ) {
      predicates.add(
              builder.lessThanOrEqualTo( root.get( "expirationDate" ), entryFilter.getExpirationDateEnd() )
      );
    }

    return predicates.toArray( new Predicate[ predicates.size() ] );
  }
}

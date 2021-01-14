package com.aod.aodmoney.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table( name = "category" )
public class Category {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  public Long id;

  @NotNull
  public String name;

  public Long getId() {
    return id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName( String name ) {
    this.name = name;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( !( o instanceof Category ) ) return false;
    Category category = ( Category ) o;
    return Objects.equals( getId(), category.getId() );
  }

  @Override
  public int hashCode() {
    return Objects.hash( getId() );
  }
}

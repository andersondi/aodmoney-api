package com.aod.aodmoney.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table( name = "person" )
public class Person {
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  private Long id;

  @NotNull
  @Size( min = 2, max = 255 )
  private String name;

  @Embedded
  public Address address;

  @NotNull
  private Boolean active;

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

  public Boolean getActive() {
    return active;
  }

  public void setActive( Boolean active ) {
    this.active = active;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress( Address address ) {
    this.address = address;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( !( o instanceof Person ) ) return false;
    Person person = ( Person ) o;
    return getId().equals( person.getId() );
  }

  @Override
  public int hashCode() {
    return Objects.hash( getId() );
  }
}

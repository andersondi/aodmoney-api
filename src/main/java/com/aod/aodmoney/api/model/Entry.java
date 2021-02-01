package com.aod.aodmoney.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table( name = "entry" )
public class Entry {

  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  Long id;

  @NotNull
  private String description;

  @NotNull
  @Column( name = "expiration_date" )
  private LocalDate expirationDate;

  @Column( name = "purchase_date" )
  private LocalDate purchaseDate;

  @NotNull
  private BigDecimal value;

  private String comment;

  @NotNull
  @Enumerated(EnumType.STRING)
  private EntryType type;

  @NotNull
  @ManyToOne
  @JoinColumn( name = "id_category" )
  private Category category;

  @NotNull
  @ManyToOne
  @JoinColumn( name = "id_person" )
  private Person person;

  public Long getId() {
    return id;
  }

  public void setId( Long id ) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate( LocalDate expirationDate ) {
    this.expirationDate = expirationDate;
  }

  public LocalDate getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate( LocalDate purchaseDate ) {
    this.purchaseDate = purchaseDate;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue( BigDecimal value ) {
    this.value = value;
  }

  public String getComment() {
    return comment;
  }

  public void setComment( String comment ) {
    this.comment = comment;
  }

  public EntryType getType() {
    return type;
  }

  public void setType( EntryType type ) {
    this.type = type;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory( Category category ) {
    this.category = category;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson( Person person ) {
    this.person = person;
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( !( o instanceof Entry ) ) return false;
    Entry launch = ( Entry ) o;
    return Objects.equals( getId(), launch.getId() );
  }

  @Override
  public int hashCode() {
    return Objects.hash( getId() );
  }
}

package com.aod.aodmoney.api.repository.filter;

import java.time.LocalDate;

public class EntryFilter {
  private String description;
  private LocalDate expirationDateStart;
  private LocalDate expirationDateEnd;

  public String getDescription() {
    return description;
  }

  public void setDescription( String description ) {
    this.description = description;
  }

  public LocalDate getExpirationDateStart() {
    return expirationDateStart;
  }

  public void setExpirationDateStart( LocalDate expirationDateStart ) {
    this.expirationDateStart = expirationDateStart;
  }

  public LocalDate getExpirationDateEnd() {
    return expirationDateEnd;
  }

  public void setExpirationDateEnd( LocalDate expirationDateEnd ) {
    this.expirationDateEnd = expirationDateEnd;
  }
}

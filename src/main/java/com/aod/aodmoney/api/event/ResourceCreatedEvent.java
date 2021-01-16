package com.aod.aodmoney.api.event;

import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreatedEvent extends ApplicationEvent {

  private Long id;
  private HttpServletResponse response;

  public ResourceCreatedEvent( Object source, HttpServletResponse response, Long id ) {
    super( source );
    this.id = id;
    this.response = response;
  }

  public HttpServletResponse getResponse() {
    return response;
  }

  public Long getId() {
    return id;
  }
}

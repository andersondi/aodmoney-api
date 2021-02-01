package com.aod.aodmoney.api.resource;

import com.aod.aodmoney.api.event.ResourceCreatedEvent;
import com.aod.aodmoney.api.model.Entry;
import com.aod.aodmoney.api.repository.filter.EntryFilter;
import com.aod.aodmoney.api.service.EntryService;
import com.aod.aodmoney.api.exceptionhandler.AodMoneyResponseEntityExceptionHandler.Error;
import com.aod.aodmoney.api.service.exception.InactivePersonException;
import com.aod.aodmoney.api.service.exception.PersonNotExistsException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/entries" )
public class EntryResource {

  @Autowired
  private EntryService entryService;

  @Autowired
  private ApplicationEventPublisher publisher;

  @Autowired
  private MessageSource messageSource;

  @GetMapping
  @ApiOperation( "List entries per page" )
  @ApiResponses( value = { @ApiResponse( code = 200, message = "Entries listed" ) } )
  public List< Entry > search( EntryFilter entryFilter ) {
    return entryService.filter( entryFilter );
  }

  @GetMapping( "/{id}" )
  @ApiOperation( "Find an entry by id" )
  @ApiResponses( value = { @ApiResponse( code = 200, message = "Entries found" ) } )
  public ResponseEntity< Optional< Entry > > findById( @PathVariable Long id ) {
    Optional entry = entryService.findById( id );

    return entry.isPresent() ? ResponseEntity.ok( entry ) : ResponseEntity.notFound().build();
  }

  @PostMapping
  @ApiOperation( "Add a new entry" )
  @ApiResponses( value = { @ApiResponse( code = 201, message = "Entry added with success" ) } )
  public ResponseEntity< Entry > create( @Valid @RequestBody Entry entry, HttpServletResponse response ) {
    entryService.save( entry );
    publisher.publishEvent( new ResourceCreatedEvent( this, response, entry.getId() ) );
    return ResponseEntity.status( HttpStatus.CREATED ).body( entry );
  }

  @ExceptionHandler( { PersonNotExistsException.class } )
  private ResponseEntity< Object > handlePersonNotExistsException( PersonNotExistsException ex ) {
    String userMessage = messageSource.getMessage( "person.not-exists", null, LocaleContextHolder.getLocale() );
    String developerMessage = ex.toString();
    List< Error > errors = Arrays.asList( new Error( userMessage, developerMessage ) );

    return ResponseEntity.badRequest().body( errors );
  }

  @ExceptionHandler( { InactivePersonException.class } )
  private ResponseEntity< Object > handleInactivePersonException( InactivePersonException ex ) {
    String userMessage = messageSource.getMessage( "person.inactive", null, LocaleContextHolder.getLocale() );
    String developerMessage = ex.toString();
    List< Error > errors = Arrays.asList( new Error( userMessage, developerMessage ) );

    return ResponseEntity.badRequest().body( errors );
  }
}

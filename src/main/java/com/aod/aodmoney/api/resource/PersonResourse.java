package com.aod.aodmoney.api.resource;

import com.aod.aodmoney.api.event.ResourceCreatedEvent;
import com.aod.aodmoney.api.model.Person;
import com.aod.aodmoney.api.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping( "/persons" )
public class PersonResourse {

  @Autowired
  private PersonService personService;

  @Autowired
  private ApplicationEventPublisher publisher;

  @PostMapping
  @ApiOperation( "Add a new person" )
  @ApiResponses( value = { @ApiResponse( code = 201, message = "Person added" ) } )
  public ResponseEntity< Person > create( @Valid @RequestBody Person person, HttpServletResponse response ) {
    Person savedPerson = personService.save( person );

    publisher.publishEvent( new ResourceCreatedEvent( this, response, person.getId() ) );
    return ResponseEntity.status( HttpStatus.CREATED ).body( savedPerson );
  }

  @GetMapping( "/{id}" )
  @ApiOperation( "Search for a person using an id" )
  @ApiResponses( value = {
          @ApiResponse( code = 200, message = "Person found" ),
          @ApiResponse( code = 404, message = "Person not found" )
  } )
  public ResponseEntity< Optional< Person > > findPersonById( @PathVariable( "id" ) Long id ) {
    Optional person = personService.findById( id );

    return person.isPresent() ? ResponseEntity.ok( person ) : ResponseEntity.notFound().build();
  }

  @DeleteMapping( "/{id}" )
  @ApiOperation( "Delete a person by id" )
  @ApiResponses( value = { @ApiResponse( code = 204, message = "Person deleted with success" ) } )
  @ResponseStatus( HttpStatus.NO_CONTENT )
  public void delete( @PathVariable( "id" ) Long id ) {
    personService.deleteById( id );
  }

  @PutMapping( "/{id}" )
  @ApiOperation( "Update an entire person by id" )
  @ApiResponses( value = { @ApiResponse( code = 200, message = "Person updated with success" ) } )
  public ResponseEntity< Person > update( @PathVariable Long id, @Valid @RequestBody Person person ) {
    Person updatedPerson = personService.updateById( id, person );
    return ResponseEntity.ok( updatedPerson );
  }

  @PutMapping( "/{id}/active" )
  @ApiOperation( "Update the active status to a person" )
  @ApiResponses( value = { @ApiResponse( code = 204, message = "Person active status updated with success" ) } )
  @ResponseStatus( HttpStatus.NO_CONTENT )
  public void updateActiveStatus( @PathVariable Long id, @RequestBody Boolean activeStatus ) {
    personService.updateActiveStatus( id, activeStatus );
  }
}

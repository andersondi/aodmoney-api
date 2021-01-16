package com.aod.aodmoney.api.resource;

import com.aod.aodmoney.api.event.ResourceCreatedEvent;
import com.aod.aodmoney.api.model.Person;
import com.aod.aodmoney.api.repository.PersonRepository;
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
  private PersonRepository personRepository;

  @Autowired
  private ApplicationEventPublisher publisher;

  @PostMapping
  @ApiOperation( "Add a new person" )
  @ApiResponses( value = { @ApiResponse( code = 201, message = "Person added" ) } )
  public ResponseEntity< Person > create( @Valid @RequestBody Person person, HttpServletResponse response ) {
    Person savedPerson = personRepository.save( person );

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
    Optional person = personRepository.findById( id );

    return person.isPresent() ? ResponseEntity.ok( person ) : ResponseEntity.notFound().build();
  }
}

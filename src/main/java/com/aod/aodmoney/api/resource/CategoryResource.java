package com.aod.aodmoney.api.resource;

import com.aod.aodmoney.api.model.Category;
import com.aod.aodmoney.api.repository.CategoryRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping( "/categories" )
public class CategoryResource {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping
  @ApiOperation( "List all categories" )
  @ApiResponses( value = { @ApiResponse( code = 200, message = "Categories listed" ) } )
  public List< Category > listAll() {
    return categoryRepository.findAll();
  }

  @PostMapping
//  @ResponseStatus( HttpStatus.CREATED) This annotation is not necessary because the operation was defined by the RequestBody return
  @ApiOperation( "Add a new category" )
  @ApiResponses( value = { @ApiResponse( code = 201, message = "Category added" ) } )
  public ResponseEntity< Category > create( @Valid @RequestBody Category category, HttpServletResponse response ) {
    Category savedCategory = categoryRepository.save( category );

    URI uri = ServletUriComponentsBuilder
            .fromCurrentRequestUri()
            .path( "/{id}" )
            .buildAndExpand( savedCategory.getId() )
            .toUri();

    response.setHeader( "Location", uri.toASCIIString() );

    return ResponseEntity.created( uri ).body( savedCategory );
  }

    @GetMapping( "/{id}" )
    @ApiOperation( "Search for a category using an id" )
    @ApiResponses( value = {
            @ApiResponse( code = 200, message = "Category found" ),
            @ApiResponse( code = 404, message = "Category not found" )
    } )
    public ResponseEntity< Optional< Category > > findCategoryById( @PathVariable( "id" ) Long id ) /*throws Exception*/ {
      /*if(!categoryRepository.findById( id ).isPresent()){
        throw new Exception();
      }*/
      return ResponseEntity.ok( categoryRepository.findById( id ) );
    }
}

package io.swagger.api;

import io.swagger.model.Recipe;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.RecipeRequest;
import io.swagger.model.RecipeService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;

import io.swagger.v3.oas.annotations.media.Schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2025-02-08T19:54:28.896589640Z[GMT]")
@RestController
public class RecipeApiController implements RecipeApi {

    private final RecipeService recipeService;

    private static final Logger log = LoggerFactory.getLogger(RecipeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RecipeApiController(ObjectMapper objectMapper, HttpServletRequest request, RecipeService recipeService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.recipeService = recipeService;
    }

    public ResponseEntity<Recipe> addRecipe(
            @RequestBody
            RecipeRequest body
    ) {
        try {
            Recipe recipe = recipeService.addRecipe(body.getName(), body.getIngredients());
            return ResponseEntity.ok(recipe);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<Recipe>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Void> deleteRecipe(
            @Parameter(in = ParameterIn.PATH, description = "идентификатор рецепта", required=true, schema=@Schema()) @PathVariable("id")
            Long id
    ) {
        try {
            recipeService.deleteRecipe(id);
            return new ResponseEntity<Void>(HttpStatus.valueOf(201));
        }
        catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Recipe> getRecipeById(
            @Parameter(in = ParameterIn.PATH, description = "идентификатор рецепта", required=true, schema=@Schema()) @PathVariable("id")
            Long id
    ) {
        Optional<Recipe> recipe = recipeService.getRecipeById(id);
        if (recipe.isPresent() && !recipe.isEmpty())
            return ResponseEntity.ok(recipeService.getRecipeById(id).get());
        return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Recipe>> getRecipes() {
        try {
            return ResponseEntity.ok(recipeService.getAllRecipes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Recipe>>(HttpStatus.BAD_REQUEST);
        }

    }

}

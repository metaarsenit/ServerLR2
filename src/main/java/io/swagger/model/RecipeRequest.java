package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;


@Schema(hidden = true)
public class RecipeRequest {

    private String name;
    private List<String> ingredients;


    public String getName() { return name; }
    public List<String> getIngredients() { return ingredients; }

    public void setName(String name) { this.name = name; }
    public void setIngredients(List<String> ingredients) { this.ingredients = ingredients; }
}

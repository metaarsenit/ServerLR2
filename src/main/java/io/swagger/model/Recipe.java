package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("recipe")
@Schema(description = "объект, представляющий данные о рецепте")
public class Recipe   {
  @Id
  private Long id = null;
  private String name = null;
  private String ingredients = null;

  public Recipe id(Long id) {
    this.id = id;
    return this;
  }

  public Recipe() {}

  public Recipe(String name, List<String> ingredients) {
    this.name = name;
    this.ingredients = String.join(",", ingredients);
  }

  @Schema(description = "идентификатор")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  @Schema(description = "Название рецепта")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  @Schema(description = "Ингредиенты")
  public List<String> getIngredients() {
    return getIngredientsList();
  }
  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public void setIngredientsList(List<String> ingredients) {
    this.ingredients = String.join(",", ingredients);
  }



  @JsonIgnore
  public List<String> getIngredientsList() {
    return List.of(ingredients.split(","));
  }




  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(this.id, recipe.id) &&
        Objects.equals(this.name, recipe.name) &&
        Objects.equals(this.ingredients, recipe.ingredients);
  }
}

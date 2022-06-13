package com.sika.bartrainer.Drink;

import java.util.Map;
import java.util.HashMap;

import com.sika.bartrainer.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/drinks")
public class DrinkController {
  @Autowired
  private DrinkService drinkService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Iterable<Drink>> list() {
    Iterable<Drink> drinks = drinkService.list();
    return createHashPlural(drinks);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Drink> read(@PathVariable Long id) {
    Drink drink = drinkService
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));
    return createHashSingular(drink);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, Drink> create(@Validated @RequestBody Drink drink) {
    Drink createdResource = drinkService.create(drink);
    return createHashSingular(createdResource);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, Drink> update(@RequestBody Drink drink, @PathVariable Long id) {
    Drink updatedResource = drinkService
        .update(drink)
        .orElseThrow(() -> new ResourceNotFoundException("No resource with that ID"));

    return createHashSingular(updatedResource);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    drinkService.deleteById(id);
  }

  private Map<String, Drink> createHashSingular(Drink drink) {
    Map<String, Drink> response = new HashMap<String, Drink>();
    response.put("drink", drink);

    return response;
  }

  private Map<String, Iterable<Drink>> createHashPlural(Iterable<Drink> drinks) {
    Map<String, Iterable<Drink>> response = new HashMap<String, Iterable<Drink>>();
    response.put("drinks", drinks);

    return response;
  }
}

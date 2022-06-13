package com.sika.bartrainer.Drink;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkService {
  @Autowired
  private DrinkRepository drinkRepository;

  public Iterable<Drink> list() {
    return drinkRepository.findAll();
  }

  public Optional<Drink> findById(Long id) {
    return drinkRepository.findById(id);
  }

  public Drink create(Drink drink) {
    return drinkRepository.save(drink);
  }

  public Optional<Drink> update(Drink drink) {
    Optional<Drink> foundDrink = drinkRepository.findById(drink.getId());

    if (foundDrink.isPresent()) {
      Drink updatedDrink = foundDrink.get();
      updatedDrink.setId(drink.getId());
      updatedDrink.setName(drink.getName());
      updatedDrink.setGlass(drink.getName());
      updatedDrink.setMethod(drink.getMethod());
      updatedDrink.setIngredient1(drink.getIngredient1());
      updatedDrink.setIngredient2(drink.getIngredient2());
      updatedDrink.setIngredient3(drink.getIngredient3());
      updatedDrink.setIngredient4(drink.getIngredient4());
      updatedDrink.setIngredient5(drink.getIngredient5());
      updatedDrink.setIngredient6(drink.getIngredient6());
      updatedDrink.setTopper(drink.getTopper());
      updatedDrink.setInstruction1(drink.getInstruction1());
      updatedDrink.setInstruction2(drink.getInstruction2());
      updatedDrink.setInstruction3(drink.getInstruction3());
      updatedDrink.setInstruction4(drink.getInstruction4());
      updatedDrink.setInstruction5(drink.getInstruction5());
      updatedDrink.setInstruction6(drink.getInstruction6());
      updatedDrink.setInstruction7(drink.getInstruction7());
      updatedDrink.setGarnish(drink.getGarnish());
      updatedDrink.setImageurl(drink.getImageurl());

      drinkRepository.save(updatedDrink);
      return Optional.of(updatedDrink);
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    drinkRepository.deleteById(id);
  }
}

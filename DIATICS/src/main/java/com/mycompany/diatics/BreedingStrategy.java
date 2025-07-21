/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BreedingStrategy {

    public void processBreeding(List<Animal> animals) {
        List<Animal> newBorns = new ArrayList<>();
        List<Animal> aliveAnimals = animals.stream().filter(Animal::isAlive).toList();

        for (int i = 0; i < aliveAnimals.size(); i++) {
            for (int j = i + 1; j < aliveAnimals.size(); j++) {
                Animal parent1 = aliveAnimals.get(i);
                Animal parent2 = aliveAnimals.get(j);

                if (parent1.canBreed(parent2)) {
                    Animal offspring = createOffspring(parent1, parent2);
                    if (offspring != null) {
                        newBorns.add(offspring);
                        break; // Her hayvan döngüde bir kez ürer
                    }
                }
            }
        }

        animals.addAll(newBorns);
    }

    private Animal createOffspring(Animal parent1, Animal parent2) {
        Gender offspringGender = ThreadLocalRandom.current().nextBoolean() ?
                                Gender.ERKEK : Gender.DISI;
        AnimalFactory factory = new AnimalFactory();

        if (parent1 instanceof HerbivorousAnimal) {
            return factory.createAnimal(HerbivorousAnimal.class,
                                        parent1.getSpecies(), offspringGender);
        } else if (parent1 instanceof CarnivorousAnimal) {
            return factory.createAnimal(CarnivorousAnimal.class,
                                        parent1.getSpecies(), offspringGender);
        }

        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HuntingStrategy {

    public void processHunting(List<Animal> animals) {
        List<Predator> predators = animals.stream()
            .filter(Animal::isAlive)
            .filter(animal -> animal instanceof Predator)
            .map(animal -> (Predator) animal)
            .toList();

        for (Predator predator : predators) {
            List<Animal> prey = predator.findPrey(animals);
            if (!prey.isEmpty()) {
                Animal target = prey.get(ThreadLocalRandom.current().nextInt(prey.size()));
                predator.hunt(target);
            }
        }
    }
}

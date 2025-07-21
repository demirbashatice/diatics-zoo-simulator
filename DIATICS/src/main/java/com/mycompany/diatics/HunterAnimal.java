/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.List;

public class HunterAnimal extends Animal implements Predator {

    public HunterAnimal(AnimalSpecies species, Gender gender) {
        super(species, gender);
    }

    @Override
    protected MovementVector calculateMovement() {
        return MovementVector.createRandom(species.getMovementSpeed());
    }

    @Override
    public boolean canHunt(Animal prey) {
        return this.getDistanceTo(prey) <= species.getHuntingRange() &&
               prey.species != AnimalSpecies.AVCI;
    }

    @Override
    public boolean canBreed(Animal partner) {
        return false;
    }

    @Override
    public List<Animal> findPrey(List<Animal> animals) {
        return animals.stream()
            .filter(Animal::isAlive)
            .filter(animal -> animal != this)
            .filter(this::canHunt)
            .toList();
    }

    @Override
    public void hunt(Animal prey) {
        if (canHunt(prey)) {
            prey.kill();
        }
    }
}

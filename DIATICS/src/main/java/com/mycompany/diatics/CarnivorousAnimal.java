/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.List;

public class CarnivorousAnimal extends Animal implements Predator {

    public CarnivorousAnimal(AnimalSpecies species, Gender gender) {
        super(species, gender);
    }

    @Override
    protected MovementVector calculateMovement() {
        return MovementVector.createRandom(species.getMovementSpeed());
    }

    @Override
    public boolean canHunt(Animal prey) {
        if (this.getDistanceTo(prey) > species.getHuntingRange()) return false;

        return switch (this.species) {
            case KURT -> prey.species == AnimalSpecies.KOYUN ||
                          prey.species == AnimalSpecies.TAVUK ||
                          prey.species == AnimalSpecies.HOROZ;
            case ASLAN -> prey.species == AnimalSpecies.INEK ||
                           prey.species == AnimalSpecies.KOYUN;
            default -> false;
        };
    }

    @Override
    public boolean canBreed(Animal partner) {
        return this.species == partner.species &&
               this.gender != partner.gender &&
               this.getDistanceTo(partner) <= ZooSimulation.BREEDING_DISTANCE;
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

/**
 *
 * @author 90539
 */
public class HerbivorousAnimal extends Animal {

    public HerbivorousAnimal(AnimalSpecies species, Gender gender) {
        super(species, gender);
    }

    @Override
    protected MovementVector calculateMovement() {
        return MovementVector.createRandom(species.getMovementSpeed());
    }

    @Override
    public boolean canHunt(Animal prey) {
        return false;
    }

    @Override
    public boolean canBreed(Animal partner) {
        return this.species == partner.species &&
               this.gender != partner.gender &&
               this.getDistanceTo(partner) <= ZooSimulation.BREEDING_DISTANCE;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.List;

public class InteractionManager {
    private final HuntingStrategy huntingStrategy;
    private final BreedingStrategy breedingStrategy;

    public InteractionManager() {
        this.huntingStrategy = new HuntingStrategy();
        this.breedingStrategy = new BreedingStrategy();
    }

    public void processAllInteractions(List<Animal> animals) {
        huntingStrategy.processHunting(animals);
        breedingStrategy.processBreeding(animals);
    }
}


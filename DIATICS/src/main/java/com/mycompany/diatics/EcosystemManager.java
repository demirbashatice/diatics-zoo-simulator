/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.ArrayList;
import java.util.List;

public class EcosystemManager {
    private final List<Animal> animals;
    private final MovementManager movementManager;
    private final InteractionManager interactionManager;
    private final ReportManager reportManager;

    public EcosystemManager() {
        this.animals = new ArrayList<>();
        this.movementManager = new MovementManager();
        this.interactionManager = new InteractionManager();
        this.reportManager = new ReportManager();
        initializeEcosystem();
    }

    public void runSimulation() {
        reportManager.printInitialReport(animals);

        for (int movement = 1; movement <= ZooSimulation.TOTAL_MOVEMENTS; movement++) {
            executeMovementCycle();

            if (movement % 100 == 0) {
                reportManager.printProgressReport(animals, movement);
            }
        }

        reportManager.printFinalReport(animals);
    }

    private void executeMovementCycle() {
        movementManager.moveAllAnimals(animals);
        interactionManager.processAllInteractions(animals);
    }

    private void initializeEcosystem() {
        AnimalFactory factory = new AnimalFactory();

        animals.addAll(factory.createHerd(HerbivorousAnimal.class, AnimalSpecies.KOYUN, 15, 15));
        animals.addAll(factory.createHerd(HerbivorousAnimal.class, AnimalSpecies.INEK, 5, 5));
        animals.addAll(factory.createHerd(HerbivorousAnimal.class, AnimalSpecies.TAVUK, 0, 10));
        animals.addAll(factory.createHerd(HerbivorousAnimal.class, AnimalSpecies.HOROZ, 10, 0));

        animals.addAll(factory.createHerd(CarnivorousAnimal.class, AnimalSpecies.KURT, 5, 5));
        animals.addAll(factory.createHerd(CarnivorousAnimal.class, AnimalSpecies.ASLAN, 4, 4));

        animals.add(factory.createAnimal(HunterAnimal.class, AnimalSpecies.AVCI, Gender.ERKEK));
    }
}

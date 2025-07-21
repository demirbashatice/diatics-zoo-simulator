/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.ArrayList;
import java.util.List;

public class AnimalFactory {

    public <T extends Animal> List<Animal> createHerd(Class<T> animalClass,
                                                     AnimalSpecies species,
                                                     int maleCount,
                                                     int femaleCount) {
        List<Animal> herd = new ArrayList<>();

        for (int i = 0; i < maleCount; i++) {
            herd.add(createAnimal(animalClass, species, Gender.ERKEK));
        }

        for (int i = 0; i < femaleCount; i++) {
            herd.add(createAnimal(animalClass, species, Gender.DISI));
        }

        return herd;
    }

    public <T extends Animal> Animal createAnimal(Class<T> animalClass,
                                                 AnimalSpecies species,
                                                 Gender gender) {
        try {
            return animalClass.getDeclaredConstructor(AnimalSpecies.class, Gender.class)
                             .newInstance(species, gender);
        } catch (Exception e) {
            throw new RuntimeException("Hayvan oluşturulamadı: " + e.getMessage());
        }
    }
}

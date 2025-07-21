/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.List;

public class MovementManager {

    public void moveAllAnimals(List<Animal> animals) {
        animals.stream()
               .filter(Animal::isAlive)
               .forEach(Animal::move);
    }
}

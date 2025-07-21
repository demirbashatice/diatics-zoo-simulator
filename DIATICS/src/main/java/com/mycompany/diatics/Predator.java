/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.diatics;
import java.util.List;

public interface Predator {
    List<Animal> findPrey(List<Animal> animals);
    void hunt(Animal prey);
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportManager {

    public void printInitialReport(List<Animal> animals) {
        System.out.println("\nBAŞLANGIÇ DURUMU:");
        printPopulationSummary(animals);
    }

    public void printProgressReport(List<Animal> animals, int movement) {
        System.out.println("\n--- " + movement + ". Hareket Sonrası ---");
        printPopulationSummary(animals);
    }

    public void printFinalReport(List<Animal> animals) {
        System.out.println("\n=== FİNAL RAPORU ===");
        printDetailedPopulation(animals);
    }

    private void printPopulationSummary(List<Animal> animals) {
        Map<AnimalSpecies, Long> population = animals.stream()
            .filter(Animal::isAlive)
            .collect(Collectors.groupingBy(
                Animal::getSpecies,
                Collectors.counting()
            ));

        System.out.println("Popülasyon Durumu:");
        for (AnimalSpecies species : AnimalSpecies.values()) {
            Long count = population.getOrDefault(species, 0L);
            System.out.println("  " + species.getDisplayName() + ": " + count);
        }

        long totalAlive = animals.stream().filter(Animal::isAlive).count();
        System.out.println("  Toplam Canlı: " + totalAlive);
    }

    private void printDetailedPopulation(List<Animal> animals) {
        Map<AnimalSpecies, Map<Gender, Long>> detailedPop = animals.stream()
            .filter(Animal::isAlive)
            .collect(Collectors.groupingBy(
                Animal::getSpecies,
                Collectors.groupingBy(
                    Animal::getGender,
                    Collectors.counting()
                )
            ));

        System.out.println("Detaylı Popülasyon Raporu:");
        for (AnimalSpecies species : AnimalSpecies.values()) {
            Map<Gender, Long> genderCount = detailedPop.getOrDefault(species, new HashMap<>());
            long male = genderCount.getOrDefault(Gender.ERKEK, 0L);
            long female = genderCount.getOrDefault(Gender.DISI, 0L);

            System.out.printf("  %s: %d (Erkek: %d, Dişi: %d)%n",
                species.getDisplayName(), male + female, male, female);
        }
    }
}

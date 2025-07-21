/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

public enum AnimalSpecies {
    KOYUN("Koyun", 2, 0),
    INEK("İnek", 2, 0),
    TAVUK("Tavuk", 1, 0),
    HOROZ("Horoz", 1, 0),
    KURT("Kurt", 3, 4),
    ASLAN("Aslan", 4, 5),
    AVCI("Avcı", 1, 8);

    private final String displayName;
    private final int movementSpeed;
    private final double huntingRange;

    AnimalSpecies(String displayName, int movementSpeed, double huntingRange) {
        this.displayName = displayName;
        this.movementSpeed = movementSpeed;
        this.huntingRange = huntingRange;
    }

    public String getDisplayName() { return displayName; }
    public int getMovementSpeed() { return movementSpeed; }
    public double getHuntingRange() { return huntingRange; }
}

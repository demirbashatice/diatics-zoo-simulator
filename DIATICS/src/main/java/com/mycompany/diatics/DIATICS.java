/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.diatics;

/**
 *
 * @author 90539
 */
public class DIATICS {

   public static final int FIELD_SIZE = 500;
    public static final int TOTAL_MOVEMENTS = 1000;
    public static final int BREEDING_DISTANCE = 3;

    public static void main(String[] args) {
        System.out.println("=== OOP TABANLI HAYVANAT BAHÇESİ SİMÜLASYONU ===");
        EcosystemManager manager = new EcosystemManager();
        manager.runSimulation();
    }
}


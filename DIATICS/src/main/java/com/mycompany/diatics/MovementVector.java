/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.concurrent.ThreadLocalRandom;

public class MovementVector {
    private final int deltaX, deltaY;

    public MovementVector(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public static MovementVector createRandom(int maxDistance) {
        double angle = ThreadLocalRandom.current().nextDouble() * 2 * Math.PI;
        int deltaX = (int) (Math.cos(angle) * maxDistance);
        int deltaY = (int) (Math.sin(angle) * maxDistance);
        return new MovementVector(deltaX, deltaY);
    }

    public int getDeltaX() { return deltaX; }
    public int getDeltaY() { return deltaY; }
}

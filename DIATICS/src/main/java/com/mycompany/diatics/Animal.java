/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.diatics;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    protected final AnimalSpecies species;
    protected final Gender gender;
    protected Position position;
    protected boolean alive;
    protected final UUID id;

    public Animal(AnimalSpecies species, Gender gender) {
        this.species = species;
        this.gender = gender;
        this.position = new Position(getRandomCoordinate(), getRandomCoordinate());
        this.alive = true;
        this.id = UUID.randomUUID();
    }

    public final void move() {
        if (!alive) return;
        MovementVector vector = calculateMovement();
        Position newPosition = applyMovementConstraints(vector);
        this.position = newPosition;
    }

    protected abstract MovementVector calculateMovement();
    public abstract boolean canHunt(Animal prey);
    public abstract boolean canBreed(Animal partner);

    private Position applyMovementConstraints(MovementVector vector) {
        int newX = Math.max(0, Math.min(ZooSimulation.FIELD_SIZE - 1,
                position.getX() + vector.getDeltaX()));
        int newY = Math.max(0, Math.min(ZooSimulation.FIELD_SIZE - 1,
                position.getY() + vector.getDeltaY()));
        return new Position(newX, newY);
    }

    public double getDistanceTo(Animal other) {
        return this.position.distanceTo(other.position);
    }

    private int getRandomCoordinate() {
        return ThreadLocalRandom.current().nextInt(0, ZooSimulation.FIELD_SIZE);
    }

    public AnimalSpecies getSpecies() { return species; }
    public Gender getGender() { return gender; }
    public Position getPosition() { return position; }
    public boolean isAlive() { return alive; }
    public void kill() { this.alive = false; }
    public UUID getId() { return id; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Animal animal = (Animal) obj;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

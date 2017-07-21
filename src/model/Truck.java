/*
 * Pamaldeep Singh Dhillon
 * Truck.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package model;

import java.util.Map;

/**
 * Truck class that contains specifics for truck movement.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public final class Truck extends AbstractVehicle {
    
    /**
     * Constructor for Truck, uses the super class constructor.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir);
    }
    
    /**
     * Moves randomly and drives through all traffic lights without stopping.
     * 
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.random();
        if (canPass(theNeighbors.get(result), Light.GREEN)) {
            result = Direction.random();
        }
        return result;
    }
    
    /**
     * Truck can pass on streets and lights.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT) {
            result = true;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDeathTime() {
        return 0;
    }
}

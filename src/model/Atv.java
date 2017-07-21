/*
 * Pamaldeep Singh Dhillon
 * Atv.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package model;

import java.util.Map;

/**
 * Atv class that contains specifics for atv movement.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public class Atv extends AbstractVehicle {
    
    /** Number of turns vehicle stays dead.*/
    private static final int DEATH_TIME = 20;
    
    /**
     * Constructor for Atv class, uses super class constructor.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir);
    }
    
    /**
     * ATVs randomly select to go straight, turn left, or turn right.
     * 
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.random();
        if (theNeighbors.get(result) == Terrain.WALL) {
            result = Direction.random();
        }
        return result;
    }
    
    /**
     * ATVs can travel on any terrain except walls. They drive through all lights without
     * stopping.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain != Terrain.WALL) {
            result = true;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDeathTime() {
        return DEATH_TIME;
    }

}

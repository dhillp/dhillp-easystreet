/*
 * Pamaldeep Singh Dhillon
 * Human.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package model;

import java.util.Map;

/**
 * Human class that contains specifics for human movement.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public class Human extends AbstractVehicle {
    
    /** Number of turns vehicle stays dead.*/
    private static final int DEATH_TIME = 50;
    
    /** Initial terrain for the vehicle.*/
    private final Terrain myTerrain;
    
    /**
     * Constructor for Human class, uses super class constructor.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     * @param theTerrain Terrain on which vehicle starts on.
     */
    public Human(final int theX, final int theY, final Direction theDir,
                 final Terrain theTerrain) {
        super(theX, theY, theDir);
        myTerrain = theTerrain;
    }
    
    /**
     * Humans move in a random direction on the terrain it started on.
     * 
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = Direction.random();
        while (!canPass(theNeighbors.get(result), Light.GREEN)) {
            result = Direction.random();
        }
        return result;
    }
    
    /**
     * Stays on the terrain it starts on. Can pass lights if on the street. Ignore color
     * of lights.
     * 
     *{@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if ((myTerrain == Terrain.STREET || myTerrain == Terrain.LIGHT)
                        && (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT)) {
            result = true;
        } else if (theTerrain == myTerrain) {
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

/*
 * Pamaldeep Singh Dhillon
 * Car.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package model;

import java.util.Map;

/**
 * Car class that contains specifics for car movement.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public class Car extends AbstractVehicle {
    
    /** Number of turns vehicle stays dead.*/
    private static final int DEATH_TIME = 10;
    
    /**
     * Constructor for Car class, uses super class constructor.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     */
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir);
    }
    
    /**
     * A car prefers to drive straight on the street if it can. If not, it turns left
     * if possible; if it cannot turn left, it turns right if possible; as a last resort,
     * it turns around.
     * 
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = this.getDirection();
        if (theNeighbors.get(result) == Terrain.STREET 
                        || theNeighbors.get(result) == Terrain.LIGHT) {
            result = this.getDirection();
        } else if (theNeighbors.get(result.left()) == Terrain.STREET) {
            result = result.left();
        } else if (theNeighbors.get(result.right()) == Terrain.STREET) {
            result = result.right();
        } else {
            result = result.reverse();
        }
        return result;
    }
    
    /**
     * Cars can only travel on streets and through lights. Cars ignore yellow and green lights.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT
                        && theLight != Light.RED) {
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
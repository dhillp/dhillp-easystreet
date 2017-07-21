/*
 * Pamaldeep Singh Dhillon
 * Bicycle.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package model;

import java.util.Map;

/**
 * Bicycle class that contains specifics for bicycle movement.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public class Bicycle extends AbstractVehicle {
    
    /** Number of turns vehicle stays dead.*/
    private static final int DEATH_TIME = 30;
    
    /**
     * Constructor for Bicycle class, uses super class constructor.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir);
    }
    
    /**
     * Bikes prefer to travel on trails. If it is on a trail it always goes straight and 
     * if it is not on a trail but there is a trail either straight ahead, to the left, or to
     * the right of it's current direction, then it turns to face the trail and moves that way.
     * If it is on a street and there is no trail near it, it prefers to go straight if
     * possible, if not then left if possible, if not then right if possible, if not then
     * in reverse.
     * 
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = this.getDirection();
        if (theNeighbors.get(result) == Terrain.TRAIL) {
            result = this.getDirection();
        } else if (theNeighbors.get(result.left()) == Terrain.TRAIL) {
            result = result.left();
        } else if (theNeighbors.get(result.right()) == Terrain.TRAIL) {
            result = result.right();
        } else {
            result = chooseDirectionHelper(theNeighbors, result);
        }
        return result;
    }
    
    /**
     * Helper for chooseDirection that returns a direction if a trail isn't available
     * for the bike to go on.
     * 
     * @param theNeighbors Map containing the types of terrain that neighbor this vehicle.
     * @param theDir Initial direction from chooseDirection method.
     * @return result Direction in which this vehicle would like to move.
     */
    public Direction chooseDirectionHelper(final Map<Direction, Terrain> theNeighbors,
                                           final Direction theDir) {
        Direction result = theDir;
        if (theNeighbors.get(result) == Terrain.STREET
                        || theNeighbors.get(result) == Terrain.LIGHT) {
            result = this.getDirection();
        } else if (theNeighbors.get(result.left()) == Terrain.STREET
                        || theNeighbors.get(result) == Terrain.LIGHT) {
            result = result.left();
        } else if (theNeighbors.get(result.right()) == Terrain.STREET
                        || theNeighbors.get(result) == Terrain.LIGHT) {
            result = result.right();
        } else {
            result = result.reverse();
        }
        return result;
    }
    
    /**
     * A Bicycle can travel on streets, lights, and trails.
     * 
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.TRAIL || theTerrain == Terrain.STREET) {
            result = true;
        } else if (theTerrain == Terrain.LIGHT && theLight == Light.GREEN) {
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

/*
 * Pamaldeep Singh Dhillon
 * AbstractVehicle.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */

package model;

import java.util.Map;

/**
 * Abstract vehicle class that contains all methods used by subclasses.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public abstract class AbstractVehicle implements Vehicle {
    /** X-coordinate of vehicle.*/
    private int myX;
    /** Original X-coordinate of vehicle for reset().*/
    private final int myInitialX;
    /** Y-coordinate of vehicle.*/
    private int myY;
    /** Original Y-coordinate of vehicle for reset().*/
    private final int myInitialY;
    /** Direction of vehicle.*/
    private Direction myDir;
    /** Original direction of vehicle for reset().*/
    private final Direction myInitialDir;
    /** True if vehicle is alive, false otherwise.*/
    private boolean myAlive;
    /** Number of times vehicle poked while it is dead.*/
    private int myPokes;
    /**
     * Constructor for AbstractVehicle. All subclass vehicles use this.
     * 
     * @param theX X-coordinate of the vehicle.
     * @param theY Y-coordinate of the vehicle.
     * @param theDir Direction of the vehicle.
     */
    public AbstractVehicle(final int theX, final int theY, final Direction theDir) {
        myX = theX;
        myInitialX = theX;
        myY = theY;
        myInitialY = theY;
        myDir = theDir;
        myInitialDir = theDir;
        myAlive = true;
        myPokes = 0;
    }
    /**
     * Returns the direction this object would like to move, based on the given
     * map of the neighboring terrain.
     * 
     * @param theNeighbors Map containing the types of terrain that neighbor this vehicle.
     * @return result Direction in which this vehicle would like to move.
     */
    public abstract Direction chooseDirection(final Map<Direction, Terrain> theNeighbors);
    
    /**
     * Returns whether or not this object may move onto the given type of
     * terrain, when the street lights are the given color.
     * 
     * @param theTerrain Terrain that vehicle is trying to pass through.
     * @param theLight Light that vehicle is trying to pass through.
     * @return result Whether this vehicle can pass through the given terrain/light.
     */
    public abstract boolean canPass(final Terrain theTerrain, final Light theLight);
    
    /**
     * Called when this Vehicle collides with the specified other Vehicle.
     * 
     * @param theOther Vehicle this vehicle is colliding with.
     */
    public void collide(final Vehicle theOther) {
        if (theOther.isAlive() && this.getDeathTime() > theOther.getDeathTime()) {
            myAlive = false;
        }
    }
    
    /**
     * Returns the file name of the image for this Vehicle object, such as
     * "car.gif".
     * 
     * @return Name of the image file that the GUI will use to draw this vehicle on the screen.
     */
    public String getImageFileName() {
        String result;
        if (this.isAlive()) {
            result = getClass().getSimpleName().toLowerCase() + ".gif";
        } else {
            result = getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }
        return result;
    }
    
    /**
     * Returns the number of updates between this vehicle's death and when it
     * should be revived.
     * 
     * @return myDeathTime Number of updates until vehicle can be revived.
     */
    public abstract int getDeathTime();
    
    /**
     * Returns this Vehicle object's direction.
     * 
     * @return Direction of the vehicle.
     */
    public Direction getDirection() {
        return myDir;
    }
    
    /**
     * Returns this Vehicle object's x-coordinate.
     * 
     * @return X-coordinate of the vehicle.
     */
    public int getX() {
        return myX;
    }
    
    /**
     * Returns this Vehicle object's y-coordinate.
     * 
     * @return Y-coordinate of the vehicle.
     */
    public int getY() {
        return myY;
    }
    
    /**
     * Returns whether this Vehicle object is alive and should move on the map.
     * 
     * @return Whether the vehicle is alive or not.
     */
    public boolean isAlive() {
        return myAlive;
    }
    
    /**
     * Called by the UI to notify a dead vehicle that 1 movement round has
     * passed, so that it will become 1 move closer to revival.
     */
    public void poke() {
        if (myPokes == this.getDeathTime()) {
            myAlive = true;
            this.setDirection(Direction.random());
            myPokes = 0;
        } else {
            myPokes++;
        }
    }
    
    /**
     * Moves this vehicle back to its original position.
     */
    public void reset() {
        this.setX(myInitialX);
        this.setY(myInitialY);
        this.setDirection(myInitialDir);
        myAlive = true;
    }
    
    /**
     * Sets this object's facing direction to the given value.
     * 
     * @param theDir New direction of the vehicle.
     */
    public void setDirection(final Direction theDir) {
        myDir = theDir;
    }
    
    /**
     * Sets this object's x-coordinate to the given value.
     * 
     * @param theX New x-coordinate of the vehicle.
     */
    public void setX(final int theX) {
        myX = theX;
    }
    
    /**
     * Sets this object's y-coordinate to the given value.
     * 
     * @param theY New y-coordinate of the vehicle.
     */
    public void setY(final int theY) {
        myY = theY;
    }
    
    /**
     * Returns class name in lower case plus number of times vehicle is poked.
     * 
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ' ' + myPokes;
    }
}

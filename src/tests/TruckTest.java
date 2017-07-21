/*
 * Pamaldeep Singh Dhillon
 * TruckTest.java
 * 
 * TCSS 305 - Autumn 2015
 * Assignment 3 - Easystreet
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Car;
import model.Direction;
import model.Truck;

/**
 * Tests for truck class.
 * 
 * @author Pamaldeep Dhillon
 * @version 27 October 2015
 */
public class TruckTest {

    /** Test method for Human constructor. */
    @Test
    public void testTruckConstructor() {
        final Truck t = new Truck(5, 6, Direction.NORTH);
        
        assertEquals("Human x coordinate not initialized correctly!", 5, t.getX());
        assertEquals("Human y coordinate not initialized correctly!", 6, t.getY());
        assertEquals("Human direction not initialized correctly!",
                     Direction.NORTH, t.getDirection());
        assertEquals("Human death time not initialized correctly!", 0, t.getDeathTime());
        assertTrue("Human isAlive() fails initially!", t.isAlive());
    }

    /**
     * Test method for {@link model.Truck#chooseDirection(java.util.Map)}.
     */
    @Test
    public void testChooseDirection() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link model.Truck#canPass(model.Terrain, model.Light)}.
     */
    @Test
    public void testCanPass() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link model.AbstractVehicle#collide(model.Vehicle)}.
     */
    @Test
    public void testCollide() {
        final Truck t1 = new Truck(3, 4, Direction.NORTH);
        t1.collide(new Car(1, 2, Direction.NORTH));
        assertEquals("Car should not kill truck!", true, t1.isAlive());
    }

    /**
     * Test method for {@link model.AbstractVehicle#getImageFileName()}.
     */
    @Test
    public void testGetImageFileName() {
        final Truck t1 = new Truck(1, 2, Direction.NORTH);
        assertEquals("truck.gif", t1.getImageFileName());
    }

    /**
     * Test method for {@link model.AbstractVehicle#poke()}.
     */
    @Test
    public void testPoke() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link model.AbstractVehicle#reset()}.
     */
    @Test
    public void testReset() {
        final Truck t1 = new Truck(1, 1, Direction.NORTH);
        t1.setX(2);
        t1.setY(2);
        t1.setDirection(Direction.EAST);
        assertEquals("X did not change when set!", 2, t1.getX());
        assertEquals("Y did not change when set!", 2, t1.getY());
        assertEquals("Direction didn't get set!", Direction.EAST, t1.getDirection());
        t1.reset();
        assertEquals("X not reset!", 1, t1.getX());
        assertEquals("Y not reset!", 1, t1.getY());
        assertEquals("Direction not reset!", Direction.NORTH, t1.getDirection());
    }

    /**
     * Test method for {@link model.AbstractVehicle#toString()}.
     */
    @Test
    public void testToString() {
        final Truck t1 = new Truck(1, 1, Direction.NORTH);
        assertEquals("toString() incorrect!", "Truck 0", t1.toString());
    }

}

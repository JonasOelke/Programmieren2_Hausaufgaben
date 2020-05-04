package ufogame;

/**
 * Declares methods to move GameObjects with the MoveGameObjects-Thread 
 * 
 * @author Jonas O.
 *
 */

public interface IMoveable {
	public void move();

	public int getX();
	public int getY();
}

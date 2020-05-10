package ufogame;

import view.IGameObject;

/**
 * Declares methods to move GameObjects with the MoveGameObjects-Thread 
 * 
 * @author Jonas O.
 *
 */

public interface IMoveable extends IGameObject{
	public void move();

	public int getX();
	public int getY();
}

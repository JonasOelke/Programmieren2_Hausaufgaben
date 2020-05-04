package ufogame;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import view.GameFrameWork;
import view.IGameObject;
import view.ITickableListener;

public class MoveGameObjects extends Thread implements ITickableListener{

	private ArrayList<ArrayList<? extends IGameObject>> GameObjectArrays = new ArrayList<>();
	
	GameFrameWork frameWork;
	
	MoveGameObjects(GameFrameWork frameWork) {
		this.frameWork = frameWork;
	}

	public void setObjectsToMove(ArrayList<Ufo> objectArray) {
		GameObjectArrays = new ArrayList<>();
		GameObjectArrays.add(objectArray);
	}
	
	@Override
	public void run() {
		for (ArrayList<? extends IGameObject> list : GameObjectArrays) {
			for (IGameObject obj : list) {
				obj.move();
			}
			
			/* if (list.get(0).getX() > frameWork.getWidth()) {
				frameWork.removeGameObject(list.get(0));
				list.remove(0);
				list.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
						ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
				frameWork.addGameObject(ufos.get(ufos.size() - 1));
			} */
		}
	}

	@Override
	public void tick(long elapsedTime) {

		
	}

}

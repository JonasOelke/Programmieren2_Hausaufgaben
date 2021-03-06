package ufogame;

import java.awt.Color;
import java.awt.Dimension;

import view.*;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import view.GameFrameWork;
import view.IKeyboardListener;
import view.IMouseListener;
import view.ITickableListener;
import view.Message;

public class Game implements ITickableListener, IKeyboardListener, IMouseListener {

	Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Ufo> ufos = new ArrayList<>();
	private Ship ship;
	private int screenWidth = screen.width;
	private int screenHeight = screen.height;
	private GameFrameWork frameWork = new GameFrameWork();
	private int score = 0; 
	private Message scoreMessage = new Message(Integer.toString(score), 800, 50, 16, new Color(255,255,255));
	private String playerName;
	
	
	/*
	 * Creates an Instance of the Game-Objects and sets the Playername
	 */
	Game(String playerName) {
		this.playerName = playerName;
	}
	
	/**
	 * Initiates everything for the game. Multiple ufos and a ship are created.
	 */
	public void init() {
		
		
		
		/*
		 * Sets the Window Dimensions to the full Screensize. 
		 * The bigger the screen the more fun it will make. 
		 */
		frameWork.setSize(screenWidth, screenHeight);
		frameWork.setBackground(new Background("Ufo-Game/assets/space.jpg"));

		/*
		 * Initiates the Ship to the x-middle and lowest fifth of the screen 
		 */
		ship = new Ship(screenWidth / 2, 4 * screenHeight / 5, screenWidth / 10, screenWidth / 10,
				"Ufo-Game/assets/ship.png");
		frameWork.addGameObject(ship);

		/*
		 * Initiates an Ufo outside the Screen (-20), with adjusted Dimensions to fit the user's screen size 
		 */
		Ufo ufo = new Ufo(-20, screenHeight / 5, screenWidth / 10, screenWidth / 19, 1,
				"Ufo-Game/assets/dino.png");
		ufos.add(ufo);
		frameWork.addGameObject(ufo);

		for (int i = 1; i < 10; i++) {
			ufos.add(new Ufo(ufos.get(i - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(i));
		}

		frameWork.addTick(this);
		frameWork.addIKeyInput(this);
		frameWork.addIMouseInput(this);

	}

	
	public void shoot() {
		
		Projectile projectile = new Projectile(ship.getX() + ship.getWidth()/4, 
				ship.getY() - ship.getWidth() / 2, ship.getWidth(), ship.getHeight(), 3,
				"Ufo-Game/assets/avo.png");
		projectiles.add(projectile);

		frameWork.addGameObject(projectile);

	}

	@Override
	public void tick(long elapsedTime) {
		for (Ufo ufo : ufos) {
			ufo.move();
		}
		if (ufos.get(0).getX() > screenWidth) {
			frameWork.removeGameObject(ufos.get(0));
			ufos.remove(0);
			ufos.add(new Ufo(ufos.get(ufos.size() - 1).getX() - 200, ufos.get(0).getY(), ufos.get(0).getWidth(),
					ufos.get(0).getHeight(), ufos.get(0).getSpeed(), ufos.get(0).getImagePath()));
			frameWork.addGameObject(ufos.get(ufos.size() - 1));
		}
		
		for(Projectile p: projectiles) {
            p.move();
        }
		
		/*
		 * This is to remove Projectiles that moved outside the Screen.
		 * It is checked whether the projectiles  
		 */
		if (!projectiles.isEmpty() && projectiles.get(0).getY() + projectiles.get(0).getHeight() < 0) {
            frameWork.removeGameObject(projectiles.get(0));
            projectiles.remove(0);
        }
		
		if (checkCollison()) {
			System.out.println("Collision detected!");
			scoreMessage.setMessage(Integer.toString(score));
			frameWork.addMessage(scoreMessage);
		}
	}
	
	public boolean checkCollison() {
		for (Ufo ufo : ufos) {
			int ufoX = ufo.getX();
			int ufoY = ufo.getY();
			
			for (Projectile projectile : projectiles) {
				int projectileX = projectile.getX();
				int projectileY = projectile.getY();
				
				int difference_y = projectileY - (ufoY + ufo.getHeight());
				if ((projectileX > ufoX && projectileX < ufoX + ufo.getWidth()) && 
					difference_y < 3 && difference_y > 0) {
					score++;
					frameWork.removeGameObject(ufo);
					ufos.remove(ufo);
					frameWork.removeGameObject(projectile);
					projectiles.remove(projectile);
					return true;
				} 
			}
		}
		
		return false;
	}
	
	//Saves the Score to a File and terminates the process - triggered by pressing "q"
	public void endGame() {
		Score playerScore = new Score(playerName, this.score);
		
		writeScoreToFile(playerScore);
		
		System.exit(0);
	}
	
	public void writeScoreToFile(Score playerScore) {
		Highscore scoreList;
		try {
			File file = new File("scores.txt");
			
			if (file.exists()) {
				FileInputStream fis;fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Object obj = ois.readObject();
				
				scoreList = obj instanceof Highscore ? (Highscore) obj : new Highscore();
			} else {
				scoreList = new Highscore();
			}
			
			scoreList.addScore(playerScore);
			
			scoreList.printScores();
			
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(scoreList);
			
			System.out.println("Your Highscore was successfully saved to file! \n Here is what we just saved:");
			scoreList.printScores();
			
			oos.close();
			fos.close();
		
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("An Error occured while trying to save the Highscore to file. Error: " + e.getMessage());
		}
	}
	
	
	@Override
	public int[] getKeys() {
		int [] keys = {KeyEvent.VK_SPACE, KeyEvent.VK_Q};
		return keys;
	}

	@Override
	public void keyDown(int key) {
		if (key == KeyEvent.VK_SPACE) {
			shoot();
		} else if (key == KeyEvent.VK_Q) {
			endGame();
		}
		
	}

	@Override
	public void mouseClicked() {
		System.out.println("Mouse clicked");
		
	}

}

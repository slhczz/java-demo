package com.demo.snake;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Controller extends KeyAdapter implements SnakeListener {
	
	private Snake snake;
	private Food food;
	private Ground ground;
	private GamePanel gamePanel;
	
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				snake.changeDirection(snake.UP);
				break;
			case KeyEvent.VK_DOWN:
				snake.changeDirection(snake.DOWN);
				break;
			case KeyEvent.VK_LEFT:
				snake.changeDirection(snake.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snake.changeDirection(snake.RIGHT);
				break;
				
		}
		
	}
	
	@Override
	public void snakeMoved(Snake snake) {
		if(food.isSnakeEatFood(snake)){
			snake.eatFood();
			food.newFood(ground.getPoint());
		}
		if(ground.isSnakeEatRock(snake)){
			snake.dir();
		}
		
		if(snake.isEatBody()){
			snake.dir();
		}
		
		gamePanel.display(snake, food, ground);
		
		
	}
	
	
	
	public void newGame(){
		snake.start();
		snake.setLife(true);
		food.newFood(ground.getPoint());
		
	}
}

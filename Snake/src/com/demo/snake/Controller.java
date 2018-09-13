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
//	有参构造
	public Controller(Snake snake, Food food, Ground ground, GamePanel gamePanel) {
		super();
		this.snake = snake;
		this.food = food;
		this.ground = ground;
		this.gamePanel = gamePanel;
	}
//键盘监听 控制蛇的上下左右移动
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
			case KeyEvent.VK_SPACE:
				if(!snake.isLife()){
					snake.setLife(true);
				}else{
					snake.setLife(false);
				}
				break;
				
		}
		
	}
//	蛇吃到食物和蛇撞到墙及蛇碰到身子
	@Override
	public void snakeMoved(Snake snake) {
		if(food.isSnakeEatFood(snake)){
			snake.eatFood();
			food.newFood(ground.getPoint());
		}
		if(ground.isSnakeEatRock(snake)){
			snake.dir("蛇撞墙啦！！");
		}
		
		if(snake.isEatBody()){
			snake.dir("蛇触碰到身体啦！！");
		}
		
		gamePanel.display(snake, food, ground);
		
		
	}
	
	
//	开始游戏
	public void newGame(){
		snake.start();
		food.newFood(ground.getPoint());
		
	}
}

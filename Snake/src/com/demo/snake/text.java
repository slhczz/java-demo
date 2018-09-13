package com.demo.snake;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class text {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Snake snake = new Snake();
		Ground ground = new Ground();
		Food food = new Food();
		GamePanel gamePanel = new GamePanel();
		Controller controller = new Controller(snake, food, ground, gamePanel);
		
		init(snake, gamePanel, controller);
		controller.newGame();
		
	}
//	初始化参数
	public static void init(Snake snake, GamePanel gamePanel,
			Controller controller) {
		JFrame frame = new JFrame();
		Panel panel = new Panel();
		Button btn = new Button("空格控制开始暂停游戏");
		frame.setTitle("贪吃蛇");
		frame.setLocation(600, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.setSize(20,20);
		gamePanel.setSize(Golbal.WIDTH * Golbal.CELL_SIZE,Golbal.HEIGHT * Golbal.CELL_SIZE);
		frame.setSize(Golbal.WIDTH * Golbal.CELL_SIZE + 15,Golbal.HEIGHT * Golbal.CELL_SIZE + 60);
		frame.add(gamePanel,BorderLayout.CENTER);
		frame.add(btn,BorderLayout.NORTH);
		btn.addKeyListener(controller);
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		frame.addKeyListener(controller);
		frame.setVisible(true);
	}

}

package com.demo.snake;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.KeyAdapter;

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

	public static void init(Snake snake, GamePanel gamePanel,
			Controller controller) {
		JFrame frame = new JFrame();
		Panel panel = new Panel();
		frame.setTitle("Ã∞≥‘…ﬂ");
		frame.setSize(400,400);
		frame.setLocation(600, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.setSize(Golbal.WIDTH * Golbal.CELL_SIZE,Golbal.HEIGHT * Golbal.CELL_SIZE);
		frame.setSize(Golbal.WIDTH * Golbal.CELL_SIZE + 20,Golbal.HEIGHT * Golbal.CELL_SIZE + 55);
		frame.setLayout(new BorderLayout());
		frame.add(panel,BorderLayout.NORTH);
		frame.add(gamePanel,BorderLayout.CENTER);
		
		
		gamePanel.addKeyListener(controller);
		snake.addSnakeListener(controller);
		frame.addKeyListener(controller);
		frame.setVisible(true);
	}

}

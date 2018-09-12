package com.demo.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

public class GamePanel extends JPanel{
	
	private Snake snake;
	private Food food;
	private Ground ground;
	
	public void display(Snake snake,Food food,Ground ground){
		System.out.println("xianshi");
		this.snake = snake; 
		this.food = food;
		this.ground = ground;
		this.repaint();
	}
	
	protected void paintComponent(Graphics g){
		//÷ÿ–¬œ‘ æ
		g.setColor(new Color(0xcfcfcf));
		g.fill3DRect(0, 0, Golbal.WIDTH * Golbal.CELL_SIZE, Golbal.HEIGHT * Golbal.CELL_SIZE, true);
		
		if(ground!= null && ground != null && ground != null){
		
			this.ground.drawMe(g);
			this.snake.drawMe(g);
			this.food.drawMe(g);
		}
	}
}	

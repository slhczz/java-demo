package com.demo.snake;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

	//面板	

public class GamePanel extends JPanel{
//	初始化参数
	private Snake snake;
	private Food food;
	private Ground ground;
	//显示面板
	public void display(Snake snake,Food food,Ground ground){
//		System.out.println("显示");
		this.snake = snake; 
		this.food = food;
		this.ground = ground;
		this.repaint();
	}
	
	
//	显示格子
	protected void paintComponent(Graphics g){
		//重新显示
		g.setColor(new Color(0xcfcfcf));
		g.fill3DRect(0, 0, Golbal.WIDTH * Golbal.CELL_SIZE, Golbal.HEIGHT * Golbal.CELL_SIZE, true);
		
		if(ground!= null && ground != null && ground != null){
		
			this.ground.drawMe(g);
			this.snake.drawMe(g);
			this.food.drawMe(g);
		}
	}
}	

package com.demo.snake;

import java.awt.Graphics;
import java.awt.Point;

public class Food extends Point {
	//����ʳ��
	public void newFood(Point p) {
		this.setLocation(p);
	}
	
	//�߳Ե�ʳ��
	public boolean isSnakeEatFood(Snake snake){
		System.out.println("chidao shi wu");
	return 	this.equals(snake.getHead());
		
	}
	//��ʾʳ��	
	public void drawMe(Graphics g){
		System.out.println("xianshi ");
		
		g.fill3DRect(x*Golbal.CELL_SIZE, y*Golbal.CELL_SIZE, Golbal.CELL_SIZE, Golbal.CELL_SIZE, true);
		
	}
}

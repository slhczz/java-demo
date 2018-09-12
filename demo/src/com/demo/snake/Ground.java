package com.demo.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Ground {
	
	private int[][] rocks = new int[Golbal.WIDTH][Golbal.HEIGHT];
	
	public Ground() {
	
		for (int x = 0; x < Golbal.WIDTH; x++) {
			rocks[x][0] = 1;
			rocks[x][Golbal.HEIGHT-1] = 1;
		}
		for (int y = 0; y < Golbal.HEIGHT; y++) {
			rocks[0][y] = 1;
			rocks[Golbal.HEIGHT-1][y] = 1;
		}
		
	}
	public boolean isSnakeEatRock(Snake snake){
		System.out.println("");
		for (int x = 0; x < Golbal.WIDTH; x++) {
			for (int y = 0; y < Golbal.HEIGHT; y++) {
				if(rocks[x][y] == 1 && x == snake.getHead().x && y == snake.getHead().y){
					return true;
				}
			}
		}
		
		return false;
	}
	public void drawMe(Graphics g){
		System.out.println("xianshi");
		g.setColor(Color.gray);
		
		for (int x = 0; x < Golbal.WIDTH; x++) {
			for (int y = 0; y < Golbal.HEIGHT; y++) {
				if(rocks[x][y] == 1){
					g.fill3DRect(x * Golbal.CELL_SIZE, y * Golbal.CELL_SIZE, Golbal.CELL_SIZE, Golbal.CELL_SIZE, true);
				}
			}
		}
		
	}
	
	public Point getPoint() {
		Random random = new Random();
		int x = 0,y = 0;
		do{
			x = random.nextInt(Golbal.WIDTH);
			y = random.nextInt(Golbal.HEIGHT);
		}while(rocks[x][y] ==1);
		
		return new Point(x,y);
	}
	
}

package com.demo.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import javax.swing.JOptionPane;

public class Snake {
//	定义蛇的移动方向
	public static final int UP = -1;
	public static final int DOWN =1 ;
	public static final int LEFT = 2;
	public static final int RIGHT = -2;
	
	private boolean life;
	private boolean runLife = true;

	private int oldDirection,newDirection,acceleration = 800;
	private Point oldTail;
	
	private LinkedList<Point> body = new LinkedList<Point>();
	
	private Set<SnakeListener> listener = new HashSet<SnakeListener>();
	
	

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}
	
	public Snake() {
		init();
	}
//	初始化蛇的长度
	public void init(){
		int y = Golbal.HEIGHT / 2;
		int x = Golbal.WIDTH / 2;
		for(int i = 0;i<3;i++){
			body.addLast(new Point(x--,y));
		}
		oldDirection = newDirection = RIGHT;
	}
//蛇爬行
	public boolean move(){
		if(life == true){
			System.out.println("蛇爬");
			if(!(oldDirection + newDirection == 0)){
				oldDirection = newDirection;
			}
			//去尾加头
			
			oldTail = body.removeLast();
			
			int x = body.getFirst().x;
			int y = body.getFirst().y;
			switch(oldDirection) {
				case UP: 
					y--;
					if(y < 0){
						y = Golbal.HEIGHT-1;
					}
					break;
				case DOWN:
					y++;
					if(y >= Golbal.HEIGHT){
						y = 0;
					}
					break;
				case LEFT: 
					if(x < 0){
						x = Golbal.WIDTH-1;
					}
					x--;
					break;
				case RIGHT:
					x++;
					if(x >= Golbal.WIDTH){
						x = 0;
					}
					break;
			}
			
			Point newHead = new Point(x,y);
			body.addFirst(newHead);
			return isLife();
		}
		return isLife();
	}
//	改变蛇的方向
	public void changeDirection(int direction){
		System.out.println("改变方向");
		
			newDirection = direction;
	}
//	获取蛇的头部
	public Point getHead() {
		
		return body.getFirst();
	}
//	蛇吃到食物
	public void eatFood(){
		System.out.println("");
		body.addLast(oldTail);
		
		if(acceleration>200){
			acceleration -=50;
		}else{
			acceleration =200;	
		}
	}
//	蛇吃到食物后长度加一
	public boolean isEatBody(){
		System.out.println("");
		for (int i = 1; i < body.size(); i++) {
			if(body.get(i).equals(this.getHead())){
				return true;
			}
		}
		
		return false;
	}
//	显示初始化蛇
	public void drawMe(Graphics g){
		System.out.println("显示初始化蛇");
		g.setColor(Color.BLUE);
		for(Point p : body){
			g.fill3DRect(p.x * Golbal.CELL_SIZE, p.y * Golbal.CELL_SIZE, Golbal.CELL_SIZE, Golbal.CELL_SIZE, true);
		}
		
	}
	
	private class SnakeDriver implements Runnable{
		public void run(){
			while(isRunLife()){
				move();
				for(SnakeListener i : listener){
					i.snakeMoved(Snake.this);
				}
				try {
					Thread.sleep(acceleration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		}
	}
	
	public void start(){
		new Thread(new SnakeDriver()).start();
	}
	
	public  void addSnakeListener(SnakeListener s) {
		if(s != null){
			this.listener.add(s);
		}
	}

	public void dir(String msg) {
		setRunLife(false);
		setLife(false);
		JOptionPane jp = new JOptionPane();
		jp.showMessageDialog(jp, msg);
	}

	public boolean isRunLife() {
		return runLife;
	}

	public void setRunLife(boolean runLife) {
		this.runLife = runLife;
	}
}

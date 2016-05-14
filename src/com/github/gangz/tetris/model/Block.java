package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;

public class Block {
	private int x;
	private int y;
	private List<Cell> cells;
	public Block(){
		setCells(new ArrayList<Cell>());
		x = 0;
		y = 0;
	}
	public List<Cell> getCells() {
		return cells;
	}
	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}
	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	public void moveDown() {
		this.y++;
	}
	public void moveRight() {
		this.x++;
	}
	public void moveLeft() {
		this.x--;
	}
	public void moveTo(int x, int y) {
		this.x =x;
		this.y = y;
	}
	public int getWidth() {
		int mostLeft = Integer.MAX_VALUE;
		int mostRight = -1;
		for (Cell cell:getCells()){
			int x = cell.getX();
			if (x>mostRight)
				mostRight=x;
			if (x<mostLeft)
				mostLeft = x;
		}
		return mostRight-mostLeft+1;
	}
	public int getHeight() {
		int mostTop = Integer.MAX_VALUE;
		int mostBottom = -1;
		for (Cell cell:getCells()){
			int x = cell.getY();
			if (x>mostBottom)
				mostBottom=x;
			if (x<mostTop)
				mostTop = x;
		}
		return mostBottom-mostTop+1;
	}
}

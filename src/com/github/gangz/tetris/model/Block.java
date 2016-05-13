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
}

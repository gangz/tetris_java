package com.github.gangz.tetris.model;

public class BlockFactory {
	public static Block makeSingleCellBlock(){
		Block block = new Block();
		block.addCell(new Cell(0,0));
		return block;
	}
}

package com.github.gangz.tetris.model;

public class BlockFactory {
	int[][][] shape_data=new int[][][]{
            {{0,0},{0,1},{0,2},{0,3}}, //BAR
            {{0,2},{1,2},{2,2},{3,2}}, //BAR
            {{0,0},{0,1},{0,2},{0,3}}, //BAR
            {{0,2},{1,2},{2,2},{3,2}}, //BAR
            {{0,0},{0,1},{1,0},{1,1}}, //SQUARE
            {{0,0},{0,1},{1,0},{1,1}}, //SQUARE
            {{0,0},{0,1},{1,0},{1,1}}, //SQUARE
            {{0,0},{0,1},{1,0},{1,1}}, //SQUARE
            {{0,0},{0,1},{1,1},{1,2}}, //Z
            {{0,1},{1,0},{1,1},{2,0}}, //Z
            {{0,0},{0,1},{1,1},{1,2}}, //Z
            {{0,1},{1,0},{1,1},{2,0}}, //Z
            {{0,0},{0,1},{0,2},{1,2}}, //L
            {{0,1},{1,1},{2,1},{2,0}}, //L
            {{0,0},{1,0},{1,1},{1,2}}, //L
            {{0,0},{0,1},{1,0},{2,0}}, //L
            {{0,1},{0,2},{1,0},{1,1}}, //INV_Z
            {{0,0},{1,0},{1,1},{2,1}}, //INV_Z
            {{0,1},{0,2},{1,0},{1,1}}, //INV_Z
            {{0,0},{1,0},{1,1},{2,1}}, //INV_Z
            {{0,0},{0,1},{0,2},{1,0}}, //INV_L
            {{0,0},{1,0},{2,0},{2,1}}, //INV_L
            {{1,0},{1,1},{1,2},{0,2}}, //INV_L
            {{0,0},{0,1},{1,1},{2,1}}, //INV_L
            {{0,0},{0,1},{0,2},{1,1}}, //T
            {{0,0},{1,0},{2,0},{1,1}}, //T
            {{1,0},{1,1},{1,2},{0,1}}, //T
            {{0,1},{1,1},{2,1},{1,0}}, //T
			};
            
	public Block makeSingleCellBlock(){
		Block block = new Block();
		block.addCell(new Cell(0,0));
		return block;
	}

	public Block makeEmptyBlock(){
		return new Block();
	}
	public Block makeVerticalBar() {
		return getBlock(0);
	}

	public Block makeRandomBlock(){
		int index = (int) (Math.random()*28);
		return getBlock(index);
	}
	public Block getBlock(int index) {
		Block block = new PredefinedBlock(index, this);
		int[][] data = shape_data[index];
		block.addCell(new Cell(data[0][0],data[0][1]));
		block.addCell(new Cell(data[1][0],data[1][1]));
		block.addCell(new Cell(data[2][0],data[2][1]));
		block.addCell(new Cell(data[3][0],data[3][1]));
		return block;
	}

	public Block makeHorzionalBar(int size) {
		Block block = new Block();
		for (int x=0;x<size;x++)
			block.addCell(new Cell(x,0));
		return block;
	}
	
	public Block makeVerticalBar(int size) {
		Block block = new Block();
		for (int y=0;y<size;y++)
			block.addCell(new Cell(0,y));
		return block;
	}
}

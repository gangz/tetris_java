package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
public class BlockCollsionDetector {
	public enum Direction{
		RIGHT,
		DOWN,
		LEFT
	}

	
	public boolean detect(Block block_1, Direction direction, Block block_2) {
		ArrayList<Cell> block_2_actual_cell = new ArrayList<Cell>();
		for (Cell cell:block_2.getCells()){
			Cell actualCell = new Cell(cell.getX()+block_2.getX(),cell.getY()+block_2.getY());
			block_2_actual_cell.add(actualCell);
		}
		
		ArrayList<Cell> block_1_actual_cell_after_move = new ArrayList<Cell>();
		int[][] offset = new int[][]{
			{1,0},
			{0,1},
			{-1,0}
		};
		for (Cell cell:block_1.getCells()){
			Cell actualCell = new Cell(cell.getX()+block_1.getX()+offset[direction.ordinal()][0],
					                                      cell.getY()+block_1.getY()+offset[direction.ordinal()][1]);
			block_1_actual_cell_after_move.add(actualCell);
		}
		Collection<Cell> commonCell = CollectionUtils.intersection(block_2_actual_cell,block_1_actual_cell_after_move);
		return commonCell.size()>0;
	}
}

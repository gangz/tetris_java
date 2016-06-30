package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlockSize {
	@Test
	public void get_block_size_should_ok(){
		Block block = new Block();
		block.addCell(new Cell(5,0));
		for (int x=0;x<4;x++)
			block.addCell(new Cell(x,1));
		block.addCell(new Cell(2,2));
		assertEquals(3,block.getHeight());
		assertEquals(6,block.getWidth());
	}
	
	@Test
	public void eliminate_shape_should_compress_low_y_value_rows(){
		Block block = new Block();
		block.addCell(new Cell(-5,0));
		for (int x=0;x<4;x++)
			block.addCell(new Cell(x,1));
		block.addCell(new Cell(2,2));
		assertEquals(3,block.getHeight());
		assertEquals(9,block.getWidth());
	}
}

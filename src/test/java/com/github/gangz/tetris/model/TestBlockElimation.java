package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlockElimation {
	@Test
	public void eliminate_shape_should_success(){
		BlockFactory factory = new BlockFactory();
        Block block = factory.makeHorzionalBar(8);
        int eliminatedRows = block.eliminate(8);
        assertEquals(1,eliminatedRows);
        assertEquals(0,block.getCells().size());
	}
	
	@Test
	public void eliminate_shape_should_compress_low_y_value_rows(){
		Block block = new Block();
		block.addCell(new Cell(5,0));
		for (int x=0;x<4;x++)
			block.addCell(new Cell(x,1));
		block.addCell(new Cell(2,2));
		block.eliminate(4);
		assertEquals(2,block.getHeight());
	}
}

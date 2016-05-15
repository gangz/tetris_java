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
}

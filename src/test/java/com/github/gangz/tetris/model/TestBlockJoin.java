package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlockJoin {
	@Test
	public void test_join_block_should_success(){
		Block b_1 = new Block();
		b_1.addCell(new Cell(1,1));
		b_1.moveTo(1, 1); //then it's actual location is in 2, 2
		
		Block b_2 = new Block();
		b_2.addCell(new Cell(10,11));
		b_2.moveTo(-5, -4); //then it's actual location is in 5, 7
		
		b_1.join(b_2);
		assertEquals(1,b_1.getX());
		assertEquals(1,b_1.getY());
		assertEquals(2,b_1.getCells().size());
		assertEquals(4,b_1.getCells().get(1).getX());
		assertEquals(6,b_1.getCells().get(1).getY());
	}
}

package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlockFactory {
	BlockFactory blockFactory = new BlockFactory();
	@Test
	public void produce_a_bar(){
		Block bar = blockFactory.makeVerticalBar();
		assertEquals(4,bar.getCells().size());
		assertEquals(1,bar.getWidth());
		assertEquals(4,bar.getHeight());
	}
}

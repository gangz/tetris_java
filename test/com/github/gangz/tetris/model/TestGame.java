package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGame {

	@Test
	public void an_active_block_should_be_created_when_init() {
		Game game = new Game();
		game.start();
		assertNotNull(game.getActiveBlock());
	}

}

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

	@Test
	public void active_block_should_move_when_receive_left_command(){
		Game game = createGame();
		int oldX = game.getActiveBlock().getX();
		
		game.moveRight();
		
		int newX = game.getActiveBlock().getX();
		assertEquals(-1, oldX-newX);
	}

	private Game createGame() {
		Game game = new Game();
		game.start();
		game.disableTimer();
		return game;
	}
}

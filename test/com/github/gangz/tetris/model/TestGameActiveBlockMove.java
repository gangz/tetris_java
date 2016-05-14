package com.github.gangz.tetris.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGameActiveBlockMove {
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
		return game;
	}
}

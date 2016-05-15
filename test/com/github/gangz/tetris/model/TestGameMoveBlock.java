package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameMoveBlock {

	@Test
	public void left_move_cannot_less_than_zero() {
		Game game = new Game();
		game.start();
		for (int i=0;i<2*game.getHorizonalSize();i++)
			game.moveLeft();
		assertEquals(0,game.getActiveBlock().getX());
	}
	
	@Test
	public void right_move_cannot_bigger_than_horizonal_size() {
		Game game = new Game();
		game.start();
		for (int i=0;i<2*game.getHorizonalSize();i++)
			game.moveRight();
		assertEquals(game.getHorizonalSize()-1,game.getActiveBlock().getX());
	}
	
	@Test
	public void move_down_should_produce_new_activeBlock(){
		
	}

}

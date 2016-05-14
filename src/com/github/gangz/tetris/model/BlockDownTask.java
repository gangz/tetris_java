package com.github.gangz.tetris.model;

import java.util.TimerTask;

public class BlockDownTask extends TimerTask{

	private Game game;

	public BlockDownTask(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		game.moveActiveBlockDown();
	}

}

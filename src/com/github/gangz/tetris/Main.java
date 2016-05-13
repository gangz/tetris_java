package com.github.gangz.tetris;

import com.github.gangz.tetris.model.Game;
import com.github.gangz.tetris.ui.GameBoard;

public class Main {
	public static void main(String[] args) {
		Game game = new Game();
		GameBoard gameBoard = new GameBoard(game);
	}

}

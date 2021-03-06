package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.gangz.tetris.model.Block;
import com.github.gangz.tetris.model.Game;
import com.github.gangz.tetris.model.IGameDataChangedListener;

public class GameBoard extends JFrame implements IGameDataChangedListener, KeyListener{
	private static final long serialVersionUID = 2849676876521085018L;
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 640;

	CellPanel nextShapePanel;
	JPanel controlPanel;
	CellPanel mainPanel ;
	private DigitPanel scorePanel;
	private Game game;
	public GameBoard(Game game){
		this.game = game;
		initGameBoard();
		createMainPanel();
		createControlPanel();
		createNextShapePanel();
		createScoreCardPanel();
		game.registerDataChangedListener(this);
		this.addKeyListener(this);
	}
	
	private void createControlPanel() {
		controlPanel = new JPanel();
		controlPanel.setLayout(null);
		controlPanel.setBounds(mainPanel.getX()+mainPanel.getWidth()+40, 
				mainPanel.getY(), mainPanel.getWidth(),mainPanel.getHeight());
		this.add(controlPanel);
	}

	/**
	 * Init the game main board
	 */
	private void initGameBoard() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setTitle("Tetris");
		this.setBackground(Color.GREEN);
		this.setLayout(null);
		this.setVisible(true);
		
	}

	private void createMainPanel() {
		mainPanel = new CellPanel(game.getHorizonalSize(),game.getVerticalSize());
		this.add(mainPanel);
		mainPanel.setBounds(20, 20, mainPanel.getWidth(), mainPanel.getHeight());
	}
	
	private void createNextShapePanel() {
		nextShapePanel = new CellPanel(5,5);
		controlPanel.add(nextShapePanel);
		nextShapePanel.setLocation(0,0);
	}
	

	private void createScoreCardPanel() {
		scorePanel = new DigitPanel(nextShapePanel.getWidth(),60);
		controlPanel.add(scorePanel);
		scorePanel.setLocation(0 ,nextShapePanel.getY()+nextShapePanel.getHeight()+30);
	}

	public void dataChanged(Game game) {
		ArrayList<Block> blocks =  new ArrayList<Block>();
		blocks.add(game.getActiveBlock());
		blocks.add(game.getPiledBlock());
		mainPanel.drawBlock(blocks);
		ArrayList<Block> nextBlocks =  new ArrayList<Block>();
		nextBlocks.add(game.getNextBlock());
		nextShapePanel.drawBlock(nextBlocks);
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode())
		{
		case KeyEvent.VK_LEFT:
			game.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			game.moveRight();
			break;
		case KeyEvent.VK_UP:
			game.rotateActiveBlock();
			break;
		case KeyEvent.VK_DOWN:
			game.moveActiveBlockDown();
			break;
		case KeyEvent.VK_ENTER:
			game.pauseToogle();
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

}

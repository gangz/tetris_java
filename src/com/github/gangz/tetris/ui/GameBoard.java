package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import com.github.gangz.tetris.model.Block;
import com.github.gangz.tetris.model.Game;
import com.github.gangz.tetris.model.IGameDataChangedListener;

public class GameBoard extends JFrame implements IGameDataChangedListener{
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 640;

	CellPanel nextShapePanel;
	JPanel controlPanel;
	CellPanel mainPanel ;
	private DigitPanel scorePanel;
	private Game game;
	public GameBoard(Game game){
		initGameBoard();
		createMainPanel();
		createControlPanel();
		createNextShapePanel();
		createScoreCardPanel();
		this.game = game;
		game.registerDataChangedListener(this);
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
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		this.setTitle("Tetris");
		this.setBackground(Color.GREEN);
		this.setLayout(null);
		this.setVisible(true);
		
	}

	private void createMainPanel() {
		mainPanel = new CellPanel(8,16);
		this.add(mainPanel);
		mainPanel.setBounds(20, 20, mainPanel.getWidth(), mainPanel.getHeight());
	}
	
	private void createNextShapePanel() {
		nextShapePanel = new CellPanel(4,4);
		controlPanel.add(nextShapePanel);
		nextShapePanel.setLocation(0,0);
	}
	

	private void createScoreCardPanel() {
		scorePanel = new DigitPanel(nextShapePanel.getWidth(),60);
		controlPanel.add(scorePanel);
		scorePanel.setLocation(0 ,nextShapePanel.getY()+nextShapePanel.getHeight()+30);
	}
	public void start(){
	}

	@Override
	public void dataChanged(Game game) {
		mainPanel.drawBlock(game.getActiveBlock());
	}

}

package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.github.gangz.tetris.model.BlockCollsionDetector.Direction;

public class Game {
	private Block activeBlock;
	private Timer timer;
	private List<IGameDataChangedListener> listeners;
	private BlockFactory blockFactory;
	private BlockCollsionDetector collsionDetector;
	private Block bottomVirtualWall;
	private Block leftVirtualWall;
	private Block rightVirtualWall;
	
	public Game(){
		blockFactory = new BlockFactory();
		collsionDetector = new BlockCollsionDetector();
		listeners = new ArrayList<IGameDataChangedListener>();
		bottomVirtualWall = blockFactory.makeHorzionalBar(getHorizonalSize());
		bottomVirtualWall.moveTo(0, getVerticalSize());
		leftVirtualWall = blockFactory.makeVerticalBar(getVerticalSize());
		leftVirtualWall.moveTo(-1, 0);
		rightVirtualWall = blockFactory.makeVerticalBar(getVerticalSize());
		rightVirtualWall.moveTo(getHorizonalSize(),0);
	}
	public Block getActiveBlock() {
		return activeBlock;
	}
	public void registerDataChangedListener(IGameDataChangedListener listener) {
		listeners.add(listener);
	}
	
	public void moveActiveBlockDown() {
		
		if (!collsionDetector.detect(activeBlock, Direction.DOWN, bottomVirtualWall))
			activeBlock.moveDown();
		notifyObservers();
	}
	private void notifyObservers() {
		for (IGameDataChangedListener listener:listeners){
			listener.dataChanged(this);
		}
	}
	public void start() {
		activeBlock = blockFactory.makeVerticalBar();
		activeBlock.moveTo((getHorizonalSize()-activeBlock.getWidth())/2,0);
	}

	public void moveRight() {
		if (!collsionDetector.detect(activeBlock, Direction.RIGHT, rightVirtualWall))
			activeBlock.moveRight();
		notifyObservers();
	}
	public void rotateActiveBlock() {
		activeBlock.rotate();
		notifyObservers();
	}
	public void moveLeft() {
		if (!collsionDetector.detect(activeBlock, Direction.LEFT, leftVirtualWall))
			activeBlock.moveLeft();
		notifyObservers();
	}
	public int getHorizonalSize() {
		return 8;
	}
	public int getVerticalSize() {
		return 16;
	}
	public void pauseToogle() {
		if (this.isPaused())
			this.resume();
		else
			this.pause();
	}
	boolean paused = true;
	private void pause() {
		paused = true;
		timer.cancel();
	}
	private void resume() {
		paused=false;
		timer = new Timer();
		timer.schedule(new BlockDownTask(this), 0,1000);
	}
	private boolean isPaused() {
		return paused;
	}
}

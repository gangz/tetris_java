package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Game {
	private Block activeBlock;
	private Timer timer;
	private List<IGameDataChangedListener> listeners;
	private BlockFactory blockFactory;
	public Game(){
		blockFactory = new BlockFactory();
		listeners = new ArrayList<IGameDataChangedListener>();
	}
	public Block getActiveBlock() {
		return activeBlock;
	}
	public void registerDataChangedListener(IGameDataChangedListener listener) {
		listeners.add(listener);
	}
	
	public void moveActiveBlockDown() {
		activeBlock.moveDown();
		notifyObservers();
	}
	private void notifyObservers() {
		for (IGameDataChangedListener listener:listeners){
			listener.dataChanged(this);
		}
	}
	public void start() {
		activeBlock = blockFactory.makeBar();
		activeBlock.moveTo((getHorizonalSize()-activeBlock.getWidth())/2,0);
	}

	public void moveRight() {
		activeBlock.moveRight();
		notifyObservers();
	}
	public void rotateActiveBlock() {
		activeBlock.rotate();
		notifyObservers();
	}
	public void moveLeft() {
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

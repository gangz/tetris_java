package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends TimerTask{
	private Block activeBlock;
	private Timer timer;
	private List<IGameDataChangedListener> listeners;
	public Game(){
		listeners = new ArrayList<IGameDataChangedListener>();
		timer = new Timer();
	}
	public Block getActiveBlock() {
		return activeBlock;
	}
	public void registerDataChangedListener(IGameDataChangedListener listener) {
		listeners.add(listener);
	}
	@Override
	public void run() {
		moveActiveBlockDown();
	}
	private void moveActiveBlockDown() {
		activeBlock.moveDown();
		notiveObservers();
	}
	private void notiveObservers() {
		for (IGameDataChangedListener listener:listeners){
			listener.dataChanged(this);
		}
	}
	public void start() {
		activeBlock = BlockFactory.makeSingleCellBlock();
		timer.schedule(this, 0,1000);
	}

	public void disableTimer() {
		timer.cancel();
	}
	public void moveRight() {
		activeBlock.moveRight();
	}
	public void rotateActiveBlock() {
		
	}
	public void moveLeft() {
		activeBlock.moveLeft();
	}
}
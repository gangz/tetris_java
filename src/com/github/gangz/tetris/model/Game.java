package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends TimerTask{
	private Block activeBlock;
	private Timer timer;
	private List<IGameDataChangedListener> listeners;
	private BlockFactory blockFactory;
	public Game(){
		blockFactory = new BlockFactory();
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
		activeBlock = blockFactory.makeBar();
		activeBlock.moveTo((getHorizonalSize()-activeBlock.getWidth())/2,0);
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
	public int getHorizonalSize() {
		return 8;
	}
	public int getVerticalSize() {
		return 16;
	}
}

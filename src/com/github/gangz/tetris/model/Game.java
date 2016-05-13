package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Game extends TimerTask{
	private Block activeBlock;
	private List<IGameDataChangedListener> listeners;
	public Game(){
		activeBlock = BlockFactory.makeSingleCellBlock();
		listeners = new ArrayList<IGameDataChangedListener>();
		Timer timer = new Timer();
		timer.schedule(this, 0,1000);
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
}

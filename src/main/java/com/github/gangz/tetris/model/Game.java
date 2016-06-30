package com.github.gangz.tetris.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import com.github.gangz.tetris.model.BlockCollsionDetector.Direction;

public class Game {
	private Block activeBlock;
	private Block nextBlock;
	private Timer timer;
	private List<IGameDataChangedListener> listeners;
	private BlockFactory blockFactory;
	private BlockCollsionDetector collsionDetector;
	private Block bottomVirtualWall;
	private Block leftVirtualWall;
	private Block rightVirtualWall;
	private Block piledBlock;
	
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
		synchronized(this){
			if (isPaused()) resume();
			if (!collsionDetector.detect(activeBlock, Direction.DOWN, bottomVirtualWall) &&
				!collsionDetector.detect(activeBlock, Direction.DOWN, piledBlock)){
				activeBlock.moveDown();
				piledBlock.eliminate(getHorizonalSize());
			}
			else{
				piledBlock.join(activeBlock);
				System.out.println("H:" + piledBlock.getHeight());
				if (piledBlock.getHeight()>=getVerticalSize()) //restart game
					start();
				produceNewActiveBlock();
			}
			notifyObservers();
		}
	}
	private void produceNewActiveBlock() {
		activeBlock = nextBlock;
		activeBlock.moveTo((getHorizonalSize()-activeBlock.getWidth())/2,0);
		nextBlock = blockFactory.makeRandomBlock();
		nextBlock.moveTo((5-nextBlock.getWidth())/2, (5-nextBlock.getHeight())/2);
	}
	private void notifyObservers() {
		for (IGameDataChangedListener listener:listeners){
			listener.dataChanged(this);
		}
	}
	public void start() {
		nextBlock = blockFactory.makeRandomBlock();
		produceNewActiveBlock();
		piledBlock = blockFactory.makeEmptyBlock();
		piledBlock.moveTo(0, 0);
	}

	public void moveRight() {
		if (isPaused()) resume();
		if (!collsionDetector.detect(activeBlock, Direction.RIGHT, rightVirtualWall) &&
				!collsionDetector.detect(activeBlock, Direction.RIGHT, piledBlock)){
			activeBlock.moveRight();
			notifyObservers();
		}
	}
	public void rotateActiveBlock() {
		activeBlock.rotate();
		notifyObservers();
	}
	public void moveLeft() {
		if (isPaused()) resume();
		if (!collsionDetector.detect(activeBlock, Direction.LEFT, leftVirtualWall) &&
				!collsionDetector.detect(activeBlock, Direction.LEFT, piledBlock)){
			activeBlock.moveLeft();
			notifyObservers();
		}
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
		timer.schedule(new BlockDownTask(this), 0,300);
	}
	private boolean isPaused() {
		return paused;
	}
	public Block getNextBlock() {
		return nextBlock;
	}
	public Block getPiledBlock() {
		return piledBlock;
	}
}

package com.github.gangz.tetris.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBlockCollision {
	BlockFactory factory = new BlockFactory();
	@Test
	public void test_two_block_should_collision_when_move_right() {
		// bar 1 - |  bar 2 - |  
		
		Block block_1 = factory.makeVerticalBar();
		block_1.moveTo(0, 0);
		Block block_2 = factory.makeVerticalBar();
		block_2.moveTo(1,0);
		BlockCollsionDetector detector = new BlockCollsionDetector();
		boolean willCollision = detector.detect(block_1, BlockCollsionDetector.Direction.RIGHT,block_2);
		assertTrue(willCollision);
	}
	
	@Test
	public void test_two_block_should_not_collision_when_move_right() {
		// bar 1 - |  bar 2 - |  
		Block block_1 = factory.makeVerticalBar();
		block_1.moveTo(0, 0);
		Block block_2 = factory.makeVerticalBar();
		block_2.moveTo(2,0);
		BlockCollsionDetector detector = new BlockCollsionDetector();
		boolean willCollision = detector.detect(block_1, BlockCollsionDetector.Direction.RIGHT,block_2);
		assertFalse(willCollision);
	}
	
	@Test
	public void test_two_block_should_not_collision_in_y_direction() {
		// bar 1 - |  bar 2 - |  
		Block block_1 = factory.makeVerticalBar();
		block_1.moveTo(0, 0);
		Block block_2 = factory.makeVerticalBar();
		block_2.moveTo(1,4);
		BlockCollsionDetector detector = new BlockCollsionDetector();
		boolean willCollision = detector.detect(block_1, BlockCollsionDetector.Direction.RIGHT,block_2);
		assertFalse(willCollision);
	}
	
	
	@Test
	public void test_two_block_should_collision_when_move_down() {
		// bar 1 - |  bar 2 - |  
		Block block_1 = factory.makeVerticalBar();
		block_1.moveTo(0, 0);
		Block block_2 = factory.makeVerticalBar();
		block_2.moveTo(0,4);
		BlockCollsionDetector detector = new BlockCollsionDetector();
		boolean willCollision = detector.detect(block_1, BlockCollsionDetector.Direction.DOWN,block_2);
		assertTrue(willCollision);
	}
	

}

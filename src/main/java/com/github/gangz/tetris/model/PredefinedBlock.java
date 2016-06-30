package com.github.gangz.tetris.model;

public class PredefinedBlock extends Block {
	private int index;
	private BlockFactory factory;

	public PredefinedBlock(int index, BlockFactory factory){
		this.index = index;
		this.factory = factory;
	}

	@Override
	public void rotate() {
		int shapeIndex = index/4;
		int indexInShape = index%4;
		indexInShape++;
		if (indexInShape==4) indexInShape=0;
		index = 4* shapeIndex + indexInShape;
		Block shape = factory.getBlock(index);
		this.setCells(shape.getCells());
	}
	
}

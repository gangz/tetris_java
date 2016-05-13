package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import com.github.gangz.tetris.model.Block;
import com.github.gangz.tetris.model.Cell;

public class CellPanel extends JComponent {
	private static final int CELL_PIXEL_SIZE = 35;
	private int horizonalCellCount = 8;
	private int verticalCellCount = 16;
	private Block block;

	
	public CellPanel(int horizonalCellCount, int verticalCellCount ){
		this.setBackground(Color.BLACK);
		this.setSize(new Dimension(horizonalCellCount*CELL_PIXEL_SIZE,
				verticalCellCount*CELL_PIXEL_SIZE));
		this.horizonalCellCount = horizonalCellCount;
		this.verticalCellCount = verticalCellCount;
		setBorder(new EtchedBorder());
	}

	public void drawBlock(Block block) {
		this.block = block;
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		if (block==null) return;
		List<Cell> cells = block.getCells();
		for (Cell cell:cells){
			g.fillRect((block.getX()+cell.getX())*CELL_PIXEL_SIZE,
					(block.getY()+cell.getY())*CELL_PIXEL_SIZE,
					CELL_PIXEL_SIZE, CELL_PIXEL_SIZE);
		}
	}
	
}

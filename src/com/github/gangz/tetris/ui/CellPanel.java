package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.border.EtchedBorder;

import com.github.gangz.tetris.model.Block;
import com.github.gangz.tetris.model.Cell;

public class CellPanel extends JComponent {
	private static final long serialVersionUID = -1380132269794418871L;
	private static final int CELL_PIXEL_SIZE = 35;
	private List<Block> blocks;

	public CellPanel(int horizonalCellCount, int verticalCellCount) {
		this.setBackground(Color.BLACK);
		this.setSize(new Dimension(horizonalCellCount * CELL_PIXEL_SIZE, verticalCellCount * CELL_PIXEL_SIZE));
		setBorder(new EtchedBorder());
	}

	public void drawBlock(List<Block> blocks) {
		this.blocks = blocks;
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		if (blocks == null)
			return;
		for (Block block : blocks) {
			List<Cell> cells = block.getCells();
			//clone the cell list to avoid concurrency problem
			cells = (List<Cell>) ((ArrayList<Cell>)cells).clone();
			for (Cell cell : cells) {
				g.fill3DRect((block.getX() + cell.getX()) * CELL_PIXEL_SIZE,
						(block.getY() + cell.getY()) * CELL_PIXEL_SIZE, CELL_PIXEL_SIZE, CELL_PIXEL_SIZE, true);
			}
		}
	}

}

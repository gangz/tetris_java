package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class CellPanel extends JPanel {
	private static final int CELL_PIXEL_SIZE = 35;
	private int horizonalCellCount = 8;
	private int verticalCellCount = 16;

	public CellPanel(int horizonalCellCount, int verticalCellCount ){
		this.setBackground(Color.BLACK);
		this.setSize(new Dimension(horizonalCellCount*CELL_PIXEL_SIZE,
				verticalCellCount*CELL_PIXEL_SIZE));
		this.horizonalCellCount = horizonalCellCount;
		this.verticalCellCount = verticalCellCount;
		setBorder(new EtchedBorder());
	}
}

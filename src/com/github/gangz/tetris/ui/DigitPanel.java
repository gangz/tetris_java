package com.github.gangz.tetris.ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextPane;

public class DigitPanel extends JPanel {
	private static final long serialVersionUID = 2051376513052622569L;
	JTextPane digitText;
	public DigitPanel(int width, int height){
		this.setBackground(Color.BLUE);
		this.setLayout(new FlowLayout());
		this.setSize(width, height);
		digitText = new JTextPane();
		this.add(digitText);
		digitText.setBackground(null);
		digitText.setForeground(Color.WHITE);
		digitText.setText("0");
		digitText.setSize(this.getSize());
		digitText.setFont(new Font("Arial",Font.PLAIN,40));
	}
}

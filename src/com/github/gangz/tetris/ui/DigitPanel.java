package com.github.gangz.tetris.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class DigitPanel extends JPanel {
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

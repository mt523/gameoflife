package com.michaelt.gol;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import com.michaelt.gol.Cell.CELL_STATE;

@SuppressWarnings("serial")
public class Window extends JFrame implements MouseListener{	
	public static Grid grid;	
	public Window(int x, int y, String title) {
		super();		
		setBackground(Color.yellow);
		setResizable(false);
		setTitle(title);
		setSize(x, y);		
		grid = new Grid();
		grid.setBackground(Color.yellow);
		add(grid);		
		grid.addMouseListener(this);
	}	
	public static void main(String args[]) {		
		Window window = new Window(500, 500, "GameOfLife");		
		window.setVisible(true);		
		while(true) {
			try {
	         Thread.sleep(50);
	         grid.iterate();
         } catch (InterruptedException pException) {
	         pException.printStackTrace();
         }
		}		
	}
	@Override
   public void mouseClicked(MouseEvent pE) {
		System.out.println("click at " + pE.getX() + ", " + pE.getY());
		grid.cells[(pE.getX()/10)][(pE.getY()/10)].state = CELL_STATE.ON;
		grid.paintComponent(grid.getGraphics());			
   }
	@Override
   public void mousePressed(MouseEvent pE) {}
	@Override
   public void mouseReleased(MouseEvent pE) {}
	@Override
   public void mouseEntered(MouseEvent pE) {}
	@Override
   public void mouseExited(MouseEvent pE) {}
}

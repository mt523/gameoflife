package com.michaelt.gol;

public class Cell {

	public enum CELL_STATE { OFF, ON, FLAG_OFF, FLAG_ON };	
	
	public CELL_STATE state;
	
	public Cell() {
		state = CELL_STATE.OFF;
	}
	
}

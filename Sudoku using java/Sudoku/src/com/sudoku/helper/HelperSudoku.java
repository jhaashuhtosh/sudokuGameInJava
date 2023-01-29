package com.sudoku.helper;

import java.awt.Color;

import javax.swing.JTextField;

public class HelperSudoku {

	/**
	 * @author jhaashutosh061@gmail.com
	 * @param arrTextFields
	 * 
	 * This method is used for fill all the column with correct value.
	 */
	public void helpForAllGameGame(JTextField[][] arrTextFields) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JTextField jText = arrTextFields[i][j];
				String tempName = jText.getName();
				if (tempName.contains("-"))
					jText.setText(String.valueOf(Integer.valueOf(tempName) * -1));
				jText.setBackground(Color.cyan);
			}
		}
	}

	/**
	 * @author jhaashutosh061@gmail.com
	 * @param gameType
	 * @return
	 * 
	 * This method is used for fill dashboard with value at as logic
	 */
	public int[][] getValueWithnIndex(String gameType) {
		if (gameType.equals("easy")) {
			int[][] gridData = { { 5, 3, -4, -6, 7, -8, -9, -1, -2 }, { 6, -7, -2, 1, 9, 5, -3, -4, -8 },
					{ -1, 9, 8, -3, -4, -2, -5, 6, -7 }, { 8, -5, -9, -7, 6, -1, -4, -2, 3 },
					{ 4, -2, -6, 8, -5, 3, -7, -9, 1 }, { 7, -1, -3, -9, 2, -4, -8, -5, 6 },
					{ -9, 6, -1, -5, -3, -7, 2, 8, -4 }, { -2, -8, -7, 4, 1, 9, -6, -3, 5 },
					{ -3, -4, -5, -2, 8, -6, -1, 7, 9 } };
			return gridData;
		} else if (gameType.equals("hard")) {
			int[][] gridData = { { 4, 5, -3, -8, -2, -6, -1, -9, -7 }, { -8, -9, 2, -5, 7, -1, 6, 3, -4 },
					{ -1, -6, -7, -4, -9, -3, 5, -2, -8 }, { -7, -1, -4, 9, 5, -2, -8, -6, -3 },
					{ 5, -8, -6, -1, -3, -7, 2, -4, -9 }, { -3, 2, -9, 6, -8, -4, 7, 5, -1 },
					{ -9, -3, -5, -2, -1, -8, 4, 7, 6 }, { -6, 7, -1, -3, 4, 5, -9, -8, -2 },
					{ -2, -4, 8, -7, -6, 9, -3, -1, 5 } };
			return gridData;
		} else if (gameType.equals("expert")) {
			int[][] gridData = { { -1, -6, -5, 8, -4, -7, -9, -2, -3 }, { 7, 8, 9, -3, 1, -2, -5, -4, 6 },
					{ -4, -3, -2, -5, -9, 6, 1, -7, -8 }, { -2, -9, 7, -4, -6, -3, -8, 5, -1 },
					{ 5, -1, 8, 7, -2, 9, 3, -6, 4 }, { -3, 4, -6, -1, -5, -8, 2, -9, -7 },
					{ -9, -7, 3, 2, -8, -4, -6, -1, -5 }, { 8, -2, -1, -6, 7, -5, 4, 3, 9 },
					{ -6, -5, -4, -9, -3, 1, -7, -8, -2 } };
			return gridData;
		} else if (gameType.equals("begineer")) {
			int[][] gridData = { { 9, 4, 2, -1, 6, 3, 8, 5, 7 }, { 5, 3, 6, 2, 8, 7, 9, 4, -1 },
					{ 8, 7, -1, -9, 5, -4, 2, 3, 6 }, { 3, 2, 7, 8, 1, 9, -4, -6, 5 }, { 1, -5, -4, 3, 2, 6, 7, 9, 8 },
					{ 6, 9, 8, 7, 4, 5, -1, 2, 3 }, { 2, 6, -5, -4, 7, -1, 3, 8, 9 }, { 7, 8, 9, 6, 3, 2, -5, 1, 4 },
					{ 4, 1, 3, 5, 9, 8, -6, -7, 2 } };
			return gridData;
		}
		return null;
	}
}

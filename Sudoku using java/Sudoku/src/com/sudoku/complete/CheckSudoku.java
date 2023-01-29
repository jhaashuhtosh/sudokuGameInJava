package com.sudoku.complete;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CheckSudoku {
	
	/**
	 * @author jhaashutosh061@gmail.com
	 * @param arrTextFields
	 * @param container
	 * 
	 * This method is used for check the column value with correct value 
	 */
	public void completeGame(JTextField[][] arrTextFields, Container container) {
		boolean tempmsg = false;
		boolean win = true;
		for (int i = 0; i < 9; i++) {
			boolean temp = false;
			for (int j = 0; j < 9; j++) {
				JTextField jText = arrTextFields[i][j];
				String tempName =  jText.getName();
				if(tempName.contains("-")) {
					String tempValue =  jText.getText();
					if(!(tempValue.isEmpty() || tempValue.isBlank())) {
						if(!tempName.equals("-"+tempValue)) {
							jText.setBackground(Color.red);
							tempmsg = true;
						}
					}else {
						JOptionPane.showMessageDialog(container, 
								"Please fill all the space first", "Sudoku", JOptionPane.INFORMATION_MESSAGE, 
								null);						
						temp = true;
						break;
					}	
				}
			}
			if(temp) {
				win = false;
				break;
			}
		}
		if(tempmsg) {
			win = false;
			JOptionPane.showMessageDialog(container, 
					"Loose match. All incorrect column's value had red background", "Sudoku", JOptionPane.ERROR_MESSAGE, 
					null);
		}
		
		if(win) {
			JOptionPane.showMessageDialog(container, "Congurations ! You won this match.");
		}
	}
}

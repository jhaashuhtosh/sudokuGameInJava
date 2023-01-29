package com.sudoku;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class SudokuDashboard {

	JFrame dashboardFrame;
	JPanel dashboardPanel;
	JTextField[][] arrTextFields = new JTextField[9][9]; 
	
	/**
	 * @author Ashutosh.jha
	 * Outer Sudoku Dashboard
	 */
	public void  sudokuDashboard() {
		dashboardFrame = new JFrame("Sudoku Game");
        dashboardFrame.setLayout(null);
		dashboardFrame.setBounds(100, 100, 500, 500);
		dashboardFrame.setDefaultCloseOperation(dashboardFrame.EXIT_ON_CLOSE);
		
		Container c=dashboardFrame.getContentPane();
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 0, 500, 30);
		JButton cButton = new JButton("Complete");
		buttonPanel.add(cButton);
		cButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				completeGame();
			}
		});
		JButton rButton = new JButton("Restart");
		buttonPanel.add(rButton);
		rButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				restartGame();
			}
		});
		JButton hButton = new JButton("Help");
		buttonPanel.add(hButton);
		hButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				helpForGame();
			}
		});
		JButton fButton = new JButton("finish");
		buttonPanel.add(fButton);
		fButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(dashboardFrame, "Are you sure to finish this Game?") == 0)
					dashboardFrame.dispose();
			}
		});
		

		int[][] gridData = returnValueWithIndexAsPerLabel("hard");
		
		dashboardPanel = new JPanel();
		dashboardPanel.setLayout(new GridLayout(9, 9));
		dashboardPanel.setBounds(0, 60, 480, 400);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JTextField tempTextField = new JTextField(); 
				tempTextField.setName(i+""+j);
				tempTextField.setHorizontalAlignment(SwingConstants.CENTER);
				
				int intGridData = gridData[i][j]; 
				tempTextField.setName(String.valueOf(intGridData));
				if(intGridData>0) { 
					tempTextField.setText(String.valueOf(intGridData));
					tempTextField.setEditable(false);
					tempTextField.setBackground(Color.YELLOW);
				}else {
					tempTextField.setBackground(Color.cyan);
				}
				tempTextField.setOpaque(true);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				tempTextField.setBorder(border); 
				arrTextFields[i][j]= tempTextField;
				dashboardPanel.add(arrTextFields[i][j]);
				tempTextField.addKeyListener(new KeyAdapter() {
					 public void keyReleased(KeyEvent ke) {
						 String value = tempTextField.getText();
				            int l = value.length();
				            if(!((ke.getKeyChar() > '0' && ke.getKeyChar() <='9' && l == 1) 
				            		|| ke.getKeyCode() == KeyEvent.VK_BACK_SPACE
				            		|| ke. getKeyCode() == KeyEvent. VK_ENTER)) {
				            	tempTextField.setText("");
				            	JOptionPane.showMessageDialog(dashboardFrame, 
										"Only 1 to 9 number allow here.", "Sudoku", JOptionPane.ERROR_MESSAGE, 
										null);
				            }
					 }
				});
				
			}
		}

		c.add(buttonPanel);
        c.add(dashboardPanel);

		dashboardFrame.setVisible(true);
	}
	

	/**
	 * @author Ashutosh.jha
	 * Inner Sudoku Dashboard
	 */
	private JPanel createSubDashboard(JPanel mainPanel, int ithPosition) {
		int index =1;
		mainPanel.setLayout(new GridLayout(3, 3));
		for (int i = ithPosition; i < (ithPosition+3); i++) {
			for (int j = 1; j < 4; j++) {
				JTextField label = new JTextField();
				label.setText(ithPosition+""+index++);
				label.setOpaque(true);
				Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				label.setBorder(border);
				mainPanel.add(label);
			}
		}
		return mainPanel;
	}
	
	private int[][] returnValueWithIndexAsPerLabel(String gameType){
		if(gameType.equals("easy")) {
			int[][] gridData = {
					{5,3,-4,-6,7,-8,-9,-1,-2},
					{6,-7,-2,1,9,5,-3,-4,-8},
					{-1,9,8,-3,-4,-2,-5,6,-7},
					{8,-5,-9,-7,6,-1,-4,-2,3},
					{4,-2,-6,8,-5,3,-7,-9,1},
					{7,-1,-3,-9,2,-4,-8,-5,6},
					{-9,6,-1,-5,-3,-7,2,8,-4},
					{-2,-8,-7,4,1,9,-6,-3,5},
					{-3,-4,-5,-2,8,-6,-1,7,9}	
			};
			return gridData;
		}else if(gameType.equals("hard")) {
			int[][] gridData = {
					{4,5,-3,-8,-2,-6,-1,-9,-7},
					{-8,-9,2,-5,7,-1,6,3,-4},
					{-1,-6,-7,-4,-9,-3,5,-2,-8},
					{-7,-1,-4,9,5,-2,-8,-6,-3},
					{5,-8,-6,-1,-3,-7,2,-4,-9},
					{-3,2,-9,6,-8,-4,7,5,-1},
					{-9,-3,-5,-2,-1,-8,4,7,6},
					{-6,7,-1,-3,4,5,-9,-8,-2},
					{-2,-4,8,-7,-6,9,-3,-1,5}	
			};
			return gridData;
		}else if(gameType.equals("expert")) {
			int [][] gridData = {
					{-1,-6,-5,8,-4,-7,-9,-2,-3},
					{7,8,9,-3,1,-2,-5,-4,6},
					{-4,-3,-2,-5,-9,6,1,-7,-8},
					{-2,-9,7,-4,-6,-3,-8,5,-1},
					{5,-1,8,7,-2,9,3,-6,4},
					{-3,4,-6,-1,-5,-8,2,-9,-7},
					{-9,-7,3,2,-8,-4,-6,-1,-5},
					{8,-2,-1,-6,7,-5,4,3,9},
					{-6,-5,-4,-9,-3,1,-7,-8,-2}
			};
		}else  if(gameType.equals("begineer")) {
			int[][] gridData = {
					{9,4,2,-1,6,3,8,5,7},
					{5,3,6,2,8,7,9,4,-1},
					{8,7,-1,-9,5,-4,2,3,6},
					{3,2,7,8,1,9,-4,-6,5},
					{1,-5,-4,3,2,6,7,9,8},
					{6,9,8,7,4,5,-1,2,3},
					{2,6,-5,-4,7,-1,3,8,9},
					{7,8,9,6,3,2,-5,1,4},
					{4,1,3,5,9,8,-6,-7,2}	
			};
			return gridData;
		}
		return null;
	}
	
	private void restartGame(){
		dashboardFrame.dispose();
		new SudokuDashboard().sudokuDashboard();
	}
	
	private void helpForGame() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JTextField jText = arrTextFields[i][j];
				String tempName =  jText.getName();
				if(tempName.contains("-"))
					jText.setText(String.valueOf(Integer.valueOf(tempName)*-1));
			}
		}
	}
	
	private void completeGame() {
		boolean tempmsg = false;
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
						JOptionPane.showMessageDialog(dashboardFrame, 
								"Please fill all the space first", "Sudoku", JOptionPane.INFORMATION_MESSAGE, 
								null);
						jText.setBackground(Color.lightGray);						
						temp = true;
						break;
					}	
				}
			}
			if(temp) {
				break;
			}
		}
		if(tempmsg) {
			JOptionPane.showMessageDialog(dashboardFrame, 
					"Loose match. All inncorrect value had red background", "Sudoku", JOptionPane.ERROR_MESSAGE, 
					null);
		}
	}
	
	public static void main(String[] args) {
		new SudokuDashboard().sudokuDashboard();
	}
}

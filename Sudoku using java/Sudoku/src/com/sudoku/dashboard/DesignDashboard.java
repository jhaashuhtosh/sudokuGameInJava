	package com.sudoku.dashboard;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.sudoku.complete.CheckSudoku;
import com.sudoku.helper.HelperSudoku;

public class DesignDashboard extends JFrame {

	private Container container;
	private JTextField[][] arrTextFields ; 
	private HelperSudoku helperSudoku;
	private CheckSudoku checkSudoku;
	private boolean booleanSbutton = false;
	
	public DesignDashboard() {
		new JFrame("Sudoku Game");
		setTitle("Sudoku Game.");
		setLayout(null);
		setBounds(100, 100, 500, 600);
		container = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		arrTextFields = new JTextField[9][9];
		helperSudoku = new HelperSudoku();
		checkSudoku = new CheckSudoku();
	}

	/***
	 * @author Ashutosh.jha This method create sudoko's Buttons
	 */
	private void DesignButtonsOfSudoku() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(0, 40, 500, 30);
		buttonPanel.setOpaque(true);
		
		JButton cButton = new JButton("Complete");
		cButton.setOpaque(true);
		buttonPanel.add(cButton);
		cButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				checkSudoku.completeGame(arrTextFields, container);
			}
		});

		JButton rButton = new JButton("Restart");
		rButton.setOpaque(true);
		buttonPanel.add(rButton);
		rButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new DesignDashboard().createCompleteSudukoGameDashboard();
			}
		});
		
		JButton hButton = new JButton("Fill All");
		hButton.setOpaque(true);
		buttonPanel.add(hButton);
		hButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				helperSudoku.helpForAllGameGame(arrTextFields);
			}
		});

		JButton sButton = new JButton("Fill Selected");
		sButton.setOpaque(true);
		buttonPanel.add(sButton );
		sButton .addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				booleanSbutton = true;
			}
		});
		
		JButton fButton = new JButton("finish");
		fButton.setOpaque(true);
		buttonPanel.add(fButton);
		fButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(container, "Are you sure to finish this Game?") == 0)
					dispose();
			}
		});
		
		container.add(buttonPanel);
		setVisible(true);       
	}
	
	private void makeSudokuNumDashboard(String gameLevel) {
		int[][] gridData = helperSudoku.getValueWithnIndex(gameLevel);
		
		JPanel dashboardPanel = new JPanel();
		dashboardPanel.setLayout(new GridLayout(9, 9));
		dashboardPanel.setBounds(0, 90, 480, 400);
		dashboardPanel.setOpaque(true);
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
				            	JOptionPane.showMessageDialog(container, 
										"Only 1 to 9 number allow here.", "Sudoku", JOptionPane.WARNING_MESSAGE, 
										null);
				            }else {
				            	tempTextField.setBackground(Color.cyan);
				            }
					 }
				});
				
				tempTextField.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if(booleanSbutton) {
							if(tempTextField.getText().trim().length()>0) {
								if(JOptionPane.showConfirmDialog(container, "Are you sure to override this column?")==0) {
									String tempValue = tempTextField.getName();
									tempTextField.setText("");
									String tempValue1 = tempValue.contains("-")? String.valueOf((Integer.parseInt(tempValue)*-1)): tempValue;
									tempTextField.setText(tempValue1);
								}
							}else {
								String tempValue = tempTextField.getName();
								tempTextField.setText(tempValue.contains("-")? String.valueOf((Integer.parseInt(tempValue)*-1)): tempValue);
							}
						}
						booleanSbutton = false;
					}
				});
				
			}
		}
        container.add(dashboardPanel);
		setVisible(true);
	}
	
	public void createCompleteSudukoGameDashboard() { 
		
		String[] playerLevelStrings = {"Select Game's Level", "begineer","easy", "hard", "expert" };
		
		JComboBox playerLevelStringList = new JComboBox(playerLevelStrings);
		playerLevelStringList.setSelectedIndex(0);
		playerLevelStringList.setBounds(150, 0, 200, 30);
		
		playerLevelStringList.setVisible(true);
		playerLevelStringList.setOpaque(true);
		
		playerLevelStringList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = playerLevelStringList.getSelectedIndex();
				if(i>0) {
					DesignButtonsOfSudoku();
					makeSudokuNumDashboard(String.valueOf(playerLevelStringList.getItemAt(i)));
					playerLevelStringList.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(container, "Please select level of game which you play.");
				}
			}
		});
		container.add(playerLevelStringList);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DesignDashboard().createCompleteSudukoGameDashboard();
		
	}
}

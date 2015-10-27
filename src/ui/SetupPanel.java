/**
 * 
 */
package ui;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * @author ChibeePatag
 *
 */
public class SetupPanel extends JPanel {
	JLabel luckyGrocersTitle;
	
	public SetupPanel() {
		GridLayout setupPanelLayout = new GridLayout(3, 1);
		setupPanelLayout.setHgap(10);
		setupPanelLayout.setVgap(10);
		setLayout(setupPanelLayout);
		
		Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(border);
		
		JPanel uploadEntriesPanel = new JPanel(new GridLayout(1, 2));		
		JLabel entriesFileLb = new JLabel("Raffle Entries");
		uploadEntriesPanel.add(entriesFileLb);		
		JTextField entriesFileNameTxt = new JTextField();
		uploadEntriesPanel.add(entriesFileNameTxt);		
		add(uploadEntriesPanel);
		
		JPanel prizesPanel = new JPanel(new GridLayout(1, 2));
		JLabel prizesFileLb = new JLabel("Prizes File");
		prizesPanel.add(prizesFileLb);		
		JTextField prizesFileNameTxt = new JTextField();
		prizesPanel.add(prizesFileNameTxt);		
		add(prizesPanel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 1));
		SelectWinnersBtn selectWinnersBtn = new SelectWinnersBtn();
		buttonPanel.add(selectWinnersBtn);
		add(buttonPanel);
		
	}
}

/**
 * 
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.Branch;
import model.Entry;
import model.Prize;
import model.Winner;
import draw.EntryReader;
import draw.WinnerPicker;

/**
 * @author ChibeePatag
 *
 */
public class SelectWinnersBtn extends JButton implements ActionListener {
	
	JTextField entriesTxt;
	JTextField prizesTxt;
	
	public SelectWinnersBtn(JTextField entriesTxt, JTextField prizesTxt) {
		super("Select Winners");
		this.entriesTxt = entriesTxt;
		this.prizesTxt = prizesTxt;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EntryReader er = new EntryReader();
		String entriesFilename = entriesTxt.getText();
		Map<Branch, List<Entry>> entries = er.read_entries(entriesFilename);
		Set<Branch> keys = entries.keySet();
		
		String prizesFilename = prizesTxt.getText();
		Map<String, List<Prize>> store_prizes = er.getPrizes(prizesFilename);
		File results = new File("results.csv");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(results);
		
		WinnerPicker winnerPicker = new WinnerPicker();
		for (Branch branch : keys) {
			//writer.println(branch.getBranch_name() + " : " + entries.get(branch).size());
			
			List<Entry> branch_entries = entries.get(branch);
			
			for (Prize prize : store_prizes.get("Store")) {
				Winner winner = winnerPicker.pickWinner(prize, branch_entries);
				winner.getEntry().getPrizes().add(prize);
				
				Prize current_branch_prize = new Prize(prize);
				current_branch_prize.setWinner(winner);
				branch.getPrizes().add(current_branch_prize);
				
				writer.print(branch.getAccount());
				writer.print(",");
				writer.print(branch.getBranch_name());
				writer.print(",");
				writer.print(prize.getPrize_description());
				writer.print(",");
				writer.print(winner.getEntry().getCustomer_name());
				writer.print(",");
				writer.print(winner.getEntry().getTelephone());
				writer.print(",");
				writer.println(winner.getEntry().getAddress());										
			}
			
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			writer.close();			
		}
	}
	


}

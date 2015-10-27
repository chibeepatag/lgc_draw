/**
 * 
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;

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
	
	public SelectWinnersBtn() {
		super("Select Winners");
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		EntryReader er = new EntryReader();
		Map<Branch, List<Entry>> entries = er.read_entries("2015-01-06_1420496014_s.csv");
		Set<Branch> keys = entries.keySet();
		
		List<Prize> store_prizes = getStorePrizes();
		
		WinnerPicker winnerPicker = new WinnerPicker();
		for (Branch branch : keys) {
			System.out.println(branch.getBranch_name() + " : " + entries.get(branch).size());
			
			List<Entry> branch_entries = entries.get(branch);
			
			for (Prize prize : store_prizes) {
				Winner winner = winnerPicker.pickWinner(prize, branch_entries);
				winner.getEntry().getPrizes().add(prize);
				
				Prize current_branch_prize = new Prize(prize);
				current_branch_prize.setWinner(winner);
				branch.getPrizes().add(current_branch_prize);
				
				System.out.print(prize.getPrize_description());
				System.out.print(": ");
				System.out.println(winner.getEntry().getCustomer_name());
			}
			
		}
		
	}
	
	public  List<Prize> getStorePrizes(){
		List<Prize> prizes = new ArrayList<Prize>();
		
		/******/
		Prize cellphone1 = new Prize("Store", "Cellphone 1", 1);
		prizes.add(cellphone1);
		Prize cellphone2 = new Prize("Store", "Cellphone 2", 1);
		prizes.add(cellphone2);
		Prize cellphone3 = new Prize("Store", "Cellphone 3", 1);
		prizes.add(cellphone3);
		
		Prize electricFan = new Prize("Store", "Electric Fan", 2);
		prizes.add(electricFan);
		
		Prize flatScreen = new Prize("Store", "Flat Screen TV", 3);
		prizes.add(flatScreen);
		/******/
		return prizes;		
	}

}

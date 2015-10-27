/**
 * 
 */
package draw;

import java.util.List;

import model.Entry;
import model.Prize;
import model.Winner;

/**
 * @author ChibeePatag
 *
 */
public class WinnerPicker {
	
	public Winner pickWinner(Prize prize, List<Entry> entries){		
		Double random_number = Double.valueOf(Math.random() * (entries.size()));
		Entry winner_entry = entries.get(random_number.intValue());
		
		Winner winner = new Winner(prize, winner_entry);
		return winner;
	}

}

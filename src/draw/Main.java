package draw;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ui.LuckyGrocersRaffleFrame;
import model.Branch;
import model.Entry;
import model.Prize;
import model.Winner;

public class Main {
	
	public static void main(String[] args) {		
		LuckyGrocersRaffleFrame.lgcFrame = new LuckyGrocersRaffleFrame("LGC Raffle Promo");
		LuckyGrocersRaffleFrame.lgcFrame.startSos(LuckyGrocersRaffleFrame.lgcFrame);		
	}
	
	

	
	public static void removeDuplicateWinners(List<Branch> branches){
		for (Branch branch : branches) {
			
		}
	}

}

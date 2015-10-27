package model;

public class Winner {
	
	private Prize prize;
	
	private Entry entry;
		
	public Winner(Prize prize, Entry entry) {
		super();
		this.prize = prize;
		this.entry = entry;
	}

	public Prize getPrize() {
		return prize;
	}

	public void setPrize(Prize prize) {
		this.prize = prize;
	}

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}		

}

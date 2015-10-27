package model;

public class Prize {

	private String prize_level;
	private String prize_description;
	private int value_rank;

	private Winner winner;

	public Prize(String prize_level, String prize_description, int value_rank) {
		super();
		this.prize_level = prize_level;
		this.prize_description = prize_description;
		this.value_rank = value_rank;
	}
	
	public Prize(Prize prize){
		this.prize_level = prize.prize_level;
		this.prize_description = prize.prize_description;
		this.value_rank = prize.value_rank;
	}

	public String getPrize_level() {
		return prize_level;
	}

	public void setPrize_level(String prize_level) {
		this.prize_level = prize_level;
	}

	public String getPrize_description() {
		return prize_description;
	}

	public void setPrize_description(String prize_description) {
		this.prize_description = prize_description;
	}

	public Winner getWinner() {
		return winner;
	}

	public void setWinner(Winner winner) {
		this.winner = winner;
	}

	public int getValue_rank() {
		return value_rank;
	}

	public void setValue_rank(int value_rank) {
		this.value_rank = value_rank;
	}

}

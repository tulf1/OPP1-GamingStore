package gamingstoresystem;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Game extends StoreEntiry {

	private String gameCategory;
	private int gameAgeRating;
	private Date gameReleaseDate;
	
	
	public Game(int countOrder, int id, String name, String gameCategory, Date gameReleaseDate, int gameAgeRating, double price) {
		// call from the super calss first construct
		super(countOrder, id, name, price);
		this.gameCategory = gameCategory;               	
		this.gameAgeRating = gameAgeRating;
		this.gameReleaseDate = 	gameReleaseDate;
	}

	public void setGameCategory(String gameCategory) {
		this.gameCategory = gameCategory;
	}

	public String getGameCategory() {
		return gameCategory;
	}
	
	public void setGameReleaseDate(Date gameReleaseDate) {
		this.gameReleaseDate = gameReleaseDate;
	}
	
	public Date getGameReleaseDate() {
		return gameReleaseDate;
	}	

	public void setGameAgeRating(int gameAgeRating) {
		this.gameAgeRating = gameAgeRating;
	}
	
	public int getGameAgeRating() {
		return gameAgeRating;
	}
	
	@Override
	public String toString() {
		return "\t==============================\n"
			+ "\t- Game ID           : " + getId() + "\n"
			+ "\t- Game Name         : " + getName() + "\n"
			+ "\t- Category          : " + getGameCategory() + "\n"
			+ "\t- Release Date      : " + getGameReleaseDate() + "\n"
			+ "\t- Age Rating        : +" + getGameAgeRating() + "\n"
			+ "\t- Price             : " + getPrice() + "$ Ryial\n"
			+ "\t==============================\n";
	}

	public String printForAdmin() {
		return "\t==============================\n"
			+ "\t- Game Number       : #" + getCountOrder() + "\n"
			+ "\t- ID                : " + getId() + "\n"
			+ "\t- Name              : " + getName() + "\n"
			+ "\t- Category          : " + getGameCategory() + "\n"
			+ "\t- Release Date      : " + getGameReleaseDate() + "\n"
			+ "\t- Age Rating        : +" + getGameAgeRating() + "\n"
			+ "\t- Price             : " + getPrice() + "$ Ryial\n"
			+ "\t- Time Added        : " + getFormatTime() + "\n"
			+ "\t==============================\n";
	}

}

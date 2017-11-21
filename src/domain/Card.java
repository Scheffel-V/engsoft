package domain;

import java.util.ArrayList;
import java.util.Date;

public class Card {
	
	private String name;
	private String game;
	private String rarity;
	private Date releaseDate;
	private ArrayList<String> tags;
	private String image;
	
	Card(String name, String game, String rarity, Date releaseDate, ArrayList<String>tags, String image) {
		this.name = name;
		this.game = game;
		this.rarity = rarity;
		this.releaseDate = releaseDate;
		this.tags = tags;
		this.image = image;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getGame() {
		return this.game;
	}
	
	void setGame(String game) {
		this.game = game;
	}
	
	String getRarity() {
		return this.rarity;
	}
	
	void setRarity(String rarity) {
		this.rarity = rarity;
	}
	
	Date getReleaseDate() {
		return this.releaseDate;
	}
	
	void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	ArrayList<String> getTags() {
		return this.tags;
	}
	
	void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	String getImage() {
		return this.image;
	}
	
	void setImage(String image) {
		this.image = image;
	}
}

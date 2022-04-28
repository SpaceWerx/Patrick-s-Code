package com.revature.models;

public class Shows {
	//This is literally half of encapsulation
	private String name;
	private String genre;
	private int length;
	private boolean series;
	private int rating;
	private String langauge;
	
	
	// Everything thing else we will need is call "boiler-plate code"
	//this is your no args
	public Shows() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Shows(String name, String genre, int length, boolean series, int rating, String langauge) {
		super();
		this.name = name;
		this.genre = genre;
		this.length = length;
		this.series = series;
		this.rating = rating;
		this.langauge = langauge;
	}

	//This is a constructor that only has the genre and length, incase I want to look at lengths based ONLY on genres
	public Shows(String genre, int length) {
		super();
		this.genre = genre;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isSeries() {
		return series;
	}

	public void setSeries(boolean series) {
		this.series = series;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getLangauge() {
		return langauge;
	}

	public void setLangauge(String langauge) {
		this.langauge = langauge;
	}

	@Override
	public String toString() {
		return "Shows [name=" + name + ", genre=" + genre + ", length=" + length + ", series=" + series + ", rating="
				+ rating + ", langauge=" + langauge + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((langauge == null) ? 0 : langauge.hashCode());
		result = prime * result + length;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rating;
		result = prime * result + (series ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shows other = (Shows) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (langauge == null) {
			if (other.langauge != null)
				return false;
		} else if (!langauge.equals(other.langauge))
			return false;
		if (length != other.length)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rating != other.rating)
			return false;
		if (series != other.series)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
}

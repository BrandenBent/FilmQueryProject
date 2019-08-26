package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Set;

import com.skilldistillery.filmquery.database.Actor;

public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private int rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private List<Actor> actors;

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			int rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	public Film(int id, String title, String description, int releaseYear, int languageId, int rentalDuration,
			int rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	public Film() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public int getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(int rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
//		builder.append("Film [title=");
		builder.append(title + " --- ");
		builder.append("DESCRIPTION:  ");
		builder.append(description + " --- ");
		builder.append("RELEASE YEAR --- ");
		builder.append(releaseYear);
//		builder.append(", rentalDuration=");
//		builder.append(rentalDuration);
//		builder.append(", rentalRate=");
//		builder.append(rentalRate);
//		builder.append(", length=");
//		builder.append(length);
//		builder.append(", replacementCost=");
//		builder.append(replacementCost);
		builder.append(" RATED: ");
		builder.append(rating);
//		builder.append(", specialFeatures=");
//		builder.append(specialFeatures);
//		SQL USED:
//		SELECT language_id, language.name 
//		FROM film JOIN language 
//		WHERE film.language_id = language.id;
		switch (languageId) {
		case 1:
			builder.append("\tThis movie is in ENGLISH");
			break;
		case 2:
			builder.append("\tThis movie is in ITALIAN");

			break;
		case 3:
			builder.append("\tThis movie is in JAPANESE");

			break;
		case 4:
			builder.append("\tThis movie is in MANDARIN");

			break;
		case 5:
			builder.append("\tThis movie is in FRENCH");

			break;

		default:
			builder.append("\tI'm sorry that language has not been added to our databse");
			break;
		}
//		builder.append("]");
		if (actors != null) {
			for (Actor actor : actors) {
				builder.append(actor);

			}
		}
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + rentalDuration;
		result = prime * result + rentalRate;
		long temp;
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Film other = (Film) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (rentalRate != other.rentalRate)
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}

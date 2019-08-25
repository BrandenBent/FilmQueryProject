package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private final String userName = "student";
	private final String password = "student";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.rental_duration,"
					+ 	 	" film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features "
					+ 	 "FROM film WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				int rentalRate = rs.getInt("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");

				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ 	 "FROM actor WHERE actor.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				actor = new Actor(id, firstName, lastName);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name"
					+ 	 "FROM actor JOIN film_actor ON film_id = actor.id"
					+    "JOIN film ON  film.id = film_actor.film_id"
					+ 	 "WHERE film.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	
	@Override
	public List<Film> findFilmKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, userName, password);
			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, film.rental_duration,"
					+ 	 	" film.rental_rate, film.length, film.replacement_cost, film.rating, film.special_features "
					+ 	 "FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, ("%" + keyword + "%"));
			stmt.setString(2, ("%" + keyword + "%"));
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				int releaseYear = rs.getInt("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				int rentalRate = rs.getInt("rental_rate");
				int length = rs.getInt("length");
				double replacementCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String specialFeatures = rs.getString("special_features");

				film = new Film(id, title, description, releaseYear, languageId, rentalDuration, rentalRate, length,
						replacementCost, rating, specialFeatures);
				
				films.add(film);
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}
}



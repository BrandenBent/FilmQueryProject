package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film findFilmById(int filmId);

	public List<Actor> findActorById(int actorId);

	public List<Actor> findActorsByFilmId(int filmId);

	List<Film> findFilmKeyword(String keyword);
}

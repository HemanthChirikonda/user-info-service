package com.hemanth.models;

public class Movie {
	private Integer movieId;
	private String movieName;
	private Integer movieRating;
	
	
	public Movie() {
		
	}
	
	public Movie(Integer movieId, String movieName, Integer movieRating) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieRating = movieRating;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}

}

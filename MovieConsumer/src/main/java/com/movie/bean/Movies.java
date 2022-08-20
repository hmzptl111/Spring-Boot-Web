package com.movie.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movies {
	private List<Movie> movies;
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for(Movie movie: movies) {
			stringBuilder.append(movie.toString() + "\n");
		}
		
		return stringBuilder.toString();
	}
}

package com.popularmovies.udacity.raihanyuwono.popularmovies.api;

import com.popularmovies.udacity.raihanyuwono.popularmovies.BuildConfig;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class Endpoint {
	private static final String MAIN_URL = "https://api.themoviedb.org/",
								API_VERSION = "3/",
								API_KEY = "?api_key=" + BuildConfig.MOVIEDB_API_KEY,
								PAGE = "&page=",
								URL = MAIN_URL + API_VERSION,
								MAIN_IMAGE_URL = "https://image.tmdb.org/t/p/",
								SIZE_185 = "w185",
								SIZE_300 = "w300";

	public static int page = 1;

	public static final String DISCOVER = URL + "discover/movie" + API_KEY,
								URL_IMAGE_POSTER = MAIN_IMAGE_URL + SIZE_185,
								URL_IMAGE_BANNER = MAIN_IMAGE_URL + SIZE_300;

	public static final String MOVIE_PAGE(){
		return DISCOVER + PAGE + page;
	}

	public static final String VIDEOS(String id){
		return URL + "movie/" + id + "/videos" + API_KEY;
	}

	public static  final String URL_YOUTUBE(String id){
		return "https://www.youtube.com/watch?v=" + id;
	}
}

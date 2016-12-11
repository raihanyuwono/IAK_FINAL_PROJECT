package com.popularmovies.udacity.raihanyuwono.popularmovies.api;

import com.popularmovies.udacity.raihanyuwono.popularmovies.BuildConfig;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class Endpoint {
	private static final String MAIN_URL = "https://api.themoviedb.org/",
								API_VERSION = "3/",
								API_KEY = "?api_key=" + BuildConfig.MOVIEDB_API_KEY,
								URL = MAIN_URL + API_VERSION;
	public static final String DISCOVER = URL + "discover/movie" + API_KEY;
}

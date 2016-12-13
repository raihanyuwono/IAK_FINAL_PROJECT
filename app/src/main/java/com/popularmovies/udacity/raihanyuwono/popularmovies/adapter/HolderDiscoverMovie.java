package com.popularmovies.udacity.raihanyuwono.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.popularmovies.udacity.raihanyuwono.popularmovies.R;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.Endpoint;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class HolderDiscoverMovie extends RecyclerView.ViewHolder{

	private ImageView image;
	private TextView title;

	public HolderDiscoverMovie(View itemView) {
		super(itemView);
		image = (ImageView) itemView.findViewById(R.id.movie_image);
		title = (TextView) itemView.findViewById(R.id.title);
	}

	public void bind(String movie_title, String path){
		String url_image = Endpoint.URL_IMAGE_POSTER + path;
//		Log.d("HolderDiscoverMovie", "url_image = " + url_image);
		Glide.with(itemView.getContext())
				.load(url_image)
				.into(image);
		title.setText(movie_title);
	}

}

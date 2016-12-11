package com.popularmovies.udacity.raihanyuwono.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.popularmovies.udacity.raihanyuwono.popularmovies.R;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class HolderDiscoverMovie extends RecyclerView.ViewHolder{

	private ImageView image;
	private TextView title;

	public HolderDiscoverMovie(View itemView) {
		super(itemView);
		image = (ImageView) itemView.findViewById(R.id.image);
		title = (TextView) itemView.findViewById(R.id.title);
	}

	public void bind(String title, String path){
		final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
		final String IMAGE_SIZE = "w185/"; //poster_size = w92, w154, w185, w342, w500, w700, original
		String url_image = IMAGE_BASE_URL + IMAGE_SIZE + path;
		Log.d("HolderDiscoverMovie", "url_image = " + url_image);
		Glide.with(itemView.getContext())
				.load(url_image)
				.into(this.image);
		this.title.setText(title);
	}

//	public void bind(ResponseDiscover.ResultsBean data){
//		final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/";
//		final String IMAGE_SIZE = "w185/"; //poster_size = w92, w154, w185, w342, w500, w700, original
//		String url_image = IMAGE_BASE_URL + IMAGE_SIZE + data.getId();
//		Glide.with(itemView.getContext())
//				.load(url_image)
//				.into(image);
//		title.setText(data.getTitle());
//	}

}

package com.popularmovies.udacity.raihanyuwono.popularmovies.fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.popularmovies.udacity.raihanyuwono.popularmovies.R;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ApiMovies;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.Endpoint;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseVideos;

/**
 * Created by raihanyuwono on 12/12/2016.
 */

public class FragmentMovieDetail extends Fragment {

	private final String TAG = "FrgamentMovieDetail";

	private ImageView img_banner, img_poster, img_play;
	private TextView title, date, rating, overview;
	private ResponseDiscover.ResultsBean data;

	public FragmentMovieDetail(ResponseDiscover.ResultsBean data){
		this.data = data;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.frag_movie_detail, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		img_banner = (ImageView) view.findViewById(R.id.img_banner);
		img_play = (ImageView) view.findViewById(R.id.img_play);
		img_poster = (ImageView) view.findViewById(R.id.img_poster);
		title = (TextView) view.findViewById(R.id.movie_title);
		date = (TextView) view.findViewById(R.id.movie_release);
		rating = (TextView) view.findViewById(R.id.movie_rating);
		overview = (TextView) view.findViewById(R.id.movie_overview);
		setView();
	}

	private void setView(){
		Glide.with(this)
				.load(Endpoint.URL_IMAGE_BANNER + data.getBackdrop_path())
				.into(img_banner);
		Glide.with(this)
				.load(Endpoint.URL_IMAGE_POSTER + data.getPoster_path())
				.into(img_poster);
		title.setText(data.getTitle());
		date.setText("Release : " + data.getRelease_date());
		rating.setText("Rating : " + data.getVote_average());
		overview.setText(data.getOverview());

		img_play.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				getVideo();
			}
		});
	}

	private void getVideo(){
		ApiMovies.videos(String.valueOf(data.getId()), new ApiMovies.Result() {
			@Override
			public void onSuccess(final String response) {
				getActivity().runOnUiThread(new Runnable() {
					@Override
					public void run() {
						handleResponse(response);
					}
				});
			}

			@Override
			public void onError(Throwable throwable) {
				Log.e(TAG, "onError: ", throwable);
			}
		});
	}

	private void handleResponse(String response){
		Gson gson = new Gson();
		ResponseVideos responseVideos = gson.fromJson(response, ResponseVideos.class);
		watch(responseVideos.getResults().get(0).getKey());
	}

	private void watch(String id){
		Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
		Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Endpoint.URL_YOUTUBE(id)));
		try {
			startActivity(appIntent);
		} catch (ActivityNotFoundException ex){
			startActivity(webIntent);
		}
	}
}

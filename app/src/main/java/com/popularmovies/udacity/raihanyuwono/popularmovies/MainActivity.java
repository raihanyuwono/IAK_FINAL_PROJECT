package com.popularmovies.udacity.raihanyuwono.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;

import com.google.gson.Gson;
import com.popularmovies.udacity.raihanyuwono.popularmovies.adapter.AdapterDiscoverMovie;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ApiMovies;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;

public class MainActivity extends AppCompatActivity {

	private String TAG = "MainActivity";

	private RecyclerView movie_list;
	private AdapterDiscoverMovie adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		movie_list = (RecyclerView) findViewById(R.id.movie_list);
		movie_list.setLayoutManager(new GridLayoutManager(this, 2));

		ApiMovies.discover(new ApiMovies.Result() {
			@Override
			public void onSuccess(final String response) {
//				Log.d(TAG, "onSuccess : " + response);
				MainActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						handleResponse(response);
					}
				});
			}

			@Override
			public void onError(Throwable throwable) {
				Log.e(TAG, "onError : " + throwable);
			}
		});

	}

	private void handleResponse(String response){
		Gson gson = new Gson();
		ResponseDiscover responseDiscover = gson.fromJson(response, ResponseDiscover.class);
//		Log.d(TAG, "onSuccess : total result = " + responseDiscover.getTotal_results());
		adapter = new AdapterDiscoverMovie(responseDiscover.getResults(),
				new AdapterDiscoverMovie.OnItemClickListener() {
					@Override public void onClick(ResponseDiscover.ResultsBean resultsBean) {
						Intent intent = new Intent(MainActivity.this, MovieDetail.class);
						intent.putExtra("data", resultsBean);
						startActivity(intent);
					}
				});
		movie_list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();

		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

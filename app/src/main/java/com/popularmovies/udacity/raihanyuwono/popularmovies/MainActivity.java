package com.popularmovies.udacity.raihanyuwono.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
			public void onSuccess(String response) {
//				Log.d(TAG, "onSuccess : " + response);
				Gson gson = new Gson();
				ResponseDiscover responseDiscover = gson.fromJson(response, ResponseDiscover.class);
//				Log.d(TAG, "onSuccess : total result = " + responseDiscover.getTotal_results());
				adapter = new AdapterDiscoverMovie(responseDiscover.getResults());
				System.out.print(adapter);
				movie_list.setAdapter(adapter);
			}

			@Override
			public void onError(Throwable throwable) {
				Log.e(TAG, "onError : " + throwable);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}

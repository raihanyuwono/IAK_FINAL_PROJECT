package com.popularmovies.udacity.raihanyuwono.popularmovies;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;
import com.popularmovies.udacity.raihanyuwono.popularmovies.fragment.FragmentMovieDetail;

public class MovieDetail extends AppCompatActivity {

	ResponseDiscover.ResultsBean data;
	Toolbar toolbar;
	ShareActionProvider mShareActionProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_movie_detail);

		getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

		data = (ResponseDiscover.ResultsBean) getIntent().getExtras().get("data");

		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.container, new FragmentMovieDetail(data))
				.commit();

		getSupportActionBar().setTitle(data.getTitle());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_share, menu);
		MenuItem item = menu.findItem(R.id.action_share);
		mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
			case android.R.id.home :
				finish();
				break;
			case R.id.action_share :
				setShareIntent();
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setShareIntent(){
		String shareBody = "Here is the share content body";
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
		shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
		startActivity(Intent.createChooser(shareIntent, getResources().getString(R.string.share_using)));
	}
}

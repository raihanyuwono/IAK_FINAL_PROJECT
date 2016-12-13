package com.popularmovies.udacity.raihanyuwono.popularmovies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.popularmovies.udacity.raihanyuwono.popularmovies.R;
import com.popularmovies.udacity.raihanyuwono.popularmovies.api.ResponseDiscover;

import java.util.List;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class AdapterDiscoverMovie extends RecyclerView.Adapter<HolderDiscoverMovie> {

	private List<ResponseDiscover.ResultsBean> data;
	private OnItemClickListener clickListener;

	public AdapterDiscoverMovie(List<ResponseDiscover.ResultsBean> data, OnItemClickListener clickListener) {
		this.data = data;
		this.clickListener = clickListener;
	}

	public interface OnItemClickListener{
		void onClick(ResponseDiscover.ResultsBean resultsBean);
	}

	@Override
	public HolderDiscoverMovie onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie, parent, false);
		return new HolderDiscoverMovie(view);
	}

	@Override
	public void onBindViewHolder(HolderDiscoverMovie holder, int position) {
		final ResponseDiscover.ResultsBean current = data.get(position);
		holder.bind(current.getTitle(), current.getPoster_path());
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				clickListener.onClick(current);
			}
		});
	}

	@Override
	public int getItemCount() {
		return data.size();
	}
}

package com.popularmovies.udacity.raihanyuwono.popularmovies.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by raihanyuwono on 11/12/2016.
 */

public class ResponseDiscover {

	private int page;
	private int total_results;
	private int total_pages;
	private List<ResultsBean> results;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal_results() {
		return total_results;
	}

	public void setTotal_results(int total_results) {
		this.total_results = total_results;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public static class ResultsBean implements Parcelable {

		/**
		 * poster_path : /nHXiMnWUAUba2LZ0dFkNDVdvJ1o.jpg
		 * adult : false
		 * overview : Underworld: Blood Wars follows Vampire death dealer, Selene, as she fends off brutal attacks from both the Lycan clan and the Vampire faction that betrayed her. With her only allies, David and his father Thomas, she must stop the eternal war between Lycans and Vampires, even if it means she has to make the ultimate sacrifice.
		 * release_date : 2016-12-01
		 * genre_ids : [28,27]
		 * id : 346672
		 * original_title : Underworld: Blood Wars
		 * original_language : en
		 * title : Underworld: Blood Wars
		 * backdrop_path : /PIXSMakrO3s2dqA7mCvAAoVR0E.jpg
		 * popularity : 45.450139
		 * vote_count : 123
		 * video : false
		 * vote_average : 4.2
		 */

		private String poster_path;
		private boolean adult;
		private String overview;
		private String release_date;
		private int id;
		private String original_title;
		private String original_language;
		private String title;
		private String backdrop_path;
		private double popularity;
		private int vote_count;
		private boolean video;
		private double vote_average;
		private List<Integer> genre_ids;

		protected ResultsBean(Parcel in) {
			poster_path = in.readString();
			adult = in.readByte() != 0;
			overview = in.readString();
			release_date = in.readString();
			id = in.readInt();
			original_title = in.readString();
			original_language = in.readString();
			title = in.readString();
			backdrop_path = in.readString();
			popularity = in.readDouble();
			vote_count = in.readInt();
			video = in.readByte() != 0;
			vote_average = in.readDouble();
		}

		public static final Creator<ResultsBean> CREATOR = new Creator<ResultsBean>() {
			@Override
			public ResultsBean createFromParcel(Parcel in) {
				return new ResultsBean(in);
			}

			@Override
			public ResultsBean[] newArray(int size) {
				return new ResultsBean[size];
			}
		};

		public String getPoster_path() {
			return poster_path;
		}

		public void setPoster_path(String poster_path) {
			this.poster_path = poster_path;
		}

		public boolean isAdult() {
			return adult;
		}

		public void setAdult(boolean adult) {
			this.adult = adult;
		}

		public String getOverview() {
			return overview;
		}

		public void setOverview(String overview) {
			this.overview = overview;
		}

		public String getRelease_date() {
			return release_date;
		}

		public void setRelease_date(String release_date) {
			this.release_date = release_date;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getOriginal_title() {
			return original_title;
		}

		public void setOriginal_title(String original_title) {
			this.original_title = original_title;
		}

		public String getOriginal_language() {
			return original_language;
		}

		public void setOriginal_language(String original_language) {
			this.original_language = original_language;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getBackdrop_path() {
			return backdrop_path;
		}

		public void setBackdrop_path(String backdrop_path) {
			this.backdrop_path = backdrop_path;
		}

		public double getPopularity() {
			return popularity;
		}

		public void setPopularity(double popularity) {
			this.popularity = popularity;
		}

		public int getVote_count() {
			return vote_count;
		}

		public void setVote_count(int vote_count) {
			this.vote_count = vote_count;
		}

		public boolean isVideo() {
			return video;
		}

		public void setVideo(boolean video) {
			this.video = video;
		}

		public double getVote_average() {
			return vote_average;
		}

		public void setVote_average(double vote_average) {
			this.vote_average = vote_average;
		}

		public List<Integer> getGenre_ids() {
			return genre_ids;
		}

		public void setGenre_ids(List<Integer> genre_ids) {
			this.genre_ids = genre_ids;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeString(poster_path);
			parcel.writeByte((byte) (adult ? 1 : 0));
			parcel.writeString(overview);
			parcel.writeString(release_date);
			parcel.writeInt(id);
			parcel.writeString(original_title);
			parcel.writeString(original_language);
			parcel.writeString(title);
			parcel.writeString(backdrop_path);
			parcel.writeDouble(popularity);
			parcel.writeInt(vote_count);
			parcel.writeByte((byte) (video ? 1 : 0));
			parcel.writeDouble(vote_average);
		}
	}
}

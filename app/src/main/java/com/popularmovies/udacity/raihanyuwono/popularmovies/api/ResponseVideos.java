package com.popularmovies.udacity.raihanyuwono.popularmovies.api;

import java.util.List;

/**
 * Created by raihanyuwono on 13/12/2016.
 */

public class ResponseVideos {

	/**
	 * id : 346672
	 * results : [{"id":"57dc05d9925141681c00909d","iso_639_1":"en","iso_3166_1":"US","key":"FtbM_W9iNjg","name":"UNDERWORLD: BLOOD WARS - Official \"Legacy\" Trailer","site":"YouTube","size":720,"type":"Trailer"},{"id":"57f813ffc3a36874fe00130e","iso_639_1":"en","iso_3166_1":"US","key":"rKHL5PyAPzs","name":"Official Trailer","site":"YouTube","size":720,"type":"Trailer"},{"id":"582e3b13c3a368772d00eb20","iso_639_1":"en","iso_3166_1":"US","key":"eScFp6RChu8","name":"UNDERWORLD: BLOOD WARS - International Trailer (HD)","site":"YouTube","size":1080,"type":"Trailer"}]
	 */

	private int id;
	private List<ResultsBean> results;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public static class ResultsBean {
		/**
		 * id : 57dc05d9925141681c00909d
		 * iso_639_1 : en
		 * iso_3166_1 : US
		 * key : FtbM_W9iNjg
		 * name : UNDERWORLD: BLOOD WARS - Official "Legacy" Trailer
		 * site : YouTube
		 * size : 720
		 * type : Trailer
		 */

		private String id;
		private String iso_639_1;
		private String iso_3166_1;
		private String key;
		private String name;
		private String site;
		private int size;
		private String type;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getIso_639_1() {
			return iso_639_1;
		}

		public void setIso_639_1(String iso_639_1) {
			this.iso_639_1 = iso_639_1;
		}

		public String getIso_3166_1() {
			return iso_3166_1;
		}

		public void setIso_3166_1(String iso_3166_1) {
			this.iso_3166_1 = iso_3166_1;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
}

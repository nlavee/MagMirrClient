package org.nlavee.skidmore.webapps.web.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class NewsObj {
	
	public String title;
	public String NewsAbstract;
	public String url;
	public String publishedTime;
	public String urlMultimedia;
	public String section;
	public ArrayList<String> tags;
	
	public NewsObj(String title, String newsAbstract, String url,
			String dateString, String urlMultimedia, String section,
			ArrayList<String> tags2) {
		this.title = title;
		this.NewsAbstract = newsAbstract;
		this.url = url;
		this.publishedTime = dateString;
		this.urlMultimedia = urlMultimedia;
		this.section = section;
		this.tags = tags2;
	}

	public NewsObj() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNewsAbstract() {
		return NewsAbstract;
	}

	public void setNewsAbstract(String newsAbstract) {
		NewsAbstract = newsAbstract;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPublishedTime() {
		return publishedTime;
	}

	public void setPublishedTime(String publishedTime) {
		this.publishedTime = publishedTime;
	}

	public String getUrlMultimedia() {
		return urlMultimedia;
	}

	public void setUrlMultimedia(String urlMultimedia) {
		this.urlMultimedia = urlMultimedia;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public ArrayList<String> getTags() {
		return tags;
	}

	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", NewsAbstract=" + NewsAbstract
				+ ", url=" + url + ", publishedTime=" + publishedTime
				+ ", urlMultimedia=" + urlMultimedia + ", section=" + section
				+ ", tags=" + tags + "]";
	}
	
	
	
	
	
}

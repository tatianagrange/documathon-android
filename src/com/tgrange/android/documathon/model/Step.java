package com.tgrange.android.documathon.model;

import java.util.ArrayList;

public class Step {
	private int id;
	private String path;
	private String text;
	
	private ArrayList<Author> authors;
	
	public Step(String path) {
		super();
		this.path = path;
	}

	public Step(int id, String path) {
		this(path);
		this.id = id;
	}

	public Step(int id, String path, String text) {
		this(id, path);
		this.text = text;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the authors
	 */
	public ArrayList<Author> getAuthors() {
		return authors;
	}

	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	
	
}

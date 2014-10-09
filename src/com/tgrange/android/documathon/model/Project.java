package com.tgrange.android.documathon.model;

import java.util.ArrayList;

public class Project {
	
	private int id;
	private String name;
	private long start;
	private long update;
	private String lang;
	
	private ArrayList<Step> steps;
	private ArrayList<Material> materials;
	private ArrayList<Tool> tools;
	
	public Project(long start, long update) {
		super();
		this.start = start;
		this.update = update;
	}
	
	public Project(String name, long start, long update) {
		this(start, update);
		this.name = name;
		
	}

	public Project(int id, String name, long start, long update) {
		this(name, start, update);
		this.id = id;
	}

	public Project(int id, String name, long start, long update,
			String lang) {
		this(id, name, start, update);
		this.lang = lang;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the start
	 */
	public long getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(long start) {
		this.start = start;
	}
	/**
	 * @return the update
	 */
	public long getUpdate() {
		return update;
	}
	/**
	 * @param update the update to set
	 */
	public void setUpdate(long update) {
		this.update = update;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 * @return the steps
	 */
	public ArrayList<Step> getSteps() {
		return steps;
	}

	/**
	 * @param steps the steps to set
	 */
	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	/**
	 * @return the materials
	 */
	public ArrayList<Material> getMaterials() {
		return materials;
	}

	/**
	 * @param materials the materials to set
	 */
	public void setMaterials(ArrayList<Material> materials) {
		this.materials = materials;
	}

	/**
	 * @return the tools
	 */
	public ArrayList<Tool> getTools() {
		return tools;
	}

	/**
	 * @param tools the tools to set
	 */
	public void setTools(ArrayList<Tool> tools) {
		this.tools = tools;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", start=" + start
				+ ", update=" + update + ", lang=" + lang + "]";
	}
	
	

}

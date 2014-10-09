package com.tgrange.android.documathon.model;

public class Material {
	private int id;
	private String name;
	private double width;
	private double lenght;
	private double thickness;
	
	public Material(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Material(int id, String name, double width, double lenght,
			double thickness) {
		this(id, name);
		this.width = width;
		this.lenght = lenght;
		this.thickness = thickness;
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
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return the lenght
	 */
	public double getLenght() {
		return lenght;
	}
	/**
	 * @param lenght the lenght to set
	 */
	public void setLenght(double lenght) {
		this.lenght = lenght;
	}
	/**
	 * @return the thickness
	 */
	public double getThickness() {
		return thickness;
	}
	/**
	 * @param thickness the thickness to set
	 */
	public void setThickness(double thickness) {
		this.thickness = thickness;
	}
	
	
}

package hashbrowns.p1.orm.models;

import java.util.ArrayList;

public class Recipe {
	private int id;
	private String  name, description, ingriedients;
	private double cooktime;
	
	
	
	public Recipe(int id, String name, String description, String ingriedients, double cooktime) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingriedients = ingriedients;
		this.cooktime = cooktime;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIngriedients() {
		return ingriedients;
	}
	public void setIngriedients(String ingriedients) {
		this.ingriedients = ingriedients;
	}
	public double getCooktime() {
		return cooktime;
	}
	public void setCooktime(double cooktime) {
		this.cooktime = cooktime;
	}
	
}

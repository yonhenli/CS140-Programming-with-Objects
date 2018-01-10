/**
Li, Yongheng
CS140 A56
Assignment 1
*/

package assignment01;

import java.io.Serializable;

public class University implements Serializable{
	private static final long serialVersionUID = -2906111453292851228L;
	private String name;
	private String city;
	
	public University(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}

}

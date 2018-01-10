/**
Li, Yongheng
CS140 A56
Assignment 1
*/

package assignment01;

import java.io.Serializable;

public class Instructor implements Serializable {
	private static final long serialVersionUID = -6606699573314198988L;
	private String name;
	private University univ;
	private InstructorCategory type;
	
	public Instructor(String name, University univ, InstructorCategory type) {
		this.name = name;
		this.univ = univ;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public University getUniv() {
		return univ;
	}
	
	public InstructorCategory getType() {
		return type;
	}
}

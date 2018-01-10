/**
Li, Yongheng
CS140 A56
Assignment 1
*/

package assignment01;

public class InstrTest {
	public static void main(String[] args) {
		University unv1 = new University("Binghamton University", "Binghamton");
		
		Instructor instr1 = new Instructor("Weiyi Meng", unv1, InstructorCategory.PROFESSOR);
		Instructor instr2 = new Instructor("Wei Xiao", unv1, InstructorCategory.PROFESSOR);
		
		System.out.println(instr1.getName() + ", " + instr1.getUniv().getName() + ", " + instr1.getType());
		System.out.println(instr2.getName() + ", " + instr2.getUniv().getName() + ", " + instr2.getType());
	}
}

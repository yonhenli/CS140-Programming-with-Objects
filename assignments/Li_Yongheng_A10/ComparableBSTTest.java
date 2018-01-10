package assignment10;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparableBSTTest {
	public static void main(String[] args) {
		String[] javaKeyWords = {
				"assert", "boolean", "break", "byte", "case", "catch", "class",
				"const", // not allowed to be used!
				"continue", "default", "do", "double", "else", "enum", "extends",
				"false", "final", "finally", "float", "for", 
				"goto", // not allowed to be used!
				"if", "implements", "import", "instanceof", "int", "interface",
				"long", "native", "new", "null", "package", "private",
				"protected", "public", "return", "short", "static", "strictfp",
				"super", "switch", "synchronized", "this", "throw", "throws",
				"transient", "true", "try", "void", "volatile", "while"};
		
		ComparableBST<String> tree1 = new ComparableBST<>(javaKeyWords[0]);
		
		for (int i = 1; i < javaKeyWords.length; i++) {
			tree1.insert(javaKeyWords[i]);
		}
		
		List<String> StrLst = Arrays.asList(javaKeyWords);
		Set<String> set1 = new TreeSet<>(StrLst);
		Set<String> set2 = new HashSet<>(StrLst);
		
		System.out.println("Time taken for unbanlanced tree: ");
		timer(tree1, javaKeyWords);
		System.out.println("Time taken for unbalanced TreeSet: ");
		timer(set1, javaKeyWords);
		System.out.println("Time taken for unbalanced HashSet: ");
		timer(set2, javaKeyWords);
		
		ComparableBST<String> tree2 = new ComparableBST<>("interface");
		tree2.insert("else");
		tree2.insert("strictfp");
		tree2.insert("class");
		tree2.insert("float");
		tree2.insert("package");
		tree2.insert("throws");
		tree2.insert("byte");
		tree2.insert("default");
		tree2.insert("false");
		tree2.insert("if");
		tree2.insert("native");
		tree2.insert("return");
		tree2.insert("synchronized");
		tree2.insert("try");
		tree2.insert("boolean");
		tree2.insert("case");
		tree2.insert("const");
		tree2.insert("do");
		tree2.insert("enum");
		tree2.insert("final");
		tree2.insert("for");
		tree2.insert("implements");
		tree2.insert("long");
		tree2.insert("new");
		tree2.insert("protected");
		tree2.insert("short");
		tree2.insert("super");
		tree2.insert("this");
		tree2.insert("transient");
		tree2.insert("volatile");
		tree2.insert("assert");
		tree2.insert("break");
		tree2.insert("catch");
		tree2.insert("continue");
		tree2.insert("double");
		tree2.insert("extends");
		tree2.insert("finally");
		tree2.insert("goto");
		tree2.insert("import");
		tree2.insert("null");
		tree2.insert("private");
		tree2.insert("public");
		tree2.insert("static");
		tree2.insert("switch");
		tree2.insert("throw");
		tree2.insert("true");
		tree2.insert("void");
		tree2.insert("while");
		
		System.out.println("Time taken for banlanced tree: ");
		timer(tree2, javaKeyWords);
		
		tree2.prettyPrint();
//		Time taken for unbanlanced tree: 9.743 seconds
//		Time taken for unbalanced TreeSet: 1.654 seconds
//		Time taken for unbalanced HashSet: 0.45 seconds
//		Time taken for banlanced tree: 2.09 seconds
	}
	
	public static void timer(ComparableBST<String> tree, String[] javaKeyWords) {
		long time1 = 0;
		long time2 = 0;
		
		time1 = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			for(String s : javaKeyWords) {
				tree.find(s);
			}
		}
		
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for tree " + (time2 - time1)/1000.0 + " seconds");
	}
	
	public static void timer(Set<String> set, String[] javaKeyWords) {
		long time1 = 0;
		long time2 = 0;
		
		time1 = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			for(String s : javaKeyWords) {
				set.contains(s);
			}
		}
		
		time2 = System.currentTimeMillis();
		System.out.println("Time taken for set " + (time2 - time1)/1000.0 + " seconds");
	}
}

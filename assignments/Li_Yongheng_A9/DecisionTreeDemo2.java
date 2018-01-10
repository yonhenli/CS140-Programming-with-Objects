package assignment09;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
   This program demonstrates a decision tree for an animal
   guessing game.
 */
public class DecisionTreeDemo2 {
	public static BinaryTree makeOriginalTree() {
		return new BinaryTree("Is it a mammal?",
				new BinaryTree("Does it have stripes?",
						new BinaryTree("Is it a carnivore?",
								new BinaryTree("Is it a tiger?"),
								new BinaryTree("Is it a zebra?")),
						new BinaryTree("Is it a pig?")),
				new BinaryTree("Does it fly?",
						new BinaryTree("Is it an eagle?"),
						new BinaryTree("Does it swim?",
								new BinaryTree("Is it a penguin?"),
								new BinaryTree("Is it an ostrich?"))));
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String response;
		BinaryTree questionTree;
		BinaryTree root;
		do {
			System.out.println("Start a new tree (Y)\n"
					+ "or read a stored tree (N)");
			response = in.next().toUpperCase();
		} while (!response.equals("Y") && !response.equals("N"));
		if (response.equals("Y")) {
			questionTree = makeOriginalTree();
		} else {
			try (FileInputStream fis =
					new FileInputStream("pkg09dectree.obj")) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				questionTree = (BinaryTree)ois.readObject();
			} catch(FileNotFoundException e){
				System.out.println("Could not find the file \"pkg09dectree.obj\"\n");
				System.out.println("Creating a new decision tree");
				questionTree = makeOriginalTree();
			} catch(IOException e){
				System.out.println("Processing problem with file\n");
				System.out.println("Creating a new decision tree");
				questionTree = makeOriginalTree();
			} catch (ClassNotFoundException e) {
				System.out.println("Processing problem recreating object\n");
				System.out.println("Creating a new decision tree");
				questionTree = makeOriginalTree();
			}
		}
		root = questionTree;
		while (true) {
			boolean done = false;
			while(!done) {
				BinaryTree left = questionTree.left();
				BinaryTree right = questionTree.right();
				if (left.isEmpty() && right.isEmpty()) {
					String choice;
					
					do{
					System.out.println(questionTree.data() + " (Y/N) ");
					choice = in.next().toUpperCase();
					}
					while(! choice.equals("Y") && ! choice.equals("N"));
					
					if (choice.equals("Y")){
						done = true;
					}

					else {
						in.nextLine();
						System.out.println("I give up. What is it?");
						String newAnswer = in.nextLine().toLowerCase();
						String data = (String)questionTree.data();
						System.out.println("Please give me a question that is true for " +
								  newAnswer + " and false for " + data.substring(6,data.length()-1));
						String newQuestion = in.nextLine();
						questionTree.setData(newQuestion);
						questionTree.setLeft(new BinaryTree("Is it " + newAnswer));
						questionTree.setRight(new BinaryTree(data));
					}
					
				} else {
					do {
						System.out.print(questionTree.data() + " (Y/N) ");
						response = in.next().toUpperCase();
					} while (!response.equals("Y") && !response.equals("N"));
					if (response.equals("Y")) {
						questionTree = left;
					} else {
						questionTree = right;
					}
				}
			}
			questionTree = root;
			do {
				System.out.println("\nDo you want to\nstop and save the "
						+ "new decision tree (S),\ncontinue in the program "
						+ "(C), or \nend the program without saving (E)");
				response = in.next().toUpperCase();
			} while (!response.equals("S") && !response.equals("C")
					&& !response.equals("E"));
			if (response.equals("S")) {
				try (FileOutputStream fos =
						new FileOutputStream("pkg09dectree.obj")) {
					ObjectOutputStream oos = new ObjectOutputStream(
							fos);
					oos.writeObject(questionTree);
				} catch (FileNotFoundException e) {
					System.out.println("\nCould not create the file "
							+ "\"pkg09dectree.obj\"");
					System.out.println("Abandoning save");
				} catch (IOException e) {
					System.out.println("\nThere was an IOException\n");
					System.out.println("Abandoning save");
				}
				break;
			} if (response.equals("E")) {
				break;
			}
		}
	}
}
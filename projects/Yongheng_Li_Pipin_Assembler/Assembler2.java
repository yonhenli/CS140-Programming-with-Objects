package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Assembler2 {
	public static void assemble(File input, File output, ArrayList<String> errors) {
		ArrayList<String> inText = new ArrayList<>();
		ArrayList<String> code = new ArrayList<>();
		ArrayList<String> data = new ArrayList<>();
		try {
			Scanner inputS = new Scanner(input);
			String line = inputS.nextLine();
			inText.add(line);
			while (inputS.hasNextLine()) {
				line = inputS.nextLine();
				inText.add(line);
			}
			
			inputS.close();
			
			int counter = 0;
			String prLine = "abcd";
			int blankStart = -1;
			int blankEnd = -1;
			for (int i = 0; i < inText.size(); i++) {
				if (inText.get(i).trim().length() == 0) {
					if (prLine.trim().length() != 0){
						blankStart = i;
						blankEnd = i;
						while (blankEnd < inText.size()-1 &&
								inText.get(blankEnd+1).trim().length() == 0) {
								blankEnd++;
						}
					}
					if (i <= blankEnd && blankEnd != inText.size()-1) {
						errors.add("Error: line " + (i + 1) + " is a blank line");
					}
				}
				else if(inText.get(i).length() != 0){
					if (inText.get(i).charAt(0) == ' ' || 
						inText.get(i).charAt(0) =='\t') {
					errors.add("Error: line " + (i+1) + " starts with white space");
					}
				}
				
				if (inText.get(i).trim().toUpperCase().startsWith("--")) {
					counter++;
					if (inText.get(i).trim().replace("-", "").length() != 0) {
						errors.add("Error: line " + (i+1) + " has a badly formatted data separator");
					}
					else if (counter > 1) {
						errors.add("Error: line" + (i+1) + " has a duplicate data separator");
					}
				}
				prLine = inText.get(i);
				
			}
			int i = 0;
			while (i < inText.size() && !inText.get(i).startsWith("--")) {
				code.add(inText.get(i).trim());	
				i++;
			}
			i++;
			while (i < inText.size()) {
				data.add(inText.get(i).trim());
				i++;
			}
			
		}catch (FileNotFoundException e) {
			errors.add("Input file does not exist");
			return;
		}
		ArrayList<String> outText = new ArrayList<>();
		
		for (int i = 0; i < code.size(); i++) {
			int indirLvl = -1;
			String[] parts = code.get(i).trim().split("\\s+");
			if (code.get(i).trim().length() != 0) {
				if (!InstructionMap.opcode.containsKey(parts[0].toUpperCase())) {
					errors.add("Error: line " + (i+1) + " illegal mnemonic " + parts[0]);
				}
				if (InstructionMap.sourceCodes.contains(parts[0].toUpperCase()) 
						&& !InstructionMap.sourceCodes.contains(parts[0])) {
					errors.add("Error: line " + (i+1) + " does not have the "
							+ "instruction mnemonic in upper case");
				}else if (InstructionMap.noArgument.contains(parts[0]) 
						&& parts.length != 1) {
					errors.add("Error: line " + (i+1) + " this mnemonic cannot take arguments");
				}else if (!InstructionMap.noArgument.contains(parts[0])) {
					if (parts.length == 1) {
						errors.add("Error: line " + (i+1) + " is missing an argument");
					}else if (parts.length >= 3) {
						errors.add("Error: line " + (i+1) + " has more than one argument");
					}
				}
				if (parts.length == 2) {
					indirLvl = 1;
					if (parts[1].startsWith("[")) {
						if (!InstructionMap.indirectOK.contains(parts[0].toUpperCase())) {
							errors.add("Error: line " + (i+1) + " has no instruction mnemonic");
						}else {
							if (!parts[1].endsWith("]")) {
								errors.add("Error: line " + (i+1) + " does not have a closing bracket");
								parts[1] = parts[1].substring(1, parts[1].length());
							}else {
								parts[1] = parts[1].substring(1, parts[1].length()-1);
							}
							indirLvl = 2;
						}
					}
					if (parts[0].endsWith("I")) {
						indirLvl = 0;
					}else if (parts[0].endsWith("A")) {
						indirLvl = 3;
					}
					int arg = 0;
					try {
						arg = Integer.parseInt(parts[1],16);
					} catch (NumberFormatException e) {
						errors.add("Error: line " + (i+1) 
							+ " does not have a numeric argument");
					}
				}
				if (errors.size() == 0) {
					int opcode = InstructionMap.opcode.get(parts[0]);
					if (parts.length == 1) {
						outText.add(Integer.toHexString(opcode).toUpperCase() + " 0 0");
					}if (parts.length == 2) {
						outText.add( Integer.toHexString(opcode).toUpperCase() + " " + indirLvl + " " + parts[1]);
					}
				}
			}
			
		}
		for (int i = 0; i < data.size(); i++) {
			String[] parts = data.get(i).trim().split("\\s+");
			if (data.get(i).trim().length() != 0) {
				if (parts.length == 2) {
					int arg = 0; 
					try {
						arg = Integer.parseInt(parts[0],16);
					} catch (NumberFormatException e) {
						errors.add("Error: line " + (i+code.size()+2) 
							+ " data address is not a hex number");
					}
					try {
						arg = Integer.parseInt(parts[1],16);
					} catch (NumberFormatException e) {
						errors.add("Error: line " + (i+code.size()+2) 
							+ " data value is not a hex number");
					}
				}else {
					errors.add("Error: line " + (i+code.size()+2) +
							" does not have length 2");
				}
			}
		}
		if (errors.size() == 0) {
			outText.add("-1");
			outText.addAll(data);
			
			try (PrintWriter out = new PrintWriter(output)){
				for(String s : outText) out.println(s);
			} catch (FileNotFoundException e) {
				errors.add("Cannot create output file");
			}
		}
	}
}
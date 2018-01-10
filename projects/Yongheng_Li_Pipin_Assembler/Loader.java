package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Loader {
	public static String load(MachineModel model, File file, 
			int codeOffset, int memoryOffset) {
		int codeSize = 0;
		if (model == null || file == null) {
			return null;
		}
		try (Scanner input = new Scanner(file)) {
			boolean incode = true;
			while (input.hasNextLine()) {
				String line = input.nextLine();
				Scanner parser = new Scanner(line);
				int first = parser.nextInt(16);
				if (incode && first == -1) {
					incode = false;
				}else if (incode && first != -1) {
					int indirLvl = parser.nextInt(16);
					int arg = parser.nextInt(16);
					model.getCode().setCode(codeOffset+codeSize, 
							first, indirLvl, arg);
					codeSize++;
				}else if (!incode) {
					int value = parser.nextInt(16);
					model.setData(memoryOffset+first, value);
				}
				parser.close();
			}
			return "" + codeSize;
			
		}catch (ArrayIndexOutOfBoundsException e) {
			return "Array Index" + e.getMessage();
		} catch (NoSuchElementException e) {
			return "From Scanner: NoSuchElementException";
		}catch (FileNotFoundException e) {
			return "File" + file.getName() + "Not Found";
		}
	}
	
	public static void main(String[] args) {
		MachineModel model = new MachineModel();
		String s = Loader.load(model, new File("out.pexe"),16,32);
		for(int i = 16; i < 16+Integer.parseInt(s); i++) {
			System.out.println(model.getCode().getText(i));			
		}
		System.out.println("--");
		System.out.println("4FF " + 
			Integer.toHexString(model.getData(0x20+0x4FF)).toUpperCase());
		System.out.println("0 " + 
			Integer.toHexString(model.getData(0x20)).toUpperCase());
		System.out.println("10 -" + 
			Integer.toHexString(-model.getData(0x20+0x10)).toUpperCase());
	}
}

package myPack;

import utilityPackage.Utility;

public class MainApp {
	
	/**	 
	 * If you run the program with input and output parameters, the results will be written to 
	 * the output text file
	 * 
	 * If you run the program only with input parameter, the results will be written to 
	 * the console	 
	 */
	
	public static boolean isZip(String s) {		
		return (s.endsWith(".zip"));		
	}

	public static void main(String[] args) {			
		
		if (args.length == 2) {
			
			String input = args[0];
			String output = args[1];
			
			if (Utility.inputFileCheck(input) && Utility.outputFileCheck(output)) {	
				
				Logicable lg;
				
				if (isZip(input)) {
					lg = new LogicZip(input);
				}
				else {
					lg = new LogicTxt(input);
				}
				
				Presentation pt = new Presentation(lg);
				pt.outputFile(output);	
				
			}
			
		}
		else if (args.length == 1) {
			
			String input = args[0]; 	
			
			if (Utility.inputFileCheck(input)) {
				
				Logicable lg;
				
				if (isZip(input)) {
					lg = new LogicZip(input);
				}
				else {
					lg = new LogicTxt(input);
				}
				
				Presentation pt = new Presentation(lg);
					
				pt.outputConsole();
			}
		}
		else {
			System.out.println("input file name not specified "
								+ "or too many arguments");
		}	
		
		
	}	
	

}

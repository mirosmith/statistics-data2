package myPack;

import utilityPackage.Utility;

public class MainApp {
	
	/**	 
	 * Pokud je program spusten s vstupnim i vystupnim souborem, vysledky se vypisou do souboru.
	 * Pokud je program spusten pouze s vstupnim souborem, vysledky se vypisou do konzole.
	 */
	
	public static boolean isZip(String s) {		
		return (s.endsWith(".zip"));		
	}

	public static void main(String[] args) {	
		
		String[] argss = new String[1];
		argss[0] = "test8.txt";
		
		if (argss.length == 2) {
			
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
		else if (argss.length == 1) {
			
			String input = argss[0]; 	
			
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

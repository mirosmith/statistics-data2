package myPack;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**   
 * Allows write the results to to console or output text file 
 */
public class Presentation {

	private Logicable logic;

	public Presentation(Logicable logic) {
		this.logic = logic;
	}

	// output to console
	public void outputConsole() {

		if (logic == null) {
			System.out.println("error due processing");
		}

		Map<String, Integer> map = logic.createMap();
		
		if (map.isEmpty()) {
			System.out.println("no data");
		}
		else {			
	
			System.out.println("------ WORD STATISTICS ------");
	
			for (Map.Entry<String, Integer> item : map.entrySet()) {
				System.out.format("%-15s %d %n", item.getKey(), item.getValue());
			}
		}

	}

	// output to text file
	public void outputFile(String outputFileName) {

		if (logic == null) {
			System.out.println("error due processing");
		}
		
		Path path = Paths.get(outputFileName);
		
		try (BufferedWriter bfw = Files.newBufferedWriter(path)){
			
			Map<String, Integer> myMap = logic.createMap();
			
			if (myMap.isEmpty()) {
				bfw.write("no data");
			}
			else {
				
				bfw.write("------ WORD STATISTICS ------ \n");
				
				for (Map.Entry<String, Integer> item : myMap.entrySet()) {
					bfw.write(item.getKey() + "     " + item.getValue() + " \n");
				}
				
				System.out.println("Successfully saved into: \n" + path.toAbsolutePath().toString());
			}
			
		} 
		catch (IOException e) {
			System.err.println(e);
		} 		

	}	

}

package myPack;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/** 
 * This is parent class, which sets filename,
 *  and allows read the input file  
 */
public class DataReader {
	
	protected String fileName;

	public DataReader(String fileName) {		
		this.fileName = fileName;		
	}

	public String getFileName() {
		return fileName;	
	}

	// reads file and creates list of words	
	public List<String> readFile(Path path) {		
		
		List<String> listOfWords = new LinkedList<String>();
		
		try (BufferedReader bfr = Files.newBufferedReader(path)) {			
			
			String line;
			
			while ((line = bfr.readLine()) != null) {				
				
				String[] lineArray = line.split(" ");
				
				for (String s : lineArray) {					
					
					// deletes white characters 
					s = s.replaceAll("\\W", "").toLowerCase().trim();					
					
					if (s.isEmpty()) {
						continue;
					}
					else {
						listOfWords.add(s);
					}
				}
				
			}
			
		} 
		catch (IOException e) {
			System.err.println(e);
		}				
		
		return listOfWords;
		
	}
	
	

}

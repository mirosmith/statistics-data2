package myPack;

import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LogicZip extends DataReader implements Logicable {	

	public LogicZip(String fileName) {
		super(fileName);		
	}

	@Override
	public Map<String, Integer> createMap() {
		Map<String, Integer> map2 = new TreeMap<String, Integer>();		
		
		List<Path> filePaths = new LinkedList<>();
		
		String inputFile = fileName;
		Path inputFilePath = Paths.get(inputFile);				
			
		URI uri = URI.create("jar:" + inputFilePath.toUri());
		
		try (FileSystem fs = FileSystems.newFileSystem(uri, new HashMap<>())) {
			
			Path directoryPath = fs.getPath("\\");
			DirectoryStream<Path> ds = Files.newDirectoryStream(directoryPath);			
			
			for (Path item : ds) {	
				String s = item.toString();
				
				if (!s.endsWith(".txt")) {
					System.out.println("unprocessed file: " + s);
					continue;
				}		
				filePaths.add(item);				
			}
			
			if (filePaths.isEmpty()) {
				System.out.println("empty zip file");
				return map2;
			}			
			
			for (Path item2 : filePaths) {

				List<String> words = readFile(item2);

				if (words.isEmpty()) {
					return map2;
				}

				int num;
				for (String element : words) {
					if (map2.containsKey(element)) {
						num = map2.get(element);
						map2.put(element, ++num);
					} else {
						map2.put(element, 1);
					}
				}
			}
			
		}		
		catch (IOException e) {
			System.err.println(e);
		}
		
		return map2;
	}

	
}

package myPack;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**  
 * Subclass which creates statistics (Map) of intput TEXT file
 */
public class LogicTxt extends DataReader implements Logicable {

	public LogicTxt(String fileName) {
		super(fileName);		
	}

	@Override
	public Map<String, Integer> createMap() {
		Map<String, Integer> map1 = new TreeMap<String, Integer>();		
		
		String inputFile = fileName;
		Path inputFilePath = Paths.get(inputFile);
		
		List<String> words = readFile(inputFilePath);

		if (words.isEmpty()) {
			return map1;
		}

		int num;
		for (String element : words) {
			if (map1.containsKey(element)) {
				num = map1.get(element);
				map1.put(element, ++num);
			} else {
				map1.put(element, 1);
			}
		}		

		return map1;
	}
	

}

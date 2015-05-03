package run;

import java.io.File;
import java.util.HashMap;

import reader.ReadJsonFile;
import writer.CreateJsonFile;
/**
 * 
 * @author vivek.subedi
 *
 */
public class RunJsonParser {

	public static void main(String[] args) {
		//reading the json file 
		ReadJsonFile.parseJsonFile(new File("C:\\Users\\vivek.subedi\\Desktop\\school.json"));
		
		//getting the hashmap that is created using json objects
		HashMap<Long, HashMap<String, Object>> data = ReadJsonFile.getFinalHashMap();
		System.out.println(data.size());
		
		//writing json object to the file
		CreateJsonFile.writeJsonData(new File("C:\\Users\\vivek.subedi\\Desktop\\school2.json"), data);
	}

}

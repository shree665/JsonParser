package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * 
 * @author vivek.subedi
 *
 */
public class CreateJsonFile {
	
	@SuppressWarnings("unchecked")
	public static void writeJsonData(File file, HashMap<Long, HashMap<String, Object>> data) {
		
		JSONArray jsonArray = new JSONArray();
		//Primary json Object (outer object)
		JSONObject mainObject = new JSONObject();
		
		//secondary json object (middle object)
		JSONObject secondObject = new JSONObject();;
		for (Entry<Long, HashMap<String, Object>> entry : data.entrySet()) {
		    Long key = entry.getKey();
		    HashMap<String, Object> value = entry.getValue();
		    
		    //tertiary json object (innermost object)
		    JSONObject thirdObject = new JSONObject();;
		    for (Entry<String, Object> jsonObjectElement : value.entrySet()) {
				if (jsonObjectElement.getValue() != null) {
					thirdObject.put(jsonObjectElement.getKey(), jsonObjectElement.getValue());
				} else {
					thirdObject.put(jsonObjectElement.getKey(), "Undefined");
				}
			}
		    
		    //System.out.println(thirdObject);
		    secondObject.put(Long.valueOf(key), thirdObject);
		}
		
		mainObject.put("schools", secondObject);
		
		//adding main object to the array
		jsonArray.add(mainObject);
		
		try {
			 
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(jsonArray.toJSONString());
			fileWriter.flush();
			fileWriter.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(mainObject);
		System.out.println("File is created !!!");
	}
}

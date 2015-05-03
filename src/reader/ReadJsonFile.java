package reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author vivek.subedi
 */
public class ReadJsonFile {
	
	//local variable
	private static HashMap<Long, HashMap<String, Object>> finalHashMap = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	public static void parseJsonFile(File file) {
		
		//json parser object
		JSONParser parser = new JSONParser();
		
		try {
			//parsing to the json array since the data json array
			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));
			System.out.println(jsonArray.size());
			
			//looping through the array
			Iterator<JSONObject> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				
				//creating json object with each index of array
				JSONObject jsonObject =  iterator.next();
				HashMap<String, Object> localMap = new HashMap<>();
				localMap.put("id", jsonObject.get("id"));
				localMap.put("name", jsonObject.get("name"));
				localMap.put("state", jsonObject.get("state"));
				localMap.put("averageFederalAidUndergrad", jsonObject.get("averageFederalAidUndergrad"));
				localMap.put("averageNetPriceStudentReceivingAid", jsonObject.get("averageNetPriceStudentReceivingAid"));
				localMap.put("estimatedTotalUndergradEnrollment", jsonObject.get("estimatedTotalUndergradEnrollment"));
				localMap.put("totalPriceOutOfStateOnCampus", jsonObject.get("totalPriceOutOfStateOnCampus"));
				localMap.put("sixYearBachelorsGradRate", jsonObject.get("sixYearBachelorsGradRate"));
				localMap.put("fullTimeRetentionRate", jsonObject.get("fullTimeRetentionRate"));
				localMap.put("partTimeRetentionRate", jsonObject.get("partTimeRetentionRate"));
				localMap.put("score", jsonObject.get("score"));
				finalHashMap.put( (Long) jsonObject.get("id"), localMap);
			}
			System.out.println("Done adding all the json object to the hash map !!!");
			
			
		}catch(FileNotFoundException e) {
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Long, HashMap<String, Object>> getFinalHashMap() {
		return finalHashMap;
	}
	
}

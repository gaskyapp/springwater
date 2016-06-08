package json_data_streaming;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataStreamDriver {

	public static Map<String, Integer> globalTallyMap = new HashMap<String, Integer>();
	public static JsonObject globalTally = new JsonObject();
	
	public static void main(String[] args) {
		DataStreamDriver driver = new DataStreamDriver();
		
		try {
			System.out.println("Reading JSON from logs_xx.json");
			System.out.println("------------------------------");
			
			for(int i=0; i<100; i++) {
				BufferedReader br = new BufferedReader(new FileReader(
					"/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_"+i+".json"));
			
				Logs logs = driver.readJson(br);
				for(int j=0; j<logs.getLogs().length; j++) {
					driver.makeTally(logs.getLog(j));
				}
			}

//			System.out.println(globalTallyMap);
			
			Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().
							setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
			
			//print out the updated global tally
	        System.out.println(gson.toJson(globalTally));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	} //end of main
	
	//Readin JSON and produce(return) log message as HashMap object with ArrayList of logs
	public Logs readJson(BufferedReader br) {
		Gson gson = new Gson();
		
		Logs logs = gson.fromJson(br, Logs.class);
		
		return logs;
	}
	
	//Consume log message and transform into a tally of all logs for each unique email address
	//Also, add onto global tally
	public void makeTally(Log log) {
		String email = log.getEmail();
		if(!globalTallyMap.containsKey(log.getEmail())) {
			globalTallyMap.put(email, 1);
		}else {
			globalTallyMap.put(email, globalTallyMap.get(email)+1);
		}
		
		JsonArray tallies = new JsonArray();
		
		for(Map.Entry<String,Integer> entry : globalTallyMap.entrySet()) {
			JsonObject tally = new JsonObject();
			tally.addProperty("email", entry.getKey());
			tally.addProperty("total", entry.getValue());
			tallies.add(tally);
		}
		
		globalTally.add("tally", tallies);
	}
	
//	//Format globalTally into the example of a tally message
//	private void updateGlobalTally(Map<String, Integer> gMap) {
//		JsonObject globalTally = new JsonObject();
//		JsonArray tallies = new JsonArray();
//		
//		JsonObject tally = new JsonObject();
//
//		
//		
//	}
}

package json_data_streaming;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;  
import java.io.File;
import java.io.FileReader;  
import java.io.IOException;  
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;  
import java.util.Map;

public class DataStreamDriver {

	public static Map<String, Integer> globalTallyMap = new HashMap<String, Integer>();
	public static Map<String, Map<String,Integer>> globalTally = new HashMap<String, Map<String,Integer>>();
	
	public static void main(String[] args) {
		DataStreamDriver driver = new DataStreamDriver();
		
		try {
			System.out.println("Reading JSON from a file");
			System.out.println("------------------------");
			
			for(int i=0; i<100; i++) {
				BufferedReader br = new BufferedReader(new FileReader("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_"+i+".json"));
			
				Logs logs = driver.readJson(br);
				for(int j=0; j<logs.getLogs().length; j++) {
					driver.makeTally(logs.getLog(j));
				}
			}
			
			System.out.println(globalTallyMap);
			
			
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
//		System.out.println("INSIDE OF MAKETALLY");
		String email = log.getEmail();
		if(!globalTallyMap.containsKey(log.getEmail())) {
			globalTallyMap.put(email, 1);
		}else {
			globalTallyMap.put(email, globalTallyMap.get(email)+1);
		}
		
		
	}
	
	//Format globalTally into the example of a tally message
	private void updateGlobalTally(Map<String, Integer> gMap) {
		globalTally.put("tally", gMap);
	}
}

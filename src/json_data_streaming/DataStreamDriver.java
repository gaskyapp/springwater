package json_data_streaming;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

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

	public static Map<String,Integer> globalTally = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		DataStreamDriver driver = new DataStreamDriver();
		
		
		try {
			System.out.println("Reading JSON from a file");
			System.out.println("------------------------");
			
			BufferedReader br = new BufferedReader(new FileReader("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json"));

//			ArrayList<Log> logArrayList = driver.readJson(br);
			Map<String,Object> map = driver.readJson(br);
			
			System.out.println("HERE");
			
			driver.makeTally(map);
//			System.out.println(logArrayList.get(0));
//			
//			driver.makeTally(logArrayList);
				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	} //end of main
	
	//Readin JSON and produce(return) log message as HashMap object with ArrayList of logs
	public Map<String,Object> readJson(BufferedReader br) {
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(br, map.getClass());
		System.out.println(map);
		System.out.println(map.get("logs"));
		System.out.println(map.get("logs").getClass());
		
//		return (ArrayList) map.get("logs");
		return map;
	}
	
	//Consume log message and transform into a tally of all logs for each unique email address
	//Also, add onto global tally
	public void makeTally(Map<String,Object> map) {
		System.out.println("HERE");
		Logs logs = new Logs((Log[]) map.get("logs"), (String)map.get("id"));
		System.out.println("HERE AFTER LOGS OBJECT");
		System.out.println(logs.toString());
		
//		List<Log> logList = new ArrayList<Log>();
//		logList = logs;
//		for(Log l : logList) {
//			System.out.println(l.toString());
//		}
		
//		for(Object c : logs) {
//			System.out.println(c.toString());
//		}
		
//		//for each log, update a tally and global tally
//		for(int i=0; i<logs.size(); i++) {
////			System.out.println(logs.get(i).toString());
//			logs.get(i).getClass();
//		}
		
		System.out.println("INSIDE MAKETALLY ");
		
	}
	
	//Print out global tally
}

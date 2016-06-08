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

	public static void main(String[] args) {
		Gson gson = new Gson();
		DataStreamDriver driver = new DataStreamDriver();
		
		try {
			System.out.println("Reading JSON from a file");
			System.out.println("------------------------");
			
			BufferedReader br = new BufferedReader(new FileReader("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json"));

			ArrayList logArrayList = driver.readJson(br);
			System.out.println(logArrayList.get(0));
			
			
//			//create logs object
//			Logs logsObj = gson.fromJson(br, Logs.class);
//			
//			System.out.println("Logs_id: " + logsObj.getId());
//			System.out.println("Logs count: " + logsObj.getLogs().length);
//			
//			Log[] logs = logsObj.getLogs();
//			System.out.println(logs[0]);
//			
//			for(int i=0; i<logsObj.getLogs().length; i++) {
//				
//			}
		
//			//Readin JSON and produce log message as HashMap object with ArrayList of logs
//			Map<String,Object> map = new HashMap<String,Object>();
//			map = (Map<String,Object>) gson.fromJson(br, map.getClass());
//			System.out.println(map);
//			System.out.println(map.get("logs"));
//			System.out.println(map.get("logs").getClass());
//			
//			ArrayList logArrayList = (ArrayList) map.get("logs");
//			
//			System.out.println(logArrayList.get(0));
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		
	} //end of main
	
	//Readin JSON and produce(return) log message as HashMap object with ArrayList of logs
	public ArrayList<Log> readJson(BufferedReader br) {
		Gson gson = new Gson();
		Map<String,Object> map = new HashMap<String,Object>();
		map = (Map<String,Object>) gson.fromJson(br, map.getClass());
		System.out.println(map);
		System.out.println(map.get("logs"));
		System.out.println(map.get("logs").getClass());
		
		return (ArrayList) map.get("logs");
	}
	
	//Consume log message and transform into a tally of all logs for each unique email address
	//Also, add onto global tally
	public void makeTally() {
		
	}
}

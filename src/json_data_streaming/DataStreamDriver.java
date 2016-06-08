package json_data_streaming;

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
import java.util.Iterator;
import java.util.List;  

public class DataStreamDriver {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		try {
			System.out.println("Reading JSON from a file");
			System.out.println("------------------------");
			
			BufferedReader br = new BufferedReader(new FileReader("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json"));
			
			//create logs object
			Logs logsObj = gson.fromJson(br, Logs.class);
			
			System.out.println("Logs_id: " + logsObj.getId());
			System.out.println("Logs count: " + logsObj.getLogs().length);
			
			Log[] logs = logsObj.getLogs();
			System.out.println(logs[0]);
			
			for(int i=0; i<logsObj.getLogs().length; i++) {
				
			}
		
//			//read json file to String
//			byte[] jsonData = Files.readAllBytes(Paths.get("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json"));
//			
//			ObjectMapper objectMapper = new ObjectMapper();
//			
//			JsonNode rootNode = objectMapper.readTree(jsonData);
//			JsonNode idNode = rootNode.path("id");
//			System.out.println("id = " + idNode.toString());
//			
//			JsonNode emailNode = rootNode.path("email");
//			JsonNode msgNode = rootNode.path("message");
//			
//			Iterator<JsonNode> elements = idNode.elements();
//			while(elements.hasNext()) {
//				System.out.println("HERE");
//				JsonNode id = elements.next();
//				System.out.println("ID = " + id.toString());
//			}
			
//			JsonFactory jasonFactory = new JsonFactory();
//			JsonParser jsonParser = jasonFactory.createParser("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json");
//			System.out.println(jsonParser);
//			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
//			   //get the current token
//			   String fieldname = jsonParser.getCurrentName();
//				
//			   if ("logs".equals(fieldname)) {
//			      //move to next token
//			      jsonParser.nextToken();
//			      System.out.println(jsonParser.getText());        	 
//			   }
//			}
			
//			ObjectMapper mapper = new ObjectMapper();
//			Logs logs = mapper.readValue("/Users/Jasper/Documents/workspace/json_data_streaming/logs/logs_0.json", Logs.class);
//			System.out.println("here");  
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

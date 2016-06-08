package json_data_streaming;

import java.util.List;

public class Logs {
	private Log[] logs;
	private String id;
	
	//Getter and Setter methods
	public Log[] getLogs() {
		return logs;
	}
	public String getId() {
		return id;
	}
	public Log getLog(int i) {
		return logs[i];
	}
	
	public void setLogs(Log[] logs) {
		this.logs = logs;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Id: ");
//		sb.append(id);
//		sb.append('\n');
//		sb.append("Email: ");
//		sb.append(email);
//		sb.append('\n');
//		sb.append("Message: ");
//		sb.append(message);
//		return sb.toString();
//	}
}

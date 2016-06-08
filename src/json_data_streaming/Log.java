package json_data_streaming;

public class Log {
String id, email, message;
	
	//Getter methods
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getMessage() {
		return message;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Id: ");
		sb.append(id);
		sb.append('\n');
		sb.append("Email: ");
		sb.append(email);
		sb.append('\n');
		sb.append("Message: ");
		sb.append(message);
		return sb.toString();
	}
}


package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configurations//config.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBaseUrl() {
		String url = properties.getProperty("BASE_URL");
		if(url != null) return url;
		else throw new RuntimeException("BASE_URL not specified in the Configuration.properties file.");
	}
	
	public String getStatusCodeOK(){
		String statusCodeOK = properties.getProperty("GET_STATUS_OK");
		if(statusCodeOK!= null) return statusCodeOK;
		else throw new RuntimeException("statusCodeOK not specified in the Configuration.properties file");		
	}
	
	public String getStatusCodeBadRequest(){
		String statusCodeBadRequest = properties.getProperty("GET_BAD_REQUEST");
		if(statusCodeBadRequest!= null) return statusCodeBadRequest;
		else throw new RuntimeException("GET_BAD_REQUEST not specified in the Configuration.properties file");		
	}

}
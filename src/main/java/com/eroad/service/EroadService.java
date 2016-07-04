package com.eroad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eroad.io.EroadFileReader;
import com.eroad.model.CsvFile;
import com.eroad.model.GoogleAPIResponse;
/**
 * 
 * @author thomasmetz
 *
 */
@Service
public class EroadService {

	private final String PARAM_LAT = "$LAT";
	private final String PARAM_LON = "$LONG";
	private final String PARAM_KEY = "$KEY";
	
	private final String GOOGLE_KEY = "AIzaSyB_A5Rp3mv40K-NrGrQWN8Pp6pioQ6WlJA";
	
	private final String INPUT_PATH_FILE = "file/input_file.csv";
	private String URL = "https://maps.googleapis.com/maps/api/timezone/json?location=$LAT,$LONG&timestamp=1331161200&key=$KEY";
	
	@Autowired
	@Qualifier("csvReader")
	EroadFileReader<String, List<CsvFile>> csvReader;
	
	/**
	 * 
	 */
	public void execute(){
		
		List<CsvFile> csvFiles = csvReader.readFile(INPUT_PATH_FILE);
		
		if(csvFiles != null && !csvFiles.isEmpty()){
			for (CsvFile csvFile : csvFiles) {
				GoogleAPIResponse apiResponse = callWebService(csvFile);
				csvFile.setTimeZoneId(apiResponse.getTimeZoneId());
			}
			csvReader.appendFile(csvFiles, INPUT_PATH_FILE);
		}
	}
	
	private GoogleAPIResponse callWebService( CsvFile csvFile ){
		RestTemplate restTemplate = new RestTemplate();
        GoogleAPIResponse response = restTemplate.getForObject(this.replaceURLParameters(URL, csvFile.getLatitude(), csvFile.getLongitude()), GoogleAPIResponse.class);
        return response;
	}
	
	/**
	 * replace the parameters within the URL
	 * 
	 * @param url
	 * @param lat
	 * @param longit
	 * @return
	 */
	private String replaceURLParameters(String url, String lat, String longit){
		return url.replace(PARAM_LON, longit).replace(PARAM_LAT, lat).replace(PARAM_KEY, GOOGLE_KEY);
	}
}
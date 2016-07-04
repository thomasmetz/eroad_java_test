package com.eroad.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import com.eroad.model.CsvFile;
/**
 * 
 * @author thomasmetz
 *
 */
@Component("csvReader")
public class CsvReader implements EroadFileReader<String, List<CsvFile>> {

	private final String COMMA = ",";

	@Override
	public List<CsvFile> readFile(String fileName) {

		File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

		BufferedReader br = null;
		String line = "";
		List<CsvFile> csvFiles = new ArrayList<>();
		try {

			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

				String[] column = line.split(COMMA);
				if (column != null && column.length > 2) {
					csvFiles.add(new CsvFile(column[0], column[1], column[2]));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return csvFiles;
	}

	@Override
	public boolean appendFile(List<CsvFile> rs, String fileName) {
		StringBuilder data = new StringBuilder();
		
		for (CsvFile csvFile : rs) {
			data.append(csvFile.getFileDate())
				.append(',')
				.append(csvFile.getLatitude())
				.append(',')
				.append(csvFile.getLongitude())
				.append(",")
				.append(csvFile.getTimeZoneId())
				.append(",")
				.append(csvFile.getTimeZoneDate())
				.append("\n");
				System.out.println( csvFile);
		}
		
		try {
			File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
			if(file != null){
				FileUtils.writeStringToFile(file, data.toString());
				return Boolean.TRUE;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}
}

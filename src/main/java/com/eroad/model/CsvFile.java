package com.eroad.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @author thomasmetz
 *
 */
public class CsvFile implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String FORMAT_READ_DATE = "yyyy-MM-dd HH:mm:ss";
	private static final String FORMAT_WRITE_DATE = "yyyy-MM-dd'T'HH:mm:ss";

	private String fileDate;
	private String latitude;
	private String longitude;
	private String timeZoneId;

	public CsvFile(String fileDate, String latitude, String longitude) {
		super();
		this.fileDate = fileDate;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getFileDateOriginal() throws ParseException {
		return new SimpleDateFormat(FORMAT_READ_DATE).parse(this.fileDate);
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getTimeZoneDate() {
		DateFormat dateFormatGmt = new SimpleDateFormat(FORMAT_WRITE_DATE);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone(this.timeZoneId));
		try {
			return dateFormatGmt.format(this.getFileDateOriginal());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String toString() {
		return this.fileDate+","+this.latitude+','+this.longitude+","+this.timeZoneId+","+this.getTimeZoneDate();		
	}
	
}
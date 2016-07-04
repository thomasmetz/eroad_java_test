package com.eroad.model;

import java.io.Serializable;

/**
 * 
 * @author thomasmetz
 *
 */
public class GoogleAPIResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dstOffset;
	private String rawOffset;
	private String status;
	private String timeZoneId;
	private String timeZoneName;

	public String getDstOffset() {
		return dstOffset;
	}

	public void setDstOffset(String dstOffset) {
		this.dstOffset = dstOffset;
	}

	public String getRawOffset() {
		return rawOffset;
	}

	public void setRawOffset(String rawOffset) {
		this.rawOffset = rawOffset;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTimeZoneId() {
		return timeZoneId;
	}

	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	public String getTimeZoneName() {
		return timeZoneName;
	}

	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}

	@Override
	public String toString() {
		return "\n ======================================================== \n"+"GoogleAPIResponse [dstOffset=" + dstOffset + ", rawOffset=" + rawOffset + ", status=" + status
				+ ", timeZoneId=" + timeZoneId + ", timeZoneName=" + timeZoneName + "]\n ======================================================== ";
	}

	// "dstOffset" : 0,
	// "rawOffset" : -28800,
	// "status" : "OK",
	// "timeZoneId" : "America/Los_Angeles",
	// "timeZoneName" : "Pacific Standard Time"

	
	
}

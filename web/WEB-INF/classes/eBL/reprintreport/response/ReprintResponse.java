package eBL.reprintreport.response;

import java.io.Serializable;
import java.util.List;

/**
 * Contains Reponse object of Reprint Report Calls
 * @author ravaradharajan
 *
 */
public class ReprintResponse  implements Serializable{
	private String sessionId = "";
	private String pgmDate = "";
	
	private String error = "";
	private boolean status = false; 
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getPgmDate() {
		return pgmDate;
	}
	public void setPgmDate(String pgmDate) {
		this.pgmDate = pgmDate;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}

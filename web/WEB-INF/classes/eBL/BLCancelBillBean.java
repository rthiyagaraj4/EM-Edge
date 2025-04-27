/*
Sr No        Version           TFS/Incident        SCF/CRF            		 			Developer Name
--------------------------------------------------------------------------------------------------------
1            V210129            13523         MOHE-CRF-0060       						Shikha Seth
--------------------------------------------------------------------------------------------------------
 */
package eBL;

import java.io.Serializable;
import eBL.Common.BlAdapter;

public class BLCancelBillBean  extends BlAdapter implements Serializable {
	
	private String docTypeCode;
	private String docNum;
	private String episodeType;
	//V210129 start
	private String facilityId;
	
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	//V210129 end
	public String getEpisodeType() {
		return episodeType;
	}
	public void setEpisodeType(String episodeType) {
		this.episodeType = episodeType;
	}
	public String getDocTypeCode() {
		return docTypeCode;
	}
	public void setDocTypeCode(String docTypeCode) {
		this.docTypeCode = docTypeCode;
	}
	
	public String getDocNum() {
		return docNum;
	}
	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}
	public void clearAll(){
		
		episodeType = "";
		docTypeCode= "";
		docNum="";
	}
}

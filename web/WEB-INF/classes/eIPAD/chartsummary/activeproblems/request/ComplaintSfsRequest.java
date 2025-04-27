/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.activeproblems.request;

import eIPAD.chartsummary.common.healthobject.SfsQuery;
import eIPAD.chartsummary.common.request.SFSRequest;

/**
 * @author SaraswathiR  
 *
 */
public class ComplaintSfsRequest extends SFSRequest {
	
	public static final int COMPLAINTS_SPECIALITY = 1;
	public static final int COMPLAINTS_NONSPECIALITY = 2;
	public static final int COMPLAINTS_ALL = 3;
	
	private String specialityCode;
	
	
	
	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.common.request.SFSRequest#getQuery()
	 * One more point to note here is ...
	 * Search by description searches based on the 'COMPLAINT_DESC description' column, 
	 * and the description displayed on the SFS UI is from the 'COMPLAINT_DESC description' column 
	 * but the description displayed on the Record Complaints form is 'COMPLAINT_TEXT' column value
	 */
	@Override
	public SfsQuery getQuery() {
		int sfsType  = getSfsType();
		StringBuffer sqlStr = new StringBuffer("");
		switch(sfsType)
		{
		case COMPLAINTS_SPECIALITY : 
			//Query taken from eCA RecPatChiefComplaintDiagLookupResult.jsp
			sqlStr.append("select COMPLAINT_ID code,COMPLAINT_DESC description,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+this.getLocale()+"',2) SPLTY_DESC from ");
			sqlStr.append(" CA_CHIEF_COMPLAINT_lang_vw where  language_id = '"+this.getLocale()+"' and eff_status = 'E' ");
			if(specialityCode!=null && !specialityCode.equals("")){
				sqlStr.append(" and SPECIALITY_CODE = '"+specialityCode+"' ");
			}
			if(this.getSearhcBy().equalsIgnoreCase("CODE")){
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_ID) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			else{
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_DESC) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			sqlStr.append(" order by complaint_desc");
			break;
			
		case COMPLAINTS_NONSPECIALITY :
			//Query taken from eCA RecPatChiefComplaintDiagLookupResult.jsp
			sqlStr.append("select COMPLAINT_ID code,COMPLAINT_DESC description,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+this.getLocale()+"',2) SPLTY_DESC from ");
			sqlStr.append(" CA_CHIEF_COMPLAINT_lang_vw where  language_id = '"+this.getLocale()+"' and eff_status = 'E' and SPECIALITY_CODE is NULL  ");
			if(this.getSearhcBy().equalsIgnoreCase("CODE")){
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_ID) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			else{
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_DESC) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			sqlStr.append(" order by complaint_desc");
			break;
			
		case COMPLAINTS_ALL :
			//Query taken from eCA RecPatChiefComplaintDiagLookupResult.jsp
			sqlStr.append("select COMPLAINT_ID code,COMPLAINT_DESC description,COMPLAINT_TEXT, am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,'"+this.getLocale()+"',2) SPLTY_DESC from ");
			sqlStr.append(" CA_CHIEF_COMPLAINT_lang_vw where  language_id = '"+this.getLocale()+"' and eff_status = 'E' ");
			if(this.getSearhcBy().equalsIgnoreCase("CODE")){
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_ID) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			else{
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("")){
					sqlStr.append(" and upper(COMPLAINT_DESC) like upper('%"+this.getSearchCriteria()+"%') ");
				}
			}
			sqlStr.append(" order by complaint_desc");
			break;
			
		default : 
			break;
			
		}
		SfsQuery oSfsQuery = new SfsQuery();
		oSfsQuery.setLocale(this.getLocale());
		oSfsQuery.setSfsQuery(sqlStr.toString());
		return oSfsQuery;
	}



	/**
	 * @return the specialityCode
	 */
	public String getSpecialityCode() {
		return specialityCode;
	}



	/**
	 * @param specialityCode the specialityCode to set
	 */
	public void setSpecialityCode(String specialityCode) {
		this.specialityCode = specialityCode;
	}

}

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
public class DiagnosisSfsRequest extends SFSRequest {
	
	public static final int DIAGNOSIS_CUSTOMLIST = 1;
	public static final int DIAGNOSIS_REGULAR = 2;
	private String termGroupId;
	private String termSetId;
	private String sensitiveYN;
	private String notifiableYN;
	private String genderSpecInd;

	/* (non-Javadoc)
	 * @see eIPAD.chartsummary.common.request.SFSRequest#getQuery()
	 */
	@Override
	public SfsQuery getQuery() {
		int sfsType  = getSfsType();
		StringBuffer sqlStr = new StringBuffer("");
		switch(sfsType)
		{
		case DIAGNOSIS_CUSTOMLIST : 
			//Query taken from eMR CusticdQueryResult.jsp
			if(termSetId!=null && !termSetId.equals("")){
				sqlStr.append("select a.term_code code,c.short_desc description,c.long_desc,b.notifiable_yn,b.sensitive_yn ,c.age_spec_ind, c.gender_spec_ind,c.code_indicator,c.select_yn from mr_term_group_dtl a, ");
				sqlStr.append("  mr_term_Code b ,  mr_d_"+termSetId+"_lang_vw c where  a.term_set_id = b.term_set_id and a.term_code = b.term_code  and ");
				sqlStr.append(" a.term_set_id = c.term_set_id and a.term_Code = c.term_code   and ( code_indicator in ('C','D') or code_indicator is null ) ");
				if(genderSpecInd!=null && !genderSpecInd.equals("")){
					sqlStr.append("and ( c.gender_spec_ind = '"+genderSpecInd+"' OR c.gender_spec_ind IS NULL OR nvl(c.age_spec_ind,'O')='O' ) ");
				}
				if(this.getSearhcBy().equalsIgnoreCase("CODE")){
					if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
					{
						sqlStr.append(" and UPPER (a.term_code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
					}
				}
				else
				{
					if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("") )
					{
						sqlStr.append(" and UPPER (LTRIM (c.short_desc)) LIKE UPPER ('%" + this.getSearchCriteria() +"%') ");
					}
				}
				if(termGroupId!=null && !termGroupId.equals("")){
					sqlStr.append(" and a.term_group_id ='"+termGroupId+"'");
				}
				if(termSetId!=null && !termSetId.equals("")){
					sqlStr.append(" and  a.term_set_id='"+termSetId+"' ");
				}
				if(sensitiveYN!=null && !sensitiveYN.equals("") && !sensitiveYN.equals("NA")){
					sqlStr.append(" and  nvl(b.sensitive_yn,'N')='"+sensitiveYN+"' ");
				}
				if(notifiableYN!=null && !notifiableYN.equals("") && !notifiableYN.equals("NA")){
					sqlStr.append(" and  nvl(b.notifiable_yn,'N')='"+notifiableYN+"' ");
				}
				
				sqlStr.append( " and c.language_id='"+this.getLocale()+"' order by description");
			}
			break;
			
		case DIAGNOSIS_REGULAR :
			//Query taken from SearchicdcodeQueryResult.jsp
			if(termSetId!=null && !termSetId.equals("")){
				sqlStr.append("select TERM_CODE code,LONG_DESC,SHORT_DESC description,decode(CODE_INDICATOR,'A','Asterisk(*)','D','Dagger(+)','C','Consequence(C)','E','External Cause Indicator(E)') CODE_INDICATOR, ");
				sqlStr.append(" SENSITIVE_YN,NOTIFIABLE_YN,AGE_SPEC_IND,GENDER_SPEC_IND,select_yn,DAGGER_INDEPENDENT_YN from MR_D_"+termSetId+"_LANG_VW ");
				sqlStr.append(" where   ( code_indicator in ('C','D','E','A') or code_indicator is null ) and EFF_STATUS='E' AND FREE_TEXT_YN = 'N' and LANGUAGE_ID='"+this.getLocale()+"' ");
				if(this.getSearhcBy().equalsIgnoreCase("CODE")){
					if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
					{
						sqlStr.append(" and UPPER (term_code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
					}
				}
				else
				{
					if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("") )
					{
						sqlStr.append(" and UPPER (LTRIM (short_desc)) LIKE UPPER ('%" + this.getSearchCriteria() +"%') ");
					}
				}
				if(genderSpecInd!=null && !genderSpecInd.equals("")){
					sqlStr.append(" and ( gender_spec_ind = '"+genderSpecInd+"'  OR gender_spec_ind IS NULL ) ");
				}
				if(sensitiveYN!=null && !sensitiveYN.equals("") && !sensitiveYN.equals("NA")){
					sqlStr.append(" and NVL(SENSITIVE_YN,'N') = '"+sensitiveYN+"' ");
				}
				if(notifiableYN!=null && !notifiableYN.equals("") && !notifiableYN.equals("NA")){
					sqlStr.append(" and NVL(NOTIFIABLE_YN,'N') = '"+notifiableYN+"' ");
				}
				
				sqlStr.append(" ORDER BY TERM_CODE ");
				
			}
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
	 * @return the termGroupId
	 */
	public String getTermGroupId() {
		return termGroupId;
	}

	/**
	 * @param termGroupId the termGroupId to set
	 */
	public void setTermGroupId(String termGroupId) {
		this.termGroupId = termGroupId;
	}

	/**
	 * @return the termSetId
	 */
	public String getTermSetId() {
		return termSetId;
	}

	/**
	 * @param termSetId the termSetId to set
	 */
	public void setTermSetId(String termSetId) {
		this.termSetId = termSetId;
	}

	/**
	 * @return the sensitiveYN
	 */
	public String getSensitiveYN() {
		return sensitiveYN;
	}

	/**
	 * @param sensitiveYN the sensitiveYN to set
	 */
	public void setSensitiveYN(String sensitiveYN) {
		this.sensitiveYN = sensitiveYN;
	}

	/**
	 * @return the notifiableYN
	 */
	public String getNotifiableYN() {
		return notifiableYN;
	}

	/**
	 * @param notifiableYN the notifiableYN to set
	 */
	public void setNotifiableYN(String notifiableYN) {
		this.notifiableYN = notifiableYN;
	}


	/**
	 * @return the genderSpecInd
	 */
	public String getGenderSpecInd() {
		return genderSpecInd;
	}

	/**
	 * @param genderSpecInd the genderSpecInd to set
	 */
	public void setGenderSpecInd(String genderSpecInd) {
		this.genderSpecInd = genderSpecInd;
	}


}

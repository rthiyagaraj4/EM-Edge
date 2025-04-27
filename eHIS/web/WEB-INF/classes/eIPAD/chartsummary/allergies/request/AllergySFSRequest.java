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
package eIPAD.chartsummary.allergies.request;


import eIPAD.chartsummary.common.request.*;
import eIPAD.chartsummary.common.healthobject.*;
import  eIPAD.chartsummary.common.constants.LocalizationConstants;


/**
 * @author GaneshkumarC
 *
 */
public class AllergySFSRequest extends SFSRequest{
	
	public static final int ALLERGEN=1;
	public static final int CAUSATIVESUBSTANCE=2;
	public static final int REACTION =3;
	private String eventTypeCode;
	private String eventTypeIndicator;
	private String allergenType;
	/**
	 * @return the eventTypeCode
	 */
	public String getEventTypeCode() {
		return eventTypeCode;
	}
	/**
	 * @param eventTypeCode the eventTypeCode to set
	 */
	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}
	/**
	 * @return the eventTypeIndicator
	 */
	public String getEventTypeIndicator() {
		return eventTypeIndicator;
	}
	/**
	 * @param eventTypeIndicator the eventTypeIndicator to set
	 */
	public void setEventTypeIndicator(String eventTypeIndicator) {
		this.eventTypeIndicator = eventTypeIndicator;
	}
	/**
	 * @return the allergenType
	 */
	public String getAllergenType() {
		return allergenType;
	}
	/**
	 * @param allergenType the allergenType to set
	 */
	public void setAllergenType(String allergenType) {
		this.allergenType = allergenType;
	}
	public SfsQuery getQuery()
	{
		int sfsType  = getSfsType();
		StringBuffer sqlStr = new StringBuffer("");
		
		switch(sfsType)
		{
		case ALLERGEN : 
		if(this.getEventTypeCode() != null )	
		{
			if(this.getEventTypeCode().equalsIgnoreCase( LocalizationConstants.CONST_EventTypeCode)) // checking whether event type code is DG
			{
				sqlStr.append(" SELECT   code, description FROM (SELECT generic_id code, generic_name description FROM ph_generic_name_lang_vw ");
				sqlStr.append(" WHERE eff_status = 'E' UNION SELECT allergen_code code, long_desc || '**' description  FROM mr_allergen_lang_vw ");
				sqlStr.append("  WHERE adv_event_type_ind = '" + checkForNull(this.getEventTypeIndicator())+ "' AND language_id = '" +this.getLocale() +"' ");
				sqlStr.append(" AND eff_status = 'E'  AND adv_event_type_code = '" +this.getEventTypeCode() + "' )");
				if(this.getSearhcBy() != null)
				{
					if(this.getSearhcBy().equalsIgnoreCase("CODE"))
					{
						if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
						{
							sqlStr.append(" WHERE UPPER (code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
						}
					}
					else
					{
						if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("") )
						{
							//sqlStr.append(" WHERE UPPER (code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
							// AND UPPER (LTRIM (description, '*')) LIKE UPPER ('')
							sqlStr.append(" where UPPER (LTRIM (description, '*')) LIKE UPPER ('%" + this.getSearchCriteria() +"%') ");
						}
					}
				}
			}
			else
			{
				sqlStr.append(" SELECT   b.allergen_code code, b.long_desc description  FROM mr_adv_event_type_ind a, mr_allergen_lang_vw b, mr_adv_event_type c ");
				sqlStr.append(" WHERE a.adv_event_type_ind = '" +checkForNull(this.getEventTypeIndicator()) +"' AND c.adv_event_type_code = '" +this.getEventTypeCode() +"' " );
				sqlStr.append(" AND language_id = '" +this.getLocale() +"' AND b.adv_event_type_ind = a.adv_event_type_ind  AND c.adv_event_type_code = b.adv_event_type_code ");
				if(this.getSearhcBy() != null)
				{
					if(this.getSearhcBy().equalsIgnoreCase("CODE"))
					{
						if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
						{
							sqlStr.append("  AND UPPER (b.allergen_code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
						}
					}
					else
					{
						if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals("") )
						{
							//sqlStr.append(" WHERE UPPER (code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
							// AND UPPER (LTRIM (description, '*')) LIKE UPPER ('')
							sqlStr.append(" AND UPPER (b.long_desc) LIKE UPPER ('%" + this.getSearchCriteria() +"%') ");
						}
					}
				}
			}
		}
		
		
			
		break;
		
		case CAUSATIVESUBSTANCE : sqlStr.append(" SELECT   drug_code code, drug_desc description  FROM ph_drug_lang_vw  WHERE generic_id = '" + checkForNull(this.getAllergenType())+"' ");
		sqlStr.append("  AND language_id = '" + this.getLocale()+"' ");
		if(this.getSearhcBy() != null)
		{
			if(this.getSearhcBy().equalsIgnoreCase("CODE"))
			{
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
				{
					sqlStr.append(" AND UPPER (drug_code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
				}
			}
			else
			{
				if(this.getSearchCriteria() != null && !this.getSearchCriteria().equals(""))
				{
					//sqlStr.append(" WHERE UPPER (code) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
					// AND UPPER (LTRIM (description, '*')) LIKE UPPER ('')
					sqlStr.append(" AND UPPER (drug_desc) LIKE UPPER ('%" + this.getSearchCriteria()+ "%') ");
				}
			}
		}
			
		break;
		
		case REACTION : sqlStr.append(" SELECT reaction_code code, long_desc description  FROM (SELECT '#' ord, reaction_code reaction_code, long_desc long_desc  FROM am_reaction_lang_vw ");
		sqlStr.append(" WHERE ");
		if(this.getSearhcBy() != null)
		{
			if(this.getSearhcBy().equalsIgnoreCase("CODE"))
			{
				if(this.getSearchCriteria() != null )
				{
					//sqlStr.append(" ( reaction_code LIKE 'UNKN%' OR upper(reaction_code) like upper('%" +  this.getSearchCriteria()+"%') ) ");
					sqlStr.append(" reaction_code LIKE 'UNKN%' ");
				}
			}
			else
			{
				//sqlStr.append(" upper(long_desc) like upper('%"+this.getSearchCriteria() +"%') ");
				sqlStr.append(" upper(long_desc) like upper('UNKN%')");
			}
		}
		sqlStr.append(" UNION ");
		sqlStr.append("  SELECT '$' ord, a.reaction_code reaction_code,  a.long_desc long_desc  FROM am_reaction_lang_vw a, mr_adv_rea_cause_agent b ");
		sqlStr.append("  WHERE (a.reaction_code = b.adv_reac_code) ");
		if(this.getSearhcBy() != null)
		{
			if(this.getSearhcBy().equalsIgnoreCase("CODE"))
			{
				if(this.getSearchCriteria() != null)
				{
					sqlStr.append(" and upper(a.reaction_code) like upper('%" +  this.getSearchCriteria()+"%')  ");
				}
			}
			else
			{
				sqlStr.append(" and upper(a.long_desc) like upper('%"+this.getSearchCriteria() +"%') ");
			}
		} 
		sqlStr.append("  AND a.language_id = '" +this.getLocale() +"' AND b.allergen_code = '" + this.getAllergenType()+"'  AND a.eff_status = 'E') ORDER BY ord ");	
		break;
		
		default : 
		break;
		
		}
		SfsQuery oSfsQuery = new SfsQuery();
		oSfsQuery.setLocale(this.getLocale());
		oSfsQuery.setSfsQuery(sqlStr.toString());
		return oSfsQuery;
	}
	private String checkForNull(String strParam)
    {
            String str ="";
            if(strParam!=null && strParam.length() > 0)
            str = strParam;
            return str;
    }
	
}

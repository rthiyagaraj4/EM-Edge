/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.*;

public class PatEncBannerReplacementBean implements java.io.Serializable
{
	String sqlPatBanner = "select a. PATIENT_ID pat_id,a.patient_name pat_name, a.PATIENT_NAME_LOC_LANG pat_name_loc_lang, get_age(a.date_of_birth,sysdate) age, a. ALT_ID1_NO alt_id, a. CODED_PSEUDO_NAME, a. NATIONALITY_CODE nationality, a. NATIONAL_ID_NO nat_id, a.PAT_CAT_CODE pat_categ, a.sex gender, c.ORGANIZATION_NAME company, c.JOB1_TITLE occupation from mp_patient a,  MP_PAT_REL_CONTACTS c where a.patient_id = ? and a.patient_id = c.patient_id";

	String sqlEncCntxBanner = "select a. PATIENT_ID pat_id,a.patient_name pat_name, a.PATIENT_NAME_LOC_LANG pat_name_loc_lang, get_age(a.date_of_birth,sysdate) age, a. ALT_ID1_NO alt_id, a. CODED_PSEUDO_NAME, a. NATIONALITY_CODE nationality, a. NATIONAL_ID_NO nat_id, a.PAT_CAT_CODE pat_categ, a.sex gender, c.ORGANIZATION_NAME company, c.JOB1_TITLE occupation,b.ENCOUNTER_ID enc_id,  b.ATTEND_PRACTITIONER_ID attend_pract_id, b.ASSIGN_CARE_LOCN_TYPE locn, b.ASSIGN_ROOM_NUM room_num, b.ASSIGN_BED_NUM bed_num, b.SPECIALTY_CODE splty_code from mp_patient a, PR_ENCOUNTER B, MP_PAT_REL_CONTACTS c where B.ENCOUNTER_ID = ? and a.patient_id = ? and b.facility_id = ? and a.patient_id = c.patient_id AND B.PATIENT_ID = A.PATIENT_ID";

	public HashMap putToHash(Connection con,String applCateg, String patientId, String encounterId, String facilityId)
	{
		PreparedStatement pstmt = null;
		ResultSet res = null;
		HashMap mapValues = new HashMap();

		String patName = "";
		String patNameInLocLang = "";
		String patAge = "";
		String altId = "";
		String nationality = "";
		String nationalityId = "";
		String patCateg = "";
		String gender = "";
		String company = "";
		String patCccupation = "";
		String attendPract = "";
		String location = "";
		String roomNum = "";
		String bedNum = "";
		String spltyCode = "";
		String locnRoomBed = "";

		try
		{
			if(applCateg.equals("P"))
			{
				pstmt = con.prepareStatement(sqlPatBanner);
				pstmt.setString(1,patientId);
			}
			else
			{
				pstmt = con.prepareStatement(sqlEncCntxBanner);
				pstmt.setString(1,encounterId);
				pstmt.setString(2,patientId);
				pstmt.setString(3,facilityId);
			}
			res = pstmt.executeQuery();

			while(res.next())
			{
				patName = res.getString("pat_name") == null ? "" : res.getString("pat_name");
				patNameInLocLang = res.getString("pat_name_loc_lang") == null ? "" : res.getString("pat_name_loc_lang");
				patAge = res.getString("age") == null ? "" : res.getString("age");
				altId = res.getString("alt_id") == null ? "" : res.getString("alt_id");
				nationality = res.getString("nationality") == null ? "" : res.getString("nationality");
				nationalityId = res.getString("nat_id") == null ? "" : res.getString("nat_id");
				patCateg = res.getString("pat_categ") == null ? "" : res.getString("pat_categ");
				gender = res.getString("gender") == null ? "" : res.getString("gender");
				company = res.getString("company") == null ? "" : res.getString("company");
				patCccupation = res.getString("occupation") == null ? "" : res.getString("occupation");

				mapValues.put("~PATIENT_ID`",patientId);
				mapValues.put("~PATIENT_NAME`",patName);
				mapValues.put("~PAT_NAME_LOCAL_LANG`",patNameInLocLang);
				mapValues.put("~AGE`",patAge);
				mapValues.put("~ALTERNATE_ID`",altId);
				mapValues.put("~NATIONALITY`",nationality);
				mapValues.put("~NATIONALITY_ID`",nationalityId);
				mapValues.put("~PAT_CATEGORY`",patCateg);
				mapValues.put("~GENDER`",gender);
				mapValues.put("~COMPANY`",company);
				mapValues.put("~OCCUPATION`",patCccupation);

				if(applCateg.equals("E"))
				{
					attendPract = res.getString("attend_pract_id") == null ? "" : res.getString("attend_pract_id");
					location = res.getString("locn") == null ? "" : res.getString("locn");
					roomNum = res.getString("room_num") == null ? "" : res.getString("room_num");
					bedNum = res.getString("bed_num") == null ? "" : res.getString("bed_num");
					spltyCode = res.getString("splty_code") == null ? "" : res.getString("splty_code");

					mapValues.put("~ATTENDING_PRACT`",attendPract);
					if(!location.equals(""))
					{
						if(!roomNum.equals("") && bedNum.equals(""))
							locnRoomBed = location+"/"+roomNum;
						else if(roomNum.equals("") && !bedNum.equals(""))
							locnRoomBed = location+"/"+bedNum;
						else if(roomNum.equals("") && bedNum.equals(""))
							locnRoomBed = location;
						else if(!roomNum.equals("") && !bedNum.equals(""))
							locnRoomBed = location+"/"+roomNum+"/"+bedNum;
					}
					else if(!roomNum.equals(""))
					{
						if(bedNum.equals(""))
							locnRoomBed = roomNum;
						else if(!bedNum.equals(""))
							locnRoomBed = roomNum+"/"+bedNum;
					}
					else if(!bedNum.equals(""))
					{
						if(roomNum.equals(""))
							locnRoomBed = bedNum;
						else if(!roomNum.equals(""))
							locnRoomBed = roomNum+"/"+bedNum;
					}
					else
						locnRoomBed = "";

					mapValues.put("~LOCN_BED_ROOM_NO`",locnRoomBed);
					mapValues.put("~SPLTY_FOR_ENC`",spltyCode);
					mapValues.put("~ENCOUNTER_ID`",encounterId);
				}
			}

			if(res != null) res.close();
			if(pstmt != null) pstmt.close();

		}//end of try
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		return mapValues;
	}

	public StringBuffer replaceVariables(String values, HashMap valueMap)
	{
		StringBuffer patLineValues = null;
		String subStrVal = "";
		String subStrReplacedVal = "";

		while(values.indexOf("~") != -1)
		{
			subStrVal = values.substring(values.indexOf("~"),(values.indexOf("`")+1));

			subStrReplacedVal = (String)valueMap.get(subStrVal);

			values = values.replaceAll(subStrVal,subStrReplacedVal);

		}
		patLineValues = new StringBuffer(values);
		return patLineValues;
	}//end of method
}//end of class

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
16/09/2014	IN049625		Ramesh G		16/09/2014		Sunil K V		Clinical Notes Content Missing.User  has entered all the data in the clinical notes and have signed off the note.														
23/02/2015	IN050800		Ramesh G		23/02/2015		Sunil K V 		When a result is reported by attaching an image from two tier laboratory module and viewed in clinical ebent history 
																		the size of the pop up window is too small to be able to see the A4 sized report
27/07/2018	IN068105		Raja S			27/07/2018	Ramesh G		MMS-DM-CRF-0143																		
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064
14/05/2019	IN067862		Ramesh G										ML-BRU-CRF-0530
19/06/2019	IN070860		Ramesh G		19/06/2019		Ramesh G		SKR-SCF-1220
9/9/2019	IN071291		Nijitha s		9/9/2019						TBMC-SCF-0089
29/10/2019  IN071608		Nijitha s		29/10/2019		Ramesh G		ML-BRU-SCF-1991
06/04/2020	IN071865		Sivabagyam M	06/04/2020		Ramesh G		ML-MMOH-CRF-1484
27/05/2020	IN072879		SIVABAGYAM M	27/05/2020		RAMESH G		MMS-DM-SCF-0688
22/06/2020	IN073100		SIVABAGYAM M	22/06/2020		RAMESH G		ML-MMOH-SCF-1541
18/11/2020	7605			SIVABAGYAM M	18/11/2020		RAMESH G		PMG2020-COMN-CRF-0085	
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.zip.*;
import java.text.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;
import eCommon.Common.CommonAdapter;
import oracle.sql.CLOB;

public class ReBuildClinicalNotes implements Serializable {
	private static final long serialVersionUID = 1L; 
	StringBuffer 	sb		=	new StringBuffer("") ;
	
	private String facilityId;
	private String accessionNum;
	private String locale;
	private String patientId;
	private String encounterId;
	private String contrModAccessionNum;
	private String clinicianName;
	private String recordMode;
	private java.util.Properties jdbcProps;
	private String practitionerName;
	private String XSLFileContextReference;
	private String modifiedDate;
	
	
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String checkForNull( String inputString, String defaultValue ) {
	        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}
	public String getXSLFileContextReference() {
		return XSLFileContextReference;
	}
	public void setXSLFileContextReference(String xSLFileContextReference) {
		XSLFileContextReference = xSLFileContextReference;
	}
	public String getPractitionerName() {
		return practitionerName;
	}
	public void setPractitionerName(String practitionerName) {
		this.practitionerName = practitionerName;
	}
	public java.util.Properties getJdbcProps() {
		return jdbcProps;
	}
	public void setJdbcProps(java.util.Properties jdbcProps) {
		this.jdbcProps = jdbcProps;
	}
	public String getClinicianName() {
		return clinicianName;
	}
	public void setClinicianName(String clinicianName) {
		this.clinicianName = clinicianName;
	}
	public String getRecordMode() {
		return recordMode;
	}
	public void setRecordMode(String recordMode) {
		this.recordMode = recordMode;
	}
	public String getFacilityId() {
		return facilityId;
	}
	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}
	public String getAccessionNum() {
		return accessionNum;
	}
	public void setAccessionNum(String accessionNum) {
		this.accessionNum = accessionNum;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getEncounterId() {
		return encounterId;
	}
	public void setEncounterId(String encounterId) {
		this.encounterId = encounterId;
	}
	public String getContrModAccessionNum() {
		return contrModAccessionNum;
	}
	public void setContrModAccessionNum(String contrModAccessionNum) {
		this.contrModAccessionNum = contrModAccessionNum;
	}
	public String getRebuildNotesCriteria() throws Exception
	{
		String rebuildNotedCriteria = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con		=	ConnectionManager.getConnection(getJdbcProps());
			String query = "SELECT REBUILD_NOTE_CRITERIA FROM CA_NOTE_PARAM";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()){
				rebuildNotedCriteria=rs.getString(1);
			}			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con!=null) con.close();
		}
		
		return rebuildNotedCriteria;
	}
	public Hashtable<String,String> getXMLPrametersDetails(StringBuffer XMLContent){
		Hashtable<String,String>  htParameters = new Hashtable<String,String>();
		
		ArrayList<String> comp_list = new ArrayList<String>();
		comp_list.add("SHORT-TEXT");
		comp_list.add("LONG-TEXT");
		comp_list.add("SHORT-TEXT-WTD");
		comp_list.add("LONG-TEXT-WTD");
		comp_list.add("TEXT");
		comp_list.add("DATE-TIME-NUMERIC");
		comp_list.add("LIST-BOX");
		comp_list.add("CHECK-BOX");
		comp_list.add("DATE-TIME-NUMERIC-WTD");
		comp_list.add("LIST-BOX-WTD");
		comp_list.add("CHECK-BOX-WTD");
		comp_list.add("TEXT-BOX");
		comp_list.add("FORMULA-COMP");			
		comp_list.add("MULTI-LIST");
		comp_list.add("HIDDEN-FIELD");
		
		
		try{
			DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = Factory.newDocumentBuilder();			
			org.w3c.dom.Document doc = builder.parse(new InputSource(new ByteArrayInputStream((XMLContent.toString()).getBytes("utf-8"))));
					
			XPathFactory factory = XPathFactory.newInstance();	    
			XPath xpath = factory.newXPath(); 	
			XPathExpression expr = xpath.compile("//" + "USER-TEMPLATE" + "/*");
			
			for(int i=0;i<comp_list.size();i++){
				NodeList list = doc.getElementsByTagName(comp_list.get(i));
				System.out.println(comp_list.get(i)+"  Total of elements : " + list.getLength());
				for(int j=0;j<list.getLength();j++){
					org.w3c.dom.Element el = (org.w3c.dom.Element) list.item(j);
					if("SHORT-TEXT".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getTextContent());
					}else if("LONG-TEXT".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getTextContent());
					}else if("SHORT-TEXT-WTD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getTextContent());
					}else if("LONG-TEXT-WTD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getTextContent());
					}else if("TEXT".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("DATE-TIME-NUMERIC".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						//TBMC-SCF-0089 Start
						//htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
						if(!"en".equals(locale))
							htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("OTHLANGVAL"));
						else
							htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
						//TBMC-SCF-0089 End
					}else if("LIST-BOX".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						NodeList children_temp = eElement.getChildNodes();
	           			 for (int h = 0; h < children_temp.getLength(); h++) {
	                		 org.w3c.dom.Node child_temp = children_temp.item(h);
	                		 if("DATA".equals(child_temp.getNodeName())){
	                			 org.w3c.dom.Element eElement_temp = (org.w3c.dom.Element) child_temp;
	                			 if("true".equals(eElement_temp.getAttribute("SELECTED")))
	                				 htParameters.put(eElement.getAttribute("NAME"), eElement_temp.getTextContent());
	                		}
	           			 }
					}else if("CHECK-BOX".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("DATE-TIME-NUMERIC-WTD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("LIST-BOX-WTD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getTextContent());
					}else if("CHECK-BOX-WTD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("TEXT-BOX".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("FORMULA-COMP".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}else if("MULTI-LIST".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						//IN071608 Starts
						NodeList children_temp_multi = eElement.getChildNodes();
						for (int h = 0; h < children_temp_multi.getLength(); h++) {
							org.w3c.dom.Node child_temp_row = children_temp_multi.item(h);
							if("MULTI-LIST-ROW".equals(child_temp_row.getNodeName())){
								NodeList child_temp_data=  child_temp_row.getChildNodes();
								for (int k = 0; k < child_temp_data.getLength(); k++) {
									org.w3c.dom.Node child_temp_data_dts = child_temp_data.item(k);
									if("MULTI-LIST-DATA".equals(child_temp_data_dts.getNodeName())){
										org.w3c.dom.Element data = (org.w3c.dom.Element) child_temp_data_dts;
										if("true".equals(data.getAttribute("SELECTED"))){
											htParameters.put(data.getAttribute("NAME"), data.getAttribute("VALUE"));
										}
									}
								} 	
							}
						}
						//htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
						//IN071608 Ends
					}else if("HIDDEN-FIELD".equals(el.getNodeName())){
						org.w3c.dom.Element eElement = (org.w3c.dom.Element)el;
						htParameters.put(eElement.getAttribute("NAME"), eElement.getAttribute("VALUE"));
					}
					
				}
			}			
			
		}catch (Exception e) {
			e.printStackTrace();			
        }		
		return htParameters;
	}
	public Hashtable<String,String> getPatientDetails(String locale,String facility_id,String patient_class,String encounterId,String patient_id,Connection con) throws Exception
	{		
		Hashtable<String,String> htPatDet=new Hashtable<String,String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer prac_credentials = new StringBuffer();
		
		String		patient_name	=	"";
		String		age				=	"";
		String		Sex				=	"";
		String		location_desc	=	"";
		String		print_date_time	=	"";
		String		regn_date		=	"";
		String		date_of_birth	=	"";
		String		mar_status		=	"";
		String		nationality		=	"";
		String		res_area_code	=	"";
		String		res_town_desc	=	"";
		String		relgn			=	"";
		String		name_prefix		=	"";
		String		region_code		=	"";
		String		facility_name	=	"";
		String		res_addr 		=	"";
		String		blood_grp  		= 	"";
		String		rh_factor  		= 	"";
		String 		national_id 	= 	"";		
		String		degree 			=	"";
		String		credential_id1 	= 	"";
		String		credential_id2 	= 	"";
		String		credential_id3 	= 	"";
		String		email_id 		= 	"";		
		String		off_tel_num 	= 	"";
		String		off_tel_ext 	= 	"";
		String		res_tel_num 	= 	"";
		String		fax_num 		= 	"";
		String		mobile_num 		= 	"";
		String		pager_num 		= 	"";
		String		room_num 		= 	"";
		String		bed_num 		= 	"";
		String		credential_id  	= 	"";
		
		String		practitioner_name	=	"";
		String		pref_contact_mode 	= 	"";
		
		
		
		
		String		visit_adm_date		=	"";
		String		speciality_name		=	"";
		String		service_code		=	"";
		String		attending_practitioner	=	"";
		
		try{
			String query = "select patient_name patient_name,get_age(date_of_birth) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,CASE WHEN ? IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(?,(SELECT PAT_CURR_LOCN_CODE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID =?),?,'1') ELSE OP_GET_DESC.OP_CLINIC(?,(SELECT PAT_CURR_LOCN_CODE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID =?),?,'1')  END LOCN_DESC , to_Char(REGN_DATE,'dd/mm/yyyy') REGN_DATE,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, mp_get_desc.MP_MARITAL_STATUS(MAR_STATUS_CODE,?,2) MAR_STATUS, mp_get_desc.MP_COUNTRY(NATIONALITY_CODE,?,2) NATIONALITY ,mp_get_desc.MP_RES_AREA(RES_AREA_CODE,?,2) RES_AREA_CODE,RES_TOWN_DESC,mp_get_desc.MP_RELIGION(RELGN_CODE,?,2) RELGN ,NAME_PREFIX,mp_get_desc.MP_REGION(REGION_CODE,?,2) REGION_CODE,sm_get_desc.SM_FACILITY_PARAM(?,?,1) FACILITY_NAME,b.ADDR1_LINE1||','||b.ADDR1_LINE2||','||b.ADDR1_LINE3||','||b.ADDR1_LINE4 res_addr,c.BLOOD_GRP ,c.RH_FACTOR,a.NATIONAL_ID_NO from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_OTH_DTLS c where a.patient_id = ? and a.PATIENT_ID = b.PATIENT_ID and a.PATIENT_ID = c.PATIENT_ID ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1,patient_class);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,encounterId);
			pstmt.setString(4,locale);
			pstmt.setString(5,facility_id);
			pstmt.setString(6,encounterId);
			pstmt.setString(7,locale);
			pstmt.setString(8,locale);
			pstmt.setString(9,locale);
			pstmt.setString(10,locale);
			pstmt.setString(11,locale);
			pstmt.setString(12,locale);
			pstmt.setString(13,facility_id);
			pstmt.setString(14,locale);
			pstmt.setString(15,patient_id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				patient_name	=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
				age 			= 	rs.getString("patient_age")==null?"":rs.getString("patient_age");
				Sex 			= 	rs.getString("Gender")==null?"":rs.getString("Gender");
				location_desc 	= 	rs.getString("LOCN_DESC")==null?"":rs.getString("LOCN_DESC");
				print_date_time = 	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
				regn_date 		= 	rs.getString("regn_date")==null?"":rs.getString("regn_date");
				date_of_birth 	= 	rs.getString("date_of_birth")==null?"":rs.getString("date_of_birth");
				mar_status 		= 	rs.getString("mar_status")==null?"":rs.getString("mar_status");
				nationality 	= 	rs.getString("nationality")==null?"":rs.getString("nationality");
				res_area_code 	= 	rs.getString("res_area_code")==null?"":rs.getString("res_area_code");
				res_town_desc 	= 	rs.getString("res_town_desc")==null?"":rs.getString("res_town_desc");
				relgn 			= 	rs.getString("relgn")==null?"":rs.getString("relgn");
				name_prefix 	= 	rs.getString("name_prefix")==null?"":rs.getString("name_prefix");
				region_code 	= 	rs.getString("region_code")==null?"":rs.getString("region_code");		
				facility_name 	= 	rs.getString("FACILITY_NAME")==null?"":rs.getString("FACILITY_NAME");		
				res_addr 		= 	rs.getString("res_addr")==null?"":rs.getString("res_addr");		
				blood_grp 		= 	rs.getString("BLOOD_GRP")==null?"":rs.getString("BLOOD_GRP");		
				rh_factor 		= 	rs.getString("RH_FACTOR")==null?"":rs.getString("RH_FACTOR");		
				national_id 	= 	rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");	//IN043083
	
				if(Sex.equals("M") )
					Sex = "Male";
				else if(Sex.equals("F") )
					Sex = "Female";
				else
					Sex = "Unknown";
	
				if(patient_class.equals("OP"))
					patient_class =	"Outpatient";
				else if(patient_class.equals("IP"))
					patient_class =	"Inpatient";
				else if(patient_class.equals("EM"))
					patient_class =	"Emergency";
				else if(patient_class.equals("DC"))
					patient_class =	"Daycare";

			}
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();	
			
			try{				
				String strPracCredentialsQuery = "select PRACTITIONER_NAME,DEGREE,CREDENTIAL_ID,CREDENTIAL_ID1,CREDENTIAL_ID2,CREDENTIAL_ID3,EMAIL_ID,PREF_CONTACT_MODE,OFF_TEL_NUM,OFF_TEL_EXT,RES_TEL_NUM,FAX_NUM,MOBILE_NUM,PAGER_NUM ,ASSIGN_BED_NUM,ASSIGN_ROOM_NUM FROM AM_PRACTITIONER A, PR_ENCOUNTER B WHERE A.PRACTITIONER_ID=B.ATTEND_PRACTITIONER_ID AND FACILITY_ID=? AND ENCOUNTER_ID=?";						
				pstmt	= con.prepareStatement(strPracCredentialsQuery);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,encounterId);
				
				rs = pstmt.executeQuery();

				if(rs.next()){
					practitioner_name 	= rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
					degree 				= rs.getString("DEGREE")==null?"":rs.getString("DEGREE");
					credential_id 		= rs.getString("CREDENTIAL_ID")==null?"":rs.getString("CREDENTIAL_ID");
					credential_id1 		= rs.getString("CREDENTIAL_ID1")==null?"":rs.getString("CREDENTIAL_ID1");
					credential_id2 		= rs.getString("CREDENTIAL_ID2")==null?"":rs.getString("CREDENTIAL_ID2");
					credential_id3 		= rs.getString("CREDENTIAL_ID3")==null?"":rs.getString("CREDENTIAL_ID3");
					email_id 			= rs.getString("EMAIL_ID")==null?"":rs.getString("EMAIL_ID");
					pref_contact_mode	= rs.getString("PREF_CONTACT_MODE")==null?"":rs.getString("PREF_CONTACT_MODE");
					off_tel_num 		= rs.getString("OFF_TEL_NUM")==null?"":rs.getString("OFF_TEL_NUM");
					off_tel_ext 		= rs.getString("OFF_TEL_EXT")==null?"":rs.getString("OFF_TEL_EXT");
					res_tel_num 		= rs.getString("RES_TEL_NUM")==null?"":rs.getString("RES_TEL_NUM");
					fax_num 			= rs.getString("FAX_NUM")==null?"":rs.getString("FAX_NUM");
					mobile_num 			= rs.getString("MOBILE_NUM")==null?"":rs.getString("MOBILE_NUM");
					pager_num 			= rs.getString("PAGER_NUM")==null?"":rs.getString("PAGER_NUM");
					bed_num 			= rs.getString("ASSIGN_BED_NUM")==null?"":rs.getString("ASSIGN_BED_NUM");
					room_num 			= rs.getString("ASSIGN_ROOM_NUM")==null?"":rs.getString("ASSIGN_ROOM_NUM");
				
					prac_credentials.append(practitioner_name+" "+degree+"<br/>");
					
					if (!credential_id.equals(""))
						prac_credentials.append(credential_id);

					if (!credential_id.equals("") && (!credential_id1.equals("")))
						prac_credentials.append(",");
					
						prac_credentials.append(credential_id1);

					if (!credential_id1.equals("") && (!credential_id2.equals("")))
						prac_credentials.append(",");

					prac_credentials.append(credential_id2);

					if (!credential_id2.equals("") && (!credential_id3.equals("")))
						prac_credentials.append(",");
					
					prac_credentials.append(credential_id3);
					
					if (!credential_id1.equals("") || !credential_id2.equals("") || (!credential_id3.equals("")))
						prac_credentials.append("<br/>");
			
					
					if (pref_contact_mode.equals("M")){
							prac_credentials.append("Mobile : "+mobile_num);
							if (!email_id.equals(""))
									prac_credentials.append("  Email : "+email_id);
					}else if (pref_contact_mode.equals("R")){
							prac_credentials.append("Residence Tel : "+res_tel_num);
							if (!email_id.equals(""))
									prac_credentials.append("  Email : "+email_id);
					}else if (pref_contact_mode.equals("O")){									
							prac_credentials.append("Office Tel : "+off_tel_num);
							if (!off_tel_ext.equals(""))
									prac_credentials.append("  ext : "+off_tel_ext);
							if (!email_id.equals(""))
									prac_credentials.append("  Email : "+email_id);
					}else {
							if (!email_id.equals(""))
									prac_credentials.append("  Email : "+email_id);
					}

				}
		
			}catch(Exception ee){
				System.err.println("Exceptionin ReBuildClinicalNote @1 : "+ee.toString());
				ee.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			
			try{
				String strPracCredentialsQuery1 = "SELECT AM_GET_DESC.AM_PRACTITIONER(ADMIT_PRACTITIONER_ID,?,1) ADMIT_PRACTITIONER_NAME,AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,?,'2') SPECIALTY_NAME,AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') SERVICE_CODE,to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE FROM PR_ENCOUNTER WHERE ENCOUNTER_ID = ? AND FACILITY_ID=?";						
				pstmt	= con.prepareStatement(strPracCredentialsQuery1);				
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,locale);
				pstmt.setString(4,encounterId);
				pstmt.setString(5,facility_id);
				
				rs = pstmt.executeQuery();

				if(rs.next()){
					attending_practitioner	=	rs.getString("ADMIT_PRACTITIONER_NAME")==null?"":rs.getString("ADMIT_PRACTITIONER_NAME");
					speciality_name			=	rs.getString("SPECIALTY_NAME")==null?"":rs.getString("SPECIALTY_NAME");
					service_code			=	rs.getString("SERVICE_CODE")==null?"":rs.getString("SERVICE_CODE");
					visit_adm_date			=	rs.getString("VISIT_ADM_DATE")==null?"":rs.getString("VISIT_ADM_DATE");
					
				}
			}catch(Exception ee){
				System.err.println("Exceptionin ReBuildClinicalNote @2 : "+ee.toString());
				ee.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
			}
			
			// setting pat details in bean
			htPatDet.put("PATIENT_ID",patient_id); 
			htPatDet.put("PATIENT_NAME",patient_name);
			//htPatDet.put("REGN_DATE",regn_date);  //TBMC-SCF-0089 Commented
			htPatDet.put("REGN_DATE",getDateBasedOnLocale(regn_date, locale, "DMY")); //TBMC-SCF-0089 Added
			htPatDet.put("GENDER",Sex);
			htPatDet.put("RESIDENTAIL_ADDRESS",res_addr);
			htPatDet.put("AGE",age);   	
			htPatDet.put("FACILITY_NAME",facility_name);
			//htPatDet.put("DATE_OF_BIRTH",date_of_birth); //TBMC-SCF-008 Commented
			htPatDet.put("DATE_OF_BIRTH",getDateBasedOnLocale(date_of_birth, locale, "DMY")); //TBMC-SCF-0089 Added
			htPatDet.put("MAR_STATUS_CODE",mar_status);
			htPatDet.put("NATIONALITY_CODE",nationality);
			htPatDet.put("RH_FACTOR",rh_factor); 	
			htPatDet.put("BLOOD_GRP",blood_grp);
			htPatDet.put("RES_AREA_CODE",res_area_code);	
			htPatDet.put("RES_TOWN_CODE",res_town_desc);
			htPatDet.put("RELGN_CODE",relgn); 	
			htPatDet.put("NAME_PREFIX",name_prefix);
			htPatDet.put("REGION_CODE",region_code); 
			htPatDet.put("ENCOUNTER_ID",encounterId);
			htPatDet.put("CURRENT_LOCATION",location_desc);
			htPatDet.put("ATTENDING_PRACTITIONER",attending_practitioner);
			//htPatDet.put("ADMISSION_DATE",visit_adm_date);//TBMC-SCF-0089 Commented
			htPatDet.put("ADMISSION_DATE",getDateBasedOnLocale(visit_adm_date, locale, "DMYHM"));//TBMC-SCF-0089 Added
			htPatDet.put("SPECIALITY",speciality_name);
			htPatDet.put("PATIENT_CLASS",patient_class);
			htPatDet.put("ROOM_NUM",room_num);
			htPatDet.put("BED_NUM",bed_num);
			htPatDet.put("SERVICE_CODE",service_code);
			htPatDet.put("ATT_PRACT_WITH_CREDENTIAL",prac_credentials.toString());
			htPatDet.put("PATIENT_NRIC",national_id);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			patient_name	=	null; 		age				=	null;		Sex				=	null;		location_desc	=	null;
			print_date_time	=	null;		regn_date		=	null;		date_of_birth	=	null;		mar_status		=	null;
			nationality		=	null;		res_area_code	=	null;		res_town_desc	=	null;		relgn			=	null;
			name_prefix		=	null;		region_code		=	null;		facility_name	=	null;		res_addr 		=	null;
			blood_grp  		= 	null;		rh_factor  		= 	null;		national_id 	= 	null;		degree 			=	null;
			credential_id1 	= 	null;		credential_id2 	= 	null;		credential_id3 	= 	null;		email_id 		= 	null;		
			off_tel_num 	= 	null;		off_tel_ext 	= 	null;		res_tel_num 	= 	null;		fax_num 		= 	null;
			mobile_num 		= 	null;		pager_num 		= 	null;		room_num 		= 	null;		bed_num 		= 	null;
			credential_id  	= 	null;			
			practitioner_name	=	null;		pref_contact_mode 	= 	null;		visit_adm_date		=	null;
			speciality_name		=	null;		service_code		=	null;		attending_practitioner	=	null;
		}
		
		return htPatDet;
	}
	public ArrayList<String> getNotesDetails() throws Exception
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			con		=	ConnectionManager.getConnection(getJdbcProps());
			//IN050800 Start.
			//String query = "select ROUND(((SELECT SUM(ROUND (  (DBMS_LOB.getlength (notes_section_content))/ 1024,4)) FROM ca_encntr_note_section WHERE facility_id = a.facility_id AND accession_num = a.accession_num GROUP BY facility_id, accession_num) -  (ROUND ((DBMS_LOB.getlength (note_content)) / 1024, 4)) ) *100  / (SELECT SUM(ROUND (  (DBMS_LOB.getlength (notes_section_content))/ 1024,4)) FROM ca_encntr_note_section WHERE facility_id = a.facility_id AND accession_num = a.accession_num GROUP BY facility_id, accession_num) ) percentage, accession_num, contr_mod_accession_num, patient_id, encounter_id, am_get_desc.am_practitioner(performed_by_id, ?, '1')  practitioner_name, nvl((select distinct addendum_status from ca_encntr_note_addendum where accession_num = ?),'O') addndm_status, added_Date, to_char((modified_date+1/86400),'mm/dd/yyyy hh24:mi:ss') modified_Date from ca_encntr_note a where accession_num = ?";
			String query = "select ROUND(((SELECT SUM(ROUND (  (DBMS_LOB.getlength (notes_section_content))/ 1024,4)) FROM ca_encntr_note_section WHERE facility_id = a.facility_id AND accession_num = a.accession_num GROUP BY facility_id, accession_num) -  (ROUND ((DBMS_LOB.getlength (note_content)) / 1024, 4)) ) *100  / (SELECT SUM(ROUND (  (DBMS_LOB.getlength (notes_section_content))/ 1024,4)) FROM ca_encntr_note_section WHERE facility_id = a.facility_id AND accession_num = a.accession_num GROUP BY facility_id, accession_num) ) percentage, accession_num, contr_mod_accession_num, patient_id, encounter_id, am_get_desc.am_practitioner(performed_by_id, ?, '1')  practitioner_name, nvl((select distinct addendum_status from ca_encntr_note_addendum where accession_num = ? and rownum=1),'O') addndm_status, added_Date, to_char((modified_date+1/86400),'mm/dd/yyyy hh24:mi:ss') modified_Date from ca_encntr_note a where accession_num = ?";
			//IN050800 End.
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, getLocale());
			pstmt.setString(2, getAccessionNum());
			pstmt.setString(3, getAccessionNum());
			rs = pstmt.executeQuery();
			if(rs.next()){
				arrayList.add(rs.getString(1)==null?"0":(String)rs.getString(1));
				arrayList.add(rs.getString(2)==null?"":(String)rs.getString(2));
				arrayList.add(rs.getString(3)==null?"":(String)rs.getString(3));
				arrayList.add(rs.getString(4)==null?"":(String)rs.getString(4));
				arrayList.add(rs.getString(5)==null?"":(String)rs.getString(5));
				arrayList.add(rs.getString(6)==null?"":(String)rs.getString(6));
				arrayList.add(rs.getString(7)==null?"":(String)rs.getString(7));
				arrayList.add(rs.getString(8)==null?"":(String)rs.getString(8));
				arrayList.add(rs.getString(9)==null?"":(String)rs.getString(9));
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con!=null) con.close();
		}
		
		return arrayList;
	}
	private String getOutputExistYN(String secHdgCode,Connection con) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sectionContent = "";
		try{
			String query = "select OUTPUT_FORM_EXISTS_YN  from CA_SECTION_HDG where sec_hdg_code=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, secHdgCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sectionContent = rs.getString("OUTPUT_FORM_EXISTS_YN");
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();			
		}
		
		return sectionContent;
	}
private String getHeaderSectionContent(String section_Code,Connection con) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sectionContent = "";
		try{
			String query = "select template_format from CA_SECTION_HDG where sec_hdg_code=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, section_Code);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sectionContent = rs.getString("template_format");
			}
			
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		
		return sectionContent;
	}
	private String getSectionContent(String accessionNum,String sectionCode,String subsectionCode,Connection con) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sectionContent = "";
		try{
			String query = "select notes_section_content from ca_encntr_note_section where accession_num=? and sec_hdg_code=? and subsec_hdg_code=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, accessionNum);
			pstmt.setString(2, sectionCode);
			pstmt.setString(3, subsectionCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sectionContent = rs.getString("notes_section_content");
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		
		return sectionContent;
	}
	//IN070860 Start.
	private String getSectionImageContent(String accessionNum,String sectionCode,String subsectionCode,Connection con) throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sectionImageContent = "";
		try{
			String query = "select img_content from ca_encntr_note_section_obj where accession_num=? and sec_hdg_code=? and subsec_hdg_code=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, accessionNum);
			pstmt.setString(2, sectionCode);
			pstmt.setString(3, subsectionCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sectionImageContent = rs.getString("img_content");
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		
		return sectionImageContent;
	}
	//IN070860 End.
	private String getSectionContentOutputYN(String accessionNum,String sectionCode,String subsectionCode,String patient_class,Connection con)throws Exception{
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sectionContent = "";
//		Hashtable<String,String> htParameters=new Hashtable<String,String>();
		Hashtable<String,String> htPatdetails=new Hashtable<String,String>();
		StringBuffer newSB = new StringBuffer();
		StringBuffer sbOutFormat = new StringBuffer();
		try{
			String query = "select notes_section_content from ca_encntr_note_section where accession_num=? and sec_hdg_code=? and subsec_hdg_code=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, accessionNum);
			pstmt.setString(2, sectionCode);
			pstmt.setString(3, subsectionCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				sectionContent = rs.getString("notes_section_content");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();						
			
			if(!"".equals(sectionContent)){
				eCA.DomParser dm = new eCA.DomParser();
				
				/*IN066793 starts*/
				boolean sitespecific=false;
				try
				{
					eCommon.Common.CommonBean bean = new eCommon.Common.CommonBean();
					sitespecific=bean.isSiteSpecific(con, "CA", "BURMESE_LANGUAGE_FONT");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				String xslURL="";
				if(sitespecific)
					 xslURL = getXSLFileContextReference()+"eCA/html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
				else
					 xslURL = getXSLFileContextReference()+"eCA/html/RecClinicalNotesTemplateDispayView.xsl";
				/*IN066793 ends*/
				
				StringBuffer sb = new StringBuffer();
				sb.append(sectionContent); 
				
	//			htParameters = dm.updateOutHtParamValues(sb, htParameters, (String)getLocale(), xslURL);
				
				String output_format_qry ="select OUTPUT_XML_FORMAT from  CA_SEC_OUTPUT_FORM b where b.SEC_HDG_CODE =?" ;
				pstmt=	con.prepareStatement(output_format_qry);
				pstmt.setString(1,sectionCode);	
				
				rs	= pstmt.executeQuery();	
				
				if(rs.next())
				{
					
					Clob clb1 = rs.getClob("OUTPUT_XML_FORMAT");				
				
					if(clb1!=null)
					{
						java.io.BufferedReader r = new java.io.BufferedReader(clb1.getCharacterStream());
						String line = null;
						
						while((line=r.readLine()) != null) 
						{
							newSB.append(line);
						}
					}
				}
				
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				
				htPatdetails=getPatientDetails(locale,getFacilityId(),patient_class,encounterId,getPatientId(),con);
				
				htPatdetails.putAll(getXMLPrametersDetails(sb));
				/*Set set = htPatdetails.entrySet();
				Iterator it = set.iterator();
				while (it.hasNext()) {
				  Map.Entry entry = (Map.Entry) it.next();
				  
				}*/
				sbOutFormat = dm.updateXMLOutContentValues(sb,newSB,htPatdetails,locale,xslURL);
				
			}	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();
		}
		System.out.println("I out in getSectionContentOutputYN....");
		return sbOutFormat.toString();
	}
	private String replaceNewLine(String input)
	{
		/* [IN032064] Start
		if(input.indexOf(" ")!=-1)
			input = input.replaceAll(" ","&nbsp;");
		
		[IN032064] End */
		//input = input.replaceAll("\n","<br>");  [IN032683]
		//input = input.replaceAll("<ADDRESS>",""); 
		//input = input.replaceAll("</ADDRESS>",""); 
		return input;
	}
	private String replaceSpecialChars(String input)
	{
		if( !input.equals("") )
		{
			if (input.indexOf("&") != -1) input = input.replaceAll("&","&amp;");
			if (input.indexOf("<") != -1) input = input.replaceAll("<","&lt;");
			if (input.indexOf(">") != -1) input = input.replaceAll(">","&gt;");				
		}

		return input;
	}	
	public boolean caReBuildNotes() throws SQLException
	{ 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;//7605
		ResultSet rs1 = null;//7605

		Hashtable<String,String> htParameter=new Hashtable<String,String>();
		eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
		
		webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
		converter.setXSLFileContextReference((String)getXSLFileContextReference());
		webbeans.eCA.RecClinicalNotesSectionBean sectionBean = new webbeans.eCA.RecClinicalNotesSectionBean();
				
		String locale =getLocale();
		
		if(locale.equals("") )
			locale ="en";

		StringBuffer noteContent = new StringBuffer();
		StringBuffer sectionContentUpdatedXML=new StringBuffer();

		String image_linked_yn			= "";
		String sectionContentType		= "";
		String headerSection 			= "";
		String prevHeaderSection 		= "";
		String subSecHdg 				= "";
		String childSectionContentType  = "";
		String secHdgCode				= "";
		String subSecHdgCode			= "";
		String sectionContent			= "";
		String sectionContentTemp		= ""; 
		String section_image_content	= "";
		String preserve_format_yn		= "";
		String note_type 				= "";
		String section_content 			= "";
		String note_header_code 		= "";
		String doc_ref_id 				= "";
		String event_date_time 			= "";
		String note_title 				= "";
		String output_yn 				= "";		
		String med_service 				= "";
		String performing_phy_name 		= "";
		String record_mode 				= "";
		String clinician_name 			= "";
		String practitioner_name 		= ""; 		
		String patient_class			= "";
		String note_status				= "";
		String note_type_desc			= "";
		String noteCopiedYN				= "";//IN068105
		String speciality_name="",location_code="",gender="";//IN072879
		String prev_note_type_desc="";//IN073100
		String display_note_description="";//7605
		String compressNoteContentYN = "N"; //6484
		try
		{
			con		=	ConnectionManager.getConnection(getJdbcProps());
			record_mode				=	getRecordMode();
			clinician_name			=	getClinicianName();
			//7605 STARTS
			String disp_noteDesc ="select DISP_NOTE_DESC,COMPRESS_NOTE_CONTENT_YN from ca_note_param";
			
			pstmt1	= con.prepareStatement(disp_noteDesc);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){	
				display_note_description   = rs1.getString("DISP_NOTE_DESC")==null?"":rs1.getString("DISP_NOTE_DESC");
				compressNoteContentYN   = rs1.getString("COMPRESS_NOTE_CONTENT_YN")==null?"N":rs1.getString("COMPRESS_NOTE_CONTENT_YN");
			}//Exception-PMG2020-COMN-CRF-0085 7605 ends
			System.out.println("ReBuildClinicalNotes.java--------------compressNoteContentYN----->"+compressNoteContentYN);
			if (rs1 != null)	rs1.close();
			if (pstmt1 != null)pstmt1.close();
			//String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service,PATIENT_CLASS,decode(event_status,'1','InProgress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified','9','InError ') event_status FROM Ca_encntr_note a WHERE  /*a.facility_id = ? AND */ a.Accession_num = ?";//Commented for IN068105
			String qry0 = "SELECT a.NOTE_TYPE,a.DOC_REF_ID,to_char(a.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME,a.Event_title_desc note_title ,am_get_desc.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,1) performing_phy_name,am_get_desc.AM_SERVICE(a.SERVICE_CODE,?,2) med_service,PATIENT_CLASS,decode(event_status,'1','InProgress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified','9','InError ') event_status,a.NOTES_COPIED_YN FROM Ca_encntr_note a WHERE  /*a.facility_id = ? AND */ a.Accession_num = ?";//Modified for IN068105
			
			try
			{
				pstmt = con.prepareStatement(qry0);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,getAccessionNum()); 
				
				rs = pstmt.executeQuery();	
				
				if(rs.next())
				{					
					note_type = rs.getString("NOTE_TYPE")==null?"":rs.getString("NOTE_TYPE");
					doc_ref_id = rs.getString("DOC_REF_ID")==null?"":rs.getString("DOC_REF_ID");
					event_date_time = rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
					note_title = rs.getString("note_title")==null?"":rs.getString("note_title");
					performing_phy_name = rs.getString("performing_phy_name")==null?"":rs.getString("performing_phy_name");
					med_service = rs.getString("med_service")==null?"":rs.getString("med_service");	
					patient_class = rs.getString("patient_class")==null?"":rs.getString("patient_class");
					note_status = rs.getString("event_status")==null?"":rs.getString("event_status");
					noteCopiedYN = rs.getString("NOTES_COPIED_YN")==null?"":rs.getString("NOTES_COPIED_YN");//IN068105
				}	
				
			}catch (Exception eeF1){
				eeF1.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20 : "+eeF1);
				return false;
			}finally{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			}
			//IN072879 starts
			try
			{
				String pat_details ="SELECT sex gender,CASE WHEN ? IN ('IP', 'DC') THEN ip_get_desc.ip_nursing_unit (?,(SELECT pat_curr_locn_code FROM pr_encounter WHERE encounter_id = ?),?,'1')ELSE op_get_desc.op_clinic (?, (SELECT pat_curr_locn_code FROM pr_encounter WHERE encounter_id = ?), ?, '1') END locn_desc, AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') speciality_name FROM PR_ENCOUNTER A,mp_patient B WHERE  A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
				
				pstmt	= con.prepareStatement(pat_details);
				pstmt.setString(1,patient_class);
				pstmt.setString(2,getFacilityId());
				pstmt.setString(3,getEncounterId());
				pstmt.setString(4,locale);
				pstmt.setString(5,getFacilityId());
				pstmt.setString(6,getEncounterId());
				pstmt.setString(7,locale);
				pstmt.setString(8,locale);
				pstmt.setString(9,getEncounterId());
				rs = pstmt.executeQuery();
				while(rs.next()){
					location_code = rs.getString("locn_desc")==null?"":rs.getString("locn_desc");		
					speciality_name   = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");
					gender= rs.getString("gender")==null?"":rs.getString("gender");
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}finally{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}			
			//IN072879 ends
			if(!note_type.equals(""))
			{
				try
				{
					String head_foot_qry ="select a.NOTE_TYPE_DESC,a.NOTE_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
					
					pstmt	= con.prepareStatement(head_foot_qry);
					pstmt.setString(1,note_type);
					rs = pstmt.executeQuery();
					while(rs.next()){
						note_header_code = rs.getString("NOTE_HEADER_CODE")==null?"":rs.getString("NOTE_HEADER_CODE");		
						note_type_desc   = rs.getString("NOTE_TYPE_DESC")==null?"":rs.getString("NOTE_TYPE_DESC");
					}
				}catch(Exception ee){
					ee.printStackTrace();
				}finally{
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
				}				
			}
			
			if(!note_header_code.equals("")){
				//-----section_content = checkForNull( (String) sectionBean.getSectionContent(note_header_code,note_header_code), "&nbsp;" );
				section_content = checkForNull( (String) getHeaderSectionContent(note_header_code,con), "&nbsp;" );
			}
			if(!event_date_time.equals("")){
				event_date_time				=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);
			}

			
			StringBuffer section_content_new = new StringBuffer(section_content);
		
			htParameter.put("V$DOC_REF_NH", doc_ref_id);
			htParameter.put("V$PR_DATE", event_date_time);
			htParameter.put("V$NT_TITLE", note_title);
			htParameter.put("V$PR_BY_PRACT", performing_phy_name);
			htParameter.put("V$NT_MEDSRV", med_service);
			htParameter.put("V$NT_STATUS", note_status);
			htParameter.put("V$SEX", gender);//IN072879
			htParameter.put("V$PT_LOCN", location_code); //IN072879
			htParameter.put("V$PT_SPLTY", speciality_name);//IN072879
			htParameter.put("V$NT_TYPE", note_type_desc);
		
			
			if((!section_content_new.toString().equals("&nbsp;")) && (!section_content_new.toString().equals(""))){					
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap<String,String> paramHash=new HashMap<String,String>();
				Hashtable<String,String> tempParameter=new Hashtable<String,String>();
				paramHash.put("#p_patient_id#",getPatientId());
				paramHash.put("#p_encounter_id#",getEncounterId());
				paramHash.put("#p_accNum#",getAccessionNum());
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_eventDate#",event_date_time); //IN039562
				paramHash.put("#p_facility_id#",getFacilityId());//IN038439
				paramHash.put("#p_contr_mod_accession_num#",getContrModAccessionNum()); 
				System.out.println("------------->"+getContrModAccessionNum());
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0){					
					htParameter.putAll(tempParameter);
				}				
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}
			if((!(section_content.equals("&nbsp;"))) && (!(section_content.equals("")))){
				/*IN066793 starts*/
				boolean sitespecific=false;
				try
				{
					eCommon.Common.CommonBean bean = new eCommon.Common.CommonBean();
					sitespecific=bean.isSiteSpecific(con, "CA", "BURMESE_LANGUAGE_FONT");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				if(sitespecific)
					section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView_Burmese.xsl");
				else
					section_content=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
				/*IN066793 ends*/
			}		
			noteContent.append("<HTML><HEAD><TITLE></TITLE> </HEAD><BODY><table border='1' cellpadding='0' cellspacing='0' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'>");
			noteContent.append(section_content);
			noteContent.append("</table><br>");

			String qry1 = "SELECT (SELECT CHILD_SEQ_NUM FROM CA_SUBSECTION_LINK D WHERE D.HEADER_SEC_HDG_CODE=A.SEC_HDG_CODE AND D.CHILD_SEC_HDG_CODE=A.SUBSEC_HDG_CODE )   CHILD_SEQ_NUM, REPLACE(HDR.SEC_HDG_DESC,'''','') HEADER_SECTION, REPLACE(NVL(DTL.SEC_HDG_DESC,HDR.SEC_HDG_DESC),'''','') SUB_SEC_HDG, HDR.CONTENT_TYPE SECTION_CONTENT_TYPE, DTL.CONTENT_TYPE CHILD_SECTION_CONTENT_TYPE,A.SEC_HDG_CODE,A.SUBSEC_HDG_CODE, DTL.IMAGE_LINKED_YN, NVL(DTL.PRESERVE_FORMAT_YN, HDR.PRESERVE_FORMAT_YN) PRESERVE_FORMAT_YN,to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=(NVL (a.modified_by_id, a.added_by_id))),?,'1') PRACTITIONER_NAME FROM  CA_ENCNTR_NOTE_SECTION A ,CA_SECTION_HDG_LANG_VW HDR ,CA_SECTION_HDG_LANG_VW DTL  WHERE   A.SEC_HDG_CODE = HDR.SEC_HDG_CODE AND A.SUBSEC_HDG_CODE = DTL.SEC_HDG_CODE(+) AND A.ACCESSION_NUM = ? AND A.NOTES_SECTION_CONTENT IS NOT NULL AND HDR.LANGUAGE_ID = ? AND DTL.LANGUAGE_ID(+) = ?  ORDER BY NOTE_SEC_SEQ_NUM ,CHILD_SEQ_NUM";
			
			try{
				pstmt = con.prepareStatement(qry1);
				pstmt.setString(1,locale);
				pstmt.setString(2,getAccessionNum());
				pstmt.setString(3,locale);
				pstmt.setString(4,locale);
				
				rs = pstmt.executeQuery();
				String sys_date_time = "";
				while(rs.next()){
					sectionContent			=	"";
					section_image_content	=	"";

					preserve_format_yn		= rs.getString("PRESERVE_FORMAT_YN");
					//noteContent.append("<table border=0 cellspacing=0 width=\"100%\" style=\"font-family:Verdana\" >");
					noteContent.append("<table border=\"0\" cellspacing=\"0\" width=\"100%\" style=\"font-family:Verdana\" >");
					headerSection			= rs.getString("Header_section")==null?"":rs.getString("Header_section");
					subSecHdg				= rs.getString("sub_sec_hdg")==null?"":rs.getString("sub_sec_hdg");
					sectionContentType		= rs.getString("section_content_type")==null?"":rs.getString("section_content_type");
					childSectionContentType = rs.getString("child_section_content_type")==null?"":rs.getString("child_section_content_type");
					secHdgCode				= rs.getString("sec_hdg_code")==null?"":rs.getString("sec_hdg_code");
					subSecHdgCode			= rs.getString("subsec_hdg_code")==null?"":rs.getString("subsec_hdg_code");
					image_linked_yn			= rs.getString("image_linked_yn")==null?"":rs.getString("image_linked_yn");
					sys_date_time = rs.getString("sys_date_time")==null?"":rs.getString("sys_date_time");//IN033677
					practitioner_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");//[IN038614]
					
					if(!record_mode.equals("SignAddendum") && !record_mode.equals("RecordAddendum")){ //IN038848
						if(display_note_description.equals("Y")){//7605
						if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
							noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr><br>");//IN071865
							 prev_note_type_desc=note_type_desc;//IN073100
						}//7605
						}
						if(!headerSection.equals(subSecHdg)){
							if(!prevHeaderSection.equals(headerSection)){
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
								prevHeaderSection = headerSection;
							}
							noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");
						}else{						
							noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
						}
					} 
					//output_yn = sectionBean.getOutputExistYN(secHdgCode,subSecHdgCode);
					output_yn = getOutputExistYN(secHdgCode,con);
					
					if(output_yn.equals("Y")){
						
					//	sectionContent = checkForNull((String)sectionBean.getSectionContent(secHdgCode_out,subSecHdgCode_out),"&nbsp;");	
						sectionContent = checkForNull((String)getSectionContentOutputYN(getAccessionNum(),secHdgCode,subSecHdgCode,patient_class,con),"&nbsp;");
						sectionContentTemp = sectionContent;
						sectionContentTemp = sectionContentTemp.replaceAll("<ADDRESS>","");
						sectionContentTemp = sectionContentTemp.replaceAll("</ADDRESS>","");
						sectionContentTemp = sectionContentTemp.trim();		
					}else{
						
					//	sectionContent = checkForNull((String)sectionBean.getSectionContent(secHdgCode,subSecHdgCode),"&nbsp;");+
						sectionContent = checkForNull((String)getSectionContent(getAccessionNum(),secHdgCode,subSecHdgCode,con),"&nbsp;");
						
						sectionContentTemp = sectionContent;
						sectionContentTemp = sectionContentTemp.replaceAll("<ADDRESS>","");
						sectionContentTemp = sectionContentTemp.replaceAll("</ADDRESS>","");
						sectionContentTemp = sectionContentTemp.trim(); 						
					}
					if(record_mode.equals("SignAddendum")){
						String content_type = (String) sectionBean.getSectionType( secHdgCode, subSecHdgCode);
						String ammend_text = (String) sectionBean.getAddendumText( secHdgCode, subSecHdgCode);	
						String ammend_text_temp = "";
						if(!"".equals(ammend_text) && ammend_text!=null)
							ammend_text_temp = ammend_text.trim();
						ammend_text_temp = ammend_text_temp.replaceAll("<ADDRESS>","");
						ammend_text_temp = ammend_text_temp.replaceAll("</ADDRESS>","");
						
						if(!ammend_text_temp.equals("") && !ammend_text_temp.equals("&nbsp;")) {	
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr><br>");//IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
									prevHeaderSection = headerSection;
								}
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");
							}else{
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
							}
							
							if (content_type.equals("T")){
								if( !sectionContent.equals("") )
									sectionContent = sectionContent.substring(0,sectionContent.indexOf("</USER-TEMPLATE>"));

								sectionContent +="<USER-TEMPLATE-ADDENDUM CREATED-BY='"+replaceSpecialChars(clinician_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM>";
								sectionContent+="</USER-TEMPLATE>";
							}else{								
								sectionContent +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I><B>Addendum Created By :</B>"+replaceSpecialChars(clinician_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
							}
						}else if(!sectionContentTemp.equals("") && !sectionContentTemp.equals("&nbsp;")){ 
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr><br>");//IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
									prevHeaderSection = headerSection;
								}
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");
							}else{
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
							}						
						}						
					}else if(record_mode.equals("RecordAddendum")){
						String content_type = (String) sectionBean.getSectionType( secHdgCode, subSecHdgCode);
						String ammend_text = (String) sectionBean.getAddendumText( secHdgCode, subSecHdgCode);
						String ammend_text_temp = "";
						if(!"".equals(ammend_text) && ammend_text!=null)
							ammend_text_temp = ammend_text.trim();
						ammend_text_temp = ammend_text_temp.replaceAll("<ADDRESS>","");
						ammend_text_temp = ammend_text_temp.replaceAll("</ADDRESS>","");						
						if(!ammend_text_temp.equals("") && !ammend_text_temp.equals("&nbsp;")) {
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr><br>");//IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
									prevHeaderSection = headerSection;
								}
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");
							}else{
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
							}
							
							if (content_type.equals("T")){
								if( !sectionContent.equals("") )
									sectionContent = sectionContent.substring(0,sectionContent.indexOf("</USER-TEMPLATE>"));
								
								sectionContent +="<USER-TEMPLATE-ADDENDUM-RECORDED RECORDED-BY='"+replaceSpecialChars(practitioner_name)+"' DATE='"+sys_date_time+"'><![CDATA["+(ammend_text)+"]]></USER-TEMPLATE-ADDENDUM-RECORDED>";
								
								sectionContent+="</USER-TEMPLATE>";
							}else{
								sectionContent +="<table border=0 cellspacing=0 width='100%'><tr><td><table border=0 cellspacing=0 width='100%' ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\"><I><B>Addendum Recorded By :</B> "+replaceSpecialChars(practitioner_name)+", Date/Time: "+sys_date_time+"</I></td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\">"+replaceNewLine(ammend_text)+"</td></tr></table></td></tr><tr><td>&nbsp;</td></tr></table>";
							}
						}else if(!sectionContentTemp.equals("") && !sectionContentTemp.equals("&nbsp;")){
							if(display_note_description.equals("Y")){//7605
							if(prev_note_type_desc.equals("") || !prev_note_type_desc.equals(note_type_desc)){//IN073100
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+note_type_desc+"</u></font></td></tr><br>");//IN071865
								 prev_note_type_desc=note_type_desc;//IN073100
							}//7605
							}
							if(!headerSection.equals(subSecHdg)){
								if(!prevHeaderSection.equals(headerSection)){
									noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:14pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
									prevHeaderSection = headerSection;
								}
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u><i>"+subSecHdg+"</i></u></font></td></tr>");
							}else{
								noteContent.append("<tr><td style=\"background-color:#ADADAD;\" colspan=\"3\"><font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>"+headerSection+"</u></font></td></tr>");
							}						
						}						
					} 
					
					if(sectionContentType.equals("T") || childSectionContentType.equals("T")){
						if(!(sectionContent.equals("&nbsp;"))){
							if(output_yn.equals("Y")){
								sectionContent=converter.buildHTMLFromXML(sectionContent,"eCA/html/RecClinicalNotesOutputFormDisplay.xsl");
								sectionContent = sectionContent.replaceAll("&lt;","<"); 
								sectionContent = sectionContent.replaceAll("&gt;",">");
								sectionContent = sectionContent.replaceAll("&amp;","&");
								noteContent.append("<TR><TD colspan=\"3\">");
								noteContent.append(sectionContent);
							}else{
								/*IN066793 starts*/
								boolean sitespecific=false;
								try
								{
									eCommon.Common.CommonBean bean = new eCommon.Common.CommonBean();
									sitespecific=bean.isSiteSpecific(con, "CA", "BURMESE_LANGUAGE_FONT");
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								
								String displayview="";
								String sentenceview="";
								if(sitespecific)
								{	
									displayview="eCA/html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
									sentenceview="eCA/html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
								}	
								else
								{	
									displayview="eCA/html/RecClinicalNotesTemplateDispayView.xsl";
									sentenceview="eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
								}
								/*IN066793 ends*/
								sectionContent=converter.buildHTMLFromXML(sectionContent,(preserve_format_yn.equals("Y")?displayview:sentenceview));
								noteContent.append("<TR><TD>");
								noteContent.append(sectionContent);
							}														
						}						
					}else{
						if(image_linked_yn.equals("Y")){
							//IN070860 Start.
							//section_image_content = (java.lang.String) sectionBean.getSectionImageContent( secHdgCode,subSecHdgCode );
							section_image_content = checkForNull((String)getSectionImageContent(getAccessionNum(),secHdgCode,subSecHdgCode,con),"&nbsp;");
							//IN070860 End.
							if(section_image_content == null)
								section_image_content = "";

							if( (sectionContent.equals("&nbsp;") || sectionContent.equals("") )&& !(section_image_content.equals("")) )
								sectionContent = "<ADDRESS>Refer below image</ADDRESS>";
							noteContent.append("<TR><TD colspan=\"3\">");
								noteContent.append(sectionContent);
							noteContent.append("</TD></TR>");
							if(!(section_image_content.equals("") )){
								noteContent.append("<TR><TD colspan=\"3\"><applet code=\"Drawing.class\" codebase=\"../../eCA/MediPainter/\" archive=\"medipainterapplet.jar\" width=\"845\" height=\"400\" align=\"baseline\">");
								noteContent.append("<param name=\"canDraw\" value=\"0\">");
								noteContent.append("<param name=\"image\" value=\"" + section_image_content + "\">");
								noteContent.append("</applet></TD></TR>");
							}
						}else{
						    noteContent.append("<TR><TD colspan=\"3\">");
							noteContent.append(sectionContent);
							noteContent.append("</TD></TR>");
						}
					}
					noteContent.append("</TD></TR>");
					noteContent.append("</table>");				
					sectionContent = "";
					section_image_content = "";		
				}
			}catch (Exception eeF2){
				eeF2.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-1: "+eeF2);
				return false;
			}finally{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			}
			/*************************************************************************/
			//Taking the addendum text from addendum tabel for the note and appending it to the last
			//IN067862 Start.
			//String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(NVL(a.MODIFIED_PRACT_ID,a.practitioner_id),?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,a.ADDENDUM_STATUS from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID /*and FACILITY_ID =? */ and ACCESSION_NUM =? and SEC_HDG_CODE='*AmmendNotes*' order by srl_no "; 
			String addendumSql = "select ADDENDUM_TEXT, AM_GET_DESC.AM_PRACTITIONER(NVL(a.MODIFIED_PRACT_ID,a.practitioner_id),?,'1') PRACTITIONER_NAME,RESP_NAME,to_char(a.MODIFIED_DATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time,a.ADDENDUM_STATUS,a.ADDENDUM_CLOB,a.ADDENDUM_STORAGE_TYPE from ca_encntr_note_addendum a,am_practitioner b,sm_resp c where a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID  and ACCESSION_NUM =? and SEC_HDG_CODE='*AmmendNotes*' order by srl_no ";
			//IN067862 End.
			try{
				pstmt = con.prepareStatement(addendumSql);				
				pstmt.setString(1,locale);
				pstmt.setString(2,getAccessionNum());
				rs= pstmt.executeQuery();
				while(rs.next()){
					noteContent.append("<table border=0 cellspacing=0 width=\"100%\" style=\"font-family:Verdana;font-size:9pt;\" >");
					noteContent.append("<TR><TD COLSPAN=\"3\">");					
					if(rs.getString(1)!=null){
						if("S".equals((String)rs.getString(5))){
							//IN067862 Start.
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							if("CLOB".equals((String)rs.getString(7))){
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(6)==null?"":rs.getString(6))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}else{
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Created By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}
							//IN067862 End.
						}else if("R".equals((String)rs.getString(5))){
							//IN067862 Start.
							//noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							if("CLOB".equals((String)rs.getString(7))){
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(6)==null?"":rs.getString(6))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}else{
								noteContent.append("<table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\" ><tr><td width='100%' COLSPAN=\"3\" style=\"font-family:Verdana;font-size:9pt;\" ><B>Addendum Recorded By :</B> "+rs.getString(2)+", Date/Time: "+com.ehis.util.DateUtils.convertDate(rs.getString(4),"DMYHMS","en",locale)+"</td></tr><tr><td width='100%'><i>"+replaceNewLine(rs.getString(1)==null?"":rs.getString(1))+"</i></td></tr><tr><td>&nbsp;</td></tr></table>");
							}
							//IN067862 End.
						}
					}
					noteContent.append("</TD></TR>");					
					noteContent.append("</table><br>");
				}
			}catch (Exception eeF3){
				eeF3.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-1: "+eeF3);
				return false;
			}finally{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			}			
			/************************************************************************/
			//IN068105 starts
			if("Y".equals(noteCopiedYN))
				noteContent.append("<table border=0 cellspacing=0 width='100%'><tr><td align='right'><span style='background-color: black;color : white'>*COPIED NOTE</span>&nbsp;&nbsp;&nbsp;&nbsp;</td></tr></table>");
			//IN068105 starts
			noteContent.append("</BODY></HTML>");
			
			
			java.sql.Clob clobNotesContent = null;
		//	java.io.Writer notesContentWriter =	null;
			java.io.BufferedWriter	notesContentBufferedWriter	= null;

		////6484 Start.
		/*
			String updateSql = "UPDATE Ca_encntr_note SET Note_content = empty_clob()  WHERE  Accession_num = ? ";
			
			try{
				pstmt = con.prepareStatement(updateSql);
				pstmt.setString(1,getAccessionNum());
				
				pstmt.executeUpdate();
			
			}catch (Exception eeF4){
				con.rollback();
				eeF4.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-3: "+eeF4);
				return false;
			}finally{
				if (pstmt != null)
					pstmt.close();
			}
		
			String selectSql = "select Note_content from Ca_encntr_note where  Accession_num = ? for update";

			try{
				pstmt = con.prepareStatement(selectSql);
				pstmt.setString(1,getAccessionNum());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){	
					clobNotesContent	= (java.sql.Clob) rs.getClob("Note_content");
					notesContentBufferedWriter = new java.io.BufferedWriter(clobNotesContent.setCharacterStream(0));				
					notesContentBufferedWriter.write(noteContent.toString(),0,noteContent.length());	
				//	notesContentBufferedWriter.write(sb.toString(),0,sb.length());					
					notesContentBufferedWriter.flush();
					notesContentBufferedWriter.close();
					
					
				}
			}catch (Exception eeF5){
				con.rollback();
				eeF5.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-4: "+eeF5);				
				return false;
			}finally{
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			}
			
			String updateModifiedDateSql = "update ca_encntr_note set modified_date =to_date(?,'mm/dd/yyyy hh24:mi:ss')  where accession_num= ?";
			
			try{
				pstmt = con.prepareStatement(updateModifiedDateSql);
				pstmt.setString(1,getModifiedDate());
				pstmt.setString(2,getAccessionNum());
				pstmt.executeUpdate();
				
			}catch (Exception eeF4){				
				con.rollback();
				eeF4.printStackTrace();
				sb.append("<br>Exception@Ejb - recordCN-20-3: "+eeF4);
				return false;
			}finally{
				if (pstmt != null)
					pstmt.close();
			}
			*/
				
			String catageroyId ="";
			if(!"".equals(getContrModAccessionNum()) && (getContrModAccessionNum()!=null))
				catageroyId= fetchOrderCatageroyId(con,getFacilityId(),getEncounterId(),getPatientId(),getContrModAccessionNum());
			
			
			if("Y".equals(compressNoteContentYN) && !"OT".equals(catageroyId) && !"LB".equals(catageroyId) && !"RD".equals(catageroyId)){
				
				String updateSql1 = "UPDATE Ca_encntr_note SET COMPRESS_NOTE_CONTENT_YN =?, NOTE_CONTENT = empty_clob(), COMPRESS_NOTE_CONTENT = ?, modified_date =to_date(?,'mm/dd/yyyy hh24:mi:ss')   WHERE Accession_num = ? ";
				try{
					pstmt = con.prepareStatement(updateSql1);
					pstmt.setString(1,"Y");
					pstmt.setBytes(2, compress(noteContent.toString()));
					pstmt.setString(3,getModifiedDate());
					pstmt.setString(4,getAccessionNum());
					pstmt.executeUpdate();
					
				}catch (Exception eeF4){				
					con.rollback();
					eeF4.printStackTrace();
					sb.append("<br>ReBuildClinicalNotes.java - recordCN-20-3: "+eeF4);
					return false;
				}finally{
					if (pstmt != null)
						pstmt.close();
				}
			}else{
				
				String updateSql1 = "UPDATE Ca_encntr_note SET COMPRESS_NOTE_CONTENT_YN =?, NOTE_CONTENT = ?, COMPRESS_NOTE_CONTENT = null, modified_date =to_date(?,'mm/dd/yyyy hh24:mi:ss')   WHERE Accession_num = ? ";
				try{
					pstmt = con.prepareStatement(updateSql1);
					Clob clobContent = stringToClob(noteContent.toString(), con);					
					pstmt.setString(1,"N");
					pstmt.setClob(2, clobContent);
					pstmt.setString(3,getModifiedDate());
					pstmt.setString(4,getAccessionNum());
					pstmt.executeUpdate();
					
				}catch (Exception eeF4){				
					con.rollback();
					eeF4.printStackTrace();
					sb.append("<br>ReBuildClinicalNotes.java - recordCN-20-3: "+eeF4);
					return false;
				}finally{
					if (pstmt != null)
						pstmt.close();
				}
			}
			////6484 End.
			con.commit();
			return true;			
		}catch(TransformerConfigurationException etc){
			con.rollback();
			return false;
		}catch(TransformerException etx){
			con.rollback();
			return false;
		}catch(FileNotFoundException efn){
			con.rollback();
			return false;
		}catch(IOException eio){
			con.rollback();
			return false;		
		}catch(Exception e){
			con.rollback();
			e.printStackTrace();
			return false;
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();				
			}
			converter = null;
			noteContent = null;
			sectionContentType = null; 
			headerSection = null;
			prevHeaderSection = null;
			subSecHdg = null;
			childSectionContentType = null;
			sectionContent = null;
			image_linked_yn			= null;		sectionContentType		= null;		headerSection 			= null;		prevHeaderSection 		= null;
			subSecHdg 				= null;		childSectionContentType	= null;		secHdgCode				= null;		subSecHdgCode			= null;
			sectionContent			= null;		sectionContentTemp		= null;		section_image_content	= null;		preserve_format_yn		= null;
			note_type 				= null;		section_content 		= null;		note_header_code 		= null;		doc_ref_id 				= null;
			event_date_time 		= null;		note_title 				= null;		output_yn 				= null;		med_service 			= null;		
			performing_phy_name 	= null;		record_mode				= null;		clinician_name 			= null;		practitioner_name 		= null;		
			patient_class			= null;		note_status				= null;		note_type_desc			= null; prev_note_type_desc=null;//IN073100
		}
	}
	
	public static String decompress(final byte[] compressed) throws IOException {
        String outStr = "";
        if ((compressed == null) || (compressed.length == 0)) {
            return "";
        }
        if (isCompressed(compressed)) {
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outStr += line;
            }
        } else {
            outStr = new String(compressed);
        }
        return outStr;
    }
	 public static boolean isCompressed(final byte[] compressed) {
	        return (compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8));
	    }
	//TBMC-SCF-0089 Start
	public String getDateBasedOnLocale(String date, String locale,String format) 
	{
	      String returnLocaledate ="";
	     
	      try
				{
	    	      if(!"en".equals(locale))
	    	      {	  
	    	  		
					returnLocaledate  =  com.ehis.util.DateUtils.convertDate(date,format,"en",locale);	
	    	      }
	    	      else{
	    	    	  returnLocaledate = date;
	    	      }
				}
			catch(Exception e)
			{
				System.out.println("Exception  while geting SM_CONVERT_DATE_2T:"+e);
				e.printStackTrace();
			}
	     
		return returnLocaledate;
	}
	//TBMC-SCF-0089 End
	//6484 Start. 
	public CLOB stringToClob(String stringData, Connection dbConn) 
		{
	        CLOB clob = null;
	        try 
			{
	            clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
	            clob.setString(1, stringData);
	        } catch (SQLException sqlException) {
	            System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
	        }
	        return clob;
		}
	public  byte[] compress(final String str) throws IOException {
		if ((str == null) || (str.length() == 0)) {
			return null;
		}
		ByteArrayOutputStream obj = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(obj);
		gzip.write(str.getBytes("UTF-8"));
		gzip.close();
		return obj.toByteArray();
	}
	public String fetchOrderCatageroyId(Connection con,String facilityId,String encounterId,String patientId,String contr_mod_accession_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String orderCategoryId = "";
		
		try 
		{
			StringBuffer sys_qry = new StringBuffer(); 
			
			//sys_qry.append(" SELECT 'LB' order_category FROM RL_REQUEST_DETAIL A WHERE  A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.OPERATING_FACILITY_ID||A.OPERATING_FACILITY_ID||A.SPECIMEN_NO||A.TEST_CODE||A.LINE_NO =? ");
			//sys_qry.append(" UNION ALL ");
			//sys_qry.append(" SELECT 'LB' order_category FROM RL_REQUEST_DETAIL A WHERE  A.OPERATING_FACILITY_ID=? AND A.PATIENT_ID=? AND A.OPERATING_FACILITY_ID||A.SPECIMEN_NO||A.TEST_CODE||A.LINE_NO =? ");
			//sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'RD' order_category FROM  RD_EXAM_VIEW_REQUESTED WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND OPERATING_FACILITY_ID||REQUEST_NUM||REQUEST_LINE_NUM =? ");
			/*
			sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'PRE' like UPPER(?) ");
			sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'INTRA' like UPPER(?) ");
			sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'OT' order_category FROM AT_ANAESTHESIA_RECORD_HDR WHERE OPERATING_FACILITY_ID||ANAESTHESIA_SERIAL_NUM||'POST' like UPPER(?) ");
			sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'OT' order_category FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE||'30' like UPPER(?) ");
			sys_qry.append(" UNION ALL ");
			sys_qry.append(" SELECT 'OT' order_category FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = ? AND ENCOUNTER_ID = ? AND OPERATING_FACILITY_ID||OPER_NUM||SPECIALITY_CODE||'99' like UPPER(?) ");
			*/

			pstmt = con.prepareStatement(sys_qry.toString());
			
			/*
			pstmt.setString(1, facilityId);
			pstmt.setString(2, patientId);
			pstmt.setString(3, contr_mod_accession_num);
			
			pstmt.setString(4, facilityId);
			pstmt.setString(5, patientId);
			pstmt.setString(6, contr_mod_accession_num);
			*/
			
			pstmt.setString(1, facilityId);
			pstmt.setString(2, patientId);
			pstmt.setString(3, contr_mod_accession_num);
		/*	
			pstmt.setString(4, contr_mod_accession_num);
			pstmt.setString(5, contr_mod_accession_num);
			pstmt.setString(6, contr_mod_accession_num);
			
			pstmt.setString(7, facilityId);
			pstmt.setString(8, encounterId);
			pstmt.setString(9, contr_mod_accession_num);
			
			pstmt.setString(10, facilityId);
			pstmt.setString(11, encounterId);
			pstmt.setString(12, contr_mod_accession_num);
		*/	
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				orderCategoryId = rs.getString("order_category") == null ? "": rs.getString("order_category");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{			
			try 
			{
				if(rs!=null)
					rs.close();
					
				if(pstmt!=null)
					pstmt.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return orderCategoryId;
	}
	//6484 End.
}

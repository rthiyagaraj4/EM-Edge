/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import eOR.Common.OrAdapter;

public class CAClinicalNotesAuditTrialReportBean  extends OrAdapter implements Serializable{
	
	/*
	public ArrayList getClinicalNotesAuditTrialReportResult(String locale,String patient_id, String encounter_id, String note_group,String note_type,String pract_id,String fromDate, String toDate,int start, int end) throws Exception {
		
		String autosaveynquery = "";
		Connection				con					= null;
		int index=1;
		ResultSet rs = null;
		ArrayList results = new ArrayList() ;
		String[] record=new String[32];//IN071618
		autosaveynquery  = "SELECT ACCESSION_NUM,ca_get_desc.ca_note_group (EVENT_GROUP, '" + locale +"', '1') note_group_desc,ca_get_desc.CA_NOTE_TYPE (EVENT_CODE, '" + locale +"', '1') note_type_desc,AM_GET_DESC.AM_PRACTITIONER(AUTHORIZED_BY_ID, '" + locale +"', '1') auth_by_name,AM_GET_DESC.AM_PRACTITIONER(PERFORMED_BY_ID, '" + locale +"', '1') perf_by_name,EVENT_DATE,EVENT_GROUP,EVENT_CODE,PERFORMED_BY_ID,AUTHORIZED_BY_ID,AM_GET_DESC.AM_SERVICE(b.service_code,?,'2')  service_name FROM cr_encounter_detail a, CA_ENCNTR_NOTE b where a.ACCESSION_NUM = b.ACCESSION_NUM and PATIENT_ID=? AND ENCOUNTER_ID = ? AND HTML_IMAGE_UPLD_ID IS NULL ##NOTEGROUPFILTER$ ##NOTETYPEFILTER$ ##PRACTFILTER$ ##DATEFILTER$  " ;
		
		if(!"".equals(note_group)){
		
			autosaveynquery = 	autosaveynquery.replace("##NOTEGROUPFILTER$",  " AND EVENT_GROUP = ? ");
		}
		else{
			autosaveynquery = autosaveynquery.replace("##NOTEGROUPFILTER$",  "  ");
		}
		
		if(!"".equals(note_type)){
			autosaveynquery = 	autosaveynquery.replace("##NOTETYPEFILTER$",  " AND EVENT_CODE = ? ");
		}
		else{
			autosaveynquery = autosaveynquery.replace("##NOTETYPEFILTER$",  "  ");
		}
		if(!"".equals(pract_id)){
			autosaveynquery = autosaveynquery.replace("##PRACTFILTER$",  " AND AUTHORIZED_BY_ID = ? ");
		}
		else{
			autosaveynquery = autosaveynquery.replace("##PRACTFILTER$",  " ");
		}
		
		if(!(fromDate.equals("") && !(toDate.equals(""))))
			autosaveynquery = autosaveynquery.replace("##DATEFILTER$", " AND TO_DATE(TO_CHAR(event_date,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')");
		
		
		System.out.println("------autosaveynquery------->"+autosaveynquery);
		PreparedStatement pstmt =  null;
		try {
			con=getConnection();
			pstmt	=	con.prepareStatement(autosaveynquery);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, patient_id);
			pstmt.setString(index++, encounter_id);
			System.out.println("--------------->"+locale);
			System.out.println("--------------->"+patient_id);
			System.out.println("--------------->"+encounter_id);
			if(!"".equals(note_group)){
				pstmt.setString(index++, note_group);
				System.out.println("--------------->"+note_group);
			}
			if(!"".equals(note_type)){
				pstmt.setString(index++, note_type);
				System.out.println("--------------->"+note_type);
			}
			if(!"".equals(pract_id)){
				pstmt.setString(index++, pract_id);
				System.out.println("--------------->"+pract_id);
			}
			if(!(fromDate.equals("") && !(toDate.equals("")))){
				
				pstmt.setString(index++, fromDate);
				pstmt.setString(index++, fromDate);
				System.out.println("--------------->"+fromDate);
				System.out.println("--------------->"+fromDate);
			}
			
				
		rs = pstmt.executeQuery();
		
		if(rs!=null) {
			if(start > 0)
				for(int i=0;(i<start-1 && rs.next());i++);
			
			while ( rs.next()) {
				
				
				record[0] = rs.getString( "EVENT_DATE" )  ;
				record[1] = rs.getString( "EVENT_GROUP" )  ;
				record[2] = rs.getString( "EVENT_CODE" )  ;
				record[3] = "";
				record[4] = rs.getString( "PERFORMED_BY_ID" )  ;
				record[5] = rs.getString( "AUTHORIZED_BY_ID" )  ;
				record[6] = rs.getString( "note_group_desc" )  ;
				record[7] = rs.getString( "note_type_desc" )  ;
				record[8] = rs.getString( "perf_by_name" )  ;
				record[9] = rs.getString( "auth_by_name" )  ;
				record[10] = rs.getString( "ACCESSION_NUM" )  ;
				record[11] = rs.getString( "service_name" )  ;
				
			
				results.add(record);
				start++;
			}
			
			  if (rs.next())
				{
					String[] templist = (String[])results.get(0);
					//templist[29] = ""+(end+7);//IN065942
					templist[11] = ""+(end+7);//IN065942 //IN071618
					results.set(0,templist);
				}
		}
	
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return results;
	} 
	*/
	
	public ArrayList getClinicalNotesAuditTrialReportResult(String locale,String patient_id, String encounter_id, String note_group,String note_type,String pract_id,String fromDate, String toDate,int start, int end) throws Exception {
		
		String queryString 	=	"";
		Connection	con	= null;
		int index=1;
		ResultSet rs = null;
		ArrayList results = new ArrayList() ;
		
		queryString  = "SELECT A.FACILITY_ID, A.ACCESSION_NUM, CA_GET_DESC.CA_NOTE_GROUP(B.NOTE_GROUP_ID, ?, '1') NOTE_GROUP_DESC, CA_GET_DESC.CA_NOTE_TYPE (A.NOTE_TYPE, ?, '1') NOTE_TYPE_DESC,AM_GET_DESC.AM_PRACTITIONER(A.AUTHORIZED_BY_ID, ?, '1') AUTH_BY_NAME,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID, ?, '1') PERF_BY_NAME,TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE,B.NOTE_GROUP_ID EVENT_GROUP,A.NOTE_TYPE EVENT_CODE,A.PERFORMED_BY_ID,A.AUTHORIZED_BY_ID,AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2')  SERVICE_NAME FROM CA_ENCNTR_NOTE A,CA_NOTE_TYPE_LANG_VW B WHERE A.NOTE_TYPE=B.NOTE_TYPE AND B.LANGUAGE_ID=? AND A.PATIENT_ID=? AND A.ENCOUNTER_ID = ?  ##NOTEGROUPFILTER$ ##NOTETYPEFILTER$ ##PRACTFILTER$ ##DATEFILTER$ ORDER BY A.EVENT_DATE_TIME DESC " ;
		
		if(!"".equals(note_group)){
		
			queryString = 	queryString.replace("##NOTEGROUPFILTER$",  " AND B.NOTE_GROUP_ID = ? "); 
		}
		else{
			queryString = queryString.replace("##NOTEGROUPFILTER$",  "  ");
		}
		
		if(!"".equals(note_type)){
			queryString = 	queryString.replace("##NOTETYPEFILTER$",  " AND A.NOTE_TYPE = ? ");
		}
		else{
			queryString = queryString.replace("##NOTETYPEFILTER$",  "  ");
		}
		if(!"".equals(pract_id)){
			queryString = queryString.replace("##PRACTFILTER$",  " AND A.PERFORMED_BY_ID = ? ");
		}
		else{
			queryString = queryString.replace("##PRACTFILTER$",  " "); 
		}
		
		if(!fromDate.equals("") && !toDate.equals("")){
				queryString = queryString.replace("##DATEFILTER$", " AND TO_DATE(TO_CHAR(A.EVENT_DATE_TIME,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy')");
		}
		else if(!fromDate.equals("")){
		 
			queryString = queryString.replace("##DATEFILTER$","AND TO_DATE(TO_CHAR(A.EVENT_DATE_TIME,'dd/mm/yyyy'),'dd/mm/yyyy') >= TO_DATE(NVL((?),'01/01/1000'),'dd/mm/yyyy') ");
		}
		else if(!toDate.equals("")){			
			queryString = queryString.replace("##DATEFILTER$","AND TO_DATE(TO_CHAR(A.EVENT_DATE_TIME,'dd/mm/yyyy'),'dd/mm/yyyy') <= TO_DATE(NVL((?),'31/12/9999'),'dd/mm/yyyy') ");
		}
		else{
			queryString = queryString.replace("##DATEFILTER$","  ");
		
		}
		
		
	
		PreparedStatement pstmt =  null;
		try {
			con=getConnection();
			pstmt	=	con.prepareStatement(queryString);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, patient_id);
			pstmt.setString(index++, encounter_id);
			System.out.println("--------------->"+locale);
			System.out.println("--------------->"+patient_id);
			System.out.println("--------------->"+encounter_id);
			if(!"".equals(note_group)){
				pstmt.setString(index++, note_group);
				System.out.println("--------------->"+note_group);
			}
			if(!"".equals(note_type)){
				pstmt.setString(index++, note_type);
				System.out.println("--------------->"+note_type);
			}
			if(!"".equals(pract_id)){
				pstmt.setString(index++, pract_id);
				System.out.println("--------------->"+pract_id);
			}
			if(!(fromDate.equals("")) && !(toDate.equals(""))){
				
				pstmt.setString(index++, fromDate);
				pstmt.setString(index++, toDate);
				System.out.println("--------------->"+fromDate);
				System.out.println("--------------->"+toDate);
			}else if(!fromDate.equals("")){
				pstmt.setString(index++, fromDate);
			}else if(!toDate.equals("")){
				pstmt.setString(index++, toDate);
			}			
				
			rs = pstmt.executeQuery();
		
			if(rs!=null) {				
				while ( rs.next()) {					
					String[] record=new String[12];
					record[0] = rs.getString( "EVENT_DATE" )  ;
					record[1] = rs.getString( "EVENT_GROUP" )  ;
					record[2] = rs.getString( "EVENT_CODE" )  ;
					record[3] = rs.getString( "SERVICE_NAME" )  ;
					System.out.println("------------->"+rs.getString( "SERVICE_NAME" ));
					record[4] = rs.getString( "PERFORMED_BY_ID" )  ;
					record[5] = rs.getString( "AUTHORIZED_BY_ID" )  ;
					record[6] = rs.getString( "NOTE_GROUP_DESC" )  ;
					System.out.println("------------->"+rs.getString( "NOTE_GROUP_DESC" ));
					record[7] = rs.getString( "NOTE_TYPE_DESC" )  ;
					record[8] = rs.getString( "PERF_BY_NAME" )  ;
					record[9] = rs.getString( "AUTH_BY_NAME" )  ;
					record[10] = rs.getString( "ACCESSION_NUM" )  ;
					record[11] = rs.getString( "FACILITY_ID" )  ;
					results.add(record);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return results;
	}
	public ArrayList getClinicalNotesAuditTrialPreviewDtls(String locale,String acc_num) throws Exception {
	
		String audit_dtls_qry = "";
		Connection				con					= null;
		
		ResultSet rs = null;
		ArrayList results = new ArrayList() ;
		
		
		PreparedStatement pstmt =  null;
		audit_dtls_qry  = "select  a.ADDED_DATE, to_char(a.action_date_time,'dd/mm/yyyy hh24:mi:ss') s_action_date_time, b.practitioner_name clinician_name, a.action_type,  action_status action_desc, dbms_lob.getlength(pre_amendment_note_content) clob_len,a.action_date_time,a.action_comment,d.practitioner_name requested_by_pract,to_char(REQUEST_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') requested_time, a.privilege_type, am_get_desc.AM_SPECIALITY(a.ACTION_BY_GROUP_CODE,?,2) spl_desc from ca_encntr_note_audit_log a, am_practitioner_lang_vw  b ,am_speciality_lang_vw c, am_practitioner_lang_vw d where b.practitioner_id(+) = a.action_by_id and c.speciality_code(+)=a.action_by_group_code and d.practitioner_id(+) = a.REQUEST_BY_ID /*and a.facility_id = ? */and a.accession_num = ?  and  b.language_id = ?  and  d.language_id(+) = ? order by nvl(a.action_date_time,a.ADDED_DATE) desc,action_status desc,action_type desc  " ;
		
		try {
			con=getConnection();
			pstmt				=	con.prepareStatement(audit_dtls_qry);
	
			pstmt.setString( 1,	locale		);
			pstmt.setString( 2,	acc_num	); 
			pstmt.setString( 3,	locale	);
			pstmt.setString( 4,	locale	);
			rs					=	pstmt.executeQuery(); 
			
			if(rs!=null) {
				
				
				while ( rs.next()) {
					String[] record=new String[11];//IN071618
					record[0] = rs.getString("s_action_date_time")==null?"":rs.getString("s_action_date_time");
					record[1] = rs.getString("clinician_name")==null?"":rs.getString("clinician_name");
					record[2] = rs.getString("action_type")==null?"":rs.getString("action_type");
					record[3] = rs.getString("action_desc")==null?"":rs.getString("action_desc");;
					record[4] = rs.getString("action_comment")==null?"&nbsp;":rs.getString("action_comment"); ;
					record[5] = rs.getString("requested_by_pract")==null?"":rs.getString("requested_by_pract");
					record[6] = rs.getString("requested_time")==null?"":rs.getString("requested_time");
					record[7] =rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
					record[8] =	rs.getString("spl_desc")==null?"":rs.getString("spl_desc");
					record[9] = Long.toString((rs.getLong("clob_len")));
					
					
					
					results.add(record);
					
					
				}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return results;
	}
	
	
	public ArrayList getNoteContent(String locale,String acc_num,String action_date_time) throws Exception {
		
		String query_notes_detail = "";
		Connection				con					= null;
		
		ResultSet rs = null;
		ArrayList results = new ArrayList() ;
		java.sql.Clob			clob_notes_content	= null;
		java.io.Reader			content_reader		= null;
		java.io.BufferedReader	bf_content_reader	= null;
		String	notes_content		=	"";
		String  notes_content1			=	"";
		PreparedStatement pstmt =  null;
		query_notes_detail = "select a.pre_amendment_note_content note_content, CA_GET_DESC.CA_NOTE_TYPE(c.NOTE_TYPE,?,'1') note_type_desc from  ca_encntr_note_audit_log a,ca_encntr_note c where /*c.facility_id=a.facility_id and*/ c.accession_num=a.accession_num /*and a.facility_id = ?*/ and a.accession_num = ? and a.action_date_time = to_date(?,'dd/mm/yyyy hh24:mi:ss')";
		
		try {
			con=getConnection();
			pstmt				=	con.prepareStatement(query_notes_detail);
	
			pstmt.setString( 1,	locale		);
			pstmt.setString( 2,	acc_num	); 
			pstmt.setString( 3,	action_date_time	);
		
			rs					=	pstmt.executeQuery(); 
			
			if(rs!=null) {
				
				
				while ( rs.next()) {
					String[] record=new String[11];//IN071618
					clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");

					if(clob_notes_content!=null)
					{
						try
						{
							content_reader	= clob_notes_content.getCharacterStream();
							bf_content_reader = new java.io.BufferedReader(content_reader);

							char[] arr_notes_content = new char[(int)clob_notes_content.length()];


							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

							notes_content = new String(arr_notes_content);

							bf_content_reader.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						if(!notes_content.equals(""))
						{
							//IN044358 Start.
							String str="<th style=\"border-style:dashed;font-size:9pt;font-weight:boldl;\"";
							String str1="<td style=\"border-style:dashed;font-size:9pt;text-align:center;font-weight:bold;\"";
							notes_content = notes_content.replaceAll(str,str1);
							String str_ ="<th style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;\"";
							String str1_ ="<td style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;text-align:center;\"";
							notes_content = notes_content.replaceAll(str_,str1_);
							notes_content = notes_content.replaceAll("</th>","</td>");
							notes_content = notes_content.replaceAll("<!--","<!-- ");
							//IN044358 End.
							notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
							notes_content = notes_content.replaceAll("PAGE-BREAK-BEFORE: always;","");           //[IN056353]
							notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				//IN067635
							notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			//IN067635
							notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
							int nIndex = notes_content.indexOf("<BODY onKeyDown='lockKey()'>");
							if(nIndex==-1)
							{
								nIndex = notes_content.indexOf("<BODY>");
							}
							int nIndex1 = notes_content.lastIndexOf("</BODY>");
							
							if(nIndex != -1 && nIndex1 != -1)
								notes_content1 = notes_content.substring(nIndex+6,nIndex1);
							else
								notes_content1 = notes_content;
						}
						
					record[0] = notes_content1;
					record[1] = rs.getString("note_type_desc");
					results.add(record);
					}
				
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return results;
	}

public String getClinicalNotesContentLastModified(String locale,String acc_num,String action_date_time) throws Exception {
		
		String query_notes_detail = "";
		Connection				con					= null;
		
		ResultSet rs = null;
		java.sql.Clob			clob_notes_content	= null;
		java.io.Reader			content_reader		= null;
		java.io.BufferedReader	bf_content_reader	= null;
		String	notes_content		=	"";
		
		PreparedStatement pstmt =  null;
		query_notes_detail = " select NOTE_CONTENT from CA_ENCNTR_NOTE where  accession_num=? ";
		
		try {
			con=getConnection();
			pstmt				=	con.prepareStatement(query_notes_detail);
	
			pstmt.setString( 1,	acc_num	); 
		
			rs					=	pstmt.executeQuery(); 
			
			if(rs!=null) {
				
				
				while ( rs.next()) { 
					//String[] record=new String[11];//IN071618//51003
					clob_notes_content	=	(java.sql.Clob) rs.getObject("NOTE_CONTENT");

					if(clob_notes_content!=null)
					{
						try
						{
							content_reader	= clob_notes_content.getCharacterStream();
							bf_content_reader = new java.io.BufferedReader(content_reader);

							char[] arr_notes_content = new char[(int)clob_notes_content.length()];


							bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

							notes_content = new String(arr_notes_content);

							bf_content_reader.close();
						}
						catch(Exception e)
						{
							e.printStackTrace(); 
						}
				
					}
				
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return notes_content;
	}
	public String getPatientName(String locale,String patientId) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String patientName ="";		
		try {
			con=getConnection();
			
			pstmt				=	con.prepareStatement("SELECT DECODE (?,'en', PATIENT_NAME,NVL (PATIENT_NAME_LOC_LANG, PATIENT_NAME)) PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID=?");	
			pstmt.setString( 1,	locale		);
			pstmt.setString( 2,	patientId	); 
		
			rs					=	pstmt.executeQuery(); 			
			if(rs!=null) {		
				
				while ( rs.next()) {
					patientName = rs.getString("PATIENT_NAME")==null?"":(String)rs.getString("PATIENT_NAME");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return patientName;
	}
	public String getPrintDate(String locale) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String printDate ="";
		
		try {
			con=getConnection();
			
			pstmt				=	con.prepareStatement("SELECT TO_CHAR(SM_CONVERT_DATE(SYSDATE,?),'DD/MM/YYYY HH24:MI') PRINT_DATE FROM DUAL");	
			pstmt.setString( 1,	locale);
		
			rs	=	pstmt.executeQuery(); 			
			if(rs!=null) {		
				
				while ( rs.next()) {
					printDate = rs.getString("PRINT_DATE")==null?"":(String)rs.getString("PRINT_DATE");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return printDate;
	}
	
	public String getSiteName(String locale) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String siteName ="";
		
		try {
			con=getConnection();			
			pstmt				=	con.prepareStatement("SELECT SITE_NAME FROM  SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID=?");	
			pstmt.setString( 1,	locale);
		
			rs	=	pstmt.executeQuery(); 			
			if(rs!=null) {		
				
				while ( rs.next()) {
					siteName = rs.getString("SITE_NAME")==null?"":(String)rs.getString("SITE_NAME");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return siteName;
	}
	public String getFacilityName(String facilityId,String locale) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String facilityName ="";
		
		try {
			con=getConnection();
			
			pstmt				=	con.prepareStatement("SELECT SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') FACILITY_NAME FROM DUAL ");	
			pstmt.setString( 1,	facilityId);
			pstmt.setString( 2,	locale);
			rs	=	pstmt.executeQuery(); 			
			if(rs!=null) {
				while ( rs.next()) {
					facilityName = rs.getString("FACILITY_NAME")==null?"":(String)rs.getString("FACILITY_NAME");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return facilityName;
	}
	public String getLocationName(String locale,String patientId,String encounterId,String facilityId) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String locationName ="";
		
		try {
			con=getConnection();
			
			pstmt				=	con.prepareStatement("Select CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1') ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END LOCATION_NAME from PR_ENCOUNTER A where A.PATIENT_ID= ? AND A.ENCOUNTER_ID=? and a.facility_id =?");	
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	locale);
			pstmt.setString( 3,	patientId);
			pstmt.setString( 4,	encounterId);
			pstmt.setString( 5,	facilityId);
			rs					=	pstmt.executeQuery(); 			
			if(rs!=null) {		
				
				while ( rs.next()) {
					locationName = rs.getString("LOCATION_NAME")==null?"":(String)rs.getString("LOCATION_NAME");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return locationName;
	}
	public String getNoteTypeDesc(String noteType) throws Exception {		
		
		Connection con = null;		
		ResultSet rs = null;		
		PreparedStatement pstmt =  null;
		String noteTypeDesc ="";
		
		try {
			con=getConnection();
			
			pstmt				=	con.prepareStatement("SELECT NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");	
			pstmt.setString( 1,	noteType);
		
			rs					=	pstmt.executeQuery(); 			
			if(rs!=null) {		
				
				while ( rs.next()) {
					noteTypeDesc = rs.getString("NOTE_TYPE_DESC")==null?"":(String)rs.getString("NOTE_TYPE_DESC");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
  			closeResultSet( rs ) ;
  			closeStatement( pstmt ) ;
  			closeConnection(con);
  		}
		return noteTypeDesc;
	}
}

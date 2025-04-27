/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
05/07/2012    IN033610      Chowminya G	 Add Notification Alert in summary 	
18/01/2013	  IN037372		Ramesh G		Oracle 11g Weblogic compilation.
22/06/2013    IN041006		Chowminya G	  Review Results->Image hyperlink not displayed	
15/11/2013	  IN035717		vijayakumark Alpha-OR- View Results Records not displayed in Practitioner s Desktop	
26/12/2013	  IN042552		Ramesh G	Bru-HIMS-CRF-391-42552
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
07/07/2017	IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
19/03/2018	IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787 
07/06/2018	IN067651		Raja S			07/06/2018		Ramesh G		GHL-SCF-1338
16/07/2018	IN068128		Raja S			16/07/2018		Ramesh G		ML-MMOH-SCF-1043
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import java.util.zip.*;
import javax.rmi.* ;
import javax.naming.* ;
import java.math.*;//IN064688 added
import eOR.Common.* ;
import eCommon.Common.*;

import eOR.ORReviewResult.*;

public class ReviewResults extends OrAdapter implements java.io.Serializable {

	protected String total_records	 		= "";
	protected String pract_id 				= "";
	protected Hashtable allValues 			= new Hashtable();
	protected ArrayList forwardPractHash    = null;

	StringBuffer traceVals 					= new StringBuffer();
    //String sqlstr = "";


	public void setMode(String mode){							this.mode = mode;								}
	public void setTotalRecs(String total_records){				this.total_records = total_records;				}
	public void setPractId(String pract_id){					this.pract_id = pract_id;						}


	public String getMode(){					return mode;	}
	public String getTotalRecs(){				return total_records;	}



	public String getClobData(String accen_num)throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String result_data = "";
		try{
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_CLOB_DATA") ) ;
			pstmt = connection.prepareStatement("SELECT compress_hist_data_yn,compress_hist_data,hist_data FROM cr_encounter_detail_txt WHERE accession_num =? ");
			
			pstmt.setString(1, (String)accen_num.trim());

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {
				
				//6484 Start.
				if("Y".equals(resultSet.getString("compress_hist_data_yn")==null?"N":(String)resultSet.getString("compress_hist_data_yn"))){
					StringBuffer compresshistData = new StringBuffer();
					java.sql.Blob hist_data_blob =  (java.sql.Blob)resultSet.getBlob("compress_hist_data");
					if(hist_data_blob!=null && hist_data_blob.length()>0){
						InputStream ins1 = hist_data_blob.getBinaryStream();
						ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
						int i;
						while((i = ins1.read()) != -1) 
							bytearrayoutputstream.write(i);
						
						byte[] compressed	=bytearrayoutputstream.toByteArray();
						if(compressed.length > 0){
							if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
								GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
								BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
								String line;
								while ((line = bufferedReader.readLine()) != null) {							
									compresshistData.append(line+"\n");
								}
							}					
						}
						result_data = compresshistData.toString();
					}
				}else{
					Clob hist_data = resultSet.getClob("hist_data");
					if(hist_data!=null && hist_data.length() > 0)
						result_data = hist_data.getSubString(1,( (int)hist_data.length() ));
				}
			}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return result_data;
	}
// Get the values for the Pracitioner, when the selection is Attending Practitioner
	public ArrayList getEventClass(String hist_rec_type) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList EventClass = new ArrayList() ;
		if(hist_rec_type==null) hist_rec_type = "";
		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_EVENT_CLASS_SELECT") ) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,hist_rec_type);
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					String[] record = new String[2];
						record[0] = resultSet.getString( "event_class" )  ;
						record[1] = resultSet.getString( "short_desc" )  ;
						EventClass.add(record) ;
				}
			}
		}catch ( Exception e )	{
			System.err.println( "Error "+e ) ;
			e.printStackTrace() ;
			return null;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return EventClass;
	}


	public String[] getAbnormalCondition()throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String result_data[] = new String[6];
		try{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_CONDN") ) ;

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) {
				result_data[0] = resultSet.getString("high_str");
				result_data[1] = resultSet.getString("low_str");
				result_data[2] = resultSet.getString("abn_str");
				result_data[3] = resultSet.getString("crit_str");
				result_data[4] = resultSet.getString("crit_high_str");
				result_data[5] = resultSet.getString("crit_low_str");
			}
		}catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return result_data;
	}

/**
	@param		:	String pract_id
	@return		:	ArrayList
*/

	public ArrayList getDetails(String pract_id,String priority,String normalcy_ind,String result_type,String resp_id,String patientId,String event_class,String group_by,String patient_class,String ca_normalcy_ind,String modal, String date_from, String date_to, String get_task_applicability, int start, int end) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;

		StringBuffer traceVal = new StringBuffer();

	//	int total_records			= 0;

		try {
			if(normalcy_ind.equals("")) normalcy_ind = null;
			if(result_type.equals("")) result_type = null;
			if(priority.equals("")) priority = null;
			if(patientId==null) patientId = "";
			if(event_class==null) event_class = "";
			if (group_by==null) group_by = "";

			if (ca_normalcy_ind == null) ca_normalcy_ind = "";

			if (modal == null) modal = "";
			/* Thai date validations start 14/02/2007*/
			if(date_from.equals("null") || date_from.equals(" ")) date_from="";
			if(date_to.equals("null") || date_to.equals(" ")) date_to="";
			if (!language_id.equals("en")){
			date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY",language_id,"en");
			date_to = com.ehis.util.DateUtils.convertDate(date_to,"DMY",language_id,"en");
			
			}
            
			/* Thai date validations end 14/02/2007*/

			traceVal.append("pract_id=" + pract_id + ",priority=" + priority + ",normalcy_ind=" + normalcy_ind + ",result_type=" + result_type + ",resp_id=" + resp_id + ",patientId=" + patientId + ",event_class=" + event_class + ",group_by=" + group_by + ",patient_class=" + patient_class + ",ca_normalcy_ind=" + ca_normalcy_ind + ",modal=" + modal + ":");

			//pract_id = "D01";
			connection = getConnection() ;

			 //sqlstr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT");

            //sqlstr = sqlstr + ";" + pract_id + "~" + priority + "~" + normalcy_ind + "~" + result_type + "~" + resp_id + "~" + patientId + "~" + event_class;



            String strNormalcyInd = "";
			if (normalcy_ind == null || normalcy_ind.equals("Y") ) //IN033610 - inculded condition for "Y"
			{
				strNormalcyInd = "nvl(a.NORMALCY_IND,'.')";
			} 
			else if (normalcy_ind.equals("N")) 
			{
				strNormalcyInd = "'.'";
			} 
			else if (normalcy_ind.equals("A")) 
			{
				pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_SELECT"));
			} 
			else if (normalcy_ind.equals("C")) 
			{
				
				pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_CRITICAL_ABNORMAL_SELECT"));
			}
		
			if ((normalcy_ind != null) && (!normalcy_ind.equalsIgnoreCase("N"))&&(!normalcy_ind.equalsIgnoreCase("Y"))) //IN033610
			{
				resultSet = pstmt1.executeQuery();
				if (resultSet != null && resultSet.next()) 
				{
					strNormalcyInd = resultSet.getString(1);
				}
				closeResultSet( resultSet ) ;
			}
            String sqlStr = "";
            if (patient_class.equals("")) 
			{  // && (ca_normalcy_ind.equals(""))
    			if (group_by.equals("E")) 
				{
					
    				//sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1");
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E') order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
					 //IN042552 Start.
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and  nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E') order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code"; //IN041006 included ext_image_upld_id
    				 //IN064688 Start
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and  nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
    				//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , result_num,F.result_num_uom,F.result_str, normal_low, normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and  nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
					//IN064688 End [Result_num,normal_low,normal_high] 
					//IN042552 End.. //Commented for IN067037
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999')) normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and  nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";//modified for IN067037//Commented for IN067651
					 sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id ,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999')) normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name,NVL (am_get_desc.am_practitioner (f.authorized_by_id, ?, '1'),f.authorized_by_id) resulted_pract_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1') event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and  nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type)  &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";//modified for IN067651
    			} 
				else 
				{
        			//sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT");
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";
					 //IN042552 Start.
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name ,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code"; //IN041006 included ext_image_upld_id
					//IN064688 start
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name ,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code"; 
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , result_num,F.result_num_uom,F.result_str, normal_low, normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name ,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";
					//IN064688 End [Result_num,normal_low,normal_high]
					 //IN042552 End. //Commented for IN067037
					 //sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999')) normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name ,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";//Modified for IN067037//Commented for IN067651
					 sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner,cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id  ,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999')) normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name,NVL (am_get_desc.am_practitioner (f.authorized_by_id, ?, '1'),f.authorized_by_id) resulted_pract_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status/*, ordering_practitioner*/,CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name ,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = (?) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(i.priority,'X') = nvl((?),nvl(i.priority,'X')) and nvl(a.NORMALCY_IND,'.') in (?) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY## and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";//Modified for IN067037//Modified for IN067651
                }
            } 
			else if (!patient_class.equals(""))
			{

			    //pract_id = "";
			    patientId = "";

                if (group_by.equals("E")) 
				{
					//System.out.println("SQL_OR_RESULT_REVIEW_SELECT1_PAT_CLASS");
    				//sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1_PAT_CLASS");
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E') order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
					//IN042552 Start.
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E') order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";//IN041006 included ext_image_upld_id
                	//IN064688 START
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , result_num,F.result_num_uom,F.result_str,   normal_low, normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";
					//IN064688 End [Result_num,normal_low,normal_high]
					//IN042552 End. //commented for IN067037
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";//Modified for IN067037//Commented for IN067651
					sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,DECODE(review_type,'O','Ordering Practitioner','A','Attending Practitioner') review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, F.ext_image_obj_id,ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, NVL (am_get_desc.am_practitioner (f.authorized_by_id, ?, '1'),f.authorized_by_id) resulted_pract_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,a.patient_id patient_id,a.event_class event_class,a.event_code event_code,a.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(A.NORMALCY_IND,'.') in nvl((?),nvl(A.NORMALCY_IND,'*')) AND a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999  and patient_class = ? AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by event_short_desc,1,f.hist_rec_type,f.event_class,event_date,f.event_group,a.event_Code";//Modified for IN067651
    			} 
				else 
				{
					//System.out.println("SQL_OR_RESULT_REVIEW_SELECT_PAT_CLASS");
        			//sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT_PAT_CLASS");
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         || case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END episode_details, am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, PR_ENCOUNTER h,or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,                  15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and h.FACILITY_ID=f.FACILITY_ID and h.encounter_id=f.encounter_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";
					//IN042552 Start.
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details,am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E') order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";//IN041006 included ext_image_upld_id
					//IN064688 start
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details,am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix ||  TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str, TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details,am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , result_num,F.result_num_uom,F.result_str,  normal_low, normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";
					//IN064688 End [Result_num,normal_low,normal_high]
					//IN042552 End.//Commented for IN067037
					//sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details,am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str,TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";//modified for IN067037//commented for IN067651
					sqlStr = "SELECT decode(?,'en',g.PATIENT_NAME,nvl(g.PATIENT_NAME_LOC_LANG,g.PATIENT_NAME))||','|| g.sex ||'/'||get_age(g.date_of_birth) ||', '|| f.patient_id   || '  '|| f.encounter_id||', ' || f.patient_class         || '/'         ||  (select (case when H.patient_class in ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1')  else  OP_GET_DESC.OP_CLINIC(H.FACILITY_ID,h.ASSIGN_CARE_LOCN_CODE,?,'1') END) from pr_encounter H where facility_id = I.ordering_facility_id and encounter_id = I.ENCOUNTER_ID) episode_details,am_get_desc.am_practitioner(ORD_PRACT_ID,?,'1') ordering_practitioner, cr_get_desc.cr_clin_event_mast        (f.hist_rec_type,f.event_code,f.event_code_type,?,'1') event, contr_sys_event_code/*,order_type_code*/,i.order_id   order_id,a.accession_num, a.hist_rec_type hist_rec_type, a.contr_sys_id,pract_id, review_type review_types,nvl2(requested_by_pract_id,'Forwarded',review_type) review_type,hist_data_type,performed_by_id reported_by, TO_CHAR(event_date,'dd/mm/yyyy hh24:mi') reported_at,authorized_by_id, TO_CHAR(event_auth_date_time,'dd/mm/yyyy hh24:mi') event_auth_date_time,f.result_num_prefix , TO_CHAR (F.result_num,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) result_num,F.result_num_uom,F.result_str,TO_CHAR (F.normal_low,DECODE (F.result_num_dec,1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',               5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',             0, '999999999','999999999'))  normal_low,TO_CHAR (F.normal_high,DECODE (F.result_num_dec, 1, '999999999.0',2, '999999999.90',3, '999999999.900',4, '999999999.9000',5, '999999999.90000',6, '999999999.900000',7, '999999999.9000000',8, '999999999.90000000',9, '999999999.90000000',0, '999999999','999999999')) normal_high, F.normalcy_ind, ext_image_obj_id,F.ext_image_appl_id, NVL (am_get_desc.am_practitioner( f.performed_by_id,?,'1'), f.performed_by_id) practitioner_name, NVL (am_get_desc.am_practitioner (f.authorized_by_id, ?, '1'),f.authorized_by_id) resulted_pract_name, authorized_by_id, TO_CHAR(create_date_time,'dd/mm/yyyy hh24:mi') create_date_time, F.status status, CR_GET_DESC.CR_HIST_REC_TYPE(F.hist_rec_type,?,'2')  hist_rec_type_desc, CR_GET_DESC.CR_EVENT_CLASS(F.hist_rec_type,F.event_class,?,'1') event_class_desc, CR_GET_DESC.CR_CLIN_EVENT_GROUP(F.hist_rec_type,F.event_group,F.event_group_type,?,'1')  event_group_desc,F.patient_id patient_id,F.event_class event_class,F.event_code event_code,F.event_group event_group,F.hist_data_TYPE hist_data,requested_by_pract_id , AM_GET_DESC.AM_PRACTITIONER(requested_by_pract_id,?,'1') requested_by_pract_name,f.ext_image_upld_id FROM &&TABLEREVIEW## a,cr_encounter_detail f,mp_patient g, or_order i WHERE A.pract_id = nvl((?),pract_id) and i.order_id=(case when  ( a.contr_sys_id = 'OR') then SUBSTR (a.accession_num,INSTR (a.accession_num, '!') + 1,15 )else(SELECT order_id FROM or_order_line WHERE  order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) and rownum=1)end) and f.HIST_REC_TYPE=a.HIST_REC_TYPE and f.CONTR_SYS_ID=a.CONTR_SYS_ID and f.ACCESSION_NUM=a.ACCESSION_NUM and f.CONTR_SYS_EVENT_CODE=a.EVENT_CODE and g.patient_id=f.patient_id and nvl(priority,'X') = nvl((?),nvl(priority,'X')) and nvl(a.NORMALCY_IND,'.') in nvl((?),nvl(a.NORMALCY_IND,'*')) and a.hist_rec_type = NVL ((?), a.hist_rec_type) &&GETTASKAPPLICABILITY##  and f.patient_id = nvl(?, f.patient_id) and f.event_class = nvl(?,f.event_class) and a.create_DATE_TIME between TO_DATE (NVL ((?),            '01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.9999 and patient_class = ?      AND NVL (f.status, '#') not in ( 'S','E')  and nvl(ca_view_confidnt_event (f.facility_id,f.ENCOUNTER_ID,f.PATIENT_ID,f.accession_num,f.EVENT_CODE_TYPE,f.event_code,f.hist_rec_type,'"+pract_id+"','"+resp_id+"',f.performed_by_id,f.AUTHORIZED_BY_ID,f.event_group),'N')='Y' order by 1,f.hist_rec_type,f.event_class,event_date,f.event_group,f.request_num_seq,a.event_Code";//modified for IN067651
                }
			} 
			 if (get_task_applicability.equals("X"))
				sqlStr = sqlStr.replace("&&GETTASKAPPLICABILITY##"," and (nvl(f.PROTECTION_IND,'N')!='Z' )  ");
			 else
				sqlStr = sqlStr.replace("&&GETTASKAPPLICABILITY##"," ");
			//IN033610 - Start	
				//	if (normalcy_ind.equals("Y"))
			if((normalcy_ind != null) && (normalcy_ind.equalsIgnoreCase("Y")))
			{
				sqlStr = sqlStr.replace("&&TABLEREVIEW##"," CA_NOTIFY_REVIEW_PEND_LOG ");
			}
			 else
			{
				sqlStr = sqlStr.replace("&&TABLEREVIEW##"," ca_result_review_pend_log ");
			}	
			//IN033610	- End	
			/*else if (!ca_normalcy_ind.equals("")) {
			    //pract_id = "";
                if ((ca_normalcy_ind.equals("Z")) || (ca_normalcy_ind.equals("N"))) {
                   if (group_by.equals("E")) {
        				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1") ) ;
        				sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1");
        			} else {
            			sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT");
                    }
                } else {
                    if (group_by.equals("E")) {
        				//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1") ) ;
        				sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT1_CRITICAL");
        			} else {
            			sqlStr = OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_SELECT_CRITICAL");
                    }
                }
			}*/
			//for(int x=0;x<10;x++)//Commented for IN067651
			for(int x=0;x<11;x++)//Modified for IN067651
			{
				sqlStr=replace(sqlStr,"?",language_id,"Y");
			}
			sqlStr = replace(sqlStr,"?",(pract_id==null)?"":pract_id,"Y");
			sqlStr = replace(sqlStr,"?",(priority==null)?"":priority,"Y");
			//sqlStr = replaceWithoutQuotes(sqlStr,"?",strNormalcyInd);

			//if (patient_class.equals("")) {  // && (ca_normalcy_ind.equals(""))
			sqlStr = replace(sqlStr,"?",strNormalcyInd,"N");
			/*} else if ((!ca_normalcy_ind.equals("")) && (((ca_normalcy_ind.equals("Z")) || (ca_normalcy_ind.equals("N"))))) {
			  sqlStr = replace(sqlStr,"?",strNormalcyInd,"N");
			} */


            traceVal.append(",sqlStr="+sqlStr);
			
            pstmt = connection.prepareStatement( sqlStr ) ;
			/*pstmt.setString( 1, pract_id ) ;
			pstmt.setString( 2, priority ) ;
			//pstmt.setString( 3, normalcy_ind ) ;
			pstmt.setString( 3, strNormalcyInd);
			pstmt.setString( 4, result_type ) ;
			pstmt.setString( 5, resp_id);
			pstmt.setString( 6, patientId);
			pstmt.setString( 7, event_class);*/
			pstmt.setString(1,result_type);
			//pstmt.setString(2,resp_id);
			pstmt.setString(2,patientId);
			pstmt.setString(3,event_class);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);

			if (!patient_class.equals("")) {
				pstmt.setString(7,patient_class);
			}
			//System.out.println("=result_type="+result_type+"resp_id"+resp_id+"patientId"+patientId+"event_class"+event_class+"date_from"+date_from+"date_to"+date_to);
			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null) {
			/*	resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */
			//changes for IN068128 starts
			//if(start > 0)
			//	for(int i=0;(i<start-1 && resultSet.next());i++);				
			//while ( start <= end && resultSet.next()) {
			while (resultSet.next()) {
			//changes for IN068128 ends
							//String[] record = new String[41];//Changed from 40 to 41 IN041006
							String[] record = new String[42];//Changed from 41 to 42 IN067651
							record[0] = resultSet.getString( "episode_details" )  ;
							record[1] = resultSet.getString( "event" )  ;
							record[2] = resultSet.getString( "contr_sys_event_code" )  ;
							record[3] = "";//resultSet.getString( "order_type_code" )  ;
							record[4] = resultSet.getString( "order_id" )  ;
							record[5] = resultSet.getString( "accession_num" )  ;
							record[6] = resultSet.getString( "hist_rec_type" )  ;
							record[7] = resultSet.getString( "contr_sys_id" )  ;
							record[8] = resultSet.getString( "pract_id" )  ;
							record[9] = resultSet.getString( "review_types" )  ;
							record[10] = resultSet.getString( "review_type" )  ;
							record[11] = resultSet.getString( "hist_data_type" )  ;
							record[12] = resultSet.getString( "reported_by" )  ;
							record[13] = resultSet.getString( "reported_at" )  ;
							record[14] = resultSet.getString( "authorized_by_id" )  ;
							record[15] = resultSet.getString( "event_auth_date_time" )  ;
							//IN064688 Changes Starts
							//record[16] = resultSet.getString( "result_num" )  ;
							String result_prefix = resultSet.getString("result_num_prefix")==null?"":resultSet.getString("result_num_prefix");
							BigDecimal rn =resultSet.getBigDecimal("result_num");
							if(rn!=null)
								record[16]=result_prefix+rn.toString();
							else
								record[16]=result_prefix;
							//IN064688 Changes Ends
							record[17] = resultSet.getString( "result_num_uom" )  ;
							record[18] = resultSet.getString( "result_str" )  ;
							//IN064688 Changes Starts
							//record[19] = resultSet.getString( "normal_low" )  ;
							//record[20] = resultSet.getString( "normal_high" )  ;
							BigDecimal nl =resultSet.getBigDecimal("normal_low");
							if(nl!=null)
								record[19]=nl.toString();
							else
								record[19]="";
							BigDecimal nh =resultSet.getBigDecimal("normal_high");
							if(nh!=null)
								record[20]=nh.toString();
							else
								record[20]="";
							//IN064688 Changes Ends							
							record[21] = resultSet.getString( "normalcy_ind" )  ;
							record[22] = resultSet.getString( "ext_image_obj_id" )  ;
							record[23] = resultSet.getString( "ext_image_appl_id" )  ;
							record[24] = resultSet.getString( "practitioner_name" )  ;
							record[25] = resultSet.getString( "authorized_by_id" )  ;
							record[26] = resultSet.getString( "create_date_time" )  ;
							record[27] = resultSet.getString( "status" )  ;
							record[28] = resultSet.getString( "ordering_practitioner" )  ;
							//Added by Siva Kumar
							record[29] = resultSet.getString("hist_rec_type_desc");
							record[30] = resultSet.getString("event_class_desc");
							record[31] = resultSet.getString("event_group_desc");
							record[32] = resultSet.getString("patient_id");
							record[33] = resultSet.getString("event_code");
							record[34] = resultSet.getString("event_group");
							record[35] = resultSet.getString("event_class");
							//End of Addition
							record[36] = resultSet.getString("hist_data"); // Will return X if data is there otherwise null
							record[37] = resultSet.getString("requested_by_pract_id"); 
							record[38] = resultSet.getString("requested_by_pract_name"); 
							record[39] = resultSet.getString("ext_image_upld_id"); //IN041006
							record[41] = resultSet.getString("resulted_pract_name");//IN067651
							//record[39] = String.valueOf(total_records);
							OrderCat.add(record) ;
							start++;
						}

						if (resultSet.next())
						{
							String[] templist = (String[])OrderCat.get(0);
							templist[40] = ""+(end+7);
							OrderCat.set(0,templist);
						}
				
					}
 
			//System.out.println("traceVal=" + traceVal.toString());

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}

public HashMap insert(){
		//System.out.println("###in insert()#####");
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{
			//System.out.println("###allValues="+allValues);
			if(allValues.containsKey("called_from")){
				//System.out.println("##allValues containsKey called_from####");
				map = insertForwardPract_id();
			}else{
				//System.out.println("##else####");
				map = reviewResults();
			}
		}catch(Exception e){
			System.err.println( "Error "+e.toString() ) ;
		}
	return map;
}

/**
	@return		:	HashMap
*/

	public HashMap reviewResults() throws Exception {
		HashMap map = new HashMap() ;
		StringBuffer tmpBuff = new StringBuffer();
		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		//int result 				= 0;
		int cnt					= 0;
		String hist_rec_type 	= "";
		String contr_sys_id 	= "";
		String contr_sys_event_code= "";
		String accession_num 	= "";
		String review_type	 	= "";
		String create_date_time = "";
		String review_remarks     = "";
		String normal_ind     = ""; //IN033610
		traceVals.append("total recs rt :  >"+total_records);
		int int_total_records = Integer.parseInt(total_records);
		try {
			for(int i=0; i<int_total_records; i++){
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
					hist_rec_type		= (String)allValues.get("hist_rec_type"+i);
					contr_sys_id		= (String)allValues.get("contr_sys_id"+i);
					contr_sys_event_code= (String)allValues.get("contr_sys_event_code"+i);
					accession_num		= (String)allValues.get("accession_num"+i);
					review_type			= (String)allValues.get("review_type"+i);
					create_date_time	= (String)allValues.get("create_date_time"+i);
					traceVals.append(">>create_date_time :  >"+create_date_time);
					review_remarks      = (String)allValues.get("review_remarks"+i);
					traceVals.append(">>review_remarks :  >"+review_remarks);
					//IN035717 starts here
					//normal_ind      = (String)allValues.get("normal_ind"+i); //IN033610
					normal_ind      = checkForNull((String)allValues.get("normalcy_ind"+i),"");
					//IN035717 ends here
					
					

					String[] updt_data1 = new String[7];
					updt_data1[0] = hist_rec_type;
					traceVals.append(">>hist_rec_type :  >"+hist_rec_type);
					updt_data1[1] = contr_sys_id;
					traceVals.append(">>contr_sys_id :  >"+contr_sys_id);
					updt_data1[2] = contr_sys_event_code;
					traceVals.append(">>contr_sys_event_code :  >"+contr_sys_event_code);
					updt_data1[3] = accession_num;
					traceVals.append(">>accession_num :  >"+accession_num);
					updt_data1[4] = review_type;
					traceVals.append(">>review_type :  >"+review_type);
					updt_data1[5] = create_date_time;
					traceVals.append(">>create_date_time :  >"+create_date_time);
					updt_data1[6] = review_remarks;
					traceVals.append(">>review_remarks :  >"+review_remarks);

					updt_map1.put("review_data"+cnt,updt_data1);
					cnt++;
				}//end of if condition
			}//end of for loop

			updt_map1.put("pract_id",pract_id);
			traceVals.append(">>pract_id :  >"+pract_id);
			updt_map1.put("login_by_id",login_by_id);
			traceVals.append(">>login_by_id :  >"+login_by_id);
			updt_map1.put("totalCount",""+cnt);
			traceVals.append(">>totalCount :  >"+cnt);

            try{
			if(!normal_ind.equals("Y")) //IN033610
			{
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE") );
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT") );
				sqlMap.put("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT") );
			}
			else //IN033610
			{
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE","DELETE FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE hist_rec_type=(?) AND accession_num = (?) AND pract_id=(?)" );
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT","INSERT INTO ca_notify_review_done_log (pract_id,hist_rec_type,contr_sys_id,accession_num,event_code,create_date_time,review_type,review_date_time,added_by_id,added_date,modified_by_id,modified_date,review_remarks,requested_by_pract_id) VALUES ((?),(?),(?),(?),(?),To_date((?),'dd/mm/yyyy hh24:mi'),(?),SYSDATE,(?),SYSDATE,(?),SYSDATE,(?),(?))" );
				sqlMap.put("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT","CALL OR_Notify_Reviewed_Pract( ? ,? ,?, ?, ? )" );
			}	
			}catch(Exception e){
			 traceVals.append(">>exception in sqlmap :  >"+e.getMessage());
			}


			//ORReviewResultHome home = null ;
			//ORReviewResultRemote remote = null ;

			try {
				updt_map1.put( "properties", getProperties() );
				
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI") ) ;
				home  = (ORReviewResultHome) PortableRemoteObject.narrow( object, ORReviewResultHome.class ) ;
				
				remote = home.create() ;

				//ORReviewResultsManager remote1 = new ORReviewResultsManager();
				traceVals.append(">>before EJB :  >"+updt_map1);
				map = remote.insert( updt_map1, sqlMap ) ;
				traceVals.append("map value   >"+map);
                //System.out.println("traceVal="+traceVals.toString());*/
				Object home =  com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"), ORReviewResultHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map1;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map1.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				
				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}
				
				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}*/
			}


		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}  
		map.put("traceVal", traceVals.toString());
		//System.out.println("traceVals="+traceVals.toString());
		return map;
	}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		allValues = recordSet;
		//System.out.println("#### allValues before thai validations="+allValues);
		if(recordSet.containsKey("total_recs")){
			//System.out.println("recordSet containsKey total_recs");
			setTotalRecs((String)recordSet.get("total_recs"));					}
		if(recordSet.containsKey("practitioner_id")){	
			//System.out.println("recordSet containsKey practitioner_id");
			setPractId((String)recordSet.get("practitioner_id"));				}

		this.mode = (String)recordSet.get( "mode" );
		/* Thai date validations start 14/02/2007*/
		if (!language_id.equals("en")){
		if(allValues.containsKey("period_from")){
		String period_from = (String)allValues.get("period_from");
		if (period_from.equals(" ") || period_from.equals("null") || period_from==null) period_from="";
		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		allValues.put("period_from",period_from);
		}
		if(allValues.containsKey("period_to")){
		String period_to = (String)allValues.get("period_to");	
		//System.out.println("=period_from="+period_from+"===period_to="+period_to);
		if (period_to.equals(" ") || period_to.equals("null") || period_to==null) period_to="";
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		allValues.put("period_to",period_to);
		}
		if(allValues.containsKey("total_recs")){
		int total_recs = Integer.parseInt((String)allValues.get("total_recs")); 
		//System.out.println("### total_recs="+total_recs);
		String create_date_time="";
		for(int i=0;i<total_recs;i++){
			if(allValues.containsKey("create_date_time")){
			create_date_time=(String)allValues.get("create_date_time"+i);
			if (create_date_time.equals(" ") || create_date_time.equals("null") || create_date_time==null) create_date_time="";			
			create_date_time= com.ehis.util.DateUtils.convertDate(create_date_time,"DMYHM",language_id,"en");
			allValues.put("create_date_time"+i,create_date_time);		
			}
		}
		}
		}

		/* Thai date validations end 14/02/2007*/
		//System.out.println("#### allValues before thai validations="+allValues);
	}

	/**
	* Used to replace the selected value to form a proper SQL String
	* @return String
	*/
	private String replace(String str ,String change ,String replace){
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
		return str ;
	}
	private String replaceWithoutQuotes(String str ,String change ,String replace){
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		str   = str.substring(0,t) + " " + replace.trim()+ " " + str.substring(t+1)  ;
		return str ;
	}
	private String replace(String str ,String change ,String replace,String quotes){
		int t = str.indexOf(change);
		if( t == -1)
			return str;
		if (quotes.equalsIgnoreCase("Y"))
			str   = str.substring(0,t) + " '" + replace.trim()+ "' " + str.substring(t+1)  ;
		else if (quotes.equalsIgnoreCase("N"))
			str   = str.substring(0,t) + " " + replace.trim()+ " " + str.substring(t+1)  ;
		return str ;
	}

	public String [] getPractitionerDetails(String login_user) throws Exception {
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String [] practitioner_details	= new String[2];
	try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_PRACTITIONER_DETAILS"));
			pstmt.setString(1, language_id);
			pstmt.setString(2,checkForNull(login_user));
			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )    // Only one record for the module_id
			{
				while(resultSet.next())
				{
					practitioner_details[0] = resultSet.getString(1);
					practitioner_details[1] = resultSet.getString(2);
					if (practitioner_details[0] == null) practitioner_details[0] = "";
					if (practitioner_details[1] == null) practitioner_details[1] = "";
                }
			}
		}catch ( Exception e )	{
			System.err.println( "getPractitionerDetails:"+e.getMessage() ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return practitioner_details;
	} // End of getPractitionerDetails

	public void clear() {
		//System.out.println("####clear() of bean");
	   super.clear();
	 //  forwardPractHash = null;
	}

	public void setForwardPractHash(ArrayList forwardPractHash) {
	   this.forwardPractHash = forwardPractHash;
	}

    public ArrayList getForwardPractHash() {
	   return forwardPractHash;
	}

    public ArrayList getAllPractitionerDetails(String practitioner_name,String ca_practitioner_id,String[] searchArray) throws Exception {
		//System.out.println("###in bean,getAllPractitionerDetails()#####");
		//System.out.println("###in bean,getAllPractitionerDetails(),ca_practitioner_id="+ca_practitioner_id);
		
        Connection connection 		= null;
        PreparedStatement pstmt 	= null;
        ResultSet resultSet 		= null;
        ArrayList practitioner_details	= new ArrayList();
		//String practitioner = ""; //Checkstyle
		String sql = "";
		
        try {
    		connection	= getConnection();
    		//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AM_PRACT"));
			sql = "SELECT b.practitioner_id code, AM_GET_DESC.AM_PRACTITIONER(b.practitioner_id,?,'1')  long_desc  FROM am_practitioner b where upper(b.practitioner_name) like (?) and eff_status ='E' and b.practitioner_id <> ? and upper(b.practitioner_id) like upper(?) order by 2";
    		//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_FORWARD_PRACT_SELECT"));
    		pstmt		= connection.prepareStatement( sql);
    		
			//if(searchArray[0].equals("D"))
			//{
				if(searchArray[1].equals("C"))
					practitioner_name = "%" + practitioner_name.trim().toUpperCase() + "%";
				else if(searchArray[1].equals("S"))
					practitioner_name = practitioner_name.trim().toUpperCase() + "%";
				else if(searchArray[1].equals("E"))
					practitioner_name = "%" + practitioner_name.trim().toUpperCase();
			//}
			/*else if (searchArray[0].equals("C"))
			{
				if(searchArray[1].equals("C"))
					practitioner_name = "%" + practitioner_name.trim().toUpperCase() + "%";
				else if(searchArray[1].equals("S"))
					practitioner_name = practitioner_name.trim().toUpperCase() + "%";
				else if(searchArray[1].equals("E"))
					practitioner_name = "%" + practitioner_name.trim().toUpperCase();
			}	*/

			//System.out.println("Query = > "+OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_FORWARD_PRACT_SELECT"));
			//System.out.println(" SearchArray = > "+searchArray[0]+" "+searchArray[1]+" practitioner_name = > "+practitioner_name+" ca_practitioner_id => "+ca_practitioner_id+" practitioner = > "+practitioner);
			pstmt.setString(1,language_id);
			if(searchArray[0].equals("D"))
			{
			pstmt.setString(2,practitioner_name);
			pstmt.setString(4,"%");
			}
    		else if(searchArray[0].equals("C")) 
			{
			pstmt.setString(2,"%");
			pstmt.setString(4,practitioner_name);
			}
			pstmt.setString(3,ca_practitioner_id);
			

			//System.out.println("========="+language_id+"========="+practitioner_name+"========="+ca_practitioner_id);
			resultSet	= pstmt.executeQuery() ;
    		if ( resultSet != null )    // Only one record for the module_id
    		{
				//System.out.println("##########");
    			while(resultSet.next())
    			{
    				String [] record = new String[2];
                    record[0] = resultSet.getString(1);
    				record[1] = resultSet.getString(2);
    				if (record[0] == null) record[0] = "";
    				if (record[1] == null) record[1] = "";
    				practitioner_details.add(record);
                }
    		}
    	}catch ( Exception e )	{
    		System.err.println( "getAllPractitionerDetails:"+e.getMessage() ) ;
    		e.printStackTrace() ;
    		throw e ;
    	} finally {
    		closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
    		closeConnection(connection);
    	}
    	return practitioner_details;
    } // End of getAllPractitionerDetails

  //  public HashMap insertForwardPract_id(ArrayList forwardPract_id){
    public HashMap insertForwardPract_id(){
		//System.out.println("###in insertForwardPract_id()#####");
		StringBuffer tmpBuff = new StringBuffer();
    	HashMap map = new HashMap() ;
        HashMap updt_map = new HashMap();
		HashMap sqlMap = new HashMap() ;
		ArrayList forwardPract_id = new ArrayList();
		//int result 				= 0;
		int int_total_records = Integer.parseInt(total_records);
        try {
//System.out.println("======total_records:=="+int_total_records);
			for(int i=0; i<int_total_records; i++){
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
					forwardPract_id.add((String)allValues.get("pract_id"+i));
				}
			}
		//	System.out.println("======Arraylidst:=="+forwardPract_id);
			updt_map.put("pract_id",pract_id);
			
			updt_map.put("forwardPract_id",forwardPract_id);
			
			traceVals.append(">>forwardPractHash :  >"+forwardPractHash);
			updt_map.put("forwardPractHash",forwardPractHash);
			traceVals.append(">>forwardPractHash :  >"+forwardPractHash);
			updt_map.put("login_by_id",login_by_id);
			traceVals.append(">>login_by_id :  >"+login_by_id);

            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") );
            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK",OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") );

			//ORReviewResultHome home = null ;
			//ORReviewResultRemote remote = null ;
//System.out.println("#####updt_map="+updt_map);
			try {
				updt_map.put( "properties", getProperties() );
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI") ) ;
				home  = (ORReviewResultHome) PortableRemoteObject.narrow( object, ORReviewResultHome.class ) ;
				
				remote = home.create() ;

				//ORReviewResultsManager remote1 = new ORReviewResultsManager();
				traceVals.append(">>before EJB :  >"+updt_map);
				map = remote.modify( updt_map, sqlMap ) ;
				traceVals.append("map value   >"+map);
                //System.out.println("traceVal="+traceVals.toString());*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"), ORReviewResultHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				//System.out.println("###map="+map);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				//System.out.println("#####11111111111updt_map="+updt_map);
				//System.out.println("#####11111111111sqlMap="+sqlMap);
				argArray	= null;
				paramArray	= null;
				//System.out.println("#####222222222updt_map="+updt_map);
				//System.out.println("#####222222222sqlMap="+sqlMap);
				/*boolean inserted = ( ((Boolean) map.get( "result" )).booleanValue() ) ;
				if(inserted){  			
					map.put( "result", new Boolean( true ) ) ;
					map.put( "message", (String) map.get("message") ) ;			
				}else{
					map.put( "result", new Boolean( false ) ) ;
				}*/
			map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				map.put("traceVal", (String)tmpBuff.toString());
			} catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}*/
			}


		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}  
		map.put("traceVal", traceVals.toString());
		//System.out.println("traceVals="+traceVals.toString());
		//System.out.println("########22222map="+map);
		return map;
	}

	public ArrayList getSysDateTime() throws Exception{
	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		ArrayList currentDate=new ArrayList();

		try{
			con=getConnection();
			pstmt=con.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_SCHEDULE_TODAY_DAY_TIME1"));
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){
				currentDate.add(rs.getString("curr_date"));
				currentDate.add(rs.getString("last_week_date"));
				currentDate.add(rs.getString("sys_date_time"));
			}
		
		}catch(Exception e){
			System.err.println("error in getSysDateTime() of ReviewResults.java="+e);
			e.printStackTrace();
			throw e;
		
		}finally{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(con);
		}

		return currentDate;	
	}
	
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		/*try{
		String perform_yn		= "";
		String hist_rec_type 	= "";
		String accession_num 	= "";
		
		 if(!allValues.containsKey("called_from")){
			int int_total_records = Integer.parseInt(total_records);
			for(int i=0; i<int_total_records; i++){
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("Y")){
					hist_rec_type		= (String)allValues.get("hist_rec_type"+i);
					accession_num		= (String)allValues.get("accession_num"+i);
					perform_yn			= getOperationalStatus(pract_id,hist_rec_type,accession_num);
					if(perform_yn.equalsIgnoreCase("N")){
						map.put( "result", new Boolean( false ) ) ;
						map.put( "message", "OR_STATUS_CHANGED" ) ;
						map.put( "invalidCode", ""+i ) ;
						break;
					}
				}
			}
		 }		
		
		}catch(Exception e){
			System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
		}*/

		 return map ;
	}

	public String getOperationalStatus(String pract_id, String hist_rec_type,String accession_num)throws Exception{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		String  valid_operation_yn		= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_RECEIVE_RESULT_STATUS") ) ;

			pstmt.setString(1, checkForNull(pract_id.trim(),""));
			pstmt.setString(2, checkForNull(hist_rec_type.trim(),""));
			pstmt.setString(3, checkForNull(accession_num.trim(),""));

			resultSet			= pstmt.executeQuery() ;

			while(resultSet != null && resultSet.next())
			{
				valid_operation_yn = checkForNull(resultSet.getString( "PERFORM_YN" ),"N")  ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error in getOperationalStatus method:"+e.getMessage() ) ;
			e.printStackTrace() ;
			throw e ;

		} finally {
			closeStatement(pstmt) ;
			closeResultSet(resultSet) ;
			closeConnection(connection) ;
		}

		return valid_operation_yn;

	}
}

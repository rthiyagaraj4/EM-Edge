/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;

public class ViewResults extends OrAdapter implements java.io.Serializable 
{
	protected String total_records	 		= "";
	protected String pract_id 				= "";
	protected Hashtable allValues 			= new Hashtable();
	protected ArrayList forwardPractHash    = null;

	StringBuffer traceVals 					= new StringBuffer();

	public void setMode(String mode){							this.mode = mode;								}
	public void setTotalRecs(String total_records){				this.total_records = total_records;				}
	public void setPractId(String pract_id){					this.pract_id = pract_id;						}

	public String getMode(){					return mode;	}
	public String getTotalRecs(){				return total_records;	}

	public String getClobData(String accen_num)throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String result_data = "";
	
		try
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_CLOB_DATA") ) ;
			pstmt.setString(1, (String)accen_num.trim());

			resultSet = pstmt.executeQuery() ;

			while(resultSet.next() ) 
			{
				Clob hist_data = resultSet.getClob("hist_data");
			
				if(hist_data!=null && hist_data.length() > 0)
					result_data = hist_data.getSubString(1,( (int)hist_data.length() ));
			}
		}
		catch ( Exception e )	
		{
			e.printStackTrace() ;
			throw e ;
		}
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		return result_data;
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

	public ArrayList getDetails(String pract_id,String priority,String normalcy_ind,String result_type,String resp_id,String patientId,String encounter_id,String encounter_chk,String group_by,String modal, String date_from, String date_to, int start, int end,String facilityid) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat			= new ArrayList() ;
		

		StringBuffer sqlStr			= new StringBuffer();
		String strNormalcyInd		= "";
		String conf_access_flag				="";

		try{
			if(normalcy_ind == null )	normalcy_ind = "*";
			if(result_type.equals(""))	
				result_type = "BLTF','LBIN','RDIN','TRET','PTCR";
			if(priority.equals(""))		priority = null;
			if(patientId==null)			patientId = "";
			if(encounter_id==null)		encounter_id = "";
			if(encounter_chk==null)		encounter_chk = "Y";
			if(group_by==null)			group_by = "";


			if (modal == null) modal = "";

			if(encounter_chk.equals("N"))
				encounter_id = null;				

			connection = getConnection() ;

			if (normalcy_ind.equals("N") ) 
				strNormalcyInd = "*";
			else if (normalcy_ind.equals("A")) 
				pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_ABNORMAL_SELECT"));
			else if (normalcy_ind.equals("C")) 
				pstmt1 = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_CRITICAL_ABNORMAL_SELECT"));
			
			if(normalcy_ind.equals("A") || normalcy_ind.equals("C"))
			{
				resultSet = pstmt1.executeQuery();
			
				if (resultSet != null && resultSet.next()) {
				
					strNormalcyInd = resultSet.getString(1);
						
				}
			
				closeResultSet( resultSet ) ;
			}
			

			if(strNormalcyInd == null || strNormalcyInd.equals("*") || strNormalcyInd.equals("") )
				strNormalcyInd="'*','A','C','N'";

			if(strNormalcyInd != null && (!strNormalcyInd.equals("")))
				strNormalcyInd=strNormalcyInd.substring(1,strNormalcyInd.length()-1);


			pstmt = connection.prepareStatement("select nvl(GET_TASK_APPLICABILITY(?,NULL,?,NULL),'X') conf_access_flag from dual");
			pstmt.setString(1,"VIEW_CONF_RESULT");
			pstmt.setString(2,resp_id);
			resultSet = pstmt.executeQuery();
	
			if(resultSet != null && resultSet.next())
				conf_access_flag=resultSet.getString("conf_access_flag");


//			sqlStr = OrRepository.getOrKeyValue("SQL_OR_VIEW_RESULTS_SELECT");
			//sqlStr.append("SELECT d.hist_data,b.short_desc event_short_desc , a.EVENT_CODE discr_msr_id, result_num_prefix || DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(RESULT_NUM), TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) RESULT_NUM , result_num_uom,result_str  result_str,to_char(a.event_date,'dd/mm/yyyy hh24:mi') reporting_date, TO_CHAR (NVL (a.event_auth_date_time, a.event_date), 'dd/mm/yyyy hh24:mi') resulting_date, NORMALCY_IND result_status, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_LOW), TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_LOW, DECODE( NVL(RESULT_NUM_DEC,'0'),'0',TO_CHAR(NORMAL_HIGH), TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000' ,8,'999999990.90000000',9,'999999990.90000000'))) NORMAL_HIGH ,critical_low, critical_high, NORMALCY_IND norm_abnorm_ind, c.long_desc  parent_short_desc, b.long_desc child_desc, HIST_DATA_TYPE result_desc ,a.PRACTITIONER_ID PRACTITIONER_ID,a.ext_image_obj_id ext_image_obj_id,a.ext_image_appl_id ext_image_appl_id,a.performed_by_id reporting_practitioner,a.hist_rec_type hist_rec_type,a.accession_num accession_num,a.contr_sys_event_code contr_sys_event_code,a.CONTR_SYS_ID,A.EVENT_CLASS,A.EVENT_GROUP FROM Cr_encounter_DETAIL a,cr_clin_event_mast b,cr_clin_event_group c,cr_encounter_detail_txt d WHERE a.hist_rec_type  in (?)  and a.encounter_id = nvl(?,a.encounter_id) and b.hist_rec_type =a.hist_rec_type and b.event_code =a.event_code  and c.hist_rec_type(+) = a.hist_rec_type and c.event_group(+) =a.event_group and a.patient_id=(?) and 'A' = decode(PROTECTION_IND,'Z',GET_TASK_APPLICABILITY('VIEW_CONF_RESULT','',?,null),'A') and nvl(a.status,'#') != 'S' and a.event_date between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy') and nvl(a.normalcy_ind,'*') in ( ? ) and a.hist_rec_type =  d.hist_rec_type(+) and a.accession_num = d.accession_num(+) and a.facility_id = ? ");
			/************************************/

			sqlStr.setLength(0);
			sqlStr.append("SELECT" );
			sqlStr.append("  d.hist_data" );
			sqlStr.append("  , b.short_desc event_short_desc" );
			sqlStr.append("  , e.short_desc hist_rec_type_desc" );
			sqlStr.append("  , a.event_code discr_msr_id" );
			sqlStr.append("  , result_num_prefix || DECODE (NVL (result_num_dec, '0'), '0', TO_CHAR (result_num), TO_CHAR (result_num, DECODE (result_num_dec, 1, '999999990.0', 2, '999999990.90', 3, '999999990.900', 4, '999999990.9000', 5, '999999990.90000', 6, '999999990.900000', 7, '999999990.9000000', 8, '999999990.90000000', 9, '999999990.90000000' ) ) ) result_num" );
			sqlStr.append("  , result_num_uom" );
			sqlStr.append("  , result_str result_str" );
			sqlStr.append("  , TO_CHAR (a.event_date, 'dd/mm/yyyy hh24:mi') reporting_date" );
			sqlStr.append("  , TO_CHAR (NVL (a.event_auth_date_time, a.event_date), 'dd/mm/yyyy hh24:mi' ) resulting_date" );
			sqlStr.append("  , normalcy_ind result_status" );
			sqlStr.append("  , DECODE (NVL (result_num_dec, '0'), '0', TO_CHAR (normal_low), TO_CHAR (normal_low, DECODE (result_num_dec, 1, '999999990.0', 2, '999999990.90', 3, '999999990.900', 4, '999999990.9000', 5, '999999990.90000', 6, '999999990.900000', 7, '999999990.9000000', 8, '999999990.90000000', 9, '999999990.90000000' ) ) ) normal_low" );
			sqlStr.append("  , DECODE (NVL (result_num_dec, '0'), '0', TO_CHAR (normal_high), TO_CHAR (normal_high, DECODE (result_num_dec, 1, '999999990.0', 2, '999999990.90', 3, '999999990.900', 4, '999999990.9000', 5, '999999990.90000', 6, '999999990.900000', 7, '999999990.9000000', 8, '999999990.90000000', 9, '999999990.90000000' ) ) ) normal_high" );
			sqlStr.append("  , critical_low" );
			sqlStr.append("  , critical_high" );
			sqlStr.append("  , normalcy_ind norm_abnorm_ind" );
			sqlStr.append("  , c.long_desc parent_short_desc" );
			sqlStr.append("  , b.long_desc child_desc" );
			sqlStr.append("  , hist_data_type result_desc" );
			sqlStr.append("  , a.practitioner_id practitioner_id" );
			sqlStr.append("  , a.ext_image_obj_id ext_image_obj_id" );
			sqlStr.append("  , a.ext_image_appl_id ext_image_appl_id" );
			sqlStr.append("  , a.performed_by_id reporting_practitioner" );
			sqlStr.append("  , a.hist_rec_type hist_rec_type" );
			sqlStr.append("  , a.accession_num accession_num" );
			sqlStr.append("  , a.contr_sys_event_code contr_sys_event_code" );
			sqlStr.append("  , a.contr_sys_id" );
			sqlStr.append("  , a.event_class" );
			sqlStr.append("  , a.event_group " );
			sqlStr.append("  , NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE  = A.hist_rec_type    	 AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM          =a.accession_num	AND CONTR_SYS_EVENT_CODE=   A.contr_sys_event_code) ,'N') text_exisits " );
			sqlStr.append("FROM" );
			sqlStr.append("  cr_encounter_detail a" );
			sqlStr.append("  , cr_clin_event_mast b" );
			sqlStr.append("  , cr_clin_event_group c" );
			sqlStr.append("  , cr_encounter_detail_txt d " );
			sqlStr.append("  , CR_HIST_REC_TYPE e " );
			//sqlStr.append("WHERE a.hist_rec_type IN ('"+result_type+"') " );//common-icn-0180
			sqlStr.append("WHERE a.hist_rec_type IN (?) " );//common-icn-0180
			sqlStr.append("  AND a.encounter_id = NVL (?, a.encounter_id) " );
			sqlStr.append("  AND b.hist_rec_type = a.hist_rec_type " );
			sqlStr.append("  AND e.hist_rec_type = a.hist_rec_type " );
			sqlStr.append("  AND b.event_code = a.event_code " );
			sqlStr.append("  AND B.EVENT_CODE_TYPE=A.EVENT_CODE_TYPE " );
			sqlStr.append("  AND c.hist_rec_type(+) = a.hist_rec_type " );
			sqlStr.append("  AND c.event_group(+) = a.event_group " );
			sqlStr.append("  AND C.EVENT_GROUP_TYPE(+)=A.EVENT_GROUP_TYPE " );
			//sqlStr.append("  AND a.patient_id = '"+patientId+"' " );//common-icn-0180
			sqlStr.append("  AND a.patient_id = ? " );//common-icn-0180
			//sqlStr.append("  AND a.event_date BETWEEN TO_DATE ('"+date_from+"', 'dd/mm/yyyy') " );//common-icn-0180
			sqlStr.append("  AND a.event_date BETWEEN TO_DATE (?, 'dd/mm/yyyy') " );//common-icn-0180
			//sqlStr.append("  AND TO_DATE ('"+date_to+"', 'dd/mm/yyyy') " );//common-icn-0180
			sqlStr.append("  AND TO_DATE (?, 'dd/mm/yyyy') " );//common-icn-0180
			sqlStr.append("  AND NVL (a.status, '#') not in ('S','E') " );
			//sqlStr.append("  AND NVL(a.normalcy_ind, '*') IN ('"+strNormalcyInd+"') " );//common-icn-0180
			sqlStr.append("  AND NVL(a.normalcy_ind, '*') IN (?) " );//common-icn-0180
			sqlStr.append("  AND a.hist_rec_type = d.hist_rec_type(+) " );
			sqlStr.append("  AND A.CONTR_SYS_ID =D.CONTR_SYS_ID (+) " );
			sqlStr.append("  AND a.accession_num = d.accession_num(+) " );
			sqlStr.append("  AND A.CONTR_SYS_EVENT_CODE =D.CONTR_SYS_EVENT_CODE(+) " );
			//sqlStr.append("  AND a.facility_id = '"+facilityid+"'" );//common-icn-0180
			sqlStr.append("  AND a.facility_id = ? " );//common-icn-0180

			/************************************/
			if (conf_access_flag.equals("X")) 
				sqlStr.append(" and nvl(PROTECTION_IND,'N')!='Z' ");
			
			if(group_by.equals("E"))
				sqlStr.append("order by hist_rec_type,reporting_practitioner,event_short_desc,resulting_date");
			else
				sqlStr.append("order by hist_rec_type,reporting_practitioner,resulting_date,event_short_desc");

			

			pstmt.close();
			resultSet.close();

			pstmt = connection.prepareStatement(sqlStr.toString()) ;
			//pstmt.setString(1,encounter_id);//common-icn-0180
			//common-icn-0180 starts
			pstmt.setString(1,result_type);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,patientId);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);
			pstmt.setString(6,strNormalcyInd);
			pstmt.setString(7,facilityid);
			
			//common-icn-0180 ends
			
			/*pstmt.setString(1,result_type);

			pstmt.setString(3,patientId);
			pstmt.setString(4,date_from);
			pstmt.setString(5,date_to);
			pstmt.setString(6,strNormalcyInd);
			pstmt.setString(7,facilityid);*/
			resultSet = pstmt.executeQuery();


			if(resultSet!=null) 
			{

				if(start > 0)
					for(int i=0;((i<(start-1)) && resultSet.next());i++);				
				while((start <= end) && resultSet.next()) 
				{
						String[] record = new String[29];
						record[0] = resultSet.getString( "hist_data" )  ;
						record[1] = resultSet.getString( "event_short_desc" )  ;
						record[2] = resultSet.getString( "discr_msr_id" )  ;
						record[3] = resultSet.getString( "RESULT_NUM" )  ;
						record[4] = resultSet.getString( "result_num_uom" )  ;
						record[5] = resultSet.getString( "result_str" )  ;
						record[6] = resultSet.getString( "reporting_date" )  ;
						record[7] = resultSet.getString( "resulting_date" )  ;
						record[8] = resultSet.getString( "result_status" )  ;
						record[9] = resultSet.getString( "NORMAL_LOW" )  ;
						record[10] = resultSet.getString( "NORMAL_HIGH" )  ;
						record[11] = resultSet.getString( "critical_low" )  ;
						record[12] = resultSet.getString( "critical_high" )  ;
						record[13] = resultSet.getString( "parent_short_desc" )  ;
						record[14] = resultSet.getString( "child_desc" )  ;
						record[15] = resultSet.getString( "result_desc" )  ;
						record[16] = resultSet.getString( "PRACTITIONER_ID" )  ;
						record[17] = resultSet.getString( "ext_image_obj_id" )  ;
						record[18] = resultSet.getString( "ext_image_appl_id" )  ;
						record[19] = resultSet.getString( "reporting_practitioner" )  ;
						record[20] = resultSet.getString( "hist_rec_type" )  ;
						record[21] = resultSet.getString( "accession_num" )  ;
						record[22] = resultSet.getString( "contr_sys_event_code" )  ;
						record[23] = resultSet.getString( "CONTR_SYS_ID" )  ;
						record[24] = resultSet.getString( "EVENT_CLASS" )  ;
						record[25] = resultSet.getString( "EVENT_GROUP" )  ;
						record[27] = resultSet.getString( "hist_rec_type_desc" )  ;
						record[28] = resultSet.getString( "text_exisits" )  ;
						
						OrderCat.add(record) ;
						start++;
					}
			

					if (resultSet.next())
					{
						String[] templist = (String[])OrderCat.get(0);
						templist[26] = ""+(end+7);
						OrderCat.set(0,templist);
					}
				
			}
				
		} catch ( Exception e )	{

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

	public String returnClobValue(String HistRecType,String ContrSysId,String AccessionNum,String ContrSysEventCode)
	{
		Connection con 		= null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String displaydata ="";
		String sql="";
		try{
			con = getConnection() ;
			if(HistRecType.equals("CLNT"))
			{
				sql = " SELECT CA_CLOB_REPLACE(HIST_DATA,'/eHIS/eCommon/html/IeStyle.css',' ') FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? ";
			}
			else
			{
				sql = " SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = ? AND CONTR_SYS_ID = ? AND ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ? ";
			}
			stmt = con.prepareStatement(sql);

			stmt.setString(1, HistRecType);
			stmt.setString(2, ContrSysId);
			stmt.setString(3, AccessionNum);
			stmt.setString(4, ContrSysEventCode);

			rs = stmt.executeQuery();
			if(rs.next())
			{
				Clob note=rs.getClob(1);
				displaydata = "";
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) displaydata=displaydata+line+"\n";					
				}
			}
			return displaydata;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			closeConnection(con);
			}catch(Exception e)
			{}
		}
		return displaydata;
	}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		allValues = recordSet;

		if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));					}
		if(recordSet.containsKey("practitioner_id")){	
			setPractId((String)recordSet.get("practitioner_id"));				}

		this.mode = (String)recordSet.get( "mode" );
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
			pstmt.setString(1,checkForNull(login_user));
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
	   super.clear();
	 //  forwardPractHash = null;
	}

	
    public ArrayList getAllPractitionerDetails(String practitioner_name,String ca_practitioner_id) throws Exception {
		
        Connection connection 		= null;
        PreparedStatement pstmt 	= null;
        ResultSet resultSet 		= null;
        ArrayList practitioner_details	= new ArrayList();

        try {
    		connection	= getConnection();
    		//pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AM_PRACT"));
    		pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_FORWARD_PRACT_SELECT"));
    		if (practitioner_name != null) practitioner_name = practitioner_name.toUpperCase() + "%";
    		pstmt.setString(1,practitioner_name);
    		pstmt.setString(2,ca_practitioner_id);
			resultSet	= pstmt.executeQuery() ;
    		if ( resultSet != null )    // Only one record for the module_id
    		{
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

    		e.printStackTrace() ;
    		throw e ;
    	} finally {
    		closeResultSet( resultSet ) ;
    		closeStatement( pstmt ) ;
    		closeConnection(connection);
    	}
    	return practitioner_details;
    } // End of getAllPractitionerDetails


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
		try{
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
			e.printStackTrace();
		}

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

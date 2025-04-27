/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
01/07/2020			        chandrashekar Raju							              AAKH-CRF-0122.2
20/08/2020      IN073540    Chandrashekar Raju                                        AAKH-CRF-0122.3
16/03/2021		15950		Nijitha S											Common-ICN-0030
31/10/2022                  Kamatchi S                                          TH-KW-CRF-0143
16/03/2022       41064      krishna pranay      16/03/2023     Ramesh Goli      AAKH-CRF-0172
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.io.Serializable;
import java.sql.*;
import java.util.*;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import eCommon.SingleTableHandler.*;



import webbeans.eCommon.ConnectionManager;
 
import eCA.Common.CaAdapter;



public class CACoderFunction extends CaAdapter implements Serializable {

	
	
	
	public String  getPatientDischargedDate(String encounter_id) throws Exception {
		
		Connection connection	= null;
		String  discharge_date = "" ;
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		String sql="";

		sql = " select discharge_date_time from pr_encounter where facility_id= ? and encounter_id= ?";
      try{
		    connection			= getConnection();
			pStatment = connection.prepareStatement(sql);
			pStatment.setString(1, login_facility_id);
			pStatment.setString(2, encounter_id); 

			resultSet = pStatment.executeQuery();

			if(resultSet.next())
			{
				discharge_date =resultSet.getString("discharge_date_time")==null?"":resultSet.getString("discharge_date_time");
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			closeConnection( connection ); //15950 Fix
		}

	return discharge_date;
}	
public HashMap getBillingValidation(String encounter_id,String locale){
	
		Connection connection	= null;
		CallableStatement cstmt = null ;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		HashMap message						= new HashMap();
		String session_id ="";
		
			try{
				connection			= getConnection();
				pstmt		= connection.prepareStatement( "SELECT USERENV('SESSIONID') session_id from dual") ;
				resultSet	= pstmt.executeQuery() ;
				while (resultSet.next()){
					session_id		=	resultSet.getString("session_id");		
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			//System.err.println("login_facility_id@@==="+login_facility_id+"session_id==="+session_id+"locale==="+locale+"encounter_id---"+encounter_id+"login_by_id==="+login_by_id+"login_at_ws_no==="+login_at_ws_no);
					cstmt=connection.prepareCall("{call bl_coders.populate_billing_services(?,?,?,?,?,?,?,?,?) }"); 
						cstmt.setString(1,login_facility_id);
						cstmt.setString(2,session_id);
						cstmt.setString(3,locale);
						cstmt.setString(4,encounter_id);
						cstmt.setString(5,login_by_id);
						cstmt.setString(6,login_at_ws_no);
						cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);

						cstmt.execute();

						message.put("p_error_text" , checkForNull((String)cstmt.getString(8)));
			            message.put("transction_status" , checkForNull((String)cstmt.getString(7)));
						message.put("session_id" , checkForNull(session_id));
						
			             closeStatement( cstmt );
						}catch(Exception e){
							e.printStackTrace();
						}
						finally{
							try{
								closeStatement( cstmt ) ;
								closeResultSet( resultSet ) ;
				                closeStatement( pstmt ) ;
								closeConnection( connection ); 

							}catch(Exception e){
							   e.printStackTrace();
							}
						}
					
				return message;
		}

public String getPatientIDLength()
	{
		Connection connection 		= null;
		Statement patIdLenStmt 	= null;
		ResultSet patIdLenRs = null;
		String patientLength="";
		try
		{
			connection = ConnectionManager.getConnection();
			patIdLenStmt = connection.createStatement();
			patIdLenRs = patIdLenStmt.executeQuery(" SELECT PATIENT_ID_LENGTH FROM MP_PARAM ");
			while(patIdLenRs.next())
			{
				patientLength = patIdLenRs.getString("PATIENT_ID_LENGTH");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(patIdLenRs!=null)
					patIdLenRs.close();
				if(patIdLenStmt != null) 
					patIdLenStmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return patientLength;
	}

public ArrayList getCoderStatus(String patient_id,String encounter_id)
	{
		Connection connection 		= null;
		PreparedStatement psmt 	= null;
		ResultSet rs = null;
		String sql ="";
		ArrayList status_record= new ArrayList();

		try
		{
		//	sql         = " SELECT REMARKS,STATUS,TO_CHAR(COMPLETE_DATE,'DD/MM/YYYY HH24:MI') COMPLETE_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = COMPLETED_BY)AUTHOR_NAME FROM CA_CODER_STATUS  WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ?";
			sql         = " SELECT REMARKS,STATUS,TO_CHAR(COMPLETE_DATE,'DD/MM/YYYY HH24:MI') COMPLETE_DATE,(SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = COMPLETED_BY) AUTHOR_NAME, TO_CHAR(SUPERVISOR_DATE,'DD/MM/YYYY HH24:MI') SUPERVISOR_DATE, (SELECT APPL_USER_NAME FROM SM_APPL_USER WHERE APPL_USER_ID = SUPERVISOR_BY) SUPERVISOR_NAME FROM CA_CODER_STATUS  WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ?";//41064
			connection			= getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, patient_id);
			psmt.setString(2, encounter_id); 
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				status_record.add( rs.getString("REMARKS"));
				status_record.add( rs.getString("STATUS"));
				status_record.add( rs.getString("COMPLETE_DATE"));
				status_record.add( rs.getString("AUTHOR_NAME"));
				status_record.add( rs.getString("SUPERVISOR_DATE"));//41064 
				status_record.add( rs.getString("SUPERVISOR_NAME"));//41064 
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(psmt != null) 
					psmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return status_record;
	}

	public ArrayList  getCoderSearchResult(String patient_class,String patient_id,String encounter_id,String from_date,String to_date,String status, String visit_list,String Clin_id) throws Exception {
		
		Connection connection	= null;
		//String  discharge_date = "" ;  //COMMON-ICN-0122
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		//String sql="";  //COMMON-ICN-0122
		StringBuffer sbSQL = new StringBuffer();
		ArrayList patient_list  =new ArrayList();
		
	//	sbSQL.append(" SELECT A.PATIENT_ID ,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.BLNG_GRP_ID,TO_CHAR (A.VISIT_ADMN_DATE, 'DD/MM/YYYY') ENCOUNTER_DATE,A.DISCHARGE_DATE_TIME,A.PRACTITIONER_NAME,A.PATIENT_NAME,A.GENDER,DECODE (STATUS,'SQ', 'SUPERVISOR QUERY','DQ', 'DOCTOR QUERY','PC', 'PARTIALLY COMPLETED','HD', 'HOLD','CO', 'COMPLETED','NW', 'NEW','NEW') STATUS FROM BL_CODER_VISIT_SHEET_VW A,CA_CODER_STATUS M WHERE A.PATIENT_ID = M.PATIENT_ID(+) AND A.ENCOUNTER_ID = M.ENCOUNTER_ID(+) AND A.PATIENT_CLASS =M.PATIENT_CLASS(+) AND A.DISCHARGE_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')+1");
		sbSQL.append(" SELECT A.PATIENT_ID ,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.BLNG_GRP_ID,TO_CHAR (A.VISIT_ADMN_DATE, 'DD/MM/YYYY') ENCOUNTER_DATE,A.DISCHARGE_DATE_TIME,A.PRACTITIONER_NAME,A.PATIENT_NAME,A.GENDER,DECODE (STATUS,'SQ', 'SUPERVISOR QUERY','DQ', 'DOCTOR QUERY','PC', 'PARTIALLY COMPLETED','HD', 'HOLD','CO', 'COMPLETED', 'SC', 'SUPERVISOR CLEARANCE COMPLETED','NW', 'NEW','NEW') STATUS FROM BL_CODER_VISIT_SHEET_VW A,CA_CODER_STATUS M WHERE A.PATIENT_ID = M.PATIENT_ID(+) AND A.ENCOUNTER_ID = M.ENCOUNTER_ID(+) AND A.PATIENT_CLASS =M.PATIENT_CLASS(+) AND A.DISCHARGE_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')+1");//41064

		if(!patient_id.equals("")) 
			sbSQL.append(" AND A.PATIENT_ID = ? ");
		if(!encounter_id.equals(""))
            sbSQL.append(" AND A.ENCOUNTER_ID = ? ");
		if(!patient_class.equals(""))
			sbSQL.append(" AND A.PATIENT_CLASS = ? ");
		if(!status.equals("*A"))
			sbSQL.append(" AND M.STATUS = ? ");
		if(!visit_list.equals("*A"))
			sbSQL.append(" AND m.ASSIGNED_PRACTITIONER_ID = ? ");

           sbSQL.append(" ORDER BY DISCHARGE_DATE_TIME ");
		
      try{
		    connection			= getConnection();
			int i=1;
			//System.err.println("for CACoder search==="+sbSQL.toString());
			pStatment = connection.prepareStatement(sbSQL.toString());
			pStatment.setString(i++, from_date);
			pStatment.setString(i++, to_date);
			if(!patient_id.equals(""))
				pStatment.setString(i++, patient_id);
			if(!encounter_id.equals(""))
				pStatment.setString(i++, encounter_id);
			if(!patient_class.equals(""))
				pStatment.setString(i++, patient_class);
			if(!status.equals("*A"))
				pStatment.setString(i++, status);
			if(!visit_list.equals("*A"))
				pStatment.setString(i++, Clin_id);
			System.out.println("SQL statement ::::::::  "+sbSQL.toString());
			System.out.println("pStatment :::::::::::::::: "+pStatment.toString());

			resultSet = pStatment.executeQuery();

			while (resultSet !=null && resultSet.next() ){
			
				patient_list.add(resultSet.getString("ENCOUNTER_DATE")==null?"":resultSet.getString("ENCOUNTER_DATE"));
				patient_list.add(resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID"));
				patient_list.add(resultSet.getString("PATIENT_ID")==null?"":resultSet.getString("PATIENT_ID"));
				patient_list.add(resultSet.getString("PATIENT_NAME")==null?"":resultSet.getString("PATIENT_NAME"));
				patient_list.add(resultSet.getString("GENDER")==null?"":resultSet.getString("GENDER"));
				patient_list.add(resultSet.getString("PRACTITIONER_NAME")==null?"":resultSet.getString("PRACTITIONER_NAME"));
				patient_list.add(resultSet.getString("BLNG_GRP_ID")==null?"":resultSet.getString("BLNG_GRP_ID"));
				patient_list.add(resultSet.getString("STATUS")==null?"":resultSet.getString("STATUS"));
				patient_list.add(resultSet.getString("DISCHARGE_DATE_TIME")==null?"":resultSet.getString("DISCHARGE_DATE_TIME"));
				patient_list.add(resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			closeConnection( connection ); //15950 Fix
		}

	return patient_list;

}public ArrayList  getPendingQueryResult(String patient_id,String from_date,String to_date,String called_from,String locale,String Clin_id) throws Exception {
		
		Connection connection	= null;
		ArrayList  pendingRecords = new ArrayList();
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		String sql="";

		sql = " SELECT A.PATIENT_ID,A.ENCOUNTER_ID ,A.PATIENT_CLASS,TO_CHAR(A.DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI')DISCHARGE_DATE_TIME,DISCH_PRACTITIONER_NAME,a.patient_name,(a.patient_id || ', '|| AGE|| ','|| GENDER|| ','|| A.PATIENT_CLASS || ', '|| A.ENCOUNTER_ID|| ','|| PRACTITIONER_NAME|| ','|| CLINIC_SPLTY_NAME) PATIENT_DETAILS,C.REMARKS FROM bl_coder_visit_sheet_vw A, CA_CODER_STATUS C WHERE  A.PATIENT_ID =C.PATIENT_ID AND   A.ENCOUNTER_ID =C.ENCOUNTER_ID AND TRUNC (c.added_date) BETWEEN TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')+1";

		if(called_from.equals("DQ")){
			sql =sql+ " AND C.STATUS ='DQ' ";
		    sql =sql + " ANd  A.PRACTITIONER_ID = ?";
		}else if(called_from.equals("SQ")){
			sql =sql + " ANd  ? = (select practitioner_id from am_practitioner where SUPERVISOR_YN = 'Y' AND practitioner_id=?)";
			sql =sql+ " AND C.STATUS ='SQ' ";
		}
		if(!patient_id .equals(""))
			sql =sql + " AND A.PATIENT_ID = ? ";
		sql =sql + " ORDER BY C.ADDED_DATE DESC ";
      try{
		    connection			= getConnection();

			System.err.println("sqlpending query@@==="+sql);
			pStatment = connection.prepareStatement(sql);
			
			
			pStatment.setString(1, from_date); 
			pStatment.setString(2, to_date);
			if(called_from.equals("DQ")){
				pStatment.setString(3, Clin_id);
				if(!patient_id .equals(""))
				pStatment.setString(4, patient_id); 
			}else{
				pStatment.setString(3, Clin_id);
				pStatment.setString(4, Clin_id);
				if(!patient_id .equals(""))
				pStatment.setString(5, patient_id); 
			}
			
			resultSet = pStatment.executeQuery();

			while (resultSet !=null && resultSet.next() )
			{
				pendingRecords.add(resultSet.getString("DISCH_PRACTITIONER_NAME")==null?"":resultSet.getString("DISCH_PRACTITIONER_NAME"));
				pendingRecords.add(resultSet.getString("DISCHARGE_DATE_TIME")==null?"":resultSet.getString("DISCHARGE_DATE_TIME"));
				pendingRecords.add(resultSet.getString("PATIENT_DETAILS")==null?"":resultSet.getString("PATIENT_DETAILS"));		
				pendingRecords.add(resultSet.getString("REMARKS")==null?"":resultSet.getString("REMARKS"));
				pendingRecords.add(resultSet.getString("PATIENT_ID")==null?"":resultSet.getString("PATIENT_ID"));
				pendingRecords.add(resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID"));
				pendingRecords.add(resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
				pendingRecords.add(resultSet.getString("patient_name")==null?"":resultSet.getString("patient_name"));
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			closeConnection( connection ); //15950 Fix
		}

	return pendingRecords;
}	

public ArrayList  getCoderReviwResult(String patient_id,String dtFrom,String dtTo,String Clin_id,
		String encounterCode,String clinicCode,String splCode,String attendingPractCode,String episode_type,
		String encodingstatusCode,String etFrom,String etTo,String billingGroupCode,String customergroupCode,
		String customerCode,String policycode,String dtEmpty,String etEmpty) throws Exception {
		
		Connection connection	= null;
		ArrayList  reviewResult = new ArrayList();
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		String sql="";
		int countIndex=1;
		System.out.println("----patient_id------->"+patient_id+"<------------");
		
		sql = " SELECT A.PATIENT_ID,A.ENCOUNTER_ID,A.PATIENT_CLASS,(   PATIENT_NAME || ', '|| AGE|| ','|| GENDER|| ','|| A.PATIENT_CLASS || ', '|| A.ENCOUNTER_ID|| ','|| PRACTITIONER_NAME|| ','|| CLINIC_SPLTY_NAME) PATIENT_DETAILS,(   'CUST: '|| CUST_CODE|| ' , BLNG GROUP: '|| BLNG_GRP_ID|| ' , POLICY TYPE: '|| POLICY_TYPE_CODE|| ' , POLICYNO: '|| POLICY_NUMBER) PAYER_DETAILS,A.VISIT_TYPE,C.REMARKS,C.ENCOUNTER_ID ENC_ID,C.ASSIGNED_PRACTITIONER_ID CODER_ID, (select PRACTITIONER_NAME from am_practitioner where practitioner_id =C.ASSIGNED_PRACTITIONER_ID) CODER_DESC,a.DISCHARGE_DATE_TIME FROM bl_coder_visit_sheet_vw A, CA_CODER_STATUS C WHERE  A.PATIENT_ID =C.PATIENT_ID(+) AND   A.ENCOUNTER_ID =C.ENCOUNTER_ID(+)  AND A.PATIENT_CLASS =C.PATIENT_CLASS(+)  AND ( C.STATUS NOT IN ('CO') OR C.STATUS IS NULL)  AND  ? = (select practitioner_id from am_practitioner where SUPERVISOR_YN = 'Y' AND practitioner_id=?) ";
		
		if(dtEmpty .equals("N"))
			sql =sql + " AND A.DISCHARGE_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+1  ";
		
		if(etEmpty .equals("N"))
			sql =sql + " AND A.VISIT_ADMN_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY')+1  ";
		
		if(!patient_id .equals(""))
			sql =sql + " AND A.PATIENT_ID = ? ";
		
		if(!encounterCode .equals(""))
			sql =sql + " AND A.ENCOUNTER_ID = ? ";
		if(!clinicCode .equals(""))
			sql =sql + " AND A.ASSIGN_CARE_LOCN_CODE = ? ";
		if(!splCode .equals(""))
			sql =sql + " AND A.SPECIALTY_CODE = ? ";
		if(!attendingPractCode .equals(""))
			sql =sql + " AND A.PRACTITIONER_ID = ? ";
		if(!episode_type .equals(""))
			sql =sql + " AND A.PATIENT_CLASS = ? ";
		if(!encodingstatusCode .equals(""))
			sql =sql + " AND C.STATUS = ? ";	
		if(!billingGroupCode .equals(""))
			sql =sql + " AND A.BLNG_GRP_ID = ? ";
		if(!customergroupCode .equals(""))
			sql =sql + " AND A.CUST_GROUP_CODE = ? ";
		if(!customerCode .equals(""))
			sql =sql + " AND A.CUST_CODE = ? ";
		if(!policycode .equals(""))
			sql =sql + " AND A.POLICY_TYPE_CODE = ? ";
			
		 sql =sql + " ORDER BY DISCHARGE_DATE_TIME  DESC ";
		 
		 System.out.println("sql===>"+sql);
      try{
		    connection			= getConnection();		
			pStatment = connection.prepareStatement(sql);
		
					
			pStatment.setString(countIndex++, Clin_id); 
			pStatment.setString(countIndex++, Clin_id); 
			System.out.println("Clin_id===>"+Clin_id);
			System.out.println("Clin_id===>"+Clin_id);
			if(dtEmpty .equals("N")){
				pStatment.setString(countIndex++, dtFrom); 
				pStatment.setString(countIndex++, dtTo); 
			}
			if(etEmpty .equals("N")){
				System.out.println("etFrom===>"+etFrom+"<============");
				System.out.println("etTo===>"+etTo+"<==============");
				pStatment.setString(countIndex++, etFrom ); 
				pStatment.setString(countIndex++, etTo); 
			}
			if(!patient_id .equals(""))
				pStatment.setString(countIndex++, patient_id); 
 
			// newly added
			if(!encounterCode .equals(""))
				pStatment.setString(countIndex++, encounterCode);
			if(!clinicCode .equals(""))
				pStatment.setString(countIndex++, clinicCode);
			if(!splCode .equals(""))
				pStatment.setString(countIndex++, splCode);			
			if(!attendingPractCode .equals(""))
				pStatment.setString(countIndex++, attendingPractCode);
			if(!episode_type .equals(""))
				pStatment.setString(countIndex++, episode_type);
			if(!encodingstatusCode .equals(""))
				pStatment.setString(countIndex++, encodingstatusCode);			
			if(!billingGroupCode .equals(""))
				pStatment.setString(countIndex++, billingGroupCode);
			if(!customergroupCode .equals(""))
				pStatment.setString(countIndex++, customergroupCode);
			if(!customerCode .equals(""))
				pStatment.setString(countIndex++, customerCode);
			if(!policycode .equals(""))
				pStatment.setString(countIndex++, policycode);
			
			System.out.println("pStatment    ::::::::::::: "+pStatment.toString());
			resultSet = pStatment.executeQuery();

			while (resultSet !=null && resultSet.next() )
			{
				
				reviewResult.add(resultSet.getString("PATIENT_ID")==null?"":resultSet.getString("PATIENT_ID"));
				reviewResult.add(resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID"));
				reviewResult.add(resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
				reviewResult.add(resultSet.getString("PATIENT_DETAILS")==null?"":resultSet.getString("PATIENT_DETAILS"));
				reviewResult.add(resultSet.getString("PAYER_DETAILS")==null?"":resultSet.getString("PAYER_DETAILS"));
				reviewResult.add(resultSet.getString("VISIT_TYPE")==null?"":resultSet.getString("VISIT_TYPE"));		
				reviewResult.add(resultSet.getString("REMARKS")==null?"":resultSet.getString("REMARKS"));
				reviewResult.add(resultSet.getString("ENC_ID")==null?"":resultSet.getString("ENC_ID"));
				reviewResult.add(resultSet.getString("CODER_ID")==null?"":resultSet.getString("CODER_ID"));
				reviewResult.add(resultSet.getString("CODER_DESC")==null?"":resultSet.getString("CODER_DESC"));

				
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			closeConnection( connection ); //15950 Fix
		}
     
	return reviewResult;
 }	

 public ArrayList  getCoderPendingRecordsResult(String patient_id,String from_date,String to_date,String Clin_id) throws Exception {
		
		Connection connection	= null;
		//String  discharge_date = "" ;  //COMMON-ICN-0122
		PreparedStatement pStatment = null;
		ResultSet resultSet = null;
		//String sql="";  //COMMON-ICN-0122
		StringBuffer sbSQL = new StringBuffer();
		ArrayList patient_list  =new ArrayList();
		
		sbSQL.append(" SELECT A.PATIENT_ID ,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.BLNG_GRP_ID,TO_CHAR (A.VISIT_ADMN_DATE, 'DD/MM/YYYY') ENCOUNTER_DATE,A.DISCHARGE_DATE_TIME,A.PRACTITIONER_NAME,A.PATIENT_NAME,A.GENDER,DECODE (STATUS,'SQ', 'SUPERVISOR QUERY','DQ', 'DOCTOR QUERY','PC', 'PARTIALLY COMPLETED','HD', 'HOLD','CO', 'COMPLETED','NW', 'NEW','NEW') STATUS FROM BL_CODER_VISIT_SHEET_VW A,CA_CODER_STATUS M WHERE A.PATIENT_ID = M.PATIENT_ID(+) AND A.ENCOUNTER_ID = M.ENCOUNTER_ID(+) AND A.PATIENT_CLASS =M.PATIENT_CLASS(+) AND A.DISCHARGE_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')+1 and ( M.STATUS NOT IN ('CO') OR M.STATUS IS NULL) AND m.ASSIGNED_PRACTITIONER_ID = ?");
		if(!patient_id.equals("")) 
			sbSQL.append(" AND A.PATIENT_ID = ? ");		

           sbSQL.append(" ORDER BY DISCHARGE_DATE_TIME ");
		

      try{
		    connection			= getConnection();
			int i=1;
			//System.err.println("for CACoder search==="+sbSQL.toString());
			pStatment = connection.prepareStatement(sbSQL.toString());
			pStatment.setString(i++, from_date);
			pStatment.setString(i++, to_date);
			pStatment.setString(i++, Clin_id);
			if(!patient_id.equals(""))
				pStatment.setString(i++, patient_id);
			

			resultSet = pStatment.executeQuery();

			while (resultSet !=null && resultSet.next() ){
			
				patient_list.add(resultSet.getString("ENCOUNTER_DATE")==null?"":resultSet.getString("ENCOUNTER_DATE"));
				patient_list.add(resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID"));
				patient_list.add(resultSet.getString("PATIENT_ID")==null?"":resultSet.getString("PATIENT_ID"));
				patient_list.add(resultSet.getString("PATIENT_NAME")==null?"":resultSet.getString("PATIENT_NAME"));
				patient_list.add(resultSet.getString("GENDER")==null?"":resultSet.getString("GENDER"));
				patient_list.add(resultSet.getString("PRACTITIONER_NAME")==null?"":resultSet.getString("PRACTITIONER_NAME"));
				patient_list.add(resultSet.getString("BLNG_GRP_ID")==null?"":resultSet.getString("BLNG_GRP_ID"));
				patient_list.add(resultSet.getString("STATUS")==null?"":resultSet.getString("STATUS"));
				patient_list.add(resultSet.getString("DISCHARGE_DATE_TIME")==null?"":resultSet.getString("DISCHARGE_DATE_TIME"));
				patient_list.add(resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
				
			}
		if(resultSet !=null) resultSet.close();
		if(pStatment != null ) pStatment.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			if(resultSet != null) resultSet.close();
			if(pStatment != null) pStatment.close();
			closeConnection( connection ); //15950 Fix
		}

	return patient_list;

}

public String getCoderRemarks(String patient_id,String encounter_id)
	{
		Connection connection 		= null;
		PreparedStatement psmt 	= null;
		ResultSet rs = null;
		String sql ="";
		String coder_remarks ="";

		try
		{
			sql         = " SELECT REMARKS FROM CA_CODER_STATUS  WHERE PATIENT_ID = ? AND ENCOUNTER_ID = ?";
			connection			= getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, patient_id);
			psmt.setString(2, encounter_id); 
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				coder_remarks =rs.getString("REMARKS");
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
					rs.close();
				if(psmt != null) 
					psmt.close();
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return coder_remarks;
	}
	//Added by Kamatchi S for TH-KW-CRF-0143
	public String getCoderClearanceStatus(String facility,String patient_id,String episode_type,String episode_id,String visit_Id)
	{  
		Connection connection 		= null;
		CallableStatement callStatus = null;
		String sql ="";
		String status ="";
		try
		{
			sql         = " { ? = call bl_coders.get_coder_clearance_status(?,?,?,?,?)}"; 
			connection			= getConnection();
			callStatus = connection.prepareCall(sql);
			callStatus.registerOutParameter(1, java.sql.Types.VARCHAR);
			callStatus.setString(2, facility);
			callStatus.setString(3, patient_id); 
			callStatus.setString(4, episode_type); 
			callStatus.setString(5, episode_id); 
			callStatus.setString(6, visit_Id); 
			callStatus.execute();
			connection.commit();
			status=callStatus.getString(1);
			//COMMON-ICN-0122 Start.
			if(callStatus != null) 
					callStatus.close();
			////COMMON-ICN-0122  End.
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				ConnectionManager.returnConnection(connection);		
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return status;
	}

	
//41064  start

public String getsupervisor(String user_id)
	{
		Connection connection 		= null;
		PreparedStatement psmt 	= null;
		ResultSet rs = null;
		String sql ="";
		String supervisor_yn ="";

		try
		{
			sql         = " SELECT SUPERVISOR_YN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID = ?";
			connection			= getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				supervisor_yn =rs.getString("SUPERVISOR_YN");
				
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
                closeStatement( psmt ) ;
				closeConnection( connection ); 	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return supervisor_yn;
	}
	public String getbilledYN(String facility_id,String patient_id,String episode_id_new,String episode_type,String visit_Id)
	{
		Connection connection 		= null;
		PreparedStatement psmt 	= null;
		ResultSet rs = null;
		String sql ="";
		String billedYN ="";

		try
		{
			sql =    "SELECT BL_CODERS.Is_bill_generated_for_enc   (?,?,?,?,?)  BILLED_YN FROM DUAL  ";
			
			connection			= getConnection();
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, facility_id);
			psmt.setString(2, patient_id);
			psmt.setString(3, episode_id_new);
			psmt.setString(4, episode_type);
			psmt.setString(5, visit_Id);

			
			
			rs = psmt.executeQuery();
			while(rs.next())
			{
				billedYN = rs.getString("BILLED_YN");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
                closeStatement( psmt ) ;
				closeConnection( connection ); 	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return billedYN;
	}
	
	public ArrayList  getAuditDetails(String patient_id,String encounter_id,String facility_id,String locale) throws Exception {
		
		Connection con	= null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		ArrayList auditDetails  =new ArrayList();
		
		String sql = "SELECT TO_CHAR(ACTION_DATE_TIME,'DD/MM/YYYY HH24:MI') ACTION_DATE_TIME1,SM_GET_DESC.sm_appl_user (ACTION_BY_ID, ?, '1') ACTION_BY,PREV_ACTION_STATUS,ACTION_STATUS,REMARKS FROM CA_CODER_STATUS_AUDIT_LOG WHERE PATIENT_ID=? AND ENCOUNTER_ID=? AND FACILITY_ID=? ORDER BY ACTION_DATE_TIME DESC";
				

		try{
		    con			= getConnection();
			psmt = con.prepareStatement(sql);
			psmt.setString(1, locale);
			psmt.setString(2, patient_id);
			psmt.setString(3, encounter_id);
			psmt.setString(4, facility_id);

			rs = psmt.executeQuery();

			while (rs !=null && rs.next() ){
				HashMap  auditRec = new HashMap();
			
				auditRec.put("ACTION_DATE_TIME",rs.getString("ACTION_DATE_TIME1")==null?"":rs.getString("ACTION_DATE_TIME1"));
				auditRec.put("ACTION_BY",rs.getString("ACTION_BY")==null?"":rs.getString("ACTION_BY"));
				auditRec.put("PREV_ACTION_STATUS",rs.getString("PREV_ACTION_STATUS")==null?"":rs.getString("PREV_ACTION_STATUS"));
				auditRec.put("ACTION_STATUS",rs.getString("ACTION_STATUS")==null?"":rs.getString("ACTION_STATUS"));
				auditRec.put("REMARKS",rs.getString("REMARKS")==null?"":rs.getString("REMARKS"));		
				
				auditDetails.add(auditRec);
			}
			if(rs !=null) rs.close();
			if(psmt != null ) psmt.close();

		}
		catch(Exception e){
			e.printStackTrace();
		
		}
		finally{
			closeResultSet( rs ) ;
            closeStatement( psmt ) ;
			closeConnection( con ); 	
		}

		return auditDetails;

	}
	//41064  end

}
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.PatProblem;

import java.rmi.* ;
import javax.ejb.* ;
import java.util.* ;
import java.sql.* ;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

/**
*
* @ejb.bean
*	name="PatProblemManager"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PatProblemManager"
*	local-jndi-name="PatProblemManager"
*	impl-class-name="eCA.PatProblem.PatProblemManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eCA.PatProblem.PatProblemManagerLocal"
*	remote-class="eCA.PatProblem.PatProblemManagerRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eCA.PatProblem.PatProblemManagerLocalHome"
*	remote-class="eCA.PatProblem.PatProblemManagerHome"
*	generate= "local,remote"
*
*
*/



public class PatProblemManager implements SessionBean
{
	Connection con ;

	PreparedStatement pstmt					=	null;
	PreparedStatement pstmt_1				=	null;
	PreparedStatement pstmt_3				=	null;
	PreparedStatement stmt					=	null;  
	PreparedStatement stmt_asscociate_code	=	null;  
	PreparedStatement pstmt_enc_dtl			=	null;  
	PreparedStatement updt_pstmt_enc_dtl	=	null;  

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	//public final String CODE_ALREADY_EXISTS		 = "CODE_ALREADY_EXISTS" ;
	//public final String RECORD_INSERTED 		 = "RECORD_INSERTED" ;
	//public final String RECORD_MODIFIED 	     = "RECORD_MODIFIED" ;
	
	SessionContext ctx;
	
	public void ejbCreate() {}
	public void ejbRemove() {}
	public void ejbActivate() {}
	public void ejbPassivate() {}
	
	public void setSessionContext(SessionContext context) 
	{
		this.ctx=context;
		ctx = ctx;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public java.util.HashMap insertPatProblem(
								java.util.Properties p,
								String 	x_patient_id,
								String 	x_diag_code,
								String 	x_record_type,
								String 	x_cause_indicator,
								String 	x_diag_code_scheme,
								String 	x_diag_desc,
								String 	x_tab_list_no,
								String 	x_analysis_code,
								String 	x_primary_yn,
								String 	x_notifiable_yn,
								String 	x_sensitive_yn,
								String 	x_onset_date,
								String 	x_onset_practitioner_id,
								String 	x_onset_locn_code,
								String 	x_onset_locn_type,
								String 	temp_x_onset_encounter_id,
								String 	x_problem_status,
								String 	client_ip_address,
								String 	x_facility_id,
								String  x_term_id,
								String x_diag_stage,
								String x_remarks,
								String x_diag_type,
								String x_significant_yn,
								String x_accession_num,
								String x_authorize,
								String x_recordedby_id,
								String x_reviwedby_id,
								String x_authorizepract_id,
								String x_associate_codes,
								String x_practitioner_id,
								String x_locn_code,
								String x_locn_type,
								String x_oper_num,
								String locale	
							   )

	{
		long x_onset_encounter_id = Long.parseLong(temp_x_onset_encounter_id);
		
		java.util.HashMap results = new java.util.HashMap() ;

		int srlno				=	0,						cnt_enc_dtl		= 0;

		boolean result 			=	false,					insertable 		=	true ;
		boolean dup 			=	false ;
		
		StringBuffer sb			= new StringBuffer( "" ) ;
		
		String addedById				= p.getProperty( "login_user" ) ;
		String addedDate				= dateFormat.format(new java.util.Date()) ;
		String modifiedById				= addedById ;
		String modifiedDate				= addedDate ;
		String modifiedAtWorkstation	= client_ip_address ;
		String addedAtWorkstation		= modifiedAtWorkstation;
		String x_support_diag_code		= "";
  	    
		java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date modified_date		= java.sql.Date.valueOf( modifiedDate ) ;

		try
		{
			con = ConnectionManager.getConnection(p);
		
			PreparedStatement invalid_stmt = null;
			ResultSet invalid_rs = null;
			ResultSet rs=null;
			
			try
			{
				StringBuffer strBuff_invalid_sql = new StringBuffer();

				strBuff_invalid_sql.append("select short_desc from mr_icd_code where diag_code=? and diag_code_scheme=?  ");

				if(x_diag_code_scheme.equals("2"))
					strBuff_invalid_sql.append(" and record_type='D'  and nvl(cause_indicator,'|')=nvl(?,'|') ");

				StringBuffer strBuff_duplicateSql = new StringBuffer();


				strBuff_duplicateSql.append("select '1' from pr_problem  where patient_id = ? and diag_code= ? and problem_status!='C' and diag_code_scheme = ? and error_yn != 'Y' ");

				if(x_diag_code_scheme.equals("2"))
					strBuff_duplicateSql.append("	and nvl(cause_indicator,'|')=nvl(?,'|') ");
				
				invalid_stmt= con.prepareStatement(strBuff_invalid_sql.toString());
				invalid_stmt.setString(1,x_diag_code);
				invalid_stmt.setString(2,x_diag_code_scheme);

				if(x_diag_code_scheme.equals("2"))
					invalid_stmt.setString(3,x_cause_indicator);

				invalid_rs=invalid_stmt.executeQuery();

				boolean invalid_bool=false;

				if(invalid_rs!=null)
				{
					if(invalid_rs.next())
					{
						if(invalid_rs.getString(1).equals(x_diag_desc))
							invalid_bool=true;
					}
				}

				if(invalid_bool)
				{
					pstmt = con.prepareStatement( strBuff_duplicateSql.toString() ) ;
					pstmt.setString( 1, x_patient_id ) ;
					pstmt.setString( 2, x_diag_code ) ;
					pstmt.setString( 3, x_diag_code_scheme ) ;

					if(x_diag_code_scheme.equals("2"))
						pstmt.setString(4,x_cause_indicator);
					
					 rs = pstmt.executeQuery() ;

					if (rs.next())
					{
							sb.setLength(0);
							insertable = false ;
							dup = true;
							final java.util.Hashtable message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
							sb.append( (String) message.get("message")) ;
							message.clear();
					}
					
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();

					StringBuffer strBuff_duplicate_buf = new StringBuffer();

					strBuff_duplicate_buf.append("select 1 from ot_post_oper_diag where operating_facility_id = ? and oper_num = ? and diag_code = ? and diag_coding_scheme = ? ");

					if( x_oper_num != null && !(x_oper_num.equals("")) )
					{
						pstmt = con.prepareStatement( strBuff_duplicate_buf.toString() ) ;
						pstmt.setString( 1, x_facility_id ) ;
						pstmt.setString( 2, x_oper_num    );
						pstmt.setString( 3, x_diag_code ) ;
						pstmt.setString( 4, x_diag_code_scheme ) ;

						 rs = pstmt.executeQuery() ;

						if (rs.next())
						{
							sb.setLength(0);
							insertable = false ;
							dup = true;
							final java.util.Hashtable message = MessageManager.getMessage( locale,"CODE_ALREADY_EXISTS","Common" ) ;
							sb.append( (String) message.get("message")) ;
							message.clear();
						}

						if(rs!=null) rs.close();
						if(pstmt != null) pstmt.close();
					}
				}
				else
				{
					insertable = false ;
					dup = true;
					result=false;
					final java.util.Hashtable message = MessageManager.getMessage( locale, "INVALID_DIAG_CODE_FOR_PATIENT","CA" ) ;
					sb.append( (String) message.get("message")) ;
					message.clear();
				}
			}
			catch ( Exception e )
			{
				insertable = false ;
				sb.append( "first catch"+e+ "<br>" ) ;
				e.printStackTrace() ;
				

			    if (con != null)
			  	{
					try
					{
						con.rollback() ;
					}
					catch (Exception ce) 
					{
						ce.printStackTrace();
					}
		        }
		    }
			
			finally
			{
				try
				{
					if(invalid_rs!=null) invalid_rs.close();
					if(invalid_stmt!=null) invalid_stmt.close();
					if (pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			if (!dup ) 
			{
				try 
				{
					String Sql = "select nvl(max(srl_no),0)+1 num from pr_problem where patient_id = ? " ;
					pstmt = con.prepareStatement( Sql ) ;
					pstmt.setString( 1, x_patient_id) ;

					 rs = pstmt.executeQuery() ;
			
					rs.next();
					srlno = rs.getInt("num");

					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
				catch(Exception e)
				{
					
					insertable = false ;
					sb.append( "second catch"+e + "<br>" ) ;
					e.printStackTrace() ;
				}
			}

			if ( insertable )
			{
				try
				{
					con.setAutoCommit(false);
					
					int nOtIns = 0;
					int res_update = 0;

					if( x_oper_num != null && !(x_oper_num.equals("")) )
					{
						String sql_query="insert into ot_post_oper_diag(OPERATING_FACILITY_ID,OPER_NUM,SRL_NO,DIAG_CODING_SCHEME,DIAG_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
						pstmt = con.prepareStatement( sql_query );
						pstmt.setString	(1,  x_facility_id  ) ;
						pstmt.setString	(2,  x_oper_num  ) ;
						pstmt.setInt(3,  srlno  ) ;
						pstmt.setString	(4,  x_diag_code_scheme  ) ;
						pstmt.setString	(5,  x_diag_code  ) ;
						pstmt.setString	(6,  addedById  ) ;
						pstmt.setDate	(7,  added_date  ) ;
						pstmt.setString	(8,  addedAtWorkstation  ) ;
						pstmt.setString  (9,  x_facility_id );
						pstmt.setString	(10,  modifiedById  ) ;
						pstmt.setDate	(11,  modified_date  ) ;
						pstmt.setString	(12, modifiedAtWorkstation  ) ;
						pstmt.setString	(13,  x_facility_id  ) ;

						nOtIns = pstmt.executeUpdate() ;
						
						if (pstmt!=null) pstmt.close();
					}
					else
						nOtIns = 1;

					if(nOtIns > 0)
					{
						String sql = " insert into 	pr_problem(PATIENT_ID,SRL_NO,DIAG_CODE,RECORD_TYPE,CAUSE_INDICATOR,diag_code_scheme,diag_desc,tab_list_no,analysis_code,primary_yn,notifiable_yn,sensitive_yn,onset_date,onset_practitioner_id,onset_facility_id,onset_locn_code,onset_locn_type,onset_encounter_id,onset_recorded_date,problem_status,added_by_id,added_date,added_facility_id, added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,final_yn,term_id,ip_diag_stage,problem_remarks,diag_type,significant_yn,accession_num,recorded_by_pract,reviewed_by_pract,authorized_yn,authorized_by_pract,curr_practitioner_id,curr_facility_id,curr_locn_code,curr_locn_type,curr_encounter_id,curr_recorded_date) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,to_date(?,'dd/mm/yyyy') ,?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

						pstmt = con.prepareStatement( sql );
						pstmt.setString	(1,  x_patient_id ) ;
						pstmt.setInt	(2,  srlno) ;
						pstmt.setString	(3,  x_diag_code ) ;
						pstmt.setString	(4,  x_record_type ) ;
						pstmt.setString	(5,  x_cause_indicator ) ;
						pstmt.setString	(6,  x_diag_code_scheme ) ;
						pstmt.setString	(7,  x_diag_desc ) ;
						pstmt.setString	(8,  x_tab_list_no ) ;
						pstmt.setString	(9,  x_analysis_code ) ;
						pstmt.setString	(10, x_primary_yn ) ;
						pstmt.setString	(11, x_notifiable_yn ) ;
						pstmt.setString	(12, x_sensitive_yn ) ;
						pstmt.setString	(13, x_onset_date ) ;
						pstmt.setString	(14, x_onset_practitioner_id ) ;
						pstmt.setString	(15, x_facility_id ) ;
						pstmt.setString	(16, x_onset_locn_code ) ;
						pstmt.setString	(17, x_onset_locn_type ) ;
						pstmt.setLong	(18, x_onset_encounter_id ) ;
						pstmt.setDate	(19, added_date) ;
						pstmt.setString	(20, x_problem_status ) ;
						pstmt.setString (21, addedById);
						pstmt.setDate	(22, added_date ) ;
						pstmt.setString	(23, x_facility_id ) ;
						pstmt.setString	(24, addedAtWorkstation ) ;
						pstmt.setString	(25, modifiedById ) ;
						pstmt.setDate	(26, modified_date ) ;
						pstmt.setString	(27, x_facility_id ) ;
						pstmt.setString	(28, modifiedAtWorkstation ) ;
						pstmt.setString	(29, x_term_id ) ;
						pstmt.setString	(30, x_diag_stage ) ;
						pstmt.setString	(31, x_remarks ) ;
						pstmt.setString (32,x_diag_type);
						pstmt.setString (33,x_significant_yn);
						pstmt.setString (34,x_accession_num);
						pstmt.setString (35,x_recordedby_id);
						pstmt.setString (36,x_reviwedby_id);
						pstmt.setString (37,x_authorize);
						pstmt.setString (38,x_authorizepract_id);
						pstmt.setString (39,x_practitioner_id);
						pstmt.setString (40,x_facility_id);
						pstmt.setString (41,x_locn_code);
						pstmt.setString (42,x_locn_type);
						pstmt.setLong (43,x_onset_encounter_id);

						res_update = pstmt.executeUpdate() ;
					}				

					if(res_update > 0)
					{
						String ins_pr_enc_dtl_sql ="insert into  pr_problem_enc_dtl(PATIENT_ID,SRL_NO,FACILITY_ID,ENCOUNTER_ID,RECORDED_DATE_TIME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,IP_DIAG_STAGE) values (?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";

						pstmt_enc_dtl = con.prepareStatement(ins_pr_enc_dtl_sql);
						pstmt_enc_dtl.setString(1,x_patient_id);
						pstmt_enc_dtl.setInt(2,srlno);
						pstmt_enc_dtl.setString(3,x_facility_id);
						pstmt_enc_dtl.setLong(4,x_onset_encounter_id);
						pstmt_enc_dtl.setString(5,addedById);
						pstmt_enc_dtl.setDate(6,added_date);
						pstmt_enc_dtl.setString(7,addedAtWorkstation);
						pstmt_enc_dtl.setString(8,x_facility_id);
						pstmt_enc_dtl.setString(9,modifiedById);
						pstmt_enc_dtl.setDate(10,modified_date);
						pstmt_enc_dtl.setString(11,modifiedAtWorkstation);
						pstmt_enc_dtl.setString(12,x_facility_id);
						pstmt_enc_dtl.setString(13,x_diag_stage);
						
						cnt_enc_dtl = pstmt_enc_dtl.executeUpdate();

						if(pstmt_enc_dtl!=null)
							pstmt_enc_dtl.close();
					}

					StringTokenizer token2 = new StringTokenizer(x_onset_date, "-");

					String code2[]=new String[3];
					
					int track2=0;
					
					while (token2.hasMoreTokens())
					{
						code2[track2]=token2.nextToken();
						track2++;
					}

					String t_onset_date = code2[2]+"/"+code2[1]+"/"+code2[0];

					String temp_text = x_diag_desc;
					
					temp_text = temp_text+" - "+ t_onset_date+" (Added)" ;

					con.commit();

					result = true ;
				
					if(cnt_enc_dtl > 0)
					{	
						final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","CA" ) ;
						sb.append( (String) message.get("message") ) ;
						message.clear();
					}
			
					//String sql1="select short_name from am_practitioner where practitioner_id= ? ";

					String sql1="select AM_GET_DESC.AM_PRACTITIONER(?,?,'2') short_name from dual ";
					stmt=con.prepareStatement(sql1);
					stmt.setString(1,x_onset_practitioner_id);
					stmt.setString(2,locale);
					 rs=stmt.executeQuery();

					rs.next();
					String short_name	= rs.getString("short_name");

					String status_id = "";

					if (x_problem_status.equals("B"))
						status_id="BETTER";
					if (x_problem_status.equals("W"))
						status_id="WORSE";
					if (x_problem_status.equals("S"))
						status_id="SAME";

					if (x_problem_status.equals("C"))
						status_id="CLOSED";

					if(rs!=null) rs.close();

					String l_long_text= status_id+"-"+short_name;
					String sql_insert="insert into pr_problem_assessment(patient_id,srl_no,log_date_time,log_text,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,PROBLEM_REMARKS,IP_DIAG_STAGE) values(?,?,sysdate,to_char(sysdate,'dd/mm/yyyy')||' '||?,?,?,?,?,?,?,?,?,?,?)";
					try
					{
						pstmt_1= con.prepareStatement( sql_insert );
						pstmt_1.setString	(1,  x_patient_id) ;
						pstmt_1.setInt		(2,  srlno) ;
						pstmt_1.setString	(3,  l_long_text) ;
						pstmt_1.setString	(4,  addedById);
						pstmt_1.setDate		(5,  added_date ) ;
						pstmt_1.setString	(6,  x_facility_id ) ;
						pstmt_1.setString	(7,  addedAtWorkstation ) ;
						pstmt_1.setString	(8,  modifiedById ) ;
						pstmt_1.setDate		(9,  modified_date ) ;
						pstmt_1.setString	(10, x_facility_id ) ;
						pstmt_1.setString	(11, modifiedAtWorkstation ) ;
						pstmt_1.setString	(12, x_remarks ) ;
						pstmt_1.setString	(13, x_diag_stage ) ;
						
						int ins_cnt=0;				
						
						ins_cnt = pstmt_1.executeUpdate();				

						if(ins_cnt > 0) result=true;
					
						if((!x_associate_codes.equals("")) && ins_cnt > 0)
						{
							String splitsupportcodes = "";
							int supp_code_updated = 0;
							
							String insert_associate_codes = "insert into pr_problem_detail(patient_id,srl_no,diag_code,support_diag_code,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no) values (?,?,?,?,?,?,?,?,?,?,?,?)";
					 	
							stmt_asscociate_code = con.prepareStatement( insert_associate_codes );
						
							StringTokenizer str1 = new StringTokenizer(x_associate_codes,"|");

							while(str1.hasMoreTokens())
							{
								splitsupportcodes = str1.nextToken();
								StringTokenizer str2 = new StringTokenizer(splitsupportcodes,"~");
							
								while(str2.hasMoreTokens())
								{
									x_support_diag_code = str2.nextToken();
									str2.nextToken();

									if(str2.hasMoreTokens())
                                    str2.nextToken();

									stmt_asscociate_code.clearParameters();

									stmt_asscociate_code.setString(1, x_patient_id);
									stmt_asscociate_code.setInt(2, srlno);
									stmt_asscociate_code.setString(3, x_diag_code);
									stmt_asscociate_code.setString(4, x_support_diag_code);
									stmt_asscociate_code.setString(5, addedById);
									stmt_asscociate_code.setDate(6, added_date);
									stmt_asscociate_code.setString(7, x_facility_id);
									stmt_asscociate_code.setString(8, addedAtWorkstation);
									stmt_asscociate_code.setString(9, modifiedById);
									stmt_asscociate_code.setDate(10, modified_date);
									stmt_asscociate_code.setString(11, x_facility_id);
									stmt_asscociate_code.setString(12, modifiedAtWorkstation);		

									supp_code_updated += stmt_asscociate_code.executeUpdate();
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace() ;
					}
					finally
					{
						con.commit();
					}
					/**End**/
			}
			catch ( Exception e ) 
			{
				sb.append( "Error in Insert : "+e.getMessage()+ "<br> ") ;
				
				e.printStackTrace() ;

				try 
				{
					con.rollback() ;
				}
				catch (Exception ce) 
				{
					ce.printStackTrace() ;
				}
			}
		  	finally 
			{
				if (con != null) 
				{
					try 
					{
						if(pstmt_1!=null) pstmt_1.close();
						if(stmt!=null) stmt.close();
						if(stmt_asscociate_code!=null) stmt_asscociate_code.close();
					}
					catch (Exception ee) {ee.printStackTrace();}
				}
			}			
		}
	}	
	catch(Exception ee)
	{
		sb.append("Error in main try "+ee.getMessage());
		ee.printStackTrace() ;
	}
	finally
	{
		if (con != null)
        {
			try 
			{
				if(pstmt!=null) pstmt.close();
				if( con != null ) ConnectionManager.returnConnection(con,p);
            } 
			catch (Exception ee) {     
					ee.printStackTrace() ;
			}
        }
	}
	results.put( "status", new Boolean(result) ) ;
	results.put( "error", sb.toString() ) ;
	return results ;
}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

public java.util.HashMap updatePatProblem(
									java.util.Properties p			,
									String x_patient_id				,
									String temp_x_srl_no			,
									String x_close_date				,
									String x_close_practitioner_id	,
									String x_close_locn_code		,
									String x_close_locn_type		,
									String temp_x_close_encounter_id,
									String x_problem_status			,
									String client_ip_address		,
									String x_facility_id			,
									//String x_diag_desc				,
									//String x_Sec_Hdg_Code			,
									//String x_logical_seq_no			, 
									String x_remarks				,
									String x_diag_type				,
									String 	x_primary_yn			,
									String x_significant_yn			,
									String x_diag_stage				,
									String	errorRemarks			,
									String x_accession_num			,
									String x_authorize				,
									String x_recordedby_id			,
									String x_reviwedby_id			,
									String x_authorizepract_id      ,
									String x_associate_codes		,
									String x_diag_code				,
									String x_practitioner_id,
									String x_locn_code,
									String x_locn_type,
									String x_include_enc,
									String locale
								) 
	{
		int x_srl_no=Integer.parseInt(temp_x_srl_no);
		long x_close_encounter_id=Long.parseLong(temp_x_close_encounter_id);



		java.util.HashMap results = new java.util.HashMap() ;
		boolean result = false ;
		//boolean updatable = true ;
		//String action_type="";
		//String 	update_decide ="";
		String 	l_long_text="";
		//String  sys_date_1="";
		String  short_name="";
		String  status_id ="";
		StringBuffer sb = new StringBuffer( "" ) ;

		String modifiedById 		= 	p.getProperty( "login_user" ) ;
		String modifiedDate 		= 	dateFormat.format( new java.util.Date() ) ;
		java.sql.Date modified_date = 	java.sql.Date.valueOf( modifiedDate ) ;
		String modifiedFacilityId 	= 	x_facility_id ;
		String modifiedAtWorkstation= 	client_ip_address;
		String addedById			=	modifiedById;
		String addedFacilityId 		= 	modifiedFacilityId;
		String addedAtWorkstation	= 	modifiedAtWorkstation;

		java.sql.Date added_date = modified_date;

		String ERROR_MARKED_BY_ID   ="";  
		//java.sql.Date  ERROR_MARKED_DATE      =null;
		String ERROR_REMARKS          ="";
		String ERROR_YN               ="N";
		try
		{
			con = ConnectionManager.getConnection(p);
			/*Statement stmtdat=null;
			ResultSet rsdat=null;
			stmtdat=con.createStatement();
            rsdat=stmtdat.executeQuery("select to_char(sysdate,'yyyy-mm-dd') d from dual ");
            rsdat.next();
            java.sql.Date sys_date = rsdat.getDate("d");
			if(stmtdat !=null) stmtdat.close();
			if(rsdat !=null)rsdat.close();*/
			if(!errorRemarks.equals(""))
			{
				ERROR_MARKED_BY_ID   =x_close_practitioner_id;  
				// ERROR_MARKED_DATE      =sys_date;
				 ERROR_REMARKS          =errorRemarks;
				 ERROR_YN               ="Y";
			}
			try
			{
				int updated = 0;
				if (x_problem_status.equals("C"))
				{
					StringBuffer strBuff_sql = new StringBuffer();

					strBuff_sql.append("update pr_problem set close_date = to_date(?,'dd/mm/yyyy'), close_practitioner_id = ?,close_facility_id = ?, close_locn_code = ?,close_locn_type = ?, close_encounter_id = ?,close_recorded_date =sysdate,problem_status='C', problem_remarks='");
					strBuff_sql.append(x_remarks);
					strBuff_sql.append("',diag_type='");
					strBuff_sql.append(x_diag_type);
					strBuff_sql.append("' , modified_by_id	= ?,modified_date= sysdate, modified_facility_id	= ?,modified_at_ws_no = ?,IP_DIAG_STAGE = ?, ERROR_MARKED_BY_ID = ?, ");					
					if (ERROR_YN.equals("Y"))
					{strBuff_sql.append(" ERROR_MARKED_DATE = SYSDATE, ");
					} 
					strBuff_sql.append(" ERROR_REMARKS = ?,  ERROR_YN = ? , accession_num = ? ,recorded_by_pract = ?, reviewed_by_pract = ?, authorized_yn = ?, authorized_by_pract = ?, curr_practitioner_id = ?,curr_facility_id=?,curr_locn_code=?,curr_locn_type=?,curr_encounter_id=?,curr_recorded_date=sysdate where PATIENT_ID	= ?  and srl_no=? ");

					try
					{
						pstmt = con.prepareStatement( strBuff_sql.toString());
						pstmt.setString  	( 1, x_close_date) ;
						pstmt.setString  	( 2, x_close_practitioner_id) ;
						pstmt.setString    	( 3, x_facility_id) ;
						pstmt.setString    	( 4, x_close_locn_code) ;
						pstmt.setString    	( 5, x_close_locn_type) ;
						pstmt.setLong    	( 6, x_close_encounter_id) ;
						pstmt.setString    	( 7, modifiedById) ;
						pstmt.setString		( 8,modifiedFacilityId ) ;
						pstmt.setString		( 9,modifiedAtWorkstation ) ;
						pstmt.setString		( 10,x_diag_stage ) ;
						pstmt.setString		( 11, ERROR_MARKED_BY_ID ) ;
						//pstmt.setDate		( 12, ERROR_MARKED_DATE );
						pstmt.setString		( 12, ERROR_REMARKS) ;
						pstmt.setString		( 13, ERROR_YN );
						pstmt.setString		( 14, x_accession_num );
						pstmt.setString		(15, x_recordedby_id);
						pstmt.setString		(16,x_reviwedby_id);
						pstmt.setString		(17,x_authorize);
						pstmt.setString		(18,x_authorizepract_id);
						pstmt.setString		(19,x_practitioner_id);
						pstmt.setString		(20,x_facility_id);
						pstmt.setString		(21,x_locn_code);
						pstmt.setString		(22,x_locn_type);
						pstmt.setLong		(23,x_close_encounter_id);
						pstmt.setString 	(24,x_patient_id );
						pstmt.setInt		( 25,x_srl_no) ;
						updated = pstmt.executeUpdate();	
						if(pstmt!=null)	pstmt.close();
				
					}
					catch(Exception e)
					{
							e.printStackTrace() ;
					}

				}
				else
				{

					StringBuffer updatesql = new StringBuffer();
					updatesql.append(" update pr_problem set problem_remarks=?,diag_type=?,primary_yn=? ,significant_yn=?, problem_status=nvl(?,problem_status), IP_DIAG_STAGE = ?,  ERROR_MARKED_BY_ID = ?,");
					
					if (ERROR_YN.equals("Y"))
					{
						updatesql.append(" ERROR_MARKED_DATE = SYSDATE, ");
					} 
					updatesql.append(" ERROR_REMARKS = ?,  ERROR_YN = ? , accession_num = ? ,recorded_by_pract = ?, reviewed_by_pract = ?, authorized_yn = ?, authorized_by_pract = ?, curr_practitioner_id = ?, curr_facility_id=?, curr_locn_code=?, curr_locn_type=?, curr_encounter_id=?,curr_recorded_date=sysdate where PATIENT_ID	= ? and srl_no=? ");

					

					pstmt_3 = con.prepareStatement(updatesql.toString());
					pstmt_3.setString 	 ( 1, x_remarks) ;
					pstmt_3.setString   ( 2, x_diag_type) ;
					pstmt_3.setString  	( 3, x_primary_yn) ;
					pstmt_3.setString   ( 4, x_significant_yn) ;
					pstmt_3.setString   ( 5, x_problem_status) ;
					pstmt_3.setString   ( 6, x_diag_stage) ;
					pstmt_3.setString	( 7, ERROR_MARKED_BY_ID ) ;
					//pstmt_3.setDate		( 8, ERROR_MARKED_DATE );
					pstmt_3.setString   ( 8, ERROR_REMARKS) ;
					pstmt_3.setString   ( 9, ERROR_YN );
					pstmt_3.setString   ( 10, x_accession_num );
					pstmt_3.setString   ( 11, x_recordedby_id) ;	
					pstmt_3.setString   ( 12, x_reviwedby_id) ;
					pstmt_3.setString   ( 13, x_authorize) ;
					pstmt_3.setString   ( 14, x_authorizepract_id) ;
					pstmt_3.setString		(15,x_practitioner_id);
					pstmt_3.setString		(16,x_facility_id);
					pstmt_3.setString		(17,x_locn_code);
					pstmt_3.setString		(18,x_locn_type);
					pstmt_3.setLong		(19,x_close_encounter_id);				
					pstmt_3.setString   ( 20, x_patient_id) ;
					pstmt_3.setInt    	( 21, x_srl_no) ;

					updated = pstmt_3.executeUpdate();

					if(pstmt_3!=null) pstmt_3.close();
				}
			
				int upd_enc_dtl = 0;
				if(updated !=0 && x_include_enc.equals("Y"))
				{
					int count = 0;

					String sql_enc_dtl = "select count(*) count  from pr_problem_enc_dtl where srl_no = ? and patient_id = ?  and  encounter_id=? and facility_id =?";
					PreparedStatement pstmt_enc_dtl = null;
					ResultSet rs_enc_dtl = null;
					pstmt_enc_dtl = con.prepareStatement(sql_enc_dtl);
					pstmt_enc_dtl.setInt(1,x_srl_no);
					pstmt_enc_dtl.setString(2,x_patient_id);
					pstmt_enc_dtl.setLong(3,x_close_encounter_id);
					pstmt_enc_dtl.setString(4,x_facility_id);
					rs_enc_dtl = pstmt_enc_dtl.executeQuery();
					
					while(rs_enc_dtl.next())
					{
						count = rs_enc_dtl.getInt("count");
					}
					
					if(pstmt_enc_dtl!=null)
						pstmt_enc_dtl.close();
					if(rs_enc_dtl!=null)
						rs_enc_dtl.close();

					if(count ==0)
					{

					String update_enc_dtl = "insert into  pr_problem_enc_dtl(PATIENT_ID,SRL_NO,FACILITY_ID,ENCOUNTER_ID,RECORDED_DATE_TIME,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,IP_DIAG_STAGE) values (?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)";
					
					updt_pstmt_enc_dtl = con.prepareStatement(update_enc_dtl);
					updt_pstmt_enc_dtl.setString(1,x_patient_id);
					updt_pstmt_enc_dtl.setInt(2,x_srl_no);
					updt_pstmt_enc_dtl.setString(3,x_facility_id);
					updt_pstmt_enc_dtl.setLong(4,x_close_encounter_id);
					//pstmt_enc_dtl.setString(5,recorded_date_time);
					updt_pstmt_enc_dtl.setString(5,addedById);
					updt_pstmt_enc_dtl.setDate(6,added_date);
					updt_pstmt_enc_dtl.setString(7,addedAtWorkstation);
					updt_pstmt_enc_dtl.setString(8,x_facility_id);
					updt_pstmt_enc_dtl.setString(9,modifiedById);
					updt_pstmt_enc_dtl.setDate(10,modified_date);
					updt_pstmt_enc_dtl.setString(11,modifiedAtWorkstation);
					updt_pstmt_enc_dtl.setString(12,x_facility_id);
					updt_pstmt_enc_dtl.setString(13,x_diag_stage);
						
					upd_enc_dtl = updt_pstmt_enc_dtl.executeUpdate();

					if(updt_pstmt_enc_dtl!=null)
						updt_pstmt_enc_dtl.close();
					}
					else
					{
						upd_enc_dtl = 1;
					}
				}
				
				if(upd_enc_dtl > 0)
				{
					/********************************************************/
					String sql_update_pr_problem_enc_dtl = "update pr_problem_enc_dtl set IP_DIAG_STAGE=? where PATIENT_ID = ? and  SRL_NO = ? and FACILITY_ID = ? and ENCOUNTER_ID = ?";

					updt_pstmt_enc_dtl = con.prepareStatement(sql_update_pr_problem_enc_dtl);
					updt_pstmt_enc_dtl.setString(1,x_diag_stage);
					updt_pstmt_enc_dtl.setString(2,x_patient_id);
					updt_pstmt_enc_dtl.setInt(3,x_srl_no);
					updt_pstmt_enc_dtl.setString(4,x_facility_id);
					updt_pstmt_enc_dtl.setLong(5,x_close_encounter_id);
					updt_pstmt_enc_dtl.executeUpdate();

					if(updt_pstmt_enc_dtl!=null) updt_pstmt_enc_dtl.close();
	
					/********************************************************/
					

					String sql_delete_pr_problem_detail = "delete pr_problem_detail where srl_no=? and patient_id=?";

					PreparedStatement pstmt_delete_pr_problem_detail = null;
					pstmt_delete_pr_problem_detail = con.prepareStatement(sql_delete_pr_problem_detail);
					pstmt_delete_pr_problem_detail.setInt(1,x_srl_no);
					pstmt_delete_pr_problem_detail.setString(2,x_patient_id);

					pstmt_delete_pr_problem_detail.executeUpdate();
					
					if(pstmt_delete_pr_problem_detail !=null) pstmt_delete_pr_problem_detail.close();

					
					if((!x_associate_codes.equals("")))
					{
						String splitsupportcodes = "";
						int supp_code_updated = 0;
						String insert_associate_codes = "insert into pr_problem_detail(patient_id,srl_no,diag_code,support_diag_code,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no) values (?,?,?,?,?,?,?,?,?,?,?,?)";
						
						stmt_asscociate_code = con.prepareStatement( insert_associate_codes );

						StringTokenizer str1 = new StringTokenizer(x_associate_codes,"|");
							while(str1.hasMoreTokens())
							{
								splitsupportcodes = str1.nextToken();
								StringTokenizer str2 = new StringTokenizer(splitsupportcodes,"~");
								while(str2.hasMoreTokens())
								{
									String x_support_diag_code = str2.nextToken();
									//String x_support_diag_desc = str2.nextToken();
                                    str2.nextToken(); 
									if(str2.hasMoreTokens())
                                    str2.nextToken();  

									stmt_asscociate_code.clearParameters();

									stmt_asscociate_code.setString(1, x_patient_id);
									stmt_asscociate_code.setInt(2, x_srl_no);
									stmt_asscociate_code.setString(3, x_diag_code);
									stmt_asscociate_code.setString(4, x_support_diag_code);
									stmt_asscociate_code.setString(5, addedById);
									stmt_asscociate_code.setDate(6, added_date);
									stmt_asscociate_code.setString(7, x_facility_id);
									stmt_asscociate_code.setString(8, addedAtWorkstation);
									stmt_asscociate_code.setString(9, modifiedById);
									stmt_asscociate_code.setDate(10, modified_date);
									stmt_asscociate_code.setString(11, x_facility_id);
									stmt_asscociate_code.setString(12, modifiedAtWorkstation);	
									supp_code_updated += stmt_asscociate_code.executeUpdate();	
								}								

							}
							if(stmt_asscociate_code!=null) stmt_asscociate_code.close();
						}
					//				

				}
				//String sql2="select short_name from am_practitioner where practitioner_id=?";

				String sql2="select AM_GET_DESC.AM_PRACTITIONER(?,?,'2') short_name from dual";
				stmt=con.prepareStatement(sql2);
				stmt.setString(1,x_close_practitioner_id);
				stmt.setString(2,locale);
				ResultSet rs=stmt.executeQuery();
				rs.next();
				short_name	= rs.getString("short_name");
				
				if(rs !=null) rs.close();
				if(stmt !=null) stmt.close();

				if (x_problem_status.equals("B"))
					status_id="BETTER";
				if (x_problem_status.equals("W"))
					status_id="WORSE";
				if (x_problem_status.equals("S"))
					status_id="SAME";

				if (x_problem_status.equals("C"))
					status_id="CLOSED";

				l_long_text= status_id+"-"+short_name;


				if(x_authorize==null || x_authorize=="")
					x_authorize="N";
				//String sql="insert into pr_problem_assessment(patient_id,srl_no,log_date_time,log_text,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,PROBLEM_REMARKS) values('"+x_patient_id+"',"+x_srl_no+",sysdate,to_char(sysdate,'dd/mm/yyyy')||' '||'"+l_long_text+"','"+addedById+"',sysdate,'"+addedFacilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',sysdate,'"+modifiedFacilityId+"','"+modifiedAtWorkstation+"','"+x_remarks+"')";
				String sql="insert into pr_problem_assessment(patient_id,srl_no,log_date_time,log_text,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,PROBLEM_REMARKS,IP_DIAG_STAGE) values(?,?,sysdate,to_char(sysdate,'dd/mm/yyyy')||' '||?,?,sysdate,?,?,?,sysdate,?,?,?,?)";
				
				try
				{
					pstmt 				= con.prepareStatement( sql );
					pstmt.setString   	(1, x_patient_id) ;
					pstmt.setInt	   	(2, x_srl_no) ;
					pstmt.setString   	(3, l_long_text) ;
					pstmt.setString 	(4,addedById);
					//pstmt.setDate		(5, added_date ) ;
					pstmt.setString		(5, addedFacilityId ) ;
					pstmt.setString		(6, addedAtWorkstation ) ;
					pstmt.setString		(7, modifiedById ) ;
					//pstmt.setDate		(8, modified_date ) ;
					pstmt.setString		(8, modifiedFacilityId ) ;
					pstmt.setString		(9, modifiedAtWorkstation ) ;
					pstmt.setString		(10, x_remarks ) ;
					pstmt.setString		(11, x_diag_stage ) ;
					//pstmt.setString		(13, x_facility_id ) ;
					//pstmt.setLong    	( 14, x_close_encounter_id) ;
					//pstmt.setString		(15, x_close_practitioner_id ) ;
					//pstmt.setString		(16, action_type ) ;
				

					int res=0;
					res = pstmt.executeUpdate() ;

						/*if (x_authorize.equals("N")){
							action_type="R";
							pstmt.setString(13, action_type) ;
							res = pstmt.executeUpdate() ;
						}else{
							action_type="R";
							pstmt.setString(13, "R") ;
							res = pstmt.executeUpdate() ;
							action_type="A";
							pstmt.setString(13, action_type) ;
							res = pstmt.executeUpdate() ;
						}*/

			
	//				int res = pstmt.executeUpdate() ;
					
					if(res > 0) result=true;
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}
				finally
				{
					con.commit();
				}
				StringTokenizer token3 = new StringTokenizer(modifiedDate, "-");

				String code3[]=new String[3];
				int track3=0;
				while (token3.hasMoreTokens())
				{
					code3[track3]=token3.nextToken();
					track3++;
				}

				//String x_sys_date = code3[2]+"/"+code3[1]+"/"+code3[0];
				if (x_problem_status.equals("C"))
				{
					StringTokenizer token2 = new StringTokenizer(x_close_date, "-");
					String code2[]=new String[3];
					int track2=0;
					while (token2.hasMoreTokens())
					{
						code2[track2]=token2.nextToken();
						track2++;
					}
					//String t_close_date = code2[2]+"/"+code2[1]+"/"+code2[0];
				}
				//String notes= " ";
				if(result)
				{
					
					con.commit();
					final java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","CA" ) ;
					sb.append( (String) message.get("message") ) ;
					message.clear();
					
				}

			}
			catch ( Exception e ) 
			{
				sb.append( "Exception @ 1"+e.getMessage() +"<br>" ) ;
				sb.append( "Exception deepa "+e.toString()+"<br>" ) ;
				e.printStackTrace() ;
			}
			finally 
			{
			  if (con != null)
			  {
				  try 
				  {
					  pstmt.close() ;
				  }
				  catch (Exception ee) 
				  {
					  try 
					  {
						  con.rollback() ;
					  }
					  catch (Exception ce) 
					  {ce.printStackTrace();}
				  }
		      }
			}
		}
		catch(Exception ee)
		{
			sb.append("Exception in main try"+ee.getMessage());
		}
		finally
		{
			if (con != null)
			{
			   try 
				{
					if( con != null ) ConnectionManager.returnConnection(con,p);
				} 
				catch (Exception ee) { ee.printStackTrace();    }
			 }
		}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public  java.util.HashMap FromCompleteVisit(
														java.util.Properties p,
														String patient_id,
														String facilityid,
														String temp_encounter_id,
														String modified_ws,
														String locale
													)
	{
		long encounter_id=Long.parseLong(temp_encounter_id);
		java.util.HashMap results = new java.util.HashMap() ;
		String modified_id = p.getProperty( "login_user" ) ;
		String addedDate = dateFormat.format( new java.util.Date() ) ;
		 java.sql. Date modified_date = java.sql.Date.valueOf( addedDate ) ;


		String prencountersql = "Select disposition_type from pr_encounter where facility_id =? and encounter_id = ? ";

		String findSql = "Select nvl(DISP_REQD_FOR_MDS_YN,'N') DISP_YN, nvl(DIAG_REQD_FOR_MDS_YN,'N') DIAG_YN,nvl(NOTES_REQD_FOR_MDS_YN,'N') NOTES_YN from OP_PARAM where operating_facility_id = ?";
		String disposition_type="";
		String disp_yn="";
		String diag_yn="";
		//String notes_yn="";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String L_note_yn="N";
		String L_disp_yn="";
		String L_diag_yn="";
		String L_visit_status="";
		StringBuffer sb=new StringBuffer();
		Connection con=null;
		boolean result=false;
		try
		{
		try
		{
			pstmt=con.prepareStatement(prencountersql);
			pstmt.setString(1,facilityid);
			pstmt.setLong(2,encounter_id);
			rs = pstmt.executeQuery();
			
			if(rs!=null)
			{
				if(rs.next())
				{
					disposition_type=rs.getString(1);
				}
			}
		}
		catch(Exception e)
		{
			sb.append("From CompleteVisit1"+e.toString());
		}
		finally
		{
			try
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null) rs.close();
			}
			catch(Exception e){e.printStackTrace();}
		}

		try
		{
			pstmt=con.prepareStatement(findSql);
			pstmt.setString(1,facilityid);
			rs = pstmt.executeQuery();
			if(rs!=null)
			{
				if(rs.next())
				{
					disp_yn=rs.getString(1);
					diag_yn=rs.getString(2);
					//notes_yn=rs.getString(3);
				}
			}
		}
		catch(Exception e)
		{
			sb.append("From CompleteVisit2"+e.toString());
		}
		finally
		{
			try
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null) rs.close();
			}
			catch(Exception e){}
		}

		if(disp_yn.equals("Y"))
		{
		   if(!(disposition_type == null) )
		   		L_disp_yn = "Y";
		}
		else
		{
			L_disp_yn="N";
		}

		if(diag_yn.equals("Y"))
		{
			String findSql1 = "Select 'X' from PR_PROBLEM where patient_id = ? and trunc(onset_recorded_date) = trunc(sysdate) and primary_yn = 'Y' and rownum < 2";
			try
			 {
				 pstmt= con.prepareStatement( findSql1 ) ;
			 	pstmt.setString( 1, patient_id) ;
  			 	rs = pstmt.executeQuery() ;

  			 	if(rs!=null)
  			 	{
					if(rs.next())
					{
						L_diag_yn="Y";
					}
				}
				else
				{
					L_diag_yn="N";
				}
		}
		catch(Exception e)
		{
			sb.append("From CompleteVisit3"+e.toString());
		}
		finally
		{
			try
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null) rs.close();
			}
			catch(Exception e){}
		}
	}
		if(L_note_yn.equals("Y") && L_diag_yn.equals("Y") && L_disp_yn.equals("Y"))
			   L_visit_status = "08";
		else
			   L_visit_status = "07";



	String L_UPDATE= "UPDATE PR_ENCOUNTER set  VISIT_STATUS = ?,modified_by_id = ?,modified_date = ?,modified_facility_id = ?,modified_at_ws_no  = ? where FACILITY_ID  = ? and ENCOUNTER_ID = ? ";

		try
		{

			pstmt=con.prepareStatement(L_UPDATE);
			pstmt.setString(1,L_visit_status);
			pstmt.setString(2,modified_id);
			pstmt.setDate	(3,modified_date);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,modified_ws);
			pstmt.setString(6,facilityid);
			pstmt.setLong	(7,encounter_id);

			int num=pstmt.executeUpdate();

			if(num!=0)
			{
				result=true;
				final java.util.Hashtable message = MessageManager.getMessage( locale,"RECORD_INSERTED","CA" ) ;

				sb.append( (String) message.get("message") ) ;
				message.clear();
			}
		}
		catch(Exception e)
		{
			sb.append("From CompleteVisit4"+e.toString());
		}
		finally
		{
			try
			{
				if(pstmt!=null)	pstmt.close();
				if(rs!=null) rs.close();
			}
			catch(Exception e){}
		}
	}
	catch(Exception ee)
	{
		sb.append("Exception in main try"+ee.getMessage());
	}
	finally
	{
		if (con != null)
        {
           try 
			{
				if( con != null ) ConnectionManager.returnConnection(con,p);
            } 
			catch (Exception ee) {     }
         }
	}

		results.put( "status", new Boolean(result) ) ;
		results.put( "error", sb.toString() ) ;
		return results ;
	}

} // end session bean

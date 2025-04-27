/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;

public class DeathRegistrationServlet extends HttpServlet implements SingleThreadModel
{
	public DeathRegistrationServlet() {
	}
	public void doPost(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse)
		throws ServletException, IOException 
	{
		Statement statement = null;
		Statement stmt = null;
		ResultSet resultset = null;
		PreparedStatement pstmt = null;
		Properties p;
		int row_count = 0;
		
		String add_item = "N";
		String diag_code = "";
		String diag_type = "";
		String diag_desc = "";
		String record_type = "";
		String cause_indicator = "";
		String d = "";
		String diag_scheme ="";
		String problem_remarks ="";
		String update_problem = "";
		String userid = "";
		String diag_short_desc = "";
		String sensitive_yn ="";
		String locale ="";
		StringBuffer sbSql = new StringBuffer();		
		boolean commit_flag = true;
		int max_Srlno = 0;
		int rcnt = 0;
		int sno = 0, maxslno=0;
		int rres = 0;
		httpservletresponse.setContentType("text/html;charset=UTF-8");
		java.io.PrintWriter out = httpservletresponse.getWriter();
		Connection connection =null;
		
		

		try
		{
			httpservletrequest.setCharacterEncoding("UTF-8");
			//httpservletresponse.setContentType("text/html;charset=UTF-8");
			HttpSession httpsession = httpservletrequest.getSession(false);
			connection=ConnectionManager.getConnection(httpservletrequest);
			statement = connection.createStatement();
			stmt = connection.createStatement();

			String encounter_id = httpservletrequest.getParameter("encounter_id");
			String call_from = httpservletrequest.getParameter("call_from");
			String rowcount = httpservletrequest.getParameter("row_count");
			String facility_id = (String) httpsession.getValue("facility_id");
			p = (java.util.Properties) httpsession.getValue("jdbc");
			userid = p.getProperty("login_user");
			locale = p.getProperty("LOCALE");	
			connection.setAutoCommit(false);
			
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			d = dateFormat.format( dt ) ;
			d=d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
			String curdate = d;
            String wsno = p.getProperty("client_ip_address");
			if (rowcount!=null)
				row_count = Integer.parseInt(rowcount);
			resultset = stmt.executeQuery("select nvl(max(srl_no),0) from mr_death_register_diag_dtl where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+"");
			resultset.next();
			maxslno = resultset.getInt(1);
			resultset.close();
			resultset = null;

			String cur_practid = httpservletrequest.getParameter("practid");
			String cur_remarks = httpservletrequest.getParameter("remarks");
			String cur_death_by_pregnancy_yn ="N"; //httpservletrequest.getParameter("death_by_pregnancy_yn");
			String cur_autopsy_yn ="N";
				//httpservletrequest.getParameter("autopsy_yn");
			String cur_medical_legal_case_yn ="N"; //httpservletrequest.getParameter("medical_legal_case_yn");
			String cur_finalize_yn = httpservletrequest.getParameter("finalize_yn");
			
			if (cur_practid==null) cur_practid = "";
			if (cur_remarks==null) cur_remarks = "";
			if (cur_death_by_pregnancy_yn==null) cur_death_by_pregnancy_yn = "N";
			if (cur_autopsy_yn==null) cur_autopsy_yn = "N";
			if (cur_finalize_yn==null) cur_finalize_yn = "N";
			if (cur_medical_legal_case_yn==null) cur_medical_legal_case_yn = "N";
			if (call_from==null) call_from = "";

			for (int i=0;i<row_count;i++)
			{
				add_item = "add_item"+i;
				diag_code = "diag_code"+i;
				diag_type = "diag_type"+i;
				diag_desc = "diag_desc"+i;
				record_type = "record_type"+i;
				cause_indicator = "cause_indicator"+i;
				problem_remarks = "remarks"+i;
				update_problem = "update_problem"+i;
				
				add_item = httpservletrequest.getParameter(add_item);
				diag_code = httpservletrequest.getParameter(diag_code);
				diag_type = httpservletrequest.getParameter(diag_type);
				diag_desc = httpservletrequest.getParameter(diag_desc);
				record_type = httpservletrequest.getParameter(record_type);
				cause_indicator = httpservletrequest.getParameter(cause_indicator);
				problem_remarks = httpservletrequest.getParameter(problem_remarks);
				update_problem = httpservletrequest.getParameter(update_problem);
				if(add_item==null) add_item = "N";
				if(diag_code==null) diag_code = "";
				if(diag_type==null) diag_type = "";
				if(diag_desc==null) diag_desc = "";
				if(record_type==null) record_type = "";
				if(cause_indicator==null) cause_indicator = "";
				if(problem_remarks==null) problem_remarks = "";
				if(update_problem==null) update_problem = "N";

				String total_records = httpservletrequest.getParameter("totalRecords");
				if(total_records==null) total_records = "0";

				int totalRecords = Integer.parseInt(total_records);

				if (record_type.equals("D"))
					diag_scheme = "2";						
				else
					diag_scheme = "1";

				if(i<totalRecords)
				{					
					if (add_item.equals("N"))
					{

						if(sbSql.length() > 0 ) 
							sbSql.delete(0,sbSql.length());

						sbSql.append(" Delete from MR_DEATH_REGISTER_DIAG_DTL ");
						sbSql.append(" where ");
						sbSql.append(" facility_id = '"+facility_id+"' 	and encounter_id = "+encounter_id+" and diag_code='"+diag_code+"' ");
						sbSql.append(" and nvl(cause_indicator,'|')= nvl('"+cause_indicator+"','|') ");
						sbSql.append(" and nvl(record_type,'X')=nvl('"+record_type+"','X') ");
						
						
						// sql = "Delete from mr_death_register_diag_dtl where facility_id = '"+facility_id+"' 	and encounter_id = "+encounter_id+" and diag_code='"+diag_code+"' and nvl(cause_indicator,'|')= nvl('"+cause_indicator+"','|') and nvl(record_type,'X')=nvl('"+record_type+"','X')";
						rcnt = stmt.executeUpdate(sbSql.toString());
						if (rcnt==0)
						{
							out.println("<script>alert('Error in Delete');</script>");
							commit_flag = false;
						}
					}
					else
					{

						if(sbSql.length() > 0 ) 
							sbSql.delete(0,sbSql.length());

						/*sbSql.append(" update MR_DEATH_REGISTER_DIAG_DTL set ");
						sbSql.append(" problem_remarks = '"+problem_remarks+"',diag_type = '"+diag_type+"',  ");
						sbSql.append(" update_problem_yn = '"+update_problem+"', ");
						sbSql.append(" modified_by_id = '"+userid+"', modified_date = to_date('"+curdate+"','dd/mm/yyyy hh24:mi'), ");
						sbSql.append(" modified_at_ws_no ='"+wsno+"', ");
						sbSql.append(" modified_facility_id = '"+facility_id+"' ");
						sbSql.append(" where ");
						sbSql.append(" facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+" and diag_code='"+diag_code+"' ");
						sbSql.append(" and nvl(cause_indicator,'|')= nvl('"+cause_indicator+"','|') ");
						sbSql.append(" and nvl(record_type,'X')=nvl('"+record_type+"','X') ");*/
						String sqlinsert="update MR_DEATH_REGISTER_DIAG_DTL set problem_remarks=?,diag_type=?,update_problem_yn=?,modified_by_id=?,modified_date=to_date(?,'dd/mm/yyyy hh24:mi'),modified_at_ws_no=?,modified_facility_id=?  where facility_id=? and encounter_id=? and diag_code=? and  nvl(cause_indicator,'|')= nvl(?,'|') and  nvl(record_type,'X')=nvl(?,'X')";
		
						pstmt		=	connection.prepareStatement(sqlinsert);
						pstmt.setString(1,problem_remarks);
						pstmt.setString(2,diag_type);
						pstmt.setString(3,update_problem);
						pstmt.setString(4,userid);
						pstmt.setString(5,curdate);
						pstmt.setString(6,wsno);
						pstmt.setString(7,facility_id);
						pstmt.setString(8,facility_id);
						pstmt.setString(9,encounter_id);
						pstmt.setString(10,diag_code);
						pstmt.setString(11,cause_indicator);
						pstmt.setString(12,record_type);
						rcnt=pstmt.executeUpdate();
	                     if(pstmt!=null) pstmt.close();
						
						//sql = "update mr_death_register_diag_dtl set problem_remarks = '"+problem_remarks+"',diag_type = '"+diag_type+"', update_problem_yn = '"+update_problem+"', modified_by_id = '"+userid+"',modified_date = to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), modified_at_ws_no ='"+wsno+"', modified_facility_id = '"+facility_id+"' where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+" and diag_code='"+diag_code+"' and nvl(cause_indicator,'|')= nvl('"+cause_indicator+"','|') and nvl(record_type,'X')=nvl('"+record_type+"','X')";
						//rcnt = stmt.executeUpdate(sbSql.toString());						
						if (rcnt==0) 
						{	
							out.println("<script>alert('Error in Updating MR_DEATH_REGISTER_DIAG_DTL');</script>");
							commit_flag = false;
						}
						else if (rcnt==1)
						{
							if (cur_finalize_yn.equals("Y")&&update_problem.equals("Y"))
							{
								resultset = stmt.executeQuery("select nvl(max(srl_no),0)+1 from pr_problem");
								resultset.next();
								max_Srlno = resultset.getInt(1);
								resultset.close();
								resultset = null;
								
								pstmt = connection.prepareStatement("select sensitive_yn, short_desc from mr_icd_code where  diag_code = ? ");
								pstmt.setString(1, diag_code);
								resultset = pstmt.executeQuery();
								resultset.next();
								diag_short_desc = resultset.getString("short_desc");
								sensitive_yn = resultset.getString("sensitive_yn");
								resultset.close();
								pstmt.close();
								resultset = null;

								//Insert into pr_problem select values from pr_encounter


								if(sbSql.length() > 0 ) 
									sbSql.delete(0,sbSql.length());

								/*sbSql.append(" insert into pr_problem ");
								sbSql.append(" ( patient_id,srl_no,diag_code, record_type, cause_indicator, diag_code_scheme, diag_desc, primary_yn, final_yn, sensitive_yn, onset_date, onset_practitioner_id, onset_facility_id, onset_locn_code, onset_locn_type, onset_encounter_id, onset_recorded_date, problem_status, problem_remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, diag_type )");
								sbSql.append(" select ");
								sbSql.append(" patient_id,"+max_Srlno+",'"+diag_code+"','"+record_type+"',		'"+cause_indicator+"','"+diag_scheme+"','"+diag_short_desc+"', 'N', 	'N','"+sensitive_yn+"', ");
								sbSql.append(" to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code,assign_care_locn_type, encounter_id, to_date('"+curdate+"','dd/mm/yyyy hh24:mi'), 'A', '"+problem_remarks+"', ");
								sbSql.append(" '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+diag_type+"' ");
								sbSql.append(" from PR_ENCOUNTER where ");
								sbSql.append(" facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+" ");*/
								String sql_insert2="insert into pr_problem( patient_id,srl_no,diag_code, record_type, cause_indicator, diag_code_scheme, diag_desc, primary_yn, final_yn, sensitive_yn, onset_date, onset_practitioner_id, onset_facility_id, onset_locn_code, onset_locn_type, onset_encounter_id, onset_recorded_date, problem_status, problem_remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, diag_type ) select patient_id,?,?,?,?,?,?,'N','N',?,to_date(?, 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code,assign_care_locn_type, encounter_id,to_date(?,'dd/mm/yyyy hh24:mi'),'A',?,?,to_date(?, 'dd/mm/yyyy hh24:mi'),?,facility_id,?,to_date(?, 'dd/mm/yyyy hh24:mi'),?,facility_id,? from 	PR_ENCOUNTER where 	facility_id=? and encounter_id=?";
								pstmt		=	connection.prepareStatement(sql_insert2);
								pstmt.setInt(1,max_Srlno);
								pstmt.setString(2,diag_code);
								pstmt.setString(3,record_type);
								pstmt.setString(4,cause_indicator);
								pstmt.setString(5,diag_scheme);
								pstmt.setString(6,diag_short_desc);
								pstmt.setString(7,sensitive_yn);
								pstmt.setString(8,curdate);
								pstmt.setString(9,curdate);
								pstmt.setString(10,problem_remarks);
								pstmt.setString(11,userid);
								pstmt.setString(12,curdate);
								pstmt.setString(13,wsno);
								pstmt.setString(14,userid);
								pstmt.setString(15,curdate);
								pstmt.setString(16,wsno);
								pstmt.setString(17,diag_type);
								pstmt.setString(18,facility_id);
								pstmt.setString(19,encounter_id);
								rcnt=pstmt.executeUpdate();
								//sql = "insert into pr_problem(patient_id,srl_no,diag_code, record_type,cause_indicator,diag_code_scheme,diag_desc, primary_yn,final_yn,sensitive_yn,onset_date,onset_practitioner_id,onset_facility_id,onset_locn_code,onset_locn_type,onset_encounter_id,onset_recorded_date,problem_status,problem_remarks,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,diag_type) select patient_id,"+max_Srlno+",'"+diag_code+"','"+record_type+"',		'"+cause_indicator+"','"+diag_scheme+"','"+diag_short_desc+"', 'N', 	'N','"+sensitive_yn+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code,assign_care_locn_type, encounter_id, to_date('"+curdate+"','dd/mm/yyyy hh24:mi'), 'A', '"+problem_remarks+"', '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+diag_type+"' from pr_encounter where 	facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+"";
								  if(pstmt!=null) pstmt.close();
								//rcnt = statement.executeUpdate(sbSql.toString());
								if (rcnt!=1)
								{
									out.println("<script>alert('Error in inserting values to Pr_problem');</script>");
									commit_flag = false;
								}
							} // end of condition if
						} // end of else if
					} //end of else
				} // end of if
				else if (add_item.equals("Y"))
				{
					sno=maxslno+1;
					
					try
					{
						if(sbSql.length() > 0 ) 
							sbSql.delete(0,sbSql.length());

						//sbSql.append(" insert into MR_DEATH_REGISTER_DIAG_DTL values ( ");
						//sbSql.append(" '"+	facility_id+"',"+encounter_id+","+sno+",'"+diag_scheme+"','"+record_type+"', ");
						//sbSql.append(" '"+cause_indicator+"', '"+diag_type+"', '"+diag_code+"', '"+problem_remarks+"', ");
						//sbSql.append(" '"+update_problem+"', '"+userid+"', to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), ");
						//sbSql.append(" '"+wsno+"', '"+facility_id+"', '"+userid+"', ");
						//sbSql.append(" to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), '"+wsno+"', '"+facility_id+"' ) ");

						//sql = "insert into mr_death_register_diag_dtl values ('"+	facility_id+"',"+encounter_id+","+sno+",'"+diag_scheme+"','"+record_type+"','"	+cause_indicator+"','"+diag_type+"','"+diag_code+"','"+problem_remarks+"','"+update_problem+"','"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), '"+wsno+"','"+facility_id+"','"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"','"+facility_id+"')";
                     
						String sql_new4="insert into mr_death_register_diag_dtl (facility_id, encounter_id, srl_no, diag_code_scheme, record_type, cause_indicator, diag_type, diag_code, problem_remarks, update_problem_yn, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id)  values(?,?,?,?,?,?,?,?,?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?,?,to_date(?,'dd/mm/rrrr hh24:mi'),?,?)";
							
						pstmt		=	connection.prepareStatement(sql_new4);
								pstmt.setString(1,facility_id);
								pstmt.setString(2,encounter_id);
								pstmt.setInt(3,sno);
								pstmt.setString(4,diag_scheme);
								pstmt.setString(5,record_type);
								pstmt.setString(6,cause_indicator);
								pstmt.setString(7,diag_type);
								pstmt.setString(8,diag_code);
								pstmt.setString(9,problem_remarks);
								pstmt.setString(10,update_problem);
								pstmt.setString(11,userid);
								pstmt.setString(12,curdate);
								pstmt.setString(13,wsno);
								pstmt.setString(14,facility_id);
								pstmt.setString(15,userid);
								pstmt.setString(16,curdate);
								pstmt.setString(17,wsno);
								pstmt.setString(18,facility_id);
								rcnt=pstmt.executeUpdate();
						  if(pstmt!=null) pstmt.close();
						//rcnt = statement.executeUpdate(sbSql.toString());
						if (rcnt==1)
						{
							if (cur_finalize_yn.equals("Y")&&update_problem.equals("Y"))
							{
								resultset = stmt.executeQuery("select nvl(max(srl_no),0)+1 from pr_problem");
								resultset.next();
								max_Srlno = resultset.getInt(1);
								resultset.close();
								resultset = null;
								
								pstmt = connection.prepareStatement("select sensitive_yn, short_desc from mr_icd_code where  diag_code = ? ");
								pstmt.setString(1, diag_code);
								resultset = pstmt.executeQuery();
								resultset.next();
								diag_short_desc = resultset.getString("short_desc");
								sensitive_yn = resultset.getString("sensitive_yn");
								resultset.close();
								pstmt.close();
								resultset = null;

								//Insert into pr_problem select values from pr_encounter

							if(sbSql.length() > 0 ) 
								sbSql.delete(0,sbSql.length());

							/*sbSql.append(" insert into PR_PROBLEM ");
							sbSql.append(" ( patient_id, srl_no,diag_code, record_type, cause_indicator, diag_code_scheme, diag_desc, primary_yn, final_yn, sensitive_yn, onset_date, onset_practitioner_id, onset_facility_id, onset_locn_code, onset_locn_type, onset_encounter_id, onset_recorded_date, problem_status, problem_remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, diag_type ) ");
							sbSql.append(" select	patient_id,"+max_Srlno+",'"+diag_code+"','"+record_type+"', '"+cause_indicator+"','"+diag_scheme+"','"+diag_short_desc+"', 'N', 'N','"+sensitive_yn+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code, assign_care_locn_type, encounter_id, to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), 'A', '"+problem_remarks+"', '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+diag_type+"'  ");
							sbSql.append(" from PR_ENCOUNTER where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+" ");*/

							//sql = "insert into pr_problem(patient_id,srl_no,diag_code, record_type,cause_indicator,diag_code_scheme,diag_desc, primary_yn,final_yn,sensitive_yn,onset_date,onset_practitioner_id, onset_facility_id,onset_locn_code,onset_locn_type,onset_encounter_id,onset_recorded_date,problem_status,problem_remarks,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,diag_type) select	patient_id,"+max_Srlno+",'"+diag_code+"','"+record_type+"', '"+cause_indicator+"','"+diag_scheme+"','"+diag_short_desc+"', 'N', 'N','"+sensitive_yn+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code, assign_care_locn_type, encounter_id, to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), 'A', '"+problem_remarks+"', '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+userid+"',to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'),'"+wsno+"', facility_id, '"+diag_type+"' from pr_encounter where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+"";
							String sql_insert2="insert into pr_problem(patient_id,srl_no,diag_code, record_type, cause_indicator, diag_code_scheme, diag_desc, primary_yn, final_yn, sensitive_yn, onset_date, onset_practitioner_id, onset_facility_id, onset_locn_code, onset_locn_type, onset_encounter_id, onset_recorded_date, problem_status, problem_remarks, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, diag_type) select patient_id,?,?,?,?,?,?,'N','N',?,to_date(?, 'dd/mm/yyyy hh24:mi'),attend_practitioner_id, facility_id, assign_care_locn_code,assign_care_locn_type, encounter_id,to_date(?,'dd/mm/yyyy hh24:mi'),'A',?,?,to_date(?, 'dd/mm/yyyy hh24:mi'),?,facility_id,?,to_date(?, 'dd/mm/yyyy hh24:mi'),?,facility_id,? from 	PR_ENCOUNTER where 	facility_id=? and encounter_id=?";

								pstmt		=	connection.prepareStatement(sql_insert2);
								pstmt.setInt(1,max_Srlno);
								pstmt.setString(2,diag_code);
								pstmt.setString(3,record_type);
								pstmt.setString(4,cause_indicator);
								pstmt.setString(5,diag_scheme);
								pstmt.setString(6,diag_short_desc);
								pstmt.setString(7,sensitive_yn);
								pstmt.setString(8,curdate);
								pstmt.setString(9,curdate);
								pstmt.setString(10,problem_remarks);
								pstmt.setString(11,userid);
								pstmt.setString(12,curdate);
								pstmt.setString(13,wsno);
								pstmt.setString(14,userid);
								pstmt.setString(15,curdate);
								pstmt.setString(16,wsno);
								pstmt.setString(17,diag_type);
								pstmt.setString(18,facility_id);
								pstmt.setString(19,encounter_id);
								rcnt=pstmt.executeUpdate();
							    if(pstmt!=null) pstmt.close();
								//rcnt = statement.executeUpdate(sbSql.toString());
								if (rcnt!=1)
								{
									out.println("<script>alert('Error in inserting values to Pr_problem');</script>");
									commit_flag = false;
								}
							} // end of if
							maxslno=sno;
						} // end of if
						else
						{
							out.println("<script>alert('Error in inserting values to mr_Death_register_diag_dtl');</script>");
							commit_flag = false;
						}
					} //end of try
					catch (Exception e)
					{
						//out.println("<script>alert('Error in insert '"+e+");</script)");
						e.printStackTrace();
						commit_flag = false;
					}
				} //end of else if
			} //end of for

			try
			{
				if (commit_flag==true)
				{
					/*rres = stmt.executeUpdate("update mr_death_register_hdr set death_date_time =to_date('"+cur_death_date_time+"','dd/mm/yyyy hh24:mi'), auth_practitioner_id='"+cur_practid+"', remarks='"+cur_remarks+"',death_by_pregnancy_yn ='"+cur_death_by_pregnancy_yn+"',autopsy_yn='"+cur_autopsy_yn+"', medical_legal_case_yn = '"+cur_medical_legal_case_yn+"', finalize_yn ='"+cur_finalize_yn+"', modified_by_id = '"+userid+"',modified_date = to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), modified_at_ws_no =	'"+wsno+"', modified_facility_id = '"+facility_id+"' where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+"");
					*/
					//String new_death=" update mr_death_register_hdr set  auth_practitioner_id='"+cur_practid+"', remarks='"+cur_remarks+"',death_by_pregnancy_yn ='"+cur_death_by_pregnancy_yn+"',autopsy_yn='"+cur_autopsy_yn+"', medical_legal_case_yn = '"+cur_medical_legal_case_yn+"', finalize_yn ='"+cur_finalize_yn+"', modified_by_id = '"+userid+"',modified_date = to_date('"+curdate+"', 'dd/mm/yyyy hh24:mi'), modified_at_ws_no =	'"+wsno+"', modified_facility_id = '"+facility_id+"' where facility_id = '"+facility_id+"' and encounter_id = "+encounter_id+"";


					String sql_new3="update mr_death_register_hdr set  auth_practitioner_id=?, remarks=?, death_by_pregnancy_yn=?, autopsy_yn=?, medical_legal_case_yn=?, finalize_yn=?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=? where facility_id =? and encounter_id =?";
					pstmt		=	connection.prepareStatement(sql_new3);
					pstmt.setString(1,cur_practid);
					pstmt.setString(2,cur_remarks);
					pstmt.setString(3,cur_death_by_pregnancy_yn);
					pstmt.setString(4,cur_autopsy_yn);
					pstmt.setString(5,cur_medical_legal_case_yn);
					pstmt.setString(6,cur_finalize_yn);
					pstmt.setString(7,userid);
					//pstmt.setString(8,curdate);
					pstmt.setString(8,wsno);
					pstmt.setString(9,facility_id);
					pstmt.setString(10,facility_id);
					pstmt.setString(11,encounter_id);
					rres=pstmt.executeUpdate();
                     if(pstmt!=null) pstmt.close();
					//rres = stmt.executeUpdate(new_death);
					
					if (rres==1)
					{
						connection.commit();
						java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
						String msg = (String) message.get("message");
						out.println("<script>alert('"+msg+"')</script>");

						if (call_from.equals("MAINTAIN_DEATH_REGISTER")) 
							out.print("<script>window.close();</script>");
						else if (call_from.equals("MO_REGN_ATTN")) 
							out.print("<script>parent.window.close();</script>");
						else
							out.print("<script>parent.parent.frames(0).location.href='../eCommon/html/blank.html';</script>");

					}
					else
					{
						connection.rollback();
						out.println("<script>alert('Error in update');</script>");
					}	
				} // end of if
				else
				{
					connection.rollback();
					out.println("<script>alert('Error in Insert/update');</script>");
				}
			} //end of try
			catch (Exception e)
			{
				//out.println("<script>alert('Error :'"+e+");</script>");
				e.printStackTrace();
				connection.rollback();
			}			
			if(resultset != null)resultset.close();
			if (stmt!=null) stmt.close();
			if(pstmt != null)pstmt.close();
			if (statement!=null) statement.close();
		} //end of main try
		catch (Exception e)
		{
			//out.println("<script>alert('Error :'"+e+");</script>");
			e.printStackTrace();
				
		}
		finally
		{
			ConnectionManager.returnConnection(connection,httpservletrequest);
		}
	}
}

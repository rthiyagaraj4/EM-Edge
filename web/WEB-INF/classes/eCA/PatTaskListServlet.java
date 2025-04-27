/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eCA;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.MessageManager;
import webbeans.eCommon.*;

public class PatTaskListServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException
	{
		HttpSession session = request.getSession(false);
				
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String outPut1 = " ";
		String outPut2 = " ";
		out.println(outPut1);
		insertRecord(request,session,out);
		out.println(outPut2);
	}
	void insertRecord(HttpServletRequest request, HttpSession session, PrintWriter out)
	{
		Hashtable tabdata;
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc") ;
		String facilityId = checkForNull((String)session.getValue("facility_id"));
		String addedById   = checkForNull(p.getProperty( "login_user" ));
		String addedAtWSNo = checkForNull(p.getProperty("client_ip_address"));
		String locale	= (String) p.getProperty("LOCALE");
		int count=0;
		String taskCode=checkForNull(request.getParameter("taskCode")).trim();
		String status=checkForNull(request.getParameter("status")).trim();
		//String taskType=checkForNull(request.getParameter("taskType")).trim();
		String patientId=checkForNull(request.getParameter("patientId")).trim();
		String remarks = checkForNull(request.getParameter("remarks")).trim();
		String practitionerId = checkForNull(request.getParameter("practitonerId")).trim();
		String taskSrlNo = checkForNull(request.getParameter("taskSrlNo")).trim();
		String resultType= checkForNull(request.getParameter("resultType")).trim();
		String resultId= checkForNull(request.getParameter("resultId")).trim();
		String discr_msr_id = "";
		String discr_result_type="";
		String  discr_result_num="";
		String  discr_result_str="";
		String dateTime= "";
		String encounter_id = checkForNull(request.getParameter("encounter_id")).trim();
		int counter=0;
		int index=0;
		PreparedStatement ps=null;
		String uom = "";
		Connection con = null;
		StringBuffer sql = new StringBuffer();
		int insertSql = 0;
		if(status.equals("P"))
		{
			dateTime= checkForNull(request.getParameter("dateTime")).trim();
		}
		try
		{	
			con = ConnectionManager.getConnection(request);
			sql.append(" update ca_pat_task_list set  ");
			if(status.equals("N"))
			{
				sql.append( " PERFORMED_DATE=sysdate " );
			}
			else
			{
				sql.append( " PERFORMED_DATE=to_date(?,'dd/mm/yyyy hh24:mi') " );
			}
			sql.append(" ,STATUS= ?, STATUS_DATE=sysdate, PERFORMED_BY_ID=?, PERFORMED_BY_ROLE_TYPE='P',remarks=?,MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where PATIENT_ID =? and  TASK_CODE = ? and  TASK_SRL_NO = ? ");
			ps = con.prepareStatement(sql.toString());
			
			if(status.equals("P"))
			{
				ps.setString(++count,dateTime);
			}	
			ps.setString(++count,status);

			ps.setString(++count,practitionerId);

			ps.setString(++count,remarks);

			ps.setString(++count,addedById);

			ps.setString(++count,addedAtWSNo);
			ps.setString(++count,facilityId);
			ps.setString(++count,patientId);

			ps.setString(++count,taskCode);
			ps.setInt(++count,Integer.parseInt(taskSrlNo));	
			int inserted = ps.executeUpdate();

			
			if(ps != null) ps.close();

		

		
if (status.equals("P"))
		{
		
		
		String care_plan_id="",md_care_plan_id="";
		PreparedStatement pstmtPatTaskList = null;
		ResultSet rsPatTaskList = null;

		String sqlPatTaskList=" select care_plan_id,md_care_plan_id from ca_pat_task_list  where "+
								" PATIENT_ID =? and  TASK_CODE = ? and  TASK_SRL_NO = ? ";
			
		pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);
		pstmtPatTaskList.setString(1,patientId);
		pstmtPatTaskList.setString(2,taskCode);
			pstmtPatTaskList.setString(3,taskSrlNo);
		rsPatTaskList= pstmtPatTaskList.executeQuery();
		while(rsPatTaskList.next())
			{
				care_plan_id = rsPatTaskList.getString(1);
				md_care_plan_id = rsPatTaskList.getString(2);

			}
		if(rsPatTaskList !=null) rsPatTaskList.close();
		if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
		sqlPatTaskList = "";


		sqlPatTaskList = " select 1 from ca_pat_task_list where care_plan_id=? and md_care_plan_id=? " + 
						" and status='O' and rownum=1 ";

		pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);

		pstmtPatTaskList.setString(1,care_plan_id);
		pstmtPatTaskList.setString(2,md_care_plan_id);
		rsPatTaskList= pstmtPatTaskList.executeQuery();
		boolean countFlag = false;
		while(rsPatTaskList.next())
			{
				countFlag = true;
			}

		if(rsPatTaskList !=null) rsPatTaskList.close();
		if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
		sqlPatTaskList = "";
		//int sqlUpdate = 0;

			if (countFlag)
			{
				
				
				sqlPatTaskList=" update CP_PAT_CARE_PLAN_INTVN_DTL  set status='P',status_date = sysdate where MD_CARE_PLAN_ID=? and CARE_PLAN_ID =? and INTERVENTION_CODE =? and status in ('O') ";

				pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);
				pstmtPatTaskList.setString(1,md_care_plan_id);
				pstmtPatTaskList.setString(2,care_plan_id);
				pstmtPatTaskList.setString(3,taskCode);
				//sqlUpdate= pstmtPatTaskList.executeUpdate();
				pstmtPatTaskList.executeUpdate();

				if(rsPatTaskList !=null) rsPatTaskList.close();
				if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
				sqlPatTaskList = "";


				sqlPatTaskList="UPDATE CP_PAT_CARE_PLAN_INTVN SET STATUS='P',status_date = sysdate where MD_CARE_PLAN_ID=? and CARE_PLAN_ID =? and INTERVENTION_CODE =? AND APPL_YN='Y' and status in ('O')";
				pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);
				pstmtPatTaskList.setString(1,md_care_plan_id);
				pstmtPatTaskList.setString(2,care_plan_id);
				pstmtPatTaskList.setString(3,taskCode);
				//sqlUpdate= pstmtPatTaskList.executeUpdate();
				pstmtPatTaskList.executeUpdate();
				
				
				if(rsPatTaskList !=null) rsPatTaskList.close();
				if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
				sqlPatTaskList = "";

			
			}
			
			else
			{
				
				
				sqlPatTaskList=" update CP_PAT_CARE_PLAN_INTVN_DTL  set status='C',status_date = sysdate where MD_CARE_PLAN_ID=? and CARE_PLAN_ID =? and INTERVENTION_CODE =? and status in ('O','P') ";

				pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);
				pstmtPatTaskList.setString(1,md_care_plan_id);
				pstmtPatTaskList.setString(2,care_plan_id);
				pstmtPatTaskList.setString(3,taskCode);
				//sqlUpdate= pstmtPatTaskList.executeUpdate();
				pstmtPatTaskList.executeUpdate();
				
				if(rsPatTaskList !=null) rsPatTaskList.close();
				if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
				sqlPatTaskList = "";


				sqlPatTaskList="UPDATE CP_PAT_CARE_PLAN_INTVN SET STATUS='C',status_date = sysdate where MD_CARE_PLAN_ID=? and CARE_PLAN_ID =? and INTERVENTION_CODE =? AND APPL_YN='Y' and status in ('O','P')";
				pstmtPatTaskList = con.prepareStatement(sqlPatTaskList);
				pstmtPatTaskList.setString(1,md_care_plan_id);
				pstmtPatTaskList.setString(2,care_plan_id);
				pstmtPatTaskList.setString(3,taskCode);
				//sqlUpdate= pstmtPatTaskList.executeUpdate();
				pstmtPatTaskList.executeUpdate();
				
				if(rsPatTaskList !=null) rsPatTaskList.close();
				if(pstmtPatTaskList !=null) pstmtPatTaskList.close();
				sqlPatTaskList = "";
				 
			}
		
		}
		//==============
			String errorMsg = "";
			StringBuffer replaceString = null;
			
			if(inserted == 1)
			{
				
				
				sql = new StringBuffer();
				counter = request.getParameter("count")==null ? 0 : Integer.parseInt(request.getParameter("count"));
				

				if(resultType.equals("DP")||resultType.equals("DA") )
				{
					
					
					//counter = request.getParameter("count")==null ? 0 : Integer.parseInt(request.getParameter("count"));

					if(counter != 0)
					{
						sql.append("insert into ca_encntr_discr_msr(FACILITY_ID,ACCESSION_NUM,ENCOUNTER_ID, PATIENT_ID,PATIENT_CLASS,TEST_OBSERV_DT_TM,PERFORMING_PRACT_ID,DISCR_MSR_ID, DISCR_MSR_RESULT_TYPE,DISCR_MSR_RESULT_NUM,DISCR_MSR_RESULT_NUM_UOM, DISCR_MSR_RESULT_STR,DISCR_MSR_RESULT_DATA,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW, CRITICAL_HIGH,NORM_ABNORM_IND,DISCR_MSR_PANEL_OR_FORM_ID,ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO,CHART_ID) values(?, 'DM$'||to_char(sysdate,'YYYY')||'$'||lpad(CA_DISCR_MSR_SEQ.NEXTVAL,16,0),?,?,(select patient_class from pr_encounter where facility_id=? and encounter_id=?) , to_date( ? ,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,empty_clob(),?,?,?,?,?,?,?,sysdate,?,?,?, sysdate,?,?,'TASKRESULT') ");
						ps = con.prepareStatement(sql.toString());
						int counter1=0;
						count = 0;
						for(index = 0 ;index < counter;index++)
						{
							counter1=0;
							discr_result_type = "";
							discr_result_num="";
							discr_result_str="";
							discr_result_type = checkForNull(request.getParameter("resultType"+index));
							discr_msr_id= checkForNull(request.getParameter("discr_msr_id"+index));

							if(!discr_msr_id.equals(""))
							{
							if(discr_result_type.equals("N"))
							{
								discr_result_num  = checkForNull(request.getParameter("comp_"+index));
							}
							else if(discr_result_type.equals("L"))
							{
								discr_result_num=checkForNull(request.getParameter("comp_"+index));
								discr_result_str = checkForNull(request.getParameter("selectListText"+index));
							}
							else if(discr_result_type.equals("C"))
							{
								discr_result_str = request.getParameter("comp_"+index)==null ? "N" :request.getParameter("comp_"+index);		
							}
							else
							{
								discr_result_str =checkForNull(request.getParameter("comp_"+index));
							}
							uom = checkForNull(request.getParameter("unit_of_measure"+index));
							ps.setString(++counter1, facilityId);
							ps.setString(++counter1, encounter_id);
							ps.setString(++counter1, patientId);
//							stmt.setString(++counter,);
							ps.setString(++counter1,facilityId);
							ps.setString(++counter1, encounter_id);
							ps.setString(++counter1, dateTime);
							ps.setString(++counter1, checkForNull((String) session.getValue("ca_practitioner_id")));
							ps.setString(++counter1, discr_msr_id);
							ps.setString(++counter1, discr_result_type);
							ps.setString(++counter1, discr_result_num);
							ps.setString(++counter1,uom);
							ps.setString(++counter1,discr_result_str);
							ps.setString(++counter1,"");
							ps.setString(++counter1,"");
							ps.setString(++counter1,"");
							ps.setString(++counter1,"");
							ps.setString(++counter1,"");
							ps.setString(++counter1,resultId);
							ps.setString(++counter1,addedById);
							ps.setString(++counter1,facilityId);
							ps.setString(++counter1,addedAtWSNo);
							ps.setString(++counter1,addedById);
							ps.setString(++counter1,facilityId);
							ps.setString(++counter1,addedAtWSNo);
							insertSql += ps.executeUpdate();
							}
						}
						if(ps != null) ps.close();
					}
						
				}
				
				
				con.commit();
				//tabdata = MessageManager.getMessage(con, "RECORD_INSERTED");
				tabdata = MessageManager.getMessage(locale, "RECORD_INSERTED","CA");
				
				errorMsg= (String) tabdata.get("message");
				replaceString = new StringBuffer(errorMsg);
				if((index=replaceString.toString().indexOf("<br>"))!=-1)
				{
							replaceString=replaceString.replace(index,index+"<br>".length()," ");
				}	
						//DUP_CHART_RECORD
					out.println("<script>alert('"+replaceString.toString()+"')</script>");
					out.println("<script>window.returnValue='OK'</script>");
					out.println("<script>window.close()</script>");
					
			}
				
		}
		catch(Exception ee)
		{
						
				try
					{
						con.rollback();
					}
				catch(Exception ex)
					{
					}
				ee.printStackTrace();
				//out.println("Exception raise by PatTaskListServlet ...So Record Not Updated  : "+ee.toString());//common-icn-0181
				
				
		}
		finally
		{
				if(con != null)
					ConnectionManager.returnConnection(con);
		}
	}
	private String checkForNull(String IntermediateString)	
	{
		if(IntermediateString == null ||IntermediateString.equals(""))
		IntermediateString="";

		return IntermediateString;
	}
}

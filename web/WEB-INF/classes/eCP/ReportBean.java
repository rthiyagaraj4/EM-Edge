/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
15/05/2018  	IN065254		Kamalakannan G  		15/05/2018 		 Ramesh G 		GHL_CRF_0485
21/05/2018 		IN067697		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/01
21/05/2018 		IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/02
29/05/2018 		IN067703 		Kamalakannan G  		29/05/2018 		 Ramesh G 		GHL_CRF_0485/05
31/05/2018 		IN067809 		Kamalakannan G  		31/05/2018 		 Ramesh G 		GHL_CRF_0485/06
---------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCP;
import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCA.Common.CaAdapter;
public class ReportBean extends CaAdapter implements java.io.Serializable {
	
	ArrayList<ArrayList<String>> nursingReportList = new ArrayList<ArrayList<String>>();	
	ArrayList<ArrayList<String>> taskStatusReport = new ArrayList<ArrayList<String>>();
	public ArrayList getNursePlanReport(String patient_id,String from_date,String to_date,String locale,String diag,String goal_code,String intervention_code,String status) throws Exception
	{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		int cnt =0;
		if(patient_id.equals(" ") || patient_id.equals("null")) patient_id = "";
		if(from_date.equals(" ") || from_date.equals("null")) from_date = "";
		if(to_date.equals(" ") || to_date.equals("null")) to_date = "";
		if(status.equals(" ") || status.equals("null")) status = "";
		if(diag.equals(" ") || diag.equals("null")) diag = "";
		if(goal_code.equals(" ") || goal_code.equals("null")) goal_code = "";
		if(intervention_code.equals(" ") || intervention_code.equals("null")) intervention_code = "";
			from_date=com.ehis.util.DateUtils.convertDate(from_date,"DMY",language_id,"en");
			to_date=com.ehis.util.DateUtils.convertDate(to_date,"DMY",language_id,"en");
		try{ 
			connection = getConnection();
			String sql   = "";
			
			sql = "SELECT distinct SM_CONVERT_DATETIME_2T(a.care_plan_start_date,?) start_date,SM_CONVERT_DATETIME_2T(a.care_plan_target_date,?)target_date,SM_CONVERT_DATETIME_2T(b.eval_datetime,?)evaluation_date,f.term_code_short_desc nursing_diagnosis,g.short_desc goal_statement,h.short_desc intervention,d.intervention_code,i.short_desc expected_outcome, a.current_status status,a.care_plan_start_date start_date_ord_by,a.care_plan_target_date targetdate,b.eval_datetime evalDate FROM cp_pat_care_plan a,cp_pat_care_plan_eval b,cp_pat_care_plan_goal c,cp_pat_care_plan_intvn d,cp_pat_care_plan_outcome e,pr_diagnosis f,cp_outcome_lang_vw g,ca_intervention h,cp_outcome_lang_vw i,mp_patient j WHERE a.md_care_plan_id = b.md_care_plan_id AND a.care_plan_id = b.care_plan_id AND a.md_care_plan_id = c.md_care_plan_id AND a.care_plan_id = c.care_plan_id AND a.md_care_plan_id = d.md_care_plan_id AND a.care_plan_id = d.care_plan_id AND a.md_care_plan_id = e.md_care_plan_id AND a.care_plan_id = e.care_plan_id AND b.md_care_plan_id = c.md_care_plan_id AND b.care_plan_id = c.care_plan_id AND b.md_care_plan_id = e.md_care_plan_id AND b.care_plan_id = e.care_plan_id AND c.md_care_plan_id = e.md_care_plan_id AND c.care_plan_id = e.care_plan_id and c.TERM_SET_ID =d.TERM_SET_ID and c.TERM_CODE =d.TERM_CODE and c.TERM_CODE_SRL_NO = d.TERM_CODE_SRL_NO and c.GOAL_CODE =d.GOAL_CODE and c.GOAL_SRL_NO =d.GOAL_SRL_NO AND c.TERM_SET_ID = e.TERM_SET_ID AND c.TERM_CODE = e.TERM_CODE AND c.TERM_CODE_SRL_NO = e.TERM_CODE_SRL_NO AND c.GOAL_CODE = e.GOAL_CODE AND c.GOAL_SRL_NO = e.GOAL_SRL_NO AND f.TERM_SET_ID = e.TERM_SET_ID AND f.TERM_CODE = e.TERM_CODE and f.TERM_SET_ID =d.TERM_SET_ID and f.TERM_CODE =d.TERM_CODE and c.TERM_SET_ID =f.TERM_SET_ID and c.TERM_CODE =f.TERM_CODE AND a.patient_id =f.patient_id AND g.outcome_code = i.outcome_code AND d.intervention_code = h.intervention_code AND e.outcome_code = i.outcome_code AND e.outcome_code = g.outcome_code AND i.language_id = g.language_id and j.PATIENT_ID=a.patient_id AND f.patient_id =e.patient_id AND a.patient_id=d.patient_id AND d.patient_id =f.patient_id and f.patient_id=? and a.care_plan_start_date  between TO_DATE((?||' 00:00'),'DD/MM/YYYY HH24:MI')   and TO_DATE((?||'23:59'),'DD/MM/YYYY HH24:MI')&&DIAG##&&INTERVENTION##&&status##&&GOAL##  ORDER BY start_date_ord_by,targetdate,evalDate,d.intervention_code ";//IN067699 time added
			if(!diag.equals(""))
			{
				sql = sql.replace("&&DIAG##" , " and f.term_code= nvl(?,f.term_code)");
			}
			else
			{
				sql = sql.replace("&&DIAG##" , "");
			}
			if(!intervention_code.equals(""))
			{
				sql = sql.replace("&&INTERVENTION##" , " and h.intervention_code=nvl(?,h.intervention_code)");	
			}
			else
			{
				sql = sql.replace("&&INTERVENTION##" , "");
			}
			if(!status.equals(""))
			{
				if(!status.equals("ALL")){
				sql = sql.replace("&&status##" , " and a.current_status = nvl(?,a.current_status)");	
				}//IN067697 start 
				else
				{
					sql = sql.replace("&&status##" , "");
				}//IN067697 end
			}
			else
			{
				sql = sql.replace("&&status##" , "");
			}
			
			if(!goal_code.equals(""))
			{
				sql = sql.replace("&&GOAL##" , "and g.outcome_code =nvl(?,g.outcome_code)");	
			}
			else
			{
				sql = sql.replace("&&GOAL##" , "");
			}
			
			
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pstmt.setString( ++cnt ,locale) ;  
			pstmt.setString( ++cnt ,locale) ;  
			pstmt.setString( ++cnt ,locale) ; 
			pstmt.setString( ++cnt ,patient_id) ;
			pstmt.setString( ++cnt ,from_date) ;
			pstmt.setString( ++cnt ,to_date) ;
			if(!diag.equals(""))
			{
				pstmt.setString( ++cnt ,diag) ;  
			}
			if(!intervention_code.equals(""))
			{
				pstmt.setString( ++cnt ,intervention_code) ;  
			}
			if(!status.equals("") && !status.equals("ALL"))//IN067697
			{
				pstmt.setString( ++cnt ,status) ;  
			}
			if(!goal_code.equals(""))
			{
				pstmt.setString( ++cnt ,goal_code) ;  
			}
			
			
			resultSet = pstmt.executeQuery();
			if(resultSet!=null) {		
			
				nursingReportList = new ArrayList<ArrayList<String>>();
			while(resultSet.next() ) 
			{
						ArrayList<String> table_rows = new ArrayList<String>();	
						table_rows.add(resultSet.getString( "START_DATE" ));
						table_rows.add(resultSet.getString( "TARGET_DATE" ));
						table_rows.add(resultSet.getString( "Evaluation_Date" ));
						table_rows.add(resultSet.getString( "Nursing_Diagnosis" ));
						table_rows.add(resultSet.getString( "goal_statement" ));
						table_rows.add(resultSet.getString( "intervention" ));
						table_rows.add(resultSet.getString( "expected_outcome" ));
						if("C".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Completed");//IN067697 
						}
						else if("D".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Discontinued");
						}
						else{
							table_rows.add("Active");
						}
						nursingReportList.add(table_rows);
				}
			}
		}
		catch( Exception e )	
		{
				System.err.println( "Error loading values from database SEARCH" ) ;
				e.printStackTrace() ;				
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		System.out.println("nursingReportList-->"+nursingReportList);
		return nursingReportList;
	}
	public void callNursingPlanOnLinePrintReport(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception{//removed return type IN067703
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		try{
				String report_id ="CPNURSPL";
				String p_facility_id = (String)hashValues.get("p_facility_id");
				//String p_userName = (String)hashValues.get("p_userName");//IN067697 commented for checkstyle
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(p_facility_id,"CP",report_id,"","") ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_patientId",(String)hashValues.get("p_patientId")) ;
				report1.addParameter("p_nursingdiag_stmt",(String)hashValues.get("p_nursingdiag_stmt")) ;
				report1.addParameter("p_status",(String)hashValues.get("p_status")) ;
				report1.addParameter("p_goal_stmt",(String)hashValues.get("p_goal_stmt")) ;				
				report1.addParameter("p_Interventions",(String)hashValues.get("p_Interventions")) ;
				report1.addParameter("p_module_id","CP") ;
				report1.addParameter("p_date_from",(String)hashValues.get("p_date_from")) ;	
				report1.addParameter("p_date_to",(String)hashValues.get("p_date_to")) ;	
				report1.addParameter("p_language_id",(String)hashValues.get("p_language_id")) ;	
				report1.addParameter("p_facility_id",(String)hashValues.get("p_facility_id")) ;	
				report1.addParameter("p_user_Name",(String)hashValues.get("p_userName")) ;//IN067697
			    onlineReports.add(report1) ;			
			}	catch(Exception dummy)
			{
				dummy.printStackTrace();
			}
				onlineReports.execute( request, response );	
	}
	
	/*task status report*/
	public ArrayList getTaskStatusReport(String patient_id,String from_date,String to_date,String locale,String goal_code,String task_code,String status) throws Exception{
		Connection connection 			= null;
		PreparedStatement pstmt 		= null;
		ResultSet resultSet 			= null;
		int cnt =0;
		if(patient_id.equals(" ") || patient_id.equals("null")) patient_id = "";
		if(from_date.equals(" ") || from_date.equals("null")) from_date = "";
		if(to_date.equals(" ") || to_date.equals("null")) to_date = "";
		if(status.equals(" ") || status.equals("null")) status = "";
		if(goal_code.equals(" ") || goal_code.equals("null")) goal_code = "";
		if(task_code.equals(" ") || task_code.equals("null")) task_code = "";
			from_date=com.ehis.util.DateUtils.convertDate(from_date,"DMY",language_id,"en");
			to_date=com.ehis.util.DateUtils.convertDate(to_date,"DMY",language_id,"en");
		try{ 
			connection = getConnection();
			String sql   = "";
			//sql = "SELECT distinct SM_CONVERT_DATE_2T(e.goal_target_date,?) target_date,D.SHORT_DESC GOAL_STATEMENT, A.TASK_CODE,B.SHORT_DESC TASK,NVL(A.PRIORITY,'R') PRIORITY,a.status,e.goal_target_date goal_target FROM ca_pat_task_list a,ca_intervention b,ca_intervention_type c,cp_outcome_LANG_VW  d,cp_pat_care_plan_goal e,mp_patient f where b.intervention_code = a.task_code   AND c.intervention_type = a.task_type AND c.intervention_type = B.intervention_type  AND d.OUTCOME_CODE = e.GOAL_CODE AND A.PATIENT_ID = E.PATIENT_ID AND A.MD_CARE_PLAN_ID =E.MD_CARE_PLAN_ID AND A.CARE_PLAN_ID =E.CARE_PLAN_ID and a.patient_id=f.patient_id and e.patient_id=f.patient_id AND d.LANGUAGE_ID =? AND A.PATIENT_ID =? and e.goal_target_date  between TO_DATE((?||' 00:00'),'DD/MM/YYYY HH24:MI')   and TO_DATE((?||'23:59'),'DD/MM/YYYY HH24:MI') &&TASK##&&status##&&GOAL## order by goal_target";//IN067699--IN067809
			//sql = "SELECT distinct SM_CONVERT_DATE_2T(A.SCHEDULE_DATETIME,?) schedule,A.SCHEDULE_DATETIME schdel,D.SHORT_DESC GOAL_STATEMENT, A.TASK_CODE,B.SHORT_DESC TASK,NVL(A.PRIORITY,'R') PRIORITY,a.status,a.task_code taskk FROM ca_pat_task_list a,ca_intervention b,ca_intervention_type c,cp_outcome_LANG_VW  d,cp_pat_care_plan_goal e,mp_patient f where b.intervention_code = a.task_code   AND c.intervention_type = a.task_type AND c.intervention_type = B.intervention_type  AND d.OUTCOME_CODE = e.GOAL_CODE AND A.PATIENT_ID = E.PATIENT_ID AND A.MD_CARE_PLAN_ID =E.MD_CARE_PLAN_ID AND A.CARE_PLAN_ID =E.CARE_PLAN_ID and a.patient_id=f.patient_id and e.patient_id=f.patient_id AND d.LANGUAGE_ID =? AND A.PATIENT_ID =? and e.goal_target_date  between TO_DATE((?||' 00:00'),'DD/MM/YYYY HH24:MI')   and TO_DATE((?||'23:59'),'DD/MM/YYYY HH24:MI') &&TASK##&&status##&&GOAL## order by goal_statement,schdel,task_code ";//IN067809
			sql = "SELECT distinct SM_CONVERT_DATETIME_2T(A.SCHEDULE_DATETIME,?) schedule,A.SCHEDULE_DATETIME schdel,D.SHORT_DESC GOAL_STATEMENT, A.TASK_CODE,B.SHORT_DESC TASK,NVL(A.PRIORITY,'R') PRIORITY,a.status,a.task_code taskk FROM ca_pat_task_list a,ca_intervention b,ca_intervention_type c,cp_outcome_LANG_VW  d,cp_pat_care_plan_goal e,mp_patient f where b.intervention_code = a.task_code   AND c.intervention_type = a.task_type AND c.intervention_type = B.intervention_type  AND d.OUTCOME_CODE = e.GOAL_CODE AND A.PATIENT_ID = E.PATIENT_ID AND A.MD_CARE_PLAN_ID =E.MD_CARE_PLAN_ID AND A.CARE_PLAN_ID =E.CARE_PLAN_ID and a.patient_id=f.patient_id and e.patient_id=f.patient_id AND d.LANGUAGE_ID =? AND A.PATIENT_ID =? and a.SCHEDULE_DATETIME  between TO_DATE((?||' 00:00'),'DD/MM/YYYY HH24:MI')   and TO_DATE((?||'23:59'),'DD/MM/YYYY HH24:MI') &&TASK##&&status##&&GOAL## order by goal_statement,schdel,task_code ";// modified for IN067809 //time added
			if(!task_code.equals(""))
			{
				sql = sql.replace("&&TASK##" , " and a.task_code=nvl(?,a.task_code)");
			}
			else
			{
				sql = sql.replace("&&TASK##" , "");
			}
			
			
			if(!status.equals(""))
			{
				if(!status.equals("ALL")){
				sql = sql.replace("&&status##" , " and a.status = nvl(?,a.status)");
				}
				else
				{
					sql = sql.replace("&&status##" , "");
				}
			}
			else
			{
				sql = sql.replace("&&status##" , "");
			}
			if(!goal_code.equals(""))
			{
				sql = sql.replace("&&GOAL##" , " and d.outcome_code =nvl(?,d.outcome_code)");	
			}
			else
			{
				sql = sql.replace("&&GOAL##" , "");
			}
			
			
			pstmt = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			pstmt.setString( ++cnt ,locale) ;  
			pstmt.setString( ++cnt ,locale) ;  
			pstmt.setString( ++cnt ,patient_id) ;
			pstmt.setString( ++cnt ,from_date) ;
			pstmt.setString( ++cnt ,to_date) ;
			if(!task_code.equals(""))
			{
				pstmt.setString( ++cnt ,task_code) ;  
			}
			if(!status.equals(""))
			{
				if(!status.equals("ALL")){
				pstmt.setString( ++cnt ,status) ;  
				}
			}
			
			if(!goal_code.equals(""))
			{
				pstmt.setString( ++cnt ,goal_code) ;  
			}
		
			
			resultSet = pstmt.executeQuery();
			if(resultSet!=null) {		
			
				taskStatusReport = new ArrayList<ArrayList<String>>();
			while(resultSet.next() ) 
			{
						ArrayList<String> table_rows = new ArrayList<String>();	
						//table_rows.add(resultSet.getString( "target_date" )); commented for IN067809
						table_rows.add(resultSet.getString( "schedule" ));//IN067809
						table_rows.add(resultSet.getString( "GOAL_STATEMENT" ));
						table_rows.add(resultSet.getString( "TASK" ));
						//IN067699 start
						if("N".equals(resultSet.getString("PRIORITY"))){
							table_rows.add("Normal");
						}
						else if("C".equals(resultSet.getString("PRIORITY"))){
							table_rows.add("Critical");
						}
						else if("R".equals(resultSet.getString("PRIORITY"))){
							table_rows.add("Routine");
						}//IN067809 start
						else if("H".equals(resultSet.getString("PRIORITY"))){
							table_rows.add("High");
						}
						else{
							table_rows.add(" ");
						}//IN067809 end
						//IN067699 end
						if("O".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Pending");
						}
						else if("P".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Performed");
						}
						else if("N".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Not Performed");
						}
						else if("D".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Discontinued");
						}
						else if("9".equals(resultSet.getString( "STATUS" ))){
							table_rows.add("Cancelled");
						}
						taskStatusReport.add(table_rows);
				}
			}
		}
		catch( Exception e )	
		{
				System.err.println( "Error loading values from database SEARCH" ) ;
				e.printStackTrace() ;				
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		System.out.println("taskStatusReport-->"+taskStatusReport);
		return taskStatusReport;
	}
	public void callTaskStatusOnLinePrintReport(Hashtable hashValues, HttpServletRequest request, HttpServletResponse response) throws Exception{//removed return type IN067703
		ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
		try{
				String report_id ="CPTASKST";
				String p_facility_id = (String)hashValues.get("p_facility_id");
				//String p_userName = (String)hashValues.get("p_userName");//IN067699 commented for checkstyle 
				System.out.println("p_facility_id-->"+p_facility_id);
				ecis.utils.OnlineReport report1= new ecis.utils.OnlineReport(p_facility_id,"CP",report_id,"","") ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_patientid",(String)hashValues.get("p_patientId")) ;
				report1.addParameter("p_status",(String)hashValues.get("p_status")) ;
				report1.addParameter("p_task",(String)hashValues.get("p_task")) ;
				report1.addParameter("p_goal_stmt",(String)hashValues.get("p_goal_stmt")) ;				
				report1.addParameter("p_module_id","CP") ;
				report1.addParameter("p_date_from",(String)hashValues.get("p_date_from")) ;	
				report1.addParameter("p_date_to",(String)hashValues.get("p_date_to")) ;	
				report1.addParameter("p_language_id",(String)hashValues.get("p_language_id")) ;	
				report1.addParameter("p_facility_id",(String)hashValues.get("p_facility_id")) ;	
				report1.addParameter("p_user_Name",(String)hashValues.get("p_userName")) ;//IN067699
			    onlineReports.add(report1) ;
			}	catch(Exception dummy)
			{
				dummy.printStackTrace();
			}
				onlineReports.execute( request, response );	
				
	}
}

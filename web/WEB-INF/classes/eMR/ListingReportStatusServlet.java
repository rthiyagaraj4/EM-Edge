package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eDS.Common.*;

public class ListingReportStatusServlet extends HttpServlet {
	
	HttpSession session;
	String facility_id;
	String locale;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	
public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException{
		
		try	{ 
			session 	= request.getSession(true);
			facility_id = (String)session.getValue("facility_id");
			locale		= (String)session.getAttribute("LOCALE"); 
			String action 		=  (request.getParameter("action")==null || request.getParameter("action")=="")?"":request.getParameter("action");
            
			if(action.equals("reportStatusList")){
			   listingReportStatus(request,response);
			}

		}catch(Exception e){
				e.printStackTrace();
			}finally{
				
			}
	}

private void  listingReportStatus( HttpServletRequest request, HttpServletResponse response){
	con = ConnectionManager.getConnection(request);
	response.setContentType("application/json");

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean isPrePractinReprintAppl		=eCommon.Common.CommonBean.isSiteSpecific(con, "MR","ALLOW_PREP_PRACT_REPRINT"); //added by mujafar for ML-MMOH-SCF-1365
	
	//variables for display
    String request_id;
	String request_date;
	String patient_id;
	String patient_name;
	String sex;
	String practitioner_name;
	String collect_date;
	String request_status;
	String request_status_id;
	String revise_status;
	String appt_date;
	String med_board_type;
	String appt_ref_no;
	String overdue_status;
	String curr_date;
	String faci_id;
	String consent_letter;
	
	/*Variables For Paginations Start*/
			int rowCountHdr				= 0;
			String isPagination			= (request.getParameter("isPagination")==null || request.getParameter("isPagination")=="")?"N":request.getParameter("isPagination");
			int currentPageNo 			= 1;
			int recordsPerPage 			= 1;
			if(request.getParameter("currentPageNo") != null)
				currentPageNo 			= Integer.parseInt(request.getParameter("currentPageNo"));
			 
			if(request.getParameter("recordsPerPage") != null)
				recordsPerPage			= Integer.parseInt(request.getParameter("recordsPerPage"));
			 
			int noOfRecords 			= 0;
			int noOfPages	 			= 0;	
			int from 		 			= 1;
			int to			 			= recordsPerPage;
			
			if(currentPageNo!=1){
				from		= (currentPageNo - 1) * recordsPerPage +1;
				to			= (from -1) + recordsPerPage;
			}
	
	//search criteria variables
	String national_id_no 		=  (request.getParameter("national_id_no")==null || request.getParameter("national_id_no")=="")?"":request.getParameter("national_id_no");
	String other_alt_type 		=  (request.getParameter("other_alt_type")==null || request.getParameter("other_alt_type")=="")?"":request.getParameter("other_alt_type");
	String other_alt_Id 		=  (request.getParameter("other_alt_Id")==null || request.getParameter("other_alt_Id")=="")?"":request.getParameter("other_alt_Id");
	String alt_id1_no 		    =  (request.getParameter("alt_id1_no")==null || request.getParameter("alt_id1_no")=="")?"":request.getParameter("alt_id1_no");
	String alt_id2_no 			=  (request.getParameter("alt_id2_no")==null || request.getParameter("alt_id2_no")=="")?"":request.getParameter("alt_id2_no");
	String alt_id3_no 			=  (request.getParameter("alt_id3_no")==null || request.getParameter("alt_id3_no")=="")?"":request.getParameter("alt_id3_no");
	String alt_id4_no 			=  (request.getParameter("alt_id4_no")==null || request.getParameter("alt_id4_no")=="")?"":request.getParameter("alt_id4_no");
	String PatientId 			=  (request.getParameter("PatientId")==null || request.getParameter("PatientId")=="")?"":request.getParameter("PatientId");
	String status_to_show 		=  (request.getParameter("status_to_show")==null || request.getParameter("status_to_show")=="")?"":request.getParameter("status_to_show");
	String from_date 		=  (request.getParameter("from_date")==null || request.getParameter("from_date")=="")?"":request.getParameter("from_date");
	String to_date 		=  (request.getParameter("to_date")==null || request.getParameter("to_date")=="")?"":request.getParameter("to_date");
	
	StringBuffer where_criteria	= new StringBuffer();
	StringBuffer sqlSb			= new StringBuffer();
	String recordsList			= "";
	JSONObject json				= new JSONObject();

	try{
	   //where conditions
	   if(status_to_show.equals(""))
	   {
		   if(isPrePractinReprintAppl) //added by mujafar for ML-MMOH-SCF-1365
		   where_criteria.append(" (request_status in('2','7','5','6','0','4') or (request_status = '1' and CONSENT_LETTER_APPL = '0'))");
	   else
		where_criteria.append(" (request_status in('2','7','5','6','0') or (request_status = '1' and CONSENT_LETTER_APPL = '0'))"); 	 
	   }
	   else if(status_to_show.equals("0"))
	   {
		   if(isPrePractinReprintAppl) //added by mujafar for ML-MMOH-SCF-1365
			    where_criteria.append(" overdue_status = 'Y' and request_status in('0','2','4','5')");
		   else
			   where_criteria.append(" overdue_status = 'Y' and request_status in('0','2','5')");
	   }
	   else if(status_to_show.equals("1")){
			   where_criteria.append(" CONSENT_LETTER_APPL = '0' and request_status = '1'");
	   }
	   else
	   {
		   where_criteria.append(" request_status = '"+status_to_show+"'");
	   }
		
	   if(!national_id_no.equals("")){
		   where_criteria.append(" and national_id_no='"+national_id_no+"'");
	   }
	   if(!other_alt_type.equals("")){
		   where_criteria.append(" and oth_alt_id_type='"+other_alt_type+"'");
	   }
	   if(!other_alt_Id.equals("")){
		   where_criteria.append(" and oth_alt_Id_no='"+other_alt_Id+"'");
	   }
	   if(!alt_id1_no.equals("")){
		   where_criteria.append(" and alt_id1_no='"+alt_id1_no+"'");
	   }
	   if(!alt_id2_no.equals("")){
		   where_criteria.append(" and alt_id2_no='"+alt_id2_no+"'");
	   }
	   if(!alt_id3_no.equals("")){
		   where_criteria.append(" and alt_id3_no='"+alt_id3_no+"'");
	   }
	   if(!alt_id4_no.equals("")){
		   where_criteria.append(" and alt_id4_no='"+alt_id4_no+"'");
	   }
	   if(!PatientId.equals("")){
		   where_criteria.append(" and patient_id='"+PatientId+"'");
	   }

	   where_criteria.append(" and facility_id='"+facility_id+"'");

       //requested from_date
	   if(from_date!=null && !from_date.equals(""))
			where_criteria.append(" and trunc(added_date) >= to_date('"+from_date+"' , 'dd/mm/yyyy') ");
		
	   //requested to_date
	   if(to_date!=null && !to_date.equals(""))
			where_criteria.append(" and trunc(added_date) <= to_date('"+to_date+"' , 'dd/mm/yyyy') ");

	   where_criteria.append(" and request_type='MR'");
	   

		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();

       if(isPagination.equals("Y")){
		  sqlSb.append("select * from (SELECT  results.*, rownum as rcnt FROM (");
		 } 

	   sqlSb.append(" select COUNT (*) OVER () noOfRecords, to_char(sysdate,'dd/mm/yyyy') curr_date,request_type, med_board_type_code, facility_id, request_id, to_char(request_date,'dd/mm/yyyy') request_date, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, patient_id, sex, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'"+locale+"','1')practitioner_name, am_get_desc.AM_MEDICAL_TEAM(facility_id, prepare_team_id,'"+locale+"','2') team_short_desc, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, to_char(appt_date,'dd/mm/yyyy') appt_date, appt_ref_no, request_status_desc, board_request_status_desc, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, request_status, revise_status, overdue_status, CONSENT_LETTER_APPL from MR_REPORT_REQUEST_HDR_VW where"+where_criteria+" ");

	   if(status_to_show.equals("")){
		   sqlSb.append(" order by request_status_desc desc");
	   }
	   else{
		   sqlSb.append(" order by request_id desc, request_date desc");
	   }

	   if(isPagination.equals("Y")){
		   sqlSb.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");
		}

	   pstmt = con.prepareStatement(sqlSb.toString());
	   rs	 = pstmt.executeQuery();

	   JSONArray ReportStatusArr = new JSONArray();
	   while(rs!=null && rs.next()){
             JSONObject jsonobj = new JSONObject();
             
			 request_id			= (rs.getString("request_id")==null || rs.getString("request_id")=="")?"" : rs.getString("request_id");
			 request_date		= (rs.getString("request_date")==null || rs.getString("request_date")=="")?"" : rs.getString("request_date");
			 patient_id			= (rs.getString("patient_id")==null || rs.getString("patient_id")=="")?"" : rs.getString("patient_id");
			 patient_name		= (rs.getString("patient_name")==null || rs.getString("patient_name")=="")?"" : rs.getString("patient_name");
			 sex				= (rs.getString("sex")==null || rs.getString("sex")=="")?"" : rs.getString("sex");
			 practitioner_name	= (rs.getString("practitioner_name")==null || rs.getString("practitioner_name")=="")?"" : rs.getString("practitioner_name");
			 collect_date		= (rs.getString("collect_date")==null || rs.getString("collect_date")=="")?"" : rs.getString("collect_date");
			 request_status		= (rs.getString("REQUEST_STATUS_DESC")==null || rs.getString("REQUEST_STATUS_DESC")=="")?"" : rs.getString("REQUEST_STATUS_DESC");
			 revise_status		= (rs.getString("revise_status")==null || rs.getString("revise_status")=="")?"" : rs.getString("revise_status");
			 appt_date			= (rs.getString("appt_date")==null || rs.getString("appt_date")=="")?"" : rs.getString("appt_date");
			 med_board_type		= (rs.getString("med_board_type_code")==null || rs.getString("med_board_type_code")=="")?"" : rs.getString("med_board_type_code");
			 appt_ref_no		= (rs.getString("appt_ref_no")==null || rs.getString("appt_ref_no")=="")?"" : rs.getString("appt_ref_no");
			 overdue_status		= (rs.getString("overdue_status")==null || rs.getString("overdue_status")=="")?"" : rs.getString("overdue_status");
			 curr_date			= (rs.getString("curr_date")==null || rs.getString("curr_date")=="")?"" : rs.getString("curr_date");
			 faci_id			= (rs.getString("facility_id")==null || rs.getString("facility_id")=="")?"" : rs.getString("facility_id");
			 request_status_id	= (rs.getString("request_status")==null || rs.getString("request_status")=="")?"" : rs.getString("request_status");
			 consent_letter	= (rs.getString("CONSENT_LETTER_APPL")==null || rs.getString("CONSENT_LETTER_APPL")=="")?"" : rs.getString("CONSENT_LETTER_APPL");
             noOfRecords		= rs.getInt("noOfRecords");

			 jsonobj.put("request_id",request_id);
			 jsonobj.put("request_date",request_date);
		     jsonobj.put("patient_id",patient_id);
			 jsonobj.put("patient_name",patient_name);
			 jsonobj.put("sex",sex);
			 jsonobj.put("practitioner_name",practitioner_name);
		     jsonobj.put("collect_date",collect_date);
			 jsonobj.put("request_status",request_status);
			 jsonobj.put("revise_status",revise_status);
			 jsonobj.put("appt_date",appt_date);
			 jsonobj.put("med_board_type",med_board_type);
			 jsonobj.put("appt_ref_no",appt_ref_no);
			 jsonobj.put("overdue_status",overdue_status);
			 jsonobj.put("curr_date",curr_date);
             jsonobj.put("faci_id",faci_id);
			 jsonobj.put("request_status_id",request_status_id);
			 jsonobj.put("consent_letter",consent_letter);
			 ReportStatusArr.put(jsonobj);
			 rowCountHdr++;
	   }

       noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
	   if(to > noOfRecords){
		  to	= noOfRecords;
       }
	   if(rowCountHdr>0){
	     json.put("recordsList", ReportStatusArr);
	   }else{
		 json.put("recordsList", recordsList);
		}
       
	   json.put("rowCountHdr", rowCountHdr);
	   json.put("currentPageNo", currentPageNo);
	   json.put("noOfRecords", noOfRecords);
	   json.put("noOfPages", noOfPages);

       response.getWriter().write(json.toString());
				
	}catch(Exception e){
		e.printStackTrace();
	 }finally{
			try{
				if(pstmt != null) pstmt.close();
				if(rs  != null) rs.close();
				if(con != null)  ConnectionManager.returnConnection(con, request);
				
			}catch(Exception ex){
				ex.printStackTrace();
			 }	
	 }

}//end of function

} //end of class

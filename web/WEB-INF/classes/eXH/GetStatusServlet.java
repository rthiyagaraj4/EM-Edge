/***************************************************************************************************************
 * Author   :   Ravindranath.O
 * Desc     :	
 ***************************************************************************************************************/
package eXH;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import java.util.Date;
import java.text.DateFormat;
import java.text.*;
import java.util.*;

import webbeans.eCommon.ConnectionManager;

public class GetStatusServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	boolean isDebugYN = false; // temporary variable for debug logging check, should be removed once final testing is done 
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		String responseMsg="";
		try
		{
			Map reqParams = XHUtil.getRequestParams(request);
			String callType = reqParams.get("callType").toString();

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			if(isDebugYN) {
				 System.out.println("callType " +callType);
			}
           
			if(isDebugYN) {
				System.out.println("REQ_PARAM " + XHUtil.getRequestParams(request));
			}			
			if("ECLAIMS".equals(callType)) {

				     ArrayList responseTxt=getStatus(reqParams,request);
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final response.... " +responseTxt);
					}
					for(int i=0;i<responseTxt.size();i++){
                      responseMsg += responseTxt.get(i)+"$!^";
					}
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final responseMsg.... " +responseMsg);
					}
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseMsg);
					resp.close(); 
			}
			if("ECLAIMSWARN".equals(callType)) {

				    String responseTxt=getWarningDetails(reqParams,request);					
					
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final responseMsg.... " +responseTxt);
					}
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			if("ECLAIMSMEMDTL".equals(callType)) {

				     String responseTxt=getMemberDetails(reqParams,request);
					 
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final response.... " +responseTxt);
					}
					/*for(int i=0;i<responseTxt.size();i++){
                      responseMsg += responseTxt.get(i)+"$!^";
					}*/
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			if("ECLAIMSEMPDTL".equals(callType)) {

				     String responseTxt=getEmpDetails(reqParams,request);
					 
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final response.... " +responseTxt);
					}
					/*for(int i=0;i<responseTxt.size();i++){
                      responseMsg += responseTxt.get(i)+"$!^";
					}*/
					if(isDebugYN) {
						System.out.println("GetStatusServlet:::final responseMsg.... " +responseMsg);
					}
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 
			}
			
		}
		catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
    }   
    
	private ArrayList getStatus(Map reqParams,HttpServletRequest request) throws Exception 
	{
		ArrayList responseTxt=new ArrayList();
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_event = "",l_type_code ="",l_type_desc="",l_type ="";
		String qry="";
		String p_response="", errorCode = "", errorMsg = "";
		String paramString=reqParams.get("paramString").toString();

       try
		{     
		   l_event = FetchFieldValue(paramString,"<EVENT>", null,"$!^", "getStatusMethod");
		   l_type =  FetchFieldValue(paramString,"<TYPE>", null,"$!^", "getStatusMethod");
		   if(isDebugYN) {

				System.out.println("GetStatusServlet.java:::getStatus...paramString...."+paramString);
				System.out.println("GetStatusServlet.java:::getStatus...paramString...."+l_event);
				System.out.println("GetStatusServlet.java:::getStatus...l_type...."+l_type);

		   }


            conn = ConnectionManager.getConnection(request);
		    qry= "Select STATUS_CODE,STATUS_DESC from XH_TRANS_STATUS where APPLICATION_ID = 'ECLAIMS' and TRANS_EVENT =? and TRANS_TYPE =? and  ACTIVE_FLAG='Y'";
			System.out.println("Query..."+qry);
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, l_event);
			pstmt.setString(2, l_type);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				l_type_code=rs.getString("STATUS_CODE");
				l_type_desc=rs.getString("STATUS_DESC");
				String str=l_type_code+"##"+l_type_desc;
				responseTxt.add(str);


				if(isDebugYN) {
					System.out.println("GetStatusServlet.java:::getStatus...l_type_code...."+l_type_code+"...l_type_desc..."+l_type_desc);
				}
			}
		
		if(isDebugYN) {
			System.out.println("GetStatusServlet.java:::getStatus...paramString..."+responseTxt);
		}
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(GetStatusServlet.java:::getStatus) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, conn);
		}
		 if(isDebugYN) System.out.println("GetStatusServlet.java:::getStatus:::responseTxt...."+responseTxt);
		return responseTxt;	
	}
	private String getWarningDetails(Map reqParams,HttpServletRequest request) throws Exception 
	{
		ArrayList responseTxt=new ArrayList();
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_patient_id = "",l_trans_num ="",l_status_type="",l_status_code ="",l_status_desc ="",l_status = "",warning_response = "",l_type= "";
		String qry="";
		String p_response="", errorCode = "", errorMsg = "";
		String paramString=reqParams.get("paramString").toString();
		String height = "80%";
		String callType = reqParams.get("callType").toString();
		int count = 0;


       try
		{     
		   l_patient_id = FetchFieldValue(paramString,"<PATIENT_ID>", null,"$!^", "getWaringDetails");
		   l_trans_num =  FetchFieldValue(paramString,"<TRANS_ID>", null,"$!^", "getWaringDetails");
		   l_status =  FetchFieldValue(paramString,"<STATUS>", null,"$!^", "getWaringDetails");
		   if(l_status.equals("A")){
              l_type = "Warning";
		   }
		   if(l_status.equals("R")){
              l_type = "Rejection";
		   }

		    if(callType.equals("ECLAIMSEMPDTL")){
              height = "50%";
		   }
		   if(isDebugYN) {

				System.out.println("GetStatusServlet.java:::getWaringDetails...paramString...."+paramString);
				System.out.println("GetStatusServlet.java:::getWaringDetails...l_patient_id...."+l_patient_id);
				System.out.println("GetStatusServlet.java:::getWaringDetails...l_trans_num...."+l_trans_num);

		   }


            conn = ConnectionManager.getConnection(request);
		    qry= "SELECT STATUS_TYPE, STATUS_CODE, STATUS_DESC FROM XF_ECLAIMS_STATUS_DTL WHERE PATIENT_ID = ? AND SRL_NO = ?";
			System.out.println("Query..."+qry);
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, l_patient_id);
			pstmt.setString(2, l_trans_num);

			rs = pstmt.executeQuery();
			warning_response = "<table border=\"1\" align=\"center\" width=\"100%\"  height=\""+height+"\"><tr><td class=\"columnheader\" colspan=\"3\">"+l_type+" Details</td></tr>";
			warning_response += "<tr> <td class=\"columnheader\" width=\"10%\">Status</td><td class=\"columnheader\" width=\"40%\">"+l_type+" Code</td> <td class=\"columnheader\">"+l_type+" Description</td> </tr>";


			while(rs.next()) {
				
				l_status_type=rs.getString("STATUS_TYPE")==null?"&nbsp;":rs.getString("STATUS_TYPE");
				l_status_code=rs.getString("STATUS_CODE")==null?"&nbsp;":rs.getString("STATUS_CODE");
				l_status_desc=rs.getString("STATUS_DESC")==null?"&nbsp;":rs.getString("STATUS_DESC");
				//String str=l_status_type+"##"+l_status_code+"##"+l_status_desc;
				//responseTxt.add(str);
				//responseTxt = warnData.split("$!^");
				warning_response +="<tr> <td id=\"status\">"+l_status_type+"</td>";
				warning_response +="<td id=\"warning_code\">"+l_status_code+"</td>";
				warning_response +="<td id=\"warning_code_desc\">"+l_status_desc+"</td></tr>";
				if(isDebugYN) {
					System.out.println("GetStatusServlet.java:::getWaringDetails...l_status_type...."+l_status_type+"...l_status_code..."+l_status_code+"...l_status_desc..."+l_status_desc);
				}
				count++;

			}
		    warning_response +="</table>";

			if(isDebugYN) {
				System.out.println("GetStatusServlet.java:::getWaringDetails...paramString..."+warning_response);
			}
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(GetStatusServlet.java:::getWaringDetails) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, conn);
		}
		 if(isDebugYN) System.out.println("GetStatusServlet.java:::getWaringDetails:::responseTxt...."+warning_response);
		if(count>0){
			return warning_response;
		}
		else{
            return "";
		}
	}
	private String getMemberDetails(Map reqParams,HttpServletRequest request) throws Exception 
	{
		ArrayList responseTxt=new ArrayList();
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_mem_num = "",l_cust_cd ="";
		String qry="";
		String l_dep_cd = "",l_dob    = "",	l_id_nbr = "",l_sname  = "",l_fname  = "",l_inits  = "",l_gender = "",l_status = "",warning_response = "",rs_format_dob = "",l_scheme_name = "",l_scheme_date = "",rs_format_schemedt = "";
		String p_response="", errorCode = "", errorMsg = "";
		String where = "";

		int count = 0;
		String paramString=reqParams.get("paramString").toString();

       try
		{    
		   l_mem_num = FetchFieldValue(paramString,"<MEMBERSHIP_NUMBER>", null,"$!^", "getWaringDetails");
		   l_cust_cd =  FetchFieldValue(paramString,"<CUSTCODE>", null,"$!^", "getWaringDetails");
           if(l_cust_cd.length()>0){
                  where = "and  CUST_CODE = ?";
		   }

		   if(isDebugYN) {

				System.out.println("GetStatusServlet.java:::getMemberDetails...paramString...."+paramString);
				System.out.println("GetStatusServlet.java:::getMemberDetails...l_mem_num...."+l_mem_num);
				System.out.println("GetStatusServlet.java:::getMemberDetails...l_cust_cd...."+l_cust_cd);

		   }


            conn = ConnectionManager.getConnection(request);
		    qry= "select DEPD_CD, to_char(DOB, 'dd/MM/yyyy') DOB, ID_NBR, SNAME, FNAME, INITS, GENDER, STATUS, SCHEME_NAME, to_char(SCHEME_DATE, 'dd/MM/yyyy') SCHEME_DATE from XF_ECLAIMS_MEM_DETAILS  where  MEMBERSHIP_NUM = ? "+where;
			System.out.println("Query..."+qry);
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, l_mem_num);
			 if(l_cust_cd.length()>0){
				pstmt.setString(2, l_cust_cd);
			 }

			rs = pstmt.executeQuery();
			warning_response = "<table border=\"1\" align=\"center\" width=\"100%\" height=\"100px\" id=\"ResponseTable\">";
			warning_response += "<tr><td class=\"columnheader\" colspan=\"10\">Existing Details</td></tr>";
			warning_response += "<tr><td class=\"columnheader\">Dependent Code</td><td class=\"columnheader\">Firstname</td><td class=\"columnheader\">Surname</td><td class=\"columnheader\">Initial</td><td class=\"columnheader\" >National Id</td><td class=\"columnheader\" >Date of Birth</td><td class=\"columnheader\" >Gender</td><td class=\"columnheader\" >Scheme Name</td><td class=\"columnheader\" >Scheme date</td><td class=\"columnheader\" >Status</td></tr>";

			while(rs.next()) {
				
				l_dep_cd = rs.getString("DEPD_CD")==null?"&nbsp;":rs.getString("DEPD_CD");
				l_dob    = rs.getString("DOB")==null?"&nbsp;":rs.getString("DOB");
				l_id_nbr = rs.getString("ID_NBR")==null?"&nbsp;":rs.getString("ID_NBR");
				l_sname  = rs.getString("SNAME")==null?"&nbsp;":rs.getString("SNAME");
				l_fname  = rs.getString("FNAME")==null?"&nbsp;":rs.getString("FNAME");
				l_inits  = rs.getString("INITS")==null?"&nbsp;":rs.getString("INITS");
				l_gender = rs.getString("GENDER")==null?"&nbsp;":rs.getString("GENDER");
				l_status = rs.getString("STATUS")==null?"&nbsp;":rs.getString("STATUS");
				l_scheme_name = rs.getString("SCHEME_NAME")==null?"&nbsp;":rs.getString("SCHEME_NAME");
				l_scheme_date = rs.getString("SCHEME_DATE")==null?"&nbsp;":rs.getString("SCHEME_DATE");

				/*
				
				SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date dateObj = sourceDateFormat.parse(l_dob);
				SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				rs_format_dob = desiredDateFormat.format(dateObj).toString();

				SimpleDateFormat sourceDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date dateObj1 = sourceDateFormat1.parse(l_scheme_date);
				SimpleDateFormat desiredDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				rs_format_schemedt = desiredDateFormat1.format(dateObj1).toString();
				
				*/			

				System.out.println(":: rs_format_dob :: "+rs_format_dob);
							
				//warning_data=responseTxt[i].split("##");
				warning_response +="<tr ><td id=\"DeptCode\">"+l_dep_cd+"</td>";
				warning_response +="<td id=\"Firstname\">"+l_fname+"</td>";
				warning_response +="<td id=\"Surname\">"+l_sname+"</td>";
				warning_response +="<td id=\"Initial\">"+l_inits+"</td>";
				warning_response +="<td id=\"national_id\">"+l_id_nbr+"</td>";
				warning_response +="<td id=\"dob\">"+l_dob+"</td>";
				warning_response +="<td id=\"gender\">"+l_gender+"</td>";
				warning_response +="<td id=\"scheme_name\">"+l_scheme_name+"</td>";
				warning_response +="<td id=\"scheme_date\">"+l_scheme_date +"</td>";
				warning_response +="<td id=\"Status\">"+l_status +"</td></tr>";

				//String str=l_dep_cd+"##"+l_dob+"##"+l_id_nbr+"##"+l_sname+"##"+l_fname+"##"+l_inits+"##"+l_gender+"##"+l_status;

				if(isDebugYN) {
					System.out.println("GetStatusServlet.java:::getMemberDetails...warning_response...."+warning_response);
				}
				count++;
			}
		warning_response +="</table>";
		//responseTxt = warning_response;

		if(isDebugYN) {
			System.out.println("GetStatusServlet.java:::getMemberDetails...responseTxt..."+warning_response);
		}
		if(isDebugYN) {
			System.out.println("GetStatusServlet.java:::getMemberDetails...count..."+count);
		}
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(GetStatusServlet.java:::getMemberDetails) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, conn);
		}
		 if(isDebugYN) System.out.println("GetStatusServlet.java:::getMemberDetails:::warning_response...."+warning_response);
		 if(count >0){
		     return warning_response;
		 }
		 else{
              return "";
		 }
	} 
	private String getEmpDetails(Map reqParams,HttpServletRequest request) throws Exception 
	{
		ArrayList responseTxt=new ArrayList();
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;
		String l_mem_num = "",l_srl_no ="";
		String qry="";
		String p_response="", errorCode = "", errorMsg = "";
		String response = "",emp_response = "",warn_response = "", emp_date = "";
        
		String l_addr_line_1 = "", l_addr_line_2 = "", l_addr_suburb = "", l_addr_city = "", l_addr_post_cd = "", l_tele_phone_work = "", l_tele_phone_home = "", l_cell_number = "", l_emp_date = "", l_emp_name = "", l_inc_cons_nbr = "", l_inc_pred_income = "";

        
		int l_trans_value = 0;

		int count = 0;
		String paramString=reqParams.get("paramString").toString();

       try
		{    
		   l_mem_num = FetchFieldValue(paramString,"<MEMBERSHIP_NUMBER>", null,"$!^", "getWaringDetails");
		   l_srl_no =  FetchFieldValue(paramString,"<TRANS_ID>", null,"$!^", "getWaringDetails");

		   l_trans_value = Integer.parseInt(l_srl_no);

		   if(isDebugYN) {

				System.out.println("GetStatusServlet.java:::getEmpDetails...paramString...."+paramString);
				System.out.println("GetStatusServlet.java:::getEmpDetails...l_mem_num...."+l_mem_num);
				System.out.println("GetStatusServlet.java:::getEmpDetails...l_trans_value...."+l_trans_value);

		   }


            conn = ConnectionManager.getConnection(request);
		    qry= "select  ADDR_LINE_1, ADDR_LINE_2, ADDR_SUBURB, ADDR_CITY, ADDR_POST_CD, TELE_PHONE_WORK, TELE_PHONE_HOME, CELL_NUMBER, TO_CHAR(TO_DATE(EMP_DATE,'yyyyMMdd'),'dd/MM/yyyy') EMP_DATE, EMP_NAME, INC_CONS_NBR, INC_PRED_INCOME  from XF_ECLAIMS_PAT_DETAILS  where  MEMBERSHIP_NUM = ? and  SRL_NO = ?";
			System.out.println("Query..."+qry);
			pstmt = conn.prepareStatement(qry);
			pstmt.setString(1, l_mem_num);
			pstmt.setInt(2, l_trans_value);
            
			rs = pstmt.executeQuery();
			emp_response += "<table border=\"1\" align=\"center\" width=\"100%\" height=\"50%\" id=\"ResponseTable\"><tr><td class=\"columnheader\" colspan=\"12\">Employee Details</td></tr>";
			emp_response += "<tr><td class=\"columnheader\" >Address Lane 1</td><td class=\"columnheader\" >Address Lane 2</td><td class=\"columnheader\"  >Sub Urb</td><td class=\"columnheader\" >City</td>"
			                   +"<td class=\"columnheader\" >Postal Code</td><td class=\"columnheader\" >Phone Work</td><td class=\"columnheader\" >Phone Home</td><td class=\"columnheader\" >Cell number</td>"
							   +"<td class=\"columnheader\" >Emp name</td><td class=\"columnheader\" >Emp Date</td><td class=\"columnheader\" >Consumer Number</td><td class=\"columnheader\" >Predicted Income</td>"
							   +"</tr>";


			while(rs.next()) {
			    l_addr_line_1 = rs.getString("ADDR_LINE_1")==null?"&nbsp;":rs.getString("ADDR_LINE_1");
				l_addr_line_2 = rs.getString("ADDR_LINE_2")==null?"&nbsp;":rs.getString("ADDR_LINE_2");
				l_addr_suburb = rs.getString("ADDR_SUBURB")==null?"&nbsp;":rs.getString("ADDR_SUBURB");
				l_addr_city = rs.getString("ADDR_CITY")==null?"&nbsp;":rs.getString("ADDR_CITY"); 
				l_addr_post_cd = rs.getString("ADDR_POST_CD")==null?"&nbsp;":rs.getString("ADDR_POST_CD"); 
				l_tele_phone_work = rs.getString("TELE_PHONE_WORK")==null?"&nbsp;":rs.getString("TELE_PHONE_WORK"); 
				l_tele_phone_home = rs.getString("TELE_PHONE_HOME")==null?"&nbsp;":rs.getString("TELE_PHONE_HOME"); 
				l_cell_number = rs.getString("CELL_NUMBER")==null?"&nbsp;":rs.getString("CELL_NUMBER"); 
				emp_date =rs.getString("EMP_DATE");
				l_emp_name = rs.getString("EMP_NAME")==null?"&nbsp;":rs.getString("EMP_NAME"); 
				l_inc_cons_nbr = rs.getString("INC_CONS_NBR")==null?"&nbsp;":rs.getString("INC_CONS_NBR"); 
				l_inc_pred_income = rs.getString("INC_PRED_INCOME")==null?"&nbsp;":rs.getString("INC_PRED_INCOME");

				System.out.println("GetStatusServlet.java:::getEmpDetails...emp_date...."+emp_date);

				/*

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String text = df.format(emp_date);

				System.out.println("GetStatusServlet.java:::getEmpDetails...text...."+text);

				*/

				
				emp_response +="<tr><td id=\"line1\">"+l_addr_line_1+"</td>";
				emp_response +="<td id=\"line2\">"+l_addr_line_2+"</td>";
				emp_response +="<td id=\"suburb\">"+l_addr_suburb+"</td>";
				emp_response +="<td id=\"city\">"+l_addr_city+"</td>";
				emp_response +="<td id=\"post_cd\">"+l_addr_post_cd+"</td>";
				emp_response +="<td id=\"phone_work\">"+l_tele_phone_work+"</td>";
				emp_response +="<td id=\"phone_home\">"+l_tele_phone_home+"</td>";
				emp_response +="<td id=\"cell_number\">"+l_cell_number+"</td>";
				emp_response +="<td id=\"emp_name\">"+l_emp_name+"</td>";
				emp_response +="<td id=\"emp_date\">"+emp_date+"</td>";
				emp_response +="<td id=\"cons_nbr\">"+l_inc_cons_nbr+"</td>";
				emp_response +="<td id=\"pred_income\">"+l_inc_pred_income+"</td></tr>";
				
				/*SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date dateObj = sourceDateFormat.parse(l_dob);
				SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				rs_format_dob = desiredDateFormat.format(dateObj).toString();

				SimpleDateFormat sourceDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
				Date dateObj1 = sourceDateFormat1.parse(l_scheme_date);
				SimpleDateFormat desiredDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
				rs_format_schemedt = desiredDateFormat1.format(dateObj1).toString();


				

				System.out.println(":: rs_format_dob :: "+rs_format_dob);
							
				//warning_data=responseTxt[i].split("##");
				warning_response +="<tr ><td id=\"DeptCode\">"+l_dep_cd+"</td>";
				warning_response +="<td id=\"Firstname\">"+l_fname+"</td>";
				warning_response +="<td id=\"Surname\">"+l_sname+"</td>";
				warning_response +="<td id=\"Initial\">"+l_inits+"</td>";
				warning_response +="<td id=\"national_id\">"+l_id_nbr+"</td>";
				warning_response +="<td id=\"dob\">"+rs_format_dob+"</td>";
				warning_response +="<td id=\"gender\">"+l_gender+"</td>";
				warning_response +="<td id=\"scheme_name\">"+l_scheme_name+"</td>";
				warning_response +="<td id=\"scheme_date\">"+rs_format_schemedt +"</td>";
				warning_response +="<td id=\"Status\">"+l_status +"</td></tr>";



				//String str=l_dep_cd+"##"+l_dob+"##"+l_id_nbr+"##"+l_sname+"##"+l_fname+"##"+l_inits+"##"+l_gender+"##"+l_status;


                  */
				if(isDebugYN) {
					System.out.println("GetStatusServlet.java:::getEmpDetails...response...."+response);
				}
				count++;
			}
		emp_response +="</table>";
		System.out.println("GetStatusServlet.java:::getEmpDetails...count...."+count);
		warn_response = getWarningDetails(reqParams,request);
		if(warn_response.length()>0 && count>0)
		{
			response ="<table><tr>"+emp_response+"</tr><tr>"+warn_response+"</tr></table>";
		}
		else if(warn_response.length()>0){
             response = warn_response;
		}
		else if(count>0){
            response = emp_response;
		}
		else{
           response = "";
		}
		
		//responseTxt = warning_response;

		if(isDebugYN) {
			System.out.println("GetStatusServlet.java:::getEmpDetails...responseTxt..."+responseTxt);
		}
		if(isDebugYN) {
			System.out.println("GetStatusServlet.java:::getEmpDetails...count..."+count);
		}
		}
		catch(Exception exp)
		{
			if(isDebugYN) System.out.println("(GetStatusServlet.java:::getEmpDetails) Exception at executing procedure");
			exp.printStackTrace(System.err);
		}
		finally
		{			
			XHUtil.closeDBResources(rs, pstmt, conn);
		}
		 if(isDebugYN) System.out.println("GetStatusServlet.java:::getEmpDetails:::responseTxt...."+responseTxt);
		
		 return response;
		 
	} 
	public String FetchFieldValue(String message, String identifier, String standardCode, String fieldSep, String procID){

		String l_app_msg = "", l_app_key = "", l_field_value = "";

		l_app_msg = " ::: Inside FetchFieldValue ::: ";
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		l_app_msg = " ::: Message : "+ message + " ::: Identifier : " + identifier + " ::: Standard Code : "+ standardCode;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	
		
		l_app_msg = " ::: Deriving Field Value..."+identifier;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);	

		try
		{
			if(standardCode != null && !(standardCode.length()>0))
			{

			}
			else
			{
				if (message.indexOf(identifier) >= 0 )
				{
					if (message.indexOf(fieldSep) >= 0)
					{
						l_field_value = message.substring(message.indexOf(identifier)+identifier.length());
						if (l_field_value.indexOf(fieldSep) >= 0)
						{						
							l_field_value = l_field_value.substring(0, l_field_value.indexOf(fieldSep));
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			l_field_value = "Error in "+ l_app_msg + " : " +  e.getMessage();
		}		

		l_app_msg = " ::: l_field_value ::: "+l_field_value;
		//if (l_debug_YN.equals("Y")) System.out.println(l_app_msg);

		return l_field_value;
	}
	
}
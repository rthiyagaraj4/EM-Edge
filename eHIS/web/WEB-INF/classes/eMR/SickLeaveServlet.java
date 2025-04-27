/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;
import com.ehis.util.*;
import webbeans.eCommon.*;

import eCommon.XSSRequestWrapper;

public class SickLeaveServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String client_ip_address ;
	String FacilityId="";
	String CERT_RECORD_ALREADY_EXISTS= "CERT_RECORD_ALREADY_EXISTS";
	String MC_NO_ALREADY_EXISTS= "MC_NO_ALREADY_EXISTS";
	HttpSession session;
	String locale ="";
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.FacilityId= (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			
			this.out = res.getWriter();
			InsertSickLeave(req);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

private void InsertSickLeave(HttpServletRequest req)
	{
		
		Connection con =null;
		PreparedStatement pstmt=null;
		PreparedStatement checkDuplicateStatement = null;
		ResultSet rs = null;
		ResultSet checkDuplicateResult = null;
		boolean insertable = true;
		try
		{

		String sl_ref_no="",PatientId="",LeaveFrom="",LeaveTo="";
		String FitonDuty="",CertIssued="",operation="";
		String certificate_type="";
		String issuedDate="";
		con=ConnectionManager.getConnection(req);
		
		PatientId = req.getParameter("PatientId")==null?"":req.getParameter("PatientId");
		
		LeaveFrom = req.getParameter("LeaveFrom")==null?"":req.getParameter("LeaveFrom");
		LeaveFrom = DateUtils.convertDate(LeaveFrom,"DMY",locale,"en");
		

		LeaveTo   = req.getParameter("LeaveTo")==null?"":req.getParameter("LeaveTo");
		LeaveTo = DateUtils.convertDate(LeaveTo,"DMY",locale,"en");
		

		CertIssued = req.getParameter("CertIssued")==null?"N":req.getParameter("CertIssued");

		FitonDuty = req.getParameter("FitonDuty")==null?"":req.getParameter("FitonDuty");
		FitonDuty = DateUtils.convertDate(FitonDuty,"DMY",locale,"en");
		
		operation = req.getParameter("operation")==null?"":req.getParameter("operation");
		certificate_type=req.getParameter("certificate_type")==null?"":req.getParameter("certificate_type");

		issuedDate=req.getParameter("IssuedDate")==null?"":req.getParameter("IssuedDate");
		issuedDate = DateUtils.convertDate(issuedDate,"DMY",locale,"en");
		
					
	    String mcNo=req.getParameter("mcNo");
		String employmentDetails=req.getParameter("employmentDetailsHidden");
		String followUpDate=req.getParameter("followUpDate");
	
			if(mcNo==null)
				mcNo="";

			if(employmentDetails==null)
				employmentDetails="";
			
			if(certificate_type.equals("O"))
			       employmentDetails="";
		
			if(followUpDate==null)
				followUpDate="";

			if (operation.equals("print"))
			{
				sl_ref_no= req.getParameter("sl_ref_no")==null?"":req.getParameter("sl_ref_no"); 
				doOnlineReports(PatientId,sl_ref_no);
				out.println("<script>parent.frames(3).location.href='../eCommon/jsp/error.jsp?err_num=&err_value=1';</script>");
			}
			else
			{
				
			try{

				checkDuplicateStatement = con.prepareStatement("Select '1' from pr_sick_leave_register where added_facility_id = ? and mc_no = ? and patient_id = ? and trunc(leave_from) = trunc(to_date(?,'dd/mm/yyyy hh24:mi')) and trunc(leave_to) = trunc(to_date(?,'dd/mm/yyyy hh24:mi'))");
				checkDuplicateStatement.setString(1,FacilityId);
				checkDuplicateStatement.setString(2,mcNo);
				checkDuplicateStatement.setString(3,PatientId);
				checkDuplicateStatement.setString(4,LeaveFrom);
				checkDuplicateStatement.setString(5,LeaveTo);
				checkDuplicateResult = checkDuplicateStatement.executeQuery();
				
				if(checkDuplicateResult != null && checkDuplicateResult.next())
				{					
					insertable = false;
				}

				if(checkDuplicateResult != null) checkDuplicateResult.close();
				if(checkDuplicateStatement != null) checkDuplicateStatement.close();
				 if(!insertable)
				{
				 java.util.Hashtable message1 = MessageManager.getMessage( con, CERT_RECORD_ALREADY_EXISTS ) ;
				 String msg1=(String)message1.get("message");
				 out.println("<script>parent.frames(2).location.href = '../eCommon/jsp/error.jsp?err_num="+msg1+"&err_value=0';</script>");				
				 message1.clear();
				 return;
				}
				}catch(Exception e)
				{}

	     if(insertable)
		{
			try{
			
			
			checkDuplicateStatement = con.prepareStatement("Select '1' from pr_sick_leave_register where mc_no = ? ");
			checkDuplicateStatement.setString(1,mcNo);
			checkDuplicateResult = checkDuplicateStatement.executeQuery();
			if(checkDuplicateResult != null && checkDuplicateResult.next())
				insertable = false;
			
			if(checkDuplicateResult != null)checkDuplicateResult.close();
			if(checkDuplicateStatement != null)checkDuplicateStatement.close();

			if(!insertable)
				{
				java.util.Hashtable message1 = MessageManager.getMessage( con, MC_NO_ALREADY_EXISTS ) ;
				String msg1=(String)message1.get("message");
				out.println("<script>parent.frames(2).location.href = '../eCommon/jsp/error.jsp?err_num="+msg1+"&err_value=0';</script>");		
				message1.clear();
				return;
				}
			
			}catch(Exception e){}
		 }

		pstmt=con.prepareStatement("select PR_SICK_LEAVE_REGISTER_SEQ.NEXTVAL  from dual");
		rs = pstmt.executeQuery();
		if (rs!=null&&rs.next())
		    sl_ref_no = rs.getString(1);
		
		StringTokenizer token=new StringTokenizer(LeaveFrom,"/");
		 while(token.hasMoreTokens())
			{
				  String dd = token.nextToken();
				  String mm = token.nextToken();
				  String yr = token.nextToken();
				  LeaveFrom = yr +"-"+mm+"-"+dd;
			}
		
		StringTokenizer token1=new StringTokenizer(LeaveTo,"/");
		 while(token1.hasMoreTokens())
			{
				  String dd = token1.nextToken();
				  String mm = token1.nextToken();
				  String yr = token1.nextToken();
				  LeaveTo = yr +"-"+mm+"-"+dd;
			}
		
		if (!FitonDuty.equals("")){
			token1=new StringTokenizer(FitonDuty,"/");
		 while(token1.hasMoreTokens())
		  {
			  String dd = token1.nextToken();
			  String mm = token1.nextToken();
			  String yr = token1.nextToken();
			  FitonDuty = yr +"-"+mm+"-"+dd;
		   }
		}
		
		 if(!issuedDate.equals("")){
			token1=new StringTokenizer(issuedDate,"/");
		  
		  while(token1.hasMoreTokens())
		     {
		         String dd = token1.nextToken();
		         String mm = token1.nextToken();
			 String yr = token1.nextToken();
			 issuedDate = yr +"-"+mm+"-"+dd;
		      }
		}

		
		
 		  String addedById = p.getProperty( "login_user" ) ;
		  Timestamp added_date  = new Timestamp(System.currentTimeMillis() );
		  java.sql.Date Leave_From = java.sql.Date.valueOf( LeaveFrom) ;
		  java.sql.Date Leave_To   = java.sql.Date.valueOf( LeaveTo) ;
		
		  HashMap tabdata=new HashMap();
		  tabdata.put("sl_ref_no",sl_ref_no);
		  tabdata.put("Patient_id",PatientId);
		  tabdata.put("Leave_from",Leave_From);
		  tabdata.put("Leave_to",Leave_To);
		  tabdata.put("fit_for_duty",checkNullWithDftValue(req.getParameter("FitForDuty"),"N"));
		  tabdata.put("CERT_TYPE",certificate_type);
		  tabdata.put("mc_no",mcNo);
		  tabdata.put("employment_details",employmentDetails);
		
		  if(!followUpDate.equals(""))
		    {
			StringTokenizer followUpDateToken=new StringTokenizer(followUpDate,"/");
			if(followUpDateToken.hasMoreTokens())
			{
				String dd=followUpDateToken.nextToken();
				String mm=followUpDateToken.nextToken();
				String yy=followUpDateToken.nextToken();
				followUpDate=yy+"-"+mm+"-"+dd;
				java.sql.Date followUpDateValue=java.sql.Date.valueOf(followUpDate);
				tabdata.put("follow_up_date",followUpDateValue);
			}
 		     }
		  
		  if (!FitonDuty.equals("")){
		
			java.sql.Date fit_on_duty   = java.sql.Date.valueOf( FitonDuty) ;
			tabdata.put("FIT_ON_DUTY",fit_on_duty);
			
				}
				
		   if(!issuedDate.equals("")){
			java.sql.Date issued_date=java.sql.Date.valueOf(issuedDate);
			tabdata.put("CERT_ISSUED_DATE",issued_date);
			}
			tabdata.put("cert_issued",CertIssued);
			tabdata.put("Authorized_by_id",checkNull(req.getParameter("AuthorizedById")));
			tabdata.put("Remarks",checkNull(req.getParameter("Remarks")));
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",client_ip_address);
			tabdata.put("ADDED_FACILITY_ID",FacilityId);
			tabdata.put("MODIFIED_BY_ID",addedById);
			tabdata.put("MODIFIED_DATE",added_date);
			tabdata.put("MODIFIED_AT_WS_NO",client_ip_address);
			tabdata.put("MODIFIED_FACILITY_ID",FacilityId);

		
			String dupflds[]={"Patient_id","ADDED_FACILITY_ID","Leave_from","Leave_to","mc_no"};
			
		       	
		String table_name=" PR_SICK_LEAVE_REGISTER ";
		boolean local_ejbs = false;
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = table_name;
				
		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();
		
		
	    java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
            (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	    
	     boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
	     String error = (String) results.get("error") ;

		if ( inserted )
		{
		   if(error.lastIndexOf("<br>")>=0)	
		   error=error.substring(0,error.lastIndexOf("<br>"));
		   out.println("<script> alert(\""+error+"\"); </script>");
		 if (CertIssued.equals("Y"))           
		      doOnlineReports(PatientId,sl_ref_no);
		 out.println("<script>parent.onSuccess();</script>");
		 }
		 else
		  {
		      if(error.lastIndexOf("<br>")>=0)	
		      error=error.substring(0,error.lastIndexOf("<br>"));
		      out.println("<script> alert(\""+error+"\"); parent.window.close();   </script>");
		   }
	   argArray = null;
	   paramArray = null;
	   dupflds = null;
	   results.clear();
	   tabdata.clear();
	}
   }
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			try{
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;
			}catch(Exception e){}
			
			ConnectionManager.returnConnection(con,req);
		}	
	}
    private void doOnlineReports(String P_PatientId,String P_sl_ref_no) throws ServletException, IOException, SQLException
    {
		StringBuffer htmlFor =new StringBuffer();
		String sqlString ="select report_id, report_desc, 1 no_of_copies, module_id from sm_report where module_id = 'OP' AND REPORT_ID = 'OPBMEDCR'";
		
		String locn_type = "C";
		String reportParamNames = "P_SL_REF_NO";
		String reportParamValues = ""+P_sl_ref_no+"";
		String p_locn_code ="";
        htmlFor .append( " <html><head> <link rel='stylesheet' type ='text/css'  href='../eCommon/html/IeStyle.css'></link>");
        htmlFor.append( "</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>") ;
		htmlFor.append("  var dialogHeight    = '25' ;");
		htmlFor.append(" var dialogWidth = '65' ;");
		htmlFor.append( "var dialogTop = 58;") ;
		htmlFor.append( "  var arguments =   ''; ");
		htmlFor.append("  var getUrl        =   '../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+P_PatientId+"&dest_locn_type="+locn_type+"&dest_locn_code="+p_locn_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
		htmlFor.append( " var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor .append( "  retVal=window.showModalDialog(getUrl,arguments,features); ");
		htmlFor .append( " </script>" ) ;
		out.println(htmlFor.toString());
		htmlFor.setLength(0);

	} 

public static String checkNull(String str)
    {
      return((str==null || str.equals("null"))?"":str);
    }
public static String checkNullWithDftValue(String str,String dftval)
    {
      return((str==null || str.equals("null"))?dftval:str);
    }

}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import java.text.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.MessageManager;

public class FlowSheetApplicabilityServlet extends javax.servlet.http.HttpServlet{

/**
*	init	-	will initialise the servlet
*	@param	config - this is ServletConfig
*/
public void init(ServletConfig config) throws ServletException{
 super.init(config);
}


private String getMessage(String locale, String messageId, String moduleId)
		{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
		}

public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
{
		PrintWriter out = null;
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = res.getWriter();
			String operation = req.getParameter("mode")==null ? "" :req.getParameter("mode") ;

			if(operation.equals("insert"))   
				insert(req, res, out);

			if(operation.equals("modify")) 
			{
				delete(req, res, out);
			}
			//modify(req, res);
			if(operation.equals("delete"))    
				delete(req, res, out);
		}//try
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
}//post
public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		HttpSession session;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection con = null;
		String pat_class="";
		String special="";
		String pctr="";
		String summary="";
		String facilityId="";
		String client_ip_address= "";
		String addedById= "";
		String addedAtWorkstation= "";
		String errorMsg = "";
		String addedFacilityId= "";
		String modifiedById= "";
		String modifiedAtWorkstation="";
		String error_value = "0" ;
		String oldPatClass = "";
		String oldSpecialty = "";
		String oldPractitioner = "";
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale		= (String) p.getProperty("LOCALE");
		facilityId = (String)session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;       
		try
		{
			con = ConnectionManager.getConnection(req);
			  addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
			 if(addedById == null)
			  addedById="";
			if(addedFacilityId == null )
				addedFacilityId="";
			if(addedAtWorkstation == null)
				addedAtWorkstation="";
			if(modifiedById == null)
				modifiedById="";
			if(modifiedAtWorkstation == null)
				modifiedAtWorkstation="";
			pat_class=req.getParameter("patclass");
			if(pat_class==null || pat_class.equals(""))
			pat_class="*A";
			special=req.getParameter("spl");
			pctr=req.getParameter("practitioner");
			summary=req.getParameter("summary");
			oldPatClass = req.getParameter("old_pat_class")==null ? "*A" : req.getParameter("old_pat_class");
			oldSpecialty = req.getParameter("old_specialty") == null ? "*ALL" :req.getParameter("old_specialty")  ;
			oldPractitioner = req.getParameter("old_practitioner")==null ? "*ALL" : req.getParameter("old_practitioner") ;	
			if(special==null || special.equals("")) special ="*ALL";
			if(pctr==null || pctr.equals("")) pctr ="*ALL";
			if(summary==null || summary.equals("")) summary="";
			HashMap tabdata=new HashMap();
			//Hashtable tabdataInsert=new Hashtable();
			 HashMap condflds=new HashMap();
			//boolean flag = false;
			int execute = 0;
			if(!(pat_class.equals(oldPatClass) && special.equals(oldSpecialty) && pctr.equals(oldPractitioner)))
			{
			ps  = con.prepareStatement("select count(*)  total  from ca_chart_summ_choice  where PATIENT_CLASS = ? and SPECILITY_ID = ? and  PRACTITIONER_ID = ? ");
			ps.setString(1,pat_class);
			ps.setString(2,special);
			ps.setString(3,pctr);
			rs = ps.executeQuery();
			rs.next();
			execute = rs.getInt("total");
				
			}
			if( execute > 0)
			{
					if(rs !=null) rs.close();
					if(ps !=null) ps.close();

					String errror=getMessage(locale, "RECORD_ALREADY_EXISTS","Common");
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errror,"UTF-8") +"&err_value=");	

				
			}
			else
			{

				tabdata.put("PATIENT_CLASS",pat_class);
				tabdata.put("SPECILITY_ID",special);
				tabdata.put("PRACTITIONER_ID",pctr);
				tabdata.put("SUMMARY_ID",summary);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("MODIFIED_FACILITY_ID",facilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				condflds.put("PATIENT_CLASS",oldPatClass);
				condflds.put("SPECILITY_ID",oldSpecialty); 
				condflds.put("PRACTITIONER_ID",oldPractitioner); 

				
			boolean local_ejbs = false;
			String tabledata = "ca_chart_summ_choice";
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabledata;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabledata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					argArray = null;
					paramArray = null;
					tabdata.clear();
					condflds.clear();
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
						//out.println("from modified:"+inserted);
						errorMsg = (String) results.get("error") ;
						if (inserted)
						{
						 error_value = "1" ;
						}
						results.clear();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);
				}
				
				
			}//try
		catch ( Exception e )
			{
				out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
				out.println( "Values sent are : <br>" ) ;
				out.println( pat_class+" "+special+" "+pctr+" "+summary );
			}
			finally
			{

				if(con != null) ConnectionManager.returnConnection(con);
				
			}
		}//modify
private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		HttpSession session;
		String pat_class="";
		String special="";
		String pctr="";
		String summary="";
		String flowsheet="";
		String facilityId="";
		String client_ip_address= "";
		String addedById= "";
		String addedAtWorkstation= "";
		String errorMsg = "";
		String addedFacilityId= "";
		String modifiedById= "";
		String modifiedAtWorkstation="";
		String error_value = "0" ;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String)session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;       

		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		pat_class=req.getParameter("patclass");
		special=req.getParameter("spl"); 
		pctr=req.getParameter("practitioner"); 
		flowsheet=req.getParameter("flowsheet1");
		try
		{
			



			if(pat_class==null || pat_class.equals(""))
			pat_class="*A";
			if(special==null || special.equals("")) special ="*ALL";
			if(pctr==null || pctr.equals("")) pctr ="*ALL";
			HashMap tabdata=new HashMap();	 
			tabdata.put("PRACT_TYPE",pat_class);
			tabdata.put("SPECIALITY_CODE",special);
			tabdata.put("PRACTITIONER_ID",pctr);
			tabdata.put("FLOW_SHEET_ID",flowsheet);
			 if(addedById == null)
			  addedById="";
			if(addedFacilityId == null )
				addedFacilityId="";
			if(addedAtWorkstation == null)
				addedAtWorkstation="";
			if(modifiedById == null)
				modifiedById="";
			if(modifiedAtWorkstation == null || modifiedAtWorkstation.equals("null") )
				modifiedAtWorkstation="";
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",addedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		String dupflds[]={"PRACT_TYPE","SPECIALITY_CODE","PRACTITIONER_ID","FLOW_SHEET_ID"};
		
		
		boolean local_ejbs = false;
		String tabledata = "ca_flow_sheet_applicablity";
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = tabledata;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = tabledata.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		argArray = null;
		paramArray = null;
		tabdata.clear();
		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue());
		//out.println("from inserted:"+inserted);
		errorMsg = (String) results.get("error") ;
		if ( inserted )
		{
			error_value = "1" ;
		}
		results.clear();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+error_value);
}//try
		catch ( Exception e )
		{
			//out.println("<h3> Exception raised by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println( pat_class+" "+special+" "+pctr+" "+summary );
		}
	}//insert
private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
		java.util.Properties p;
		HttpSession session;
		String pat_class="";
		String special="";
		String pctr="";
		String summary="";
		String facilityId="";
		String client_ip_address= "";
		String errorMsg = "";
		String modifiedById= "";
		String modifiedAtWorkstation="";
		String error_value = "0" ;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String)session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;       
		try
		{

			pat_class=req.getParameter("patclass_del2");

			if(pat_class==null || pat_class.equals(""))
				pat_class="*A";
			special=req.getParameter("speciality_code_mode");
			pctr=req.getParameter("practitioner_id_mode");
			summary=req.getParameter("flow_sheet_id_mode");
			if(special==null || special.equals("")) special ="*ALL";
			if(pctr==null || pctr.equals("")) pctr ="*ALL";
			if(summary==null) summary="";


			
			HashMap condflds=new HashMap();
			//PRACT_TYPE, PRACTITIONER_ID, SPECIALITY_CODE, FLOW_SHEET_ID
			pat_class=pat_class.trim();
			pctr=pctr.trim();
			special=special.trim();
			summary=summary.trim();
			condflds.put("PRACT_TYPE",pat_class);
			condflds.put("PRACTITIONER_ID",pctr);  
			condflds.put("SPECIALITY_CODE",special); 
			condflds.put("FLOW_SHEET_ID",summary);  
			
			
			boolean local_ejbs = false;
			String tabledata = "ca_flow_sheet_applicablity";
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;


			Object home =  com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = condflds;
			argArray[2] = tabledata;

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = condflds.getClass();
			paramArray[2] = tabledata.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			argArray = null;
			paramArray = null;
			condflds.clear();

			boolean deleted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
            errorMsg = (String) results.get("error") ;
			out.println("deleted="+deleted);
			if (deleted)
			{
				 error_value = "1" ;
				 
			}
         	results.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);



}//try
catch (Exception e)
		{
			//out.println("<h3> Exception raised by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			out.println( pat_class+" "+special+" "+pctr+" "+summary );
		}


}//delete

}//class

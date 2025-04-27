/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           	created
27/12/2012    IN035950      Nijitha        	CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
											more appealing. Keeping the display of information more clear and visible.					
10/06/2013	  IN039398		Nijitha         Assign Chart Summary->Create a new record->System is displaying ‘Processing. Please Wait..’ message and not allowing the user to perform other function, when we click on ‘Apply’ button. 					
---------------------------------------------------------------------------------------------------------------
*/
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
import eCommon.SingleTabHandler.*;
public class AssignChartSummServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
	 super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
    
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			out = res.getWriter();
			String operation = req.getParameter("mode")==null ? "" :req.getParameter("mode") ;
			if(operation.equals("insert"))   insert(req, res, out);
			if(operation.equals("modify"))    modify(req, res, out);
			if(operation.equals("delete"))    delete(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

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
		HttpSession sess = req.getSession(false);
		p = (java.util.Properties) sess.getValue( "jdbc" ) ;
		facilityId = (String)sess.getValue("facility_id") ;
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
			
			 HashMap condflds=new HashMap();
			
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
					ps  = con.prepareStatement("select message_id ,MESSAGE_TEXT_SYSDEF from sm_message  where MESSAGE_REF = ? ");
					ps.setString(1,"RECORD_ALREADY_EXISTS");
					rs = ps.executeQuery();
					rs.next();
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( "APP-"+rs.getString("message_id") +"-" +rs.getString("MESSAGE_TEXT_SYSDEF") ,"UTF-8") +"&err_value=");	

				if(rs !=null) rs.close();
				if(ps !=null) ps.close();
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
						//IN035950 Start
						HashMap styleResults = null;
						if(inserted)
						{
							styleResults = updatePrefStyleForWidget(con,p,sess,addedById,addedFacilityId,addedAtWorkstation,pat_class,special,pctr,summary,oldPatClass,oldSpecialty,oldPractitioner);
							if(null!=styleResults)
							inserted = ( ((Boolean) styleResults.get( "status" )).booleanValue());
						}
						//IN035950 End
						
						if (inserted)
						{
						 error_value = "1" ;
						}
						else
						{
						 errorMsg = (String) results.get("error") ;
						}
						errorMsg = (String) results.get("error") ;
						results.clear();
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg ,"UTF-8") +"&err_value="+error_value);
				}
				
				
			}//try
		catch ( Exception e )
			{
				System.out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
				System.out.println( "Values sent are : <br>" ) ;
				System.out.println( pat_class+" "+special+" "+pctr+" "+summary );
			}
			finally
			{

				if(con != null) ConnectionManager.returnConnection(con);
				
			}
		}//modify
		
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
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
		
		HttpSession sess = req.getSession(false);
		p = (java.util.Properties) sess.getValue( "jdbc" ) ;
		facilityId = (String)sess.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;           
		try
		{
		    addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
			pat_class=req.getParameter("patclass");
			special=req.getParameter("spl"); 
			pctr=req.getParameter("practitioner"); 
			summary=req.getParameter("summary") ==null ? "" :req.getParameter("summary") ;
			if(pat_class==null || pat_class.equals(""))
			pat_class="*A";
			if(special==null || special.equals("")) special ="*ALL";
			if(pctr==null || pctr.equals("")) pctr ="*ALL";
			HashMap tabdata=new HashMap();	 
			tabdata.put("patient_class",pat_class);
			tabdata.put("specility_id",special);
			tabdata.put("practitioner_id",pctr);
			tabdata.put("summary_id",summary);
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
//		tabdata.put("LOCALE",locale );

		String dupflds[]={"patient_class","specility_id","practitioner_id"};
		
		boolean local_ejbs = false;
		String tabledata = "ca_chart_summ_choice";
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
		
		//IN035950 Starts
		HashMap styleResults = null;
		if(inserted)
		{
			styleResults = insertPrefStyleForWidget(p,busObj,sess,addedById,addedFacilityId,addedAtWorkstation,pat_class,special,pctr,summary);
			if(null!=styleResults)//IN039398
			inserted = ( ((Boolean) styleResults.get( "status" )).booleanValue());
		}
		//IN035950 Ends
		
		if ( inserted )
		{
			error_value = "1" ;
		}
		else
		{
			errorMsg = (String) results.get("error") ;
		}
		errorMsg = (String) results.get("error") ;
		results.clear();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);
}//try
		catch ( Exception e )
		{
			System.out.println("<h3> Exception raised by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());
			System.out.println( "Values sent are : <br>" ) ;
			System.out.println( pat_class+" "+special+" "+pctr+" "+summary );
		}
	}//insert
private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{		
		java.util.Properties p;
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
		
		HttpSession sess = req.getSession(false);
		p = (java.util.Properties) sess.getValue( "jdbc" ) ;
		facilityId = (String)sess.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;           
		try
		{
			pat_class=req.getParameter("patclass");
			if(pat_class==null || pat_class.equals(""))
				pat_class="*A";
			special=req.getParameter("spl");
			pctr=req.getParameter("practitioner");
			summary=req.getParameter("summary");
			if(special==null || special.equals("")) special ="*ALL";
			if(pctr==null || pctr.equals("")) pctr ="*ALL";
			if(summary==null) summary="";
			HashMap condflds=new HashMap();
			condflds.put("patient_class",pat_class);
			condflds.put("specility_id",special); 
			condflds.put("practitioner_id",pctr);  
			condflds.put("summary_id",summary);  
			
			boolean local_ejbs = false;
			String tabledata = "ca_chart_summ_choice";
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
			//out.println("deleted="+deleted);
			if (deleted)
			{
				 error_value = "1" ;
				 
			}
            else
            {
                 errorMsg = (String) results.get("error") ;
			}
          	errorMsg = (String) results.get("error") ;
			results.clear();
            res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8" ) +"&err_value="+error_value);



}//try
catch (Exception e)
		{
			System.out.println("<h3> Exception raised by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());
			System.out.println( "Values sent are : <br>" ) ;
			System.out.println( pat_class+" "+special+" "+pctr+" "+summary );
		}


}//delete

//IN035950 Starts
	private HashMap insertPrefStyleForWidget(java.util.Properties prop,
			Object busObj, HttpSession sess, String addedById,
			String addedFacilityId, String addedAtWorkstation,
			String pat_class, String special, String pctr, String summary) 
		{
		HashMap styleMap = null;
		String styleSheetName = "";
		Set styleSet = null;
		String styleKey = "";
		String contentID = "";
		String tabledata = "CA_CHART_SUMM_STYLE_SHEET";
		HashMap tabdata = new HashMap();
		Class[] paramArray = new Class[4];
		Object argArray[] = new Object[4];
		java.util.HashMap styleResults = null;

		tabdata.put("ADDED_BY_ID", addedById);
		tabdata.put("ADDED_DATE",
				new java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
		tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
		tabdata.put("MODIFIED_BY_ID", addedById);
		tabdata.put("MODIFIED_DATE",
				new java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID", addedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO", addedAtWorkstation);
		tabdata.put("PATIENT_CLASS", pat_class);
		tabdata.put("SPECILITY_ID", special);
		tabdata.put("SUMMARY_ID", summary);
		tabdata.put("PRACTITIONER_ID", pctr);

		String dupflds[] = {  };

		if (sess.getAttribute("allStyles") != null) {
			styleMap = (HashMap) sess.getAttribute("allStyles");
			styleSet = styleMap.keySet();
			for (Iterator iterator = styleSet.iterator(); iterator.hasNext();) {
				styleKey = (String) iterator.next();
				System.out.println("key--->" + styleKey);
				contentID = styleKey.substring(22);
				System.out.println("contentID--->" + contentID);
				styleSheetName = (String) styleMap.get("PREFERRED_STYLE_WIDGET"
						+ contentID);
				tabdata.put("CONTENT_ID", contentID);
				tabdata.put("STYLE_SHEET", styleSheetName);

				argArray[0] = prop;
				argArray[1] = tabdata;
				argArray[2] = dupflds;
				argArray[3] = tabledata;

				paramArray[0] = prop.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = tabledata.getClass();

				try {
					styleResults = (java.util.HashMap) (busObj.getClass()
							.getMethod("insert", paramArray)).invoke(busObj,
							argArray);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return styleResults;
	}
private HashMap updatePrefStyleForWidget(Connection con,Properties prop, HttpSession sess,
			String addedById, String addedFacilityId,
			String addedAtWorkstation, String pat_class, String special,
			String pctr, String summary,String oldPatClass,String oldSpecialty,String oldPractitioner) 
		{
		int execute = 0;
		PreparedStatement ps = null;
		java.util.HashMap styleResults = null;
		ResultSet rs = null;
		boolean local_ejbs = false;
		int deleteCount=0;
		Object home;
		Object busObj;
		try {
			home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		
		
		//if(!(pat_class.equals(oldPatClass) && special.equals(oldSpecialty) && pctr.equals(oldPractitioner)))
		//{
		ps  = con.prepareStatement("select count(*)  total  from CA_CHART_SUMM_STYLE_SHEET  where PATIENT_CLASS = ? and SPECILITY_ID = ? and  PRACTITIONER_ID = ? AND SUMMARY_ID=?");
		ps.setString(1,pat_class);
		ps.setString(2,special);
		ps.setString(3,pctr);
		ps.setString(4,summary);
		rs = ps.executeQuery();
		rs.next();
		execute = rs.getInt("total");
		if(rs !=null) rs.close();
		if(ps !=null) ps.close();
		//}
			if( execute > 0)
			{
					
					ps  = con.prepareStatement(" DELETE FROM CA_CHART_SUMM_STYLE_SHEET WHERE SUMMARY_ID=? ");
					ps.setString(1,summary);
					deleteCount = ps.executeUpdate();
					if(deleteCount>0)
					con.commit();
					styleResults = insertPrefStyleForWidget(prop, busObj,sess,addedById,addedFacilityId,addedAtWorkstation,pat_class,special,pctr,summary);
					if(rs !=null) rs.close();
					if(ps !=null) ps.close();
			}else
			{
				styleResults = insertPrefStyleForWidget(prop,busObj,sess,addedById,addedFacilityId,addedAtWorkstation,pat_class,special,pctr,summary);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con);
		}
		return styleResults;
	}
//IN035950 Ends	
}//class

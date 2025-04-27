/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
18/07/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ehis.persist.*;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;

import java.net.*;
import java.util.*;

import webbeans.eCommon.*;

public class EncSummGroupCompServlet extends javax.servlet.http.HttpServlet
{	
	private static final long serialVersionUID = 1L;
	
	String mode = "";
	
	int es_group_flag = 0;	
	String es_group_type="";
	String es_group_code="";
	int es_comp_flag = 0;	
	String es_comp_type="";
	String es_comp_code="";
	String es_comp_remarks="";
	int es_comp_template = 0;	
	int es_comp_columns = 0;	
	String es_comp_status="";	
	String es_comp_desc="";	
	String es_column_type="";
	
	String facilityId="" ;
	String client_ip_address="";
	String addedById = "";
	String modifiedById = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	
	String errorMsg = "";

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
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
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{

		PrintWriter out = null;
		
		boolean bStatus = true;
		
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8 ");
			out = res.getWriter();				
			
			setKeyValues(req);			
			
			if(bStatus)
			{				
				if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
				if (mode.trim().equalsIgnoreCase("update"))   modify(req, res, out);
				if (mode.trim().equalsIgnoreCase("delete"))   delete(req, res, out);
			}			
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	

 /********************************* Populates the hash table with the values *******************/

	@SuppressWarnings("deprecation")
	public void setKeyValues(HttpServletRequest req)
	{			
		java.util.Properties p;		
		
		mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");
		String es_group_flag_str = "";
		es_group_flag_str = (req.getParameter("es_group_flag")==null)?"":req.getParameter("es_group_flag");
		
		if (es_group_flag_str == "")
			es_group_flag = 0;
		else
			es_group_flag = Integer.parseInt(es_group_flag_str);
		
		es_group_type = (req.getParameter("es_group_type")==null)?"":req.getParameter("es_group_type");
		es_group_code = (req.getParameter("es_group_code")==null)?"":req.getParameter("es_group_code");		
		
		HttpSession session	= req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;	
	
	}
	
	public HashMap<String, Object> populateHashMap(HttpServletRequest req, PrintWriter out)
	{			
		java.util.Properties p;		
		
		HashMap<String, Object> tabdata	= null;
		
		HttpSession session	= null;
		session	= req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;        
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;  
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address;
		
		tabdata=new HashMap<String, Object>();
		
		es_comp_columns = 0;
		es_comp_desc = "";
		
		
		mode = (req.getParameter("mode")==null)?"":req.getParameter("mode");
		String es_group_flag_str = "";
		es_group_flag_str = (req.getParameter("es_group_flag")==null)?"":req.getParameter("es_group_flag");
		
		if (es_group_flag_str == "")
			es_group_flag = 0;
		else
			es_group_flag = Integer.parseInt(es_group_flag_str);
		
		es_group_type = (req.getParameter("es_group_type")==null)?"":req.getParameter("es_group_type");
		es_group_code = (req.getParameter("es_group_code")==null)?"":req.getParameter("es_group_code");	
		
		String es_comp_flag_str = "";
		es_comp_flag_str = (req.getParameter("es_comp_flag")==null)?"":req.getParameter("es_comp_flag");
		
		if (es_comp_flag_str == "")
			es_comp_flag = 0;
		else
			es_comp_flag = Integer.parseInt(es_comp_flag_str);
		
		es_comp_type = (req.getParameter("es_comp_type")==null)?"":req.getParameter("es_comp_type");
		es_comp_code = (req.getParameter("es_comp_code")==null)?"":req.getParameter("es_comp_code");
		es_comp_remarks = (req.getParameter("es_comp_remarks")==null)?"":req.getParameter("es_comp_remarks");
		
		String es_comp_temp_str = "";
		es_comp_temp_str = (req.getParameter("es_comp_template")==null)?"":req.getParameter("es_comp_template");
		
		if (es_comp_temp_str == "")
			es_comp_template = 0;
		else
			es_comp_template = Integer.parseInt(es_comp_temp_str);
		
		if (es_comp_template == 2)
		{
			String es_comp_column_str = "";
			es_comp_column_str = (req.getParameter("es_comp_colcount")==null)?"":req.getParameter("es_comp_colcount");
			
			if (es_comp_column_str == "")
				es_comp_columns = 0;
			else
				es_comp_columns = Integer.parseInt(es_comp_column_str);
			
			es_comp_desc = (req.getParameter("es_table_details")==null)?"":req.getParameter("es_table_details");
			
			es_column_type = (req.getParameter("es_columnType_details")==null)?"":req.getParameter("es_columnType_details");
		}
		else if (es_comp_template == 4)
		{
			es_comp_desc = (req.getParameter("es_LineChart_details")==null)?"":req.getParameter("es_LineChart_details");
		}
		
		es_comp_status = "E";
		
		tabdata.put("ES_GROUP_FLAG", es_group_flag);
		tabdata.put("ES_GROUP_TYPE",es_group_type);
		tabdata.put("ES_GROUP_CODE",es_group_code);
		tabdata.put("ES_COMP_FLAG",es_comp_flag);			
		tabdata.put("ES_COMP_TYPE",	es_comp_type);
		tabdata.put("ES_COMP_CODE",es_comp_code);
		tabdata.put("ES_COMP_REMARKS",	es_comp_remarks);	
		tabdata.put("ES_COMP_TEMPLATE",es_comp_template);			
		tabdata.put("ES_COMP_COLUMNS",	es_comp_columns);
		tabdata.put("ES_COMP_DESC",es_comp_desc);
		tabdata.put("ES_COMP_STATUS",es_comp_status);	
		tabdata.put("ES_COLUMN_TYPE",es_column_type);	
		
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",facilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		
		return tabdata;
	}

/***************************************insert**********************************************/

	@SuppressWarnings("deprecation")
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		
		Connection con = null;

		PreparedStatement ps = null;
		String keyVal = "";
		String mapVal = "";
		
		String comp_flag = "";		
		String comp_template = "";
		String comp_col_count = "";
		
		String comp_column = "";
		
		String comp_checked = "";
		
		String comp_desc = "";
		
		boolean comp_checked_flag = false;
		
		StringTokenizer strCodeToken = null;
		//StringTokenizer strSeqToken = null;
		int i=0;
		int rowsCount = 0;
		int insertCount = 0;
		String rowno = "";
		
		try
		{	
			HttpSession session	= req.getSession(false);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			
			con = ConnectionManager.getConnection(req);			
			
			//eCA.EncSummCompRecBean recordsBean = (eCA.EncSummCompRecBean)session.getAttribute("summRecCompBean");
			eCA.EncSummCompRecBean recordsBean = (eCA.EncSummCompRecBean)getObjectFromBean("summRecCompBean","eCA.EncSummCompRecBean",session);			
			
			String locale = (String) p.getProperty("LOCALE");
									
			ArrayList indexList = new ArrayList();		
			if(recordsBean != null)
			{ 
				indexList = recordsBean.retrieveArrayList();

				ps  = con.prepareStatement(" insert into cr_es_group_details (es_group_flag, es_group_type, es_group_code, es_comp_flag, es_comp_type, es_comp_code, es_comp_remarks, es_comp_template, es_comp_columns, es_comp_status, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, es_column_type) " +
						"		values(?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?)");
				
				for(i=0; i<indexList.size(); i++)
				{			
					comp_checked_flag = false;
					keyVal = (String)indexList.get(i);
					
					mapVal = recordsBean.fetchRecords(keyVal);
					
					strCodeToken = new StringTokenizer(mapVal,"~");
					while(strCodeToken.hasMoreTokens())
					{
						comp_flag = strCodeToken.nextToken();						
						es_comp_flag = Integer.parseInt(comp_flag);
						
						rowno = strCodeToken.nextToken();
						
						es_comp_type = strCodeToken.nextToken();
	
						es_comp_code = strCodeToken.nextToken();
						comp_desc = strCodeToken.nextToken();
						comp_template = strCodeToken.nextToken();
						if (comp_template.equalsIgnoreCase("@"))									
							comp_template = "0";			
						
						es_comp_template = Integer.parseInt(comp_template);					
						
						comp_col_count = strCodeToken.nextToken();
						if (comp_col_count.equalsIgnoreCase("@"))
							comp_col_count = "0";
						
						es_comp_columns = Integer.parseInt(comp_col_count);
						
						comp_column = strCodeToken.nextToken();
						if (comp_column.equalsIgnoreCase("@"))
							comp_column = "0";
						
						comp_checked = strCodeToken.nextToken();
						if (comp_checked.equalsIgnoreCase("checked"))
						{
							comp_checked_flag = true;
							insertCount++; 
						}
						
						es_comp_status = "E";					
						
					}
					
					if (comp_checked_flag){				
						ps.setInt(1,es_group_flag);
						ps.setString(2,es_group_type);
						ps.setString(3,es_group_code);
						ps.setInt(4,es_comp_flag);
						ps.setString(5,es_comp_type);
						ps.setString(6,es_comp_code);
						ps.setString(7,es_comp_remarks);
						ps.setInt(8,es_comp_template);
						ps.setInt(9,es_comp_columns);
						ps.setString(10,es_comp_status);
						ps.setString(11,addedById);
						ps.setString(12,addedAtWorkstation);
						ps.setString(13,facilityId);				
						ps.setString(14,modifiedById);
						ps.setString(15,modifiedAtWorkstation);				
						ps.setString(16,facilityId);
						ps.setString(17,es_column_type);
						
						rowsCount = rowsCount + ps.executeUpdate();
					}
				}	
			}
			
			if(rowsCount == insertCount){
				con.commit();
				recordsBean.clearBean();
				session.removeAttribute("summRecCompBean");
				Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_INSERTED","CA");
				errorMsg = (String) tabdata.get("message");
				tabdata.clear();				
				out.println("<script>alert('"+errorMsg+"');</script>");				
				out.println("<script>window.close();</script>");
				//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");										
			}
			else
			{
				try{
					con.rollback();
					errorMsg = "Exception raise by Servlet ...So Record Not inserted  Foll: Error Received : "+errorMsg;
					out.println("<script>alert('"+errorMsg+"');</script>");
					//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(errorMsg,"UTF-8") + "&err_value=0");
				}
				catch(Exception ee){
					ee.printStackTrace();
				}
			}
		}//end of try-1
		catch(Exception e){
			e.printStackTrace();			 
		}
		finally
		{
			try
			{				
				if( ps != null)ps.close();			
				if(con != null)ConnectionManager.returnConnection(con);
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}


	@SuppressWarnings("deprecation")
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String error_value = "0" ;

		HashMap<String, Object> tabdata = null;		
		
		HttpSession session	= null;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;		
		
		tabdata=new HashMap<String, Object>();
		
		try
		{				
			tabdata = populateHashMap(req, out); //FILL THE HASHMap
			
			String locale = (String) p.getProperty("LOCALE");
			
			HashMap<String, Object> condflds=new HashMap<String, Object>();
			condflds.put("ES_GROUP_FLAG",es_group_flag);
			condflds.put("ES_GROUP_TYPE",es_group_type);
			condflds.put("ES_GROUP_CODE",es_group_code);
			condflds.put("ES_COMP_FLAG",es_comp_flag);
			condflds.put("ES_COMP_TYPE",es_comp_type);
			condflds.put("ES_COMP_CODE",es_comp_code);
			
			boolean local_ejbs = false;
			String tabname="CR_ES_GROUP_DETAILS";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();
			condflds.clear();

			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;	
			
			if (modified)			
				error_value = "1";	
			
			results.clear();   	

			out.println("<script> alert('"+error+"'); window.close(); </script>");			
   			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println("<script>alert('Exception raise by Servlet '"+e.toString()+");</script>");	//common-icn-0181
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		
		Connection con = null;

		PreparedStatement ps = null;
		String comp_flag = "";			
		StringTokenizer strDataToken = null;
		StringTokenizer strRecToken = null;
		int rowsCount = 0;
		int deleteCount = 0;
		
		String comp_data = "";	
		String comp_record = "";
		
		try
		{	
			HttpSession session	= req.getSession(false);
			
			con = ConnectionManager.getConnection(req);						
			p = (java.util.Properties) session.getValue("jdbc");			
			String locale = (String) p.getProperty("LOCALE");
			
			rowsCount = Integer.parseInt(req.getParameter("recordCount"));
			comp_data = req.getParameter("comp_data");								
		
			if(rowsCount > 0)
			{			
				ps  = con.prepareStatement(" delete from cr_es_group_details where es_group_flag = ? and es_group_type = ? and es_group_code = ? and es_comp_flag = ? and es_comp_type = ? and es_comp_code = ? ");
				
				strDataToken = new StringTokenizer(comp_data,"^");
				
				while(strDataToken.hasMoreTokens())
				{
					comp_record = strDataToken.nextToken();
					strRecToken = new StringTokenizer(comp_record,"~");
					while(strRecToken.hasMoreTokens())
					{
						comp_flag = strRecToken.nextToken();						
						es_comp_flag = Integer.parseInt(comp_flag);
						es_comp_type = strRecToken.nextToken();						
						es_comp_code = strRecToken.nextToken();						
					}
					
					ps.setInt(1,es_group_flag);
					ps.setString(2,es_group_type);
					ps.setString(3,es_group_code);
					ps.setInt(4,es_comp_flag);
					ps.setString(5,es_comp_type);
					ps.setString(6,es_comp_code);
					
					try{
						deleteCount = deleteCount + ps.executeUpdate();
					}
					catch (SQLException e) {
						errorMsg = "Exception raise by Servlet ...So Record Not Deleted  Foll: Error Received : "+e.getMessage();					
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(errorMsg,"UTF-8") + "&err_value=0");						
					}

				}
				
				if(rowsCount == deleteCount){
					con.commit();					
					Hashtable tabdata = MessageManager.getMessage(locale,"RECORD_DELETED","CA");
					errorMsg = (String) tabdata.get("message");
					tabdata.clear();						
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMsg,"UTF-8")+"&err_value=1");										
				}
				else
				{
					try{
						con.rollback();
						errorMsg = "Exception raise by Servlet ...So Record Not Deleted  Foll: Error Received : ";					
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + URLEncoder.encode(errorMsg,"UTF-8") + "&err_value=0");
					}
					catch(Exception ee){
						ee.printStackTrace();
					}
				}
			}			
			
		}//end of try-1
		catch(Exception e){
			e.printStackTrace();			 
		}
		finally
		{
			try
			{				
				if(ps != null) ps.close();			
				if(con != null) ConnectionManager.returnConnection(con);
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
		}
	}
	
	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null fields
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}	
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}
	
	
	
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;

/**
 *		FileName : ResultTemplateServlet.java
 *		Version	 : 3
 *		Date	 : 14-2-05	
**/

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import webbeans.eCommon.*;
//import oracle.sql.*; //commented as part of weblogic migration
//import oracle.jdbc.*;
import webbeans.eCommon.MessageManager;

public class ResultTemplateServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt0=null;
	int rs=0;
	
	ResultSet rs1=null;
	ResultSet rs0=null;


	String result_template_id     = "" ;   
	String result_template_name   = "" ;   
	String result_template        = "" ;   
	String eff_status             = "" ;   
	
	String facilityId ;
	String client_ip_address ;


	String addedById			= "";
	String modifiedById			= "";
	String addedFacilityId		= "";
	String modifiedFacilityId	= "";
	String addedAtWorkstation	= "";
	String modifiedAtWorkstation= "";
String locale="";
	String error_value="";
	String error="";

	HashMap tabdata			= null;

	String mode					 = ""; 
	String beforeUpdateEff_status= "";

	boolean inserted=false;

	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		 locale= p.getProperty("LOCALE");
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		//modifiedDate = dateFormat.format( new java.util.Date());  
		modifiedFacilityId		= (this.facilityId==null)?"":this.facilityId;                    
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;                            

		tabdata=new HashMap();

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");


			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res);
			if (mode.trim().equalsIgnoreCase("update"))   modify(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		}
		catch(Exception e)	{	}
	}*/
/**********************************************************************************************/

	private void extractData(HttpServletRequest req)
	{
		
				beforeUpdateEff_status	= checkNull("beforeUpdateEff_status", req); 
				
				eff_status				= checkNull("eff_status", req); 
				eff_status  			=(eff_status.equals(""))?"D":eff_status ;
								
				if(mode.trim().equalsIgnoreCase("update"))
				{
					result_template_id	= checkNull("result_template_id_update",req);
				}
				else
				{
					result_template_id	= checkNull("result_template_id",req);
				}
				
				
				result_template_name	= checkNull("result_template_name",req);        
				
				result_template			= checkNull("result_template", req);          
									
		}
	/***************************************Checks the request paramtere for the null values*****************************************************/
	
	public String checkNull(String str,HttpServletRequest req) //flag is true for null feilds
	{
		String tempHolder =  req.getParameter(str)	 ;
		return (tempHolder==null)?"":tempHolder ;
	}

 /**********************************************Pouplates the hashtable with the values*******************/

	public void populateHashTable()
	{
			if(!(beforeUpdateEff_status.equalsIgnoreCase("checked")) &&  mode.trim().equalsIgnoreCase("update"))
				{	
					tabdata.put("RESULT_TEMPLATE_ID", result_template_id);
					tabdata.put("EFF_STATUS",eff_status);
					tabdata.put("MODIFIED_BY_ID",modifiedById);
					tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
					tabdata.put("MODIFIED_FACILITY_ID",this.facilityId);
					tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
					return ;
				}


			tabdata.put("RESULT_TEMPLATE_ID", result_template_id);
			tabdata.put("RESULT_TEMPLATE_NAME",result_template_name);
			tabdata.put("RESULT_TEMPLATE", result_template);
			tabdata.put("EFF_STATUS",eff_status);

			if (mode.equalsIgnoreCase("insert"))
			{
				
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", this.facilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				
			}
			
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",this.facilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			
	
			return ;
	
	}

/***************************************insert**********************************************/

	private void insert(HttpServletRequest req, HttpServletResponse res)
	{
	
		try
		{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			//addedDate = dateFormat.format( new java.util.Date() ) ;

			addedFacilityId		= (this.facilityId==null)?"":this.facilityId;  
			addedAtWorkstation	= (client_ip_address==null)?"":client_ip_address; 
		                                        
		

			extractData(req) ;
		
			int filecount = 0;
			String sql33 = " select count(*) fc from am_result_template where result_template_id=?";
			pstmt0=con.prepareStatement(sql33);
			pstmt0.setString(1,result_template_id);
			rs0=pstmt0.executeQuery();
			if ((rs0 != null) && rs0.next())
			{
			filecount = rs0.getInt("fc"); 
			
			}		
			
			if(filecount==0)
			{
		
			String sql=" insert into am_result_template values(?,?,empty_clob(),?,?,sysdate,?,?,?,sysdate,?,?) ";
			pstmt=con.prepareStatement(sql);
			
			
			pstmt.setString(1,result_template_id);
			pstmt.setString(2,result_template_name);
			pstmt.setString(3,eff_status);
			pstmt.setString(4,addedById);
			pstmt.setString(5,addedAtWorkstation);
			pstmt.setString(6,addedFacilityId);
			pstmt.setString(7,modifiedById);
			pstmt.setString(8,modifiedAtWorkstation);
			pstmt.setString(9,modifiedFacilityId);

			rs= pstmt.executeUpdate();
		
			if(rs!=0)
			{
				String sql1="Select result_template from am_result_template where result_template_id=? for update";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setString(1,result_template_id);
				rs1=pstmt1.executeQuery();
				Clob clb=null;
				if(rs1!=null && rs1.next())
				{
					clb=rs1.getClob(1);
					//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream());//commented and the following line added as part of weblogic migration.
					Writer w = clb.setCharacterStream(0);
					  w.write(result_template,0,result_template.length());
					  w.flush();
					  w.close();
				}
				 inserted=true;
			}
			else inserted=false;

			if ( inserted )
			{
				con.commit();
			 error_value = "1" ;
			 Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
                 error = (String)hashtable1.get("message");
				hashtable1.clear();
			}
			else
			{
				
				con.rollback();
				error_value="0";
			 Hashtable hashtable1 = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
                 error = (String)hashtable1.get("message");
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) +"&err_value="+error_value);

			}
			else
			{
			error_value="0";
			Hashtable hashtable1 = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
                 error = (String)hashtable1.get("message");
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) +"&err_value="+error_value);
			}

			}
			catch ( Exception e )
			{
						out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
									
			}
			finally
			{
				try
				{
					if(rs1!=null) rs1.close();
					if(rs0!=null) rs0.close();
					if(pstmt0!=null) pstmt0.close();
					if(pstmt1!= null) pstmt1.close();
					if(pstmt!= null) pstmt.close();
				}catch(Exception e){out.print("Exception in closing statements " + e);}
				ConnectionManager.returnConnection(con,req);
			}
	}

	/***************************************modify**********************************************/


	private void modify(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			extractData(req) ;
			populateHashTable(); //FILL THE HASHTABLE

			String sql=" Update am_result_template set  result_template_name=? ,result_template=empty_clob(), eff_status=?, modified_by_id=?,modified_date=sysdate,modified_at_ws_no=?, modified_facility_id=? where result_template_id=? ";
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1,result_template_name);
			pstmt.setString(2,eff_status);
			pstmt.setString(3,modifiedById);
			pstmt.setString(4,modifiedAtWorkstation);
			pstmt.setString(5,modifiedFacilityId);
			pstmt.setString(6,result_template_id);

			rs= pstmt.executeUpdate();
			
			if(rs!=0)
			{
				String sql1="Select result_template from am_result_template where result_template_id=? for update";
				pstmt1=con.prepareStatement(sql1);
				pstmt1.setString(1,result_template_id);
				rs1=pstmt1.executeQuery();
				Clob clb=null;
				if(rs1!=null && rs1.next())
				{
					clb=rs1.getClob(1);
					//BufferedWriter w = new BufferedWriter(((CLOB)clb).getCharacterOutputStream()); //Commented and the following line added as part of weblogic migration
					Writer w = clb.setCharacterStream(0);
					  w.write(result_template,0,result_template.length());
					  w.flush();
					  w.close();
				}
				 inserted=true;
			}
			else inserted=false;
			

				if ( inserted )
			{
				con.commit();
			 error_value = "1" ;
			 Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
              error = (String)hashtable1.get("message");
				hashtable1.clear();
			}
			else
			{
				con.rollback();
				error_value="0";
			}

		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(error,"UTF-8"  ) +"&err_value="+error_value);

		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
		finally
		{	
			try
			{
			if(rs1!=null)rs1.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			}
			catch(Exception e)
			{}
			ConnectionManager.returnConnection(con,req);
		}
	}


}

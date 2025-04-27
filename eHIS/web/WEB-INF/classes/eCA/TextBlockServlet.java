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
?             100            ?           created
14/08/2012		IN034340		Dinesh T		For retaining the copy paste content format from MS Document	
---------------------------------------------------------------------------------------------------------------
*/ 
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class TextBlockServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MMS-ME-SCF-0097
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			out = res.getWriter();
			String operation = req.getParameter("mode");

			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
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
			doPost(req, res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
	//[IN033180] Start.
	/*private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{	

		java.util.Properties p;
		String text_blk_id 		=	"";
		String service_code 	=	"";
		String practitioner_id 	=	"";
		String note_type 		=	"";
		String sec_hdg_code 	=	"";
		String text_blk		    = 	"";
		String procedure_yn		=   "";

		String facilityId ;
		String client_ip_address ;
		String eff_status = "";
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		
		try
		{
			text_blk_id 	=	req.getParameter("text_blk_id");
			service_code 	=	req.getParameter("service");
			practitioner_id =	req.getParameter("practitioner");
			note_type 		=	req.getParameter("notetype")==null?"":req.getParameter("notetype");
			sec_hdg_code 	=	req.getParameter("section")==null?"":req.getParameter("section");
			text_blk 		=	req.getParameter("text_block");
			procedure_yn    =   req.getParameter("procedure_yn")==null?"N":req.getParameter("procedure_yn");

			eff_status = req.getParameter("eff_status");
			if ( eff_status == null )
				eff_status="D";

			String addedById		= (String) p.getProperty( "login_user" ) ;
			String modifiedById		= addedById ;
			
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();

			tabdata.put("text_blk_id",text_blk_id);
			tabdata.put("service_code",service_code);
			tabdata.put("practitioner_id",practitioner_id);
			tabdata.put("note_type",note_type);
			tabdata.put("sec_hdg_code",sec_hdg_code);
			tabdata.put("text_blk",text_blk);
			tabdata.put("applicable_category",procedure_yn);
			tabdata.put("eff_status",eff_status);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();

			condflds.put("text_blk_id",text_blk_id);

			boolean local_ejbs = false;
			String tabname="ca_text_blk_by_serv_pract";
		
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

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( inserted )
				 error_value = "1" ;

			results.clear();
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			out.println( "Values sent are : <br>" ) ;
			out.println(text_blk_id+" "+service_code+" "+practitioner_id+" "+note_type+" "+sec_hdg_code+" "+text_blk);
		}
	}*/


	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		
		java.util.Properties p;
		String text_blk_id 		=	"";
		String service_code 	=	"";
		String practitioner_id 	=	"";
		String note_type 		=	"";
		String sec_hdg_code 	=	"";
		String text_blk		    = 	"";
		String text_blk_content =	"";	//[IN033180] 
		String text_blk_type	=	""; //[IN033180] 
		String procedure_yn		=   "";
		
		String facilityId ;
		String client_ip_address ;
		String eff_status = "";
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		String local = (String) p.getProperty("LOCALE");  //[IN033180] 
		try
		{
			text_blk_id 	=	req.getParameter("text_blk_id");
			service_code 	=	req.getParameter("service");
			practitioner_id =	req.getParameter("practitioner");
			note_type 		=	req.getParameter("notetype")==null?"":req.getParameter("notetype");
			sec_hdg_code 	=	req.getParameter("section")==null?"":req.getParameter("section");
			text_blk 		=	req.getParameter("text_block");
			//text_blk_content 		=	req.getParameter("textBlockEditorContent");		//[IN033180] 
			text_blk_type	=	req.getParameter("text_type_id");		//[IN033180] 
			procedure_yn    =   req.getParameter("procedure_yn")==null?"N":req.getParameter("procedure_yn");

			eff_status = req.getParameter("eff_status");
			
			if ( eff_status == null )
					eff_status="D";

			out.println(text_blk_id+" "+service_code+" "+practitioner_id+" "+note_type+" "+sec_hdg_code+" "+text_blk);

			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			//[IN033180] 
			java.util.HashMap results =new HashMap();
			boolean result = false;
			if("T".equals(text_blk_type)){			//[IN033180] 
				HashMap tabdata=new HashMap();

				tabdata.put("text_blk_id",text_blk_id);
				tabdata.put("service_code",service_code);
				tabdata.put("practitioner_id",practitioner_id);
				tabdata.put("note_type",note_type);
				tabdata.put("sec_hdg_code",sec_hdg_code);
				tabdata.put("applicable_category",procedure_yn);
				tabdata.put("text_blk",text_blk);
				tabdata.put("eff_status",eff_status);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
				tabdata.put("text_type",text_blk_type);

				String dupflds[]={"text_blk_id"};

				boolean local_ejbs = false;
				String tabname="ca_text_blk_by_serv_pract";
			
				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				
				Object argArray[] = new Object[4];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = dupflds;
				argArray[3] = tabname;

				Class [] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = dupflds.getClass();
				paramArray[3] = tabname.getClass();

				//[IN033180] java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				tabdata.clear();
			}else if("E".equals(text_blk_type)){
				Connection con			=	null;
				PreparedStatement pstmt	=	null;
				PreparedStatement pstmt1=	null;
				PreparedStatement pstmt2=	null;
				PreparedStatement pstmt3=	null;
				ResultSet rs			= 	null;
				ResultSet rset_clob		= 	null;
					
				try{				
					con = ConnectionManager.getConnection();
					
					pstmt = con.prepareStatement("select * from ca_text_blk_by_serv_pract where text_blk_id=?");
					pstmt.setString(1,text_blk_id);
					rs = pstmt.executeQuery();
					if(rs.next()){
						results.put("status", result);
						java.util.Hashtable hashtable = MessageManager.getMessage(local,"CODE_ALREADY_EXISTS","Common");
                    	String error = (java.lang.String)hashtable.get("message");
						results.put("error", error);
					}else{					
						String insertQuery ="insert into ca_text_blk_by_serv_pract (text_blk_id,service_code,practitioner_id,note_type,sec_hdg_code,applicable_category,text_blk,eff_status,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no,TEXT_TYPE,TEXT_CLOB_BLK)values(?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,empty_clob())";
						pstmt1	= con.prepareStatement(insertQuery);
						pstmt1.setString(1,text_blk_id);
						pstmt1.setString(2,service_code);
						pstmt1.setString(3,practitioner_id);
						pstmt1.setString(4,note_type);
						pstmt1.setString(5,sec_hdg_code);
						pstmt1.setString(6,procedure_yn);
						pstmt1.setString(7,text_blk);
						pstmt1.setString(8,eff_status);
						pstmt1.setString(9,addedById);
						pstmt1.setString(10,facilityId);
						pstmt1.setString(11,addedAtWorkstation);
						pstmt1.setString(12,modifiedById);
						pstmt1.setString(13,modifiedFacilityId);
						pstmt1.setString(14,modifiedAtWorkstation);
						pstmt1.setString(15,text_blk_type);
						
						int result_clob = pstmt1.executeUpdate();
						if(result_clob > 0) result = true; else result = false;
						if(result){
							pstmt2	= con.prepareStatement("select TEXT_CLOB_BLK from ca_text_blk_by_serv_pract where text_blk_id=? FOR UPDATE ");
							pstmt2.setString(1,text_blk_id);
							rset_clob = pstmt2.executeQuery();
							String text_content=session.getValue( "TEXTBLOCK_CONTENT" )==null?"":(String) session.getValue( "TEXTBLOCK_CONTENT" ) ;
							text_blk_content = java.net.URLDecoder.decode(text_content,"UTF-8");
							//text_blk_content = text_blk_content.replace("\"", "'");							
							text_blk_content = text_blk_content.replace("#DQ#", "\"");//IN034340							
							if(rset_clob!=null){
								while(rset_clob.next())
								{							
									java.sql.Clob tclb		=rset_clob.getClob(1);
									java.io.Writer ist = tclb.setCharacterStream(1);
									ist.write(text_blk_content);
									ist.flush();
									ist.close();
								}
							}
							if(rset_clob!=null)rset_clob.close();
							
							pstmt3	= con.prepareStatement("update ca_text_blk_by_serv_pract set text_blk=? where text_blk_id=? ");
							pstmt3.setString(1," ");
							pstmt3.setString(2,text_blk_id);
							result_clob = pstmt3.executeUpdate();
							if(result_clob > 0) result = true; else result = false;
							
						}
						con.commit();
						results.put("status", result);
						java.util.Hashtable hashtable = MessageManager.getMessage(local,"RECORD_INSERTED","SM");
                    	String error = (java.lang.String)hashtable.get("message");
						results.put("error", error);					
					}
				}catch(Exception ex){
					try
					{
						con.rollback();
					}
					catch(java.lang.Exception exception1) { }
					result = false;
					results.put("status", result);
                    String error = ex.getMessage();
					results.put("error", error);
				}finally{
					if(rs!=null)rs.close();//15905
					if(pstmt3!=null)pstmt3.close();
					if(pstmt2!=null)pstmt2.close();
					if(pstmt1!=null)pstmt1.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
				}
			}
			//[IN033180] end.
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted )
				error_value = "1" ;

			 results.clear();
			
			
			 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			// out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			 e.printStackTrace();
			// out.println( "Values sent are : <br>" ) ;//common-icn-0181
			 out.println(text_blk_id+" "+service_code+" "+practitioner_id+" "+note_type+" "+sec_hdg_code+" "+text_blk);
		}
	}
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{	

		java.util.Properties p;
		String text_blk_id 		=	"";
		String service_code 	=	"";
		String practitioner_id 	=	"";
		String note_type 		=	"";
		String sec_hdg_code 	=	"";
		String text_blk		    = 	"";
		String text_blk_content =	"";	
		String text_blk_type	=	""; 
		String procedure_yn		=   "";

		String facilityId ;
		String client_ip_address ;
		String eff_status = "";
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		String local = (String) p.getProperty("LOCALE");  
		try
		{
			text_blk_id 	=	req.getParameter("text_blk_id");
			service_code 	=	req.getParameter("service");
			practitioner_id =	req.getParameter("practitioner");
			note_type 		=	req.getParameter("notetype")==null?"":req.getParameter("notetype");
			sec_hdg_code 	=	req.getParameter("section")==null?"":req.getParameter("section");
			text_blk 		=	req.getParameter("text_block");
			//text_blk_content 		=	req.getParameter("textBlockEditorContent");		
			text_blk_type	=	req.getParameter("text_type_id");		
			procedure_yn    =   req.getParameter("procedure_yn")==null?"N":req.getParameter("procedure_yn");

			eff_status = req.getParameter("eff_status");
			if ( eff_status == null )
				eff_status="D";

			String addedById		= (String) p.getProperty( "login_user" ) ;
			String modifiedById		= addedById ;
			
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			java.util.HashMap results =new HashMap();
			boolean result = false;
			Connection con			=	null;
			PreparedStatement pstmt	=	null;
			PreparedStatement pstmt1=	null;
			PreparedStatement pstmt2=	null;
			//ResultSet rs			= 	null;//checkstyle
			ResultSet rset_clob		= 	null;
					
			try{				
				con = ConnectionManager.getConnection();				
				if("T".equals(text_blk_type)){	
					pstmt = con.prepareStatement("update ca_text_blk_by_serv_pract set text_blk_id=?,service_code=?,practitioner_id=?,note_type=?,sec_hdg_code=?,text_blk=?,applicable_category=?,eff_status=?,modified_by_id=?,modified_date=sysdate,modified_facility_id=?,modified_at_ws_no=?,text_type=?,text_clob_blk=empty_clob() where text_blk_id=?");
					pstmt.setString(1,text_blk_id);
					pstmt.setString(2,service_code);
					pstmt.setString(3,practitioner_id);
					pstmt.setString(4,note_type);
					pstmt.setString(5,sec_hdg_code);
					pstmt.setString(6,text_blk);
					pstmt.setString(7,procedure_yn);
					pstmt.setString(8,eff_status);
					pstmt.setString(9,modifiedById);
					pstmt.setString(10,modifiedFacilityId);
					pstmt.setString(11,modifiedAtWorkstation);
					pstmt.setString(12,text_blk_type);
					pstmt.setString(13,text_blk_id);
					
					int result_clob = pstmt.executeUpdate();
					if(result_clob > 0) result = true; else result = false;
					if(result){
						results.put("status", result);
						java.util.Hashtable hashtable = MessageManager.getMessage(local,"RECORD_MODIFIED","SM");
						String error = (java.lang.String)hashtable.get("message");
						results.put("error", error);
					}
					con.commit();
				}else if("E".equals(text_blk_type)){
					pstmt = con.prepareStatement("update ca_text_blk_by_serv_pract set text_blk_id=?,service_code=?,practitioner_id=?,note_type=?,sec_hdg_code=?,text_blk=?,applicable_category=?,eff_status=?,modified_by_id=?,modified_date=sysdate,modified_facility_id=?,modified_at_ws_no=?,text_type=?,text_clob_blk=empty_clob() where text_blk_id=?");
					pstmt.setString(1,text_blk_id);
					pstmt.setString(2,service_code);
					pstmt.setString(3,practitioner_id);
					pstmt.setString(4,note_type);
					pstmt.setString(5,sec_hdg_code);
					pstmt.setString(6,"");
					pstmt.setString(7,procedure_yn);
					pstmt.setString(8,eff_status);
					pstmt.setString(9,modifiedById);
					pstmt.setString(10,modifiedFacilityId);
					pstmt.setString(11,modifiedAtWorkstation);
					pstmt.setString(12,text_blk_type);
					pstmt.setString(13,text_blk_id);					
					int result_clob = pstmt.executeUpdate();
					if(result_clob > 0) result = true; else result = false;
					if(result){
						pstmt1	= con.prepareStatement("select TEXT_CLOB_BLK from ca_text_blk_by_serv_pract where text_blk_id=? FOR UPDATE ");
						pstmt1.setString(1,text_blk_id);
						rset_clob = pstmt1.executeQuery();
						String text_content=session.getValue( "TEXTBLOCK_CONTENT" )==null?"":(String) session.getValue( "TEXTBLOCK_CONTENT" ) ;
						text_blk_content = java.net.URLDecoder.decode(text_content,"UTF-8");
						//text_blk_content = text_blk_content.replace("\"", "'");						
						text_blk_content = text_blk_content.replace("#DQ#", "\"");//IN034340						
						if(rset_clob!=null){
							while(rset_clob.next())
							{							
								java.sql.Clob tclb		=rset_clob.getClob(1);
								java.io.Writer ist = tclb.setCharacterStream(1);
								ist.write(text_blk_content);
								ist.flush();
								ist.close();
							}
						}
						if(rset_clob!=null)rset_clob.close();
						pstmt2	= con.prepareStatement("update ca_text_blk_by_serv_pract set text_blk=? where text_blk_id=? ");
						pstmt2.setString(1," ");
						pstmt2.setString(2,text_blk_id);
						result_clob = pstmt2.executeUpdate();
						if(result_clob > 0) result = true; else result = false;
					}
					con.commit();
					results.put("status", result);
					java.util.Hashtable hashtable = MessageManager.getMessage(local,"RECORD_MODIFIED","SM");
					String error = (java.lang.String)hashtable.get("message");
					results.put("error", error);
				}
			}catch(Exception ex){
				try
				{
					con.rollback();
				}
				catch(java.lang.Exception exception1) { }
				result = false;
				results.put("status", result);
				String error = ex.getMessage();
				results.put("error", error);
			}finally{
				if(pstmt2!=null)pstmt2.close();
				if(pstmt1!=null)pstmt1.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			}			

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			
			if ( inserted )
				 error_value = "1" ;

			results.clear();
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			out.println(text_blk_id+" "+service_code+" "+practitioner_id+" "+note_type+" "+sec_hdg_code+" "+text_blk);
		}
	}
	//[IN033180] Start.
}

/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date			Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
22/03/2016    	IN059755     	Karthi											Error Received : java.util.MissingResourceException: Cant find resource for bundle eSM.resources.Messages, key CODE_ALREADY_EXISTS 
03/03/2022      29024           K Pranay                                          unused local variable[Common-ICN-0092  ]
-------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;

public class ResearchPatientCategoryFactorsMasterServlet extends javax.servlet.http.HttpServlet
{
	         
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException			
	{
		res.setContentType("text/html;charset=UTF-8");	
		req.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res, out);
		}
		catch(Exception e)
		{
			out.println("Exception in try1 of ResearchPatientCategoryFactorsMasterServlet.java: "+e.toString());
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
	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		Connection          con = null;
		PreparedStatement pstmt = null;	
		ResultSet rs			= null;
		try
		{
			con = ConnectionManager.getConnection(req);
			
			java.util.Properties p;
		//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;//Common-ICN-0092 
			
			String research_categ_fact_id 	 		= "";
			String research_categ_fact_desc 	 	= "";
			String research_categ_fact_select_categ = "";
			String eff_status 			 = "";
			String facilityId			 = "";
			String client_ip_address	 = "";
			String addedById			 = "";
		//	String addedDate			 = "";//Common-ICN-0092  
			String addedAtWorkstation	 = "";
			String addedFacilityId		 = "";			
			String modifiedById			 = "";
		//	String modifiedDate			 = "";//Common-ICN-0092  
			String modifiedAtWorkstation = "";
			String modifiedFacilityId	 = "";
			int fctUpRecord				 = 0;
			int[] fctDtlUpRecord ={};
			HttpSession session;
			session 	= req.getSession(false);
			facilityId 	= (String)session.getValue( "facility_id" ) ;
			
			p = (Properties)session.getValue("jdbc") ;			
			client_ip_address = p.getProperty("client_ip_address");
			 
			
			addedById 			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address;
			
			modifiedById 			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
			modifiedFacilityId		=  (facilityId == null)?"":facilityId; 
			modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address; 
			
			research_categ_fact_id 	 		 = req.getParameter("research_categ_fact_id");
			research_categ_fact_desc 	 	 = req.getParameter("research_categ_fact_desc");
			research_categ_fact_select_categ = req.getParameter("research_categ_fact_select_categ");
			eff_status						 = req.getParameter("eff_status1");
			String error = "" ;
			String error_value = "0" ;
			
			/*HashMap tabdata = new HashMap(); 			
			tabdata.put("RESEARCH_CATEG_FACT_ID",research_categ_fact_id);
			tabdata.put("RESEARCH_CATEG_FACT_DESC",research_categ_fact_desc);
			tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			
			String dupflds[]={"RESEARCH_CATEG_FACT_ID"}
			
			
			boolean local_ejbs = false;
			String tabname="CA_RESEARCH_CATEGORY_FACT";
			
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
			
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();
			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			*/
			
			//pstmt = con.prepareStatement("SELECT RESEARCH_CATEG_FACT_ID FROM CA_RESEARCH_CATEGORY_FACT WHERE RESEARCH_CATEG_FACT_ID='"+research_categ_fact_id+"'");//COMMON-ICN-0180
			pstmt = con.prepareStatement("SELECT RESEARCH_CATEG_FACT_ID FROM CA_RESEARCH_CATEGORY_FACT WHERE RESEARCH_CATEG_FACT_ID=?");//COMMON-ICN-0180
			pstmt.setString(1,research_categ_fact_id );//COMMON-ICN-0180
			rs = pstmt.executeQuery();
			if(rs.next()){
				error_value = "1" ;
				//java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"CODE_ALREADY_EXISTS","SM"); //IN059755 - commented.
				java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_EXISTS","SM"); //IN059755 - modified.
				error =(java.lang.String)hashtable4.get("message");
			}else{
				try{
					if(rs!=null)rs.close();//Common-ICN-0092
					if(pstmt!=null)pstmt.close();
					String SqlQuery ="INSERT INTO CA_RESEARCH_CATEGORY_FACT (RESEARCH_CATEG_FACT_ID,RESEARCH_CATEG_FACT_DESC,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(SqlQuery);
					pstmt.setString(1,research_categ_fact_id);
					pstmt.setString(2,research_categ_fact_desc);
					pstmt.setString(3,eff_status);
					pstmt.setString(4,addedById);
					pstmt.setTimestamp(5,new  java.sql.Timestamp(System.currentTimeMillis()));
					pstmt.setString(6,addedFacilityId);
					pstmt.setString(7,addedAtWorkstation);
					pstmt.setString(8,modifiedById);
					pstmt.setTimestamp(9,new  java.sql.Timestamp(System.currentTimeMillis()));
					pstmt.setString(10,modifiedFacilityId);
					pstmt.setString(11,modifiedAtWorkstation);
					
					fctUpRecord = pstmt.executeUpdate();
					
					if(pstmt!=null)pstmt.close();
					
					
			
					if ( fctUpRecord>0 )
					{
						String SqlQuery1 ="INSERT INTO CA_RESEARCH_CATEGORY_FACT_DTL(RESEARCH_CATEG_FACT_ID,RESEARCH_CATEG_ID,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?)";
						String[] temValue_=research_categ_fact_select_categ.split(",");
						pstmt = con.prepareStatement(SqlQuery1);
			
						int tempCount = temValue_.length;
					//	int count =0;//Common-ICN-0092  
						
						for(int i=0;i<tempCount;i++){				
							if(!temValue_[i].equals(""))
							{
							pstmt.setString(1,research_categ_fact_id);
							pstmt.setString(2,(String)temValue_[i]);
							pstmt.setString(3,addedById);
							pstmt.setTimestamp(4,new  java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(5,addedFacilityId);
							pstmt.setString(6,addedAtWorkstation);
							pstmt.setString(7,modifiedById);
							pstmt.setTimestamp(8,new  java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(9,modifiedFacilityId);
							pstmt.setString(10,modifiedAtWorkstation);
							pstmt.addBatch();
							}	
						}
						fctDtlUpRecord = pstmt.executeBatch();
						if(pstmt!=null)pstmt.close();			
					}
					System.out.println("	ResearchPatientCategoryFactorsMasterServlet.java-------------fctDtlUpRecord.length--------->"+fctDtlUpRecord.length);
					if(fctDtlUpRecord.length>0){
						error_value = "1" ;
						java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_INSERTED","SM");
						error =(java.lang.String)hashtable4.get("message");
						con.commit();	
					}else{
						con.rollback();
						error ="Exception occurred, data not saved.";
					}
				}catch(Exception ex){
					error = ex.getMessage();
				}
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);			
			
		}//end of try block
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();//Common-ICN-0092
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				}catch(Exception e){
					System.out.println("Exception raise by ResearchPatientCategoryFactorsMasterServlet : "+e.toString());
				}
		}
	}//end of insert 
	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		Connection          con = null;
		PreparedStatement pstmt = null;	
		//ResultSet rs			= null;//Common-ICN-0092 
		try
		{
			con = ConnectionManager.getConnection(req);
			
			java.util.Properties p;
		//	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;// Common-ICN-0092  
			
			String research_categ_fact_id 	 		= "";
			String research_categ_fact_desc 	 	= "";
			String research_categ_fact_select_categ = "";
			String eff_status 			 = "";
			String facilityId			 = "";
			String client_ip_address	 = "";
			String addedById			 = "";
		//	String addedDate			 = "";//Common-ICN-0092  
			String addedAtWorkstation	 = "";
			String addedFacilityId		 = "";			
			String modifiedById			 = "";
		//	String modifiedDate			 = "";//Common-ICN-0092  
			String modifiedAtWorkstation = "";
			String modifiedFacilityId	 = "";
			int fctUpRecord				 = 0;
			int deletRecord				 = 0;
			int[] fctDtlUpRecord ={};
			HttpSession session;
			session 	= req.getSession(false);
			facilityId 	= (String)session.getValue( "facility_id" ) ;
			
			p = (Properties)session.getValue("jdbc") ;			
			client_ip_address = p.getProperty("client_ip_address");
			 
			
			addedById 			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address;
			
			modifiedById 			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
			modifiedFacilityId		=  (facilityId == null)?"":facilityId; 
			modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address; 
			
			research_categ_fact_id 	 		 = req.getParameter("research_categ_fact_id1");
			research_categ_fact_desc 	 	 = req.getParameter("research_categ_fact_desc");
			research_categ_fact_select_categ = req.getParameter("research_categ_fact_select_categ");
			eff_status						 = req.getParameter("eff_status1");
			String error = "" ;
			String error_value = "0" ;
			String[] temValue_=research_categ_fact_select_categ.split(","); 
			int tempCount = temValue_.length; 
		
			try{
				String SqlQuery ="UPDATE CA_RESEARCH_CATEGORY_FACT SET RESEARCH_CATEG_FACT_DESC=?,EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=?,MODIFIED_FACILITY_ID=?,MODIFIED_AT_WS_NO=? WHERE RESEARCH_CATEG_FACT_ID=?";
				pstmt = con.prepareStatement(SqlQuery);				
				pstmt.setString(1,research_categ_fact_desc);
				pstmt.setString(2,eff_status);				
				pstmt.setString(3,modifiedById);
				pstmt.setTimestamp(4,new  java.sql.Timestamp(System.currentTimeMillis()));
				pstmt.setString(5,modifiedFacilityId);
				pstmt.setString(6,modifiedAtWorkstation);
				pstmt.setString(7,research_categ_fact_id);
				fctUpRecord = pstmt.executeUpdate();				
				if(pstmt!=null)pstmt.close();				
			
				if ( fctUpRecord>0 ){
				
					//String DeleteQuery="DELETE FROM CA_RESEARCH_CATEGORY_FACT_DTL WHERE RESEARCH_CATEG_FACT_ID='"+research_categ_fact_id+"'";//common-icn-0180
					String DeleteQuery="DELETE FROM CA_RESEARCH_CATEGORY_FACT_DTL WHERE RESEARCH_CATEG_FACT_ID=?";//common-icn-0180
					pstmt = con.prepareStatement(DeleteQuery);
					pstmt.setString(1, research_categ_fact_id);//common-icn-0180
					deletRecord = pstmt.executeUpdate();
					if(pstmt!=null)pstmt.close();
				
					
							
						String SqlQuery1 ="INSERT INTO CA_RESEARCH_CATEGORY_FACT_DTL(RESEARCH_CATEG_FACT_ID,RESEARCH_CATEG_ID,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) VALUES(?,?,?,?,?,?,?,?,?,?)";
						
						pstmt = con.prepareStatement(SqlQuery1);
					
						
					//	int count =0;//Common-ICN-0092  
						
						for(int i=0;i<tempCount;i++){				
							if(!temValue_[i].equals(""))
							{
							pstmt.setString(1,research_categ_fact_id);
							pstmt.setString(2,(String)temValue_[i]);
							pstmt.setString(3,addedById);
							pstmt.setTimestamp(4,new  java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(5,addedFacilityId);
							pstmt.setString(6,addedAtWorkstation);
							pstmt.setString(7,modifiedById);
							pstmt.setTimestamp(8,new  java.sql.Timestamp(System.currentTimeMillis()));
							pstmt.setString(9,modifiedFacilityId);
							pstmt.setString(10,modifiedAtWorkstation);
							pstmt.addBatch();
						}
						}
						fctDtlUpRecord = pstmt.executeBatch();
						if(pstmt!=null)pstmt.close();			
				
				}
			
				if(fctDtlUpRecord.length>0){
					error_value = "1" ;
					java.util.Hashtable hashtable4 = MessageManager.getMessage(p.getProperty("LOCALE"),"RECORD_MODIFIED","SM");
					error =(java.lang.String)hashtable4.get("message");
					con.commit();	
				}else{
					con.rollback();
					error ="Exception occurred, data not saved.";
				}
			}catch(Exception ex){
				error = ex.getMessage();
			}
			
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);			
			
		}//end of try block
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				}catch(Exception e){
					System.out.println("Exception raise by ResearchPatientCategoryFactorsMasterServlet : "+e.toString());
				}
		}
	}//end of modify
}
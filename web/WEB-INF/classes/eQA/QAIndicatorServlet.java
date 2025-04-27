/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eQA;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*; 
import webbeans.eCommon.ConnectionManager;


import eCommon.SingleTabHandler.*;

public class QAIndicatorServlet extends HttpServlet implements SingleThreadModel{
	PrintWriter out;
	String facilityId;
	HttpSession session;
	Properties p;
	String client_ip_address;
	boolean inserted		= false;
	String mode="";
	String qind_clind_id="";               
	String qind_clind_desc="";          
	String qind_group_id="";             
	String area_of_concern="";       
	String clind_type="";                   
	String standard_desc="";           
	String standard_value="";          
	String clind_class="";                 
	String incl_criteria="";              
	String dflt_rep_periodicity=""; 
	String dflt_bd_by_gender_yn=""; 
	String dflt_bd_age_range_id="";	
	String eff_status="";
	String standard_oper="";
	java.util.HashMap results=null;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

		
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			res.setContentType("text/html");
			this.out = res.getWriter();
		try	{

			session 					= req.getSession(true);
			this.facilityId = (String) session.getValue( "facility_id" ) ;
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		    this.client_ip_address = p.getProperty("client_ip_address");
			qind_clind_id		=  req.getParameter("qind_clind_id");
			if(qind_clind_id	==null || qind_clind_id.equals("") || qind_clind_id	=="")
			qind_clind_id	= "";
			qind_clind_desc		=  req.getParameter("qind_clind_desc");
			if(qind_clind_desc==null || qind_clind_desc.equals("") || qind_clind_desc=="")
			qind_clind_desc="";
			qind_group_id		=  req.getParameter("qind_group_id")==null? "":req.getParameter("qind_group_id");
			if(qind_group_id==null || qind_group_id.equals("") || qind_group_id=="")
			qind_group_id= "";
			area_of_concern		=  req.getParameter("area_of_concern");
			if(area_of_concern==null || area_of_concern.equals("") || area_of_concern=="")
			area_of_concern= "";
			clind_type		=  req.getParameter("clind_type");
			if(clind_type==null || clind_type.equals("") || clind_type=="")
			clind_type= "";
			standard_desc=  req.getParameter("standard_desc");
			if( standard_desc==null ||   standard_desc.equals("") ||  standard_desc=="")
			standard_desc= "";
			standard_value=  req.getParameter("standard_value");
			if( standard_value==null ||   standard_value.equals("") ||  standard_value=="")
			standard_value= "";
			
			standard_oper=  req.getParameter("standard_oper");
			if( standard_oper==null ||   standard_oper.equals("") ||  standard_oper=="")
			standard_oper= "";
            standard_value=standard_oper+"!"+standard_value;
			clind_class=  req.getParameter("clind_class");
			if( clind_class==null ||   clind_class.equals("") ||  clind_class=="")
			clind_class= "";
			incl_criteria=  req.getParameter("concatValues");
			if( incl_criteria==null ||   incl_criteria.equals("") || incl_criteria=="")
			incl_criteria= "";
			dflt_rep_periodicity=  req.getParameter("dflt_rep_periodicity");
			if( dflt_rep_periodicity==null ||   dflt_rep_periodicity.equals("") ||  dflt_rep_periodicity=="")
			dflt_rep_periodicity= "";
			dflt_bd_by_gender_yn=  req.getParameter("dflt_bd_by_gender_yn");
			if( dflt_bd_by_gender_yn==null ||   dflt_bd_by_gender_yn.equals("") ||  dflt_bd_by_gender_yn=="")
			dflt_bd_by_gender_yn= "N";
			dflt_bd_age_range_id=  req.getParameter("dflt_bd_age_range_id");
			if( dflt_bd_age_range_id==null ||   dflt_bd_age_range_id.equals("") ||  dflt_bd_age_range_id=="")
			dflt_bd_age_range_id= "";

			eff_status 		=  req.getParameter("eff_status");
			if(eff_status==null || eff_status.equals("") ||eff_status=="")
			eff_status	= "D";
			String retval = "0" ;
			String numerator = req.getParameter("numerator");
			if(numerator==null || numerator.equals("") ||numerator==""){ 
				numerator	= "";
			}
			String denomenator =req.getParameter("denomenator");
			if(denomenator==null || denomenator.equals("") ||denomenator==""){ 
				denomenator	= "";
			}

			  mode 						= req.getParameter("mode");
			  mode 						= (mode == null)?"":mode;

			if(mode.equalsIgnoreCase("U")){
			     modifyIndicator(res);

					/*if (numerator!=""){
							retval = ins_num_den(req, res, qind_clind_id, "80" , numerator); 
					} 
					if (denomenator!=""){
							retval = ins_num_den(req, res, qind_clind_id, "90" , denomenator); 
					} 

					if ((numerator!="")||(denomenator!="")) {
						if (retval=="0"){
//							System.err.println("Error while inserting Clinical Reference Notes "+ retval); 
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( retval ) + "&err_value=" + "Error while inserting Clinical Reference Notes " );
						}
                    }*/
			}
            else {
			 insertIndicator(res);
			}

					if (numerator!=""){
							retval = ins_num_den(req, res, qind_clind_id, "80" , numerator); 
					} 
					if (denomenator!=""){
							retval = ins_num_den(req, res, qind_clind_id, "90" , denomenator); 
					} 

					if ((numerator!="")||(denomenator!="")) {
						if (retval=="0"){
//							System.err.println("Error while inserting Clinical Reference Notes "+ retval); 
							res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( retval ) + "&err_value=" + "Error while inserting Clinical Reference Notes " );
						}
                    }
				 
		}catch(Exception e){
						out.println(e.toString());
			}
	}

 private void  insertIndicator(HttpServletResponse res){
  try{
    	String addedById			= p.getProperty( "login_user" ) ;
    	String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;
//java.sql.Date added_date	= java.sql.Date.valueOf( addedDate ) ;
//java.sql.Date modified_date	= java.sql.Date.valueOf( modifiedDate ) ;
		java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
		java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;

		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 

		HashMap tabdata=new HashMap();
				
			tabdata.put("QIND_CLIND_ID",qind_clind_id);
			tabdata.put("QIND_CLIND_DESC",qind_clind_desc);
			tabdata.put("QIND_GROUP_ID",qind_group_id);
			tabdata.put("AREA_OF_CONCERN",area_of_concern);
			tabdata.put("CLIND_TYPE",clind_type);
			tabdata.put("STANDARD_DESC",standard_desc);
			tabdata.put("STANDARD_VALUE",standard_value);
			tabdata.put("SYS_USER_CREATED","D");
			tabdata.put("CLIND_CLASS",clind_class);
            tabdata.put("INCL_CRITERIA",incl_criteria);
			tabdata.put("DFLT_REP_PERIODICITY",dflt_rep_periodicity);
			tabdata.put("DFLT_BD_BY_GENDER_YN",dflt_bd_by_gender_yn);
            tabdata.put("DFLT_BD_AGE_RANGE_ID",dflt_bd_age_range_id);
            tabdata.put("EFF_STATUS",eff_status);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",added_date);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID",facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);
						

			String dupflds[]={"QIND_CLIND_ID"};
		try{
				//InitialContext context = new InitialContext();
				//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				//final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
				//final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"QA_QIND_CLIND");
			
			String tabname="QA_QIND_CLIND";
			boolean local_ejbs = false;
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

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			   if ( inserted )
			   {
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
			   else
			   {
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
				  String error = "Error ";
				  String error_value = "0" ;
				  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  tabdata.clear();
	  results.clear();
	  
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the insertParameter

 private void  modifyIndicator(HttpServletResponse res){
  try{
		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	=client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;

	//	java.sql.Date added_date1	= java.sql.Date.valueOf( addedDate ) ;
	//	java.sql.Date added_date	= new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
		java.sql.Date modified_date1= java.sql.Date.valueOf(modifiedDate ) ;
	    java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ; 
		HashMap tabdata=new HashMap();
			tabdata.put("QIND_CLIND_ID",qind_clind_id);
			tabdata.put("QIND_CLIND_DESC",qind_clind_desc);
			tabdata.put("QIND_GROUP_ID",qind_group_id);
			tabdata.put("AREA_OF_CONCERN",area_of_concern);
			tabdata.put("CLIND_TYPE",clind_type);
			tabdata.put("STANDARD_DESC ",standard_desc);
			tabdata.put("STANDARD_VALUE ",standard_value);
			tabdata.put("CLIND_CLASS",clind_class);
            tabdata.put("INCL_CRITERIA",incl_criteria);
			tabdata.put("DFLT_REP_PERIODICITY",dflt_rep_periodicity);
			tabdata.put("DFLT_BD_BY_GENDER_YN ",dflt_bd_by_gender_yn);
            tabdata.put("DFLT_BD_AGE_RANGE_ID",dflt_bd_age_range_id);
            tabdata.put("EFF_STATUS",eff_status);

			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);

			HashMap condflds=new HashMap();
			condflds.put("qind_clind_id",qind_clind_id);
	try{
			//InitialContext context = new InitialContext();
			//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			//final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			//final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"QA_QIND_CLIND");

			String tabname="QA_QIND_CLIND";
			boolean local_ejbs = false;
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
			results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);		

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
		   if ( inserted )
		   {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		   }
		   else
		   {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		   }
		 }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );                  
	            }
	  tabdata.clear();
	  results.clear();
	  condflds.clear();
	  }catch ( Exception e )
      {
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter

private String ins_num_den(HttpServletRequest req, HttpServletResponse res, String qind_clind_id, String section_id,  String ref_note_text ){
		Connection con = null;
		PreparedStatement pstmt1 = null;
		String err_text = "";

		String addedById			= p.getProperty( "login_user" ) ;
		String addedDate			= dateFormat.format( new java.util.Date() ) ;
		String modifiedById			= addedById ;
		String modifiedDate			= addedDate ;
		String addedFacilityId		= facilityId;
		String modifiedFacilityId	= addedFacilityId ;
		String addedAtWorkstation	= client_ip_address;
		String modifiedAtWorkstation= addedAtWorkstation ;

		try
		{
			con = ConnectionManager.getConnection(req);
			String sql = "INSERT INTO QA_QIND_CLIND_REF_NOTE (QIND_CLIND_ID, SECTION_ID, REF_NOTE_TEXT ,  ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?)";
			 pstmt1=con.prepareStatement(sql);
			 pstmt1.setString(1, qind_clind_id);
			 pstmt1.setString(2, section_id);
			 pstmt1.setString(3, ref_note_text);
			 pstmt1.setString(4, addedById);
			 pstmt1.setString(5, addedAtWorkstation);
			 pstmt1.setString(6, addedFacilityId);
			 pstmt1.setString(7, modifiedById);
			 pstmt1.setString(8, modifiedAtWorkstation);
			 pstmt1.setString(9, modifiedFacilityId);

			 int flag = pstmt1.executeUpdate();
			
			if (flag > 0){
				con.commit();
				err_text = ""+flag;
			}else{	 					
				err_text = "Record not inserted for Numerator/Deneminator == "+flag;
			}
			if (pstmt1!=null){
				pstmt1.close();
			}
		}catch (Exception e ){
						err_text = e.toString();
		}finally{
				//if (pstmt1!=null){pstmt1.close()};
				if(con!=null)	ConnectionManager.returnConnection(con,req);
			
		} 
		return  err_text ;
	}


} // End of the Class

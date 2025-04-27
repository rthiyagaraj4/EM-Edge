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
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class CreateUserDesktopServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel{
	PrintWriter out;
	java.util.Properties p; 
	String client_ip_address 	;
	String facilityId ;
	String code="";
	String name="";
	String Contents_types="";
	String module_id="";
	String Function_id="";
	String effectiveStatus="";
	Connection con=null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1=null;
	PreparedStatement deletePstmt=null;
	String mode							= "";
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		
		req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");	
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		this.client_ip_address = p.getProperty("client_ip_address");
		
		mode			= req.getParameter("mode")==null?"insert":req.getParameter("mode");
		
		code=req.getParameter("Desktop_code");
		if(code==null)
			code="";
        name=req.getParameter("Desktop_name");
		if(name == null)
			name="";
       
	    Contents_types=req.getParameter("Contents_types");
		if ( Contents_types == null ) Contents_types="";
        module_id=req.getParameter("module_id");
	 	if ( module_id == null ) module_id="";
        Function_id=req.getParameter("Function_id");
		if ( Function_id == null||Function_id.equals(""))
			Function_id="OA"; //check...

		try
		 {
			res.setContentType("text/html");
			this.out = res.getWriter();

			
			if (mode.equals("insert")){
				insertCode(req, res);
			}else if(mode.equals("modify")){
				modifyCode(req, res);
			}
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

private void insertCode(HttpServletRequest req, HttpServletResponse res){
	try{
		
		ResultSet rs =null;
		
		String addedById = p.getProperty( "login_user" ) ;
	//	String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
	// String modifiedDate = addedDate ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String insertDeskDTL="";
		String row_cnt						= "";
		boolean		resulFlag	=	false;
		boolean		codeExist	=	false;
		boolean		bUpdated	=	true;
		 effectiveStatus =req.getParameter("eff_status");
		if(effectiveStatus == null )
			effectiveStatus="D";
		//	java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		// java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;	
		
		//String summaryID=req.getParameter(summaryIDCheck);

		int cont			= 0;
		row_cnt			= req.getParameter("row_count");
		if(row_cnt!= null)
				cont = Integer.parseInt(row_cnt);
		String desktop_summary_type			= "";
		String option_id					= "";
		String option_occurance				= "";
		String header_option_id				= "";
		String header_option_occurance		= "";
		String order_seq_no					= "";
		String error_value					= "";
		String error						= "";
		String locale= p.getProperty("LOCALE");

		desktop_summary_type= req.getParameter("desktop_summary_type")==null?"":req.getParameter("desktop_summary_type");


		try{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit( false );
			
			//String insertSQL="insert into sm_desktop_setup(desktop_code,desktop_name,content_type,module_id,function_id,eff_status,desktop_layout_type,navigation_panel_type,added_by_id,added_date,added_facility_id,added_at_ws_no,modified_by_id,modified_date,modified_facility_id,modified_at_ws_no) values('"+code+"','"+name+"','"+Contents_types+"','"+module_id+"','"+Function_id+"','"+effectiveStatus+"','01','01','"+addedById+"',SYSDATE,'"+facilityId+"','"+addedAtWorkstation+"','"+modifiedById+"',SYSDATE,'"+modifiedFacilityId+"','"+modifiedAtWorkstation+"')";

			
			
			//duplicate check
			
			String rec_exi_qry ="select 1 from SM_DESKTOP_SUM_HDR f where f.DESKTOP_SUMMARY_ID=? ";

			pstmt =con.prepareStatement(rec_exi_qry);

			pstmt.setString(1,code);
			

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				codeExist = true;
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(codeExist)
			{
				error = getMessage(locale, "CODE_ALREADY_EXISTS","Common");

				error_value		= "0" ;
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );

			}



			
			//duplicate check
			
			String insertSQL="INSERT INTO SM_DESKTOP_SUM_HDR(DESKTOP_SUMMARY_ID,DESKTOP_SUMMARY_NAME,DESKTOP_SUMMARY_TYPE,SYS_USER_DEF_IND,DESKTOP_LAYOUT_TYPE,NAVIGATION_PANEL_TYPE,EFF_STATUS,DFLT_CONTENT_TYPE,DFLT_MODULE_ID,DFLT_FUNCTION_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID ) values(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)";
			pstmt=con.prepareStatement(insertSQL);
			pstmt.setString(1,code.trim());
			pstmt.setString(2,name.trim());
			pstmt.setString(3,desktop_summary_type.trim());
			pstmt.setString(4,"U");
			pstmt.setString(5,"01");
			pstmt.setString(6,"01");
			pstmt.setString(7,effectiveStatus);
			pstmt.setString(8,"E");//DFLT_CONTENT_TYPE
			pstmt.setString(9,module_id);
			pstmt.setString(10,Function_id);//OA Function_id
			pstmt.setString(11,addedById);
			pstmt.setString(12,addedAtWorkstation);
			pstmt.setString(13,facilityId);
			pstmt.setString(14,modifiedById);
			pstmt.setString(15,modifiedAtWorkstation);
			pstmt.setString(16,modifiedFacilityId);
			int resCount=pstmt.executeUpdate();
			if(resCount>0)
				resulFlag=true;

			
			if(resulFlag){
				
				insertDeskDTL="INSERT INTO SM_DESKTOP_SUM_DTL (DESKTOP_SUMMARY_ID,SUMMARY_COMP_ID,HDR_SUMMARY_COMP_ID,ORDER_SEQ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SUMMARY_COMP_OCC_NUM,HDR_SUMMARY_COMP_OCC_NUM ) values (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";

				pstmt1=con.prepareStatement(insertDeskDTL);

				for(int i=0;i < cont;i++)
				{
					option_id = req.getParameter("option_id"+i);
					
					if(option_id == null)
						option_id ="";
			
					option_occurance = req.getParameter("option_occurance"+i);
					
					if(option_occurance == null)
						option_occurance ="";

					header_option_id = req.getParameter("header_option_id"+i);

					if(header_option_id == null)
						header_option_id ="";

					header_option_occurance =req.getParameter("header_option_occurance"+i);
					
					if(header_option_occurance == null)
						header_option_occurance ="";

					order_seq_no = req.getParameter("order_seq_no"+i);
					
					if(order_seq_no == null)
						order_seq_no ="";
				
				
				
					pstmt1.setString	(1,code.trim());
					pstmt1.setString	(2,option_id.trim());
					pstmt1.setString	(3,header_option_id.trim());
					pstmt1.setInt		(4,Integer.parseInt(order_seq_no.trim()));
					//pstmt1.setString	(4,header_option_id.trim());
					//pstmt1.setInt		(5,Integer.parseInt(header_option_occurance.trim()));
					//pstmt1.setInt		(6,Integer.parseInt(order_seq_no.trim()));
					pstmt1.setString	(5,addedById);
					pstmt1.setString	(6,addedAtWorkstation);
					pstmt1.setString	(7,facilityId);
					pstmt1.setString	(8,modifiedById);
					pstmt1.setString	(9,modifiedAtWorkstation);
					pstmt1.setString	(10,modifiedFacilityId);
					pstmt1.setInt		(11,Integer.parseInt(option_occurance.trim()));
					pstmt1.setInt		(12,Integer.parseInt(header_option_occurance.trim()));

					pstmt1.addBatch();
				
				}

				int [] nInsStatus = pstmt1.executeBatch();
				
				if(nInsStatus.length == -3 || nInsStatus.length <  cont)
					bUpdated = false;

			}
				
				
				if(bUpdated)
				{
					con.commit();
					error_value			= "1" ;
					error				= getMessage(locale, "RECORD_INSERTED","CA");
				}
				else
				{
					con.rollback();
					error_value			= "0" ;
					error				= getMessage(locale, "FAILED_TRANSACTION","CA");
				}
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );				
			
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
		
		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,p);
		}
	}catch(Exception e){
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			e.printStackTrace();
	}
}
private void modifyCode(HttpServletRequest req, HttpServletResponse res){
		
	
	try{	
	
		String addedById = p.getProperty( "login_user" ) ;
	//	String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
	// String modifiedDate = addedDate ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String insertDeskDTL="";
		String row_cnt						= "";
	//	boolean		resulFlag	=	false;
//		boolean		codeExist	=	false;
		boolean		bUpdated	=	true;
		 effectiveStatus =req.getParameter("eff_status");
		if(effectiveStatus == null )
			effectiveStatus="D";

		int cont			= 0;
		row_cnt			= req.getParameter("row_count");
		if(row_cnt!= null)
				cont = Integer.parseInt(row_cnt);
		String desktop_summary_type			= "";
		String option_id					= "";
		String option_occurance				= "";
		String header_option_id				= "";
		String header_option_occurance		= "";
		String order_seq_no					= "";
		String error_value					= "";
		String error						= "";
		String locale= p.getProperty("LOCALE");

		desktop_summary_type= req.getParameter("desktop_summary_type")==null?"":req.getParameter("desktop_summary_type");


		try{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit( false );
			
			

			
			
			//duplicate check
			
			String rec_exi_qry =" delete from  SM_DESKTOP_SUM_DTL where DESKTOP_SUMMARY_ID=? ";

			pstmt =con.prepareStatement(rec_exi_qry);

			pstmt.setString(1,code);
			
			pstmt.executeUpdate();
			//rs = pstmt.executeQuery();
			
		
			if(pstmt != null) pstmt.close();

			
			
			
			//if(resulFlag){
				
				insertDeskDTL="INSERT INTO SM_DESKTOP_SUM_DTL (DESKTOP_SUMMARY_ID,SUMMARY_COMP_ID,HDR_SUMMARY_COMP_ID,ORDER_SEQ,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SUMMARY_COMP_OCC_NUM,HDR_SUMMARY_COMP_OCC_NUM ) values (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?)";

				pstmt1=con.prepareStatement(insertDeskDTL);

				for(int i=0;i < cont;i++)
				{
					option_id = req.getParameter("option_id"+i);
					
					if(option_id == null)
						option_id ="";
			
					option_occurance = req.getParameter("option_occurance"+i);
					
					if(option_occurance == null)
						option_occurance ="";

					header_option_id = req.getParameter("header_option_id"+i);

					if(header_option_id == null)
						header_option_id ="";

					header_option_occurance =req.getParameter("header_option_occurance"+i);
					
					if(header_option_occurance == null)
						header_option_occurance ="";

					order_seq_no = req.getParameter("order_seq_no"+i);
					
					if(order_seq_no == null)
						order_seq_no ="";

				
				
					
					pstmt1.setString	(1,code.trim());
					pstmt1.setString	(2,option_id.trim());
					pstmt1.setString	(3,header_option_id.trim());
					pstmt1.setInt		(4,Integer.parseInt(order_seq_no.trim()));
					//pstmt1.setString	(4,header_option_id.trim());
					//pstmt1.setInt		(5,Integer.parseInt(header_option_occurance.trim()));
					//pstmt1.setInt		(6,Integer.parseInt(order_seq_no.trim()));
					pstmt1.setString	(5,addedById);
					pstmt1.setString	(6,addedAtWorkstation);
					pstmt1.setString	(7,facilityId);
					pstmt1.setString	(8,modifiedById);
					pstmt1.setString	(9,modifiedAtWorkstation);
					pstmt1.setString	(10,modifiedFacilityId);
					pstmt1.setInt		(11,Integer.parseInt(option_occurance.trim()));
					pstmt1.setInt		(12,Integer.parseInt(header_option_occurance.trim()));

					pstmt1.addBatch();
				
				}

				int [] nInsStatus = pstmt1.executeBatch();
				
				if(nInsStatus.length == -3 || nInsStatus.length <  cont)
					bUpdated = false;
				
			//}
				
				
				if(bUpdated)
				{
					con.commit();
					error_value			= "1" ;
					error				= getMessage(locale, "RECORD_INSERTED","CA");
				}
				else
				{
					con.rollback();
					error_value			= "0" ;
					error				= getMessage(locale, "FAILED_TRANSACTION","CA");
				}
				
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );			

			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
		
		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,p);
		}
	}catch(Exception e){
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;//common-icn-0181
			e.printStackTrace();
	}
	
	
	
	
	/*	
		try{
		String addedById = p.getProperty( "login_user" ) ;
	//	String addedDate = dateFormat.format( new java.util.Date() ) ;
		String modifiedById = addedById ;
		//String modifiedDate = addedDate ;
		String addedFacilityId=facilityId;
		String modifiedFacilityId = addedFacilityId ;
		String addedAtWorkstation=client_ip_address;
		String modifiedAtWorkstation = addedAtWorkstation ;
		String insertDeskDTL="";
		boolean resulFlag=false;
		 effectiveStatus =req.getParameter("eff_status");
		if(effectiveStatus == null )
			effectiveStatus="D";
		int max_record=Integer.parseInt(req.getParameter("max_record")==null?"0":req.getParameter("max_record"));
		//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
		//ava.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;			
		try{
			con=ConnectionManager.getConnection(req);
			con.setAutoCommit( false );
			String updateSQL="update sm_desktop_setup set desktop_name='"+name+"',content_type='"+Contents_types+"',module_id='"+module_id+"',function_id='"+Function_id+"',eff_status='"+effectiveStatus+"',modified_by_id='"+modifiedById+"',modified_date=SYSDATE,modified_facility_id='"+modifiedFacilityId+"',modified_at_ws_no='"+modifiedAtWorkstation+"' where DESKTOP_CODE='"+code+"' ";
			
			pstmt=con.prepareStatement(updateSQL);
			int resCount=pstmt.executeUpdate();
			if(resCount>0)
				resulFlag=true;
			if(resulFlag){
				String deleteSQL="delete from SM_DESKTOP_SETUP_DTL where  DESKTOP_CODE='"+code+"'";
				deletePstmt=con.prepareStatement(deleteSQL);
				try{
					int deleteCount=deletePstmt.executeUpdate();
					resulFlag=true;
				}catch(Exception excp){
					excp.printStackTrace();
					resulFlag=false;
				}
				for(int count=0;count<max_record;count++){
					if(resulFlag){
						String check1="chk"+(new Integer(count)).toString();
						String summaryIDCheck="summaryID"+(new Integer(count)).toString();
						//if((req.getParameter(check)).equals("Y"))
						String check=req.getParameter(check1);
						if(check!=null && check.equals("Y")){
							insertDeskDTL="";
							String summaryID=req.getParameter(summaryIDCheck);
							insertDeskDTL="insert into SM_DESKTOP_SETUP_DTL(DESKTOP_CODE,DESKTOP_SUMMARY_ID,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO)values('"+code+"','"+summaryID+"','"+addedById+"',SYSDATE,'"+addedAtWorkstation+"','"+facilityId+"','"+modifiedById+"',SYSDATE,'"+modifiedFacilityId+"','"+modifiedAtWorkstation+"')";
			

							pstmt1=con.prepareStatement(insertDeskDTL);
							int insCount=pstmt1.executeUpdate();
							if(insCount>0){
								resulFlag=true;
							}else{
								resulFlag=false;
							}
						}
					}else{
						break;
					}
	if(pstmt1!=null)pstmt1.close();
				}
			}
			if(resulFlag){
				con.commit();
				String locale= p.getProperty("LOCALE");
				Hashtable hashtable1 = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				String err_num = (String)hashtable1.get("message");
				hashtable1.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode(err_num,"UTF-8" ) + "&err_value=1" );
			}else{
				con.rollback();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode("Exception Occured","UTF-8" ) + "&err_value=1" );
			}
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(deletePstmt!=null)deletePstmt.close();
		}catch(Exception ex){
			
			ex.printStackTrace();
		}finally{
			ConnectionManager.returnConnection(con,p);
		}
	}catch(Exception e){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			e.printStackTrace();
	}

*/
}

private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

}

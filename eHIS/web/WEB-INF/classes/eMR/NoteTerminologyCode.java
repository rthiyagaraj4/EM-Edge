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
import java.text.*;
import webbeans.eCommon.*;


 public class NoteTerminologyCode extends HttpServlet
 {
	PrintWriter out;
	String client_ip_addr	= "";
	String facilityId		= "" ;
	String addedId			= "";
	String mode				= "";
	HttpSession session; 
	Properties p;
		
	Connection conn		= null;
	PreparedStatement pstmt_hdr=null,pstmt_dtl=null,pstmt_dupchk=null,pstmt_dupchk_dtl=null;
	ResultSet rs	= null, rsDtl = null;
	String locale ="";
	public synchronized void init(ServletConfig config) throws ServletException
	{
			 super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		session			= req.getSession(false);
		this.p			= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		client_ip_addr  = this.p.getProperty("client_ip_address");
		try{
			req.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			this.out = response.getWriter();
			mode =req.getParameter("mode") == null ? "" :  req.getParameter("mode");
			if(mode.equals("insert")|| mode.equals("1")){
				insert(req,response);
			}else if(mode.equals("modify")|| mode.equals("2")){
				modify(req,response);
			}
		
		} catch(Exception e) {
			out.println("Exception in dopost Block : "+e.toString());
			e.printStackTrace();
		}

	}
	private void insert(HttpServletRequest req,HttpServletResponse response)		
	{
		this.p			= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		client_ip_addr	= this.p.getProperty("client_ip_address");
		addedId			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
		
		try
        {
			conn = ConnectionManager.getConnection(req);
			
			pstmt_hdr = conn.prepareStatement("insert into MR_TERM_FOR_NOTE_TYPE_HDR(SERVICE_CODE, NOTE_TYPE, TERM_SET_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
			pstmt_dtl = conn.prepareStatement("insert into MR_TERM_FOR_NOTE_TYPE_DTL(SERVICE_CODE, NOTE_TYPE, TERM_SET_ID, TERM_CODE, CODE_LEVEL, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
			pstmt_dupchk = conn.prepareStatement("select count(*) from MR_TERM_FOR_NOTE_TYPE_HDR where SERVICE_CODE like upper(?) and NOTE_TYPE like upper(?) and TERM_SET_ID like upper(?)");

			
			pstmt_dupchk_dtl = conn.prepareStatement("select count(*) from MR_TERM_FOR_NOTE_TYPE_DTL where NOTE_TYPE = upper(?) and TERM_SET_ID = upper(?) and Term_Code = upper(?) and CODE_LEVEL = ?");
			
			

			String service_code	= req.getParameter("service_code") == null ? "" :  req.getParameter("service_code");
			String note_type	= req.getParameter("proc_code") == null ? "" :  req.getParameter("proc_code");
			String term_set_id	= req.getParameter("term_set_id") == null ? "" :  req.getParameter("term_set_id");
			int totalRecords	= req.getParameter("totalRecords") == null ? 0 :  Integer.parseInt(req.getParameter("totalRecords"));


			
			String term_code	= "",tmp_term_code="";
			String code_level	= "",tmp_code_level="";
			//String code_chk		= "";
			String tmp_chk		= "";
			int count=0,cnt=0;
			String msg = "",error_val="",dup_msg="";
			StringBuffer sb_dup_msg = new StringBuffer();
			
			pstmt_dupchk.setString(1,service_code);
			pstmt_dupchk.setString(2,note_type);
			pstmt_dupchk.setString(3,term_set_id);
			rs = pstmt_dupchk.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
				}
			if (rs != null)rs.close();
			if(pstmt_dupchk != null)pstmt_dupchk.close();
			
			pstmt_dupchk_dtl.setString(1,note_type);
			pstmt_dupchk_dtl.setString(2,term_set_id);

			for(int i=0;i<totalRecords;i++){
			tmp_chk = req.getParameter("term_chk"+i) == null?"":req.getParameter("term_chk"+i);
					if(tmp_chk.equals("Y")){
						term_code = req.getParameter("term_code"+i) == null?"":req.getParameter("term_code"+i);
						code_level = req.getParameter("code_level"+i) == null?"":req.getParameter("code_level"+i);
						tmp_term_code = "'"+term_code+"',";
						tmp_code_level = "'"+code_level+"',";
					}
			}
			if(tmp_term_code.length() >0){
				tmp_term_code=tmp_term_code.substring(0,tmp_term_code.length()-1);
				tmp_code_level=tmp_code_level.substring(0,tmp_code_level.length()-1);
			}else{
				tmp_term_code= "''";
				tmp_code_level= "''";
			}
			pstmt_dupchk = conn.prepareStatement("select e.SHORT_DESC description from MR_TERM_FOR_NOTE_TYPE_DTL a,mr_term_code e where service_code like upper(?) and note_type like upper(?) and a.term_set_id like upper(?) and e.term_code = a.term_code and a.term_code in ("+tmp_term_code+") and a.code_level in ("+tmp_code_level+") union select 'All' description from MR_TERM_FOR_NOTE_TYPE_DTL a,mr_term_code e where service_code like upper(?) and note_type like upper(?) and a.term_set_id like upper(?) and a.term_code like upper('*ALL') and a.code_level in ("+tmp_code_level+") order by 1");
			/*pstmt_dupchk.setString(1,service_code);
			pstmt_dupchk.setString(2,note_type);
			pstmt_dupchk.setString(3,term_set_id);
			pstmt_dupchk.setString(4,tmp_term_code);
			pstmt_dupchk.setString(5,tmp_code_level);
			pstmt_dupchk.setString(6,service_code);
			pstmt_dupchk.setString(7,note_type);
			pstmt_dupchk.setString(8,term_set_id);
			pstmt_dupchk.setString(9,tmp_code_level);*/
			pstmt_dupchk.setString(1,service_code);
			pstmt_dupchk.setString(2,note_type);
			pstmt_dupchk.setString(3,term_set_id);
			pstmt_dupchk.setString(4,service_code);
			pstmt_dupchk.setString(5,note_type);
			pstmt_dupchk.setString(6,term_set_id);
			rs = pstmt_dupchk.executeQuery();
			
			while(rs.next()){
				sb_dup_msg.append(rs.getString(1));
				
				//dup_msg += rs.getString(1)+",";
			}

			if(rs != null)rs.close();

			
			dup_msg = sb_dup_msg.toString();
			if(count == 0 && dup_msg.equals("")){
				pstmt_hdr.setString(1,service_code);
				pstmt_hdr.setString(2,note_type);
				pstmt_hdr.setString(3,term_set_id);
				pstmt_hdr.setString(4,addedId);
				pstmt_hdr.setString(5,client_ip_addr);
				pstmt_hdr.setString(6,facilityId);
				pstmt_hdr.setString(7,addedId);
				pstmt_hdr.setString(8,client_ip_addr);
				pstmt_hdr.setString(9,facilityId);
				int result_update = pstmt_hdr.executeUpdate();

				for(int i=0;i<totalRecords;i++){
//<-- Added by Vinod 9/14/2005
					term_code = req.getParameter("term_code"+i) == null?"":req.getParameter("term_code"+i);
					code_level = req.getParameter("code_level"+i) == null?"":req.getParameter("code_level"+i);
					pstmt_dupchk_dtl.setString(3,term_code);
					pstmt_dupchk_dtl.setString(4,code_level);

					rsDtl = pstmt_dupchk_dtl.executeQuery();
						if(rsDtl.next()){
						//cnt = rsDtl.getInt(1);
						cnt = 0; 
					}
					tmp_chk = req.getParameter("term_chk"+i) == null?"":req.getParameter("term_chk"+i);
					if ( rsDtl != null)
					{
						rsDtl.close();
					}
					if ( (cnt>0) && (tmp_chk.equals("Y")) ) // If the record is cheked and duplicate then only break.
					{
						break;
					} 
//Vinod 9/14/2005 -->					
					if ( tmp_chk.equals("Y") ){
						term_code = req.getParameter("term_code"+i) == null?"":req.getParameter("term_code"+i);
						code_level = req.getParameter("code_level"+i) == null?"":req.getParameter("code_level"+i);
						pstmt_dtl.setString(1,service_code);
						pstmt_dtl.setString(2,note_type);
						pstmt_dtl.setString(3,term_set_id);
						pstmt_dtl.setString(4,term_code);
						pstmt_dtl.setString(5,code_level);
						pstmt_dtl.setString(6,addedId);
						pstmt_dtl.setString(7,client_ip_addr);
						pstmt_dtl.setString(8,facilityId);
						pstmt_dtl.setString(9,addedId);
						pstmt_dtl.setString(10,client_ip_addr);
						pstmt_dtl.setString(11,facilityId);
						pstmt_dtl.addBatch();
					}
					}
				if (cnt>0)
				{
					conn.rollback();
					msg = "APP-MR0048 Duplicate Term Code : "+term_code;error_val="0";
				}
				else{
					int result_update1[] = pstmt_dtl.executeBatch();
					if(result_update >0 && result_update1.length>0){
						conn.commit();
						
						java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
						msg = (String) message.get("message");

					}else{
						conn.rollback();
						msg = "Operation Failed";error_val="0";
					}
				}
			}else{
				error_val = "0";

				if(dup_msg.length() >0){
					dup_msg = dup_msg.substring(0,dup_msg.length()-1);
					msg = "APP-SM0095 Record Already Exists : "+dup_msg;
				}else
					msg = "APP-SM0095 Record Already Exists...";
			}

			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=" + error_val);
			
		}catch(Exception e){
		//System.err.println("Error while inserting the values=="+e.toString());
		e.printStackTrace();
		}finally{
			try{
			if(conn != null) ConnectionManager.returnConnection(conn,req);
			if(rs != null)rs.close();
			if(pstmt_dupchk != null)pstmt_dupchk.close();
			if(pstmt_dupchk_dtl != null)pstmt_dupchk_dtl.close();
			if(pstmt_hdr != null)pstmt_hdr.close();
			if(pstmt_dtl != null)pstmt_dtl.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}


	private void modify(HttpServletRequest req,HttpServletResponse response)	
	{
		this.p			= (java.util.Properties) session.getAttribute( "jdbc" ) ;
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		client_ip_addr	= this.p.getProperty("client_ip_address");
		addedId			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;    
		
		PreparedStatement pstmt_del_hdr = null,pstmt_del_dtl=null;
		try
        {
			conn = ConnectionManager.getConnection(req);
           /* Modified by vinod - 05/09/2005 Query changed for deleting only one record - removed 'Like' and replaced with '=' */
			pstmt_del_hdr=conn.prepareStatement("delete from MR_TERM_FOR_NOTE_TYPE_HDR where  upper(SERVICE_CODE) = upper(?) and  upper(NOTE_TYPE) = upper(?) and   upper(TERM_SET_ID) = upper(?)");
			pstmt_del_dtl=conn.prepareStatement("delete from MR_TERM_FOR_NOTE_TYPE_DTL where  upper(SERVICE_CODE) = upper(?) and  upper(NOTE_TYPE) = upper(?) and  upper(TERM_SET_ID) = upper(?) ");
			pstmt_hdr = conn.prepareStatement("insert into MR_TERM_FOR_NOTE_TYPE_HDR(SERVICE_CODE, NOTE_TYPE, TERM_SET_ID, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
			pstmt_dtl = conn.prepareStatement("insert into MR_TERM_FOR_NOTE_TYPE_DTL(SERVICE_CODE, NOTE_TYPE, TERM_SET_ID, TERM_CODE, CODE_LEVEL, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?) ");
			pstmt_dupchk_dtl = conn.prepareStatement("select count(*) from MR_TERM_FOR_NOTE_TYPE_DTL where NOTE_TYPE = upper(?) and TERM_SET_ID = upper(?) and Term_Code = upper(?) and CODE_LEVEL = ?");
					
			String service_code=req.getParameter("service_code") == null ? "" :  req.getParameter("service_code");

			

			String note_type =req.getParameter("proc_code") == null ? "" :  req.getParameter("proc_code");
			String term_set_id=req.getParameter("term_set_id") == null ? "" :  req.getParameter("term_set_id");

			
			int totalRecords=req.getParameter("totalRecords") == null ? 0 :  Integer.parseInt(req.getParameter("totalRecords"));
			String term_code	= "";
			String code_level	= "";
			//String code_chk		= "";
			String tmp_chk		= "";
			String msg = "",error_val="";
			int cnt=0;
			boolean flag = false;

			pstmt_del_dtl.setString(1,service_code);
			pstmt_del_dtl.setString(2,note_type);
			pstmt_del_dtl.setString(3,term_set_id);
			try{
			pstmt_del_dtl.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			pstmt_del_hdr.setString(1,service_code);
			pstmt_del_hdr.setString(2,note_type);
			pstmt_del_hdr.setString(3,term_set_id);
			try{
			pstmt_del_hdr.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			pstmt_hdr.setString(1,service_code);
			pstmt_hdr.setString(2,note_type);
			pstmt_hdr.setString(3,term_set_id);
			pstmt_hdr.setString(4,addedId);
			pstmt_hdr.setString(5,client_ip_addr);
			pstmt_hdr.setString(6,facilityId);
			pstmt_hdr.setString(7,addedId);
			pstmt_hdr.setString(8,client_ip_addr);
			pstmt_hdr.setString(9,facilityId);

			int result_update = pstmt_hdr.executeUpdate();

			pstmt_dupchk_dtl.setString(1,note_type);
			pstmt_dupchk_dtl.setString(2,term_set_id);
			for(int i=0;i<totalRecords;i++){
				term_code = req.getParameter("term_code"+i) == null?"":req.getParameter("term_code"+i);
				code_level = req.getParameter("code_level"+i) == null?"":req.getParameter("code_level"+i);
				pstmt_dupchk_dtl.setString(3,term_code);
				pstmt_dupchk_dtl.setString(4,code_level);
				rsDtl = pstmt_dupchk_dtl.executeQuery();
				if(rsDtl.next()){
					cnt = rsDtl.getInt(1);
				}
				if ( rsDtl != null)
				{
					rsDtl.close();
				}
				tmp_chk = req.getParameter("term_chk"+i) == null?"":req.getParameter("term_chk"+i);
				
				if ( (cnt>0) && (tmp_chk.equals("Y")) ) // If the record is cheked and duplicate then only break.
					{
						flag = true;
						break;
					} 

				if(tmp_chk.equals("Y")){
				code_level = req.getParameter("code_level"+i) == null?"":req.getParameter("code_level"+i);
				pstmt_dtl.setString(1,service_code);
				pstmt_dtl.setString(2,note_type);
				pstmt_dtl.setString(3,term_set_id);
				pstmt_dtl.setString(4,term_code);
				pstmt_dtl.setString(5,code_level);
				pstmt_dtl.setString(6,addedId);
				pstmt_dtl.setString(7,client_ip_addr);
				pstmt_dtl.setString(8,facilityId);
				pstmt_dtl.setString(9,addedId);
				pstmt_dtl.setString(10,client_ip_addr);
				pstmt_dtl.setString(11,facilityId);
				//result_update = pstmt_dtl.executeUpdate();
				pstmt_dtl.addBatch();
				}
			}
			if( (cnt >0) && (flag == true) )
			{
				conn.rollback();
				msg = "APP-MR0048 Duplicate Term Code : "+term_code;error_val="0";			
			}
			else {
				int result_update1[] = pstmt_dtl.executeBatch();
			
				if(result_update >0 && result_update1.length>0){
					conn.commit();					
					java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message.get("message");

				}else{
					conn.rollback();
					msg = "Operation Failed while updating";error_val="0";
				}
			}		
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg,"UTF-8") + "&err_value=" + error_val);
		}catch(Exception e){
			//System.err.println("Error while inserting the values=="+e.toString());
			e.printStackTrace();

		}finally{
			try{
			if(conn != null) ConnectionManager.returnConnection(conn,req);
			if(pstmt_del_hdr != null)pstmt_del_hdr.close();
			if(pstmt_del_dtl != null)pstmt_del_dtl.close();
			if(pstmt_dupchk_dtl != null)pstmt_dupchk_dtl.close();
			if(pstmt_hdr != null)pstmt_hdr.close();
			if(pstmt_dtl != null)pstmt_dtl.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
 }

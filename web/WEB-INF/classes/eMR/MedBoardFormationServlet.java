/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* @Module		: Medical Records..[MR]
* @Author		: DEEPA S 
* @Created on	: 30 MARCH 2005
* @Function		: Servlet to insert and modify the values for  MEDICAL BOARD FORMATION function...
*/

package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

public class MedBoardFormationServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	RecordSet Record;

	Connection          con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_slno = null;
	ResultSet rs_slno = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1	= null;

	String facilityId			= "";
	String client_ip_address	= "";
	String addedById			= "";
	String addedDate			= "";
	String addedAtWorkstation	= "";
	String addedFacilityId		= "";
	String modifiedById			= "";
	String modifiedAtWorkstation= "";
	String bean_record ="";
	String appt_date ="";
	String user_type ="";
	String user ="";
	String role ="";
	String pract_id ="";
	String request_id ="";
	String medical_board ="";
	String check ="";
	String formation_status ="";
	String locale="";

	int srl_no = 0;
	int incr = 0; 
	int insert_chk=0;
	int rec_count = 0;
	int count = 0;
	int RecordCount = 0;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doGet(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		session = req.getSession(false);
		this.p = (Properties)session.getValue("jdbc") ;
		this.facilityId = (String)session.getValue( "facility_id" ) ;
		
		client_ip_address = this.p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate = dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (this.facilityId == null)?"":this.facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
		modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
		modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;      

		Record = (RecordSet)session.getValue("MedBoardReqFormBean");
		boolean result=true;
		String error="";
		StringBuffer strBuff = new StringBuffer();
		try
		{
			con = ConnectionManager.getConnection(req);
			con.setAutoCommit(false);
			String req_id = req.getParameter("request_id")==null?"":req.getParameter("request_id");
			formation_status = req.getParameter("formation_status");
			if(formation_status == null  || formation_status.equals(""))
			formation_status = "1";// Incomplete
			if(addedById == null) 	addedById="";
			if(addedDate == null)	addedDate="";
			if(facilityId == null )		facilityId="";
			if(addedFacilityId == null )	addedFacilityId="";
			if(addedAtWorkstation == null)	addedAtWorkstation="";
			if(modifiedById == null)		modifiedById="";
			if(modifiedAtWorkstation == null ) 	modifiedAtWorkstation="";
			//SQL for Getting Srl_no....
			if(strBuff.length() > 0) strBuff.delete(0,strBuff.length());
			strBuff.append("select nvl(max(srl_no),0)+1 srl_no from MR_MED_BOARD_MEMBER where ");
			strBuff.append("FACILITY_ID=? and REQUEST_ID=? and MEDICAL_BOARD_CODE=? "); 
			pstmt_slno = con.prepareStatement(strBuff.toString()) ;
			String selectSql = " select count(*) from MR_MED_BOARD_MEMBER where request_id='"+req_id+"' and facility_id='"+facilityId+"' ";
			stmt = con.createStatement();
			rs	=	stmt.executeQuery(selectSql);
			if (rs.next() && rs != null)
			{
				RecordCount = rs.getInt(1);
			}

			if(RecordCount >0)
			{
				if(rs !=null) rs.close();
				String deleteSql = " delete from MR_MED_BOARD_MEMBER where request_id='"+req_id+"' and facility_id='"+facilityId+"' ";
				int del	= stmt.executeUpdate(deleteSql);
				if(del == 0){	}
			}

			if(stmt != null) stmt.close();

			//Sql for Insert record into MR_MED_BOARD_MEMBER table....
			StringBuffer strBuff1=new StringBuffer();
			if(strBuff1.length() > 0) strBuff1.delete(0,strBuff1.length());
			strBuff1.append("insert into MR_MED_BOARD_MEMBER (FACILITY_ID,REQUEST_ID"); strBuff1.append(",MEDICAL_BOARD_CODE,SRL_NO,PRACT_TYPE,USER_PRACT_YN,PRACTITIONER_ID");
			strBuff1.append(",ROLE,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID"); strBuff1.append(",MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) ");
			strBuff1.append(" values (?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ");
			pstmt	=	con.prepareStatement(strBuff1.toString());
			rec_count = Record.getSize();
			if(	rec_count > 0 )
			{
				for(int j=0;j<rec_count;j++)
				{
					bean_record = (String)Record.getObject(j);
					StringTokenizer split_rec = new StringTokenizer(bean_record,"~");
					while(split_rec.hasMoreTokens())
					{
						user_type	= split_rec.nextToken();
						user		= split_rec.nextToken();
						pract_id	= split_rec.nextToken();
						split_rec.nextToken();
						role		= split_rec.nextToken();
						check		= split_rec.nextToken();
						appt_date	= split_rec.nextToken();
						
						if  (appt_date.equals("") || appt_date.equals(" "))
						appt_date = "";
						request_id	= split_rec.nextToken();
						medical_board= split_rec.nextToken();

						if(check.equals("Checked"))
						{
							pstmt_slno.setString( 1, addedFacilityId);
							pstmt_slno.setString( 2, request_id) ;
							pstmt_slno.setString( 3, medical_board);
							try
							{
								rs_slno = pstmt_slno.executeQuery();
								while(rs_slno.next())
								{
									srl_no = rs_slno.getInt("srl_no");
								}
								if(rs_slno != null) rs_slno.close();
								pstmt.clearParameters();
							}catch(Exception e)
							{
							e.printStackTrace();
							error+=e.getMessage();
							con.rollback();	
							result=false;
							}
						}

						if(check.equals("Checked") && result)
						{
							pstmt.setString(1,addedFacilityId);
							pstmt.setString(2,request_id);
							pstmt.setString(3,medical_board);
							pstmt.setInt(4,srl_no);
							pstmt.setString(5,user_type);
							pstmt.setString(6,user);
							pstmt.setString(7,pract_id);
							pstmt.setString(8,role);
							pstmt.setString(9,addedById);
							pstmt.setString(10,addedAtWorkstation);
							pstmt.setString(11,addedFacilityId);
							pstmt.setString(12,modifiedById);
							pstmt.setString(13,modifiedAtWorkstation);
							pstmt.setString(14,addedFacilityId);
							try
							{
								insert_chk+= pstmt.executeUpdate();
								incr++;
							}
							catch(Exception e1)
							{
								e1.printStackTrace();
								error+=e1.getMessage();
								con.rollback();	
								result=false;
							}
						}
					}
				}
				if(result)
				{
					strBuff.delete(0,strBuff.length());
					if(formation_status.equals("1")) // incomplete - dont update Request Status..
					{
						strBuff.append(" update MR_REPORT_REQUEST_HDR set ");
						strBuff.append(" APPT_DATE =to_date(?,'dd/mm/yyyy') ,MODIFIED_BY_ID =? ,MODIFIED_DATE= SYSDATE,MODIFIED_AT_WS_NO= ? ,MODIFIED_FACILITY_ID = ? ");
						strBuff.append(" where REQUEST_ID = ? ");
						pstmt1 = con.prepareStatement(strBuff.toString());	
						pstmt1.setString(1,appt_date);
						pstmt1.setString(2,modifiedById);
						pstmt1.setString(3,modifiedAtWorkstation);
						pstmt1.setString(4,addedFacilityId);
						pstmt1.setString(5,request_id);
					}
					else
					{
						strBuff.append(" update MR_REPORT_REQUEST_HDR set ");
						strBuff.append(" APPT_DATE =to_date(?,'dd/mm/yyyy'), ");
						strBuff.append(" REQUEST_STATUS = ? ,MODIFIED_BY_ID =? ,MODIFIED_DATE= SYSDATE,MODIFIED_AT_WS_NO= ? ,MODIFIED_FACILITY_ID = ? where REQUEST_ID = ? ");
						pstmt1 = con.prepareStatement(strBuff.toString());	
						pstmt1.setString(1,appt_date);
						pstmt1.setString(2,"3");
						pstmt1.setString(3,modifiedById);
						pstmt1.setString(4,modifiedAtWorkstation);
						pstmt1.setString(5,addedFacilityId);
						pstmt1.setString(6,request_id);
					}
					try
					{
						count+= pstmt1.executeUpdate(); 
					}
					catch(Exception e2)
					{
						e2.printStackTrace();
						error+=e2.getMessage();
						con.rollback();	
						result=false;
					}
					pstmt1.close();
				}
			}

			if(pstmt != null) pstmt.close();
			if(pstmt_slno != null) pstmt_slno.close();
			if(result)
			{
				java.util.Hashtable message = MessageManager.getMessage( locale, "RECORD_INSERTED","SM" ) ;
				error = (String) message.get("message") ;
				//error = error.substring(0,error.indexOf("<br>")) ;
				con.commit();
				if ( message != null ) message.clear();
			}
			else
			{
				con.rollback();	
			}
			out.println("<script>alert(\""+error+"\");parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();</script>");
		}
		catch ( Exception e )
		{
			try
			{
				con.rollback();
			}
			catch(Exception ex)
			{
				//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+ex.toString());
				ex.printStackTrace();
			}
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally
		{
			try
			{				
				if(pstmt!=null)pstmt.close();
				ConnectionManager.returnConnection(con, req);
			}catch(Exception ei)
			{ 
				//out.println(ei.toString());
				ei.printStackTrace();				
			}
		}
	}
}

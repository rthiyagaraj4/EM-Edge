/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Modified By		: NANDA KUMAR R.
Modified Date	: 21/04/2002
*/
package eSM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
public class ResponsibilityForUserServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
PrintWriter out;
java.util.Properties p;
String userid;
String s20 = "";
String err_value="0";
String  facility ;
String locale="";
String remarks;
PreparedStatement pslPrepStmt1=null;
PreparedStatement pslPrepStmt2=null;
PreparedStatement  pslPrepStmt=null;
Statement stmt				 = null;
Statement stmt1				 = null;
String facilityId ;
String client_ip_address ;
String objectName;
Connection con ;
String insert_vals="";
String update_vals="";
String delete_vals="";
String respID="";
	HttpSession session;
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			con = ConnectionManager.getConnection(req);
			insertFacility(req, res);


			pslPrepStmt1=null; 
			pslPrepStmt2=null;
			pslPrepStmt=null;
			out = null;
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	finally
		{
			ConnectionManager.returnConnection(con, req);
		}

	}
	private void insertFacility(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			userid=req.getParameter("userID");
			objectName=req.getParameter("objname");
			String addedById = p.getProperty( "login_user" ) ;
	
		/*	HashMap tabdata=new HashMap();
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );*/
            String checkedFromDate="",checkedToDate=""  ;          

			int ilStatus =0 ;
			int ilStatus1 =0 ;
			int ilStatus2 =0 ;
            String	from	=	"",	to		=	"";
            from		=	(req.getParameter("from")==null)	?	"0"	:	req.getParameter("from");
            to			=	(req.getParameter("to")==null)		?	"0"	:	req.getParameter("to");
			insert_vals = req.getParameter("insert_vals");
			update_vals = req.getParameter("update_vals");
			delete_vals = req.getParameter("delete_vals");
			String i="";
			System.out.println(" ************************ ResponsibilityForUserServlet objectName : "+objectName);
			if(objectName.equals("User"))
			{
				if(!insert_vals.equals(""))
				{
					StringTokenizer insToken = new StringTokenizer(insert_vals, "~");
					String sql="insert into sm_resp_for_user (APPL_USER_ID ,RESP_ID,EFF_DATE_FROM,EFF_DATE_TO,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,sysdate,?)";
					pslPrepStmt = con.prepareStatement(sql);
					while(insToken.hasMoreTokens())
					{
						i = insToken.nextToken();
						respID = (req.getParameter("respID"+i)==null)	?	""	:	req.getParameter("respID"+i);
						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
												
						pslPrepStmt.setString(1,userid);
						pslPrepStmt.setString(2,respID);
						pslPrepStmt.setString(3,checkedFromDate);
						pslPrepStmt.setString(4,checkedToDate);
						pslPrepStmt.setString(5,addedById);
						pslPrepStmt.setString(6,client_ip_address);
						pslPrepStmt.setString(7,addedById);
						pslPrepStmt.setString(8,client_ip_address);
						ilStatus = pslPrepStmt.executeUpdate();
	
						 
						if(!(ilStatus >=1))
						{
							break;
						}
					}
					if(pslPrepStmt!=null) pslPrepStmt.close();
				}
				
				if(!delete_vals.equals(""))
				{
					StringBuffer sblQry = new StringBuffer();
					StringBuffer sblQry1 = new StringBuffer();
					StringTokenizer insToken = new StringTokenizer(delete_vals, "~");
					String ids_to_delete = "(";
					int k=0;
					stmt1 = con.createStatement();
					stmt = con.createStatement();
					while(insToken.hasMoreTokens())
					{
						if(k != 0)
							ids_to_delete = ids_to_delete +",";
						i = insToken.nextToken();
						
						ids_to_delete =ids_to_delete+ "'"+i+"'";
						k++;
					}
					ids_to_delete = ids_to_delete +")";
					
					sblQry.append("delete from SM_FREQ_FUNC_BY_USER where APPL_USER_ID ='"+userid+"' and RESP_ID IN "+ids_to_delete);
	
					ilStatus1 = stmt.executeUpdate(sblQry.toString());
	
					sblQry1.append("delete from sm_resp_for_user where APPL_USER_ID ='"+userid+"' and RESP_ID IN "+ids_to_delete);
					
					ilStatus2 = stmt1.executeUpdate(sblQry1.toString());
				
				}
				
				if(stmt!=null) stmt.close();	
				if(stmt1!=null) stmt1.close();	
				if(!update_vals.equals(""))
				{
					StringTokenizer insToken = new StringTokenizer(update_vals, "~");
					//String sql="insert into sm_resp_for_user (APPL_USER_ID ,RESP_ID,EFF_DATE_FROM,EFF_DATE_TO,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,sysdate,?)";
					String sql="update sm_resp_for_user set EFF_DATE_FROM=to_date(?,'dd/mm/yyyy') , EFF_DATE_TO = to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?  where APPL_USER_ID =? and RESP_ID = ? ";
					pslPrepStmt = con.prepareStatement(sql);
					while(insToken.hasMoreTokens())
					{
						i = insToken.nextToken();
						respID = (req.getParameter("respID"+i)==null)	?	""	:	req.getParameter("respID"+i);
						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
					
						pslPrepStmt.setString(1,checkedFromDate);
						pslPrepStmt.setString(2,checkedToDate);
						pslPrepStmt.setString(3,addedById);
						pslPrepStmt.setString(4,client_ip_address);
						pslPrepStmt.setString(5,userid);
						pslPrepStmt.setString(6,respID);
	
						ilStatus2 = pslPrepStmt.executeUpdate();
						
						if(!(ilStatus2 >=1))
						{
							break;
						}
					}
					if(pslPrepStmt!=null) pslPrepStmt.close();
				}
				
			}
			
			if(objectName.equals("Resp"))
			{
				if(!insert_vals.equals(""))
				{
					StringTokenizer insToken = new StringTokenizer(insert_vals, "~");
					String sql="insert into sm_resp_for_user (APPL_USER_ID ,RESP_ID,EFF_DATE_FROM,EFF_DATE_TO,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,sysdate,?)";
					pslPrepStmt = con.prepareStatement(sql);				
					while(insToken.hasMoreTokens())
					{
						i = insToken.nextToken();
						respID = (req.getParameter("respID"+i)==null)	?	""	:	req.getParameter("respID"+i);
						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
						
						pslPrepStmt.setString(1,respID);
						pslPrepStmt.setString(2,userid);
						pslPrepStmt.setString(3,checkedFromDate);
						pslPrepStmt.setString(4,checkedToDate);
						pslPrepStmt.setString(5,addedById);
						pslPrepStmt.setString(6,client_ip_address);
						pslPrepStmt.setString(7,addedById);
						pslPrepStmt.setString(8,client_ip_address);
						ilStatus = pslPrepStmt.executeUpdate();
	
						 
						if(!(ilStatus >=1))
						{
							break;
						}
					}
				}
				if(pslPrepStmt!=null) pslPrepStmt.close();
				if(!delete_vals.equals(""))
				{
					StringBuffer sblQry = new StringBuffer();
					StringBuffer sblQry1 = new StringBuffer();
					StringTokenizer insToken = new StringTokenizer(delete_vals, "~");
					String ids_to_delete = "(";
					int k=0;
					stmt = con.createStatement();
					stmt1 = con.createStatement();
					while(insToken.hasMoreTokens())
					{
						if(k != 0)
							ids_to_delete = ids_to_delete +",";
						i = insToken.nextToken();
						
						ids_to_delete =ids_to_delete+ "'"+i+"'";
						k++;
					}
					ids_to_delete = ids_to_delete +")";
					
					sblQry.append("delete from SM_FREQ_FUNC_BY_USER where    RESP_ID ='"+userid+"' and APPL_USER_ID IN "+ids_to_delete);
					
					ilStatus1 = stmt.executeUpdate(sblQry.toString());
	
					sblQry1.append("delete from sm_resp_for_user where RESP_ID ='"+userid+"' and APPL_USER_ID IN "+ids_to_delete);
					
					ilStatus2 = stmt1.executeUpdate(sblQry1.toString());
				
				}
				if(stmt!=null) stmt.close();	
				if(stmt1!=null) stmt1.close();	
				if(!update_vals.equals(""))
				{
					StringTokenizer insToken = new StringTokenizer(update_vals, "~");
					//String sql="insert into sm_resp_for_user (APPL_USER_ID ,RESP_ID,EFF_DATE_FROM,EFF_DATE_TO,ADDED_BY_ID ,ADDED_DATE ,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO ) values (?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,sysdate,?,?,sysdate,?)";
					String sql="update sm_resp_for_user set EFF_DATE_FROM=to_date(?,'dd/mm/yyyy') , EFF_DATE_TO = to_date(?,'dd/mm/yyyy'),MODIFIED_BY_ID=?,MODIFIED_DATE=sysdate,MODIFIED_AT_WS_NO=?  where APPL_USER_ID =? and RESP_ID = ? ";
					pslPrepStmt = con.prepareStatement(sql);
					while(insToken.hasMoreTokens())
					{
						i = insToken.nextToken();
						respID = (req.getParameter("respID"+i)==null)	?	""	:	req.getParameter("respID"+i);
						checkedFromDate = (req.getParameter("eff_date_from"+i)==null)	?	""	:	req.getParameter("eff_date_from"+i);
						checkedToDate = (req.getParameter("eff_date_to"+i)==null)	?	""	:	req.getParameter("eff_date_to"+i);
						
						checkedFromDate=DateUtils.convertDate(checkedFromDate,"DMY",locale,"en");
						checkedToDate=DateUtils.convertDate(checkedToDate,"DMY",locale,"en");
						
						pslPrepStmt.setString(1,checkedFromDate);
						pslPrepStmt.setString(2,checkedToDate);
						pslPrepStmt.setString(3,addedById);
						pslPrepStmt.setString(4,client_ip_address);
						pslPrepStmt.setString(5,respID);
						pslPrepStmt.setString(6,userid);
	
						ilStatus2 = pslPrepStmt.executeUpdate();
						
						if(!(ilStatus2 >=1))
						{
							break;
						}
					}
				}
			}
         
			if(ilStatus >=1 || ilStatus1 >=1 || ilStatus2 >=1)
			{
				con.commit();
				err_value="1";
				java.util.Hashtable hashtable1 = MessageManager.getMessage(locale,"RECORD_INSERTED", "SM");
				s20 = (String)hashtable1.get("message");
				hashtable1.clear();
			}else con.rollback();
			
           	res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +  java.net.URLEncoder.encode("", "UTF-8") + "&err_value=" + err_value);
	//	}
			if(pslPrepStmt1!=null) pslPrepStmt1.close();
			if(pslPrepStmt2!=null) pslPrepStmt2.close();
			if(pslPrepStmt!=null) pslPrepStmt.close();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(  userid+ " "+facility+ " "+remarks);
			e.printStackTrace();
		}
	}
}

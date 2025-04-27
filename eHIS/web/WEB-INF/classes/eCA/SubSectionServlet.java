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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

public class SubSectionServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return(mesg) ;
	}

	public  void doPost(HttpServletRequest request,	HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = null;

		out = response.getWriter();		
		java.util.Properties p;

		StringTokenizer tokenizeTilde = null;
		StringTokenizer tokenizePipe  = null;

		String facilityId			= "";
		String client_ip_address	= "";
		String errorMessage			= "";
		String child_sec_code		= "";
		String child_seq_num		= "";
		String operation_del_sql	= "";
		String val					= "";
		String val1					= "";
		String val2					= "";
		String val3					= "";
		String addedById			= "";
		String key					= "";
		String added_facility_id	= "";


		HttpSession session = request.getSession(false);

		p						= (java.util.Properties) session.getValue("jdbc");
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue("facility_id");
		client_ip_address		= (String) p.getProperty("client_ip_address");

		Connection con = null;
		
		ResultSet rs1 = null;

		PreparedStatement pstmt_ins		= null;
		PreparedStatement pstmt_upd		= null;
		PreparedStatement pstmt_update	= null;
		PreparedStatement pstmt_del		= null;

		boolean flag = false;
		int i = 0;
		
		final int MAX = Integer.parseInt(request.getParameter("array_length"));// obtaining the length of the number of Text Boxes Created
		
		int insert = 0;
		int row_count = 0;

		String [] subSec_Code	= new String[MAX];
		String [] seq_num		= new String[MAX];

		added_facility_id = facilityId;

		try 
		{
			con = ConnectionManager.getConnection(request);
			addedById = p.getProperty("login_user");
						
			out.println("<html>");
			out.println("<body>");
			
			String section = request.getParameter("section_code");
			
			if (section == null || section.equals(""))
				section = "";
			
			String finalString = request.getParameter("finalString");//Concatenated String Value
			
			if (finalString == null || finalString.equals(""))
				finalString = "";

			if (!finalString.equals("")) 
			{
				tokenizeTilde = new StringTokenizer(finalString, "~");
				
				while (tokenizeTilde.hasMoreTokens())// loop for Splitting the Final String
				{
					val = tokenizeTilde.nextToken();
					tokenizePipe = new StringTokenizer(val, "||");
					val1 = tokenizePipe.nextToken();
					val1 = java.net.URLDecoder.decode(val1);
					val2 = tokenizePipe.nextToken();

					if (val2.equals("null")) 
						val2 = "";
					
					seq_num[i] = val2; //list of Sequence Number are read into
									   // an String array
					val3 = tokenizePipe.nextToken();
					
					subSec_Code[i] = val3;//list of SubSection Code
										  // Corresponding to Sequence Number
					i++;
				}
				
				for (i = 0; i < MAX; i++) 
				{
					key = seq_num[i];

					for (int j = i + 1; j < MAX; j++) 
					{
						if (Integer.parseInt(key) == Integer.parseInt(seq_num[j]))//Checking for Duplicate Sequence Number
							flag = true;
					}
				}

				if (flag == true) // if Condition to alert for Duplicate Sequence Number
				{
					errorMessage=getMessage(locale, "DUPLICATE_SEQUENCE_NUMBER","CA");
					response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+ java.net.URLEncoder.encode(errorMessage,"UTF-8"));
				}
				else 
				{
					operation_del_sql = "Delete from ca_subsection_link where header_sec_hdg_code =?";
					pstmt_del = con.prepareStatement(operation_del_sql);
					pstmt_del.setString(1, section);
					pstmt_del.executeUpdate();
					String operation_ins_sql = "Insert into ca_subsection_link(header_sec_hdg_code, child_sec_hdg_code, child_seq_num, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)values(?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					operation_del_sql = "select  CHILD_SEQ_NUM,CHILD_SEC_HDG_CODE  from ca_subsection_link where  HEADER_SEC_HDG_CODE=? and CHILD_SEC_HDG_CODE=? order by CHILD_SEQ_NUM ";
					pstmt_upd = con.prepareStatement(operation_del_sql);//Query used to Check for already Present Sequence Number
					pstmt_upd.setString(1, section);
					
					pstmt_ins = con.prepareStatement(operation_ins_sql); //Query to Insert new Values in to the Table ca_subsection_link
									
					pstmt_ins.setString(1, section);
					pstmt_ins.setString(4, addedById);
					pstmt_ins.setString(5, client_ip_address);
					pstmt_ins.setString(6, added_facility_id);
					pstmt_ins.setString(7, addedById);
					pstmt_ins.setString(8, client_ip_address);
					pstmt_ins.setString(9, added_facility_id);
					
					

					pstmt_update = con.prepareStatement("update  ca_subsection_link set child_seq_num = ?,MODIFIED_BY_ID = ?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where header_sec_hdg_code =? and child_sec_hdg_code =? ");//Query to Update Fields if Sequence Number Corresponding to a Section Code is Present
					pstmt_update.setString(2, addedById);
					pstmt_update.setString(3, client_ip_address);
					pstmt_update.setString(4, added_facility_id);
					pstmt_update.setString(5, section);
					
					for (i = 0; i < MAX; i++) 
					{
						pstmt_upd.setString(2, subSec_Code[i]);
						rs1 = pstmt_upd.executeQuery();
						child_seq_num = "0";
						child_sec_code = "";
						
						while (rs1.next()) 
						{
							child_seq_num = rs1.getString("CHILD_SEQ_NUM") == null ? "0": rs1.getString("CHILD_SEQ_NUM");
							child_sec_code = rs1.getString("CHILD_SEC_HDG_CODE") == null ? "": rs1.getString("CHILD_SEC_HDG_CODE");
						}

						if (rs1 != null) rs1.close();

						if (child_sec_code.equals(subSec_Code[i]))//Condition
																  // to Check
																  // SubSection
																  // Codes from
																  // Table and
																  // from the
																  // SubSection
																  // Code are
																  // Equals
						{
							
							if (Integer.parseInt(child_seq_num) != Integer
									.parseInt(seq_num[i])) // if above condtion
														   // is Executed then
														   // update the
														   // Corresponding
														   // Sequence Number
														   // are not equal
							{
								pstmt_update.setInt(1, Integer
										.parseInt(seq_num[i]));
								pstmt_update.setString(6, subSec_Code[i]);
								insert = pstmt_update.executeUpdate();
								
								row_count += insert;
								
							} 
							else if (Integer.parseInt(child_seq_num) == Integer.parseInt(seq_num[i]))// else if above condtion is fails then Corresponding Sequence Number are not altered
								row_count++;
						} 
						else// if Not Match is Found then new Entries are added in to the Table
						{
							pstmt_ins.setString(2, subSec_Code[i]);
							pstmt_ins.setInt(3, Integer.parseInt(seq_num[i]));
							insert = pstmt_ins.executeUpdate();
							
							row_count += insert;
						}
					}
					
					if (rs1 != null)
						rs1.close();
					
					if (pstmt_upd != null)
						pstmt_upd.close();
					
					if (row_count == MAX) // if no of rows inserted are equals
										  // to the number of Entries then
										  // Values are Committed to the
										  // Database
					{
						
						con.commit();
						errorMessage =getMessage(locale, "RECORD_INSERTED","CA");
									
						response
								.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
										+ java.net.URLEncoder
												.encode(errorMessage,"UTF-8")
										+ "&err_value=1");
						
					} 
					else// if above condtion fails then the Values are
						  // rollbacked from the Database
					{
						try 
						{
							con.rollback();
						} 
						catch (Exception ee) 
						{
							//out.println("Exception in Main Block  : "+ ee.toString());//common-icn-0181
							ee.printStackTrace();
						}
					}
				}
			} 
			else // if finalString Posted is a Null String then all Values
				   // Corresponding to that Main Section Code and Sub Section
				   // Code are Deleted
			{
				operation_del_sql = "Delete from ca_subsection_link where header_sec_hdg_code =?";
				pstmt_del = con.prepareStatement(operation_del_sql);
				pstmt_del.setString(1, section);
				pstmt_del.executeUpdate();

				errorMessage =getMessage(locale, "RECORD_INSERTED","CA");
				response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMessage,"UTF-8")+ "&err_value=1");
			}
		} 
		catch (Exception e) 
		{
			//out.println("Exception in Main Block  : " + e.toString());//common-icn-0181
			
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (pstmt_ins != null)
					pstmt_ins.close();
				if (pstmt_del != null)
					pstmt_del.close();

				if (pstmt_update != null)
					pstmt_update.close();
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			} 
			catch (Exception ee) 
			{
				//out.println("Exception in finally Block : " + ee.toString());//common-icn-0181
				ee.printStackTrace();
			}
		}
	}
}


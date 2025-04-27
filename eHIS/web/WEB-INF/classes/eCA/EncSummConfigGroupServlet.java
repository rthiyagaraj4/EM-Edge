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
24/09/2013        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class EncSummConfigGroupServlet extends javax.servlet.http.HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	String mode = "";
	
	String es_summ_code = "";	
	int es_group_flag = 0;	
	String es_group_type="";
	String es_group_code="";
	int es_group_seq = 0;	
	
	String facilityId="";
	String client_ip_address="";
	String addedById = "";
	String modifiedById = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	
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
		
		String errorMessage			= "";
		String strChildGroupType = "", strChildGroupCode = "", strChildGroupSeq = ""; 
		String val = "", val1 = "", val2 = "", val3 = "", val4 = "";				
		String key					= "";

		HttpSession session = request.getSession(false);

		p						= (java.util.Properties) session.getValue("jdbc");
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue("facility_id");
		client_ip_address		= (String) p.getProperty("client_ip_address");

		Connection con = null;
		
		ResultSet rs1 = null;

		PreparedStatement pstmt_sel		= null;
		PreparedStatement pstmt_ins		= null;
		PreparedStatement pstmt_upd		= null;		
		PreparedStatement pstmt_del		= null;
		
		String operation_sel_sql = "", operation_ins_sql = "", operation_upd_sql = "", operation_del_sql = "";

		boolean flag = false;
		int i = 0;
		
		final int MAX = Integer.parseInt(request.getParameter("array_length"));// obtaining the length of the number of Text Boxes Created
		
		int insert = 0;
		int row_count = 0;

		String [] group_Type	= new String[MAX];
		String [] group_Code	= new String[MAX];
		String [] seq_num		= new String[MAX];		

		try 
		{
			con = ConnectionManager.getConnection(request);
			addedById = p.getProperty("login_user");
						
			out.println("<html>");
			out.println("<body>");
			
			String summaryCode = request.getParameter("summaryCode");
			
			if (summaryCode == null || summaryCode.equals(""))
				summaryCode = "";
			
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
					
					seq_num[i] = val2; //list of Sequence Number are read into an String array
					
					val3 = tokenizePipe.nextToken();					
					group_Code[i] = val3;//list of Group Code
					
					val4 = tokenizePipe.nextToken();					
					group_Type[i] = val4;//list of Group Type
					
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
					operation_del_sql = "Delete from cr_es_summ_dtl where es_summ_code = ?";
					pstmt_del = con.prepareStatement(operation_del_sql);
					pstmt_del.setString(1, summaryCode);
					pstmt_del.executeUpdate();
					
					operation_sel_sql = "Select es_summ_code, es_group_flag, es_group_type, es_group_code, es_group_seq from cr_es_summ_dtl " +
										"where es_summ_code = ? and es_group_flag = 0 and es_group_type = ? and es_group_code = ? ";
					pstmt_sel = con.prepareStatement(operation_sel_sql);
					
					operation_ins_sql = "Insert into cr_es_summ_dtl (es_summ_code, es_group_flag, es_group_type, es_group_code, es_group_seq, " +
							"added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) " +
							"values(?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)";
					
					pstmt_ins = con.prepareStatement(operation_ins_sql); //Query to Insert new Values in to the Table cr_es_summ_dtl
					
					operation_upd_sql = "update cr_es_summ_dtl set es_group_seq = ?, modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?"+
							" where  es_summ_code = ? and es_group_flag = 0 and es_group_type = ? and es_group_code = ? ";
					
					pstmt_upd = con.prepareStatement(operation_upd_sql); //Query to update the new sequence values in to the Table cr_es_summ_dtl
									
					pstmt_ins.setString(1, summaryCode);
					pstmt_ins.setString(4, addedById);
					pstmt_ins.setString(5, client_ip_address);
					pstmt_ins.setString(6, facilityId);
					pstmt_ins.setString(7, addedById);
					pstmt_ins.setString(8, client_ip_address);
					pstmt_ins.setString(9, facilityId);					
					
					for (i = 0; i < MAX; i++) 
					{
						pstmt_sel.setString(1, summaryCode);
						pstmt_sel.setString(2, group_Type[i]);
						pstmt_sel.setString(3, group_Code[i]);
						
						rs1 = pstmt_sel.executeQuery();
						strChildGroupType = "";
						strChildGroupCode = "";
						strChildGroupSeq = "";
						
						while (rs1.next()) 
						{
							strChildGroupType = rs1.getString("es_group_type") == null ? "": rs1.getString("es_group_type");
							strChildGroupCode = rs1.getString("es_group_code") == null ? "": rs1.getString("es_group_code");
							strChildGroupSeq = rs1.getString("es_group_seq") == null ? "0": rs1.getString("es_group_seq");							
						}

						if (rs1 != null) rs1.close();

						if ((strChildGroupType.equals(group_Type[i])) && (strChildGroupCode.equals(group_Code[i])))//Condition to Check group codes from table and from the group code are Equals
						{							
							if (Integer.parseInt(strChildGroupSeq) != Integer.parseInt(seq_num[i])) // if above condition is executed then update the corresponding Sequence Number are not equal
							{
								pstmt_upd.setInt(1, Integer.parseInt(seq_num[i]));
								pstmt_upd.setString(2, addedById);
								pstmt_upd.setString(3, client_ip_address);
								pstmt_upd.setString(4, facilityId);
								pstmt_upd.setString(5, summaryCode);
								pstmt_upd.setString(6, group_Type[i]);
								pstmt_upd.setString(7, group_Code[i]);			
								
								insert = pstmt_upd.executeUpdate();
								
								row_count += insert;								
							} 
							else if (Integer.parseInt(strChildGroupSeq) == Integer.parseInt(seq_num[i]))// else if above condition is fails then corresponding Sequence Number are not altered
								row_count++;
						} 
						else// if Not Match is Found then new Entries are added in to the Table
						{
							pstmt_ins.setString(1, summaryCode);
							pstmt_ins.setInt(2, es_group_flag);
							pstmt_ins.setString(3, group_Type[i]);
							pstmt_ins.setString(4, group_Code[i]);		
							pstmt_ins.setInt(5, Integer.parseInt(seq_num[i]));							
							pstmt_ins.setString(6, addedById);
							pstmt_ins.setString(7, client_ip_address);
							pstmt_ins.setString(8, facilityId);
							pstmt_ins.setString(9, addedById);
							pstmt_ins.setString(10, client_ip_address);
							pstmt_ins.setString(11, facilityId);
							
							insert = pstmt_ins.executeUpdate();
							
							row_count += insert;
						}
					}
					
					if (rs1 != null)
						rs1.close();
					
					if (pstmt_upd != null)
						pstmt_upd.close();
					
					if (row_count == MAX) // if no of rows inserted are equals to the number of Entries then Values are Committed to the Database
					{						
						con.commit();
						errorMessage = getMessage(locale, "RECORD_INSERTED","CA");						
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMessage,"UTF-8")+"&err_value=1");						
					} 
					else// if above condition fails then the Values are roll backed from the Database
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
				
				if (pstmt_upd != null)
					pstmt_upd.close();
				
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


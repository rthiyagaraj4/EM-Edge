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
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

-----------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class EncSummLayoutServlet extends javax.servlet.http.HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	String mode = "";
	
	String es_summ_code = "";	
	
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
		
		PrintWriter out = null;

		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");	
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = response.getWriter();			
			mode = request.getParameter("mode");

			if (mode.trim().equalsIgnoreCase("insert"))   insert(request, response, out);
			if (mode.trim().equalsIgnoreCase("update"))   modify(request, response, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}

	}
	/**************************/

	public void insert(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{

		java.util.Properties p;

		StringTokenizer tokenizeTilde = null;
		StringTokenizer tokenizePipe  = null;
		String val = "";
		
		String errorMessage			= "";

		HttpSession session = request.getSession(false);

		p						= (java.util.Properties) session.getValue("jdbc");
		String locale			= (String) p.getProperty("LOCALE");
		facilityId				= (String) session.getValue("facility_id");
		client_ip_address		= (String) p.getProperty("client_ip_address");

		Connection con = null;
		
		PreparedStatement pstmt_upd_hdr		= null;	
		PreparedStatement pstmt_upd_fields		= null;	
	
		String operation_upd_hdr_sql = "", operation_upd_fields_sql = "";

		int i = 0;
		
		final int MAX = Integer.parseInt(request.getParameter("fieldsCount"));// obtaining the number of fields created.
		
		int update_hdr_count = 0, update_fields_count = 0;
		int row_count = 0;
		
		String es_summ_code = "";
		
		int es_header_orient = 0, es_colors_indicate = 0, es_tbl_cell_color_fill = 0, es_tbl_cell_bborder_fill = 0; 
		int es_footer_sign_flag = 0, es_footer_sign_posn = 0;// es_footer_digital_sig = 0; 51003
		int es_footer_sign_1_flag = 0, es_footer_sign_1_practid = 0, es_footer_sign_1_splty = 0; 
		int es_footer_sign_2_flag = 0, es_footer_sign_2_practid = 0, es_footer_sign_2_splty = 0;
		int es_footer_sign_3_flag = 0, es_footer_sign_3_practid = 0, es_footer_sign_3_splty = 0;

		String es_footer_sign_1_label = "", es_footer_sign_2_label = "", es_footer_sign_3_label = "";
		String headerValue = "", footerValue = "";
		 
		
		String [] feildID		= new String[MAX];
		int [] fieldHiddenFlag	= new int[MAX];
		int [] fieldFlag		= new int[MAX];		
		int [] fieldOrient		= new int[MAX];		
		String [] fieldLbl		= new String[MAX];		
		
		try 
		{
			con = ConnectionManager.getConnection(request);
			addedById = p.getProperty("login_user");
						
			out.println("<html>");
			out.println("<body>");
			
			es_summ_code = request.getParameter("es_summ_code");			

			if (es_summ_code == null || es_summ_code.equals(""))
				es_summ_code = "";
			
			es_header_orient = Integer.parseInt(request.getParameter("hiddenHeaderOrient"));	
			es_colors_indicate = Integer.parseInt(request.getParameter("hiddenColorIndicate"));
			es_tbl_cell_color_fill = Integer.parseInt(request.getParameter("hiddenTblCellColFill"));
			es_tbl_cell_bborder_fill = Integer.parseInt(request.getParameter("hiddenTblCellBorFill"));
			
			es_footer_sign_flag = Integer.parseInt(request.getParameter("hiddenFooterSignFlag"));
			es_footer_sign_posn = Integer.parseInt(request.getParameter("hiddenFooterSignPosn"));
			
			es_footer_sign_1_flag = Integer.parseInt(request.getParameter("hiddenFooterSign1Flag"));
			es_footer_sign_1_practid = Integer.parseInt(request.getParameter("hiddenFooterSign1Pract"));
			es_footer_sign_1_splty = Integer.parseInt(request.getParameter("hiddenFooterSign1Splty"));
			es_footer_sign_1_label = request.getParameter("hiddenFooterSign1Lbl");
			
			es_footer_sign_2_flag = Integer.parseInt(request.getParameter("hiddenFooterSign2Flag"));
			es_footer_sign_2_practid = Integer.parseInt(request.getParameter("hiddenFooterSign2Pract"));
			es_footer_sign_2_splty = Integer.parseInt(request.getParameter("hiddenFooterSign2Splty"));
			es_footer_sign_2_label = request.getParameter("hiddenFooterSign2Lbl");
			
			es_footer_sign_3_flag = Integer.parseInt(request.getParameter("hiddenFooterSign3Flag"));
			es_footer_sign_3_practid = Integer.parseInt(request.getParameter("hiddenFooterSign3Pract"));
			es_footer_sign_3_splty = Integer.parseInt(request.getParameter("hiddenFooterSign3Splty"));
			es_footer_sign_3_label = request.getParameter("hiddenFooterSign3Lbl");
			
			headerValue = request.getParameter("headerValue");//Concatenated String Value
			footerValue = request.getParameter("footerValue");//Concatenated String Value
			
			if (headerValue == null || headerValue.equals(""))
				headerValue = "";

			if (footerValue == null || footerValue.equals(""))
				footerValue = "";

			String finalString = request.getParameter("fieldsValue");//Concatenated String Value
			
			if (finalString == null || finalString.equals(""))
				finalString = "";

			if (!finalString.equals("")) 
			{
				tokenizeTilde = new StringTokenizer(finalString, "~");
				
				while (tokenizeTilde.hasMoreTokens())// loop for Splitting the Final String
				{
					val = tokenizeTilde.nextToken();					
					tokenizePipe = new StringTokenizer(val, "||");
					feildID[i] = tokenizePipe.nextToken();
					fieldHiddenFlag[i] = Integer.parseInt(tokenizePipe.nextToken());
					fieldFlag[i] = Integer.parseInt(tokenizePipe.nextToken());
					fieldOrient[i] = Integer.parseInt(tokenizePipe.nextToken());
					fieldLbl[i] = tokenizePipe.nextToken();
					
					i++;
				}			
				

				if (es_summ_code.length() > 0)
				{					
					operation_upd_hdr_sql = "update cr_es_summ_layout_hdr "+
												"set es_header_orient = ?, "+
													"es_colors_indicate = ?, "+
													"es_tbl_cell_color_fill = ?, "+
													"es_tbl_cell_bborder_fill = ?, "+ 
													"es_footer_sign_flag = ?, "+
													"es_footer_sign_posn = ?, "+
													"es_footer_sign_1_flag = ?, "+
													"es_footer_sign_1_label = ?, "+
													"es_footer_sign_1_practid = ?, "+
													"es_footer_sign_1_splty = ?, "+
													"es_footer_sign_2_flag = ?, "+
													"es_footer_sign_2_label = ?, "+
													"es_footer_sign_2_practid = ?, "+
													"es_footer_sign_2_splty = ?, "+
													"es_footer_sign_3_flag = ?, "+
													"es_footer_sign_3_label = ?, "+
													"es_footer_sign_3_practid = ?, "+
													"es_footer_sign_3_splty = ?, "+
													"es_header_code = ?, "+
													"es_footer_code = ?, "+	
													"modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? "+
											" where  es_summ_code = ? ";
					
					pstmt_upd_hdr = con.prepareStatement(operation_upd_hdr_sql); //Query to update the layout header table 
									
					pstmt_upd_hdr.setInt(1, es_header_orient);
					pstmt_upd_hdr.setInt(2, es_colors_indicate);
					pstmt_upd_hdr.setInt(3, es_tbl_cell_color_fill);
					pstmt_upd_hdr.setInt(4, es_tbl_cell_bborder_fill);
					
					pstmt_upd_hdr.setInt(5, es_footer_sign_flag);
					pstmt_upd_hdr.setInt(6, es_footer_sign_posn);
					
					pstmt_upd_hdr.setInt(7, es_footer_sign_1_flag);
					pstmt_upd_hdr.setString(8, es_footer_sign_1_label);
					pstmt_upd_hdr.setInt(9, es_footer_sign_1_practid);
					pstmt_upd_hdr.setInt(10, es_footer_sign_1_splty);
					
					pstmt_upd_hdr.setInt(11, es_footer_sign_2_flag);
					pstmt_upd_hdr.setString(12, es_footer_sign_2_label);
					pstmt_upd_hdr.setInt(13, es_footer_sign_2_practid);
					pstmt_upd_hdr.setInt(14, es_footer_sign_2_splty);
					
					pstmt_upd_hdr.setInt(15, es_footer_sign_3_flag);
					pstmt_upd_hdr.setString(16, es_footer_sign_3_label);
					pstmt_upd_hdr.setInt(17, es_footer_sign_3_practid);
					pstmt_upd_hdr.setInt(18, es_footer_sign_3_splty);
					
					pstmt_upd_hdr.setString(19, headerValue);
					pstmt_upd_hdr.setString(20, footerValue);
					
					pstmt_upd_hdr.setString(21, addedById);
					pstmt_upd_hdr.setString(22, client_ip_address);
					pstmt_upd_hdr.setString(23, facilityId);
					
					pstmt_upd_hdr.setString(24, es_summ_code);
					
					update_hdr_count = pstmt_upd_hdr.executeUpdate();
					
					
					operation_upd_fields_sql = "update cr_es_summ_layout_fields "+
														"set es_field_flag = ?, "+
															"es_field_orient = ?, "+
															"es_field_lbl = ?, "+
															"modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ?"+
												" where  es_summ_code = ?  and es_field_id = ? ";
					
					pstmt_upd_fields = con.prepareStatement(operation_upd_fields_sql); //Query to update the layout fields table 
					
					for (i = 0; i < MAX; i++) 
					{
						pstmt_upd_fields.setInt(1, fieldFlag[i]);
						pstmt_upd_fields.setInt(2, fieldOrient[i]);

						if (fieldLbl[i].equalsIgnoreCase("null")){
							pstmt_upd_fields.setString(3, "");
						}
						else
						{
							pstmt_upd_fields.setString(3, fieldLbl[i]);
						}
						
						
						pstmt_upd_fields.setString(4, addedById);
						pstmt_upd_fields.setString(5, client_ip_address);
						pstmt_upd_fields.setString(6, facilityId);
						
						pstmt_upd_fields.setString(7, es_summ_code);
						pstmt_upd_fields.setString(8, feildID[i]);
						
						update_fields_count = pstmt_upd_fields.executeUpdate();	
						
						row_count ++;
					}
					
					if (pstmt_upd_hdr != null)
						pstmt_upd_hdr.close();
					
					if (pstmt_upd_fields != null)
						pstmt_upd_fields.close();
					
					if ((row_count == MAX) & (update_hdr_count == 1))// if no of rows inserted are equals to the number of Entries then Values are Committed to the Database
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
				if (pstmt_upd_hdr != null)
					pstmt_upd_hdr.close();
				
				if (pstmt_upd_fields != null)
					pstmt_upd_fields.close();				
				
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			} 
			catch (Exception ee) 
			{
				out.println("Exception in finally Block : " + ee.toString());
				ee.printStackTrace();
			}
		}
	}
	
	public void modify(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
	{

		java.util.Properties p;

	//	String errorMessage			= "";//51003

		HttpSession session = request.getSession(false);

		p						= (java.util.Properties) session.getValue("jdbc");
		//String locale			= (String) p.getProperty("LOCALE");//51003
		facilityId				= (String) session.getValue("facility_id");
		client_ip_address		= (String) p.getProperty("client_ip_address");

		Connection con = null;
		
		PreparedStatement pstmt_upd_hdr		= null;	
	
		String operation_upd_hdr_sql = "";
		
		int headfootFlag = 0;

		int update_hdr_count = 0;
	
		String es_summ_code = "";
		
		String headerValue = "", footerValue = "";
		
		String changeFlag = "";
		    
		 
		try 
		{
			con = ConnectionManager.getConnection(request);
			addedById = p.getProperty("login_user");

			changeFlag = request.getParameter("changeFlag");
			
			es_summ_code = request.getParameter("es_summ_code");			
			
			if (es_summ_code == null || es_summ_code.equals(""))
				es_summ_code = "";			
					
			headerValue = request.getParameter("headerValue");//Concatenated String Value
			footerValue = request.getParameter("footerValue");//Concatenated String Value
			
			if (headerValue == null || headerValue.equals(""))
				headerValue = "";

			if (footerValue == null || footerValue.equals(""))
				footerValue = "";

			if (!headerValue.equals("") || !footerValue.equals("")) 
			{
				if (es_summ_code.length() > 0)
				{					
					if (footerValue.equals("update")){
						operation_upd_hdr_sql = "update cr_es_summ_layout_hdr "+
													"set "+
														"es_header_code_preview = ?, "+													
														"modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? "+
												" where  es_summ_code = ? ";
						
						headfootFlag = 0;
					}
					else
					{
						operation_upd_hdr_sql = "update cr_es_summ_layout_hdr "+
													"set es_footer_code_preview = ?, "+
														"modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? "+
												" where  es_summ_code = ? ";
						
						headfootFlag = 1;
					}

					pstmt_upd_hdr = con.prepareStatement(operation_upd_hdr_sql); //Query to update the layout header table 
					
					if (footerValue.equals("update")){
						pstmt_upd_hdr.setString(1, headerValue);
					}
					else
					{
						pstmt_upd_hdr.setString(1, footerValue);
					}
					
					pstmt_upd_hdr.setString(2, addedById);
					pstmt_upd_hdr.setString(3, client_ip_address);
					pstmt_upd_hdr.setString(4, facilityId);
					pstmt_upd_hdr.setString(5, es_summ_code);
					
					update_hdr_count = pstmt_upd_hdr.executeUpdate();	
					
					if (pstmt_upd_hdr != null)
						pstmt_upd_hdr.close();
					
					if (update_hdr_count == 1)// if no of rows inserted are equals to the number of Entries then Values are Committed to the Database
					{						
						con.commit();
						String htmlFor = "";		
						htmlFor = htmlFor +"<html><head>";
						htmlFor = htmlFor +"</head><body class='message'>";
						htmlFor = htmlFor +"<script language = 'JavaScript'>" ;
						htmlFor = htmlFor +"  var dialogHeight    = '700px' ;";
						htmlFor = htmlFor + " var dialogWidth = '1050px' ;";
						htmlFor = htmlFor + " var dialogTop  = '100' ;";
						htmlFor = htmlFor + " var dialogLeft = '100' ;";
						htmlFor = htmlFor +"  var arguments  =   ''; ";
						htmlFor = htmlFor +"  var getUrl      =   '../eCA/jsp/EncSummPageHeader.jsp?summCode="+es_summ_code+"&HeadFootFlag="+headfootFlag+"&changeFlag="+changeFlag+"';";
						htmlFor = htmlFor +"  var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +' ; dialogTop:'+ dialogTop +' ;dialogLeft='+ dialogLeft +';scroll=no; status:no;help:no; location:no ';";
						htmlFor = htmlFor +"  var retVal      =   window.showModalDialog(getUrl,arguments,features); ";
						htmlFor = htmlFor +"</script>";
						htmlFor = htmlFor +"</body>";
						htmlFor = htmlFor +"</html>";
						out.println(htmlFor);
						
						//errorMessage = getMessage(locale, "RECORD_INSERTED","CA");						
						//response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(errorMessage,"UTF-8")+"&err_value=1");
					
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
			//out.println("Exception in Main Block  : " + e.toString());	//common-icn-0181		
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				if (pstmt_upd_hdr != null)
					pstmt_upd_hdr.close();
				
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


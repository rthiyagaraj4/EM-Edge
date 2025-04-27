/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

// Class Level Imports
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.servlet.http.HttpSession;
import javax.servlet.SingleThreadModel;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

// Framework Level Imports
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class FMDocumentTypeInFolderServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out		=	null;
	Properties prop		=	null;
	HttpSession session	=	null;

	Connection connection		=	null;
	PreparedStatement	pstmt	=	null;
	String facility_id			=	"";
	String login_user			=	"";
	String client_ip_address	=	"";
	String operation			=	"";
	String sqlString			=	"";
	String delString			=	"";
	String locale			= "" ;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws
					ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			session					=	request.getSession(false);
			this.facility_id		=	checkForNull((String) session.getValue("facility_id"));
			this.prop				=	(Properties) session.getValue("jdbc");
			locale = prop.getProperty("LOCALE");
			this.login_user			=	checkForNull(prop.getProperty("login_user"));
			this.client_ip_address	=	checkForNull(prop.getProperty("client_ip_address"));
			this.operation			=	checkForNull(request.getParameter("operation"));
			this.out				=	response.getWriter();
			if (operation.equals("Insert"))
				insertDocumentTypeInFolder(request, response, locale);

		}catch(Exception exception)
		{
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_value=0&err_num="+java.net.URLEncoder.encode(exception.toString(),"UTF-8"));
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws
					ServletException, IOException
	{
		try
		{
			response.setContentType("text/html");
			this.out		=	response.getWriter();		
			String param	=	request.getQueryString();
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + param + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");

		}catch(Exception e){
		out.println("Exception in doGet method :"+e.toString());
		}
	}

	public void insertDocumentTypeInFolder(HttpServletRequest request, HttpServletResponse response, String locale)
		throws IOException
	{
		try
		{	
			String	documet_type		=	"";
			String	required_type		=	"";
			String	folder_id			=	"";
			String	folder_name			=	"";
			String	strTokenValue		=	"";
			String valid_values			=	checkForNull(request.getParameter("valid_values"));	 
			String folderName			=	checkForNull(request.getParameter("folderName"));	 
			connection					=	ConnectionManager.getConnection(prop);
			connection.setAutoCommit(false);
			int records_modified		=	0;
			int error_number			=	0;

			StringTokenizer folderToken	=	new StringTokenizer(folderName, "$$");
			
			if (folderToken.hasMoreTokens())
				folder_id	=	folderToken.nextToken();
			if (folderToken.hasMoreTokens())
				folder_name	=	folderToken.nextToken();
			
			StringTokenizer strToken	=	new StringTokenizer(valid_values, ",");
			StringTokenizer innerToken	=	null; 
			
			sqlString	=	"INSERT INTO fm_doc_type_in_folder (facility_id, doc_type_code, doc_folder_id, doc_folder_name, reqd_type, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id ) VALUES (?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? ) ";
			
			delString	=	" DELETE FROM fm_doc_type_in_folder WHERE facility_id = ? AND doc_type_code = ? AND doc_folder_id = ? ";
			while (strToken.hasMoreTokens())
			{
				strTokenValue	=	strToken.nextToken();
				if ((strTokenValue != null) && (!strTokenValue.equals("")))
				{
					innerToken	=	new StringTokenizer(strTokenValue, "$$");
					
					if (innerToken.hasMoreTokens())
						documet_type	=	innerToken.nextToken();
					
					if (innerToken.hasMoreTokens())
						required_type	=	innerToken.nextToken();

					pstmt	=	connection.prepareStatement(delString);
					pstmt.setString(1, facility_id);
					pstmt.setString(2, documet_type);
					pstmt.setString(3, folder_id);
					records_modified	=	pstmt.executeUpdate();
					if (pstmt != null)  pstmt.close();
					pstmt				=	null;
					records_modified	=	0;
					pstmt	=	connection.prepareStatement(sqlString);

					pstmt.setString(1, facility_id);
					pstmt.setString(2, documet_type);
					pstmt.setString(3, folder_id);
					pstmt.setString(4, folder_name);
					pstmt.setString(5, required_type);
					pstmt.setString(6, login_user);
					pstmt.setString(7, client_ip_address);
					pstmt.setString(8, facility_id);
					pstmt.setString(9, login_user);
					pstmt.setString(10, client_ip_address);
					pstmt.setString(11, facility_id);

					records_modified	=	pstmt.executeUpdate();
					if (pstmt != null)  pstmt.close();
				}
			}

			String error_message	=	"";
			if (records_modified > 0)
			{
				error_number	=	1;
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error_message	=	(String) message.get("message");
				connection.commit();
				message.clear();
			}
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_message,"UTF-8" )+"&err_value="+error_number);
		if (pstmt != null) pstmt.close();
		}catch(Exception exception)
		{
			response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_value=0&err_num="+java.net.URLEncoder.encode(exception.toString(),"UTF-8"));
		}
		finally
		{			
			ConnectionManager.returnConnection(connection,prop);
		}
	}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
}

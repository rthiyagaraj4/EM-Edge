/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.StringTokenizer;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

public class DTLinkEncounterDocTypeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;	
	java.util.Properties p;

	String facility_id			=	"";
	String client_ip_address	=	"";	

	Connection	connection			=	null;
	ResultSet	resultSet			=	null;
	PreparedStatement preStatement	=	null;
	PreparedStatement pStatement	=	null;
	String locale			= "" ;

	public final String RECORD_MODIFIED = "RECORD_MODIFIED" ;

	HttpSession session;
	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session				=	req.getSession(false);
		this.p				=	(java.util.Properties) session.getValue( "jdbc" ) ;
		locale = p.getProperty("LOCALE");
		this.facility_id	=	checkForNull((String) session.getValue("facility_id"));		
		p					=	(Properties) session.getValue("jdbc");
		client_ip_address	=	 p.getProperty("client_ip_address");

		try
		{
			this.out = res.getWriter();
			String action_code = checkForNull(req.getParameter("action_code"));
			if ( action_code.equals("L") )	insertLinkEncounter(req, res, locale);
			if ( action_code.equals("D"))	deleteLinkEncounter(req, res, locale);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
	try	{
	this.out = res.getWriter();
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");
	String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = req.getQueryString() ;
	String source = url + params ;
	out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
	}
	catch(Exception e)	{	
	out.println("Exception in doGet method :"+e.toString());
	}
	}

	private void insertLinkEncounter(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		String file_no				=	"";
		String file_type_code		=	"";
		String encounter_id			=	"";
		String encounter_date_time	=	"";
		String patient_class		=	"";
		String patient_id			=	"";
		String sqlString			=	"";
		String fileString			=	"";
		String error_value			=	"0";
		String error				=	"";		
		String volume_no			=	"";		
		String fs_location			=	"";		
		String fs_location_desc		=	"";		
		String document_no			=	"";		
		String doc_type_code		=	"";		
		String doc_type_desc		=	"";		
		String doc_folder_id		=	"";		
		String maintain_doc_or_file	=	"";		
		String num_of_zeros			=	"";
		String first_num_of_zeros	=	"";
		String new_file				=	"";
		String first_file			=	"";
		String doc_details			=	"";
		String doc_date				=	"";
		int records_modified		=	0;
		int patient_id_length		=	0;

		try
		{
			connection			=	ConnectionManager.getConnection(req);
			connection.setAutoCommit(false);

			file_no				=	checkForNull(req.getParameter("file_no"));
			file_type_code		=	checkForNull(req.getParameter("file_type"));
			encounter_id		=	checkForNull(req.getParameter("encounter_id"));
			encounter_date_time	=	checkForNull(req.getParameter("encounter_date_time"));
			patient_class		=	checkForNull(req.getParameter("patient_class"));
			patient_id			=	checkForNull(req.getParameter("patient_id"));
			doc_folder_id		=	checkForNull(req.getParameter("doc_folder_id"));
			maintain_doc_or_file=	checkForNull(req.getParameter("maintain_doc_or_file"));
			String addedById	=	checkForNull(p.getProperty("login_user"));

			if (maintain_doc_or_file.equals("D"))
			{
				sqlString		= "SELECT patient_id_length FROM mp_param ";	
				preStatement	=	connection.prepareStatement(sqlString);
				resultSet		=	preStatement.executeQuery();
				if ((resultSet!=null) && (resultSet.next()))
					patient_id_length	=	resultSet.getInt("patient_id_length");
				if (resultSet != null)  resultSet.close();
				if (preStatement != null)  preStatement.close();
				patient_id_length -= 2;	
				for (int i=0; i<patient_id_length; i++)
				{
					if (i==(patient_id_length-1))
						first_num_of_zeros	=	num_of_zeros+"1";
					num_of_zeros =num_of_zeros + "0";
				}
				first_file	=	"DT"+first_num_of_zeros;				
				fileString		= "select 'DT' || trim(to_char(max(to_number(substr(FILE_NO,3,?)))+1,'"+num_of_zeros+"')) new_file_no from fm_encounter_doc_type_link ";	
			}			
			sqlString =	"INSERT INTO fm_encounter_doc_type_link (facility_id, encounter_id, doc_type_code, file_no, file_type_code, volume_no, encounter_date_time, patient_id, patient_class, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id, doc_folder_id, fs_locn_code, DOC_DETAILS, DOC_DATE ) VALUES (?, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/rrrr hh24:mi'), ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, to_date(?, 'dd/mm/rrrr') )";

			ArrayList arrList	=	(ArrayList) session.getAttribute("documentArrList");			
			session.removeAttribute("documentArrList");
			try
			{
				Iterator	outItr = arrList.iterator();
				while (outItr.hasNext())
				{
					if (maintain_doc_or_file.equals("D"))
					{
						pStatement		=	null;
						pStatement		= connection.prepareStatement(fileString);
						pStatement.setInt(1, patient_id_length);						
						resultSet		= pStatement.executeQuery();
						if ((resultSet!=null) && (resultSet.next()))
							new_file	=	checkForNull(resultSet.getString("new_file_no"));
						if (new_file.equals("DT"))
							new_file = first_file;
						file_no	=	new_file;
						if (resultSet != null)  resultSet.close();
						if (pStatement != null)  pStatement.close();
					}					
					records_modified	=	0;
					Iterator	inItr	=	((ArrayList)outItr.next()).iterator();
					if (!maintain_doc_or_file.equals("D"))
						volume_no		=	(String)inItr.next();
					else
					{
						volume_no		=	"1";
						fs_location		=   (String)inItr.next();
						fs_location_desc=   (String)inItr.next();
					}
					document_no			=	(String)inItr.next();
					doc_type_code		=	(String)inItr.next();
					doc_type_desc		=	(String)inItr.next();
					doc_details			=	(String)inItr.next();
					doc_date			=	(String)inItr.next();
			
					preStatement		=	null;
					preStatement		=	connection.prepareStatement(sqlString);
					preStatement.setString(1, facility_id);
					preStatement.setString(2, encounter_id);
					preStatement.setString(3, doc_type_code);
					preStatement.setString(4, file_no);
					preStatement.setString(5, file_type_code);
					preStatement.setString(6, volume_no);
					preStatement.setString(7, encounter_date_time);
					preStatement.setString(8, patient_id);
					preStatement.setString(9, patient_class);
					preStatement.setString(10, addedById);
					preStatement.setString(11, client_ip_address);
					preStatement.setString(12, facility_id);
					preStatement.setString(13, addedById);
					preStatement.setString(14, client_ip_address);
					preStatement.setString(15, facility_id);
					preStatement.setString(16, doc_folder_id);
					preStatement.setString(17, fs_location);
					preStatement.setString(18, doc_details);
					preStatement.setString(19, doc_date);					
					records_modified = preStatement.executeUpdate();
					if (preStatement != null)  preStatement.close();
				}			
			}catch (Exception exception)
			{
				error	=	exception.toString();
			}
			if ( records_modified > 0)
			{
				error_value = "1" ;
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
				error	= (String) message.get("message") ;
				connection.commit();
				message.clear();
			}
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8" )+"&err_value="+error_value+"';</script>");
			arrList.clear();			
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
		finally
		{							
				ConnectionManager.returnConnection(connection, req);			
		}
	}
	
	private void deleteLinkEncounter(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		String doc_type_code		=	"";
		String encounter_id			=	"";
		String valid_values			=	"";
		String sqlString			=	"";
		String error_value			=	"0" ;
		String error				=	"";		
		int records_modified		=	0;		

		try
		{
			connection			=	ConnectionManager.getConnection(req);
			connection.setAutoCommit(false);

			valid_values		=	checkForNull(req.getParameter("valid_values"));			

			sqlString =	"DELETE FROM fm_encounter_doc_type_link WHERE facility_id = ? AND encounter_id = ? AND doc_type_code = ? ";
			preStatement		=	connection.prepareStatement(sqlString);
			
			StringTokenizer strToken	= null;
			StringTokenizer innerToken	= null;
			String tokenValue	=	"";
			if ((!valid_values.equals("")) && (!valid_values.equals(",")))
				strToken =  new StringTokenizer(valid_values, ",");
			
			try
			{
				while(strToken.hasMoreTokens())
				{
					tokenValue	= checkForNull(strToken.nextToken());
					if (!tokenValue.equals(""))
					{
						innerToken	= new StringTokenizer(tokenValue, "$$");	
						
						if(innerToken.hasMoreTokens())
							encounter_id	=	checkForNull(innerToken.nextToken());
						if(innerToken.hasMoreTokens())
							doc_type_code	=	checkForNull(innerToken.nextToken());
						
												
						preStatement.setString(1, facility_id);
						preStatement.setString(2, encounter_id);
						preStatement.setString(3, doc_type_code);
						
						records_modified = preStatement.executeUpdate();
					}
				}
			
			}catch (Exception exception)
			{
				error	=	exception.toString();
			}

			if ( records_modified > 0)
			{
				error_value = "1" ;
				//java.util.Hashtable message = MessageManager.getMessage(connection, RECORD_MODIFIED ) ;
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
				error	= (String) message.get("message") ;
				message.clear();
				connection.commit();
			}
			else if (records_modified == 0)
			{
				error_value = "0" ;
				error		=	"No Records Modified";
			}
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8" )+"&err_value="+error_value+"';</script>");			
			if (preStatement != null)  preStatement.close();
	}
	catch ( Exception e )
	{
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
	}
	finally
	{			
			ConnectionManager.returnConnection(connection, req);		
	}
}

	
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
}


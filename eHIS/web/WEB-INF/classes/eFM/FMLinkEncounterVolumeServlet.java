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
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

public class FMLinkEncounterVolumeServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;

	String facility_id			=	"";
	String client_ip_address	=	"";
	
	Connection	connection			=	null;
	ResultSet	resultSet			=	null;
	PreparedStatement preStatement	=	null;
	PreparedStatement preStatement1	=	null;
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
		session				=	req.getSession(false);
		this.p				=	(java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id	=	checkForNull((String) session.getValue("facility_id"));		
		p					=	(Properties) session.getValue("jdbc");
		locale = p.getProperty("LOCALE");
		client_ip_address	=	 p.getProperty("client_ip_address");

		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String action_code = checkForNull(req.getParameter("action_code"));
			if ( action_code.equals("L") )	insertLinkEncounter(req, res, locale);
			if ( action_code.equals("C"))	modifyLinkEncounter(req, res, locale);
			if ( action_code.equals("D"))	deleteLinkEncounter(req, res, locale);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
 	throws javax.servlet.ServletException,IOException
	{
		try	
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?" ;
			String params = req.getQueryString() ;
			String source = url + params ;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='../eSM/js/SiteParameter.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='" + source + "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eSM/jsp/SiteBlank.jsp' frameborder=0><frame name='messageFrame'	src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html>");
		}
		catch(Exception e)	
		{
			out.println("Exception in doGet method :"+e.toString());
			e.printStackTrace();
		}
	}

	private void insertLinkEncounter(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		String file_no				=	"";
		String file_type_code		=	"";
		String valid_values			=	"";
		String encounter_id			=	"";
		String encounter_date_time	=	"";
		String patient_class		=	"";
		String patient_id			=	"";
		String encounter_volume		=	"";
		String sqlString			=	"";
		String error_value			=	"0" ;
		String error				=	"";		
		int records_modified		=	0;
		int i						=	0;
		int j						=	0;
		int k						=	0;
		try
		{
			connection			=	ConnectionManager.getConnection(req);
			connection.setAutoCommit(false);

			file_no				=	checkForNull(req.getParameter("file_no"));
			file_type_code		=	checkForNull(req.getParameter("file_type_code"));
			valid_values		=	checkForNull(req.getParameter("valid_values"));
			encounter_id		=	checkForNull(req.getParameter("encounter_id"));
			encounter_date_time	=	checkForNull(req.getParameter("encounter_date_time"));
			/*if(!encounter_date_time.equals(""))
				encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM",locale,"en");*/
			patient_class		=	checkForNull(req.getParameter("patient_class"));
			patient_id			=	checkForNull(req.getParameter("patient_id"));	
			String addedById	=	checkForNull(p.getProperty("login_user"));

			StringTokenizer strToken	= null;
			StringTokenizer innerToken	= null;
			StringTokenizer lastToken	= null;

			int strCount	=	0;
			int innerCount	=	0;
			int lastCount	=	0;

			String tokenValue	=	"";

			if ((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken =  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}

			sqlString =	"INSERT INTO fm_encounter_volume_link (facility_id, file_no, file_type_code, volume_no, encounter_id, encounter_date_time, patient_id, patient_class, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id) VALUES (?, ?, ?, ?, ?, to_date(?, 'dd/mm/rrrr hh24:mi'), ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ? )";
			preStatement = connection.prepareStatement(sqlString);

			for (i=0; i<strCount; i++)
			{
				tokenValue = checkForNull(strToken.nextToken());
				if (!tokenValue.equals(""))
				{
					innerToken	=	new StringTokenizer(tokenValue, "||");
					innerCount	=	innerToken.countTokens();
					for (j=0; j<innerCount ; j++)
					{
						if (innerToken.hasMoreTokens())
							encounter_id		=	checkForNull(innerToken.nextToken());
						if (innerToken.hasMoreTokens())
							file_no				=	checkForNull(innerToken.nextToken());
						if (innerToken.hasMoreTokens())
							file_type_code		=	checkForNull(innerToken.nextToken());
						
						if (file_no.equals("$$"))	file_no = "";
						if (file_type_code.equals("$$"))	file_type_code = "";
						
						if (innerToken.hasMoreTokens())
							encounter_date_time	=	checkForNull(innerToken.nextToken());
						
						if (innerToken.hasMoreTokens())
							patient_class		=	checkForNull(innerToken.nextToken());
						lastToken	=	new StringTokenizer(patient_class, "^^");
						lastCount	=	lastToken.countTokens();
						for (k=0; k<lastCount; k++)
						{
							if (lastToken.hasMoreTokens())
								patient_class		=	checkForNull(lastToken.nextToken());
							if (lastToken.hasMoreTokens())
								encounter_volume	=	checkForNull(lastToken.nextToken());
						}
					}
					if(!encounter_date_time.equals(""))
						{
						 encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM",locale,"en");
						}
					
					preStatement.setString(1, facility_id);
					preStatement.setString(2, file_no);
					preStatement.setString(3, file_type_code);
					preStatement.setString(4, encounter_volume);
					preStatement.setString(5, encounter_id);
					preStatement.setString(6, encounter_date_time);
					preStatement.setString(7, patient_id);
					preStatement.setString(8, patient_class);
					preStatement.setString(9, addedById);
					preStatement.setString(10, client_ip_address);
					preStatement.setString(11, facility_id);
					preStatement.setString(12, addedById);
					preStatement.setString(13, client_ip_address);
					preStatement.setString(14, facility_id);

					records_modified = preStatement.executeUpdate();
				}
			}
			if(records_modified > 0)
			{
				error_value = "1" ;
				Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED", "SM" ) ;
				error	= (String) message.get("message") ;				
				connection.commit();
				message.clear();
			}
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value+"';</script>");
		if (preStatement != null)  preStatement.close();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet insertLinkEncounter ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(connection, req);		
		}
	}
	private void deleteLinkEncounter(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		String file_no				=	"";
		String file_type_code		=	"";
		String valid_values			=	"";
		String encounter_id			=	"";
		String encounter_date_time	=	"";
		String patient_class		=	"";	
		String encounter_volume		=	"";	
		String sqlString			=	"";
		String error_value			=	"0";
		String error				=	"";	
		
		int records_modified		=	0;
		int i						=	0;
		int j						=	0;
		int k						=	0;

		try
		{
			connection			=	ConnectionManager.getConnection(req);
			connection.setAutoCommit(false);

			file_no				=	checkForNull(req.getParameter("file_no"));
			file_type_code		=	checkForNull(req.getParameter("file_type_code"));
			valid_values		=	checkForNull(req.getParameter("valid_values"));
			encounter_id		=	checkForNull(req.getParameter("encounter_id"));
			encounter_date_time	=	checkForNull(req.getParameter("encounter_date_time"));
			patient_class		=	checkForNull(req.getParameter("patient_class"));
						
			StringTokenizer strToken	= null;
			StringTokenizer innerToken	= null;
			StringTokenizer lastToken	= null;

			int strCount	=	0;
			int innerCount	=	0;
			int lastCount	=	0;

			String tokenValue	=	"";

			if ((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken =  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}

			sqlString =	"DELETE FROM fm_encounter_volume_link WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND encounter_id = ? ";
			preStatement =	connection.prepareStatement(sqlString);

			for (i=0; i<strCount; i++)
			{
				tokenValue = checkForNull(strToken.nextToken());
				if(!tokenValue.equals(""))
				{
					innerToken	=	new StringTokenizer(tokenValue, "||");
					innerCount	=	innerToken.countTokens();
					for(j=0; j<innerCount; j++)
					{
						if(innerToken.hasMoreTokens())
							encounter_id	= checkForNull(innerToken.nextToken());
						if (innerToken.hasMoreTokens())
							file_no	= checkForNull(innerToken.nextToken());
						if (innerToken.hasMoreTokens())
							file_type_code	= checkForNull(innerToken.nextToken());
						
						if(file_no.equals("$$"))	file_no = "";
						if(file_type_code.equals("$$"))	file_type_code = "";
						
						if(innerToken.hasMoreTokens())
							encounter_date_time	= checkForNull(innerToken.nextToken());

						
						
						if(innerToken.hasMoreTokens())
							patient_class	= checkForNull(innerToken.nextToken());

						lastToken	= new StringTokenizer(patient_class, "^^");
						lastCount	= lastToken.countTokens();

						for(k=0; k<lastCount; k++)
						{
							if(lastToken.hasMoreTokens())
								patient_class	= checkForNull(lastToken.nextToken());
							if (lastToken.hasMoreTokens())
								encounter_volume	= checkForNull(lastToken.nextToken());
						}
					}
					
					if(!encounter_date_time.equals(""))
					{	encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM",locale,"en");
					}

					preStatement.setString(1, facility_id);
					preStatement.setString(2, file_no);
					preStatement.setString(3, encounter_volume);
					preStatement.setString(4, encounter_id);
					
					records_modified = preStatement.executeUpdate();
				}
			}
			
			if(records_modified > 0)
			{
				error_value = "1" ;
				Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
				error	= (String) message.get("message") ;				
				connection.commit();
				message.clear();
			}
			else if(records_modified == 0)
			{
				error_value = "0" ;
				error		=	"No Records Modified";
			}
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value+"';</script>");

			if(preStatement != null)  preStatement.close();
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet deleteLinkEncounter ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(connection, req);
		}
	}

	private void modifyLinkEncounter(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		String file_no				=	"";
		String file_type_code		=	"";
		String valid_values			=	"";
		String encounter_id			=	"";
		String encounter_date_time	=	"";
		String patient_class		=	"";
		String patient_id			=	"";	
		String sqlString			=	"";
		String error_value			=	"0";
		String error				=	"";		
		String volume_number		=	"";
		String updateString			=	"";
		
		int records_modified		= 0;
		int encounter_volume		= -1;
		int k						= 0;		
		int x						= 0;
		int y						= 0;

		try
		{
			connection			=	ConnectionManager.getConnection(req);
			connection.setAutoCommit(false);

			file_no				=	checkForNull(req.getParameter("file_no"));
			file_type_code		=	checkForNull(req.getParameter("file_type_code"));
			valid_values		=	checkForNull(req.getParameter("valid_values"));
			encounter_id		=	checkForNull(req.getParameter("encounter_id"));
			encounter_date_time	=	checkForNull(req.getParameter("encounter_date_time"));

			patient_class		=	checkForNull(req.getParameter("patient_class"));
			patient_id			=	checkForNull(req.getParameter("patient_id"));	
			
			String addedById	=	checkForNull(p.getProperty("login_user"));
			StringTokenizer strToken	= null;
			StringTokenizer innerToken	= null;
			StringTokenizer lastToken	= null;

			int strCount	=	0;
			int innerCount	=	0;
			int lastCount	=	0;

			String tokenValue	=	"";

			if((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken =  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}

			if((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken =  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}

			sqlString	=	"SELECT volume_no FROM fm_encounter_volume_link WHERE facility_id = ? AND file_no = ? AND patient_id = ? AND encounter_id = ? ";
			preStatement	=	connection.prepareStatement(sqlString);

			updateString = " UPDATE fm_encounter_volume_link set volume_no = ?, modified_by_id=?, modified_date=sysdate, modified_at_ws_no=?, modified_facility_id=? WHERE facility_id = ? AND file_no = ? AND volume_no = ? AND encounter_id = ? AND patient_id = ? "; 
			preStatement1 =	connection.prepareStatement(updateString);
			
			for(y=0; y<strCount; y++)
			{
				tokenValue = checkForNull(strToken.nextToken());
				if(!tokenValue.equals(""))
				{
					innerToken	=	new StringTokenizer(tokenValue, "||");
					innerCount	=	innerToken.countTokens();
					for(x=0; x<innerCount ; x++)
					{
						if(innerToken.hasMoreTokens())
							encounter_id		=	checkForNull(innerToken.nextToken());
						if(innerToken.hasMoreTokens())
							file_no				=	checkForNull(innerToken.nextToken());
						if(innerToken.hasMoreTokens())
							file_type_code		=	checkForNull(innerToken.nextToken());
						
						if(file_no.equals("$$"))	file_no = "";
						if(file_type_code.equals("$$"))	file_type_code = "";
						
						if(innerToken.hasMoreTokens())
							encounter_date_time	=	checkForNull(innerToken.nextToken());
						
						if(innerToken.hasMoreTokens())
							patient_class		=	checkForNull(innerToken.nextToken());
						lastToken	=	new StringTokenizer(patient_class, "^^");
						lastCount	=	lastToken.countTokens();

						for(k=0; k<lastCount; k++)
						{
							if(lastToken.hasMoreTokens())
								patient_class		=	checkForNull(lastToken.nextToken());
							if(lastToken.hasMoreTokens())
								volume_number		=	checkForNull(lastToken.nextToken());
						}
					
						if(!encounter_date_time.equals(""))
						{	encounter_date_time=DateUtils.convertDate(encounter_date_time,"DMYHM",locale,"en");
						}
					}

						preStatement.setString(1, facility_id);
						preStatement.setString(2, file_no);
						preStatement.setString(3, patient_id);
						preStatement.setString(4, encounter_id);

						resultSet	= preStatement.executeQuery();

						while((resultSet != null) && (resultSet.next()))
						{
							encounter_volume	=	resultSet.getInt("volume_no");

							preStatement1.setString(1, volume_number);
							/*Below line modified and added the audit column*/
							preStatement1.setString(2, addedById);
							preStatement1.setString(3, client_ip_address);
							preStatement1.setString(4, facility_id);							
							
							preStatement1.setString(5, facility_id);
							preStatement1.setString(6, file_no);
							preStatement1.setInt(7, encounter_volume);
							preStatement1.setString(8, encounter_id);
							preStatement1.setString(9, patient_id);

							records_modified = preStatement1.executeUpdate();
						}
						if(resultSet != null)  resultSet.close();
				}
			}
			if(records_modified > 0)
			{
				error_value = "1" ;
				Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
				error	= (String) message.get("message") ;				
				connection.commit();
				message.clear();
			}
			out.println("<Script>parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num="+ java.net.URLEncoder.encode( error,"UTF-8" )+"&err_value="+error_value+"';</script>");

			if(resultSet != null)  resultSet.close();
			if(preStatement != null)  preStatement.close();
			if(preStatement1 != null)  preStatement1.close();
			if(pStatement != null)  pStatement.close();
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet in modifyLinkEncounter ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();
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


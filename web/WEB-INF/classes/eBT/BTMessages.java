/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;

import java.sql.ResultSet;
import java.sql.Types;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import webbeans.eCommon.*;
import org.xml.sax.InputSource;
import eBT.*;

//import oracle.aurora.jndi.sess_iiop.ServiceCtx;

public class BTMessages extends javax.servlet.http.HttpServlet
{


public void init(ServletConfig config) throws ServletException	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws javax.servlet.ServletException,IOException
	{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");

	PrintWriter out;			
	 /* int flag=0;
	 int countMsg=0; */ //Commented Against Common-ICN-0045
	 String message_id="",message_txt="";
	 String query;
	//HttpSession session=req.getSession(true);

	HttpSession session=req.getSession(true);

	String local = (String)session.getAttribute("LOCALE");
	
	//res.setContentType("text/html");
	out=res.getWriter();

	message_id=req.getParameter("msg_id");

//	System.out.println(" EBT :"+message_id);

PreparedStatement pstmt=null;	
Connection con =null;
ResultSet resultSet =null;

 try{
	 con = ConnectionManager.getConnection(req);						
   
		query = "select message_id||'-'||NVL(message_text,message_text_sysdef) MSG_TXT from sm_message_lang_vw where UPPER(message_ref) = UPPER(?) and language_id = (select decode(count(1),1,?,'en') coun  from sm_message_lang_vw  where upper(message_Ref) = upper(?) and language_id = ?)"; 

			pstmt=con.prepareStatement(query);
			pstmt.setString(1, (message_id==null?"":message_id));
			pstmt.setString(2,local);
			pstmt.setString(3, (message_id==null?"":message_id)); 
			pstmt.setString(4,local);
			resultSet	= pstmt.executeQuery();	
			
	while(resultSet!= null && resultSet.next())
		{	
		message_txt=resultSet.getString( "MSG_TXT" );						
		}

	message_txt =(message_txt==null?"":message_txt);
	//System.out.println(" EBT :"+message_txt);
	 out.print(message_txt);
	 if(resultSet!=null) resultSet.close();
		}
		catch(Exception e)
		{
		//System.out.println(" EBT :"+e);
				out.print("0");
		}
		finally
		{
			try
			{
				if(resultSet!=null) resultSet.close();
				if(pstmt !=null) pstmt.close();
			
				ConnectionManager.returnConnection(con, req);
			}
			catch(Exception er)
			{
			}
		}
	}

}


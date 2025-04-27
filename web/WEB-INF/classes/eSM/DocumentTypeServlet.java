/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSM;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class DocumentTypeServlet extends javax.servlet.http.HttpServlet
{

	PrintWriter out;
	java.util.Properties p;
	String client_ip_address	= "";
	String facilityId			= "";
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	PreparedStatement pstmt2	= null;
	String added_facility_id	= "";
	String modified_facility_id = "";
	String added_by_id			= "";
	String modified_by_id		= "";
	String modified_at_ws_no	= "";
	String added_at_ws_no		= "";
	String locale				= "";
	String operation ="";
	Connection con = null;
	Statement stmt=null;

	ResultSet rs=null;
	Statement stmt1=null;
	Statement stmt2=null;
	String sql="";
	String sql1="";




public void init(ServletConfig config) throws ServletException	{
	super.init(config);
	}
public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{

	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");

	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = p.getProperty("client_ip_address");

	try {
		this.out = res.getWriter();
		this.facilityId = (String) session.getAttribute( "facility_id" ) ;
		added_facility_id = (String) session.getValue( "facility_id" ) ;
		modified_facility_id=added_facility_id;
		added_by_id	= (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		locale = p.getProperty("LOCALE");
		modified_by_id = added_by_id;
		added_at_ws_no = client_ip_address;
		modified_at_ws_no = client_ip_address ;

		operation=req.getParameter("operation")==null?"":req.getParameter("operation");



		if(operation.equals("insert"))
        insertDocumentType( req, res);

		if(operation.equals("modify"))
		modifyDocumentType(req,res);

	}
	catch (Exception e)	{
		out.println(e.toString());
		}
	}


private void insertDocumentType(HttpServletRequest req, HttpServletResponse res)	{

	try {



		  con = ConnectionManager.getConnection(req);
		  stmt=con.createStatement();
		  stmt1=con.createStatement();
		  stmt2=con.createStatement();
		  String doc_type_code = req.getParameter("doctype");
		  String long_desc= req.getParameter("longdescription");
		  String short_desc = req.getParameter("shortdescription");
		  String entity_or_facility_based= req.getParameter("basedon");
          String status= req.getParameter("eff_status");
		  //String MODULE_ID = req.getParameter("module_id");

		  //String ACC_ENTITY_CODE= req.getParameter("entitymode");
		  String DOC_PRINT_FLAG = req.getParameter("autoprint");
          String DOC_ENTRY_MODE= req.getParameter("entitymode");
          String start_doc_no= req.getParameter("startdocnum");
		  String next_doc_no= req.getParameter("nextdoctype");
		  String DOC_NUM_GEN_FLAG= req.getParameter("eff_status1");
		  int cnt = 0;
		  int maxRecordInt= Integer.parseInt(req.getParameter("cnt"));
		  //String doctype="";


		  boolean result = true;
		  String msg = "";
		  String error_val;
		  boolean isatLeastOneNumberingSelected=false;
		  //String message1="";



		  if(result)
		  {
			 String sql1="SELECT DOC_TYPE_CODE FROM SY_DOC_TYPE_MASTER  WHERE  DOC_TYPE_CODE ='"+doc_type_code+"'";
		rs=stmt.executeQuery(sql1);
		if(rs!=null && rs.next())
		{
			String error_value1 = "0" ;
			Hashtable hashtable1 = MessageManager.getMessage(locale, "CODE_ALREADY_EXISTS","Common");
             error_value1 = (String)hashtable1.get("message");
			 hashtable1.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error_value1,"UTF-8" )+"&err_value=1");
		}
         else
			  {


   pstmt = con.prepareStatement("INSERT INTO SY_DOC_TYPE_MASTER(DOC_TYPE_CODE, LONG_DESC, SHORT_DESC, ENTITY_OR_FACILITY_BASED,STATUS,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

			 pstmt.setString(1,doc_type_code);
			 pstmt.setString(2,long_desc);
			 pstmt.setString(3,short_desc);
			 pstmt.setString(4,entity_or_facility_based);
			 pstmt.setString(5,status);
			 pstmt.setString(6,added_by_id);
			 pstmt.setString(7,added_at_ws_no);
			 pstmt.setString(8,added_facility_id);
			 pstmt.setString(9,modified_by_id);
			 pstmt.setString(10,modified_at_ws_no);
			 pstmt.setString(11,modified_facility_id);

			 cnt = pstmt.executeUpdate();

			 if(cnt > 0)
				result	=	true;
					else
				result	=	false;

		 if(result)
		 {

			 pstmt2 = con.prepareStatement("INSERT INTO SY_ACC_ENTITY_DOC_TYPE(ACC_ENTITY_CODE,DOC_TYPE_CODE, DOC_NUM_GEN_FLAG,DOC_PRINT_FLAG,DOC_ENTRY_MODE,START_DOC_NO,NEXT_DOC_NO,STATUS,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date,modified_at_ws_no,modified_facility_id) VALUES (?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)");

			 pstmt2.setString(1,"ZZ");
			 pstmt2.setString(2,doc_type_code);
			 pstmt2.setString(3,DOC_NUM_GEN_FLAG);
			 pstmt2.setString(4,DOC_PRINT_FLAG);
			 pstmt2.setString(5,DOC_ENTRY_MODE);
			 pstmt2.setString(6, start_doc_no);
			 pstmt2.setString(7,next_doc_no);
			 pstmt2.setString(8,status);
			 pstmt2.setString(9,added_by_id);


			 pstmt2.setString(10,added_at_ws_no);
			 pstmt2.setString(11,added_facility_id);
			 pstmt2.setString(12,modified_by_id);

			 pstmt2.setString(13,modified_at_ws_no);
			 pstmt2.setString(14,modified_facility_id);
			 cnt=pstmt2.executeUpdate();
			 if(cnt > 0)
				result	=	true;
					else
				result	=	false;
		 }


		for(int i=0;i<maxRecordInt;i++)
		{
			String isSelect_YN = req.getParameter("select"+i);


			if(isSelect_YN!=null && isSelect_YN.equals("Y"))

			{

				String module_name = req.getParameter("module_id"+i);


				pstmt1 = con.prepareStatement("INSERT INTO SY_DOC_TYPE_MASTER_DTL(DOC_TYPE_CODE, MODULE_ID,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,sysdate,?,?,?,sysdate,?,?)");

				 pstmt1.setString(1,doc_type_code);
				 pstmt1.setString(2,module_name);
                 pstmt1.setString(3,added_by_id);
				 pstmt1.setString(4,added_at_ws_no);
				 pstmt1.setString(5,added_facility_id);
				 pstmt1.setString(6,modified_by_id);
				 pstmt1.setString(7,modified_at_ws_no);
				 pstmt1.setString(8,modified_facility_id);

				cnt=pstmt1.executeUpdate();

				if(cnt > 0)
					result	=	true;
				else
					result	=	false;


				 isatLeastOneNumberingSelected = true;
				if (pstmt1 != null) pstmt1.close();

			}

		}



			if(result)
			{
					con.commit();
					java.util.Hashtable message1 = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message1.get("message");
					message1.clear();
					error_val="1";

			}
			else if(!isatLeastOneNumberingSelected)
			{
				con.rollback();
				java.util.Hashtable message1 = MessageManager.getMessage( locale, "ATLEAST_ONE_SELECTED","Common" ) ;
				msg = (String) message1.get("message");
              message1.clear();
				error_val="0";
			}
			else
			{
					con.rollback();
					java.util.Hashtable message1 = MessageManager.getMessage( locale, "ATLEAST_ONE_SELECTED","Common" ) ;
					msg = (String)message1.get("message");
					message1.clear();
					error_val="0";
			}


			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);


		if (pstmt1 != null) pstmt1.close();
		if (pstmt != null) pstmt.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
		if (stmt2 != null) stmt2.close();
		rs.close();



	}
	}
	}
	catch ( Exception e ) {
		out.println(e.getMessage());
		out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,req);

	}
	}


	private void modifyDocumentType(HttpServletRequest req, HttpServletResponse res)	{

		try
		{
	      con = ConnectionManager.getConnection(req);
		  stmt=con.createStatement();
		  stmt1=con.createStatement();
		  stmt2=con.createStatement();

		  String doc_type_code = req.getParameter("doctype");
		  String long_desc= req.getParameter("longdescription");
		  String short_desc = req.getParameter("shortdescription");
		  String entity_or_facility_based= req.getParameter("basedon");
          String status= req.getParameter("eff_status");
		  //String module_id = req.getParameter("module_id");
		  //String ACC_ENTITY_CODE= req.getParameter("entitymode");
		  String DOC_PRINT_FLAG = req.getParameter("autoprint");
          String DOC_ENTRY_MODE= req.getParameter("entitymode");
          String start_doc_no= req.getParameter("startdocnum");
		  String next_doc_no= req.getParameter("nextdoctype");
		  String DOC_NUM_GEN_FLAG= req.getParameter("eff_status1");
		  int cnt = 0;
		  int maxRecordInt= Integer.parseInt(req.getParameter("cnt"));
		  //String doctype="";
		  boolean result = true;
		  String msg = "";
		  String error_val;
		  boolean isatLeastOneNumberingSelected=false;



		if(result)
		{
			sql = "UPDATE SY_DOC_TYPE_MASTER SET DOC_TYPE_CODE='"+doc_type_code+"',LONG_DESC='"+long_desc+"',SHORT_DESC='"+short_desc+"', ENTITY_OR_FACILITY_BASED='"+entity_or_facility_based+"',STATUS="+status+",modified_by_id='"+modified_by_id+"',modified_date=sysdate,modified_at_ws_no='"+modified_at_ws_no+"',modified_facility_id='"+modified_facility_id+"' where DOC_TYPE_CODE='"+doc_type_code+"'";

			cnt = stmt.executeUpdate(sql);
			if(cnt > 0)
				result	=	true;
			else
				result	=	false;
		}

		if(result)
		 {


			sql1 = "UPDATE SY_ACC_ENTITY_DOC_TYPE SET ACC_ENTITY_CODE='ZZ',DOC_TYPE_CODE='"+doc_type_code+"',DOC_NUM_GEN_FLAG='"+DOC_NUM_GEN_FLAG+"', DOC_PRINT_FLAG='"+DOC_PRINT_FLAG+"',DOC_ENTRY_MODE='"+DOC_ENTRY_MODE+"',START_DOC_NO='"+start_doc_no+"',NEXT_DOC_NO='"+next_doc_no+"',STATUS="+status+",modified_by_id='"+modified_by_id+"',modified_date=sysdate,modified_at_ws_no='"+modified_at_ws_no+"',modified_facility_id='"+modified_facility_id+"' where DOC_TYPE_CODE='"+doc_type_code+"'";

            cnt=stmt1.executeUpdate(sql1);
   		    if(cnt > 0)
				result	=	true;
			else
				result	=	false;
		 }
		 pstmt1 = con.prepareStatement("INSERT INTO SY_DOC_TYPE_MASTER_DTL(DOC_TYPE_CODE, MODULE_ID,ADDED_BY_ID,added_date, added_at_ws_no,added_facility_id, modified_by_id,modified_date, modified_at_ws_no,modified_facility_id) VALUES (?,?,?,sysdate,?,?,?,sysdate,?,?)");

		for(int i=0;i<maxRecordInt;i++)
		{
			String isSelect_YN = req.getParameter("select"+i);

			if(isSelect_YN!=null && isSelect_YN.equals("Y"))
			{
				String module_name = req.getParameter("module_id"+i);
				 pstmt1.setString(1,doc_type_code);
				 pstmt1.setString(2,module_name);
                 pstmt1.setString(3,added_by_id);
				 pstmt1.setString(4,added_at_ws_no);
				 pstmt1.setString(5,added_facility_id);
				 pstmt1.setString(6,modified_by_id);
				 pstmt1.setString(7,modified_at_ws_no);
				 pstmt1.setString(8,modified_facility_id);
	             cnt=pstmt1.executeUpdate();
				 if(cnt > 0)
					result	=	true;
				 else
					result	=	false;

				 isatLeastOneNumberingSelected = true;
			}
		}
		if(result)
			{
					con.commit();
					java.util.Hashtable message1 = MessageManager.getMessage( locale, "RECORD_MODIFIED","SM" ) ;
					msg = (String) message1.get("message");
					message1.clear();
					error_val="1";

			}
			else if(!isatLeastOneNumberingSelected)
			{
				con.rollback();
				java.util.Hashtable message1 = MessageManager.getMessage( locale, "ATLEAST_ONE_SELECTED","Common" ) ;
				msg = (String) message1.get("message");
              message1.clear();
				error_val="0";
			}
			else
			{
					con.rollback();
					java.util.Hashtable message1 = MessageManager.getMessage( locale, "ATLEAST_ONE_SELECTED","Common" ) ;
					msg = (String)message1.get("message");
					message1.clear();
					error_val="0";
			}
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode(msg, "UTF-8") + "&err_value=" + error_val);


		if (pstmt1 != null) pstmt1.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
		if (stmt2 != null) stmt2.close();

	}

	catch ( Exception e ) {
		/*out.println(e.getMessage());
		out.println(e.toString()); */
		e.printStackTrace();
		}
	finally
	{
		ConnectionManager.returnConnection(con,req);

	}

	}


}



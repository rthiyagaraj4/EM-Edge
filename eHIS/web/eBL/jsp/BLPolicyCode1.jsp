<!DOCTYPE html>
<!--
	Author		 		:	Prakash.S
	Created on 			:	16th Jan 2002
	Last Modified on	:	16th Jan 2002
	Module/Function		:	BL - Get Policy Type Code
	Purpose				:	This function is used to populate the Reference Source Code depending up on 
							the Facility selected by the user (Either Enterprise/External).
-->

<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{

	con	=	ConnectionManager.getConnection(request);
	//Connection con = (Connection) session.getValue("connection");
	request.setCharacterEncoding("UTF-8");
	//facility_id  =  (String) session.getValue("facility_id") ;
	String cust_code="",policy_type_code="",short_desc="";
	String query_ref_source="" /*,facility_id="" */ ;
	cust_code	= 	request.getParameter("cust_code");

	if(cust_code==null) cust_code="";
	cust_code=cust_code.trim();

	out.println("<html><head>");

	//out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");


	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<link rel='StyleSheet' href='../../eCommon/html/'"+sStyle+" type='text/css'/>");

//	out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");
	//out.println("<script language='javascript'>");
	//out.println("alert(\"hi in temp Jsp\");");
	//out.println("alert(parent.frames[1].document.forms[0].name);");
	
	
		stmt = con.createStatement();
		
		out.println("<script language='javascript'>");
		
		query_ref_source = "Select short_desc, policy_type_code from bl_ins_policy_types_lang_ve where language_id='"+locale+"' and cust_code='"+cust_code+"' and nvl(status,'N') <> 'S' order by short_desc";

		//out.println("</head><body><br>Query : "+query_ref_source+"</body>");
		
		rs = stmt.executeQuery(query_ref_source);

		out.println("var policy_type_code	= 'select';");
		out.println("var short_desc	= '         ---- Select ----       ';");
		out.println("var opt=parent.frames[1].frames[0].document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	policy_type_code; ");
		out.println("parent.frames[1].frames[0].document.forms[0].policy_type.add(opt); ");
		out.println("parent.frames[1].frames[0].document.forms[0].policy_type.selectedIndex = 0;");
		while(rs.next())
		{
			
			policy_type_code	=	rs.getString("policy_type_code");
			short_desc	=	rs.getString("short_desc");

			out.println("var policy_type_code	= '"+policy_type_code+"';");
			out.println("var short_desc	= '"+short_desc+"';");

			out.println("var opt = parent.frames[1].frames[0].document.createElement('OPTION'); ");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	policy_type_code; ");
			out.println("parent.frames[1].frames[0].document.forms[0].policy_type.add(opt); ");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE'> </body></html>");
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body CLASS='MESSAGE'>");
		//out.println("Exception@1 : "+e);
		e.printStackTrace();
		out.println("</body></html>");
	}
	finally
	{
		if (rs != null)   rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	//out.println("</script></head><body CLASS='MESSAGE'> </body></html>");

%>


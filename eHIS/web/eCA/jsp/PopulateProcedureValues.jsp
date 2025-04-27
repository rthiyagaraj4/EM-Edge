<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs   = null;
	//String locale=(String)session.getValue( "LOCALE" ) ;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String sql_query = "", practitioner = "", pract_name="";
	String operating_facility_id="";
	String practitionername="";
	String practitionerid="";
	StringTokenizer str=null;
	try
	{
		 practitioner=request.getParameter("pract_name");
		 practitioner=java.net.URLDecoder.decode(practitioner);
		 str	=	new StringTokenizer(practitioner,"|");
			while(str.hasMoreTokens())
				{
					str.nextToken();
					pract_name= str.nextToken();
					
				}
		 operating_facility_id=(String) session.getValue("facility_id");
		  
		con = ConnectionManager.getConnection(request);
		//sql_query="Select practitioner_name,practitioner_id from am_pract_for_facility_vw where operating_facility_id= ? /*and practitioner_name !=?*/ and eff_status='E' /*and pract_type='SG'*/ order by 1";
		sql_query="Select b.practitioner_name,practitioner_id from am_pract_for_facility a, am_practitioner_lang_vw b  where operating_facility_id= ? /*and practitioner_name !=?*/ and eff_status='E' /*and pract_type='SG'*/ and a.practitioner_id = b.practitioner_id and b.language_id = ? order by 1";
		stmt = con.prepareStatement(sql_query);
		stmt.setString(1,operating_facility_id);
		stmt.setString(2,locale);
		//stmt.setString(2,pract_name);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			practitionername	= rs.getString("practitioner_name");
			practitionername=java.net.URLEncoder.encode(practitionername);
			practitionername=practitionername.replace('+',' ');
			practitionername=practitionername.replace('%',' ');
			practitionername=practitionername.replace('2',' ');
			practitionername=practitionername.replace('7',' ');
			practitionername.trim();
			practitionerid		= rs.getString("practitioner_id");
			practitionerid=java.net.URLEncoder.encode(practitionerid);
			if((practitionername == null) || practitionername.equals("null"))practitionername="";
			if((practitionerid == null) || practitionerid.equals("null"))practitionerid="";
			if (!pract_name.equals(practitionername))
			{
			%>
			  <script>
			if(parent.frame2){
			var element = parent.frames[2].document.createElement('OPTION');
			element.text = '<%=practitionername%>';
			element.value=  '<%=practitionerid%>';
			//alert(frames[1].name);
				parent.frame2.document.OPProc_form.practitioner1.add(element);
			}else {
			var element = parent.frames[2].document.createElement('OPTION');
			element.text = '<%=practitionername%>';
			element.value=  '<%=practitionerid%>';
			//alert(frames[1].name);
				parent.workAreaFrame.frame2.document.OPProc_form.practitioner1.add(element);
			}

			</script> 
			<%
			}
		}
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();	
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		
		ConnectionManager.returnConnection(con, request);
	}
	
%>

<body class=message  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>


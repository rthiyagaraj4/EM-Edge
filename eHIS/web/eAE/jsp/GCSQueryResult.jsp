<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

 <BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> 

<% 
		request.setCharacterEncoding("UTF-8");
		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		int i=0;

	try
	{ 
      con =  ConnectionManager.getConnection(request);
	  stmt = con.createStatement();
	  String strsql2="select APPL_GCS_RESPONSE_CODE,GCS_CODE,GCS_DESC,GCS_RESPONSE_DESC from AE_GCS_FOR_RESPONSE_VW order by GCS_CODE";
 	  rs = stmt.executeQuery(strsql2);
%>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='60%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th width='30%'><fmt:message key="eAE.GCSCategory.label" bundle="${ae_labels}"/></th>
<%
	
 String classValue = "" ;
while ( rs!=null && rs.next())
 {
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	
	out.println("<tr><td class='"+classValue+"'>");
	String gcs_code = rs.getString("GCS_CODE");
	out.println("<a href='../../eAE/jsp/ModifyGCSforResponse.jsp?gcs_code="+gcs_code+"' target='f_query_add_mod' >");
	out.println(gcs_code+"</td><td class='"+classValue+"'>");
	String gcs_desc= rs.getString("GCS_DESC");
	out.println(gcs_desc+"</td><td class='"+classValue+"'>");
	String gcs_response_desc= rs.getString("GCS_RESPONSE_DESC");
	out.println(gcs_response_desc+"</td>");
	i++;
 }//endwhile 
 %>
</td></tr>
</table>
<br><center>
</center>
<%


 if(rs!=null)	rs.close();
 if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
		e.printStackTrace();
     }
	finally   
	{
		 if(con!=null)		
		 ConnectionManager.returnConnection(con,request);
    }
%>
</BODY>
</HTML>


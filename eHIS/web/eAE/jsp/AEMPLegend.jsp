<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<%
    String color            ="";
    String sql              ="";
	String  green           ="";
	String red              ="";
    String yellow           ="";
    String unassigned       ="";	
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	String locale		    = (String)session.getAttribute("LOCALE");
	Connection con		= ConnectionManager.getConnection(request); 
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	
	
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<table border='1' cellpadding='0' cellspacing='2' width='100%'>
<tr>
	<td width='5%' class='label' align='RIGHT' nowrap><b><fmt:message key="Common.priority.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;</b></td>
	 	 
	 <%
	 try
	{
	 
	   sql="SELECT PRIORITY_ZONE_TAB_DESC,PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' ";
			
		if(!five_level_triage_appl_yn.equals("Y")){
				sql	= sql + "  and priority_zone not in ('B','W') ";
		}
		sql= sql + " order by PRIORITY_ZONE_ORDER asc";
	    pstmt   = con.prepareStatement(sql.toString());
		pstmt.setString(1,locale) ;
	    rset    = pstmt.executeQuery();
		while(rset!=null && rset.next())
		{
		String pri_zone_desc=rset.getString("PRIORITY_ZONE_TAB_DESC")==null?"":rset.getString("PRIORITY_ZONE_TAB_DESC");
		String pri_zone_color=rset.getString("PRIORITY_ZONE_COLOR")==null?"":rset.getString("PRIORITY_ZONE_COLOR");
		 out.println("<td  style=background-color:"+pri_zone_color+">"+pri_zone_desc+"</td>");
		}
		    
			
	}
	 catch(Exception e)
	{
	e.printStackTrace();
	}
finally 
{
if(pstmt!=null) pstmt.close();
if(rset!=null) rset.close();
if(con!=null)ConnectionManager.returnConnection(con,request);

		
}
	 
	 
	 %>
	
	
</tr>
</table>
</body>
</html>


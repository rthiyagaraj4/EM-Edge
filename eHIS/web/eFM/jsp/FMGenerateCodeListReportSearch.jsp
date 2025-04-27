<!DOCTYPE html>
<!-- Developed By	   :-	Prashant Bhalsingh
	 Created on   	   :	24/06/2001
	 Module Name 	   :	FM\File Code report
-->
<%@ page import="java.sql.*, java.util.*, webbeans.eCommon.* , java.text.* "  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src="../../eFM/js/repcodeCheck.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 </head>
<BODY onMouseDown="CodeArrest();"  onload='' onKeyDown = 'lockKey();'>
<form name="ReportSearch" id="ReportSearch" action="" method="post" target="messageFrame">
<body  OnMouseDown="CodeArrest()" onLoad="codeCheck('code');" onKeyDown = 'lockKey();'>
<BR>
<div align="left">
<table border="0" cellpadding="3" cellspacing="0"  align='center' width='30%'>
<tr>
	  <td width='10%' >&nbsp;</td>
      <td class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td class='fields'><select name="code" id="code" onChange="codeCheck(this.value);" >
	<option value=' ' selected>----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------</option>
	<%
		
			 Connection con = null; 
			 Statement stmt =null;
			 ResultSet rs =null;   	
	
	try {
			  con = ConnectionManager.getConnection(request);

			  stmt = con.createStatement();
			  
			  String sql = "Select  master_code,master_code_desc from sm_master_code_lang_vw where module_id='FM' and language_id='"+localeName+"' order by master_code_desc";
				
			  rs = stmt.executeQuery(sql);
			  if( rs != null )
			  {
				  while( rs.next())
				  {
					String classname = rs.getString("master_code") ;
					String classname1=rs.getString("master_code_desc");

	%>
	
	<option value='<%= classname %>'><%= classname1%></option>
	
	<%
				  }
			  }
	if (stmt != null) stmt.close();
	 if (rs != null)   rs.close();
	}
	catch(Exception e) { out.println(e.toString());}

	finally {	  
	  ConnectionManager.returnConnection(con,request);
	}

	%>
    </select></td>
    <td width='10%' >&nbsp</td></tr>
    </table>
</div>
</form>
</body>
 </html>


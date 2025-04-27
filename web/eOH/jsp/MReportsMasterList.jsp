<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
   request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/><Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language='javascript' src='../../eOH/js/MasterReports.js'></script> 
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
//String mode=request.getParameter("mode");
String master_code_desc="";
String table_id="";
String sql = "";
%>
<form onload='FocusFirstElement()'  action="" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>
 <tr>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
<td width='25%'>&nbsp;</td>
</tr> 
<tr>
<td>&nbsp;</td>
	<td class='label' colspan='3'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	<select name="master_list" id="master_list" onChange="loadPage(this.value)" >
 	<option value='' selected><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
	<% 
	try{
        con=ConnectionManager.getConnection(request);
		sql="SELECT TABLE_ID, MASTER_CODE_DESC FROM SM_MASTER_CODE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=? ORDER BY MASTER_CODE_DESC";
		pstmt=con.prepareStatement(sql);
	    pstmt.setString(1,"OH");
	    pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
	    while(rs.next()){
			table_id=rs.getString(1);
			master_code_desc=rs.getString(2);
	%>	
			<option value= "<%=table_id%>"> <%=master_code_desc%> </option>
        <% 
		}%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'>
		
	<% 
	}catch(Exception e){
		out.println("exp"+e);
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			out.println("exp"+e);
		}
	}
%>

</td>

</tr>
 <tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr> 
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>



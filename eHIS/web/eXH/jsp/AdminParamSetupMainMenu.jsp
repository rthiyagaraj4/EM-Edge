<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page import = "java.util.*" %>
<html>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language=JavaScript src="../../eCommon/js/menu.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eXH/js/Adminmenu.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>

	<body style="background-color:dimgray;"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="XHAdminMenuForm" id="XHAdminMenuForm">
	<input type=hidden name='menu_values' id='menu_values'>

	<table cellspacing=1 cellpadding=3 width='100%' align=center id='t'>
	<%

	Connection con=null;
	Statement stmt=null;
	ResultSet rset=null;
	con=ConnectionManager.getConnection(request);
	String sql1="select MODULE_ID,FUNCTION_ID,FUNCTION_NAME,FUNCTION_TYPE,EXECUTABLE_NAME,INSERT_ACCESS_YN,UPDATE_ACCESS_YN,QUERY_ONLY_ACCESS_YN,DELETE_ACCESS_YN,PRINT_ACCESS_YN from sm_function where FUNCTION_PARAMETERS like '%group=A%' order by to_number(substr(FUNCTION_PARAMETERS,1,instr(FUNCTION_PARAMETERS,'+')-1)) asc";
	stmt=con.createStatement();
	rset=stmt.executeQuery(sql1);

	 while(rset.next())
	  {

	 %>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('<%=rset.getString(5)+"?"+"module_id=XH"+"&"+"function_id="+rset.getString(2)+"&"+"function_name="+rset.getString(3)+"&"+"function_type="+rset.getString(4)+"&"+"access="+rset.getString(6)+rset.getString(7)+rset.getString(8)+rset.getString(9)+rset.getString(10)%>')"><%=rset.getString(3)%></td>
		</tr>

	
	<%
	  }
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	if(con!=null) con.close();

	%>
	<tr>
		<td class='MENUHIGHERLEVELCOLOR'>
		<a href='javascript:goHomePage()' style='color:white;'><b><fmt:message key="eXH.MENU.Label" bundle="${xh_labels}"/></b></a></td>
		</tr>

	</table>
	</body>
	</form>
</html>


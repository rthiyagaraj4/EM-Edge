<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,java.sql.ResultSetMetaData,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
ResultSetMetaData rsmd = null;
//String selected = "selected";
//String defaultval = "";
%>
<HEAD>
<%											    
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/QueryBuilder.js" ></script> 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">
alert("QueryBuilderSelectMaster");
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%

String mode			=	request.getParameter("mode");

%>

<form name="QueryBuilder_setup_form" id="QueryBuilder_setup_form" target='messageFrame' method='post' action=''>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>

<tr>
<td class=label > <fmt:message key="Common.Table.label" bundle="${common_labels}"/></td> 


<td class='fields'>
<%
try
{
con=ConnectionManager.getConnection();
//String qry = "SELECT table_name FROM user_tables where table_name like 'XH_%' ORDER BY 1";
String qry = "SELECT table_name FROM user_tables where TABLE_NAME LIKE 'XH%'";
//System.out.println("QueryBuilderSelectMaster qry : "+qry);
//stmt = con.createStatement();
stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
rs = stmt.executeQuery(qry);

rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();
//System.out.println("QueryBuilderSelectMaster Col Cnt : "+numberOfColumns);
String colName = rsmd.getColumnName(1); 
//System.out.println("QueryBuilderSelectMaster col Name : "+colName);
rs.last();
int rowcount = rs.getRow();
//System.out.println("QueryBuilderSelectMaster rowcount : "+rowcount);

%>
<select class='select' name='table_nam' id='table_nam' >
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>
		<!--
			  <option value='XH_APPLICATION'>XH_APPLICATION</option> -->
		  
	<%
		while(rs.next())
            {     
			 //System.out.println("Table : "+rs.getString(1));

	%>
		<option value=''><%=rs.getString(1)%> </option>
    <% 	
			}
	%>

</select>
<%

}catch(Exception e1){
	//System.out.println("Table Val Excptn : ");
	System.out.println("QueryBuilderSelectMaster.jsp:Exception-3 "+e1.toString());
	e1.printStackTrace(System.err);
}

%>
</td>

<td> </td> <td> </td> </tr>
<tr>
<td class=label ><fmt:message key="eXH.Columns.Label" bundle="${xh_labels}"/></td> 

<td class='fields'>
<select class='select' name='col_name' id='col_name' multiple >
            <option value=''>-------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>
			<!--
		    <option value='APPLICATION_ID'>APPLICATION_ID</option>
	  	    <option value='APPLICATION_NAME'>APPLICATION_NAME</option>
			-->
</select>
</td> 

<td> </td> <td> </td> </tr>
<!--
<tr>
<td class=label ><fmt:message key="eXH.WhereClause.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="whereClause"  name =whereClause size=40> </td>
<td> </td>
<td colspan=4 class= 'BUTTON'><input class='BUTTON' type="button"  name=query value='<fmt:message key="Common.query.label" bundle="${common_labels}"/>' onClick='getQuery();'></td>
</tr>

<tr>
<td class=label ><fmt:message key="eXH.QueryText.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text id="qyeryText"  name =queryText size=40> </td>
<td> </td><td> </td>
</tr>
-->
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>
	
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 


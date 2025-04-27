<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<html>
<%
	//String search_text="";
	String column_names = "";
	String column_descriptions = request.getParameter("column_descriptions");
	String column_sizes = request.getParameter("column_sizes");
	String column_types = "";
	String search_by_index = "";
	String sql = request.getParameter( "sql");
	String strColumnDelimiter = ",";
	String message = request.getParameter("message");
	message = (message == null) ? " ":message;
%>
<head>
<%	request.setCharacterEncoding("UTF-8");	%>
<title> <%= request.getParameter("title")%></title>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<script>

	function closew()
	{
		parent.window.close();
	}
	function CallDescFrame()
	{
		var search_by_index = document.forms[0].search_by.selectedIndex;


		document.forms[0].search_by_index.value = search_by_index;
		document.forms[0].submit();
	 }

	 function valtext(comp)
	 {
		 var txt=comp.value;
		CallDescFrame(this);
	}
</script>

<body onLoad = "document.getElementById("search_text").focus()">
<form name='frm_search_criteria' id='frm_search_criteria' ACTION='EBTLookupBody.jsp' method='post' target='code_desc'>
<%
Connection conn = null;
try
	{
	//	System.out.println("EBT = EBT LOOKUP HEADER ");
		conn = ConnectionManager.getConnection(request);
		
		PreparedStatement prepareStatement = conn.prepareStatement(sql);
				
		prepareStatement.execute();
		ResultSetMetaData rmeta = prepareStatement.getMetaData();
		int intCount = rmeta.getColumnCount() ;
		String strTempColumnTypeName = "";
		for (int i=1;i<=intCount ;i++ )
		{
			column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
			strTempColumnTypeName = rmeta.getColumnTypeName(i);
			if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
			{
				strTempColumnTypeName = "VARCHAR2";
			}
			column_types = column_types + rmeta.getColumnTypeName(i) + strColumnDelimiter;
		}
			prepareStatement.close();
			ConnectionManager.returnConnection(conn, request);
	}
	catch(Exception ex)
	{
						
			ConnectionManager.returnConnection(conn, request);
	}

%>

<table align='right'  border="0" width=100% cellspacing='0' cellpadding='0'>
	<tr width='100'>
		<td>&nbsp;</td>
		<td colspan=2  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<select name="search_by" id="search_by">
		<%
		boolean first =  true;
		String strTempSelected = "SELECTED";
		StringTokenizer strColumnTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
		StringTokenizer strColumnDescriptionsTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
		while(strColumnTokenizer.hasMoreElements())
		{
			if (first) 
			{
				strTempSelected = "SELECTED";
				first = false;
			}
			else
			{
				strTempSelected = " ";
			}
	
			out.println("<option value='"+strColumnTokenizer.nextElement()+"'  "+ strTempSelected+"  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+strColumnDescriptionsTokenizer.nextElement(),"bt_labels")+"</option>");
			/*out.println("<option value='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+strColumnTokenizer.nextElement(),"bt_labels")+"'  "+ strTempSelected+"  >"+strColumnDescriptionsTokenizer.nextElement()+"</option>");*/

			/*out.println("<option value='"+strColumnTokenizer.nextElement()+"'  "+ strTempSelected+"  >"+strColumnDescriptionsTokenizer.nextElement()+"</option>");
		*/
		}
		%>


		</select>
		&nbsp;<b class='label'><%=message%></b>
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;&nbsp;</td>
		<td class='label' colspan=2  ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		<input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text" value='' width=30% align="left" size='40' maxlength='70' >
		&nbsp;
		<select name="search_criteria" id="search_criteria">
		<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		</select>

		</td>
		<td align='right'><input type="button" width='20%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="valtext(search_text); " class='button' >
		</td>
	</tr>
</table>
<input type='hidden' name='column_names' id='column_names' value="<%=column_names%>">
<input type='hidden' name='column_descriptions' id='column_descriptions' value="<%=column_descriptions%>">
<input type='hidden' name='column_sizes' id='column_sizes' value="<%=column_sizes%>">
<input type='hidden' name='column_types' id='column_types' value="<%=column_types%>">
<input type='hidden' name='search_by_index' id='search_by_index' value="<%=search_by_index%>">
<input type='hidden' name='sql' id='sql' value="<%=sql%>">

<BR>
<BR>
</form>
</body>
</html>


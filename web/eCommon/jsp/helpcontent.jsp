<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"
 import="java.sql.*, java.util.*, java.text.*" %>

<%
request.setCharacterEncoding("UTF-8");	

	String FunctionID = request.getParameter("FunctionID");
	String no_of_pages =  request.getParameter("no_of_pages");
	String min_val = request.getParameter("minimum_value");

	if(min_val == null)
		min_val = "1";

	int max_val = Integer.parseInt(min_val)+10;
	int i=1;
%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../html/IeStyle.css"></link>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function OnSelect(index)
{
	var file = "../../eMP/help/PATREG"+index+".htm";	parent.frames[0].document.location.href=file;
}

function Dialog(ind)
{
		var retVal = new String();
		var dialogHeight = "25" ;
		var dialogWidth = "48" ;
		var status = "no";
		var scroll = "yes";
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll;
		var arguments	= "" ;
		var file = "/eHIS/ph/DOC/PATREG"+ind+".html";

		retVal = window.showModalDialog(file,arguments,features);
}

function Previous()
{
	var min = '<%=min_val%>';
	if(min != "1")
		min = parseInt(min)-1;

	parent.frames[1].document.location.href="../../eCommon/jsp/helpcontent.jsp?FunctionID=<%=FunctionID%>&no_of_pages=<%=no_of_pages%>&minimum_value="+min;
}

function Next()
{
	var minimum = '<%=min_val%>';
	var noofpages = '<%=no_of_pages%>';
	var maximum = parseInt(minimum)+9;

	if(maximum != noofpages)
		minimum = parseInt(minimum)+1;

	parent.frames[1].document.location.href="../../eCommon/jsp/helpcontent.jsp?FunctionID=<%=FunctionID%>&no_of_pages=<%=no_of_pages%>&minimum_value="+minimum;
}

</script>
</head>
<body  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='helpcontent' id='helpcontent' >
<table width='50%' align='center'>
<br>
<tr>
<%

//	for(i = 1;i < Integer.parseInt(no_of_pages);i++)
	out.println("<td width='3%'><input type='button' class='button' name='prev' id='prev' value='<--' onClick='Previous();'></td>");
	for(i = Integer.parseInt(min_val);i < max_val;i++)
	{
		out.println("<td width='5%' align='center'><a href=\"javascript:OnSelect('"+i+"')\">");
		out.println(i+"</a></td>");
	}
	out.println("<td width='3%'><input type='button' class='button' name='next' id='next' value='-->' onClick='Next();'></td>");
%>
</tr>

</table>
</form>
</body>
</html>


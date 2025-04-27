<!DOCTYPE html>
<html>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<head>

<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferenceapplelement.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="post" action=''  >
<%
boolean boolToggle =  true;	
String strTDClass = "";
String strBeanName = XHApplicationElementControllerBean.strBeanName;
Connection conn = null;
ArrayList arrRow = null;
ArrayList arrCol = null;
HashMap resultsQry=null;
String strPrevious = "";
String strNext  = "";
try
{
	conn = ConnectionManager.getConnection(request);
	XHApplicationElementControllerBean	xhBean = XHApplicationElementControllerBean.getBean(strBeanName,request,session);
	xhBean.action(request,conn);
	resultsQry = xhBean.getResultSet();
	arrRow = (ArrayList)resultsQry.get("qry_result"); 
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}

	}
	
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>

<%
if(arrRow.size()==0)
{
%>
<script>
   alert(getMessage('XH1013','XH'));
</script>
<% } else { %>

	<tr>
	
	<td colspan="4" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER' width='40%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'width='20%'><fmt:message key="eXH.FormatType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>

</tr>
	<%
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
        
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
	%>
	<tr>
	
	<td <%=strTDClass%> align="left" nowrap >
    <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%>
	<%=arrCol.get(1)+""%>
	</td>


	<td <%=strTDClass%> align="left" nowrap>
	<select name='<%=arrCol.get(0)+"_format"%>' id='<%=arrCol.get(0)+"_format"%>' >
    <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%>  
	<option value='H' <%=(arrCol.get(2)+"").equals("H") ?"selected":" "%>> <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%><fmt:message key="eXH.HL7.Label" bundle="${xh_labels}"/></option>
	<option value='S' <%=(arrCol.get(2)+"").equals("S") ?"selected":" "%>> <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%><fmt:message key="eXH.String.Label" bundle="${xh_labels}"/></option>
	<option value='U' <%=(arrCol.get(2)+"").equals("U") ?"selected":" "%>> <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }%><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></option>  
	</td>
	<td <%=strTDClass%> align="left" nowrap>
    <% if ((arrCol.get(5)).equals("C")){ %>
    <font color=green> <% }else {%>
	<input type="checkbox" size="15" name='<%=arrCol.get(0)+"_check"%>' id='<%=arrCol.get(0)+"_check"%>' value='<%=arrCol.get(3)+""%>' <%=(arrCol.get(3)+"").equalsIgnoreCase("Y")? "checked":""%> onClick='funCheck(this)'><%}%>
	<input type="hidden" name='<%=arrCol.get(0)+"_value"%>' id='<%=arrCol.get(0)+"_value"%>' value='<%=arrCol.get(4)+""%>'>
	</td>
	</tr>
    
	<%
	}%>
<tr>
		<td colspan=4 class=label><img src='../../eCommon/images/green_square.jpg' width=40 height=15 ><fmt:message key="eXH.Recently.Label" bundle="${xh_labels}"/></td> 
		</tr>

<%

if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

}
	%>
	</table>
<input type='hidden' name='action_type' id='action_type' value='' >
</form>
</html>



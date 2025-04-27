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
<script Language="JavaScript"  src="../../eXH/js/DataElementCrossReferencebasicelement.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="DATAELEMENTCROSSREF" id="DATAELEMENTCROSSREF" method="POST" action='../../eXH/jsp/DataElementCrossRefBasicElement2.jsp' >
<%
boolean boolToggle =  true;	
String strTDClass = "";
String strBeanName = XHElementControllerBean.strBeanName;
//System.out.println("strBeanName"+strBeanName);
Connection conn = null;
try
{


	conn = ConnectionManager.getConnection(request);

		XHElementControllerBean	xhBean = XHElementControllerBean.getBean(strBeanName,request,session);
	//XHDervationControllerBean xhBean = XHDervationControllerBean.getBean(strBeanName,request,session,response);
	xhBean.action(request,conn);
	HashMap resultsQry = xhBean.getResultSet();
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
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
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
%>

<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%= strNext %></A>
	</td>
</tr>

<tr>

	<td class='COLUMNHEADER' width='25%'><fmt:message key="eXH.ElementCode.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='50%'><fmt:message key="eXH.ElementDesc.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.FacilityBased.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADER' width='15%'><fmt:message key="eXH.InUse.Label" bundle="${xh_labels}"/></td>
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
	//System.out.println("arrCol.get(1)"+arrCol.get(1));
%>
<tr>

<td <%=strTDClass%> align="left" ><%=arrCol.get(0)+""%> </td>
<td <%=strTDClass%> align="left" ><INPUT TYPE="text" value='<%=arrCol.get(1)+""%>' name ='<%=arrCol.get(0)+"e"%>' size="40">  </td>

<td <%=strTDClass%> align="left" >
	<input type="checkbox" size="2" name='<%=arrCol.get(0)+"f"%>' id='<%=arrCol.get(0)+"f"%>' value='<%=arrCol.get(3)+""%>' <%=(arrCol.get(3)+"").equalsIgnoreCase("Y")? "checked":""%> disabled>
</td>
<td <%=strTDClass%> align="left" >
	<input type="checkbox" size="2" name='<%=arrCol.get(0)+""%>' id='<%=arrCol.get(0)+""%>' value='<%=arrCol.get(2)+""%>' <%=(arrCol.get(2)+"").equalsIgnoreCase("Y")? "checked":""%> onClick='funCheck(this)'> 
</td>

</tr>
<%
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();

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
</table>
<input type='hidden' name='action_type' id='action_type' value='U' >
</form>
</body>
</html>



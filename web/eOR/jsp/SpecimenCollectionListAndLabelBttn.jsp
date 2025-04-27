<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?          	 created
16/07/2012	  IN34013		DineshT	     Redirect button is made unavailable, when the page has been used in the TaskList funcion of CA				
17/07/2012    IN034056		NijithaS     Script Error is displaying in Record Collection and Record Dispatch 
										 from Task List. 
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/SpecimenOrder.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="javascript" src="../../eXH/js/ExternalApplication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	
	
	/* Mandatory checks start */
	//String templocale=localeName;
	String p_function_from = request.getParameter( "p_function_from" ) ;
	if(p_function_from==null) p_function_from = "";
	String option = request.getParameter( "option" ) ;
	String insButtVal = "Record";
	if(!(request.getParameter( "insButtVal" )).equals(""))
	{
 	 insButtVal = request.getParameter( "insButtVal" ) ;
    }
	if(option==null) option = "";

	String bean_id = "Or_SpecimenOrder" ;
	String bean_name = "eOR.SpecimenOrder";
//	String disabled = "" ;


/* Mandatory checks end */

%>
<form name='specimen_order_btn' id='specimen_order_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
<tr>
<td class='label' width='85%'><table cellpadding=3 cellspacing=0 border=1 width="98%" >
<tr><td  class='QRY7' width='2%'></td><td  nowrap class='label' style="border-top: 1px solid black;border-bottom: 1px solid lightgray;"><fmt:message key="Common.Future.label" bundle="${common_labels}"/></td><td  class='QRY2' width='2%'></td><td  nowrap class='label' style="border-top: 1px solid black;border-bottom: 1px solid lightgray;"><fmt:message key="Common.Due.label" bundle="${common_labels}"/></td><td  class='QRY3' width='2%'></td><td  nowrap class='label' style="border-top: 1px solid black;border-bottom: 1px solid lightgray;"><fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></td>
<td  class='QRY5' width='2%'></td><td  nowrap class='label' style="border-top: 1px solid black;border-bottom: 1px solid lightgray;border-right: 1px solid lightgray;"><fmt:message key="eOR.Unbilled.label" bundle="${or_labels}"/></td><!-- IN030589 -->
</tr>
</table></td>
		<%
		if(option.equals("S")){%>
			<td  class='button'  align=right >
			<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reprint.label","common_labels")%>' class='button'  onClick='printDispatchValues(localeName)'>
			 </td>
		<%}
		else
		{
			if(!p_function_from.equals("CP"))//IN34013
			{
			%>
			<td class='button'><input class='button' type='button' name='redirectOrder' id='redirectOrder' value='Redirect Order' onclick='openRedirectWindow()' /></td>
			<%
			}//IN34013	
			%>
			<td  class='button' align=right><%
				if (insButtVal.equals("Record")) 
				insButtVal=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels");
				%>
			
			<INPUT TYPE="button" name="insButton" id="insButton" value='<%=insButtVal%>' class='button'  onClick='insert(localeName)'>
			</td> 
		<% if(!p_function_from.equals("CP")) { %>
				 <td  class='button' align="right" > 
				<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='clearAll()'>
				
				 </td> 
		<%	}
		} %>
		</td>
</tr>

</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<!-- <input type="hidden" name="p_language_id" id="p_language_id" value="<%= localeName %>"> -->
</form>
<script>
//if(parent.SpecimenOrderSearch.document.getElementById("option_list").value != 'N')//IN034056
if(parent.SpecimenOrderSearch.document.getElementById("option_list").value != 'N' && parent.SpecimenOrderBtn.document.getElementById("redirectOrder") != null)//IN034056
document.getElementById("redirectOrder").style.display = 'none';
</script>
</body>
</html>


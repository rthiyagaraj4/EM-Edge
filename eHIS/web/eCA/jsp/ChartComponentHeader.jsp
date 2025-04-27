<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.ChartComponentHeader.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	/** added by kishore kumar n on 27/11/2008  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	/** ends here*/
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<form name='ChartComponentHeaderForm' id='ChartComponentHeaderForm' method='post' action='../../eCA/jsp/ChartComponentList.jsp'>
<table align='center' border=0 cellpadding=3 cellspacing=0 width='100%'>
<tr>
	<td class='label'  ><fmt:message key="Common.Chart.label" bundle="${common_labels}"/>
	<input type='text' name='chartDesc' id='chartDesc' size='30' maxlength='30' OnBlur='getChartCode(this)' OnChange = 'resetValues();' ><input type='button' onclick='resetValues();getChartCode(this)' value='?' name='cmnlookupChart' id='cmnlookupChart' class='BUTTON'><img src='../../eCommon/images/mandatory.gif'>
	</td>

	<td align='right'><input type='button' class='BUTTON' name='searchChId' id='searchChId' value='<fmt:message key="eCA.Showdetail.label" bundle="${ca_labels}"/>' ONCLICK='setTimeout("dispDesc()",500)'></td>
</tr>
</table>
	<!-- added by kishore kumar n on 27/11/2008  -->
	<%if(!imgUrl.equals("")){ %>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<!--ends here -->
<input type ='hidden' name='remove_value' id='remove_value' value=''>
<input type='hidden' name='chartCompSearch' id='chartCompSearch' value=''>
</form>
</body>
</html>


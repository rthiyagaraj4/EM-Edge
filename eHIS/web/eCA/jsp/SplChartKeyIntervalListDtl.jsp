<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,java.math.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title>SplChartKeyIntervalList</title>
	<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />



<%	
String mode = request.getParameter("mode");
mode = mode==null?"insert":mode;

String splChartType =  request.getParameter("spl_chart_type");
splChartType = splChartType==null?"":splChartType;

String splChartGroup =  request.getParameter("spl_chart_group");
splChartGroup = splChartGroup==null?"":splChartGroup;

String unit =  request.getParameter("unit");
unit = unit==null?"":unit;

String  startValue =  request.getParameter("start_value");
startValue = startValue==null || startValue.equals("")?"0.0":startValue;

String  endValue   = request.getParameter("end_value");
endValue = endValue==null || endValue.equals("")?"0.0":endValue;

String  interval   = request.getParameter("interval");
interval = interval==null || interval.equals("")?"1.0":interval;

String unitValue = null;
if(unit.equals("M"))
 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
else if(unit.equals("Y"))
 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
else if(unit.equals("D"))
 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
else if("KG".equals(unit))
 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
else if("KM".equals(unit))
 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.kgm2.label","ca_labels");
else if("CM".equals(unit))
 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.centimeters.label","ca_labels");
else if("W".equals(unit))
 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");  //IN061886
	
String xAxis_element =  request.getParameter("xAxis_element");
xAxis_element = xAxis_element==null?"*K":xAxis_element;

double begin = Double.parseDouble(startValue);
double end   = Double.parseDouble(endValue);
double incr  = Double.parseDouble(interval);

if(((end-begin)/incr)>100)
{	%>

<script language='javascript'>
function displayError()
{
	alert(getMessage("LIMIT_UPTO100_ONLY","CA"));
	parent.frameSplChartKeyIntervalListHdr.location.href='../../eCommon/html/blank.html';
}
displayError();
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
} else
{
	%>

<form name="SplChartKeyIntervalListDtl" id="SplChartKeyIntervalListDtl" action="../../servlet/eCA.SplChartKeyServlet" method="post" target="messageFrame">

<div style="display: flex; justify-content: center;">
<table id="splchart_details"  width='50%' align=center class='grid'>
<tr>
	<td class='COLUMNHEADERCENTER'  width='20%'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='20%'><fmt:message key="Common.Key.label" bundle="${common_labels}"/> <fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'  width='60%'><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
</tr>
<%
String classValue = null;
int i = 1;

for(double f=begin;f<end;f+=incr)
{
	/*if(i % 2 == 0 )
	{
		classValue	=	"QRYEVEN";
	}
	else
	{
		classValue	=	"QRYODD";
	}*/
	classValue	=	"gridData";
	
	double keyValue = f + incr;

	keyValue = keyValue>end?end:keyValue;
	String range   = ""+f+"~"+keyValue;
%>

<tr>
	<td width='20%' class = 'gridNumericData' nowrap>&nbsp;<%=(i)%>&nbsp;</td>
	<td width='20%' class = 'gridNumericData' nowrap>&nbsp;<%=keyValue%>&nbsp;</td>
	<td width='60%'  class = '<%=classValue%>' nowrap>&nbsp;<%=range%>&nbsp;<%=unitValue%></td>
</tr>
<input type='hidden' name='start_value<%=i%>' id='start_value<%=i%>' value='<%=f%>'>
<input type='hidden' name='end_value<%=i%>' id='end_value<%=i%>' value='<%=keyValue%>'>
<% i++; }%>
</table>
<input type="hidden" name="rec_count" id="rec_count" value = "<%=(i-1)%>"/>
<input type="hidden" name="mode" id="mode" value = "<%=mode%>"/>
<input type="hidden" name="spl_chart_type" id="spl_chart_type" value = "<%=splChartType%>"/>
<input type="hidden" name="spl_chart_group" id="spl_chart_group" value = "<%=splChartGroup%>"/>
<input type="hidden" name="unit" id="unit" value = "<%=unit%>"/>
<input type="hidden" name="xAxis_element" id="xAxis_element" value="<%=xAxis_element%>"/>
</form>
</body>
<% } %>
</html>


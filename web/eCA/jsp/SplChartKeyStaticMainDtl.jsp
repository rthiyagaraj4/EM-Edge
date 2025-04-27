<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>SplChartKeyStaticMainDtl</title>
		<script src='../../eCA/js/SplChartKey.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
</head>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="SplChartKeyStaticMainDtl" id="SplChartKeyStaticMainDtl"  action="../../servlet/eCA.SplChartKeyServlet" method="post" target="messageFrame">

<div style="display: flex; justify-content: center;">
<table id="splchart_details" name="splchart_details"  width='98%' class='grid' align=center>
<%	
String mode = request.getParameter("mode");
mode = mode==null?"insert":mode;

String splChartType = request.getParameter("spl_chart_type");
splChartType = splChartType==null?"":splChartType;

String splChartGroup = request.getParameter("spl_chart_group");
splChartGroup = splChartGroup==null?"":splChartGroup;

String unit = request.getParameter("unit");
unit = unit==null?"":unit;

String xAxis_element =  request.getParameter("xAxis_element");
xAxis_element = xAxis_element==null?"*K":xAxis_element;

String classValue = null;
int totalRecords = 12, i = 1;
for(i=1;i<=totalRecords;i++)
{
	if(i % 2 == 0 )
	{
		classValue	=	"gridData";
	}
	else
	{
		classValue	=	"gridData";
	}
%>

<tr>
	<td width='30%' align='right' class = 'gridNumericData' nowrap>&nbsp;<%=(i)%>&nbsp;</td>
	<td width='34%' align='center' class = '<%=classValue%>' nowrap><input type='text' name='start_value<%=i%>' id='start_value<%=i%>' maxlength=11 value='' onkeypress="return allowPositiveNumber();"  onBlur="checkPositiveNumber(this);" <%if(i!=1) out.print("readOnly");%>></td>
	<td width='34%' align='center' class = '<%=classValue%>' nowrap><input type='text' name='end_value<%=i%>' id='end_value<%=i%>'  maxlength=11 value='' onkeypress="return checkval3(<%=i%>)" onBlur="if(checkPositiveNumber(this))  if(checkval2(<%=i%>)) setNextFirstValue(this,<%=i%>);"></td>
	
</tr>
<%}%>
</table>
</div>
<input type="hidden" name="unit" id="unit" value = "<%=unit%>"/>
<input type="hidden" name="rec_count" id="rec_count" value = "<%=totalRecords%>"/>
<input type="hidden" name="mode" id="mode" value = "<%=mode%>"/>
<input type="hidden" name="spl_chart_type" id="spl_chart_type" value = "<%=splChartType%>"/>
<input type="hidden" name="spl_chart_group" id="spl_chart_group" value = "<%=splChartGroup%>"/>
<input type="hidden" name="xAxis_element" id="xAxis_element" value="<%=xAxis_element%>"/>
</form>
</body>
</html>


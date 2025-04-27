<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants" %>
<%@ include file="/framework/html/Tag.text" %>
<ibaHTML:html locale="true">
<head>
	<%
	String facilityId=(String)session.getAttribute("facility_id");
	String addedById = (String) session.getAttribute("login_user");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
					String qryEven = "QRYEVEN";
			String qryOdd = "QRYODD";
		

			
	%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript"	src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LinenRequest.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
<script type="text/javascript">
var contentList =new Hashtable();
function callNext()
{
var val=document.getElementById("Date1").value;
var dateF=val;
var TimeF=document.getElementById("Time").value;
var currencyF=document.getElementById("Currency").value;
var noOfDeci=document.getElementById("Decimal").value;

 
  if(dateF!=""&& TimeF!=="")
	{
	
	 var str="";
	 location.href=contextPath + 	"/eLC/core/jsp/PersonaliseData.jsp?dateFormat="+dateF+"&timeFormat="+TimeF+"&currency="+currencyF+"&decimal="+noOfDeci;
	 }
	 
}


</script>
</head>
<title><ibaBean:message key="com.iba.ehis.lc.laundryUser.user" bundle="lcLabels" /></title>

<body>
<br><br>
<form name="PersonalizeForm" id="PersonalizeForm"  target="messageFrame">

<table align="center" border=0 cellspacing=0 cellpadding=2 width=100% height=100%>

<tr>
<td class="label"><ibaBean:message key="com.iba.ehis.lc.dateFormat" bundle="lcLabels" /></td>
<td>
			<select name="Date1" id="Date1">
							<option value="">
							<ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="">
							<ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="dd/MM/yyyy">dd / MM / yyyy</option>
							<option value="dd/MM/yy">dd / MM / yy</option>
							<option value="dd/MMM/yyyy">dd / MMM / yyyy</option>
							<option value="dd/MMM/yy">dd / MMM / yy</option>
							<option value="MM/dd/yyyy">MM / dd / yyyy</option>
							<option value="MM/dd/yy">MM / dd / yy</option>
							<option value="MMM/dd/yyyy">MMM / dd / yyyy</option>
							<option value="MMM/dd/yy">MMM / dd / yy</option>
							<option value="yyyy/MM/dd">yyyy / MM / dd</option>
							<option value="yy/MM/dd">yy / MM / dd</option>
							<option value="yyyy/MMM/dd">yyyy / MMM / dd</option>
							<option value="yy/MMM/dd">yy / MMM / dd</option>
						
			</select>
			
</td>
</tr>
<tr>
<td class="label"><ibaBean:message key="com.iba.ehis.lc.timeFormat" bundle="lcLabels" /></td>
<td>
			<select name="Time" id="Time">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="hh:mm">hh:mm</option>
							<option value="hh:mm">hh24:mm</option>
							<option value="hh:mm:ss">hh:mm:ss</option>
							<option value="hh:mm:ss">hh24:mm:ss</option>
			</select>

</td>
</tr>
<tr>
<td class="label"><ibaBean:message key="com.iba.ehis.lc.currencySymbol" bundle="lcLabels" /></td>
<td>
			<select name="Currency" id="Currency">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="en">$</option>
							<option value="th">Th.</option>
							<option value="uk">Uk.</option>
			</select>

</td>
</tr>
<tr>
<td class="label"><ibaBean:message key="com.iba.ehis.lc.noOfDecimal" bundle="lcLabels" /></td>
<td>
			<select name="Decimal" id="Decimal">
							<option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" />
							</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
 			</select>

</td>
</tr>
<tr>
<td align="right">
<input class="BUTTON" type="button" value="Ok" name="Ok" id="Ok" onclick="callNext()"/></td><td><input class="BUTTON" type="reset" value="Reset" name="Reset" id="Reset" />
</td>
</tr>
</table>
<input type="hidden" name="operatingFacilityId" id="operatingFacilityId" value="<%=facilityId%>"/>
</form>

</body>
</ibaHTML:html>


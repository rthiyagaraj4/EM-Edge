<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN061886		Kamalakannan G		09/02/2018		Ramesh Goli		ML-MMOH-CRF-0538
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>

<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>	
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script><!-- Used for Prescription -->
	<script language='javascript' src='../../eBL/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	var currClass="";
	function change_common_tab(obj)
	{ 
		var colorFlag = "";
		var yType ="S";
		if(obj=="SpecificView")
		{
			colorFlag = "SpecificView"
			colorChange(colorFlag,obj);
			parent.splChtCustomViewFrame.location.href = "../../eCA/jsp/ChartRecordingSplChtLinks.jsp?<%=request.getQueryString()%>&Y_AXIS_TYPE="+yType;
		}
		else if(obj=="CustomView")
		{
			yType="M";
			colorFlag = "CustomView"
			colorChange(colorFlag,obj);
			parent.splChtCustomViewFrame.location.href = "../../eCA/jsp/ChartRecordingSplChtUserInput.jsp?<%=request.getQueryString()%>&Y_AXIS_TYPE="+yType;
		}
		else if(obj=="MutipleView")
		{
			colorFlag = "MutipleView"
			colorChange(colorFlag,obj);
			parent.splChtCustomViewFrame.location.href = "../../eCA/jsp/ChartRecordingSplChtLinks.jsp?<%=request.getQueryString()%>&Y_AXIS_TYPE=M";		
		}
	}
	
	function colorChange(colorFlag,obj) 
	{
		if(colorFlag=="SpecificView"){
			document.CharFormTab.specificView.className  = "CASECONDSELECTHORZ";
			document.CharFormTab.customView.className	="CAFIRSTSELECTHORZ";
			document.CharFormTab.sampleView.className	="CAFIRSTSELECTHORZ";
			obj.className
		}
		if(colorFlag=="CustomView"){
			document.CharFormTab.customView.className		= "CASECONDSELECTHORZ";
			document.CharFormTab.specificView.className		="CAFIRSTSELECTHORZ";
			document.CharFormTab.sampleView.className		="CAFIRSTSELECTHORZ"
		}
		if(colorFlag=="MutipleView"){
			document.CharFormTab.sampleView.className		= "CASECONDSELECTHORZ";
			document.CharFormTab.specificView.className 	 = "CAFIRSTSELECTHORZ";
			document.CharFormTab.customView.className		="CAFIRSTSELECTHORZ"
		}		
		currClass ="CASECONDSELECTHORZ";
	}
	function callOnMouseOver(obj){
		currClass = obj.className ;
		obj.className = 'CASECONDSELECTHORZ';
	}
	function callOnMouseOut(obj){		
		obj.className = currClass
	}
	</script>
	<STYLE TYPE="text/css"></STYLE>
 </head>
<%
String class_name_first			= "";
%>
	<form name="CharFormTab" id="CharFormTab">
		<table cellpadding='0' cellspacing='0' width='100%'>
			<tr>
				<td class='CAGROUPHEADING' align='center' colspan='2'><fmt:message key="eCA.GrowthChart.label" bundle="${ca_labels}"/></td>
			</tr>
			<tr><td></td></tr>
		</table>
		<table id="tab" width="100%">
			<tr>
				<%
				class_name_first		= "CAFIRSTSELECTHORZ"; 
				%>
				<td id="specificView" class="CASECONDSELECTHORZ <%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)"><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('SpecificView')" />Specific View</td>
				<td id="customView" class="<%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)"><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('CustomView')" />Custom View</td>
				<td id="sampleView" class="<%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onmouseout="callOnMouseOut(this)"><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('MutipleView')" />Multiple View</td>
			</tr>
		</table>
		
	</form>
</body>
</html> 


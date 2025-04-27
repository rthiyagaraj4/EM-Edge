<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<html>
<head>
		<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>	
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
		<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
		<Script language ="JavaScript" src ='<%=request.getContextPath()%>/core/lookup/js/Lookup.js'></Script>
		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
		<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLCMasterCodes/js/LinenMasterCodes.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

        <%			
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		%>		
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
  <ibaHTML:form action="/RepLinenMasterCodesAction.do" target="messageFrame" method="GET">   
   		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
   		<tr>
   			<td align="right" class="label">
					<ibaBean:message key="com.iba.ehis.lc.masterCodes" bundle="lcLabels" />
			</td>
		<td>
			<ibaHTML:select property="vo.repNames" onchange = "getMasterCodes(this.value);">
			<ibaHTML:option value=""><ibaBean:message key="com.iba.ehis.lc.select" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="T"><ibaBean:message key="com.iba.ehis.lc.linenType" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="I"><ibaBean:message key="com.iba.ehis.lc.linenItem" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="A"><ibaBean:message key="com.iba.ehis.lc.agencyCode.agencyCode" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="R"><ibaBean:message key="com.iba.ehis.lc.ReasonComplaintCode" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="S"><ibaBean:message key="com.iba.ehis.lc.StandardStockforWCD" bundle="lcLabels" /></ibaHTML:option>
			<ibaHTML:option value="L"><ibaBean:message key="com.iba.ehis.lc.LaundaryUsers" bundle="lcLabels" /></ibaHTML:option>
			</ibaHTML:select>
		</td>
	</tr>
	<tr>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
</ibaHTML:form>
</body>
</html>


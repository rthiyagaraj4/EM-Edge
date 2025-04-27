<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
	<%@ page  import="com.iba.framework.core.util.Constants"%>

<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>
<head>
	<%		
			String functionId=(String)request.getParameter("functionId");
			String locale=(String)session.getAttribute("LOCALE");
			String moduleId=(String)request.getParameter("moduleId");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	%>
	
	
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />		<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>

	<script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></script>
	<script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ActionType.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<script language="JavaScript" src="<%=request.getContextPath()%>/eLC/Reason/js/Reason.js"></script>
	<script language="JavaScript">
	function hideLabel()
	{
	 var labelObj=document.getElementById("lebel");
	 labelObj.visible=false;
	}
	function disable()
 {
 	if(document.getElementById("method").value==2)
 	 {
	 	document.getElementById("vo.reasonCode").readOnly=true;
		document.getElementById("vo.reasonDesc").readOnly=true;

	 }	
	 else
		document.getElementById("vo.effStatus").checked=true;
 }
	</script>
</head>

<body onLoad="hideLabel();disable();checkVal();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/ReasonAction.do" target="messageFrame">

		<table border='0' cellpadding='2' cellspacing='0' width='75%'
			align='center'>
			<tr>
				<td>
					<table border='0' cellpadding='2' cellspacing='0' width='50%'
						align='center'>
						<tr>
							<td align="left" width="30%" CLASS='label'>
								<ibaBean:message
									key="com.iba.ehis.lc.Code"
									bundle="lcLabels" />
							</td>
							<td width="70%">
							<ibaHTML:text property="vo.reasonCode" maxlength="10" onkeyup="setFieldsToUpperCase(this)" onkeypress="return checkAlphaNum()" />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
							<td align="left" width="30%" CLASS='label'>
								<ibaBean:message
									key="com.iba.ehis.lc.description"
									bundle="lcLabels" />
							</td>
							<td width="70%" nowrap="nowrap">
								<ibaHTML:text property="vo.reasonDesc" maxlength="100" size="40" />	
								<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
					<td  class='label'>
						<ibaBean:message key="com.iba.ehis.lc.status"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:checkbox property="vo.effStatus" value="E" />
						<ibaLogic:equal value="E" property="vo.effStatus" name="ReasonForm">
							<script type="text/javascript">
							<!--
									document.getElementById("vo.effStatus").checked=true
							//-->
							</script>
						</ibaLogic:equal>
						
					</td>
				</tr>
					</table>
				</td>
			</tr>
		</table>
	<br><br>
	

<div id="lebel" >
		<table border='0' cellpadding='2' cellspacing='0' width='60%'
			align='center' >
			<tr>
			<th colspan=2 align='left'>
			<ibaBean:message key="com.iba.ehis.lc.reason.actionTypeAssociation"
									bundle="lcLabels" />
			</th>
			</tr>
			<tr>
			<td colcpan=2></td>
			</tr>
			<tr>
				<th>
					<table border='0' cellpadding='2' cellspacing='0' width='75%'
						align='center'>
						<tr>

							<th align="left" >
								<ibaBean:message key="com.iba.ehis.lc.reason.actionType"
									bundle="lcLabels" />
							</th>
							<th align="right">
								<ibaBean:message key="com.iba.ehis.lc.reason.active"
									bundle="lcLabels" />
							</th>

						</tr>
					</table>
				</th>
			</tr>
		</table>
</div>		
		<table id="contentTable" border='1' cellpadding='2' cellspacing='0'
			width='60%' align='center' >
		</table>

		<ibaHTML:hidden property="method" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
		<input type="hidden" name="languageId" id="languageId" value="<%=locale%>" />
	</ibaHTML:form>
</body>
</ibaHTML:html>


<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page  import="com.iba.framework.core.util.Constants" %>

<%@ include file="/framework/html/Tag.text"%>
<ibaHTML:html>
<head>
	<%		String facilityId=(String)request.getAttribute("facility_Id");
			String functionId = (String) request.getParameter("functionId");
			String moduleId = (String) request.getParameter("moduleId");
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";
	%>
	
	
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
	<script Language="JavaScript" src="<%=request.getContextPath()%>/core/lookup/js/Lookup.js"></script>		
	<script type="text/javascript" src="<%=request.getContextPath()%>/framework/js/hashtable.js"></script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/DynaLookup.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/engine.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/util.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/ActionType.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/dwrlc/interface/LaundryUser.js'></script>
	<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
	<Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/LaundryUser/js/LaundryUser.js"></Script>

	</head>
<body onload="disable()" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<ibaHTML:form action="/LaundryUserAction.do" target="messageFrame">

		<table border='0' cellpadding='2' cellspacing='0' width='75%'
			align='center'>
			<tr>
				<td>
					<table border='0' cellpadding='2' cellspacing='0' width='50%'
						align='center'>
						<tr>
							<td align="left" width="30%" CLASS='label'>
								<ibaBean:message
									key="com.iba.ehis.lc.laundryUser.user"
									bundle="lcLabels" />
							</td>
							<td width="70%">
							<ibaHTML:text property="vo.user" maxlength='40' onblur="showLookup()" />
							<input type='button' id="lookup" class='button' value='?' onclick='showLookup()' />
							<img src="framework/images/mandatory.gif"></img>
							</td>
						</tr>
						<tr>
							<td align="left" width="30%" CLASS='label' nowrap="nowrap">
								<ibaBean:message
									key="com.iba.ehis.lc.laundryUser.overrideWardConfirmation"
									bundle="lcLabels" />
							</td>
							<td width="70%">
								<ibaHTML:checkbox property="vo.overRideWardConf" value="Y"/>	
							<ibaLogic:equal value="Y" property="vo.overRideWardConf" name="LaundryUserForm">
							<script type="text/javascript">
							<!--
								document.getElementById("vo.overRideWardConf").checked=true
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
	
		


		<ibaHTML:hidden property="method" />
		<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>" />
		<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>" />
	</ibaHTML:form>
</body>
</ibaHTML:html>



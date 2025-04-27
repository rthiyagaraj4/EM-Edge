<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page  import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
<%			
			String functionId=(String)request.getParameter("functionId");
			String moduleId=(String)request.getParameter("moduleId");
			
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<Script Language="JavaScript" src="<%=request.getContextPath()%>/eLC/LinenType/js/LinenType.js"></Script>
<Script>
function disable()
 {
 	 if(document.getElementById("method").value==2)
 	 {
	 	document.getElementById("vo.linenTypeCode").readOnly=true;
	 	
	 	if(document.getElementById("vo.effStatus").checked==false)
	 		{
	 		    document.getElementById("vo.linenTypeDesc").readOnly="readonly";
	 			
			 }
	 }	
 }
 function statusChk()
 {
		if(document.getElementById("method").value==0)
 		document.getElementById("vo.effStatus").checked=true;
 }
</Script>
</head>
	<body onload="disable();statusChk();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
		<br>
		<ibaHTML:form action="/LinenTypeAction.do" target="messageFrame" >
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.linenType"
							bundle="lcLabels" />
					</td>
					<td> 
						<ibaHTML:text property="vo.linenTypeCode" size="4" maxlength="4" onkeyup="setFieldsToUpperCase(this)"  onkeypress="return checkAlphaNum()"/>
						<img src='framework/images/mandatory.gif'></img>
					</td>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.description"
							bundle="lcLabels" />
					</td> 
					<td>
						<ibaHTML:text property="vo.linenTypeDesc" size="35" maxlength="30" />
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.status"
							bundle="lcLabels" />
					</td>
					<td>
						
						<ibaHTML:checkbox property="vo.effStatus" value="E" />
						
						<ibaLogic:equal value="E" property="vo.effStatus" name="LinenTypeForm">
							<script type="text/javascript">
							<!--
									document.getElementById("vo.effStatus").checked=true
							//-->
							</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

						</ibaLogic:equal>
						
					</td>
				</tr>
				
			</table>
			<ibaHTML:hidden property="method"/>

			<ibaHTML:hidden property="vo.functionId" value="<%=functionId%>"/>
			<ibaHTML:hidden property="vo.moduleId" value="<%=moduleId%>"/>
			<input type='hidden' name="ContextPath" id="ContextPath" value="<%=request.getContextPath()%>"/>
		</ibaHTML:form>
	</body>
</html>



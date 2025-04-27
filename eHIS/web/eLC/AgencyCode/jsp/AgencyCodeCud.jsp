<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<%@ include file="/framework/html/Tag.text"%>
<html>
<head>
<%			
			String functionId=(String)request.getParameter("function_id");
			String moduleId=(String)request.getParameter("moduleId");
			
			//out.println(functionId);
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
<script src="<%=request.getContextPath()%>/eCommon/js/ValidateControl.js" language="javascript"></script>
<Script type='text/javascript' src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
<Script type='text/javascript' src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/framework/js/Ajax_DWR.js'></script>
<Script type='text/javascript' src="<%=request.getContextPath()%>/eLC/AgencyCode/js/AgencyCode.js"></Script>
 
<Script>
function disable()
 {
	 if(document.getElementById("method").value==0){
	 document.getElementById("vo.effStatus").checked=true}

	 if(document.getElementById("method").value==2)
 	 {
	 	document.getElementById("vo.agencyCode").readOnly="readonly";
	  	if(document.getElementById("vo.effStatus").checked==false)
	 	 {
		 	document.getElementById("vo.agencyName").readOnly="readonly";
		 }	
     }
	
 }	
</Script>
</head>
	<body onload="disable();" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	
		<br>
		<ibaHTML:form action="/AgencyCodeAction.do" target="messageFrame" >
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.agencyCode.agencyCode"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.agencyCode" size="4" maxlength="4" onkeyup="setFieldsToUpperCase(this)" onkeypress="return checkAlphaNum()"/>
						<img src='framework/images/mandatory.gif'></img>
					</td>
				<tr>
					<td align="right" class='label'>
						<ibaBean:message key="com.iba.ehis.lc.agencyCode.name"
							bundle="lcLabels" />
					</td>
					<td>
						<ibaHTML:text property="vo.agencyName" size="35" maxlength="30" />
						<img src='framework/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td  class='label' align="right" >
						<ibaBean:message key="com.iba.ehis.lc.status"
							bundle="lcLabels" />
					</td>
					<td>
						
						<ibaHTML:checkbox property="vo.effStatus" value="E" />
						
						<ibaLogic:equal value="E" property="vo.effStatus" name="AgencyCodeForm">
							<script type="text/javascript">
							<!--
									document.getElementById("vo.effStatus").checked=true
							//-->
							</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



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



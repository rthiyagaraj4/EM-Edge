<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src='../js/CommonPolicyTabChangeFrame.js'></script> 
	<script language="javascript" src='../js/CommonPolicyDefinition.js'></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=0 width='100%' align="center">
<tr width='100%'>
	<td width="100%" class="white">
		<ul id='tablist' class='tablist'>
			<li class="tablistitem" title='<fmt:message key="eBL.OutpatientEmergency.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('Outpatient')" class="tabClicked" id="Outpatient">
					<span class="tabSpanclicked" id="Outpatientspan">
						<fmt:message key="eBL.OutpatientEmergency.label" bundle="${bl_labels}"/>
						</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eBL.InpatientDayCare.label" bundle="${bl_labels}"/>'>
				<a onclick="fnShowMainTabDetails('Inpatient')" class="tabA" id="Inpatient" >
					<span class="tabAspan" id="Inpatientspan">					
					<fmt:message key="eBL.InpatientDayCare.label" bundle="${bl_labels}"/>					
					</span></a>
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.external.label" bundle="${common_labels}"/>'>
				<a onclick="fnShowMainTabDetails('External')" class="tabA" id="External" >
					<span class="tabAspan" id="Externalspan">					
					<fmt:message key="Common.external.label" bundle="${common_labels}"/>					
					</span></a>
			</li>
		</ul>
	</td>	
	</tr>
</table>

</body>
</html>


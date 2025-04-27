<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8"  %>
<%@  page contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 //Checkstyle Violation commented by Munisekhar
//String bill_flag =checkForNull(request.getParameter("bill_flag"));
//String params = request.getQueryString();
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script type="text/javascript">
function loadCUD(){
	var params = document.KitchentabForm.params.value;
	parent.KitchenAdd.location.href = '../../eDS/jsp/KitchenModify.jsp?'+params;
}

function changeTab(object){
	var params = document.KitchentabForm.params.value;
	if(object == 'KitchenArea'){
		document.getElementById('KitchenTab').className = "tabA";
		document.getElementById('KitchenTabspan').className = "tabAspan";
		document.getElementById('KitchenAreaTab').className = "tabClicked";
		document.getElementById('KitchenAreaTabspan').className = "tabSpanclicked"
		parent.KitchenAdd.location.href = '../../eDS/jsp/KitchenArea.jsp?'+params;
	}
	else if(object == 'Kitchen'){
		document.getElementById('KitchenAreaTab').className = "tabA";
		document.getElementById('KitchenAreaTabspan').className = "tabAspan";
		document.getElementById('KitchenTab').className = "tabClicked";
		document.getElementById('KitchenTabspan').className = "tabSpanclicked"
		parent.KitchenAdd.location.href = '../../eDS/jsp/KitchenModify.jsp?'+params;
	}
}
</script>
</head>
<body onload="loadCUD()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<form name="KitchentabForm" id="KitchentabForm">
<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr>
					<td width="100%" class="white">
					<ul id='tablist' class='tablist'>
						<li class='tablistitem' title='<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>'>
						<a onclick="changeTab('Kitchen')" class="tabclicked" id="KitchenTab">
						<span class="tabSpanclicked" id="KitchenTabspan">
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/></span></a>
						</li>
						<li class="tablistitem" title='<fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}"/>' >
						<a onclick="changeTab('KitchenArea')" class="tabA" id="KitchenAreaTab">
						<span class="tabAspan" id="KitchenAreaTabspan">
						<fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}"/>
						</span>
						</a>
						</li>
						</ul>
						</td>
						</tr>
			</table>
			<input type="hidden" name = "params" value = "<%=request.getQueryString()%>">

			</form>
</body>


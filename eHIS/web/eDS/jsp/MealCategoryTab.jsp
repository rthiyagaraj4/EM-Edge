<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8"  %>
<%@  page contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Checkstyle Violation commented by Munisekhar
//String bill_flag =checkForNull(request.getParameter("bill_flag"));
//String tabCheck = request.getParameter("mealCategory");
String tabCheck = request.getParameter("meal_category_code");//ML-MMOH-CRF-406
String Attendent_Label_Name=request.getParameter("Attendent_Label_Name");//ML-MMOH-CRF-0406
%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script type="text/javascript">
function loadCUD(){
	var params = document.MealCategorytabForm.params.value;
	parent.MealCategoryAdd.location.href = '../../eDS/jsp/MealCategoryModify.jsp?'+params;
}

function changeTab(object){
	var params = document.MealCategorytabForm.params.value;
	if(object == 'Attendents'){
		document.getElementById('MealCategoryTab').className = "tabA";
		document.getElementById('MealCategoryTabspan').className = "tabAspan";
		document.getElementById('AttendantsTab').className = "tabClicked";
		document.getElementById('AttendantsTabspan').className = "tabSpanclicked"
		parent.MealCategoryAdd.location.href = '../../eDS/jsp/MealCategoryAttendents.jsp?'+params;
	}
	else if(object == 'MealCategory'){
		//if(document.getElementById('tabCheck').value == 'ATT'){//ML-MMOH-CRF-406
			document.getElementById('AttendantsTab').className = "tabA";
			document.getElementById('AttendantsTabspan').className = "tabAspan";
		//}

		document.getElementById('MealCategoryTab').className = "tabClicked";
		document.getElementById('MealCategoryTabspan').className = "tabSpanclicked"
		parent.MealCategoryAdd.location.href = '../../eDS/jsp/MealCategoryModify.jsp?'+params;
	}
}
</script>
</head>
<body onload="loadCUD()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<form name="MealCategorytabForm" id="MealCategorytabForm">
<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr>
					<td width="100%" class="white">
					<ul id='tablist' class='tablist'>
						<li class='tablistitem' title='<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}"/>'>
						<a onclick="changeTab('MealCategory')" class="tabclicked" id="MealCategoryTab">
						<span class="tabSpanclicked" id="MealCategoryTabspan">
						<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}"/></span></a>
						</li>
						<%if("ATT".equals(tabCheck)) {%><!--ML-MMOH-CRF-406-->
						<!--<li class="tablistitem" title='<fmt:message key="eOT.Attendents.Label" bundle="${ot_labels}"/>' >-->
						<li class="tablistitem" title='<%=Attendent_Label_Name%>' ><!--ML-MMOH-CRF-406-->
						<a onclick="changeTab('Attendents')" class="tabA" id="AttendantsTab">
						<span class="tabAspan" id="AttendantsTabspan">
						<!--<fmt:message key="eOT.Attendents.Label" bundle="${ot_labels}"/>-->
						<%=Attendent_Label_Name%><!--ML-MMOH-CRF-406-->
						</span>
						</a>
						</li>
						<%} %>
						</ul>
						</td>
						</tr>
			</table>
			<input type="hidden" name = "params" value = "<%=request.getQueryString()%>">
			<input type="hidden" name = "tabCheck" value = "<%=tabCheck%>">
			</form>
</body>


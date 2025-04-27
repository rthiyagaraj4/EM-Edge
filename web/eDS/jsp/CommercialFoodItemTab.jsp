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
// Checkstyle Violation commented by Munisekhar
//String bill_flag =checkForNull(request.getParameter("bill_flag"));
//String params = request.getQueryString();

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script type="text/javascript">
function loadCUD(){
	var params = document.CommercialFoodItemtabForm.params.value;
	parent.CommercialFoodItemAdd.location.href = '../../eDS/jsp/CommercialFoodItemModify.jsp?'+params;
}

function changeTab(object){
	var params = document.CommercialFoodItemtabForm.params.value;
	if(object == 'Nutrients'){
		document.getElementById('FoodItemTab').className = "tabA";
		document.getElementById('FoodItemTabspan').className = "tabAspan";
		document.getElementById('NutrientsTab').className = "tabClicked";
		document.getElementById('NutrientsTabspan').className = "tabSpanclicked"
		parent.CommercialFoodItemAdd.location.href = '../../eDS/jsp/CommercialFoodItemNutrients.jsp?'+params;
	}
	else if(object == 'FoodItem'){
		document.getElementById('FoodItemTab').className = "tabClicked";
		document.getElementById('FoodItemTabspan').className = "tabSpanclicked";
		document.getElementById('NutrientsTab').className = "tabA";
		document.getElementById('NutrientsTabspan').className = "tabAspan"
		parent.CommercialFoodItemAdd.location.href = '../../eDS/jsp/CommercialFoodItemModify.jsp?'+params;
	}
}
</script>
</head>
<body onload="loadCUD()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
<form name="CommercialFoodItemtabForm" id="CommercialFoodItemtabForm">
<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr>
					<td width="100%" class="white">
					<ul id='tablist' class='tablist'>
						<li class='tablistitem' title='<fmt:message key="eOT.CommercialFormula.Label" bundle="${ot_labels}"/>'>
						<a onclick="changeTab('FoodItem')" class="tabclicked" id="FoodItemTab">
						<span class="tabSpanclicked" id="FoodItemTabspan">
						<fmt:message key="eOT.CommercialFormula.Label" bundle="${ot_labels}"/></span></a>
						</li>
						<li class="tablistitem" title='<fmt:message key="eOT.NutrientsCommercialFormula.Label" bundle="${ot_labels}"/>' >
						<a onclick="changeTab('Nutrients')" class="tabA" id="NutrientsTab">
						<span class="tabAspan" id="NutrientsTabspan">
						<fmt:message key="eOT.NutrientsCommercialFormula.Label" bundle="${ot_labels}"/>
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


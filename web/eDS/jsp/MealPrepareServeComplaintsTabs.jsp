<!DOCTYPE html>
<%@  page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  
 %>
<html>
<head>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script> -->
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>

<script language="javascript">
function changeTab(objStr)
{	
	selectTab(objStr);
	var frmObj=document.MealPrepareServeComplaintsTabForm;
	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
	if(objStr =="SpclFoodItems") {
		document.getElementById("SpclFoodItemsTab").style.display = '';
		document.getElementById("viewID").value="freqBasedTab";
		parent.meal_tab_frame.meal_plan_details_frame.location.href="../../eCommon/html/blank.html";
		parent.header_frame.location.href="../../eDS/jsp/MealPrepareServeComplaintsFreqBasedHeader.jsp?"+params;
		tabClicked('freqBasedTab');
	}
	else {
		document.getElementById("SpclFoodItemsTab").style.display = "none";
		document.getElementById("viewID").value="mealTypeTab";
		parent.meal_tab_frame.meal_plan_details_frame.location.href="../../eCommon/html/blank.html";
		parent.header_frame.location.href="../../eDS/jsp/MealPrepareServeComplaintsHeader.jsp?"+params;
	}
	//parent.tab_frame.location.href="../../eDL/jsp/MealPrepareServeComplaintsTabFrames.jsp?"+params;
 }

function changeSpclFoodItemsTab(objStr) {
	var frmObj=document.MealPrepareServeComplaintsTabForm;
	var params=frmObj.params.value;
	document.getElementById("viewID").value=objStr;
	if(objStr=="freqBasedTab") {
		selectTab('FreqBasedTab');
		parent.meal_tab_frame.meal_plan_details_frame.location.href="../../eCommon/html/blank.html";
		parent.header_frame.location.href="../../eDS/jsp/MealPrepareServeComplaintsFreqBasedHeader.jsp?"+params;
	}
	else if(objStr=="nonFreqBasedTab") {
		prevTabObj="FreqBasedTab";
		selectTab('NonFreqBasedTab');
		parent.meal_tab_frame.meal_plan_details_frame.location.href="../../eCommon/html/blank.html";
		parent.header_frame.location.href="../../eDS/jsp/MealPrepareServeComplaintsNonFreqBasedHeader.jsp?"+params;
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<STYLE TYPE="text/css">
       	A:link{
       	     COLOR: white;
       	}
     	A:visited{
             COLOR: white ;
        }
        A:active{
             COLOR: white;
        }
</style>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="MealPrepareServeComplaintsTabForm" id="MealPrepareServeComplaintsTabForm">
<table id="tab" cellspacing=3 cellpadding="1" border="0" width="100%">
	  <tr>

	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="eOT.MealTypeTab.Label" bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="tabClicked('mealTypeTab');changeTab('MealType');" id="MealType">
				<span class="tabSpanclicked" id="MealTypespan">
				<fmt:message key="eOT.MealTypeTab.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="tabClicked('spFoodItemsTab');changeTab('SpclFoodItems');" id="SpclFoodItems">
				<span class="tabAspan" id="SpclFoodItemsspan">
				<fmt:message key="eOT.SpclFoodItems.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

</tr>
<tr id="SpclFoodItemsTab" style='display:none'>
<td width= "100%" class="white">
<ul id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="tabClicked('freqBasedTab');changeSpclFoodItemsTab('freqBasedTab');" id="FreqBasedTab">
				<span class="tabSpanclicked" id="FreqBasedTabspan">
				<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="tabClicked('nonFreqBasedTab');changeSpclFoodItemsTab('nonFreqBasedTab');" id="NonFreqBasedTab">
				<span class="tabAspan" id="NonFreqBasedTabspan">
				<fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
</ul>
</td>
</tr>
<script> prevTabObj='MealType'</script>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="viewID" id="viewID" value="mealTypeTab">
</form>
</body>
</html>


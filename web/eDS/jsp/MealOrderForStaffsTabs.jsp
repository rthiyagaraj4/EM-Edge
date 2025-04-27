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
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eDS/js/MealOrderForStaffs.js"></script>

<script language="javascript">
function changeTab(objStr)
{	
	selectTab(objStr);
	var frmObj=document.MealOrderForStaffsTabForm;
	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
	var error="";
	if(objStr =="MealOrder"){
		document.getElementById("viewID").value="mealOrderTab";
		parent.details_frame.location.href="../../eDS/jsp/MealOrderCUD.jsp?"+params;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
	else{
		document.getElementById("viewID").value="mealServedTab";
		parent.details_frame.location.href="../../eDS/jsp/DocumentMealServedCUD.jsp?"+params;
		parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	}
 }
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<style TYPE="text/css">
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

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="tabClicked('MealOrder');changeTab('MealOrder');">
<form name="MealOrderForStaffsTabForm" id="MealOrderForStaffsTabForm">
<table id="tab" cellspacing=3 cellpadding="1" border="0" width="100%">
<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" style="padding-left: 5px;">
		<li class="tablistitem" title='Meal Order'>
			<a  class="tabClicked"  onclick="tabClicked('MealOrder');changeTab('MealOrder');" id="MealOrder">
				<span class="tabSpanclicked" id="MealOrderspan">
					<fmt:message key="eOT.MealOrder.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='Document Meal Served' >
			<a  class="tabA"  onclick="tabClicked('MealServed');changeTab('MealServed');" id="MealServed">
				<span class="tabAspan" id="MealServedspan">
					<fmt:message key="eOT.DocMealServed.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
</tr>
<script> prevTabObj='MealType'</script>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
<input type="hidden" name="viewID" id="viewID" value="mealOrderTab">
<script> prevTabObj='MealOrder'</script>
</form>
</body>
</html>


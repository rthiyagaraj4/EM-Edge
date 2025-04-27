<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eDS/js/MealPreparedServedComplaints.js"></script>

<script language="javascript">
function changeTab_SpclFoodItems(objStr)
{	selectTab(objStr);
	var frmObj=document.MealPrepareServeComplaintsTabForm;
	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
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
<form name="SpecialFoodItemsTabForm" id="SpecialFoodItemsTabForm">
<table id="tab" cellspacing=3 cellpadding="1" border="0" width="100%">
	  <tr>

	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="tabClicked('freqBasedTab');changeTab('FreqBased');" id="FreqBasedTab">
				<span class="tabSpanclicked" id="FreqBasedTabspan">
				<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

		<li class="tablistitem" title='<fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="tabClicked('nonFreqBasedTab');changeTab('NonFreqBased');" id="NonFreqBasedTab">
				<span class="tabAspan" id="NonFreqBasedTabspan">
				<fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>

</tr>
<script> prevTabObj='FreqBased'</script>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
</form>
</body>
</html>


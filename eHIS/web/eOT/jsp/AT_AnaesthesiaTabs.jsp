<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>


<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link> 
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
 
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.RecordAnesthesiaTabForm;
	var obj=document.getElementById("AnesthesiaDetails");
	var params=frmObj.params.value;
	params=params+"&tab_name="+objStr;
	parent.at_tab_frame.location.href="../../eOT/jsp/AT_AnaesthesiaTabFrames.jsp?"+params;
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
<form name="RecordAnesthesiaTabForm" id="RecordAnesthesiaTabForm">
<table id="tab" cellspacing=3 cellpadding="1" border="0" width="100%">
	  <tr>
	
	<td width= "100%" class="white">
	<ul style = padding-left:0px ; id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/>'>
			<a  class="tabClicked"  onclick="changeTab('AnesthesiaDetails');" id="AnesthesiaDetails"> 
				<span class="tabSpanclicked" id="AnesthesiaDetailsspan">
				<fmt:message key="Common.AnaesthesiaDetails.label" bundle="${common_labels}"/> 
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('PendingOrders');" id="PendingOrders"> 
				<span class="tabAspan" id="PendingOrdersspan">
				<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
	
</tr>
<script> prevTabObj='AnesthesiaDetails'</script>
</table>
<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
</form>
</body>
</html>


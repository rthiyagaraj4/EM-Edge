<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<STYLE TYPE="text/css">
       	A:link
       	{
       	     COLOR: white;
       	}
     	A:visited
     	{
             COLOR: white ;
        }
        A:active
        {
             COLOR: white;
        }
</style>


<script language='javascript'>
function changeTab(objStr)
{

var frmObj=document.forms[0];
var obj1=document.getElementById("ByDate");
obj1.className="CAFIRSTSELECTHORZ";
obj1=document.getElementById("ByPatient");
obj1.className="CAFIRSTSELECTHORZ";

obj1=document.getElementById(objStr);
obj1.className="CASECONDSELECTHORZ";


if(objStr=='ByDate')
{
var param=frmObj.param.value;
parent.frames[1].location.href="../../eOT/jsp/PickGenByDate.jsp?"+param;
}
if(objStr=='ByPatient')
	{
parent.parent.frames[1].frames[1].location.href="../../eOT/jsp/PickListPatientFrame.jsp?"+param;
//	alert('U N D E R C O N S T R U C T I O N');
}

}

function initTab()
{
obj1=document.getElementById("ByDate");
obj1.className="CAFIRSTSELECTHORZ";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<form name="OrCommonForm" id="OrCommonForm" OnLoad="initTab()">
<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>

<tr>
	<td id="ByDate" 	class="CASECONDSELECTHORZ" onMouseOver="" onMouseOut=";" onclick="" nowrap>
		<a  class="MENUHIGHERLEVELLINK" 
		href="javascript:changeTab('ByDate');"> 
			<fmt:message key="Common.ByDate.label" bundle="${common_labels}"/></a>
	</td>

	<td id="ByPatient" class="CAFIRSTSELECTHORZ"  onMouseOver="" onMouseOut=""  onclick="" nowrap>
				<!--<a  class="MENUHIGHERLEVELLINK" href="javascript:changeTab('ByPatient');"> ByPatient</a>-->
		<fmt:message key="eOT.ByPatient.Label" bundle="${ot_labels}"/>
	</td>
	<td colspan='5' width='75%'></td>
</tr>
<input type='hidden' name='booking_no' id='booking_no' value='<%=request.getParameter("ByPatient")%>' %>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>


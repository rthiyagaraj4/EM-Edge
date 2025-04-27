<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title>
<fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
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
function changeTab(objStr){
	selectTab(objStr);
	var frmObj=document.forms[0];
	//var obj1=document.getElementById("ByDate");
	//obj1.className="CAFIRSTSELECTHORZ";
	//obj1=document.getElementById("ByPatient");
	//obj1.className="CAFIRSTSELECTHORZ";
	//obj1=document.getElementById(objStr);
	//obj1.className="CASECONDSELECTHORZ";
	if(objStr=='ByDate'){
		var param=frmObj.param.value;
		//if(frmObj.booking_no.value!=null &&  frmObj.booking_no.value!='')
		parent.frames[1].location.href="../../eOT/jsp/PickGenByDate.jsp?"+param;
		//parent.parent.frames[2].location.href="../../eOT/jsp/PatientView.jsp?"+param;
		/*else
		parent.parent.frames[1].location.href="../../eOT/jsp/PickGenPatientDtl.jsp?"+param;
		*/
	}
	if(objStr=='ByPatient'){
		parent.parent.frames[1].frames[1].location.href="../../eOT/jsp/PickListPatientFrame.jsp?"+param;
		//	alert('U N D E R C O N S T R U C T I O N');
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<form name="OrCommonForm" id="OrCommonForm" >
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align='center'>
<tr>
<td width= "100%" class="white">
	<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='<fmt:message key="Common.ByDate.label" bundle="${common_labels}"/>' >
			<a  class="tabClicked"  onclick="changeTab('ByDate');" id="ByDate"> 
				<span class="tabSpanclicked" id="ByDatespan">
				<fmt:message key="Common.ByDate.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
		<li class="tablistitem" title='<fmt:message key="eOT.ByPatient.Label" bundle="${ot_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('ByPatient');" id="ByPatient"> 
				<span class="tabAspan" id="ByPatientspan">
				<fmt:message key="Common.Review.label" bundle="${common_labels}"/>
				</span>
			</a>
		</li>
	</ul>
	</td>

<!-- <td id="ByDate" 	class="CASECONDSELECTHORZ" onMouseOver="" onMouseOut=";" onclick="" nowrap>
		<a  class="MENUHIGHERLEVELLINK" 
		href="javascript:changeTab('ByDate');"> 
			<fmt:message key="eOT.ByDate.Label" bundle="${ot_labels}"/></a>
			</td>

			<td id="ByPatient" 		onMouseOver="" onMouseOut=";"  onclick="" nowrap>
			<fmt:message key="eOT.ByPatient.Label" bundle="${ot_labels}"/>
			</td> -->
</tr>
<input type='hidden' name='booking_no' id='booking_no' value='<%=request.getParameter("ByPatient")%>' %>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
</table>
</form>
</body>
</html>


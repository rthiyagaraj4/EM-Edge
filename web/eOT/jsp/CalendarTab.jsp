<!DOCTYPE html>
<html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	
    //Added Against MMS Vulnerability Issue - Starts 
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript'>
function changeTab(objStr){
	/* donot delete the below code. Old statements for references
		var obj1=document.getElementById("ScheduleStatus");
		obj1.className="CAFIRSTSELECTHORZ";
		obj1=document.getElementById("DaySchedule");
		obj1.className="CAFIRSTSELECTHORZ";
		obj1=document.getElementById(objStr);
		obj1.className="CASECONDSELECTHORZ";
	*/
	selectTab(objStr);
	var frmObj=document.forms[0];
	var param=frmObj.param.value;
	var called_from=frmObj.called_from.value;
	//alert("param--->"+param)
	//alert(objStr);
	if(objStr=='ScheduleStatus'){
		if(called_from!="OT_SLATE") {
			//alert("32")
				//parent.parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;
			parent.parent.frames[1].location.href="../../eOT/jsp/CalendarFrame.jsp?"+param;
			//alert(parent.parent.commontoolbarFrame.document.forms[0].name)
			if(parent.parent.parent.commontoolbarFrame!=null && parent.parent.parent.commontoolbarFrame.document.forms[0].reset.disabled==true){
			
				if(parent.parent.parent.commontoolbarFrame.document.forms[0].home.value=='Menu')
				expand='0';
				else expand='1';
			
			param=param+"&expand="+expand;
            parent.parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+param;
			}
		}else{
			//alert("46")
			parent.parent.frames[0].location.href="../../eOT/jsp/CalendarTab.jsp?"+param;
			parent.parent.frames[1].location.href="../../eOT/jsp/DiarySheduleSearch.jsp?"+param;
		}
	}
}
/*
function initTab(){
	//commented for Thai converions. called from <form OnLoad="initTab()"....
	obj1=document.getElementById("DaySchedule");
	obj1.className="CAFIRSTSELECTHORZ";
}
*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OrCommonForm" id="OrCommonForm" >
	<!-- <table id="tab" cellspacing=0 cellpadding=3="1" border="0" width='100%'>

		<tr>
			<td id="ScheduleStatus" 	class="CASECONDSELECTHORZ" onMouseOver="" onMouseOut="" onclick="" nowrap>
			<a class="MENUHIGHERLEVELLINK" href="javascript:changeTab('ScheduleStatus');"> 
				<fmt:message key="eOT.ScheduleStatus.Label" bundle="${ot_labels}"/></a>
			</td>

			<td id="DaySchedule" class="CAFIRSTSELECTHORZ"  onMouseOver="" onMouseOut=""  onclick="" nowrap>
			<a class="MENUHIGHERLEVELLINK"><fmt:message key="eOT.DaySchedule.Label" bundle="${ot_labels}"/></a>
			</td>
<td colspan='5' width='75%'>&nbsp;</td>
</tr> -->

<tr>
	<td width= "100%" class="white">
	<ul id="tablist" class="tablist" style="padding-left:0px" >
		<li class="tablistitem" title='<fmt:message key="eOT.ScheduleStatus.Label" bundle="${ot_labels}"/>' >
			<a  class="tabClicked"  onclick="changeTab('ScheduleStatus');" id="ScheduleStatus"> 
				<span class="tabSpanclicked" id="ScheduleStatusspan"><fmt:message key="eOT.ScheduleStatus.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="Common.Review.label" bundle="${common_labels}"/>' >
			<a  class="tabA"  onclick="changeTab('DaySchedule');" id="DaySchedule"> 
				<span class="tabAspan" id="DaySchedulespan"><fmt:message key="eOT.DaySchedule.Label" bundle="${ot_labels}"/>
				</span>
			</a>
		</li>
	</ul>
  </td>
</tr>
<!-- The below line is required to change the select state of Initial tab selected -->
<input type='hidden' name='booking_no' id='booking_no' value='<%=request.getParameter("booking_no")%>' %>
<input type='hidden' name='called_from' id='called_from' value='<%=request.getParameter("called_from")%>' %>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
</table>
</form>
</body>
</html>
<script>prevTabObj='ScheduleStatus'</script>


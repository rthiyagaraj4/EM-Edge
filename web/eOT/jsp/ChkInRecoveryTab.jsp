<!DOCTYPE html>
<%@ page import ="eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.*" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>


<% String recovery_in_out_flag = CommonBean.checkForNull(request.getParameter("recovery_in_out_flag")); %>

<html>
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/Tabs.css"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eOT/js/CheckInOutRecoveryRoom.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
</head>
<script language="javascript">
function changeTab(objStr)
{
	selectTab(objStr);
	var frmObj=document.forms[0];

	//var recovery_in_out_flag = frmObj.recovery_in_out_flag.value;
	<% if(recovery_in_out_flag.equals("CHECK_IN_RECO")){ %>
	//	obj1=document.getElementById("untowards_tab");
//		obj1.className="CAFIRSTSELECTHORZ";
	<%}else{%>
//		obj1=document.getElementById("specimen_tab");
//		obj1.className="CAFIRSTSELECTHORZ";
	<%}%>
//	obj1=document.getElementById(objStr);
//	obj1.className="CASECONDSELECTHORZ";
	var params=frmObj.param.value;
	parent.parent.commontoolbarFrame.location.href="../../eCommon/jsp/commonToolbar.jsp?"+params;
	<%  if(recovery_in_out_flag.equals("CHECK_IN_RECO") ){ %>
	 parent.parent.result_frame.location.href='../../eOT/jsp/UntowardEventFrames.jsp?'+params
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	<%}else{%>
		if(objStr=='SpecimenDetails'){
			//parent.parent.result_frame.location.href="../../eOT/jsp/DisposalDetailsFrame.jsp?"+params;
			parent.parent.parent.result_frame.location.href='../../eOT/jsp/SpecimenFrames.jsp?'+params;
			parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="
		}
<%}%>

}//end of Change Tab script method
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="CheckInRecoveryTabForm" id="CheckInRecoveryTabForm">
<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%' align='center'>
<tr>
<%  if(recovery_in_out_flag.equals("CHECK_IN_RECO")){ %>
 <td width="100%" class="white" colspan="2">
	<ul id="tablist" class="tablist" >
	<li class="tablistitem" title='<fmt:message key="eOT.UntowardEvents.Label" bundle="${ot_labels}"/>'>
		<a class="tabClicked" onclick="changeTab('UntowardEvents');" id="UntowardEvents"> 
		<span class="tabSpanclicked" id="UntowardEventsspan">
		<fmt:message key="eOT.UntowardEvents.Label" bundle="${ot_labels}"/></span>
		</a>
	</li>
	</ul>
	</td> 
	<!-- <td width="25%" class="button" colspan="2">
		<input type='button' class='button' value='<fmt:message key="eOT.RecoveryNotes.Label" bundle="${ot_labels}"/>' onClick='funRecoveryNotes();'>
		<input type='button' class='button' value='<fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/>' name="record_vitals"onClick='callRecordVitals();'>
	</td>	Commented by sathish on17-03-2009 for Amazon changes. These buttons transferred to CommonOperHdr.jsp -->
	<%}
			
	else{%>
		<td width="25%" class="white" colspan="4">
		<ul id="tablist" class="tablist">
			<li class="tablistitem" title='<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/>'>
			<a class="tabClicked"  onclick="changeTab('SpecimenDetails');" 	id="SpecimenDetails"> 
				<span class="tabSpanclicked" id="SpecimenDetailsspan">
					<fmt:message key="Common.SpecimenDetails.label" bundle="${common_labels}"/>
				</span>
			</a>
	</li>
	</ul>
	</td>
	<% } %>
	</tr>
</table>
<input type='hidden' name='param' id='param' value='<%=request.getQueryString()%>'>
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=CommonBean.checkForNull(request.getParameter("slate_user_id"))%>' >
<input type='hidden' name='discr_msr_id' id='discr_msr_id' value='<%=CommonBean.checkForNull(request.getParameter("discr_msr_id"))%>' >
<script>

<%	if(recovery_in_out_flag.equals("CHECK_IN_RECO")){ %>
	prevTabObj='UntowardEvents';
	changeTab('UntowardEvents');
<%}else{%>
	prevTabObj='SpecimenDetails';
	changeTab('SpecimenDetails');
<%	} %>
</script>
<% if(recovery_in_out_flag.equals("CHECK_IN_RECO")){ %>
		<script>isRecordVitalEnable()
		
		</script> 
<% } %>
</form>
</body>
</html>
	


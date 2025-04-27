<!DOCTYPE html>

<%@page  import ="eCommon.XSSRequestWrapper,eCommon.Common.CommonBean"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%@page  contentType="text/html;charset=UTF-8" %>
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
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
</head>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
<script language="javascript">
function changeTab(objStr){
	var frmObj=document.RecordIntraAnesthesiaTabForm;
	selectTab(objStr);
	var params=frmObj.params.value;
	if(parent.intra_anesth_header_frame!=null){
		var hdr_formObj = parent.intra_anesth_header_frame.RecordAnesthesiaHdrForm;
		if(hdr_formObj!=null){
			accession_num=hdr_formObj.accession_num.value;
		}
		params="accession_num="+accession_num+"&"+params;
	}
	var old_objStr = "";
	if(objStr=="OperationProcedures")
		old_objStr = "operations_procedures";
	else if(objStr=="PersonalDetails")
		old_objStr = "personal_details";
	params=params+"&tab_name="+old_objStr;
	parent.intra_anesth_tab_details_frame.location.href="../../eOT/jsp/AT_IntraAnaesTabFrames.jsp?"+params;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% 

   String facility_id = CommonBean.checkForNull( request.getParameter("facility_id") );
   String patient_id = CommonBean.checkForNull( request.getParameter("patient_id") );
   String anesthesia_srl_no = CommonBean.checkForNull( request.getParameter("anesthesia_srl_no") );
   java.util.Properties prop = null;
   prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
%>

<form name="RecordIntraAnesthesiaTabForm" id="RecordIntraAnesthesiaTabForm">
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width="100%">
		<tr>
		
	<td width="100%" class="white">
		
	<ul id="tablist" class="tablist" >

	<li class="tablistitem" title='<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/>'>
	 <a  class="tabClicked"  onclick="changeTab('OperationProcedures');" id="OperationProcedures"> 
					<span class="tabSpanclicked" id="OperationProceduresspan">
					<fmt:message key="eOT.OperationsProcedures.Label" bundle="${ot_labels}"/> 
					</span>
	</a>
	</li>	
	
	<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>'>
	 <a  class="tabA"  onclick="changeTab('PersonalDetails');" id="PersonalDetails"> 
		<span class="tabAspan" id="PersonalDetailsspan">
		<fmt:message key="eOT.PersonnelDetails.Label"  bundle="${ot_labels}"/> 
		</span>
	</a>
</li>			

</td>
</tr>
	<script>prevTabObj='OperationProcedures'</script>

</table>
	<input type="hidden" name="params" id="params" value="<%=request.getQueryString()%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="anesthesia_srl_no" id="anesthesia_srl_no" value="<%=anesthesia_srl_no%>">
</form>
</body>
</html>


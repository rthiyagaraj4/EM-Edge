<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper,eCommon.Common.CommonBean" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
<% 
   String slate_user_id = CommonBean.checkForNull( request.getParameter("login_user") ); 
   String facility_id = CommonBean.checkForNull( request.getParameter("facility_id") );
   String patient_id = CommonBean.checkForNull( request.getParameter("patient_id") );
   String anesthesia_srl_no = CommonBean.checkForNull( request.getParameter("anesthesia_srl_no") );
   String episode_id = CommonBean.checkForNull( request.getParameter("episode_id") );
   String anesthesia_accession_num = CommonBean.checkForNull( request.getParameter("anesthesia_accession_num") );
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> 
	<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PostAnaesthesiaTabForm" id="PostAnaesthesiaTabForm">
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>'>
	<table id="tab" cellspacing=0 cellpadding=3  border="0" width='100%'>
		<tr>
		<td width="100%" class="white" >
		<ul id="tablist" class="tablist" >
		<li class="tablistitem" title='<fmt:message key="eOT.PersonnelDetails.Label"  bundle="${ot_labels}"/>'>
			<a  class="tabClicked"  onclick="changeTab('PersonalDetails');" id="PersonalDetails"> 
				<span class="tabSpanclicked" id="PersonalDetailsspan">
					<fmt:message key="eOT.PersonnelDetails.Label"  bundle="${ot_labels}"/> 
				</span>
			</a>
		</li>
		
		<li class="tablistitem" title='<fmt:message key="eOT.UntowardEvent.Label" bundle="${ot_labels}"/>'>
		    <a  class="tabA"  onclick="changeTab('UntowardEvent');" id="UntowardEvent"> 
			<span class="tabAspan" id="UntowardEventspan">
				<fmt:message key="eOT.UntowardEvent.Label"  bundle="${ot_labels}"/> 
			</span>
			</a>
		</li>
		</ul>
</td>

</td>
</table>
<script>
	prevTabObj='PersonalDetails';
	changeTab('PersonalDetails');
</script>
<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
<input type="hidden" name="slate_user_id" id="slate_user_id" value="<%=slate_user_id%>">
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type='hidden' name='episode_id' id='episode_id' value='<%=episode_id%>'>
<input type="hidden" name="anesthesia_srl_no" id="anesthesia_srl_no" value="<%=anesthesia_srl_no%>">
<input type="hidden" name="anesthesia_accession_num" id="anesthesia_accession_num" value="<%=anesthesia_accession_num%>">
</form>
</body>
</html>


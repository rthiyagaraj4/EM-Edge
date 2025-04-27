<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>                        
<% request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>


<html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.HashMap,java.util.ArrayList,eOT.AT_AnaesthesiaHistoryBean" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/Common.jsp" %>

<head>
<link rel="StyleSheet" type="text/css" href="../../eOT/html/AnaesthesiaHistoryStyle.css"></link>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale	= (String)session.getAttribute("LOCALE");
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
 String accession_num = checkForNull(request.getParameter("accession_num"));
 String strAnesthesiaSrlNo = checkForNull(request.getParameter("anaesthesia_srl_no"));
  String bean_id = "AT_AnaesthesiaHistoryBean";
  String bean_name = "eOT.AT_AnaesthesiaHistoryBean";
  AT_AnaesthesiaHistoryBean bean = (AT_AnaesthesiaHistoryBean) mh.getBeanObject( bean_id, request, bean_name );
  String strHeight="",strWeight="",strBSA="",strAnaesthesiaDesc="",strEndDateTime="",strStartDateTime="",strBMIDesc="",strRecoveryStartDateTime="",strRecoveryEndDateTime="";
  

HashMap map = bean.getBMIDtls(strAnesthesiaSrlNo);
if(map!=null && map.size()>0){
	 strHeight=(String) map.get("height");
	 strWeight=(String) map.get("weight");;
	 strBSA=(String) map.get("bsa");
	 strBMIDesc=(String) map.get("bmi");
	 strAnaesthesiaDesc=(String) map.get("anaesthesia");
	 strStartDateTime=(String) map.get("start_time_anes");
	 strEndDateTime=(String) map.get("end_time_anes");
	 strRecoveryStartDateTime=(String) map.get("start_time_rec");
	 strRecoveryEndDateTime=(String) map.get("end_time_rec");
}
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AnaesthesiaParticulars" id="AnaesthesiaParticulars" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
<tr><td colspan=2>
</td></tr>
 <tr>
	<td class="OTGROUPHEADER" colspan=2>
	<fmt:message key="eOT.BMIDetails.Label" bundle="${ot_labels}"/>	
	
	
	
	</td>
</tr>
 <tr>
	<td class="label"><B>
	<fmt:message key="Common.height.label" bundle="${common_labels}"/>	
	
	<%=strHeight%>
	<fmt:message key="Common.Cms.label" bundle="${common_labels}"/>	
	</B></td>
	<td class="label"><B><fmt:message key="Common.weight.label" bundle="${common_labels}"/>: 	  
	<%=strWeight%>
	<fmt:message key="Common.Kgs.label"  bundle="${common_labels}"/>:	  
	</B></td>
</tr>
 <tr>
	<td class="label"><B>
	<fmt:message key="Common.BSA.label" bundle="${common_labels}"/>:
	<%=strBSA%></B></td>
	<td class="label"><B>
	<fmt:message key="Common.BMI.label"bundle="${common_labels}"/>	
	<%=strBMIDesc%><B></td>
 </tr>
 <tr><td colspan=2>
 </td></tr>
 </table>
 <table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	 <tr>
		<td class="OTGROUPHEADER" colspan=2>
		<fmt:message key="eOT.AnaesthesiaParticulars.Label" bundle="${ot_labels}"/>	
		</td>
	 </tr>
	 <tr>
		<td class="label" ><b> <fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>:
		
<%=strAnaesthesiaDesc%></b></td>
		<td class="label">
		</td>
	</tr>
	 <tr>
		<td class="label"><B>
		<fmt:message key="eOT.AnaesthesiaStartTime.Label" bundle="${ot_labels}"/>:	
	<!-- Modfied by DhanasekarV on 22/11/2010 against the issue IN025160-->
	<%=com.ehis.util.DateUtils.convertDate(strStartDateTime,"DMYHM","en",locale)%></B></td>
	<!--	<%=strStartDateTime%></B></td>-->
		<td class="label"><B>
		<fmt:message key="eOT.AnaesthesiaEndTime.Label" bundle="${ot_labels}"/>:
		<%=com.ehis.util.DateUtils.convertDate(strEndDateTime,"DMYHM","en",locale)%></B></td>
		<!--<%=strEndDateTime%></B></td>-->
	</tr>
	 <tr><td colspan=2></td></tr>
 </table>
 <table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="OTGROUPHEADER" COLSPAN=2>
			<fmt:message key="eOT.RecoveryParticulars.Label" bundle="${ot_labels}"/>
		</td>
	</tr>
	<tr>
		<td class="label"><B>
		<fmt:message key="eOT.RecoveryStartTime.Label" bundle="${ot_labels}"/>:
		<%=com.ehis.util.DateUtils.convertDate(strRecoveryStartDateTime,"DMYHM","en",locale)%></B></td>
		<!--<%=strRecoveryStartDateTime%></B></td>-->
		<td class="label"><B>
		<fmt:message key="eOT.RecoveryEndTime.Label" bundle="${ot_labels}"/>
		:<%=com.ehis.util.DateUtils.convertDate(strRecoveryEndDateTime,"DMYHM","en",locale)%></B></td>
		<!--:<%=strRecoveryEndDateTime%></B></td> -->
	</tr>
	<tr><td colspan=2></td></tr>
 </table>
 <table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
 <tr>
	<td class="OTGROUPHEADER" COLSPAN=3>
	<fmt:message key="eOT.PersonnelDetails.Label" bundle="${ot_labels}"/>
	</td>
	</tr>
	<td class="columnHeader" align="center">
	<fmt:message key="Common.Role.label" bundle="${common_labels}"/>	
	</td>
	<td class="columnHeader"  align="center">
	<fmt:message key="Common.name.label" bundle="${common_labels}"/>:	
	</td>
	<td class="columnHeader"  align="center">
	<fmt:message key="Common.Position.label" bundle="${common_labels}"/>:	
	</td>
	<%
		ArrayList list_personnel = bean.getPersonnelDtls(strAnesthesiaSrlNo);
		if(list_personnel!=null && list_personnel.size()>0){
			int len = list_personnel.size();
			for(int i=0;i<len;i++){
			map = (HashMap)list_personnel.get(i);
	%>
		<tr>
			<td class="label" align="center"><B><%=map.get("role")%></B></td>
			<td class="label" align="center"><B><%=map.get("surgeon")%>
		</B></td>
			<td class="label"align="center"><B><%=map.get("position")%></B></td>
		</tr>
	<%}}%>
	<tr><td colspan=3></td></tr>
 </table>
 
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	<td class="columnHeader" align='Center'>
	<fmt:message key="eOT.UntowardEvents.Label"bundle="${ot_labels}"/>	
	</td>
	<td class="columnHeader" align='Center'>
	<fmt:message key="Common.ActionRemarks.label" bundle="${common_labels}"/>	
	</td>
	<td class="columnHeader" align='Center'>
	<fmt:message key="Common.generalRemarks.label" bundle="${common_labels}"/>
	</td>
	<%
		ArrayList list_untoward = bean.getUntowardEvtsDtls(accession_num);
		if(list_untoward!=null && list_untoward.size()>0){
		int size = list_untoward.size();
		for(int i=0;i<size;i++){
		map = (HashMap)list_untoward.get(i);
	%>

	<tr>
		<td class="label" align="center"><B><%=map.get("untoward_event")%></B></td>
		<td class="label" align="center"><B><%=map.get("action_remarks")%></B></td>
		<td class="label" align="center"><B><%=map.get("general_remarks")%></B></td>
		
	</tr>
	<%}}%>
	<tr><td colspan=3></td></tr>
 </table>
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="OTGROUPHEADER" COLSPAN=3>
		<fmt:message key="eOT.PremorbidDetails.Label" bundle="${ot_labels}"/>	
		
		
		</td>
	</tr>
	<td class="columnHeader" align='center'>
	<fmt:message key="eOT.PreMorbidStatus.Label" bundle="${ot_labels}"/>	
	
	</td>
	<td class="columnHeader" align='center'>
	<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
	</td>
	<tr>
	<%
		ArrayList list_pre_morbid = bean.getPreMorbidDtls(strAnesthesiaSrlNo);
		if(list_pre_morbid!=null && list_pre_morbid.size()>0){
		int capcity = list_pre_morbid.size();
		for(int i=0;i<capcity;i++){
		map = (HashMap)list_pre_morbid.get(i);
	%>
		<td class="label" align="center"><B><%=map.get("premorbid")%></B></td>
		<td class="label" align="center"><B><%=map.get("remarks")%></B></td>
	</tr>
	<%}}%>
	<tr><td colspan=2></td></tr>
 </table>
</form>
</body>
</html>


<!DOCTYPE html>

<%@page import="eBT.*, java.sql.*, java.text.*,java.util.*"  contentType="text/html; charset=UTF-8"%>



<jsp:useBean id="bean" scope="page" class="eBT.BTQueryDetails"/>

<html>
<%	request.setCharacterEncoding("UTF-8");	%>
<!--<head><title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBT.PatientAntibody.label","bt_labels")%></title>-->



<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<head>
	<!--<title><fmt:message key="eBT.PatientAntibody.label" bundle="${bt_labels}"/></title>-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
	String patient_id				= request.getParameter("patient_id");

	Properties properties			= (Properties) session.getValue( "jdbc" ); 
    String classValue				= "";
    ArrayList antiBodyDetails      = new ArrayList();
	ArrayList antibody					= null;
	String locale = (String)session.getAttribute("LOCALE");
	antiBodyDetails				= bean.getAntiBodyDetails(patient_id,locale, properties);	

	String 	antibody_code	= "";
	String long_desc	= "";
	String  last_date	="";
	int    i	= 0;

%>
<form name="antibody_details" id="antibody_details">


	<table width="100%" border='1' cellspacing="0" cellpadding="0" >
	<tr>
		<th width="20%" ><fmt:message key="eBT.Antibody.label" bundle="${bt_labels}"/></th>
		<th width="55%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width="25%"><fmt:message key="eBT.LastReportedDate.label" bundle="${bt_labels}"/></th>
	</tr>
<%
		for(i=0;i<antiBodyDetails.size();i++)
		{
			antibody =(ArrayList)antiBodyDetails.get(i);
			if(i % 2 == 0){
				classValue = "QRYEVEN";
			}else{
				classValue = "QRYODD";
			}
			antibody_code = (String)antibody.get(0);
			if(antibody_code==null) antibody_code = "";
			long_desc = (String)antibody.get(1);
			if(long_desc==null) long_desc = "";
			last_date =(String)antibody.get(2);
			if(last_date==null) last_date = "";

%>
			<tr>
				<td width="20%"  class="<%=classValue%>"><%=antibody_code%></td>
				<td width="55%"  class="<%=classValue%>"><%=long_desc%></td>
	 			<td width="25%"  class="<%=classValue%>"><%=last_date%></td>

			</tr>

<%			
			if(antibody!=null){
				antibody.clear();
				antibody = null; // nullifying the objects
			}
		}
		if(i == 0){ %>
	  	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();</script>
<% } %>

</table>


</tr>
</form>
<%
	// Nullifying the objects
	if(antiBodyDetails!=null) {
		antiBodyDetails.clear();
		antiBodyDetails      = null;
	}
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


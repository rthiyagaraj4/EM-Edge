<!DOCTYPE html>

<%@page import="eBT.*,java.util.*"  contentType="text/html; charset=UTF-8"%>



<jsp:useBean id="bean" scope="page" class="eBT.BTQueryDetails"/>

<html>
<head>



<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
	String patient_id				= request.getParameter("patient_id");
	String locale = (String)session.getAttribute("LOCALE");

	Properties properties			= (Properties) session.getValue( "jdbc" ); 
    String classValue				= "";
    ArrayList requirementDetails       = new ArrayList();
	ArrayList requirement				= null;
	requirementDetails				= bean.getRequirementDetails(patient_id,locale,properties);	

	String 	requirement_code	= "";
	String short_desc	= "";
	int    i	= 0;

%>
<form name="requirement_details" id="requirement_details">
	<table width="100%" border='1' cellspacing="0" cellpadding="0" >
	<tr>
		<th width="35%" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width="65%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	</tr>
<%
		for(i=0;i<requirementDetails.size();i++)
		{
			requirement =(ArrayList)requirementDetails.get(i);
			if(i % 2 == 0){
				classValue = "QRYEVEN";
			}else{
				classValue = "QRYODD";
			}
			requirement_code = (String)requirement.get(0);
			if(requirement_code==null) requirement_code = "";
			short_desc = (String)requirement.get(1);
			if(short_desc==null) short_desc = "";			
%>
			<tr>
				<td width="35%"  class="<%=classValue%>"><%=requirement_code%></td>
				<td width="65%"  class="<%=classValue%>"><%=short_desc%></td>
			</tr>

<%			
			if(requirement!=null){
				requirement.clear();
				requirement = null; // nullifying the objects
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
	if(requirementDetails!=null) {
		requirementDetails.clear();
		requirementDetails = null;
	}
	// set it back persistence
	//putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


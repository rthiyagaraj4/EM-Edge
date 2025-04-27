<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>

<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	String Patient_Id	=	request.getParameter("patient_id");
    String facilityId 	= (String) session.getValue( "facility_id" ) ;	
  %>

<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
<iframe name='PatientLineFrame' id='PatientLineFrame' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&Patient_Id=<%=Patient_Id%>' frameborder=0 scrolling='no' noresize style='height:10%;width:100vw'></iframe>
<iframe name='group_head' id='group_head' src='../../eIP/jsp/IPEncounterDisplay_WristBand.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling="auto" style='height:*%;width:100vw'></iframe><iframe name='group_head1' id='group_head1' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0%;width:100vw'></iframe>
</html>


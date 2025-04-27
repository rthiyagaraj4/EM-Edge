<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
	String Patient_Id	=	request.getParameter("patient_id");
    String facilityId 	= (String) session.getValue( "facility_id" ) ;
    String called_from = request.getParameter("called_from");
   if(called_from==null) called_from="";
%>


<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
<iframe name='PatientLineFrame' id='PatientLineFrame' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&Patient_Id=<%=Patient_Id%>' frameborder=0 scrolling='no' noresize style='height:13vh;width:95vw'></iframe>
<iframe name='group_head' id='group_head' src='../../eFM/jsp/IPEncounterDisplay.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling="auto" style='height:70vh;width:95vw'></iframe><iframe name='group_head1' id='group_head1' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0vh;width:95vw'></iframe>
</html>


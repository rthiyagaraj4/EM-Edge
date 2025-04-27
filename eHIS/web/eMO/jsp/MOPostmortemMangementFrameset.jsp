<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="eMO.RecordPostmortem.label" bundle="${mo_labels}"/></title>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
    String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); 
    String reg_no=request.getParameter("select_registration")==null?"":request.getParameter("select_registration"); 
	String viewdata=request.getParameter("viewdata")==null?"":request.getParameter("viewdata");
	String or_installyn=request.getParameter("or_installyn")==null?"N":request.getParameter("or_installyn");	
%>

    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MOManageDeceased.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name='header' id='header' src='../../eMO/jsp/MORegistrationDet.jsp?regn_no=<%=reg_no%>' frameborder=0 scrolling='no' noresize style='height:3%;width:100vw'></iframe>
<iframe name='patientLine' id='patientLine' src='../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>' frameborder=0 noresize scrolling='no' style='height:8%;width:100vw'></iframe><iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eMO/jsp/MORecordPostmortem.jsp?patient_id=<%=patient_id%>&regn_no=<%=reg_no%>&viewdata=<%=viewdata%>' frameborder=0 noresize scrolling='no' style='height:115%;width:100vw'></iframe><iframe name='OkCancel' id='OkCancel' src='../../eMO/jsp/MOBodyPartButton.jsp?butt1=butt1&viewdata=<%=viewdata%>&or_installyn=<%=or_installyn%>' frameborder=0 noresize scrolling='no' style='height:4%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:4%;width:100vw'></iframe><iframe name='dummyframe' id='dummyframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
	
				 
</html>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<title><fmt:message key="Common.Modify.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.deceaseddetails.label" bundle="${common_labels}"/></title>
<script language='javascript' src='../../eMR/js/CreatePatientFile.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String encounterid		=	checkForNull(request.getParameter("encounter_id"));
	String call_from		=	checkForNull(request.getParameter("call_from"));
	String patient_id		=	checkForNull(request.getParameter("patient_id"));
	String deceased_date	=	checkForNull(request.getParameter("deceaseddate"));
	String discharge_date	=	checkForNull(request.getParameter("dischargeDate"));
	String adm_date			=	checkForNull(request.getParameter("admissionDate"));
	//String admission_type	=	java.net.URLDecoder.decode(checkForNull(request.getParameter("admission_type")),"UTF-8");
	String admission_type	=	checkForNull(request.getParameter("admission_type"));
	String pract_id			=	checkForNull(request.getParameter("pract_id"));
	//String pract_name		=	checkForNull(request.getParameter("pract_name"));
	String remarks			=	checkForNull(request.getParameter("remarks"));

	
	
	
%>
<iframe src="../../eMR/jsp/AddModifyDeceasedDetails.jsp?encounter_id=<%=encounterid%>&call_from=<%=call_from%>&patient_id=<%=patient_id%>&deceased_date=<%=deceased_date%>&dischargeDate=<%=discharge_date%>&admissionDate=<%=adm_date%>&admission_type=<%=admission_type%>&pract_id=<%=pract_id%>&remarks=<%=remarks%>" name="Deceased_Date_Frame" scrolling='no' frameborder = 'no' noresize style='height:80%;width:100vw'></iframe>
	<iframe src="../../eMR/jsp/recordDiag.jsp?call_from=<%=call_from%>" name="RecordDiag_frame" scrolling='no' frameborder = 'no' noresize style='height:10%;width:100vw'></iframe>
	<iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame" scrolling='no'frameborder = 'no'  noresize style='height:10%;width:100vw'></iframe>

</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap" %>
<% request.setCharacterEncoding("UTF-8"); 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
	<head>
		<title> <fmt:message key="eMR.viewdeathregister.label" bundle="${mr_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/dchk.js' ></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%


String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String locn_code				=	checkForNull(request.getParameter("Locn_Code"));
String gender	 					=	checkForNull(request.getParameter("Sex"));
String dob							=	checkForNull(	request.getParameter("Dob"));
String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
String episode_id				=	checkForNull(request.getParameter("episode_id"));
String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
String practitioner_type	=	checkForNull(request.getParameter("practitioner_type"));
String patient_class			=	checkForNull(request.getParameter("patient_class"));
String call_from					=	checkForNull(request.getParameter("call_from"));
String episode_type			=	checkForNull(request.getParameter("episode_type"));
String mode						=	checkForNull(request.getParameter("mode"));
String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));
String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));
String CA = checkForNull(request.getParameter("CA"));
if (CA.equals("")) CA="N";

%>
</html>
		<%
		if (!CA.equals("Y"))	{
		%>
		<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>" frameborder="0" scrolling="NO" style="height: 9vh; width:90vh;"></iframe>

		<%}
		else {%>
		<iframe id ='DeathRegister_Sections_Frames' rows='*,4%'></iframe>
		<%}
		%>
				<iframe name='VDR_Result_Frame' id='VDR_Result_Frame' style="height: 70vh; width:90vh;" frameborder='0' scrolling='AUTO' src='../../eMR/jsp/ViewMDRResult.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&locn_code=<%=locn_code%>&gender=<%=gender%>&dob=<%=dob%>&speciality_code=<%=speciality_code%>&episode_id=<%=episode_id%> &practitioner_id=<%=practitioner_id%>&practitioner_type=<%=practitioner_type%>&patient_class=<%=patient_class%> &call_from=<%=call_from%>&episode_type=<%=episode_type%>&finalize_yn=<%=finalize_yn%>&visit_adm_date=<%=visit_adm_date%>'>
				</iframe>
				<%
				if (!CA.equals("Y"))	{
				%>
				<iframe name='DR_Button_Frame' id='DR_Button_Frame'  src='../../eMR/jsp/DPEquiSpprtDiagClose.jsp?' frameborder='0'  style="height: 6vh; width:80vh;" scrolling='NO'> </iframe>
				<%}
				%>
				<iframe name='DR_Message_Frame' id='DR_Message_Frame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='NO' style='height:5vh;width:90vw'></iframe>
		

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


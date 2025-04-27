<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<!-- Last Visit & Last Visit WithIn 24 Hrs. Added on 12/05/2004 -->
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
	  <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	//String l_encounter_id 		= checkForNull(request.getParameter("encounter_id")); i remove this varriable here and frame. Wednesday, May 05, 2010 venkat s PE_EXE
	String lastVisit24HrFlag    = checkForNull(request.getParameter("lastVisit24HrFlag"));
	String clinic_code          = checkForNull(request.getParameter("clinic_code"));
	String patient_id           = checkForNull(request.getParameter("patient_id"));
	String func_source          = checkForNull(request.getParameter("func_source"));

	/*Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652*/
	String curr_encounter_id    = checkForNull(request.getParameter("curr_encounter_id"));
	String calledFrom		    = checkForNull(request.getParameter("calledFrom"));

    if (lastVisit24HrFlag.equals("Y"))
	{%>
	<title><fmt:message key="eAE.LastVisitWithin24Hrs.label" bundle="${ae_labels}"/></title>
	<%}%>
</head>
	<iframe name='lastVisit' id='lastVisit' src='../../eAE/jsp/AERegisterAttnLastVisit.jsp?curr_encounter_id=<%=curr_encounter_id%>&calledFrom=<%=calledFrom%>&lastVisit24HrFlag=<%=lastVisit24HrFlag%>&clinic_code=<%=clinic_code%>&patient_id=<%=patient_id%>&func_source=<%=func_source%>' frameborder=no scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
	
	<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
</html>



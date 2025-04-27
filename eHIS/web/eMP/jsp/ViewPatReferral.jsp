<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<title><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></title>
</head>
<%
	String referralid = request.getParameter("referral_id");
	String orderCatalogCode = request.getParameter("ordercatlogcode");
	String FacilityId = request.getParameter("facilityId");//added for Bru-HIMS-CRF-380

	/*Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1 Start*/
	String called_from		= checkForNull(request.getParameter("called_from"));
	String RepDb			= checkForNull(request.getParameter("RepDb"));
	String clob_data		= checkForNull(request.getParameter("clob_data"));
	String cdrPatientId		= checkForNull(request.getParameter("patientId"));
	/*End*/

%>


	<iframe name='Constant' id='Constant' tabindex=-1	 src='../../eMP/jsp/ViewPatReferralNew.jsp?referral_id=<%=referralid%>&orderCatalogCode=<%=orderCatalogCode%>&RepDb=<%=RepDb%>&cdrPatientId=<%=cdrPatientId%>&clob_data=<%=clob_data%>&called_from=<%=called_from%>&frame_name=first&facility_id=<%=FacilityId%>'  frameborder=0 scrolling='auto'style='height:100vh;width:100vw' ></iframe><!--Modified by Thamizh selvi on 29th June 2018 against ML-MMOH-CRF-0115.1-->
<!-- 	<frame name='Tabs' id='Tabs' tabindex=-1			src='../../eMP/jsp/ViewPatReferralNew.jsp?referral_id=<%=referralid%>&orderCatalogCode=<%=orderCatalogCode%>&frame_name=second'  frameborder=0 scrolling='no' noresize> -->

</html>
<%!
public static String checkForNull(String inputString)
{
	return((inputString == null || inputString.equals("null")) ? "" : inputString);
}	
%>


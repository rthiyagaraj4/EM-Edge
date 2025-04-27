<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:29 AM -->

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

	String refrlAappt	= "";
	String IPinstall_yn	= "";
	String OPinstall_yn	= "";
	String OAinstall_yn	= "";
	String RDinstall_yn	= "";
	String title	= "";
	request.setCharacterEncoding("UTF-8");
	refrlAappt	= request.getParameter("refrlAappt")==null?"":request.getParameter("refrlAappt");
	IPinstall_yn = request.getParameter("IPinstall_yn");
	OPinstall_yn = request.getParameter("OPinstall_yn");
	OAinstall_yn = request.getParameter("OAinstall_yn");
	RDinstall_yn = request.getParameter("RDinstall_yn");
	
	if(refrlAappt == null) refrlAappt = "";
	if(IPinstall_yn == null) IPinstall_yn = "N";
	if(OPinstall_yn == null) OPinstall_yn = "N";
	if(OAinstall_yn == null) OAinstall_yn = "N";
	if(RDinstall_yn == null) RDinstall_yn = "N";

	if(refrlAappt.equals("A")) {
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AppointmentDetails.label","common_labels");
	} else if(refrlAappt.equals("R")) {
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RdAppts.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.details.label","common_labels");
	} else if(refrlAappt.equals("L")) {
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels");	
	} else if(refrlAappt.equals("I")) {
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IpBooking.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.details.label","common_labels");																	
	}
	%>
	<html>
    <head>
	<!-- <title><fmt:message key="eMP.apptreferraldtls.label" bundle="${mp_labels}"/></title> -->
	<title><%=title%></title>
       <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	   <Script language='javascript' src='../../eMP/js/PopulateApptReferralComp.js'></Script>
	</head>
	<iframe name="popAppRefCriteriaFrame" id="popAppRefCriteriaFrame" src="../../eMP/jsp/PopulateApptReferralCompCriteria.jsp?refrlAappt=<%=refrlAappt%>&IPinstall_yn=<%=IPinstall_yn%>&OPinstall_yn=<%=OPinstall_yn%>&OAinstall_yn=<%=OAinstall_yn%>&RDinstall_yn=<%=RDinstall_yn%>"  scrolling='no' noresize style='height:42vh;width:100vw'></iframe>
		<iframe name="popAppRefResultFrame" id="popAppRefResultFrame" src="../../eCommon/html/blank.html" scrolling='no' noresize style='height:54vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
	
<html>
		
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>


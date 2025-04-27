<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");
String patientId	= checkForNull(request.getParameter("patientId"));
String encounterId	= checkForNull(request.getParameter("encounterId"));
String LastDet		= checkForNull(request.getParameter("LastDet"));
String tit			= checkForNull(request.getParameter ("call_function"));
String function_id	= checkForNull(request.getParameter ("call_function"));
if(tit.equals("AdminHist"))
	tit = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AdmissionHistory.label","ip_labels");
else
	tit = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PreviousIPStay.label","ip_labels");
%>
<html>
<head>
	<title><%=tit%></title>
</head>

<iframe name='query' id='query' 	src='../jsp/LastAdmissionQuery.jsp?function_id=<%=function_id%>&LastDet=<%=LastDet%>&patientId=<%=patientId%>&encounterId=<%=encounterId%>' frameborder=0 style='height:12vh;width:95vw'></iframe><iframe name='result' id='result'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:75vh;width:95vw'></iframe><iframe name='close' id='close'	src='../jsp/LastAdmissionButton.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:95vw'></iframe>

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
%>


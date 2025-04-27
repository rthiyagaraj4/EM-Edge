<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
<title>Administer Interfaced records ----BLADMINT</title>

</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//BLBillGenInterfaceSearchResult.jsp
		String patientId=request.getParameter("patient_id");
		String episodeId=request.getParameter("episode_id");
		String visitId=request.getParameter("visit_id");
		String episodeType=request.getParameter("episode_type");
		String futureYn = request.getParameter("futureYN");
		System.out.println("episodeType  in main frame "+episodeType);
	

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<iframe name='search_frame' 	id='search_frame' src='BLBillGenInterface.jsp?&patient_id=<%=patientId%>&episode_id=<%=episodeId %>&visit_id=<%=visitId %>&episode_type=<%=episodeType %>&futureYN=<%=futureYn %>' frameborder=0  style="height:20vh;width:100vw"></iframe>
		<iframe name='result_frame'  id='result_frame'	src='../../eCommon/html/blank.html' frameborder=0  style="height:50vh;width:100vw"></iframe>
		<iframe name="dummy_frame" id="dummy_frame"  src='../../eCommon/html/blank.html'	 frameborder=0 noresize style="height:3vh;width:100vw"></iframe>
		<iframe name='bottom_frame' id='bottom_frame'	 src='BLBillGenInterfaceBottomFrame.jsp' frameborder=0 noresize  style="height:5vh;width:100vw"></iframe>
</HTML>



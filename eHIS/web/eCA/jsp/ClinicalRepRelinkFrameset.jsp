<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<!-- <frameset rows='45%,*,0%' id='frameID'> -->
	<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request); //MOHE-SCF-0153
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String hist_rec_type=request.getParameter("hist_rec_type");
	String contr_system =request.getParameter("contr_system");
//	String event_code =request.getParameter("event_code");

	%>
	<iframe name='sectionsFrame' id='sectionsFrame' src="" frameborder=0 noresize style='height:45vh;width:100vw'></iframe>
	<iframe name='addSectionsFrame' id='addSectionsFrame' src="../../eCA/jsp/ClinicalRepConEventsSearch.jsp?hist_rec_type=<%=hist_rec_type%>&contr_system=<%=contr_system%>" frameborder=0 noresize style='height:55vh;width:100vw'></iframe>
	<iframe name='removeRecFrame' id='removeRecFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:100vw'></iframe>
	<!-- </frameset> -->
</html>


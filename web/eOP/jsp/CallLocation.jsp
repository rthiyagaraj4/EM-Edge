<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
		<%
			request.setCharacterEncoding("UTF-8");
			String encounter=request.getParameter("p3");
			String PatientID=request.getParameter("p2");
			String facility=(String) session.getValue("facility_id");

			

		/*	out.print(request.getParameter("p1"));
			out.print(request.getParameter("p2"));
			out.print(request.getParameter("p3"));
			out.print(request.getParameter("p4"));
			out.print(request.getParameter("p5"));
			out.print(request.getParameter("p6"));
			out.print(request.getParameter("p7"));
			out.print(request.getParameter("p8"));
			out.print(request.getParameter("p9"));*/
		%>
	</HEAD>
	<title><fmt:message key="Common.currentlocation.label" bundle="${common_labels}"/></title>
	<iframe name='PLINE' id='PLINE' SRC='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling=no style='height:25vh;width:100vw'></iframe>
<iframe name='detail' id='detail' src='../../eOP/jsp/ConsLocation.jsp?Encounter_Id=<%=encounter%>&Patient_ID=<%=PatientID%>&facilityid=<%=facility%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:75vh;width:100vw'></iframe>
<iframe name='but' id='but'    src='../../eOP/jsp/ConsLocationbut.jsp'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10vh;width:100vw'></iframe>
</HTML>


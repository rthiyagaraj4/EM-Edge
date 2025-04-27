<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, java.net.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD><title><fmt:message key="ePH.DispenseNoLookup.label" bundle="${ph_labels}"/></title>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<%
    String patientid = request.getParameter("PatientId");
	String disp_locn=request.getParameter("disp_locn");
	String disp_locn_desc=request.getParameter("disp_locn_desc");
	String source = "../../ePH/jsp/ReissueMedDispLookup.jsp?PatientId="+patientid+"&disp_locn="+disp_locn+"&disp_locn_desc="+URLEncoder.encode(disp_locn_desc);
%>
<iframe name="Disp_Lookup_Frame" id="Disp_Lookup_Frame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC=<%=source%> style="height:23vh;width:100vw"></iframe><iframe name="Disp_Result_Frame" id="Disp_Result_Frame" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:77vh;width:100vw"></iframe>
</HTML>


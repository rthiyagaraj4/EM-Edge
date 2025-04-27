<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<HEAD>
<script src='../../eCA/js/ClinicalRepMast.js' language='javascript'></script>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String hist_rec_type=request.getParameter("hist_rec_type");
String contr_system =request.getParameter("contr_system");
//String ret_str=request.getParameter("ret_str");
String mode=request.getParameter("mode");

%>
<iframe name='sectionsFrame' id='sectionsFrame' src='../../eCA/jsp/ClinicalRepMastBatchEventSelected.jsp?hist_rec_type=<%=hist_rec_type%>&contr_system=<%=contr_system%>&mode=<%=mode%>' frameborder=0 noresize style='height:22vh;width:99vw'></iframe>
	<iframe name='addSectionsFrame' id='addSectionsFrame' src="../../eCA/jsp/ClinicalRepMastBatchEventSearch.jsp?hist_rec_type=<%=hist_rec_type%>&contr_system=<%=contr_system%>" frameborder=0 noresize style='height:65vh;width:99vw'></iframe>
	<iframe name='removeRecFrame' id='removeRecFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0vh;width:99vw'></iframe>

</html>


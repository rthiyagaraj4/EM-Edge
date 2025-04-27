<!--Created by Ashwini on 06-May-2024 for ML-MMOH-CRF-2125-->
<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String facilityId = request.getParameter("facilityId");
if(facilityId == null) facilityId="";

accessRightRecSet.clearAll();
%>

<html>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eAM/js/ServiceforSpeciality.js'></script>
</head>

<iframe name='f_query_add_mod_query' id='f_query_add_mod_query' src='../../eAM/jsp/ServiceforSpecialityAddModify.jsp?facilityId=<%=facilityId%>' frameborder=0 noresize scrolling='no' frameborder='0' style='height:25vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_res' id='f_query_add_mod_res' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' frameborder='0' style='height:72vh;width:100vw'></iframe>

</html>


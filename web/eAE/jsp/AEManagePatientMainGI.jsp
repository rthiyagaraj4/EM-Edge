<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String clinic_code=request.getParameter("clinic_code");
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 Start*/
String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar2nd 2014 End*/

System.err.println("request.getQueryString()-----??--------->"+request.getQueryString());
System.err.println("clinic_code===== ?????========="+clinic_code);
%> 
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	
	<iframe name='AEMPSearchCriteriaFrame' src='../../eAE/jsp/AEManagePatGICriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:13.5vh;width:100vw'></iframe> 
	<!--//Maheshwaran K added QueryString for ML-MMOH-CRF-1973 as on 21-07-2023-->
	<iframe name='tabs_frame' src='../../eAE/jsp/AEManagePatGITabs.jsp?five_level_triage_appl_yn=<%=five_level_triage_appl_yn%>&QueryString=<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='AEMPSearchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe>
	<iframe name='AEMPLegendFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw;display: none'></iframe>
</html> 


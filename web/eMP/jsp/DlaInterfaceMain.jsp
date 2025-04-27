<!DOCTYPE html>
<html>
<head>
<%@ page import ="eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<title><fmt:message key="eMP.Dlainterfacesearch.label" bundle="${mp_labels}"/></title>

<%
String disp = (String)request.getParameter("display") ;
String national_id = request.getParameter("nationalIdNo");

String function_id = request.getParameter("CalledFromFunction");
String patient_id = request.getParameter("patient_id");

if(function_id != null) 
{	
	session.setAttribute("dla_function_id",function_id);
}
String fucn_id_temp = (String)session.getAttribute("dla_function_id");
if(patient_id != null)
{
	session.setAttribute("dla_patient_id",patient_id);
}
if(fucn_id_temp != null && !fucn_id_temp.equalsIgnoreCase("ChangePatDtls"))
{
	session.removeAttribute("dla_patient_id");
}


if(national_id == null)national_id = "";
if(disp == null)
{
%>											 
<frameset rows="150,310,20">    
	<frame name="queue_frame" src="../../eMP/jsp/DlaSearch.jsp?nationalIdNo=<%=national_id%>" frameborder=0  scrolling="no" noResize>
	<frame name="action_frame" src="../../eCommon/html/blank.html" frameborder='' scrolling='auto' noResize>
	<frame name="message_frame" src="../../eCommon/html/blank.html" frameborder=0  scrolling="auto" noResize>
</frameset>
<%}
else
{
%>   										    
<frameset rows="310,20" border='0' >
<frameset id='dlaFrameSet' cols="75%,25%" border='0'>
	<!-- <frame name="action_frame" src="../../eCommon/html/blank.html" frameborder='' scrolling='no' noResize> 
	Commented and added the below code for SRR20056-SCF-5529 [IN:024247] by Suresh M on 09.12.2010-->
	<frame name="action_frame" src="../../eMP/jsp/DlauiInterfaceSearchResult.jsp?national_id=<%=request.getParameter("national_id")%>" frameborder='' scrolling='no' noResize>
	<frame name="image_frame" src="../../eMP/jsp/DlauiInterfaceSearchResultImage.jsp?national_id=<%=request.getParameter("national_id")%>&isFromOracleDB=<%=request.getParameter("isFromOracleDB")%>" frameborder='' scrolling='no' noResize>
</frameset>
<frame name="message_frame" src="../../eCommon/html/blank.html" frameborder='' scrolling='no' noResize>
</frameset>

<%}%>

</html>

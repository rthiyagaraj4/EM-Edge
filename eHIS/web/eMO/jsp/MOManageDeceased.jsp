<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script src='../../eMO/js/MOManageDeceased.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

<%
	String called_from_ca = request.getParameter("called_from_ca")==null?"N":request.getParameter("called_from_ca");
    String callfrommoreg = request.getParameter("callfrom")==null?"":request.getParameter("callfrom");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");


if(callfrommoreg.equals("callfrommoreg"))
{String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
 
	
	%>
   
 
   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:40vh;width:100vw'></iframe>
   <iframe name='patientFrame' id='patientFrame' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:30%;width:100vw'></iframe>
	
   <iframe name='patientLine' id='patientLine' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:7%;width:100vw'></iframe>
   <iframe name='encounterFrame' id='encounterFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:0%;width:100vw'></iframe>
   <iframe name='patientDetailsFrame' id='patientDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
   <iframe name='dummyframe' id='dummyframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>

<%}else if(called_from_ca.equals("N"))
{    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
 
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='AEMPSearchCriteriaFrame' id='AEMPSearchCriteriaFrame' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?<%=request.getQueryString()%>&callfrom=callfrommanage' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='MOFrame' id='MOFrame' src='../../eMO/jsp/MOManagePatTabs.jsp' frameborder=0 noresize scrolling='no' style='height:3vh;width:100vw'></iframe>
	<iframe name='AEMPSearchResultFrame' id='AEMPSearchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:55vh;width:100vw'></iframe>
	<iframe name='colorFrame' id='colorFrame' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:1vh;width:100vw'></iframe>
<%}else{
	
 %>
	<!-- - <iframeset rows='0,35%,3%,*,5%,0%' >-->
 	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
    <iframe name='AEMPSearchCriteriaFrame' id='AEMPSearchCriteriaFrame' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?<%=request.getQueryString()%>&callfrom=callfrommanage' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='MOFrame' id='MOFrame' src='../../eMO/jsp/MOManagePatTabs.jsp' frameborder=0 noresize scrolling='no' style='height:3vh;width:100vw'></iframe> 
	<iframe name='AEMPSearchResultFrame' id='AEMPSearchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:55vh;width:100vw'></iframe>
	<iframe name='colorFrame' id='colorFrame' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:1vh;width:100vw'></iframe>
<%}%>
<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>


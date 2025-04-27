<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	String  framesVisible	=	"";
	String  dynaicRows	=	"";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String qrystr = request.getQueryString();
	String displayFrames	=	request.getParameter("displayFrames");
	if(displayFrames.equals("NO")){
		framesVisible	=	"style='display:none'";
		dynaicRows	="*,5%";
		
	}else{
		framesVisible	=	"";
		dynaicRows		=	"35%,*,7%,0%";
	
     }

%>
<html> <%
if(displayFrames.equals("NO")){
	%>
<title><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.ComplaintDetails.label" bundle="${ca_labels}"/></title>
		<% }else { %>
<title><fmt:message key="Common.record.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.ChiefComplaint.label" bundle="${ca_labels}"/></title>

		<% } 
		%>
<head>
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%if(displayFrames.equals("YES")){%>
	<iframe name="RecPatChiefComplaintResultFrame" id="RecPatChiefComplaintResultFrame" src='../../eCA/jsp/RecPatChiefComplaintResult.jsp?<%=qrystr%>' frameborder=0 scrolling="auto" noresize style='height:16vh;width:98vw'></iframe>
	<iframe name="RecPatChiefComplaintAddModifyFrame" id="RecPatChiefComplaintAddModifyFrame" src='../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize <%=framesVisible%> style='height:65vh;width:98vw'></iframe>
	
	<iframe name="AEMessageFrame" id="AEMessageFrame" src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:98vw'></iframe>
	<iframe name="AESubmitFrame" id="AESubmitFrame" src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:98vw'></iframe>
	<%}else{%>
	<iframe name="AERecPatChiefComplaintResultFrame" id="AERecPatChiefComplaintResultFrame" src='../../eAE/jsp/AERecPatChiefComplaintResult.jsp?<%=qrystr%>' frameborder=0 noresize scrolling='no' style='height:70vh;width:98vw'></iframe>
	<iframe name="AEOKButtonFrame" id="AEOKButtonFrame" src='../../eAE/jsp/AEChiefComplaintDisplay.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:98vw'></iframe>
	<%}%>

</html>


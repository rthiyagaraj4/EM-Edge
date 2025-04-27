<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></title>
		<script src='../../eCA/js/STDCompReferralDetails.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String qryStr = request.getQueryString();
		//out.println("<script>alert('"+qryStr+"')</script>");
		%>
		<iframe name='radBtnsFrame' id='radBtnsFrame' src='../../eCA/jsp/STDCompReferralDetailsCriteria.jsp?<%=qryStr%>' frameborder='0' noresize scrolling='no' style='height:10%;width:100vw'></iframe>
			<iframe name='detailsFrame' id='detailsFrame' src='../../eCA/jsp/STDCompReferralDetails.jsp?<%=qryStr%>' frameborder='0' noresize scrolling='auto' style='height:100vh;width:100vw'></iframe>
			<iframe name='buttonsFrame' id='buttonsFrame' src='../../eCA/jsp/STDCompReferralDetailsTools.jsp?<%=qryStr%>' frameborder='0' noresize scrolling='no' style='height:11%;width:100vw'></iframe>
			<iframe name='intermediateFrame' id='intermediateFrame' src='../../eCA/jsp/blank.jsp' frameborder='0' noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
			<iframe name = 'messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder='0' noresize scrolling='no' style='height:10%;width:100vw'></iframe>
		
	</head>
</html>


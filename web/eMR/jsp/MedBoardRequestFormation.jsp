<!DOCTYPE html>
<%
/**
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: DEEPA S 
* @Created on	: 23 MARCH 2005
* @Function		: 
 ****************************************************************************************
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<title> <fmt:message key="eMR.FormationofMedicalBoard.label" bundle="${mr_labels}"/> </title>
<head>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String Qrystr = request.getQueryString();
	//out.println("<script>alert(\""+Qrystr+"\");</script>");
%>
	<iframe name='MedBoardRequestFrameDetails' id='MedBoardRequestFrameDetails'  framespacing=0 border=0 src='../../eMR/jsp/MedBoardRequestFrames.jsp?<%=Qrystr%>' frameborder='no' scrolling='no' noresize  style='height:26vh;width:99vw'></iframe>
	<iframe name='MedBoardRequestFormationMain' id='MedBoardRequestFormationMain' framespacing=0 border=0 src='../../eMR/jsp/MedBoardRequestFormationMain.jsp?<%=Qrystr%>' frameborder='no' scrolling='no' noresize  style='height:26vh;width:99vw'></iframe>
	<iframe name='MedBoardRequestFormationResult' id='MedBoardRequestFormationResult' framespacing=0 border=0 src='../../eMR/jsp/MedBoardRequestFormationResult.jsp?<%=Qrystr%>' frameborder='no' scrolling='auto' noresize  style='height:30vh;width:99vw'></iframe>
	<iframe name='MedBoardRequestButtons' id='MedBoardRequestButtons' framespacing=0 border=0 src='../../eMR/jsp/MedBoardRequestButtons.jsp?<%=Qrystr%>' frameborder='no' scrolling='no' noresize  style='height:4vh;width:99vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='no' noresize border=0 scrolling='auto' style='height:8vh;width:99vw'></iframe>
</html>


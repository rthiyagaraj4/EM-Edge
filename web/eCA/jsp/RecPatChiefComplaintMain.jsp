<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title>Record Chief Complaint</title>
<head>
<script src='../../eCA/js/RecPatChiefComplaint.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String qrystr = request.getQueryString();
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");//CHL-CRF [IN035950]
%>
</head>
<!-- //CHL-CRF Start.[IN035950]-->
<% if(!"".equals(p_called_from_widget)){%> 
<!--  <frameset rows='33%,*,0%,8%' -->
	<iframe name="RecPatChiefComplaintResultFrame" src='../../eCA/jsp/RecPatChiefComplaintResult.jsp?<%=qrystr%>' frameborder=0 scrolling="auto" noresize style="height:40vhvh;width:100vw"></iframe>
	<iframe name="RecPatChiefComplaintAddModifyFrame" src='../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style="height:52vh;width:100vw"></iframe>
	<iframe name="RecPatChiefComplaintBlankFrame" src='../../eCommon/html/blank.html' frameborder=0 scrolling="no" noresize style="height:0vh;width:100vw"></iframe>
	<iframe name='messageFrame'	 id='messageFrame'	src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize style="height:8vh;width:100vw"></iframe>
<%}else{%>
<!--  <frameset rows='33%,*,0%' > --><!--rows='33%,*,7%' -->
	<iframe name="RecPatChiefComplaintResultFrame" src='../../eCA/jsp/RecPatChiefComplaintResult.jsp?<%=qrystr%>' frameborder=0 scrolling="auto" noresize style="height:40vh;width:100vw"></iframe>
	<iframe name="RecPatChiefComplaintAddModifyFrame" src='../../eCA/jsp/RecPatChiefComplaintAddModify.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style="height:60vh;width:100vw"></iframe>
	<iframe name="RecPatChiefComplaintBlankFrame" src='../../eCommon/html/blank.html' frameborder=0 scrolling="no" noresize style="height:0vh;width:100vw"></iframe>
<%}%>
<!--//CHL-CRF End.[IN035950]-->
	 
<!--	<frame name="RecPatChiefComplaintActionButtonFrame" src='../../eCA/jsp/RecPatChiefComplaintActionButton.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize> -->
<!-- //CHL-CRF Start.[IN035950]-->
<% //if(!"".equals(p_called_from_widget)){
%>
<!-- <frame name='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize></frame> -->	
<%//}
%>
<!--//CHL-CRF End.[IN035950]-->
</frameset>
<form name="CC_main" method="" action =""> 
<input type="hidden"  name="qrystr"     value="<%=qrystr%>" >
</form>
</html>

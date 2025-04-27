<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History   	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/04/2018	IN061884		Raja S			18/04/2018		Ramesh G		ML-MMOH-CRF-0536
16/10/2018 	IN068145		Raja S			16/10/2018   	Ramesh G		ML-MMOH-CRF-1212  
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<TITLE> Group Display </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String graphorder = request.getParameter("graphorder")==null?"D":request.getParameter("graphorder");
	String show_mode = request.getParameter("show_mode")==null?"D":request.getParameter("show_mode");//IN068145

%>
	<FRAMESET ROWS="*,7%" id='myFrameSetControls' FRAMEBORDER=NO >
	<%if(show_mode.equals("C")){%>
		<FRAME SRC="../../eCA/jsp/GroupDisplayDetails.jsp?<%=request.getQueryString()%>" name='DetailsFrame' FRAMESPACING=NO FRAMEBORDER=NO scrolling=yes>
	<%}else if(show_mode.equals("E")){%><!--IN068145-->
		<FRAME SRC="../../eCA/jsp/DisplayGroupExpanded.jsp?<%=request.getQueryString()%>" name='DetailsFrame' FRAMESPACING=NO FRAMEBORDER=NO scrolling=yes>
	<%}%>
		<FRAME SRC="../../eCA/jsp/GroupDisplayControl.jsp?<%=request.getQueryString()%>&graphorder=<%=graphorder%>" name='controlsFrame' FRAMESPACING=NO FRAMEBORDER=YES scrolling=no>  
	</FRAMESET>

</HTML>


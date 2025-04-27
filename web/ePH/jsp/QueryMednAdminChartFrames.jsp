<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<!--This file is saved on 28/10/2005-->
<html>                                
	<head>                                
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>                               
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String params = request.getQueryString() ;
		String called_from	=	request.getParameter("called_from");
		if(called_from==null) {
%>
			<iframe name="f_queryCriteria" id="f_queryCriteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QueryMednadminChartCriteria.jsp?<%=params%>" style="height:8vh;width:100vw"></iframe>
			<iframe name="f_orderframe" id="f_orderframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="auto" style="height:92vh;width:100vw"></iframe>
<%
		}
		else	{
%>
			<iframe name="f_queryCriteria" id="f_queryCriteria" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/QueryMednadminChartCriteria.jsp?<%=params%>" style="display:none"></iframe>
			<iframe name="f_orderframe" id="f_orderframe" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="no" style="height:100vh;width:98vw"></iframe>
<%	
	}
%>
</html>	


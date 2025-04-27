<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.Results.label" bundle="${ca_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<!--<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>-->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String framesize="";
	String modal_YN = request.getParameter("modal_YN")==null?"N":request.getParameter("modal_YN");
	
	if(modal_YN.equals("Y"))
	{
		framesize="27%,5%,*%,5%,5%,5%";
	}
	else
	{

		framesize ="27%,5%,*%,5%,5%";
	}
	
	%>
 	<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<frameset rows='<%=framesize%>'>
	<frame name='ReviewResultsSearch' id='ReviewResultsSearch' src='ViewResultSearchCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="no" noresize>
	<frame name='ReviewResultsHeader' id='ReviewResultsHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
	<frame name='ReviewResultsResult' id='ReviewResultsResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize>
	<frame name='ReviewResultsBtn' id='ReviewResultsBtn'	  src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
	<frame src="../../eCA/jsp/ViewResultsColorBar.jsp?<%=request.getQueryString()%>" name="button_f1" scrolling="no" frameborder="0" noresize>
	<%if(modal_YN.equals("Y"))
	{ %>
	<frame src="../../eCommon/jsp/MstCodeError.jsp" name="messageFrame" id="messageFrame" scrolling="no" frameborder="0" noresize>	
<%
	}

%>
</frameset>
</html>


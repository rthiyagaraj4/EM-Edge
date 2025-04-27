<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../js/SplChartRef.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String display = request.getParameter("display");
	String url = null;
	if(display.equals("yes"))
	 url = "../../eCA/jsp/SplChartRefDtlDisp.jsp?";
	else
	 url = "../../eCA/jsp/SplChartRefDtlList.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
%>

		<iframe name='frameSplChartRefDtlList' id='frameSplChartRefDtlList'   src='<%=source%>'  frameborder=0 noresize style='height:60vh;width:100vw'></iframe>
		<iframe name='frameSplChartRefDtlHdr' id='frameSplChartRefDtlHdr'	src='../../eCA/jsp/SplChartRefDtlHdr.jsp' frameborder=0 style='height:0%;width:100vw'></iframe>
		
</html>






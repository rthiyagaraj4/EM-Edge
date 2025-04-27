<!DOCTYPE html>
<%--Author  Archana Kumari Dhal Created on 4/3/2009 --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String dateRange =request.getParameter("dateRange")==null?"":request.getParameter("dateRange");
		String FromDesktop =request.getParameter("FromDesktop")==null?"":request.getParameter("FromDesktop");
		//out.println("FromDesktop"+FromDesktop);
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		if (!dateRange.equals("N")){			
			frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		}
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="javascript" src="../js/MedRecAdminAlert.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>
<%
	if(FromDesktop.equals("Y")) {%>
    <iframe name="MedRecAdminAlertCriteriaFrame" id="MedRecAdminAlertCriteriaFrame" src="../../eCA/jsp/MedRecAdminAlertCriteria.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling=no noresize style="height:68%;width:100vw"></iframe>
	<iframe name="MedRecAdminAlertResultMainFrame" id="MedRecAdminAlertResultMainFrame" src="../../eCommon/html/blank.html"  frameborder=0 scrolling=auto noresize style="height:100vh;width:100vw"></iframe>

	<%}else{%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 scrolling="no" noresize style='height:8vh;width:100vw'></iframe>
	<iframe name="MedRecAdminAlertCriteriaFrame" id="MedRecAdminAlertCriteriaFrame" src="../../eCA/jsp/MedRecAdminAlertCriteria.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling=no noresize style="height:68%;width:100vw"></iframe>
	<iframe name="MedRecAdminAlertResultMainFrame" id="MedRecAdminAlertResultMainFrame" src="../../eCommon/html/blank.html"  frameborder=0 scrolling=auto noresize style="height:100vh;width:100vw"></iframe>

<%}%>
</html>


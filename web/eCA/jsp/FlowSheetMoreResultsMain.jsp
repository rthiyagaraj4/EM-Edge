<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           									created
19/07/2019	  IN070933		Ramesh Goli		19/07/2019		Ramesh Goli		ML-MMOH-SCF-1325
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">



<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	//String query_string = request.getQueryString();
	String strEncId ="";
	String strPatientId = "";
//	String strEncounterId ="";
	String beanKeyEncId = "";
	strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	beanKeyEncId = strEncId;
	strPatientId		= request.getParameter("patientid")==null?"":request.getParameter("patientid");
	String title		= request.getParameter("title")==null?"":request.getParameter("title");
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+strPatientId+beanKeyEncId,"eCA.PatientBannerGroupLine",session);
	//out.println("<script>alert('query_string"+query_string+"')</script>");
%>

<html>
<title><%=title%></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<iframe src="../../eCA/jsp/FlowSheetMoreResults.jsp?<%=request.getQueryString()%>" name="FlowSheetMoreResultFrame"  scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:30vh;width:98vw"></iframe>
<iframe src='../../eCommon/html/blank.html' name='FlowSheetTextFrame' id='FlowSheetTextFrame' scrolling="auto" frameborder="0" marginheight=0 marginwidth=0 style="height:60vh;width:98vw"></iframe>
	<iframe src="../../eCA/jsp/FlowSheetTextToolbar.jsp" name="FlowsheetToolbarFrame" id="FlowsheetToolbarFrame"  frameborder="0" marginheight=0 marginwidth=0 style="height:0vh;width:98vw"></iframe>	 
	<iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="yes" frameborder="0" noresize style="height:10vh;width:98vw"></iframe>   <!-- IN070933 -->

</html>


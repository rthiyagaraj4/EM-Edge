<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	eCA.PatientBannerGroupLine usrPrvlgBean = null;
	usrPrvlgBean = (eCA.PatientBannerGroupLine)getObjectFromBean("usrPrvlgBean","eCA.PatientBannerGroupLine",session);
	usrPrvlgBean.clearBean();
%>

<html>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/UserPrvlgToPrintAndEMail.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<!-- Modified by kishore kumar N on 08/12/2008 for the CRF 0387
	altered frameset row size (usrPrvlgPrintEmailDetailsFrame) 
-->
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='usrPrvlgPrintEmailDetailsFrame' id='usrPrvlgPrintEmailDetailsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
	<iframe name='usrPrvlgPrintEmailPractFrame' id='usrPrvlgPrintEmailPractFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:65vh;width:100vw'></iframe>
	<iframe name='usrPrvlgPrintEmailIntermedFrame' id='usrPrvlgPrintEmailIntermedFrame' src='../../eCA/jsp/UserPrvlgToPrintAndEMailInter.jsp' frameborder=0 scrolling='auto' noresize style='height:6vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
</html>


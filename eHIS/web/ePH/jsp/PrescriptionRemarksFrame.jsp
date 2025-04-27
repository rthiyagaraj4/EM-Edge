<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<!-- 
Developed by	: P.Sudhakaran.
Module/Function : RefillDetailsFrame
-->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");;
	String params = request.getQueryString(); 
	String title = "";
%>

<html>
<head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
	if((called_from!=null) && (called_from.equals("PRNamend")||called_from.equals("PRN"))){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PRNRemarks.label", "ph_labels");
%>
<%
}else{
	title = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.ClinicalComments.label", "common_labels");
}
%>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<title><%=title%></title>
	
</head>
<!--<frameset rows="*,10%" >-->
<%
	if((called_from!=null) && (called_from.equals("PRNamend")||called_from.equals("PRN"))){
%>
	<iframe name="remarks_detail" id="remarks_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionPRNRemarks.jsp?<%=params%>" style="height:90vh;width:100vw"></iframe>
	<iframe name="remarks_close" id="remarks_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=<%=called_from%>" style="height:90vh;width:100vw"></iframe>
<%
	}
	else{
%>
	<iframe name="remarks_detail" id="remarks_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/PrescriptionRemarks.jsp?<%=params%>&called_from='ClinicalComments'" style="height:85vh;width:98vw"></iframe>
	<iframe name="remarks_close" id="remarks_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionClose.jsp?called_from=remarks" style="height:10vh;width:98vw" ></iframe>
<%
	}
%>
	<!--</frameset>-->

</html>



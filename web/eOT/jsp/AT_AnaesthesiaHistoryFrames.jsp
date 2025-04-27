<!DOCTYPE html>

<%@page  contentType="text/html;charset=UTF-8" import ="eCommon.Common.CommonBean"  %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<% request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>



<html>

<%	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	String patient_name = CommonBean.checkForNull(request.getParameter("patient_name"));
	String oper_desc = CommonBean.checkForNull(request.getParameter("oper_desc"));
	patient_name=java.net.URLDecoder.decode(patient_name,"UTF-8");

%>
 <%

String AnaesthesiaHistory =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaHistory.Label","OT");
%>



<head>
<!--<title><%=AnaesthesiaHistory%>-<%=patient_id+","+patient_name+"@@@Procedure: "+oper_desc+"@@@"%></title>-->
<title><%=AnaesthesiaHistory%></title>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	//String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString();
	String url = "../../eOT/jsp/AT_AnaesthesiaHdr.jsp?function_name=Anesthesia History";
	
%>

<iframe name="CommonToolbarFrame" id="CommonToolbarFrame"  scrolling="no" noresize src="<%=url%>" frameborder='0' style='height:5vh;width:100vw;border=0'></iframe>
	<iframe name='OtPatientLineFrame' id='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>"  scrolling="no" noresize frameborder='0' style='height:17vh;width:100vw;border=0'></iframe>
	<iframe name='AneasthesiaDetailFrame' id='AneasthesiaDetailFrame' SRC='../../eOT/jsp/AT_AnaesthesiaHistorySummary.jsp?<%=params%>'  scrolling='no' noresize frameborder='0' style='height:70vh;width:100vw;border=0'></iframe>
	<iframe name="MessageFrame" id="MessageFrame" src="../../eCommon/jsp/error.jsp"  noresize scrolling="auto" frameborder='0' style="height:7vh;width:100vw;border=0"></iframe>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AnaesthesiaHistoryFrames" id="AnaesthesiaHistoryFrames">
	<input type='hidden' name='params' id='params' value='<%=params%>' >
</form>
</body>
</html>


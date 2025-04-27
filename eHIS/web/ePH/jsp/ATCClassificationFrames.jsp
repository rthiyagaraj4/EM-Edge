<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<script language="JavaScript" src="../../ePH/js/ATCClassification.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
 	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<title><fmt:message key="Common.ATCClassification.label" bundle="${common_labels}"/></title>

<% 
String	calling_func	= request.getParameter("called_from");
%>

	<iframe name='f_level1' id='f_level1' src="../../ePH/jsp/ATCHeader.jsp?level_num=1&called_from=<%=calling_func%>" frameborder='1' scrolling='no' noresize style='height:3vh; width:32vw'></iframe>
	<iframe name='f_level2' id='f_level2' src="../../ePH/jsp/ATCHeader.jsp?level_num=2&called_from=<%=calling_func%>" frameborder='1' scrolling='no' noresize style='height:3vh; width:32vw'></iframe>
	<iframe name='f_level3' id='f_level3' src="../../ePH/jsp/ATCHeader.jsp?level_num=3&called_from=<%=calling_func%>" frameborder='0' scrolling='no' noresize style='height:3vh; width:32vw'></iframe>
	

	<iframe name='f_level1_detail' id='f_level1_detail' src="../../ePH/jsp/ATCLevelDetail.jsp?mode=<%=CommonRepository.getCommonKeyValue("MODE_INSERT")%>&level_num=1&called_from=<%=calling_func%>" frameborder=0 scrolling='yes' noresize  style='height:33vh; width:32vw; border-style: solid; border-color:white;border-width:2'></iframe>
	<iframe name='f_level2_detail' id='f_level2_detail' src="" frameborder=0 scrolling='yes' noresize  style='height:33vh; width:32vw;border-style: solid; border-color: white;border-width:2'></iframe>
	<iframe name='f_level3_detail' id='f_level3_detail' src="" frameborder=0 scrolling='yes' noresize  style='height:33vh; width:32vw; border-style: solid; border-color: white;border-width:2'></iframe>

	<iframe name='f_level4' id='f_level4' src="../../ePH/jsp/ATCHeader.jsp?level_num=4&called_from=<%=calling_func%>" frameborder='1' scrolling='no'    noresize style='height:3vh; width:32vw'></iframe>
	<iframe name='f_level5' id='f_level5' src="../../ePH/jsp/ATCHeader.jsp?level_num=5&called_from=<%=calling_func%>" frameborder='1' scrolling='no'    noresize style='height:3vh; width:32vw'></iframe>
	<iframe name='f_viewlevel' id='f_viewlevel' src="../../ePH/jsp/ATCHeader.jsp?level_num=6&called_from=<%=calling_func%>" frameborder=0 scrolling='no'noresize style='height:3vh; width:32vw'></iframe>
	

	<iframe name='f_level4_detail' id='f_level4_detail' src="" frameborder=0 scrolling='yes' noresize  style='height:52vh; width:32vw; border-style: solid; border-color: white;border-width:2'></iframe>
	<iframe name='f_level5_detail' id='f_level5_detail' src="" frameborder=0 scrolling='yes' noresize  style='height:52vh; width:32vw; border-style: solid; border-color: white;border-width:2'></iframe>
	<iframe name='f_view_levels' id='f_view_levels' src="../../ePH/jsp/ATCViewLevelFrames.jsp?called_from=<%=calling_func%>" frameborder=0 scrolling='no' noresize  style='height:52vh; width:32vw; border-style: solid; border-color:white;border-width:2'></iframe>

</html>


<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String sec_hdg_desc = request.getParameter("sec_hdg_desc")==null?"":request.getParameter("sec_hdg_desc");
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCA/js/Section.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!--<title><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></title> -->
		<title><fmt:message key="eCA.Define.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<%=sec_hdg_desc%> </title>
	</head>
		<frameset rows="69%,23%,8%" id='MultiOrdSel' name='MultiOrdSel' frameborder='no' noresize>
				<frame name='MultiOrdSelDetails' id='MultiOrdSelDetails'		src='../../eCA/jsp/SectionMultiResCatResult.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto'  noresize></frame>
				<!-- Commented by Jyothi on 09/03/2010 to fix 19822 -->
				<!-- <frame name="MultiOrdSelAdd" id="MultiOrdSelAdd" noresize src="../../eCa/jsp/SectionMultiResCatAddModify.jsp?<%=request.getQueryString()%>" ></frame> -->
				<frame name="MultiOrdSelAdd" id="MultiOrdSelAdd" noresize src="../../eCA/jsp/SectionMultiResCatAddModify.jsp?<%=request.getQueryString()%>" ></frame>

				<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize></frame>
					
		</frameset> 

</html>


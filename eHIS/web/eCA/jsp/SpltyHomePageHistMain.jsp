<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="Bean" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="AllergyTypeBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html>
<head>
<script language='javascript' src='../../eCA/js/SpltyHomePageLinkMed.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<title><fmt:message key="eCA.LinkResultDocuments.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>

<%

  String result_linked_rec_type="";

  result_linked_rec_type=	(request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type"));

			//if(result_linked_rec_type.equals("LBIN")||result_linked_rec_type.equals("LBRP")||result_linked_rec_type.equals("PTCR")||result_linked_rec_type.equals("RDIN")||result_linked_rec_type.equals("RDRP")||result_linked_rec_type.equals("SUNT")||result_linked_rec_type.equals("TRET")||result_linked_rec_type.equals("FDOC")||result_linked_rec_type.equals("RXIN") ||result_linked_rec_type.equals("BLTF"))

	%>
		<frameset name="notes" rows = '23%,*,3%' id='notes' frameborder=0 >
		<frame name="RecClinicalNotesLinkHistRepCriteriaFramenew" frameborder="0" scrolling="no" noresize src = "../../eCA/jsp/SpltyHomePageHistRepCriteria.jsp?<%=request.getQueryString()%>"></frame> 
		<frameset name="notes1" rows='53%,8%,30%,9%' onunLoad="">
		<frame name="RecClinicalNotesLinkHistRepResultFramenew" src="../../eCommon/html/blank.html" frameborder=1></frame>
		<frame name="RecClinicalNotesLinkHistRepShowButtonsFramenew" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/SpltyHomePageHistRepShowButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame>
		<frame name="RecClinicalNotesLinkHistSelectedTextFramenew" frameborder="1" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		<frame name="RecClinicalNotesLinkHistRepSelectButtonsFramenew" frameborder="1" scrolling="no" noresize src = "../../eCA/jsp/SpltyHomePageHistRepSelectButtons.jsp?<%=request.getQueryString()%>" scrolling="no"></frame> 
		</frameset>
		<frame name="messageFrameReference" frameborder="0" scrolling="auto" noresize src = "../../eCommon/html/blank.html"></frame>
		</frameset> 

</html>












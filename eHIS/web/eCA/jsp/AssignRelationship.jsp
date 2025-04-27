<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<title><fmt:message key="eCA.AssignRelationship.label" bundle="${ca_labels}"/></title>
</head>
<%
		 
		String modal_yn = "", reln_req_yn="";
		String firstFrameSrc  = "";
		String secondFrameSrc = "";
		String fromOpenChart_yn = "";
		modal_yn	=	request.getParameter("modal_yn");
		reln_req_yn	=	request.getParameter("reln_req_yn");
		fromOpenChart_yn	=	request.getParameter("fromOpenChart_yn");
		if (fromOpenChart_yn==null) fromOpenChart_yn="N";

		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String visit_id = request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String height1="";
		String height2="";
		String height3="";
		String height4="";
		
		//out.println("<script>alert('" + request.getQueryString() + "');</script>");
		//out.println("<script>alert('" + modal_yn + "');</script>");

		if(modal_yn==null) modal_yn = "N";
		if(reln_req_yn==null) reln_req_yn = "N";

		if(reln_req_yn.equals("Y"))
		{
			firstFrameSrc  = "../../eCA/jsp/AssignRelationshipView.jsp?";
			secondFrameSrc = "../../eCA/jsp/AssignRelationshipMain.jsp?";
		}
		else
		{
			out.println("<script>alert(getMessage('CA_ENC_RELN_NO','CA'));</script>");
			firstFrameSrc  = "../../eCommon/html/blank.html?";
			secondFrameSrc = "../../eCommon/html/blank.html?";
		}

		if(modal_yn.equals("Y"))
		{
			height1 = "10vh";
			height2 = "30vh";
			height3 = "48vh";
			height4 = "10vh";
	%>
		<!-- <frameset rows='10%,30%,*,10%' framespacing='0' > -->

	<%
		}
		else
		{
			height2 = "40vh";
			height3 = "48vh";
	%>
		<!-- <frameset rows='40%,*' framespacing='0' > -->

	<%
		}
		if(modal_yn.equals("Y"))
		{
	%>

	<iframe name='plineFrame' id='plineFrame' style='height:<%=height1%>;width:100vw' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Patient_ID=<%=patient_id%>&visit_id=<%=visit_id%>' scrolling='no' frameborder="no"></iframe>
	<%
		}
	%>
	<iframe name="AssignRelationshipViewFrame" id="AssignRelationshipViewFrame" style='height:<%=height2%>;width:100vw' frameborder="no" scrolling="auto" noresize src="<%=firstFrameSrc%><%=request.getQueryString()%>"></iframe>
	<iframe name="AssignRelationshipFrame" id="AssignRelationshipFrame"  style='height:<%=height3%>;width:100vw' frameborder="no" scrolling="auto" noresize src="<%=secondFrameSrc%><%=request.getQueryString()%>"></iframe>
	<%
		if(modal_yn.equals("Y"))
		{
	%>
		<iframe name="messageFrame" id="messageFrame" frameborder="no" style='height:<%=height4%>;width:100vw' scrolling="no" noresize src="../../eCommon/jsp/error.jsp"></iframe> 
	<%
		}
	%>
	<!-- <frame name="PatientSearchDetailsFrame" frameborder="no" scrolling="no" noresize src="../../eCA/jsp/PatientSearchDetails.jsp?<%=request.getQueryString()%>"></frame> -->
<!--</frameset>  -->
</html>

<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<head>
    <Title>Consults</Title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultReporting" ;
	String bean_name = "eOR.ResultReportingBean";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");

	//db- String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	String practitioner_type = (String)session.getValue("practitioner_type");
	//String patient_id = request.getParameter("patient_id");
	String encounter_id =	request.getParameter("episode_id");
	if(encounter_id==null || encounter_id.trim().equals(""))
		encounter_id =	request.getParameter("encounter_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id== null)practitioner_id = "";
	if(practitioner_type== null)practitioner_type = "";
	String  isValid = "";

	String CanelFlag = request.getParameter("CanelFlag");
	if (CanelFlag == null) CanelFlag = "";

	String option_id = request.getParameter("option_id");
	if (option_id == null) option_id = "";

	String expand_title_yn =	request.getParameter("TITLE_FRAME_EXPAND")==null?"N":request.getParameter("TITLE_FRAME_EXPAND");

	//if(!practitioner_type.equals("NS"))
	//{
//		ResultReportingBean bean = (ResultReportingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		 ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name, request ) ;

		isValid = bean.isAuthorised(practitioner_id,resp_id) ;
	//}

	if(isValid != null)
	{
%>
<%--<Script>alert('patient_id=<%=patient_id%>,encounter_id=<%=encounter_id%>,option_id=<%=option_id%>')</Script>--%>
<%--<script>alert('<%=request.getQueryString()%>')</script>--%>
<frameset rows='40%,4%,*' <%if(expand_title_yn.equals("Y")){%> onLoad = "changeMainSizeNursingActivity()"<%}%> >
	<%--<frame name='ResultReportingSearch' id='ResultReportingSearch' src='ResultReportingSearch.jsp?patient_id=<%=patient_id %>&encounter_id=<%=encounter_id%>&option_id=<%=option_id%>&CanelFlag=<%=CanelFlag%>' frameborder=0 scrolling=no noresize>--%>
	<frame name='ResultReportingSearch' id='ResultReportingSearch' src='ResultReportingSearch.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no noresize>
	<frame name='ResultReportingHeader' id='ResultReportingHeader' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
	<frame name='ResultReportingResult' id='ResultReportingResult' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto>
	<!-->
	<frame name='ResultReportingBtn' id='ResultReportingBtn'	  src='../../eCommon/html/blank.html' frameborder=0>
	-->
</frameset>
	<%}else{
	out.println("<script>alert(getOrMessage(\"PRACT_RESP_NO_ACCESS\")); </script>");
		}%>
</html>

<%
 	//putObjectInBean(bean_id,bean,request);
%>


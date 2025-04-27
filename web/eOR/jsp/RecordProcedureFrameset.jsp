<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
	<title><fmt:message key="eOR.RecordProcedure.label" bundle="${or_labels}"/></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ResultReporting.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>function_id = "<%=request.getParameter("function_id")%>";</script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_id = request.getParameter("orderId");
	order_id	= (order_id == null) ? "" : order_id.trim();

	String from = request.getParameter("from");
	from	= (from == null)?"":from.trim();
	String qryString = request.getQueryString();
	if (qryString.indexOf("&from=") != -1)
		qryString = qryString.substring(0,qryString.indexOf("&from="));
	String pat_id	= request.getParameter("patient_id");

	if (from.equals("")) {
%>
<%--<Script>alert('1<%=from%>')</Script>--%>
<frameset rows='*'>
	<frame name='content' id='content' src='RecordProcedureFrameset.jsp?<%=qryString%>&from=content' frameborder=0 scrolling=no noresize>
</frameset rows="*">
<%} else if (from.equals("content")) {%>
<%--<Script>alert('2<%=from%>')</Script>--%>
<frameset rows="*,10%">
	<frame name='workAreaFrame' id='workAreaFrame' src='RecordProcedureFrameset.jsp?<%=qryString%>&from=workAreaFrame' frameborder=0 scrolling=no noresize>
	<frame name='messageframe' id='messageframe' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling=no noresize>
</frameset>
<%} else if (from.equals("workAreaFrame")) {
	/* Mandatory checks start */
		String mode	   				= "1";//request.getParameter( "mode" ) ;
		String function_id 			= request.getParameter( "function_id" ) ;

		String bean_id = "Or_RecordProcedure";//request.getParameter("bean_id");
		String bean_name = "eOR.RecordProcedureBean";//request.getParameter("bean_name");

	/* Mandatory checks end */

	/* Initialize Function specific start */

		RecordProcedureBean bean = (RecordProcedureBean)getBeanObject( bean_id,  bean_name, request ) ;
		bean.setFunctionId(bean.checkForNull(function_id));
		bean.clear() ;
		bean.setMode( mode ) ;

		int count = bean.orderableCount(order_id);

	/* Initialize Function specific end */

%>
<%--<Script>alert('3<%=from%>,<%=count%>')</Script>--%>
<%if (count == 1) {%>
<frameset cols="*" frameborder=0 scrolling=no noresize>
	<frame name='frame2' id='frame2' src='../../eCA/jsp/AddModifyOPProc.jsp?<%=qryString%>&from=frame2&mode=OR&pat_id=<%=pat_id%>' frameborder=0 scrolling=no noresize> <%-- &mode=update&code=8191&srl_no=1 --%>
</frameset>
<%} else if (count > 1) {%>
<frameset cols="<%="10%,*"%>" frameborder=0 scrolling=no noresize>
	<frame name='frame1' id='frame1' src='../../eOR/jsp/RecordProcedureLeft.jsp?<%=qryString%>'  frameborder=0 scrolling=no noresize>
	<frame name='frame2' id='frame2' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize>
</frameset>

<%}
	putObjectInBean(bean_id,bean,request);
}%>
</html>


<!DOCTYPE html>

<%@ page   import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*"contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
	<title><fmt:message key="eSS.DiscrepancyDetails.label" bundle="${ss_labels}"/></title>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SSAcknowledgment.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
		String params = request.getQueryString() ;

%>
<iframe name="frameAckDiscrepancyDetail" id="frameAckDiscrepancyDetail" src="../../eSS/jsp/AcknowledgmentDiscrepancyDetail.jsp?<%=params%>" frameborder=0 scrolling='no'   noresize></iframe>
		<iframe name="frameAckDiscrepancyList" id="frameAckDiscrepancyList" src="../../eSS/jsp/AcknowledgmentDiscrepancyList.jsp?<%=params%>" frameborder=0 scrolling='auto' noresize></iframe>

</html>


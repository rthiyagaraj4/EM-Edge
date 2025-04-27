<!DOCTYPE html>
<!-- OrderableFrameSet.jsp -->
<%@page contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="Common.Order.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Selection.label" bundle="${common_labels}"/></title>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%String appt_ref_no= (request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
String appt_order= (request.getParameter("appt_order")==null||request.getParameter("appt_order").equals("null"))?"":request.getParameter("appt_order"); %>
<iframe src="AppointmentOrderSearch.jsp?appt_ref_no=<%=appt_ref_no%>&appt_order=<%=appt_order%>" name="refusal_searchframe0"  scrolling='no' frameborder="0"  style='height:5vh;width:100vw'></iframe>,
<iframe src="AppointmentOrderSelect.jsp?appt_ref_no=<%=appt_ref_no%>&appt_order=<%=appt_order%>" name="refusal_resultframe1"    scrolling='no' frameborder="0"  style='height:95vh;width:100vw'></iframe>
</html>



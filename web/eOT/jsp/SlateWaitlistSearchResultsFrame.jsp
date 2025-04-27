<!DOCTYPE html>
<%@page  import="eOT.*, eOT.Common.*" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
 <%
	String params		= request.getQueryString() ;
	String preferred_date	= request.getParameter("preferred_date");
	String speciality	= request.getParameter("speciality");
	String surgeon		= request.getParameter("surgeon");
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";

	SlateBean bean	= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	boolean ot_waitlist_dtls_flag = false;
		ot_waitlist_dtls_flag = bean.loadWaitlistDetails(preferred_date,speciality,surgeon);
	if(ot_waitlist_dtls_flag==true){
%>
	
		<iframe name="f_header_frame" id="f_header_frame" scrolling="no" noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params%>&sch_unsch_flag=WAITLIST"  style="height:7vh;width:100vw"></iframe>
		<iframe name="f_waitlist_results_frame" id="f_waitlist_results_frame" scrolling="yes" noresize src="../../eOT/jsp/SlateWaitlistResults.jsp?<%=params%>"  style="height:93vh;width:100vw"></iframe>
		<%
	}else{
	%>
		<iframe name="f_header_frame" id="f_header_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"  style="height:100vh;width:100vw"></iframe>
	<%
	}
	%>
</html>
	<%
		if(ot_waitlist_dtls_flag==false){
	%>
		<script language="javascript">
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			//enableSearchCriteria();
		</script>
	<%
		}
	%>


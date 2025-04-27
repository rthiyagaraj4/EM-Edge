<!DOCTYPE html>
<%//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="eOT.*, eOT.Common.*,eCommon.Common.CommonBean" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <%
	String params		= request.getQueryString() ;
	String booking_date	= request.getParameter("booking_date");
	String theatre		= CommonBean.checkForNull(request.getParameter("theatre"));
	String speciality	= CommonBean.checkForNull(request.getParameter("speciality"));
	String surgeon		= CommonBean.checkForNull(request.getParameter("surgeon"));
	String view_status	= CommonBean.checkForNull(request.getParameter("view_status"));
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";

	SlateBean bean	= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
	boolean ot_reschedule_dtls_flag = false;
		ot_reschedule_dtls_flag = bean.loadReScheduleDetails(booking_date,theatre,speciality,surgeon,view_status);
	if(ot_reschedule_dtls_flag==true){
%>
	
		<iframe name="f_header_frame" id="f_header_frame" scrolling="no"  noresize src="../../eOT/jsp/SlateResultsHeader.jsp?<%=params%>&sch_unsch_flag=RESCHEDULE"  style="height:10vh;width:100vw"></iframe>
		<iframe name="f_reschedule_results_frame" id="f_reschedule_results_frame" scrolling="yes"  noresize src="../../eOT/jsp/SlateReScheduleResults.jsp?<%=params%>"  style="height:65vh;width:100vw"></iframe>
		<iframe name="f_reschedule_other_action_frame" id="f_reschedule_other_action_frame" scrolling="no"  noresize src="../../eOT/jsp/SlateReScheduleOtherActions.jsp?<%=params%>"  style="height:25vh;width:100vw"></iframe>
		<%
	}else{
	%>
		<iframe name="f_header_frame" id="f_header_frame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"  style="height:100vh;width:100vw"></iframe>
	<%
	}
	%>
</html>
	<%
		if(ot_reschedule_dtls_flag==false){
	%>
		<script language="javascript">
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			//enableSearchCriteria();
		</script>
	<%
		}
	%>


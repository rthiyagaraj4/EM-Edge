<!DOCTYPE html>

<!--
Developed by    : Bhavani Shankar.
Module/Function : Instrument Count 
Start Date		: 07/02/2006
-->
<%@page   import="eOT.*,eOT.Common.* , eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
	<script language="javascript" src="../../eOT/js/InstrumentCount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<title><fmt:message key="eOT.InstrumentCount.Label" bundle="${ot_labels}"/></title>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String source = url + params;
	String booking_num	= request.getParameter("booking_num");
	String oper_num		= request.getParameter("oper_num");
	String order_id		= request.getParameter("order_id");
	String invoked_from	= request.getParameter("invoked_from");
	invoked_from=invoked_from==null?"":invoked_from;
	invoked_from=invoked_from.equalsIgnoreCase("null")?"":invoked_from;
	String query_flag_yn		= request.getParameter("query_flag_yn");
	query_flag_yn=query_flag_yn==null?"N":query_flag_yn;
	query_flag_yn=query_flag_yn.equalsIgnoreCase("null")?"N":query_flag_yn;
	String hdr_params = params+"&instr_called_from=SET";
	String bean_id	 = "InstrumentCountBean";
	String bean_name = "eOT.InstrumentCountBean";
	InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
	bean.clear();
%>
<script>
</script>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:20%;width:100vw"></iframe><iframe name="patient_title" id="patient_title" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" style="height:70%;width:100vw"></iframe><iframe name="bio_hazard_frame" id="bio_hazard_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/Biohazard.jsp?<%=params%>">
		<iframeset cols="35%,*" id="frameset_1">
				<iframeset rows="*,40" style="height:22%;width:100vw"></iframe><iframe name="f_instr_hdr" id="f_instr_hdr" frameborder="1" noresize scrolling="yes" src="../../eOT/jsp/InstrumentCountListFrame.jsp?<%=params%>" style="height:100vh;width:100vw"></iframe><iframe name="f_create_set" id="f_create_set" frameborder="1" noresize scrolling="no" src="../../eOT/jsp/InstrumentCountCreateSetButton.jsp?<%=params%>" style="height:50%;width:100vw"></iframe>
			<iframe name="f_instr_dtl" id="f_instr_dtl" frameborder="0" noresize scrolling="auto" src="../../eCommon/html/blank.html?<%=params%>" style="height:100vh;width:100vw"></iframe><iframe name="f_instr_item_status_confirm" id="f_instr_item_status_confirm" frameborder="0" noresize scrolling="no" src="../../eCommon/html/blank.html?<%=params%>" style="height:20%;width:100vw"></iframe><iframe name="f_instr_dtl_confirm" id="f_instr_dtl_confirm" frameborder="0" noresize scrolling="no" src="../../eCommon/html/blank.html?<%=params%>" style="height:20%;width:100vw"></iframe>
		</frameset>
		<frame name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>
<form name="InstrumentCountMainForm" id="InstrumentCountMainForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
</form>
</html>


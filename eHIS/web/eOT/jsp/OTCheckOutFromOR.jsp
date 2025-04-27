<!DOCTYPE html>
<HTML>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckOutFromOR.Label","ot_labels")%></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eOT/js/CheckInToOR.js'></script>
	<script type='text/javascript' src='../../eOT/js/CheckOutFromOR.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
	<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String recovery_in_out_flag="CHECK_OUT_FROM_OR";
	String params = request.getQueryString()+"&facility_id="+facility_id+"&recovery_in_out_flag="+recovery_in_out_flag;
	String source = url + params ;

	//String oper_dtls = params+"&title=Operation Details&editable_yn=N&booking_oper_flag=OPER&booking_num=";

String operationdetails_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels");

String oper_dtls = params+"&title="+operationdetails_title+"&editable_yn=N&booking_oper_flag=OPER&booking_num=";
%>

<frameset rows="42,*,50">
    <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
		
		<frameset rows='11%,12%,14%,19%,6%,*' border='0'>
			 <frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=oper_dtls%>" frameborder=0  scrolling="no" noresize></frame>
			<frame name='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=oper_dtls%>'  scrolling='no' noresize></frame>
			<frame name='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>'  scrolling='auto' noresize>
			<frame name='recovery_frame' SRC='../../eOT/jsp/CheckOutFromOR.jsp?<%=params%>' scrolling='auto' noresize></frame>

				<frameset rows='0%,*' border='0'>
					<frame name='ObjectCollect' SRC='../../eOT/jsp/NursingObjectCollect.jsp?<%=params%>'  scrolling='no' noresize='no'></frame>
					<frame name='tab_frame' SRC='../../eOT/jsp/ChkInRecoveryTab.jsp?<%=params%>'  scrolling='auto' noresize></frame>	
				</frameset>
			<frame name='result_frame' =SRC='../../eCommon/html/blank.html'  scrolling='no' noresize='no'></frame> 
		</frameset>
	 <frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="OTCheckInToORForm" >
		<input type='hidden' name='params' value='<%=params%>' >
	</form>
</body>
</html>

<!DOCTYPE html>
  <%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<HTML>
<head>
<title><fmt:message key="eOT.TransfertoOTfromRecoveryRoom.Label" bundle="${ot_labels}"/></title>
<%

String operationdetails =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels")+",";

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eOT/js/TransferToOT.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString()+"&function_name=Transfer To OT from Recovery Room&facility_id="+facility_id;
	String source = url + params ;
	String oper_dtls = params+"&title="+operationdetails+"&editable_yn=N&booking_oper_flag=OPER&booking_num=";

%>

<frameset rows="42,*,50">
    <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
<!--    <frame name="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/HoldingAreaFrames.jsp?<%=params%>"> -->
		<FRAMESET ROWS='12%,17.5%,40%,*' border='0'>
		<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" frameborder=0  scrolling="no" noresize>
			<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='no' noresize>
			</FRAME>
			<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>'  scrolling='yes' noresize>
			</FRAME>	
			<FRAME NAME='transfer_ot_frame' SRC='../../eOT/jsp/TransferToOTDetails.jsp?<%=params%>' scrolling='auto' noresize></FRAME>
		</FRAMESET>
    <frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>
<body  onKeyDown = 'lockKey();'>
	<form name="OTTransferForm">
		<input type='hidden' name='params' value='<%=params%>' >
		<input type='hidden' name='locale' value="<%=locale%>">
	</form>
</body>
</html>

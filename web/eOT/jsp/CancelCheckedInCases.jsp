<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<HTML>
<title> <fmt:message key="eOT.CancelCheckedInCases.Label" bundle="${ot_labels}"/></title>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src='../../eOT/js/CancelCheckIn.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString()+"&facility_id="+facility_id;
	String source = url + params ;	
	String title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels")+"," ;	
		
//	String oper_dtls = params+"&title=OperationDetails&editable_yn=N&booking_oper_flag=OPER&booking_num=";
	String oper_dtls = params+"&title="+title+"&editable_yn=N&booking_oper_flag=OPER&booking_num=";
%>

	<FRAMESET rows="42,*,50">
	<FRAME name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
	<!-- <FRAMESET ROWS='20%,40%,*' border='0'> -->
		<FRAMESET rows='12%,18%,40%,*' border='0'>
		<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" frameborder=0  scrolling="no" noresize>
		<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>' scrolling='no' noresize>
		</FRAME>
		<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>' scrolling='yes' noresize>
		</FRAME>	
		<FRAME NAME='cancel_checkIn_frame' SRC='../../eOT/jsp/CancelCheckIn.jsp?<%=params%>' scrolling='auto' noresize>
		</FRAME>
	</FRAMESET>
    <FRAME name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
	</FRAME>
</FRAMESET>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
  <form name="OTTransferForm">
	<input type='hidden' name='params' value='<%=params%>' >
  </form>
</body>
</html>

<!DOCTYPE html>
<HTML>
<%@ page import = "eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<title><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CheckInToOperatingRoom.Label","ot_labels")%></title>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eOT/js/CheckInToOR.js'></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
	<script type='text/javascript' src='../../eCommon/js/DateUtils.js'></script>
</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString()+"&facility_id="+facility_id;
	System.err.println("23,OTCheckInToOR.jsp,params===="+params);
	String source = url + params ;
	System.err.println("25,OTCheckInToOR.jsp,source===="+source);
	String operationdetails_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels");
	String oper_dtls = params+"&title="+operationdetails_title+"&editable_yn=N&booking_oper_flag=OPER&booking_num=";
	System.err.println("28,OTCheckInToOR.jsp,oper_dtls===="+oper_dtls);
%>

<frameset rows="42,*,50">
    <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
		<FRAMESET ROWS='12%,18%,44%,*' border='0'>
		<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=oper_dtls%>" frameborder=0  scrolling="no" noresize>
			<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=oper_dtls%>'  scrolling='no' noresize>
			<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>'  scrolling='yes' noresize>
			</FRAME>	
			<FRAME NAME='CheckInORFrame' SRC='../../eOT/jsp/CheckInToOR.jsp?<%=params%>' scrolling='auto' noresize></FRAME>
		</FRAMESET>

    <frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="OTCheckInToORForm" >
		<input type='hidden' name='params' value='<%=params%>' >
	</form>
</body>
</html>

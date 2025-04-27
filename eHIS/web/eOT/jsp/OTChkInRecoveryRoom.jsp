<!DOCTYPE html>

<%@page   import="eCommon.XSSRequestWrapper,eOT.Common.*, eOT.*,eCommon.Common.*"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<% 
	String recovery_in_out_flag=CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));


	if(recovery_in_out_flag.equals("CHECK_IN_RECO") ){ %>
		<title><fmt:message key="eOT.CheckInToRecoveryRoom.Label" bundle="${ot_labels}"/></title>
	<%}else{ %>
	<title>
		<fmt:message key="eOT.CheckOutFromRecoveryRoom.Label" bundle="${ot_labels}"/>
	</title>
	<%}%>

<head>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eOT/js/CheckInOutRecoveryRoom.js'></script>
	<script language='javascript' src='../../eOT/js/OTCommon.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>
<%  
	String bean_id = "ChkInOutRecoveryBean";
	String bean_name = "eOT.ChkInOutRecoveryBean";
	ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean) mh.getBeanObject(bean_id, request, bean_name );
	bean.clear();
	//String recovery_in_out_flag=CommonBean.checkForNull(request.getParameter("recovery_in_out_flag"));
	String facility_id  = (String) session.getValue("facility_id");
	//System.err.println("facility_id====="+facility_id);
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString()+"&recovery_in_out_flag="+recovery_in_out_flag;
	String source = url + params;

String operationdetails_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels");
	
		String oper_dtls = params+"&title=operationdetails_title&editable_yn=N&booking_oper_flag=OPER&booking_num=";
		//System.err.println(" Source in ChkinRecRoom : "+source);
%>

	
<frameset rows="42,*,50">
    <frame name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
<% 
	if(recovery_in_out_flag.equalsIgnoreCase("CHECK_IN_RECO")){ 
%>
	 <FRAMESET ROWS='12%,16%,25%,14%,7%,*' border='0'>  
	
			<FRAME name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" noresize scrolling='no' > 
			<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='no' noresize>
			<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>' scrolling='auto' noresize>
			<!--<FRAME NAME='recovery_frame' SRC='../../eOT/jsp/ChkInRecoveryRoom.jsp?<%=params%>' scrolling='no' noresize>-->
			<FRAME NAME='recovery_frame' SRC='../../eCommon/html/blank.html' scrolling='yes' noresize>
				
			<FRAME NAME='tab_frame' SRC='../../eCommon/html/blank.html' scrolling='no' noresize>
			<FRAME NAME='result_frame' SRC='../../eCommon/html/blank.html' scrolling='no' noresize>
		</FRAMESET>
<%} else if(recovery_in_out_flag.equalsIgnoreCase("CHECK_OUT_RECO")){ 
				//System.err.println(" Params in Chk Out from Rec ----> : "+params);
				%>
		<!-- <FRAMESET ROWS='25%,25%,19%,4.5%,*' border='0'> -->
			<FRAMESET ROWS='12%,10%,15%,27%,6%,*' border='0'>
			<FRAME name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" noresize scrolling='no' >
			<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='no' noresize>
			<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>' scrolling='auto' noresize >
			<FRAME NAME='recovery_frame' SRC='../../eOT/jsp/ChkInRecoveryRoom.jsp?<%=params%>' scrolling='yes' noresize >
			<FRAMESET rows='0,*' border='0'>
				<FRAME NAME='ObjectCollect' SRC='../../eOT/jsp/NursingObjectCollect.jsp?<%=params%>'  scrolling='no' noresize='no'>
				<FRAME name="tab_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/ChkInRecoveryTab.jsp?<%=params%>">    	    
			</FRAMESET>
			<FRAME NAME='result_frame' =SRC='../../eCommon/html/blank.html'  scrolling='no' noresize='no'></FRAME> 
			<!--<FRAME NAME='tab_frame' SRC='../../eCommon/html/blank.html' scrolling='no' noresize>-->
			<!-- <FRAME NAME='result_frame' SRC='../../eCommon/html/blank.html' scrolling='auto' noresize> -->

		</FRAMESET>
<%}%>

    <frame name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</frameset>

	

<body  onKeyDown = 'lockKey();'>
	<form name="ChkInOutRecoveryForm" >
		<input type='hidden' name='params' value='<%=params%>' >
	</form>
</body>
</html>

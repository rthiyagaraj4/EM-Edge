<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
String function_id_temp=request.getParameter("function_id_temp")==null?"":request.getParameter("function_id_temp");
if(function_id_temp.equals("33")){
%>
<title><fmt:message key="eOT.ChangeHoldingArea.Label" bundle="${ot_labels}"/></title>
<%
}else{	
%>
	<title><fmt:message key="eOT.HoldingArea.Label" bundle="${ot_labels}"/></title>
<%
}
%>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eOT/js/HoldingArea.js'></script>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString()+"&facility_id="+facility_id;
	String source = url + params ;
String operationdetails_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationDetails.Label","ot_labels");
	
	String oper_dtls = params+"&title=operationdetails_title&editable_yn=N&booking_oper_flag=OPER&booking_num=";
//holding_area_frame
%>

<FRAMESET rows="40,*,50">
    <FRAME name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>">
		<FRAMESET ROWS='12%,18%,30%,*' border='0'>
		<frame name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" frameborder=0  scrolling="auto" noresize>
			<FRAME NAME='common_patient_hdr_frame' SRC='../../eOT/jsp/CommonOperDtlsHdr.jsp?<%=params%>'  scrolling='no' noresize>
			</FRAME>
			<FRAME NAME='common_oper_dtls_frame' SRC='../../eOT/jsp/CommonOperationDtls.jsp?<%=oper_dtls%>'  scrolling='yes' noresize>
			</FRAME>	
			<FRAME NAME='holding_area_frame' SRC='../../eCommon/html/blank.html' scrolling='auto' noresize></FRAME>
		</FRAMESET>

    <FRAME name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto">
</FRAMESET>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form name="OTHoldingAreaForm" >
		<input type='hidden' name='params' value='<%=params%>'>
	</form>
</body>
</html>

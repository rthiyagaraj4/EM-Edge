<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean,eOR.OrderEntryBillingQueryBean,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  %>

<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<title>
 Administrative Function for All Charges
</title>

<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String facility_id = (String) session.getAttribute("facility_id");

String bean_id 						= "OrderEntryBillingQueryBean";
String bean_name 					= "eOR.OrderEntryBillingQueryBean";
OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request ) ;
or_bean.clearBean();
cleanAll(session);
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eOT/js/Hashtable.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
</head>

<%
	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	//String booking_num = CommonBean.checkForNull(request.getParameter("booking_num")); // 04000112
	//String slate_user_id = CommonBean.checkForNull(request.getParameter("slate_user_id")); // logged in user from Slate
	if(called_from==null) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("null")) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("")) called_from="OT_MENU";
%>


    <iframe name='OtPatientLineFrame' id='OtPatientLineFrame' SRC='../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>'  scrolling='no' noresize style='height:10vh;width:100vw';border='0'></iframe>
	<!-- Modified by DhanasekarV on 27/01/2011 against issue IN026046   -->
	<!--<frame name='AdministrativeFucntionFrame' id='AdministrativeFucntionFrame' SRC='../../eOT/jsp/AdministrativeFunctionforAllChargesFrame.jsp?<%=params%>'  scrolling='auto' noresize>
	</frame>-->
	<iframe name='AdministrativeFucntionFrame' id='AdministrativeFucntionFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:75vh;width:100vw';border='0'></iframe>
	<iframe name='AdministrativeFunctionCompletionStatus' id='AdministrativeFunctionCompletionStatus' SRC='../../eOT/jsp/AdministrativeFunctionCompletionStatus.jsp?<%=params%>'  scrolling='no' noresize style='height:8vh;width:100vw';border='0'></iframe>>
	 <iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" noresize scrolling="auto" style='height:8vh;width:100vw';border='0'></iframe>
	<iframe name='AdminObjectCollect' id='AdminObjectCollect' SRC='../../eOT/jsp/AdministrativeFunctionobjectCollect.jsp?<%=params%>'  scrolling='no' noresize='no' style='height:0vh;width:100vw';border='0'></iframe>
	<iframe name='dummy_rep_frame' id='dummy_rep_frame' src="../../eCommon/html/blank.html" noresize scrolling='no' style='height:0vh;width:100vw';border='0'></iframe>



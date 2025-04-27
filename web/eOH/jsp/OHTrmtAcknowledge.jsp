<!DOCTYPE html>


<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String cur_date = "";

	String params = request.getQueryString();
	String facility_id = (String)session.getValue("facility_id") ;
	String ca_practitioner_id = (String)session.getValue("ca_practitioner_id") ;

	String patient_id = checkForNull(request.getParameter( "patient_id" )) ;
	String episode_id = checkForNull(request.getParameter("episode_id")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String speciality_code = checkForNull(request.getParameter("speciality_code")) ;

	String chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
	String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
	String task_code = checkForNull(request.getParameter("task_code")) ;
	String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
	//Added by Sharon Crasta on 3/31/2010 for IN018302 to disable the fields for asOnDate and closed charts
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;
    //End

	String acknowledge_date = "";
	String ack_receipt_no = "";
	String acknowledged_by = "";
	String expected_delivery_date = "";
	String acknowledged_yn = "";
	String disable_all = "";
	String readonly_all = "";
	String ack_checked = "";
	String acknowledge_date_hid = "";

%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type="text/javascript" src="../../eOH/js/OHTrmtSendOutAcknowledge.js"></script>
	<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
try{
	con=ConnectionManager.getConnection(request);

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	pstmt = con.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') CUR_DATE_TIME FROM DUAL");
	rs=pstmt.executeQuery();
		
	while(rs.next()){
		//cur_date = checkForNull(rs.getString("CUR_DATE_TIME"));
		 cur_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("CUR_DATE_TIME"),"DMYHM","en",locale));

	}

	acknowledge_date = cur_date; //Initially before recording, acknowledge_date is defaulted to sysdate. 
	//expected_delivery_date = cur_date; //Initially before recording, expected_delivery_date is defaulted to sysdate. 

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	pstmt=con.prepareStatement("SELECT TO_CHAR(ACKNOWLEDGE_DATE,'DD/MM/YYYY HH24:MI') ACKNOWLEDGE_DATE, ACK_RECEIPT_NO, ACKNOWLEDGED_BY, TO_CHAR(EXPECTED_DELIVERY_DATE,'DD/MM/YYYY HH24:MI') EXPECTED_DELIVERY_DATE, ACKNOWLEDGED_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
	pstmt.setString(1,patient_id);				
	pstmt.setString(2,chart_num);				
	pstmt.setString(3,chart_line_num);				
	pstmt.setString(4,trmt_code);				
	pstmt.setString(5,task_code);				
	pstmt.setString(6,task_seq_no);
	rs=pstmt.executeQuery();
	
	while(rs!=null && rs.next()){
//		acknowledge_date=checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
//		acknowledge_date=checkForNull(rs.getString("ACKNOWLEDGE_DATE"));
		acknowledge_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ACKNOWLEDGE_DATE"),"DMYHM","en",locale));
		ack_receipt_no=checkForNull(rs.getString("ACK_RECEIPT_NO"));
		acknowledged_by=checkForNull(rs.getString("ACKNOWLEDGED_BY"));
		expected_delivery_date=checkForNull(rs.getString("EXPECTED_DELIVERY_DATE"));
		acknowledged_yn=checkForNull(rs.getString("ACKNOWLEDGED_YN"));
		acknowledge_date_hid = acknowledge_date;
		if(acknowledge_date.equals("") && !acknowledged_yn.equals("N") && !acknowledged_yn.equals("Y")){
			//acknowledge_date = cur_date;
		}
		/*
		if(expected_delivery_date.equals("")){
			expected_delivery_date = cur_date;
		}*/

		
	}
	if(acknowledged_yn.equals("Y")){
		disable_all = "disabled";
		readonly_all = "disabled";
		ack_checked = "checked";
	}
	//Added by Sharon Crasta on 3/31/2010 for IN018302
	else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
		disable_all = "disabled";
		readonly_all = "readonly";
	}//End
	else{
		disable_all = "";
		ack_checked = "";
	} 



%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setAckDefaultValues();CurrTime()">

	<form name="OHTrmtAcknowledge" id="OHTrmtAcknowledge" action="../../servlet/eOH.OHTrmtSendOutAckServlet" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0>
			<tr>
				<td width="25%" class='ITEMSELECT' nowrap colspan='6'><fmt:message key="eOH.ExtLocAckDetails.Label" bundle="${oh_labels}"/></td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<!-- <input type="text" name="ack_recvd_date" id="ack_recvd_date" value="" size=10 onKeyPress = "NumberCheck(this);" onBlur='checkDateNotGraterThanSysDate(this)'> -->
						

					 <input type="text" name="ack_recvd_date" id="ack_recvd_date" value="<%=acknowledge_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='checkDateTimeValidations(this,"ack");' <%=disable_all%>> 
					<!-- <input type="text" name="ack_recvd_date" id="ack_recvd_date" value="<%=acknowledge_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='checkDateValidity(this);checkDateGreaterThanRegDate(this,"ack");' <%=disable_all%>> -->
					<input id="ack_recvd_cal" type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return callCalender(this,'ack_recvd_date');" <%=disable_all%>>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.RecieptNo.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="ack_recpt_no" id="ack_recpt_no" value="<%=ack_receipt_no%>" size="9" maxlength="9" <%=disable_all%>/>
				</td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.ReceivedPersonnelDetail.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="ack_personnel" id="ack_personnel" value='<%=acknowledged_by%>' <%=readonly_all%> maxlength="100"/>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.ExpectedDeliveryDate.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<!-- <input type="text" name="ack_expected_date" id="ack_expected_date" value="" size=10 onKeyPress = "NumberCheck(this);" onBlur='checkDateNotGraterThanSysDate(this)'> -->
					<input type="text" name="ack_expected_date" id="ack_expected_date" value="<%=expected_delivery_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='ExpDelieveryDateVal(this);' <%=disable_all%>>
					<input id="ack_expected_cal" type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return callCalender(this,'ack_expected_date');" <%=disable_all%>>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.Acknowledged.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="checkbox" name="ack_completed" id="ack_completed" value='<%=acknowledged_yn%>' onclick="setSendoutAckValue('Acknowledge');" <%=ack_checked%> <%=disable_all%>/>
				</td>
			</tr>
			<tr>
				<td width="25%" colspan="6" class="button">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onclick ="ackAction();" <%=disable_all%>>&nbsp;
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="ackReset();" <%=disable_all%>>
				</td>
			</tr>
		</table>
		<input type = "hidden" name= "params" value = "<%=params%>">
		<input type = "hidden" name= "locale" value = "<%=locale%>">

		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "ca_practitioner_id" value = "<%=ca_practitioner_id%>">
		<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "location_code" value = "<%=location_code%>">
		<input type = "hidden" name= "speciality_code" value = "<%=speciality_code%>">
		<input type = "hidden" name= "cur_date" value = "<%=cur_date%>">

		<input type = "hidden" name= "chart_level" value = "<%=chart_level%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type = "hidden" name= "trmt_code" value = "<%=trmt_code%>">
		<input type = "hidden" name= "task_code" value = "<%=task_code%>">
		<input type = "hidden" name= "task_seq_no" value = "<%=task_seq_no%>">

		<input type = "hidden" name= "called_from" value = "acknowledge">
	</form>
</body>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>


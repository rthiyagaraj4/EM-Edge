<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,java.util.regex.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
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

	String received_date = "";
	String received_by = "";
	String received_yn = "";
	String remarks = "";
	String disable_all = "";
	String rcv_checked = "";
	String readonly_all = "";
	String lab_price = "";
	String rcv_receipt_no = "";

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

	received_date = cur_date;//Initially before recording, received_date is defaulted to sysdate.

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	pstmt=con.prepareStatement("SELECT TO_CHAR(RECEIVED_DATE,'DD/MM/YYYY HH24:MI') RECEIVED_DATE, RECEIVED_BY, RECEIVED_YN, REMARKS, LAB_PRICE, RCV_RECEIPT_NO FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
	pstmt.setString(1,patient_id);				
	pstmt.setString(2,chart_num);				
	pstmt.setString(3,chart_line_num);				
	pstmt.setString(4,trmt_code);				
	pstmt.setString(5,task_code);				
	pstmt.setString(6,task_seq_no);
	rs=pstmt.executeQuery();
	
	while(rs!=null && rs.next()){
		//received_date=checkForNull(rs.getString("RECEIVED_DATE"));
		received_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("RECEIVED_DATE"),"DMYHM","en",locale));

		received_by=checkForNull(rs.getString("RECEIVED_BY"));
		received_yn=checkForNull(rs.getString("RECEIVED_YN"));
		remarks=checkForNull(rs.getString("REMARKS"));
		lab_price=checkForNull(rs.getString("LAB_PRICE"));
		rcv_receipt_no=checkForNull(rs.getString("RCV_RECEIPT_NO"));
		
		if(received_date.equals("") && !received_yn.equals("N") && !received_yn.equals("Y")){
			//received_date = cur_date;
		}
	}

	if(received_yn.equals("Y")){
		disable_all = "disabled";
		readonly_all = "readonly";
		rcv_checked = "checked";
	}
	//Added by Sharon Crasta on 3/31/2010 for IN018302
	else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
		disable_all = "disabled";
		readonly_all = "readonly";
	}//End
	else{
		disable_all = "";
		rcv_checked = "";
	}

%>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setRcvDefaultValues();CurrTime()">

	<form name="OHTrmtRecvDetails" id="OHTrmtRecvDetails" action="../../servlet/eOH.OHTrmtSendOutAckServlet" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0>
			<tr>
				<td width="25%" class='ITEMSELECT' nowrap colspan='6'><fmt:message key="eOH.RecievedDetails.Label" bundle="${oh_labels}"/></td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<!-- <input type="text" name="recv_recvd_date" id="recv_recvd_date" value="" size=10 onKeyPress = "NumberCheck(this);" onBlur='checkDateNotGraterThanSysDate(this)'> -->
					<input type="text" name="recv_recvd_date" id="recv_recvd_date" value="<%=received_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='checkDateTimeValidations(this,"recv");' <%=disable_all%>>
					<input id="recv_recvd_cal" type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return callCalender(this,'recv_recvd_date');" <%=disable_all%>>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.RecieptNo.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="recv_recpt_no" id="recv_recpt_no" value="<%=rcv_receipt_no%>" size="9" maxlength="9" <%=disable_all%>/>
				</td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.ReceivedPersonnelDetail.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="recv_personnel" id="recv_personnel" value='<%=received_by%>' <%=readonly_all%> maxlength="100"/>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.LabPrice.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="recv_lab_price" id="recv_lab_price" value='<%=lab_price%>' size='10' maxlength="10" <%=disable_all%> onKeyPress = "LabPriceNumberCheck(this);" onBlur="return checkForDecimal(this);"/> 
				</td> 
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="recv_remarks" id="recv_remarks" value='<%=remarks%>' size='50' maxlength="500" <%=readonly_all%>/> 
					<!-- <textarea name="recv_remarks" ROWS='3' COLS='20' onBlur="makeValidString(this)" id='remarks_txt' <%=disable_all%>><%=remarks%></textarea> -->
					
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.Received.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="checkbox" name="recv_completed" id="recv_completed" value='<%=received_yn%>' onclick="setSendoutAckValue('Recieve');" <%=rcv_checked%> <%=disable_all%>/>
				</td> 
			</tr>
			<tr>
				<td width="25%" colspan="6" class="button">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onclick ="rcvAction();" <%=disable_all%>>&nbsp;
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="rcvReset();" <%=disable_all%>>
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

		<input type = "hidden" name= "called_from" value = "recvDetails">
		 <!-- Added by Sharon Crasta on 11/13/2009(was getting a script error) -->
		 <input type = "hidden" name= "lab_price_db" value = ""> 
		 <!-- -->

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


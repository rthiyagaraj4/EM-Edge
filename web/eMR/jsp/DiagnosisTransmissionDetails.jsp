<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%
	PreparedStatement pstmt		= null;
	ResultSet rset						= null;
	Connection con = ConnectionManager.getConnection(request);
	String trans_by_id = "";
	String trans_date = "";
	String conf_by_id = "";
	String conf_date = "";	
	String conf_date_dis="";
	String conf_details_status = "";
	String trns_details_status = "";
	String conf_date_status = "";
	String trans_date_status = "";
	String operation = "";
	String location = "";
	String conf_job_title = "";
	String trans_job_title = "";
	String button_status = "";
	String sys_date = "";
	String trans_date_dis = "";
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String Encounter_Id = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");
	String srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String diag_code = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String diag_code_scheme = request.getParameter("diag_code_scheme")==null?"":request.getParameter("diag_code_scheme");
	//<!--removed comment for diag_code_scheme for SCR 4943-->
	String recorded_date = request.getParameter("recorded_date")==null?"":request.getParameter("recorded_date");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
	String occur_srl_no = request.getParameter("occur_srl_no")==null?"":request.getParameter("occur_srl_no");
try {
	//String sql = " select to_char(sysdate,'dd/mm/yyyy hh24:mi') SDATE, TRANS_BY_ID,to_char(TRANS_DATE,'dd/mm/yyyy hh24:mi') TRANS_DATE, CONF_BY_ID,to_char(CONF_DATE,'dd/mm/yyyy hh24:mi') CONF_DATE, LOCATION,CONF_JOB_TITLE,TRANS_JOB_TITLE    from mr_diag_transmission where patient_id = ? and srl_no = ? ";
	String sql = " select to_char(sysdate,'dd/mm/yyyy hh24:mi') SDATE, TRANS_BY_ID,to_char(TRANS_DATE,'dd/mm/yyyy hh24:mi') TRANS_DATE, CONF_BY_ID,to_char(CONF_DATE,'dd/mm/yyyy hh24:mi') CONF_DATE, LOCATION,CONF_JOB_TITLE,TRANS_JOB_TITLE    from mr_diag_transmission where patient_id = ? and encounter_id = ? and term_set_id = ? and term_code = ?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patient_id);
	pstmt.setString(2,Encounter_Id);
	pstmt.setString(3,term_set_id);
	pstmt.setString(4,term_code);
	rset = pstmt.executeQuery();
	while(rset.next()){
		sys_date			= rset.getString("SDATE");
		trans_by_id		= rset.getString("TRANS_BY_ID")==null?"":rset.getString("TRANS_BY_ID");
		trans_date		= rset.getString("TRANS_DATE")==null?"":rset.getString("TRANS_DATE");
		if(trans_date != ""){
			trans_date_dis = DateUtils.convertDate(trans_date,"DMYHM","en",localeName); 			
		}
		conf_by_id		= rset.getString("CONF_BY_ID")==null?"":rset.getString("CONF_BY_ID");
		conf_date			= rset.getString("CONF_DATE")==null?"":rset.getString("CONF_DATE");
		if( conf_date != ""){
			conf_date_dis = DateUtils.convertDate(conf_date,"DMYHM","en",localeName);
		}
		location			= rset.getString("LOCATION")==null?"":rset.getString("LOCATION");
		conf_job_title	= rset.getString("CONF_JOB_TITLE")==null?"":rset.getString("CONF_JOB_TITLE");
		trans_job_title	= rset.getString("TRANS_JOB_TITLE")==null?"":rset.getString("TRANS_JOB_TITLE");
	}
}catch(Exception e){
	e.printStackTrace();
}
finally{
	try{
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	if (con != null){
		ConnectionManager.returnConnection(con,request);
	}
}
if(call_function.equals("TRANSMIT_NOTIFY_REP")){
		if(trans_by_id.equals("")&& trans_date.equals("")){
			conf_details_status = "disabled";
			conf_date_status	= "disabled";
			trns_details_status = "";
			trans_date_status = "";
			operation = "insert";
			button_status = "";
		}else if (!trans_by_id.equals("")&& !trans_date.equals("")){
			conf_details_status = "disabled";
			trns_details_status = "disabled";
			conf_date_status	= "disabled";
			trans_date_status	= "disabled";
			operation = "display";
			button_status = "disabled";
		}
}else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
		if(conf_by_id.equals("")&& conf_date.equals("")){
			if(!trans_by_id.equals("")||!trans_date.equals("")){
				conf_details_status = "";
				trns_details_status = "disabled";
				trans_date_status	= "disabled";
				conf_date_status	= "";
				operation = "insert";
				button_status = "";
			}else{
				conf_details_status = "disabled";
				trns_details_status = "disabled";
				trans_date_status	= "disabled";
				conf_date_status	= "disabled";
				operation = "display";
				button_status = "disabled";
			}
		}else if (!trans_by_id.equals("")&& !trans_date.equals("") && !conf_by_id.equals("") && !conf_date.equals("")){
			conf_details_status = "disabled";
			trns_details_status = "disabled";
			trans_date_status	= "disabled";
			conf_date_status	= "disabled";
			operation = "display";
			button_status = "disabled";
		}
}
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<title></title>
			<script src='../../eMR/js/MedRecRequest.js' language='javascript'></script>	
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
			<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
			<script language='javascript' src="../../eCommon/js/CommonLookup.js"></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
		<form name='markencounter_Form' id='markencounter_Form' action='../../servlet/eMR.DiagTransmissionServlet' method='post' target='messageFrame'>
				<table cellspacing=0 cellpadding=3 align='center' width='100%' border='0'>
						<th colspan=2 ><fmt:message key="eMR.TransmissionDetails.label" bundle="${mr_labels}"/></th>
						<th colspan=2 ><fmt:message key="eMR.CommunicationDetails.label" bundle="${mr_labels}"/></th>
						<tr>
							<td class=label width='25%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='trm_name' id='trm_name' size=30 maxlength='30' value='<%=trans_by_id%>' <%=trns_details_status%>><img src='../../eCommon/images/mandatory.gif' id='img1' style='visibility:visible'></img></td>
							<td class=label width='25%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='com_name' id='com_name' size=30 maxlength='30' value='<%=conf_by_id%>' <%=conf_details_status%>><img src='../../eCommon/images/mandatory.gif' id='img4' style='visibility:hidden'></img></td>
						</tr>
						<tr>
							<td class=label width='25%'  nowrap><fmt:message key="eMR.TransmissionDateTime.label" bundle="${mr_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='trm_datetime' id='trm_datetime' size='14' maxlength='16' onkeypress="return Valid_DT(event);"  onblur='chkDates(this);compareWithSysDt(this);' value='<%=trans_date_dis%>' <%=trns_details_status%>><img  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trm_datetime.select();return showCalendar('trm_datetime',null,'hh:mm')" <%=trans_date_status%>/><img src='../../eCommon/images/mandatory.gif' id='img2' style='visibility:visible'></img></td>
							<!-- <td class=fields width='25%' ><input type='text' name='trm_datetime' id='trm_datetime' id='trmdatetime' size='14' maxlength='16' onkeypress="return Valid_DT(event);"  onblur='//compareDates2(this);date_Validate1(this);' value='<%=trans_date%>' <%=trns_details_status%>><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trm_datetime.select();return showCalendar('trmdatetime',null,'hh:mm')" <%=trans_date_status%>><img src='../../eCommon/images/mandatory.gif' id='img2' style='visibility:visible'></img></td> -->
							<td class=label width='25%' ><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='com_desig' id='com_desig' size=20 maxlength='20' value='<%=conf_job_title%>' <%=conf_details_status%>><img src='../../eCommon/images/mandatory.gif' id='img5' style='visibility:hidden'></img></td>
						</tr>
						<tr>
							<td class=label width='25%' ><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='trm_desig' id='trm_desig' size=20 maxlength='20' value='<%=trans_job_title%>' <%=trns_details_status%>></td>
							<td class=label width='25%'  nowrap><fmt:message key="eMR.AckDateTime.label" bundle="${mr_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='conf_datetime' id='conf_datetime' id='confdatetime' size='14' maxlength='16' onkeypress="return Valid_DT(event);" onblur= 'chkDates(this);compareWithSysDt(this);compareWithRcdate(this);' value='<%=conf_date_dis%>' <%=conf_details_status%>><img src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trm_datetime.select();return showCalendar('confdatetime',null,'hh:mm')" <%=conf_date_status%>/><img src='../../eCommon/images/mandatory.gif' id='img6' style='visibility:hidden'></img></td>
							<!-- <td class=fields width='25%' ><input type='text' name='conf_datetime' id='conf_datetime' id='confdatetime' size='14' maxlength='16' onkeypress="return Valid_DT(event);" onblur= 'compareDates2(this);date_Validate1(this);Validate_withRcdate(this);' value='<%=conf_date%>' <%=conf_details_status%>><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].trm_datetime.select();return showCalendar('confdatetime',null,'hh:mm')" <%=conf_date_status%>><img src='../../eCommon/images/mandatory.gif' id='img6' style='visibility:hidden'></img></td> -->
						</tr>
						<tr>
							<td class=label width='25%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
							<td class=fields width='25%' ><input type='text' name='trm_location' id='trm_location' size=20 maxlength='20' value='<%=location%>' <%=trns_details_status%>><img src='../../eCommon/images/mandatory.gif' id='img3' style='visibility:visible'></img></td>
							<td class=label width='25%' >&nbsp;</td>
							<td class=label width='25%' >&nbsp;</td>
						</tr>		
						<tr class='label'>
							<td class="label" width='25%'>&nbsp;</td>
							<td class="label" width='25%'>&nbsp;</td>
							<td class="label" width='25%'>&nbsp;</td>
							<td class='button' width='25%'><INPUT TYPE=button class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onclick="submitPage2();" <%=button_status%>><INPUT TYPE=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick="closeWindow();"></td>
						</tr>
				</table>
				<input type='hidden' name='diag_code' id='diag_code' value='<%=diag_code%>'>
				<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value='<%=diag_code_scheme%>'>
				<!--removed comment for diag_code_scheme for SCR 4943-->
				<input type='hidden' name='srl_no' id='srl_no' value='<%=srl_no%>'>
				<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
				<input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=Encounter_Id%>'>
				<input type='hidden' name='operation' id='operation' value='<%=operation%>'>
				<input type='hidden' name='call_function' id='call_function' value='<%=call_function%>'>
				<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
				<input type='hidden' name='recorded_date' id='recorded_date' value='<%=recorded_date%>'>
				<input type='hidden' name='transmission_name' id='transmission_name' value='<%=trans_by_id%>'>
				<input type='hidden' name='confirmatin_name' id='confirmatin_name' value='<%=conf_by_id%>'>
				<input type='hidden' name='term_set_id' id='term_set_id' value='<%=term_set_id%>'>
				<input type='hidden' name='term_code' id='term_code' value='<%=term_code%>'>
				<input type='hidden' name='occur_srl_no' id='occur_srl_no' value='<%=occur_srl_no%>'>
				<script>
						if(document.forms[0].transmission_name.value!=''){
							document.getElementById("img1").style.visibility='hidden';
							document.getElementById("img2").style.visibility='hidden';
							document.getElementById("img3").style.visibility='hidden';		
							document.getElementById("img4").style.visibility='visible';
							document.getElementById("img5").style.visibility='visible';
							document.getElementById("img6").style.visibility='visible';
						}
						if(document.forms[0].confirmatin_name.value!=''&& document.forms[0].transmission_name.value!=''){
							document.getElementById("img4").style.visibility='hidden';
							document.getElementById("img5").style.visibility='hidden';
							document.getElementById("img6").style.visibility='hidden';		
						}
				</script>
		</form>
	</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


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
	String episode_type = checkForNull(request.getParameter("episode_type")) ;
	String patient_class = checkForNull(request.getParameter("patient_class")) ;
	String encounter_id = checkForNull(request.getParameter("encounter_id")) ;
	String visit_id = checkForNull(request.getParameter("visit_id")) ;
	String location_code = checkForNull(request.getParameter("location_code")) ;
	String location_type = checkForNull(request.getParameter("location_type")) ;
	String speciality_code = checkForNull(request.getParameter("speciality_code")) ;

	//out.println("encounter_id:==="+encounter_id);
	//out.println("patient_id:==="+patient_id);
	//out.println("patient_class:==="+patient_class);

	String chart_level = checkForNull(request.getParameter("oh_chart_level")) ;
	String chart_num = checkForNull(request.getParameter("chart_num")) ;
	String chart_line_num = checkForNull(request.getParameter("chart_line_num")) ;
	String trmt_code = checkForNull(request.getParameter("trmt_code")) ;
	String task_code = checkForNull(request.getParameter("task_code")) ;
	String task_seq_no = checkForNull(request.getParameter("task_seq_no")) ;
	String seq_no = checkForNull(request.getParameter("seq_no")) ;

	String send_from_facility_id = facility_id;
	String send_practitioner_id = ca_practitioner_id;
	String send_from_location = location_code;
	String performing_location = "";
	String sent_out_date = "";
	String sent_to = "";
	String sendout_yn = "";
	String disable_all = "";
	String readonly_all = "";
	String sendout_checked = "";
	String DB_practitioner_id = "";
	String DB_patient_class = "";
	String note_event_status = "";
	String db_practitioner_id = "";
	String pract_selected = "";
	String contr_mod_accession_num = patient_id+"$"+chart_num+"$"+chart_line_num+"$"+seq_no;
	//Added by Sharon Crasta on 3/31/2010 for IN018302 to disable the fields for asOnDate and closed charts
	String baseline_chart_yn = checkForNull(request.getParameter( "baseline_chart_yn" )) ;
	String date_diff_flag = checkForNull(request.getParameter( "date_diff_flag" )) ;

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

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//pstmt=con.prepareStatement("SELECT A.PATIENT_CLASS, A.ATTEND_PRACTITIONER_ID PRACTITIONER_ID FROM PR_ENCOUNTER A WHERE A.FACILITY_ID = ? AND A.ENCOUNTER_ID = ? AND A.PATIENT_ID = ? AND  A.PATIENT_CLASS = ?");
		pstmt=con.prepareStatement("SELECT A.PATIENT_CLASS, A.ATTEND_PRACTITIONER_ID PRACTITIONER_ID FROM PR_ENCOUNTER A WHERE A.FACILITY_ID = ? AND A.ENCOUNTER_ID = ? AND A.PATIENT_ID = ?");
		pstmt.setString(1,facility_id);
		pstmt.setString(2,encounter_id);
		pstmt.setString(3,patient_id);
		//pstmt.setString(4,patient_class);
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			DB_practitioner_id = checkForNull(rs.getString("PRACTITIONER_ID"));
			DB_patient_class = checkForNull(rs.getString("PATIENT_CLASS"));
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		pstmt = con.prepareStatement("SELECT EVENT_STATUS FROM CA_ENCNTR_NOTE WHERE CONTR_MOD_ACCESSION_NUM=?");
		pstmt.setString(1,contr_mod_accession_num);
		rs=pstmt.executeQuery();
		while(rs.next()){
			note_event_status = checkForNull(rs.getString("EVENT_STATUS"));
		}

		sent_out_date = cur_date; //Initially before recording, sent_out_date is defaulted to sysdate. 

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		pstmt=con.prepareStatement("SELECT SEND_FROM_FACILITY_ID, SEND_FROM_LOCATION, SEND_PRACTITIONER_ID, PERFORMING_LOCATION, TO_CHAR(SENT_OUT_DATE,'DD/MM/YYYY HH24:MI') SENT_OUT_DATE, SENT_TO, SENDOUT_YN FROM OH_RESTORATIVE_CHART_TASKS WHERE PATIENT_ID = ? AND CHART_NUM = ? AND CHART_LINE_NUM = ? AND TRMT_CODE = ? AND TASK_CODE = ? AND TASK_SEQ = ?");
		pstmt.setString(1,patient_id);				
		pstmt.setString(2,chart_num);				
		pstmt.setString(3,chart_line_num);				
		pstmt.setString(4,trmt_code);				
		pstmt.setString(5,task_code);				
		pstmt.setString(6,task_seq_no);
		rs=pstmt.executeQuery();
		
		while(rs!=null && rs.next()){
			send_from_facility_id=checkForNull(rs.getString("SEND_FROM_FACILITY_ID"));
			send_from_location=checkForNull(rs.getString("SEND_FROM_LOCATION"));
			send_practitioner_id=checkForNull(rs.getString("SEND_PRACTITIONER_ID"));
			performing_location=checkForNull(rs.getString("PERFORMING_LOCATION"));
			//sent_out_date=checkForNull(rs.getString("SENT_OUT_DATE"));
			sent_out_date=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("SENT_OUT_DATE"),"DMYHM","en",locale));
			sent_to=checkForNull(rs.getString("SENT_TO"));
			sendout_yn=checkForNull(rs.getString("SENDOUT_YN"));


			/*
			if(send_from_facility_id.equals("")){
				send_from_facility_id = facility_id;
			}


			if(send_from_location.equals("")){
				send_from_location = location_code;
			}*/

			if(send_practitioner_id.equals("")&& !sendout_yn.equals("N") && !sendout_yn.equals("Y")){
				//send_practitioner_id = ca_practitioner_id;
				send_practitioner_id = DB_practitioner_id;
			}
			
			if(sent_out_date.equals("") && !sendout_yn.equals("N") && !sendout_yn.equals("Y")){
				//sent_out_date = cur_date;
			}
		}

		//out.println("sendout_yn:=="+sendout_yn);
		//out.println("task_seq_no:=="+task_seq_no);

		if(sendout_yn.equals("Y")){
			disable_all = "disabled";
			readonly_all = "readonly";
			sendout_checked = "checked";
		}
		//Added by Sharon Crasta on 3/31/2010 for IN018302
		else if(baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")) { 
			disable_all = "disabled";
			readonly_all = "readonly";
		}//End
		else{
			disable_all = "";
			sendout_checked = "";
		}

		//out.println("send_practitioner_id:==="+send_practitioner_id);
		//out.println("location_code:==="+location_code);
		//out.println("facility_id:==="+facility_id);

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

<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="setSendoutDefaultValues();CurrTime()">
<!-- <body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" > -->

	<form name="OHTrmtSendOut" id="OHTrmtSendOut" action="../../servlet/eOH.OHTrmtSendOutAckServlet" method="post" target="messageFrame">
		<table width="100%" cellpadding =4 cellspacing=0>
			<tr>
				<td width="25%" class='ITEMSELECT' nowrap colspan='6'><fmt:message key="eOH.SentFromDetails.Label" bundle="${oh_labels}"/></td>
			</tr>
			<!-- <tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<select name="sendout_facility" id="sendout_facility" <%=disable_all%> DB_VALUE=<%=send_from_facility_id%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("SELECT FACILITY_ID, FACILITY_NAME FROM SM_FACILITY ORDER BY FACILITY_NAME");
							rs=pstmt.executeQuery();
								
							while(rs.next()){
						%>
								<option value='<%=checkForNull(rs.getString("FACILITY_ID"))%>' ><%=checkForNull(rs.getString("FACILITY_NAME"))%></option>
						<%
							}
						%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<select name="sendout_location" id="sendout_location" <%=disable_all%> DB_VALUE=<%=send_from_location%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							pstmt=con.prepareStatement("SELECT CLINIC_CODE, SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID = ? ORDER BY SHORT_DESC");
							pstmt.setString(1,facility_id);
							rs=pstmt.executeQuery();
								
							while(rs.next()){
						%>
								<option value='<%=checkForNull(rs.getString("CLINIC_CODE"))%>'><%=checkForNull(rs.getString("SHORT_DESC"))%></option>
						<%
							}
						%>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr> -->
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<select name="sendout_parct" id="sendout_parct" <%=disable_all%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							/*if(DB_patient_class.equals("OP") || DB_patient_class.equals("EM")){
								pstmt=con.prepareStatement("SELECT A.PRACTITIONER_ID, B.PRACTITIONER_NAME FROM OP_PRACT_FOR_CLINIC A, AM_PRACTITIONER_LANG_VW B  WHERE A.FACILITY_ID = ? AND  A.CLINIC_CODE = ? AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = ?");
							}else if(DB_patient_class.equals("IP") || DB_patient_class.equals("DC")){
								pstmt=con.prepareStatement("SELECT A.PRACTITIONER_ID, B.PRACTITIONER_NAME FROM IP_NURSING_UNIT_FOR_PRACT A, AM_PRACTITIONER_LANG_VW B  WHERE A.FACILITY_ID = ? AND  A.NURSING_UNIT_CODE = ? AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = ?");
							}
							
							pstmt.setString(1,facility_id);
							pstmt.setString(2,location_code);
							pstmt.setString(3,locale);
							rs=pstmt.executeQuery();

							*/
							
							//pstmt=con.prepareStatement("SELECT A.PRACTITIONER_ID PRACTITIONER_ID ,B.PRACTITIONER_NAME PRACTITIONER_NAME FROM CA_PRACT_BY_LOCN A,AM_PRACTITIONER_LANG_VW B WHERE A.PRACTITIONER_ID = B.PRACTITIONER_ID AND LOCN_TYPE = NVL(?,LOCN_TYPE) AND LOCN_CODE =NVL(?,LOCN_CODE) AND FACILITY_ID=? AND B.LANGUAGE_ID = ? ORDER BY 2");
							if(DB_patient_class.equals("OP") || DB_patient_class.equals("EM")){
								pstmt=con.prepareStatement("SELECT A.PRACTITIONER_ID PRACTITIONER_ID ,B.PRACTITIONER_NAME PRACTITIONER_NAME FROM CA_PRACT_BY_LOCN A,AM_PRACTITIONER_LANG_VW B WHERE A.PRACTITIONER_ID = B.PRACTITIONER_ID AND LOCN_TYPE IN ('X','Z',NVL(?,LOCN_TYPE)) AND LOCN_CODE IN ('*ALLC','*ALLZ',NVL(?,LOCN_CODE)) AND FACILITY_ID=? AND B.LANGUAGE_ID = ? AND TRUNC(SYSDATE) BETWEEN TRUNC(EFF_FROM_DATE) AND NVL(TRUNC(EFF_TO_DATE),TRUNC(SYSDATE)) ORDER BY 2");
							}else if(DB_patient_class.equals("IP") || DB_patient_class.equals("DC")){
								pstmt=con.prepareStatement("SELECT A.PRACTITIONER_ID PRACTITIONER_ID ,B.PRACTITIONER_NAME PRACTITIONER_NAME FROM CA_PRACT_BY_LOCN A,AM_PRACTITIONER_LANG_VW B WHERE A.PRACTITIONER_ID = B.PRACTITIONER_ID AND LOCN_TYPE IN ('Y','Z',NVL(?,LOCN_TYPE)) AND LOCN_CODE IN ('*ALLW','*ALLZ',NVL(?,LOCN_CODE)) AND FACILITY_ID=? AND B.LANGUAGE_ID = ? AND TRUNC(SYSDATE) BETWEEN TRUNC(EFF_FROM_DATE) AND NVL(TRUNC(EFF_TO_DATE),TRUNC(SYSDATE)) ORDER BY 2");
							}
							
							pstmt.setString(1,location_type);
							pstmt.setString(2,location_code);
							pstmt.setString(3,facility_id);
							pstmt.setString(4,locale);
							rs=pstmt.executeQuery();
							
								
							while(rs.next()){
								db_practitioner_id = checkForNull(rs.getString("PRACTITIONER_ID"));
								if(db_practitioner_id.equals(send_practitioner_id)){
									pract_selected = "selected";
								}else{
									pract_selected = "";
								}
						%>		
								<option value='<%=checkForNull(rs.getString("PRACTITIONER_ID"))%>' <%=pract_selected%>><%=checkForNull(rs.getString("PRACTITIONER_NAME"))%></option>
						<%
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td width="25%" class='ITEMSELECT' nowrap colspan='6'><fmt:message key="eOH.SentToDetails.Label" bundle="${oh_labels}"/></td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td>
				<td width="25%"> 
					<!-- <input type="text" name="sendout_perm_loc" id="sendout_perm_loc" value='<%=performing_location%>' size="12" maxlength="12" <%=disable_all%>/> -->
					<select name="sendout_perm_loc" id="sendout_perm_loc" <%=disable_all%> DB_VALUE=<%=performing_location%>>
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							//pstmt=con.prepareStatement("SELECT EXT_LOC_CODE, EXT_LOC_DESC FROM OH_EXT_PERFORM_LOCATIONS WHERE EFF_STATUS = 'E'");
							pstmt=con.prepareStatement("SELECT EXT_LOC_CODE, EXT_LOC_DESC FROM OH_EXT_PERFORM_LOC_LANG_VW WHERE LANGUAGE_ID = ? AND EFF_STATUS = 'E'");//Added by SRidevi Joshi on 5/18/2010 for IN021464

							pstmt.setString(1,locale);
							rs=pstmt.executeQuery();
								
							while(rs.next()){
						%>
								<option value='<%=checkForNull(rs.getString("EXT_LOC_CODE"))%>'><%=checkForNull(rs.getString("EXT_LOC_DESC"))%></option>
						<%
							}
						%>
					</select>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.SentOut.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="checkbox" name="sendout_completed" id="sendout_completed" value='<%=sendout_yn%>' onclick="setSendoutAckValue('SendOut');" <%=disable_all%> <%=sendout_checked%>/>
				</td>
			</tr>
			<tr>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.SentToPersonnel.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<input type="text" name="sendout_personnel" id="sendout_personnel" value='<%=sent_to%>' <%=readonly_all%> maxlength='100'/>
				</td>
				<td width="25%" class='LABEL' nowrap><fmt:message key="eOH.SendOutDate.Label" bundle="${oh_labels}"/></td>
				<td width="25%"> 
					<!-- <input type="text" name="sendout_date" id="sendout_date" value="" size=10 onKeyPress = "NumberCheck(this);" onBlur='checkDateNotGraterThanSysDate(this)'> -->
					<!-- <input type="text" name="sendout_date" id="sendout_date" value="<%=sent_out_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='checkDateValidity(this);checkDateGreaterThanRegDate(this,"sendout");OHValidateDateTime(this);' <%=disable_all%>> -->
					
					<input type="text" name="sendout_date" id="sendout_date" value="<%=sent_out_date%>" size=12 onKeyPress = "NumberTimeCheck(this);" onBlur='checkDateTimeValidations(this,"sendout");' <%=disable_all%>>
					<input id="sendout_cal" type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return callCalender(this,'sendout_date');" <%=disable_all%> > 
				</td>
			</tr>
			<% if(!sendout_yn.equals("Y")){ %>
				<tr>
					<td width="25%" class='LABEL' nowrap ><a href="javascript:openClinicalNotes();" id="viewRecordNotes"><fmt:message key="eOH.LabDetails.Label" bundle="${oh_labels}"/></a></td>
				</tr>
			<% }else{ 
					if(!note_event_status.equals("")){	
			%>
						<tr>
							<td width="25%" class='LABEL' nowrap ><a href="javascript:openClinicalNotes();" id="viewRecordNotes"><fmt:message key="eOH.ViewLabDetails.Label" bundle="${oh_labels}"/></a></td>
						</tr>
			<%		} 
				}
			%>
			<tr>
				<td width="25%" colspan="6" class="button">
					<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onclick ="sendOutAction();" <%=disable_all%>>&nbsp;
					<input type="button" class="button" name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'  onclick="sendOutReset();" <%=disable_all%>>
				</td>
			</tr>
		</table>
		<input type = "hidden" name= "params" value = "<%=params%>">
		<input type = "hidden" name= "patient_id" value = "<%=patient_id%>">
		<input type = "hidden" name= "facility_id" value = "<%=facility_id%>">
		<input type = "hidden" name= "locale" value = "<%=locale%>">
		<input type = "hidden" name= "ca_practitioner_id" value = "<%=ca_practitioner_id%>">
		<input type = "hidden" name= "episode_id" value = "<%=episode_id%>">
		<input type = "hidden" name= "episode_type" value = "<%=episode_type%>">
		<input type = "hidden" name= "visit_id" value = "<%=visit_id%>">
		<input type = "hidden" name= "patient_class" value = "<%=patient_class%>">
		<input type = "hidden" name= "encounter_id" value = "<%=encounter_id%>">
		<input type = "hidden" name= "location_code" value = "<%=location_code%>">
		<input type = "hidden" name= "location_type" value = "<%=location_type%>">
		<input type = "hidden" name= "speciality_code" value = "<%=speciality_code%>">
		<input type = "hidden" name= "cur_date" value = "<%=cur_date%>">

		<input type = "hidden" name= "chart_level" value = "<%=chart_level%>">
		<input type = "hidden" name= "chart_num" value = "<%=chart_num%>">
		<input type = "hidden" name= "chart_line_num" value = "<%=chart_line_num%>">
		<input type = "hidden" name= "trmt_code" value = "<%=trmt_code%>">
		<input type = "hidden" name= "task_code" value = "<%=task_code%>">
		<input type = "hidden" name= "task_seq_no" value = "<%=task_seq_no%>">
		<input type = "hidden" name= "seq_no" value = "<%=seq_no%>">
		<input type = "hidden" name= "note_event_status" value = "<%=note_event_status%>">

		<input type = "hidden" name= "called_from" value = "sendOut">
		<input type = "hidden" name= "sent_practitioner_id_hid" value = "<%=send_practitioner_id%>">
		<input type = "hidden" name= "performing_location_hid" value = "<%=performing_location%>">
		<input type = "hidden" name= "sent_out_date_hid" value = "<%=sent_out_date%>">
		<input type = "hidden" name= "sent_to_hid" value = "<%=sent_to%>">
		<input type = "hidden" name= "sendout_yn_hid" value = "<%=sendout_yn%>">

		

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


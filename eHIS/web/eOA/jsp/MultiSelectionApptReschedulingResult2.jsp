<!--Created by Ashwini on 05-Apr-2024 for ML-MMOH-CRF-2060-->
<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.text.*,org.json.simple.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"> </script>
<script language="javascript" src="../../eOA/js/MultiSelectionApptRescheduling.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='JavaScript' src='../../eCommon/js/showModalDialog.js' ></script>

<%
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	Connection con = null;

	int init = 0;
	int selected_appt_cnt = 0;
	String classValue = "OAQRYEVEN";
	String workstation_id = "";
	String srl_no = "";
	String slot_slab_start_time = "";
	String slot_slab_end_time = "";
	String patient_id = "";
	String patient_name = "";
	String gender = "";
	String visit_type_desc = "";
	String reason_for_contact = "";
	String no_of_slots = "";
	String selected_appt = "";
	String from_srl_no = "";
	String total_to_srl_no = "";
	String available_total_slots = "";
	String available_first_visit_slots = "";
	String available_other_visit_slots = "";

	try {
		con = ConnectionManager.getConnection(request);

		String locale = (String) session.getAttribute("LOCALE");
		String fac_id = (String) session.getValue("facility_id");
		String curr_user_id = (String) session.getValue("login_user");

		JSONObject userJson = new JSONObject();
		JSONArray userListArr = new JSONArray();
		userJson = eSM.SMCommonBean.getUserSessionDetails(con,
				curr_user_id);
		userListArr = (JSONArray) userJson.get("userListArr");

		for (int j = 0; j < userListArr.size(); j++) {
			JSONObject jsonDtls = (JSONObject) userListArr.get(j);
			workstation_id = (String) jsonDtls.get("WORKSTATION");
		}
		if (workstation_id == null)
			workstation_id = "";
		if (workstation_id == "")
			workstation_id = "DFLTWSNO";

		String locn_type = request.getParameter("locn_type");
		if (locn_type == null)
			locn_type = "";

		String from_speciality = request
				.getParameter("from_speciality");
		if (from_speciality == null)
			from_speciality = "";

		String from_locn = request.getParameter("from_locn");
		if (from_locn == null)
			from_locn = "";

		String from_resc = request.getParameter("from_resc");
		if (from_resc == null)
			from_resc = "";

		String from_date = request.getParameter("from_date");
		if (from_date == null)
			from_date = "";

		String from_res_class = request.getParameter("from_res_class");
		if (from_res_class == null)
			from_res_class = "";

		String to_speciality = request.getParameter("to_speciality");
		if (to_speciality == null)
			to_speciality = "";

		String to_locn = request.getParameter("to_locn");
		if (to_locn == null)
			to_locn = "";

		String to_resc = request.getParameter("to_resc");
		if (to_resc == null)
			to_resc = "";

		String to_date = request.getParameter("to_date");
		if (to_date == null)
			to_date = "";

		String to_res_class = request.getParameter("to_res_class");
		if (to_res_class == null)
			to_res_class = "";

		String reason_code_revision = request
				.getParameter("reason_code_revision");
		if (reason_code_revision == null)
			reason_code_revision = "";

		String visit_limit_rule = request
				.getParameter("visit_limit_rule");
		if (visit_limit_rule == null)
			visit_limit_rule = "N";

		String from_selected_appt = request
				.getParameter("from_selected_appt");
		if (from_selected_appt == null)
			from_selected_appt = "";

		String selected_appt_arr[] = from_selected_appt.split("\\$");

		String from_serial_no = request.getParameter("from_serial_no");
		if (from_serial_no == null)
			from_serial_no = "";

		String from_serial_no_arr[] = from_serial_no.split("\\$");

		JSONObject CntjsonObj = getSlotsCount(con, fac_id, locn_type,
				to_locn, to_res_class, to_resc, to_date);

		String time_table_type = (String) CntjsonObj
				.get("time_table_type");
		String slot_appt_ctrl = (String) CntjsonObj
				.get("slot_appt_ctrl");
		String max_slots_per_day = (String) CntjsonObj
				.get("max_slots_per_day");
		String max_patients_per_day = (String) CntjsonObj
				.get("max_patients_per_day");
		String max_first_visits = (String) CntjsonObj
				.get("max_first_visits");
		String max_other_visits = (String) CntjsonObj
				.get("max_other_visits");
		String total_slots_booked = (String) CntjsonObj
				.get("total_slots_booked");
		String total_first_visit = (String) CntjsonObj
				.get("total_first_visit");
		String total_other_visits = (String) CntjsonObj
				.get("total_other_visits");
		String total_first_visits_blocked = (String) CntjsonObj
				.get("total_first_visits_blocked");
		String total_other_visits_blocked = (String) CntjsonObj
				.get("total_other_visits_blocked");

		if (time_table_type.equals("1") && slot_appt_ctrl.equals("P")) {
			total_slots_booked = String.valueOf(Integer
					.parseInt(total_first_visit)
					+ Integer.parseInt(total_other_visits)
					+ Integer.parseInt(total_first_visits_blocked)
					+ Integer.parseInt(total_other_visits_blocked));
		}

		total_first_visit = String.valueOf(Integer
				.parseInt(total_first_visit)
				+ Integer.parseInt(total_first_visits_blocked));
		total_other_visits = String.valueOf(Integer
				.parseInt(total_other_visits)
				+ Integer.parseInt(total_other_visits_blocked));

		if (time_table_type.equals("1") && slot_appt_ctrl.equals("S")) {
			available_total_slots = String.valueOf(Integer
					.parseInt(max_slots_per_day)
					- Integer.parseInt(total_slots_booked));
		} else {
			available_total_slots = String.valueOf(Integer
					.parseInt(max_patients_per_day)
					- Integer.parseInt(total_slots_booked));
		}

		available_first_visit_slots = String.valueOf(Integer
				.parseInt(max_first_visits)
				- Integer.parseInt(total_first_visit));
		available_other_visit_slots = String.valueOf(Integer
				.parseInt(max_other_visits)
				- Integer.parseInt(total_other_visits));
%>

</head>

<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>

<form name="MultiSelectionApptReschResult2Form" id="MultiSelectionApptReschResult2Form">

<%
	if (!visit_limit_rule.equals("N")) {
%>
<table border="2" width="40%" cellspacing='0' cellpadding='0' id='VstCnt'>
<tr>
<td class='label' align='middle' width='10%' nowrap>&nbsp;</td>
<td class='label' align='middle' width='10%' nowrap>
	<%
		if (time_table_type.equals("1")
						&& slot_appt_ctrl.equals("S")) {
	%>
		<b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/></b>
	<%
		} else {
	%>
		<b><fmt:message key="Common.patient.label" bundle="${common_labels}"/></b>
	<%
		}
	%>
</td>
<td class='label' align='middle' width='10%' nowrap><b><fmt:message key="Common.firstvisit.label" bundle="${common_labels}"/></b></td>
<td class='label' align='middle' width='10%' nowrap><b><fmt:message key="Common.othervisit.label" bundle="${common_labels}"/></b></td>
</tr>
<tr>
<td class='label' align='middle' width='10%' nowrap><b><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></b></td>
<td class='label' align='middle' width='10%' nowrap>
	<%
		if (time_table_type.equals("1")
						&& slot_appt_ctrl.equals("S")) {
	%>
		<b><%=max_slots_per_day%></b>
	<%
		} else {
	%>
		<b><%=max_patients_per_day%></b>
	<%
		}
	%>
</td>
<td class='label' align='middle' width='10%' nowrap><b><%=max_first_visits%>&nbsp;</b></td>
<td class='label' align='middle' width='10%' nowrap><b><%=max_other_visits%>&nbsp;</b></td>
</tr>
<tr>
<td class='label' align='middle' width='10%' nowrap><b><fmt:message key="Common.booked.label" bundle="${common_labels}"/></b></td>
<td class='label' align='middle' width='10%' nowrap><b><%=total_slots_booked%>&nbsp;</b></td>
<td class='label' align='middle' width='10%' nowrap><b><%=total_first_visit%>&nbsp;</b></td>
<td class='label' align='middle' width='10%' nowrap><b><%=total_other_visits%>&nbsp;</b></td>
</tr>
</table>
<%
	}
%>

<table border="1" width="100%" cellspacing='0' cellpadding='0' id='results2'>

<tr>
	<th class='COLUMNHEADER' ><div  id='head1' class='myClass'><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER'  ><div  id='head2' width='12%' class='myClass'><fmt:message key="Common.totime.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER' ><div  id='head3'  class='myClass'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER'  ><div  id='head4' width='12%' class='myClass'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></div></th>
	<th class='COLUMNHEADER' ><div  id='head5' class='myClass'><fmt:message key="Common.ReasonForContact.label" bundle="${common_labels}"/></div></th>
</tr>

<%
	JSONArray ArrJSONSch = new JSONArray();
		ArrJSONSch = getToSchedule(con, fac_id, locn_type, to_locn,
				to_res_class, to_resc, to_date);

		for (int i = 0; i < ArrJSONSch.size(); i++) {
			JSONObject jsonObjSch = (JSONObject) ArrJSONSch.get(i);

			srl_no = (String) jsonObjSch.get("srl_no");
			total_to_srl_no += srl_no + "$";
			slot_slab_start_time = (String) jsonObjSch
					.get("slot_slab_start_time");
			slot_slab_end_time = (String) jsonObjSch
					.get("slot_slab_end_time");

			if (!from_selected_appt.equals("")
					&& selected_appt_arr.length > init) {
				selected_appt = selected_appt_arr[i];
				from_srl_no = from_serial_no_arr[i];
				selected_appt_cnt++;
			} else {
				selected_appt = "";
				from_srl_no = "";
			}

			if (!selected_appt.equals("")) {
				JSONObject jsonObj = getApptDtls(con, locale, fac_id,
						selected_appt);

				patient_id = (String) jsonObj.get("patient_id");

				if (patient_id.equals("")) {
					patient_id = "";
				} else {
					patient_id = patient_id + ", ";
				}

				patient_name = (String) jsonObj.get("patient_name");
				gender = (String) jsonObj.get("gender");
				visit_type_desc = (String) jsonObj
						.get("visit_type_desc");
				reason_for_contact = (String) jsonObj
						.get("reason_for_contact");
				no_of_slots = (String) jsonObj.get("no_of_slots");
			} else {
				patient_id = "";
				patient_name = "";
				gender = "";
				visit_type_desc = "";
				reason_for_contact = "";
				no_of_slots = "";
			}
%>
	<tr>

		<td width="10%" nowrap class="<%=classValue%>"><%=srl_no%>&nbsp;&nbsp;<%=slot_slab_start_time%></td>

		<!--<td width="10%" nowrap class="<%=classValue%>"><%=slot_slab_start_time%></td>-->

		<td width="10%" nowrap class="<%=classValue%>"><%=slot_slab_end_time%></td>

		<%
			if (!patient_name.equals("")) {
		%>
		<td width='23%' nowrap class="<%=classValue%>"><%=patient_id%><%=patient_name%>,&nbsp;<%=gender%></td>
		<%
			} else {
		%>
		<td width='23%' class="<%=classValue%>">&nbsp;</td>
		<%
			}
		%>

		<%
			if (!visit_type_desc.equals("")) {
		%>
		<td width='13%' nowrap class="<%=classValue%>"><%=visit_type_desc%></td>
		<%
			} else {
		%>
		<td width='13%' class="<%=classValue%>">&nbsp;</td>
		<%
			}
		%>

		<%
			if (!reason_for_contact.equals("")) {
		%>
		<td width='23%' nowrap class="<%=classValue%>"><%=reason_for_contact%></td>
		<%
			} else {
		%>
		<td width='23%' class="<%=classValue%>">&nbsp;</td>
		<%
			}
		%>

		<input type='hidden' name='from_srl_no_<%=init%>' id='from_srl_no_<%=init%>' value='<%=from_srl_no%>'>
		<input type='hidden' name='to_srl_no_<%=init%>' id='to_srl_no_<%=init%>' value='<%=srl_no%>'>
		<input type='hidden' name='trf_from_time_<%=init%>' id='trf_from_time_<%=init%>' value='<%=slot_slab_start_time%>'>
		<input type='hidden' name='trf_to_time_<%=init%>' id='trf_to_time_<%=init%>' value='<%=slot_slab_end_time%>'>
		<input type='hidden' name='selected_appt_<%=init%>' id='selected_appt_<%=init%>' value='<%=selected_appt%>'>
		<input type='hidden' name='no_of_slots_<%=init%>' id='no_of_slots_<%=init%>' value='<%=no_of_slots%>'>

	</tr>
<%
	init++;
		}
%>
			<input type='hidden' name='time_table_type' id='time_table_type' value='<%=time_table_type%>'>
			<input type='hidden' name='selected_appt_cnt' id='selected_appt_cnt' value='<%=selected_appt_cnt%>'>
			<input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
			<input type='hidden' name='from_locn' id='from_locn' value='<%=from_locn%>'>
			<input type='hidden' name='from_resc' id='from_resc' value='<%=from_resc%>'>
			<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'>
			<input type='hidden' name='to_locn' id='to_locn' value='<%=to_locn%>'>
			<input type='hidden' name='to_resc' id='to_resc' value='<%=to_resc%>'>
			<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'>
			<input type='hidden' name='to_res_class' id='to_res_class' value='<%=to_res_class%>'>
			<input type='hidden' name='reason_code_revision' id='reason_code_revision' value='<%=reason_code_revision%>'>
			<input type='hidden' name='curr_user_id' id='curr_user_id' value='<%=curr_user_id%>'>
			<input type='hidden' name='workstation_id' id='workstation_id' value='<%=workstation_id%>'>
			<input type='hidden' name='available_total_slots' id='available_total_slots' value='<%=available_total_slots%>'>
			<input type='hidden' name='available_first_visit_slots' id='available_first_visit_slots' value='<%=available_first_visit_slots%>'>
			<input type='hidden' name='available_other_visit_slots' id='available_other_visit_slots' value='<%=available_other_visit_slots%>'>
			<input type='hidden' name='total_to_srl_no' id='total_to_srl_no' value='<%=total_to_srl_no%>'>
		</table>

</form>

<%
	} catch (Exception es) {
		es.printStackTrace();
	} finally {
		ConnectionManager.returnConnection(con, request);
	}
%>

</body>
</html>

<%!public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static JSONArray getToSchedule(Connection con, String fac_id,
			String locn_type, String to_locn, String to_res_class,
			String to_resc, String to_date) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONArray ArrJSONSch = new JSONArray();

		try {

			StringBuffer sql_label = new StringBuffer();

			sql_label
					.append("SELECT a.srl_no, TO_CHAR (a.slot_slab_start_time, 'hh24:mi') AS slot_slab_start_time, TO_CHAR (a.slot_slab_end_time, 'hh24:mi') AS slot_slab_end_time FROM oa_clinic_schedule_slot_slab a WHERE a.facility_id = ? AND a.care_locn_type_ind = ? AND a.clinic_code = ? AND a.resource_class = ? AND a.clinic_date = TO_DATE (?, 'dd/mm/yyyy')  AND a.pri_appt_ref_no is null AND ext_slot_yn is null AND schedule_status is null AND ");

			if (to_resc.equals("")) {
				sql_label.append("a.practitioner_id is null");
			} else {
				sql_label.append("a.practitioner_id = ?");
			}

			pstmt = con.prepareStatement(sql_label.toString());

			pstmt.setString(1, fac_id);
			pstmt.setString(2, locn_type);
			pstmt.setString(3, to_locn);
			pstmt.setString(4, to_res_class);
			pstmt.setString(5, to_date);

			if (!to_resc.equals("")) {
				pstmt.setString(6, to_resc);
			}

			rs = pstmt.executeQuery();

			while (rs != null && rs.next()) {

				JSONObject jsonObjSch = new JSONObject();

				String srl_no = rs.getString("srl_no") == null ? "" : rs
						.getString("srl_no");
				String slot_slab_start_time = rs
						.getString("slot_slab_start_time") == null ? "" : rs
						.getString("slot_slab_start_time");
				String slot_slab_end_time = rs.getString("slot_slab_end_time") == null ? ""
						: rs.getString("slot_slab_end_time");

				jsonObjSch.put("srl_no", srl_no);
				jsonObjSch.put("slot_slab_start_time", slot_slab_start_time);
				jsonObjSch.put("slot_slab_end_time", slot_slab_end_time);

				ArrJSONSch.add(jsonObjSch);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getToSchedule - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return ArrJSONSch;
	}

	public static JSONObject getApptDtls(Connection con, String locale,
			String fac_id, String selected_appt) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String patient_id = "";
		String patient_name = "";
		String gender = "";
		String visit_type_desc = "";
		String reason_for_contact = "";
		String no_of_slots = "";

		JSONObject jsonObj = new JSONObject();

		try {
			String sql = "SELECT patient_id, NVL (patient_name_loc_lang, patient_name) AS patient_name, DECODE (gender, 'M', 'Male', 'F', 'Female', 'U', 'Unknown' ) AS gender, (SELECT short_desc visit_type FROM op_visit_type_lang_vw WHERE visit_type_code = appt_type_code AND ROWNUM = 1) AS visit_type_desc, am_get_desc.am_contact_reason (contact_reason_code, ?, 1 ) AS reason_for_contact, NVL (no_of_slots, 0) no_of_slots FROM oa_appt WHERE appt_ref_no = ? AND facility_id = ?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, locale);
			pstmt.setString(2, selected_appt);
			pstmt.setString(3, fac_id);

			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {
				patient_id = rs.getString("patient_id") == null ? "" : rs
						.getString("patient_id");
				patient_name = rs.getString("patient_name") == null ? "" : rs
						.getString("patient_name");
				gender = rs.getString("gender") == null ? "" : rs
						.getString("gender");
				visit_type_desc = rs.getString("visit_type_desc") == null ? ""
						: rs.getString("visit_type_desc");
				reason_for_contact = rs.getString("reason_for_contact") == null ? ""
						: rs.getString("reason_for_contact");
				no_of_slots = rs.getString("no_of_slots") == null ? "" : rs
						.getString("no_of_slots");
			}

			jsonObj.put("patient_id", patient_id);
			jsonObj.put("patient_name", patient_name);
			jsonObj.put("gender", gender);
			jsonObj.put("visit_type_desc", visit_type_desc);
			jsonObj.put("reason_for_contact", reason_for_contact);
			jsonObj.put("no_of_slots", no_of_slots);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getApptDtls - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getSlotsCount(Connection con, String fac_id,
			String locn_type, String to_locn, String to_res_class,
			String to_resc, String to_date) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String time_table_type = "";
		String slot_appt_ctrl = "";
		String max_slots_per_day = "";
		String max_patients_per_day = "";
		String max_first_visits = "";
		String max_other_visits = "";
		String total_slots_booked = "";
		String total_first_visit = "";
		String total_other_visits = "";
		String total_first_visits_blocked = "";
		String total_other_visits_blocked = "";

		JSONObject jsonObj = new JSONObject();

		try {
			StringBuffer sql_label = new StringBuffer();

			sql_label
					.append("SELECT time_table_type, b.slot_appt_ctrl, NVL (max_slots_per_day, 0) max_slots_per_day, max_patients_per_day, NVL (max_first_visits, 0) AS max_first_visits, NVL (max_other_visits, 0) AS max_other_visits, NVL (total_slots_booked, 0) AS total_slots_booked, NVL (total_first_visit, 0 ) AS total_first_visit, NVL (total_follow_up, 0) + NVL (total_routine, 0) + NVL (total_series, 0) + NVL (total_consult, 0) + NVL (total_emergency, 0) total_other_visits, NVL (total_first_visits_blocked, 0) total_first_visits_blocked, NVL (total_other_visits_blocked, 0) total_other_visits_blocked FROM oa_clinic_schedule, oa_param b WHERE facility_id = ? AND care_locn_type_ind = ? AND clinic_code = ? AND resource_class = ? AND clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND ");

			if (to_resc.equals("")) {
				sql_label.append("practitioner_id is null");
			} else {
				sql_label.append("practitioner_id = ?");
			}

			pstmt = con.prepareStatement(sql_label.toString());

			pstmt.setString(1, fac_id);
			pstmt.setString(2, locn_type);
			pstmt.setString(3, to_locn);
			pstmt.setString(4, to_res_class);
			pstmt.setString(5, to_date);

			if (!to_resc.equals("")) {
				pstmt.setString(6, to_resc);
			}

			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {
				time_table_type = rs.getString("time_table_type") == null ? ""
						: rs.getString("time_table_type");
				slot_appt_ctrl = rs.getString("slot_appt_ctrl") == null ? ""
						: rs.getString("slot_appt_ctrl");
				max_slots_per_day = rs.getString("max_slots_per_day") == null ? ""
						: rs.getString("max_slots_per_day");
				max_patients_per_day = rs.getString("max_patients_per_day") == null ? ""
						: rs.getString("max_patients_per_day");
				max_first_visits = rs.getString("max_first_visits") == null ? ""
						: rs.getString("max_first_visits");
				max_other_visits = rs.getString("max_other_visits") == null ? ""
						: rs.getString("max_other_visits");
				total_slots_booked = rs.getString("total_slots_booked") == null ? ""
						: rs.getString("total_slots_booked");
				total_first_visit = rs.getString("total_first_visit") == null ? ""
						: rs.getString("total_first_visit");
				total_other_visits = rs.getString("total_other_visits") == null ? ""
						: rs.getString("total_other_visits");
				total_first_visits_blocked = rs
						.getString("total_first_visits_blocked") == null ? ""
						: rs.getString("total_first_visits_blocked");
				total_other_visits_blocked = rs
						.getString("total_other_visits_blocked") == null ? ""
						: rs.getString("total_other_visits_blocked");
			}

			jsonObj.put("time_table_type", time_table_type);
			jsonObj.put("slot_appt_ctrl", slot_appt_ctrl);
			jsonObj.put("max_slots_per_day", max_slots_per_day);
			jsonObj.put("max_patients_per_day", max_patients_per_day);
			jsonObj.put("max_first_visits", max_first_visits);
			jsonObj.put("max_other_visits", max_other_visits);
			jsonObj.put("total_slots_booked", total_slots_booked);
			jsonObj.put("total_first_visit", total_first_visit);
			jsonObj.put("total_other_visits", total_other_visits);
			jsonObj.put("total_first_visits_blocked",
					total_first_visits_blocked);
			jsonObj.put("total_other_visits_blocked",
					total_other_visits_blocked);

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
				System.err.println("Exception in getSlotsCount - "
						+ ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}%>
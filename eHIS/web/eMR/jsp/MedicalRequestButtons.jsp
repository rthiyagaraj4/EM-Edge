<!DOCTYPE html>
<%/*
MODULE			:	Medical Records..(MR)
Function Name	:	Medical Report
[Request/Prepare/Status/Forward/Receive/Deliver/Revise]
Created On		:	22 JULY 2004
*/%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,java.sql.PreparedStatement,eCommon.XSSRequestWrapper"%>
<%	
	request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	StringBuffer sqlBuff=new StringBuffer();
	Boolean isRejectReportApplicable = false; //  Added by Mujafar for ML-MMOH-CRF-0714
	//out.println("<script>alert(\""+request.getQueryString()+"\");</script>");
	String Facility_Id = (String) session.getValue("facility_id");

	String call_function = request.getParameter("call_function");
		if(call_function == null) call_function ="";
//out.println("<script>alert(\"call_function:"+call_function+"\");</script>");
	String called_from = request.getParameter("called_from");
		if(called_from == null) called_from ="";

	String patientId = request.getParameter("patientId");
		if(patientId == null) patientId ="";

	String request_id = request.getParameter("request_id");
		if(request_id == null) request_id =""; 
	// added by mujafar for ML-MMOH-CRF-0714 START		
	String req_status = request.getParameter("req_status");
		if(req_status == null) req_status ="";
		
	String request_status_des = request.getParameter("request_status_des");
		if(request_status_des == null) request_status_des ="";
	// END
		

	String patient_line			= "";
	String dischargeDateTime	= "";
	String attending_practitioner= "";	
	String accession_num		= "";
	String facility_name		= "";		
	String visit_adm_date		= "";
	String specialty_name		= "";
	String enc_ids				= "";
	String event_status			= "";
	String location_code	= "";
String specialty_code	= "";

	String disViewMedRep = ""; //Added by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396

	Boolean isDeliveredRepModifyAppl = false;//Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 

	Boolean isViewMedicalReportAppl = false;//Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331 
	Boolean isAcceptRequestByPractAppl = false; // added by mujafar for ML-MMOH-CRF-1315

try
{
	try
	{
		con = ConnectionManager.getConnection(request);
		isRejectReportApplicable =     eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //  Added by Mujafar for ML-MMOH-CRF-0714

		isDeliveredRepModifyAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","MODIFY_ISSUED_MEDICAL_REPORT"); //Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 

		isViewMedicalReportAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","VIEW_MED_REPORT"); //Added by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331
		isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ACCEPT_REJECT_BY_PRACT_APPL"); // added by mujafar for ML-MMOH-CRF-1315
		
		String encSql=" select ENCOUNTER_ID from MR_REPORT_REQUEST_DTL where REQUEST_ID = '"+request_id+"' and FACILITY_ID = '"+Facility_Id+"' and PATIENT_ID = '"+patientId+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(encSql);
		if (rs.next() && rs != null)
		{
			enc_ids = rs.getString("ENCOUNTER_ID");
			
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 1: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		sqlBuff.append("select a.event_status, a.accession_num from CA_ENCNTR_NOTE a ");
		sqlBuff.append(" where a.patient_id = ? and a.ACCESSION_NUM = ");
		sqlBuff.append("(select ACCESSION_NUM from MR_REPORT_REQUEST_HDR where ");
		sqlBuff.append("facility_id=? and patient_id =?");
		sqlBuff.append(" and REQUEST_ID = ?)");
		
		pstmt = con.prepareStatement(sqlBuff.toString());
		pstmt.setString(1,patientId);
		pstmt.setString(2,Facility_Id);
		pstmt.setString(3,patientId);
		pstmt.setString(4,request_id);
		rs	=pstmt.executeQuery();
		if (rs.next() && rs != null)
		{
			accession_num = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			event_status= rs.getString("EVENT_STATUS")==null?"":rs.getString("EVENT_STATUS");
		}
		
		//Added by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396
		if (accession_num == "")
		{
			disViewMedRep = "disabled";
		}else
		{
			disViewMedRep = "";
		}

		if(rs !=null) rs.close();
		if(pstmt !=null) pstmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 2: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String MainSql=" select AM_GET_DESC.AM_SERVICE(SERVICE_CODE,'"+localeName+"','2')  specialty_name,to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME, (select SHORT_NAME from am_practitioner where practitioner_id = ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner from CA_IP_ACTIVE_EPISODE_VW where facility_id = '"+Facility_Id+"' and episode_id = '"+enc_ids+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(MainSql);
		if (rs.next() && rs != null)
		{
			visit_adm_date	=	rs.getString("visit_adm_date");
			specialty_name	=	rs.getString("specialty_name");
			dischargeDateTime= rs.getString("discharge_date_time");
			attending_practitioner = rs.getString("attending_practitioner");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();

	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 4: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String facilitySql=" select facility_name, get_patient.get_line_detail('"+patientId+"','"+locale+"') patient_line from SM_FACILITY_PARAM where facility_id = '"+Facility_Id+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(facilitySql);
		if (rs.next() && rs != null)
		{
			facility_name	= rs.getString("FACILITY_NAME");
			patient_line	= rs.getString("patient_line");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();


	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 5: "+exp.toString());
		exp.printStackTrace();
	}

	try
	{
		String pr_sql=" select PAT_CURR_LOCN_CODE,SPECIALTY_CODE from PR_ENCOUNTER where  facility_id = '"+Facility_Id+"' and ENCOUNTER_ID = '"+enc_ids+"' and PATIENT_ID='"+patientId+"' ";

		stmt = con.createStatement();
		rs	=	stmt.executeQuery(pr_sql);
		if (rs.next() && rs != null)
		{
			location_code = rs.getString("PAT_CURR_LOCN_CODE")==null?"":rs.getString("PAT_CURR_LOCN_CODE");
			specialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		}
		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();


	}catch(Exception exp)
	{
		//out.println(" Err in tryCatch 6: "+exp.toString());
		exp.printStackTrace();
	}
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src="../js/MedRecRequestButtons.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
	async function showPrevDelReports()
	{
		var request_type	= "MR";
		var retVal			= new String();
		var dialogHeight	= "70vh";
		var dialogWidth		= "70vw";
		var dialogTop		= "72";
		var status			= "no";
		var center			= "";
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;

		retVal = await window.showModalDialog("../../eMR/jsp/ReportRequestQueryResult.jsp?title=PREV_DEL_REPORT&status_to_show=6&request_type=MR&PatientId="+document.record_form.patientId.value,arguments,features);
	}
	/*Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 Start*/
	async function ModifyDetails(){
		
		var retVal			= new String();
		var dialogHeight	= "12vh";
		var dialogWidth		= "35vw";
		var dialogTop		= "";
		var status			= "no";
		var center			= "";
		var arguments		= "";
		var features		= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		
		var deliveredDate = parent.DetailFrame.document.MedicalRecordReqForm.DeliveredDate.value;
		var requestId = parent.DetailFrame.document.MedicalRecordReqForm.request_id.value;
		var preparedPract = parent.DetailFrame.document.MedicalRecordReqForm.hdd_pract_code.value;
		var preparedDate = parent.DetailFrame.document.MedicalRecordReqForm.hdd_PrepareDate.value;
		var collectDate = parent.DetailFrame.document.MedicalRecordReqForm.hdd_CollectDate.value;
		var collectionMode = parent.DetailFrame.document.MedicalRecordReqForm.collectionMode.value;
		var facilityId = parent.DetailFrame.document.MedicalRecordReqForm.facility_id.value;
		var patientId = parent.DetailFrame.document.MedicalRecordReqForm.patientId.value;
		var revisedCollectDate = parent.DetailFrame.document.MedicalRecordReqForm.old_revised_collect_date.value;

		retVal = await window.showModalDialog("../../eMR/jsp/MedRecRequestModifyFrameset.jsp?request_type=MR&deliveredDate="+deliveredDate+"&facilityId="+facilityId+"&requestId="+requestId+"&preparedPract="+preparedPract+"&preparedDate="+preparedDate+"&collectDate="+collectDate+"&revisedCollectDate="+revisedCollectDate+"&collectionMode="+collectionMode+"&patientId="+patientId,arguments,features);

		if(retVal != null){
			parent.window.close();
		}

	}/*End*/
</script>
</head>
	<body onKeyDown='lockKey()'>
	<form name='record_form' id='record_form'>
		<table width='100%' cellpadding='0' cellspacing='0' border='0' width='100%'>
			<tr>
			<%	
				if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				{	
					if(called_from.equals("CA"))
					{	
					if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				%>				
						<td class=label width="25%">&nbsp;</td>
					<%	}}else{	
					if(!isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					%>
						<td class=label width="40%">&nbsp;</td>
					<%	}}	%>
				<%	if(called_from.equals("CA"))
					{
					if(isAcceptRequestByPractAppl){  // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					%>
					<td class="label" ><input type='button' name='Notes' id='Notes' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrepareMedicalReport.label","mr_labels")%>' class='button' onclick='openCAModal()'></td>
					
					<%}else{%>
						<td class="label" ><input type='button' name='Notes' id='Notes' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RecordNotes.label","mr_labels")%>' class='button' onclick='openCAModal()'></td>
					<%	}}	%>				
					
					<!--Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396-->
					<td class="label"  ><input type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")%>' class='button' onclick='printReport();' <%=disViewMedRep%> ></td>
			<%	}
				/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
				else if(!call_function.equals("DELIVER_MEDICAL_REPORT") && !call_function.equals("MEDICAL_REPORT_COMPLETED") && ((isViewMedicalReportAppl && !call_function.equals("RECEIVE_MEDICAL_REPORT")) || !isViewMedicalReportAppl)) 
				{	
					%>
					<td class=label width="50%">&nbsp;</td>
			<%	}	
				/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
				if(call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_COMPLETED") || (isViewMedicalReportAppl && call_function.equals("RECEIVE_MEDICAL_REPORT")))
				{	%>
					<!--Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396-->
					<td class='button' ><input type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ViewMedicalReport.label","mr_labels")%>' class='button' onclick='printReport();' <%=disViewMedRep%> ></td>
			<%	}	%>
	<%
			String disable="";
			int count_req=0;
			// added by mujafar for ML-MMOH-CRF-0714 START
			String disable_record="";
			if(isRejectReportApplicable && req_status.equals("98") && !request_status_des.equals("OVERDUE") && !called_from.equals("CA"))
					disable_record="disabled";
			// END
			StringBuffer sqlPr = new StringBuffer();
			sqlPr.append("SELECT  count(*) count  FROM mr_report_request_hdr where patient_id='"+patientId+"'  AND request_status='6' ");

			stmt = con.createStatement();
			rs	=	stmt.executeQuery(sqlPr.toString());
			
			 while(rs!=null && rs.next()){
				 
				 count_req=rs.getInt(1);
				 
			 }
				
				stmt.close();
				rs.close();
			
			if(count_req==0)
			disable="disabled";
	%>
			<td class='button'  align="right">
			<!--Added by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233 Start-->
			<% if(isDeliveredRepModifyAppl && call_function.equals("MEDICAL_REPORT_COMPLETED")){ %>
				<input type='button' name='modify' id='modify' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ModificationRequired.label","mr_labels")%>' class='button' onclick='ModifyDetails();' >
			<% } %><!--End-->
			
			<input type='button' name='showPrevDtls' id='showPrevDtls' <%=disable%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrevDelMedReport.label","mr_labels")%>' class='button' onclick='showPrevDelReports()'>
<%							
			/*Modified by Ashwini on 01-Apr-2019 for ML-MMOH-CRF-1331*/
			if(!call_function.equals("MEDICAL_REPORT_COMPLETED") && !call_function.equals("MEDICAL_REPORT_CANCELLED") && !(isViewMedicalReportAppl && called_from.equals("CA") && call_function.equals("RECEIVE_MEDICAL_REPORT")))
				{
					
					
			if(isAcceptRequestByPractAppl && (call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER") ))
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 
					
					String disable_record1="";
					if(!called_from.equals("CA")  ) 
						disable_record1 = "disabled";
					
				%>	
					<input type='button' name='savedraft' id='savedraft' id='savedraft' <%=disable_record1%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SaveAsDraft.label","mr_labels")%>' class='button' onclick='apply1();'> 
					
					<input type='button' name='search' id='search' <%=disable_record%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.SubmitMedicalReport.label","mr_labels")%>' class='button' onclick='apply();'> <!-- ADDED by mujafar for ML-MMOH-CRF-0714 -->
				<%}else{%>	
					<input type='button' name='search' id='search' <%=disable_record%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class='button' onclick='apply();'> <!-- ADDED by mujafar for ML-MMOH-CRF-0714 -->
					
				<%	}}	%>	

					<input type='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onclick='closeME();'></td>
			</tr>
		<input type="hidden" name="encounter_id" id="encounter_id"	value="<%=enc_ids%>">
		<input type="hidden" name="patient_line" id="patient_line"	value="<%=patient_line%>">
		<input type="hidden" name="facility_name" id="facility_name"	value="<%=facility_name%>">
		<input type="hidden" name="visit_adm_date" id="visit_adm_date"	value="<%=visit_adm_date%>">
		<input type="hidden" name="episode_type" id="episode_type"	value="I">
		<input type="hidden" name="dischargeDateTime" id="dischargeDateTime"	value="<%=dischargeDateTime%>">
		<input type="hidden" name="specialty_name" id="specialty_name"	value="<%=specialty_name%>">
		<input type="hidden" name="attending_practitioner" id="attending_practitioner" value="<%=attending_practitioner%>">
		<input type="hidden" name="request_id" id="request_id"	value="<%=request_id%>">
		<input type="hidden" name="patientId" id="patientId"	value="<%=patientId%>">
		<input type="hidden" name="accession_num" id="accession_num"	value="<%=accession_num%>">
		<input type="hidden" name="call_function" id="call_function"	value="<%=call_function%>">
		<input type="hidden" name="called_from" id="called_from"	value="<%=called_from%>">
		<input type="hidden" name="event_status" id="event_status"	value="<%=event_status%>">	
		<input type="hidden" name="specialty_code" id="specialty_code"	value="<%=specialty_code%>">
		<input type="hidden" name="location_code" id="location_code"	value="<%=location_code%>">
	</table>
		<%	
		if(called_from.equals("CA"))
		{
			/*Modified by Ashwini on 26-Feb-2020 for ML-MMOH-SCF-1396*/
			if(!accession_num.equals(""))
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
			}else
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
			}
		}
		else
		{
			if(!accession_num.equals("") && ( event_status.equals("4") ||event_status.equals("5")) )
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = false;</script>");
			}
			else
			{
				out.println("<script>if(document.forms[0].print)document.forms[0].print.disabled = true;</script>");
			}
		}
		%>					
	</form>
	</body>
</html>
<%	}catch(Exception e) 
	{	
		//out.println(e.toString());
		e.printStackTrace();
	}
    finally
    {
		 ConnectionManager.returnConnection(con,request);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>


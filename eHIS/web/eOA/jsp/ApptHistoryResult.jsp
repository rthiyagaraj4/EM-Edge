<!DOCTYPE html>
<!--Created by Ashwini on 25-May-2017 for ML-MMOH-CRF-0610-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src='../../eOA/js/OAAppointmentHistory.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		String facility_id		= checkForNull((String)session.getValue("facility_id"));
		String locale			= (String)session.getAttribute("LOCALE");
        
			
		try
		{
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			con		= ConnectionManager.getConnection(request);	

			Boolean isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			
			String class_val				= "QRYEVENSMALL";		
			String patient_id				= checkForNull(request.getParameter("patientid"));
			String speciality				= checkForNull(request.getParameter("speciality"));
			String frm_appt_date			= checkForNull(request.getParameter("from"));
			String to_appt_date				= checkForNull(request.getParameter("to"));
			String location_type			= checkForNull(request.getParameter("location_type"));
			String b_loc_val				= checkForNull(request.getParameter("loc_value"));
			String resourceType_1			= checkForNull(request.getParameter("resourceType_1"));
			String practitioner_name		= checkForNull(request.getParameter("practitioner"));
			String p_fm_service_code		= checkForNull(request.getParameter("frm_service_code"));
			String p_to_service_code		= checkForNull(request.getParameter("to_service_code"));
			String pat_id = "";
			String patient_name = "";
			String appt_ref_no = "";
			String app_date = "";
			String app_re_schedule = "";
			String app_cancel = "";
			String speciality1 = "";
			String location = "";
			String resources = "";
			String service = "";
			String status = "";
			String reason = "";
			String done_by = "";
			String action_date = "";
			String remarks = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			int currentPageNo 	= 1;
			int recordsPerPage 	= 14;
				
			if(request.getParameter("currentPageNo") != null)
				currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
		%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			
		<form name = 'ApptHistoryResultForm'  target="messageFrame">

			<%
					JSONObject json 	= new JSONObject();
					JSONArray ApptHisjsonArr = new JSONArray();
					json  = eOA.OACommonBean.getApptHistory(con, locale, patient_id, speciality, frm_appt_date, to_appt_date, location_type, b_loc_val, resourceType_1, practitioner_name, p_fm_service_code, p_to_service_code, facility_id,recordsPerPage,currentPageNo);

					int curPageNo		= 0;
					curPageNo		= (Integer) json.get("currentPageNo");
					
					int noOfRecords		= 0;
					noOfRecords		= (Integer) json.get("noOfRecords");
				
					int noOfPages		= 0;
					noOfPages		= (Integer) json.get("noOfPages");
				
					int prevPageNo	= curPageNo - 1;		
					int nextPageNo	= curPageNo + 1;
					

			if(noOfRecords == 0) {
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
			else{
			%>

			<table align='right'>
				<tr>
					<% if ( curPageNo > 1 ){ 
					%>
						<td align ='right' id='prev'><A HREF="../../eOA/jsp/ApptHistoryResult.jsp?patientid=<%=patient_id%>&speciality=<%=speciality%>&from=<%=frm_appt_date%>&to=<%=to_appt_date%>&location_type=<%=location_type%>&loc_value=<%=b_loc_val%>&resourceType_1=<%=resourceType_1%>&practitioner_name=<%=practitioner_name%>&frm_service_code=<%=p_fm_service_code%>&to_service_code=<%=p_to_service_code%>&facility_id=<%=facility_id%>&currentPageNo=<%=prevPageNo%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){
						%>
						<td align ='right' id='next'><A HREF="../../eOA/jsp/ApptHistoryResult.jsp?patientid=<%=patient_id%>&speciality=<%=speciality%>&from=<%=frm_appt_date%>&to=<%=to_appt_date%>&location_type=<%=location_type%>&loc_value=<%=b_loc_val%>&resourceType_1=<%=resourceType_1%>&practitioner_name=<%=practitioner_name%>&frm_service_code=<%=p_fm_service_code%>&to_service_code=<%=p_to_service_code%>&facility_id=<%=facility_id%>&currentPageNo=<%=nextPageNo%>"  text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
				</tr>
			</table>
			<br></br>
			<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' style='margin-left:5px;'>
				<tr>
					<td>		
						<tr>
							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
							
							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
							
							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/>&nbsp;</td>
							
							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.ApptDate/Time.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="eOA.ReScheduleDate/Time.label" bundle="${oa_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.Cancellation.label" bundle="${common_labels}"/> <fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;</td>
							
							<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
							<%if(isRemarksFieldAppl){%>
							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</td> 
							<%}%>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/>&nbsp;</td>

							<td width='20%' height="20" class="columnheadercenter" align='center' nowrap><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/>&nbsp;</td>
						</tr>		
					<%
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
				
										
						ApptHisjsonArr = (JSONArray)json.get("ApptHisjsonArr");
						for(int i = 0 ; i < ApptHisjsonArr.size() ; i++) 
						{
						JSONObject PatListObj	= (JSONObject)ApptHisjsonArr.get(i);
						pat_id					= (String) PatListObj.get("patient_id");
						patient_name			= (String) PatListObj.get("patient_name");
						appt_ref_no				= (String) PatListObj.get("appt_ref_no");
						app_date				= (String) PatListObj.get("app_date");
						app_re_schedule			= (String) PatListObj.get("app_re_schedule");
						app_cancel				= (String) PatListObj.get("app_cancel");
						speciality1				= (String) PatListObj.get("speciality");
						location				= (String) PatListObj.get("location");
						resources				= (String) PatListObj.get("resources");
						service					= (String) PatListObj.get("service");
						status					= (String) PatListObj.get("status");
						reason					= (String) PatListObj.get("reason");
						remarks					= (String) PatListObj.get("remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
						done_by					= (String) PatListObj.get("done_by");
						action_date				= (String) PatListObj.get("action_date");
						
					%>
						<tr>
							<td width='20%' nowrap class='<%=class_val%>'><%=pat_id%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=patient_name%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=appt_ref_no%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=app_date%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=app_re_schedule%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=app_cancel%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=speciality1%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=location%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=resources%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=service%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=status%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=reason%>&nbsp;</td>
							<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
							<%if(isRemarksFieldAppl){%>
							<td width='20%' nowrap class='<%=class_val%>'><%=remarks%>&nbsp;</td> 
							<%}%>
							<td width='20%' nowrap class='<%=class_val%>'><%=done_by%>&nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=action_date%>&nbsp;</td>
							
						</tr>
						<%}%>
					</td>
				</tr>
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>
				<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
				<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>
			    <input type="hidden" name="p_patient_id" id="p_patient_id"   value=""></input>
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"></input>

			</table>
			<%
			}
			%>	
	</form>
</body>
		<%
				
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}	
		%>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>


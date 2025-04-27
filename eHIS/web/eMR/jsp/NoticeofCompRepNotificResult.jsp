<!DOCTYPE html>
<!--Created by Ashwini on 04-Oct-2017 for ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src="../js/NoticeofCompRepNotific.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		String facility_id				= checkForNull((String)session.getValue("facility_id"));
		String locale					= checkForNull((String)session.getValue("LOCALE"));
		String function_id				= checkForNull(request.getParameter("function_id"));
		String p_user_name				= checkForNull((String)session.getValue("login_user")) ;
        String p_module_id				= "MR" ;
        String p_report_id				= "" ;

		if(function_id.equals("NOTICE_OF_COMPLTD_REP_NOTIFIC"))
		{p_report_id= "MRNOCRNO" ;}
		else if(function_id.equals("CONFIRM_POST_RECEIPT_MED_REP"))
		{p_report_id= "MRCOPRMR" ;}
		else if(function_id.equals("MEDICAL_REPORT_APP"))
		{p_report_id= "MRAPPLIC" ;}
		else if(function_id.equals("PREPARE_MEDICAL_REPORT"))
		{p_report_id= "MRBOBBDO" ;}
		//Added by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722
		else if(("REFUND_LETTER").equals(function_id))
		{p_report_id= "MRRDUBLP" ;}

		try
		{
			con		= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			String class_val				= "QRYEVENSMALL";		
			String recv_mrd					= checkForNull(request.getParameter("recvMrd"));
			String p_fm_Date				= checkForNull(request.getParameter("from"));
			String p_to_Date				= checkForNull(request.getParameter("to"));
			String req_id					= checkForNull(request.getParameter("reqId"));
			String patient_id				= checkForNull(request.getParameter("patientid"));
			String request_id = "";
			String request_date = "";
			String pat_id = "";
			String patient_name = "";
			String gender = "";
			String practitioner_name = "";
			String collect_date = "";
			String request_status = "";
			int tot_amount		= 0;////Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368
			int currentPageNo 	= 1;
				
			if(request.getParameter("currentPageNo") != null)
				currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
		%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			
		<form name = 'NoticeCompRepNotificResultForm'  target="messageFrame">

			<%
					JSONObject json 	= new JSONObject();
					JSONArray compltdRepjsonArr = new JSONArray();
					json  = eMR.MRCommonBean.getCompltdRepDetails(con, locale, function_id, recv_mrd, p_fm_Date, p_to_Date, req_id, patient_id, facility_id, currentPageNo);	

					int curPageNo		= 0;
					curPageNo		= (Integer) json.get("currentPageNo");
					
					int noOfRecords		= 0;
					noOfRecords		= (Integer) json.get("noOfRecords");
				
					int noOfPages		= 0;
					noOfPages		= (Integer) json.get("noOfPages");
				
					int prevPageNo	= curPageNo - 1;		
					int nextPageNo	= curPageNo + 1;
					

			if(noOfRecords == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
			else{
			%>

			<table align='right'>
				<tr>
					<% if ( curPageNo > 1 ){ 
					%>
						<td align ='right' id='prev'><A HREF="../../eMR/jsp/NoticeofCompRepNotificResult.jsp?recvMrd=<%=recv_mrd%>&from=<%=p_fm_Date%>&to=<%=p_to_Date%>&reqId=<%=req_id%>&patientid=<%=patient_id%>&facility_id=<%=facility_id%>&currentPageNo=<%=prevPageNo%>&function_id=<%=function_id%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){
						%>
						<td align ='right' id='next'><A HREF="../../eMR/jsp/NoticeofCompRepNotificResult.jsp?recvMrd=<%=recv_mrd%>&from=<%=p_fm_Date%>&to=<%=p_to_Date%>&reqId=<%=req_id%>&patientid=<%=patient_id%>&facility_id=<%=facility_id%>&currentPageNo=<%=nextPageNo%>&function_id=<%=function_id%>" text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
				</tr>
			</table>
			<br></br>
			<table cellspacing='0' cellpadding='0' align='center' width='100%' border='1' style='margin-left:5px;'>
				<tr>
					<td>		
						<tr>
							<th width='10%' height="20" class="columnheadercenter" align="left" nowrap><fmt:message key="eMR.RequestID.label" bundle="${mr_labels}"/>&nbsp;</th>
							<th width='10%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.RequestDate.label" bundle="${common_labels}"/>&nbsp;</th>
							<th width='10%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</th>
							<th width='20%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</th>
							<th width='10%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</th>
							<th width='15%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;</th>
							<!--Added by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722-->
							<% if(!("REFUND_LETTER").equals(function_id)) { %>
							<th width='15%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="eMR.CollectDate.label" bundle="${mr_labels}"/>&nbsp;</th>
							<% } %>
							<th width='20%' height="20" class="columnheadercenter" align='left' nowrap><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/>&nbsp;</th>
						</tr>		
					<%
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
				
										
						compltdRepjsonArr = (JSONArray)json.get("compltdRepArray");
						for(int i = 0 ; i < compltdRepjsonArr.size() ; i++) 
						{
						JSONObject compltdRepObj	= (JSONObject)compltdRepjsonArr.get(i);
						request_id					= (String) compltdRepObj.get("request_id");
						request_date				= (String) compltdRepObj.get("request_date");
						pat_id						= (String) compltdRepObj.get("patient_id");
						patient_name				= (String) compltdRepObj.get("patient_name");
						gender						= (String) compltdRepObj.get("gender");
						practitioner_name			= (String) compltdRepObj.get("practitioner_name");
						collect_date				= (String) compltdRepObj.get("collect_date");
						request_status				= (String) compltdRepObj.get("request_status");
						tot_amount					= (Integer) compltdRepObj.get("tot_amount"); //Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368
					%>
						<tr>
						<!-- tot_amount Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368 -->
							<td width='10%' nowrap class='<%=class_val%>'><a href="javascript:showReport('<%=request_id%>','<%=pat_id%>','<%=tot_amount%>')"><%=request_id%> &nbsp;</td>
							<td width='10%' nowrap class='<%=class_val%>'><%=request_date%> &nbsp;</td>
							<td width='10%' nowrap class='<%=class_val%>'><%=pat_id%> &nbsp;</td>
							<td width='20%' nowrap class='<%=class_val%>'><%=patient_name%> &nbsp;</td>
							<td width='10%' nowrap class='<%=class_val%>'><%=gender%> &nbsp;</td>
							<td width='15%' nowrap class='<%=class_val%>'><%=practitioner_name%> &nbsp;</td>
							<!--Added by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722-->
							<% if(!("REFUND_LETTER").equals(function_id)) { %>
							<td width='15%' nowrap class='<%=class_val%>'><%=collect_date%> &nbsp;</td>
							<% } %>
							<td width='20%' nowrap class='<%=class_val%>'><%=request_status%> &nbsp;</td>
						</tr>
						<%}%>
					</td>
				</tr>

				<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
				<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>
				<input type='hidden' name='p_recv_mrd' id='p_recv_mrd' value ="<%=recv_mrd%>"></input>
				<input type='hidden' name='p_fm_date' id='p_fm_date' value ="<%=p_fm_Date%>"></input>
				<input type='hidden' name='p_to_date' id='p_to_date' value ="<%=p_to_Date%>"></input>
				<%if(("MRRDUBLP").equals(p_report_id)){%>
				<input type='hidden' name='p_request_id' id='p_request_id' value =""></input>
				<%}else{%>
				<input type='hidden' name='p_req_id' id='p_req_id' value =""></input>
				<%}%>
				<input type="hidden" name="p_patient_id" id="p_patient_id" value=""></input>
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"></input>
				<input type='hidden' name='p_language_id' id='p_language_id' value ="<%=locale%>"></input>
			    <input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id%>"></input>
				<input type='hidden' name='p_function_id' id='p_function_id' value= "<%=function_id%>">
			    <input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>"></input>
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name%>">

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


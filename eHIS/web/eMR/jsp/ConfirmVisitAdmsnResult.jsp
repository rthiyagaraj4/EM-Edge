<!DOCTYPE html>
<!--Created by Ashwini on 05-May-2017 for ML-MMOH-CRF-0698-->
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src="../js/ConfirmVisitAdmsn.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%
		Connection con = null;
		String locale					= (String)session.getAttribute("LOCALE");
		String facility_id				= checkForNull((String)session.getValue("facility_id"));
        String p_module_id				= "MR" ;
        String p_report_id				= "MRSPKKH" ;
			
		try
		{
			con		= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			String class_val				= "QRYEVENSMALL";		
			String patient_id				= checkForNull(request.getParameter("patientid"));
			String enc_type					= checkForNull(request.getParameter("encounType"));
			String frm_enc_date				= checkForNull(request.getParameter("from"));
			String to_enc_date				= checkForNull(request.getParameter("to"));
			String pat_id = "";
			String patient_name = "";
			String gender = "";
			int currentPageNo 	= 1;
			boolean isMRRepRefApplYN = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REP_REF_NO_APPL_YN"); //	Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365
			if(request.getParameter("currentPageNo") != null)
				currentPageNo = Integer.parseInt(request.getParameter("currentPageNo"));
		%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
			
		<form name = 'ConfirmVisitAdmsnResultForm'  target="messageFrame">

			<%
					JSONObject json 	= new JSONObject();
					JSONArray patDetailjsonArr = new JSONArray();
					json  = eMR.MRCommonBean.getPatientDetails(con,patient_id,facility_id, enc_type, frm_enc_date, to_enc_date,currentPageNo);	

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
						<td align ='right' id='prev'><A HREF="../../eMR/jsp/ConfirmVisitAdmsnResult.jsp?patientid=<%=patient_id%>&encounType=<%=enc_type%>&from=<%=frm_enc_date%>&to=<%=to_enc_date%>&facility_id=<%=facility_id%>&currentPageNo=<%=prevPageNo%>" text-decoration='none' onclick="fnSetvalue('P');" ><fmt:message key="Common.previous.label" bundle="${common_labels}" /></A></td>
					<%}
					if ( curPageNo >=1 && curPageNo != noOfPages ){
						%>
						<td align ='right' id='next'><A HREF="../../eMR/jsp/ConfirmVisitAdmsnResult.jsp?patientid=<%=patient_id%>&encounType=<%=enc_type%>&from=<%=frm_enc_date%>&to=<%=to_enc_date%>&facility_id=<%=facility_id%>&currentPageNo=<%=nextPageNo%>"  text-decoration='none' onclick="fnSetvalue('N');"><fmt:message key="Common.next.label" bundle="${common_labels}"/></A></td>
					<%}%>
				</tr>
			</table>
			<br></br>
			<table cellspacing='0' cellpadding='0' align='center' width='98%' border='1' style='margin-left:5px;'>
				<tr>
					<td>		
						<tr>
							<td width='20%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='40%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='10%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
							<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start -->
							<%if(isMRRepRefApplYN){ %>
							<td width='15%' height="20" class="COLUMNHEADERCENTER" align='center' nowrap><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/>&nbsp;</td><!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 -->
							<%} %>
							<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End-->
						</tr>		
					<%
						if(class_val.equals("QRYEVENSMALL"))
								class_val = "QRYODDSMALL";
						else
								class_val = "QRYEVENSMALL";
				
										
						patDetailjsonArr = (JSONArray)json.get("patDtlArray");
						for(int i = 0 ; i < patDetailjsonArr.size() ; i++) 
						{
						JSONObject PatListObj	= (JSONObject)patDetailjsonArr.get(i);
						pat_id					= (String) PatListObj.get("patient_id");
						patient_name			= (String) PatListObj.get("patient_name");
						gender					= (String) PatListObj.get("gender");	
					%>
						<tr>
							<td width='20%' nowrap class='<%=class_val%>'><a href="javascript:showReport('<%=pat_id%>','<%=i%>')"><%=pat_id%></td>
							<td width='40%' nowrap class='<%=class_val%>'><%=patient_name%></td>
							<td width='10%' nowrap class='<%=class_val%>'><%=gender%></td>
							<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 Start-->
							<%if(isMRRepRefApplYN){ %>
							<td width='15%' nowrap class='<%=class_val%>'><input type='text' name='ref_dtls_<%=i%>' id='ref_dtls_<%=i%>' value='' maxlength="30" size="40" onKeyup="return ChangeUpperCase(this);" onblur = "ChangeUpperCase(this);"/></td>
							<%}%>
							<!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 End-->  
						</tr>
						<%}%>
					</td>
				</tr>

				<input type='hidden' name='isPrevClicked' id='isPrevClicked' value = ""></input>
				<input type='hidden' name='isNextClicked' id='isNextClicked' value = ""></input>
				<input type='hidden' name='P_patient_class' id='P_patient_class' value ="<%=enc_type%>"></input>
				<input type='hidden' name='p_fr_adm_visit_date' id='p_fr_adm_visit_date' value ="<%=frm_enc_date%>"></input>
				<input type='hidden' name='p_to_adm_visit_date' id='p_to_adm_visit_date' value ="<%=to_enc_date%>"></input>
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>"></input>
			    <input type="hidden" name="p_module_id" id="p_module_id"   value="<%=p_module_id%>"></input>
			    <input type="hidden" name="p_report_id" id="p_report_id"   value="<%=p_report_id%>"></input>
			    <input type="hidden" name="p_patient_id" id="p_patient_id"   value=""></input>
			    <input type="hidden" name="p_reference_no" id="p_reference_no"   value=""></input><!-- Added By Dharma on 29/11/2019 against  ML-MMOH-CRF-1365 -->

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


<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<% 
	try{
		request.setCharacterEncoding("UTF-8");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String reqFromDate = request.getParameter("reqFromDate")==null?"N":request.getParameter("reqFromDate");
		String reqToDate = request.getParameter("reqToDate")==null?"":request.getParameter("reqToDate");
		String drugName = request.getParameter("drugName")==null?"":request.getParameter("drugName");
		String drugCode = request.getParameter("drugCode")==null?"":request.getParameter("drugCode");
		String req_pract_id = request.getParameter("req_pract_id")==null?"":request.getParameter("req_pract_id");
		String reqStatus = request.getParameter("reqStatus")==null?"":request.getParameter("reqStatus");
		String facility_id			= (String)session.getValue("facility_id");
		SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= dtSystemFormat.format(date_time); 
		String locale = (String) session.getAttribute("LOCALE");
		String bean_id					= "@NPBRequestApproveRejectBean";
		String bean_name				= "ePH.NPBRequestApproveRejectBean";
		NPBRequestApproveRejectBean bean			= (NPBRequestApproveRejectBean)getBeanObject(bean_id,bean_name,request);
		bean.clear();
		bean.setLanguageId(locale);
		//if condition newly added by manickam
		if(!(locale.equals("en"))){
			reqFromDate = com.ehis.util.DateUtils.convertDate(reqFromDate,"DMY",locale,"en");
			reqToDate = com.ehis.util.DateUtils.convertDate(reqToDate,"DMY",locale,"en");
		}	
		ArrayList NPBFormList = bean.getNPBRequestList(patient_id, req_pract_id, drugName,drugCode, reqStatus, reqFromDate,reqToDate);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/NPBRequestApproveReject.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'>
		<form name='NPBRequestQueryResult' id='NPBRequestQueryResult'>
<%
			if(NPBFormList==null || NPBFormList.size()==0){
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
			}
			else{
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='1'>
					<TR>
						<th width='8%'><fmt:message key="ePH.NPBForm.label" bundle="${ph_labels}"/></th>
						<th width='8%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
						<th width='14%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
						<th width='15%'><fmt:message key="ePH.NBPDRUG.label" bundle="${ph_labels}"/></th>
						<th width='10%'><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
						<th width='7%'><fmt:message key="ePH.ReqQty.label" bundle="${ph_labels}"/></th>
						<th width='7%'><fmt:message key="ePH.ReqDate.label" bundle="${ph_labels}"/></th>
						<th width='5%'><fmt:message key="ePH.ReqStatus.label" bundle="${ph_labels}"/></th>
						<th width='7%'><fmt:message key="ePH.ReqPract.label" bundle="${ph_labels}"/></th>
						<th width='7%'><fmt:message key="ePH.ValidUpto.label" bundle="${ph_labels}"/></th>
						<th width='7%'><fmt:message key="Common.Approve.label" bundle="${common_labels}"/>/<fmt:message key="Common.Reject.label" bundle="${common_labels}"/></th>
						<th width='5%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
						<th width='5%'><fmt:message key="Common.Select.label" bundle="${common_labels}"/></th>
					</TR>
<%
					HashMap NPBRequestDtl = null;
					String 	request_no ="", request_facility_id="", request_pract_id="", request_date_time ="", request_status ="", request_drug_code ="", request_drug_name ="", request_form_id ="",request_form_content="" , request_can_date_time ="", request_can_by_id ="", request_can_reason ="", request_ack_date_time ="", request_ack_reason ="", request_ack_by_id="", request_rej_date_time="", request_rej_by_id ="", request_rej_reason ="", request_aprv_date_time ="", request_aprv_by_id ="", request_aprv_reason ="", request_quantity="", request_qty_uom_code ="", request_form_name ="", apr_pract_name="", ack_pract_name="", can_pract_name="", reject_pract_name="", request_pract_name="", classvalue="", patientDtl="", drug_validity_date="", approved_drug_code;

					for(int i=0; i<NPBFormList.size(); i++){
						NPBRequestDtl = (HashMap)NPBFormList.get(i);
						if(NPBRequestDtl!=null){
							request_no =	NPBRequestDtl.get("REQUEST_NO")==null?"":(String)NPBRequestDtl.get("REQUEST_NO");                                    
							patient_id =	NPBRequestDtl.get("PATIENT_ID")==null?"":(String)NPBRequestDtl.get("PATIENT_ID");                                    
							request_facility_id =	NPBRequestDtl.get("REQUEST_FACILITY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_FACILITY_ID");          
							request_pract_id =	NPBRequestDtl.get("REQUEST_PRACT_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_PRACT_ID");                    
							request_date_time =	NPBRequestDtl.get("REQUEST_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_DATE_TIME");                  
							request_status =	NPBRequestDtl.get("REQUEST_STATUS")==null?"":(String)NPBRequestDtl.get("REQUEST_STATUS");                        
							request_drug_code =	NPBRequestDtl.get("REQUEST_DRUG_CODE")==null?"":(String)NPBRequestDtl.get("REQUEST_DRUG_CODE");                  
							request_drug_name =	NPBRequestDtl.get("REQUEST_DRUG_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_DRUG_NAME");                  
							approved_drug_code =	NPBRequestDtl.get("APPROVED_DRUG_CODE")==null?"":(String)NPBRequestDtl.get("APPROVED_DRUG_CODE");                  
							request_form_id =	NPBRequestDtl.get("REQUEST_FORM_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_ID");                      
							request_form_content =	NPBRequestDtl.get("REQUEST_FORM_CONTENT")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_CONTENT");        
							drug_validity_date =	NPBRequestDtl.get("DRUG_VALIDITY_DATE")==null?"":(String)NPBRequestDtl.get("DRUG_VALIDITY_DATE");        
							//request_can_date_time =	NPBRequestDtl.get("REQUEST_CAN_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_DATE_TIME");      
							//request_can_by_id =	NPBRequestDtl.get("REQUEST_CAN_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_BY_ID");                  
							request_can_reason =	NPBRequestDtl.get("REQUEST_CAN_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_REASON");            
							//request_ack_date_time =	NPBRequestDtl.get("REQUEST_ACK_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_DATE_TIME");      
							request_ack_reason =	NPBRequestDtl.get("REQUEST_ACK_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_REASON");            
							//request_ack_by_id =	NPBRequestDtl.get("REQUEST_ACK_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_BY_ID");                  
							//request_rej_date_time =	NPBRequestDtl.get("REQUEST_REJ_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_DATE_TIME");      
							//request_rej_by_id =	NPBRequestDtl.get("REQUEST_REJ_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_BY_ID");                  
							request_rej_reason =	NPBRequestDtl.get("REQUEST_REJ_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_REASON");            
							//request_aprv_date_time =	NPBRequestDtl.get("REQUEST_APRV_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_DATE_TIME");
							//request_aprv_by_id =	NPBRequestDtl.get("REQUEST_APRV_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_BY_ID");            
							request_aprv_reason =	NPBRequestDtl.get("REQUEST_APRV_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_REASON");          
							request_quantity =	NPBRequestDtl.get("REQUEST_QUANTITY")==null?"":(String)NPBRequestDtl.get("REQUEST_QUANTITY");                    
							request_qty_uom_code =	NPBRequestDtl.get("REQUEST_QTY_UOM_CODE")==null?"":(String)NPBRequestDtl.get("REQUEST_QTY_UOM_CODE");        
							request_form_name =	NPBRequestDtl.get("REQUEST_FORM_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_NAME");                  
							request_pract_name =	NPBRequestDtl.get("REQUEST_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_PRACT_NAME");                  
							reject_pract_name =	NPBRequestDtl.get("REJECT_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("REJECT_PRACT_NAME");                  
							can_pract_name =	NPBRequestDtl.get("CAN_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("CAN_PRACT_NAME");                  
							ack_pract_name =	NPBRequestDtl.get("ACK_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("ACK_PRACT_NAME");                  
							apr_pract_name =	NPBRequestDtl.get("APR_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("APR_PRACT_NAME");                  
							patientDtl =	NPBRequestDtl.get("PATIENT_DTL")==null?"":(String)NPBRequestDtl.get("PATIENT_DTL");   
							if(request_drug_code.equals("")){
								request_drug_code = approved_drug_code;
							}
							if ( i % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
%>
							<tr >
								<td nowrap class='<%=classvalue%>'><a  href="javascript:openNPBFormPreview('<%=i%>');" id="NPBPreviewLink<%=i%>"  style="font-size:9;" ><%=request_form_name%></a>&nbsp;</td>
								<td nowrap class='<%=classvalue%>'><%=patient_id%>&nbsp;</td>
								<td nowrap class='<%=classvalue%>'><%=patientDtl%>&nbsp;</td>
								<td nowrap class='<%=classvalue%>' name='RequestDrugName_<%=i%>' id='RequestDrugName_<%=i%>'><%=request_drug_name%>&nbsp;</td>
								<td nowrap class='<%=classvalue%>'>
<%
								if((request_status.equals("R") || request_status.equals("A") )&&request_drug_code.equals("")){
%>
									<input type='text' name="request_drug_code_<%=i%>" id="request_drug_code_<%=i%>" value="<%=request_drug_code%>" readonly>
									<input type="button" name="DrugSearch<%=i%>" id="DrugSearch<%=i%>" value="?" class="button"  onClick="searchDrugNameCLP('<%=i%>');" ><img src="../../eCommon/images/mandatory.gif" name='reqDrugCodeMand_<%=i%>' id='reqDrugCodeMand_<%=i%>' style='visibility:hidden;'  align="center">
<%
								}
								else{
%>
									<input type='hidden' name="request_drug_code_<%=i%>" id="request_drug_code_<%=i%>" value="<%=request_drug_code%>">
									<%=request_drug_code%>
									<img src="../../eCommon/images/mandatory.gif" id='reqDrugCodeMand_<%=i%>' style='display:none;'  align="center">
<%
								}
%>
								&nbsp;</td>
								<td nowrap class='<%=classvalue%>'><%=request_quantity%> &nbsp;<%=bean.getUomDisplay(facility_id,request_qty_uom_code)%></td>
								<td nowrap class='<%=classvalue%>'><%=request_date_time%> &nbsp;</td>
								<td nowrap class='<%=classvalue%>'>&nbsp;
<%
								if(request_status.equals("R")){
%>
									<fmt:message key="Common.Requested.label" bundle="${common_labels}"/> 
<%
								}
								else if(request_status.equals("C")){
%>
									<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> 
<%
								}
								else if(request_status.equals("A")){
%>
									<fmt:message key="ePH.Acknowledged.label" bundle="${ph_labels}"/> 
<%
								}
								else if(request_status.equals("J")){
%>
									<fmt:message key="Common.Rejected.label" bundle="${common_labels}"/> 
<%
								}
								else if(request_status.equals("P")){
%>
									<fmt:message key="Common.Approved.label" bundle="${common_labels}"/> 
<%
								}
%>
								&nbsp;</td>
								<td nowrap class='<%=classvalue%>'><%=request_pract_name%>&nbsp;</td>
								<td nowrap class='<%=classvalue%>'>
									<input type="text" maxlength="10" size="10" name="validityDate_<%=i%>" id="validityDate_<%=i%>" OnBlur='ValidateValidityDate(this, "<%=Sysdate%>","<%=locale%>")' value='<%=drug_validity_date%>'>
									<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar<%=i%>' onclick="return showCalendar('validityDate_<%=i%>');" >
									<img src="../../eCommon/images/mandatory.gif"  align="center"  name='validityDateMand_<%=i%>' id='validityDateMand_<%=i%>' style="visibility:hidden;"></td>
								<td nowrap class='<%=classvalue%>'>
									<select name='ReqAction_<%=i%>' id='ReqAction_<%=i%>' onchange='ActionChange("<%=i%>")'> 
										<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
								if(request_status.equals("R")){
%>
										<option value='A' ><fmt:message key="ePH.Acknowledge.label" bundle="${ph_labels}"/></option>
										<option value='P' ><fmt:message key="Common.Approve.label" bundle="${common_labels}"/></option>
										<option value='J' ><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
<%
								}
								else if(request_status.equals("A")){
%>
										<option value='P' ><fmt:message key="Common.Approve.label" bundle="${common_labels}"/></option>
										<option value='J' ><fmt:message key="Common.Reject.label" bundle="${common_labels}"/></option>
<%
								}
%>
									</select>&nbsp;<img  src="../../eCommon/images/mandatory.gif"  name='ReqActionMand_<%=i%>'id='ReqActionMand_<%=i%>' style='visibility:hidden;'></img>
								<td nowrap class='<%=classvalue%>'>
									<a  href="javascript:openNPBRemarks('<%=i%>');" id="remarks<%=i%>"  style="font-size:9;" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a> 
									<img src="../../eCommon/images/mandatory.gif"  align="center" name='remarksMand_<%=i%>'  id='remarksMand_<%=i%>' style="visibility:hidden;">&nbsp;
								</td>
								<td nowrap class='<%=classvalue%>'>
<%
								if(request_status.equals("R") || request_status.equals("A")){
%>
									<input type='checkbox' name='select_<%=i%>' id='select_<%=i%>' onclick='selectRec("<%=i%>");'/>
<%
								}
								else{
%>
									<input type='checkbox' name='select_<%=i%>' id='select_<%=i%>' disabled/>
<%
								}
%>
								</td>
							</tr>
							<input type='hidden' name="request_no_<%=i%>" id="request_no_<%=i%>" value="<%=request_no%>">
							<input type='hidden' name="request_status_<%=i%>" id="request_status_<%=i%>" value="<%=request_status%>">
							<input type='hidden' name="request_drug_name_<%=i%>" id="request_drug_name_<%=i%>" value="<%=request_drug_name%>">
							<input type='hidden' name="NPBReqFormId_<%=i%>" id="NPBReqFormId_<%=i%>" value="<%=request_form_id%>">
							<input type='hidden' name="request_form_name_<%=i%>" id="request_form_name_<%=i%>" value="<%=request_form_name%>">
							<input type='hidden' name="request_pract_name_<%=i%>" id="request_pract_name_<%=i%>" value="<%=request_pract_name%>">
							<input type='hidden' name="reject_pract_name_<%=i%>" id="reject_pract_name_<%=i%>" value="<%=reject_pract_name%>">
							<input type='hidden' name="can_pract_name_<%=i%>" id="can_pract_name_<%=i%>" value="<%=can_pract_name%>">
							<input type='hidden' name="ack_pract_name_<%=i%>" id="ack_pract_name_<%=i%>" value="<%=ack_pract_name%>">
							<input type='hidden' name="apr_pract_name_<%=i%>" id="apr_pract_name_<%=i%>" value="<%=apr_pract_name%>">
							<input type='hidden' name="request_date_time_<%=i%>" id="request_date_time_<%=i%>" value="<%=request_date_time%>">
							<input type='hidden' name="request_can_date_time_<%=i%>" id="request_can_date_time_<%=i%>" value="<%=request_can_date_time%>">
							<input type='hidden' name="request_rej_date_time_<%=i%>" id="request_rej_date_time_<%=i%>" value="<%=request_rej_date_time%>">
							<input type='hidden' name="request_aprv_date_time_<%=i%>" id="request_aprv_date_time_<%=i%>" value="<%=request_aprv_date_time%>">
							<input type='hidden' name="request_ack_date_time_<%=i%>" id="request_ack_date_time_<%=i%>" value="<%=request_ack_date_time%>">
							<input type='hidden' name="request_can_reason_<%=i%>" id="request_can_reason_<%=i%>" value="<%=java.net.URLEncoder.encode(request_can_reason,"UTF-8")%>">
							<input type='hidden' name="request_rej_reason_<%=i%>" id="request_rej_reason_<%=i%>" value="<%=java.net.URLEncoder.encode(request_rej_reason,"UTF-8")%>">
							<input type='hidden' name="request_ack_reason_<%=i%>" id="request_ack_reason_<%=i%>" value="<%=java.net.URLEncoder.encode(request_ack_reason,"UTF-8")%>">
							<input type='hidden' name="request_aprv_reason_<%=i%>" id="request_aprv_reason_<%=i%>" value="<%=java.net.URLEncoder.encode(request_aprv_reason,"UTF-8")%>">
							<input type='hidden' name="approved_drug_code_<%=i%>" id="approved_drug_code_<%=i%>" value="<%=request_drug_code%>">
							<textarea rows="0" cols="25" name="request_form_content_<%=i%>" style='display:none;'><%=request_form_content%></textarea>
<%
						}
					}
%>
				</table>
				<input type='hidden' name="mode" id="mode" value="2">
				<input type='hidden' name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type='hidden' name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type='hidden' name="totalRec" id="totalRec" value="<%=NPBFormList.size()%>">
				<input type='hidden' name="locale" id="locale" value="<%=locale%>">
<%
			}
%>
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html> 


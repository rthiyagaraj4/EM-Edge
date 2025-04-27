<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String reqFromDate = request.getParameter("reqFromDate")==null?"N":request.getParameter("reqFromDate");
		String reqToDate = request.getParameter("reqToDate")==null?"":request.getParameter("reqToDate");
		String drugName = request.getParameter("drugName")==null?"":request.getParameter("drugName");
		String drugCode = request.getParameter("drugCode")==null?"":request.getParameter("drugCode");
		String pract_id = request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String NPBReqFormId = request.getParameter("NPBReqFormId")==null?"":request.getParameter("NPBReqFormId");
		String reqStatus = request.getParameter("reqStatus")==null?"":request.getParameter("reqStatus");
		String facility_id			= (String)session.getValue("facility_id");
		SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy HH:MM");
		java.util.Date date_time	 	= new java.util.Date();
		String Sysdate 				= dtSystemFormat.format(date_time); 
		String locale = (String) session.getAttribute("LOCALE");
		String bean_id					= "@NPBRequestBean"+patient_id+encounter_id;
		String bean_name				= "ePH.NPBRequestBean";
		NPBRequestBean bean			= (NPBRequestBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
				//if condition newly added by manickam
		if(!(locale.equals("en"))){
			reqFromDate = com.ehis.util.DateUtils.convertDate(reqFromDate,"DMY",locale,"en");
			reqToDate = com.ehis.util.DateUtils.convertDate(reqToDate,"DMY",locale,"en");
		}
		ArrayList NPBFormList = bean.getNPBRequestList(patient_id, encounter_id, reqFromDate,reqToDate, drugName,drugCode, NPBReqFormId, reqStatus );
		ArrayList cancelReasonList = bean.loadCancelReason();
		String params = request.getQueryString();
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="JavaScript" src="../js/NPBRequest.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown = 'lockKey()'>
		<form name='NPBRequestList' id='NPBRequestList'>
<%
			if(NPBFormList==null || NPBFormList.size()==0){
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
			}
			else{
%>
			<br>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='1'>
					<TR>
						<th><fmt:message key="ePH.NPBForm.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="ePH.RequestPract.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="ePH.NBPDRUG.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="ePH.RequestedQty.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></th>
						<th><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></th>
					</TR>
<%
					HashMap NPBRequestDtl = null;
					String 	request_no ="", request_facility_id="", request_pract_id="", request_date_time ="", request_status ="", request_drug_code ="", request_drug_name ="", request_form_id ="",request_form_content="", request_can_date_time ="", request_can_by_id ="", request_can_reason ="", request_ack_date_time ="", request_ack_reason ="", request_ack_by_id="", request_rej_date_time="", request_rej_by_id ="", request_rej_reason ="", request_aprv_date_time ="", request_aprv_by_id ="", request_aprv_reason ="", request_quantity="", request_qty_uom_code ="", request_form_name ="", apr_pract_name="", ack_pract_name="", can_pract_name="", reject_pract_name="", request_pract_name="", classvalue="";
					for(int i=0; i<NPBFormList.size(); i++){
						NPBRequestDtl = (HashMap)NPBFormList.get(i);
						if(NPBRequestDtl!=null){
							request_no =	NPBRequestDtl.get("REQUEST_NO")==null?"":(String)NPBRequestDtl.get("REQUEST_NO");                                    
							request_facility_id =	NPBRequestDtl.get("REQUEST_FACILITY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_FACILITY_ID");          
							request_pract_id =	NPBRequestDtl.get("REQUEST_PRACT_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_PRACT_ID");                    
							request_date_time =	NPBRequestDtl.get("REQUEST_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_DATE_TIME");                  
							request_status =	NPBRequestDtl.get("REQUEST_STATUS")==null?"":(String)NPBRequestDtl.get("REQUEST_STATUS");                        
							request_drug_code =	NPBRequestDtl.get("REQUEST_DRUG_CODE")==null?"":(String)NPBRequestDtl.get("REQUEST_DRUG_CODE");                  
							request_drug_name =	NPBRequestDtl.get("REQUEST_DRUG_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_DRUG_NAME");                  
							request_form_id =	NPBRequestDtl.get("REQUEST_FORM_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_ID");                      
							request_form_content =	NPBRequestDtl.get("REQUEST_FORM_CONTENT")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_CONTENT");        
							request_can_date_time =	NPBRequestDtl.get("REQUEST_CAN_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_DATE_TIME");      
							request_can_by_id =	NPBRequestDtl.get("REQUEST_CAN_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_BY_ID");                  
							request_can_reason =	NPBRequestDtl.get("REQUEST_CAN_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_CAN_REASON");            
							request_ack_date_time =	NPBRequestDtl.get("REQUEST_ACK_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_DATE_TIME");      
							request_ack_reason =	NPBRequestDtl.get("REQUEST_ACK_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_REASON");            
							request_ack_by_id =	NPBRequestDtl.get("REQUEST_ACK_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_ACK_BY_ID");                  
							request_rej_date_time =	NPBRequestDtl.get("REQUEST_REJ_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_DATE_TIME");      
							request_rej_by_id =	NPBRequestDtl.get("REQUEST_REJ_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_BY_ID");                  
							request_rej_reason =	NPBRequestDtl.get("REQUEST_REJ_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_REJ_REASON");            
							request_aprv_date_time =	NPBRequestDtl.get("REQUEST_APRV_DATE_TIME")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_DATE_TIME");
							request_aprv_by_id =	NPBRequestDtl.get("REQUEST_APRV_BY_ID")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_BY_ID");            
							request_aprv_reason =	NPBRequestDtl.get("REQUEST_APRV_REASON")==null?"":(String)NPBRequestDtl.get("REQUEST_APRV_REASON");          
							request_quantity =	NPBRequestDtl.get("REQUEST_QUANTITY")==null?"":(String)NPBRequestDtl.get("REQUEST_QUANTITY");                    
							request_qty_uom_code =	NPBRequestDtl.get("REQUEST_QTY_UOM_CODE")==null?"":(String)NPBRequestDtl.get("REQUEST_QTY_UOM_CODE");        
							request_form_name =	NPBRequestDtl.get("REQUEST_FORM_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_FORM_NAME");                  
							request_pract_name =	NPBRequestDtl.get("REQUEST_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("REQUEST_PRACT_NAME");                  
							reject_pract_name =	NPBRequestDtl.get("REJECT_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("REJECT_PRACT_NAME");                  
							can_pract_name =	NPBRequestDtl.get("CAN_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("CAN_PRACT_NAME");                  
							ack_pract_name =	NPBRequestDtl.get("ACK_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("ACK_PRACT_NAME");                  
							apr_pract_name =	NPBRequestDtl.get("APR_PRACT_NAME")==null?"":(String)NPBRequestDtl.get("APR_PRACT_NAME");                  
							// addeded for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -start
							request_aprv_reason=java.net.URLEncoder.encode(request_aprv_reason,"UTF-8");
							//request_can_reason=java.net.URLEncoder.encode(request_can_reason,"UTF-8");
							request_ack_reason=java.net.URLEncoder.encode(request_ack_reason,"UTF-8");
							request_rej_reason=java.net.URLEncoder.encode(request_rej_reason,"UTF-8");
							// addeded for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -end
							if ( i % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
%>
							<tr >
								<td width='8%' nowrap class='<%=classvalue%>'>
									<a  href="javascript:openNPBAmend('<%=i%>');" id="NPBPreviewLink<%=i%>"  style="font-size:9;" ><%=request_form_name%></a>&nbsp;
									<textarea rows="0" cols="25" name="request_form_content_<%=i%>" style="display:none;"><%=request_form_content%></textarea>
								</td>
								<td width='8%' nowrap class='<%=classvalue%>'><%=request_date_time%>&nbsp;</td>
								<td width='15%' nowrap class='<%=classvalue%>'><%=request_pract_name%>&nbsp;</td>
								<td width='20%' nowrap class='<%=classvalue%>'> <%=request_drug_name%>&nbsp;</td>
								<td width='5%' nowrap class='<%=classvalue%>'><%=request_quantity%> &nbsp;</td>
								<td width='8%' nowrap class='<%=classvalue%>'><%=bean.getUomDisplay(facility_id,request_qty_uom_code)%> &nbsp;</td>
								<td width='8%' nowrap class='<%=classvalue%>'>&nbsp;
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
								</td>
								<td width='5%' nowrap class='label'>
<%
								if(request_status.equals("R")){
%>
									<input type='checkbox' name='cancelchk_<%=i%>' id='cancelchk_<%=i%>' onclick='selectCancel("<%=i%>");'/>
<%
								}
								else{
									if(request_status.equals("C") ){
%>
										<input type='checkbox' name='cancelchk_<%=i%>' id='cancelchk_<%=i%>' disabled checked/>
<%
									}
									else{
%>
										<input type='checkbox' name='cancelchk_<%=i%>' id='cancelchk_<%=i%>' disabled/>
<%
									}
								}
%>
								</td>
								<td width='10%' nowrap class='<%=classvalue%>'>
									<select name='cancelReason_<%=i%>' id='cancelReason_<%=i%>' disabled> 
										<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									if(cancelReasonList!=null && cancelReasonList.size()>0){
										for(int j=0; j < cancelReasonList.size(); j+=2){
											if(((String)cancelReasonList.get(j)).equals(request_can_reason)){
%>
												<option value='<%=(String)cancelReasonList.get(j)%>' selected ><%=(String)cancelReasonList.get(j+1)%></option>
<%
											}
											else{
%>
												<option value='<%=(String)cancelReasonList.get(j)%>' ><%=(String)cancelReasonList.get(j+1)%></option>
<%
											}
										}
									}
									else{
%>
<%
									}
%>
									</select>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
								</td>
								<td width='8%' nowrap class='<%=classvalue%>'><a  href="javascript:openOtherDetails('<%=i%>');" id="OtherDtlLink_<%=i%>"  style="font-size:9;" ><fmt:message key="Common.otherDetails.label" bundle="${common_labels}"/></a> &nbsp;</td>
							</tr>
							<input type='hidden' name="request_no_<%=i%>" id="request_no_<%=i%>" value="<%=request_no%>">
							<input type='hidden' name="request_status_<%=i%>" id="request_status_<%=i%>" value="<%=request_status%>">
							<input type='hidden' name="NPBReqFormId_<%=i%>" id="NPBReqFormId_<%=i%>" value="<%=request_form_id%>">
							<input type='hidden' name="changed_<%=i%>" id="changed_<%=i%>" value="N">
							<input type='hidden' name="formTXTchanged_<%=i%>" id="formTXTchanged_<%=i%>" value="N">
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
							<!-- added forML-BRU-SCF-0367 [IN:034747](3rd point) -start-->
							<input type='hidden' name="request_can_reason_<%=i%>" id="request_can_reason_<%=i%>" value="<%=request_can_reason%>">
							<input type='hidden' name="request_rej_reason_<%=i%>" id="request_rej_reason_<%=i%>" value="<%=request_rej_reason%>">
							<input type='hidden' name="request_ack_reason_<%=i%>" id="request_ack_reason_<%=i%>" value="<%=request_ack_reason%>">
							<input type='hidden' name="request_aprv_reason_<%=i%>" id="request_aprv_reason_<%=i%>" value="<%=request_aprv_reason%>">
							<!--	 addeded for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -end -->
<%
						}
					}
%>
				</table>
				<input type='hidden' name="mode" id="mode" value="2">
				<input type='hidden' name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type='hidden' name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>">
				<input type='hidden' name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
				<input type='hidden' name="pract_id" id="pract_id" value="<%=pract_id%>">
				<input type='hidden' name="totalRec" id="totalRec" value="<%=NPBFormList.size()%>">
				<script>
					parent.f_query_result_buttons.location.href = "../../ePH/jsp/NPBRequestButtons.jsp?<%= params %>"+"&calledFrom=NPBList";
				</script>
<%
			}
%>
		</form>
	</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html> 


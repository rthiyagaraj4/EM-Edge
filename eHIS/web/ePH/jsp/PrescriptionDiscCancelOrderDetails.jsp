<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8"); 
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends

		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<style>
			TD.COMPUNDRX{
				BACKGROUND-COLOR:#E4CAFF;
				FONT-SIZE: 8pt ;
				height:10;
				BORDER-STYLE: solid;
			}
		</style>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<title></title>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	try{
		String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String generic_id			=	request.getParameter("generic_id")==null?"":request.getParameter("generic_id");
		String called_frm			=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
		String patient_class		=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String order_date			=	request.getParameter("order_date")==null?"":request.getParameter("order_date");
		String from_date			=	request.getParameter("start_date")==null?"":request.getParameter("start_date");//Added for BRU-HIMS-CRF-403 
		String to_date				=	request.getParameter("end_date")==null?"":request.getParameter("end_date");//Added for BRU-HIMS-CRF-403 
		String call_from			=	request.getParameter("call_from")==null?"":request.getParameter("call_from");//Added for BRU-HIMS-CRF-403 
		String take_home_medication =   request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");//added take_home_medication for ML-BRU-SCF-1587 [IN:054876]
		String	start_date			=	"";
		String	end_date			=	"";
		String	drug_desc			=	"";
		String	practitioner_name	=	"";
		String	facility_name		=	"";
		String	location			=	"";
		String diag_text			=	"";
		String split_dose_prev		=	"";
		String order_id				=	"";
		String order_line_no		=	"";
		String freq_code			=	"";
		String freq_desc			=	"";
		String duplicate_reason		=	"";
		String allergy_reason		=	"";
		String dosage_reason		=	"";	
		String link					=	"";
		String discont_date_time	=	"";
		String perf_locn			=	"";
		String iv_prep_yn			=   "";
		String discharge_ind		=	"";
		String in_formulary_yn		=	"";
		String dosage				=	"";
		String dosage_uom			=	"";
		int order_status_type		=   0;
		String	drug_code			=   "";
		String	sliding_scale			=   "";  //added for Bru-HIMS-CRF-265 [IN:032315] 
		String	drug_view			=   "";
		String img_style="";   //added for Bru-HIMS-CRF-265 [IN:032315] 
		if(generic_id==null || generic_id.equals(""))	
			generic_id					=	"";
		else
			called_frm					=	"DUP";

		String	bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		String class_name			=	"";
		ArrayList active_orders		=	new ArrayList();		
		HashMap record				=	new HashMap();
		HashMap<String, ArrayList> hmGericIdBasedRecords = null;
		String pres_drug_code ="";

		PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request) ;
		ArrayList	presDetails 	= (ArrayList) bean.getpresDetails(); //added for HSA-CRF-0151 [IN:048468] -start
		String current_rx ="", currentrx_override="", tmp_generic_id="";
		StringBuilder sbGenericIds = new StringBuilder();
		HashMap drugDetails = null;
		int genericIdCount = 0, tot_rec_count=0, genericRecCount=0, genricIndex=0;
		for(int i=0;i<presDetails.size();i++){
			drugDetails=(HashMap) presDetails.get(i);
			current_rx			= drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");	
			currentrx_override	= drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
			tmp_generic_id	= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
			if(current_rx.equals("Y") || (!currentrx_override.equals("Y") || (call_from.equals("buttons") && generic_id.equals(tmp_generic_id)) || (take_home_medication.equals("Y")&&currentrx_override.equals("Y")))){//added take_home_medication condition for ML-BRU-SCF-1587 [IN:054876] // current_rx.equals("Y") && changed to current_rx.equals("Y") || for ML-MMOH-SCF-0317.1
				if(genericIdCount==0)
					sbGenericIds.append("'"+tmp_generic_id+"'");
				else
					sbGenericIds.append(", '"+tmp_generic_id+"'");
				genericIdCount++;
			}
		}
		String defSelect = bean.getCancelDiscConDupOrdersDefSelect();
		if(defSelect.equals("Y"))
			defSelect = "checked";
		else
			defSelect = ""; //added for HSA-CRF-0151 [IN:048468] -end
		int take_home	=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
		hmGericIdBasedRecords	=	bean.getPatientActiveOrdersForDC(patient_id,patient_class,order_date,take_home, sbGenericIds.toString(),from_date,to_date);//Added from_date,to_date for BRU-HIMS-CRF-403  //generic_id changed to sbGenericIds.toString() for HSA-CRF-0151 [IN:048468]
		bean.setCurrentActiveOrders(active_orders);
%>
		<form name="DiscCancelOrderDetailsForm" id="DiscCancelOrderDetailsForm" >
			<table id="dupDrugs" name="test" id="test" cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
				<tr >
					<th colspan='12' align="left" class="<%=class_name%>" style='color:blue'nowrap><B><fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></B></th>
				</tr>
				<tr><td colspan='12' >&nbsp;</td></tr>
				<tr>
					<th align="center" class="small" width="9%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="9%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="32%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="8%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="8%"><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></th>
					<th align="center" class="small" width="12%"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="12%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="10%"><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="12%"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="8%"><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></th>
					<th align="center" class="small" width="8%"><input type="checkbox" name='selectAll' id='selectAll' value="" onClick="selectAllRec(this);" <%=defSelect%>><fmt:message key="ePH.perform.label" bundle="${ph_labels}"/></th>
				</tr>
<%
				for (String key: hmGericIdBasedRecords.keySet()){ //added for HSA-CRF-0151 [IN:048468]
					genericIdCount = 0;
					for(int i=0;i<presDetails.size();i++){
						drugDetails=(HashMap) presDetails.get(i);
						tmp_generic_id	= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
						pres_drug_code	= drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
						if(tmp_generic_id.equals(key)){
							if(genericIdCount==0){
%>
								<tr><td colspan='12' >&nbsp;</td></tr>
								<tr>
									<td  colspan='11' class='label'  ><b><fmt:message key="Common.generic.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=tmp_generic_id%>&nbsp;&nbsp;-&nbsp;&nbsp;<%=drugDetails.get("GENERIC_NAME")==null?"":(String)drugDetails.get("GENERIC_NAME")%><b></td>
									<input type='hidden' name='genericId_<%=genricIndex%>' id='genericId_<%=genricIndex%>' value='<%=tmp_generic_id%>'>
									<td align="left" nowrap ><input type="checkbox" name='select_Gen_<%=key%>' id='select_Gen_<%=key%>' value="" onClick="selectGeneric(this, '<%=tmp_generic_id%>')" <%=defSelect%>>
									<fmt:message key="Common.selectall.label" bundle="${common_labels}"/></th>
								</tr>
<%
								genricIndex++;
							}
							start_date	=	CommonBean.checkForNull((String)drugDetails.get("START_DATE"));
							end_date	=	CommonBean.checkForNull((String)drugDetails.get("END_DATE"));
							drug_desc	=	CommonBean.checkForNull((String)drugDetails.get("DRUG_DESC"));
							genericIdCount++;
%>
							<tr>
								<th align="left" class="small" nowrap><%=start_date%>&nbsp;</th>
								<th align="left" class="small" nowrap><%=end_date%>&nbsp;</th>
								<th align="left" class="small" colspan='10'><%=drug_desc%></th>
							</tr>
							<tr></tr>
<%
							break;
						}
					} //added for HSA-CRF-0151 [IN:048468] -end
					active_orders = (ArrayList)hmGericIdBasedRecords.get(key);
					genericRecCount = active_orders.size(); //added for HSA-CRF-0151 [IN:048468]
					tot_rec_count+=genericRecCount; //added for HSA-CRF-0151 [IN:048468]
					for (int i=0; i<genericRecCount; i++) {
						if(i%2==0)
							class_name	=	"QRYEVENSMALL";
						else
							class_name	=	"QRYODDSMALL";

						record	=	(HashMap)	active_orders.get(i);
						start_date			=	CommonBean.checkForNull((String)record.get("start_date"));
						end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
						drug_desc			=	CommonBean.checkForNull((String) record.get("drug_desc"));
						practitioner_name	=	CommonBean.checkForNull((String) record.get("practitioner_name"));
						facility_name		=	CommonBean.checkForNull((String) record.get("facility_name"));
						location			=	CommonBean.checkForNull((String) record.get("location"));
						diag_text			=	CommonBean.checkForNull((String) record.get("diag_text"));
						split_dose_prev		=	CommonBean.checkForNull((String) record.get("split_dose_prev")); 
						order_id			=	CommonBean.checkForNull((String) record.get("order_id")); 
						order_line_no		=	CommonBean.checkForNull((String) record.get("order_line_no")); 
						freq_code			=	CommonBean.checkForNull((String) record.get("freq_code"));      
						freq_desc			=	CommonBean.checkForNull((String) record.get("freq_desc")); 
						allergy_reason		=	CommonBean.checkForNull((String) record.get("allergy_reason")); 
						dosage_reason		=	CommonBean.checkForNull((String) record.get("dosage_reason")); 
						duplicate_reason	=	CommonBean.checkForNull((String) record.get("duplicate_reason")); 
						perf_locn			=	CommonBean.checkForNull((String) record.get("perf_locn")); 
						iv_prep_yn			=   CommonBean.checkForNull((String) record.get("iv_prep_yn")); 
						discharge_ind		=   CommonBean.checkForNull((String) record.get("discharge_ind")); 
						in_formulary_yn		=	CommonBean.checkForNull((String) record.get("in_formulary_yn")); 
						dosage				=	CommonBean.checkForNull((String) record.get("dosage")); 
						dosage_uom			=	CommonBean.checkForNull((String) record.get("dosage_uom_desc")); 
						drug_code			=	CommonBean.checkForNull((String) record.get("drug_code")); 
						sliding_scale		=	CommonBean.checkForNull((String) record.get("sliding_scale"));   //added for Bru-HIMS-CRF-265 [IN:032315] 

						duplicate_reason = java.net.URLEncoder.encode(duplicate_reason);
						dosage_reason	 = java.net.URLEncoder.encode(dosage_reason);
						allergy_reason	 = java.net.URLEncoder.encode(allergy_reason);

						discont_date_time	=	(String) record.get("discont_date_time"); 
						order_status_type  = Integer.parseInt((String) record.get("order_status_type"));
						String discont_color="";
						drug_view		=	"onClick=\"callMenuFunctions('View','Pharmacy','"+patient_id+"','"+encounter_id+"','"+order_id+"','"+order_line_no+"','"+order_status_type+"','','PH','"+drug_code+"','"+generic_id+"')\"  style='cursor:pointer;color:blue'";
						if(discont_date_time!=null && !discont_date_time.equals("") ){
							discont_color = "red"; 
						}
									
						if(!allergy_reason.equals("") || !dosage_reason.equals("") || !duplicate_reason.equals("")) {
							link		=	"onClick=\"showReasons('"+allergy_reason+"','"+dosage_reason+"','"+duplicate_reason+"')\"  style='cursor:pointer;color:blue'";
							img_style="display:inline;cursor:pointer;";   //added for Bru-HIMS-CRF-265 [IN:032315] 
						}
						else {
							link		=	"";
							img_style = "display:none;";
						}

						StringTokenizer st		=	new StringTokenizer(diag_text,"~");
						boolean diag_text_found	=	false;
							while(st.hasMoreTokens()) {
							String txt	= (String)st.nextToken();
							if(!txt.equals("")) {
								diag_text_found	=	true;
								break;
							}
						}

						if(iv_prep_yn.equals("1")||iv_prep_yn.equals("2")||iv_prep_yn.equals("3")||iv_prep_yn.equals("4")||iv_prep_yn.equals("5")){
							if(order_line_no.equals("1")){
								class_name = "IVFLUID";
							}
							else{
								class_name		  = "IVINGREDIENT";
								/*practitioner_name = "&nbsp;";
								facility_name	  = "&nbsp;";
								location    = "&nbsp;";
								perf_locn	= "&nbsp;";
								freq_code	= "&nbsp;";	
								start_date  = "&nbsp;";
								end_date    = "&nbsp;";*/
							}
						}
						else if(iv_prep_yn.equals("6"))
							class_name		  = "COMPUNDRX";

						if(discharge_ind.equals("D"))
							class_name	= "DISCHARGEMED";

						if(in_formulary_yn.equals("N"))
							class_name	=	"FORMULARY";
%>
						<tr >
							<td align="left" class="<%=class_name%>" nowrap><%=start_date%>&nbsp;</td>
							<td align="left" class="<%=class_name%>" nowrap><%=end_date%>&nbsp;</td>
							<td align="left" class="<%=class_name%>" <%=drug_view%> ><label style="color:<%=discont_color%>"><%=drug_desc%>&nbsp;</label></td>
<%		
							if(split_dose_prev.equals("")) {		
%>
								<td align="left" class="<%=class_name%>" nowrap><%=dosage%>&nbsp;<%=dosage_uom%>&nbsp;</td>
								<td align="left" class="<%=class_name%>" ><img style="<%=img_style%>" <%=link%> src="../../ePH/images/DrugRemarks.gif" height='20' width='20' ></img>&nbsp;</td>
								<td align="left" class="<%=class_name%>" ><%=freq_desc%>&nbsp;</td>
<%			
							}
							else{	
%>
								<td align="left" class="<%=class_name%>" nowrap><%=dosage%>&nbsp;<%=dosage_uom%></td>
								<td align="left" class="<%=class_name%>" ><img style="<%=img_style%>" <%=link%> src="../../ePH/images/DrugRemarks.gif" height='20' width='20' ></img>&nbsp;</td>
								<td align="left" class="<%=class_name%>" ><label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=freq_desc%>','<%=start_date%>','<%=sliding_scale%>','<%=iv_prep_yn%>')" style="cursor:pointer;color:blue"><%=freq_desc%></label></td>
<%			
							}
%>
							<td align="left" class="<%=class_name%>" ><%=practitioner_name%></td>
							<td align="left" class="<%=class_name%>" ><%=location%></td>
							<td align="left" class="<%=class_name%>" ><%=perf_locn%></td>
							<td align="left" class="<%=class_name%>" ><%=facility_name%></td>
<%			
							if(diag_text_found) {
%>
								<td align="left" class="<%=class_name%>" style="cursor:pointer;color:blue"><label onClick="callDiagText('<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(diag_text)%>')">Details</label></td>
<%
							}
							else {
%>
								<td align="left" class="<%=class_name%>">&nbsp;</td>
<%
							}
							if(order_status_type >= 25){
%>
								<td  align="left" class="<%=class_name%>" nowrap>&nbsp;<input type="checkbox" name='select_<%=key%>_<%=i%>' id='select_<%=key%>_<%=i%>' value="" <%=defSelect%> onclick='checkSelectAll(this,"<%=key%>","<%=i%>");'><fmt:message key="Common.Discontinue.label" bundle="${common_labels}"/></td>
								<input type="hidden" name="performType_<%=key%>_<%=i%>" id="performType_<%=key%>_<%=i%>" value="D">
<%				
							}
							else if(order_status_type < 25){
%>
								<td  align="left" class="<%=class_name%>" nowrap>&nbsp;<input type="checkbox" name='select_<%=key%>_<%=i%>' id='select_<%=key%>_<%=i%>' <%=defSelect%> onclick='checkSelectAll(this, "<%=key%>","<%=i%>");'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></td>
								<input type="hidden" name="performType_<%=key%>_<%=i%>" id="performType_<%=key%>_<%=i%>" value="C">
<%						
							}
%>
							<td name="info">
							<input type="hidden" name="order_id_<%=key%>_<%=i%>" id="order_id_<%=key%>_<%=i%>" value="<%=order_id%>">
							<input type="hidden" name="pract_id_<%=key%>_<%=i%>" id="pract_id_<%=key%>_<%=i%>" value="<%=(String)session.getValue("ca_practitioner_id")%>">
							<input type="hidden" name="drug_code_<%=key%>_<%=i%>" id="drug_code_<%=key%>_<%=i%>" value="<%=drug_code%>">
							<input type="hidden" name="order_line_no_<%=key%>_<%=i%>" id="order_line_no_<%=key%>_<%=i%>" value="<%=order_line_no%>">
							<input type="hidden" name="pres_drug_code<%=key%>_<%=i%>" id="pres_drug_code<%=key%>_<%=i%>" value="<%=pres_drug_code%>">
							<input type="hidden" name="pres_generic_id<%=key%>_<%=i%>" id="pres_generic_id<%=key%>_<%=i%>" value="<%=tmp_generic_id%>"> <!--added for 54058-->
							</td>
						</tr>
<%
					}
%>
					<input type="hidden" name="genericRecCount_<%=key%>" id="genericRecCount_<%=key%>" value="<%=genericRecCount%>"> <!-- //added for HSA-CRF-0151 [IN:048468] -->
<%
				}
%>
			</table>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
				<tr><td colspan='3'>&nbsp;</td></tr>
				<tr><td colspan='3'>&nbsp;</td></tr>
				<tr>
					<td colspan="2" width='80%'>&nbsp;</td>
					<td width='20%'>
						<input type="button" name="cancel" id="cancel" value='<fmt:message key="ePH.DiscontinueCancelOrders.label" bundle="${ph_labels}"/>'  class="button" onClick="discCancValue('<%=patient_id%>','<%=patient_class%>','<%=order_date%>','<%=take_home%>','<%=generic_id%>','<%=encounter_id%>')">
					</td>	
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="pract_id" id="pract_id" value="<%=(String)session.getValue("ca_practitioner_id")%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="order_date" id="order_date" value="<%=order_date%>">
			<input type="hidden" name="take_home" id="take_home" value="<%=take_home%>">
			<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>">
			<input type="hidden" name="tot_rec_count" id="tot_rec_count" value="<%=tot_rec_count%>">
			<input type="hidden" name="genericIdsCount" id="genericIdsCount" value="<%=hmGericIdBasedRecords.size()%>"> <!--//added for HSA-CRF-0151 [IN:048468]-->
			<input type="hidden" name="clearDupYN" id="clearDupYN" value="N">
		
		</form>
<%
		putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
	</body>
</html>


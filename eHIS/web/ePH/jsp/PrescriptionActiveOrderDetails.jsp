<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<title><fmt:message key="ePH.CurrentMedication.label" bundle="${ph_labels}"/></title>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="activeOrderDetailsForm" id="activeOrderDetailsForm" >
<%
		String patient_id			=	request.getParameter("patient_id");
		String encounter_id			=	request.getParameter("encounter_id");
		String generic_id			=	request.getParameter("generic_id");
		String called_frm			=	request.getParameter("called_frm");
		String patient_class		=	request.getParameter("patient_class");
		String order_date			=	request.getParameter("order_date");	
		String called_from			=	CommonBean.checkForNull(request.getParameter("called_from"));//Added for Bru-HIMS-CRF-072.1[IN 049144]
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
		//String freq_code			=	"";
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
		String per_facility_name	=	"";
        String split_yn				=	"";
	    String sliding_scale_yn		=	"";
	    String dosage_string 		=	"";
		String split_freq_desc		=	"";
		String class_name_formulary	=	"";
		String class_name_discharge_ind	=	"";
		String style_name_compoumnd	=	"";
		String orig_order_line_no	=	"";
		String drug_code = "",issued_qty="",mediplancheck="disabled",checked="",alternate="",order_uom="",qty_issue="",qty_issuelocal="";//Added for Bru-HIMS-CRF-072.1[IN 049144]
		int i=0;//Added for Bru-HIMS-CRF-072.1[IN 049144]
		boolean isSameOrder = false;
		
		if(called_frm==null)	called_frm					=	"";
		if(patient_class==null)	patient_class				=	"";
		if(order_date==null)	order_date					=	"";
		if(generic_id==null || generic_id.equals(""))	
			generic_id					=	"";
		else
			called_frm					=	"DUP";

		String	bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name			= "ePH.PrescriptionBean_1";
		String facility_id			= (String) session.getValue("facility_id");
		String class_name			= "";
		ArrayList active_orders		= new ArrayList();		

		PrescriptionBean_1 bean = (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);// Added for Bru-HIMS-CRF-072.1[IN 049144] start
		bean.setObject(all_bean);
		MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( "MedicationPlannerBean", "ePH.MedicationPlannerBean",request); 
		bean.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144] end
		int take_home				 =	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));

		if(called_frm.equals("PH")){
			active_orders	=	bean.getPatientActiveOrders(patient_id,patient_class,order_date,take_home,called_from);//called_from Added for Bru-HIMS-CRF-072.1[IN 049144]
		}
		else if(called_frm.equals("DUP")){
			active_orders	=	bean.getDuplicateDrugs(patient_id,generic_id);
		}
		else if(called_frm.equals("OT")){
			active_orders	=	bean.getPatientActiveOrdersForOT(patient_id,patient_class,take_home);
		}
		else{
			active_orders	=	bean.getActiveOrders();
		}
%>
		<table cellpadding=0 cellspacing=0 width="130%" align="center" border="1">
			<tr>
<%
			if(called_from.equals("MediPlan")) {
%><!--Added for Bru-HIMS-CRF-072.1[IN 049144]-->
				<th  class="small" width="2%">&nbsp;</th>
<%
			}
 %>
			<th  class="small" width="2%">&nbsp&nbsp&nbsp</th>
			<th  class="small" width="2%">&nbsp&nbsp&nbsp</th>
			<th  class="small" width="2%">&nbsp&nbsp&nbsp</th>
			<th  class="small" width="13%"><fmt:message  key="Common.StartDate.label" bundle="${common_labels}"/></th>
			<th  class="small" width="13%"><fmt:message  key="Common.enddate.label" bundle="${common_labels}"/></th>
			<th  class="small" width="40%"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
			<th  class="small" width="8%"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/></th>
			<th  class="small" width="12%"nowrap><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></th>
			<th  class="small" width="12%"><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></th>
			<th  class="small" width="10%"><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></th>
			<th  class="small" width="10%" nowrap><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></th>
			<th  class="small" width="15%" nowrap><fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></th>
			<th  class="small" width="8%"><fmt:message  key="Common.diagnosis.label" bundle="${common_labels}"/></th>
			<th  class="small" width="20%"><fmt:message  key="Common.PerformingFacility.label" bundle="${common_labels}"/></th>
	</tr>
<% 
		if(active_orders!=null && active_orders.size()!=0){
		for (i=0; i<active_orders.size(); i++) {

			if(i%2==0)
				class_name				=	"QRYEVENSMALL";
			else
				class_name				=	"QRYODDSMALL";
			class_name_formulary		=	"";
			class_name_discharge_ind	=	"";
			style_name_compoumnd		=	"";
			HashMap record	=	(HashMap)	active_orders.get(i);
			start_date			=	CommonBean.checkForNull((String)record.get("start_date"));
			end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
			drug_desc			=	CommonBean.checkForNull((String) record.get("drug_desc"));
//			strength			=	CommonBean.checkForNull((String) record.get("strength"));
//			strength_uom_desc	=	CommonBean.checkForNull((String) 			record.get("strength_uom_desc"));
//			form_desc			=	CommonBean.checkForNull((String) record.get("form_desc"));
			practitioner_name	=	CommonBean.checkForNull((String) record.get("practitioner_name"));
			facility_name		=	CommonBean.checkForNull((String) record.get("facility_name"));
			location			=	CommonBean.checkForNull((String) record.get("location"));
			diag_text			=	CommonBean.checkForNull((String) record.get("diag_text"));
			split_dose_prev		=	CommonBean.checkForNull((String) record.get("split_dose_prev")); 
			order_id			=	CommonBean.checkForNull((String) record.get("order_id")); 
			order_line_no		=	CommonBean.checkForNull((String) record.get("order_line_no")); 
			//freq_code			=	CommonBean.checkForNull((String) record.get("freq_code"));      
			freq_desc			=	CommonBean.checkForNull((String) record.get("freq_desc")); 
			allergy_reason		=	CommonBean.checkForNull((String) record.get("allergy_reason")); 
			dosage_reason		=	CommonBean.checkForNull((String) record.get("dosage_reason")); 
			duplicate_reason	=	CommonBean.checkForNull((String) record.get("duplicate_reason")); 
			perf_locn			=	CommonBean.checkForNull((String) record.get("perf_locn")); 
			iv_prep_yn			=   CommonBean.checkForNull((String) record.get("iv_prep_yn")); 
			discharge_ind		=   CommonBean.checkForNull((String) record.get("discharge_ind")); 
			in_formulary_yn		=	CommonBean.checkForNull((String) record.get("in_formulary_yn")); 
			dosage				=	CommonBean.checkForNull((String) record.get("dosage")); 
			dosage_uom			=	CommonBean.checkForNull((String) record.get("dosage_uom_code")); 
			per_facility_name	=	CommonBean.checkForNull((String) record.get("per_facility_name"));
			discont_date_time	=	(String) record.get("discont_date_time");
			
			split_yn		=	CommonBean.checkForNull((String) record.get("split_yn"),"N"); 
			sliding_scale_yn	=	CommonBean.checkForNull((String) record.get("sliding_scale_yn"),"N"); 
			
			if(sliding_scale_yn.equals("Y"))
				dosage_string = "<b>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.SlidingScale.label", "common_labels")+" </b>" ;
			else
				dosage_string = dosage +"  "+ CommonBean.checkForNull(bean.getUomDisplay(facility_id,dosage_uom));

			if(split_yn.equals("Y"))
				split_freq_desc  = "<b>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels")+"</b>";
			else
				split_freq_desc  = freq_desc;
			String discont_color=	"";

			//if(discont_date_time !=null
			//Handled space for discont_date_time regardng incident num:25773 ==By Sandhya
			if(discont_date_time!=null && !(discont_date_time.equals(""))){

				
				discont_color = "red"; 
			}
			allergy_reason = java.net.URLEncoder.encode(allergy_reason,"UTF-8")	;								
			dosage_reason = java.net.URLEncoder.encode(dosage_reason,"UTF-8")	;								
			duplicate_reason = java.net.URLEncoder.encode(duplicate_reason,"UTF-8")	;								
			if(!allergy_reason.equals("") || !dosage_reason.equals("") || !duplicate_reason.equals("")) {
				link		=	"onClick=\"showReasons('"+allergy_reason+"','"+dosage_reason+"','"+duplicate_reason+"')\"  style='cursor:pointer;color:blue'";
			}
			else {
				link		=	"";
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
				}else{
					class_name			= "IVINGREDIENT";
					practitioner_name	= "&nbsp;";
					facility_name		= "&nbsp;";
					location			= "&nbsp;";
					perf_locn			= "&nbsp;";
					//freq_code			= "&nbsp;";	
				}
			}				
			if(in_formulary_yn.equals("N"))
				class_name_formulary	= "FORMULARY";
			if(discharge_ind.equals("D"))
				class_name_discharge_ind= "DISCHARGEMED";
			if(iv_prep_yn.equals("6"))
			{
				style_name_compoumnd	= "background-color:#E4CAFF";
				if(!order_line_no.equals("1"))
				{
					dosage_string="&nbsp;";				
					split_freq_desc="&nbsp;";	
				}
			}
         orig_order_line_no =order_line_no;

			if(iv_prep_yn != null && !(iv_prep_yn.equals(""))){ // && condition added for IN23638 --03/09/2010-- priya
				order_line_no = "1";
			}
%>
			<tr > <!--Added for Bru-HIMS-CRF-072.1[IN 049144] start-->
<%
			if(called_from.equals("MediPlan")) {
				drug_code			=	CommonBean.checkForNull((String) record.get("drug_code"));	
				issued_qty			=	CommonBean.checkForNull((String) record.get("issued_qty"),"0");	
				alternate			=	CommonBean.checkForNull((String) record.get("alternates"));
				order_uom			=	CommonBean.checkForNull((String) record.get("order_uom"));
				if(alternate.equals("Y")){// If alternate drug is dispensed, qty issue is empty.User has to enter value
					qty_issue		="";qty_issuelocal="";
				}
				else {
					qty_issue 			= issued_qty +"  "+ CommonBean.checkForNull(medplan_bean.getUOMDesc(order_uom,medplan_bean.getStrPrimaryLangID()));
					qty_issuelocal 		= issued_qty +"  "+ CommonBean.checkForNull(medplan_bean.getUOMDesc(order_uom,medplan_bean.getStrLocalLangID()));
				}
				mediplancheck="disabled";	isSameOrder = false;checked="";
				//if(Integer.parseInt(issued_qty)>0){//Commented for [IN:051785]
					LinkedHashMap hshmedplan = medplan_bean.getMedPlan_DrugDetails();
					LinkedHashMap hshmedplanlocal =  medplan_bean.getMedPlan_Local_DrugDetails();
					LinkedHashMap hshTemp = new LinkedHashMap();
					Set <String> hshKeys = new HashSet<String>();
					Set <String> hshlocalKeys = new HashSet<String>();
					hshKeys = hshmedplan.keySet();
					hshlocalKeys = hshmedplanlocal.keySet();
					if((hshKeys!=null && hshKeys.size()>0)||(hshlocalKeys!=null && hshlocalKeys.size()>0)){
						for(String key:hshKeys){
							hshTemp = (LinkedHashMap)hshmedplan.get(key);
							if(((String)hshTemp.get("order_id")).equals(order_id) && ((String)hshTemp.get("order_line_no")).equals(order_line_no) && ((String)hshTemp.get("curr_disp_yn")).equals("Y"))
								isSameOrder = true;
						}
						for(String key:hshlocalKeys){
							hshTemp = (LinkedHashMap)hshmedplanlocal.get(key);
							if(((String)hshTemp.get("order_id")).equals(order_id) && ((String)hshTemp.get("order_line_no")).equals(order_line_no) && ((String)hshTemp.get("curr_disp_yn")).equals("Y"))
								isSameOrder = true;
						}
					}
				//}
				if(Integer.parseInt(issued_qty)>0 && !isSameOrder)
					mediplancheck="";
				if(isSameOrder)//if Added for [IN:051785]
					checked="checked";
%>
				<td  class="<%=class_name%>"><input type="checkbox" id="chk_drugselect<%=i%>" <%=mediplancheck%> <%=checked%>/></td>
				<input type="hidden" name="drug_code<%=i%>" id="drug_code<%=i%>" value="<%=drug_code%>"/>
				<input type="hidden" name="order_id<%=i%>" id="order_id<%=i%>" value="<%=order_id%>"/>
				<input type="hidden" name="order_line_no<%=i%>" id="order_line_no<%=i%>" value="<%=order_line_no%>"/>
				<input type="hidden" name="drug_name<%=i%>" id="drug_name<%=i%>" value="<%=drug_desc%>"/>
				<input type="hidden" name="qty_issue<%=i%>" id="qty_issue<%=i%>" value="<%=qty_issue%>"/>
				<input type="hidden" name="qty_issuelocal<%=i%>" id="qty_issuelocal<%=i%>" value="<%=qty_issuelocal%>"/>
				<input type="hidden" name="howtotake<%=i%>" id="howtotake<%=i%>" value="<%=CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+drug_code))%>"/>
				<input type="hidden" name="howtotakelocal<%=i%>" id="howtotakelocal<%=i%>" value="<%=CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+drug_code))%>"/>
				<input type="hidden" name="impnote<%=i%>" id="impnote<%=i%>" value="<%=CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(drug_code))%>"/>
				<input type="hidden" name="impnotelocal<%=i%>" id="impnotelocal<%=i%>" value="<%=CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(drug_code))%>"/>
				<input type="hidden" name="drug_name_local<%=i%>" id="drug_name_local<%=i%>" value="<%=CommonBean.checkForNull(medplan_bean.getDrug_desc_local(drug_code))%>"/>

<%
			}
 %><!--Added for Bru-HIMS-CRF-072.1[IN 049144] end-->
			<td  class="<%=class_name_formulary%>">&nbsp;&nbsp;&nbsp;</td>
			<td  class="<%=class_name_discharge_ind%>">&nbsp;&nbsp;&nbsp;</td>
			<td  style="<%=style_name_compoumnd%>">&nbsp;&nbsp;&nbsp;</td>			
			<td  class="<%=class_name%>" nowrap ><%=start_date%></td>
			<td  class="<%=class_name%>" nowrap ><%=end_date%></td>
			<td  class="<%=class_name%>" <%=link%>  nowrap><label style="color:<%=discont_color%>"><%=drug_desc%></label></td>
<%			
	
			if(split_dose_prev.equals("")) {
%>
				<td  class="<%=class_name%>"nowrap><%=dosage_string%></td>
				<td  class="<%=class_name%>"><%=split_freq_desc%></td>
<%			}else{	
%>
				<td  class="<%=class_name%>" nowrap><%=dosage_string%></td>
<%				if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
					if(orig_order_line_no.equals("1")){

%>
						<td  class="<%=class_name%>" nowrap><label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=java.net.URLEncoder.encode(freq_desc,"UTF-8")%>','<%=start_date%>','<%=sliding_scale_yn%>')" style="cursor:pointer;color:blue" nowrap><%=split_freq_desc%></label></td>
<%			
				}
				else{
%>
					<td  class="<%=class_name%>" nowrap><label  nowrap><%=split_freq_desc%></label></td>

<% 				}
			}
			else{
%>
				<td  class="<%=class_name%>" nowrap><label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=java.net.URLEncoder.encode(freq_desc,"UTF-8")%>','<%=start_date%>','<%=sliding_scale_yn%>')" style="cursor:pointer;color:blue" nowrap><%=split_freq_desc%></label></td>
<%			}
		}
%>
			<td  class="<%=class_name%>">&nbsp;<%=practitioner_name%></td>
			<td  class="<%=class_name%>">&nbsp;<%=location%></td>
			<td  class="<%=class_name%>"><%=perf_locn%>&nbsp;</td>
			<td  class="<%=class_name%>" nowrap>&nbsp;<%=facility_name%></td>
<%			
			if(diag_text_found) {
%>
				<td  class="<%=class_name%>" style="cursor:pointer;color:blue"><label onClick="callDiagText('<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(diag_text,"UTF-8")%>')">Details</label></td>
<%
			}
			else {
%>
				<td  class="<%=class_name%>">&nbsp;</td>
<%
			}
%>
			<td  class="<%=class_name%>" nowrap>&nbsp;<%=per_facility_name%></td>
		</tr>
<%
		}
	}
%>
	</table>
	<input type="hidden" name="totalrecords" id="totalrecords" value="<%=i%>"/>
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>


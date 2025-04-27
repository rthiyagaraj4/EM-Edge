<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
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
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<title><fmt:message key="ePH.LastVisitMedication.label" bundle="${ph_labels}"/></title>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="lastVisitOrderDetailsForm" id="lastVisitOrderDetailsForm" >
<%
			try{
				String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
				String encounter_id			=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
				String called_frm			=	request.getParameter("called_frm")==null?"":request.getParameter("called_frm");
				String patient_class		=	request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
				String order_date			=	request.getParameter("order_date")==null?"":request.getParameter("order_date");	

				String bean_id			= "DispMedicationBean" ;
				String bean_name		= "ePH.DispMedicationBean";
				DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
				String facility_id			= (String) session.getValue("facility_id");
				String class_name			= "";
				ArrayList alPrevVisitOrders		= new ArrayList();		

				String	start_date			=	"";
				String	end_date			=	"";
				String	drug_desc			=	"";
				String	practitioner_name	=	"";
				String	facility_name		=	"";
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
				String iv_prep_yn			=   "";
				String discharge_ind		=	"";
				String in_formulary_yn		=	"";
				String dosage				=	"";
				String dosage_uom			=	"";
				String split_yn				=	"";
				String sliding_scale_yn		=	"";
				String dosage_string 		=	"";
				String split_freq_desc		=	"";
				String class_name_formulary	=	"";
				String class_name_discharge_ind	=	"";
				String style_name_compoumnd	=	"";
				String orig_order_line_no	=	"";
				String prescribed_qty	=	"";
				String dispensed_qty	, route_desc, pres_uom, disp_uom, order_line_status, line_status_txt, dispnsd_disp_unit_value="",  content_in_pres_base_uom, freq_nature, dosage_type, pres_disp_unit_value,alternates ;
				//alPrevVisitOrders	=	bean.getPrevVisitOrders();//bean.getPatientPrevVisitOrders(patient_id,"100999770001"); COMMENTED FOR  KDAH-ICN-0006
                 alPrevVisitOrders	=	bean.getPatientPrevVisitOrders(patient_id,encounter_id);//ADDED FOR KDAH-ICN-0006
				if(alPrevVisitOrders.size()<1){
%>
					<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));window.close();</script> 
<%
				}
%>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1">
					<tr>
						<th  class="small" width="1%" rowspan='2'>&nbsp;&nbsp;&nbsp;</th>
						<th  class="small" width="1%" rowspan='2'>&nbsp;&nbsp;&nbsp;</th>
						<th  class="small" width="1%" rowspan='2'>&nbsp;&nbsp;&nbsp;</th>
						<th  class="small" width="27%" rowspan='2' nowrap>&nbsp;<fmt:message key="ePH.Prescribed/DispensedDrug.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="7%" rowspan='2' nowrap>&nbsp;<fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;</td>
						<th  class="small" width="9%" rowspan='2' nowrap>&nbsp;<fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" rowspan='2' nowrap>&nbsp;<fmt:message key="ePH.DosageDetails.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" rowspan='2' nowrap>&nbsp;<fmt:message  key="Common.StartDate.label" bundle="${common_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" rowspan='2' nowrap>&nbsp;<fmt:message  key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" colspan='2' nowrap>&nbsp;<fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" colspan='2' nowrap>&nbsp;<fmt:message key="ePH.DispenseQuantity.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" rowspan='2' nowrap>&nbsp;<fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/>&nbsp;</th>
					</tr>
					<tr border='1'>
						<th  class="small" width="9%" nowrap>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" nowrap>&nbsp;<fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" nowrap>&nbsp;<fmt:message key="ePH.PrescribingUnit.label" bundle="${ph_labels}"/>&nbsp;</th>
						<th  class="small" width="9%" nowrap>&nbsp;<fmt:message key="ePH.DispensingUnit.label" bundle="${ph_labels}"/>&nbsp;</th>
					</tr>
<% 
					for (int i=0; i<alPrevVisitOrders.size(); i++) {

						if(i%2==0)
							class_name				=	"QRYEVENSMALL";
						else
							class_name				=	"QRYODDSMALL";
						class_name_formulary		=	"";
						class_name_discharge_ind	=	"";
						style_name_compoumnd		=	"";
						HashMap record	=	(HashMap)	alPrevVisitOrders.get(i);
						start_date			=	CommonBean.checkForNull((String)record.get("start_date"));
						end_date			=	CommonBean.checkForNull((String) record.get("end_date"));
						drug_desc			=	CommonBean.checkForNull((String) record.get("drug_desc"));
						practitioner_name	=	CommonBean.checkForNull((String) record.get("practitioner_name"));
						split_dose_prev		=	CommonBean.checkForNull((String) record.get("split_dose_prev")); 
						order_id			=	CommonBean.checkForNull((String) record.get("order_id")); 
						order_line_no		=	CommonBean.checkForNull((String) record.get("order_line_no")); 
						freq_desc			=	CommonBean.checkForNull((String) record.get("freq_desc")); 
						allergy_reason		=	CommonBean.checkForNull((String) record.get("allergy_reason")); 
						dosage_reason		=	CommonBean.checkForNull((String) record.get("dosage_reason")); 
						duplicate_reason	=	CommonBean.checkForNull((String) record.get("duplicate_reason")); 
						iv_prep_yn			=   CommonBean.checkForNull((String) record.get("iv_prep_yn")); 
						discharge_ind		=   CommonBean.checkForNull((String) record.get("discharge_ind")); 
						in_formulary_yn		=	CommonBean.checkForNull((String) record.get("in_formulary_yn")); 
						dosage				=	CommonBean.checkForNull((String) record.get("dosage")); 
						dosage_uom			=	CommonBean.checkForNull((String) record.get("dosage_uom_code")); 
						prescribed_qty		=	CommonBean.checkForNull((String) record.get("prescribed_qty")); 
						dispensed_qty		=	CommonBean.checkForNull((String) record.get("dispensed_qty")); 
						route_desc			=	CommonBean.checkForNull((String) record.get("route_desc")); 
						pres_uom			=	CommonBean.checkForNull((String) record.get("pres_uom")); 
						disp_uom			=	CommonBean.checkForNull((String) record.get("disp_uom")); 
						
						split_yn			=	CommonBean.checkForNull((String) record.get("split_yn"),"N"); 
						sliding_scale_yn	=	CommonBean.checkForNull((String) record.get("sliding_scale_yn"),"N"); 
						order_line_status	=	CommonBean.checkForNull((String) record.get("order_line_status"),""); 
						line_status_txt		=	CommonBean.checkForNull((String) record.get("line_status_desc"));
						content_in_pres_base_uom		=	CommonBean.checkForNull((String) record.get("content_in_pres_base_uom"));
						freq_nature		=	CommonBean.checkForNull((String) record.get("freq_nature"));
						dosage_type		=	CommonBean.checkForNull((String) record.get("dosage_type"));
						alternates		=	CommonBean.checkForNull((String) record.get("alternates"));

						if(!dosage_type.equals("A")){
							if(!freq_nature.equals("P")){
								pres_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(prescribed_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
							}
							else{
								pres_disp_unit_value=prescribed_qty;
								pres_uom=disp_uom;
							}
						}
						else{
							if(!iv_prep_yn.equals("5") && !iv_prep_yn.equals("") && !iv_prep_yn.equals("9") && !iv_prep_yn.equals("0")){ 
								pres_disp_unit_value=prescribed_qty;
							}
							else{
								pres_disp_unit_value =  (new Double(Math.ceil(Float.parseFloat(prescribed_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
							}
						}
						if(dispensed_qty != null && dispensed_qty != ""){
							if(!pres_uom.equals(disp_uom)){
								if(iv_prep_yn.equals("2")||iv_prep_yn.equals("4")||iv_prep_yn.equals("6")||iv_prep_yn.equals("0")){
									dispnsd_disp_unit_value	=  Double.parseDouble(dispensed_qty)/Float.parseFloat(content_in_pres_base_uom)+"";
								}
								else{										
									if(!dosage_type.equals("A")){
									   dispnsd_disp_unit_value		=  (new Double(Math.ceil(Float.parseFloat(dispensed_qty)/Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
									}
									else{
										if(freq_nature.equals("P")){
											dispnsd_disp_unit_value     =dispensed_qty+"";
											dispensed_qty		=  (new 		Double(Math.ceil(Float.parseFloat(dispensed_qty)*Float.parseFloat(content_in_pres_base_uom))).intValue())+"";
										}
									}
								}
							}
							else{
								dispnsd_disp_unit_value		= dispensed_qty;
							}
						}

						if(sliding_scale_yn.equals("Y"))
							dosage_string = "<b>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.SlidingScale.label", "common_labels")+" </b>" ;
						else
							dosage_string = dosage +"  "+ CommonBean.checkForNull(bean.getUomDisplay(facility_id,dosage_uom));
						

						if(split_yn.equals("Y"))
							split_freq_desc  = "<b>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Divided.label", "ph_labels")+"</b>";
						else
							split_freq_desc  = freq_desc;
						String discont_color=	"";


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
							}
							else{
								class_name			= "IVINGREDIENT";
								practitioner_name	= "&nbsp;";
								facility_name		= "&nbsp;";
								//freq_code			= "&nbsp;";	
							}
						}				
						if(in_formulary_yn.equals("N"))
							class_name_formulary	= "FORMULARY";
						if(discharge_ind.equals("D"))
							class_name_discharge_ind= "DISCHARGEMED";
						if(iv_prep_yn.equals("6")){
							style_name_compoumnd	= "background-color:#E4CAFF";
							if(!order_line_no.equals("1")){
								dosage_string="&nbsp;";				
								split_freq_desc="&nbsp;";	
							}
						}
						orig_order_line_no =order_line_no;

						if(iv_prep_yn != null && !(iv_prep_yn.equals(""))){ 
							order_line_no = "1";
						}
						//disp_uom		=	pres_uom;
						if(alternates.equals("Y")){
							dispensed_qty		= "";
							dispnsd_disp_unit_value = "";
							disp_uom		=  "";
						}
%>
						<tr > 
							<td  class="<%=class_name_formulary%>" >&nbsp;</td>
							<td  class="<%=class_name_discharge_ind%>">&nbsp;</td>
							<td  style="<%=style_name_compoumnd%>">&nbsp;</td>			
							<td  class="<%=class_name%>" <%=link%>  nowrap>&nbsp;<label style="color:<%=discont_color%>"><%=drug_desc%>&nbsp;</label></td>
							<td class="<%=class_name%>" nowrap>&nbsp;<%=line_status_txt%>&nbsp;</td>
							<td  class="<%=class_name%>"nowrap >&nbsp;<%=route_desc%>&nbsp;</td>
							<td  class="<%=class_name%>"nowrap>&nbsp;<%=dosage_string%>&nbsp;
<%			
							if(split_dose_prev.equals("")) {		
%>
								<label><%=split_freq_desc%></label>
<%			
							}
							else{	
								if(iv_prep_yn.equals("3")||iv_prep_yn.equals("4")){
									if(orig_order_line_no.equals("1")){
%>
										<label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=java.net.URLEncoder.encode(freq_desc,"UTF-8")%>','<%=start_date%>','<%=sliding_scale_yn%>')" style="cursor:pointer;color:blue" nowrap><%=split_freq_desc%></label>
<%			
									}
									else{
%>
										<label  nowrap><%=split_freq_desc%></label>
<% 	
									}
								}
								else{
%>
								   <label onClick="callFreqDet('<%=patient_id%>','<%=encounter_id%>','<%=order_id%>','<%=order_line_no%>','<%=java.net.URLEncoder.encode(freq_desc,"UTF-8")%>','<%=start_date%>','<%=sliding_scale_yn%>')" style="cursor:pointer;color:blue" nowrap><%=split_freq_desc%></label>
<%
								}
							}  
%>
						   &nbsp;</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;<%=start_date%>&nbsp;</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;<%=end_date%>&nbsp;</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;
<%
						if(prescribed_qty!=null && !prescribed_qty.equals("")){
%>
							<%=prescribed_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_uom))%>
<%
						}
%>
						</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;
<%
						if(pres_disp_unit_value!=null && !pres_disp_unit_value.equals("")){
%>
							<%=pres_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))%>
<%
						}
%>
						&nbsp;</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;
<%
						if(dispensed_qty!=null && !dispensed_qty.equals("")){
%>
							<%=dispensed_qty%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,pres_uom))%>
<%
						}
%>
						</td>
						<td  class="<%=class_name%>"nowrap >&nbsp;
<%
						if(dispnsd_disp_unit_value!=null && !dispnsd_disp_unit_value.equals("")){
%>
							<%=dispnsd_disp_unit_value%>&nbsp;<%=CommonBean.checkForNull(bean.getUomDisplay(facility_id,disp_uom))%>
<%
						}
						else if(alternates.equals("Y")){
%>
							<img  src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/> <fmt:message key="Common.Dispensed.label" bundle="${common_labels}"/>' align="center"></img>
							</font>						
<%
						}
%>
						&nbsp;</td>
						<td  class="<%=class_name%>">&nbsp;<%=practitioner_name%>&nbsp;</td>
						</tr>
<%
					}
%>
				</table>
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


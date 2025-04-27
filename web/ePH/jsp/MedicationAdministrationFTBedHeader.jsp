<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistencebean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="Javascript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="MedicationAdministrationBedPatientHeader" id="MedicationAdministrationBedPatientHeader" >
<%
		try{
			String bean_id_all_stages	= "DispMedicationAllStages" ;
			String bean_name_all_stages	= "ePH.DispMedicationAllStages";
			DispMedicationAllStages bean_all_stages = (DispMedicationAllStages)getBeanObject( bean_id_all_stages, bean_name_all_stages, request ) ;
			bean_all_stages.setLanguageId(locale);
			bean_all_stages.setModuleId("1");
			String bean_id					= "MedicationAdministrationBean";
			String bean_name				= "ePH.MedicationAdministrationBean";
			MedicationAdministrationBean bean			= (MedicationAdministrationBean)getBeanObject( bean_id, bean_name, request );
			String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

			String bed_num			   = request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
			String encounter_id		   = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String nursing_unit		   = request.getParameter("nursing_unit");
			String admin_from_date	   = request.getParameter("admin_from_date");
			String admin_to_date	   = request.getParameter("admin_to_date");
			String hold_discontinue_yn = request.getParameter("hold_discontinue_yn");
			String order_type		   = request.getParameter("order_type");
			String to_time			   = request.getParameter("to_time");
			String display_order_by	   = request.getParameter("display_order_by");
			String patient_class       = request.getParameter("patient_class").trim();
			
			String call_from_ca        = request.getParameter("call_from_ca")==null?"":request.getParameter("call_from_ca");
			if(call_from_ca.equals("undefined"))
				call_from_ca		   = "";
			call_from_ca			   = call_from_ca.trim();
			String option_id           = request.getParameter("option_id")==null?"":request.getParameter("option_id");
			if(option_id.equals("undefined"))
				option_id			   = "";
			option_id				   = option_id.trim();
			
			String administration_status   = request.getParameter("administration_status");
			String called_from             = request.getParameter("called_from");
			String from_time               = request.getParameter("from_time");	
			String mode                    = request.getParameter("mode");
			String flag                    = "N";
//System.err.println("=============>"+request.getQueryString());
			//code added for from and to bed no...
			String from_bed_no			   = request.getParameter("from_bed_no");
			String to_bed_no			   = request.getParameter("to_bed_no");
			String route_admin			   = request.getParameter("route_admin");
			String admin_route_categ	   = request.getParameter("admin_route_categ");
			String MAR_sch_level_yn	   = request.getParameter("MAR_sch_level_yn")==null?"":request.getParameter("MAR_sch_level_yn");
			String bean_idFT	= "MedicationAdministrationFTBean";
			String bean_nameFT= "ePH.MedicationAdministrationFTBean";
			ArrayList patient_details =null;
			MedicationAdministrationFTBean beanFT	= (MedicationAdministrationFTBean)getBeanObject( bean_idFT, bean_nameFT , request);
			beanFT.setLanguageId(locale);
			beanFT.clear();
			//getting allergy existence detail - SKR-CRF-010
			String customer_id = beanFT.getCustomerID();
			String allergic_yn				=  "N";
			int num =0;
			//getting allergy existence detail - SKR-CRF-010

			if(patient_id.equals("")){
				if(!locale.equals("en")){
					admin_from_date	   = DateUtils.convertDate(admin_from_date, "DMYHM",locale,"en");
					admin_to_date	   = DateUtils.convertDate(admin_to_date, "DMYHM",locale,"en");
					from_time	   = DateUtils.convertDate(from_time, "DMYHM",locale,"en");
					to_time	   = DateUtils.convertDate(to_time, "DMYHM",locale,"en");
				}
				if(patient_class.equals("A"))
					patient_class="OP";
				else if(patient_class.equals("E"))
					patient_class="EM";
					patient_details = beanFT.getPatientDetails(nursing_unit,admin_from_date,admin_to_date,hold_discontinue_yn,administration_status,mode,order_type,to_time,from_time,called_from,from_bed_no,to_bed_no,patient_class,route_admin,admin_route_categ);
			}
			else{
				flag="Y";
				patient_details=beanFT.getPatientDetail(patient_id);
			}
			HashMap hmSchMARDtl =(HashMap) bean.getSchMARParams();
			if(patient_details.size()==0){
%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
					parent.f_bed_patient.location.href="../../eCommon/html/blank.html";
					if(parent.parent.f_button != null){
						parent.parent.f_button.location.href = "../../eCommon/html/blank.html";
						parent.parent.parent.f_search.location.href = "../../ePH/jsp/MedicationAdministrationSearch.jsp";
					}
					else{
						parent.parent.f_admin_button.location.href="../../eCommon/html/blank.html";
					}
				</script>
<%		
				return;
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" name="patient_header_table" id="patient_header_table">
				<tr>
					<td class='COLUMNHEADER'  width="10%" style="font-size:10"><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="10%" style="font-size:10"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="40%" style="font-size:10"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="10%"  style="font-size:10"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="10%"  style="font-size:10"><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADER' width="20%" style="font-size:10"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				</tr>
<%
				int recCount = 1;
				String classvalue	  = "";
				String assign_bed_num = "";
				String patient_name	  = ""; 
				String gender		  = ""; 
				String age			  = ""; 
				String nationality	  = ""; 
				if(patient_id.equals("")){			
					for(int i=0;i<patient_details.size();i=i+7){
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;	

						assign_bed_num = (String)patient_details.get(i);
						patient_id	   = (String)patient_details.get(i+1);
						patient_name   = (String)patient_details.get(i+2);
						gender		   = (String)patient_details.get(i+3);
						age			   = (String)patient_details.get(i+4);
						nationality	   = (String)patient_details.get(i+5);
						encounter_id   = (String)patient_details.get(i+6);
						if(nationality==null){
							nationality = "&nbsp;&nbsp;";
						}
					
						if(assign_bed_num==null)assign_bed_num="";
						
						bean_all_stages.addPatient(patient_id);
						bean_all_stages.addPrescription(patient_id,patient_id);
						//getting allergy existence detail - SKR-CRF-010
						allergic_yn = "N";
						if(customer_id.equals("SKR")){
							num=  beanFT.loadallergydetail(patient_id);
							if(num>0)
								allergic_yn = "Y";
						}
						//getting allergy existence detail -SKR-CRF-010
%>
						<tr id="tr_<%=recCount%>">
							<td  class="<%=classvalue%>" style="font-size:10">
								<label id="bed_no_<%=recCount%>" name="bed_no_<%=recCount%>" ><%=assign_bed_num%>&nbsp;</label>
							</td>
							<td width='10%' class="<%=classvalue%>" style="font-size:10">
<%
							if(mode.equals("NOTIME")){
%>
								<label onClick="loadDrugAdminChart('<%=encounter_id%>','<%=patient_id%>','<%=recCount%>');collapse('<%=recCount%>','<%=mode%>');" id="patient_id_<%=recCount%>" style="cursor:pointer;color:blue"><%=patient_id%></label>
<%
							}
							else{
%>
								<label  onClick="getDrugDetails('<%=encounter_id%>','<%=recCount%>','<%=assign_bed_num%>','<%=nursing_unit%>','<%=hold_discontinue_yn%>','<%=from_time%>','<%=to_time%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=administration_status%>','<%=order_type%>','<%=patient_id%>','<%=display_order_by%>','','<%=route_admin%>','<%=admin_route_categ%>','<%=allergic_yn%>');collapse('<%=recCount%>');" id="patient_id_<%=recCount%>" style="cursor:pointer;color:blue"><%=patient_id%></label>
<%
								//",'<%=allergic_yn " added in getDrugDetails() method call fpr SKR-CRF-010
							}
%>
							</td>
							<td  class="<%=classvalue%>" style="font-size:10">
				<%
							if(mode.equals("NOTIME")){
				%>
								<label onClick="loadDrugAdminChart('<%=encounter_id%>','<%=patient_id%>','<%=recCount%>');collapse('<%=recCount%>', '<%=mode%>');"  style="cursor:pointer;color:blue"><%=patient_name%>&nbsp;</label>
				<%
							}
							else{
				%>
								<label  onClick="getDrugDetails('<%=encounter_id%>','<%=recCount%>','<%=assign_bed_num%>','<%=nursing_unit%>','<%=hold_discontinue_yn%>','<%=from_time%>','<%=to_time%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=administration_status%>','<%=order_type%>','<%=patient_id%>','<%=display_order_by%>','','<%=route_admin%>','<%=admin_route_categ%>','<%=allergic_yn%>');collapse('<%=recCount%>');" style="cursor:pointer;color:blue"><%=patient_name%></label>
				<%
								//",'<%=allergic_yn " added in getDrugDetails() method call fpr SKR-CRF-010
							}
				%>
							</td>
							<td class="<%=classvalue%>" style="font-size:10"><%=gender%></td>
							<td class="<%=classvalue%>" style="font-size:10"><%=age%></td>
							<td class="<%=classvalue%>" style="font-size:10"><%=nationality%></td>
							<input type="hidden" name="encounter_id_<%=recCount%>" id="encounter_id_<%=recCount%>" value="<%=encounter_id%>" >
						</tr>
<%
						recCount++;
					}
				}
				else{
					allergic_yn = "N";
					if(patient_details.size()!= 0){
						nationality=(String)patient_details.get(0);
						patient_name=(String)patient_details.get(1);
						gender=(String)patient_details.get(2);
						age=(String)patient_details.get(3);
					}
					classvalue = "QRYEVEN" ; 
%>

					<tr><td class="<%=classvalue%>" style="font-size:10"><%=bed_num%></td>
						<td class="<%=classvalue%>" style="font-size:10"><%=patient_id%></td>
						<td class="<%=classvalue%>" style="font-size:10"><%=patient_name%></td>
						<td class="<%=classvalue%>" style="font-size:10"><%=gender%></td>
						<td class="<%=classvalue%>" style="font-size:10"><%=age%></td>
						<td class="<%=classvalue%>" style="font-size:10"><%=nationality%></td>
					</tr>
<%
				}
				if(MAR_sch_level_yn.equals("Y")){
					ArrayList alAllergyList = null;
					StringBuffer allegenList = new StringBuffer();
					if(customer_id.equals("SKR")){//getting allergy existence detail - SKR-CRF-010
						alAllergyList=  beanFT.getAllergydetail(patient_id);
						for(int i=0;i<alAllergyList.size();i++){
							if(i==2){
								allegenList.append(", "+(String)alAllergyList.get(i)+", < more >"); //com.ehis.util.BundleMessage.getBundleMessage(pageContext, "PH.more.label", "ph_labels")
								break;
							}
							else if(i>0)
								allegenList.append(", "+(String)alAllergyList.get(i));
							else
								allegenList.append((String)alAllergyList.get(i));
							allergic_yn = "Y";
						}
					}
%>
					<tr border="1" id="pat_links" >
						<td class='label'>
<%
						if(allergic_yn.equals("Y")){
%>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('AL')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></font>
<%
						}
%>
						&nbsp;</td>
						<td class='label' colspan='2' style='font-size:10;color:red;'><b><%=allegenList.toString()%>&nbsp;</b></td>
						<td align='right' class="white" colspan='3'>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('PR')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('CR')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('DM')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('DP','<%=encounter_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></font> <!-- encounter_id added for AAKH-CRF-0088.2-->
						</td>
					</tr>
<%
				}
				else{
					
					if(customer_id.equals("SKR")){//getting allergy existence detail - SKR-CRF-010
						num=  beanFT.loadallergydetail(patient_id);
						if(num>0)
							allergic_yn = "Y";
					}
%>
					<tr border="1" id="pat_links" style="display:none">
						<td align='right' class="white"  colspan='6'>
							<!--- Display allergy existence detail KnownCaseofAllergy -SKR-CRF-010-->
							<label style='font-size:11;font-weight:bold;color:red;display:none;' id='lblkwncaseAlgy' name='lblkwncaseAlgy'><fmt:message key="ePH.KnownCaseofAllergy.label" bundle="${ph_labels}"/></label>
							<!--- Display allergy existence detail KnownCaseofAllergy -SKR-CRF-010-->
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('AL')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('PR')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('CR')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('DM')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Demographics.label" bundle="${common_labels}"/></font>
							<font style="font-size:9;cursor:pointer" class="HYPERLINK" onClick="callFunction('DP','<%=encounter_id%>')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></font> <!-- encounter_id added for AAKH-CRF-0088.2-->
						</td>
					</tr>
<%
				}
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="selected_patient_id_row" id="selected_patient_id_row" value="">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="pat_id_link" id="pat_id_link" value="">
			<input type="hidden" name="call_from_ca" id="call_from_ca" value="<%=call_from_ca%>">
			<input type="hidden" name="option_id" id="option_id" value="<%=option_id%>">			
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">			
			<input type="hidden" name="MAR_sch_level_yn" id="MAR_sch_level_yn" value="<%=MAR_sch_level_yn%>">			
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">			
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">			
<%	
			if(flag.equals("Y")){
%>
				<script>
					getDrugDetails('<%=encounter_id%>','1','<%=bed_num%>','<%=nursing_unit%>','<%=hold_discontinue_yn%>','<%=from_time%>','<%=to_time%>','<%=admin_from_date%>','<%=admin_to_date%>','<%=administration_status%>','<%=order_type%>','<%=patient_id%>','<%=display_order_by%>','CA','<%=route_admin%>','<%=admin_route_categ%>','<%=allergic_yn%>');
<%
				//if(!MAR_sch_level_yn.equals("Y")){
%>
					collapse('1','','<%=MAR_sch_level_yn%>');
<%
				//}
%>
				</script>
 <%
				//",'<%=allergic_yn " added in getDrugDetails() method call fpr SKR-CRF-010
			}
			
			putObjectInBean(bean_id,bean,request);
			putObjectInBean(bean_idFT,beanFT,request);
			putObjectInBean(bean_id_all_stages,bean_all_stages,request);
		}
		catch(Exception e){
			e.printStackTrace();
		}
%>
		</form>
	</body>
</html>


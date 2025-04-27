<!DOCTYPE html>
 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
10/12/2019      IN070606           Manickavasagam                         		 MMS-KH-CRF-0029
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- Modified for IN:072715  -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<title><fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="DispQueueMgmtHoldReason" id="DispQueueMgmtHoldReason" >
<%
try{
			String generic_id		= CommonBean.checkForNull(request.getParameter("gen_id"));
			String generic_name		= CommonBean.checkForNull(request.getParameter("gen_name"));
			String patient_id		= CommonBean.checkForNull(request.getParameter("pat_id"));
			String encounter_id		= CommonBean.checkForNull(request.getParameter("enc_id"));
			String drug_desc		= CommonBean.checkForNull(request.getParameter("drug_desc"));
			String mono_graph		= CommonBean.checkForNull(request.getParameter("mono_graph"));
			String daily_dose		= CommonBean.checkForNull(request.getParameter("daily_dose"));
			String unit_dose		= CommonBean.checkForNull(request.getParameter("unit_dose"));
			String dosage_std		= CommonBean.checkForNull(request.getParameter("dosage_std"));//Added for ML-MMOH-SCF-0864
			String dose_unit_desc   = CommonBean.checkForNull(request.getParameter("dose_unit_desc"));//Added for ML-MMOH-SCF-0864,Modified for IN:070451
			String min_daily_dose	= CommonBean.checkForNull(request.getParameter("min_daily_dose"));
			String min_unit_dose	= CommonBean.checkForNull(request.getParameter("min_unit_dose")); 
			String allergy_yn		= CommonBean.checkForNull(request.getParameter("allergy_yn"));
			String current_rx		= CommonBean.checkForNull(request.getParameter("current_rx"));
			String limit_ind		= CommonBean.checkForNull(request.getParameter("limit_ind"));
			String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
			String srl_no			= CommonBean.checkForNull(request.getParameter("srl_no"));
			String dosage_unit		= CommonBean.checkForNull(request.getParameter("dosage_unit"));
			String interaction_exists	= CommonBean.checkForNull(request.getParameter("interaction_exists")); // added for FD-RUT-CRF-0066.1 [IN036975]
			String interaction_remarks	= ""; // added for FD-RUT-CRF-0066.1 [IN036975]
			String food_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
			String lab_interaction_remarks = ""; //MMS-KH-CRF-0029[IN070606]
			String disease_interaction_remarks ="";//Added for MMS-DM-CRF-0229

			String intr_msg_content	= "";
			String allergy			= "";
			String exceed_dose		= "";
			String dup_drug			= "";
			//Added for IN:070451
			String max_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_daily_ceeling_dose"));
			String min_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_daily_ceeling_dose"));
			String max_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_unit_ceeling_dose"));
			String min_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_unit_ceeling_dose"));
			//String dose_unit_desc			= CommonBean.checkForNull(request.getParameter("dose_unit_desc"));
			String dose_unit_desc1			= CommonBean.checkForNull(request.getParameter("dose_unit_desc1"));
			//Added for IN:070451
			//Added for IN:072715 start
			String allergy_override_select	= CommonBean.checkForNull(request.getParameter("allergy_remarks_code"));
			String dose_override_select	= CommonBean.checkForNull(request.getParameter("dose_remarks_code"));
			String dup_drug_override_select	= CommonBean.checkForNull(request.getParameter("currentrx_remarks_code"));
			String inter_override_select	= CommonBean.checkForNull(request.getParameter("interaction_remarks_code"));
			String food_inter_override_select	= CommonBean.checkForNull(request.getParameter("food_interaction_remarks_code"));
			String lab_inter_override_select	= CommonBean.checkForNull(request.getParameter("lab_interaction_remarks_code"));
			String disease_inter_override_select	= CommonBean.checkForNull(request.getParameter("disease_interaction_remarks_code"));//Added for MMS-DM-CRF-0229
			//Added for IN:072715 end
			if (request.getParameter("allergy") != null){
				allergy	= java.net.URLDecoder.decode(request.getParameter("allergy"),"UTF-8");
			}

			if (request.getParameter("exceed_dose") != null){
				exceed_dose	= java.net.URLDecoder.decode(request.getParameter("exceed_dose"),"UTF-8");
			}

			if (request.getParameter("dup_drug") != null){
				dup_drug =java.net.URLDecoder.decode(request.getParameter("dup_drug"),"UTF-8");
			}
			if (request.getParameter("interaction_remarks") != null){ // added for FD-RUT-CRF-0066.1 [IN036975]
				interaction_remarks =java.net.URLDecoder.decode(request.getParameter("interaction_remarks"),"UTF-8");
			}
			//Added for IN:072715 START
			Connection con			= null; 
				con				= ConnectionManager.getConnection(request);
			boolean over_ride_remarks_select_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","PH_OVERRIDE_REASON_SELECT_APPL");
			if(con != null)
				ConnectionManager.returnConnection(con,request);
			String sql="select REASON_CODE,REASON_DESC from PH_MEDN_TRN_REASON where APPL_TRN_TYPE=? AND EFF_STATUS='E'";
			ArrayList dose_override_params= new ArrayList();
			dose_override_params.add("BD");
			ArrayList allergy_override_params= new ArrayList();
			allergy_override_params.add("AO");
			ArrayList dup_drug_override_params= new ArrayList();
			dup_drug_override_params.add("DP");
			ArrayList inter_override_params= new ArrayList();
			inter_override_params.add("DD");
			ArrayList food_inter_override_params= new ArrayList();
			food_inter_override_params.add("DF");
			ArrayList lab_inter_override_params= new ArrayList();
			lab_inter_override_params.add("DL");
			//Added for IN:072715 END
			ArrayList disease_inter_override_params= new ArrayList();//Added for MMS-DM-CRF-0229
			disease_inter_override_params.add("DI");
			String bean_id				= "DirectDispensingBean" ;
			String bean_name			= "ePH.DirectDispensingBean";
			DirectDispensingBean bean	= (DirectDispensingBean)getBeanObject( bean_id,bean_name,request);
			//bean.setLanguageId(locale);
			//String or_bean_name			= "eOR.OrderEntryBean";
			//String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
			//OrderEntryBean orbean		= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request);
			//orbean.setLanguageId(locale);
			//String called_from		=	orbean.getCalledFromFunction();
			String disable_status	=	"";

			//if(called_from!=null && called_from.equals("RENEW_ORDER")) {
				//disable_status		=	"disabled";
			//}
			String pres_bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
			String pres_bean_name		= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 Pres_bean	= (PrescriptionBean_1)getBeanObject( pres_bean_id,pres_bean_name,request);
			String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean PresBean	= (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);
			PresBean.setLanguageId(locale);
			Pres_bean.setLanguageId(locale);
			HashMap ext_drugData = null;
			String ext_drug_code ="", ext_srl_no="";
	/*		if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
				   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
					if(dose_unit_desc==null || dose_unit_desc=="" ) {
					  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
				     if(dosage_unit.split("/").length>=2){
					   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
					 }
					
					} 
				}*/// Added for ML-MMOH-SCF-0863 - End, commentted for IN:070451
		    

			if (request.getParameter("allergy") == null && request.getParameter("exceed_dose") == null && request.getParameter("dup_drug") == null&& request.getParameter("interaction_remarks") == null) {
				ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
				
				for(int j=0;j<prescriptionDetails.size();j++){
					ext_drugData	=(HashMap) prescriptionDetails.get(j);
					ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
					ext_srl_no		=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){

						if(ext_drugData.containsKey("ALLERGY_REMARKS") && ext_drugData.get("ALLERGY_REMARKS")!=null) {
							allergy	=(String)ext_drugData.get("ALLERGY_REMARKS");
							//allergy		=	java.net.URLDecoder.decode(allergy,"UTF-8");
						}

						if(ext_drugData.containsKey("DOSE_REMARKS") && ext_drugData.get("DOSE_REMARKS")!=null) {
							exceed_dose	=(String)ext_drugData.get("DOSE_REMARKS");
							//exceed_dose	=	java.net.URLDecoder.decode(exceed_dose,"UTF-8");
						}

						if(ext_drugData.containsKey("CURRENTRX_REMARKS") && ext_drugData.get("CURRENTRX_REMARKS")!=null) {
							dup_drug	=(String)ext_drugData.get("CURRENTRX_REMARKS");
							//dup_drug	=	java.net.URLDecoder.decode(dup_drug,"UTF-8");
						}
						if(ext_drugData.containsKey("INTERACTION_REMARKS") && ext_drugData.get("INTERACTION_REMARKS")!=null ) { // added for FD-RUT-CRF-0066.1 [IN036975]
							interaction_remarks	=(String)ext_drugData.get("INTERACTION_REMARKS");
							//interaction_remarks =java.net.URLDecoder.decode(interaction_remarks,"UTF-8");
						}//MMS-KH-CRF-0029[IN070606] - start
						if(ext_drugData.containsKey("FOOD_INTERACTION_REMARKS")) {
							food_interaction_remarks	=(String)ext_drugData.get("FOOD_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("FOOD_INTERACTION_REMARKS");
						}
						if(ext_drugData.containsKey("LAB_INTERACTION_REMARKS")) {
							lab_interaction_remarks	=(String)ext_drugData.get("LAB_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("LAB_INTERACTION_REMARKS");
						}
						//MMS-KH-CRF-0029[IN070606] - End
						if(ext_drugData.containsKey("DISEASE_INTERACTION_REMARKS")) {//modified for MMS-KH-CRF-0229
							disease_interaction_remarks	=(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS")==null?"":(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS");
						}
						//Added for IN:072715 START
					if(ext_drugData.containsKey("ALLERGY_REMARKS_CODE")) { 
						allergy_override_select	=(String)ext_drugData.get("ALLERGY_REMARKS_CODE")==null?"":(String)ext_drugData.get("ALLERGY_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("DOSE_REMARKS_CODE")) { 
						dose_override_select	=(String)ext_drugData.get("DOSE_REMARKS_CODE")==null?"":(String)ext_drugData.get("DOSE_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("CURRENTRX_REMARKS_CODE")) {
						dup_drug_override_select	=(String)ext_drugData.get("CURRENTRX_REMARKS_CODE")==null?"":(String)ext_drugData.get("CURRENTRX_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("INTERACTION_REMARKS_CODE")) { 
						inter_override_select	=(String)ext_drugData.get("INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("INTERACTION_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("FOOD_INTERACTION_REMARKS_CODE")) { 
						food_inter_override_select	=(String)ext_drugData.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("FOOD_INTERACTION_REMARKS_CODE");
					}
					if(ext_drugData.containsKey("LAB_INTERACTION_REMARKS_CODE")) { 
						lab_inter_override_select	=(String)ext_drugData.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("LAB_INTERACTION_REMARKS_CODE");
					}
					//Added for IN:072715 END
				//	System.err.println("ext_drugData@@==="+ext_drugData);
					if(ext_drugData.containsKey("DISEASE_INTERACTION_REMARKS_CODE")) { //Added for MMS-DM-CRF-0229
						disease_inter_override_select	=(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String)ext_drugData.get("DISEASE_INTERACTION_REMARKS_CODE");
					}
						break;
					}
				}
			}
%>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<%
				if(allergy_yn.equals("Y")) {
					HashMap details = null;
					String allergic_indications	= "";
					ArrayList allergyDetails = PresBean.populateAllergyDetails(generic_id,patient_id);
					if((allergyDetails==null || allergyDetails.size()==0 )){
						String ATC_allergy = PresBean.getATCAllergyAlertGeneric(patient_id,generic_id);
						if(ATC_allergy!=null && !ATC_allergy.equals("0")){
							generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
							generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
							allergyDetails = PresBean.populateAllergyDetails(generic_id,patient_id);
						}
					}
					for(int i=0;i<allergyDetails.size();i++){
						details=(HashMap) allergyDetails.get(i);
						if(!allergic_indications.equals(""))
							allergic_indications =  allergic_indications+" - ";
						allergic_indications = allergic_indications+(String)details.get("ALLERGIC_INDICATIONS"); //added allergic_indications+ for IN24641 --29/10/2010-- priya
					}
					if(!allergic_indications.equals("")) {
%>
						<tr>
							<marquee  bgcolor="#CC0000" scrollamount="3"><font color="white" style="font-weight:bold" size=1><fmt:message key="Common.AllergicDescription.label" bundle="${common_labels}"/> :&nbsp;&nbsp;<%=allergic_indications%></font></marquee>
						</tr>
<%	
					}	
%>
					<tr>
						<th  class="data">&nbsp;<fmt:message key="ePH.AllergicOverrideReason.label" bundle="${ph_labels}"/></th>
						<!-- Added for IN:072715 START --> 
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="allergy_remarks_code" id="allergy_remarks_code"  onChange="checkOverrideRemarks(this,'AO',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.allergy,'allergy','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,allergy_override_params,allergy_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td ><label onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.AllergicDetails.label" bundle="${ph_labels}"/> </label>&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="allergy" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=allergy%></textarea>	&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
						</td>
					</tr>
					<tr><td colspan="2"></td></tr>
					<tr><td colspan="2"></td></tr>
					</table>
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr><td colspan="2"></td></tr>
					<tr><td colspan="2"></td></tr>
<% 
				}
				if(limit_ind.equals("N")) {
%>
					<tr>
						<td colspan="2"><marquee bgcolor="#FFCC66" scrollamount="3"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.DailyDose.label" bundle="${ph_labels}"/> : <fmt:message key="Common.maximum.label" bundle="${common_labels}"/>-<%=daily_dose%>,<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/> -<%=min_unit_dose%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.UnitDose.label" bundle="${common_labels}"/>: <fmt:message key="Common.maximum.label" bundle="${common_labels}"/>-<%=unit_dose%>,<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/>-<%=min_daily_dose%></font></marquee></td>
					</tr>
					<tr>
						<th  class="data">&nbsp;<fmt:message key="ePH.BeyondDoseLimitOverrideReason.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</th>
						<!-- dosage_std and dose_unit_desc added for ML-MMOH-SCF-0864 -->
						<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dose_remarks_code" id="dose_remarks_code"  onChange="checkOverrideRemarks(this,'BD',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.exceed_dose,'exceed_dose','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,dose_override_params,dose_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td ><label onClick="showMonoGraph('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>')" style="cursor:pointer;color:blue;font-size:9">Overdose Details</label>&nbsp;&nbsp;&nbsp;</td><!-- Modified for IN:070451  -->
					</tr>
					<tr>
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="exceed_dose" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=exceed_dose%></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</tr>
					<tr><td colspan="2"></td></tr>
					<tr><td colspan="2"></td></tr>
<% 
				}
				if(current_rx.equals("Y")) {
					ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
					HashMap  dup_info		=	null;
					String dup_drug_info	=	"";
					if(curr_info.size()>=1) {
						dup_info	  =	(HashMap)curr_info.get(0);
						dup_drug_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.PatientisCurrentlyOn.label", "ph_labels")+" "+drug_desc+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Medicationtill.label", "ph_labels")+"  "+com.ehis.util.DateUtils.convertDate((String)dup_info.get("end_date"),"DMYHM","en",locale)+";\n";
						dup_drug_info +=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Hasbeenprescribedby.label", "ph_labels")+" "+" "+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.from.label", "common_labels")+dup_info.get("location");
					}
					//if(!dup_drug_info.equals("")) {
%>
					<tr>
						<td colspan="2"><marquee bgcolor="#6699FF" scrollamount="3"><font color="black" style="font-weight:bold" size=1><%=dup_drug_info%></font></marquee></td>
					</tr>
					<tr>
						<th  class="data">&nbsp;<fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</th>
						<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dup_drug_remarks_code" id="dup_drug_remarks_code"  onChange="checkOverrideRemarks(this,'DP',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.dup_drug,'dup_drug','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,dup_drug_override_params,dup_drug_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td ><label onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.DuplicateDrugs.label" bundle="${ph_labels}"/> </label>&nbsp;&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;<textarea rows="3" cols="80" name="dup_drug" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=dup_drug%></textarea>&nbsp;
						<img src="../../eCommon/images/mandatory.gif" align="center">
						
						</td>
					</tr>
					<tr><td colspan="2">&nbsp;</td></tr>
<% 
				}
				if(interaction_exists.equals("Y")) { // added for FD-RUT-CRF-0066.1 [IN036975] -Start
				//MMS-KH-CRF-0029[IN070606] start
					String interaction_type = "";
					String intr_desc = "";
					ArrayList intrType= new ArrayList();
				//MMS-KH-CRF-0029[IN070606] end	

					ArrayList alDrugIntrList = (ArrayList) ext_drugData.get("INTERACTION_DTL");
					if(alDrugIntrList!=null && alDrugIntrList.size()>2){
						HashMap hmDrugInteractionDtl = null;
						for(int intr=0; intr<(alDrugIntrList.size()-2); intr++){
							hmDrugInteractionDtl = (HashMap) alDrugIntrList.get(intr);
							intr_msg_content += (String)hmDrugInteractionDtl.get("intr_name")+", ";
							//MMS-KH-CRF-0029[IN070606] start
							interaction_type = (String)hmDrugInteractionDtl.get("INTR_TYPE2");
							intrType.add(interaction_type);

							if(interaction_type.equals("F")){
									intr_desc = "Drug-Food";
								
							}
							else if(interaction_type.equals("L")){
									intr_desc = "Drug-Lab";
									
							}else if(interaction_type.equals("I")){//Added for MMS-DM-CRF-0229
									intr_desc = "Drug-Disease";
									
							}
							else{
									intr_desc = "Drug-Drug";
							}
						//MMS-KH-CRF-0029[IN070606] end	
						}
					}
					//MMS-KH-CRF-0029[IN070606] start
						String drug_drug_display = "none";
						String drug_food_display = "none";
						String drug_lab_display = "none";
						String drug_disease_display = "none";//Added for MMS-DM-CRF-0229
						String drug_intr_lbl_display="none";
						String food_intr_lbl_display="none";
						String lab_intr_lbl_display="none";
						String disease_intr_lbl_display="none";//Added for MMS-DM-CRF-0229

						if(intrType!=null && intrType.size()>0){
						if(intrType.contains("D") || intrType.contains("G")){
							drug_drug_display = "inline";
							
						}
						if(intrType.contains("F")){
							drug_food_display = "inline";
						}
						if(intrType.contains("L")){
							drug_lab_display = "inline"; 
						}
						if(intrType.contains("I")){//Added for MMS-DM-CRF-0229
							drug_disease_display = "inline"; 
						}
						
						if(drug_drug_display.equals("inline"))
						{
							drug_intr_lbl_display ="inline";
							
						}else{
							if(drug_lab_display.equals("inline")){
								lab_intr_lbl_display="inline";
							}else if(drug_disease_display.equals("inline")){//Added for MMS-DM-CRF-0229
								disease_intr_lbl_display="inline";
							}else {
								food_intr_lbl_display="inline";
							}
						}
						
					} //MMS-KH-CRF-0029[IN070606] end
					if(!intr_msg_content.equals(""))
						intr_msg_content = intr_msg_content.substring(0, intr_msg_content.length()-2);
%>
					<tr style="display:<%=drug_drug_display%>"> <!-- style added for MMS-KH-CRF-0029-->
						<td colspan="2"><marquee bgcolor="#FFD2E9" scrollamount="2"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.Drug-DrugInteractions.label" bundle="${ph_labels}"/>: <%=intr_msg_content%></font></marquee></td>
					</tr>
					<tr style="display:<%=drug_drug_display%>"><!-- style added for MMS-KH-CRF-0029-->
						<td class="COLUMNHEADERCENTER"  class="data">&nbsp;<fmt:message key="ePH.Drug-DrugInteractionOverrideReason.label" bundle="${ph_labels}"/>&nbsp;</td>
						<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="interaction_remarks_code" id="interaction_remarks_code"  onChange="checkOverrideRemarks(this,'DD',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.interaction_remarks,'interaction_remarks','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,inter_override_params,inter_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td class="label"><label onClick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" style="cursor:pointer;color:blue;font-size:9;display:<%=drug_intr_lbl_display%>">Interaction Dtls.</label>&nbsp;</td>
					</tr>
					<tr style="display:<%=drug_drug_display%>"> <!-- style added for MMS-KH-CRF-0029-->
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="interaction_remarks" onKeyPress="javascript:if(event.keyCode != '32'){ return checkMaxLimit(this,255)};" onblur="checkMaxLimit(this,255);" <%=disable_status%>><%=interaction_remarks%></textarea>&nbsp;
						<img src="../../eCommon/images/mandatory.gif" >
						</td>
					</tr><!-- added for MMS-KH-CRF-0029 - start-->
					<tr style="display:<%=drug_food_display%>">
						<td colspan="2"><marquee bgcolor="#FFD2E9" scrollamount="2"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.Drug-FoodInteractions.label" bundle="${ph_labels}"/> : <%=intr_msg_content%></font></marquee></td>
					</tr> 
					<tr style="display:<%=drug_food_display%>">
						<td class="COLUMNHEADERCENTER"  class="data">&nbsp;<fmt:message key="ePH.Drug-FoodInteractionOverrideReason.label" bundle="${ph_labels}"/>&nbsp;</td>
						<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="food_interaction_remarks_code" id="food_interaction_remarks_code"  onChange="checkOverrideRemarks(this,'DF',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.food_interaction_remarks,'food_interaction_remarks','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,food_inter_override_params,food_inter_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td class="label"><label onClick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" style="cursor:pointer;color:blue;font-size:9;display:<%=food_intr_lbl_display%>">Interaction Dtls.</label>&nbsp;</td>
					</tr>
					<tr style="display:<%=drug_food_display%>">
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="food_interaction_remarks" onKeyPress="javascript:if(event.keyCode != '32'){ return checkMaxLimit(this,255)};" onblur="checkMaxLimit(this,255);" <%=disable_status%>><%=food_interaction_remarks%></textarea>&nbsp;

							<img src="../../eCommon/images/mandatory.gif" >

						</td>
					</tr>
					<tr style="display:<%=drug_lab_display%>">
						<td colspan="2"><marquee bgcolor="#FFD2E9" scrollamount="2"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.Drug-LabInteractionOverrideReason.label" bundle="${ph_labels}"/>: <%=intr_msg_content%></font></marquee></td>
					</tr>
					<tr style="display:<%=drug_lab_display%>">
						<td class="COLUMNHEADERCENTER"  class="data">&nbsp;<fmt:message key="ePH.Drug-LabInteractionOverrideReason.label" bundle="${ph_labels}"/>&nbsp;</td>
						<!-- Added for IN:072715 START -->
				<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="lab_interaction_remarks_code" id="lab_interaction_remarks_code"  onChange="checkOverrideRemarks(this,'DL',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.lab_interaction_remarks,'lab_interaction_remarks','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,lab_inter_override_params,lab_inter_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td class="label"><label onClick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" style="cursor:pointer;color:blue;font-size:9;display:<%=lab_intr_lbl_display%>">Interaction Dtls.</label>&nbsp;</td>
					</tr>
					<tr style="display:<%=drug_lab_display%>">
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="lab_interaction_remarks" onKeyPress="javascript:if(event.keyCode != '32'){ return checkMaxLimit(this,255)};" onblur="checkMaxLimit(this,255);" <%=disable_status%>><%=lab_interaction_remarks%></textarea>&nbsp;

							<img src="../../eCommon/images/mandatory.gif" >

						</td>
					</tr> <!-- added for MMS-KH-CRF-0029 - end-->
					<tr style="display:<%=drug_disease_display%>">
						<td colspan="2"><marquee bgcolor="#FFD2E9" scrollamount="2"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.Drug-DiseaseOverrideReason.label" bundle="${ph_labels}"/>: <%=intr_msg_content%></font></marquee></td>
					</tr>
					<tr style="display:<%=drug_disease_display%>">
						<td class="COLUMNHEADERCENTER"  class="data">&nbsp;<fmt:message key="ePH.Drug-DiseaseOverrideReason.label" bundle="${ph_labels}"/>&nbsp;</td>
				<!-- Added for IN:072715 START -->
				<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="disease_interaction_remarks_code" id="disease_interaction_remarks_code"  onChange="checkOverrideRemarks(this,'DI',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.disease_interaction_remarks,'disease_interaction_remarks')"> <%=bean.getOverrideListValues(sql,disease_inter_override_params,disease_inter_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
						<td class="label"><label onClick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" style="cursor:pointer;color:blue;font-size:9;display:<%=disease_intr_lbl_display%>">Interaction Dtls.</label>&nbsp;</td>
					</tr>
					<tr style="display:<%=drug_disease_display%>">
						<td  colspan="2">&nbsp;<textarea rows="3" cols="80" name="disease_interaction_remarks" onKeyPress="javascript:if(event.keyCode != '32'){ return checkMaxLimit(this,255)};" onblur="checkMaxLimit(this,255);" <%=disable_status%>><%=disease_interaction_remarks%></textarea>&nbsp;

					<tr><td colspan="2"></td>&nbsp;</tr>
					<!-- added for MMS-KH-CRF-0029-start -->
					<input type="hidden" name="drug_drug_display" id="drug_drug_display" value="<%=drug_drug_display%>"> 
					<input type="hidden" name="drug_lab_display" id="drug_lab_display" value="<%=drug_lab_display%>"> 
					<input type="hidden" name="drug_food_display" id="drug_food_display" value="<%=drug_food_display%>"> 
					<!-- added for MMS-KH-CRF-0029 end -->
					<input type="hidden" name="drug_disease_display" id="drug_disease_display" value="<%=drug_disease_display%>"> <!-- MMS-DM-CRF-0229 -->
<% 
				} // added for FD-RUT-CRF-0066.1 [IN036975] -End
%>
				<tr>
					<td  colspan="2" align="right">
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="validate(document.DispQueueMgmtHoldReason)"></td>
							
				</tr>
				</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="allergy_yn" id="allergy_yn" value="<%=allergy_yn%>">
				<input type="hidden" name="current_rx" id="current_rx" value="<%=current_rx%>">
				<input type="hidden" name="limit_ind" id="limit_ind" value="<%=limit_ind%>">
				<input type="hidden" name="interaction_exists" id="interaction_exists" value="<%=interaction_exists%>">
				<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
				<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
			</form>
			<!-- Added for IN:072715  -->
		
		<script type="text/javascript">
		<%if(over_ride_remarks_select_appl){%>
		<%if(!(allergy_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.allergy!=null)
			document.DispQueueMgmtHoldReason.allergy.readOnly = true;
 					<%}%>
		<%if(!(dose_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.exceed_dose!=null)
			document.DispQueueMgmtHoldReason.exceed_dose.readOnly = true;
 					<%}%>
		<%if(!(dup_drug_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.dup_drug!=null)
			document.DispQueueMgmtHoldReason.dup_drug.readOnly = true;
 					<%}%>
		<%if(!(inter_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.interaction_remarks!=null)
			document.DispQueueMgmtHoldReason.interaction_remarks.readOnly = true;
 					<%}%>
		<%if(!(food_inter_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.food_interaction_remarks!=null)
			document.DispQueueMgmtHoldReason.food_interaction_remarks.readOnly = true;
 					<%}%>
		<%if(!(lab_inter_override_select.equals("OTHR"))){%>
		if(document.DispQueueMgmtHoldReason.lab_interaction_remarks!=null)
			document.DispQueueMgmtHoldReason.lab_interaction_remarks.readOnly = true;
 					<%}%>
		<%if(!(disease_inter_override_select.equals("OTHR"))){%>//Added for MMS-DM-CRF-0229
		     if(document.DispQueueMgmtHoldReason.disease_interaction_remarks!=null)
			document.DispQueueMgmtHoldReason.disease_interaction_remarks.readOnly = true;
		<%}%>
		<%}%>
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!-- Added for IN:072715  -->
<% 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,PresBean,request); 
			}catch(Exception exception) {
			       exception.printStackTrace();
			 }
%>
	</body>
</html>


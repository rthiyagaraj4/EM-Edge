<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*,eOR.*, ePH.Common.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- Modified for IN:072715  -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
04/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
20/09/2019      IN:071108		    manickavasagam                                          ML-MMOH-CRF-1408
25/06/2020  	IN:072715       	Haribabu  	25/06/2020     Manickavasagam     		MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order        
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/PrescriptionComp.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
		<style>
textarea {
  resize: none;
}
</style>
		<title>Override Reason</title>
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
			String min_daily_dose	= CommonBean.checkForNull(request.getParameter("min_daily_dose"));
			String min_unit_dose	= CommonBean.checkForNull(request.getParameter("min_unit_dose")); 
			String allergy_yn		= CommonBean.checkForNull(request.getParameter("allergy_yn"));
			String current_rx		= CommonBean.checkForNull(request.getParameter("current_rx"));
			String limit_ind		= CommonBean.checkForNull(request.getParameter("limit_ind"));
			String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
			String srl_no			= CommonBean.checkForNull(request.getParameter("srl_no"));
			String dosage_unit		= CommonBean.checkForNull(request.getParameter("dosage_unit"));
			String order_id		    = CommonBean.checkForNull(request.getParameter("order_id"));
			String order_line_num	= CommonBean.checkForNull(request.getParameter("order_line_num"));
			String drug_db_allergy_flag		= CommonBean.checkForNull(request.getParameter("drug_db_allergy_flag"));
			String drug_db_duptherapy_flag  = CommonBean.checkForNull(request.getParameter("drug_db_duptherapy_flag"));
			String drug_db_interface_yn		= CommonBean.checkForNull(request.getParameter("drug_db_interface_yn"));
			//added for ML-MMOH-CRF-1408 - start
			String max_daily_ceiling_dose   = CommonBean.checkForNull(request.getParameter("max_daily_celing_dose"));
			String min_daily_ceiling_dose   = CommonBean.checkForNull(request.getParameter("min_daily_ceiling_dose"));
			String max_unit_ceiling_dose    = CommonBean.checkForNull(request.getParameter("max_unit_ceiling_dose"));
			String min_unit_ceiling_dose   = CommonBean.checkForNull(request.getParameter("min_unit_ceiling_dose"));
			String dose_unit_desc   = CommonBean.checkForNull(request.getParameter("dose_unit_desc"));
			String dose_unit_desc1   = CommonBean.checkForNull(request.getParameter("dose_unit_desc1"));
			String dosage_std		 = CommonBean.checkForNull(request.getParameter("dosage_std"));
			String drug_db_dosecheck_yn = CommonBean.checkForNull(request.getParameter("drug_db_dosecheck_yn")); //ML-MMOH-CRF-1408
System.err.println("max_daily_ceiling_dose==53=>"+max_daily_ceiling_dose);
			//added for ML-MMOH-CRF-1408 - end
			//Added for IN:072715 start
			String allergy_override_select	= CommonBean.checkForNull(request.getParameter("allergy_remarks_code"));
			String dose_override_select	= CommonBean.checkForNull(request.getParameter("dose_remarks_code"));
			String dup_drug_override_select	= CommonBean.checkForNull(request.getParameter("currentrx_remarks_code"));
			//Added for IN:072715 end
			String allergy			= "";
			String exceed_dose		= "";
			String dup_drug			= "";
			HashMap drugReasons     = new HashMap();
			String allergy_override_reason="";
			String dosage_limit_override_reason="";
			String duplicate_drug_override_reason="";
			String allergy_flag="";
			String doselimit_flag="";
			String currentrx_flag="";

			if (request.getParameter("allergy") != null){
				allergy	= java.net.URLDecoder.decode(request.getParameter("allergy")==null?"":request.getParameter("allergy"),"UTF-8");
			}

			if (request.getParameter("exceed_dose") != null){
				exceed_dose	= java.net.URLDecoder.decode(request.getParameter("exceed_dose")==null?"":request.getParameter("exceed_dose"),"UTF-8");
			}

			if (request.getParameter("dup_drug") != null){
				dup_drug =java.net.URLDecoder.decode(request.getParameter("dup_drug")==null?"":request.getParameter("dup_drug"),"UTF-8");
			}

			String bean_id			= "IVPrescriptionBean"+patient_id+encounter_id;
			String bean_name		= "ePH.IVPrescriptionBean";
			IVPrescriptionBean bean = (IVPrescriptionBean)
			getBeanObject(bean_id,bean_name ,request);

			String pr_bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
			String pr_bean_name				= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pr_bean		= (PrescriptionBean_1)getBeanObject( pr_bean_id,pr_bean_name, request  ) ;

			String or_bean_name				= "eOR.OrderEntryBean";
			String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name, request  ) ;
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

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
			
			//Added for IN:072715 END
			
			if(!order_id.equals("") && !order_line_num.equals("")){
				drugReasons=bean.getDrugReasons(order_id,order_line_num,"");
				allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
				if(allergy_override_reason == null || !allergy.equals("")) allergy_override_reason="";
				dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
				if(dosage_limit_override_reason == null) dosage_limit_override_reason="";
				duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
				if((duplicate_drug_override_reason == null) || !dup_drug.equals("")) duplicate_drug_override_reason="";
				/*if(allergy_yn.equals("Y") && !allergy_override_reason.equals("")){
					allergy_flag="disabled";
					allergy_yn="Y";
				}*/
				if(!dosage_limit_override_reason.equals("")) {
					doselimit_flag="disabled";
					//limit_ind="Y";
				}
				/*if(current_rx.equals("Y") && !duplicate_drug_override_reason.equals("")){
					currentrx_flag="disabled";
				 	current_rx	= "Y";
				}*/
			}				
			String called_from		=	orbean.getCalledFromFunction();
			String disable_status	=	"";
			if(called_from!=null && called_from.equals("RENEW_ORDER")) {
				disable_status		=	"disabled";
			}

			if (request.getParameter("allergy") == null && request.getParameter("exceed_dose") == null && request.getParameter("dup_drug") == null) {
				ArrayList prescriptionDetails	=	(ArrayList)bean.getpresDetails();
				for(int j=0;j<prescriptionDetails.size();j++){
					HashMap ext_drugData	=(HashMap) prescriptionDetails.get(j);
					String ext_drug_code	=(String) ext_drugData.get("DRUG_CODE");
					String ext_srl_no		=(String) ext_drugData.get("SRL_NO");
					if( drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no) ){
						if(ext_drugData.containsKey("ALLERGY_REMARKS")) {
							allergy		=	java.net.URLDecoder.decode((String)ext_drugData.get("ALLERGY_REMARKS"));
						}
						if(ext_drugData.containsKey("DOSE_REMARKS")) {
							exceed_dose	=	java.net.URLDecoder.decode((String)ext_drugData.get("DOSE_REMARKS"));
						}

						if(ext_drugData.containsKey("CURRENTRX_REMARKS")) {
							dup_drug	=	java.net.URLDecoder.decode((String)ext_drugData.get("CURRENTRX_REMARKS"));
						}
						//Added for IN:072715 start
						if(allergy_override_select.equals("")){
							allergy_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("ALLERGY_REMARKS_CODE"));	  		
						}
						if(dose_override_select.equals("")){
							dose_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("DOSE_REMARKS_CODE"));	  		
						}
						if(dup_drug_override_select.equals("")){
							dup_drug_override_select			=java.net.URLDecoder.decode( (String)ext_drugData.get("CURRENTRX_REMARKS_CODE"));	  		
						}
						//Added for IN:072715  end
						break;
					}
				}
			}
%>
			<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<%
			//if(drug_db_allergy_flag.equals("N") && (allergy_yn.equals("Y") || !allergy_override_reason.equals(""))){
			if(allergy_yn.equals("Y")){
				HashMap details = null;
				String allergic_indications	= "";
				ArrayList allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
				if((allergyDetails==null || allergyDetails.size()==0 )){
					String ATC_allergy = presBean.getATCAllergyAlertGeneric(patient_id,generic_id);
					if(ATC_allergy!=null && !ATC_allergy.equals("0")){
						generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
						generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
						allergyDetails = presBean.populateAllergyDetails(generic_id,patient_id);
					}
				}
				 for(int i=0;i<allergyDetails.size();i++){
					details=(HashMap) allergyDetails.get(i);
					if(!allergic_indications.equals(""))
						allergic_indications =  allergic_indications+" - ";
					allergic_indications = allergic_indications+(String)details.get("ALLERGIC_INDICATIONS"); //added allergic_indications+ for IN24641 --29/10/2010-- priya
				 }
				if(!allergic_indications.equals("") || !allergy_override_reason.equals("") || !allergy.equals("")) {
%>
					<tr><marquee  bgcolor="#CC0000" scrollamount="3"><font color="white" style="font-weight:bold" size=1>Allergic Description:&nbsp;&nbsp;<%=allergic_indications%></font></marquee></tr>
<%
				}
%>
				<tr>
					<th align="left" class="COLUMNHEADERCENTER">&nbsp;<fmt:message key="ePH.AllergicOverrideReason.label" bundle="${ph_labels}"/></th>
					<!-- Added for IN:072715 START --> 
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="allergy_remarks_code" id="allergy_remarks_code"  onChange="checkOverrideRemarks(this,'AO',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.allergy,'allergy','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,allergy_override_params,allergy_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
					<td align="right"><label onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.AllergicDetails.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td align="left" colspan="2">&nbsp;<textarea rows="3" cols="80" name="allergy" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%> <%=allergy_flag%>><%=allergy%><%=allergy_override_reason%></textarea>&nbsp;<!-- Modified for IN:073485 START -->
<% 
					if(called_from!=null && !called_from.equals("RENEW_ORDER")) { 
%>
						<img src="../../eCommon/images/mandatory.gif" align="center"><!-- Modified for IN:073485 START -->
<%
					}	
%>
					</td>
				</tr>
				<tr><td colspan="2"></td></tr>
				<tr><td colspan="2"></td></tr>
				</table>
				<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
				<tr><td colspan="2"></td></tr>
				<tr><td colspan="2"></td></tr>
<%			}
			if( (limit_ind.equals("N") || !dosage_limit_override_reason.equals(""))) { // changed drug_db_interface_yn to drug_db_dosecheck_yn for ML-MMOH-CRF-1408//drug_db_dosecheck_yn.equals("N") && removed for mms-dm-crf-0209.1
%>
				<tr>
					<td colspan="2"><marquee bgcolor="#FFCC66" scrollamount="3"><font color="black" style="font-weight:bold" size=1>Daily Dose: Maximum-<%=daily_dose%>,Minimum-<%=min_unit_dose%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Unit Dose: Maximum-<%=unit_dose%>,Minimum-<%=min_daily_dose%></font></marquee></td>
				</tr>
				<tr>
					<th align="left" class="data">&nbsp;Beyond Dose Limit Override Reason&nbsp;&nbsp;</th>
					<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dose_remarks_code" id="dose_remarks_code"  onChange="checkOverrideRemarks(this,'BD',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.exceed_dose,'exceed_dose','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,dose_override_params,dose_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
					<td align="left" ><label onClick="showMonoGraph('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=dose_unit_desc%>','<%=dose_unit_desc1%>')"  style="cursor:pointer;color:blue;font-size:9">Overdose Details</label>&nbsp;&nbsp;&nbsp;</td>
				<!-- modified for ML-MMOH-CRF-1408-->
				</tr> 
				<tr>
					<td align="left" colspan="2">&nbsp;<textarea rows="3" cols="80" name="exceed_dose" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%><%=doselimit_flag%>><%=exceed_dose%><%=dosage_limit_override_reason%></textarea>&nbsp;
	<% if(called_from!=null && !called_from.equals("RENEW_ORDER")) { %>
	<img src="../../eCommon/images/mandatory.gif" align="center">
	<%	}	%>
	</td>
</tr>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<% }
	
	if(drug_db_duptherapy_flag.equals("N") && (current_rx.equals("Y") || !duplicate_drug_override_reason.equals(""))) {

	  //  out.println("in side line 205");		

		ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
		HashMap  dup_info		=	null;
		String dup_drug_info	=	"";

		if(curr_info.size()>=1) {
			dup_info	  =	(HashMap)curr_info.get(0);
			dup_drug_info = "Patient is Currently On this Medication till :"+dup_info.get("end_date")+";\n";
			dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
		}

		if(!dup_drug_info.equals("") || !duplicate_drug_override_reason.equals("") || !dup_drug.equals("") || current_rx.equals("Y")) {
%>
<tr>
	<td colspan="2"><marquee bgcolor="#6699FF" scrollamount="3"><font color="black" style="font-weight:bold" size=1><%=dup_drug_info%></font></marquee></td>
</tr>
<tr>
	<th align="left" class="data">&nbsp;Duplicate Drug Override Reason&nbsp;&nbsp;</th>
	<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dup_drug_remarks_code" id="dup_drug_remarks_code"  onChange="checkOverrideRemarks(this,'DP',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.dup_drug,'dup_drug','<%=patient_id%>','<%=encounter_id%>')"> <%=bean.getOverrideListValues(sql,dup_drug_override_params,dup_drug_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
	<td align="left"><label onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')" style="cursor:pointer;color:blue;font-size:9">Duplicate Drugs</label>&nbsp;&nbsp;&nbsp;</td>
</tr>
<%	}	%>
<tr>
	<td align="left" colspan="2">&nbsp;<textarea rows="3" cols="80" name="dup_drug" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%> <%=currentrx_flag%>> <%=dup_drug%> <%=duplicate_drug_override_reason%></textarea>&nbsp;
	<% if(called_from!=null  && !called_from.equals("RENEW_ORDER")) { %>
	<img src="../../eCommon/images/mandatory.gif" align="center">
	<%	}	%>
	</td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<% } %>
<tr>
			<td align="center" colspan="2">
			<% if(called_from!=null && called_from.equals("RENEW_ORDER")) { %>
				<input type="button" value=" Close " class="button" onClick="window.close()"></td>
			<%	} else {	%>
				<input type="button" value=" OK " class="button" onClick="validate(document.DispQueueMgmtHoldReason)"></td>
			<%	}	

				putObjectInBean(bean_id,bean,request);
				putObjectInBean(or_bean_id,orbean,request);
				putObjectInBean(pr_bean_id,pr_bean,request);
				putObjectInBean(presBean_id,presBean,request);
%>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="allergy_yn" id="allergy_yn" value="<%=allergy_yn%>">
			<input type="hidden" name="current_rx" id="current_rx" value="<%=current_rx%>">
			<input type="hidden" name="limit_ind" id="limit_ind" value="<%=limit_ind%>">
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">
		</form>
		<!-- Added for IN:072715 start -->
		
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
		<%}%>
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<!-- Added for IN:072715 end -->
	</body>
</html>
<%

}catch(Exception exception) {
       exception.printStackTrace();
 }
%>


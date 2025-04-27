<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
25/06/2020  IN:072715       Haribabu            25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                    PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- Modified for IN:072715 START -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
        request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../js/OncologyRegimen.js"></script>
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
	String min_daily_dose	= CommonBean.checkForNull(request.getParameter("min_daily_dose"));
	String min_unit_dose	= CommonBean.checkForNull(request.getParameter("min_unit_dose")); 
	String allergy_yn		= CommonBean.checkForNull(request.getParameter("allergy_yn"));
	String current_rx		= CommonBean.checkForNull(request.getParameter("current_rx"));
	String limit_ind		= CommonBean.checkForNull(request.getParameter("limit_ind"));
	String drug_code		= CommonBean.checkForNull(request.getParameter("drug_code"));
	String srl_no			= CommonBean.checkForNull(request.getParameter("srl_no"));
	String dosage_unit		= CommonBean.checkForNull(request.getParameter("dosage_unit"));
	//Added for IN:070451
	String dosage_std		= CommonBean.checkForNull(request.getParameter("dosage_std"));
	String max_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_daily_ceeling_dose"));
	String min_daily_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_daily_ceeling_dose"));
	String max_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("max_unit_ceeling_dose"));
	String min_unit_ceeling_dose			= CommonBean.checkForNull(request.getParameter("min_unit_ceeling_dose"));
	String dose_unit_desc			= CommonBean.checkForNull(request.getParameter("dose_unit_desc"));
	String dose_unit_desc1			= CommonBean.checkForNull(request.getParameter("dose_unit_desc1"));
	//Added for IN:070451
	
	//Added for IN:072715 start
			String allergy_override_select	= CommonBean.checkForNull(request.getParameter("allergy_remarks_code"));
			String dose_override_select	= CommonBean.checkForNull(request.getParameter("dose_remarks_code"));
			String dup_drug_override_select	= CommonBean.checkForNull(request.getParameter("currentrx_remarks_code"));
			
			//Added for IN:072715 end
	
	String amend_serial_no  = request.getParameter("amend_serial_no") == null ? "":request.getParameter("amend_serial_no");
	String drug_db_allergy_flag		= CommonBean.checkForNull(request.getParameter("drug_db_allergy_flag"));
	String drug_db_duptherapy_flag  = CommonBean.checkForNull(request.getParameter("drug_db_duptherapy_flag"));
	String drug_db_interface_yn		= CommonBean.checkForNull(request.getParameter("drug_db_interface_yn"));

	String allergy			= "";
	String exceed_dose		= "";
	String dup_drug			= "";


	if (request.getParameter("allergy") != null){
		allergy	= java.net.URLDecoder.decode(request.getParameter("allergy"));
	}

	if (request.getParameter("exceed_dose") != null){
		exceed_dose	= java.net.URLDecoder.decode(request.getParameter("exceed_dose"));
	}

	if (request.getParameter("dup_drug") != null){
		dup_drug =java.net.URLDecoder.decode(request.getParameter("dup_drug"));
	}

	String bean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name				= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
	String pres_bean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String pres_bean_name		= "ePH.PrescriptionBean";
	PrescriptionBean Pres_bean	= (PrescriptionBean)getBeanObject( pres_bean_id,pres_bean_name,request);
	Pres_bean.setLanguageId(locale);
	String called_from				=	orbean.getCalledFromFunction();
	String disable_status			=	"";

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

	int over_ride_serial_no			= 0;
	ArrayList prescriptionDetails	=	new ArrayList();
	HashMap ext_drugData			=   new HashMap();

	if(!amend_serial_no.equals("")&&amend_serial_no!=null){
		//over_ride_serial_no			=(Integer.parseInt(amend_serial_no)-1);
		over_ride_serial_no			=(Integer.parseInt(amend_serial_no));
		prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
	}

	if(called_from!=null && called_from.equals("AMEND_ORDER")) {
		//disable_status		=	"disabled";

		for(int j=0;j<prescriptionDetails.size();j++){
			ext_drugData				=(HashMap) prescriptionDetails.get(j);
			if(ext_drugData.get("DRUG_CODE").equals(drug_code) && ext_drugData.get("SRL_NO").equals(over_ride_serial_no)){
				over_ride_serial_no			=j;	
			break;
			}
		}
	}

	      /*   if(!amend_serial_no.equals("")&&amend_serial_no!=null){
			   
			   ext_drugData				=(HashMap) prescriptionDetails.get(over_ride_serial_no);
               
				 if(ext_drugData.containsKey("ALLERGY_REMARKS")) {
						if(ext_drugData.get("ALLERGY_REMARKS") != null && !ext_drugData.get("ALLERGY_REMARKS").equals("")){
							allergy		=	java.net.URLDecoder.decode((String)ext_drugData.get("ALLERGY_REMARKS"));
						}
				 }

				if(ext_drugData.containsKey("DOSE_REMARKS")) {
					exceed_dose	=	java.net.URLDecoder.decode((String)ext_drugData.get("DOSE_REMARKS"));
				}

				if(ext_drugData.containsKey("CURRENTRX_REMARKS")) {
					if(ext_drugData.get("CURRENTRX_REMARKS") != null && !ext_drugData.get("CURRENTRX_REMARKS").equals("")){
						dup_drug	=	java.net.URLDecoder.decode((String)ext_drugData.get("CURRENTRX_REMARKS"));
					}

				}
			 }*/

		if(called_from!=null && called_from.equals("AMEND_ORDER")){
		    int srlNo =0;
			HashMap Existingrecord;
			ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();			  

			if(!amend_serial_no.equals("")){				
				srlNo				= Integer.parseInt(amend_serial_no);

				Existingrecord  	= (HashMap) getExistingCYTORecords.get(srlNo);
				if(allergy.equals("")){
					allergy	        = java.net.URLDecoder.decode((String)Existingrecord.get("ALLERGY_OVERRIDE_REASON"));
				}
				if(exceed_dose.equals("")){//Modified for IN:072715 if condition added to fix exsting bug
				exceed_dose		= java.net.URLDecoder.decode((String)Existingrecord.get("DOSAGE_LIMIT_OVERRIDE_REASON"));
				}

				if(dup_drug.equals("")){
					 dup_drug			=java.net.URLDecoder.decode( (String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON"));	  		
				}
				//Added for IN:072715 start
				if(allergy_override_select.equals("")){
					allergy_override_select			=java.net.URLDecoder.decode( (String)Existingrecord.get("ALLERGY_REMARKS_CODE"));	  		
				}
				if(dose_override_select.equals("")){
					dose_override_select			=java.net.URLDecoder.decode( (String)Existingrecord.get("DOSE_REMARKS_CODE"));	  		
				}
				if(dup_drug_override_select.equals("")){
					dup_drug_override_select			=java.net.URLDecoder.decode( (String)Existingrecord.get("CURRENTRX_REMARKS_CODE"));	  		
				}
				//Added for IN:072715  end
				
			} 
		}
		  /*else{
              if(!amend_serial_no.equals("")&&amend_serial_no!=null){
               ArrayList prescriptionDetails	=	(ArrayList)bean.getDrugDetails();
               int over_ride_serial_no			=(Integer.parseInt(amend_serial_no)-1);
			   HashMap ext_drugData				=(HashMap) prescriptionDetails.get(over_ride_serial_no);


                 if(ext_drugData.containsKey("ALLERGY_REMARKS")) {
						allergy		=	java.net.URLDecoder.decode((String)ext_drugData.get("ALLERGY_REMARKS"));
					}

					if(ext_drugData.containsKey("DOSE_REMARKS")) {
						exceed_dose	=	java.net.URLDecoder.decode((String)ext_drugData.get("DOSE_REMARKS"));
					}

					if(ext_drugData.containsKey("CURRENTRX_REMARKS")) {
						dup_drug	=	java.net.URLDecoder.decode((String)ext_drugData.get("CURRENTRX_REMARKS"));
					}
				}
		  }*/

%>

<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<% if(drug_db_allergy_flag.equals("N") && (allergy_yn.equals("Y"))) {
	HashMap details = null;
	String allergic_indications	= "";
	ArrayList allergyDetails = bean.populateAllergyDetails(generic_id,patient_id);
		if((allergyDetails==null || allergyDetails.size()==0 )){
			String ATC_allergy = Pres_bean.getATCAllergyAlertGeneric(patient_id,generic_id);
			if(ATC_allergy!=null && !ATC_allergy.equals("0")){
				generic_id = ATC_allergy.substring(0,ATC_allergy.indexOf('~'));
				generic_name = ATC_allergy.substring(ATC_allergy.indexOf('~')+1);
				allergyDetails = Pres_bean.populateAllergyDetails(generic_id,patient_id);
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
<tr><marquee  bgcolor="#CC0000" scrollamount="3"><font color="white" style="font-weight:bold" size=1><fmt:message key="Common.AllergicDescription.label" bundle="${common_labels}"/>:&nbsp;&nbsp;<%=allergic_indications%></font></marquee></tr>
<%	}	%>
<tr>
	<th class="data">&nbsp;<fmt:message key="ePH.AllergicOverrideReason.label" bundle="${ph_labels}"/></th>
	<!-- Added for IN:072715 START --> 
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="allergy_remarks_code" id="allergy_remarks_code"  onChange="checkOverrideRemarks(this,'AO',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.allergy,'allergy')"> <%=bean.getOverrideListValues(sql,allergy_override_params,allergy_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
	<td ><label onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.AllergicDetails.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
	<td colspan="2">&nbsp;<textarea rows="3" cols="80" name="allergy" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=allergy%></textarea>&nbsp;<!-- Modified for IN:073485 START -->
	<% if(called_from!=null && !called_from.equals("AMEND_ORDER")) { %>
	<img src="../../eCommon/images/mandatory.gif" align="center"><!-- Modified for IN:073485 START -->
	<%	}	%>
	</td>
</tr>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
</table>
<table cellpadding="0" cellspacing="0" width="102%" align="center" border="0">
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<% }
	if(drug_db_interface_yn.equals("N") && (limit_ind.equals("N"))) {%>
<tr>
	<td colspan="2"><marquee bgcolor="#FFCC66" scrollamount="3"><font color="black" style="font-weight:bold" size=1><fmt:message key="ePH.DailyDose.label" bundle="${ph_labels}"/>: <fmt:message key="Common.maximum.label" bundle="${common_labels}"/>-<%=daily_dose%><%=dosage_unit%>,<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/>-<%=min_unit_dose%>
	<%=dosage_unit%>&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;<fmt:message key="Common.UnitDose.label" bundle="${common_labels}"/>: <fmt:message key="Common.maximum.label" bundle="${common_labels}"/>-<%=unit_dose%><%=dosage_unit%>,<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/>-<%=min_daily_dose%>
	<%=dosage_unit%></font></marquee>
	</td>
</tr>
<tr>
	<th class="data">&nbsp;<fmt:message key="ePH.BeyondDoseLimitOverrideReason.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</th>
	<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dose_remarks_code" id="dose_remarks_code"  onChange="checkOverrideRemarks(this,'BD',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.exceed_dose,'exceed_dose')"> <%=bean.getOverrideListValues(sql,dose_override_params,dose_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
	<td ><label onClick="showMonoGraph('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>')" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.OverdoseDetails.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;&nbsp;</td><!-- Modified for IN:070451  -->
</tr>
<tr>
	<td colspan="2">&nbsp;<textarea rows="3" cols="80" name="exceed_dose" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=exceed_dose%></textarea>&nbsp;
	<% if(called_from!=null && !called_from.equals("AMEND_ORDER")) { %>
	<img src="../../eCommon/images/mandatory.gif" align="center">
	<%	}	%>
	</td>
</tr>
<tr><td colspan="2"></td></tr>
<tr><td colspan="2"></td></tr>
<% }
	
	if(drug_db_duptherapy_flag.equals("N") && (current_rx.equals("Y"))) {
     
		ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
		HashMap  dup_info		=	null;
		String dup_drug_info	=	"";

		if(curr_info.size()>=1) {
			dup_info	  =	(HashMap)curr_info.get(0);
			dup_drug_info = "Patient is Currently On this Medication till :"+dup_info.get("end_date")+";\n";
			dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
		}
         

%>
<tr>
	<td colspan="2"><marquee bgcolor="#6699FF" scrollamount="3"><font color="black" style="font-weight:bold" size=1><%=dup_drug_info%></font></marquee></td>
</tr>
<tr>
	<th class="data">&nbsp;<fmt:message key="ePH.DuplicateDrugOverrideReason.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</th>
	<!-- Added for IN:072715 START -->
					<%if(over_ride_remarks_select_appl){ %>
						<td class="fields">&nbsp;
					<select name="dup_drug_remarks_code" id="dup_drug_remarks_code"  onChange="checkOverrideRemarks(this,'DP',document.DispQueueMgmtHoldReason,document.DispQueueMgmtHoldReason.dup_drug,'dup_drug')"> <%=bean.getOverrideListValues(sql,dup_drug_override_params,dup_drug_override_select) %> </select>
					</td>
					<%} %>
					<!-- Added for IN:072715 END -->
	<td ><label onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')" style="cursor:pointer;color:blue;font-size:9"><fmt:message key="ePH.DuplicateDrugs.label" bundle="${ph_labels}"/></label>&nbsp;&nbsp;&nbsp;</td>
</tr>
<%	//}	%>
<tr>
	<td colspan="2">&nbsp;<textarea rows="3" cols="80" name="dup_drug" onKeyPress="return checkMaxLimit(this,255);" <%=disable_status%>><%=dup_drug%></textarea>&nbsp;
	<% if(called_from!=null  && !called_from.equals("AMEND_ORDER")) { %>
	<img src="../../eCommon/images/mandatory.gif" align="center">
	<%	}	%>
	</td>
</tr>
<tr><td colspan="2">&nbsp;</td></tr>
<% } %>
<tr>
			<td colspan="2">			
				<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="validate(document.DispQueueMgmtHoldReason)"></td>
			
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
		<%}%>
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!-- Added for IN:072715  -->
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,orbean,request);
}
catch(Exception e){
	e.printStackTrace();
}				
%>


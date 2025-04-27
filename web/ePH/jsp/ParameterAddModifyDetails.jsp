<!DOCTYPE html>
 <!--This file is saved on 07/11/2005  modified on 08/02/2017 for AAKH-CRF-0094-->
<%-- Modified By Surendra Reddy
	Modification ::
		Now the function will work depending on the licenceRights
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
    <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
<!-- <script language="JavaScript" src="../js/PhMessages.js"></script>
 --> <script language="JavaScript" src="../js/Parameter.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 <script>
 function tab_click1(id){
	selectTab(id);
	callPrescriptionRules();
}
 function tab_click2(id){
	selectTab(id);
	callDispensingRules();
}
 
 function tab_click3(id){
	selectTab(id);
	callDrugDatabaseInterface();
}

 function tab_click4(id){

    selectTab(id);
    callProcessNames();
}
 </script>
</head>
<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
try{
    /* Mandatory checks start */
    String mode                     ="";
    String bean_id                  = "Phparameter" ;
    String bean_name                = "ePH.ParameterBean";
   // String st_install_yn           = "";
    String disabled                 = "" ;
    String checked                  = "";
    //boolean allow_modify            = false;
   // String drug_item_code_link      = "";
    String max_pres_duration        = "";
	String max_pres_duration_dm= "";
    String licenseValue="";
	String prescription_duration    = "";
    String dispense_value_strength  = "";
	String disp_alt_form_yn			= "";
	String allow_sel_by_atc_yn		= "";
    String allow_dispense           = "";
    String no_days_ahead            = "";
    String allow_past_dispense      = "";
    String upto_days                = "";
	String inpatient_yn				= "";
	String licenseYN				= "";
	String drug_db_interface_yn		= "";
	String regn_stage_prompt		= "";
	String verify_stage_prompt		= "";
	String fill_stage_prompt		= "";
	String allocate_stage_prompt    = "";
	String bill_receipt_stage_prompt= "";
	String deliver_stage_prompt		= "";

	String iv_with_additives        = "";
	String iv_intermittent          = "";
	String iv_without_additives     = "";
	String print_alt_drug_dosage_qty_yn		= "";
	String issue_uom_by		= "";
	String DUOM="";
	String IUOM="";
	String first_trim_from ="";	//added for  RUT-CRF-0063 [IN:029601] -start
	String first_trim_to   ="";
	String second_trim_from="";
	String second_trim_to  ="";
	String third_trim_from ="";
	String third_trim_to   ="";
	String disp_no_preg_dtl_yn="N";
	String infusion_over_app_yn="Y";//added for AAKH-CRF-0094
	String infusion_over_app_yn_chk="";//added for AAKH-CRF-0094	
	String preg_checked="";
	String opt_sel	=	""; //added for  RUT-CRF-0063 [IN:029601] -end
	String iv_calc_infuse_by	=	"D"; //added for  SKR-CRF-0035 [IN:037747] -end

    HashMap existrec                = new HashMap();

	String licenceRights = PhLicenceRights.getKey();
	ParameterBean bean = (ParameterBean)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(locale);
	existrec       = (HashMap)bean.loadExistData();
	inpatient_yn	= bean.ipInstallYN();
    if(existrec!=null){
        mode                    =CommonRepository.getCommonKeyValue("MODE_MODIFY") ;
   //     drug_item_code_link     =(String)existrec.get("drug_item_code_link_reqd_yn");
        max_pres_duration       =(String)existrec.get("max_durn_for_op_pres");
        prescription_duration   =(String)existrec.get("max_durn_for_ip_pres");
		max_pres_duration_dm =(String)existrec.get("max_durn_for_dm_pres");
		if(max_pres_duration_dm==null)
			max_pres_duration_dm="";

		if(inpatient_yn .equals("N")){
            prescription_duration ="0";
		}
		if(prescription_duration!=null && prescription_duration.equals("0"))
			prescription_duration="";

        //alternate_drug_selection=(String)existrec.get("alt_drug_sel_criteria");
        dispense_value_strength =(String)existrec.get("disp_multi_strength_yn");
		allow_sel_by_atc_yn		=(String)existrec.get("allow_sel_by_atc_yn");

		disp_alt_form_yn		=(String)existrec.get("disp_alt_form_yn");
        allow_dispense          =(String)existrec.get("disp_before_start_date_yn");
        no_days_ahead           =(String)existrec.get("disp_before_no_of_days");
         if(no_days_ahead!=null && no_days_ahead.equals("0"))
			 no_days_ahead="";
        allow_past_dispense     =(String)existrec.get("disp_beyond_earliest_start_yn");
        upto_days               =(String)existrec.get("disp_beyond_no_of_days");
		print_alt_drug_dosage_qty_yn		=(String)existrec.get("print_alt_drug_dosage_qty_yn");

          if(upto_days!=null && upto_days.equals("0"))upto_days="";

       // if( (st_install_yn.equals("Y")) && (drug_item_code_link.equals("X")) ){
          //  allow_modify=true;
       // }

		if(((String)existrec.get("drug_db_interface_yn")).equals("Y")){
			drug_db_interface_yn = "checked";
		}
       
		/*
		if(existrec.get("drug_db_interface_name")!=null){
			drug_db_interface_name = (String)existrec.get("drug_db_interface_name");
		}
		
		if(((String)existrec.get("drug_db_dosecheck_yn")).equals("Y")){
			drug_db_dosecheck_yn = "checked";
			}
		if(((String)existrec.get("drug_db_duptherapy_yn")).equals("Y")){
			drug_db_duptherapy_yn = "checked";
		}

		if(((String)existrec.get("drug_db_interact_check_yn")).equals("Y")){
			drug_db_interaction_yn = "checked";
		}
		if(((String)existrec.get("drug_db_contraind_check_yn")).equals("Y")){
			drug_db_contracheck_yn = "checked";
		}
		if(((String)existrec.get("drug_db_allergy_check_yn")).equals("Y")){
			drug_db_alergycheck_yn = "checked";
		}*/    
          
		if(existrec.get("regn_stage_prompt")!= null){
			regn_stage_prompt = (String)existrec.get("regn_stage_prompt");
		}
		if(existrec.get("verify_stage_prompt")!= null){
			verify_stage_prompt = (String)existrec.get("verify_stage_prompt");
		}
		if(existrec.get("fill_stage_prompt")!= null){
			fill_stage_prompt = (String)existrec.get("fill_stage_prompt");
		}
		if(existrec.get("allocate_stage_prompt")!= null){
			allocate_stage_prompt = (String)existrec.get("allocate_stage_prompt");
		}
		if(existrec.get("bill_receipt_stage_prompt")!= null){
			bill_receipt_stage_prompt = (String)existrec.get("bill_receipt_stage_prompt");
		}
		if(existrec.get("deliver_stage_prompt")!= null){
			deliver_stage_prompt = (String)existrec.get("deliver_stage_prompt");
		}
		if(existrec.get("iv_with_additives")!= null){
			iv_with_additives = (String)existrec.get("iv_with_additives");
		}
		if(existrec.get("iv_intermittent")!= null){
			iv_intermittent = (String)existrec.get("iv_intermittent");
		}
		if(existrec.get("iv_without_additives")!= null){
			iv_without_additives = (String)existrec.get("iv_without_additives");
		}
		if(existrec.get("issue_uom_by")!= null){
		issue_uom_by=(String)existrec.get("issue_uom_by");
		}
		//added for  RUT-CRF-0063 [IN:029601] -start
		if(existrec.get("first_trim_from")!= null){
			first_trim_from =existrec.get("first_trim_from")==null?"":(String)existrec.get("first_trim_from");
		} 
		if(existrec.get("first_trim_to")!= null){
			first_trim_to   =existrec.get("first_trim_to")==null?"":(String)existrec.get("first_trim_to");
		}
		if(existrec.get("second_trim_from")!= null){
			second_trim_from=existrec.get("second_trim_from")==null?"":(String)existrec.get("second_trim_from");
		}
		if(existrec.get("second_trim_to")!= null){
			second_trim_to  =existrec.get("second_trim_to")==null?"":(String)existrec.get("second_trim_to");
		}
		if(existrec.get("third_trim_from")!= null){
			third_trim_from =existrec.get("third_trim_from")==null?"":(String)existrec.get("third_trim_from");
		}
		if(existrec.get("third_trim_to")!= null){
			third_trim_to   =existrec.get("third_trim_to")==null?"":(String)existrec.get("third_trim_to");
		}
		if(existrec.get("DISP_NO_PREG_DTL_YN")!= null){
			disp_no_preg_dtl_yn   =existrec.get("DISP_NO_PREG_DTL_YN")==null?"":(String)existrec.get("DISP_NO_PREG_DTL_YN");
		}	  //adding end for  RUT-CRF-0063 [IN:029601] -end
		if(existrec.get("IV_CALC_INFUSE_BY")!= null){ //Added for SKR-CRF-0035 [IN:037747]
			iv_calc_infuse_by   =existrec.get("IV_CALC_INFUSE_BY")==null?"D":(String)existrec.get("IV_CALC_INFUSE_BY");
		}
		//added for aakh-crf-0094
		if(existrec.get("INFUSION_OVER_APP_YN")!= null){
			infusion_over_app_yn   =existrec.get("INFUSION_OVER_APP_YN")==null?"":(String)existrec.get("INFUSION_OVER_APP_YN");
		}//end aakh-crf-0094
	}
    else{
		mode=CommonRepository.getCommonKeyValue("MODE_INSERT") ;
    }
%>
<form name="parameter_detail_form" id="parameter_detail_form" >
     <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" >
      	<%
			String display="none";
		%>
		<tr>
			<td width= "180%" class="white">
			 <ul id="tablist" class="tablist" >

			 <li class="tablistitem" title='<fmt:message key="ePH.PrescriptionRules.label" bundle="${ph_labels}"/>'>
			 <a onclick="tab_click1('PrescriptionRules_tab')" class="tabClicked" id="PrescriptionRules_tab" >
				<span class="tabSpanclicked" id="PrescriptionRules_tabspan">
				<fmt:message key="ePH.PrescriptionRules.label" bundle="${ph_labels}"/></span>
				</a>
			</li>


			<%
			if (!licenceRights.equals("PHBASIC")){
		%> 
		<li class="tablistitem" title='<fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/>'>
			 <a onclick="tab_click2('DispensingRules_tab')" class="tabA" id="DispensingRules_tab" >
				<span class="tabAspan" id="DispensingRules_tabspan">
				<fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
		<%
		  }else
			{
				display="inline";
			}
		%>
		
         <li class="tablistitem" title='<fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/>'>
			 <a onclick="tab_click3('drug_database_interface_tab')" class="tabA" id="drug_database_interface_tab" >
				<span class="tabAspan" id="drug_database_interface_tabspan">
				<fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/></span>
				</a>
			</li>
	       
		<%
		if (!licenceRights.equals("PHBASIC")){
		%>
		<li class="tablistitem" title='<fmt:message key="Common.ProcessName.label" bundle="${common_labels}"/>'>
			 <a onclick="tab_click4('Process_Name_tab')" class="tabA" id="Process_Name_tab" >
				<span class="tabAspan" id="Process_Name_tabspan">
				<fmt:message key="Common.ProcessName.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<%
		}
		%>
		</ul>
		</td>
		</tr>
     </table>
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="prescription_rules" style="display:<%=display%>">
		<tr>
			<th colspan="3"><fmt:message key="ePH.OutpatientEncounters.label" bundle="${ph_labels}"/>  </th>
		</tr>
        <tr>
            <td class="label" width="30%"><fmt:message key="ePH.MaxPrescriptionDurationForOutPatients.label" bundle="${ph_labels}"/></td>
			<td   colspan="2" >
        <%
          if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
        %>
               <input type="text" size="3" maxlength="3" name="max_pres_duration" id="max_pres_duration" value="" onKeyPress="return(ChkNumberInput(this,event,0));" class="NUMBER" onBlur="checkIsNotZero(this, 'Max Prescription Duration');checkSplChars(this);">
        <%
          }else{
        %>
				<input type="text" size="3" maxlength="3" name="max_pres_duration" id="max_pres_duration" value="<%=max_pres_duration%>" onKeyPress="return(ChkNumberInput(this,event,0));" class="NUMBER" onBlur="checkIsNotZero(this, 'Max Prescription Duration');checkSplChars(this);">
         <%
         }
         %>
            &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
            </td>
        </tr>
	    <tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>

		<!--Disharge Medications-->	
		<tr>
			<th colspan="3"><fmt:message key="ePH.DischargeMedications.label" bundle="${ph_labels}"/>  </th>
		</tr>
        <tr>
            <td class="label" width="30%"><fmt:message key="ePH.MaxPrescriptionDurationforDischargeMedications.label" bundle="${ph_labels}"/></td>
			<td  colspan="2" >
		
        <%
          if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
        %>
               <input type="text" size="3" maxlength="3" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="" onKeyPress="return(ChkNumberInput(this,event,0));" class="NUMBER" onBlur="checkIsNotZero(this, 'MaxPrescriptionDurationforDischargeMedications');checkSplChars(this);">
        <%
          }else{
        %>
				<input type="text" size="3" maxlength="3" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="<%=max_pres_duration_dm%>" onKeyPress="return(ChkNumberInput(this,event,0));" class="NUMBER" onBlur="checkIsNotZero(this, 'MaxPrescriptionDurationforDischargeMedications');checkSplChars(this);">
         <%
         }
         %>   
            &nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
            </td>
        </tr>
	    <tr>
			<td colspan="3" class="label">&nbsp;</td>
		</tr>
		<tr>
	        <th colspan="4"><fmt:message key="ePH.Inpatient/OtherEncounters.label" bundle="${ph_labels}"/> </th>
		</tr>
        <tr>
            <td class="label" width="30%" ><fmt:message key="ePH.MaxPrescriptionDurationforInpatients.label" bundle="${ph_labels}"/></td>
            <td  colspan="2" >
                 <%
                   if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						prescription_duration="";
				   }

				   if(inpatient_yn.equals("Y")) disabled="";
					 	else disabled="disabled";
					%>
                 <input type="text" size="3" maxlength="3" name="prescription_duration" id="prescription_duration" value="<%=prescription_duration%>"  onKeyPress="return(ChkNumberInput(this,event,0));" <%=disabled%> class="NUMBER" onBlur="checkIsNotZero(this, 'Max Prescription Duration for Inpatients');checkSplChars(this);">
			&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id="prescription_duration_man" style="visibility:hidden" ></img>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
            <%
					if(inpatient_yn.equals("Y")){
					%>
							<script>validatePrescriptionDuration("Y")</script>
					<%
					}
					else{
					%>
							<script>validatePrescriptionDuration("N")</script>
					<%
					}
			%>
            </td>
        </tr>
        <tr><td colspan="3" class="label">&nbsp;</td></tr>
		<!-- added for  RUT-CRF-0063 [IN:029601] -->
        <th colspan="3"><fmt:message key="ePH.TrimesterSetUp.label" bundle="${ph_labels}"/> </th>
		<tr>
			<td class="label" width="30%" > <fmt:message key="ePH.FirstTrimester.label" bundle="${ph_labels}"/> </td>
			<td class="label" width="15%" >
				<select name="first_trimster_from" id="first_trimster_from" onblur="chkweeks(first_trimster_from, first_trimster_to, 'F')";>
					<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%    
					 for(int i=0;i<44;i++){
						if(!first_trim_from.equals("")){
							if(Integer.parseInt(first_trim_from) == (i+1))
								opt_sel = "selected";
							else
								opt_sel = "";
						}
		
%>
						<option value="<%=i+1%>" <%=opt_sel%>><%=i+1%></option>
<%  
					}
%>

				</select>
				&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
				</td>
				<td class="label" width="*" >
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				&nbsp;&nbsp;<select name="first_trimster_to" id="first_trimster_to"  onblur="chkweeks(first_trimster_from, first_trimster_to, 'T')">
					<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%       
					for(int i=0;i<44;i++){
						if(!first_trim_to.equals("")){
							if(Integer.parseInt(first_trim_to) == (i+1)){
								opt_sel = "selected";
							}
							else
								opt_sel = "";
							}
%>
							<option value="<%=i+1%>" <%=opt_sel%>><%=i+1%></option>
<%  
					}
%>
					</select>
					&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
<%
	                   if(disp_no_preg_dtl_yn!=null && disp_no_preg_dtl_yn.equals("Y"))
	                          preg_checked="checked";
                       else
						      preg_checked="";
%>	
				&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<fmt:message key="ePH.DisplayNoPregRecord.label" bundle="${ph_labels}"/>&nbsp;
				<input type='checkbox' name='Preg_record_yn' id='Preg_record_yn' value='<%=disp_no_preg_dtl_yn%>'  <%=preg_checked%> onclick='assignValue(this);'>
			</tr>
			<tr>
				<td class="label"  width="30%"> <fmt:message key="ePH.SecondTrimester.label" bundle="${ph_labels}"/> </td>
				<td class="label" width="15%" >
					<select name="second_trimster_from" id="second_trimster_from"  onblur="chkweeks(second_trimster_from, second_trimster_to, 'F')">
					<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<% 
					opt_sel = "";
					for(int i=0;i<44;i++){
						if(!second_trim_from.equals("")){
							if(Integer.parseInt(second_trim_from) == (i+1))
								opt_sel = "selected";
							else
								opt_sel = "";
						}
%>
						<option value="<%=i+1%>" <%=opt_sel%>><%=i+1%></option>
<%  
					}
%>
					</select>
					&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
					</td>
					<td class="label" width="*" >
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;<select name="second_trimster_to" id="second_trimster_to"  onblur="chkweeks(second_trimster_from, second_trimster_to, 'T')">
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%      
					opt_sel = "";
					for(int i=0;i<44;i++){
						if(!second_trim_to.equals("")){
							if(Integer.parseInt(second_trim_to) == (i+1))
								opt_sel = "selected";
							else
								opt_sel = "";
						}
%>
						<option value="<%=i+1%>"<%=opt_sel%>><%=i+1%></option>
<%  
					}
%>
					</select>
					&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
				</td>
			</tr>
			<tr>
				<td class="label"  width="30%" > <fmt:message key="ePH.ThirdTrimester.label" bundle="${ph_labels}"/> </td>
				<td class="label" width="15%" >
					<select name="third_trimster_from" id="third_trimster_from"  onblur="chkweeks(third_trimster_from, third_trimster_to, 'F')">
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%       
						opt_sel = "";
						for(int i=0;i<44;i++){
							if(!third_trim_from.equals("")){
								if(Integer.parseInt(third_trim_from) == (i+1))
									opt_sel = "selected";
								else
									opt_sel = "";
							}
%>
							<option value="<%=i+1%>"<%=opt_sel%>><%=i+1%></option>
<%  
						}
%>
					</select>
					&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
					</td>
					<td class="label" width='*'>
					<fmt:message key="Common.to.label" bundle="${common_labels}"/> 
					&nbsp;&nbsp;<select name="third_trimster_to" id="third_trimster_to"  onblur="chkweeks(third_trimster_from, third_trimster_to, 'T')">
						<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
<%			
						opt_sel = "";
						for(int i=0;i<44;i++){
							if(!third_trim_to.equals("")){
								if(Integer.parseInt(third_trim_to) == (i+1))
									opt_sel = "selected";
								else
									opt_sel = "";
							}
							
%>
							<option value="<%=i+1%>"<%=opt_sel%>><%=i+1%></option>
<%  
						}
%>
					</select>
					&nbsp;&nbsp;<fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
				</td>
			</tr><!-- adding end for  RUT-CRF-0063 [IN:029601] -->
			<th colspan="4"><fmt:message key="ePH.IV.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Prescription.label" bundle="${common_labels}"/> </th>
			<tr>
			<td class="label"  width="30%" ><fmt:message key="ePH.InfuseOverCalcBy.label" bundle="${ph_labels}"/><!-- altered table space for aakh-crf-0094 -->
				<td class="label" width="15%" >	<!-- altered table space for aakh-crf-0094 -->
					<select name="iv_calc_infuse_by" id="iv_calc_infuse_by" >
<%
						if(!iv_calc_infuse_by.equals("I")){
%>
							<option value='D' selected><fmt:message key="Common.duration.label" bundle="${common_labels}"/></option>
							<option value='I' ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option value='D' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></option>
							<option value='I' selected><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
<%
						}
%>
					</select>
				</td>
				<!-- added for aakh-crf-0094 start -->
				<%if(infusion_over_app_yn!=null && infusion_over_app_yn.equals("Y"))
					infusion_over_app_yn_chk="checked";
                       		  else
		                        infusion_over_app_yn_chk="";%>	
                    	   <td class="label"><!-- label added AAKH-CRF-0094  -->
								&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<fmt:message key="ePH.InfusionOverApplicable.label" bundle="${ph_labels}"/>
								
								&nbsp;&nbsp;<input type='checkbox'  name='infusion_over_app_yn' id='infusion_over_app_yn' value="Y" <%=infusion_over_app_yn_chk%> onclick='assignValue(this);'  >
			    </td>		
								<!-- added for aakh-crf-0094 end -->
			</tr>
        </table>
	    <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="dispense_rules" style="display:none">
        <tr><td colspan="5" class="white"></td></tr>
        <tr><td colspan="5" class="label">&nbsp;</td></tr>
        <tr>
            <td class="label" width="38%"><fmt:message key="ePH.DispenseByAlternateForm.label" bundle="${ph_labels}"/></td>
            <td width="5%">&nbsp;
            <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
            <input type="checkbox" name="disp_alt_form_yn" id="disp_alt_form_yn" value="N" onclick="assignValue(this);validateMultiStrength(this);">

            <%
                }else{
                        if(disp_alt_form_yn !=null && disp_alt_form_yn.equals("Y"))                                       checked="checked";
                        else
                            checked="";
            %>
                    <input type="checkbox" name="disp_alt_form_yn" id="disp_alt_form_yn" value="<%=disp_alt_form_yn%>" <%=checked%> onclick="assignValue(this);validateMultiStrength(this);" >
            <%
                }
           %>
            </td>
           <%--    <td class="label"  width="38%"><fmt:message key="ePH.ByMultiStrength.label" bundle="${ph_labels}"/></td>
          <td width="5%">&nbsp;
            <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
            <input type="checkbox" name="dispense_value_strength" id="dispense_value_strength" value="N" onclick="assignValue(this);">

            <%
                }else{
				String dis="";
                        if(dispense_value_strength !=null && dispense_value_strength.equals("Y")){
						checked="checked";
							if(disp_alt_form_yn !=null && disp_alt_form_yn.equals("Y"))
								dis="disabled";
												}
                        else
                            checked="";
            %>
                    <input type="checkbox" name="dispense_value_strength" id="dispense_value_strength" value="<%=dispense_value_strength%>" <%=checked%> <%=dis%> onclick="assignValue(this);" >
            <%
                }
           %>
            </td> --%>
          <!-- ADDED for GHL-CRF-0548 START  -->
            <td class="label"  width="38%"><fmt:message key="ePH.DispenseBy.label" bundle="${ph_labels}"/></td>
            <td  width="5%">&nbsp;
             <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %> 
            <select name="dispense_value_strength" id="dispense_value_strength" DISABLED >
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
           <%  }else{
        	   String display_multi="";
        	   if(disp_alt_form_yn !=null && disp_alt_form_yn.equals("Y"))
        	   if(dispense_value_strength !=null &&( dispense_value_strength.equals("Y") ||dispense_value_strength.equals("M") || dispense_value_strength.equals("N"))){
        		   display_multi="enabled";
        		   %>
           
           <select name="dispense_value_strength" id="dispense_value_strength" <%=display_multi%>  >
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
           
           <%}else{%>
           
           <select name="dispense_value_strength" id="dispense_value_strength" <%=display_multi%>  >
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					
			
           </select>
        	   
          <% } else{
        	  display_multi="disabled";
           %>
        	 <select name="dispense_value_strength" id="dispense_value_strength"  <%=display_multi%>>
					<option value='M'><fmt:message key="ePH.MultiStrength.label" bundle="${ph_labels}"/></option>
					<option value='S'><fmt:message key="ePH.SingleStrength.label" bundle="${ph_labels}"/></option>
           </select>
         <% }} %>
            </td>
            <!-- ADDED for GHL-CRF-0548 END  -->
        </tr>
		<tr>
            <td class="label" width=""><fmt:message key="ePH.AllowAlternateGenericName.label" bundle="${ph_labels}"/></td>
			<td width="5%">&nbsp;
            <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
            <input type="checkbox" name="allow_sel_by_atc_yn" id="allow_sel_by_atc_yn" value="N" onclick="assignValue(this);">

            <%
                }else{
                        if(allow_sel_by_atc_yn !=null && allow_sel_by_atc_yn.equals("Y"))                                       checked="checked";
                        else
                            checked="";
            %>
                    <input type="checkbox" name="allow_sel_by_atc_yn" id="allow_sel_by_atc_yn" value="<%=allow_sel_by_atc_yn%>" <%=checked%> onclick="assignValue(this);" >
            <%
                }
           %>
            </td>
	       <td class="label"  width="38%"><fmt:message key="ePH.PrintDosageQtyforAlternateDrugs.label" bundle="${ph_labels}"/></td>
			<td width="5%">&nbsp;
            <%
	             if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
            <input type="checkbox" name="print_alt_drug_dosage_qty_yn" id="print_alt_drug_dosage_qty_yn" value="Y" onclick="assignValue(this);">

            <%
                }
			else{
                        if(print_alt_drug_dosage_qty_yn !=null && print_alt_drug_dosage_qty_yn.equals("Y")) 
							checked="checked";
                        else
                            checked="";
            %>
                    <input type="checkbox" name="print_alt_drug_dosage_qty_yn" id="print_alt_drug_dosage_qty_yn" value="<%=print_alt_drug_dosage_qty_yn%>" <%=checked%>  onclick="assignValue(this);" >
            <%
                }
           %>
            </td>
			   <td class="label"></td>
        </tr>
		<tr>
		<td class="label" width=""><fmt:message key="ePH.DispenseBy.label" bundle="${ph_labels}"/></td>
		<td class="label"> &nbsp;
		<%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
        %>
		<select name="issue_uom_by" id="issue_uom_by"><option value="D" selected><fmt:message key="ePH.DrugUOM.label" bundle="${ph_labels}"/></option><option value="I"><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/></option>
		<%
		}else{
			if(issue_uom_by.equals("D"))
				DUOM="selected";
			else
				IUOM="selected";
		%>
		<select name="issue_uom_by" id="issue_uom_by"><option value="D" <%=DUOM%>><fmt:message key="ePH.DrugUOM.label" bundle="${ph_labels}"/></option><option value="I" <%=IUOM%>><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/></option>
		<%
		}
		%>
		</td>
		<td colspan=3>&nbsp;</td>
		</tr>
        <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="dispense_rules_op_pharm" style="display:none">
        <tr><td colspan="5" class="label">&nbsp;</td></tr>
        <th colspan="5"><fmt:message key="ePH.OutpatientPharmacy.label" bundle="${ph_labels}"/></th>
        <tr><td colspan="5" class="label">&nbsp;</td></tr>
        <tr>
            <td class="label" width="40%"><fmt:message key="ePH.AllowDispensinginadvance.label" bundle="${ph_labels}"/></td>
            <td width="5%">&nbsp;
            <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
                 <input type="checkbox" name="allow_dispense" id="allow_dispense" value="N" onclick="assignValue(this);validateNoDaysAhead(this);" >
            <%
              }else{
                   if(allow_dispense!=null && allow_dispense.equals("Y"))                 checked="checked";
                   else
                         checked="";

            %>
				<input type="checkbox" name="allow_dispense" id="allow_dispense" value="<%=allow_dispense%>" onclick="ValidateNoofDaysAhead(this);" <%=checked%>>
            <%
                }
           %>
            </td>
            <td class="label" width="5%"></td>
            <td class="label" width="27%"><fmt:message key="ePH.NoofdaysAhead.label" bundle="${ph_labels}"/></td>
            <td width="23%">&nbsp;
            <%
                if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						no_days_ahead="";
						disabled="disabled";
				}
				else{
					if(allow_dispense!=null && allow_dispense.equals("Y")){
						disabled="";
					}
					else{
						disabled="disabled";
					}

				}
            %>
				<input type="text" size="3" maxlength="3" name="no_days_ahead" id="no_days_ahead" value="<%=no_days_ahead%>" onKeyPress="return(ChkNumberInput(this,event,0));" <%=disabled%> class="NUMBER" onBlur="checkIsNotZero(this, 'No of days Ahead');checkSplChars(this);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id="no_days_ahead_man" style="visibility:hidden"></img>
             </td>
			 <%
                if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						if(allow_dispense!=null && allow_dispense.equals("Y")){
						%>
						<script>validateNoDaysAheadMandatory("Y")</script>
						<%
						}else{
						%>
						<script>validateNoDaysAheadMandatory("N")</script>
						<%
						}
				}
            %>
        </tr>
        <tr>
            <td class="label" width="40%"><fmt:message key="ePH.AllowDispensingpastOrders.label" bundle="${ph_labels}"/></td>
            <td width="5%">&nbsp;
            <%
             if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
                  }else{
                        if(allow_past_dispense!=null && allow_past_dispense.equals("Y")) checked="checked";
                        else
                            checked="";
				  }
		   %>
            <input type="checkbox" name="allow_past_dispense" id="allow_past_dispense" value="<%=allow_past_dispense%>" onclick="ValidateUptoDays(this);" <%=checked%> >
            </td>
            <td class="label" width="5%"></td>
            <td class="label" width="27%"><fmt:message key="ePH.UptoNoofDays.label" bundle="${ph_labels}"/></td>
            <td width="23%">&nbsp;
            <%
                if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						upto_days="";
						disabled="disabled";
				}
				else{
					if(allow_past_dispense!=null && allow_past_dispense.equals("Y")){
						disabled="";
					}else{
						disabled="disabled";
					}

				}
            %>
                 <input type="text" size="3" maxlength="3" name="upto_days" id="upto_days" value="<%=upto_days%>" onKeyPress="return(ChkNumberInput(this,event,0));" <%=disabled%> class="NUMBER" onBlur="checkIsNotZero(this, 'Up to No of Days');checkSplChars(this);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id="upto_days_man" class="NUMBER"></img>
             </td>
			 <%
                if(!mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
					if(allow_past_dispense!=null && allow_past_dispense.equals("Y")){
					%>
						<script>validateUptoDaysMandatory("Y")</script>
					<%
					}else{
					%>
						<script>validateUptoDaysMandatory("N")</script>
					<%
					}

				}
            %>
        </tr>
	    <tr><td colspan="5" class="label">&nbsp;</td></tr>
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr>
        </table>

		<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="drug_database_interface" >
        <tr><td colspan="5" class="label">&nbsp;</td></tr>
       
		<tr>
            <td class="label" ><fmt:message key="ePH.DrugDatabaseInterfaceRequired.label" bundle="${ph_labels}"/>
            &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="drug_db_interface_yn" id="drug_db_interface_yn" value="Y"  <%=drug_db_interface_yn%>></td>
		</tr>
       
       
		
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white">&nbsp;</td></tr>
        <tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr>
        </table>


		<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="process_names" style="display:none">
        <tr><td colspan="4" class="label">&nbsp;</td></tr>
		<th colspan="4"><fmt:message key="ePH.PromptsForDispensingStages.label" bundle="${ph_labels}"/></th>
        <tr>
            <td class="label"><fmt:message key="Common.Registration.label" bundle="${common_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="regn_stage_prompt" id="regn_stage_prompt" value="<%=regn_stage_prompt%>" maxlength="15" size="15"></td>
            <td class="label" ><fmt:message key="ePH.Verification.label" bundle="${ph_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="verify_stage_prompt" id="verify_stage_prompt" value="<%=verify_stage_prompt%>" maxlength="15" size="15"></td>
		</tr>
		<tr>
            <td class="label" ><fmt:message key="ePH.Fill.label" bundle="${ph_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="fill_stage_prompt" id="fill_stage_prompt" value="<%=fill_stage_prompt%>" maxlength="15" size="15"></td>
			<td class="label" ><fmt:message key="Common.Allocate.label" bundle="${common_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="allocate_stage_prompt" id="allocate_stage_prompt" value="<%=allocate_stage_prompt%>" maxlength="15" size="15"></td>
		</tr>
		<tr>
            <td class="label" ><fmt:message key="ePH.Bill/Receipt.label" bundle="${ph_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="bill_receipt_stage_prompt" id="bill_receipt_stage_prompt" value="<%=bill_receipt_stage_prompt%>" maxlength="15" size="15"></td>
            <td class="label" ><fmt:message key="ePH.Deliver.label" bundle="${ph_labels}"/></td>
            <td>&nbsp;&nbsp;<input type="text" name="deliver_stage_prompt" id="deliver_stage_prompt" value="<%=deliver_stage_prompt%>" maxlength="15" size="15"></td>
		</tr>
		<th colspan="4"><fmt:message key="ePH.IVOrderTypeLegends.label" bundle="${ph_labels}"/></th>
		<tr >
            <td class="label" ><fmt:message key="Common.IVwithAdditives.label" bundle="${common_labels}"/></td>
            <td colspan="4">&nbsp;&nbsp;<input type="text" onkeypress="return CheckForNumbers(event)" name="iv_with_additives" id="iv_with_additives" value="<%=iv_with_additives %>" maxlength="35" size="35">
			<img src="../../eCommon/images/mandatory.gif" ></td>
        </tr>
		<tr colspan="4"> <td class="label"><fmt:message key="ePH.IVIntermittent.label" bundle="${ph_labels}"/> </td>
            <td colspan="4" >&nbsp;&nbsp;<input type="text" onkeypress="return CheckForNumbers(event)" name="iv_intermittent" id="iv_intermittent" value="<%=iv_intermittent %>" maxlength="35" size="35">
			<img src="../../eCommon/images/mandatory.gif" >
			</td>
           
		</tr>
		<tr colspan="4">
		<td class="label"><fmt:message key="ePH.IVwithoutAdditives.label" bundle="${ph_labels}"/></td>
            <td colspan="4" >&nbsp;&nbsp;<input type="text" onkeypress="return CheckForNumbers(event)" name="iv_without_additives" id="iv_without_additives" value="<%=iv_without_additives %>" maxlength="35" size="35">
			<img src="../../eCommon/images/mandatory.gif" ></td>
           
		</tr>
        
		</table>
		</table>
		<input type="hidden" name="inpatient_yn" id="inpatient_yn" value="<%=inpatient_yn%>">
		<input type="hidden" name="licenceRights" id="licenceRights" value="<%=licenceRights%>">
        <script>callPrescriptionRules();</script>
        <script>PrescriptionRules_tab.click();</script>
</form>
<% putObjectInBean(bean_id,bean,request ) ;
}catch(Exception e){
	e.printStackTrace();
}%>
</body>
</html>


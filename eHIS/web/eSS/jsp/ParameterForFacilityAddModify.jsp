<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%> 
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="ds" class="eSS.ParameterForFacilityBean" scope="page"/>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language="JavaScript" src="../../eSS/js/ParameterForFacility.js"></script>
	<script language='javascript'>

	function checking()
	{
		var check=document.formParameterForFacility.bl_interface_yn;
		var blng_code=document.formParameterForFacility.def_blng_serv_code;
		if(check.checked==false)
		{
		blng_code.disabled=true;
		blng_code.value="";
		}
		else if(check.checked==true)
		{
			blng_code.disabled=false;
		}
		
	}
function validateMonth(obj){
if(parseInt(obj.value) > 12){
alert(getMessage("MONTH_IS_GR_12","Common"));
obj.focus();
return false;
}
}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled				=	"";

	String records_exist_for_Issuegroup				=	"N";
	String records_exist_for_Returngroup			=	"N";
	String records_exist_for_loan_Issuegroup		=	"N";
	String records_exist_for_loan_Returngroup		=	"N";
	String disablePackingLabel						=	"";  // ML-MMOH-CRF-1821-- TFS - 30369

	try{
	
	mode							=	"" ;
	bean_id							=	"ParameterForFacilityBean" ;
	bean_name						=	"eSS.ParameterForFacilityBean";
	ParameterForFacilityBean bean	=	(ParameterForFacilityBean)getBeanObject( bean_id,bean_name, request  ) ;  

	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	mode							=	bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");


	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.loadData();
	}
	else{
		ParameterForEntityBean bean1 = (ParameterForEntityBean)getBeanObject( "ParameterForEntityBean","eSS.ParameterForEntityBean", request );  
		bean1.clear() ;
	
		bean1.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		
		bean.setBl_interface_yn(          bean1.getBl_interface_yn()			);
		bean.setCurr_proc_month(          bean1.getCurr_proc_month()           );
		bean.setCurr_proc_year(           bean1.getCurr_proc_year()            );
		bean.setDef_adj_doc_type_code(    bean1.getDef_adj_doc_type_code());
		bean.setDef_blng_serv_code(       bean1.getDef_blng_serv_code()     );   
		bean.setDef_iss_doc_type_code(    bean1.getDef_iss_doc_type_code()    ); 
		bean.setDef_pre_doc_type_code(    bean1.getDef_pre_doc_type_code()     );
		bean.setDef_req_doc_type_code(    bean1.getDef_req_doc_type_code()     );
		bean.setDef_rof_doc_type_code(    bean1.getDef_rof_doc_type_code()     );
		bean.setDef_rtg_doc_type_code(    bean1.getDef_rtg_doc_type_code()     );
		bean.setDef_rti_doc_type_code(    bean1.getDef_rti_doc_type_code()    );
		bean.setDef_trd_doc_type_code(    bean1.getDef_trd_doc_type_code()     );
		bean.setDef_var_doc_type_code(    bean1.getDef_var_doc_type_code()     );
		bean.setDef_write_off_reason_code(bean1.getDef_write_off_reason_code() );
		bean.setGen_rof_at_pre_yn(        bean1.getGen_rof_at_pre_yn()         );
		bean.setDef_rql_doc_type_code(    bean1.getDef_rql_doc_type_code()    ); //Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		bean.setDef_isl_doc_type_code(    bean1.getDef_isl_doc_type_code()    ); 
		bean.setDef_rtl_doc_type_code(    bean1.getDef_rtl_doc_type_code()    ); //ended
		//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		bean.setDef_rqv_doc_type_code(    bean1.getDef_rqv_doc_type_code()    );
		bean.setDef_rtv_doc_type_code(    bean1.getDef_rtv_doc_type_code()    );
		
		putObjectInBean("ParameterForEntityBean",bean1,request);
		//putObjectInBean("ParameterForFacilityBean",bean1,request);

		// Set for Default Parameter for Facility Bean 
		bean.setPrint_packed_labelYn("Y");// By default make it Y 
		bean.setAllow_multi_group_typeYn("Y"); // By default make it Y 

	}

//Added By Sakti Sankar on 06/12/2012 against CRF#222
		if(bean.getRecordCountForIssueGroup())
			records_exist_for_Issuegroup = "Y";
		if(bean.getRecordCountForReturnGroup())
			records_exist_for_Returngroup = "Y";
//Added ends

//Added By Sakti Sankar on 10/13/2013 against CRF#225.1
		if(bean.getRecordCountForLoanIssueGroup())
			records_exist_for_loan_Issuegroup = "Y";
		if(bean.getRecordCountForLoanReturnGroup())
			records_exist_for_loan_Returngroup = "Y";
//Added ends
System.out.println("bean.getAllow_multi_group_typeYn()"+bean.getAllow_multi_group_typeYn());
// Added for ML-MMOH-CRF-1821-- TFS - 30369
if((bean.getAllow_multi_group_typeYn()).equalsIgnoreCase("Y")) {
	disablePackingLabel					= "disabled"; 
	//bean.setPrint_packed_labelYn("N"); // Make it false
}

// Ends for ML-MMOH-CRF-1821-- TFS - 30369
%>
<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">
	<form name="formParameterForFacility" id="formParameterForFacility" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td align='center' class='WHITE'>
	<table cellpadding=1 cellspacing=0 align='center' width='98%'>
	<tr>
	<tr><td align='left' colspan='4'>&nbsp;</td></tr>
		<td class='LABEL' colspan='4' align='center'><fmt:message key="eSS.CurrentProcessingMonthYear.label" bundle="${ss_labels}"/>&nbsp;<input type="text" value="<%=bean.getCurr_proc_month()%>" name="curr_proc_month" class="NUMBER" maxLength='2' size='2' onKeyPress='return isValidInteger();' onBlur="validateMonth(this)"  <%=codeDisabled%>><input type="text" value="<%=bean.getCurr_proc_year()%>" name="curr_proc_year"  class="NUMBER" maxLength='4' size='4' onKeyPress='return isValidInteger();' <%=codeDisabled%>><%=bean.getMandatoryImageTag()%>
		</td>
	</tr>

	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.Interface.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.Billing.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="Y" name="bl_interface_yn" id="bl_interface_yn" <%=bean.getChecked(bean.getBl_interface_yn())%> onClick="checking()" <%=bean.isModuleInstalled("BL")?"":"disabled title='Module not installed'"%>></td>
		<td align="left" class="label"><fmt:message key="eSS.BillingService.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="def_blng_serv_code" id="def_blng_serv_code" <%=bean.getBl_interface_yn().equals("N")?"disabled":""%>  <%=bean.isModuleInstalled("BL")?"":"disabled title='Module not installed'"%>>
			<%=bean. getDef_blng_serv_code_List()%>
			</select>
		</td>
	</tr>

<!--Added By Sakti Sankar on 06/12/2012 against CRF#222-->
	<tr>
	<td align='left' colspan='4' >&nbsp;</td></tr>
	<tr >
		<th align='left' colspan='4'><fmt:message key="eSS.AcknowledgementFor.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td class="label"><fmt:message key="eSS.Issue.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="iss_ack_req_yn" id="iss_ack_req_yn" value="Y"  <%=bean.checkForNull(bean.getChecked(bean.getIss_ack_req_yn()))%> onclick="checkRecordsForIssueGroup(this)"></td>
		<td class="label"><fmt:message key="eSS.IssueReturn.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="ret_ack_req_yn" id="ret_ack_req_yn" value="Y"  <%=bean.checkForNull(bean.getChecked(bean.getRet_ack_req_yn()))%> onclick="checkRecordsForReturnGroup(this)"></td>&nbsp;&nbsp;
		<td class="label"><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="isl_ack_req_yn" id="isl_ack_req_yn" value="Y"  <%=bean.checkForNull(bean.getChecked(bean.getIsl_ack_req_yn()))%> onclick="checkRecordsForLoanIssueGroup(this)"></td>
		<td class="label"><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="rtl_ack_req_yn" id="rtl_ack_req_yn" value="Y"  <%=bean.checkForNull(bean.getChecked(bean.getRtl_ack_req_yn()))%> onclick="checkRecordsForLoanReturnGroup(this)"></td>&nbsp;&nbsp;
		<td class="label">&nbsp;</td>

	</tr>
<!--ends-->

	<tr><td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.DefaultDocumentTypes.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.PrepareGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_pre_doc_type_code" id="def_pre_doc_type_code">
			<%=bean.getDef_pre_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eSS.RequestGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_req_doc_type_code" id="def_req_doc_type_code">
			<%=bean.getDef_req_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_iss_doc_type_code" id="def_iss_doc_type_code">
			<%=bean.getDef_iss_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eSS.ReturnGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtg_doc_type_code" id="def_rtg_doc_type_code">
			<%=bean.getDef_rtg_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<!--Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013-->
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.RequestForLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rql_doc_type_code" id="def_rql_doc_type_code">
			<%=bean.getDef_rql_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eSS.IssueAgainstLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_isl_doc_type_code" id="def_isl_doc_type_code">
			<%=bean.getDef_isl_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.ReturnOfLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtl_doc_type_code" id="def_rtl_doc_type_code">
			<%=bean.getDef_rtl_doc_type_code_List()%>
		</select>
		</td>	<!--ENDED-->

		<td align='left'  class='label'><fmt:message key="eSS.TrayDiscrepancy.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_trd_doc_type_code" id="def_trd_doc_type_code">
			<%=bean.getDef_trd_doc_type_code_List()%>
		</select>
		</td>
	</tr>


	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.ReturnInstrument.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rti_doc_type_code" id="def_rti_doc_type_code">
			<%=bean.getDef_rti_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eSS.Variance.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_var_doc_type_code" id="def_var_doc_type_code">
			<%=bean.getDef_var_doc_type_code_List()%>
		</select>
		</td>		
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.WriteOff.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_adj_doc_type_code" id="def_adj_doc_type_code">
			<%=bean.getDef_adj_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eSS.AutoRequestGroup.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_auto_req_doc_type_code" id="def_auto_req_doc_type_code">
			<%=bean.getDef_auto_req_doc_type_code_List()%>
		</select>
		</td>
		
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.ProcessSterilizationRequest.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rof_doc_type_code" id="def_rof_doc_type_code">
			<%=bean.getDef_rof_doc_type_code_List()%>
		</select>
		</td>	<!-- Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015-->
		<td align='left'  class='label'><fmt:message key="eSS.ReturnVendorLoan.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rtv_doc_type_code" id="def_rtv_doc_type_code">
			<%=bean.getDef_rtv_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.RequestLoanFromVendor.label" bundle="${ss_labels}"/></TD>
		<td>&nbsp;<select name="def_rqv_doc_type_code" id="def_rqv_doc_type_code">
			<%=bean.getDef_rqv_doc_type_code_List()%>
		</select>
		</td>
	</tr><!-- Added ends -->
	
	<tr><td align='left' colspan='4'>&nbsp;</td></tr>

	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.OtherDefaults.label" bundle="${ss_labels}"/></th>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.StoreforPrepareGroup.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="def_store_code_for_pre" id="def_store_code_for_pre">
			<%=bean.getDef_store_code_for_pre_List()%>
		</select>
		</td>
		<!-- Added by sakti against KDAH-CRF-0247 -->		
		<td align='left'  class='label'  ><fmt:message key="eSS.SurgeryTypeLinkedToOT.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="" name="surg_nature_link_ot_yn" id="surg_nature_link_ot_yn" <%=bean.getChecked(bean.getSurgery_Type_Linked_To_OT())%> onClick="enableAutoRequest(this)" ></td>
		<td>&nbsp;</td>
	</tr>
	<tr>		<td align='left'  class='label'><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="def_service_location_code" id="def_service_location_code">
			<%=bean.getDef_service_location_code_List()%>
		</select>
		</td>
		<!-- Added for ML-MMOH-CRF-1821-- TFS - 30369 -->
		<td align='left' class='label'><fmt:message key="eSS.AllowMultiGroupTypes.label" bundle="${ss_labels}"/></TD>
		<td >&nbsp;<input type="checkbox" value="<%=bean.getAllow_multi_group_typeYn()%>" name="allow_multi_group_types_yn" <%=bean.getChecked(bean.getAllow_multi_group_typeYn())%> onClick="enableAutoRequest(this);checkDisablePack(this);" ></td> 
		<td class="label">&nbsp;</td>
		<!-- END for ML-MMOH-CRF-1821-- TFS - 30369 -->
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.WriteoffReason.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="def_write_off_reason_code" id="def_write_off_reason_code">
			<%=bean.getDef_write_off_reason_code_List()%>
		</select>
		</td>
		<!-- Added for ML-MMOH-CRF-1821-- TFS - 30369 -->
		<td align='left' class='label'><fmt:message key="eSS.GroupTypeMandatory.label" bundle="${ss_labels}"/></TD>
		<td >&nbsp;<input type="checkbox" value="<%=bean.getGroup_type_mandatoryYn()%>" name="group_type_mandatory_yn" <%=bean.getChecked(bean.getGroup_type_mandatoryYn())%> onClick="enableAutoRequest(this)" ></td> 
		<td class="label">&nbsp;</td>
		<!-- END for ML-MMOH-CRF-1821-- TFS - 30369 -->
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eSS.AutoRequestonStore.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="def_auto_req_on_store" id="def_auto_req_on_store">
			<%=bean.getReq_on_store_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'>&nbsp;</TD> 
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td align='left'  class='label'  width='20%'><fmt:message key="eSS.EnableAutoRequest.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="Y" name="auto_req_yn" id="auto_req_yn" <%=bean.getChecked(bean.getAuto_req_yn())%> onClick="enableAutoRequest(this)" ></td>
		<td align='left'  class='label'>&nbsp;</TD>
		<td>&nbsp;</td>
	</tr>
	<tr>
	<td class='label'  align='left'><fmt:message key="eST.DurnforStartDate.label" bundle="${st_labels}"/></td>
	<td align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getDurn_for_start_date(),"0")%>"  name="durn_for_start_date" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="return getdurationcheck(this)" >&nbsp; Days 
	</td>
	</tr>	
	<tr><td align='left' colspan='4'>&nbsp;</td></tr>

<!-- Added for ML-MMOH-CRF-1821-- TFS - 30369 -->
 	<tr>
		<th align='left' colspan='4'><fmt:message key="eSS.Packing.label" bundle="${ss_labels}"/></th>	
	</tr>
	<tr>
		<td class='label' align='left'><fmt:message key="eSS.InstructionPacking.label" bundle="${ss_labels}"/></td>
		<td align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getInstruction_label_pack())%>"  name="instruction_label_pack" maxLength='50' size='50' ></td>
		<td align='left'  class='label'><fmt:message key="eSS.PrintPacked.label" bundle="${ss_labels}"/></td>
		<td >&nbsp;<input type="checkbox" value="<%=bean.getPrint_packed_labelYn()%>" name="print_packed_label_yn"  onClick="enableAutoRequest(this)" <%=bean.getChecked(bean.getPrint_packed_labelYn())%>  ></td>
	</tr>	

	<tr class="select1">
		<td class='label'  align='left'><fmt:message key="eSS.LabelSizeLinenGroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="linen_group_label_type" id="linen_group_label_type" <%=disablePackingLabel%> >
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="6X9" <%=(bean.checkForNull(bean.getLinen_group_label_type(),"").equalsIgnoreCase("6X9")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></OPTION>
					<OPTION VALUE="3X5" <%=(bean.checkForNull(bean.getLinen_group_label_type(),"").equalsIgnoreCase("3X5")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/></OPTION>
				</SELECT>
		</td>
		<td class='label'  align='left'><fmt:message key="eSS.LabelSizeSetGroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="set_group_label_type" id="set_group_label_type" <%=disablePackingLabel%> >
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="6X9" <%=(bean.checkForNull(bean.getGroup_label_type(),"").equalsIgnoreCase("6X9")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></OPTION>
					<OPTION VALUE="3X5" <%=(bean.checkForNull(bean.getGroup_label_type(),"").equalsIgnoreCase("3X5")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/></OPTION>
			</SELECT>
		</td>
	</tr>


	<tr class="select2">
		<td class='label'  align='left'><fmt:message key="eSS.LabelSizeSingleGroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="single_group_label_type" id="single_group_label_type" <%=disablePackingLabel%> >
				<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
				<OPTION VALUE="6X9" <%=(bean.checkForNull(bean.getSingle_group_label_type(),"").equalsIgnoreCase("6X9")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></OPTION>
				<OPTION VALUE="3X5" <%=(bean.checkForNull(bean.getSingle_group_label_type(),"").equalsIgnoreCase("3X5")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/></OPTION>
			</SELECT>
		</td>
		<td class='label'  align='left'><fmt:message key="eSS.LabelSizeSoftPackGroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="soft_pack_group_label_type" id="soft_pack_group_label_type" <%=disablePackingLabel%> >
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="6X9" <%=(bean.checkForNull(bean.getSoft_pack_group_label_type(),"").equalsIgnoreCase("6X9")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></OPTION>
					<OPTION VALUE="3X5" <%=(bean.checkForNull(bean.getSoft_pack_group_label_type(),"").equalsIgnoreCase("3X5")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/></OPTION>
			</SELECT>
		</td>
	</tr>	

	<tr class="select3">
		<td class='label'  align='left'><fmt:message key="eSS.LabelSizeTraytGroupType.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name="tray_group_label_type" id="tray_group_label_type" <%=disablePackingLabel%> >
					<option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="6X9" <%=(bean.checkForNull(bean.getTray_group_label_type(),"").equalsIgnoreCase("6X9")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></OPTION>
					<OPTION VALUE="3X5" <%=(bean.checkForNull(bean.getTray_group_label_type(),"").equalsIgnoreCase("3X5")?"Selected":"")%>><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/></OPTION>
			</SELECT>
		</td>
		<td class='label'  align='left'>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>	

<!-- EMD - for ML-MMOH-CRF-1821-- TFS - 30369 -->
	</table>
		</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="records_exist_for_Issuegroup" id="records_exist_for_Issuegroup"				value="<%= records_exist_for_Issuegroup %>">
	<input type="hidden" name="records_exist_for_Returngroup" id="records_exist_for_Returngroup"				value="<%= records_exist_for_Returngroup %>">
	<input type="hidden" name="records_exist_for_loan_Issuegroup" id="records_exist_for_loan_Issuegroup"				value="<%= records_exist_for_loan_Issuegroup %>">
	<input type="hidden" name="records_exist_for_loan_Returngroup" id="records_exist_for_loan_Returngroup"				value="<%= records_exist_for_loan_Returngroup %>">
	<input type="hidden" name="allow_multi_group_types_yn_orgi" id="allow_multi_group_types_yn_orgi"				value="<%=bean.getAllow_multi_group_typeYn()%>">
	
	


	</form>
	<%
		putObjectInBean(bean_id,bean,request);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
</body>
</html>


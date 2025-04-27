<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
19/05/2017				IN062881			B.Badmavathi								     			 PO Mandatory in GRN 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eST.ParameterForEntityBean,eMM.MM_license_rights,java.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eST/js/ParameterForEntity.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style type="text/css">
		select{
			width=140px;
		}

	</style>
</head>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled =	"";
	String decimalCodeDisabled = "";
	String periodEndScopeDisabled="";
	String Checked = "";
	mode	= "" ;
	bean_id = "parameterForEntityBean" ;
	bean_name = "eST.ParameterForEntityBean";
	ParameterForEntityBean bean = (ParameterForEntityBean)getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);

	
	bean.clear() ;
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	mode	=	bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled = "disabled";
		bean.loadData();
	}
	periodEndScopeDisabled=(bean.getPeriodEndScope().equals("F"))?"disabled":"";

	boolean complete_inventory = new eMM.MM_license_rights().getSTboundary().equals("I");
		
	String strAuditTrailDisabled="";
	HashMap hshAuditTrail=new HashMap();
	hshAuditTrail=(HashMap)bean.fetchRecord("SELECT  count(SRL_NO) SRL_NO FROM ST_ACC_ENTITY_PARAM_LOG");
	if(((String)hshAuditTrail.get("SRL_NO")).equals("0")){
		strAuditTrailDisabled="disabled";
	}
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
	String records_exist_for_prepack		=			"N";
	String records_exist_for_standard		=			"N";
	String records_exist_for_extemp			=			"N";
	String records_exist_for_others		    =			"N";
	            
  String prep_prepack  =   bean.checkForNull(bean.getPrepacking()) ;
  String prep_standard =   bean.checkForNull(bean.getStandardFormulary()) ;
  String prep_extemp   =   bean.checkForNull(bean.getExtemporaneous()) ;
  String prep_others   =   bean.checkForNull(bean.getOthers()) ;
	             
  if(prep_prepack.equals("") && prep_standard.equals("") && prep_extemp.equals("") && prep_others.equals("") ){
	            	 
	            	 prep_prepack  = "Pre Packing";
	                 prep_standard = "Standard Formulary";
	                 prep_extemp   = "Extemporaneous";
	                 prep_others   =  "Others";
	}
	               
	             if(bean.getPrep_Extemp())
	     			records_exist_for_extemp = "Y";
	     		if(bean.getPrep_Standardform())
	     			records_exist_for_standard = "Y";
	     		if(bean.getPrep_Others())
	     			records_exist_for_others = "Y";
	     		if(bean.getPrep_prepack())
	     			records_exist_for_prepack = "Y";
		//ends
		//Added against GDOH-CRF-0109 starts
			String po_mandatory = "";
			HashMap hashPOMandaory=new HashMap();
			hashPOMandaory = (HashMap) bean.fetchRecord(bean.getStRepositoryValue("SQL_MM_PO_MANDATORY"),"MM");		
			po_mandatory = (String) hashPOMandaory.get("PO_MANDATORY_YN");
		//Added against GDOH-CRF-0109 ends

		String disabled_weighted_avg_unit_price = ""; //PMG2023-COMN-CRF-0039
%>
<body onLoad="FocusFirstElement(); callbtprice();sitespecificenabledisable();assignvalue();assignvalues();">
	<form name="formParameterForEntity" id="formParameterForEntity" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%' align=center>
		<tr><td align='center' class='WHITE'>
	<table cellpadding=1 cellspacing=0 align='center' width='98%'>
	<tr>
		<td align='right'  colspan='4'>
			<input class="button" type="button" name="AuditTrail" id="AuditTrail" value='<fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>' onClick="auditTrailLogs();" <%=strAuditTrailDisabled%>>
		</td>	
	</tr>
	<%if(!periodEndScopeDisabled.equals("disabled")){%>
	<tr>
	<td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>	<td class='LABEL' colspan='4' align='center'><fmt:message key="Common.CurrentProcessingMonth/Year.label" bundle="${common_labels}"/>&nbsp;<input type="text" value="<%=bean.getCurr_proc_month()%>" name="curr_proc_month" class="NUMBER" maxLength='2' size='2' onKeyPress='return isValidInteger();' <%=codeDisabled%> <%=periodEndScopeDisabled%>><input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getCurr_proc_year(),"YY","en",locale)%>" name="curr_proc_year"  class="NUMBER" maxLength='4' size='4' onKeyPress='return isValidInteger();' <%=codeDisabled%> <%=periodEndScopeDisabled%>><%=bean.getImage("M")%> <!--Modified for TBMC_scf_0018-->
		</td>
	</tr>
	<%}%>
	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.Interface.label" bundle="${common_labels}"/></th>	
	</tr>

	<tr>
		<td align='left'  class='label'><fmt:message key="Common.Billing.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<input type="checkbox" value="Y" name="bl_interface_yn" id="bl_interface_yn" <%=bean.getChecked(bean.getBl_interface_yn())%> <%=bean.isBillingModuleInstalled()?"":"disabled title='Module not installed'"%> onclick='callbtprice()'></td>
		<td align='left'  class='label'><fmt:message key="Common.GeneralLedger.label" bundle="${common_labels}"/></td>
		<td colspan='3' >&nbsp;&nbsp;<input type="checkbox" value="Y" name="gl_interface_yn" id="gl_interface_yn" <%=bean.getChecked(bean.getGl_interface_yn())%> <%=bean.isModuleInstalled("GL")?"":"disabled title='Module not installed'"%>></td>
	</tr>
		<tr>
	<td align='ridgt' class='label'><fmt:message key="eST.SalePriceApplicable.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='sale_price_appl_yn' id='sale_price_appl_yn' <%=bean.getChecked(bean.checkForNull(bean.getSale_price_appl_yn(),"N"))%> onclick="mrpPrice(this);"></td>
	<td align='ridgt' class='label'><fmt:message key="eST.FolioAtBatchPrice.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='batch_sale_price_yn' id='batch_sale_price_yn' <%=bean.getChecked(bean.getBatch_sale_price_yn())%>></td>
	<td></td>
	</tr>
	<tr>
		<td align='ridgt' class='label'><fmt:message key="eST.MRPGreaterThanUnitPrice.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='lesser_sale_price_yn' id='lesser_sale_price_yn' <%=bean.getChecked(bean.getBl_interface_yn().equals("N")?"N":bean.getLesser_sale_price_yn())%> disabled></td>
 		<td align='ridgt' class='label'>PO Applicable</td>
		<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='po_details_applicable_yn' id='po_details_applicable_yn' <%=bean.getChecked(bean.checkForNull(bean.getPo_details_applicable_yn(),"N"))%>></td>
		<td></td>
	</tr>
	<tr>
	<td align='ridgt' class='label'><fmt:message key="eST.InterfacetoexternalPO.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='interface_to_external_po_yn' id='interface_to_external_po_yn' <%=bean.getChecked(bean.checkForNull(bean.getInterface_to_external_po_yn(),"N"))%> onclick="validateporequest(this),checkPOMandatory(this)" ></td><!-- Added checkPOMandatory() against GDOH-CRF-0109 -->
	<td align='ridgt' class='label'><fmt:message key="eST.InterfacePOApplicable.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<input type='checkbox' value='Y' name='interface_po_applicable_yn' id='interface_po_applicable_yn' <%=bean.getChecked(bean.checkForNull(bean.getInterface_po_applicable_yn(),"N"))%>  onclick="assignvalues();"></td>
	

	</tr>
	
	<tr>
	<td align='left' class='label'><fmt:message key="eST.AllowUnfinalizedGRNThroughInterface.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<input type="checkbox" value="" name="allow_unf_grn_thru_interface_yn" id="allow_unf_grn_thru_interface_yn" onclick = "assignvalue();" <%=bean.getChecked(bean.checkForNull(bean.getAllow_unf_grn_thru_interface_yn(),"N"))%>></td>
	<td align='left'  class='label'><fmt:message key="eST.GeneratePORequestBy.label" bundle="${st_labels}"/></td>
	<td>&nbsp;&nbsp;<select name="porequest_by" id="porequest_by" <%=(bean.checkForNull(bean.getInterface_to_external_po_yn(),"N")).equals("Y")?"":"disabled"%>>
	<option value="NA" <%=bean.getPOrequest_by().equals("NA")?"Selected":""%>><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
	<%if(complete_inventory){%>
		<option value="MG" <%=bean.getPOrequest_by().equals("MG")?"Selected":""%> >Meterial Group</option>
	<%}%>
	<option value="IC" <%=bean.getPOrequest_by().equals("IC")?"Selected":""%> ><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></option></select></td>
	</tr>
	

	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.DefaultStockParameter.label" bundle="${st_labels}"/></th>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.ExpiryWarningDays.label" bundle="${st_labels}"/></td>
		<td  >&nbsp;&nbsp;<input type="text" value="<%=bean.getExpiry_warning_days()%>" name="expiry_warning_days" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"><%=bean.getImage("M")%></td>
	
		<td align='left'  class='label'><fmt:message key="eST.RestrictViewingStockStatus.label" bundle="${st_labels}"/></td>
		<td>&nbsp;
		<select name="restrict_view_stock_status" id="restrict_view_stock_status">
		<option value="UAS"  <%=bean.checkForNull(bean.getRestrictViewStockStatus()).equals("UAS")?"Selected":""%>><fmt:message key="eST.UserAccessStores.label" bundle="${st_labels}"/></option>
		<option value="ALL" <%=bean.checkForNull(bean.getRestrictViewStockStatus()).equals("ALL")?"Selected":""%>><fmt:message key="eST.AllStores.label" bundle="${st_labels}"/></option>	  		
		</select>
		</td>
 </tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.Transactionacrossfacility.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<input type="checkbox" value="Y" name="trn_across_facility_yn" id="trn_across_facility_yn" <%=bean.getChecked(bean.getTrn_across_facility_yn())%>></td>
		<td align='left'  class='label'><fmt:message key="eST.AllowMultiStoreIssue.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<input type="checkbox" value="Y" name="multi_store_issue_yn" id="multi_store_issue_yn" <%=bean.getChecked(bean.getMulti_store_issue_yn())%> disabled></td>
	</tr>
<!-- /**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - No of Decimals. False is passed to checkIntegerFormat to allow 0.
	*/
 -->
<%
//out.println(bean.getDispDecimalDtlsYN());
if((bean.getDispDecimalDtlsYN()).equals("Y")){
	/*Commented by suresh.r on 10-07-2014 against AAKH-SCF-0113 beg
		if(bean.getNoOfDecimals()==0){
			decimalCodeDisabled = "";
		}else{
			decimalCodeDisabled = "disabled";
		}Commented by suresh.r on 10-07-2014 against AAKH-SCF-0113 end*/
	decimalCodeDisabled = "";
}else{
	decimalCodeDisabled = "disabled";
}
%>
	<tr><!--Added Allow Display Decimals check box by suresh.r on 10-07-2014 against AAKH-SCF-0113 beg -->
		<td align='left'  class='label' colspan='2'>Allow Display Of Decimals&nbsp;&nbsp;
		<input type="checkbox" value="" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" <%=bean.getChecked(bean.checkForNull(bean.getDisp_decimal_dtls_yn(),"N"))%> onclick="assigncheckvalue(this)">
		<td align='left'  class='label' colspan='2'>No of Decimals&nbsp;&nbsp;<input type="text" value="<%=bean.getNo_of_decimals()%>" name="no_of_decimals" class="NUMBER" maxLength='1' size='3' onKeyPress='return validIntegerLessThanThree(this);' onBlur="checkIntegerFormat(this,false);" <%=decimalCodeDisabled%>></td>
	</tr>
<%//}%>
	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.DefaultDocumentTypes.label" bundle="${common_labels}"/></th>	
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_grn_doc_type_code" id="def_grn_doc_type_code">
		<%=bean.getDef_grn_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.ReturnVendor.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_rtv_doc_type_code" id="def_rtv_doc_type_code">
		<%=bean.getDef_rtv_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.ManufacturingReceipt.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_mfg_doc_type_code" id="def_mfg_doc_type_code">
		<%=bean.getDef_mfg_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <fmt:message key="Common.Issue.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_iss_doc_type_code" id="def_iss_doc_type_code">
		<%=bean.getDef_iss_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_ret_doc_type_code" id="def_ret_doc_type_code">
		<%=bean.getDef_ret_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_urg_doc_type_code" id="def_urg_doc_type_code">
		<%=bean.getDef_urg_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_tfr_doc_type_code" id="def_tfr_doc_type_code">
		<%=bean.getDef_tfr_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.StockAdjustment.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_adj_doc_type_code" id="def_adj_doc_type_code">
		<%=bean.getDef_adj_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_var_doc_type_code" id="def_var_doc_type_code">
		<%=bean.getDef_var_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_prt_doc_type_code" id="def_prt_doc_type_code">
		<%=bean.getDef_prt_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_sal_doc_type_code" id="def_sal_doc_type_code">
		<%=bean.getDef_sal_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_srt_doc_type_code" id="def_srt_doc_type_code">
		<%=bean.getDef_srt_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_obs_doc_type_code" id="def_obs_doc_type_code">
		<%=bean.getDef_obs_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.SplitBatch.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_spl_doc_type_code" id="def_spl_doc_type_code">
		<%=bean.getDef_spl_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.ChangeBin.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_bin_doc_type_code" id="def_bin_doc_type_code">
		<%=bean.getDef_bin_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></td>
		<td>&nbsp;&nbsp;<select name="def_stk_item_con_doc_type_code" id="def_stk_item_con_doc_type_code">
		<%=bean.getDef_stk_item_con_doc_type_code_List()%>
		</select>
		</td>

	</tr>
	<!--//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014-->
	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/>-<fmt:message key="eST.PreparationType.label" bundle="${st_labels}"/> Names </th>	
	</tr>
	<tr>
	    <td class = 'label'  align='left' ><fmt:message key="eST.PrePacking.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<input type=text name="prepacking" id="prepacking" size=40 maxlength=40    onKeyPress=""  value= "<%=prep_prepack%>" onBlur="return  checkPrepack(this);" ></td> 
		 <td class = 'label'  align='left' ><fmt:message key="eST.StandardFormulary.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<input type=text name="standardformulary" id="standardformulary" size=40 maxlength=40   onKeyPress=""  value= "<%=prep_standard%>" onBlur="return  checkStandardform(this);" ></td>
	</tr>
	<tr>
		<td class = 'label'  align='left' ><fmt:message key="eST.Extemporaneous.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<input type=text name="extemporaneous" id="extemporaneous" size=40 maxlength=40    onKeyPress=""  value= "<%=prep_extemp%>" onBlur="return  checkExtemp(this);" ></td>
		 <td class = 'label'  align='left' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
		<td >&nbsp;<input type=text name="others" id="others" size=40 maxlength=40    onKeyPress=""  value= "<%=prep_others%>" onBlur="return  checkOthers(this);" ></td>
	</tr>
	<tr>
	     <td align='left' colspan='4'  class='label'><i><b> Note : 'Extemporaneous' indicates manufacturing with Ad-Hoc Ingredients</i></b></td>
	</tr>
	
	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.DefaultInterfaceGRNValues.label" bundle="${st_labels}"/></th>	
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.Supplier.label" bundle="${st_labels}"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="supplier" id="supplier"  value=""><%=bean.getSupp_code_List(bean.getSupplier())%>
		
			</select></td>
		<td align='left'  class='label'><fmt:message key="eST.TradeName.label" bundle="${st_labels}"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="trade_name" id="trade_name" value="<%=bean.getTrade_Name_List(bean.getTrade_name())%>">
		</select></td>
		<td align='left'  class='label' colspan='2'><fmt:message key="eST.BinnLocation.label" bundle="${st_labels}"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="bin_location" id="bin_location" value="<%=bean.getBin_Locn_List(bean.getBin_location())%>">
		</select></td>
	</tr>
	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.InventoryAgeingSlot.label" bundle="${st_labels}"/></th>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.AgeSlots.label" bundle="${st_labels}"/></td>
		<td colspan='3'>&nbsp;&nbsp;<input type="text" value="<%=bean.getAge_slot_1()%>" name="age_slot_1" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"> --
		<input type="text" value="<%=bean.getAge_slot_2()%>" name="age_slot_2" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"> --
		<input type="text" value="<%=bean.getAge_slot_3()%>" name="age_slot_3" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"> --
		<input type="text" value="<%=bean.getAge_slot_4()%>" name="age_slot_4" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"> --
		<input type="text" value="<%=bean.getAge_slot_5()%>" name="age_slot_5" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"> 
		</td>
	</tr>
<% 
	disabled_weighted_avg_unit_price = ""; //PMG2023-COMN-CRF-0039
	if(bean.getAverageCostUnitPriceYn().equalsIgnoreCase("Y"))
		disabled_weighted_avg_unit_price = "DISABLED";
	else
		disabled_weighted_avg_unit_price = "";

%>
	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.others.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.WeightedAverageCostUnitCostPrice.label" bundle="${st_labels}"/></td> 
		<td colspan='3'>&nbsp;&nbsp;<input type="checkbox"  name="unit_cost_price_yn" id="unit_cost_price_yn" value="<%=bean.getAverageCostUnitPriceYn()%>" <%=bean.getChecked(bean.checkForNull(bean.getAverageCostUnitPriceYn(),"N"))%> <%=disabled_weighted_avg_unit_price%> onclick='callAverageUnitCostYn(this)'></td>
	</tr>

<%//if (!inventory_module_scope.equals("P")) {
%>
<!-- 	<tr>
		<td align='right'  class='label'><fmt:message key="eST.GraceDaysforHomeCare.label" bundle="${st_labels}"/></td>
		<td colspan='3' >&nbsp;&nbsp;<input type="text" value="<%=bean.getGrace_days_for_hc_pat()%>" name="grace_days_for_hc_pat" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="checkIntegerFormat(this);"></td>
	</tr>
 --><%//}%>
	</table>
		</td></tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="ss_period_end_scope" id="ss_period_end_scope" value="<%=bean.getPeriodEndScope()%>">
	<input type="hidden" name="site_id" id="site_id" value="<%=bean.getCustomerID()%>">
	<!--//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014-->
	<input type="hidden"	name="records_exist_for_prepack" id="records_exist_for_prepack"				value="<%= records_exist_for_prepack %>">
	<input type="hidden"	name="records_exist_for_standard" id="records_exist_for_standard"				value="<%= records_exist_for_standard %>">
	<input type="hidden"	name="records_exist_for_others" id="records_exist_for_others"				    value="<%= records_exist_for_others %>">
	<input type="hidden"	name="records_exist_for_extemp" id="records_exist_for_extemp"				    value="<%= records_exist_for_extemp %>">
	<input type="hidden"	name="po_mandatory" id="po_mandatory"				value="<%= po_mandatory %>"> <!-- Added against GDOH-CRF-0109 -->

	</form>
					<%
						putObjectInBean(bean_id,bean,request);
					%>
</body>
</html>


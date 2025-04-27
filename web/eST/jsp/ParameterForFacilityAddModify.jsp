<!DOCTYPE html>

<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				43682			        Abdul Rabbani        27/02/2014      Abdul Rabbani     AMS-SCF-0275
--------------------------------------------------------------------------------------------------------------------------------------------
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)
27/02/2015				52253			        Suresh R           27/02/2015        Suresh R     MMS-QH-CRF-0205(Added Allow Equivalent UOM?s for Physical Inventory Entry)
26/04/2016				56060				Badmavathi B					  PMG2015-CRF-INT-ST-0001(Use 'Authorize at Issue Store' privilege to Authorize)
31/01/2017 				63276				Badmavathi B					  GHL-CRF-0446 Added new column RESTRICT_SPLIT_GRN_BATCHES	
02/11/2017				064982              Sharanraj         				  GHL-CRF-0483 Added new label 	'SelectAllItemsByDefaultWhenSaleDocumentIsPicked' along with checkbox
1/2/2018				66368				Shazana 						  GHL-CRF-0503 Added new column Include_Zero_Stock_QOH	
10/10/2019              IN:071343              B Haribabu                                         GHL-CRF-0608
05/02/2021      TFS id:6938                     B Haribabu          05/02/2021       Manickam           MMS-DM-CRF-0174.3
17/05/2021                                 Chandrashekar Arram                       MO-CRF-20166
7/6/2021				TFS-19787				Shazana													MOHE-CRF-0084.1 

--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.ParameterForFacilityBean,eST.ParameterForEntityBean, eCommon.Common.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ParameterForFacility.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

		<style type="text/css">
			select{
				width=140px;
			}

		</style>
<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled							=			"";
	String records_exist_phy_inv				=			"N";
	String records_exist_for_issue				=			"N";
	String records_exist_for_issueReturn		=			"N";
	String records_exist_Stock_transfer			=			"N";
	String records_exist_for_AllowEqvUOM		=			"N";//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253
	String disabled			= "";
	String issue_history_durn ="";//Added for MO-CRF-20166
	
	String zeroQOHDisabled="";//Added for GHL-CRF-0503
	
	mode								=			"" ;
	bean_id								=			"parameterForFacilityBean" ;
	bean_name							=			"eST.ParameterForFacilityBean";
	ParameterForFacilityBean bean		=			(ParameterForFacilityBean)getBeanObject( bean_id, bean_name,request);   
	bean.setLanguageId(locale);

	bean.clear() ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setMaterial_group_code("ALL") ;
	//Added for GHL-CRF-0446 starts
    	Connection con				= null;
   try{//Added for TFS id:6938		
	con						= ConnectionManager.getConnection(request);
	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	//boolean restrict_req_exd_max_stock = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","RESTRICT_REQ_EXD_MAX_STOCK");
	boolean barcode_appl_for_ack = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","BARCODE_APPL_FOR_ACK");//Added for TFS id:6938
	boolean restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");//Added for TFS id:19787
	
	bean.setSite_spec_yn(site);
	System.out.println("site====>"+site);
	//Added for GHL-CRF-0446 ends
	mode								=			bean.recordExists()?eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"):eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

	ServletContext context				=			getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled					=			"disabled";
		bean.loadData();
		issue_history_durn = bean.getIssueHistoryDurn();//Adding start for MO-CRF-20166
		if(issue_history_durn == null || issue_history_durn.equals("null"))
			issue_history_durn ="30";
		if(issue_history_durn.equals("0"))
			issue_history_durn ="";//Adding end for MO-CRF-20166
	}
	else{
		ParameterForEntityBean bean1	=			(ParameterForEntityBean)getBeanObject( "parameterForEntityBean","eST.ParameterForEntityBean", request);  
		bean1.setLanguageId(locale);
		bean1.clear() ;
		bean1.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		try { 
				bean1.loadData();
		}
		catch (Exception exception) {
			out.println("<script>alert(getMessage('ENTITY_PARAM_NOT_SET','ST'));history.go(-1);</script>");
			exception.printStackTrace();
		}
		bean.setCurr_proc_month		 (    bean1.getCurr_proc_month()      );
		bean.setCurr_proc_year		 (    bean1.getCurr_proc_year()       );
		bean.setDef_grn_doc_type_code(    bean1.getDef_grn_doc_type_code());
		bean.setDef_rtv_doc_type_code(    bean1.getDef_rtv_doc_type_code());
		bean.setDef_mfg_doc_type_code(    bean1.getDef_mfg_doc_type_code());
		bean.setDef_iss_doc_type_code(    bean1.getDef_iss_doc_type_code());
		bean.setDef_ret_doc_type_code(    bean1.getDef_ret_doc_type_code());
		bean.setDef_urg_doc_type_code(    bean1.getDef_urg_doc_type_code());
		bean.setDef_tfr_doc_type_code(    bean1.getDef_tfr_doc_type_code());
		bean.setDef_adj_doc_type_code(    bean1.getDef_adj_doc_type_code());
		bean.setDef_var_doc_type_code(    bean1.getDef_var_doc_type_code());
		bean.setDef_prt_doc_type_code(    bean1.getDef_prt_doc_type_code());
		bean.setDef_sal_doc_type_code(    bean1.getDef_sal_doc_type_code());
		bean.setDef_srt_doc_type_code(    bean1.getDef_srt_doc_type_code());
		bean.setDef_spl_doc_type_code(    bean1.getDef_spl_doc_type_code());
		bean.setDef_obs_doc_type_code(    bean1.getDef_obs_doc_type_code());
		bean.setDef_bin_doc_type_code(    bean1.getDef_bin_doc_type_code());
		
		putObjectInBean("parameterForEntityBean",bean1,request);
	}

		if(bean.getRecordCountForIssue())
			records_exist_for_issue = "Y";
		if(bean.getRecordCountForIssueReturn())
			records_exist_for_issueReturn = "Y";
		if(bean.getRecordCountForStockTransfer())
			records_exist_Stock_transfer = "Y";
		//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
		if(bean.getRecordCountForPhyInvEntry())
		records_exist_for_AllowEqvUOM	="Y";
		//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 end



			if(bean.getPhyInvRecordCount())
			records_exist_phy_inv = "Y";
			
			if(((String)bean.getBatch_look_up_entry_yn()).equalsIgnoreCase("N"))
			{
			disabled="disabled";
			
			}
			//if(bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("ALL"))
				
				//ADDED FOR GHL-CRF-0503
				if(bean.getRestrict_split_GRN_batches().equalsIgnoreCase("N")){
					zeroQOHDisabled="disabled";
				}

%>
</head>
<body onLoad="FocusFirstElement(); getDefaultItmSearch();">
	<form name="formParameterForFacility" id="formParameterForFacility" onReset="FocusFirstElement();">
	<table border=0 align='center' width='100%' height='100%'>
		<tr><td align='center' class='WHITE'>
	<table cellpadding=1 cellspacing=0 align='center' width='98%' border = 0>
	<tr>
	<tr>
		<td colspan='4'>&nbsp;</td></tr>
		<td class='LABEL' colspan='4' align='center' style='padding-left: 1px;'><fmt:message key="Common.CurrentProcessingMonth/Year.label" bundle="${common_labels}"/>&nbsp;<input type="text" value="<%=bean.getCurr_proc_month()%>" name="curr_proc_month" class="NUMBER" maxLength='2' size='2' onKeyPress='return isValidInteger();' <%=codeDisabled%> onBlur="checkIntegerFormat(this);"><input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getCurr_proc_year(),"YY","en",locale)%>" name="curr_proc_year"  class="NUMBER" maxLength='4' size='4' onKeyPress='return isValidInteger();' <%=codeDisabled%> onBlur="checkIntegerFormat(this);"><%=bean.getImage("M")%></td>  <!--Modified for TBMC_scf_0018-->
	</tr>
	 <!-- <tr>
		
		<td colspan='2' class="label"><fmt:message key="eST.DisplayBatchlookupinPhysicalInventoryEntryEntry.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="batch_look_up_entry_yn" id="batch_look_up_entry_yn" value="Y"  <%=bean.getChecked(bean.getBatch_look_up_entry_yn())%> onclick="toggleObject(this)"></td> Modified By Sakti Sankar against inc#34757 

		<td colspan='2' align='right' class='label' ><fmt:message key="eST.ApplicableBatchesInPhysicalInventoryEntry.label" bundle="${st_labels}"/>&nbsp;&nbsp;
		<select name="appl_batches_in_phy_inv_entry" id="appl_batches_in_phy_inv_entry" <%=disabled%> onchange="return checkRecordsPhyInv(this);" >
		<option value="ALL"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("ALL")?"Selected":""%>><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/> </option>
		<option value="GRN"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("GRN")?"Selected":""%>><fmt:message key="eST.GRNBatchesOnly.label" bundle="${st_labels}"/> </option>
		</select>
		</td>  Added By Sakti against CRF# - RUT-CRF-0081 icn#34757 
		<td  class="label" colspan='3' nowrap><fmt:message key="eST.DisplayLookup.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;<select style="width: 370px" name="batch_look_up_entry_yn" id="batch_look_up_entry_yn" value="Y" onchange="return enabledisable(this);" >
		<option value="B"<%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("B")?"Selected":""%>><fmt:message key="eST.DisplayAndAllowNewBatch.label" bundle="${st_labels}"/> </option>
		<option value="Y" <%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("Y")?"Selected":""%>><fmt:message key="eST.AllowBatchLookup.label" bundle="${st_labels}"/> </option>
		<option value="N"<%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("N")?"Selected":""%>> <fmt:message key="eST.ManualBatchEntry.label" bundle="${st_labels}"/> </option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="eST.ApplicableBatchesInPhysicalInventoryEntry.label"bundle="${st_labels}"/>&nbsp;&nbsp;<select name="appl_batches_in_phy_inv_entry" id="appl_batches_in_phy_inv_entry" <%=disabled%> onchange="return checkRecordsPhyInv(this);" >
		<option value="ALL"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("ALL")?"Selected":""%>><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></option><option value="GRN"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("GRN")?"Selected":""%>><fmt:message key="eST.GRNBatchesOnly.label" bundle="${st_labels}"/> </option>
		</select>
		</td>
	</tr> -->
	<tr>
		
		<td colspan='2' class="label"><fmt:message key="eST.AllowChangeBatchDuringAuthorize.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="authorize_batch_change_yn" id="authorize_batch_change_yn" value="Y"  <%=bean.getChecked(bean.getAuthorize_batch_change_yn())%> ></td>
		<td colspan='2' class="label"><fmt:message key="eST.AllowPartialQtyWORemarksDuringAuthorize.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="authorize_partial_qty_rmks_yn" id="authorize_partial_qty_rmks_yn" value="Y"  <%=bean.getChecked(bean.getAuthorize_partial_qty_rmks_yn())%> ></td>
	</tr>
	<!--Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253 beg  -->
	<tr>
		<td colspan='2' class="label"><fmt:message key="eST.AllowEqualUOMforPhyInvEntry.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="allow_equal_UOM_yn" id="allow_equal_UOM_yn" value="Y"  <%=bean.getChecked(bean.getAllow_equal_UOM_yn())%> onclick="checkRecordsForAllowEqvUOMs(this)"></td>
		<!-- Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001  -->
		<!-- 		<td colspan='2' class="label"></td> -->
		<td colspan='2' class="label"><fmt:message key="eST.AllowAuthorizeAtIssueStore.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="allow_authorize_at_issue_store" id="allow_authorize_at_issue_store" value="Y"  <%=bean.getChecked(bean.getAllow_authorize_at_issue_store())%> onclick="checkAllowAuthorizeAtIssueStore(this)"></td>
	</tr>
	<!--Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253 end  -->
	<!-- Added against GHL-CRF-0446 starts -->
	<%if(site){ %>
	<tr>
		<td colspan='2' class="label"><fmt:message key="eST.AllowGRNBatchDuringSplit.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="restrict_split_GRN_batches" id="restrict_split_GRN_batches" value="Y"  <%=bean.getChecked(bean.getRestrict_split_GRN_batches())%> onclick="includeZeroStock(this);"></td>
		<td colspan='2' class="label"><fmt:message key="eST.AllowZeroStockBatchDuringSplit.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="include_Zero_Stock_QOH" id="include_Zero_Stock_QOH"  value="Y" <%=bean.getChecked(bean.getRestrict_split_GRN_batches().equals("N")?"N":bean.getInclude_Zero_Stock_QOH())%> <%=zeroQOHDisabled%> ></td><!-- Added against GHL-CRF-0503 -->
	</tr>
	<%} %>
	<!-- Added against GHL-CRF-0446 ends -->
	<!-- Added for IN:071343 start -->
	
	<tr>
		<td colspan='4' class="label"><fmt:message key="eST.RstrictRequesastionExdMaxstock.label" bundle="${st_labels}"/>  &nbsp;&nbsp;&nbsp;<input type="checkbox" name="restrict_request_exd_max_stock" id="restrict_request_exd_max_stock" value="Y"  <%=bean.getChecked(bean.getRestrict_request_exd_max_stock())%> ></td>
	</tr>
	
	<!-- Added for IN:071343 end -->
	<tr>
	<td align='left' colspan='4' >&nbsp;</td></tr>
	<tr >
		<th align='left' colspan='4'><fmt:message key="eST.AcknowledgementFor.label" bundle="${st_labels}"/></th>	
	</tr>
	<tr>
		<td class="label"><fmt:message key="eST.IssueReqUrg.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="iss_ack_req_yn" id="iss_ack_req_yn" value="Y"  <%=bean.getChecked(bean.getIss_ack_req_yn())%> onclick="checkRecordsForIssue(this)"></td>
		<td class="label"><fmt:message key="eST.IssueReturn.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="iss_ret_ack_req_yn" id="iss_ret_ack_req_yn" value="Y"  <%=bean.getChecked(bean.getIss_ret_ack_req_yn())%> onclick="checkRecordsForIssueReturn(this)"></td>
		<td class="label"><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="stock_trans_ack_req_yn" id="stock_trans_ack_req_yn" value="Y"  <%=bean.getChecked(bean.getStock_trans_ack_req_yn())%> onclick="checkRecordsForStockTransfer(this)" ></td>&nbsp;&nbsp;
		<td class="label">&nbsp;</td>

	</tr>
	<!-- Added for TFS id:6938 start-->
	<%if(barcode_appl_for_ack){ %>
 <tr>
		<td class="label"><fmt:message key="eST.BarcodeForAck.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="barcode_for_ack_req_yn" id="barcode_for_ack_req_yn" value="Y"  <%=bean.getChecked(bean.getBarcodeForAckReqYN())%> ></td>

	</tr>
	<%} %>
	<!-- Added for TFS id:6938 end -->
	<tr>
	<td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.DefaultDocumentTypes.label" bundle="${common_labels}"/></th>	
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_grn_doc_type_code" id="def_grn_doc_type_code">
		<%=bean.getDef_grn_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.ReturnVendor.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_rtv_doc_type_code" id="def_rtv_doc_type_code">
		<%=bean.getDef_rtv_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.ManufacturingReceipt.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_mfg_doc_type_code" id="def_mfg_doc_type_code">
		<%=bean.getDef_mfg_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="Common.Request.label" bundle="${common_labels}"/> <fmt:message key="Common.Issue.label" bundle="${common_labels}"/></TD>
		<td>&nbsp;<select name="def_iss_doc_type_code" id="def_iss_doc_type_code">
		<%=bean.getDef_iss_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.IssueReturns.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_ret_doc_type_code" id="def_ret_doc_type_code">
		<%=bean.getDef_ret_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.UrgentIssue.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_urg_doc_type_code" id="def_urg_doc_type_code">
		<%=bean.getDef_urg_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.StockTransfer.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_tfr_doc_type_code" id="def_tfr_doc_type_code">
		<%=bean.getDef_tfr_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eMM.Adjustment.label" bundle="${mm_labels}"/></TD>
		<td>&nbsp;<select name="def_adj_doc_type_code" id="def_adj_doc_type_code">
		<%=bean.getDef_adj_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="Common.Variance.label" bundle="${common_labels}"/></TD>
		<td>&nbsp;<select name="def_var_doc_type_code" id="def_var_doc_type_code">
		<%=bean.getDef_var_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.ProductTransfer.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_prt_doc_type_code" id="def_prt_doc_type_code">
		<%=bean.getDef_prt_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.Sales.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_sal_doc_type_code" id="def_sal_doc_type_code">
		<%=bean.getDef_sal_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.SalesReturns.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_srt_doc_type_code" id="def_srt_doc_type_code">
		<%=bean.getDef_srt_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="Common.OpeningBalance.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="def_obs_doc_type_code" id="def_obs_doc_type_code">
		<%=bean.getDef_obs_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.SplitBatch.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<select name="def_spl_doc_type_code" id="def_spl_doc_type_code">
		<%=bean.getDef_spl_doc_type_code_List()%>
		</select>
		</td>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.ChangeBin.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<select name="def_bin_doc_type_code" id="def_bin_doc_type_code">
		<%=bean.getDef_bin_doc_type_code_List()%>
		</select>
		</td>
		<td align='left'  class='label'><fmt:message key="eST.StockItemConsumption.label" bundle="${st_labels}"/></TD>
		<td>&nbsp;<select name="def_stk_item_con_doc_type_code" id="def_stk_item_con_doc_type_code">
		<%=bean.getDef_stk_item_con_doc_type_code_List()%>
		</select>
		</td>
		<!-- Added by Sakti against Bru-HIMS-CRF-408 moved from up last check box newly added -->
		<tr>
	<td align='left' colspan='4'>&nbsp;</td></tr>
	<tr>
		<th align='left' colspan='4'><fmt:message key="eST.DefaultsForPhysicalInventory.label" bundle="${st_labels}"/></th>	
	</tr>
<tr>
<td  class="label" colspan='2' nowrap><fmt:message key="eST.DisplayLookup.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;<select style="width: 370px" name="batch_look_up_entry_yn" id="batch_look_up_entry_yn" value="Y" onchange="return enabledisable(this);" >
		<option value="B"<%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("B")?"Selected":""%>><fmt:message key="eST.DisplayAndAllowNewBatch.label" bundle="${st_labels}"/> </option>
		<option value="Y" <%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("Y")?"Selected":""%>><fmt:message key="eST.AllowBatchLookup.label" bundle="${st_labels}"/> </option>
		<option value="N"<%=bean.getBatch_look_up_entry_yn().equalsIgnoreCase("N")?"Selected":""%>> <fmt:message key="eST.ManualBatchEntry.label" bundle="${st_labels}"/> </option></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class="label" nowrap><fmt:message key="eST.ApplicableBatchesInPhysicalInventoryEntry.label"bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td align='left' class="label"><select name="appl_batches_in_phy_inv_entry" id="appl_batches_in_phy_inv_entry" <%=disabled%> onchange="return checkRecordsPhyInv(this);" >
		<option value="ALL"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("ALL")?"Selected":""%>><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></option><option value="GRN"<%=bean.getAppl_batches_in_phy_inv_entry().equalsIgnoreCase("GRN")?"Selected":""%>><fmt:message key="eST.GRNBatchesOnly.label" bundle="${st_labels}"/> </option>
		</select>
		</td>
		
		
	</tr>
	<tr>
	<td  class="label"><fmt:message key="eST.DefaultCutoffDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
	<td  align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getCut_off_days())%>"  name="cut_off_days" class="NUMBER" maxLength='5' size='5' onKeyPress='return isValidInteger();' onBlur="return isValidIntegerZero(this);" >&nbsp; <fmt:message key="Common.days.label" bundle="${common_labels}"/>
	</td>
	<td  class="label"><fmt:message key="eST.UseDeviceForPhysicalCount.label" bundle="${st_labels}"/> &nbsp;&nbsp;&nbsp;</td>
	<td  align='left' class="label"><input type="checkbox" name="phy_inv_dev_yn" id="phy_inv_dev_yn" value="Y"  <%=bean.getChecked(bean.getPhy_inv_dev_yn())%> ></td>
	</tr>
	<!-- Added ends -->
	
		<tr><td align='left' colspan='4'>&nbsp;</td></tr>

	<tr>
		<th align='left' colspan='4'><fmt:message key="Common.OtherDefaults.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
		<td align='left'  class='label'><fmt:message key="eST.GoodsReceipt.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<select name="def_store_code_for_rec" id="def_store_code_for_rec">
		<%=bean.getDef_store_code_for_rec_List()%>
		</select></td>
		<td class='label'><fmt:message key="eST.ItemImageCataloguePath.label" bundle="${st_labels}"/></td>
		<td>&nbsp;<input type="text"   value="<%=bean.checkForNull(bean.getItem_image_catlg_path())%>"  name="item_image_catlg_path"  size='30' maxlength="" > 
	</td>
	</tr>
    <tr>
		<input type="hidden" name="remarks_code" id="remarks_code" value="<%=bean.getRemarks_code()%>">
<!-- 	<td align="right" class="label"  nowrap>
	<a href="javascript:searchRemarks(document.formParameterForFacility.remarks_code.value,document.formParameterForFacility.adjustment_remarks.value)">Adjustment Remarks</a></td>
 -->
		<td align='left'  class='label'> <fmt:message key="eST.AdjRemarks.label" bundle="${st_labels}"/></td>
		<td align='left' colspan='3' >&nbsp;<textarea rows=2 cols=50 name="adjustment_remarks"  onKeyPress="return false;"  onBlur="return checkLength()" disabled ><%=bean.getDef_adjustment_remarks()%></textarea> <input type='button' class='BUTTON' value='?' onClick="searchRemarks(remarks_code,adjustment_remarks);"> </td>
		
	</tr>
	<!-- Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria -->
	<tr>
	<td  class="label"><fmt:message key="eST.DefaultItemSearchBy.label" bundle="${st_labels}"/></td>
	<td  align='left'>&nbsp;<select name="dflt_item_search" id="dflt_item_search" >
		<option value="IN"><fmt:message key="Common.ItemName.label" bundle="${common_labels}"/></option>
		<option value="IC"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
		<option value="MC"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></option>
		<option value="PN"><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></option>
		<option value="TI"><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></option>
		<option value="TN"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></option>
		<option value="AC"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></option></select></td>
<!--Added By Sakti against CRF# - RUT-CRF-0081 icn#34757-->
<!-- 	<td  class="label"><fmt:message key="eST.DefaultCutoffDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
	<td  align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getCut_off_days())%>"  name="cut_off_days" class="NUMBER" maxLength='5' size='5' onKeyPress='return isValidInteger();' onBlur="return isValidIntegerZero(this);" >&nbsp; <fmt:message key="Common.days.label" bundle="${common_labels}"/>
	</td> -->
	<!--Added ends-->
	   
	 <!-- //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014 -->
	<td  class="label" nowrap><fmt:message key="eST.HeaderRemarksModeforStockItemConsumption.label" bundle="${st_labels}"/></td>
	     <td><select name="hdr_rems_mode" id="hdr_rems_mode" onchange="">
		<option value="M" <%=bean.checkForNull(bean.getHdrrems_mode(),"M").equalsIgnoreCase("M")?"Selected":""%> ><fmt:message key="eST.Manual.label" bundle="${st_labels}"/></option>
		<option value="P" <%=bean.checkForNull(bean.getHdrrems_mode(),"P").equalsIgnoreCase("P")?"Selected":""%> > <fmt:message key="eST.Predefined.label" bundle="${st_labels}"/> </option>
		</select></td>
	</tr>
	<!-- Added ended -->
	<!--Added by Rabbani #Inc no:30909 on 12/03/12 -->
	<tr>
	<td class='LABEL'  align='center' style='padding-left: 1px;'><fmt:message key="eST.DurnforStartDate.label" bundle="${st_labels}"/></td>
	<td align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getDurn_for_start_date(),"0")%>"  name="durn_for_start_date" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="return getdurationcheck(this)" >&nbsp; Days 
	</td>
	<!--Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
		 <td  class="label"><fmt:message key="eST.DefaultManufacturingMode.label" bundle="${st_labels}"/> </td>
	     <td><select name="dflt_mfg_mode" id="dflt_mfg_mode" >
		  <!-- Added by Rabbani #Inc no:39330 on 12-APR-2013 -->
		<option value="R" <%=bean.checkForNull(bean.getDft_mode_mfg(),"R").equalsIgnoreCase("R")?"Selected":""%> ><fmt:message key="eST.BasedonRequest.label" bundle="${common_labels}"/></option>
		<option value="D" <%=bean.checkForNull(bean.getDft_mode_mfg(),"R").equalsIgnoreCase("D")?"Selected":""%> ><fmt:message key="eST.DirectManufacturing.label" bundle="${st_labels}"/></option>
		</select></td>
		<!-- ends -->
	</tr>
	<!--ends-->
	<tr>
	<!--//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts -->
	<td class='LABEL'  align='center' style='padding-left: 1px;'><fmt:message key="eST.DefaultDurationforExpiryDateforDisposableDrugswithoutExpiryDate.label" bundle="${st_labels}"/></td>
	<td align='left' class="label"><input type="text"   value="<%=bean.checkForNull(bean.getDflt_Durn_for_ExpDate(),"0")%>"  name="dflt_Durn_for_ExpDate" class="NUMBER" maxLength='4' size='4' onpaste="return false;" onKeyPress='return CheckForDispChars(event);' onBlur="return getdurationforexpdate(this)" > 
	</td>
	<!--Added by suresh.r on 31-01-2014 against AMS-CRF-0054  -->
	<td  class="label"><fmt:message key="eST.IssueRetBaseOn.label" bundle="${st_labels}"/> </td>
	     <td><select name="iss_ret_based_on" id="iss_ret_based_on" onchange="checkRecordsForIssueReturnBaseOn(this)">
		<option value="D" <%=bean.checkForNull(bean.getIss_ret_based_on(),"D").equalsIgnoreCase("D")?"Selected":""%> ><fmt:message key="eST.DocLevel.label" bundle="${st_labels}"/></option>
		<option value="I" <%=bean.checkForNull(bean.getIss_ret_based_on(),"I").equalsIgnoreCase("I")?"Selected":""%> ><fmt:message key="eST.ItemLevel.label" bundle="${st_labels}"/></option>
		</select></td>
	<!--Added by suresh.r on 31-01-2014 against AMS-CRF-0054  -->
	</tr>
	
	<!-- Added by Sharanraj against GHL-CRF-0483 STARTS -->
	<tr>
	<td  class="label"><fmt:message key="eST.SelectAllItemsByDefaultWhenSaleDocumentIsPicked.label" bundle="${st_labels}"/> </td>
	<td> <input type="checkbox" name="Sal_Doc_Picked_yn" id="Sal_Doc_Picked_yn"   value="Y"  <%=bean.getChecked(bean.getSal_Doc_Picked_yn())%>>   </td>
	<td class='LABEL'  align='center' style='padding-left: 1px;'><fmt:message key="eST.DurationForIssueHistory.label" bundle="${st_labels}"/></td><!-- Added for MO-CRF-20166 -->
	<td align='left' class="label"><input type="text"   value="<%=issue_history_durn%>"  name="issue_history_durn" class="NUMBER" maxLength='3' size='3' onKeyPress='return isValidInteger();' onBlur="return getissueHistorycheck(this)" >&nbsp; Days <!-- Added for Mo-CRF-20166 -->
	</td>
	</tr>
	<!-- added for TFS: 19787 -->
	<tr>
	<%
	System.out.println("getuseraccess: "+bean.getUser_access_store_reports_yn());  
	if(restrict_stores_user_access_yn){ %>
	<td  class="label"><fmt:message key="eST.RestrictStoresToUserAccessibleStoresInReports.label" bundle="${st_labels}"/> </td>
	<td> <input type="checkbox" name="user_access_store_reports_yn" id="user_access_store_reports_yn"   value="Y"  <%=bean.getChecked(bean.getUser_access_store_reports_yn())%>>   </td> 
	<%} %>
	
	</tr> <!-- TFS: 19787 END -->
	
	<!-- Added by Sharanraj against GHL-CRF-0483 ENDS   -->
	
	</table>
	<input type="hidden"	name="mode" id="mode"							value="<%=mode%>">
	<input type="hidden"	name="bean_id" id="bean_id"						value="<%=bean_id%>">
	<input type="hidden"	name="bean_name" id="bean_name"					value="<%= bean_name %>">
	<input type="hidden"	name="language_id" id="language_id"					value="<%= locale %>">
	<input type="hidden"	name="records_exist_for_issue" id="records_exist_for_issue"				value="<%= records_exist_for_issue %>">
	<input type="hidden"	name="records_exist_for_issueReturn" id="records_exist_for_issueReturn"				value="<%= records_exist_for_issueReturn %>">
	<input type="hidden"	name="records_exist_Stock_transfer" id="records_exist_Stock_transfer"				value="<%= records_exist_Stock_transfer %>">
	<input type="hidden"	name="records_exist_phy_inv" id="records_exist_phy_inv"		value="<%= records_exist_phy_inv %>">
	<input type="hidden"	name="appl_batches" id="appl_batches"		value="<%=(String)bean.getAppl_batches_in_phy_inv_entry()%>">
	<input type="hidden"	name="function_id" id="function_id"					value="<%=bean.getFunctionId()%>">
	<input type="hidden"	name="rem_trans_type" id="rem_trans_type"				value="ADJ">
 	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<input type="hidden"	name="bean_batch_look_up_entry_yn" id="bean_batch_look_up_entry_yn"				value="<%=bean.getBatch_look_up_entry_yn()%>">
	<!-- Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria -->
	<input type="hidden"	name="dflt_search" id="dflt_search"		value="<%=(String)bean.getDflt_item_search()%>">
	<input type='hidden'	name="dflt_search_item" id="dflt_search_item"		value="<%=(String)bean.getDflt_search_item()%>">
	<!-- Added ended -->
   <!--//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts -->
	<input type='hidden'	name="dflt_manfg_mode" id="dflt_manfg_mode"		   value="<%=(String)bean.getDflt_mfg_mode()%>">
	<input type='hidden'	name="dflt_mode_for_mfg" id="dflt_mode_for_mfg"		value="<%=(String)bean.getDft_mode_mfg()%>">
	<!-- ends -->
	<input type="hidden"	name="chk_iss_ret_based_on" id="chk_iss_ret_based_on"		value="<%=(String)bean.getIss_ret_based_on()%>"><!--Added by suresh.r on 31-01-2014 against AMS-CRF-0054  -->
	<input type="hidden"	name="records_exist_for_AllowEqvUOM" id="records_exist_for_AllowEqvUOM"				value="<%= records_exist_for_AllowEqvUOM %>"><!-- Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 -->
	</form>
<%
		putObjectInBean(bean_id,bean,request);
%>
<%
//Added for TFS id:6938 start	
   }
   catch(Exception e){
   	e.printStackTrace();
   }
   finally{
   	
   	if(con != null)
   		ConnectionManager.returnConnection(con,request);

   }
   //Added for TFS id:6938 end
%>
</body>
</html>


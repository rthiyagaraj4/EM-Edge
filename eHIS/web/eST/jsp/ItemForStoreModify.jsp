<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
31/10/2019      IN:071344       	B Haribabu  15/10/2019      Manickam        GHL-CRF-0609  
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172

---------------------------------------------------------------------------------------------------------
*/
%>   




<%@page  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ItemForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%



	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	//String codeDisabled					=		"";
	String disabled_2						=		"";
	String disabled							=		"";
	String store_code						=		"";
	String item_code						=		"";
	//String item_analysis					=		"";
	String gif_visibility					=		"visibility:visibile";
	String StkYN_checked					=		"";
	String stockItemYNFlag					=		"";
	String request_uom						=		"";
	String issue_uom						=		"";
	String Eff_status_field					=		"";
	String gen_uom_code						=		"";
	String  disabled_1						=		"";
	String  effect_change					=		"Y";
	ItemForStoreDetail itemForStoreDetail	=		null;
	String sales_disabled	=	"";//Added for GHL-CRF-0456 
	String auto_rol_field_disabled					=		"";//Added for  IN:071344 
			
	//Added for MMS-DM-CRF-0177
	
		String pre_alloc_appl_yn = "";
		String near_expiry_appl= "";
		String near_expiry = "";
		String stock_level = "";
		String drug_check_yn="";
		String durn_value ="";
		String durn_type = "";
		String durn_type_N = "";
		String durn_type_D = "";
		String durn_type_M = "";
		String durn_type_Y = "";
		String expiry_stock_val = "";
		String pre_visibility = "visibility:hidden";
		String durn_value_in_days = "";
		String pre_alloc_item_store = "N";
		boolean pre_alloc = false;
		
	//Added for MMS-DM-CRF-0177
		
	/* Mandatory checks start */
	//boolean editMode = false;
	mode									=		request.getParameter("mode");
	function_id								=		request.getParameter("function_id");
	item_code								=		request.getParameter("item_code");
	store_code								=		request.getParameter("store_code");
	request_uom								=		request.getParameter("uom");
	issue_uom								=		request.getParameter("uom");

	bean_id									=		"itemForStoreBean";
	bean_name								=		"eST.ItemForStoreBean";

	if (mode == null || mode.equals("")) 
		return;
	if (!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	ItemForStoreBean bean					=		(ItemForStoreBean)getBeanObject(bean_id,bean_name,request );  
	bean.setLanguageId(locale);
	ServletContext context					=		getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.loadData(store_code,item_code);
		itemForStoreDetail					=		bean.getItemForStoreDetail();
		
	}
	//Added for GHL-CRF-0456 starts
	if(bean.isSalesAllowed(item_code))
	{
		sales_disabled							=	 "disabled";
		itemForStoreDetail.setSales_allowed_yn("N");
	}
	//Added for GHL-CRF-0456 ends
    bean.setLanguageId(locale);
	String bin_locations					=		"";
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setSelected_store_code(itemForStoreDetail.getStore_code());
	if(bean.isNonStockStore(store_code))
	
	{
		disabled_1							=	 "disabled";
	}
	bean.setSelected_bin_location_code(itemForStoreDetail.getBin_location_code());
		disabled							=	"disabled";

	bin_locations							=	bean.getSelectedBinLocations(store_code,item_code);
	String stores							=	bean.getStores();

	if((itemForStoreDetail.getRequestUOM()).length() > 0 )
		request_uom							=	itemForStoreDetail.getRequestUOM();

	if((itemForStoreDetail.getIssueUOM()).length() > 0 )
		issue_uom							=	itemForStoreDetail.getIssueUOM();
		gen_uom_code						=	itemForStoreDetail.getGen_uom_code();
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		if(itemForStoreDetail.getStock_item_yn().equals("Y") && bean.getQtyOnHand(store_code,item_code) > 0 ) {
			stockItemYNFlag					=	"disabled";
		}
		else {
			stockItemYNFlag					=	"";
		}
		if(itemForStoreDetail.getEff_status().equals("E")){
			Eff_status_field				=	"enabled";
		}
		else {
			Eff_status_field				=	"disabled";
		}
		//Added for  IN:071344 start
		if(itemForStoreDetail.getAutoRolYN().equals("Y"))
		{
			auto_rol_field_disabled = "disabled";
		}
		else
		{
			auto_rol_field_disabled = "enabled";
		}
		//Added for  IN:071344 end
	}

if(itemForStoreDetail.getStock_item_yn().equals("Y"))
{
	StkYN_checked							=	"checked";
	gif_visibility							=	"visibility:visible";
	
}
else
{
	StkYN_checked							=	"";
	gif_visibility							=	"visibility:hidden";
	disabled_2								=	"disabled";
}
if(Integer.parseInt((String)bean.fetchRecord("SELECT COUNT (*) COUNT FROM ST_ITEM_BATCH WHERE ITEM_CODE=? AND STORE_CODE=? AND COMMITTED_QTY > 0",new String[]{item_code,store_code}).get("COUNT"))>0)
{
	effect_change="N";
}

//Added for MMS-DM-CRF-0177 - Start
	ArrayList pre_alloc_check = null ;
	ArrayList pre_alloc_item_check = null;
	pre_alloc_check	=	bean.getPreAllocCheck();
	pre_alloc_item_check = bean.getPreAllocItemStore(item_code, store_code);
	drug_check_yn   =   bean.getDrugSearchYN(item_code);
	
	if(pre_alloc_check!=null && pre_alloc_check.size() > 1) {
		pre_alloc_appl_yn	  = pre_alloc_check.get(0)==null?"N":pre_alloc_check.get(0).toString();
	}
	if(pre_alloc_item_check!=null && pre_alloc_item_check.size() > 1)
	{
		near_expiry_appl  = pre_alloc_item_check.get(0)==null?"":pre_alloc_item_check.get(0).toString();
		durn_value  = pre_alloc_item_check.get(1)==null?"":pre_alloc_item_check.get(1).toString();
		durn_type  = pre_alloc_item_check.get(2)==null?"N":pre_alloc_item_check.get(2).toString();
		durn_value_in_days  = pre_alloc_item_check.get(3)==null?"":pre_alloc_item_check.get(3).toString();
	}
	if(pre_alloc_appl_yn.equals("Y") && drug_check_yn.equals("Y")) 
	{
		pre_alloc = true;
		bean.setPreAllocAppl(pre_alloc);
		pre_visibility = "visibility:visible";
		pre_alloc_item_store="Y";
	}
	if(near_expiry_appl.equals("E")){
		near_expiry="checked";
		stock_level="";
		
	}
	else if(near_expiry_appl.equals("S")){
		stock_level="checked";
		near_expiry="";
	}
	
	if(durn_type=="")
	{
		durn_type="N";
	}
	if(durn_type.equals("N"))
		durn_type_N = "selected";
	else if(durn_type.equals("D"))
		durn_type_D = "selected";
	else if(durn_type.equals("M"))
		durn_type_M = "selected";
	else if(durn_type.equals("Y"))
		durn_type_Y = "selected";
	
	
	if(near_expiry.equals("checked"))
	 {
		 expiry_stock_val="";
	 }else{
		 expiry_stock_val="disabled";
	 }
	//Added for MMS-DM-CRF-0177 - End
	
%>
<form name="formItemForStoreModify" id="formItemForStoreModify">
	<table border="0" cellpadding="0" cellspacing="0" width='100%'  height='100%' align=center>
	<tr>
	<td width='100%'  class="WHITE">
		<table border="0" cellpadding="1" cellspacing="0" width='98%'  align=center>
			<tr>
				<td  class="label" colspan='8'>&nbsp;</td>
			</tr>
			<tr>
				<td  class="label">	
					<fmt:message key="Common.Store.label" bundle="${common_labels}"/>
					</td>
				<td  class='fields' colspan='6'>
					&nbsp;&nbsp;
					<select name="store_code" id="store_code" onBlur='return loadBinLocations(this);' <%=disabled%>><%=stores%>
					</select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" >
				</td>
			</tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.item.label" bundle="${common_labels}"/>
				</td>
				<td  class='fields'  colspan='6'>
				&nbsp;&nbsp;
					<input type='text' name="item_desc" id="item_desc" value="<%=itemForStoreDetail.getItem_desc()%>" maxLength=60 size=70 <%=disabled%>>
					<input class="button" onClick="return searchItemCode(item_code,item_desc);" type="button" value="?" <%=disabled%> ><IMG src="../../eCommon/images/mandatory.gif">
					
				
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></td>
				<td   class='fields'>				&nbsp;
					<input type='checkbox' name="stock_item_yn" id="stock_item_yn" onClick="Stk_item_qry_Checked();"  <%=StkYN_checked%> <%=disabled_1%> value="Y" <%=stockItemYNFlag%><%=Eff_status_field%> >
				</td>
				<td  class="label"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></th></td>
				<td   class='fields' colspan="5">&nbsp;&nbsp;<select name="bin_location_code" id="bin_location_code" <%=disabled_2%> <%=Eff_status_field%> ><%=bean.getSelectedBinLocations(store_code,item_code)%></select> &nbsp<img id ="bin_mandiatory" src="../../eCommon/images/mandatory.gif" align=center style ="<%=gif_visibility%>"></td>
			</tr>
						<tr>
				<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	</td>
				<td   class='fields'>&nbsp; 
					<input type='checkbox' name="Eff_status" id="Eff_status" onCLick="eff_status_Checked();" <%=itemForStoreDetail.getEff_status().equals("E")?"checked":""%> 
 					value="<%=itemForStoreDetail.getEff_status()%>" > 
				</td>
				<td  class="label"></td>
				<td  class="label" colspan="5"></td>
			</tr>

			<tr>
				<th  colspan='8'><fmt:message key="eST.ReorderAttributes.label" bundle="${st_labels}"/></th>
			</tr>
			<tr>
		
				<td  class='label'><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="min_stock_qty" id="min_stock_qty" <%=auto_rol_field_disabled %> value="<%=itemForStoreDetail.getMin_stock_qty()%>" size='15' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkDoubleFormat(this);" <%=Eff_status_field%>></td><!-- Modified for  IN:071344 -->
				<td  class="label"><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="5">&nbsp;&nbsp;<input type='text' name="max_stock_qty" id="max_stock_qty"  <%=auto_rol_field_disabled %> value="<%=itemForStoreDetail.getMax_stock_qty()%>" size='15' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(this,reorder_qty);return checkDoubleFormat(this);" <%=Eff_status_field%>></td<!-- Modified for  IN:071344 -->
			</tr>
			<tr> 
       			<td  class="label"><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="reorder_level" id="reorder_level" <%=auto_rol_field_disabled %> value="<%=itemForStoreDetail.getReorder_level()%>" size='15' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);" <%=Eff_status_field%>></td><!-- Modified for  IN:071344 -->
				<td  class="label"><fmt:message key="eST.ReorderFreqDays.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="5">&nbsp;&nbsp;<input type='text' name="reorder_freq_days" id="reorder_freq_days" value="<%=itemForStoreDetail.getReorder_freq_days()%>" onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" size='3' maxLength='3' onBlur="return checkIntegerFormat(this);"<%=Eff_status_field%>></td>
			</tr>
			<tr>
				<td  class="label">
				<fmt:message key="eST.ReorderQuantity.label" bundle="${st_labels}"/>&nbsp;&nbsp;
				<td>&nbsp;&nbsp;<input type='text' name="reorder_qty" id="reorder_qty" <%=auto_rol_field_disabled %> value="<%=bean.checkForNull(itemForStoreDetail.getReorderqty(),"")%>" size='12' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(max_stock_qty,this);return checkIntegerFormat(this);" <%=Eff_status_field%> ></td><!-- Modified for  IN:071344 -->
				<td  class="label" colspan='7'>&nbsp;</td>

			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
				<td   class='fields'>&nbsp;&nbsp;<input type='text' name="lead_days" id="lead_days"  value="<%=bean.checkForNull(itemForStoreDetail.getLead_days(),"")%>" size='12' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);"  ></td>
				<td  class="label"><fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="5">&nbsp;&nbsp;<input type='text' name="min_stock_days" id="min_stock_days"  value="<%=bean.checkForNull(itemForStoreDetail.getMin_stock_days(),"")%>" size='12' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);"  ></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/></td>
				<td   class='fields'>&nbsp;&nbsp;<input type='text' name="min_stock_percentage" id="min_stock_percentage"   value="<%=bean.checkForNull(itemForStoreDetail.getMin_stock_percentage(),"")%>" size='12' maxLength='6' onkeypress="return isValidNumber(this,event,3,2);" class="NUMBER" onBlur="return checkDoubleFormat(this);"  ></td>
				<td  class="label"><fmt:message key="eST.ReqGenerationBase.label" bundle="${st_labels}"/>&nbsp;</td>
				<td   class='fields' colspan="5" >&nbsp;&nbsp;<select name="req_gen_stg" id="req_gen_stg"  <%=Eff_status_field%>><%=bean.getRequestGenStgList()%> </select></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.ReqUOM.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<select name="request_uom" id="request_uom"  <%=Eff_status_field%>><%=bean.getRequest_uom_code_List(gen_uom_code,request_uom,item_code)%></select> </td>
			
				<td  class="label"><fmt:message key="eST.IssueUOM.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="5">&nbsp;&nbsp;<select name="issue_uom" id="issue_uom"  <%=Eff_status_field%> disabled  ><%=bean.getIssue_uom_code_List(gen_uom_code,issue_uom,item_code)%></select>
				<IMG src="../../eCommon/images/mandatory.gif">
				</td>
				
			</tr>
			<tr>
				<td  class="label" nowrap><fmt:message key="eST.PhyInventoryType.label" bundle="${st_labels}"/></td>
				<td   class='fields'>&nbsp;&nbsp;<input type='text' name="phy_inv_type" id="phy_inv_type"  value="<%=itemForStoreDetail.getPhyinv_type()%>" size='7' maxLength='4' <%=Eff_status_field%> ></td>
				<td  class="label" nowrap><fmt:message key="eST.PhyCountPerYear.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="5">&nbsp;
					<select name="phy_inv_count_per_year" id="phy_inv_count_per_year" <%=Eff_status_field%> >
						<option  value='1' <%=(itemForStoreDetail.getPhycountper_year().equals("1"))?"selected":"" %> >1</option>
						<option value='2' <%=(itemForStoreDetail.getPhycountper_year().equals("2"))?"selected":"" %>>2</option>
						<option value='3' <%=(itemForStoreDetail.getPhycountper_year().equals("3"))?"selected":"" %> >3</option>
						<option value='4'<%=(itemForStoreDetail.getPhycountper_year().equals("4"))?"selected":"" %> >4</option>
						<option value='6' <%=(itemForStoreDetail.getPhycountper_year().equals("6"))?"selected":"" %> >6</option>
						<option value='12' <%=(itemForStoreDetail.getPhycountper_year().equals("12"))?"selected":"" %> >12</option> 
					</select>
				</td>
			</tr>
			<!--Added for GHL-CRF-0456 starts -->
				<tr>
				<td  class="label"><fmt:message key="eST.Sales/PatientIssues.label" bundle="${st_labels}"/>	</td>
				<td   class='fields'>&nbsp; 
				<%
				if(itemForStoreDetail.getSales_allowed_yn()==null || itemForStoreDetail.getSales_allowed_yn().equals(""))
					itemForStoreDetail.setSales_allowed_yn("Y");
				%>
					<input type='checkbox' name="sales_allowed_yn" id="sales_allowed_yn" onClick="sales_Checked();" <%=sales_disabled%> <%=!itemForStoreDetail.getSales_allowed_yn().equals("N")?"checked":""%> 
 					value="<%=itemForStoreDetail.getSales_allowed_yn()%>" > 
				</td>
				<td  class="label"><fmt:message key="eST.InternalConsumption.label" bundle="${st_labels}"/>	</td>
				<td   class='fields'>&nbsp; 
				<%
				if(itemForStoreDetail.getConsumption_allowed_yn()==null || itemForStoreDetail.getConsumption_allowed_yn().equals(""))
					itemForStoreDetail.setConsumption_allowed_yn("Y");
				%>
					<input type='checkbox' name="consumption_allowed_yn" id="consumption_allowed_yn" onClick="cons_Checked();"   <%=!itemForStoreDetail.getConsumption_allowed_yn().equals("N")?"checked":""%> 
 					value="<%=itemForStoreDetail.getConsumption_allowed_yn()%>" > 
 					<td  class="label"><fmt:message key="eST.NoofDays.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="no_of_days" id="no_of_days" value="<%=itemForStoreDetail.getNo_of_days()%>" onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" size='3' maxLength='3' onBlur="return checkIntegerFormat1(this);"<%=Eff_status_field%>>
				<fmt:message key="eST.Days.label" bundle="${st_labels}"/></td> 
				<!-- MO-CRF-20172 -->
				</td>
			</tr>
			<!-- Added for GHL-CRF-0456 ends -->
			
			<!-- Added for MMS-DM-CRF-0177 -->
<tr>
				 <td  class="label" id="pre_alloc_1" nowrap style="<%=pre_visibility%>"><fmt:message key="eST.PreAllocationDrugs.label" bundle="${st_labels}"/></td>
	
				<td class="fields" id="pre_check" style="<%=pre_visibility%>" nowrap><input type="radio" name="expiry_stock_1" id="expiry_stock_1" id=expiry_stock_1" value="<%=near_expiry_appl%>" <%=near_expiry%> onClick="applicableAllocation('E',document.formItemForStoreModify)" ><fmt:message key="eST.NearExpiry.label" bundle="${st_labels}"/>
				<input type="text" nowrap size="3" name="durn_value" id="durn_value" id="durn_value_1" maxlength="2" class="NUMBER" value="<%=durn_value%>" onBlur="CheckNum(this);checkSplChars(this);ChkNumberInput1(this,document.formItemForStoreModify);ChkDuration(this,'',document.formItemForStoreModify);" <%=expiry_stock_val%>> &nbsp;
				
				<select name="durn_type" id="durn_type" id="durn_type_1" onchange="validateDuration(durn_value,this);ChkDuration(durn_value,this,document.formItemForStoreModify);" <%=expiry_stock_val%>>
				<option value="N" <%=durn_type_N %>>---<fmt:message key="eST.Select.label" bundle="${st_labels}"/>---</option> <!--  N stands for Nothing -->
				<option value="D" <%=durn_type_D %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
				<option value="M" <%=durn_type_M %>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
				<option value="Y" <%=durn_type_Y %>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				</select>&nbsp;
				
				<input type="radio" name="expiry_stock_2" id="expiry_stock_2" id=expiry_stock_2" value="<%=near_expiry_appl%>" <%=stock_level%> onClick="applicableAllocation('S',document.formItemForStoreModify)" ><fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>
				
				</td> 
				<td colspan="6">&nbsp;</td>
</tr>
				<!-- Added for MMS-DM-CRF-0177 -->
			<tr>
				<td  class="label" colspan='8'>&nbsp;</td>
			</tr>
			</table>
	</table>
			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=function_id%>">
			<input type="hidden" name="effect_change" id="effect_change"		value="<%=effect_change%>">
			<input type="hidden" name="store_desc" id="store_desc"			value="<%=itemForStoreDetail.getStore_desc()%>">
			<input type="hidden" name="item_code" id="item_code"			value="<%=itemForStoreDetail.getItem_code()%>">
			<input type="hidden" name="bin_location_desc" id="bin_location_desc"   value="<%=itemForStoreDetail.getBin_location_desc()%>">
			<input type="hidden" name="auto_rol_yn" id="auto_rol_yn"   value="<%=itemForStoreDetail.getAutoRolYN()%>"><!-- Added for  IN:071344 -->
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"  value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
			
			<!-- Added for MMS-DM-CRF-0177 -->
			<input type="hidden" name="near_expiry_appl" id="near_expiry_appl"	value="<%=near_expiry_appl%>">
			<input type="hidden" name="durn_value_in_days" id="durn_value_in_days"  value="<%=durn_value_in_days%>">
			<input type="hidden" name="pre_alloc_item_store" id="pre_alloc_item_store" value="<%=pre_alloc_item_store%>">
			<input type="hidden" name="stock_level" id="stock_level" value="<%=stock_level%>">
			<input type="hidden" name="near_expiry" id="near_expiry" value="<%=near_expiry%>">
			<!--  Added for MMS-DM-CRF-0177 --> 
			
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


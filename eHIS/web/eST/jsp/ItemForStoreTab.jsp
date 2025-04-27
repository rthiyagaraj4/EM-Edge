<%
/*   
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603		Badmavathi B						GHL-CRF-0456
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
<body onSelect="codeArrestThruSelect();">	 

<%
	
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	//String codeDisabled		=		"";
	String disabled				=		"";
	String store_code			=		"";
	String item_code			=		"";
	String item_analysis		=		"";
	String checked				=		"";
	String request_uom			=		"";
	String issue_uom			=		"";
	String gen_uom_code			=		"";
	String gif_visibility		=		"visibility:visibile";
	String modify_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
	String add_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String dis_abled			=		"disabled";
	
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
	boolean pre_alloc = false;
	String durn_value_in_days = "";
	String pre_alloc_item_store = "N";
	
	//Added for MMS-DM-CRF-0177
	
	ItemForStoreDetail itemForStoreDetail;

	/* Mandatory checks start */
	boolean editMode			=		false;
	mode						=		request.getParameter("mode");
	function_id					=		request.getParameter("function_id");
	item_code					=		request.getParameter("item_code");
	store_code					=		request.getParameter("store_code");
	bean_id						=		"itemForStoreBean";
	bean_name					=		"eST.ItemForStoreBean";
	//Added for GHL-CRF-0456 starts	
	String consumption_allowed_yn ="";
	String sales_allowed_yn ="";
	boolean sales_yn=false;
	//Added for GHL-CRF-0456 ends  

	if (mode == null || mode.equals("")) 
		return;
	if (!(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	ItemForStoreBean bean = (ItemForStoreBean)getBeanObject(bean_id, bean_name,request );  
	  bean.setLanguageId(locale);

	ServletContext context		=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	String bin_locations		=		"";
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if (item_code != null && store_code != null)	{
		itemForStoreDetail		=		 bean.getItemForStoreDetail(store_code,item_code);
		editMode = true;
		
	}
	else {
		itemForStoreDetail		=		new ItemForStoreDetail();
		editMode = false;
		itemForStoreDetail.clear();
	}
	bean.setSelected_store_code(itemForStoreDetail.getStore_code());
	bean.setSelected_bin_location_code(itemForStoreDetail.getBin_location_code());
	if (editMode)	{
	//Added for GHL-CRF-0456 starts	
		 consumption_allowed_yn =itemForStoreDetail.getConsumption_allowed_yn();
		 sales_allowed_yn = itemForStoreDetail.getSales_allowed_yn();
		 sales_yn = bean.isSalesAllowed(item_code);
	//Added for GHL-CRF-0456 ends
		disabled			=	 "disabled";
		bin_locations		=	 bean.getDfltBinLocation(store_code);
		
		request_uom			=		itemForStoreDetail.getRequestUOM();
		issue_uom			=		itemForStoreDetail.getIssueUOM();
		gen_uom_code		=	(String)bean.fetchRecord("SELECT GEN_UOM_CODE from  mm_item_lang_vw	B  WHERE B.item_code	= ? and  B.language_id = ?",new String[]{item_code,locale}).get("GEN_UOM_CODE");
//itemForStoreDetail.getGen_uom_code();
	}
	else {
		bin_locations		=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>"; 
	

	}


	String stock_item_yn = itemForStoreDetail.getStock_item_yn();
	if (stock_item_yn != null) {
		checked				=		stock_item_yn.equals("Y")?"checked":"";
		gif_visibility		=		stock_item_yn.equals("Y")?"visibility:visible":"visibility:hidden";
	}
	String stores = bean.getStores();
	
	//Added for MMS-DM-CRF-0177
	
	ArrayList pre_alloc_check = null;
    pre_alloc_check	=	bean.getPreAllocCheck();
	drug_check_yn   =   bean.getDrugSearchYN(item_code);	
	
	if(!editMode){		
	if(pre_alloc_check!=null && pre_alloc_check.size() > 1) {
		pre_alloc_appl_yn	  = pre_alloc_check.get(0)==null?"N":pre_alloc_check.get(0).toString();
		near_expiry_appl	  = pre_alloc_check.get(1)==null?"":pre_alloc_check.get(1).toString();
		durn_value			  = pre_alloc_check.get(2)==null?"":pre_alloc_check.get(2).toString();
		durn_type			  = pre_alloc_check.get(3)==null?"N":pre_alloc_check.get(3).toString();
		durn_value_in_days	  = pre_alloc_check.get(4)==null?"":pre_alloc_check.get(4).toString();
	   }
	}else{
		if(pre_alloc_check!=null && pre_alloc_check.size() > 1){
			pre_alloc_appl_yn	  = pre_alloc_check.get(0)==null?"N":pre_alloc_check.get(0).toString();
		}	
		near_expiry_appl = itemForStoreDetail.getNearExpiryAppl();
		durn_type = itemForStoreDetail.getDurnType();
		durn_value = itemForStoreDetail.getDurnValue();
		durn_value_in_days =  itemForStoreDetail.getDurnValueInDays();
	}
	
	if(pre_alloc_appl_yn.equals("Y") && drug_check_yn.equals("Y"))
	{
		pre_alloc = true;
		bean.setPreAllocAppl(pre_alloc);
		pre_visibility = "visibility:visible";
		pre_alloc_item_store="Y";
	}
	//System.err.println("near_expiry_appl"+ near_expiry_appl);
	if((near_expiry_appl!=null) && near_expiry_appl.equals("E")){
			near_expiry="checked";
			stock_level="";
			
		}
	else if((near_expiry_appl!=null) && near_expiry_appl.equals("S")){
		stock_level="checked";
		near_expiry="";
	}
	
	if(durn_type=="" || durn_type == null)
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
	
	//Added for MMS-DM-CRF-0177
%>
<form name="formItemForStoreSingleDetail" id="formItemForStoreSingleDetail" >
		<table border="0" cellpadding="1" cellspacing="0" width='100%'  align=center>
			<a name="tab1" id="tab1"></a>
<img src="../../eST/images/IndividualItem.gif" border="0" alt="Individual Item" style="position: relative; top: 10px;">

<a href="javascript:void(0);" onclick="scrollToTab7();">
  <img src="../images/RangeOfItems_click.gif" border="0" alt="Range of Items" style="position: relative; top: 10px;">
</a>
	
			<tr>
				<td  colspan="4">&nbsp;</td>
			</tr>
			
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align=center>
			<tr>
				<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<select name="store_code" id="store_code" onBlur='return populateBinLocation();' <%=disabled%>><%=stores%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></td>
				<td  class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td  class='fields' colspan="3">&nbsp;&nbsp;<input type='text' name="item_desc" id="item_desc" value="<%=itemForStoreDetail.getItem_desc()%>" maxLength=60 size=70 onMouseOver='setItemDesc();' <%=disabled%>><input name="item_search" id="item_search" class="button" onClick="return callItemSearchScreen();" type="button" value="?" <%=disabled%> >&nbsp;<IMG src="../../eCommon/images/mandatory.gif"align='center'></td>
				<!-- searchItemCode(item_code,item_desc) -->
			</tr>
			<tr>
				<td  class="label"><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></td>
				<td   class='fields'>&nbsp;<input type='checkbox' name="stock_item_yn" id="stock_item_yn" onCLick="Stk_item_create_Checked(store_code);" value="Y" <%=checked%> ></td>
				<td  class='label'><fmt:message key="eST.MinStock.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="min_stock_qty" id="min_stock_qty" value="<%=itemForStoreDetail.getMin_stock_qty()%>" size='15' maxLength='12' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkDoubleFormat(this);">
			<td  class="label">	&nbsp;<fmt:message key="eST.ReorderQuantity.label" bundle="${st_labels}"/></td>
			<td   class='fields'>	&nbsp;&nbsp;<input type='text' name="reorder_qty" id="reorder_qty" value="<%=itemForStoreDetail.getReorderqty()%>" size='15' maxLength='12' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(max_stock_qty,this);return checkDoubleFormat(this);"></td>
			</tr>
			<tr>
       			<td  class="label"><fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="reorder_level" id="reorder_level" value="<%=itemForStoreDetail.getReorder_level()%>" size='15' maxLength='15' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);"></td>
				<td  class="label"><fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/></td>
				<td  class='fields' colspan="3">&nbsp;&nbsp;<input type='text' name="max_stock_qty" id="max_stock_qty" value="<%=itemForStoreDetail.getMax_stock_qty()%>" size='15' maxLength='12' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(this,reorder_qty);return checkDoubleFormat(this);"></td>
			</tr>
			
			<tr>
				<td  class="label"><fmt:message key="Common.BinLocation.label" bundle="${common_labels}"/></td>
				<td  class='fields' >&nbsp;&nbsp;<select name="bin_location_code" id="bin_location_code" disabled ><%=bin_locations%></select>&nbsp;<img id ="bin_mandiatory" src="../../eCommon/images/mandatory.gif" align=center style ="<%=gif_visibility%>"></td> 
				<td  class="label"><fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
				
				<td   class='fields'>&nbsp;&nbsp;<input type='text' name="lead_days" id="lead_days" disabled value="<%=bean.checkForNull(itemForStoreDetail.getLead_days(),"")%>" size='15' maxLength='4' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);"></td>
				<td  class="label">&nbsp;<fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
				<td  class='fields'>&nbsp;<input type='text' name="min_stock_days" id="min_stock_days" disabled value="<%=bean.checkForNull(itemForStoreDetail.getMin_stock_days(),"")%>" size='15' maxLength='4' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);"></td>
				
			</tr>
			
			<tr>
				<td  class="label"><fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/></td>
				<td   class='fields'>&nbsp;&nbsp;<input type='text' name="min_stock_percentage" id="min_stock_percentage" disabled value="<%=bean.checkForNull(itemForStoreDetail.getMin_stock_percentage(),"")%>" size='15' maxLength='15' onkeypress="return isValidNumber(this,event,3,2);" class="NUMBER" onBlur="return checkDoubleFormat(this);"></td>
				<td  class="label"><fmt:message key="eST.ReqUOM.label" bundle="${st_labels}"/></td>
				<%if (item_code != null && store_code != null)
				{



				%>
				<td  class='fields'>&nbsp;<select name="request_uom" id="request_uom"><%=bean.getRequest_uom_code_List(gen_uom_code,request_uom,item_code)%></select></td>
				<%}else{
				%>
				<td  class='fields'>&nbsp;&nbsp;<select name="request_uom" id="request_uom"><option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option></select></td>
				<%}%>
				<td  class="label" >&nbsp;<fmt:message key="eST.IssueUOM.label" bundle="${st_labels}"/></td>
					<%if (item_code != null && store_code != null)
				{
					
					

				%>
				<td  class='fields'>&nbsp;<select name="issue_uom" id="issue_uom" ><%=bean.getRequest_uom_code_List(gen_uom_code,issue_uom,item_code)%></select>
				<IMG src="../../eCommon/images/mandatory.gif"align='center'>
				</td>
				<%}else{
				%>
				<td  class='fields'>&nbsp;<select name="issue_uom" id="issue_uom" disabled<%=dis_abled%>><option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option></select>
				<IMG src="../../eCommon/images/mandatory.gif"align='center'>
				</td>
				<%}
				%>
			</tr>

			<tr>
				<td  class="label" ><fmt:message key="eST.ReorderFreqDays.label" bundle="${st_labels}"/></td>
				<td class='fields'>&nbsp;&nbsp;<input type='text'  name="reorder_freq_days" id="reorder_freq_days" value="<%=itemForStoreDetail.getReorder_freq_days()%>" onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" size='3' maxLength='3' onBlur="return checkIntegerFormat(this);"></td>
				
				<td  class="label" colspan="4"><fmt:message key="eST.ReqGenerationBase.label" bundle="${st_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name='req_gen_stg' id='req_gen_stg'><%=bean.getRequestGenStgList()%></select></td>
				</tr>
				<!--Added for GHL-CRF-0456 starts-->
			<tr>
				<td  class="label"><fmt:message key="eST.Sales/PatientIssues.label" bundle="${st_labels}"/>	</td>
				<td   class='fields'>&nbsp; <input type='checkbox' name="sales_allowed_yn" id="sales_allowed_yn"  disabled  ></td>
				<td  class="label"><fmt:message key="eST.InternalConsumption.label" bundle="${st_labels}"/>	</td>
				<td   class='fields'> <input type='checkbox' name="consumption_allowed_yn" id="consumption_allowed_yn"   disabled ></td>
				
				<!--Added for GHL-CRF-0456 ends-->
				
				<!-- MO-CRF-20172 START -->				
				<td  class="label" ><fmt:message key="eST.NoofDays.label" bundle="${st_labels}"/></td>
				<td class='fields'>&nbsp;&nbsp;<input type='text'  name="no_of_days" id="no_of_days" value="<%=itemForStoreDetail.getNo_of_days()%>" onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" size='3' maxLength='3' onBlur="return checkIntegerFormat1(this);">
				<fmt:message key="eST.Days.label" bundle="${st_labels}"/></td> 
				<!-- MO-CRF-20172 END -->
				</tr>
				<tr>
				
				<!-- Added for MMS-DM-CRF-0177 -->
		
				<td  class="label" id="pre_alloc_1" nowrap style="<%=pre_visibility%>"><fmt:message key="eST.PreAllocationDrugs.label" bundle="${st_labels}"/></td>
	
				<td id="pre_check" class="fields" style="<%=pre_visibility%>" nowrap><input type="radio" name="expiry_stock_1" id="expiry_stock_1" id=expiry_stock_1" value="<%=near_expiry_appl%>" <%=near_expiry%> onClick="applicableAllocation('E',document.formItemForStoreSingleDetail)" ><fmt:message key="eST.NearExpiry.label" bundle="${st_labels}"/>
				<input type="text" nowrap size="3" name="durn_value" id="durn_value" id="durn_value_1" maxlength="2" class="NUMBER" value="<%=durn_value%>" onBlur="CheckNum(this);checkSplChars(this);ChkNumberInput1(this,document.formItemForStoreSingleDetail);ChkDuration(this,'',document.formItemForStoreSingleDetail);" <%=expiry_stock_val%>>&nbsp;
				
				<select name="durn_type" id="durn_type" id="durn_type_1" onchange="validateDuration(durn_value,this);ChkDuration(durn_value,this,document.formItemForStoreSingleDetail);" <%=expiry_stock_val%> >
				<option value="N" <%=durn_type_N %>>---<fmt:message key="eST.Select.label" bundle="${st_labels}"/>---</option> <!--  N stands for Nothing -->
				<option value="D" <%=durn_type_D %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
				<option value="M" <%=durn_type_M %>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
				<option value="Y" <%=durn_type_Y %>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				</select>&nbsp;
				
				<input type="radio" name="expiry_stock_2" id="expiry_stock_2" id=expiry_stock_2" value="<%=near_expiry_appl%>" <%=stock_level%> onClick="applicableAllocation('S',document.formItemForStoreSingleDetail)" ><fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/>
				
				</td> 

				<td colspan="3">&nbsp;</td>

				<!-- Added for MMS-DM-CRF-0177 -->
								
				<td  class='fields'>
				
					<input type='button' value='<%=editMode?modify_legend:add_legend%>' name='add_single' class='BUTTON' onClick='updateSingle();'></input>&nbsp;&nbsp;&nbsp; 
				
					<input type='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name='cancel_single' onBlur='return setStoreFocus();' onClick='clearSingleForm();' class='BUTTON'></input>
				</td>
				</tr>
				</table>
			</tr>
			</table>
			<br> <br><br><br><br><br><br><br><br><br><br><br><br>

			<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=function_id%>">
			<input type="hidden" name="dis_abled" id="dis_abled"			value="<%=dis_abled%>">
			<input type="hidden" name="store_desc" id="store_desc"			value="<%=itemForStoreDetail.getStore_desc()%>">
			<input type="hidden" name="item_code" id="item_code"			value="<%=itemForStoreDetail.getItem_code()%>">
			<input type="hidden" name="bin_location_desc" id="bin_location_desc"   value="<%=itemForStoreDetail.getBin_location_desc()%>">
			<input type="hidden" name="medical_item_yn" id="medical_item_yn"		value="">
			<input type="hidden" name="editing" id="editing"				value="<%=editMode?2:1%>">
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"	value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="near_expiry_appl" id="near_expiry_appl"	value="<%=near_expiry_appl%>"><!-- Added for MMS-DM-CRF-0177 -->
			<input type="hidden" name="durn_value_in_days" id="durn_value_in_days"  value="<%=durn_value_in_days%>"><!--  Added for MMS-DM-CRF-0177 --> 
			<input type="hidden" name="pre_alloc_item_store" id="pre_alloc_item_store" value="<%=pre_alloc_item_store%>"><!--  Added for MMS-DM-CRF-0177 --> 
	</form>
	
	<form name="formItemForStoreMultipleDetail" id="formItemForStoreMultipleDetail">
	<%
		bean.setSelected_store_code("");
		bean.setSelected_bin_location_code("");
		item_analysis = bean.getItemAnalysis();
	%>	
			<!-- Batch Processing -->
			<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
			<tr>
				<td   class='white'><a  href="javascript:tab1.scrollIntoView();
				if(document.formItemForStoreSingleDetail.add_single.value == '  Add  '){  document.formItemForStoreSingleDetail.store_code.focus();}else{document.formItemForStoreSingleDetail.min_stock_qty.focus();}" onFocus="javascript:tab7.scrollIntoView();" name="tab7" id="tab7"><img  src="../images/IndividualItem_click.gif" border=0></a><img  src="../images/RangeOfItems.gif" border=0></td>
			</tr>
			</table>
			<br><br>
			<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
			<tr>
				<td  class="label">&nbsp;</td>
				<td  class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td  class="label">&nbsp;</td>
				<td  class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>	
			<tr>
				<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="from_store_code" id="from_store_code" value="" maxLength=6 size=6 class="UPPER"  onBlur="toUpperCase(this);"><input class="button" onClick="searchStoreCode(from_store_code,m_store_desc);" type="button" value="?" name="store_search_from" id="store_search_from"></td>
				<td  class="label">&nbsp;</td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="to_store_code" id="to_store_code" value="" maxLength=6 size=6 class="UPPER"  onBlur='toUpperCase(this);'><input class="button" onClick="searchStoreCode(to_store_code,m_store_desc);" type="button" value="?"></td>
			</tr>	
			<tr>
				<td  class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="from_item_code" id="from_item_code" value="" maxLength=20 size=20 class="UPPER"  onBlur="toUpperCase(this);"><input class="button" onClick="callMultipleItemSearchScreen(from_item_code,m_item_desc);" type="button" value="?"></td>
				<td  class="label">&nbsp;</td>
				<td  class='fields'>&nbsp;&nbsp;<input type='text' name="to_item_code" id="to_item_code" value="" maxLength=20 size=20 class="UPPER"  onBlur="toUpperCase(this);"><input class="button" onClick="callMultipleItemSearchScreen(to_item_code,m_item_desc);" type="button" value="?"></td>
			</tr>	
			<tr>
				<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
				<td  class='fields'>&nbsp;&nbsp;<select name="m_item_analysis_from_1" id="m_item_analysis_from_1" ><%=item_analysis%></select></td>
				<td >&nbsp;</td>
				<td  class='fields'>&nbsp;&nbsp;<select name="m_item_analysis_to_1" id="m_item_analysis_to_1" ><%=item_analysis%></select></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
				<td >&nbsp;&nbsp;<select name="m_item_analysis_from_2" id="m_item_analysis_from_2"><%=item_analysis%></select></td>
				<td  class='fields'>&nbsp;</td>
				<td class='fields' >&nbsp;&nbsp;<select name="m_item_analysis_to_2" id="m_item_analysis_to_2"><%=item_analysis%></select></td>
			</tr>
			<tr>
				<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
				<td  class='fields'>&nbsp;&nbsp;<select name="m_item_analysis_from_3" id="m_item_analysis_from_3"><%=item_analysis%></select></td>
				<td >&nbsp;</td>
				<td  class='fields'>&nbsp;&nbsp;<select name="m_item_analysis_to_3" id="m_item_analysis_to_3"><%=item_analysis%></select></td>
			</tr>
			
			</table>
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
			<th ></th><th ></th>
		</table>
		<br>
		
			<table border="0" cellpadding="1" cellspacing="0" width='100%'  align=center>
				<tr>
				
					<td  class="label" colspan=2 nowrap>&nbsp<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input id = 'Stock_item' type='checkbox'  name="m_stock_item_yn" id="m_stock_item_yn" value="Y" onCLick="Stk_itemChecked();">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.MinStock.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name="m_min_stock_qty" id="m_min_stock_qty" value="" size='6' maxLength='9' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="makeValidString(this);">&nbsp;&nbsp;&nbsp;<fmt:message key="eST.MaxStock.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name="m_max_stock_qty" id="m_max_stock_qty" value="" size='6' maxLength='9' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(this,reorder_qty);return checkDoubleFormat(this);">
					&nbsp;&nbsp;<fmt:message key="eST.ReorderQuantity.label" bundle="${st_labels}"/>
					&nbsp;&nbsp;<input type='text' name="reorder_qty" id="reorder_qty" value="" size='15' maxLength='12' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="chkReorderQty(m_max_stock_qty,this);return checkDoubleFormat(this);"></td> 
				</tr>
			
       			
		<tr>
			
				<td  class="label" colspan=2 nowrap>
				&nbsp;<fmt:message key="eST.ROLevel.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name="m_reorder_level" id="m_reorder_level" value="" size='4' maxLength='9' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="makeValidString(this);">&nbsp;&nbsp;<fmt:message key="eST.ReorderFreqDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;
				<input type='text' name="m_reorder_freq_days" id="m_reorder_freq_days" value="" onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" size='3' maxLength='3' onBlur="makeValidString(this);">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.ReqGenerationBase.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;<select name='m_req_gen_stg' id='m_req_gen_stg'><%=bean.getRequestGenStgList()%></select>
				</td>
			
		</tr>
			
		<tr>
			<td  class="label" colspan=2 nowrap>&nbsp;<fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/>&nbsp;&nbsp;<input type='text' name="m_min_stock_percentage" id="m_min_stock_percentage" disabled value="" size='4' maxLength='4' onkeypress="return isValidNumber(this,event,3,2);" class="NUMBER" onBlur="return checkDoubleFormat(this);">&nbsp;&nbsp;<fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name="m_lead_days" id="m_lead_days" disabled value="" size='3' maxLength='4' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text' name="m_min_stock_days" id="m_min_stock_days" disabled value="" size='2' maxLength='4' onkeypress="return isValidNumber(this,event,<%=bean.getStRepositoryValue("INTEGER_PRECISION")%>,0);" class="NUMBER" onBlur="return checkIntegerFormat(this);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='button' onclick="return updateMultiple();" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' name='m_add' class='BUTTON'></input>
				<input type='button' onclick='clearMultipleForm();' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' name='m_cancel' class='BUTTON' onClick='return setFromStoreFocus();'></input></td>
			</tr>

		</table>
			
			<tr>
				<td  colspan="4">&nbsp;</td>
			</tr>
	<input type="hidden" name="mode" id="mode"				value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" name="facility_id" id="facility_id"			value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="function_id" id="function_id"			value="<%=function_id%>">
	<input type="hidden" name="m_bin_location_desc" id="m_bin_location_desc" value="">
	<input type="hidden" name="m_store_desc" id="m_store_desc"		value="">
	<input type="hidden" name="m_item_desc" id="m_item_desc"			value="">
	<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
	<input type="hidden" name="SQL_ST_ITEM_STORE_LOOKUP" id="SQL_ST_ITEM_STORE_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_STORE_LOOKUP")%>">
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
	<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" >
	<tr>
		<td width="100%" id="toolTipData">&nbsp;</td>
	</tr>
</table>
<% if (editMode){ %>
<script> 
	<% if (stock_item_yn.equals("Y"))
		{	%>
			document.formItemForStoreSingleDetail.stock_item_yn.checked = true;
			document.formItemForStoreSingleDetail.bin_location_code.disabled = false;
		<%
		//Added for GHL-CRF-0456 starts
		}if(consumption_allowed_yn.equals("Y")){%>
		document.formItemForStoreSingleDetail.consumption_allowed_yn.checked = true;
		document.formItemForStoreSingleDetail.consumption_allowed_yn.disabled = false;
		 <%}else{%>
		 document.formItemForStoreSingleDetail.consumption_allowed_yn.checked = false;
			document.formItemForStoreSingleDetail.consumption_allowed_yn.disabled = false;
		 <%}
		if(sales_allowed_yn.equals("N") && sales_yn){%>
		 document.formItemForStoreSingleDetail.sales_allowed_yn.checked = false;
			document.formItemForStoreSingleDetail.sales_allowed_yn.disabled = true;
		<% }
		else if(sales_allowed_yn.equals("N") && !sales_yn){%>
		document.formItemForStoreSingleDetail.sales_allowed_yn.checked = false;
		document.formItemForStoreSingleDetail.sales_allowed_yn.disabled = false;
		<%}
		else{%>
		 document.formItemForStoreSingleDetail.sales_allowed_yn.checked = true;
			document.formItemForStoreSingleDetail.sales_allowed_yn.disabled = false;
		 <%}		//Added for GHL-CRF-0456 ends
			 %>
</script>
<%}%>
</form>
			<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


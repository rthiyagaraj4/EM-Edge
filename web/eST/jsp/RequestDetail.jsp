<!DOCTYPE html>
<!-- 
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017	IN061750		Badmavathi B									ML-MMOH-CRF-0567		
06/06/2018	IN067830			Shazana												ML-MMOH-SCF-1013		
14/10/2019  IN:071343        B Haribabu                                         GHL-CRF-0608
17/05/2021                   Chandrashekar Arram                                    MO-CRF-20166
-------------------------------------------------------------------------------------------------------------------------------
*/
 -->
<%@ page import=" eST.RequestBean,eST.RequestDetailBean, java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/Request.js"></script>

		 <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		 </script>
</head>
<%
	boolean editMode					=			 false;
	RequestDetailBean requestDetail;
	String mode							=			 request.getParameter("mode");
	String edit							=			 request.getParameter("edit")==null?"1":request.getParameter("edit");
	String disabled						=			 "";
	String item_disabled				=			 "";
	String item_desc					=			 "", item_desc_temp="";
	String uom							=			 "";
	String required_qty					=			 "";
	String req_uom_qty					=			 "";
	String	pur_uom_code				=			 "";
	String	conv_fact					=			 "1";// added for ML-MMOH-SCF-1013
	String	qty_on_hand					=			 "";
	String	max_stk_qty					=			 "";
	String	uom_conv_text			=			 "";
	String reset_mode						=		CommonBean.checkForNull(request.getParameter("reset_mode"));
	
	
	int srl_no							=			-1;
	mode								=			mode.trim();

	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	String bean_id						=			 "requestBean";
	String bean_name					=			 "eST.RequestBean";
	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String disable_add					=			"";
	String stock_item_yn				=			"";
	String available_stock				=			"";
	String checked						=			"";
	String	uom_code					=			"";
	String	kit_item_yn					=			"";
	String	kit_template_uom			=			"";
	String	display_style				=			 "visibility:hidden";
	String	kit_uom_code				=			"";
	String	def_issue_uom				=			"";
	String from_multiples				=			"1";
	String to_multiples					=			"1";
	String batch_multiples				=			"1";
	String issue_uom_multiples			=			"1";
	String dec_allowed_yn				=			"N";
	String kit_temp_code            =        "";//01/08/12
    String usage_type               =        "";
	String	iss_history_style		=			 "visibility:hidden";//Added for MO-CRF-20166
	RequestBean bean					=			(RequestBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	//Added for ML-MMOH-CRF-0567 starts 
	Connection con				= null;
	con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_CREATE_REQUEST_DEF_UOM");
	bean.setSite_spec_yn(site_main);
	//Added for ML-MMOH-CRF-0567 ends
	boolean restrict_req_exd_max_stock = bean.getRestrictReqExdMaxStock();//Added for IN:071343 
	if(reset_mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			bean.clear();
			bean.initialize();
		}

	String issue_history_durn = bean.getIssueHistoryDurn();//Adding start for MO-CRF-20166
		if(issue_history_durn ==null || issue_history_durn.equals("0"))
		 issue_history_durn ="";//Adding end for MO-CRF-20166
	String from_store_desc                =     "";//Added for MO-CRF-20166
	String to_store_desc                =       "";//Added for MO-CRF-20166

 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();
	//int no_of_decimals					=			0;
	String item_code					=			request.getParameter("item_code");
	String index						=			bean.checkForNull((String)request.getParameter("index"));

	if (item_code != null) {
 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/

		/*dec_allowed_yn = bean.getAllowDecimalsYN(item_code);*/
		requestDetail					=			bean.getItemDetail(item_code);
		if((requestDetail.getDec_allowed_yn()).equals("N")){
			no_of_decimals = 0;
		}else{
			no_of_decimals	= requestDetail.getNo_of_decimals();
		}
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		editMode						=			true;
		item_disabled					=			"disabled";
		if(edit.equals("2")){
			disabled					=			"disabled";
		}
		no_of_decimals					=			requestDetail.getNo_of_decimals();
		dec_allowed_yn					=			requestDetail.getDec_allowed_yn();
		item_code						=			requestDetail.getItem_code();
		item_desc						=			requestDetail.getItem_desc(); 
		uom								=			requestDetail.getUomDesc();
		uom_code						=			requestDetail.getUom();
		srl_no							=			requestDetail.getSrl_no();
		required_qty					=			bean.setNumber(requestDetail.getRequired_qty(),no_of_decimals);
		stock_item_yn					=			requestDetail.getStock_item_yn();
		available_stock					=			bean.setNumber(requestDetail.getAvailable_stock(),no_of_decimals);
		req_uom_qty						=			bean.setNumber(requestDetail.getReqUomQty(),no_of_decimals);
		pur_uom_code					=			requestDetail.getPurUomCode();
		conv_fact						=			bean.checkForNull(requestDetail.getConvFact(),"1");
		 from_store_desc                =     bean.getStoreDesc(bean.getRequest_by_store());//Added for MO-CRF-20166
	     to_store_desc                =       bean.getStoreDesc(bean.getRequest_on_store());//Added for MO-CRF-20166
		// System.err.println("item_code @@==="+item_code+"mode===="+mode);
		if(conv_fact==null || conv_fact.equals("null"))
		conv_fact="1";
		uom_conv_text				=			bean.checkForNull(requestDetail.getUomconvtext(),"checkFS");
		qty_on_hand						=			bean.setNumber(requestDetail.getQty_on_hand(),no_of_decimals);
		max_stk_qty						=			(bean.checkForNull(requestDetail.getMax_stk_qty())).equals("")?"":requestDetail.getMax_stk_qty();
		kit_template_uom				=			bean.checkForNull(requestDetail.getKit_template_uom());
		kit_item_yn						=			bean.checkForNull(requestDetail.getKit_item_yn(),"N");
		kit_uom_code					=			bean.checkForNull(requestDetail.getKit_uom_code());
		def_issue_uom					=			bean.checkForNull(requestDetail.getDef_issue_uom());
		if(kit_item_yn.equals("Y")){
		display_style				=			 "visibility:visible";
		}else{
		display_style				=			 "visibility:hidden";
		}

		if(stock_item_yn.equals("Y")) {
			checked						=			"checked";
		}
		from_multiples				=			requestDetail.getFromMultiples(); 
		to_multiples				=			requestDetail.getToMultiples(); 
		batch_multiples				=			requestDetail.getBatchMultiples(); 
		issue_uom_multiples			=			requestDetail.getIssueUOMMultiples();
		kit_temp_code               =           requestDetail.getKitTemp_code(); 
		usage_type					=           requestDetail.getUsagetype();	
	}
	else {
		item_code						=			"";
		disable_add						=			 "disabled";
	}
	item_desc_temp = item_desc.replaceAll(" ","%20");
	item_desc_temp = java.net.URLEncoder.encode(item_desc_temp,"UTF-8");
	item_desc_temp = item_desc_temp.replaceAll("%2520","%20");
	String trn_per_record = bean.checkForNull((String)(((HashMap)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"),"ISS")).get("RECORDS_PER_TRN"))); //Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
	if(!item_desc_temp.equals("") && !issue_history_durn.equals(""))//Added for MO-CRF-20166
      iss_history_style          =            "visibility:visible";//Added for MO-CRF-20166j

%>
<body>
	<form name="formRequestDetail" id="formRequestDetail" action="../../eST/jsp/IssueHistoryResult.jsp" method="post"  target="formIssueHistoryResult">
		<table border="0" cellspacing="0" cellpadding="0" width="100%" >
			 <tr>
				<td colspan="2" class="label" >
					<fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;
					<input type="text" name="item_desc" id="item_desc" size="70" maxlength="60"  <%=item_disabled%> value="" >
					<input type="hidden" name="item_desc_temp" id="item_desc_temp" value="<%=item_desc_temp%>" >
					<input type="button" value="?" class="button" onClick="return callItemSearch();" <%=item_disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>&nbsp;&nbsp;
					<label class="label">&nbsp;
					<fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;</label>
					<label id='uom_label'  class="label">&nbsp;<B><%=uom%></B></label>
					<label class="label">&nbsp;</label>
					<label class="label">&nbsp;</label>
					<label class="label">&nbsp;</label>
					<label class="label" style = "<%=iss_history_style%>"><a name ="iss_history" id="iss_history" class='gridLink' href="javascript:viewIssueHistory();"> <B>Issue History</B><a></label><!-- Added for MO-CRF-20166 href modified for IN19719-->
					<label class="label">&nbsp;</label>
				</td>
			</tr>
			<tr>
				<td >
					<label class="label">
					<fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/>&nbsp;</label><label id ='Qty_onhand_label' class= 'label'>&nbsp;&nbsp;&nbsp;&nbsp<B><%=qty_on_hand%></B></label> 
				</td>
				<td>
					<label class="label">&nbsp;
					<fmt:message key="eST.MaxStockLevel.label" bundle="${st_labels}"/>&nbsp;</label><label id ='max_stk_qty_label' class = 'label'><B><%=max_stk_qty%></B></label>
				</td>
				<td>
					<label class="label">&nbsp;&nbsp;
					<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>
					&nbsp;&nbsp;<input type="checkbox" name="stock_item_yn" id="stock_item_yn" <%=checked%> disabled>
				</td>
				<td id="kit_template" STYLE="<%=display_style%>" class="label">
					&nbsp;&nbsp;<fmt:message key="eST.KitTemplateUOM.label" bundle="${st_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="kit_template_uom" id="kit_template_uom" value="<%=kit_template_uom%>" readonly>
				</td>
				<td>&nbsp;</td>
		
			</tr>
			<tr>
		 <table border="0" cellspacing="0" cellpadding="0" width="100%">
			<td class=label align=left>
			<fmt:message key="eST.ReqUOM.label" bundle="${st_labels}"/></td>
			<%
		//String caption1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
			if(edit.equals("1")){
			%>
			<td align=left  class='label'>&nbsp;
				<select name='pur_uom_code' id='pur_uom_code' onchange="calculateConversion();" onBlur="checkUOMConvFactor();" <%=disabled%>>
				<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			
				</select><label>&nbsp;&nbsp;
				<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_pur_uom_conv"><%=uom_conv_text%></b>
			</td>
			<%}else{
			
			%>		
			<td align=left  class='label'>&nbsp;
				<select name='pur_uom_code' id='pur_uom_code' onchange="calculateConversion();" onBlur="checkUOMConvFactor();" ><%=bean.getPur_uom_code_Modify_List(uom_code,item_code,pur_uom_code)%></select><label>&nbsp;&nbsp;
				<fmt:message key="eST.ConvFactorRule.label" bundle="${st_labels}"/>:</label><b id="id_pur_uom_conv"><%=uom_conv_text%></b>
			</td>
			<%}%>
			<td align="left" class="label">
				<fmt:message key="eST.ReqUOMQty.label" bundle="${st_labels}"/></td>
<!-- 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - No.of Decimals is passed to isValidNumber function and maxlength is increased to 12, onblur, checkdoubleformat is called.
	*/

 -->	
			<td >
			<!--Modified for IN:071343 starts -->
			<%if(restrict_req_exd_max_stock) {%>
				<input type="text" name="req_uom_qty" id="req_uom_qty" size=13 maxlength=16 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="calRequestQty1();" value="<%=req_uom_qty%>" >&nbsp;
				<img src="../../eCommon/images/mandatory.gif" align=center>
			<%}else{ %>
			<input type="text" name="req_uom_qty" id="req_uom_qty" size=13 maxlength=16 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);" onBlur="calRequestQty();" value="<%=req_uom_qty%>" >&nbsp;
			<img src="../../eCommon/images/mandatory.gif" align=center>
			<%} %>
			<!--Modified for IN:071343 END -->
			</td>
			<td align="right" class="label"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
			<td >&nbsp;
				<input type="text" name="required_qty" id="required_qty" size="12" disabled maxlength="12" class="NUMBER"  value="<%=required_qty%>" >&nbsp;
				<img src="../../eCommon/images/mandatory.gif" align=center>
			</td>
			<td  align="right" class="label"
			<!--Modified for IN:071343 starts -->
			<%if(restrict_req_exd_max_stock) {%>
			<input type="button" class="button" name="add" id="add" value="<%=caption%>" <%=disable_add%> onClick="if(calRequestQty1()) addItemRecord();">&nbsp;
			<%}else{ %>
				<input type="button" class="button" name="add" id="add" value="<%=caption%>" <%=disable_add%> onClick="if(calRequestQty()) addItemRecord();">&nbsp;
				<%} %>
				<!--Modified for IN:071343 starts -->
				<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="resetDetail();">
			</td>
		</table>
	  </tr>
</table>
		<input type="hidden"		name="mode" id="mode"						 value="<%=mode%>">
		<input type="hidden"		name="req_uom_code" id="req_uom_code"				 value="">
		<input type="hidden"		name="request_by_store" id="request_by_store"			 value="">
		<input type="hidden"		name="request_on_store" id="request_on_store"			 value="">
		<input type="hidden"		name="item_code" id="item_code"				 value="<%=item_code%>">
		<input type="hidden"		name="srl_no" id="srl_no"					 value="<%=srl_no%>">
		<input type="hidden"		name="bean_id" id="bean_id"					 value="<%=bean_id%>">
		<input type="hidden"		name="bean_name" id="bean_name"				 value="<%= bean_name %>">
		<input type="hidden"		name="function_id" id="function_id"				 value="<%=bean.getFunctionId()%>">
		<input type="hidden"		name="editing" id="editing"					 value="<%=editMode?2:1%>">
		<input type="hidden"		name="available_stock" id="available_stock"			 value="<%=available_stock%>">
		<input type="hidden"		name="conv_fact" id="conv_fact"				 value="<%=conv_fact%>">
		<input type="hidden"		name="uom" id="uom"						 value="<%=uom_code%>">
		<input type="hidden"		name="temp_uom" id="temp_uom"					 value="<%=uom%>">
		<input type="hidden"		name="qty_on_hand" id="qty_on_hand"				 value="<%=qty_on_hand%>">
		<input type="hidden"		name="max_stk_qty" id="max_stk_qty"				 value="<%=max_stk_qty%>">
		<input type="hidden"		name="frm_tmp_conv" id="frm_tmp_conv"				 value="">
		<input type="hidden"		name="to_tmp_conv" id="to_tmp_conv"				 value="">
        <input type="hidden"		name="check_box_status" id="check_box_status"			 value="Y">
		<input type="hidden"		name="item_class_code" id="item_class_code"			 value="">
		<input type="hidden"		name="item_class_desc" id="item_class_desc"			 value="">
		<input type="hidden"		name="phy_inv_id" id="phy_inv_id"				 value="">
		<input type="hidden"		name="index" id="index"					 value="<%=index%>">
		<input type="hidden"		name="kit_item_yn" id="kit_item_yn"				 value="<%=kit_item_yn%>">
		<input type="hidden"		name="kit_uom_code" id="kit_uom_code"				 value="<%=kit_uom_code%>">
		<input type="hidden"		name="def_issue_uom" id="def_issue_uom"			 value="<%=def_issue_uom%>">
		<input type="hidden"		name="uom_conv_text" id="uom_conv_text"			 value="<%=uom_conv_text%>">
		<input type="hidden"		name="from_multiples" id="from_multiples"			 value="<%=from_multiples%>">
		<input type="hidden"		name="to_multiples" id="to_multiples"				 value="<%=to_multiples%>">
		<input type="hidden"		name="batch_multiples" id="batch_multiples"			 value="<%=batch_multiples%>">
		<input type="hidden"		name="issue_uom_multiples" id="issue_uom_multiples"		 value="<%=issue_uom_multiples%>">
		
		

<!-- 	/**
	* @Name - Mahesh
	* @Date - 12/01/2010
	* @Inc# - IN015496
	* @Desc - Code added to accept decimal values dynamically.
	*/

 -->	
		<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=dec_allowed_yn%>">
		<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">
		 <input type="hidden"       name="kit_temp_code" id="kit_temp_code"	         value="<%=kit_temp_code%>" >
		 <input type="hidden"       name="usage_type" id="usage_type"	         value="<%=usage_type%>" >
		 <input type="hidden"       name="trn_per_record" id="trn_per_record"	         value="<%=trn_per_record%>" >
		 <input type="hidden"       name="issue_history_durn" id="issue_history_durn"	         value="<%=issue_history_durn%>" ><!-- Added for MO-CRF-20166 -->
		
	</form>
	<!-- Added for ML-MMOH-CRF-0567 starts -->
	<script language="JavaScript">
		<%if(mode.equals("2")){%>
			setTimeout('reqUOM();', 200);
		<%}%>
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	%>
	<!-- Added for ML-MMOH-CRF-0567 ends -->
	<%
putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>
<script>
Setitemdesc(document.formRequestDetail.item_desc_temp);
</script> 



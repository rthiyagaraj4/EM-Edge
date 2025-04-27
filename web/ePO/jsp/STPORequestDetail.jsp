<!DOCTYPE html>
<%@ page import=" ePO.STPORequestDetailBean,ePO.STPORequestBean, ePO.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
		<script language="JavaScript" src="../../ePO/js/STPORequest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		 <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		 </script>
</head>
<%
	boolean editMode					=			 false;
	STPORequestDetailBean requestDetail;
	String mode							=			 request.getParameter("mode");
	String edit							=			 request.getParameter("edit")==null?"1":request.getParameter("edit");
	String disabled						=			 "";
	String item_disabled				=			 "";
	String item_desc					=			 "";
	String uom							=			 "";
	String required_qty					=			 "";
	String req_uom_qty					=			 "";
	String	pur_uom_code				=			 "";
	String	conv_fact					=			 "";
	String	qty_on_hand					=			 "";
	String	max_stk_qty					=			 "";
	String 	id_pur_uom_conv1			=			"";
	String remarks						=			"";
	String required_by_date				=			"";
	int srl_no							=			-1;
	mode								=			mode.trim();


	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	String bean_id						=			 "stporequestBean";
	String bean_name					=			 "ePO.STPORequestBean";
	String caption						=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels");
	String disable_add					=			"";
	//String stock_item_yn				=			"";
	String available_stock				=			"";
	//String checked						=			"";
	String	uom_code					=			"";

	STPORequestBean bean					=			(STPORequestBean) getBeanObject(bean_id, bean_name,request );  
	bean.setLanguageId(locale);
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function and isValidNumber Function.
	*/

	int no_of_decimals					=			bean.getNoOfDecimals();
	String item_code					=			 request.getParameter("item_code");

	if (item_code != null) {
		/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/
		if((bean.getAllowDecimalsYN(item_code)).equals("N")){
			no_of_decimals = 0;
		}
		caption							=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels");
		editMode						=			true;
		item_disabled					=			"disabled";
		if(edit.equals("2"))
			disabled					=			"disabled";
		requestDetail					=			bean.getItemDetail(item_code);
		item_code						=			requestDetail.getItem_code();
		item_desc						=			requestDetail.getItem_desc();
		uom								=			requestDetail.getUomDesc();
		uom_code						=			requestDetail.getUom();
		srl_no							=			requestDetail.getSrl_no();
		required_qty					=			requestDetail.getRequired_qty();
		available_stock					=			requestDetail.getAvailable_stock();
		req_uom_qty						=			requestDetail.getReqUomQty();
		pur_uom_code					=			requestDetail.getPurUomCode();
		conv_fact						=			requestDetail.getConvFact();
		qty_on_hand						=			requestDetail.getQty_on_hand();
		max_stk_qty						=			requestDetail.getMax_stk_qty();
		id_pur_uom_conv1				=			requestDetail.getPur_uom_conv_id();
		required_by_date				=			bean.checkForNull(requestDetail.getRequired_by_date());	
		remarks							=			bean.checkForNull(requestDetail.getRemarks());
	if(conv_fact.equals(id_pur_uom_conv1))
		id_pur_uom_conv1=conv_fact;
	}
	else {
		item_code						=			"";
		disable_add						=			 "disabled";
	}
	/*String  item_code_dis				="";
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
	item_code_dis= "disabled";
	else
	item_code_dis= "";*/
	
%>
<body>
	<form name="formPORequestDetail" id="formPORequestDetail">
	<table border="0" cellspacing="0" cellpadding="0" width="100%" >
	  <tr>
		<td colspan="5" class="label" ><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;
		<input type="text" name="item_desc" id="item_desc" size="70" maxlength="60"  value="<%=item_desc%>" <%=item_disabled%>>		
		<input type="button" value="?" class="button" onClick="return callItemSearch();" <%=item_disabled%> >&nbsp;
		<img src="../../eCommon/images/mandatory.gif" align=center></img>&nbsp;&nbsp;		
		<label class="label">&nbsp;<fmt:message key="Common.uom.label" bundle="${common_labels}"/>&nbsp;</label>
		<label id='uom_label' class="label">&nbsp;<B><%=uom%></B></label>
		<input type="button" value=">>" class="button" name="batchsearch" onClick="callBatchSearchScreen();" title="Item Batch Details"></td>

</tr>
<tr>
	<td >
		<label colspan="4" class="label">&nbsp;
	<!--	<fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/>&nbsp;</label><label id ='Qty_onhand_label' class= 'label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<B><%=qty_on_hand%></B></label> 		
		-->
	</td>
	
	
		
</tr>


	  <tr>
	  <table border="0" cellspacing="0" cellpadding="0" width="100%">
	  
		<td class=label align=right>
		<fmt:message key="ePO.ReqUOM.label" bundle="${po_labels}"/></td>
		<%
	
		if(edit.equals("1")){
			%>
		<td align=left  class='label'>&nbsp;
		<select name='pur_uom_code' id='pur_uom_code' onBlur="checkUOMConvFactor();" <%=disabled%>>
		<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>	---&nbsp;&nbsp;&nbsp;&nbsp;</option>
			
		</select><label>&nbsp;&nbsp;
		<fmt:message key="ePO.ConvFactorRule.label" bundle="${po_labels}"/>:</label><b id="id_pur_uom_conv"><%=id_pur_uom_conv1%></b>
		</td>
			<%  }else{
%>		
			<td align=left  class='label'>&nbsp;
			<select name='pur_uom_code' id='pur_uom_code'  onBlur="checkUOMConvFactor();" >
			<%=bean.getPur_uom_code_Modify_List(uom_code,item_code,pur_uom_code)%></select><label>&nbsp;&nbsp;
			<fmt:message key="ePO.ConvFactorRule.label" bundle="${po_labels}"/>:</label><b id="id_pur_uom_conv"><%=id_pur_uom_conv1%></b>
		</td>
		<% }%>


		<td align="left" class="label">
		<fmt:message key="ePO.ReqUOMQty.label" bundle="${po_labels}"/></td>
		<td ><input type="text" name="req_uom_qty" id="req_uom_qty" size=12 maxlength=12 class="NUMBER" onkeypress="return isValidNumber(this,event,7,<%=no_of_decimals%>);"  onBlur="calRequestQty(this);" value="<%=req_uom_qty%>" >&nbsp;
		<img src="../../eCommon/images/mandatory.gif" align=center></td>

		<!--<td align="right" class="label"><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></td>
		<td >&nbsp;	<input type="hidden" name="required_qty" id="required_qty" size="12" disabled maxlength="12" class="NUMBER"  value="<%=required_qty%>" >&nbsp;
		<img src="../../eCommon/images/mandatory.gif" align=center></td>-->
		
		<input type="hidden" name="required_qty" id="required_qty" value="<%=required_qty%>" >

		<td align="right" class="label"><fmt:message key="ePO.RequiredByDate.label" bundle="${po_labels}"/></td>
		<td >&nbsp;	
		<input type="text" name="required_by_date" id="required_by_date" size="10" value="<%=required_by_date%>" onBlur="CheckDate(this);" >&nbsp;
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('required_by_date');"></img></td>
		
		<td class="label" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks(remarks.value,'');"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label></td>



		<td  align="right" class="label">
		<input type="button" class="button" name="add" id="add" value="<%=caption%>" <%=disable_add%> onClick="calRequestQty(req_uom_qty);if(issueUOMQtyChk())addItemRecord();">&nbsp;
		<input type="button" class="button" name="cancel" id="cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="resetDetail();"></td>
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
		<input type="hidden"		name="id_pur_uom_conv1" id="id_pur_uom_conv1"			 value="<%=id_pur_uom_conv1%>">
		<input type="hidden"		name="dec_allowed_yn" id="dec_allowed_yn"			 value="<%=bean.getAllowDecimalsYN(item_code)%>">
		<input type="hidden"		name="no_of_decimals" id="no_of_decimals"			 value="<%=no_of_decimals%>">

		<input type="hidden"		name="remarks" id="remarks"					 value="<%=remarks%>" >

	</form>
	<%
putObjectInBean(bean_id,bean,request);
	%>
</body>
</html>


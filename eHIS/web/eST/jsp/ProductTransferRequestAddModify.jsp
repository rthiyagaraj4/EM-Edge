<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->	
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javaScript" src="../../eST/js/ProductTransferRequest.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 

</head>
<style>
textarea {
  resize: none;
}
</style>
<% 
 //  int i							=		0;
	String mode;
	String bean_id;
	String bean_name;
	String function_id;
	String user_name				=		(String) session.getValue( "login_user" ) ;
	String facility_id				=		(String) session.getValue( "facility_id" ) ;

	mode							=		request.getParameter( "mode" ) ;
	if(mode==null)		mode		=		"1";
	function_id						=		request.getParameter( "function_id" ) ;
	bean_id							=		"ProductTransferRequestBean" ;
	bean_name						=		"eST.ProductTransferRequestBean";
	ProductTransferRequestBean bean =		(ProductTransferRequestBean)getBeanObject( "ProductTransferRequestBean","eST.ProductTransferRequestBean", request  );
	bean.setLanguageId(locale);
	  
%>
<body onLoad="FocusFirstElement();">
<form name="formProductTransferRequestAddModify" id="formProductTransferRequestAddModify" onReset="FocusFirstElement();">
<br><br><br>
<table border="0" cellpadding="0" cellspacing="0" width='80%'  height='60%' align=center>
	<tr>
		<td  colspan='8'>&nbsp;</td>	
    </tr>
	<tr>
		<td  class="label"  nowrap width ="20%">&nbsp;<fmt:message key="eST.RepackStore.label" bundle="${st_labels}"/></td>
		<td  class='fields' colspan = "7"width ="20%">&nbsp;<select name='store' id='store'><%=bean.getStores()%></select><img src='../../eCommon/images/mandatory.gif' ></td>

	</tr>
	<tr>
		  <td  class="label" nowrap width ="20%">&nbsp;<fmt:message key="eST.RequiredItem.label" bundle="${st_labels}"/></td>
		  <td class=fields  colspan = "7" >&nbsp;<input maxLength=60 size=70 name="repack_item" id="repack_item" value="" ><input type=button name="repack_item_search" id="repack_item_search" class="button" onClick="callItemSearchScreento(repack_item.value),geteqvalvalue();"  value='?' >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>
		  </tr>
		  <tr>
    	  <td  class="label" nowrap width ="20%">&nbsp;<fmt:message key="eST.Itemtobeused.label" bundle="${st_labels}"/></td>
		  <td  class="fields" colspan = "7" >&nbsp;<input maxLength=60 size=70 name="item_used" id="item_used" value=""   ><input type=button name="item_search_to" id="item_search_to" class="button" onClick="callItemSearchScreenfrom(item_used.value);"  value='?' >&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td>

   </tr>
   
   <tr>
		  <td  class="label" nowrap width ="20%">&nbsp;<fmt:message key="eST.RequiredQuantity.label" bundle="${st_labels}"/></td>
		  <td  class="fields" nowrap width ="7%">&nbsp;<input class="NUMBER" maxLength=12 size=12 name="required_qty" id="required_qty" value=""  onkeypress="allow_restrict_decimals(this,event);" onBlur="calculateQTY();">&nbsp;<img src='../../eCommon/images/mandatory.gif'  ></td>
		  <td id="to_item_uom_desc" name="to_item_uom_desc"  class=label width ="10%" nowrap>&nbsp;</td>  
	   
		  <td  class="label" nowrap width ="10%">&nbsp;<fmt:message key="eST.RepackSize.label" bundle="${st_labels}"/></td>
		  <td  class="fields" nowrap width ="7%">&nbsp;<input class="NUMBER" maxLength=3 size=8 name="repack_factor" id="repack_factor" value="1"  onkeypress="return isValidNumber(this,event,12,0);" onChange ="calRequireQTY();calculateQTY(); ">&nbsp;<img src='../../eCommon/images/mandatory.gif' ></td><!-- modified for ML-MMOH-SCF-1065 --> 
		 <td  class="label" nowrap width ="5%"> &nbsp;<fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
			<td  class="fields" nowrap width ="5%">&nbsp;<input class="NUMBER" maxLength=12 size=12 name="quantity" id="quantity" value="" onkeypress="allow_restrict_decimals1(this,event);"  onChange = "calRequireQTY();">&nbsp;<img src='../../eCommon/images/mandatory.gif'  ></td> <!-- modified for ML-MMOH-SCF-1065 -->
			<td id="from_item_uom_desc" name="from_item_uom_desc"   class=label width ="10%"nowrap> &nbsp;</td>	
	</tr>
	<tr>
		<td  colspan='8'>&nbsp;</td>	
    </tr>
	<tr>
		<th  colspan='8'>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;</th>	
    </tr>
	<tr>
		<td  colspan='8'>&nbsp;</td>	
    </tr>
  	<tr>
		<td  class="label" width ="20%" nowrap>&nbsp;<fmt:message key="eST.ReqBy.label" bundle="${st_labels}"/></td>
		<td class="fields" colspan="2">&nbsp;<input maxLength=30 size=30 name="requested_by" id="requested_by" value="<%=session.getValue("login_user")%>" readOnly></td>
		<!-- <td align="right" class="label" nowrap width ="20%"> &nbsp;Quantity</td>
		<td align="left" class="label" nowrap width ="10%">&nbsp;<input class="NUMBER" maxLength=12 size=4 name="quantity" id="quantity" value="" align=right onblur = "calRequireQTY();">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' ></td>


		<td id="from_item_uom_desc"  align='left' class=label width ="20%">&nbsp;</td>	  -->
	<td  class="label" nowrap colspan ="5"> &nbsp;</td>
    </tr>
    <tr>
		<td  class="label" width ="20%">&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class="fields" colspan=7>&nbsp;<TEXTAREA id=TEXTAREA cols=70 rows=4 name='remarks' Style="color:#666666" onKeyPress="return false;" ></TEXTAREA><input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"></td>
	</tr>
	
	
</table>

		<input type="hidden"	name="request_no" id="request_no"			value=<%=bean.getProd_Trf_Req_No()%>>
		<input type="hidden"	name="store_code" id="store_code"			value="">
		<input type="hidden"	name="from_item_code" id="from_item_code"		value="">
		<input type="hidden"	name="to_item_code" id="to_item_code"			value="">
		<input type="hidden"	name="from_repack_uom_code" id="from_repack_uom_code" value="">
		<input type="hidden"	name="to_repack_uom_code" id="to_repack_uom_code"	value="">
		<input type="hidden"	name="from_trade_id_yn" id="from_trade_id_yn"		value="">
		<input type="hidden"	name="to_trade_id_yn" id="to_trade_id_yn"		value="">
		<input type="hidden"	name="repack_group1" id="repack_group1"		value="">
		<input type="hidden"	name="repack_group2" id="repack_group2"		value="">
		<input type="hidden"	name="eqvlvalue" id="eqvlvalue"			value="">
		<input type="hidden"	name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden"	name="bean_id" id="bean_id"				value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"			value="<%= bean_name %>">
		<input type="hidden"	name="function_id" id="function_id"			value="<%= function_id %>">
		<input type="hidden"	name="p_module_id" id="p_module_id"			value="ST">
		<input type="hidden"	name="p_report_id" id="p_report_id"			value="STBPTRDC">
		<input type="hidden"	name="p_user_name" id="p_user_name"			value="<%=user_name%>">
		<input type="hidden"	name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
		<input type="hidden"	name="p_request_no" id="p_request_no"			value=""> 
		<input type="hidden"	name="phy_inv_id" id="phy_inv_id"			value=""> 
		<input type="hidden"	name="lang_id" id="lang_id"				value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"		value="PRT">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden" name="allow_deci_yn_from" id="allow_deci_yn_from"				value="">
		<input type="hidden" name="no_deci_from" id="no_deci_from"				value="">
		<input type="hidden" name="allow_deci_yn_to" id="allow_deci_yn_to"				value="">
		<input type="hidden" name="no_deci_to" id="no_deci_to"				value="">
		<input type="hidden" name="req_qty" id="req_qty"				value="">
		<input type="hidden" name="qty" id="qty"				value="">
</form>
</form>
<%
putObjectInBean("ProductTransferRequestBean",bean,request);
%>
</body>
</html>


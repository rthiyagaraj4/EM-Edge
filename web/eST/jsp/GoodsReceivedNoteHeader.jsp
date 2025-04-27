<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
09/05/2017		IN062881		B.Badmavathi								     PO Mandatory in GRN 
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
26/05/2021      TFS-19175              Prabha              27/05/2021         Manickam                NMC-JD-CRF-0100
--------------------------------------------------------------------------------------------------------------------------------------------
*/      
%>
<%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*,java.lang.*,java.util.*, eST.Common.*,java.sql.*,webbeans.eCommon.*" %><!-- Modified for IN:071539 -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>       
<%
		request.setCharacterEncoding("UTF-8");
		String locale		=   (String)session.getAttribute("LOCALE");

		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReceivedNote.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body>
<form name="formGoodsReceivedNoteHeader" id="formGoodsReceivedNoteHeader">
<%
	String bean_id					=		"goodsReceivedNoteBean" ;
	String bean_name				=		"eST.GoodsReceivedNoteBean";
	eST.GoodsReceivedNoteBean bean  =		(eST.GoodsReceivedNoteBean) getBeanObject(bean_id,bean_name,request);
	eST.Common.StHeaderBean stbean  =		(eST.Common.StHeaderBean) getBeanObject("StHeaderBean","eST.Common.StHeaderBean",request);
	//	Added for GDOH-CRF-0109 starts
		String po_mandatory			=	(String)bean.getMmParameter().get("PO_MANDATORY_YN");
		String visibilityPO			=	po_mandatory.equals("Y")?"visible":"hidden";
	//	Added for GDOH-CRF-0109 ends
	String mode						=		request.getParameter("mode");	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
	stbean.clear();
	}
	bean.setLanguageId(locale);
    String facilityid               =		(String)session.getValue("facility_id");
	String trn_type					=		"GRN";
	String sql_id					=		"SQL_ST_GRN_STORE_SELECT";
	String preview_disabled			=		"disabled";
	String item_class_based			=		bean.getGRNItemClassBased(trn_type);
	String local_currency			=		"";

	String supp_disabled = ""; //Added for NMC-JD-CRF-0100
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		preview_disabled			=		 "";
		supp_disabled = "disabled"; //Added for NMC-JD-CRF-0100
	}
	
	boolean flag_grn                =   bean.isCreateGRNApplicable(facilityid,trn_type);
	
	HashMap PO_Interface			=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")});

	String external_po_yn			=	bean.checkForNull((String)PO_Interface.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	String PO_disabled				=   "";

	String po_interface_yn =    bean.checkForNull((String)PO_Interface.get("PO_INTERFACE_YN"),"N");
	
	if(po_interface_yn.equals("Y")){
	external_po_yn = "N";
	}

	if(external_po_yn.equals("Y")){
	PO_disabled="disabled";
	}else{		
	PO_disabled="";
	}
	
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		PO_disabled="disabled";
		local_currency = (String)bean.fetchRecord("select BASE_CURRENCY from SM_ACC_ENTITY_PARAM where ACC_ENTITY_ID='ZZ'").get("BASE_CURRENCY");
	}

	String grn_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  grn_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getStore_code()),(String) session.getValue( "login_user" )}).get("GRN_DELETE_YN"),"N");
	
	
	String select_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") +"---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	//Added for IN:071539 start
    Connection con				= null;
	 
	boolean supp_code_non_mand = false;
	try 
	{
		con						= ConnectionManager.getConnection(request);
		supp_code_non_mand = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_SUPP_CODE_NON_MAND");
	} 
	catch (Exception e) 
	{
		e.printStackTrace(System.err);
		System.out.println(" Error in Criteria Page " + e.getMessage());
	} 
	finally 
	{
		if (con != null) ConnectionManager.returnConnection(con, request);
	}
	String supp_code_non_mand_chk="N";
	if(supp_code_non_mand)
		supp_code_non_mand_chk="Y";
	//Added for IN:071539 end
	
%>
<%
putObjectInBean(bean_id,bean,request);
%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.checkForNull(bean.getDoc_type_code())%>" />
	<jsp:param name="doc_no"			value="<%=bean.checkForNull(bean.getDoc_no())%>" />
	<jsp:param name="doc_date"			value="<%=bean.checkForNull(bean.getDoc_date())%>" />
	<jsp:param name="doc_ref"			value="<%=bean.checkForNull(bean.getDoc_ref())%>" />
	<jsp:param name="store_code"		value="<%=bean.checkForNull(bean.getStore_code())%>" />
	<jsp:param name="item_class_code"   value="<%=bean.checkForNull(bean.getItem_class_code())%>" />
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
</jsp:include>
<table cellpadding=2 cellspacing=0 border=0 width='100%' align=center>
<tr>


	
	<%if(po_interface_yn.equals("Y")){%>
	<td class='label' ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name='supp_code' id='supp_code' id='supp_code'  value="<%=bean.getSupp_code()%>" <%=supp_disabled%>><!-- Modified for IN:071539 -->  <!-- supp_disabled Added for NMC-JD-CRF-0100 -->
		<%
			out.println(bean.getSupp_code_List());
		%>
		</select><%=bean.getImage("M")%>
	</td>
	<%}%>


	<td class='label' ><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
	<td class='fields'><input type='text' name='po_no' id='po_no' size='20' maxLength='20' value="<%=bean.getPo_no()%>" onKeyPress="return CheckForSpecialChars(event);" <%=PO_disabled%> onblur ="enableDocType(this)" >
	<%if(po_interface_yn.equals("Y")){%>
	<input type='button' name="podetail_search" id="podetail_search" class="button" onClick="Load_PurchaseOrderDetails(po_no,supp_code);"  value='?'>
	<%}%>
	<span style="visibility:<%=visibilityPO%>"><%=bean.getImage("M")%><!--	Added for GDOH-CRF-0109 -->
	</td>

	
	<%if(external_po_yn.equals("Y")){%>
	<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
	<%if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {		
	%>
	<td class="fields">
	<select name="po_doc_type_code" id="po_doc_type_code"   disabled >
	<%	if(!bean.getPo_no().equals("")){%>
	<option value="" ><%=CommonBean.checkForNull(bean.getDoc_type_code_List_PO(bean.getPo_no()))%> </option>
	<%}else{%>
	<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> </option>
	<%}%>	
	</select>
	</td>
	<%	}else{%>
	<td class="fields">
	<select name="po_doc_type_code" id="po_doc_type_code" onchange="LoadDetailPage(this)" <%=PO_disabled%> disabled>
	<%=bean.getDoc_type_code_List_PO_create()%> </select>
	</td>
	<%}
	}%>
	

	<%if(!po_interface_yn.equals("Y")){%>
	<td class='label' ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<td class='fields'><select name='supp_code' id='supp_code' value="<%=bean.getSupp_code()%>">
		<%
			out.println(bean.getSupp_code_List());
		%>
		</select><%=bean.getImage("M")%>
	</td>
	<%}%>
	<%if(!po_interface_yn.equals("Y")){%>
	<td class='label' ><fmt:message key="eST.Currency.label" bundle="${st_labels}"/></td>
	<%}else{%>
	<td class='label' ><fmt:message key="eST.POCurrency.label" bundle="${st_labels}"/></td>
	<%}%>
	<td class='fields'><select name="currency_code" id="currency_code" disabled>	<%=bean.getCurrency_code_List()%>
	</select>
	</td>
	
	<%if(po_interface_yn.equals("Y")){%>
	<td class='label' ><fmt:message key="eST.ExchangeRate.label" bundle="${st_labels}"/></td>
	<td class='fields'><input type='text' name='exchangerate' id='exchangerate' size='10' maxLength='5' value="<%=bean.getConversion_rate()%>"  onblur="calculateCostAndValue(this);"></td>
	<td class='label' ><fmt:message key="eST.LocalCurrency.label" bundle="${st_labels}"/>
	<span id="localcurrency" class='label'></span>
	<%if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		out.println(local_currency);
		}
	}%>
	</td>
	</tr>
	<tr>
	<td class="label"><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale)%>" name="receipt_date" id="receipt_date"  maxLength="10" size="10" onBlur="checkSysdate(receipt_date,sysdate);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar  ('receipt_date');" onBlur="receipt_date.focus()"  ></img><%=bean.getImage("M")%></td>	


	<td  class="label"><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/></td>
	<td  class='fields'><input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn"  <%=bean.getChecked(bean.getEntry_completed_yn())%>> <label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks();"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label></td>	

	<!--added for Bru-HIMS-CRF-113 by Ganga-->
	<%if(po_interface_yn.equals("Y")){%>
	<td  class="label"><fmt:message key="eST.DoNo.label" bundle="${st_labels}"/></td>
	<td  class='fields'><input type="text" value="<%=bean.getDo_no()%>" name="do_no" size="15" maxLength="20" onKeyPress="return CheckForSpecialChars(event);" <%=PO_disabled%>> <input type=button name="dodetail_search" id="dodetail_search" class="button" onClick="Load_DelieveryOrderDetails(do_no,supp_code);"  value='?'></td>
	<td  class="label"><fmt:message key="eST.InvoiceNo.label" bundle="${st_labels}"/></td>
	<td  class='fields'><input type="text" value="<%=bean.getInvoice_no()%>" name="invoice_no"  size="15" maxLength="30" onKeyPress="return CheckForSpecialChars(event);"></td>	
	<td  class="label"><fmt:message key="eST.InvoiceReceivedBy.label" bundle="${st_labels}"/></td>
	<td  class='fields'><input type="text" value="<%=bean.getInvoice_received_by()%>" name="invoice_received_by" size="15" maxLength="30" onKeyPress="return CheckForSpecialChars(event);"></td>	
	<%}%>
	<!--added ended for Bru-HIMS-CRF-113 by Ganga-->
	<td colspan=2></td>
</tr>
<tr>
	<td colspan=9 class='fields' style="text-align:right">	<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>'  class=button style='width:88' style='height:14pt' <%=preview_disabled%> onclick="previewDetails();">	</td>
</tr>

</table>

	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn"		value="N">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">	
	<input type="hidden" name="item_class_code1" id="item_class_code1"		value="<%=stbean.getItem_class_code()%>">
	<input type='hidden' name="sysdate" id="sysdate"					value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
	<input type='hidden' name="external_po_yn" id="external_po_yn"			value="<%=external_po_yn%>">
	<input type="hidden" name="remarks" id="remarks"					value="<%=bean.checkForNull(bean.getRemarks(),"")%> " >
	<input type="hidden" name="grn_delete_yn" id="grn_delete_yn"			value="<%=grn_delete_yn.trim()%>" >
	<input type='hidden' name="grn_yn" id="grn_yn"					value="<%=flag_grn%>">
	<input type='hidden' name="grn_mode" id="grn_mode"				value="">
	<input type='hidden' name="po_mandatory" id="po_mandatory"				value="<%=po_mandatory%>"><!--	Added for GDOH-CRF-0109 -->
	<input type='hidden' name="supp_code_new" id="supp_code_new"				value=""> <!-- Added for IN:071539 -->
	<input type='hidden' name="supp_code_non_mand_chk" id="supp_code_non_mand_chk"				value="<%=supp_code_non_mand_chk%>"> <!-- Added for IN:071539 -->
</form>

</body>
</html>


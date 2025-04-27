<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------

22/01/2017							Chithra										 GHL-CRF-496 
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%
 request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/BatchSearchGoodsReturnToVendor.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	BatchSearchGoodsReturnToVendorBean bean = (BatchSearchGoodsReturnToVendorBean) getBeanObject( "BatchSearchGoodsReturnToVendorBean","eST.BatchSearchGoodsReturnToVendorBean",request );
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	String item_code= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String supp_code= request.getParameter( "supp_code" )==null?"":request.getParameter( "supp_code" ) ;
	String doc_type_code	= request.getParameter( "doc_type_code" )==null?"":request.getParameter( "doc_type_code" ) ;
	String doc_no	= request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;
	String trn_type	= request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;
	String tot_qty=request.getParameter( "tot_qty" )==null?"":request.getParameter( "tot_qty" ) ;// added for 	 GHL-CRF-496 
	String rdonly="";
	String searchFunction	= "Y";
	String multipleSelect	= "Y";
	String maxAllowed="1";

	if(multipleSelect.equals("N"))maxAllowed="1";
	else if(multipleSelect.equals("Y"))maxAllowed="10";
		if(searchFunction.equals("Y")){
		rdonly="disabled";
	}
	
	bean.setMaxAllowed(maxAllowed) ;
	bean.setMultipleSelect(multipleSelect) ;
	bean.setSearchFunction(searchFunction) ;
	bean.setItem_code(item_code);
	bean.setStore_code(store_code);
	bean.setSupp_code(supp_code);
	String site_id=bean.getCustomerID();
	String sap_legend="";
	if(site_id.equals("MC")){
		sap_legend="SAP " ;
	
	}
%>

<body onload='FocusFirstElement();' >
	<form name="BatchSearchCriteria_Form" id="BatchSearchCriteria_Form" >
	  <table border="0" cellpadding="2" cellspacing="0" width='100%' align=center>
		<form name="formBatchSearch" id="formBatchSearch" onSubmit= 'return submitPage();' >
       		<table border=0 cellspacing=0 cellpadding=2 width='100%' align=center>
			    <th   colspan=4><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>

				<tr>
					<td  class=label><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='3'>&nbsp;<input type=text name=item_code size=20 maxlength=20 value="<%=item_code%>" disabled ><input type=button name="item_search_from" id="item_search_from" class="button"   onClick="searchCodeItem(item_code_from)"  value='?' disabled></td>
				</tr>

				<tr>
					<td  class=label><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td class='fields'>&nbsp;<input type=text name="store_code" id="store_code" size=15 maxlength=15 value="<%=store_code%>" disabled <%=rdonly%>><input type=button name="store_search_from" id="store_search_from" class="button"   onClick="return searchCodeStore(store_code_from);"  value='?' disabled></td>
					<td  class=label><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td><!-- Modified for IN:074037  -->
					<td class='fields'>&nbsp;<input type=text name=supp_code size=15 maxlength=15 value="<%=supp_code%>" disabled <%=rdonly%>><input type=button name="store_search_to" id="store_search_to" class="button"   onClick="return searchCodeStore(store_code_to);"  value='?' disabled></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;<input type='text' name='po_no' id='po_no' size='10' maxLength='10' value="" onKeyPress="return CheckForSpecialChars(event);">
					</td>
					<td  class="label"><%=sap_legend%><fmt:message key="eST.GRNDocType/No.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;<select name="grn_doc_type_code" id="grn_doc_type_code">
						<%=bean.getDoc_type_code_ListGRN()%>
					</select>&nbsp;<input type="text" class="NUMBER" value="" name="grn_doc_no" id="grn_doc_no" maxLength="8" size="8" onKeyPress="return CheckForSpecialChars(event);"  onBlur="checkIntegerFormat(this);"></td>
				</tr>

				<tr>
				<!--  GHL-CRF-496  -->
				<td  class=label><fmt:message key="eST.TotalAvailableQuantity.label" bundle="${st_labels}"/></td>
				<td class='fields'>&nbsp;<input type=text name="store_code1" id="store_code1" size=15 maxlength=15 value="<%=tot_qty%>" disabled <%=rdonly%>></td>
					<!-- end	 GHL-CRF-496  -->
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td  class=label>&nbsp;&nbsp;</td>
					<%if(searchFunction.equals("Y")){%>
					<td class='fields'><input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'><input type=button class=button name="Close" id="Close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="returnVals();"></td>
					<%}else if(searchFunction.equals("N")){ %>
					<td class='fields'><input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled><input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'></td>
					<%}%>
                </tr>
		 </table>
</center>
</table>
<input type=hidden name=facility_id value="<%=bean.getLoginFacilityId()%>">
<input type=hidden name=searchFunction value="<%=searchFunction%>">
<input type=hidden name=multipleSelect value="<%=multipleSelect%>">
<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
<input type=hidden name=doc_type_code value="<%=doc_type_code%>">
<input type=hidden name=doc_no value="<%=doc_no%>">
<input type=hidden name=trn_type value="<%=trn_type%>">

<script>
  searchVals();
</script>

</form>
<%
putObjectInBean("BatchSearchGoodsReturnToVendorBean",bean,request);
%>
</body>
</html>


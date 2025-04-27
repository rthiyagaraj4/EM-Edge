<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/ReplaceGRNBatchSearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<%
// pmd 29/01/05
//	java.util.HashMap defaultParameter = null;

//	String bean_id = "batchSearchReplaceGRNBean";
	//String bean_name = "eST.BatchSearchReplaceGRNBean";
	
	BatchSearchReplaceGRNBean bean = (BatchSearchReplaceGRNBean) getBeanObject( "BatchSearchReplaceGRNBean", "eST.BatchSearchReplaceGRNBean", request );
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
//	String disabled = "";
//	String facility_id = (String) session.getValue("facility_id");
	
	String item_code= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
	String supp_code= request.getParameter( "supp_code" )==null?"":request.getParameter( "supp_code" ) ;

	String rdonly="";
	String searchFunction	= "Y";//request.getParameter( "searchFunction" )==null?"N":request.getParameter( "searchFunction" ) ;
	String multipleSelect	= "Y";//request.getParameter( "multipleSelect" )==null?"N":request.getParameter( "multipleSelect" ) ;
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
		bean.setLanguageId(locale);
%>

<body onload='FocusFirstElement();' >
	<form name="BatchSearchCriteria_Form" id="BatchSearchCriteria_Form" >
	  <table border="0" cellpadding="0" cellspacing="0" width='100%' align="center">
		<form name="formBatchSearch" id="formBatchSearch" onSubmit= 'return submitPage();' >
       		<table border='0' cellspacing=0 cellpadding=0 width='100%'>
			    <th   colspan=4><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>

				<tr>
					<td  class=label><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class='fields'  colspan='3' class='fields'>&nbsp;<input type=text name=item_code size=20 maxlength=20 value="<%=item_code%>" disabled ><input type=button name="item_search_from" id="item_search_from" class="button"   onClick="searchCodeItem(item_code_from)"  value='?' disabled></td>
				</tr>

				<tr>
					<td  class=label><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<input type=text name=supp_code size=15 maxlength=15 value="<%=supp_code%>" disabled <%=rdonly%>><input type=button name="store_search_to" id="store_search_to" class="button"   onClick="return searchCodeStore(store_code_to);"  value='?' disabled></td>
					<td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class='label'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eST.RTVDocType/No.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;<select name="grn_doc_type_code" id="grn_doc_type_code">
						<%=bean.getDoc_type_code_ListGRN()%>
					</select><input type="text" class="NUMBER" value="" name="grn_doc_no" id="grn_doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);"></td>
					<td class='label'>&nbsp;</td>
					<td class='label'>&nbsp;</td>
			</tr>

				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td  class=label>&nbsp;&nbsp;</td>
					<%if(searchFunction.equals("Y")){%>
					<td class='fields' ><input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' 
					value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled>
						<input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'><input type=button class=button name="Close" id="Close" 
						value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="returnVals();"></td>
					<%}else if(searchFunction.equals("N")){ %>
					<td class='fields' ><input type='button'  class='BUTTON' name='previous' id='previous' value='<fmt:message key="Common.previous.label" bundle="${common_labels}"/>' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' 
					value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick='goNext();' disabled>
						<input type='button' class='BUTTON' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchVals();'></td>
					<%}%>
                </tr>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		 </table>
</center>
</table>
<input type=hidden name=facility_id value="<%=bean.getLoginFacilityId()%>">
<input type=hidden name=searchFunction value="<%=searchFunction%>">
<input type=hidden name=multipleSelect value="<%=multipleSelect%>">
<input type=hidden name='store_code' id='store_code' value="<%=store_code%>">
<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
<script>
	searchVals();
</script>
</form>
<%
putObjectInBean("BatchSearchReplaceGRNBean",bean,request);
%>
</body>
</html>


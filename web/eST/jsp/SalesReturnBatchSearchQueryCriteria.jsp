<!DOCTYPE html>
<%@ page import ="eST.SalesReturnBatchSearchBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language="javascript" src="../../eST/js/SalesReturnBatchSearch.js"></script>
</head>

<%
	SalesReturnBatchSearchBean bean = (SalesReturnBatchSearchBean)getBeanObject( "SalesReturnBatchSearchBean", "eST.SalesReturnBatchSearchBean" ,request );
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String item_code= request.getParameter( "item_code" )==null?"":request.getParameter( "item_code" ) ;
	String store_code= request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" ) ;
    String sal_trn_type = request.getParameter( "sal_trn_type" )==null?"":request.getParameter( "sal_trn_type" ) ;

	String patient_id= request.getParameter( "patient_id" )==null?"":request.getParameter( "patient_id" ) ;
	String encounter_id= request.getParameter( "encounter_id" )==null?"":request.getParameter( "encounter_id" ) ;

	String rdonly="";

	String searchFunction	= request.getParameter( "searchFunction" )==null?"N":request.getParameter( "searchFunction" ) ;
	String multipleSelect	= request.getParameter( "multipleSelect" )==null?"N":request.getParameter( "multipleSelect" ) ;
	String maxAllowed="1";
	String doc_type_code	= request.getParameter( "doc_type_code" )==null?"":request.getParameter( "doc_type_code" ) ;
	String doc_no	= request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;
	String trn_type	= request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;

	if(multipleSelect.equals("N"))maxAllowed="1";
	else if(multipleSelect.equals("Y"))maxAllowed="10";
	
	if(searchFunction.equals("Y"))
	{
		if(item_code.equals(""))
		{%>
			<script language="JavaScript">
				alert(getMessage("ST_ITEM_CODE_BLANK","ST"));
				parent.window.close();
			</script>
		<%}else if (store_code.equals(""))
		{%>
				<script language="JavaScript">
				alert(getMessage("ST_STORE_CODE_BLANK","ST"));
				parent.window.close();
				</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		}
		else
			rdonly="disabled";
	}
	
	bean.setMaxAllowed(maxAllowed) ;
	bean.setMultipleSelect(multipleSelect) ;
	bean.setSearchFunction(searchFunction) ;
	
%>

<body onload='FocusFirstElement();' >
	<form name="BatchSearchCriteria_Form" id="BatchSearchCriteria_Form" >
	  <table border="0" cellpadding="0" cellspacing="0" width='100%' align="center" >
		<form name="formBatchSearch" id="formBatchSearch" onSubmit= 'return submitPage();' >
       		<table border=0 cellspacing=0 cellpadding=0 width='100%' align="center" >
			    <th   colspan=4><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>

				<tr>
					<td  class=label><fmt:message key="Common.item.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='fields'><input type=text name=item_code_from size=20 maxlength=20 value="<%=item_code%>" <%=rdonly%> ><input type=button name="item_search_from" id="item_search_from" class="button"   onClick="searchCodeItem(item_code_from)"  value='?' disabled></td>
					<td  class=label><fmt:message key="Common.IssueStore.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='fields'><input type=text name=store_code size=15 maxlength=15 value="<%=store_code%>" <%=rdonly%>><input type=button name="store_search" id="store_search" class="button"   onClick="return searchCodeStore(store_code);"  value='?' disabled></td>
				</tr>

				<tr>
					<td  class=label><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='fields'><input type=text name=patient_id size=15 maxlength=15 value="<%=patient_id%>" <%=rdonly%>><input type=button name="" id="" class="button"   onClick="return searchCodeStore(patient_id);"  value='?' disabled></td>
					<td  class=label><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class='fields'><input type=text name=encounter_id size=15 maxlength=15 value="<%=encounter_id%>" <%=rdonly%>><input type=button name="" id="" class="button"   onClick="return searchCodeStore(encounter_id);"  value='?' disabled></td>
				</tr>

				<tr>
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
<input type=hidden name=sal_trn_type value="<%=sal_trn_type%>">

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
putObjectInBean( "SalesReturnBatchSearchBean",bean,request);
%>
</body>
</html>


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html> 
<head>
  <%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/DrugItemLink.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
     /* Mandatory checks start */
    String mode			= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
   
	String from_source=request.getParameter("from_source");
	
	if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
 %>
<form name="drugitemlink_criteria" id="drugitemlink_criteria" >
 <%
 if(from_source!=null && from_source.equals("matching_record")){
 %>
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="">
        <tr>
			<td class="label" colspan="5">&nbsp;</td>
		</tr>
		<tr>
			<td class="label" width="11%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
			<td class="label"  width="5%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="label" width="35%" >&nbsp;&nbsp;<input type="text" name="item_code_from_desc" id="item_code_from_desc" value="" size="10" maxlength="10"></input><input type="button" class="button" name="search_from" id="search_from" value="?" onClick="searchItemCode('from');">&nbsp;</td>
			<td class="label" width="8%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class="label" width="39%">&nbsp;&nbsp;<input type="text" size="10" maxlength="10"  name="item_code_to_desc" id="item_code_to_desc" value=""></input><input type="button" class="button" name="search_to" id="search_to" value="?" onClick="searchItemCode('to');"></td>
		</tr>
	</table>
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="">
    	<tr>
			<td class="label"  width="15%" colspan="2" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
			<td class="label" >&nbsp;&nbsp;<select name="criteria" id="criteria">
					<option value="AS"><fmt:message key="Common.Associated.label" bundle="${common_labels}"/></option>
					<option selected value="UA"><fmt:message key="ePH.Unassociated.label" bundle="${ph_labels}"/></option>
					<option value="NF"><fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
			<td class="label" width="18%" ><fmt:message key="ePH.MaxRecords.label" bundle="${ph_labels}"/></td>
			<td class="label" width="40%" >&nbsp;&nbsp;<select name="max_rec" id="max_rec">
					<option value="20">20</option>
					<option value="40">40</option>
					<option value="60">60</option>
					<option value="80">80</option>
					<option selected value="100">100</option>
				</select>
			</td>
		</tr>
	</table>
	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="">
    	<tr>
			<td class="label"  width="17%"><input type="button" class="button" name="search_matching" id="search_matching" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'		
			 onClick="SearchItemCodeResult()" ><input type="button" class="button" name="" id="" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'	 "Clear" onClick="ClearItemCode()"
			</td>
		</tr>
		<table>
<%
 }else if(from_source!=null && from_source.equals("missing_record")){
%>
<table border="1" width="50%" cellspacing="0" cellpadding="0" class="TABTABLE">
	<tr>
		<td class="TDCLICKED" width="25%" height="20" onClick="javascript:SearchItemCodeResultMR('BT')"><fmt:message key="ePH.InventoryItemsDrugs.label" bundle="${ph_labels}"/></td>
		<td class="TDNORMAL" width="15%"  onClick="javascript:SearchItemCodeResultMR('IT')"><fmt:message key="ePH.InventoryItems.label" bundle="${ph_labels}"/></td>
		<td class="TDNORMAL" width="10%"  onClick="javascript:SearchItemCodeResultMR('DR')"><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></td>

	</tr>
</table>
<script>SearchItemCodeResultMR('BT');</script>
<%
 }
%>
<input type="hidden" name="from_source" id="from_source" value="<%=from_source%>">
<input type="hidden" name="item_code_from_code" id="item_code_from_code" value="">
<input type="hidden" name="item_code_to_code" id="item_code_to_code" value="">
<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
<input type="hidden" name="SQL_PH_DRUG_ITEM_LINK_SELECT1" id="SQL_PH_DRUG_ITEM_LINK_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_ITEM_LINK_SELECT1")%>">
</form>
</body>
</html>


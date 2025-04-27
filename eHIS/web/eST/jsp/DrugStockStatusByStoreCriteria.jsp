<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src="../../eST/js/DrugStockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String bean_id								=		"DrugStockStatusByStoreBean";
	String bean_name							=		"eST.DrugStockStatusByStoreBean";
	
	DrugStockStatusByStoreBean bean					=		(DrugStockStatusByStoreBean) getBeanObject( bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String user									=		(String) session.getValue( "login_user" );
%>

<body  >
<form name="DrugStockStatusByStoreCriteria_form" id="DrugStockStatusByStoreCriteria_form"    >

<div align="left">

<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>

<tr>
	<td colspan=1 width="12%">&nbsp;</td>
	<td colspan=6 >&nbsp;</td>
</tr>

<tr >
	<td align="right"  class="label">&nbsp;&nbsp;From Store Code</td>
	<td  class="label" align="left"><input type='text' size='15'  maxlength='15' name='store_code_from' id='store_code_from'  value=""   ><input class='button' type='button' name='searchItem1' id='searchItem1' value='?'  onClick="searchStoreCode(from_store_code,store_code_from,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	</td>
	<td align="left"  class="label" >To Store Code</td>
	<td  class="label" align="left">&nbsp;<input type='text' size='15'  maxlength='15' name='store_code_to' id='store_code_to'  value=""><input class='button' type='button' name='searchItem2' id='searchItem2' value='?'  onClick="searchStoreCode(to_store_code,store_code_to,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	</td>
	<td align="left"  class="label" ><fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/></td>
	<td> 
	<select name='stock_level' id='stock_level'>
	<option value="A"  ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value="S"  ><fmt:message key="eST.StockOnHand.label" bundle="${st_labels}"/></option>
	<option value="Z"  ><fmt:message key="eST.ZeroStock.label" bundle="${st_labels}"/></option>
	<option value="B"  ><fmt:message key="eST.BelowRe-OrderLevel.label" bundle="${st_labels}"/></option>
	</select>
	</td>
	
</tr>

<tr >
	<td align="right"  class="label" >&nbsp;&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td  class="label" align="left" colspan=3>
	<input type='text' size='70'  maxlength='60' name='item_desc' id='item_desc'  value="">
	<input class='button' type='button' name='searchResult' id='searchResult' value='?'  onClick="searchItemCode(item_code,item_desc);" class="label"></span>
	</td>
	<td align="left"  class="label" ><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></td>
	<td>
	<select name='stock_item' id='stock_item'>
	<option value=""  ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
	<option value="Y"  ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
	<option value="N"  ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
	
	</select>
	</td>
   
</tr>
</table>
<table cellpadding="0" cellspacing="0" width='100%' align='center' border="0">
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='label'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;<input maxLength=4 size=6 name="p_fm_item_class" id="p_fm_item_class" value="" >
		<input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
		<td class="label">&nbsp;</td>
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=6 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 1</td>
		<td class=fields>&nbsp;<select name="analysis_code1_from" id="analysis_code1_from" onChange="loadcolumn(analysis_code1_from);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 1</td>
		<td class=fields>&nbsp;&nbsp;<select name="analysis_code1_to" id="analysis_code1_to" onChange="loadcolumn(analysis_code1_to);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 2</td>
		<td class=fields>&nbsp;<select name="analysis_code2_from" id="analysis_code2_from" onChange="loadcolumn(analysis_code2_from);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 2</td>
		<td class=fields>&nbsp;&nbsp;<select name="analysis_code2_to" id="analysis_code2_to" onChange="loadcolumn(analysis_code2_to);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
	</tr>
	<tr>
		<td class="label">&nbsp;</td>
		<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 3</td>
		<td class=fields>&nbsp;<select name="analysis_code3_from" id="analysis_code3_from" onChange="loadcolumn(analysis_code3_from);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
		<td class="label">&nbsp;</td>
		<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 3</td>
		<td class=fields>&nbsp;&nbsp;<select name="analysis_code3_to" id="analysis_code3_to" onChange="loadcolumn(analysis_code3_to);" > <%=bean.getItemAnal_code_List()%>
		</select></td>
	</tr>
	<tr>
		<td align="right" colspan='6' >
		<input class='button' type='button' name='showItem' id='showItem' value='<fmt:message key="eST.ShowItems.label" bundle="${st_labels}"/>'  onClick="searchResults(document.DrugStockStatusByStoreCriteria_form);" class="label">&nbsp;</td>
	</tr>
</table>
</div>
	<input type="hidden" name ="to_store_code" >
	<input type="hidden" name ="from_store_code" >
	<input type="hidden" name ="item_code" >
	<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
	<input type="hidden" name="language_id" id="language_id"						value="<%=locale%>">
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE_ITEM_STORE")%>">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">


</form>
	<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean(bean_id,bean,request);
%>

</body>
</html>


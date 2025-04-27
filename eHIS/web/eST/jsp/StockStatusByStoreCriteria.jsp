<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
7/6/2021		TFS-19789			Shazana											MOHE-CRF-0084.1 
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%><!-- Modified for TFS id:6938 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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
		<script language='javascript' src="../../eST/js/StockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection con				= null;//Added for TFS id:6938
boolean restrict_stores_user_access_yn =false;//Added for TFS id:19789 
String strFacilityParam = "";
String restrictInReportYN = "";//end
try{//Added for TFS id:6938
//	java.util.HashMap defaultParameter			=		null;
	String bean_id								=		"StockStatusByStoreBean";
	String bean_name							=		"eST.StockStatusByStoreBean";
	
	StockStatusByStoreBean bean					=		(StockStatusByStoreBean) getBeanObject( bean_id,  bean_name, request );  
	bean.setLanguageId(locale);
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String user									=		(String) session.getValue( "login_user" );
	con						= ConnectionManager.getConnection(request);//Added for TFS id:6938
	boolean barcode_appl =CommonBean.isSiteSpecific(con, "ST", "BARCODE_APPL_FOR_QUERY_FUNC");//Added for TFS id:6938
	restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");//Added for TFS id:19789 
	strFacilityParam = bean.getRestrictUserAccessStore();
	if(strFacilityParam== null || strFacilityParam.equals(""))
		strFacilityParam = "N"; 
	if(restrict_stores_user_access_yn){
		if(strFacilityParam.equals("Y")){
			restrictInReportYN = "Y";
		}else{
			restrictInReportYN = "N"; 
		}
	}//END 
	
	
%>

<body  >
<form name="StockStatusByStoreCriteria_form" id="StockStatusByStoreCriteria_form"    >
<!-- action="../../eST/jsp/StockStatusByStoreResult.jsp" method="post"  target="result" onReset='FocusFirstElement();' -->

<div align="left">

<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>

<tr>
	<td colspan=1 width="12%">&nbsp;</td>
	<td colspan=6 >&nbsp;</td>
</tr>

<tr >
	<td align="left"  class="label">&nbsp;&nbsp;From Store Code</td>
	<% if(restrictInReportYN.equals("Y")){ %><!-- added for TFS id:19789  -->
	<td  class="label" align="left">&nbsp;<input type='text' size='15'  maxlength='15' name='store_code_from' id='store_code_from'  value=""   ><input class='button' type='button' name='searchItem1' id='searchItem1' value='?'  onClick="searchStoreCode1(from_store_code,store_code_from,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	<%}else{ %>
		<td  class="label" align="left">&nbsp;<input type='text' size='15'  maxlength='15' name='store_code_from' id='store_code_from'  value=""   ><input class='button' type='button' name='searchItem1' id='searchItem1' value='?'  onClick="searchStoreCode(from_store_code,store_code_from,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	<%} %>
	</td>
	<td align="left"  class="label" >To Store Code</td>
	<% if(restrictInReportYN.equals("Y")){ %>
	<td  class="label" align="left">&nbsp;<input type='text' size='15'  maxlength='15' name='store_code_to' id='store_code_to'  value=""><input class='button' type='button' name='searchItem2' id='searchItem2' value='?'  onClick="searchStoreCode1(to_store_code,store_code_to,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	<%}else{ %>
	<td  class="label" align="left">&nbsp;<input type='text' size='15'  maxlength='15' name='store_code_to' id='store_code_to'  value=""><input class='button' type='button' name='searchItem2' id='searchItem2' value='?'  onClick="searchStoreCode(to_store_code,store_code_to,'<%=user%>','<%=locale%>');"><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></span>
	<%} %>
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
<!-- Added for TFS id:6938 -->
<%if(barcode_appl){ %>
<tr>
	<td class=label colspan="1" >&nbsp;&nbsp;<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/>&nbsp;&nbsp;</td>
		<td  class='label' colspan="5">&nbsp;<input type=text name=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenForQueryFunction(event, barcode,'SSBS','<%=bean_id%>','<%=bean_name%>',document.StockStatusByStoreCriteria_form);" ></td>
	</tr>
	<%} %>
	<!-- Added for TFS id:6938 -->
<tr >
	<td align="left"  class="label" >&nbsp;&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td  class="label" align="left" colspan=3>&nbsp;<input type='text' size='70'  maxlength='60' name='item_desc' id='item_desc'  value=""   ><input class='button' type='button' name='searchResult' id='searchResult' value='?'  onClick="searchItemCode(item_code,item_desc);" class="label"></span>
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
		<input class='button' type='button' name='showItem' id='showItem' value='<fmt:message key="eST.ShowItems.label" bundle="${st_labels}"/>'  onClick="searchResults(document.StockStatusByStoreCriteria_form);" class="label">&nbsp;</td>
	</tr>
</table>
</div>
	<input type="hidden" name ="to_store_code" >
	<input type="hidden" name ="from_store_code" >
	<input type="hidden" name ="item_code" value=""><!-- Modified for TFS id:6938 -->
	<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
	<input type="hidden" name="language_id" id="language_id"						value="<%=locale%>">
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_STOCK_STATUS_BY_STORE_ITEM_STORE")%>">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">


</form>
	<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%=eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean(bean_id,bean,request);
//Added for TFS id:6938
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);

}
//Added for TFS id:6938
%>

</body>
</html>


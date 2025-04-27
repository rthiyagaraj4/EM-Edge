<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
---------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page import ="eST.ItemMovementBean, eST.Common.* , eCommon.Common.*,java.util.HashMap,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%><!-- Modified for TFS id:6938 -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=    (String)session.getAttribute("LOCALE");
		String sStyle			=	 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/StTransaction.js"></script>
	<script language='javascript' src="../../eST/js/ItemMovement.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	Connection con				= null;//Added for TFS id:6938
	try{//Added for TFS id:6938
	String facility_id			=		(String)session.getValue("facility_id");
	String bean_id				=		"ItemMovementBean";
	String bean_name			=		"eST.ItemMovementBean";
	ItemMovementBean bean		=		(ItemMovementBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFacility_id(facility_id);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	//HashMap move_date			=		bean.getStParameter();
	//HashMap move_date			=		bean.getStParameter();
	HashMap move_date = bean.fetchRecord("select	substr(st_get_post_mth_yr(to_char(to_date(sysdate,'dd/mm/yyyy'))),1,2) CURR_PROC_MONTH, substr(st_get_post_mth_yr(to_char(to_date(sysdate,'dd/mm/yyyy'))),3,4) CURR_PROC_YEAR from	dual");
	//String l_move_month	= (String)hmResult.get("MM");
	//String l_move_year	= (String)hmResult.get("YYYY");
	
	String Current_Year = (String)move_date.get("CURR_PROC_YEAR");
	Current_Year = com.ehis.util.DateUtils.convertDate(bean.checkForNull(Current_Year),"YY","en",locale);
	con						= ConnectionManager.getConnection(request);//Added for TFS id:6938
	boolean barcode_appl =CommonBean.isSiteSpecific(con, "ST", "BARCODE_APPL_FOR_QUERY_FUNC");//Added for TFS id:6938	
	
%>
<body onload='dis_detail(document.StockStatusByStoreCriteria_form);'>
<form name="StockStatusByStoreCriteria_form" id="StockStatusByStoreCriteria_form" >
<table border="0" cellpadding="0" cellspacing="2" width='100%' align=center>
<!-- Added for TFS id:6938 start -->
<%if(barcode_appl){ %>
<tr>
<td colspan="4">&nbsp;</td>
	<td class=label >&nbsp;<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/></td>
		<td  class='label' nowrap><input type=text name=barcode id=barcode size=80  maxlength=100 value="" onkeypress="callItemSearchScreenForQueryFunction(event, barcode,'ITMMOV','<%=bean_id%>','<%=bean_name%>',document.StockStatusByStoreCriteria_form);" ></td>
	</tr>
	<%} %>
	<!-- Added for TFS id:6938 end-->
	<tr nowrap>
		<td   class="label" nowrap>&nbsp;<fmt:message key="eST.QueryType.label" bundle="${st_labels}"/>&nbsp;</td>
		<td    class="label" nowrap>
			<select name='query_type' id='query_type' 		onChange="dis_detail(document.StockStatusByStoreCriteria_form);">
				<option value='summary'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
				<option  value='detail'><fmt:message key="Common.details.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td  class="label" nowrap>&nbsp;<fmt:message key="eST.ResultCriteria.label" bundle="${st_labels}"/>&nbsp;
		</td>
		<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
		<td class="label">
			<select name='result_criteria' id='result_criteria' >
				<option  value='quantity'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
				<option  value='value'><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<%}else{%>
		<td class="label">
			<select name='result_criteria' id='result_criteria' >
				<option  value='quantity'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<%}%>
		<td  class="label"  >&nbsp;<fmt:message key="Common.item.label" bundle="${common_labels}"/> </td>
		<td  class="label" colspan="3">
			<input type='text' size='40'  maxlength='60' name='item_desc' id='item_desc'  value="">
			<input type=hidden size='15'  maxlength='15' name='item_code' id='item_code'  value="">
			<input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="return searchItemCode(item_code,item_desc);" class="label">
			<span id="item_S" style="visibility:hidden"><%=bean.getImage("M")%></span></span>
		</td>
	</tr>
	<tr >
		<td   class="label" nowrap>&nbsp;<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan='1'   class="label">
			<input type='text' name='store_code' id='store_code'  value="">
			<input class='button' type='button' name='storecode' id='storecode' value='?'  onClick="return searchStoreCode(store_code);" class="label">
			<span id="store_S" style="visibility:hidden"><%=bean.getImage("M")%></span>
		</td>
		<td class="label" nowrap>&nbsp;<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/>&nbsp;</td>
		<td    class="label" nowrap>
			<input type='text' size='15'  maxlength='15' name='item_class' id='item_class'  value="">
			<input class='button' type='button' name='searchItemClass' id='searchItemClass' value='?'  onClick="return searchCodeItemClass(item_class);" class="label"></td>
		<td class="label">&nbsp;<fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class="label">
			<select name='trn_type' id='trn_type' onclick="trn_Show(document.StockStatusByStoreCriteria_form);" onChange="trn_Show(document.StockStatusByStoreCriteria_form);"><%=bean.getTrn_type()%>
			</select>
		</td>
		<td class="label" colspan="2">&nbsp;<fmt:message key="eST.StockItem.label" bundle="${st_labels}"/>&nbsp;
			<select name='stock_item' id='stock_item'>
				<option value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option  value='Y'><fmt:message key="Common.Stock.label" bundle="${common_labels}"/></option>
				<option  value='N'><fmt:message key="eST.NonStock.label" bundle="${st_labels}"/></option>
			</select>
		</td>
	</tr>
	<tr>
		<td   class="label"  >&nbsp;<fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/>&nbsp;</td>
		<td   class="label" >
			<input type='text' size='2'  maxlength='2' name='from_month' id='from_month' value="" onKeyPress="return isValidInteger();" >&nbsp;/&nbsp;
			<input type='text' size='4'  maxlength='4' name='from_year' id='from_year' value="" onKeyPress="return isValidInteger();">
		<td  class="label"  ><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td   class="label" >
			<input type='text' size='2'  maxlength='2' name='to_month' id='to_month' value="<%=bean.checkForNull((String)move_date.get("CURR_PROC_MONTH"))%>" onKeyPress="return isValidInteger();" >&nbsp;/&nbsp;
			<input type='text' size='4'  maxlength='4' name='to_year' id='to_year' value="<%=Current_Year%>" onKeyPress="return isValidInteger();">	</td>	
		<td class="label" colspan="2" id="inflow_out_flow" style="visibility:hidden" ><fmt:message key="eST.StockInflow.label" bundle="${st_labels}"/>/<fmt:message key="eST.Outflow.label" bundle="${st_labels}"/>&nbsp;	
			<select name='stock_inflow_outflow' id='stock_inflow_outflow' >
				<option  value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option  value='I'><fmt:message key="eST.Inflow.label" bundle="${st_labels}"/></option>
				<option  value='O'><fmt:message key="eST.Outflow.label" bundle="${st_labels}"/></option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="6">&nbsp;</td>
		
		<td  class="label" align="right" >
			<input class='button' type='button' name='showItem' id='showItem' value='<fmt:message key="eST.ShowItems.label" bundle="${st_labels}"/>'  onClick="searchResults(document.StockStatusByStoreCriteria_form);" class="label">&nbsp;&nbsp;
		</td>
	</tr>
</table>
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_STORE")%>">
	<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
	<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>" >
	<input type="hidden" name="facility_id" id="facility_id"						value="<%=facility_id%>" >
	<input type="hidden" name="store_desc" id="store_desc"						value="" >
</form>
<%
putObjectInBean(bean_id,bean,request);
//Added for TFS id:6938 start
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);

	}
	//Added for TFS id:6938 end
%>
</body>
</html>


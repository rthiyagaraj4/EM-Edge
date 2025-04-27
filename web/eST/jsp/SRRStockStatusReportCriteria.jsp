<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!--	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/SRRReportStockStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"ReportsStockStatusBean";
		String bean_name			=		"eST.ReportsStockStatusBean";
		//String p_report_id		=		 null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		ReportsStockStatusBean bean =		(ReportsStockStatusBean) getBeanObject( bean_id,  bean_name,request  );  
		String p_store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = 'E' and language_id=? order by SHORT_DESC",locale));
	
	
		
/* Incident No :18071
		
  Change :STBSTKS4 Option is Added 
  Date : 1/11/2010
  By   : Rams
*/
//		bean.setLanguageId(locale);
		bean.clear();
		bean.setLanguageId(locale);
		/**
			 * @Name - Priya
			 * @Date - 07/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost 
			 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockStatusReportCriteria" id="formStockStatusReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
					<td  class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields  colspan='8'>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" onChange="loadcolumn(p_report_id),setReportType(),setReportOrder();setBatchSelection(this,p_batch_sel)" > 
						<option  value='STBSTKS1'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS2'><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS3'><fmt:message key="eST.ByStoreBatch.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS4'><fmt:message key="eST.ByStoreBinLocation.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS5'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS6'><fmt:message key="eST.ByItemBatch.label" bundle="${st_labels}"/></option>
					</select></td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
				</tr>
				<tr><td class='label' colspan='4'>&nbsp;</td></tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_gr" id="p_store_gr" ><%=p_store_group%>
					</select></td>
				</tr>

							
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=4>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>

				<tr><td class='label' colspan='3'>&nbsp;</td></tr>
				
				

				<tr>
					<td  class="label" ><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_drug_nondrug" id="p_drug_nondrug" >
						<option value=''><fmt:message key="Common.all.label" bundle="${mm_labels}"/></option>
						<option  value='Y'><fmt:message key="Common.Drug.label" bundle="${mm_labels}"/></option>
						<option  value='N'><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>

			
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" > <input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" > <input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"> </td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>

				<td class=label align=right><font style="visibility:hidden" id = 'p_bin_style'><fmt:message key="Common.BinLocation.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_bin_loc size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);" id="p_fr_bin_loc_txt" style="visibility:hidden" ></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<font style="visibility:hidden" id = 'p_bin_to_style' hidden><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_bin_loc size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);" id="p_to_bin_loc_txt" style="visibility:hidden"></td>
				</tr>
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.UnitCost.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text class="number" name=p_fr_unit_cost size=14 maxlength=14  value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false);"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_unit_cost size=14 maxlength=14 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false); "></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text class="number" name=p_fr_st_val size=14 maxlength=14  value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false);"></td>
					<td  class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_st_val size=14 maxlength=14 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false); "></td>
				</tr>
				<tr>
					<td class="label" width="20%" ><fmt:message key="eST.ItemSelection.label" bundle="${st_labels}"/></td>
					<td class=fields  width="30%">&nbsp;&nbsp;<select name="p_item_sel" id="p_item_sel" >
						<option value='AL'><fmt:message key="eST.AllItems.label" bundle="${st_labels}"/></option>
						<option  value='ZO'><fmt:message key="eST.ZeroStockItems.label" bundle="${st_labels}"/></option>
						<option  value='LR'><fmt:message key="eST.ItemLessthanReorderLevel.label" bundle="${st_labels}"/></option>
						<option  value='LM'><fmt:message key="eST.ItemLessthanMinimumLevel.label" bundle="${st_labels}"/></option>
						<option  value='IS'><fmt:message key="eST.ItemwithStock.label" bundle="${st_labels}"/></option>
						<option  value='MS'><fmt:message key="eST.ItemGreaterthanMaximumLevel.label" bundle="${st_labels}"/></option>
					</select></td>
					<td class="label" width="20%"><fmt:message key="eST.StockPositionof.label" bundle="${st_labels}"/> </td>
					<td class=fields width="30%">&nbsp;&nbsp;<select name="p_stk_pt" id="p_stk_pt" >
						<option value='A'><fmt:message key="eST.AllStores.label" bundle="${st_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.ReorderableStoresstock.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.NonReorderableStoresStock.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eST.ExpirySelection.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_expiry_sel" id="p_expiry_sel" >
						<option value='A'><fmt:message key="eST.AllItems.label" bundle="${st_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.NonExpiryItems.label" bundle="${st_labels}"/></option>
					</select></td>
					<td  class="label" ><fmt:message key="eST.BatchSelection.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;
					<!--
					/**
					* @Name - Priya
					* @Date - 08/06/2010
					* @Inc# - IN021369
					* @Desc - To generate 'Batch Selection' select box value based on the selected report type
					*/
					-->
					<select name="p_batch_sel" id="p_batch_sel" disabled>
						<option value="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
						<!--<option value='A'><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.SuspendedBatches.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.ActiveBatches.label" bundle="${st_labels}"/></option>-->
					</select></td>
				</tr>

				<tr><td class='label' colspan='3'>&nbsp;</td></tr>


				<tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal1" id="p_item_anal1" >
					<option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					ArrayList	arraylist		=		null;
					HashMap		hmItemCode		=		null;	
					String code					=		"";
					String	desc				=		"";

					arraylist					=		bean.getArrayCodeList();
					int arrLength				=		arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode				=		(HashMap) arraylist.get(i);
						code					=		(String)hmItemCode.get("code");
						desc					=		(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
				
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>2</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal2" id="p_item_anal2" >
					<option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      		=		(HashMap) arraylist.get(i);
						code					=		(String)hmItemCode.get("code");
						desc					=		(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
						</tr>
						<tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3" id="p_item_anal3" >
					<option value="">&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      		=		(HashMap) arraylist.get(i);
						code					=		(String)hmItemCode.get("code");
						desc					=		(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					
				</tr>

				

				<tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
						<td class=fields >&nbsp;&nbsp;<select name="p_abc_anal" id="p_abc_anal" >
					<option value="">  ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  </option>
					<option value ='A'><fmt:message key="eST.A.label" bundle="${st_labels}"/></option>
					<option  value='B'><fmt:message key="eST.B.label" bundle="${st_labels}"/></option>
					<option  value='C'><fmt:message key="eST.C.label" bundle="${st_labels}"/></option>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					</select></td>
				</tr>
				
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>
					
					<tr>
					<td class="label" ><fmt:message key="eST.ConsignmentItems.label" bundle="${st_labels}"/> </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_consg_item" id="p_consg_item" >
						<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
					</select></td>

					<td class=label align=right width="30%"><font style="visibility:visible" id = 'p_top_style'><fmt:message key="Common.Top.label" bundle="${common_labels}"/></font></td>
					<td class=fields nowrap>&nbsp;&nbsp;<input type="text" class="NUMBER" name="p_count" id="p_count" maxLength="4" size="4" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this),setValue();" id="p_count_style" style="visibility:visible"><font style="visibility:visible" id = 'p_item_style'>Item(s)</font>&nbsp;<font style="visibility:visible" id = 'p_by_style'><fmt:message key="Common.by.label" bundle="${mm_labels}"/>&nbsp;&nbsp;<select name="p_item_by" id="p_item_by"  id="p_select_by_style" style="visibility:visible">
						<option value='Q'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option  value='C'><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/> </option>
					</select></td>
					
				<tr>
					<td  class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_report_order" id="p_report_order" >
						<option value='I'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
						<option  value='S'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </option>
						<option  value='V'><fmt:message key="Common.ItemValue.label" bundle="${common_labels}"/></option>
					</select></td>

					<td  class="label" ><fmt:message key="Common.Nature.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="p_eff_status" id="p_eff_status" >
						<option value ='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option  value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
						<option  value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
				</select></td>
					
				</tr>

					<tr><td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
				</tr>

				
				
			   <!--  <tr>
					<td align="right" class="label">Print Technical Specification</td>
					<td align="left">&nbsp;<input type="checkbox" value="E" name="print_spec" id="print_spec"></td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr> -->
                
				</table>
				</td>  

				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


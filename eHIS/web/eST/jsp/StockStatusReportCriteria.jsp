<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017		IN063889			B.Badmavathi								    Performance issue - KDAH-SCF-0415 
10/08/2018		IN068415			Haribabu										AMRI-SCF-0540
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*, webbeans.eCommon.*,java.sql.*,java.lang.*,  java.util.*,java.lang.*" %>
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
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!--	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ReportStockStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"ReportsStockStatusBean";
		String bean_name			=		"eST.ReportsStockStatusBean";
		//String p_report_id		=		 null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		ReportsStockStatusBean bean =		(ReportsStockStatusBean) getBeanObject( bean_id,  bean_name,request  );  
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
					 
	//Added for Amri-scf-0540 starts 
	Connection con				= null;
    con						= ConnectionManager.getConnection(request);
	boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_STOCKSTATUS_REPORT_TO_STORE");
											
	//Added for  Amri-scf-0540 ends			 
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockStatusReportCriteria" id="formStockStatusReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
					<td  class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields  colspan='8'>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" onChange="loadcolumn(p_report_id,'<%=site_main%>'),setReportType(),setReportOrder();" > <!-- added for AMRI-SCF-0540 -->
						<option  value='STBSTKS1'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS2'><fmt:message key="eST.ByItemStore.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS3'><fmt:message key="eST.ByStoreBatch.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS4'><fmt:message key="eST.ByStoreBinLocation.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS5'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
						<option  value='STBSTKS6'><fmt:message key="eST.ByItemBatch.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<!-- Modified for AMRI-SCF-0540 start -->
				<%if(site_main){ %>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" disabled>
					<input class="button" disabled onClick="return searchCodeStore(p_fr_st_code,p_to_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"> <IMG id='fm_str_code_mnd' style="visibility:hidden" src="../../eCommon/images/mandatory.gif" ></td> 
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 disabled name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code,p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?" disabled></td>
				</tr>
				<%}else{ %>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" disabled><input class="button" disabled onClick="return searchCodeStore(p_fr_st_code,p_to_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"> <IMG id='fm_str_code_mnd' style="visibility:hidden" src="../../eCommon/images/mandatory.gif" ></td> 
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 disabled name="p_to_st_code" id="p_to_st_code" value=""  readonly ><input class="button" onClick="return searchCodeStore(p_to_st_code,p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?" disabled></td>
				</tr>
				<%} %>
				<!-- Modified for AMRI-SCF-0540 start end -->
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" > <input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"> </td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" > <input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name='p_fr_alp_code'  id='p_fr_alp_code' size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class=label>&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name='p_to_alp_code' id='p_to_alp_code' size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
					<td class=label align=left><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text class="number" name='p_fr_unit_cost' id='p_fr_unit_cost' size=14 maxlength=14  value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false);"></td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name='p_to_unit_cost' id='p_to_unit_cost' size=14 maxlength=14 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false); "></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.StockValue.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name='p_fr_st_val' id='p_fr_st_val' size=14 maxlength=14 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false); "></td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name='p_to_st_val' id='p_to_st_val' size=14 maxlength=14 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, <%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this, false); "></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eST.BinLocationRange.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text disabled name='p_fr_bin_loc' id='p_fr_bin_loc' size=10 maxlength=10 value=""  ></td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name='p_to_bin_loc' id='p_to_bin_loc' disabled size=10 maxlength=10 value=""  ></td>
				

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
					<td class=fields >&nbsp;&nbsp;<select name="p_batch_sel" id="p_batch_sel" >
						<option value='A'><fmt:message key="eST.AllBatches.label" bundle="${st_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.SuspendedBatches.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.ActiveBatches.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>


				<tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
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
				
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2</td>
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
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>3</td>
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
					<td  class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="p_eff_status" id="p_eff_status" >
						<option value ='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option  value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
						<option  value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
				</select></td>
				</tr>
					
					<tr>
					<td class="label" ><fmt:message key="eST.ConsignmentItems.label" bundle="${st_labels}"/> </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_consg_item" id="p_consg_item" >
						<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option  value='Y'><fmt:message key="eST.Consignment.label" bundle="${st_labels}"/></option>
						<option  value='N'><fmt:message key="eST.NonConsignment.label" bundle="${st_labels}"/></option>
					</select></td>

					<td class=label align=right width="30%"><font style="visibility:visible" namw='p_top_style' id = 'p_top_style'><fmt:message key="Common.Top.label" bundle="${common_labels}"/></font></td>
					<td class=fields>&nbsp;&nbsp;<input type="text" class="NUMBER" name="p_count" id="p_count" maxLength="4" size="4" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this),setValue();" name="p_count_style" id="p_count_style" style="visibility:visible"><font style="visibility:visible" name="p_item_style" id ="p_item_style">Item(s)</font></td>
					
				<tr>
					<td  class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_report_order" id="p_report_order" >
						<option value='I'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
						<option  value='S'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </option>
						<option  value='V'><fmt:message key="Common.ItemValue.label" bundle="${common_labels}"/></option>
					</select></td>
					<td class=label width="10%">&nbsp;</td>
				   <td class=label>&nbsp;&nbsp;</td>
				
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
			<input type="hidden" name="p_user_id" id="p_user_id"						value="<%=user_name%>">
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


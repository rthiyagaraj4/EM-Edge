<!DOCTYPE html>
<%/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
9/7/2021				TFS-21260      		     Shazana           	     									ST-GHL-CRF-0640.7-TF-US001/01 - Sales Return
--------------------------------------------------------------------------------------------------------------------------------------------
*/ %> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/PrintCountSheet.js"></script>


	</head>
	<%
		
		String bean_id = "PrintCountSheetBean";
		String bean_name = "eST.PrintCountSheetBean";
		//String pr_report_id = "STBPHSHI";

		
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		PrintCountSheetBean bean = (PrintCountSheetBean) getBeanObject( bean_id, bean_name, request ) ;
		bean.clear();
		bean.setLanguageId(locale); 
		/**
	 * @Name - Priya
	 * @Date - 07/06/2010
	 * @Inc# - 
	 * @Desc -  To get no of decimals for cost 
	 */
		int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());	

		String []stParameters=	{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		//String curr_proc_day=(String)hmRecord.get("CURR_PROC_DAY");//Commented for checkstyle on 17/04/2015
		String curr_proc_month=(String)hmRecord.get("CURR_PROC_MONTH");
		String curr_proc_year =(String)hmRecord.get("CURR_PROC_YEAR");
					
	%>
	<body onLoad="FocusFirstElement();loadcolumn();">
		<form name="formPrintCountSheetReportCriteria" id="formPrintCountSheetReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
		<tr>
		<td width='100%'  class="WHITE">
			<table cellpadding="0" cellspacing="0" width="100%"  border="0">
			<th colspan=8 ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			<tr>
				<td   class="label" width="20%" height="30">
				<fmt:message key="eST.PhyInvProcessMode.label" bundle="${st_labels}"/></td>
				<td class='fields'  colspan='8'>&nbsp;&nbsp;
				<select name="p_report_mode" id="p_report_mode" onChange="loadcolumn();">
				<option value="A"><fmt:message key="eST.Annual.label" bundle="${st_labels}"/></option>
				<option value="P"><fmt:message key="eST.Perpetual.label" bundle="${st_labels}"/></option>
				</select></td>
			</tr>
			<tr>
					<td >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;
					<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="fields" colspan=5>&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td  >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label">
					<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/>
					</td>
					<td class='fields'>&nbsp;
					<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" >
					<input class="button" onClick="return searchCodeStore(p_fr_st_code,p_to_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"><%=bean.getImage("M")%></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value=""  readonly>
					<input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?" disabled></td>
					<td class="label">&nbsp;</td>
				</tr>
			<!-- Added by B.Badmavathi on 02-04-2015 against HSA-CRF-0220 -->	
				<tr>
					<td  class="label">
				<fmt:message key="eST.BinLocationCode.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_bin_code" id="p_fm_bin_code" value="" ><input class="button" name="p_fm_bin" id="p_fm_bin" onClick="return searchBinCode(p_fm_bin_code);" type="button" value="?"></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_bin_code" id="p_to_bin_code" value="" ><input class="button"  onClick="return searchBinCode(p_to_bin_code);" type="button"  name="p_to_bin" id="p_to_bin" value="?"></td>
					<td class="label">&nbsp;</td>
				</tr>
			 <!-- Added ends -->	
			 
				<tr>
					<td  class="label">
				<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button"  onClick="return searchCodeItem(p_to_item_code);" type="button"  name="p_to_sr2" id="p_to_sr2" value="?"></td>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td  class="label">
					<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button"  name="p_fm_b_class" id="p_fm_b_class" value="?"></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button"  name="p_to_b_class" id="p_to_b_class" value="?"></td>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class=label >
					<fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input type=text name="p_fr_alp_code" id="p_fr_alp_code" size=10 maxlength=10 value=""></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value=""></td>
					<td class=label>&nbsp;</td>
				</tr>
					<td class=label >
					<fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/>
					</td>
					<td class='fields'>&nbsp;&nbsp;<input type=text name="p_fr_unit_cost" id="p_fr_unit_cost" size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" value="" onKeyPress="return isValidNumber(this,event,8,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this);"></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input type=text name="p_to_unit_cost" id="p_to_unit_cost" size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" value="" onKeyPress="return isValidNumber(this,event,8,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this);"></td>
					<!--ComputeCost();-->
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class=label >
					<fmt:message key="eST.StockItemValue.label" bundle="${st_labels}"/></td>
					<td class='fields'>&nbsp;&nbsp;<input type=text name=p_fr_st_val size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" value="" onKeyPress="return isValidNumber(this,event,12,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this); "></td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<input type=text name=p_to_st_val size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" value="" onKeyPress="return isValidNumber(this,event,12,<%=noOfDecimalsForCost%>);" onblur="checkDoubleFormat(this); "></td>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class=label >
					<fmt:message key="eST.PhyInventoryType.label" bundle="${st_labels}"/></td>
					</td>
					<td class='fields' nowrap>&nbsp;&nbsp;<input type=text  name="p_fr_phy_inv" id="p_fr_phy_inv" size=10 maxlength=10 value="" onKeyPress="return checkSpecialChars(this);" >&nbsp;&nbsp;
					<fmt:message key="eST.PhysicalCountforBatchQty.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_phy_count_sel" id="p_phy_count_sel">
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Z"><fmt:message key="eST.ZeroQuantity.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="eST.NonZeroquantity.label" bundle="${common_labels}"/></option>
					
					</select></td>
					<td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td class=label >
					<fmt:message key="eST.PhyCount.label" bundle="${st_labels}"/>
					</td>
					<td class='fields'>&nbsp;&nbsp;<select name="p_phy_sel" id="p_phy_sel" >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="6">6</option>
					<option value="12">12</option>
					</select></td>
					<td class=label colspan=5>&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td>
				</tr>
				<!--<tr>
					<td align="right" class="label" width="20%" >Item Selection</td>
					<td class=label  width="30%">&nbsp;&nbsp;<select name="p_item_sel" id="p_item_sel" >
					<%=bean.getItemSelection()%>
					</select></td>
					<td class=label width="20%" colspan=5>&nbsp;&nbsp;</td>
					<td align="right" class="label" width="20%"></td>
				</tr>-->
				<tr>
				</td>
					<td  class="label" width="20%" ><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/>
</td>
					<td class='fields' width="20%">&nbsp;&nbsp;<select name="p_expiry_sel" id="p_expiry_sel" >
<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<option value="Y"><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></option>
<option value="N"><fmt:message key="eST.NonExpiryItems.label" bundle="${st_labels}"/></option>
					</select></td><td width="20%" colspan=5></td><td width="20%"></td>
				</tr>
				<tr>
					<td  class="label" >
					<fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/>
</td>
					<td class='fields' >&nbsp;&nbsp;<select name="p_report_id1" id="p_report_id1" onChange="setReportItemId();">
					<option value="STBPHSHI"><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
					<option value="STBPHSHB"><fmt:message key="eST.ByBinLocation.label" bundle="${st_labels}"/> </option>
					</select></td>
					<td class=label colspan=5>&nbsp;&nbsp;</td>
					<td  class="label" ></td>
				</tr>

				<tr>  
				<td  class="label"><fmt:message key="eST.ConsumptionPeriod.label" bundle="${st_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fr_month" id="p_fr_month" value="" onKeyPress="return isValidInteger();"  class="NUMBER"> 
				<class=text><b>/<b><class=text>
				<input maxLength=4 size=4 name="p_fr_year" id="p_fr_year" value="" onKeyPress="return isValidInteger();"  class="NUMBER">  <span style="visibility:hidden" id="mandatory_img_from"><%=bean.getImage("M")%> </span></td> 

				<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value=""  onKeyPress="return isValidInteger();"  onblur="changeToPeriod();" class="NUMBER"> 
				<class=text> <b>/</b><class=text> <input maxLength=4 size=4 name="p_to_year" id="p_to_year" value="" onKeyPress="return isValidInteger();" onblur="changeToPeriod();" class="NUMBER"> <span style="visibility:hidden" id="mandatory_img_to"><%=bean.getImage("M")%> </span>  </td> 
				<td class="label">&nbsp;</td>
				</tr>

				<tr>
				<td  class="label" ><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<select name="p_slow_fast_move" id="p_slow_fast_move"  onchange="changeVisibility();">
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
				<option value="S"><fmt:message key="eST.SlowMoving.label" bundle="${st_labels}"/></option>
				<option value="F"><fmt:message key="eST.FastMoving.label" bundle="${st_labels}"/></option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<font style="visibility:visible" align="right"><fmt:message key="Common.Top.label" bundle="${common_labels}"/></font></td>
				<td class=fields >&nbsp;&nbsp;<input type="text" class="NUMBER" maxLength="3" size="1" name="p_count" id="p_count" onKeyPress="return isValidInteger();" onblur="checkIntegerFormat(this);" ><span style="visibility:hidden" id="mandatory_img_count"><%=bean.getImage("M")%> </span><fmt:message key="Common.item.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;
				<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
				<select name="p_order_by_qty_value" id="p_order_by_qty_value">
				<option value="V"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
				<option value="Q"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></option>
				</select>
				<%}else{%>
				<select name="p_order_by_qty_value" id="p_order_by_qty_value">
				<option value="Q"><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></option>
				</select>
				<%}%>
				</td>	
				 
			</tr>


				<tr><td colspan=8>&nbsp;</td></tr>
				</table>

				<table cellpadding="0" cellspacing="0" width="100%"  border="0" align=center>
					<th colspan=8 >
					<fmt:message key="eST.Analysis.label" bundle="${st_labels}"/></th>
					<tr><td colspan=8 >&nbsp;</td></tr>
				<tr>
					<td  class="label" >
					<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
					<td class='fields' >&nbsp;&nbsp;<select name="p_item_anal1" id="p_item_anal1" >
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				    <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";String	desc		=	"";
					arraylist		=	bean.getArrayCodeList();
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
					hmItemCode      	=	(HashMap) arraylist.get(i);
					code				=	(String)hmItemCode.get("CODE");
					desc				=	(String)hmItemCode.get("DESCRIPTION");
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
					<td class='fields' colspan=5>&nbsp;&nbsp;<select name="p_item_anal3" id="p_item_anal3" >
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
</option>
					<%
					for(int i=0;i<arrLength; i++)
					{
					hmItemCode = (HashMap) arraylist.get(i);
					code				=	(String)hmItemCode.get("CODE");
					desc				=	(String)hmItemCode.get("DESCRIPTION");
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>

				</tr>
				<tr>
				<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
				<td class='fields' >&nbsp;&nbsp;<select name="p_item_anal2" id="p_item_anal2" >
<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<%
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("CODE");
						desc				=	(String)hmItemCode.get("DESCRIPTION");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					<td  class="label" ><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/></td>
					<td class='fields' >&nbsp;&nbsp;<select name="p_abc_sel" id="p_abc_sel" >
					<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="A"><fmt:message key="eST.A.label" bundle="${st_labels}"/></option>
					<option value="B"><fmt:message key="eST.B.label" bundle="${st_labels}"/></option>
					<option value="C"><fmt:message key="eST.C.label" bundle="${st_labels}"/></option>
					</select></td>
					
				</tr>
				        
				</table>
				</td>  

				</tr>
			</table>
		
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="ST">
	<input type="hidden" name="p_report_id" id="p_report_id" value="STBPHSHI">

	<input type="hidden" name="p_phy_inv_id" id="p_phy_inv_id" value="">
	
	<input type="hidden" name="mode" id="mode" value="<%=eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="curr_proc_month" id="curr_proc_month" value="<%=curr_proc_month%>">
	<input type="hidden" name="curr_proc_year" id="curr_proc_year" value="<%=curr_proc_year%>">
	<input type='hidden' name="sysdate" id="sysdate" value="<%=bean.getSystemDate().toString()%>">
	
	</form><!-- added form above from below for TFS:23594 -->
	<input type="hidden" name="SQL_ST_STORE_LOOKUP_LANG" id="SQL_ST_STORE_LOOKUP_LANG" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_LANG")%>">
    <input type="hidden" name="SQL_ST_ITEM_LOOKUP_LANG" id="SQL_ST_ITEM_LOOKUP_LANG" 	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" 	 value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
	
	 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


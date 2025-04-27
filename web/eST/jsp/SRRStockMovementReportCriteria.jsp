<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
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
String locale			= (String)session.getAttribute("LOCALE");

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRReportStockMovement.js"></script>  
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		
		String bean_id = "StockMovementReportBean";
		String bean_name = "eST.StockMovementReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		StockMovementReportBean bean = (StockMovementReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);

		String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP WHERE EFF_STATUS = ?","E"));


		 String s_all ="All";
		store_group = store_group.replace("---Select---",s_all);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockMovementReportCriteria" id="formStockMovementReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=9 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				</tr>
				
				<tr>
					<td class=label align=right><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" onChange="loadcolumn(p_report_id);"  tabindex='1'> 
<option  value='STBMOVIT'><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
<option  value='STBMOVST'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option
					</select></td>
				</tr>

				<tr>
				<td align="right" colspan=5>&nbsp;</td>
			</tr>
			<tr>
					<td class=label align=right><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_STORE_GR" id="P_STORE_GR" ><%=store_group%>
					</select></td>
				</tr>
				
	    	<!-- 		<tr>
					<td align="right"  width="30%">&nbsp;</td>
					<td class="fields" width="20%">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td align="right" width="10%">&nbsp;</td>
					<td class="fields" width="40%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>

				 -->
				<tr>
					<td class=label align=right><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value=""  tabindex='2'  ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"  tabindex='3'> <IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" id="p_item_store_style" style="visibility:hidden" ></IMG></td>
					<td class=fields >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value=""  tabindex='4'><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"  tabindex='5'></td>
					<td>&nbsp; </td>
				</tr>
				<tr>
				<td align="right" colspan=5>&nbsp;</td>
			</tr>

			

			<tr>
					<td class=label align=right><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_DRUG_NDRUG" id="P_DRUG_NDRUG" >
					<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></OPTION>
					</select></td>
				</tr>
           <br>
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value=""  tabindex='9'><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"  tabindex='10'></td>
				<!-- 	<td class="label" width="10%">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value=""  tabindex='11'><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?" tabindex='12'></td>
					<td>&nbsp; </td>  -->
				</tr>
				 <br>
				<tr>
					<td class="label" width="30%"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value=""  tabindex='5'><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?" tabindex='6'></td>
					<td class=fields >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value=""  tabindex='7'><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  tabindex='8'></td>
					<td>&nbsp; </td>
				</tr>
				
				<tr>
					<td class=label align=right width="30%"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alp_code size=10 maxlength=10 value=""  tabindex='13' onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class=fields >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_alp_code size=10 maxlength=10 value="" tabindex='14' onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp; </td>
										<td align="right" class="label" colspan = 8>&nbsp;</td>
				</tr>

                  <tr>
				  	<td align="right" class="label" colspan = 8>&nbsp;</td>
				</tr>

				 <tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class=fields >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>2</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td>&nbsp; </td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>3</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				<!-- 	   -->
				   </tr>

				    <tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_ANALY" id="P_ANALY" ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION></SELECT></td>

					<td class=fields>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="P_SUPPLIER" id="P_SUPPLIER" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchsuppliercode(P_SUPPLIER);" type="button" value="?"  ></td>
				</tr>
				<tr>
				<td align="right" colspan=5>&nbsp;</td>
			</tr>
				 <!--
					* @Name - Priya
					* @Date - 31/12/2009
					* @Inc# - IN017730
					* @Desc - removed the function call clearMultipleForm() as no need to clear the form on change of 'Movement calculate by' 
					 -->

				  <tr>
					<td class=label align=right><fmt:message key="eST.MovementCalculateBy.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_MOV_CAL" id="P_MOV_CAL" onChange="loadmovementcalculateby();" >
					<!-- <option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>  -->
					<OPTION VALUE="1" ><fmt:message key="Common.Sale.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="2"><fmt:message key="Common.Sale.label" bundle="${common_labels}"/>+<fmt:message key="eST.IssuetononStockitem.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="3"><fmt:message key="eST.IssueStockNonstock.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="4"><fmt:message key="eST.IssuetoNonStockItem.label" bundle="${st_labels}"/></OPTION></SELECT></td>
					</tr>

				<tr>
					<td class=label align=right><fmt:message key="eST.Excludetheitemsreceivedwithin.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input class="NUMBER" type=text name=P_EXC_MON size=2 maxlength=2 value="" onblur="return CheckNum(P_EXC_MON);" onKeyPress="return isValidInteger();"  tabindex='15'> <fmt:message key="Common.month.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)</td>
				<!-- 	
					<td>&nbsp; </td>  -->

						<td class=fields>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Top.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type="text" class="NUMBER" name="P_COUNT" id="P_COUNT" maxLength="8" size="8" onKeyPress="return isValidInteger();"  onBlur="checkIntegerFormat(this);"  tabindex='17'> <fmt:message key="Common.item.label" bundle="${common_labels}"/>(<fmt:message key="eST.S.label" bundle="${st_labels}"/>)<fmt:message key="Common.by.label" bundle="${common_labels}"/>
						<select name="P_COUNT_BY" id="P_COUNT_BY" >
				<option value="trn_qty1_desc"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
				<option value="trn_value1_desc"><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></option>
				</select></td>



					</tr>
					<tr>
					<td class=label align=right><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="p_report_option" id="p_report_option" tabindex='17'>
					<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="M"><fmt:message key="eST.MovedItemsOnly.label" bundle="${st_labels}"/></option>
					<option value="N"><fmt:message key="eST.NonMovedItemsOnly.label" bundle="${st_labels}"/></option>
					</select></td>

					<td class=fields >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name=P_ORDER_BY  tabindex='16'>
						<option value="trn_qty1_desc"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option value="Item_code"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
						<option value="item_desc"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					</select></td>
					
					</tr>
			
			<tr></tr>
			<tr></tr>
			</table>
			

			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>

			<tr>

			
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="eST.MovementCutoffDaysSlotRange.label" bundle="${st_labels}"/></th>
				
				<tr>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 1</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 2</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 3</td>
					<td   class="fields" width="20%"><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 4</td>
				</tr>

				<tr>
					<td class=fields >&nbsp;&nbsp;<input type=text name=p_fr_date1 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_date1');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date2 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_date2');" ></img>&nbsp;</td>

					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date3 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_date3');" ></img>&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_date4 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_date4');" ></img>&nbsp;</td>

				</tr>

					<tr>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date1 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date1');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date2 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date2');" ></img>&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date3 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date3');" ></img>&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_to_date4 size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date4');" ></img>&nbsp;</td>

				</tr>
			
				</table>
				</td>
				</tr>

	</table>			
				<tr></tr>
	</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			 
</form>

<input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LOOKUP" id="SQL_AP_SUPPLIER_SELECT_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">

<%
putObjectInBean(bean_id,bean,request);
%>
		
	</body>
</html>	


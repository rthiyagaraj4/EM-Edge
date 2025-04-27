<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
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

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRStockHoldingAnalysis.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "StockHoldingAnalysisBean";
		String bean_name = "eST.StockHoldingAnalysisBean";
		String p_report_id = "STBSTHLD";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		StockHoldingAnalysisBean bean = (StockHoldingAnalysisBean)getBeanObject( bean_id,bean_name, request );  
		bean.clear();
		
bean.setLanguageId(locale);
boolean b=false;

	   String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP WHERE EFF_STATUS = ?","E",b));

	  // String s_all ="All";
	  // out.println(store_group);
		//store_group = store_group.replace("---Select---",s_all+"   ").trim();
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockHoldingAnalysis" id="formStockHoldingAnalysis" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<BR>
			</br>
						<BR>
			</br>			<BR>
			</br>

			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
			<!-- 	<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td  >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

			 -->
			 <tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

			<tr>
				<td class=label align=right><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<select name="P_REPORT_BY" id="P_REPORT_BY" > 
				<option  value='IT'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
				<option  value='ST'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option></td>
			</tr>
			<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>
			<tr>
					<td class=label align=right><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_group" id="p_store_group" >
					<OPTION VALUE=" "><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<%=store_group%>
					</select></td>
				</tr>
				<!--
					* @Name - Priya
					* @Date - 31/12/2009
					* @Inc# - IN018071
					* @Desc - look up Store code from and to is added in query criteria as per the report document 
					 -->
				<tr>
					<td class=label align=right><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				

				<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

			<tr>
					<td class=label align=right><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_drug_medical_supply" id="p_drug_medical_supply" >
					<OPTION VALUE="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="M"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></OPTION>
					</select></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=5 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=5 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label" align=right><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

				<tr>
					<td class=label align=right><fmt:message key="eST.StockAvailability.label"   bundle="${st_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fm_ava_stk size=6 maxlength=6 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this, false);chkMonth(this); "><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_ava_stk size=6 maxlength=6 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this, false); chkMonth(this);"><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="eST.ConsumptionPeriod.label"   bundle="${st_labels}"/> </td>
					<!-- 					
						* @Name - Priya
						* @Date - 09/04/2010
						* @Inc# - 
						* @Desc - To allow 2 no fo dogits in p_cons_period		
					-->
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_cons_period size=5 maxlength=5 class="NUMBER" value="12" onKeyPress="return isValidNumber(this, event, 2, 0);" onblur="checkDoubleFormat(this, false); "><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;</td><td class=label colspan=5>&nbsp;&nbsp;</td>
				</tr>
			<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

							
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>  3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				    
				</tr>
			<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

			<tr>
					<td class=label align=right><fmt:message key="eST.AverageUsageCalculateBy.label"   bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_averageusagecalculateby" id="p_averageusagecalculateby" >
					<option value ='S'><fmt:message key="Common.Sale.label" bundle="${common_labels}"/></option>
					<option  value='SI'><fmt:message key="eST.SaleIssue.label"   bundle="${st_labels}"/></option>
					</select></td>
				   
				</tr>

				
				
				
				<tr>

				<tr>
			   <td class=label align=right><fmt:message key="eST.SuppressZero.label" bundle="${st_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<select name="P_SuppressZero" id="P_SuppressZero" >
					<OPTION VALUE="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<option value ='Z'><fmt:message key="eST.Zero.label" bundle="${st_labels}"/></option>
					<option  value='NZ'><fmt:message key="eST.NonZero.label" bundle="${st_labels}"/></option>
					</select></td>


					<td class="label">&nbsp;<fmt:message key="Common.Nature.label" bundle="${mm_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<option value ='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='E'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					</select></td>
				 
				</tr>
					
				<tr>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
				  <td align="right" class="label" >&nbsp;</td>
                </tr>

				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%=p_report_id%>">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT" id="SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT" id="SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_STERILE_SELECT_FOR_REPORT" id="SQL_ST_STERILE_SELECT_FOR_REPORT" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STERILE_SELECT_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
				<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


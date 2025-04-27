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
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRStockLevelReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "StockLevelReportBean";
		String bean_name = "eST.StockLevelReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		StockLevelReportBean bean = (StockLevelReportBean) getBeanObject( bean_id,bean_name , request );  
		bean.clear();
		bean.setLanguageId(locale);
		

		String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = ? and language_id=? order	by short_desc",new String[]{"E",locale}));
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockLevelReportCriteria" id="formStockLevelReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				
			<!-- 	<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				 -->
				 
				<tr>
				<td class=label align=right><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<select name="p_report_idS" id="p_report_idS" > <option  value='STBCONS1'>
				<fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
				<option  value='STBCONS2'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
				</select></td>
				</tr>
				<tr>
				<td align="right" colspan=8>&nbsp;</td>
				</tr>
				<tr>
				<td class=label align=right><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_group" id="p_store_group" ><%=store_group%>
				</select></td>
				</tr>
				<tr>
				<td class=label align=right><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
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
				<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
				<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				
				<tr>
				<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fr_alp_code" id="p_fr_alp_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_alp_code" id="p_to_alp_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

				<tr>
				<td align="right" colspan=8>&nbsp;</td>
		     	</tr>
					
				<tr>
				<td class=label align=right><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></td>
				<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_st_val size=10 maxlength=10 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this); "></td>
				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_st_val size=10 maxlength=10 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this); "></td>
				</tr>
				<tr>
				<td align="right" colspan=8>&nbsp;</td>
			    </tr>

				<tr>
				<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
				<td class=fields >&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				ArrayList	arraylist		=	null;
				HashMap		hmItemCode		=	null;	
				String code = "";String	desc		=	"";

				arraylist		=	bean.getArrayCodeList();
				int arrLength		=	arraylist.size();
				for(int i=0;i<arrLength; i++)
				{
				hmItemCode      	=	(HashMap) arraylist.get(i);

				code				=	(String)hmItemCode.get("code");
				desc				=	(String)hmItemCode.get("desc");

				%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
				</select></td>

				<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>2</td>
				<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				for(int i=0;i<arrLength; i++)
				{
				hmItemCode      	=	(HashMap) arraylist.get(i);

				code				=	(String)hmItemCode.get("code");
				desc				=	(String)hmItemCode.get("desc");

				%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
				</select></td>
				</tr>
				<tr>

				<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>3</td>
				<td class=fields >&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
				<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				for(int i=0;i<arrLength; i++)
				{
				hmItemCode      	=	(HashMap) arraylist.get(i);

				code				=	(String)hmItemCode.get("code");
				desc				=	(String)hmItemCode.get("desc");

				%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
				</select></td>
                    </tr>
					<tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_abc_analysis" id="p_abc_analysis" ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION></SELECT></td>
				   </tr>
				   <tr>
				   <td align="right" colspan=8>&nbsp;</td>
			       </tr>

					<tr>
					<td class=label align=right><fmt:message key="eST.StockPositionof.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_stk_pt" id="p_stk_pt" >
					<option value="A" ><fmt:message key="eST.AllStores.label" bundle="${st_labels}"/></option>
					<option value="Y" ><fmt:message key="eST.ReorderableStoresstock.label" bundle="${st_labels}"/></option>
					<option value="N" ><fmt:message key="eST.NonReorderableStoresStock.label" bundle="${st_labels}"/></option>
					</select></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="eST.ItemSelection.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" > 
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option  value='Z'><fmt:message key="eST.ZeroStock.label" bundle="${st_labels}"/></option>
					<option  value='N'><fmt:message key="eST.NonZeroStock.label" bundle="${st_labels}"/></option>
					<option  value='M'><fmt:message key="eST.ItemLessthanMinimumLevel.label" bundle="${st_labels}"/></option>
					<option  value='R'><fmt:message key="eST.ItemLessthanReorderLevel.label" bundle="${st_labels}"/></option>
					</select></td>
				   </tr>
				
					<tr>
					<td class=label align=right><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<option  value='1'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					<option  value='2'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>

					</select></td>

					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.Nature.label" bundle="${mm_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<select name="p_eff_status" id="p_eff_status" > 
					<option value ='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					<option  value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					</select></td>
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

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBSTKL1">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		</form>
			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


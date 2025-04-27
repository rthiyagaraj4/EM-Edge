<!DOCTYPE html>
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
	<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRPurchaseAdviceReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "StockLevelReportBean";
		String bean_name = "eST.StockLevelReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		StockLevelReportBean bean = (StockLevelReportBean)getBeanObject( bean_id, bean_name, request );
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formPurchaseAdviceReportCriteria" id="formPurchaseAdviceReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				<tr>
				 <td align="right" class="label" colspan =8>&nbsp;</td>
				 </tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_drug_nondrug" id="p_drug_nondrug" >
						<option value=''><fmt:message key="Common.all.label" bundle="${mm_labels}"/></option>
						<option  value='Y'><fmt:message key="Common.Drug.label" bundle="${mm_labels}"/></option>
						<option  value='N'><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				
				<tr>
					<td   class="label" ><fmt:message key="Common.SpecialItem.label" bundle="${common_labels}"/></td>
					<td class=fields  >&nbsp;&nbsp;<select name="p_spl_item" id="p_spl_item" >
					<option value ='A'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='Y'><fmt:message key="Common.SpecialItem.label" bundle="${common_labels}"/></option>
					<option  value='N'><fmt:message key="eST.NonSpecialItem.label" bundle="${st_labels}"/></option>
					</select></td>
					<td   class="label" ><fmt:message key="eST.ItemSelection.label" bundle="${st_labels}"/></td>
					<td class=fields  COLSPAN=5>&nbsp;&nbsp;<select name="p_item_sel" id="p_item_sel" > 
				<option value='A'> <fmt:message key="eST.AllItems.label" bundle="${st_labels}"/> </option>
				<option value='R'><fmt:message key="eST.BelowRe-OrderLevel.label" bundle="${st_labels}"/> </option>
				<option value='M'> <fmt:message key="eST.BelowMinimumStockLevel.label" bundle="${st_labels}"/> </option>
				<option value='Z'> <fmt:message key="eST.ZeroStock.label" bundle="${st_labels}"/> </option>
<!-- 			<option value=' '> Consignmet Items </option> -->

					</select></td>
                 <!--Added by Rabbani #INC NO:37176 on 08/01/2013 -->
                 <tr>
			     <td class=label align=right><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
			     <td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
			     <td class="fields"  >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			    <td class=fields >&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
			     </tr>
					<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class="fields"  >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>

				<tr>
				 <td align="right" class="label" colspan =8>&nbsp;</td>
				 </tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fr_alp_code" id="p_fr_alp_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_alp_code" id="p_to_alp_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
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
				
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
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
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 3</td>
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
				 <td align="right" class="label" colspan =8>&nbsp;</td>
				 </tr>

				 <tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_abc_analysis" id="p_abc_analysis" ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option><OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION>
					
					</select></td>
						<td  class="label" ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
				<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_supplier_code" id="p_supplier_code" value="" ><input class="button" name="p_fr_sr" id="p_fr_sr" onClick="return searchsuppliercode(p_supplier_code);" type="button" value="?"  ></td>
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="eST.ShowBatchInfo.label" bundle="${st_labels}"/></td>
					<td align="left" >&nbsp;<input type="checkbox" value="E" name="p_batch_info" id="p_batch_info"></td>
					
					<td  class="label" width="20%"><fmt:message key="eST.StockPositionof.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_stk_pt" id="p_stk_pt" >
					<option value="A" ><fmt:message key="eST.AllStores.label" bundle="${st_labels}"/></option>
<option value="Y" ><fmt:message key="eST.ReorderableStoresstock.label" bundle="${st_labels}"/></option>
<option value="N" ><fmt:message key="eST.NonReorderableStoresStock.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
                
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBPUADV">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
		</form>
			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP_FOR_PUR_AD")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			  <input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LOOKUP" id="SQL_AP_SUPPLIER_SELECT_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LOOKUP")%>">
			  <!--Added by Rabbani #INC NO:37176 on 08/01/2013 -->
			  <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			  

			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


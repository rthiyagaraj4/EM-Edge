<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRMonthlySummaryReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "MonthlySummaryReportBean";
		String bean_name = "eST.MonthlySummaryReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		
		
		MonthlySummaryReportBean bean = (MonthlySummaryReportBean) getBeanObject(bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		String []stParameters=	{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
		String curr_proc_month=(String)hmRecord.get("CURR_PROC_MONTH");
		String curr_proc_year =(String)hmRecord.get("CURR_PROC_YEAR"); 
		curr_proc_year = com.ehis.util.DateUtils.convertDate(curr_proc_year,"YY","en",locale);//modified by chandrashekar.a on 16/2/2011 for getting thai date

		String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP WHERE EFF_STATUS = ?","E"));

		StockLevelReportBean bean1 = (StockLevelReportBean)getBeanObject( "StockLevelReportBean", "eST.StockLevelReportBean",request) ; bean1.clear();
		bean1.setLanguageId(locale); 

	%>
	<body onLoad="FocusFirstElement();">
		<form name="MonthlySummaryReportCriteria" id="MonthlySummaryReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
				    <td  class="label" width="20%" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" onChange="loadcolumn(this),clearMultipleForm();"> 
<option  value='STBMTSM1'><fmt:message key="eST.ItemClassConsolidated.label" bundle="${st_labels}"/></option>
<option  value='STBMTSM2'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
<option  value='STBMTSM3'><fmt:message key="eST.StoreItem.label" bundle="${st_labels}"/></option>
<option  value='STBMTSM4'><fmt:message key="eST.StoreItemClass.label" bundle="${st_labels}"/></option>
					</select></td>
				
				</tr>

			<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>
				<!--  <tr>
					<td align="right">&nbsp;</td>
					<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td  class="fields" colspan=5 width"10%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				 -->

				 	<tr>
					<td class=label align=right><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_group" id="p_store_group" disabled><%=store_group%>
					</select></td>
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code" disabled value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" disabled value="?"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 disabled name="p_to_str_code" id="p_to_str_code" value="" disabled><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" disabled ></td>
				</tr>
				<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

			<tr>
					<td class=label align=right><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_drug_medical_supply" id="p_drug_medical_supply"  disabled>
					<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></OPTION>
					</select></td>
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td class=label align=right><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 disabled name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?" disabled></td>
					<td class=fields >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 disabled name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?" disabled ></td>
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
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 1</td>
					<td class=fields>&nbsp;&nbsp;<SELECT name="p_item_anal1_code1" id="p_item_anal1_code1" disabled><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";String	desc		=	"";

					arraylist		=	bean1.getArrayCodeList();
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("code");
						desc				=	(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					<td class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<SELECT name="p_item_anal1_code2" id="p_item_anal1_code2" disabled><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
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
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>  3</td>
					<td class=fields>&nbsp;&nbsp;<SELECT name="p_item_anal1_code3" id="p_item_anal1_code3" disabled><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
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
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_abc_analysis" id="p_abc_analysis"  ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION></SELECT></td>
				</tr>

				<tr>
				<td align="right" colspan=8>&nbsp;</td>
			</tr>

				<tr>	
					<td class=label align=right><fmt:message key="eST.Accounting.label" bundle="${st_labels}"/>&nbsp;<fmt:message key="Common.Month/Year.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_month" id="p_month" value="<%=curr_proc_month%>" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_year" id="p_year" value="<%=curr_proc_year%>" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
				   <td class="label">&nbsp;<fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
			<%if(((String)bean.getAccessCostDetails()).equals("Y")){%>
					<td class=fields colspan=5 >&nbsp;&nbsp;<select name="P_REPORT_OPTION" id="P_REPORT_OPTION" disabled>	
						<option  value='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option  value='Q'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option  value='CV'><fmt:message key="eST.CostValue.label" bundle="${st_labels}"/></option>
					</select></td>
			<%}else{%>
					<td class=fields colspan=5 >&nbsp;&nbsp;<select name="P_REPORT_OPTION" id="P_REPORT_OPTION" disabled>	
						<option  value='Q'><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
					</select></td>
			<%}%>
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
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="curr_proc_month" id="curr_proc_month"		value="<%=curr_proc_month%>">
			<input type="hidden" name="curr_proc_year" id="curr_proc_year"		value="<%=curr_proc_year %>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


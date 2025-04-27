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
	<!-- 	<link rel="stylesheet" type "text/css"
		href="../../eCommon/html/IeStyle.css"></link> -->
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
		<script language="javascript" src="../../eST/js/RecalculateStoreStockLevelCriteria.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "RecalculateItemStockLevel";
		String bean_name = "eST.RecalculateItemStockLevel";
//		String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
				
		RecalculateItemStockLevel bean = (RecalculateItemStockLevel) getBeanObject( bean_id, bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="RecalculateStoreStockLevelCriteria" id="RecalculateStoreStockLevelCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<!-- <tr>
					<td align="right" class="label">Store Code</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value=""><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label"></td>
					<td class=label colspan=9><input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr> -->
				<tr>
					<td align="left" class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button" name="p_fr_sr" id="p_fr_sr" onClick="return searchCodeStore(p_fr_st_code);" type="button" value="?"></td>
					<td class=fields colspan=6>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" name="p_to_sr" id="p_to_sr" onClick="return searchCodeStore(p_to_st_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class=fields colspan=6>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td class=fields colspan=6>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				
				
				<tr>
					<td class=label align=left><fmt:message key="eST.ConsumptionPeriod.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<input type=text name=p_cons_per id=p_cons_per size=4 maxlength=2 class="NUMBER" value="" onKeyPress="return isValidInteger();" ><%=bean.getImage("M")%></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<input type=text name=p_lead_days id=p_lead_days size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.MinStockDays.label"   bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<input type=text name=p_min_stk_days id=p_min_stk_days size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
				</tr>
				<tr>
					<td class=label align=left>% <fmt:message key="eST.ofMinStock.label"   bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<input type=text name=p_buffer_perc id=p_buffer_perc size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
				</tr>

				<tr>
					<td align="left" class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<select name="p_order_type" id="p_order_type" >
					<option value='I'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
        <option value='S'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td align="left" class="label" ><fmt:message key="eST.IncludeStockIssues.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=7>&nbsp;<input name="p_stk_issue" id="p_stk_issue" type='checkbox' checked value='Y'>
					</td>
				</tr>
				<tr>
					<td class=label align=right></td>
					<td class=label colspan=7>&nbsp;&nbsp;</td>
				</tr>
		<!--		<tr>
					<td align="right" class="label">Process Option</td>
					<td class=label>
					<INPUT type=radio name=p_process_option id=p_process_option CHECKED  value="R">Report Only<INPUT type=radio name=p_process_option id=p_process_option   value="PR" >Process & Report<td align="right" class="label"></td>
					<td class=label><td align="right" class="label"></td>
					<td class=label>&nbsp;&nbsp;
					<td class="label">&nbsp;</td>
				</tr>-->
			   
			<tr>
					<td class=label align=right></td>
					<td class=label colspan=7>&nbsp;&nbsp;</td>
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
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBCASL2">	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
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


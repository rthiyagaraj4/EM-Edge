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
		<script language="javascript" src="../../eST/js/StockHoldingAnalysis.js"></script>
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
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td  >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=5 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=5 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.StockAvailability.label"   bundle="${st_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fm_ava_stk id=p_fm_ava_stk size=6 maxlength=6 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this, false);chkMonth(this); "><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;</td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_ava_stk id=p_to_ava_stk size=6 maxlength=6 class="NUMBER" value="" onKeyPress="return isValidNumber(this, event, 10, 2);" onblur="checkDoubleFormat(this, false); chkMonth(this);"><fmt:message key="Common.months.label" bundle="${common_labels}"/></td>
				</tr>
							
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
					<td class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>  3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				    <td align="right" class="label" ></td>
					<td class=label >&nbsp;&nbsp</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eST.ConsumptionPeriod.label"   bundle="${st_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_cons_period id=p_cons_period size=5 maxlength=5 class="NUMBER" value="12" onKeyPress="return isValidNumber(this, event, 1, 0);" onblur="checkDoubleFormat(this, false); "></td>
					<td class="label">&nbsp;</td><td class=label colspan=5>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<option value ='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='E'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					</select></td>
				    <td align="right" class="label" ></td>
					<td class=label >&nbsp;&nbsp;</td>
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


<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ExpiryAnalysis.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<%
		
		String bean_id					=		"ReportsStockStatusBean";
		String bean_name				=		"eST.ReportsStockStatusBean";
		//String p_report_id			=		null;
		
		
		ReportsStockStatusBean bean		=		(ReportsStockStatusBean) getBeanObject( bean_id,bean_name,request);  
		String facility_id				=		bean.getLoginFacilityId();
		String user_name				=		bean.getLoginById();
		//bean.clear();
		bean.setLanguageId(locale);
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formExpiryAnalysisCriteria" id="formExpiryAnalysisCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td  class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
					<td colspan='3'>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" tabindex='1'>
					<option  value='STBEXPIT'><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/></option>
					<option  value='STBEXPST'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td  >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td colspan='2' class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" class='UPPER'  tabindex='2'><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"  tabindex='3'></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" class="UPPER" tabindex='4'><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"  tabindex='5'></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td colspan=2 class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" class="UPPER"  tabindex='6'><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"  tabindex='7'></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" class="UPPER" tabindex='8'><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?" tabindex='9'></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemClassCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" class="UPPER" tabindex='10'><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"  tabindex='11'></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value=""  class="UPPER" tabindex='12'><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?" tabindex='13'></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type=text name=p_fm_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);" tabindex='14'></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);" tabindex='15'></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>

			<tr>
				<th colspan=4 align=left><fmt:message key="eST.ExpiryCutoffDays.label"   bundle="${st_labels}"/></th>
				</tr>
				<tr>
					<td colspan=4 align=center>
					<table align='center' cellpadding=0 cellspacing=0 border=0 align=center width='100%'>
						<tr>
							<td class='fields' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 1</b>
							</td>
							<td class='fields' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 2</b>
							</td>
							<td class='fields' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 3</b>
							</td>
							<td class='fields' align='center'><b><fmt:message key="Common.Slot.label" bundle="${common_labels}"/> 4</b>
							</td>
						</tr>
						<tr>
							<td align='center' class='fields'><input type='text' name="p_fm_slot_1_1_a" id="p_fm_slot_1_1_a"  onBlur="CheckDate(this,'<%=locale%>');"  maxlength=10 size=10 tabindex='16'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_slot_1_1_a');" tabindex='17'></img>
							<img src="../../eCommon/images/mandatory.gif" align=center>
							</td>
							<td align='center' class='fields'><input type='text' name="p_fm_slot_2_1_a" id="p_fm_slot_2_1_a"  onBlur="CheckDate(this,'<%=locale%>');"  maxlength=10 size=10 tabindex='20'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_slot_2_1_a');" tabindex='21'></img>
							</td>
							<td align='center' class='fields'><input type='text' name="p_fm_slot_3_1_a" id="p_fm_slot_3_1_a"  onBlur="CheckDate(this,'<%=locale%>');" maxlength=10 size=10 tabindex='24'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_slot_3_1_a');" tabindex='25'></img>
							</td>
							<td align='center' class='fields'><input type='text' name="p_fm_slot_4_1_a" id="p_fm_slot_4_1_a"  onBlur="CheckDate(this,'<%=locale%>');"  maxlength=10 size=10 tabindex='28'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_slot_4_1_a');" tabindex='29'></img>
							</td>
						</tr>
						<tr>
							<td align='center' class='fields'><input type='text' name="p_to_slot_1_1_a" id="p_to_slot_1_1_a"  onBlur="CheckDate(this,'<%=locale%>');" maxlength=10 size=10 tabindex='18'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_slot_1_1_a');" tabindex='19'></img><img src="../../eCommon/images/mandatory.gif" align=center>
							</td>
							<td align='center' class='fields'><input type='text' name="p_to_slot_2_1_a" id="p_to_slot_2_1_a"  onBlur="CheckDate(this,'<%=locale%>');" maxlength=10 size=10 tabindex='22'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_slot_2_1_a');" tabindex='23'></img>
							</td>
							<td align='center' class='fields'><input type='text' name="p_to_slot_3_1_a" id="p_to_slot_3_1_a"  onBlur="CheckDate(this,'<%=locale%>');" maxlength=10 size=10 tabindex='26'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_slot_3_1_a');" tabindex='27'></img>
							</td>
							<td align='center' class='fields'><input type='text' name="p_to_slot_4_1_a" id="p_to_slot_4_1_a"  onBlur="CheckDate(this,'<%=locale%>');"  maxlength=10 size=10 tabindex='30'>
							<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_slot_4_1_a');" tabindex='31'></img>
							</td>
						</tr>
					</table>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="p_fm_slot_1_1" id="p_fm_slot_1_1" 						value="">
			<input type="hidden" name="p_fm_slot_2_1" id="p_fm_slot_2_1" 						value="">
			<input type="hidden" name="p_fm_slot_3_1" id="p_fm_slot_3_1" 						value="">
			<input type="hidden" name="p_fm_slot_4_1" id="p_fm_slot_4_1" 						value="">
			<input type="hidden" name="p_to_slot_1_1" id="p_to_slot_1_1" 						value="">
			<input type="hidden" name="p_to_slot_2_1" id="p_to_slot_2_1" 						value="">
			<input type="hidden" name="p_to_slot_3_1" id="p_to_slot_3_1" 						value="">
			<input type="hidden" name="p_to_slot_4_1" id="p_to_slot_4_1" 						value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			<input type="hidden" name="p_fm_slot_1" id="p_fm_slot_1"							value="01/01/1800">
			<input type="hidden" name="p_fm_slot_2" id="p_fm_slot_2"							value="01/01/1800">
			<input type="hidden" name="p_fm_slot_3" id="p_fm_slot_3"							value="01/01/1800">
			<input type="hidden" name="p_fm_slot_4" id="p_fm_slot_4"							value="01/01/1800">
			<input type="hidden" name="p_to_slot_1" id="p_to_slot_1"							value="01/01/1800">
			<input type="hidden" name="p_to_slot_2" id="p_to_slot_2"							value="01/01/1800">
			<input type="hidden" name="p_to_slot_3" id="p_to_slot_3"							value="01/01/1800">
			<input type="hidden" name="p_to_slot_4" id="p_to_slot_4"							value="01/01/1800">
            

		</form>
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"						value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	


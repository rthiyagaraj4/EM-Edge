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

String sterile_disabled		=	"disabled";

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
		<!-- <script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id					=		"reportsMasterCodeBean";
		String bean_name				=		"eST.ReportsMasterCodeBean";
		String p_report_id				=		"STBITEMS";
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		
		

		ReportsMasterCodeBean bean		=		(ReportsMasterCodeBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		
		bean.setLanguageId(locale);

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formReportItem" id="formReportItem" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left>
				<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?">
					 <!-- Added  for the ML-MMOH-CRF-0915 Starts --> 
					<input type="hidden" name="p_fm_item_desc" id="p_fm_item_desc" id="p_fm_item_desc" value="" >  
					<input type="hidden" name="p_to_item_desc" id="p_to_item_desc" id="p_to_item_desc" value="" >
					 <!-- Added  for the ML-MMOH-CRF-0915 ends-->  
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=4 size=20 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" > <input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=4 size=20 name="p_to_item_class_code" id="p_to_item_class_code" value="" > <input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.MachineCode.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_machine_code" id="p_fm_machine_code" value="" > <input class="button" onClick="return searchMachineCode(p_fm_machine_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_machine_code" id="p_to_machine_code" value="" > <input class="button" onClick="return searchMachineCode(p_to_machine_code);" type="button" value="?"></td>
				</tr>
                <tr>
					<td  class="label"><fmt:message key="eST.ModelNo.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_model_no" id="p_fm_model_no" value="" ></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_model_no" id="p_to_model_no" value="" ></td>
				</tr>
                <tr>
					<td  class="label"><fmt:message key="eST.PartNumber.label" bundle="${st_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_part_no" id="p_fm_part_no" value="" ></td>
					<td class="label">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_part_no" id="p_to_part_no" value="" ></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.SterileType.label" bundle="${common_labels}"/></td>
					<td class="fields" colspan=3>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_sterile_type" id="p_sterile_type" value="" <%=sterile_disabled%> > <input class="button" onClick="return searchSterileType(p_sterile_type);" type="button" value="?" <%=sterile_disabled%>></td>
				</tr>

              <!--   <tr>
					<td align="right" class="label">&nbsp;</td>
					<td class=label align="left">&nbsp;&nbsp;Analysis 1</td>
					<td class=label align="left">&nbsp;&nbsp;Analysis 2</td>
					<td class=label align="left">&nbsp;&nbsp;Analysis 3</td>
				</tr> -->
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
					<td class="fields">&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2</td>
					<td class="fields">&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
					<td class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
					<td class="fields">&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				    <td class="label" ><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_expiry_yn" id="p_expiry_yn" >
					<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option  value='Y'><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></option>
					<option  value='N'><fmt:message key="eST.NonExpiryItems.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_nature" id="p_nature" >
					<option value ='B'><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></option>
					<option  value='E'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></option>
					</select></td>

				    <td class="label" ><fmt:message key="Common.orderBy.label"  bundle="${common_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<option  value='1'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
					<option  value='2'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </option>
					</select></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" onChange="setReportItemId()" > 
						<option  value='1'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						<option  value='D'><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					</select></td>
					
					<!-- Added for the ML-MMOH-CRF-0915 Starts -->
					 <td class="label" ><fmt:message key="Common.ReportBy.label"  bundle="${common_labels}"/></td>
					<td class="fields" >&nbsp;&nbsp;<select name="p_Search_by" id="p_Search_by" >
					<option  value='C'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
					<option  value='D'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </option>
					</select></td>
					<!-- Added for the ML-MMOH-CRF-0915 ends -->
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
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 			value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 			value="<%=p_report_id%>">
			<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
		</form>
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"						value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ALPHA_LOOKUP" id="SQL_ST_ALPHA_LOOKUP"						value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ALPHA_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT" id="SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_MACHINE_CODE_LOOKUP_FOR_REPROT")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT" id="SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_STERILE_SELECT_FOR_REPORT" id="SQL_ST_STERILE_SELECT_FOR_REPORT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STERILE_SELECT_FOR_REPORT")%>">
<%	



putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


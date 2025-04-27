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
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eMM/js/ItemsNotCreated.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"MonthlySummaryReportBean";
		String bean_name			=		"eST.MonthlySummaryReportBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		MonthlySummaryReportBean bean =		(MonthlySummaryReportBean) getBeanObject(bean_id,bean_name,request);  
		String user_id=bean.getLoginById();
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
		
			   

	  
		
	%>
		<body onLoad="FocusFirstElement()">
<!-- 	SQL_ST_TRN_TYPE_SELECT_LIST -->
		<form name="ItemsNotCreatedReportCriteria" id="ItemsNotCreatedReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
		<tr>
		<td width='60%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=5 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

       </tr>
       <tr>
				<td align="right"></td>
				<td class="fields"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td align="right" >
				<td class="fields"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	    </tr>
		<tr>
				<td align="right" class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}"/>
				</td>
				<td class=fields>
				<input type="text" name="dt_from_1" id="dt_from_1" size="10" maxlength="10" onBlur="CheckDate(this);">
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from_1');" ></img> 
				<img src="../../eCommon/images/mandatory.gif" align='center'></img>
				&nbsp;&nbsp;</td>
				<td class="fields"></td><td class=fields>	
			    &nbsp;<input type="text" name="dt_to_1" id="dt_to_1" size="10" maxlength="10" onBlur="CheckDate(this);checkDocDate(document.forms[0]);" >
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to_1');" ></img>
					
				</td>
						
			</tr>
			<br>
			
				<tr>
					<td class="label"><fmt:message key="eMM.InterfaceItemCode.label" bundle="${mm_labels}"/></td>
					<td class=fields><input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label"></td>
				<td class=field>&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
				</tr>
	          <!--    <tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/> </td>
					<td class=fields><input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class="label"></td>
					<td class=fields>&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr> -->
	<tr>
						
					<td class="label"><fmt:message key="eMM.InterfaceMaterialGroupCode.label" bundle="${mm_labels}"/></td>
					<td class=fields><select name="p_material_group_code" id="p_material_group_code" >
					<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					<option value='N'><fmt:message key="eMM.Non-Drug.label" bundle="${mm_labels}"/></option>
		            </select>
					</td>

				</tr>
		
	</table>		
	</td>
	</tr>
	</table>
	
	<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="MM">
			<input type="hidden" name="dt_from" id="dt_from" 							value="">
			<input type="hidden" name="dt_to" id="dt_to" 								value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"							value="MMITMLIST">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
		    <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		    <input type="hidden" name="SQL_ST_ITEM_LOOKUP_NEW" id="SQL_ST_ITEM_LOOKUP_NEW"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP_NEW")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	
				
	
	
		
		


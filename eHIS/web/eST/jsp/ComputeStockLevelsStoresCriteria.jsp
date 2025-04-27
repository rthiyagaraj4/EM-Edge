<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@  page import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*, java.sql.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@	 include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@  include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale					=		 (String)session.getAttribute("LOCALE");
		
		String sStyle					=		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eST/js/StCommon.js"></script>
			<script language="javascript" src="../../eST/js/ComputeStockLevelsStores.js"></script>
			<!-- <script language='javascript' src='../../eST/js/MonthlySummaryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
   -->
	</head>
	<%
		
		String bean_id						 =		 "ComputeStockLevelsStoresBean";
		String bean_name					 =		 "eST.ComputeStockLevelsStoresBean";
		//String p_report_id				 =		  null;
		String facility_id					 =		 (String) session.getValue( "facility_id" ) ;
	//	String user_name					 =		 (String) session.getValue( "login_user" ) ;
		
		String	store_code					 =	 (request.getParameter( "store_code" ) !=null ? (request.getParameter("store_code").trim()):"" );
		//String	store_desc					 =	 (request.getParameter( "store_desc" ) !=null ? (request.getParameter("store_desc").trim()):"" );
		String	fm_item_class_code			 =	 (request.getParameter( "fm_item_class_code" ) !=null ? (request.getParameter("fm_item_class_code").trim()):"" );
		//String	fm_item_class_desc			 =	 (request.getParameter( "fm_item_class_desc" ) !=null ? (request.getParameter("fm_item_class_desc").trim()):"" );
		//String	fm_item_desc				 =	 (request.getParameter( "fm_item_desc" ) !=null ? (request.getParameter("fm_item_desc").trim()):"" );
		String	fm_item_code			 =	 (request.getParameter( "fm_item_code" ) !=null ? (request.getParameter("fm_item_code").trim()):"" );
		ComputeStockLevelsStoresBean bean	 =	(ComputeStockLevelsStoresBean) getBeanObject( bean_id, bean_name,request);  
		bean.setLanguageId(locale);
		bean.clear();
		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formComputeStockLevelsStoresCriteria" id="formComputeStockLevelsStoresCriteria" action="../../eST/jsp/ComputeStockLevelsStoresResult.jsp"  target="frameComputeStockLevelsStoresResult"  onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0"  align="center" border="0" width='100%'>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;
					<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
					<td class="label">&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label">
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;
					<input maxLength=20 size=20 name="fm_item_code" id="fm_item_code" value="<%=fm_item_code%>" >
					<input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(fm_item_code);" type="button" value="?"></td>
					<td align="right">&nbsp;<!-- <input type="hidden" name="fm_item_code" id="fm_item_code" value = "<%=fm_item_code%>" > --></td>
					<td>&nbsp;&nbsp;
					<input maxLength=20 size=20  name="to_item_code" id="to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(to_item_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label">
					<fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
					<input maxLength=15 size=15 name="fm_item_class_code" id="fm_item_class_code" value="<%=fm_item_class_code%>" >
					<input class="button" onClick="return searchCodeItemClass(fm_item_class_code);" type="button" value="?" name="s1" id="s1"><!-- <input type="hidden" name="fm_item_class_code" id="fm_item_class_code" value = "<%=fm_item_class_code%>" > --></td>
					<td align="right">&nbsp;</td>
					<td >&nbsp;&nbsp;
					<input maxLength=15 size=15 name="to_item_class_code" id="to_item_class_code" value="" >
					<input class="button" onClick="return searchCodeItemClass(to_item_class_code);" type="button" value="?" name='s2' id='s2'></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label">
					<fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
					<input maxLength=15 size=15 name="store_code" id="store_code" value="<%=store_code%>" >
					<input class="button" onClick="return searchCodeStore(store_code);" type="button" value="?" name="st" id="st"><%=bean.getImage("M")%><!-- <input type="hidden" name="store_code" id="store_code" value = "<%=store_code%>" > --></td>
					<td align="right">&nbsp;</td>
					<td >&nbsp;&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				
					<th colspan=5 align=left>
					<fmt:message key="eST.ConsumptionCriteria.label" bundle="${st_labels}"/></th>
			
				<tr>
					<td class=label align=left>
					<fmt:message key="eST.ConsumptionPeriod.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;
					<input type=text name="consumption_period" id="consumption_period" size=4 maxlength=2 class="NUMBER" value="" onKeyPress="return isValidInteger();" ><%=bean.getImage("M")%></td>
					<td class=label align=left>
					<fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;
					<input type=text name="lead_days" id="lead_days" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
					<td class=label>&nbsp;
					<fmt:message key="eST.IncludeStockIssues.label" bundle="${st_labels}"/>&nbsp;<input name="p_stk_issue" id="p_stk_issue" type='checkbox' checked value='Y'></td>
				</tr>
				<tr>
					<td class=label align=left>
					<fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;
					<input type=text name="min_stock_days" id="min_stock_days" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
					<td class=label align=left>
					<fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/> (<fmt:message key="Common.on.label" bundle="${common_labels}"/> <fmt:message key="eST.MinStock.label" bundle="${st_labels}"/>)</td>
					<td>&nbsp;&nbsp;
					<input type=text name="buffer_percentage" id="buffer_percentage" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
					<td align='right'>
					<input type="button" class='button' value='<fmt:message key="Common.Compute.label" bundle="${common_labels}"/>' onClick="searchItems();" name="compute"></td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			<input type="hidden"		 name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden"		 name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden"		 name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden"		 name="language_id" id="language_id"						value="<%=locale%>">
			<input type="hidden"		 name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden"		 name="mode" id="mode"							value="2">
			<input type="hidden"		 name="function_id" id="function_id"						value="<%=request.getParameter("function_id")%>">
			<input type="hidden"		 name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			<input type="hidden"		 name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden"		 name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">

		</form>
		<% putObjectInBean(bean_id,bean,request);%>
	</body>
</html>	


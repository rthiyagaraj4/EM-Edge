
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027		Badmavathi B					GHL-CRF-0413.7 - US005 - Barcode search
07/08/2020  IN073577        B Haribabu          07/08/2020                          MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import="eST.PhysicalInventoryEntryBean,webbeans.eCommon.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script>
 -->		
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/PhysicalInventoryEntry.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 -->	</head>
	<%
		String bean_id = "PhysicalInventoryEntryBean";
		String bean_name = "eST.PhysicalInventoryEntryBean";
		
		PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean) getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear_data_added();
		//Added for GHL-CRF-0413.7 starts
	       	Connection con				= null;
	   	con						= ConnectionManager.getConnection(request);
	   	boolean site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_BARCODE_INT_EXT");
	   	bean.setSite_spec_yn(site);
	   	//Added for GHL-CRF-0413.7 ends
	
	%>	
<!-- 	<body onLoad="FocusFirstElement();fun_submit();">
 -->	<body onLoad="FocusFirstElement();">
		<form name="formPhysicalInventoryEntryHeader" id="formPhysicalInventoryEntryHeader">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='70%' align=center><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
				<tr>
					<td  class="label"><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
					<td class="fields">
					&nbsp;&nbsp;<select name="phy_inv_id" id="phy_inv_id" onChange="getStore();">
					<%=bean.getTempphyid()%>
					</select></td>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td><!-- Modified for TFS id:6938 -->
					<td class="fields">&nbsp;&nbsp;<input type='text' size='15'  maxlength='15' name='store_desc' id='store_desc'  value="" disabled></td>
					<td  class="label">&nbsp;&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" colspan=6>&nbsp;</td>
				</tr>

				<tr>
				<td class="label" align = "left"><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/>&nbsp;<input type="checkbox" value="" name="entry_completed_yn" id="entry_completed_yn"></td>
				<td class="fields">
					&nbsp;&nbsp;</td>
				<%if(site){ //Added for GHL-CRF-0413.7 starts%>
				<td  class="label">
					<fmt:message key="eST.BarcodeId.label" bundle="${st_labels}"/><!-- Modified for TFS id:6938 -->
				</td>
				<td class=fields>
					&nbsp;
					<input  name=barcode size=80 maxlength=100 value = "" onkeypress="searchBarcode(event,barcode,'<%=bean_id%>','<%=bean_name%>')" disabled ><!--Modified for IN:073577 increased size from 70 to 80 -->
				</td>
				<%} //Added for GHL-CRF-0413.7 ends%>
				<!--<td  class="label"><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
					<td>
					<select name="view_batches" id="view_batches" onChange="">
					<option value="GRN" selected>GRN BATCHES </option>
					<option value="ALL" >ALL BATCHES </option>
					</select></td>-->
					<td align='right'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onclick="fun_submit();"  </td>
					</td>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
				</tr>
				<tr>
					<td class="label" colspan=3>&nbsp;
					
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="mode" id="mode" value="1">
			<input type="hidden" name="facility_id" id="facility_id" value="">
			<input type="hidden" name="item_code" id="item_code" value="">
			<input type="hidden" name="item_desc" id="item_desc" value="">
			<input type="hidden" name="store_code" id="store_code" value="">
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="SQL_ST_ITEM_LOOKUP_LANG" id="SQL_ST_ITEM_LOOKUP_LANG" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP_LANG")%>">
			<input type="hidden"    name="site" id="site"	 						value="<%=site%>"><!--Added for GHL-CRF-0413.7 -->
		</form>
<%
putObjectInBean(bean_id,bean,request);
%>
<%
//Added for GHL-CRF-0413.7 starts
	if(con != null)
		ConnectionManager.returnConnection(con,request);
//Added for GHL-CRF-0413.7 ends
%>
	</body>
</html>


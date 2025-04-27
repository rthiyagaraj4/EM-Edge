<!DOCTYPE html>

<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePO.*, ePO.Common.*  ,eCommon.Common.*,java.sql.*,java.lang.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		<script language="javascript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePO/js/POReprintDocument.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"PORePrintDocReportBean";
		String bean_name			=		"ePO.PORePrintDocReportBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		PORePrintDocReportBean bean	=		(PORePrintDocReportBean) getBeanObject( bean_id,  bean_name, request);  
		bean.setLanguageId(locale);
		
		String to_date	 =  com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();	
		String from_date =  com.ehis.util.DateUtils.minusDate(to_date,"DMY",locale,1,"M").toString();
	
		String display_flag					= "visibility:hidden"; 

		String select_option="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
				
	%>
	<body onLoad="FocusFirstElement();">
		<form name="ReprintDocumentCriteria" id="ReprintDocumentCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<td width='100%' align='center' class="WHITE"  height='100%'>
				<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0"  height='100%'>
				<th colspan=6 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr><td  class="label" colspan='4'>&nbsp;&nbsp;</td> </tr>		
				<tr>	
					<td class="label" ><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_trn_type" id="p_trn_type" onChange="loaddoctype();loadpurunitcode();">
					
	                <option value="" >&nbsp;&nbsp;&nbsp;&nbsp;---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>
				    <option value="POREQN"><fmt:message key="ePO.PurchaseRequest.label" bundle="${po_labels}"/></option>
					<option value="PORDER"><fmt:message key="ePO.PurchaseOrder.label" bundle="${po_labels}"/></option>
	                <option value="DLVORD"><fmt:message key="ePO.DeliveryOrder.label" bundle="${po_labels}"/></option>
		         </select></img><%=bean.getImage("M")%></td>				 
						 
					<td  class="label" >Type</td>
					<td>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" >
						<%=select_option%>
						</select></td>
					
                    <td class="label" >Doc No</td>
					<td>&nbsp;&nbsp;<input class="NUMBER" type="text" size="25" maxlength="25"  name="doc_no" id="doc_no"  onKeyPress="return CheckForSpecialChars(event);"></td>
					
				</tr>
				<tr>
				    <td class="label" id = 'pur1'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="pur_unit" id="pur_unit"  id = 'purcode'>
						<%=select_option%>
					</select> </td>
					<td  class="label" id = 'store1'  ><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=45 size=45 name="store_desc" id="store_desc" id = 'store_desc'><input class="button" onClick="return searchCodeStore(store_code,store_desc);" id='but1' type="button" value="?"><input type="hidden" name="store_code" id="store_code" value = "" ></td>
					<td  class="label" id = 'suplierlabel'><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/> </td>
				    <td  class="fields"  >&nbsp;	
					<select name="to_supplier" id="to_supplier"  id = 'suplier' ><%=bean.getRequestToSupp()%></select></td>
				</tr>
				
				<tr>
					<td class=label align=right><fmt:message key="ePO.PeriodFromDate.label" bundle="${po_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name=p_fr_doc_date size=10 maxlength=10 class="DATE" value="<%=from_date%>"  onBlur="ChekDate(this,'<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fr_doc_date');"></img><%=bean.getImage("M")%></td>
					<td class="label" align=right><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_doc_date size=10 maxlength=10 class="DATE" value="<%=to_date%>"  onBlur="ChekDate(this,'<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');"></img><%=bean.getImage("M")%></td>
				</tr>   				 
				<tr>
				</tr>
				
				<tr>
				 <td align='right' colspan=5><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="frmdate();"></td>  
		        </tr> 
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id"				value="PO">
			<input type="hidden" name="p_user_name" id="p_user_name"				value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id">
			<input type="hidden" name="p_doc_no" id="p_doc_no">
			<input type="hidden" name="dest_locn_code" id="dest_locn_code"			value="PARAMETER_WILL_BE_PASSED">
			<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
			

		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" 		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_PO_STORE_LOOKUP_FOR_REPORT")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>	



<!DOCTYPE html>
<%@ page import=" ePO.*,ePO.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale		=	(String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoMessages.js"></script>
		<script language="JavaScript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String bean_id								=		"amendPurchaseOrderBean";
	String bean_name							=		"ePO.AmendPurchaseOrderBean";
	String user									=		(String) session.getValue( "login_user" );


	AmendPurchaseOrderBean bean = (AmendPurchaseOrderBean) getBeanObject( bean_id, bean_name,request );

	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String minusdate	       =    com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d");
%>
<body onload='FocusFirstElement();document.formAmendPOSearchWindowCriteria.submit();' >
	<form name="formAmendPOSearchWindowCriteria" id="formAmendPOSearchWindowCriteria" action="../../ePO/jsp/AmendPOSearchWindowResult.jsp" method="post" target="frameAmendPOSearchWindowResult" onReset='FocusFirstElement();'>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center"  colspan=6 >	
			<th  colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
			<tr>
				<td class="label"  ><fmt:message key="Common.item.label"	bundle="${common_labels}"/></td>
				<td class="fields" ><input type=text name=item_desc size=70 maxlength=60 value="" onkeypress=""> 
					<input type=hidden name="item_code" id="item_code" value=""> 
					<input type='button' class='button' value='?' onClick='searchItemCode(item_desc);' name="item_search" id="item_search"></td>
				<td class="label"  >Facility</td>
				<td class="fields">&nbsp;
					<select name="facility_id" id="facility_id">
						<%=bean.getFacilityList()%>
					</select>
				</td>
		
				<td class="label"  >Store</td>
				<td class="fields">&nbsp;
					<select name="req_store_code" id="req_store_code">
						<%=bean.getRequestByStoreList()%>
					</select>
				</td>
			</tr>
			<tr> 
				<td  class="label" colspan ="2">
					<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=minusdate%>" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
					<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');">
				</td>
				<td class="label"  >Req Doc NO</td>
				<td class="fields" ><input type="text" size="20" maxlength="20" class='NUMBER' name="req_no" id="req_no" onKeyPress="return isValidInteger();" ></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<br>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td align="left"><input type=button name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="document.formAmendPOSearchWindowCriteria.submit();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type=button name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' style="font-family:verdana;width:5em"  onclick="ReloadPurchaseOrderWindow();"></td>
			</tr>
		</table>

		<input type="hidden" 	name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"  	value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_LOOKUP")%>"> 
		<input type="hidden" 	name="batch_id" id="batch_id"				value="" >
		<input type="hidden" 	name="expiry_date" id="expiry_date"			value="" >
		<input type="hidden" 	name="trade_id" id="trade_id"				value="" >
		<input type="hidden" 	name="binlocation" id="binlocation"			value="" >
		<input type="hidden" 	name="loc_batch_string" id="loc_batch_string"		value="" >
</form>
 
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


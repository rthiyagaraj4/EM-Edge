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
		<script language="JavaScript" src="../../eST/js/PoMessages.js"></script>
		<script language="JavaScript" src="../../ePO/js/DeliveryOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String facility_id							=		(String) session.getValue( "facility_id" ) ;
	String user									=		(String) session.getValue( "login_user" );
	String language_id									=		(String) session.getValue( "locale" );

	String bean_id								=		"deliveryOrderBean";
	String bean_name							=		"ePO.DeliveryOrderBean";

	DeliveryOrderBean bean = (DeliveryOrderBean) getBeanObject( bean_id, bean_name,request );	

	String po_number								   =       bean.checkForNull(request.getParameter("po_number"));
	String store_code								   =	   bean.checkForNull(request.getParameter("store_code"));
	String mode										   =	   bean.checkForNull(request.getParameter("mode"));	
	String supp_code								   =	   bean.checkForNull(request.getParameter("supp_code"));
	String tran_currency								   =	   bean.checkForNull(request.getParameter("tran_currency"));
	String tran_currency_temp								   =	   bean.checkForNull(request.getParameter("tran_currency_temp"));
	
	String codeDisabled								   =		"";

	if(mode.equals("2"))
	codeDisabled = "Readonly";
	
		
	String supp_desc =	bean.checkForNull((String)bean.fetchRecord("SELECT supp_code, short_name FROM ap_supplier_lang_vw WHERE language_id = ? and supp_code = ? ORDER BY short_name",new String[]{locale,supp_code}).get("SHORT_NAME"),"");
	
	System.out.println("supp_code = "+supp_code);
	System.out.println("supp_desc = "+supp_desc);
	
	HashMap alstartdate      = bean.getDurationforStartDate();
   // String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
//	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	
	String currentdate	   =	com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	String plusDate	       =    com.ehis.util.DateUtils.plusDate(currentdate,"DMY",locale,7,"d");
	
	

%>
<body onload='FocusFirstElement();document.formPOItemDetailCriteria.submit();' >
	<form name="formPOItemDetailCriteria" id="formPOItemDetailCriteria" action="../../ePO/jsp/POItemDetailResult.jsp" method="post" target="framePOItemDetailResult" onReset='FocusFirstElement();'>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center">	
		<th  colspan=6><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
	 <!--   <td class="label"  ><fmt:message key="Common.item.label"	bundle="${common_labels}"/></td>
		<td>&nbsp;&nbsp;<input type=text name=item_desc size=70 maxlength=60 value="" onkeypress=''><input type=hidden name="item_code" id="item_code" value=""  ><input type='button' class='button' value='?' onClick='searchItemCode(item_desc)' name="item_search" id="item_search"></td>
	-->
		<input type=hidden name="item_code" id="item_code" value=""  >
		<input type=hidden name="item_desc" id="item_desc" value=""  >
				
		<td  class="label">	<fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/>	</td>
		<td class='fields'>&nbsp;&nbsp;<input type="hidden" size="15" maxlength="20"  name="supp_code" id="supp_code"  value="<%=supp_code%>" disabled>
		<input type="text" size="15" maxlength="30"  name="supp_desc" id="supp_desc"  value="<%=supp_desc%>" disabled></td>
		
		
		<td class="label"><fmt:message key="eST.PORaisedBy.label" bundle="${st_labels}"/></td>
		<td class="fields">&nbsp;
			<select name="purchase_unit" id="purchase_unit">
			<%=bean.getRequestFromPurchaseUnit(bean.getRequest_by_pu())%>
			</select>
		</td>
		<td  class="label"><fmt:message key="ePO.POMode.label" bundle="${po_labels}"/></td>													
		<td class="fields">&nbsp;
			<select name="po_mode" id="po_mode" >
				<option value="D"  selected>Direct Order</option>
				<option value="R" >Order Based on Request</option>
			</select>
		</td>
		<td>&nbsp;</td> 
		
		
		</tr>
		<tr>&nbsp;</tr>
		<tr>
		<td  class="label">Delivery Due
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td class="label">
		<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=plusDate%>" onBlur="CheckDate(this); ">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img> 
		</td>

		<td class="label"><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="15" maxlength="20"  name="doc_no" id="doc_no" onKeyPress="return CheckForSpecialChars(event);" value="<%=po_number%>" <%=codeDisabled%> ></td>
		<td>&nbsp;</td>
		<td align="center">
		<input type=button name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="chekValidateFromDate();" >&nbsp;
		</td>

        </tr>
	</table>

	 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	 <input type="hidden" name="po_number" id="po_number"	value="<%=po_number%>">
	 <input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	 <input type="hidden" name="mode" id="mode" value="<%=mode%>">
	 <input type="hidden" name="loc_batch_string" id="loc_batch_string" value="">
	 <input type="hidden" name="supp_code1" id="supp_code1" value="<%=supp_code%>">
	 <input type="hidden" name="tran_currency" id="tran_currency" value="<%=tran_currency%>">
	 <input type="hidden" name="tran_currency_temp" id="tran_currency_temp" value="<%=tran_currency_temp%>">
	 <input type="hidden" name="language_id" id="language_id" value="<%=language_id%>">
	 
	 
	 
</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


<!DOCTYPE html>
<%@ page import=" eST.*,eST.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
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
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
		<script language="JavaScript" src="../../eST/js/SalesReturn.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<%
	String facility_id							=		(String) session.getValue( "facility_id" ) ;

	java.util.Properties prop			=	(java.util.Properties) session.getValue( "jdbc" ) ;
	String login_at_ws_no				=	 prop.getProperty( "client_ip_address" );
	String bean_id						=	 "salesReturnBean"+login_at_ws_no;
	String bean_name					=	 "eST.SalesReturnBean";

	String user									=		(String) session.getValue( "login_user" );
	String patient_id                           =       request.getParameter("patient_id");
	String patient_name                         =       request.getParameter("patient_name");
	String sal_trn_type                         =       request.getParameter("sal_trn_type");
	String encounter_id                         =       request.getParameter("encounter_id");
	String store_code                           =       request.getParameter("store_code");
    String chargeable_yn                        =       request.getParameter("chargeable_yn");
	

	

	SalesReturnBean bean = (SalesReturnBean) getBeanObject( bean_id, bean_name,request );

	String noOfDecimalsForCost=bean.getNoOfDecimalsCost();

	HashMap alstartdate      = bean.getDurationforStartDate();
    String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

%>
<body onload='FocusFirstElement();document.formSalesReturnSearchWindowCriteria.submit();' >
	<form name="formSalesReturnSearchWindowCriteria" id="formSalesReturnSearchWindowCriteria" action="../../eST/jsp/SalesReturnSearchWindowResult.jsp" method="post" target="frameSalesReturnSearchWindowResult" onReset='FocusFirstElement();'>
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align="center"  colspan=4  >	
		<th  colspan=4><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></th>
		<tr>
	    <td class="label"  ><fmt:message key="Common.item.label"	bundle="${common_labels}"/></td>
		<td class="fields" width="40%"><input type=text name=item_desc size=70 maxlength=60 value="" onkeypress='searchItemCodeforBarcode(event,this);'><input type=hidden name="item_code" id="item_code" value=""  ><input type='button' class='button' value='?' onClick='searchItemCodeforBarcode(event,item_desc);' name="item_search" id="item_search"></td>
		<td class="label"  width="8%" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="fields" width="40%"  ><input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" ></td>
		</tr>
		<% if(sal_trn_type.equals("X")){%>
		<tr>
		<td class="label" ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class="fields" width="40%"><input type='text' name="patient_name" id="patient_name" value=""  size=70  maxLength=40  ></td>
		<td width="8%" >&nbsp;&nbsp;</td>
		<td width="40%">&nbsp;&nbsp;</td>
		</tr>
	    <%}%>
		<tr>
		<td  class="label" colspan ="2">
		<fmt:message key="Common.fromdate.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');">
		</td>
		<td>&nbsp;</td>
		<td align="left"><input type=button name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="document.formSalesReturnSearchWindowCriteria.submit();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type=button name="reset" id="reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' style="font-family:verdana;width:10em"  onclick="ReloadSaleWindow();"></td>
        </tr>
	</table>

	 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
	 <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	 
	 <input type="hidden" name="sal_trn_type" id="sal_trn_type" value="<%=sal_trn_type%>">
	 <input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	 <input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
	 <input type="hidden" name="chargeable_yn" id="chargeable_yn" value="<%=chargeable_yn%>">
	 <input type="hidden"    name="loc_batch_string" id="loc_batch_string"				value="" >
	 <input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
	 <input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" ><!--dummy-->
	 <input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value=""><!--dummy-->
	 <input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" ><!--dummy-->
	 <input type="hidden"    name="batch_id" id="batch_id"				value="" >
	 <input type="hidden"    name="expiry_date" id="expiry_date"				value="" >
	 <input type="hidden"    name="trade_id" id="trade_id"				value="" >
	 <input type="hidden"    name="binlocation" id="binlocation"				value="" >
	 <input type="hidden"    name="bean_id" id="bean_id"				value="<%=bean_id%>" >
	 <input type="hidden"    name="bean_name" id="bean_name"				value="<%=bean_name%>" >
</form>
<script>
callBarCodeApplicable('SRT','formSalesReturnSearchWindowCriteria','<%=bean_id%>','<%=bean_name%>');
</script>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>


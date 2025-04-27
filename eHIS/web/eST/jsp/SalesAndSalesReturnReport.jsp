<!DOCTYPE html>
 <%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
13/04/2018								Soorya Prakash M 						  							KDAH-CRF-0380  Sale/Sale Return Report
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import=" eST.SalesAndReturnHistoryBean,java.util.HashMap,java.sql.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head> 
<%
	request.setCharacterEncoding("UTF-8");
    String locale			= (String)session.getAttribute("LOCALE");
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> 
	<script language="JavaScript" src="../../eST/js/SalesAndSalesReturnReport.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>" 
    </script>
</head>
<%
	
	String bean_id   = "SalesAndReturnHistoryBean";
	String bean_name = "eST.SalesAndReturnHistoryBean";
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	String user_name			=		(String) session.getValue( "login_user" ) ;
	SalesAndReturnHistoryBean bean = (SalesAndReturnHistoryBean) getBeanObject(bean_id,bean_name, request  );  
	bean.setLanguageId(locale);
	bean.clear();
	
	int pat_length				=		Integer.parseInt(bean.checkForNull((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"),"0"));

	  HashMap alstartdate      = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formSalesAndSalesReturnReport" id="formSalesAndSalesReturnReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td align="left" class="label"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="p_trn_type" id="p_trn_type" value="SAL" onclick = "PopulateSalesDocTypeCode(this.value);" checked>
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.SalesReturn.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="p_trn_type" id="p_trn_type" value="SRT" onclick= "PopulateSalesReturnDocTypeCode(this.value);">
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.Both.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="p_trn_type" id="p_trn_type" value="BOT" onclick= " populateBothDocTypeCode(this.value);"></td> 
	</tr>
</table>
<br>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" >
   <tr>
		<td align="left" class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='field'>&nbsp;<select name="p_sal_doc_type" id="p_sal_doc_type" ><%=bean.getDoc_type_code_ListOptions("SAL","")%></select></td>
		<td align="left" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" size="8" maxlength="8" class='NUMBER' name="p_doc_no" id="p_doc_no" onKeyPress="return isValidInteger();" ></td>	
		<td align="left" class="label"><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<select name="p_sal_trn_type" id="p_sal_trn_type"><%=bean.getSaleReportType()%></select></td>
  </tr>
  <tr>
		<td align="left" class="label" ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' maxLength=8 size=8 name="p_store_code" id="p_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td> 		
		<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' size='20'  maxlength='21' name='p_item_code' id='p_item_code'  value=""   ><input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchItemCode(p_item_code);" ></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
  </tr>
  <tr> 
		<td align="left"  class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;<input type="text"  name="p_from_date" id="p_from_date" size="8" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_date');"></img><%=bean.getImage("M")%>
		&nbsp;<td align="left" class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		<td align="left">&nbsp;<input type="text" name="p_to_date" id="p_to_date" size="8" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date');"></img><%=bean.getImage("M")%>
		</td> 
		<td align="right" class="label"></td><td>&nbsp;</td>
  </tr>
  <tr>
	 	<td class='label' align='left'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' name='p_patient_id' id='p_patient_id' class="UPPER" size=20 maxLength="<%=pat_length%>" value="" onBlur="searchpatientName(document.formSalesAndSalesReturnReport);"><input type='button' class='button' value="?" onclick="searchPatient();"></td>
		<td align="left" class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :</td>
		<td align="left" >&nbsp;<font size=1><label id="patient_name"></font></td>
		<td align="left" class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> :</td>
		<td align="left" >&nbsp;<font size=1><label id="patient_nation"></font></td>
  </tr>
  <tr>
		<td align="left" class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
		<td align="left">&nbsp;<input type="text" name="p_encounter_id" id="p_encounter_id" size="12" maxlength="12" onBlur="CheckNum(this);" onKeyPress="return isValidInteger();"></td>			
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		
  </tr>
 </table>
 </td>
 </tr>
 </table>

		
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="DT_FROM" id="DT_FROM" value="">
		<input type="hidden" name="DT_TO" id="DT_TO" value="">
		<input type="hidden" name="p_report_id" id="p_report_id"  value="STSALSRT">
		<input type="hidden" name="p_user_id" id="p_user_id"  value="<%=user_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
		<input type="hidden" name="p_language_id" id="p_language_id"			value="<%=locale%>">
		<input type="hidden" name="p_module_id" id="p_module_id"				value="ST">
	</form>
	<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
        <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


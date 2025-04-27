
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By       	Description
--------------------------------------------------------------------------------------------------------------
05/07/2021		TFS id:-19018       Prabha	  16/06/2021	   Manicakavasagam	AMS-CRF-0258
---------------------------------------------------------------------------------------------------------------
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
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script> <!-- Added for AMS-CRF-0258 -->
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> 
	<script language="JavaScript" src="../../eST/js/SalesAndReturnHistory.js"></script> 
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
	String mode         = request.getParameter("mode");
	String facility_id  =  (String) session.getValue( "facility_id" ) ;

	SalesAndReturnHistoryBean bean = (SalesAndReturnHistoryBean) getBeanObject(bean_id,bean_name, request  );  
	bean.setLanguageId(locale);
	bean.clear();
	
	int pat_length				=		Integer.parseInt(bean.checkForNull((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"),"0"));

	//String currentdate		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	//String currentdateminus =  com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d").toString();

	  HashMap alstartdate      = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	  
	  // Added for AMS-CRF-0258 - Start
	  SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	  java.util.Date date_time	 	= new java.util.Date();
	  String Sysdate 				= dtSystemFormat.format(date_time); 
	// Added for AMS-CRF-0258 - End
	%>
<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()' > <!-- Added for AMS-CRF-0258 -->
<form name= "formSalesAndReturnHistoryQueryCriteria"  action="../../eST/jsp/SalesAndReturnHistoryQueryResult.jsp" method="post"  target="frameSalesAndReturnHistoryQueryResult" onReset="FocusFirstElement();">
<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" >
	<tr>
		<td align="left" class="label"><fmt:message key="eST.Sales.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="trn_type" id="trn_type" value="SAL" onclick = "PopulateSalesDocTypeCode(this.value);" checked>
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.SalesReturn.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="trn_type" id="trn_type" value="SRT" onclick= "PopulateSalesReturnDocTypeCode(this.value);">
		&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eST.Both.label" bundle="${st_labels}"/>&nbsp;
		<input type='radio' name="trn_type" id="trn_type" value="BOT" onclick= " populateBothDocTypeCode(this.value);"></td> 
	</tr>
</table>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center" >
   <tr>
		<td align="left" class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='field'>&nbsp;<select name="sal_doc_type" id="sal_doc_type" ><%=bean.getDoc_type_code_ListOptions("SAL","")%></select></td>
		<td align="left" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" size="8" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" ></td>	
		<td align="left" class="label"><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<select name="sal_trn_type" id="sal_trn_type"><%=bean.getSaleType()%></select></td>
  </tr>
  <tr>
		<td align="left" class="label" ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' maxLength=8 size=8 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td> 		
		<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' size='20'  maxlength='21' name='item_code' id='item_code'  value=""   ><input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchItemCode(item_code);" ></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
  </tr>
  <tr> 
		<td align="left"  class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;<input type="text"  name="from_date" id="from_date" size="8" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');"></img><%=bean.getImage("M")%>
		&nbsp;<td align="left" class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/>
		<td align="left">&nbsp;<input type="text" name="to_date" id="to_date" size="8" maxlength="10"  value="<%=currentdate%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');"></img>
		</td> 
		<td align="right" class="label"></td><td>&nbsp;</td>
  </tr>
  <tr>
	 	<td class='label' align='left'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' name='patient_id' id='patient_id' class="UPPER" size=20 maxLength="<%=pat_length%>" value="" onBlur="searchpatientName(document.formSalesAndReturnHistoryQueryCriteria);"><input type='button' class='button' value="?" onclick="searchPatient();"></td>
		<td align="left" class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :</td>
		<td align="left" >&nbsp;<font size=1><label id="patient_name"></font></td>
		<td align="left" class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> :</td>
		<td align="left" >&nbsp;<font size=1><label id="patient_nation"></font></td>
  </tr>
  <tr>
		<td align="left" class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
		<td align="left">&nbsp;<input type="text" name="encounter_id" id="encounter_id" size="12" maxlength="12" onBlur="CheckNum(this);" onKeyPress="return isValidInteger();"></td>			
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right"  >
		<input class='button' type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="checkDate(document.forms[0]);" class="label">&nbsp;</td>
  </tr>
 </table>

		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
        <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> <!-- Added for AMS-CRF-0258 -->
		<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>"> <!-- Added for AMS-CRF-0258 -->
		<input type="hidden" name="p_doc_no" id="p_doc_no">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


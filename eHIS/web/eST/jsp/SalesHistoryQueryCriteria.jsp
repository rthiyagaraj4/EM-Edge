<!DOCTYPE html>
<%@ page import=" eST.SalesHistoryBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head> 
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/CommonLookup.js"></script> -->  <!--  Commented for MOHE-SCF-0156  -->
	<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>	<!-- Added for MOHE-SCF-0156 -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script> 
	<script language="JavaScript" src="../../eST/js/SalesHistory.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>" 
    </script>
</head>
<%
	
	String bean_id = "SalesHistoryBean";
	String bean_name = "eST.SalesHistoryBean";
	String mode = request.getParameter("mode");
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	/*
	try{
	mode = mode.trim();
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	}
	catch(Exception ee) { }
	*/
	SalesHistoryBean bean = (SalesHistoryBean) getBeanObject(bean_id,bean_name, request  );  
	bean.setLanguageId(locale);
	bean.clear();
	//bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));
	//bean.setMode(mode);
	//bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	//java.util.HashMap defaultParameter = bean.getDefaultStParameter();

	/*To get the max length to be allowed for patient id*/
	int pat_length				=		Integer.parseInt(bean.checkForNull((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"),"0"));

	//String currentdate		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	//String currentdateminus =  com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d").toString();

	  HashMap alstartdate      = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	
%>
<body onload="FocusFirstElement(); ">
	<form name= "formSalesHistoryQueryCriteria" action="../../eST/jsp/SalesHistoryQueryResult.jsp" method="post"  target="result" onReset='FocusFirstElement();'>
	
	<table border="0" cellspacing="0" width="100%" align="center" >
	<!--
			* @Name - Priya
			* @Date - 07/07/2010
			* @Inc# - 21346 (AK-CRF-0018)
			* @Desc - New Query parameters DocType &  DocNo are added
	-->
	  <tr>
		<td align="left" class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name="sal_doc_type" id="sal_doc_type"><%=bean.getDoc_type_code_ListOptions("SAL","")%></select></td>
		<td align="left" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" ></td>			
		<td align="left" class="label"><fmt:message key="eST.SalesType.label" bundle="${st_labels}"/></td>
		<td >&nbsp;<select name="sal_trn_type" id="sal_trn_type"><%=bean.getSaleType()%></select></td>
		
		<!-- <td align="right" class="label">Category</td> 
		<td >&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getSaleType()%></select></td> -->
	  </tr>
	  <tr>
		<td align="left" class="label" ><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td> 		
		<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' size='20'  maxlength='21' name='item_code' id='item_code'  value=""   ><input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="searchItemCode(item_code);" ></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
	  </tr>
	  <tr>
		<td align="left" class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td align="left">&nbsp;<input type="text" name="from_date" id="from_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_date');" ></img><%=bean.getImage("M")%></td><td align="left" class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>		
		<td align="left">&nbsp;<input type="text" name="to_date" id="to_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_date');" ></img><%=bean.getImage("M")%></td>	 
		
		<td align="right" class="label"></td>
		<td>&nbsp;</td>
	  </tr>
	  <tr>
	 	<td class="label" align="left"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type='text' name='patient_id' id='patient_id' size=20 maxLength="<%=pat_length%>" value="" onBlur="searchpatientName(document.formSalesHistoryQueryCriteria);"><input type='button' class='button' value="?" onclick="searchPatient();"></td> <!--<%=bean.getImage("M")%> Commented by ganga Wednesday, November 21, 2012 for IN034623 GHL-SCF-604-->
		<td align="left" class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/> :</td>		
 		<td align="left" >&nbsp;<font size=1><label id="patient_name"></font></td>
		<td align="left" class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> :</td>				
 		<td align="left" >&nbsp;<font size=1><label id="patient_nation"></font></td>
		 
		
		<!--<td >&nbsp;&nbsp;</td> -->
	   </tr>
 <tr>
		<td align="left" class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
		<td align="left">&nbsp;<input type="text" name="encounter_id" id="encounter_id" size="12" maxlength="12" onBlur="CheckNum(this);" onKeyPress="return isValidInteger();"></td>	 
		
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right" class="label"></td>
		<td align="right"  >
		<input class='button' type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick=" DateValidations();" class="label">&nbsp;</td>
		</tr>
	  
	</table>
		<!--<input type="hidden" name ="store_code" >
		<input type="hidden" name ="item_code" > -->
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
        <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


<!DOCTYPE html>
<%@ page import=" eST.SalesBean,java.util.HashMap" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eST/js/Sales.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String bean_id = "salesBean";
	String bean_name = "eST.SalesBean";
	SalesBean bean = (SalesBean) getBeanObject( bean_id,  bean_name,request  );    
	bean.setLanguageId(locale);
	bean.setModuleId(bean.checkForNull((String)request.getParameter("module_id"),"ST"));

// modified on 22/12...
	//bean.clear();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode("1");
	bean.setTrn_type("SAL");
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
//	bean.setEntity_param((String) session.getAttribute("ACC_ENTITY_ID"));
	bean.initDoc_type_code_List();
//	initStore_code_List();
	if((bean.getModuleId()).equals("OT")){
		String ot_doc_type =		bean.checkForNull((String)bean.fetchRecord("SELECT ST_DOC_TYPE_SLI FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?",bean.getLoginFacilityId()).get("ST_DOC_TYPE_SLI"),"");
		bean.setDoc_type_code(ot_doc_type);
	}else{
		java.util.HashMap defaultParameter = bean.getDefaultStParameter();
		String default_doc_type_code = (String)defaultParameter.get("DEF_SAL_DOC_TYPE_CODE");
		bean.setDoc_type_code(default_doc_type_code);
	}

	/*To get the max length to be allowed for patient id*/
	int pat_length				=		Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_PATIENT_ID_LENGTH"))).get("PATIENT_ID_LENGTH"));
	
    //String currentdate		=  com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	//String currentdateminus =  com.ehis.util.DateUtils.minusDate(currentdate,"DMY",locale,7,"d").toString();
	String module_id =  bean.checkForNull((String)request.getParameter("module_id"),"ST");	

//Added by Rabbani #Inc no:30909 on 12/03/12 Starts
	
	  HashMap alstartdate      = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
	 //ends	
	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	if(homepage.equals("Y"))
		bean.setStore_code(store_code);
	
%>
<body onload='FocusFirstElement();document.formSalesQueryCriteria.submit();'>
	<form name= "formSalesQueryCriteria" action="../../eST/jsp/SalesQueryResult.jsp" method="post" target="SalesQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align="center" >
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDoc_type_code_List()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" ></td>
		<td  class="label"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');NursingUnitList(doc_date,to_doc_date);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');NursingUnitList(doc_date,to_doc_date);"></img><%=bean.getImage("M")%></td>
		<td class="label"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="3">&nbsp;&nbsp;<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');NursingUnitList(doc_date,to_doc_date)">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');NursingUnitList(doc_date,to_doc_date)"> </img></td> 
	  </tr>

	  <tr>
		<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="store_code" id="store_code"><%=bean.getSALStore_code_List()%></select></td>
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=bean.getAllItem_class_List()%></select></td>
		<%if((bean.getCustomerID()).equals("MC")){%>
		<td class='label' ><fmt:message key="eST.Priority.label" bundle="${st_labels}"/></td>
		<td class='label' >&nbsp;<select name='sales_priority_type' id='sales_priority_type'  >
		<option value="%"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<option value="R"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
		<option value="U" ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option> </select></td>
		<%}else{%>
		<td class='fields'>&nbsp;&nbsp;</td>
		<td class='fields' colspan="5">&nbsp;&nbsp;</td>
		<%}%>
		
				
	  </tr>
	  <tr>
		<td class='label' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan="3">&nbsp;&nbsp;<input type='text' name='patient_id' id='patient_id' size=20 maxLength="<%=pat_length%>" value="" ><input type='button' class='button' value="?" onclick="searchPatient();"></td>
		<%if((bean.getCustomerID()).equals("MC")){%>
		<td class="label"><fmt:message key="eST.nursingunit/clinic.label" bundle="${st_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="nursing_unit_code" id="nursing_unit_code">&nbsp;&nbsp;<%=bean.getNursingUnitCodeListNew((String)alstartdate.get("DURATIONFORSTARTDATE"),(String)alstartdate.get("SYSTEMDATE"))%></select></td>
		<!--<td class='fields'>&nbsp;&nbsp;<input type='text' name='nursing_unit_desc' id='nursing_unit_desc' size=20 maxLength="" value="" ><input type='button' class='button' value="?" onclick="searchNursingUnit(nursing_unit_desc);"></td>-->		
		<%}else{%>
		<!--<td class='fields'>&nbsp;&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;</td>-->
		<%}%>
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="orderbycolumns" id="orderbycolumns">
		<option value="hdr.added_date asc"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value="hdr.added_date desc"><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>	
		</select></td>
		<%if(!((bean.getCustomerID()).equals("MC"))){%>
		<td class='fields'>&nbsp;&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;</td>
		<%}%>
		<td class='fields'>&nbsp;&nbsp;</td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'   onClick="frmdate();"></td>
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		<input type="hidden" name="facility_id" id="facility_id" value="<%=(String) session.getValue( "facility_id" )%>">

	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<!--<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_no asc">-->
		<!--<input type="hidden" name="nursing_unit_code" id="nursing_unit_code" value="">-->
		<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


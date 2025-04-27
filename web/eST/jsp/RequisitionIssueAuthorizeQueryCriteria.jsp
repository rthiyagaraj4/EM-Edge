<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
26/04/2016		56060			B.Badmavathi					 	PMG2015-CRF-INT-ST-0001	Authorize at Issue Store Privilges
---------------------------------------------------------------------------------------------------------------
*/
%>
<jsp:useBean id="obj0" scope="page" class="eST.AuthorizeAtIssueStoreBean"/>
<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
	String locale			= (String)session.getAttribute("LOCALE");
		
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
	<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
    <script>
        function_id			=	"<%= request.getParameter("function_id") %>"
		menu_id				=	"<%= request.getParameter("menu_id") %>"
		module_id			=	"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String default_value			=	"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	String bean_id					=	"authorizeAtIssueStoreBean";
	String bean_name				=	"eST.AuthorizeAtIssueStoreBean";
	AuthorizeAtIssueStoreBean bean  =	(AuthorizeAtIssueStoreBean) getBeanObject(bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear();
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	java.util.HashMap defaultParameter		=	 bean.getDefaultStParameter();
	String default_doc_type_code			=	(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	
	//Added by Rabbani #Inc no:30909 on 12/03/12 Starts
	
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
	 //ends


%>
<body onload='FocusFirstElement();document.formRequisitionIssueQueryCriteria.submit();'>
	<form name= "formRequisitionIssueQueryCriteria" action="../../eST/jsp/RequisitionIssueAuthorizeQueryResult.jsp" method="post" target="RIAuthorizeQueryResultFrame">
	<table border="0" cellspacing="0" width="100%" align="center">
	  <tr>
		<td  class="label">
			<fmt:message key="eST.Requestsof.label" bundle="${st_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="request_type" id="request_type">
			<OPTION VALUE="N"><fmt:message key="eST.InternalStores.label" bundle="${st_labels}"/></OPTION>
			<OPTION VALUE="Y"><fmt:message key="eST.ExternalStores.label" bundle="${st_labels}"/></OPTION>
		<!-- 	<OPTION VALUE="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION> -->
				
			</select>
		</td>
		<td class="label" >
			<fmt:message key="Common.DocType.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="doc_type_code" id="doc_type_code">
				<%=bean.getDocTypeCodes()%>
			</select>
		</td>
		<td>
			&nbsp;&nbsp;
		</td>
		<td>
			&nbsp;&nbsp;
		</td>

	  </tr>
	   <tr>
		<td  class="label">
			<fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/>
		</td>
		<!-- Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts  -->
		<%if(bean.getAllow_Auth_Issue_store().equals("N")){
		%>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="request_on_store" id="request_on_store" onBlur="populateToStoresInQuery(this);" onchange="loadItemClass(this,request_by_store);">
				<%=bean.getRequestOnStoreQuery()%>
			</select>
		</td >
		<%}else { %>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="request_on_store" id="request_on_store" onBlur="populateToStoresInQuery(this);" onchange="loadItemClass(this,request_by_store);">
				<%=bean.getRequestOnStoreQuery1()%>
			</select>
		</td >
		<%} %>
				<!-- Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends  -->
			<td class="label" >
			<fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="request_by_store" id="request_by_store" onchange="loadItemClass(request_on_store,this);">
				<%=default_value%>
			</select>
		</td>
		<td>
			&nbsp;&nbsp;
		</td>
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		<td>
			&nbsp;&nbsp;
		</td>

	  </tr>
	  <tr>
	 	<td  class="label">
			<fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10"  value="<%=currentdateminus%>" 
			onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>
			&nbsp;&nbsp;
			<label class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</label>
			&nbsp;&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" 
			onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"> </img>
		</td>
		<td  class='label'>
				<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>
		 </td>
		 <td class='fields'>
			 &nbsp;&nbsp;
			<input type="text" class="NUMBER" name="doc_no" id="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);">
		</td>
		<td>

			&nbsp;&nbsp;
		</td>
		 <td>&nbsp;</td>
	  </tr>
	  <tr>

	    <td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
	  	<td  >&nbsp;&nbsp;<select name="item_class_code" id="item_class_code" ><%=bean.getDefaultItemClasses()%></select></td>
	 	
		<td align="left" class="label">
			<fmt:message key="Common.item.label" bundle="${common_labels}"/>
		</td>
		 <td> 
			 &nbsp;&nbsp;
			<input type="text" name="item_code" id="item_code" size="20" maxlength="40"  value="" >
			<input type="button" name="item_search" id="item_search" value="?" class="button" onClick="return callItemSearchScreen_qry(item_code);">
		</td>
		 	
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		
	  </tr>
	  <tr>
	  <td  class="label">
			<fmt:message key="eST.ReqStatus.label" bundle="${st_labels}"/>
		</td>
		<td class='fields'>
			&nbsp;&nbsp;
			<select name="request_status" id="request_status">
			<option value="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
			<option value="W"><fmt:message key="eST.AuthorizedatRequestbyStore.label" bundle="${st_labels}"/></option>
			<!--<option value="P"><fmt:message key="Common.PartiallyIssued.label" bundle="${common_labels}"/></option>-->
		    <option value="PA">Partially Authorized At Issue Store</option> 
		    <option value="PAI">Partially Authorized/Issued at Issue Store</option> 
		    <option value="FAPI">Fully Authorized/Partially Issued at Issue Store</option> 
			</select>
		</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td class='fields' colspan='2'>
			<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="checkDocDate(document.forms[0]);">
		</td>
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="hdr.facility_id, hdr.doc_type_code, hdr.doc_no">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


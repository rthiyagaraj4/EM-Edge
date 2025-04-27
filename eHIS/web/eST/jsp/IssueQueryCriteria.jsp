<!DOCTYPE html>
<% 
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
21/01/2019		IN067798			B Haribabu						AMRI-CRF-0382 - New filter Authorized date

---------------------------------------------------------------------------------------------------------
*/ 
%> 

 <%@ page contentType="text/html;charset=UTF-8" import=" eST.*, eST.Common.* , eCommon.Common.* ,webbeans.eCommon.*,java.sql.*,java.lang.*,  java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eST/js/Issue.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=		 "<%= request.getParameter("function_id") %>"
		menu_id				=		"<%= request.getParameter("menu_id") %>"
		module_id			=		"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
//	String function_id		=		request.getParameter("function_id");
	String default_value	=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	String bean_id			=		 "issueBean";
	String bean_name		=		"eST.IssueBean";
	IssueBean bean			=		(IssueBean) getBeanObject(bean_id,  bean_name,request);  
	bean.setLanguageId(locale);
	bean.initialize();
	ServletContext context  =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	HashMap defaultParameter		=		bean.getDefaultStParameter();
	String default_doc_type_code	=		(String)defaultParameter.get("DEF_TFR_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));
	
	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	if(homepage.equals("Y"))
		bean.setFrom_store_code(store_code);

	//Added by Sakti Sankar #Inc no: on 25/03/13 Starts
	  
	HashMap alstartdate           = bean.getDurationforStartDate();
    String currentdate			  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus		  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
//ends

//Added for AMRI-CRF-0382 starts 
		Connection con				= null;
		boolean auth_date_filter_app =false;
		try {
		con						= ConnectionManager.getConnection(request);
		auth_date_filter_app = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_ISSUE_QUERY_AUTH_DATE_FLT");
		bean.setSite_spec_yn(auth_date_filter_app);
		}
		catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
		}
		finally{
			

			if(con != null)
				ConnectionManager.returnConnection(con,request);
		
		}
		
		ArrayList urg_doctype_codes=null;
		urg_doctype_codes=bean.getAllUrgDocType();
	      String urg_doctype_codes_temp = "";
	      for (int j = 0; j < urg_doctype_codes.size(); j++) { 
	    	  urg_doctype_codes_temp += (String) urg_doctype_codes.get(j).toString()  + "@"; 
	        } 
	      if (urg_doctype_codes_temp != null && urg_doctype_codes_temp.length() > 0 && urg_doctype_codes_temp.charAt(urg_doctype_codes_temp.length() - 1) == '@') {
	    	  urg_doctype_codes_temp = urg_doctype_codes_temp.substring(0, urg_doctype_codes_temp.length() - 1);
	      }
		//Added for  AMRI-CRF-0382 ends
		
		

		
%>

<body onload='FocusFirstElement();onloadvalidation();searchResult();'> <!-- Modified for  AMRI-CRF-0382  -->
	<form name= "formIssueQueryCriteria" action="../../eST/jsp/IssueQueryResult.jsp" method="post" target="IssueQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" id="doc_type_code" onchange="onChangeFilter(this,'<%=auth_date_filter_app%>','<%=urg_doctype_codes_temp%>');changeMode(this,'<%=urg_doctype_codes_temp%>');" onFocus="populateToStoresInQuery(fm_store)" onchange="location.href='../../eST/jsp/IssueQueryResult.jsp?option=' + this.value ;"><%=bean.getAllIssDocTypeCodes()%></select></td> <!-- Modified for  AMRI-CRF-0382  -->
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
		<!--<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" ></img> </td>-->
		<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img></td>

		<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="fm_store" id="fm_store" onBlur="populateToStoresInQuery(this);"><%=bean.getFromStore()%></select></td>
		<td  class="label"><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="to_store" id="to_store" onBlur="loadItemClassesInQuery(fm_store,this);"><%=default_value%></select></td>	 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='3'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
		<!-- Added for  AMRI-CRF-0382 START -->
		</tr>
		<tr>
		<%if(auth_date_filter_app ){ %>
		
		<td  class="label" id="fromauthdate" ><fmt:message key="eST.FromAuthorizeDate.label" bundle="${st_labels}"/></td>
		<td class='fields' id="fromauthdate1" >
			&nbsp;
			<input type="text" name="from_authorize_date" id="from_authorize_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');fromDateCheck(this);">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_authorize_date');"></img></td>
		<td  class="label" id="toauthdate" ><fmt:message key="eST.ToAuthorizeDate.label" bundle="${st_labels}"/></td>
		<td class='fields' id="toauthdate1" >
			&nbsp;
			<input type="text" name="to_authorize_date" id="to_authorize_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');toDateCheck(this);">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_authorize_date');"></img></td>	</div>
		<%} %>
	    <!-- Added for  AMRI-CRF-0382 ends -->	
		<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td class="feilds">&nbsp;
			<select name="trn_type" id="trn_type">
				<OPTION VALUE="HDR.TRN_TYPE ASC"><fmt:message key="eST.NormalIssues.label" bundle="${st_labels}"/>
				</option>
				<OPTION VALUE="HDR.TRN_TYPE DESC" selected><fmt:message key="eST.UrgentIssues.label" bundle="${st_labels}"/>
				</option>
			</select>
		&nbsp;&nbsp;&nbsp;&nbsp;
			<select name="doc_type_order" id="doc_type_order" id="doctypeorder">
				<OPTION VALUE="HDR.DOC_NO"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></option>
				<OPTION VALUE="FMS.SHORT_DESC"><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></option>
				<OPTION VALUE="TOS.SHORT_DESC"><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></option>
			</select>
			<select name="order" id="order">
				<OPTION VALUE="ASC"><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
				<OPTION VALUE="DESC"><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<td colspan=5>&nbsp;&nbsp;</td>
		<td class='fields'>&nbsp;<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'     onClick="if(searchResult())checkSysdateTo(to_doc_date,from_doc_date); "></td> <!--IF condition Added for TTM-SCF-0182 -->
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="siteid" id="siteid" id="site_id" value="<%=auth_date_filter_app%>">
		 <input type="hidden" name="urgdoccode" id="urgdoccode" id="urg_doccode" value="<%=urg_doctype_codes_temp%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<!-- <input type="hidden" name="orderbycolumns" id="orderbycolumns" value="fm_store_code,hdr.doc_date,doc_type_code,hdr.doc_no"> -->
		<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="REQ.facility_id,HDR.FACILITY_ID, hdr.doc_type_code, hdr.doc_no">
		<input type="hidden" name="start_date" id="start_date" value="<%=currentdateminus%>"> <!-- Added for  AMRI-CRF-0382  -->
		<input type="hidden" name="end_date" id="end_date"  value="<%=currentdate%>"> <!-- Added for  AMRI-CRF-0382  -->
		<input type="hidden" name="locale" id="locale"  value="<%=locale%>"> <!-- Added for  AMRI-CRF-0382  -->
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>


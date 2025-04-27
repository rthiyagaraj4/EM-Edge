<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>


<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOR/js/RefusalOrders.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		
		
		function change_common_tab(obj,chk_yn)
		{  
			//alert(obj);
			   			
			if((obj=="View") )
			{	//(licence_key=="ORPV") Only For Alrabha Version(Pharmacy Version) to load the Pharamacy Tab
				//alert("view");
				colorChange(obj);
 				//parent.refusal_main.location.href = "../../eOR/jsp/RefusalOrdersTab.jsp?<%=request.getQueryString()%>&tab_name=View";
			}
			else if( obj=="Refusal" )
			{
				//alert("refusal");
				colorChange(obj);
   		  		//parent.refusal_main.location.href = "../../eOR/jsp/RefusalOrdersTab.jsp?<%=request.getQueryString()%>";
		  	}
			
			if(top.content)
				top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
		}

		function colorChange(obj) {
			/*if(document.refusaltab_form.all.viewRefusal){
				document.refusaltab_form.all.viewRefusal.className  = "CAFIRSTSELECTHORZ";
				alert('here');
			}if(document.refusaltab_form.all.refusalType){
				document.refusaltab_form.all.refusalType.className		= "CASECONDSELECTHORZ";
				alert('hereeeeeeeeeeeeeee');
			}*/
			if(obj=='View'){
				document.refusaltab_form.viewRefusal.className  = "CASECONDSELECTHORZ";
				document.refusaltab_form.refusalType.className		= "CAFIRSTSELECTHORZ";
				//alert('here');
			}else if(obj=='Refusal'){
				document.refusaltab_form.viewRefusal.className  = "CAFIRSTSELECTHORZ";
				document.refusaltab_form.refusalType.className		= "CASECONDSELECTHORZ";
				//alert('hereeeeeeeeeeeeeee');
			}
		}
		function changeColor(obj,from_name)
		{
			if(from_name=="COMMON")
				cellref = document.getElementById("tab").rows(0).cells
			for(i=0; i<cellref.length; i++)
			{
				if(i!=2 && i!=3)
				 cellref[i].className = 'CAFIRSTSELECTHORZ'
			}
			obj.className = "CASECONDSELECTHORZ"
			currClass ="CASECONDSELECTHORZ";
		}
		function callOnMouseOver(obj){
		currClass = obj.className ;
		 obj.className = 'CASECONDSELECTHORZ';
		 
		}

function callOnMouseOut(obj){
	obj.className = currClass;
}
	</script>
	<STYLE TYPE="text/css"></STYLE>
 </head>
<%
			bean.setLanguageId(localeName);

	//String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");

	//String class_name_first		= "";
		request.setCharacterEncoding("UTF-8");

	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");
	//out.println("<script>alert('in existing page,patient_id="+patient_id+"')</script>");
	//String tab_name = (request.getParameter("tab_name")==null) ? "View":request.getParameter("tab_name");
	
	//SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
	//java.util.Date date_time= new java.util.Date();
	//String dateString 		= date_format.format(date_time);
	Properties properties	= (Properties) session.getValue( "jdbc" );
	String curr_sys_date			= "";
	String last_month_date			= "";
	//String sys_time_sec				= "";

	ArrayList sysdate = (ArrayList)bean.getSysDateTime(properties);
	for(int i=0;i<sysdate.size();i++){
		curr_sys_date	= (String)sysdate.get(0);
		last_month_date = (String)sysdate.get(4);

		//sys_time_sec	 = (String)sysdate.get(5);
		//curr_sys_date	= (String)sysdate.get(2);
		//last_month_date = (String)sysdate.get(3);
	}
//out.println("<script>alert('==="+request.getQueryString()+"===')</script>");
//out.println("<script>alert('==="+dateString+"===')</script>");
	
	
	/* Thai date validations start 14/02/2007*/
    if(curr_sys_date.equals("null") || curr_sys_date.equals(" ")) curr_sys_date="";
	if(last_month_date.equals("null") || last_month_date.equals(" ")) last_month_date="";

    curr_sys_date = com.ehis.util.DateUtils.convertDate(curr_sys_date,"DMY","en",localeName);
    last_month_date = com.ehis.util.DateUtils.convertDate(last_month_date,"DMY","en",localeName);
   String temp_curr_sys_date = curr_sys_date;
   String temp_last_month_date = last_month_date;
/* Thai date validations end 14/02/2007*/


	

// Till here 21/05/2003
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="refusalsearch_form" id="refusalsearch_form"> 
	<table  cellspacing=0 cellpadding="3" border="0" width='100%'  align="center">
	
	<tr>
		<!-- <td class='label' width='40%'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;View&nbsp;<select name="view" id="view">
		<option value="">All</option>
		<option value="C">Current Encounter</option>
		</select></td> -->
		<td class='label'><input type="hidden" name="view" id="view" value="" >
		<fmt:message key="eOR.RefusalType.label" bundle="${or_labels}"/></td>
		<td class="fields">
		<select name="refusal_type" id="refusal_type" onchange='callRefusal(this)'>
		<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value="O"><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="eOR.NonOrderable.label" bundle="${or_labels}"/></option>
		</select></td>
		<td class='label'><fmt:message key="Common.catalog.label" bundle="${common_labels}"/></td>
		<td >
			<input type="text" name="catalog_desc" id="catalog_desc" onblur='callRefusalOrderOrderables(catalog_desc)'><input class="button" type="button" name='catalog_lookup' id='catalog_lookup' size=50 value="?" onClick='callRefusalOrderOrderable1(catalog_desc)'>

		</td>
		</tr>
		
	<tr><!-- chckDate(this) -->
	<td class='label'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
	 <td><!-- <input type="text" name="date_from" id="date_from" value="<%=last_month_date%>" size="10" maxlength="10" onBlur="CheckDate(this)" onKeyPress='return OrAllowDateFormat()'> --><input type="text" name="date_from" id="date_from" value="<%=last_month_date%>" size="10" maxlength="10" onBlur="chckDate(this)" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_from');" style='cursor:pointer'>-<input type=text name='date_to' id='date_to' value='<%=curr_sys_date%>' size="10" maxlength="10" onBlur="checkDateRange(this,'refusalsearch_form')" onKeyPress='return OrAllowDateFormat()'><img src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendar('date_to');" style='cursor:pointer'> </td>
	<td class="label">
		   <input type="hidden" name="catalog_code" id="catalog_code" value="">
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
			<td>
			<select name="order_by" id="order_by">
			<option value="d"><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></option>
			</select>
	</td>

		</tr>
		<tr>
		<td colspan=4>
		</td>
		<td class='button'>
			<input class="button" type="button" name="search" id="search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick='populateExistingValues()'>
			<input class="button" type="button" name="clear" id="clear" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick='clearSearchValues()'>
			
		</td>
		
		</tr>
	</table>
	<%if(!imgUrl.equals("")){ %>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">

	<input type="hidden" name="temp_curr_sys_date" id="temp_curr_sys_date" value="<%=temp_curr_sys_date %>">
    <input type="hidden" name="temp_last_month_date" id="temp_last_month_date" value="<%=temp_last_month_date %>">
     <input type="hidden" name="localeName" id="localeName" value="<%=localeName %>">

	<script>
	populateExistingValues();
	</script>

	<input type="hidden" name="module_id" id="module_id" value="">
</form>
</body>
</html> 

 


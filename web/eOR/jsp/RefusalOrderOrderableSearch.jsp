
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- RefusalOrderOrderableSearch.jsp -->
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
28/11/2012		IN031304		Karthi L		To default Radiology Category code during order catalog search when Radiology Appointement is checked(IN035976)  
---------------------------------------------------------------------------------------------------------------
*/ %>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
    </script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="callDisable();searchResult1();">
<%
	/* Mandatory checks start */
		request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String CallingModule = (request.getParameter("CallingModule")==null) ? "":request.getParameter("CallingModule");
	String mode	   = request.getParameter("mode") ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	String order_category = (request.getParameter("order_category")==null) ? "":request.getParameter("order_category");
	String order_type = (request.getParameter("order_type")==null) ? "":request.getParameter("order_type");
	String activity_type = (request.getParameter("activity_type")==null) ? "":request.getParameter("activity_type");
	String searchText = request.getParameter("searchText");
	if(searchText==null) searchText = "";
	String called_from = request.getParameter("called_from");

	// Apart from the Normal Parameters, when passed from Clinic (OA) p_clinic_code will be passed
	// And p_speciality_code if speciality is selected, if from OP and if Wing/OT is selected service_code, p_wing_code and p_service_code will be passed 
	String p_clinic_code = (request.getParameter("p_clinic_code")==null) ? "":request.getParameter("p_clinic_code");
	String p_speciality_code = (request.getParameter("p_speciality_code")==null) ? "":request.getParameter("p_speciality_code");
	String p_service_code = (request.getParameter("p_service_code")==null) ? "":request.getParameter("p_service_code");
	String p_wing_code = (request.getParameter("p_wing_code")==null) ? "":request.getParameter("p_wing_code");
	//Added by Uma on 3/12/2010 for IN019490
	String practitionerId = (request.getParameter("practitionerId")==null) ? "":request.getParameter("practitionerId");
	//String table_name = request.getParameter("table_name");
	String rd_appt_yn = (request.getParameter("rd_appt_yn")==null) ? "":request.getParameter("rd_appt_yn"); // added for IN031304
	String locn_Code = (request.getParameter("locnCode")==null) ? "":request.getParameter("locnCode"); // added for IN031304
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);

	ArrayList getOrderCategory = new ArrayList();
	ArrayList OrderTypes = new ArrayList();
	ArrayList ActivityType = new ArrayList();
	if(called_from.equalsIgnoreCase("OP") || called_from.equalsIgnoreCase("OA"))
	{
		if (called_from.equalsIgnoreCase("OP"))// modified for IN031304
		{
			getOrderCategory = (ArrayList) bean.getOrderCategoryOPOA();
			OrderTypes = (ArrayList )bean.getLocationOPOA(order_category);
		}
		else { // added for IN031304
			if(called_from.equalsIgnoreCase("OA") && rd_appt_yn.equalsIgnoreCase("N")) 
			{
				getOrderCategory = (ArrayList) bean.getOrderCategoryOPOA();
				OrderTypes = (ArrayList )bean.getLocationOPOA(order_category);
			}
			else
			{
				getOrderCategory = (ArrayList) bean.getOrderCategoryOARADYN();
				OrderTypes = (ArrayList )bean.getLocationOPOA(order_category);
			}
		}
	}
	else
	{
		getOrderCategory = (ArrayList) bean.getOrderCategory();
		OrderTypes = (ArrayList ) bean.getLocation(order_category);
	}

		ActivityType	= (ArrayList ) bean.getActivityType(order_category, order_type);
	
%>
<form name="RefusalOrderableSearch" id="RefusalOrderableSearch" target='' action=''>

<table align="center"  border="0" width="100%"  cellspacing="0" cellpadding="3">
<tr>
<td class="label" nowrap><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td><td class='fields'>
<select name="ordercategory" id="ordercategory" onChange="populateOrderCodes(this)">
<!-- added forIN031304 - Start -->
<%
if(called_from.equalsIgnoreCase("OA") && rd_appt_yn.equalsIgnoreCase("Y"))
{
	if(!order_category.equals(""))
	{
		for(int i=0;i<getOrderCategory.size();i++)
		{
			String getcategory[]=(String[])getOrderCategory.get(i);
				
%>
	<option value="<%=getcategory[0].trim() %>" <%=eHISFormatter.select(order_category.trim(),getcategory[0].trim())%> ><%=getcategory[1]%></option>
<%
		}
	}
	else
	{
		for(int i=0;i<getOrderCategory.size();i++)
		{
			String getcategory[]=(String[])getOrderCategory.get(i);
			
%>
		<option value="<%=getcategory[0]%>" ><%=getcategory[1]%></option>
<%
		}
	}
}
else
{
%>
<!-- added forIN031304 - END -->
<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
	if(!order_category.equals(""))
	{
		for(int i=0;i<getOrderCategory.size();i++)
		{
			String getcategory[]=(String[])getOrderCategory.get(i);
%>
			<option value="<%=getcategory[0].trim() %>" <%=eHISFormatter.select(order_category.trim(),getcategory[0].trim())%>><%=getcategory[1]%></option>
<%
		}
	}
	else
	{
		for(int i=0;i<getOrderCategory.size();i++)
		{
			String getcategory[]=(String[])getOrderCategory.get(i);
%>
			<option value="<%=getcategory[0]%>"><%=getcategory[1]%></option>

<%
		}
	}
}  //added forIN031304
%>
</select>
</td>
<td class="label" nowrap><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td><td class='fields'>
<select name="typecode" id="typecode" onChange="populateActivity(this)">
<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
if(!order_type.equals(""))
{
for(int i=0;i<OrderTypes.size();i++)
{
	String getordertype[] = (String[])OrderTypes.get(i);
%>
<option value="<%= getordertype[0].trim()%>"
<%=eHISFormatter.select(order_type.trim(),getordertype[0].trim())%>><%=getordertype[1]%></option>
<%
}
}else{
	for(int i=0;i<OrderTypes.size();i++)
{
	String getordertype[] = (String[])OrderTypes.get(i);
%>
<option value="<%=getordertype[0]%>"><%=getordertype[1]%></option>
<%
}
}
%>
</select>
</td></tr><tr>
<td class="label" nowrap><fmt:message key="eOR.ActivityType.label" bundle="${or_labels}"/></td><td class="fields">
<select name="activity_type" id="activity_type" onChange="makeResultBlank()">
<option value="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
 
for(int i=0;i<ActivityType.size();i++)
{
	String getactivitytype[] = (String[])ActivityType.get(i);
%>
	<option value="<%=getactivitytype[0].trim()%>"
<%
if(!ActivityType.equals(""))
{
%>
	<%=eHISFormatter.select(activity_type.trim(),getactivitytype[0].trim())%>><%=getactivitytype[1]%></option>
<% } else { %>
	<option value="<%=getactivitytype[0]%>"><%=getactivitytype[1]%></option>
<% } %>
<% } %>
 
</select>
</td><td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td><td class="fields">
       <input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick="storeVal(this)"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		</td></tr><tr>
		<td class="label">
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td><td class='fields'>
        <select name="search_criteria" id="search_criteria" onChange="makeResultBlank()">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select>
        </td>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td><td class='fields'>
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" 
		value='<%=searchText%>' width="30%" align="left" size="40" maxlength="70" onKeyPress="populateSearch()">
        </td></tr><tr>
		<td colspan=3></td>
        <td class="button" align="right" nowrap ><input type="button" align="left" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="searchResult1()" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="resetFormSearch(this.form)" class="button" >
        </td>
    </tr>

</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="called_from" id="called_from" value="<%= called_from%>">

<input type="hidden" name="p_clinic_code" id="p_clinic_code" value="<%=p_clinic_code%>">
<input type="hidden" name="p_speciality_code" id="p_speciality_code" value="<%=p_speciality_code%>">
<input type="hidden" name="p_wing_code" id="p_wing_code" value="<%=p_wing_code%>">
<input type="hidden" name="p_service_code" id="p_service_code" value="<%=p_service_code%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="templocale" id="templocale" value="<%=localeName%>">
<input type="hidden" name="CallingModule" id="CallingModule" value="<%=CallingModule%>">
<!-- Added by Uma on 3/12/2010 for IN019490 -->
<input type="hidden" name="practitionerId" id="practitionerId" value="<%=practitionerId%>">
<!-- Ends Here -->
<input type="hidden" name="locn_Code" id="locn_Code" value="<%=locn_Code%>"> <!-- IN031304	 -->
<input type="hidden" name="rd_appt_yn" id="rd_appt_yn" value="<%=rd_appt_yn%>"> <!-- IN031304	 -->
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>


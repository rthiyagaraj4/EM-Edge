<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../js/WaitTimePendingOrders.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	
	String mode = (String )request.getParameter("mode");
	String facility_id = (String )session.getAttribute("facility_id");
	String bean_id = "Or_WaitTimePendingOrders";
	String bean_name = "eOR.WaitTimePendingOrdersBean";
	
	WaitTimePendingOrdersBean bean = (WaitTimePendingOrdersBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	String sql_or_order_entry_catalog = OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CATALOG");
	String sql_or_waiting_list_catalog = OrRepositoryExt.getOrKeyValue("SQL_OR_WAITING_LIST_CATALOG");
	//int		totalRecords	=	0;
	ArrayList Category_Data = new ArrayList();
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">
<form name="form_wait_time_pending" id="form_wait_time_pending">
<%
	String classVal = "";
	int noOfRecords = 0;
	if(mode.equalsIgnoreCase("1"))
	{
		noOfRecords = 10;
	%>
	<table class='grid' width="100%">
	<tr>
		<td class='COLUMNHEADER'  rowspan="2" width='21%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' rowspan="2" width='19%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' rowspan="2" width='25%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'  rowspan="2" width='5%'><fmt:message key="Common.active.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'  colspan="3" width='30%'><fmt:message key="eOR.WaitingTime.label" bundle="${or_labels}"/></td>
		
	</tr>
		<tr>
		
		<td class='COLUMNHEADER'><fmt:message key="Common.Green.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/></td>	
		<td class='COLUMNHEADER'><fmt:message key="Common.Red.label" bundle="${common_labels}"/></td>	
		
	</tr>	
	<%	for(int i=0;i<noOfRecords;i++)
		{
			if(i%2 == 0)
				classVal = "gridData";
			else
				classVal = "gridData";
	%>
		<tr>
			<td class='<%= classVal %>' >
				<select name="order_category<%=i%>" id="order_category<%=i%>" onchange="populateOrderTypes(this,<%=i%>)" onblur='parent.resetColorCode(this)'>
					<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<%
					Category_Data = bean.getOrderCategory();
					for(int j=0; j<Category_Data.size(); j++){
						String[] record = (String [])Category_Data.get(j);
				%>
						<option value='<%=record[0]%>'><%=record[1]%></option>
				<%	
					}Category_Data=null;
				%>
				</select><%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%>
			</td>
			<td class='<%= classVal %>' >
				<select name="order_type<%=i%>" id="order_type<%=i%>" onchange="showCatalogButtn(this,<%=i%>)" onblur='parent.resetColorCode(this)'>
					<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				</select><%if(i==0){%><img src="../../eCommon/images/mandatory.gif"></img><%}%>
			</td>
			
			<td class='<%= classVal %>' ><!-- <input type=text name="order_catalog_val<%=i%>" id="order_catalog_val<%=i%>" size=16 maxlength=40 onblur="parent.resetColorCode(this);searchForOrderCatalog(order_category<%=i%>,order_type<%=i%>,order_catalog_val<%=i%>,<%=i%>,this)" value='' readonly> -->
			<input type=hidden name="order_catalog<%=i%>" id="order_catalog<%=i%>" value="">
			<input type=text name="order_catalog_val<%=i%>" id="order_catalog_val<%=i%>" size=16 maxlength=40 onblur="parent.resetColorCode(this);searchForOrderCatalog(order_category<%=i%>,order_type<%=i%>,this,<%=i%>)" value="All" readonly>
			<input type=button class=button value="?" name="order_catalog_butn<%=i%>" id="order_catalog_butn<%=i%>" onclick="searchForOrderCatalog(order_category<%=i%>,order_type<%=i%>,order_catalog_val<%=i%>,<%=i%>);" style="visibility:hidden"><%if(i==0){%><img src="../../eCommon/images/mandatory.gif" align=center></img><%}%>
			</td>
			<td  class='<%= classVal %>'><input type=checkbox name="active_stat<%=i%>" id="active_stat<%=i%>" value="Y" checked onclick="chkValue(this,<%=i%>)"></td>
			
			<td class='<%= classVal %>' ><input type=text name="wait_time_green<%=i%>" id="wait_time_green<%=i%>" size=5 maxlength=6 onkeypress="return allowPositiveNumber()" onBlur="parent.resetColorCode(this);checkPositiveNumber(this);return chkWaitTime(this,<%=i%>)" ></td>
			
			<td class='<%= classVal %>' ><input type=text name="wait_time_yellow<%=i%>" id="wait_time_yellow<%=i%>" size=5 maxlength=6 onkeypress="return allowPositiveNumber()" onBlur="parent.resetColorCode(this);checkPositiveNumber(this);return chkWaitTime(this,<%=i%>)" ></td>
			
			<td nowrap class='<%= classVal %>' ><input type=text name="wait_time_red<%=i%>" id="wait_time_red<%=i%>" size=5 maxlength=6 onkeypress="return allowPositiveNumber()" onBlur="parent.resetColorCode(this);checkPositiveNumber(this);return chkWaitTime(this,<%=i%>)" ><%if(i==0){%><img style="visibility:visible" id='img_red_mode1<%=i%>' src="../../eCommon/images/mandatory.gif"></img><%}%></img></td>
		</tr>
		<%}	%>
		</table>
		<%
		}else if(mode.equals("2")){
			String enableStatus="";
	//		String readOnly = "readonly" ;
			String order_category = request.getParameter("order_cat")==null?"":request.getParameter("order_cat");
			String order_type_code = request.getParameter("order_type_code")==null?"":request.getParameter("order_type_code");
			String order_type_desc = request.getParameter("order_type_desc")==null?"":request.getParameter("order_type_desc");
			String order_catalog_code = request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
			String order_catalog_desc = request.getParameter("order_catalog_desc")==null?"":request.getParameter("order_catalog_desc");
			String wait_green = request.getParameter("wait_green")==null?"":request.getParameter("wait_green");
			String wait_yellow = request.getParameter("wait_yellow")==null?"":request.getParameter("wait_yellow");
			String wait_red = request.getParameter("wait_red")==null?"":request.getParameter("wait_red");
			String active_stat = request.getParameter("active_stat")==null?"":request.getParameter("active_stat");
			String order_category_desc ="";

			String[] LoadData = new String[8];
			LoadData = bean.loadData(order_category,order_type_code,order_catalog_code);
			
			order_category		 = LoadData[0];
			order_type_code		 = LoadData[1];
			order_catalog_code	 = LoadData[2];
			wait_green			 = LoadData[3];
			wait_yellow			 = LoadData[4];
			wait_red			 = LoadData[5];
			active_stat			 = LoadData[6];
			order_category_desc			 = LoadData[7];

			if(wait_green == null)
				wait_green = "";
			if(wait_yellow == null)
				wait_yellow = "";
			if(wait_red == null)
				wait_red = "";
			
			if(active_stat.equalsIgnoreCase("N")){
				  enableStatus = "disabled"	  ;

			}
				
					
		%>
		<table cellpadding=3 cellspacing=0 border=0 width='100%'  align='center'>
		
		<tr>
			<td  class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type=text name='order_category_desc' id='order_category_desc' size=15 maxlength=15 value="<%=order_category_desc.trim()%>" readonly  disabled></td>
			<input type='hidden' name='order_category' id='order_category' value="<%=order_category.trim()%>">
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name='order_type_desc' id='order_type_desc' size=15 maxlength=15 value="<%=order_type_desc.trim()%>" readonly
			disabled></td>
			<input type='hidden' name='order_type' id='order_type' value="<%=order_type_code.trim()%>">
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type=text name='order_catalog_desc' id='order_catalog_desc' size=40 maxlength=40 value="<%=order_catalog_desc.trim()%>" onBlur="makeValidString(this)" disabled readonly></td>
			<input type='hidden' name='order_catalog' id='order_catalog' value="<%=order_catalog_code.trim()%>">
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="eMP.ActiveStatus.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type="checkbox" name="active_stat" id="active_stat" size="1" value="<%=active_stat%>" <%=eHISFormatter.ChkBoxChecked("Y",active_stat)%> onclick="return chkValue(this,'')" ></td>
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="eOR.WaitTimeforGreen.label" bundle="${or_labels}"/></td>
			<td  class="fields"><input type=text name='wait_time_green' id='wait_time_green' size=5 maxlength=6 value="<%=wait_green.trim()%>" onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);return chkWaitTime(this,'')" <%=enableStatus%>>(<fmt:message key="eOR.Mins.label" bundle="${or_labels}"/>)
			<%if(active_stat.equals("Y")){%><img style="visibility:visible" id='img_green' src="../../eCommon/images/mandatory.gif"></img><%}else{%><img style="visibility:hidden" id='img_green' src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="eOR.WaitTimeforYellow.label" bundle="${or_labels}"/></td>
			<td  class="fields"><input type=text name='wait_time_yellow' id='wait_time_yellow' size=5 maxlength=6 value="<%=wait_yellow.trim()%>" onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);return chkWaitTime(this,'')" <%=enableStatus%>>(<fmt:message key="eOR.Mins.label" bundle="${or_labels}"/>)
			<%if(active_stat.equals("Y")){%><img style="visibility:visible" id='img_yellow' src="../../eCommon/images/mandatory.gif"></img><%}else{%><img style="visibility:hidden" id='img_yellow' src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		</tr>
		
		<tr>
			<td  class="label"><fmt:message key="eOR.WaitTimeforRed.label" bundle="${or_labels}"/></td>
			<td  class="fields"><input type=text name='wait_time_red' id='wait_time_red' size=5 maxlength=6 value="<%=wait_red.trim()%>" onkeypress="return allowPositiveNumber()" onBlur="checkPositiveNumber(this);return chkWaitTime(this,'')" <%=enableStatus%>>(<fmt:message key="eOR.Mins.label" bundle="${or_labels}"/>)
			<%if(active_stat.equals("Y")){%><img style="visibility:visible" id='img_red' src="../../eCommon/images/mandatory.gif"></img><%}else{%><img style="visibility:hidden" id='img_red' src="../../eCommon/images/mandatory.gif"></img><%}%></td>
		</tr>
		
		</table>
	<%	}
		
	%>

	<input type="hidden" name="sql_or_order_entry_catalog" id="sql_or_order_entry_catalog" value="<%=sql_or_order_entry_catalog%>">
	<input type="hidden" name="sql_or_waiting_list_catalog" id="sql_or_waiting_list_catalog" value="<%=sql_or_waiting_list_catalog%>">
	<!-- <input type='hidden' name='noOfRecords' id='noOfRecords' value="<%//= noOfRecords %>"> -->
	<input TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=noOfRecords%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%= facility_id %>">
	<input type='hidden' name='mode' id='mode' value="<%= mode %>">
	<input type='hidden' name='bean_id' id='bean_id' value="<%= bean_id %>">
	<input type='hidden' name='bean_name' id='bean_name' value="<%= bean_name %>">
	
</form>

</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);
 
%>


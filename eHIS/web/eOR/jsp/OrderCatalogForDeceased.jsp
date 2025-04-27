<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
14/11/2012		IN036069		Karthi L		Delete option for newly added rows
20/11/2012		IN036351		Karthi L		to display all order category code
20/11/2012		IN036352		Karthi L		to enable first row to remove
26/11/2012		IN036465		Karthi L		Unit test issue
17/12/2013		IN045197		Ramesh G		Bru-HIMS-CRF-348.2 - Embalm request
18/12/2013		IN045770		Ramesh G		Bru-HIMS-CRF-348.2- 45197/03
20/12/2013		IN045880		Ramesh G		Bru-HIMS-CRF-348.2- 45197/05
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="java.sql.*, java.util.*, eOR.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderCatalogForDeceased.js"></script>
		<Script language ="JavaScript" src ="../../eCommon/js/CommonLookup.js"></Script>
		<% int  index =0; %>
		<script language = "JavaScript">
			var index1=0;
			function counter()
			{
				index1 = index1+1;
			}
			function changeValue(upd)
			{
				if(upd == "Y")
				{
				}
			}
			function deleteRowOption()
			{
				var entryMode = document.orderCatalogRuleForm.mode.value
				if(index1 ==0 && entryMode ==1)
				{
					document.orderCatalogRuleForm.delete_row_check0.disabled='true';
				}
			}
			
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<%	
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String pageStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Properties props = (Properties)session.getAttribute("jdbc");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=pageStyle%>' type='text/css'/>
	</head>
<!--<body  onMouseDown="CodeArrest()" onKeyDown="lockKey();" onLoad ="deleteRowOption();"> --> <!-- commented for IN036352 --> 

	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey();"> <!-- modified for IN036352 -->
			<%
				String mode						= request.getParameter( "mode" ) ;
				String bean_id					= "Or_Catalog_For_Deceased" ;
				String bean_name    			= "eOR.OrderCatalogForDeceasedBean";
				int totalRecords				= 0;
				
				String upd_category_code 		= request.getParameter( "upd_category_code" ) ;
				String upd_order_type 			= request.getParameter( "upd_order_type" ) ;
				String upd_order_catalog_code 	= request.getParameter( "upd_order_catalog_code" ) ;
				String upd_postmortem_app 		= request.getParameter( "upd_postmortem_app" ) ;
				String upd_postmortem_type 		= request.getParameter( "upd_postmortem_type" ) ;
				String upd_allow_for_deceased 	= request.getParameter( "upd_allow_for_deceased" ) ;
				String order_category_short_code 	= request.getParameter( "order_category_short_code" ) ;
				String order_type_short_code 	= request.getParameter( "order_type_short_code" ) ;
				String order_catalog_short_code 	= request.getParameter( "order_catalog_short_code" ) ;
				String upd_category_code_yn	="N";
				String upd_order_type_yn		="N";
				String upd_order_catalog_code_yn	="N";
				String upd_postmortem_app_yn	="N";
				String upd_postmortem_type_yn	="N";
				String checked_yn ="";
				String g_allow_orders = upd_allow_for_deceased; // added for 36465
				
			%>
	<form name='orderCatalogRuleForm' id='orderCatalogRuleForm'>		
		<table cellpadding=0 cellspacing=0 width="100%"  border=0>
			<tr>
				<th class="columnheader" rowspan='2' width='15%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
				<th class="columnheader" rowspan='2' width='15%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
				<th class="columnheader" rowspan='2' width='17%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
				<th class="columnheader" colspan='2' width='38%'><fmt:message key="eOR.PostMortem.label" bundle="${or_labels}"/></th>				
				<th class="columnheader" rowspan='2' width='5%'><fmt:message key="eOR.AllowOrdersforDeceased.label" bundle="${or_labels}"/></th>
				<!-- <th class="columnheader" rowspan='2' width='5%'>Enable</th> --> <!-- IN036465 -->
				<!-- <th class="columnheader" rowspan='2' width='5%'>Select row to Delete</th> --> <!-- IN036465 -->
				<th class="columnheader" rowspan='2' width='10%'><fmt:message key="eOR.SelectrowtoRemove.label" bundle="${or_labels}"/></th> <!-- IN036465 -->
				<!-- <th class="columnheader" rowspan='2' width='5%'>Add / Remove Row</th> --> <!-- IN036465 -->
			</tr>
			<tr>
				
				<th class="columnheader" width='19%'><fmt:message key="eOR.appl.label" bundle="${or_labels}"/></th>
				<th class="columnheader" width='19%'><fmt:message key="eOR.Type.label" bundle="${or_labels}"/></th>
				
			</tr>
			
			<% if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){%>	
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<!-- <td>&nbsp;</td> --> <!-- IN036465 -->
				<td align = "center">
				<input type = 'button' name 'addOrRemoveRow' id = 'addOrRemoveRow' value = '+' style="font-size: 13px; font-family: Verdana;font-weight:bold;height:22px;
					width:24px;" onClick = 'counter();addRow(index1);' /> 
				<input type = 'button' name 'addOrRemoveRow' id = 'addOrRemoveRow' value = '-' style="font-size: 13px; font-family: Verdana;font-weight:bold;height:22px;
					width:24px;" onClick = 'deleteRow();' />
				</td>
			</tr>
			<%}%>	
		<table>
		<table id = 'orderDeceasedData' width="100%" table name = 'orderDeceasedData' cellpadding=0 cellspacing=0  border=0>
			
			<tr>
				<td width ='15%' align="center" >
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
					%>
					<select <%=eHISFormatter.chkReturn("y",upd_category_code_yn,"","disabled")%> name = "order_category<%=index%>" style="width:120px;" >
					
					<option> <%= upd_category_code%> </option>
					</select>
					<img src="../../eCommon/images/mandatory.gif"></img>
					<%}else{%>
					<select name = "order_category<%=index%>" onChange="getOrderTypes(order_category<%=index%>,<%=index%>);resetRowValue();" style="width:120px;">
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						beanQueryObj.setLanguageId(localeName);
						//ArrayList l_order_category = beanQueryObj.getOrderCategory(props); // commneted for IN036351
						ArrayList l_order_category = beanQueryObj.getAllOrderCategoryCode(props); // added for IN036351
						String[] l_category_details=null;
						
						for(int i=0; i<l_order_category.size(); i++)
						{
							l_category_details = (String[])l_order_category.get(i);
							out.println("<option value = '"+l_category_details[0]+"'>"+l_category_details[1]+"</option>");	 
						}
						
						l_order_category= null;
					%>
					
					</select>
					<img src="../../eCommon/images/mandatory.gif"></img>
					<%}
					%>
				</td>
				<td width ='15%' align="center">
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){ 
						%>
						<select name="order_type<%=index%>" id="order_type<%=index%>" style="width:120px;" name = "order_type<%=index%>" <%=eHISFormatter.chkReturn("y",upd_order_type_yn,"","disabled")%>
							>
							<option> <%= upd_order_type%> </option>
						</select>
					<%}else{%>		
					<select name="order_type<%=index%>" id="order_type<%=index%>" style="width:120px;"  name = "order_type<%=index%>" >
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							
						</select>
					<%}
					%>	
				</td>
				
				<td width ='17%' align="center">
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
						%>
					<input type="text" name="order_catalog_desc<%=index%>" id="order_catalog_desc<%=index%>"  style="width:140px;" <%=eHISFormatter.chkReturn("Y",upd_order_catalog_code_yn,"","disabled")%> 
						value = "<%=upd_order_catalog_code%>">
						<input type="hidden" name="order_catalog_code<%=index%>" id="order_catalog_code<%=index%>" value="">
					<%}else{%>	
						<input type="text" name="order_catalog_desc<%=index%>" id="order_catalog_desc<%=index%>" value="" style="width:100px;" onBlur='catalogsearchOnClick(order_catalog_desc<%=index%>,order_category<%=index%>,order_type<%=index%>);'> 
						<input type='button' class = "button" name="catalogSearch" id="catalogSearch" value="?" onClick='catalogsearchOnClick(order_catalog_desc<%=index%>,order_category<%=index%>,order_type<%=index%>);'>
						<input type="hidden" name="order_catalog_code<%=index%>" id="order_catalog_code<%=index%>" value="">
					<%}
					%>	
				</td>
				
				<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				{
				%>
					<td width='19%'><select name = "postmortem_appl<%=index%>"  <%=eHISFormatter.chkReturn("y",upd_postmortem_app_yn,"","disabled")%>  style="width:140px;" > <option> <%= upd_postmortem_app%> </option>
					</select>
					<img src="../../eCommon/images/mandatory.gif"></img></td>
					
				<%
				}else{
				%>	
					<td width='19%' align="center" >
						<select name = "postmortem_appl<%=index%>" style="width:120px;" onchange="chagePostmortemType(this,'postmortem_type<%=index%>')">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value = "B">All</option>
							<option value = "R">Post Mortem Request</option>
							<option value = "Q">Post Mortem Record</option>
							<option value = "E">Embalm Registration</option>  <!-- IN045197 -->
						</select>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				<%}
				%>	
				<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				{
				%>
					<td width='19%' align = "center" > 
						<select name = "postmortem_type<%=index%>"  <%=eHISFormatter.chkReturn("y",upd_postmortem_type_yn,"","disabled")%> style="width:170px;" > <option> <%= upd_postmortem_type %> </option>
						</select>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				<%
				}else{
				%>	
					<td width='19%' align = "center"> 
						<select name = "postmortem_type<%=index%>" style="width:170px;" >
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<option value = "B">Both</option>
							<option value = "C">Clinical Post Mortem</option>
							<option value = "M">Medico Legal Post Mortem</option>
							<option value = "E">Not Applicable</option>
						</select>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>	
				<%}
				%>	
					
				<td width ='5%' align ="center" > 
				<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				{
					if(upd_allow_for_deceased.equals("Y")){
						checked_yn = "checked";
				%>
						<input type='checkbox' name = "allow_for_deceased<%=index%>" value = <%= upd_allow_for_deceased %> <%=checked_yn%> onClick="chkValue('<%=index%>');" />
				<%
					} 
					else 
					{
						%>
						<input type='checkbox' name = "allow_for_deceased<%=index%>" value="N" onClick="chkValue('<%=index%>');"/>
						
					<%}
				}else{%>		
					<input type='checkbox' name = "allow_for_deceased<%=index%>" checked = true value="Y" onClick="chkValue('<%=index%>');"/> <!-- IN036465 -->
				<%}
				%>	
				</td>
				<!-- <td width = '5%' align = "center" > --> <!-- IN036465 -->
				<td width = '10%' align = "center" > <!-- IN036465 -->
				<%	 if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				{%>
				<%}
				else
				{%>	
				<!--commented for 36069	<input type='checkbox' name = "delete_row_check<%=index%>"onClick='deleteRowValue();'/> --> 
					<input type='checkbox' value = "" name = "delete_row_check<%=index%>" /> 
				<%}
				%>	
				</td>
				<!-- <td width = '5%'>&nbsp;</td> --> <!-- IN036465 -->
			</tr>
			
			
		</table>
			
			<input type='hidden' name='language_id' id='language_id' value='<%=localeName%>'/>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="upd_category_code" id="upd_category_code" value="<%=order_category_short_code%>">
			<input type="hidden" name="upd_order_type" id="upd_order_type" value="<%=order_type_short_code%>">
			<input type="hidden" name="upd_order_catalog_code" id="upd_order_catalog_code" value="<%=order_catalog_short_code%>">
			<input type="hidden" name="upd_postmortem_app" id="upd_postmortem_app" value="<%=upd_postmortem_app%>">
			<input type="hidden" name="upd_postmortem_type" id="upd_postmortem_type" value="<%=upd_postmortem_type%>">
			<input type="hidden" name="table_Id" id="table_Id" value="orderDeceasedData">
			<input type = "hidden" name="totalRecords" id="totalRecords" value ="<%=totalRecords%>">
			<input type = "hidden" name="deceased_check_yn" id="deceased_check_yn" value ="<%=checked_yn%>">
			<input type = "hidden" name="upd_allow_for_deceased" id="upd_allow_for_deceased" value ="<%=upd_allow_for_deceased%>">
			<input type = "hidden" name="g_allow_orders" id="g_allow_orders" value ="<%=g_allow_orders%>"><!-- 36465 -->
		</form>
		</body>		
		
</html>


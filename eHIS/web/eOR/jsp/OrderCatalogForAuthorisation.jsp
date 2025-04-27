<!DOCTYPE html>
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
14/03/2014     IN041644			Nijitha S		Prescription  Authorization of Drugs Based on Rules
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="java.sql.*, java.util.*, eOR.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<jsp:useBean id="beanObj" scope="page" class="eOR.OrderEntryBean"/>
<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderCatalogForAuthorisation.js"></script>
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

	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey();">
			<%
				String mode						= request.getParameter( "mode" ) ;
				String bean_id					= "Or_Catalog_For_Authorisation" ;
				String bean_name    			= "eOR.OrderCatalogForAuthorisationBean";
				int totalRecords				= 0;
				
				String upd_category_code 		= request.getParameter( "upd_category_code" ) ;
				String upd_order_type 			= request.getParameter( "upd_order_type" ) ;
				String upd_order_catalog_code 	= request.getParameter( "upd_order_catalog_code" ) ;
				String upd_duration_value 		= request.getParameter( "upd_duration_value" ) ;
				String upd_duration_type 		= request.getParameter( "upd_duration_type" ) ;
				String upd_duration_type_code =  request.getParameter( "upd_duration_type_code" ) ;
				String order_category_desc =  request.getParameter( "order_category_desc" ) ;
				String order_type_desc =  request.getParameter( "order_type_desc" ) ;
				String order_catalog_desc =  request.getParameter( "order_catalog_desc" ) ;
				
				String upd_category_code_yn	="N";
				String upd_order_type_yn		="N";
				String upd_order_catalog_code_yn	="N";
				
				String checked_yn ="";
				
				
			%>
	<form name='orderCatalogAuthoriseForm' id='orderCatalogAuthoriseForm'>		
		<table cellpadding=0 cellspacing=0 width="100%"  border=0>
			<tr>
				<th class="columnheader" rowspan='2' width='15%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
				<th class="columnheader" rowspan='2' width='15%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></th>
				<th class="columnheader" rowspan='2' width='17%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
				<th class="columnheader" rowspan='2' width='19%'><fmt:message key="eOR.DurationValue.label" bundle="${or_labels}"/></th>
				<th class="columnheader" rowspan='2' width='19%'><fmt:message key="eOR.Duration.label" bundle="${or_labels}"/> <fmt:message key="eOR.Type.label" bundle="${or_labels}"/></th>
				<%if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){ %>				
				<th class="columnheader" rowspan='2' width='%'><fmt:message key="eOR.SelectrowtoRemove.label" bundle="${or_labels}"/></th>
				<%
				}
				%>
				
			</tr>
			<tr>
			</tr>
			<% if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){%>	
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				
				<td align = "center">
				<input type = 'button' name='addOrRemoveRow' id = 'addOrRemoveRow' value = '+' style="font-size: 13px; font-family: Verdana;font-weight:bold;height:22px;
					width:24px;" onClick = 'counter();addRow(index1);' /> 
				<input type = 'button' name='addOrRemoveRow' id = 'addOrRemoveRow' value = '-' style="font-size: 13px; font-family: Verdana;font-weight:bold;height:22px;
					width:24px;" onClick = 'deleteRow();' />
				</td>
			</tr>
			<%}%>	
		<table>
		<table id = 'orderAuthorisationData' width="100%" table name = 'orderAuthorisationData' cellpadding=0 cellspacing=0  border=0>
			
			<tr>
				<td width ='15%' >
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
					%>
					<select <%=eHISFormatter.chkReturn("y",upd_category_code_yn,"","disabled")%> name = "order_category<%=index%>" id = "order_category<%=index%>" style="width:120px;" >
					
					<option> <%= order_category_desc%> </option>
					</select>
					
					<%}else{%>
					<select name = "order_category<%=index%>" id = "order_category<%=index%>" onChange="getOrderTypes(order_category<%=index%>,<%=index%>);resetRowValue();" style="width:120px;">
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<%
						beanQueryObj.setLanguageId(localeName);
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
				<td width ='15%'>
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){ 
						%>
						<select name="order_type<%=index%>" id="order_type<%=index%>" style="width:120px;" name = "order_type<%=index%>" <%=eHISFormatter.chkReturn("y",upd_order_type_yn,"","disabled")%>
							>
							<option> <%= order_type_desc%> </option>
						</select>
					<%}else{%>		
					<select name="order_type<%=index%>" id="order_type<%=index%>" style="width:120px;"  name = "order_type<%=index%>" >
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							
						</select>
					<%}
					%>	
				</td>
				
				<td width ='17%' align = "left">
					<% if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ))){
						%>
					<input type="text" name="order_catalog_desc<%=index%>" id="order_catalog_desc<%=index%>"  style="width:140px;" <%=eHISFormatter.chkReturn("Y",upd_order_catalog_code_yn,"","disabled")%> 
						value = "<%=order_catalog_desc%>">
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
					<td width='19%'><input type=text name="duration_value<%=index%>" id="duration_value<%=index%>" size="3" maxlength="3" value="<%=upd_duration_value%>" onblur='checkPositiveNumber(this);' onchange='updateDurationValue(this);'>
					<img src="../../eCommon/images/mandatory.gif"></img></td>
					
				<%
				}else{
				%>	
					<td width='19%' align = "left" class='fields'>
						<input type=text name="duration_value<%=index%>" id="duration_value<%=index%>" size="3" maxlength="3" value="" onblur='checkPositiveNumber(this);'>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				<%}
				%>	
				<% 
				beanObj.setLanguageId(localeName);
				ArrayList durationType = beanObj.getPlaceOrderDuration();
				String[] durationType_details=null;
				if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				{
				%>
					<td width='19%'align = "left" > 
						<select name = "duration_type<%=index%>" style="width:145px;" onchange='updateDurationType(this);' >
						<%
						
						for(int i=0; i<durationType.size(); i++)
						{
							durationType_details = (String[])durationType.get(i);
							
							if(durationType_details[0].equals(upd_duration_type_code))
							{								
								out.println("<option value = '"+durationType_details[0]+"' selected>"+durationType_details[1]+"</option>");
							}
							else
							{
								out.println("<option value = '"+durationType_details[0]+"'>"+durationType_details[1]+"</option>");
							}
						}
						
					%>
						</select>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>
				<%
				}else{
				%>	
					<td width='19%' align = "left"> 
						<select name = "duration_type<%=index%>" style="width:145px;" >
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
						
						for(int i=0; i<durationType.size(); i++)
						{
							durationType_details = (String[])durationType.get(i);
							out.println("<option value = '"+durationType_details[0]+"'>"+durationType_details[1]+"</option>");	 
						}
						
						durationType= null;
					%>
						</select>
						<img src="../../eCommon/images/mandatory.gif"></img>
					</td>	
				<%}
				%>	
					
				
				
				<%	 if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )))
				
				{%>	
					<td width = '15%' align = "center" >
					<input type='checkbox' value = "" name = "delete_row_check<%=index%>" /></td> 
				<%}
				%>	
				
			</tr>
			
			
		</table>
		
			<input type='hidden' name='language_id' id='language_id' value='<%=localeName%>'/>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="upd_category_code" id="upd_category_code" value="<%=upd_category_code%>">
			<input type="hidden" name="upd_order_type" id="upd_order_type" value="<%=upd_order_type%>">
			<input type="hidden" name="upd_order_catalog_code" id="upd_order_catalog_code" value="<%=upd_order_catalog_code%>">
			<input type="hidden" name="upd_duration_value" id="upd_duration_value" value="<%=upd_duration_value%>">
			<input type="hidden" name="upd_duration_type" id="upd_duration_type" value="<%=upd_duration_type_code%>">
			<input type="hidden" name="table_Id" id="table_Id" value="orderAuthorisationData">
			<input type = "hidden" name="totalRecords" id="totalRecords" value ="<%=totalRecords%>">
			
			
		</form>
		</body>		
		
</html>


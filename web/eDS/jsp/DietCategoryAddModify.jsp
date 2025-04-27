<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src="../../eDS/js/DietCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<Script>
function disableMeal(){
 	 if(document.getElementById("mode").value=='modify'){
	 	document.getElementById("diet_Category").readOnly="readonly";
	 	document.getElementById("long_Desc").readOnly="readonly";
	 	if(document.getElementById("order_Type").value != "")
	 	document.getElementById("order_Type").disabled=true;
	 }	
 }
</Script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=true;disableMeal();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String dietCategory = "";
   String orderType = "";
   String longDesc = "";


   String dietCategoryCode = request.getParameter("dietCategory");
   String disabled_flag = "";
   String readOnlyFlag = "";

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;

   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
	   		con = ConnectionManager.getConnection(request);
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_DIET_CATEGORY);
	   		pstmt.setString(1,dietCategoryCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			dietCategory = rst.getString("diet_category_code");
	   			longDesc = rst.getString("description");
	   			orderType = rst.getString("order_type_code");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Diet category->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Diet category:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.DietCategoryServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.DietCategoryCode.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="diet_Category" id="diet_Category" value="<%=dietCategory %>" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.Description.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  size="30" maxlength="30" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.OrderType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="order_Type" id="order_Type" onchange="orderTypeDuplicate(this.value);">
							<option><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />
							<%
							String orderTypeCode = "";
							String shortDesc = "";
							try{
								con = ConnectionManager.getConnection(request);
						   		pstmt = con.prepareStatement(DlQuery.DL_DIET_CATEGORY);
						   		pstmt.setString(1,"DS");
						   		pstmt.setString(2,locale);
						   		rst = pstmt.executeQuery();
						   		
						   		while(rst.next()){
						   			orderTypeCode = rst.getString("order_Type_Code");
						   			shortDesc = rst.getString("short_Desc");
						   			
						   			if(orderType != null && orderType.equals(orderTypeCode)) {%>
						   				<option  value="<%=orderTypeCode%>" selected><%=shortDesc%></option>
						   			<%}
						   			else {
						    %>
						    
						    <option  value="<%=orderTypeCode%>"><%=shortDesc%></option>	
						    <% }
						   		}
								}
							catch(Exception e){
						   		System.err.println("Error in Diet category->"+e);
					   		}
					   		finally{
					   			try{
									if(pstmt!=null) pstmt.close();
									if(rst!=null) rst.close();
									ConnectionManager.returnConnection(con);
								}
								catch(Exception e){
									System.err.println("Exception in Diet category:"+e);
								}
					   		}

							%>
							
							</option>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='description' id='description' value="">
			<input type='hidden' name=longDesc1 value="">
			<input type='hidden' name="ordList" id="ordList" value="">
		</form>
	</body>
</html>



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
<script language='javascript' src='../../eDS/js/Ingredients.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String ingredients = "";
   String shortDesc = "";
   String longDesc = "";
   String enabledYn = "";

   String ingredientsCode = request.getParameter("ingredients");
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
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_INGREDIENTS);
	   		pstmt.setString(1,ingredientsCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			ingredients = rst.getString("ingredient_code");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			enabledYn = rst.getString("eff_status");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Ingredients->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Ingredients:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.IngredientsServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.IngredientCode.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="ingredients" id="ingredients" value="<%=ingredients %>" size="40" maxlength="20" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  size="100" maxlength="60" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" size="50" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ItemCode.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="item_Code" id="item_Code" disabled>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.StockUOM.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="stock_Uom" id="stock_Uom" disabled>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
						</select>
					</td>
				</tr>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
			<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabledYn)){ %>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enabled_Yn" id="enabled_Yn"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enabled_Yn" id="enabled_Yn"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updIngredients' id='updIngredients' value='<%=ingredients%>'>
		</form>
	</body>
</html>



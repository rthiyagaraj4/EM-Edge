<!DOCTYPE html>
<!-- Added by Rajesh 28-8-12-->
<%@page import="eDS.Common.DlQuery"%>
<%@page import="java.io.File"%>
<!-- Added by Rajesh 28-8-12-->
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
<script language='javascript' src='../../eDS/js/FoodItem.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<!-- Modified by Rajesh 28-8-12-->
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- Modified by Rajesh 28-8-12-->
<% String foodItem = "";
   String longDesc = "";
   String shortDesc = "";
   String itemType = "";
   String servingUom = "";
   String preparationFactor = "";
   String calorieContent = "";
   String preparationUom = "";
   String baseQty = "";
   String enabled_yn = "";
   String foodItemCode = request.getParameter("foodItem");
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
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_FOOD_ITEM);
	   		pstmt.setString(1, locale);
	   		pstmt.setString(2, foodItemCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			foodItem = rst.getString("food_item_code");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			itemType = rst.getString("item_type");
	   			servingUom = rst.getString("serving_uom_code");
	   			preparationFactor = rst.getString("prep_factor");
	   			calorieContent = rst.getString("calorific_cont_per_uom");
	   			preparationUom = rst.getString("prep_uom");
	   			baseQty = rst.getString("prep_base_qty");
	   			enabled_yn = rst.getString("eff_status");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Food Item->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Food Item:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="foodItem_form" id="foodItem_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.FoodItemServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="left">
						<fmt:message key="eOT.FoodItemCode.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="food_Item" id="food_Item" value="<%=foodItem%>" size="20" maxlength="20" onblur="setFieldToUpperCase(this);" onkeypress="return checkAlpha(event)" <%=readOnlyFlag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				<tr>
					<td class='label' align="left">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc%>"  size="60" maxlength="60" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc%>" size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_ITEM_TYPE);
						pstmt.setString(1, locale);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="item_Type" id="item_Type">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("item_type").equals(itemType)){%>
									<option value="<%=rst.getString("item_type")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("item_type")%>">
								<%} %>
							<%=rst.getString("short_desc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.ServingUOM.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="serving_Uom" id="serving_Uom">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
							pstmt.setString(1, locale);
							rst = pstmt.executeQuery();
							while(rst.next()) {
								if(rst.getString("uom_code").equals(servingUom)){%>
									<option value="<%=rst.getString("uom_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("uom_code")%>">
								<%} %>
							<%=rst.getString("short_desc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>

					<td align="left" class='label'>
						<fmt:message key="eOT.PreparationUOM.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="preparation_Uom" id="preparation_Uom">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%pstmt = con.prepareStatement(DlQuery.DL_DS_GET_UOM);
							pstmt.setString(1, locale);
							rst = pstmt.executeQuery();
							while(rst.next()) {
								if(rst.getString("uom_code").equals(preparationUom)){%>
									<option value="<%=rst.getString("uom_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("uom_code")%>">
								<%} %>
							<%=rst.getString("short_desc")%>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>

				</tr>

				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.PreparationFactor.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="preparation_Factor" id="preparation_Factor" value="<%=preparationFactor  %>"  size="10" maxlength="10" onblur="CheckPosNumber('preparation_Factor')" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
					<td align="left" class='label'>
						<fmt:message key="eOT.PreparationBaseQty.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="base_Qty" id="base_Qty" value="<%=baseQty %>"  size="10" maxlength="10" onblur="CheckPosNumber('base_Qty')" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.CalorieContentUOM.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="calorie_Content" id="calorie_Content" value="<%=calorieContent %>"  size="10" maxlength="10" onblur="CheckPosNumber('calorie_Content')" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>

				</tr>
				<%}

				catch(Exception e){
					System.err.println("Exception in Food Item:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Food Item:"+e);
					}
				}
				%>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<%if("modify".equals(mode)){
							if("E".equals(enabled_yn)){ %>
								<input type="checkbox" name="enable" id="enable"  checked="checked"/>
							<%}
							else{%>
								<input type="checkbox" name="enable" id="enable"/>
							<%}
						}
						else{ %>
							<input type="checkbox" name="enable" id="enable"  checked="checked"/>
						<%} %>
					</td>
				</tr>
				<tr>
			</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updFoodItem' id='updFoodItem' value='<%=foodItem%>'>
			<input type='hidden' name='applyValue' id='applyValue' value='master'>
		</form>
	</body>
</html>



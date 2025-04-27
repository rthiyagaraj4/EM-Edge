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
<script language='javascript' src='../../eDS/js/MealClass.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String itemType = "";
   String shortDesc = "";
   String longDesc = "";
   String enabledYn = "";
   String comFormula = "";
   String dietCategory = "";
   String itemTypeCode = request.getParameter("itemType");
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
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_ITEM_TYPE);
	   		pstmt.setString(1,itemTypeCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			itemType = rst.getString("item_type");
	   			longDesc = rst.getString("long_desc");
	   			shortDesc = rst.getString("short_desc");
	   			comFormula = rst.getString("comm_formula_yn");
	   			dietCategory = rst.getString("appl_diet_category");
	   			enabledYn = rst.getString("eff_status");
	   		}
   		}
   		catch(Exception e){
	   		System.err.println("Error in Item Type->"+e);
   		}
   		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Item Type:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.ItemTypeServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.ItemType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="item_Type" id="item_Type" value="<%=itemType %>" size="4" maxlength="4" onkeyup="setFieldToUpperCase(this)"  onkeypress="return checkAlpha(event)" <%=disabled_flag %>/>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>"  size="30" maxlength="30" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" size="15" maxlength="15" />
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<%try{ %>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.ApplDietCategory.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="diet_Category" id="diet_Category" >
						<%	con = ConnectionManager.getConnection(request);
							pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_CATEGORY);
							pstmt.setString(1, locale);
							rst = pstmt.executeQuery(); %>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("code").equals(dietCategory)){%>
									<option value="<%=rst.getString("code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("code")%>">
								<%} %>
							<%=rst.getString("description") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<%}

				catch(Exception e){
					System.err.println("Exception in Item Type:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Item Type:"+e);
					}
				}
				%>

				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.CommercialFormula.Label" bundle="${ot_labels}"/>
					</td>
					<td>
					<%if("Y".equals(comFormula)){ %>
						<input type="checkbox" name="com_Formula" id="com_Formula" checked="checked"/>
					<%}
					else{ %>
						<input type="checkbox" name="com_Formula" id="com_Formula" />
					<%} %>

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
			<input type='hidden' name='updItemType' id='updItemType' value='<%=itemType%>'>
		</form>
	</body>
</html>



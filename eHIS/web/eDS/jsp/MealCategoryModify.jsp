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
<script language='javascript' src='../../eDS/js/MealCategory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% //Checkstyle Violation commented by Munisekhar
   //String mealCategory = "";
   String dietType = "";
   String mealClass = "";
   String mealCategoryCode = request.getParameter("mealCategory");
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
	   		pstmt = con.prepareStatement(DlQuery.DL_GET_MEAL_CATEGORY);
	   		pstmt.setString(1,mealCategoryCode);
	   		rst = pstmt.executeQuery();
	   		while(rst.next()){
	   			dietType = rst.getString("default_diet_type");
	   			mealClass = rst.getString("default_meal_class");
	   		}
  		}

  		catch(Exception e){
	   		System.err.println("Error in Meal Category->"+e);
  		}
  		finally{
  			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				System.err.println("Exception in Meal Category:"+e);
			}
  		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MealCategoryServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type="text" name="meal_Category" id="meal_Category" value="<%=mealCategoryCode %>" size="30" maxlength="30" <%=disabled_flag %>/>
					</td>
				</tr>
				<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td class='label' align="right">
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="diet_Type" id="diet_Type">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("diet_type").equals(dietType)){%>
									<option value="<%=rst.getString("diet_type")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("diet_type")%>">
								<%} %>
							<%=rst.getString("short_desc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class='label'>
						<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="meal_Class" id="meal_Class">
						<%	pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
							rst = pstmt.executeQuery(); %>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%while(rst.next()) {
								if(rst.getString("meal_class").equals(mealClass)){%>
									<option value="<%=rst.getString("meal_class")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("meal_class")%>">
								<%} %>
							<%=rst.getString("short_desc") %>
							</option>
							<%}
							pstmt = null;
							rst = null;%>
						</select>
					</td>
				</tr>
				<%}

				catch(Exception e){
					System.err.println("Exception in Meal Category:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Meal Category:"+e);
					}
				}
				%>
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updMealCategory' id='updMealCategory' value='<%=mealCategoryCode%>'>
		</form>
	</body>
</html>



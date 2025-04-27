<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat"%>
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
<script language='javascript' src='../../eDS/js/MenuCycle.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String menuSchdCycle = "";
   String dietType = "";
   String mealClass = "";
   Date mealPlanDate = new Date();
   String referenceDayNo = "";
   String enabled_yn = "";
   String facility_id = (String) session.getValue("facility_id");
   String strDate = "";

  // String kitchenCode = request.getParameter("kitchenCode");
   String disabled_flag = "";
   String readOnlyFlag = "";

   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   String mode = request.getParameter("mode");
   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
   			dietType = request.getParameter("dietType");
   		   	mealClass = request.getParameter("mealClass");

   			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_GET_MENU_CYCLE);
			pstmt.setString(1,dietType);
			pstmt.setString(2,mealClass);
			pstmt.setString(3,facility_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				dietType = rst.getString("diet_type");
				mealClass = rst.getString("meal_class");
				menuSchdCycle = rst.getString("menu_sched_cycle_days");
				referenceDayNo = rst.getString("meal_plan_ref_day_no");
				mealPlanDate = rst.getDate("meal_plan_ref_date");
				strDate = sdf.format(mealPlanDate);
				enabled_yn = rst.getString("eff_status");

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
				System.err.println("Exception in Menu Cycle Add Modify:"+e);
			}
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="menuCycle_form" id="menuCycle_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuCycleServlet" method="post" target="messageFrame">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<% try{
						con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
						rst = pstmt.executeQuery();
				%>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
					</td>
					<td colspan="4">
						<select name="diet_Type" id="diet_Type" <%=disabled_flag %>>
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
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
					</td>
					<td colspan="4">
						<select name="meal_Class" id="meal_Class" <%=disabled_flag %>>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%
							pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_CLASS);
							rst = pstmt.executeQuery();
							while(rst.next()) {
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
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.MenuSchedCycle.Label" bundle="${ot_labels}"/>
					</td>
					<td colspan="4">
						<select name="menu_Schd_Cycle" id="menu_Schd_Cycle" >
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%if("modify".equals(mode)){%>
							<option value="<%=menuSchdCycle%>" selected><%=menuSchdCycle%></option>
							<%} %>
							<!--modified by N Munisekhar on 20-May-2013 against [IN039894]-->
							<%if(!menuSchdCycle.equals("1"))%>
							<option value="1">1</option>
                            <%if(!menuSchdCycle.equals("2"))%>							
							<option value="2">2</option>
							<%if(!menuSchdCycle.equals("3"))%>
							<option value="3">3</option>
                            <%if(!menuSchdCycle.equals("4"))%>							
							<option value="4">4</option>
							<%if(!menuSchdCycle.equals("5"))%>
							<option value="5">5</option>
                            <%if(!menuSchdCycle.equals("6"))%>							
							<option value="6">6</option>
							<%if(!menuSchdCycle.equals("7"))%>
							<option value="7">7</option>
                            <%if(!menuSchdCycle.equals("8"))%>							
							<option value="8">8</option>
							<%if(!menuSchdCycle.equals("9"))%>
							<option value="9">9</option>
                            <%if(!menuSchdCycle.equals("10"))%>							
							<option value="10">10</option>
							<%if(!menuSchdCycle.equals("11"))%>
							<option value="11">11</option>
                            <%if(!menuSchdCycle.equals("12"))%>							
							<option value="12">12</option>
							<%if(!menuSchdCycle.equals("13"))%>
							<option value="13">13</option>
                            <%if(!menuSchdCycle.equals("14"))%>							
							<option value="14">14</option>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.MealPlanDate.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<input type ="text" size="10" name="meal_PlanDate" id="meal_PlanDate" value="<%=strDate %>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('meal_PlanDate');">
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>

					<td align="left" class='label'>
						<fmt:message key="eOT.RefDayNo.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="reference_Day_No" id="reference_Day_No">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%if("modify".equals(mode)){%>
							<option value="<%=referenceDayNo%>" selected><%=referenceDayNo%></option>
							<%} %>
							<!--modified by N Munisekhar on 20-May-2013 against [IN039894]-->
							<%if(!referenceDayNo.equals("1"))%>
							<option value="1">1</option>
                            <%if(!referenceDayNo.equals("2"))%>							
							<option value="2">2</option>
							<%if(!referenceDayNo.equals("3"))%>
							<option value="3">3</option>
                            <%if(!referenceDayNo.equals("4"))%>							
							<option value="4">4</option>
							<%if(!referenceDayNo.equals("5"))%>
							<option value="5">5</option>
                            <%if(!referenceDayNo.equals("6"))%>							
							<option value="6">6</option>
							<%if(!referenceDayNo.equals("7"))%>
							<option value="7">7</option>
                            <%if(!referenceDayNo.equals("8"))%>							
							<option value="8">8</option>
							<%if(!referenceDayNo.equals("9"))%>
							<option value="9">9</option>
                            <%if(!referenceDayNo.equals("10"))%>							
							<option value="10">10</option>
							<%if(!referenceDayNo.equals("11"))%>
							<option value="11">11</option>
                            <%if(!referenceDayNo.equals("12"))%>							
							<option value="12">12</option>
							<%if(!referenceDayNo.equals("13"))%>
							<option value="13">13</option>
                            <%if(!referenceDayNo.equals("14"))%>							
							<option value="14">14</option>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>

				<%}

				catch(Exception e){
					System.err.println("Exception in Menu Time table:"+e);
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Menu Time Table:"+e);
					}
				}
				%>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>
					</td>
					<td colspan="4">
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
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updDietType' id='updDietType' value='<%=dietType%>'>
			<input type='hidden' name='updMealClass' id='updMealClass' value='<%=mealClass%>'>
		</form>
	</body>
</html>



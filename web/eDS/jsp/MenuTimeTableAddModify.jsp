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
<script language='javascript' src='../../eDS/js/MenuTimeTable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String kitchenCode = "";
   String dietType = "";
   String mealClass = "";
   String mealType = "";
   String dayNo = "";
   String menu = "";
   String enabled_yn = "";
   String sql="";
  // String kitchenCode = request.getParameter("kitchenCode");
   String disabled_flag = "";
   String readOnlyFlag = "";
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
   String mode = request.getParameter("mode");
   String facility_id  = (String) session.getValue("facility_id");
   /* Added Against Start ML-MOH-CRF-1006(US6) */
   String patientClass = "";
   String all =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
   String emergency =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
   String inpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
   String Outpatient =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
   String Staff =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Staff.label","common_labels");
	TreeMap<String,String> patientClassMap = new TreeMap<String,String>();
	patientClassMap.put("", all);
	patientClassMap.put("EM", emergency);
	patientClassMap.put("IP", inpatient);
	patientClassMap.put("OP", Outpatient);
	patientClassMap.put("ST", Staff);
	/* Added Against End ML-MOH-CRF-1006(US6) */

   if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
   			kitchenCode = request.getParameter("kitchenCode");
   			dietType = request.getParameter("dietType");
   		   	mealClass = request.getParameter("mealClass");
   		   	mealType = request.getParameter("mealType");
   		   	dayNo = request.getParameter("dayNo");
   		   	
   		 	con = ConnectionManager.getConnection(request);
   		 	sql="select kitchen_code,diet_type,meal_class,meal_type,day_no,menu_code,eff_status,patient_class from ds_diet_menu_time_table where kitchen_code = ? and diet_type = ? and meal_class = ? and meal_type = ? and day_no = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,kitchenCode);
			pstmt.setString(2,dietType);
			pstmt.setString(3,mealClass);
			pstmt.setString(4,mealType);
			pstmt.setString(5,dayNo);
			rst = pstmt.executeQuery();			
			while(rst.next()) {
				menu=rst.getString("menu_code");
				enabled_yn=rst.getString("eff_status");
		/* Added Against Start ML-MOH-CRF-1006(US-5) */
				patientClass = rst.getString("patient_class");
				if(("null").equals(patientClass))
				patientClass="";
		/* Added Against End ML-MOH-CRF-1006(US-5) */	
			}
			
			/* menu = request.getParameter("menu");
   		 	enabled_yn = request.getParameter("enabled"); */
   		}catch(Exception e){
	   		System.err.println("Error in Diet category->"+e);
			e.printStackTrace();
   		}finally{					
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e){
				System.err.println("Exception in Menu Time Table:"+e);
				e.printStackTrace();
			}   		
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
		<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="mealClass_form" id="mealClass_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuTimeTableServlet" method="post" target="messageFrame">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<% try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
				rst = pstmt.executeQuery();
		%>
		<!-- Added Against Start ML-MOH-CRF-1006(US6) -->
		<tr>
			<td align="left" class='label'>
				<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
			</td>
			<td>
			<select name="Patient_Class" id="Patient_Class" id="Patient_Class" onChange='changeMealType(this);changeDietType(this);' <%=disabled_flag%> >
			<%
				for (String key : patientClassMap.keySet()) {
					if(key.equals(patientClass)){%>
						<option value="<%=key%>" selected="selected">
					<%}else{%>
						<option value="<%=key%>">
					<%}%>
						<%=patientClassMap.get(key)%>
						</option>				
					<%}%>										
			</select>	
			</td>
		</tr>
		<!-- Added Against End ML-MOH-CRF-1006(US6) -->
		<tr>
			<td align="left" class='label'>
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td id="dietTypeTD">
			<select name="diet_Type" id="diet_Type" onchange="loadDayNo('mealclass');" <%=disabled_flag %>>
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
			<td>
				<select name="meal_Class" id="meal_Class" onchange="loadDayNo('mealClass');" <%=disabled_flag %>>
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
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="kitchen_Code" id="kitchen_Code" <%=disabled_flag %>>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%
							pstmt = con.prepareStatement(DlQuery.DL_GET_KITCHEN_CODE);
							pstmt.setString(1, locale);
							pstmt.setString(2, facility_id);
							rst = pstmt.executeQuery();
							System.out.println("inside kitchencode");
							while(rst.next()) {
								if(rst.getString("kitchen_code").equals(kitchenCode)){%>
									<option value="<%=rst.getString("kitchen_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("kitchen_code")%>">
								<%} %>
							<%=rst.getString("long_desc") %>
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
						<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
					</td>
					<td id='MealTypeTD'>
						<select name="meal_Type" id="meal_Type" onchange="loadDayNo('menulist');" <%=disabled_flag %>>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%
							pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_TYPE);							
							pstmt.setString(1, locale);
							rst = pstmt.executeQuery();
							while(rst.next()) {
								if(rst.getString("meal_type").equals(mealType)){%>
									<option value="<%=rst.getString("meal_type")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("meal_type")%>">
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
						<fmt:message key="eOT.DayNo.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="day_No" id="day_No" <%=disabled_flag %>>
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>

						<%if("modify".equals(mode)){ %>
							<option value ="<%= dayNo%>" selected="selected"><%= dayNo%></option>
						<% } %>
							</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td align="left" class='label'>
						<fmt:message key="eOT.Menu.Label" bundle="${ot_labels}"/>
					</td>
					<td>
						<select name="menu_Item" id="menu_Item">
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%
							pstmt = con.prepareStatement(DlQuery.DL_DS_GET_MENU);
							pstmt.setString(1, locale);
							pstmt.setString(2, dietType);
							pstmt.setString(3, mealClass);
							pstmt.setString(4, mealType);
							rst = pstmt.executeQuery();
							while(rst.next()) {
								if(rst.getString("menu_code").equals(menu)){%>
									<option value="<%=rst.getString("menu_code")%>" selected="selected">
								<%}
								else{%>
									<option value="<%=rst.getString("menu_code")%>">
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
				<%}catch(Exception e){
					System.err.println("Exception in Menu Time table:"+e);
					e.printStackTrace();
				}finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}catch(Exception e){
						System.err.println("Exception in Menu Time Table:"+e);
						e.printStackTrace();
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
			</table>
			<input type='hidden' name='locale' id='locale' value="<%=locale%>">
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='updDietType' id='updDietType' value='<%=dietType%>'>
			<input type='hidden' name='updMealClass' id='updMealClass' value='<%=mealClass%>'>
			<input type='hidden' name='updMealType' id='updMealType' value='<%=mealType%>'>
			<input type='hidden' name='updKitchen' id='updKitchen' value='<%=kitchenCode%>'>
			<input type='hidden' name='updDayNo' id='updDayNo' value='<%=dayNo%>'>
		</form>
	</body>
</html>


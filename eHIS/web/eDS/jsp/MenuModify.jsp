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
<script language='javascript' src='../../eDS/js/Menu.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!-- Added Against ML-MOH-CRF-1006-US5 -->
<% String menu = "";
   String longDesc = "";
   String shortDesc = "";
   String dietType = "";
   String mealClass = "";
   String mealType = "";
   Date effFromDate = new Date();
   Date effToDate = new Date();
   String enabled_yn = "";
   //String facility_id = (String) session.getValue("facility_id");
   String strDate = "";
   String toDate = "";
  // String kitchenCode = request.getParameter("kitchenCode");
   String disabled_flag = "";
   String readOnlyFlag = "";
   Connection con = null;
   ResultSet rst = null;
   PreparedStatement pstmt = null;
   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   String mode = request.getParameter("mode");
   /* Added Against Start ML-MOH-CRF-1006(US-5) */
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
	/* Added Against End ML-MOH-CRF-1006(US-5) */
	if("modify".equals(mode)){
   		try{
   			disabled_flag = "disabled";
   			readOnlyFlag = "readonly";
   			menu = request.getParameter("menu");
   			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_GET_MENU);
			pstmt.setString(1,locale);
			pstmt.setString(2,menu);
			rst = pstmt.executeQuery();
			while(rst.next()){
				menu = rst.getString("menu_code");
				longDesc = rst.getString("long_desc");
				shortDesc = rst.getString("short_desc");
				mealType = rst.getString("meal_type");
				dietType = rst.getString("diet_type");
				mealClass = rst.getString("meal_class");
				effFromDate = rst.getDate("eff_from_date");
				strDate = sdf.format(effFromDate);
				effToDate = rst.getDate("eff_to_date");
				if(effToDate == null){
					effToDate = null;
				}else{
					toDate = sdf.format(effToDate);
				}
				enabled_yn = rst.getString("eff_status");
				/* Added Against Start ML-MOH-CRF-1006(US-5) */
				patientClass = rst.getString("patient_class");
				if(("null").equals(patientClass))
					patientClass="";
				/* Added Against End ML-MOH-CRF-1006(US-5) */	
	   		}

   		}
   		catch(Exception e){
	   		System.err.println("Error in Menu Function--->"+e);
			e.printStackTrace();
   		}
   		finally{
   			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			ConnectionManager.returnConnection(con);
   		}
   }
%>
		<br>
		<fmt:setLocale value="<%=locale %>"/>
	<fmt:setBundle basename="eOT.resources.Labels" var="ot_labels"/>
		<form name="menu_form" id="menu_form"  onload='FocusFirstElement()'  action="../../servlet/eDS.MenuCycleServlet" method="post" target="messageFrame">
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.Menu.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2">
					<input type="text" name="menu_Code" id="menu_Code" value="<%=menu %>" size="10" maxlength="10" onblur="setFieldToUpperCase(this);" onkeypress="return checkAlpha(event);" <%=disabled_flag %>/>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.LongDescription.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2">
					<input type="text" name="long_Desc" id="long_Desc" value="<%=longDesc %>" size="30" maxlength="30" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.ShortDescription.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2">
					<input type="text" name="short_Desc" id="short_Desc" value="<%=shortDesc %>" size="15" maxlength="15" />
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<!-- Added Against Start ML-MOH-CRF-1006(US5) -->
			<tr>
				<td align="left" class='label'>
					<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
				</td>
				<td colspan="2">
			<%
				try{	con = ConnectionManager.getConnection(request);
						pstmt = con.prepareStatement(DlQuery.DL_DS_DIET_TYPE);
						rst = pstmt.executeQuery();
				%>
				<select name="Patient_Class" id="Patient_Class" id="Patient_Class" onChange='changeMealType(this);changeDietType(this);'>
					
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
			<!-- Added Against End ML-MOH-CRF-1006(US-5) -->
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2" id="dietTypeTD">

					<select name="diet_Type" id="diet_Type" >
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
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>&nbsp;&nbsp;
				</td>
				<td colspan="2" id='MealTypeTD'>
					<select name="meal_Type" id="meal_Type" >
							<option value="">
								<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
							</option>
							<%
							pstmt = con.prepareStatement(DlQuery.DL_DS_MEAL_TYPE);
							pstmt.setString(1,locale);
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
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2">
						<select name="meal_Class" id="meal_Class" >
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
			<%}

				catch(Exception e){
					System.err.println("Exception in Menu Time table:"+e);
					e.printStackTrace();
				}

				finally{
					try{
						if(pstmt!=null) pstmt.close();
						if(rst!=null) rst.close();
						ConnectionManager.returnConnection(con);
					}
					catch(Exception e){
						System.err.println("Exception in Menu:"+e);
						e.printStackTrace();
					}
				}
				%>
				<td align="left" class='label'>
					<fmt:message key="eOT.EffectiveFromDate.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td>
					<input type ="text" size="10" name="eff_FromDate" id="eff_FromDate" value="<%=strDate %>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('eff_FromDate');">
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td align="left" class='label'>
					<fmt:message key="eOT.EffectiveToDate.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td class='label'>
					<input type ="text" size="10" name="eff_ToDate" id="eff_ToDate" value="<%=toDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
						<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('eff_ToDate');">
				</td>
			</tr>
			<tr>
				<td align="left" class='label'>
					<fmt:message key="eOT.Enabled.Label" bundle="${ot_labels}"/>&nbsp&nbsp
				</td>
				<td colspan="2">
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
				<td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td>
			</tr>
		</table>

		<table border='0' cellspacing='0' width='100%' align='center' id="dummyTable"  height='0'>
		</table>

		<input type="hidden" name="locale" id="locale" value="<%=locale%>" />
		<input type="hidden" name="updMenuCode" id="updMenuCode" value="<%=menu%>" />
		<input type='hidden' name='valueForNutCode' id='valueForNutCode' value=''>
		<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
		<input type='hidden' name='forUpdate' id='forUpdate' value=''>
		<input type=hidden name="flag" id="flag" />
		</form>
	</body>
</html>


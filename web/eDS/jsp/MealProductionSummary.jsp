<!DOCTYPE html>
<!---ML-MMOH-CRF-0680 for Meal Production Summary -->
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Statement,eCommon.Common.*,eDS.Common.JSONObject"%>
<%@  page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/>
<jsp:setProperty name="DSCommonBeanObj" property="FacilityId" value='<%=session.getAttribute("facility_id").toString()%>'/>
<jsp:setProperty name="DSCommonBeanObj" property="Locale" value='<%=session.getAttribute("LOCALE").toString()%>'/>
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
<script language='javascript' src='../../eDS/js/MealProductionSummary.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
<%
	 Connection conn=null;
	 PreparedStatement pstmt=null;
	 ResultSet rst=null;
	 String facility_id  = (String) session.getValue("facility_id");
	 String servingDate="";
	 HashMap<String,String> kitchenMap = DSCommonBeanObj.getKitchenQuery(locale,facility_id);
	 HashMap<String,String> mealTypeMap = DSCommonBeanObj.getMealTypeQuery(locale);
	 HashMap<String,String> MealClassMap = DSCommonBeanObj.getMealClassValues(locale);
	 HashMap<String,String> dietTypeMap = DSCommonBeanObj.getDietType(locale);
	 HashMap<String,String> menuTypeMap = DSCommonBeanObj.getMenuType(locale);
		 
	try{
		conn = ConnectionManager.getConnection(request);

		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
%>
		
<%
   boolean isMenuType =false;
   isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");//Menu Type for Selyang Site.
%>
	<form name="MealProductionSummary" id="MealProductionSummary" method="post"  target="messageFrame">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		<%if(isMenuType){%>
			<tr>
				<td  class="label">
					<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
				</td>
				<td>
					<select name="menu_type" id="menu_type" id = 'menu_type'>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%for(String key : menuTypeMap.keySet()){%>
					<option value="<%=key%>"> <%=menuTypeMap.get(key)%> </option>
				<%}%>	
					</select> <img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
			<%}%>
			
			<tr>
				<td  class="label">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<select name="kitchen" id="kitchen" id = 'kitchen'>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%for(String key : kitchenMap.keySet()){%>
					<option value="<%=key%>"> <%=kitchenMap.get(key)%> </option>
				<%}%>	
				</select>
				</td>
			</tr>
					
			<tr>
				<td  class="label">
					<fmt:message key="Common.date.label" bundle="${common_labels}"/>
				</td>
				<td>
					<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
					<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>

			<tr>	 
				<td class="label" >
					<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
				</td>
				<td class='label'>
					<select name="OrderType" id="OrderType" id="OrderType" onchange ="enableDisableField();enableKitchen();">
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 
					<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option> 
					<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="ST"><fmt:message key="eDS.Staff.Label" bundle="${ds_labels}"/></option>
					</select>
				</td>
			</tr>	
							
			<tr>
				<td  class="label" >
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<select name="mealClass" id="mealClass" id ="mealClass">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%for(String mealClasskey : MealClassMap.keySet()){%>
					<option value="<%=mealClasskey%>"> <%=MealClassMap.get(mealClasskey)%>
					<%}%>
					</select>
				</td>
			</tr>					
				 
			<tr>
				<td  class="label" >
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<select name="mealType" id="mealType" id ="mealType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%for(String mealTypekey : mealTypeMap.keySet()){%>
					<option value="<%=mealTypekey%>"> <%=mealTypeMap.get(mealTypekey)%>
					<%}%>
					</select>
				</td>
			</tr>
							
			<tr>
				<td  class="label" >
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<select name="dietType" id="dietType" id ="dietType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%for(String dietTypekey : dietTypeMap.keySet()){%>
					<option value="<%=dietTypekey%>"> <%=dietTypeMap.get(dietTypekey)%>
					<%}%>
					</select>
				</td>
			</tr>
                   
		<INPUT type="hidden" name="isMenuType" id="isMenuType" id="isMenuType" value="<%=isMenuType%>">
		</table>

	<%
	   }catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{
		if(conn!=null)  
		ConnectionManager.returnConnection(conn);
		}
	%>
		<input type="hidden" name="method" id="method"/>

		<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

		<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

		<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
		<input type="hidden" name="module_id" id="module_id" value="DS">

		<input type="hidden" name="p_report_id" id="p_report_id" value="DSMLPRDSUM">
		<input type="hidden" name="report_id" id="report_id" value="DSMLPRDSUM"/>

		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
		<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
		<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
		<input type="hidden" name="converDate" id="converDate" value="" />

		<input type='hidden' name='PARAM1' id='PARAM1' value="" />						
		</form>
	</body>
	</html>


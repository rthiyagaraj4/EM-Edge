<!DOCTYPE html>
<!-- Created By Selvin Manoharan Against KDAH-CRF-0350 -->
<%@ page import="eCommon.Common.CommonBean,java.util.HashMap"%>
<%@  page import ="java.util.*,java.util.HashMap,java.sql.*,java.net.*,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eDS.*" %>
<%@ page import="eDS.Common.DlQuery,eDS.DSCommonBean,eDS.*"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%			
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	Connection conn=null;
	
 %>
<html>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<head>
 	<script language='javascript' src='../../eDS/js/KitchenOrderTicket.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
	<script language="Javascript" src="../../eDS/js/DSCommon.js"></script>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript'>
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="getSysDate()">
		<form name="KitchenOrderTicketQueryCriteria" id="KitchenOrderTicketQueryCriteria">
		<br/>
		<br/>
			<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>

<% 
try{
	//Added by Santhosh for ML-MMOH-SCF-2331
	conn = ConnectionManager.getConnection(request);
	boolean isSpecialDiet = false;
	isSpecialDiet = CommonBean.isSiteSpecific(conn,"DS","SPECIAL_DIET_CATEGORY");
	HashMap<String,String> kitchenMap = DSCommonBeanObj.getKitchenQuery(locale,facility_id);
	HashMap<String,String> mealTypeMap = DSCommonBeanObj.getMealTypeQuery(locale);
	HashMap<String,String> dietCategoryMap = DSCommonBeanObj.getDietCategory(locale);
	HashMap<String,String> MealClassMap = DSCommonBeanObj.getMealClassValues(locale);
	HashMap<String,String> dietTypeMap = DSCommonBeanObj.getDietType(locale);
%>
			<tr>
				<td align="left" class="label">
						<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
				</td>
				<td>
					<input type ="text" size="10" name="servDate" id="servDate" value="" onkeypress="return checkForSpecCharsforID(event);" maxlength=10 onblur='isValidDate(this);'>
					<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('servDate');">	
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
				<td align="left" class="label" >
						<fmt:message key="eDS.Kitchen.Label" bundle="${ds_labels}"/>
				</td>
				<td>
						<select name="kitchenCode" id="kitchenCode">
							<option value="">
								<fmt:message key="Common.all.label" bundle="${common_labels}"/>
							</option>
							<%for(String key : kitchenMap.keySet()){%>
							
							<option value="<%=key%>"> <%=kitchenMap.get(key)%>
							
							<%}%>
						</select>	
				</td>
				<td align="left" class="label">
						<fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>
				</td>
				<td>
					<!-- ML-MMOH-CRF-1006-US4 -->
				<select name="Patient_Class" id="Patient_Class" id="Patient_Class" onChange='changeMealType();changeDietType();'>
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option> 
		            <option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="ST"><fmt:message key="eDS.Staff.Label" bundle="${ds_labels}"/></option>
				</select>
				</td>
			</tr>	
			<tr>
				<td align="left" class="label">
						<fmt:message key="eDS.MealType.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class="label" id='MealTypeTD'> <!-- MealTypeTD Added Against ML-MOH-CRF-1006-US4 -->
						<select name="MealType" id="MealType">
							<option value="">
						<fmt:message key="Common.all.label" bundle="${common_labels}"/>
							</option>
							<%for(String mealTypekey : mealTypeMap.keySet()){%>
							
							<option value="<%=mealTypekey%>"> <%=mealTypeMap.get(mealTypekey)%>
							
							<%}%>
						</select>
				</td>
				<td align="left" class="label">
						<fmt:message key="eDS.DietCategory.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class="label">
					<select name="DietCategory" id="DietCategory">
						<option value="">
						<fmt:message key="eDS.select.Label" bundle="${ds_labels}"/>
						</option>
							<%for(String Dietkey : dietCategoryMap.keySet()){
								if(isSpecialDiet){//Added by Santhosh for ML-MMOH-SCF-2331 
									if(!Dietkey.equals("SD01")){%>
										<option value="<%=Dietkey%>"> <%=dietCategoryMap.get(Dietkey)%>
									<%}
								} else{ %>
										<option value="<%=Dietkey%>"> <%=dietCategoryMap.get(Dietkey)%>
								<%}
							}%>
					</select>
				</td>
				<td align="left" class="label">
						<fmt:message key="eDS.MealClass.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class="label">
					<select name="MealClass" id="MealClass">
						<option value="">
						<fmt:message key="eDS.select.Label" bundle="${ds_labels}"/>
						</option>
							<%for(String mealClasskey : MealClassMap.keySet()){%>
						<option value="<%=mealClasskey%>"> <%=MealClassMap.get(mealClasskey)%>
							<%}%>
					</select>
				</td>	
				<td align="left" class="label">
						<fmt:message key="eDS.DietType.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class="label" id="dietTypeTD">
					<select name="DietType" id="DietType"> <!-- dietTypeTD Added Against ML-MOH-CRF-1006-US4 -->
						<option value="">
						<fmt:message key="eDS.select.Label" bundle="${ds_labels}"/>
						</option>
						<%for(String dietTypekey : dietTypeMap.keySet()){%>
						<option value="<%=dietTypekey%>"> <%=dietTypeMap.get(dietTypekey)%>
						<%}%>
					</select>
				</td>	
		</tr>
<%}
		catch(Exception e){
			System.err.println("Exception in KitchenOrderTicketQueryCriteria:"+e);
			e.printStackTrace();
		}finally{
			try{
				}catch(Exception e){
					System.err.println("Exception in KitchenOrderTicketQueryCriteria.jsp:"+e);
					e.printStackTrace();
				}
		}%>
</table>
		<br/>
		<table width="100%">
		<tr>
			<td width="40%"></td>
			<td width="25%"></td>
			<td width="25%"></td>
			<td width="10%" colspan='6' align="right" class="label">
				<input type="button" class='BUTTON' name="select" id="select" value='<fmt:message key="Common.Select.label" bundle="${common_labels}"/>' onclick="submitForm();"/>
			</td>
		</tr>
</table>
			<input type='hidden' name = 'locale' id = 'locale' value = '<%=locale%>'>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden' name = 'currentDate' id = 'currentDate' value = ''>
		</form>
	</body>
</html>


<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
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
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealOrderList.js'></script>
<script language='javascript' src='../../eDS/js/MealTicket_OP_EM.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
  $(document).ready(function() {
	var facility_id=$('#facility_id').val();
	getCurrentServerDate();
	var kitchenFrom=$('#kitchenFrom').val();
	loadKitchen();
	loadSpecialty();
	loadMealType();
	loadDietType();
});	

</script>
</head>
<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
			//Added against CRF-0782 strts Here
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			//String dietCategoryCode = "";
			//String description =  "";
			//Added against CRF-0782 ends Here		
			
			String facility_id  = (String) session.getValue("facility_id");
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";
			String patient_id_length="";
			String priorityZoneCode="";
		//	String description=""; //Commented against CRF-0782 strts Here
			String sql_cust_id="select customer_id from SM_SITE_PARAM where rownum = 1";
			String customer_id="";
			boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207
			try{
			conn = ConnectionManager.getConnection(request);
			isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
				//MMS-DM-CRF-0044
				pstmt=conn.prepareStatement(sql_cust_id);
				rst=pstmt.executeQuery();
				if(rst !=null && rst.next())
				{
				customer_id=checkForNull(rst.getString("customer_id"));
				}	
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
			}
			catch(Exception DCat)
			{
			  System.out.println("GenerateMeal Plan Kitchen"+DCat);
			 }
			  finally
			  {
			   if(rst != null) rst.close();
			   if(pstmt != null) pstmt.close();
			  }
%>
<form name="MealStatisticsOPAndEMReport" id="MealStatisticsOPAndEMReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		<tr>
			<td  class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}"/>
			</td>
			<td>
				<input type="text" name="servingDate" id="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			
			
		</tr>
		<tr>
   			<td>
			</td>
			<td  class="label">
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td  class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr>
			<td  class="label">
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
			</td>
			<td  class='label'>
			<select name="kitchenFrom" id="kitchenFrom" id ="kitchenFrom" onChange='loadSpecialty();loadLocation();getPriorityZone();getTreatmentArea()'><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					</select>
						<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td  class='label'>
				<select name="kitchenTo" id="kitchenTo" id="kitchenTo" onChange='loadSpecialty();loadLocation();getPriorityZone();getTreatmentArea()'><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
					<img src='../../eCommon/images/mandatory.gif' />
			</td>

		</tr>
		<tr>
			<td  class="label">
				<fmt:message key="eDS.MealOrderFor.Label" bundle="${ds_labels}"/>
			</td>
			<td  class='label'>
				<select name="mealOrderFor" id="mealOrderFor" id="mealOrderFor" onChange="loadSpecialty();disableEMFields(this.value);loadLocation();loadMealType();">
				<option value="ALL"><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<option value="OP"><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></option>
				<option value="EM"><fmt:message key="eDS.EmergencyPatients.Label" bundle="${ds_labels}"/></option>
				</select>
			</td>
			<td  class='label'>
			</td>
		</tr>
		<tr>
			<td  class='label'>
				<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
			</td>
			<td  class='label'>
					<select name="SpecialtyFrom" id="SpecialtyFrom" id="SpecialtyFrom" onChange="loadLocation();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					</select>
			</td>
			<td  class='label'>
				<select name="SpecialtyTo" id="SpecialtyTo" id="SpecialtyTo" onChange="loadLocation();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td  class="label">
				<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			</td>
			<td  class='label'>
			<%if(isMultiDietType){%>
			    <select name="location" id="location" id="location" onchange="selectAll(this.value);getPriorityZone();getTreatmentArea()" 
				<option value="" >
			<%}else{%>		
				<select name="location" id="location" id="location" onchange="selectAll(this.value);getPriorityZone();getTreatmentArea()" multiple>
			<%}%>	
				<option value="" >   <!-- modified against ML-MMOH-CRF-1818-->
				<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				</option>
				</select>
			</td>
			<td  class='label'>
				
			</td>
		</tr>
		<tr>
								<td  class="label">
									<fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
									<select name="priorityZone" id="priorityZone" id="priorityZone" onChange="getTreatmentArea();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									
									</select>
								</td>
								<td  class='label'>
									<select name="priorityZoneTo" id="priorityZoneTo" id="priorityZoneTo" onChange="getTreatmentArea();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									
									</select>
								</td>
							</tr>
			<tr>
								<td  class="label">
									<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
									<select name="treatmentAreaFrom" id="treatmentAreaFrom" id="treatmentAreaFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									</select>
								</td>
								
								<td  class='label'>
									<select name="treatmentAreaTo" id="treatmentAreaTo" id="treatmentAreaTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									</select>
								</td>
				
			
			</tr>
			
		<%// if(customer_id == "WCH") {%>
			<!-- CRF 782 Start-->
		<!--<tr>
			<td class="label"  nowrap><fmt:message key="eOT.DietCategory.Label" bundle="${ot_labels}" /></td>
				<td nowrap>
				<select name="dietCategory" id="dietCategory" id="dietCategory"> 
				<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-->
				<%
					/*try{
						conn = ConnectionManager.getConnection(request);
						String sql_diet_Category = "select diet_Category_Code, ds_get_desc.ds_diet_category(diet_Category_Code,'"+locale+"', 1) description from Ds_Diet_Category";
						pstmt = conn.prepareStatement(sql_diet_Category);
						rst	= pstmt.executeQuery();
						while(rst != null && rst.next()){
						dietCategoryCode=rst.getString(1);
						description=rst.getString(2);*/
				 %>
					<!--option value="<dietCategoryCode%>">
						<description%>
					</option-->
				<%
				/*	}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally	{
						if(pstmt != null){
							pstmt.close();
						}
						if(conn != null){
							conn.close();
						}
					}*/
				 %>
				<!--</td>

		</tr>-->
	<%//}%>
		<!-- CRF 782 End-->
		<tr>
			<td  class='label'>
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td  class='label'>
					<select name="mealTypeFrom" id="mealTypeFrom" id="mealTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

							<option value="<%=strCode%>"><%=strDesc%></option>
					</select>
			</td>
			<td  class='label'>
				<select name="mealTypeTo" id="mealTypeTo" id="mealTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
						<option value="<%=strCode%>"><%=strDesc%></option>
				</select>
			</td>
		</tr>
		<tr>
			<td  class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td  class='label'>
					<select name="dietTypeFrom" id="dietTypeFrom" id="dietTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

							<option value="<%=strCode%>"><%=strDesc%></option>
					</select>
			</td>
			<td  class='label'>
				<select name="dietTypeTo" id="dietTypeTo" id="dietTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
						<option value="<%=strCode%>"><%=strDesc%></option>
				</select>
			</td>
		</tr>
		</tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
				<td>
					<input type="text" name="patientIdFrom" id="patientIdFrom" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">
				</td>
				</td>
				<td>
					<input type="text" name="patientIdTo" id="patientIdTo" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">
				</td>
				</td>
			</tr>
			
				<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
				<input type="hidden" name="method" id="method"/>
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
				<input type="hidden" name="p_user" id="p_user"	value="<%=session.getValue("login_user")%>"/><!--55878-->
				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">
				<input type="hidden" name="p_report_id" id="p_report_id" value="DSOPEMMLT">
				<input type="hidden" name="report_id" id="report_id" value="DSOPEMMLT"/>
				<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
				<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
				<input type='hidden' name='conDate' id='conDate' >
				<input type='hidden' name='nd_serv_date' id='nd_serv_date' >
				<input type='hidden' name='p_kitchen_code_from' id='p_kitchen_code_from' >
				<input type='hidden' name='p_kitchen_code_to' id='p_kitchen_code_to' >
				<input type='hidden' name='nd_fr_meal' id='nd_fr_meal' >
				<input type='hidden' name='nd_to_meal' id='nd_to_meal' >
				<input type='hidden' name='nd_fr_ward_code' id='nd_fr_ward_code' >
				<input type='hidden' name='nd_to_ward_code' id='nd_to_ward_code' >
				<input type='hidden' name='nd_fr_diet_type' id='nd_fr_diet_type' >
				<input type='hidden' name='nd_to_diet_type' id='nd_to_diet_type' >
				<input type='hidden' name='nd_fr_meal_class' id='nd_fr_meal_class' >
				<input type='hidden' name='nd_to_meal_class' id='nd_to_meal_class' >
				<input type='hidden' name='nd_fr_pat_id' id='nd_fr_pat_id' >
				<input type='hidden' name='nd_to_pat_id' id='nd_to_pat_id' >
				<input type='hidden' name='nd_from_bed_no' id='nd_from_bed_no' >
				<input type='hidden' name='nd_to_bed_no' id='nd_to_bed_no' >				
				<!--<input type='hidden' name='p_user' id='p_user' >-->
				<input type='hidden' name='P_MEAL_PLAN_SEQ_NO' id='P_MEAL_PLAN_SEQ_NO' >
				<input type='hidden' name='chkPatientId1' id='chkPatientId1' >
				<input type='hidden' name='chkPatientId2' id='chkPatientId2' >
				<input type='hidden' name='customer_id' id='customer_id' value = '<%=customer_id%>'>
				<input type="hidden" name="selectedAll" id="selectedAll" id="selectedAll" value="" />
			</form>
		</body>
		
</html>


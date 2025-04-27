<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.Common.*,webbeans.eCommon.ConnectionManager" %>
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
<script language='javascript' src='../../eDS/js/OPMealOrderList.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type="text/javascript" src="../../eDS/js/DSResourceLookUp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
		<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			//Checkstyle Violation commented by Munisekhar
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";
			boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207

			try{

				conn = ConnectionManager.getConnection(request);
				isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207

				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();

		%>
	<form name="MealOrderReport" id="MealOrderReport" method="post"  target="messageFrame">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td  class="label">
					<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
						</td>
					<td  class='label'>
					
					
					<select name="kitchen" id="kitchen" onchange="getSpeciality();getLocation();getPriorityZone();getTreatmentArea();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

						<%
									try
									{
									sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"' and eff_status='E' order by 2";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>

							<%}

									}
									  catch(Exception DCat)
										  {
										  System.out.println("OP Meal Order List"+DCat);
									  }
									   finally
									   {
										   if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   }

								%>
								</select>
								<img src='../../eCommon/images/mandatory.gif' />

					</td>
					</tr>
					<tr>
					<td  class="label">
						<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
								</td>
								<td  class='label'>

					<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
								<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
							<img src='../../eCommon/images/mandatory.gif' />
								</td>
							</tr>
<!--							<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>-->

							<tr>
								<td  class="label">
									<fmt:message key="eDS.MealOrderFor.Label" bundle="${ds_labels}"/>
								</td>
								<td  class='label'>
									<select name="mealOrderFor" id="mealOrderFor" onchange="disableEMFields(this.value);getSpeciality();getLocation();getPriorityZone();getTreatmentArea();getMealTypes();">
										<option value="ALL"><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
										<option value="OP"><fmt:message key="Common.Outpatients.label" bundle="${common_labels}"/></option>
										<option value="EM"><fmt:message key="eDS.EmergencyPatients.Label" bundle="${ds_labels}"/></option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td  class="label">
									<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
									<select name="speciality" id="speciality" onChange="getLocation();getPriorityZone();getTreatmentArea();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									<%
										try
										{
											String specialityCode = "";
											String description =  "";
											String sql_speciality ="select distinct speciality_code, am_get_desc.am_speciality(speciality_code,'"+locale+"', 2) short_desc from Am_Speciality where EFF_STATUS ='E' order by UPPER(short_desc)";
											pstmt=conn.prepareStatement(sql_speciality);
											rst = pstmt.executeQuery();
											while(rst.next()){
											specialityCode = rst.getString(1);
											description =  rst.getString(2);
									%>
									<option value="<%=specialityCode%>"><%=description%></option>
										<%}
										}
										catch(Exception DCat)
										{
											System.out.println("OPMealOrderList.jsp Exception in retrieving speciality code--->"+DCat);
									  	}
									   	finally
									   	{
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   	}

								%>
									</select>
								</td>
							</tr>
														
							<tr>
								<td  class="label">
									<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
							<%if(isMultiDietType){%>	
								<select name="location" id="location" style="height: auto; overflow: auto; min-width: 8vw; onchange="selectAll(this.value);getPriorityZone();getTreatmentArea()" >
							<%}else{%>			
								<select name="location" id="location" style="height: auto; overflow: auto; min-width: 8vw; onchange="selectAll(this.value);getPriorityZone();getTreatmentArea()" multiple>
							<%}%>	
									<option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				                       <fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				                    </option>
									</select>
								</td>
							</tr>
							<tr>
								<td  class="label">
									<fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
									<select name="priorityZone" id="priorityZone" onChange="getTreatmentArea();"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
<%-- 									<%
										try
										{
											String priorityZoneCode = "";
											String description =  "";
											String sql_priorityZone ="select priority_zone,priority_zone_desc from ae_priority_zone where eff_status='E' order by 2";
											pstmt=conn.prepareStatement(sql_priorityZone);
											rst = pstmt.executeQuery();
											while(rst.next()){
											priorityZoneCode = rst.getString(1);
											description =  rst.getString(2);
									%>
									<option value="<%=priorityZoneCode%>"><%=description%></option>
										<%}
										}
										catch(Exception DCat)
										{
											System.out.println("OP Meal Order List exception in retrieving Priority Zone-->"+DCat);
									  	}
									   	finally
									   	{
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   	}

								%> --%>
									</select>
								</td>
							</tr>
							
							<tr>
								<td  class="label">
									<fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/>
								</td>
								<td  class='label'>
									<select name="treatmentArea" id="treatmentArea"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									</select>
								</td>
							</tr>
							
<%-- 							<tr>
								<td  class="label"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
								
								<td>
									<input type=text name='practitioner_name' id='practitioner_name'  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" value=''  onblur="" size='25'>
									<input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input>
									<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');">
									<input type=hidden name='Hid_ResourceType' id='Hid_ResourceType'  value='P' size='30' maxlength='30' >
									<input type=hidden name='resourceType_1' id='resourceType_1'  value='P' size='30' maxlength='30' >
								</td>							
							</tr> --%>
														
							<tr>
								<td  class="label">
									<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
								</td>
								<td  class='label'>
									<select name="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									<%
										try
										{
											String mealTypeCode = "";
											String mealTypeDesc =  "";
											String sql_meal_type ="select meal_type,short_Desc from ds_meal_type where eff_Status ='E' and (opmealorder_yn='Y' or em_meal_order_yn='Y') order by meal_order";
											pstmt=conn.prepareStatement(sql_meal_type);
											rst = pstmt.executeQuery();
											while(rst.next()){
											mealTypeCode = rst.getString(1);
											mealTypeDesc =  rst.getString(2);
									%>
									<option value="<%=mealTypeCode%>"><%=mealTypeDesc%></option>
										<%}
										}
										catch(Exception DCat)
										{
											System.out.println("Meal Order List exception in Meal Type--->"+DCat);
									  	}
									   	finally
									   	{
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   	}
								%>
									</select>
								</td>
							</tr>
							<tr>
								<td  class="label">
									<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
								</td>
								<td  class='label'>
									<select name="dietType" id="dietType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
									<%
										try
										{
											String dietTypeCode = "";
											String dietTypeDesc =  "";
											String sql_diet_type ="select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id like '"+locale+"' and eff_Status ='E' order by short_Desc ASC";
											pstmt=conn.prepareStatement(sql_diet_type);
											rst = pstmt.executeQuery();
											while(rst.next()){
											dietTypeCode = rst.getString(1);
											dietTypeDesc =  rst.getString(2);
									%>
									<option value="<%=dietTypeCode%>"><%=dietTypeDesc%></option>
										<%}
										}
										catch(Exception DCat)
										{
											System.out.println("Meal Order List exception in Diet Type--->"+DCat);
									  	}
									   	finally
									   	{
											if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   	}

								%>
									</select>
								</td>
							</tr>
							<!-- Added against ML-MMOH-CRF-0825 - US08 -->

				            <tr>
							<td  class="label">
									<fmt:message key="eDS.SearchFor.Label" bundle="${ds_labels}"/>
								</td>
								<td  class='label'>
									
								<select name="SearchFor" id="SearchFor">
		                  <option value="RLO"><fmt:message key="eDS.RegularLateIrregularDietOrders.Label" bundle="${ds_labels}"/></option>
                                  <option value="RO"><fmt:message key="eDS.RegularDietOrders.Label" bundle="${ds_labels}"/></option>
	                              <option value="LO"><fmt:message key="eDS.LateIrregularDietOrders.Label" bundle="${ds_labels}"/></option>
							     </select>
								</td>
							</tr>
						</table>
									<%
			}
		catch(Exception e){
			e.printStackTrace();
			out.println(e);
		}finally{

		if(conn!=null)  ConnectionManager.returnConnection(conn, request);
		}
			 %>
						<input type="hidden" name="method" id="method"/>

						<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
						<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

						<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
						<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

						<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
						<input type="hidden" name="module_id" id="module_id" value="DS">

						<input type="hidden" name="p_report_id" id="p_report_id" value="DSMLOPLT">
						<input type="hidden" name="report_id" id="report_id" value="DSMLOPLT"/>

						<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
						<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
						<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
						<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
						<input type="hidden" name="converDate" id="converDate" value="" />

						<input type='hidden' name='PARAM1' id='PARAM1' value="" />
						<input type="hidden" name="selectedAll" id="selectedAll" value="" />
						
					</form>
				</body>
		</html>



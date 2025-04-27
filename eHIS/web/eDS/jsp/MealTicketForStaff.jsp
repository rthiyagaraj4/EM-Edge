<!DOCTYPE html>
<!-- New file MealTicketForStaff.jsp created against ML-MMOH-CRF-0675 on 21-Jul-17  -->
<%@ page import="eDS.Common.DlQuery" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String facility_id=(String)session.getAttribute("facility_id");
%>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealTicketsForStaff.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eDS/js/jquery-latest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
	<%
		Connection conn=null;
		PreparedStatement stmt=null;
		Statement st = null ;
		ResultSet rst=null;

		String current_date="",sql = "",meal_category_code="",meal_category_description="";
		String menu_type_code="",menu_type_description="";
		String diet_type_code="",diet_type_description="";
		String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
		String diet_location_code="",diet_location_description="";
		String mealCode = "";
    	String mealDesc = "";
        String strMtype = "";
	    String strMDesc = "";
		try{
			conn	= ConnectionManager.getConnection(request);
			st	= conn.createStatement() ;
			rst	= st.executeQuery(sql_curr_date);
			while(rst!=null && rst.next()){
			current_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}			
	%>
		
	<form name="MealTicketForstaff" id="MealTicketForstaff" target="messageFrame" method="POST">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			
		<!-- Meal Tickets For Staff MenuType -->
			<tr>
				<td class='label' >
					<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}" />
				</td>
				<td>
						<select name="MenuType" id="MenuType" id ='MenuType' >						
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
				<% 
					try{
										sql= "select menu_type, short_desc from ds_menu_type order by 2,1";
										stmt=conn.prepareStatement(sql);
										rst=stmt.executeQuery();
										if(rst!=null)
										{
										   while(rst.next())
												{
													menu_type_code=rst.getString(1);
													menu_type_description=rst.getString(2);
				%>
												   <option value="<%=menu_type_code%>"><%=menu_type_description%>
				<%		}
						}
				%>
									</select>							
				<% }catch(Exception e){
							e.printStackTrace();
						}
					finally{
					try{
						if(rst!=null) rst.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
							}
					}
				%>
				</td>				
			</tr>		
			
			
		<!-- Meal Tickets For Staff OrderDate -->
			<tr>
			  <td  class="label">
					<fmt:message key="Common.OrderDate.label" bundle="${common_labels}" />
			  </td>
			  <td>
					<input type="text" name="date" id="date" maxlength="10" size="10" value="<%=current_date%>" onkeypress="return checkForSpecCharsforID(event);" onblur='validDateObj(this,"DMY","<%=locale%>");'>
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date');">
					<img src='../../eCommon/images/mandatory.gif' />
			  </td>				              
		    </tr>
			
		<!-- Meal Tickets For Staff DietRequestLocation -->
			<tr>
				<td class='label' >
					<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
				</td>
				<td>
					<select name="dietLocation" id="dietLocation" id ='dietLocation' >								
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
					</option>
				<% 
					try{ 
							sql= "SELECT LOCATION_CODE, SHORT_DESC FROM ds_diet_request_loc_lang_vw WHERE language_id = 'en' and eff_status = 'E' ORDER BY 2, 1";
		
							stmt=conn.prepareStatement(sql);
							rst=stmt.executeQuery();
							if(rst!=null)
							{
							   while(rst.next())
									{
										diet_location_code=rst.getString(1);
										diet_location_description=rst.getString(2);				 
				%>			 
									
							<option value="<%=diet_location_code%>" ><%=diet_location_description%>
				<%						
						}
						}
				%>
					</select>
						
				<% }catch(Exception e){
					e.printStackTrace();
					}
					finally{
					try{
						if(rst!=null) rst.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					}
				%>
				</td>
			</tr>
			
		<!-- Meal Tickets For Staff Meal Category-->
			<tr>
				<td class='label' >
					<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" />
				</td>
				<td>				
					<select name="mealCategory" id="mealCategory" onChange="callPractitioner(this)">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
					</option>
				<% 
					try{												
							sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = '"+locale+"') ORDER BY 2, 1";

							stmt=conn.prepareStatement(sql);
							rst=stmt.executeQuery();
							if(rst!=null)
							{
							   while(rst.next())
									{
										meal_category_code=rst.getString(1);
										meal_category_description=rst.getString(2);
				%>
								  <option value="<%=meal_category_code%>"><%=meal_category_description%>
				<%  
									}
							}
				%>
					</select>	
					<img src='../../eCommon/images/mandatory.gif'></img>
				 <% }catch(Exception e){
						e.printStackTrace();
						}
				  finally{
					try{
						if(rst!=null) rst.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					}
				%>
				</td>
			</tr>

		<!-- Meal Tickets For Staff Practitioner Id -->
			<tr id="practId" style="display:none;">
				<td align='right' width='30%' class="label">
					<fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/>&nbsp;&nbsp;
				</td>
				<td>
					<input type=text name='practitioner_id' id='practitioner_id'  onblur="callPractSearch1(this,practitioner_id,'en','<%=facility_id%>');" value=''   size='25' >
					<input type=hidden name='practitionerid' id='practitionerid'  value='' size='30' maxlength='30' >
					</input>	
				</td>
			</tr>

		<!-- Meal Tickets For Staff Practitioner Name -->
			<tr id="practName" style="display:none;">
				<td class='label' >
					<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />	
				</td>
				<td>
				   <input type=text name='practitioner_name' id='practitioner_name' value=''  size='25'>
	  			   <input type=hidden name='practitionername' id='practitionername'  value='' size='30' maxlength='30'>
				   </input>
				   <input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick =   "callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" >
					
					<!-- <img src='../../eCommon/images/mandatory.gif'></img> -->
				</td>
			</tr>

		<!-- Meal Tickets For Staff DietType -->
			<tr>
				<td class='label' >
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
				</td>							
				<td>
					<select name="DietType" id="DietType" id='DietType'>
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
					</option>
				<% 
					try
					{
						sql= "select DIET_TYPE,SHORT_DESC from DS_DIET_TYPE_LANG_VW where (LANGUAGE_ID='"+locale+"') and (EFF_STATUS='E') and (appl_staff_order_yn = 'Y') order by  2 , 1";
						stmt=conn.prepareStatement(sql);
						rst=stmt.executeQuery();
					if(rst!=null)
					{
						while(rst.next())
						{
							diet_type_code=rst.getString(1);
							diet_type_description=rst.getString(2);
				%>
							<option value="<%=diet_type_code%>"><%=diet_type_description%>
				<%  
					}
					}
				%>
					</select>							
				<% }catch(Exception e){
						e.printStackTrace();
					}
					finally{
					try{
						if(rst!=null) rst.close();
						if(stmt!=null) stmt.close();
					}catch(Exception e)
					{
						e.printStackTrace();
					}
					}
				%>
				</td>				
			</tr>
		
		<!-- Meal Tickets For Staff MealClass -->
			<tr>	
				<td  class="label">
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
				</td>
					<td>
						<select name="mealClass" id="mealClass">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
						</option>
				<%
						try
						{
							sql ="select mealclass.meal_Class, mealclass.short_Desc from Ds_Meal_Class_Lang_Vw mealclass where mealclass.language_Id='"+locale+"' and mealclass.eff_Status='E' and (appl_staff_order_yn ='Y')";

							stmt=conn.prepareStatement(sql);
							rst = stmt.executeQuery();
							while(rst.next()){
								mealCode = rst.getString(1);
								mealDesc =  rst.getString(2);
				%>
						<option value="<%=mealCode%>"><%=mealDesc%></option>
				<%}
						}catch(Exception DCat)
						  {
							  System.out.println("GenerateMeal Plan Kitchen"+DCat);
							  DCat.printStackTrace();
						  }
						   finally
						   {
							   if(rst != null) rst.close();
							   if(stmt != null) stmt.close();
						   }
				%>
						</select>
						</td>
						<td>
				</td>				
			</tr>

			<!-- Meal Tickets For Staff MealType -->	
			<tr>
				<td  class="label">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
				</td>
				<td>
					<select name="mealType" id="mealType">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
					</option>
				<%
					try
					{
						sql ="select mealType.meal_Type,mealType.short_Desc from Ds_Meal_Type_Lang_Vw mealType where mealType.eff_Status ='E'	and mealType.language_Id like '"+locale+"' order by meal_order";														
						stmt=conn.prepareStatement(sql);
						rst = stmt.executeQuery();
						while(rst.next()){
							strMtype = rst.getString(1);
							strMDesc = rst.getString(2);
				%>
						<option value="<%=strMtype%>"><%=strMDesc%></option>
				<%}%>
						</select>
					</td>
				<%
					}
					catch(Exception e){
						e.printStackTrace();
					}
					finally
					{
						if(rst !=null) rst.close();
						if(stmt !=null) stmt.close();
					}
				%>
				<td>
				</td>
			</tr>
	</table>
				<%
					}
					catch(Exception e){
						e.printStackTrace();
						out.println(e);
					}finally{
						if(rst !=null) rst.close();
						if(st !=null) st.close();
						if(conn!=null)  ConnectionManager.returnConnection(conn, request);
					}
				%>

	<input type="hidden" name="method" id="method"/>
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
	<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
	<input type="hidden" name="module_id" id="module_id" value="DS">
	<input type="hidden" name="p_report_id" id="p_report_id" id ="p_report_id" value="DSMOFSMLT">
	<input type="hidden" name="report_id" id="report_id" id ="report_id" value="DSMOFSMLT"/>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
	<input type="hidden" name="datepattrn" id="datepattrn" value="dd/MM/yyyy"/>
	<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
	<input type="hidden" name="converDate" id="converDate" value="" />
	<input type='hidden' name='PARAM1' id='PARAM1' value="" />
	<input type="hidden" name="selectedAll" id="selectedAll" id="selectedAll" value="" />	
</form>
</body>
</html>


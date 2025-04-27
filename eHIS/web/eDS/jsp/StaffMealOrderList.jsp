<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,eCommon.Common.*,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>

<%
	String locale = (String)session.getAttribute("LOCALE");
	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
	.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
	:"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
	String facility_id=(String)session.getAttribute("facility_id");//Added Against CRF-0678
%>

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script Language="JavaScript" src="../../eDS/js/StaffMealOrderList.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<%
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String sql="";
	String strCode ="";
	String strDesc ="";
	String servingDate="";
	String strMtype = "";
	String strMDesc = "";
	String dietCode = "";
	String dietDesc = "";
	String mealCode = "";
	String mealDesc = "";
	boolean isMultiDietType =false; //Added By Gaurav Against MMS-KH-SCF-0207

try{
		conn = ConnectionManager.getConnection(request);
		isMultiDietType = CommonBean.isSiteSpecific(conn,"DS","DS_MULTI_DIET_TYPES"); //Added By Gaurav Against MMS-KH-SCF-0207
		pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");
		rst = pstmt.executeQuery();
		while(rst.next()){
			servingDate = rst.getString("CURRENT_DATE");
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();	
%>

<body onload="getlocation()" >
	<br>
		<form name="StaffMealOrderList" id="StaffMealOrderList" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>

			   <tr>
					  <td  class="label">
						  <fmt:message key="Common.date.label" bundle="${common_labels}" />
					  </td>
					  <td>
					  <input type="text" name="date" id="date" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='validDateObj(this,"DMY","<%=locale%>");'>
					  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date');"><!-- ML-MMOH-SCF-0564 -->
					  <img src='../../eCommon/images/mandatory.gif' />
					  </td>
				              
		    	</tr>
			                
			 <!-- Added against ML-MMOH-CRF-0419 List View Starts -->		
							
                <tr>
					<td  class="label">
						<fmt:message key="eDS.DietRequestLocation.Label" bundle="${ds_labels}" />
					</td>
					<td  class='label'>
				<%if(isMultiDietType){%>	
					<select name="loc" id="loc" id="loc"  onchange="selectAll(this.value)" >
						   <option value="">
				<%}else{%>			   
						<select name="loc" id="loc" id="loc"  onchange="selectAll(this.value)" multiple>
				<%}%>		   
						   <option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				           <fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				           </option>
						</select>			
					</td>
				</tr>			 
							
			<!--CRF-0419-->			
		    	<tr>	
					<td  class="label">
						<fmt:message key="eOT.MealCategory.Label" bundle="${ot_labels}" />
	 			    </td>
		            <td>
					<select name="mealCategory" id="mealCategory" onChange="callPractitioner(this)"><!--CRF-0678-->
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
							<%
									try
									{
										//Added against ML-MMOH-CRF-0678
										sql= "SELECT meal_category_code, description FROM ds_meal_category_lang_vw WHERE meal_category_code IN ('STF', 'ONC', 'STU','DOC','OPS') AND (language_id = '"+locale+"') ORDER BY 2, 1";

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
										  System.out.println("GenerateMeal Plan Kitchen"+DCat);
									  }
									   finally
									   {
										   if(rst != null) rst.close();
										    if(pstmt != null) pstmt.close();
									   }

								%>
									</select>
						</td>
				 <td>
				</td>
			</tr>
			
		<!-- Added Against CRF-0678 Starts Here-->
		<tr id="practName" style="display:none;">
				<td class='label' >
					<fmt:message key="eDS.practitionerName.Label" bundle="${ds_labels}" />					
				</td>
         	<td>
			<input type=text name='practitioner_name' id='practitioner_name'  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" value=''  onblur="" size='25' >
			<input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input>
			<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" >
			
		</td>
         	</tr>				
		<!-- Added Against CRF-0678 Ends Here-->

			<tr>
				<td  class="label">
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
				</td>			
				<td>
							<select name="dietType" id="dietType">
								<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
			<%
							try
							{
								sql ="select diettype.diet_Type,diettype.short_Desc from Ds_Diet_Type_Lang_Vw diettype where diettype.eff_Status='E' and diettype.language_Id like '"+locale+"' and (appl_staff_order_yn = 'Y')";//Modified against CRF-0419
									pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									dietCode = rst.getString(1);
									dietDesc =  rst.getString(2);
			%>
							<option value="<%=dietCode%>"><%=dietDesc%></option>
			<%}

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
							</select>
						</td>
						<td>
				</td>				
			</tr>

			<tr>	
				<td  class="label">
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
				</td>
					<td>
						<select name="mealClass" id="mealClass">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
						<%
									try
									{
										sql ="select mealclass.meal_Class, mealclass.short_Desc from Ds_Meal_Class_Lang_Vw mealclass where mealclass.language_Id='"+locale+"' and mealclass.eff_Status='E' and (appl_staff_order_yn ='Y')";//Modified against CRF-0419
											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											mealCode = rst.getString(1);
											mealDesc =  rst.getString(2);
									%>
									<option value="<%=mealCode%>"><%=mealDesc%></option>
									<%}

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
									</select>
								</td>
						<td>
				</td>				
			</tr>

			<tr>
				<td  class="label">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" />
							</td>
								<td>
									<select name="mealType" id="mealType">
										<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
										<%
								try
								{
									sql ="select mealType.meal_Type,mealType.short_Desc from Ds_Meal_Type_Lang_Vw mealType where mealType.eff_Status ='E'	and mealType.language_Id like '"+locale+"' order by meal_order";														
									pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
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
						    if(pstmt !=null) pstmt.close();
						}
					%>
							<td>
						</td>
						<%
						}
						catch(Exception e)	  {}
						finally
						{
							try{
								if(pstmt!=null) pstmt.close();
								if(rst!=null) rst.close();
								ConnectionManager.returnConnection(conn);
							}
							catch(Exception e){
								System.err.println("Exception in Staff Meal Order List:"+e);
						}	}

					%>
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
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		</table>
				<hidden property="method"/>
				<hidden property="moduleId" value="DS"/>
				
				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>
				
				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>
				
				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">
						
				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
				<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
				
				<input type='hidden' name='p_report_id' id='p_report_id' value="DSRSTFOR">
				<input type='hidden' name='report_id' id='report_id' value="DSRSTFOR">
				
				<input type='hidden' name='P_Diet_Location' id='P_Diet_Location' value=''>
				<input type='hidden' name='P_Order_Date' id='P_Order_Date' value="">
				<input type='hidden' name='P_Meal_Category' id='P_Meal_Category' value=''>
				<input type='hidden' name='P_Diet_Type' id='P_Diet_Type' value=''>
				<input type='hidden' name='P_Meal_Class' id='P_Meal_Class' value=''>
				<input type='hidden' name='P_Meal_Type' id='P_Meal_Type' value=''>
				<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">	
                <input type="hidden" id="selectedAll" name="selectedAll" id="selectedAll" value="" /><!-- CRF-0419 -->	
                <input type="hidden" id="selectedAlldescription" name="selectedAlldescription" id="selectedAlldescription" value="" />	<!--CRF-0419-->
</form>
</body>
</html>


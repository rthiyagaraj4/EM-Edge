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
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eDS/js/MealOrderList.js'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- Added against ML-MMOH-CRF-0682 Starts-->
<script>
/*
	function changeRepId()
	{
		var repType = document.getElementById("repType").value;
		var PatientClass = document.getElementById("PatientClass").value;	
		if(repType == 'Summary')
		{
			if(PatientClass == 'IP')
			{
				document.getElementById("report_id").value = "DSRMLORLS";
				document.getElementById("p_report_id").value = "DSRMLORLS";
			}
			else if (PatientClass == 'OP')
			{		
				document.getElementById("report_id").value = "DSRMLORLS";
				document.getElementById("p_report_id").value = "DSRMLORLS";
			}
			else if (PatientClass == 'EM')
			{		
				document.getElementById("report_id").value = "DSRMLORLS";
				document.getElementById("p_report_id").value = "DSRMLORLS";
			}
		}
		else if(repType == 'Detail')
		{
			if(PatientClass == 'IP')
			{
				document.getElementById("report_id").value = "DSRMLORLD";
				document.getElementById("p_report_id").value = "DSRMLORLD";
			}
			else if (PatientClass == 'OP')
			{
				document.getElementById("report_id").value = "DSRMLORLD";
				document.getElementById("p_report_id").value = "DSRMLORLD";
			}
			else if (PatientClass == 'EM')
			{
				document.getElementById("report_id").value = "DSRMLORLD";
				document.getElementById("p_report_id").value = "DSRMLORLD";
			}
		}
		else if(repType == 'Both')
		{
			if(PatientClass == 'IP')
			{
				document.getElementById("report_id").value = "DSRMLORL";
				document.getElementById("p_report_id").value = "DSRMLORL";
			}
			else if (PatientClass == 'OP')
			{
				document.getElementById("report_id").value = "DSRMLORL";
				document.getElementById("p_report_id").value = "DSRMLORL";
			}
			else if (PatientClass == 'EM')
			{
				document.getElementById("report_id").value = "DSRMLORL";
				document.getElementById("p_report_id").value = "DSRMLORL";
			}
		}
	}
*/ //Commented Against ML-MMOH-SCF-1543

</script>
<!-- Added against ML-MMOH-CRF-0682 Ends-->
</head>
<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<br>
	<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rst=null;
		String facility_id  = (String) session.getValue("facility_id");
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
			<td align="left" class="label">
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
			</td>
			<td align="left" class='label'>				
				<select name="kitchen" id="kitchen" onchange="getWards(this.value);">
				<option value="">
					<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				</option>

				<%
					try
					{
						sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"' AND EFF_STATUS='E' order by 2";

						pstmt=conn.prepareStatement(sql);
						rst = pstmt.executeQuery();
						while(rst.next()){
						strCode = rst.getString(1);
						strDesc =  rst.getString(2);
				%>
				<option value="<%=strCode%>"><%=strDesc%></option>
				<%	}
						}
						catch(Exception DCat)
						{
							DCat.printStackTrace();
							System.out.println("MealOrderList==Kitchen==>"+DCat);
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
				<td align="left" class="label">
					<fmt:message key="Common.date.label" bundle="${common_labels}"/>
				</td>
				<td align="left" class='label'>
					<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
					<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
					<img src='../../eCommon/images/mandatory.gif' />
				</td>
			</tr>
			<!--<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>-->
					<!-- Added against ML-MMOH-CRF-0682 Starts-->
					<!--
			   <tr>	 
					<td class="label" >
						<fmt:message key="Common.patientclass.label" bundle="${ds_labels}"/>
					</td>
					<td class='label'>
						<select name="PatientClass" id="PatientClass" id="PatientClass">
								<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${ds_labels}"/></option> 
								<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${ds_labels}"/></option>
								<option value="EM"><fmt:message key="Common.emergency.label" bundle="${ds_labels}"/></option>
						</select>
				   </td>
				   --><!--Commented Against ML-MMOH-SCF-1543-->
			<!-- Added against ML-MMOH-CRF-0682 Ends-->
					
		<tr>
			<td align="left" class="label">
				<fmt:message key="eOT.Ward.Label" bundle="${ot_labels}"/>
			</td>
			<td align="left" class='label'>
			<%if(isMultiDietType){%>
				<select name="ward" id="ward" onchange="selectAll(this.value)">
			<%}else{%>		
				<select name="ward" id="ward" onchange="selectAll(this.value)" multiple style="height: auto; overflow: auto; min-width: 12vw;">
			<%}%>	
				<option value="">   <!-- modified against ML-MMOH-CRF-1818-->
				<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="left" class="label">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
			</td>
			<td align="left" class='label'>
				<select name="mealClass" id="mealClass">
				<option value="">
					<fmt:message key="eOT.select.Label" bundle="${ot_labels}"/>
				</option>
				<%
					try
					{
						String mealClassCode = "";
						String description =  "";
						//String sql_meal_Class ="select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+locale+"' and eff_Status ='E' order by short_Desc ASC";
						String sql_meal_Class ="select meal_Class,short_Desc from Ds_Meal_Class_Lang_Vw where language_Id like '"+locale+"' order by short_Desc ASC";//59957
						pstmt=conn.prepareStatement(sql_meal_Class);
						rst = pstmt.executeQuery();
						while(rst.next()){
						mealClassCode = rst.getString(1);
						description =  rst.getString(2);
				%>
				<option value="<%=mealClassCode%>"><%=description%></option>
				<%}
					}
					catch(Exception DCat)
					{
						DCat.printStackTrace();
						System.out.println("MealOrderList==MealClass==>"+DCat);
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
				<td align="left" class="label">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class='label'>
					<select name="mealType" id="mealType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
					{
						String mealTypeCode = "";
						String mealTypeDesc =  "";
						//String sql_meal_type ="select meal_type,short_Desc from ds_meal_type_lang_vw where language_Id like '"+locale+"' and eff_Status ='E' order by meal_order ASC";
						String sql_meal_type ="select meal_type,short_Desc from ds_meal_type_lang_vw where language_Id like '"+locale+"' order by meal_order ASC";//59957
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
						DCat.printStackTrace();
						System.out.println("MealOrderList==MealType==>"+DCat);
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
				<td align="left" class="label">
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
				</td>
				<td align="left" class="label">
				<%if(isMultiDietType){%>
					<!-- Added Against ML-MMOH-CRF-1818 Starts-->
					<input type="text" value="" id="dietTypeDesc" name="dietTypeDesc" id="dietTypeDesc" onblur="if(this.value!='') return dietTypeLookup('dietTypeDesc'); else dietType.value=''"/>
					<input type="hidden"  value="" name="dietType" id="dietType" />
					<input type="button" id="bt" class="BUTTON" value="?" onclick="dietTypeLookup('dietTypeDesc')" />
					<!-- Added Against ML-MMOH-CRF-1818 Ends-->				
				<%}else{%>
					<!-- Commented Against ML-MMOH-CRF-1818 -->
					<select name="dietType" id="dietType"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
					try
						{
							String dietTypeCode = "";
							String dietTypeDesc =  "";
							//String sql_diet_type ="select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id like '"+locale+"' and eff_Status ='E' order by short_Desc ASC";
							String sql_diet_type ="select diet_type,short_Desc from ds_diet_type_lang_vw where language_Id like '"+locale+"' order by short_Desc ASC";//59957
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
							DCat.printStackTrace();
							System.out.println("MealOrderList==DietType==>"+DCat);
						}
						finally
						{
							if(rst != null) rst.close();
							if(pstmt != null) pstmt.close();
						}

				%>
					</select>

			<%}%>	
		   </td>
			</tr>

			<!-- Added against ML-MMOH-CRF-0412 -->
			<tr>
				<td align="left" class="label">
					<fmt:message key="eDS.TextureOfDiet.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class='label'>
					<select name="textureofdiet" id="textureofdiet"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				<%
						try
						{
							String textureDietCode = "";
							String textureDietDesc =  "";
							//String sql_textureDiet ="select texture_of_diet,short_Desc from ds_texture_of_diet_lang_vw where language_Id like '"+locale+"'  and eff_Status ='E' order by short_desc ASC";
							String sql_textureDiet ="select texture_of_diet,short_Desc from ds_texture_of_diet_lang_vw where language_Id like '"+locale+"' order by short_desc ASC";//59957
							pstmt=conn.prepareStatement(sql_textureDiet);
							rst = pstmt.executeQuery();
							
							while(rst.next()){
							textureDietCode = rst.getString(1);
							textureDietDesc =  rst.getString(2);
				%>
					<option value="<%=textureDietCode%>"><%=textureDietDesc%></option>
				<%}
						}
						catch(Exception DCat)
						{
							DCat.printStackTrace();
							System.out.println("MealOrderList==TextureOfDiet==>"+DCat);
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
			<!-- Added against ML-MMOH-CRF-0412 -->

			<tr>
			<td align="left" class="label">
					<fmt:message key="eDS.SearchFor.Label" bundle="${ds_labels}"/>
				</td>
				<td align="left" class='label'>					
					<select name="SearchFor" id="SearchFor">
						<option value="RLO"><fmt:message key="eDS.RegularLateIrregularDietOrders.Label" bundle="${ds_labels}"/></option>
						<option value="RO"><fmt:message key="eDS.RegularDietOrders.Label" bundle="${ds_labels}"/></option>
						<option value="LO"><fmt:message key="eDS.LateIrregularDietOrders.Label" bundle="${ds_labels}"/></option>
					 </select>
				</td>
			</tr>
			<!-- Added against ML-MMOH-CRF-0682 Starts-->
			<!--
				<tr>
					<td align="right" class="label">
							<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
					</td>
					 <td align="right" class='label'>
						<select name="repType" id="repType" id="repType" onchange="changeRepId();">
						<option value="Summary"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						<option value="Detail"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
						<option value="Both"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						</select>
					</td>			
				</tr>--><!--Commented Against ML-MMOH-SCF-1543-->
				<!-- Added against ML-MMOH-CRF-0682 Ends -->
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

	<input type="hidden" name="p_report_id" id="p_report_id" value="DSRMLORL">
	<input type="hidden" name="report_id" id="report_id" value="DSRMLORL"/><!--Added Against ML-MMOH-SCF-1543-->

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


<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
	<%
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		String language_Id = (String)session.getAttribute("LOCALE");
	%>    

	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script Language="JavaScript" src="../../eDS/js/MenuforDietType.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript">

	
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
    	    			
</head>
	<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			String sql="";
			String strCode ="";
			String strDesc ="";
			String strDtype = "";
			String strDDesc = "";
			String strMtype = "";
			String strMDesc = "";
			// Checkstyle Violation commented by Munisekhar
			//String strCtype = "";
			//String strCDesc = "";
			

			try{

				conn = ConnectionManager.getConnection(request);
			
		%>
		
		<form name="MenuforDietType" id="MenuforDietType" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				<tr>
					<td  class="label">
						<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
					</td>
						<td>
							<select name="Kitchen" id="Kitchen">
								<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
								<%
									try
									{
									sql ="select  KITCHEN_CODE,SHORT_DESC  from DS_KITCHENS_LANG_VW  where language_id ='"+locale+"' and operating_facility_id ='"+facility_id+"'";

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
							<img src='../../eCommon/images/mandatory.gif' />
							</td>
						<td>
					</td>
				</tr>
			<tr>
   			<td>
				</td>
					<td align="left" class="label">
							<fmt:message key="Common.from.label" bundle="${common_labels}" />
						</td>
							<td align="left" class="label">
							<fmt:message key="Common.to.label" bundle="${common_labels}" />
						</td>
					</tr>		
					          <tr>
								<td  class="label">
								<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" />
							</td>
							<td>
								<select name = "dietTypeFrom">
									<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
									<%
										   try
											{
												sql ="select dietType.diet_type,dietType.short_Desc from DS_DIET_TYPE_Lang_Vw dietType where dietType.eff_Status ='E'	and dietType.language_Id like '"+locale+"'";
														pstmt=conn.prepareStatement(sql);
														rst = pstmt.executeQuery();
														while(rst.next()){
														strDtype = rst.getString(1);
														strDDesc =  rst.getString(2);
											%>
											<option value="<%=strDtype%>"><%=strDDesc%></option>
											<%} %>
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
							<select name = "dietTypeTo">
								<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" />
								
								<%pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strDtype = rst.getString(1);
									strDDesc =  rst.getString(2);%>
									<option value="<%=strDtype%>"><%=strDDesc%></option>
									<%} %>
									</select>
								</td>
							</tr>
								
							<tr>
						<td  class="label">
							<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" />
								</td>
									<td>
										<select name="mealClassFrom" id="mealClassFrom">
											<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
											<%
												try
												{
												sql ="select mealClass.meal_class,mealClass.short_Desc from ds_meal_class_Lang_Vw mealClass where mealClass.eff_Status ='E'	and mealClass.language_Id like '"+locale+"'";
														pstmt=conn.prepareStatement(sql);
														rst = pstmt.executeQuery();
														while(rst.next()){
														strMtype = rst.getString(1);
														strMDesc =  rst.getString(2);
											%>
											<option value="<%=strMtype%>"><%=strMDesc%></option>
											<%} %>
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
								<select name="mealClassTo" id="mealClassTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
									<%pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strMtype = rst.getString(1);
									strMDesc =  rst.getString(2);%>
									<option value="<%=strMtype%>"><%=strMDesc%></option>
									<%} %>
									</select>
								</td>
								</tr>
								<tr>
						<td  class="label">
							<fmt:message key="eOT.DayRefCode.Label" bundle="${ot_labels}" />
								</td>
									<td>
										<select name="dayRefCodeFrom" id="dayRefCodeFrom">
											<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
											<option value="1">1</option><option value="2">2</option>
											<option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option>
												
											</select>
										</td>
										
									<td>
								<select name="dayRefCodeTo" id="dayRefCodeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
									<option value="1">1</option><option value="2">2</option>
											<option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12">12</option><option value="13">13</option><option value="14">14</option>
									
								</select>
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
												System.err.println("Exception in Menu For Diet Type List:"+e);
											}
									   }

								%>
							</tr>
							
				
					<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
					<hidden property="method"/>
					<hidden property="functionId" value="DSR_MENU_FOR_DIET_TYPE"/>
					<hidden property="moduleId" value="DS"/>
					<input type="hidden" name="language_id" id="language_id" value="<%=language_Id%>"/>
					<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>"/>
					
					<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
					<input type="hidden" name="module_id" id="module_id" value="DS">

					<input type="hidden" name="p_report_id" id="p_report_id" value="DSRMNUDT">
					<input type="hidden" name="report_id" id="report_id" value="DSRMNUDT"/>
			
					<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
					<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">
					<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>
					<input type="hidden" name="P_KITCHEN_CODE" id="P_KITCHEN_CODE"/>
					
					<input type='hidden' name='PARAM1' id='PARAM1' value=''>
					<input type='hidden' name='PARAM2' id='PARAM2' value=''>
					<input type='hidden' name='PARAM3' id='PARAM3' value=''>
					<input type='hidden' name='PARAM4' id='PARAM4' value=''>
					<input type='hidden' name='PARAM5' id='PARAM5' value=''>
					<input type='hidden' name='PARAM6' id='PARAM6' value=''>
					<input type='hidden' name='PARAM7' id='PARAM7' value=''>
					<input type='hidden' name='PARAM8' id='PARAM8' value=''>		
			</form>
		</body>
</html>


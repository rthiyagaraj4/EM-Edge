<!DOCTYPE html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.net.URLEncoder,java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<IBATagLibs:initCalendar /> 
	 <%
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		
	%>       
	<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<Script Language="JavaScript" src="../../eDS/js/AttendMealList.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
	<%
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rst=null;
			String facility_id  = (String) session.getValue("facility_id");
			// Checkstyle Violation commented by Munisekhar
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String strCode ="";
			String strDesc ="";
			String wardCode ="";
			String wardDesc ="";
			String servingDate="";
			String strMtype = "";
			String strMDesc = "";
			String mealClassId = "";
			String mealClassDescription =  "";
			String dietTypeId = "";
			String dietTypeDescription =  "";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = rst.getString("CURRENT_DATE");
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				
			
			
		%>
	<body>
	<br>
		<form name="AttendMealList" id="AttendMealList" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
				<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			<tr>
				<td  class="label">
							<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}" />
					</td>		
					<td align="left">
							<select name="kitchen" id="kitchen">
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
							<fmt:message key="Common.date.label" bundle="${common_labels}" />
					</td>
					<td align="left">
							<Input name="dateFrom" id="dateFrom" value="<%=servingDate%>"  size="10" maxlength="10" onkeypress="return checkForSpecCharsforID(event);"  onblur='validDateObj(this,"DMY","<%=locale%>");'/> 
							<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateFrom');">
							<img src='../../eCommon/images/mandatory.gif' />
					</td>
					<td align="left">
							<Input name="dateTo" id="dateTo" value="<%=servingDate%>"  size="10" maxlength="10"onkeypress="return checkForSpecCharsforID(event);"  onblur='validDateObj(this,"DMY","<%=locale%>");'/>  
							<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dateTo');">
							<img src='../../eCommon/images/mandatory.gif' />
					</td>
				</tr>
				<tr>	
					<td  class="label">
							<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}" />
					</td>
					<td align="left">
							<select name="wardCodeFrom" id="wardCodeFrom">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
							<%
									try
									{
									sql ="SELECT IP_WARD.NURSING_UNIT_CODE, IP_WARD.SHORT_DESC FROM IP_NURSING_UNIT_LANG_VW IP_WARD WHERE IP_WARD.EFF_STATUS ='E'	AND IP_WARD.FACILITY_ID LIKE '"+facility_id+"' AND IP_WARD.LANGUAGE_ID LIKE '"+locale+"'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											wardCode = rst.getString(1);
											wardDesc =  rst.getString(2);
							%>
							<option value="<%=wardCode%>"><%=wardDesc%></option>
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
					<td align="left">
							<select name="wardCodeTo" id="wardCodeTo">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
							<%
								pstmt=conn.prepareStatement(sql);
								rst = pstmt.executeQuery();
								while(rst.next()){
								wardCode = rst.getString(1);
								wardDesc =  rst.getString(2);
							%>
							<option value="<%=wardCode%>"><%=wardDesc%></option>

							<%}%>
							</select>
					</td>
			</tr>	
<!-- start MMS-QH-CRF-0190 -->
			<tr>	
				<td  class="label"> <fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}" /> </td>
				<td align="left">
					<select name="mealClassFrom" id="mealClassFrom">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
<%
				try
				{
							String sql_meal_Class = "select meal_Class,ds_get_desc.ds_meal_class(meal_Class,'"+locale+"', 2)  short_Desc from Ds_Meal_Class where eff_Status ='E'";
							pstmt=conn.prepareStatement(sql_meal_Class, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							rst = pstmt.executeQuery();
							while(rst.next())
							{
								mealClassId = rst.getString(1);
								mealClassDescription =  rst.getString(2);
%>
								<option value="<%=mealClassId%>"><%=mealClassDescription%></option>
<%
							}
%>
					</select>
				</td>
				<td align="left">
					<select name="mealClassTo" id="mealClassTo">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
<%
							rst.beforeFirst();
							while(rst.next())
							{
								mealClassId = rst.getString(1);
								mealClassDescription =  rst.getString(2);
%>
								<option value="<%=mealClassId%>"><%=mealClassDescription%></option>
<%
							}
%>
					</select>
<%
				}
				catch(Exception ex)
				{
					System.out.println("mealClass Plan Kitchen"+ex);
				}
				finally
				{
					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
				}
%>
				</td>
			</tr>

			<tr>	
				<td  class="label"> <fmt:message key="eOT.DietType.Label" bundle="${ot_labels}" /> </td>
				<td align="left">
					<select name="dietTypeFrom" id="dietTypeFrom">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
<%
				try
				{
							String sqlDietType = "SELECT   diet_type, short_desc FROM ds_diet_type WHERE eff_status = 'E' ORDER BY 2, 1";
							pstmt=conn.prepareStatement(sqlDietType, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							rst = pstmt.executeQuery();
							while(rst.next())
							{
								dietTypeId = rst.getString(1);
								dietTypeDescription =  rst.getString(2);
%>
								<option value="<%=dietTypeId%>"><%=dietTypeDescription%></option>
<%
							}
%>
					</select>
				</td>
				<td align="left">
					<select name="dietTypeTo" id="dietTypeTo">
						<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
<%
							rst.beforeFirst();
							while(rst.next())
							{
								dietTypeId = rst.getString(1);
								dietTypeDescription =  rst.getString(2);
%>
								<option value="<%=dietTypeId%>"><%=dietTypeDescription%></option>
<%
							}
%>
					</select>
<%
				}
				catch(Exception ex)
				{
					System.out.println("mealClass Plan Kitchen"+ex);
				}
				finally
				{
					if(rst != null) rst.close();
					if(pstmt != null) pstmt.close();
				}
%>
				</td>
			</tr>

<%--
			<tr>
					<td  class="label">
							<fmt:message key="eOT.MealTypeTab.Label" bundle="${ot_labels}" />
					</td>
					<td align="left">
							<select name="mealTypeFrom" id="mealTypeFrom">
							<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
							<%
								try
								{
									sql ="select mealType.meal_Type,mealType.short_Desc from Ds_Meal_Type_Lang_Vw mealType where mealType.eff_Status ='E' and mealType.language_Id like '"+locale+"' order by meal_order";														
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
					<td align="left">
							<select name="mealTypeTo" id="mealTypeTo">
								<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
								<%
									pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strMtype = rst.getString(1);
									strMDesc =  rst.getString(2);
								%>
								<option value="<%=strMtype%>"><%=strMDesc%></option>
								<%}%>
							</select>
					</td>
				</tr>
--%>
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
								System.err.println("Exception in Attendant Meal List:"+e);
							}
						}
					%>
<!-- end MMS-QH-CRF-0190 -->
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			</table>
			<hidden name="method"/>
			<hidden name="functionId" value="DSR_ATTND_MEAL_LIST"/>
			<hidden name="moduleId" value="DS"/>
			
			<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

			<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<input type='hidden' name='p_language_id' id='p_language_id' value='<%=locale%>'>
			
			<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
			<input type="hidden" name="module_id" id="module_id" value="DS">

			<input type="hidden" name="p_report_id" id="p_report_id" value="DSRATMLT">
			<input type="hidden" name="report_id" id="report_id" value="DSRATMLT"/>
			</form>		
	</body>
</html>


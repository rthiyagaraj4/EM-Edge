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
	<Script Language="JavaScript" src="../../eDS/js/DSCommercialFormulaDistribution.js"></Script>
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
			// Checkstyle Violation commented by Munisekhar
			//String params="";
			//String source ="";
			//String duration ="";
			String sql="";
			String strCode ="";
			String strDesc ="";
			String servingDate="";
			String strMtype = "";
			String strMDesc = "";
			String strKatype = "";
			String strKaDesc = "";
			String strWctype = "";
			String strWcDesc = "";
			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = rst.getString("CURRENT_DATE");
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
				String SystemDate_display = DateUtils.convertDate(servingDate,"DMY" ,"en",localeName);
			
			
			
		%>
		
		<form name="CommercialFormulaDistributionList" id="CommercialFormulaDistributionList" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
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
					<td>&nbsp;&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;</td>
					<td align="left" class="label"><fmt:message key="Common.from.label" bundle="${common_labels}" /></td>
					<td align="left" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}" /></td>
					<td>&nbsp;&nbsp;</td>
				</tr>		
				<tr>
						<td  class="label"><fmt:message key="Common.date.label" bundle="${common_labels}" /></td>
								<td>
									<input type="text" name="from" id="from" maxlength="10" size="10" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"  onblur='validDateObj(this,"DMY","<%=locale%>");'>
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');">
									<img src='../../eCommon/images/mandatory.gif' />
								</td>
								<td>
									<input type="text" name="to" id="to" maxlength="10" size="10" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);" onblur='validDateObj(this,"DMY","<%=locale%>");'>
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to');">
									<img src='../../eCommon/images/mandatory.gif' />
								</td>
								<td>&nbsp;&nbsp;</td>
				<tr>
					<td class="label"><fmt:message key="eOT.KitchenArea.Label" bundle="${ot_labels}" /></td>
					<td class='fields'><select name = "kitchenAreaFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option><%
												try
												{
												sql ="select KITCHEN_AREA_CODE.KITCHEN_AREA_CODE,KITCHEN_AREA_CODE.short_Desc from DS_KITCHEN_AREA_LANG_VW KITCHEN_AREA_CODE where KITCHEN_AREA_CODE.eff_Status ='E'	and KITCHEN_AREA_CODE.language_Id like '"+locale+"'";
														pstmt=conn.prepareStatement(sql);
														rst = pstmt.executeQuery();
														while(rst.next()){
														strKatype = rst.getString(1);
														strKaDesc =  rst.getString(2);
											%><option value="<%=strKatype%>"><%=strKaDesc%></option>
											<%} %>
					</select></td><%
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
					
					<td class='fields'><select name = "kitchenAreaTo">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option><%pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strKatype = rst.getString(1);
									strKaDesc =  rst.getString(2);%>
									<option value="<%=strKatype%>"><%=strKaDesc%></option>
									<%} %>
					</select></td>
					<td>&nbsp;&nbsp;</td>
				</tr>
							<tr>
						<td  class="label"><fmt:message key="eOT.MealTypeTab.Label" bundle="${ot_labels}" /></td>
									<td>
										<select name="mealTypeFrom" id="mealTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
											<%
												try
												{
												sql ="select mealType.meal_Type,mealType.short_Desc from Ds_Meal_Type_Lang_Vw mealType where mealType.eff_Status ='E'	and mealType.language_Id like '"+locale+"' order by meal_order";
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
								<select name="mealTypeTo" id="mealTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
									<%pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strMtype = rst.getString(1);
									strMDesc =  rst.getString(2);%>
									<option value="<%=strMtype%>"><%=strMDesc%></option>
									<%} %>
								</select>
							</td>
				    <td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}" /></td>
					<td class='fields'><select name = "WardCodeFrom">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
					<%
												try
												{
												sql ="select KITCHEN_CODE.NURSING_UNIT_CODE,KITCHEN_CODE.short_Desc from DS_WARDS_KITCHEN_VW KITCHEN_CODE where KITCHEN_CODE.LINKED_YN ='Y' and operating_facility_id ='"+facility_id+"'";
														pstmt=conn.prepareStatement(sql);
														rst = pstmt.executeQuery();
														while(rst.next()){
														strWctype = rst.getString(1);
														strWcDesc =  rst.getString(2);
											%>
											<option value="<%=strWctype%>"><%=strWcDesc%></option>
											<%} %>
					</select></td><%
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
					
					<td class='fields'><select name = "WardCodeTo">
					<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option><%pstmt=conn.prepareStatement(sql);
									rst = pstmt.executeQuery();
									while(rst.next()){
									strWctype = rst.getString(1);
									strWcDesc =  rst.getString(2);%>
									<option value="<%=strWctype%>"><%=strWcDesc%></option>
									<%}
									
									
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
													System.err.println("Exception in DS Commercial Formula Distribution List:"+e);
												}
										   } 
									%>
					</select></td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
						<td class="label"><fmt:message key="eOT.CommercialFormula.Label" bundle="${ot_labels}" /></td>
							<td>
								<input type="text" name="itemCodeFrom" id="itemCodeFrom" size="30" maxlength="30" onblur="if(this.value!='') getLookupDetail(itemCodeHiddenFrom,itemCodeFrom);else itemCodeHiddenFrom.value=''" value=""/>
								<input type="button" class='button' value='?' onClick="getLookupDetail(itemCodeHiddenFrom,itemCodeFrom);" />
								<input type="hidden" name="itemCodeHiddenFrom" id="itemCodeHiddenFrom" value="">
							</td>
							<td>
								<input name="itemCodeTo" id="itemCodeTo" type="text" size="30" maxlength="30" onblur="if(this.value!='')getLookupDetail(itemCodeHiddenTo,itemCodeTo);else itemCodeHiddenTo.value=''"value=""/>
     							<input type="button" class='button' value='?' onClick="getLookupDetail(itemCodeHiddenTo,itemCodeTo);" />
								<input type='hidden' name="itemCodeHiddenTo" id="itemCodeHiddenTo" value=""/>
						    </td>
							<td>&nbsp;&nbsp;</td>
				</tr>
									
				<tr>
						<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td> 
								<td class='fields'>
									<select name='Reporttype' id='Reporttype'>
											<option value='S'><fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
											<option value='D'><fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
									</select>
								</td>
								<td >&nbsp;</td>
								<td >&nbsp;</td>
				</tr>
				<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
					<hidden property="method"/>
					<hidden property="functionId" value="DSR_COMM_FORMULA_DIST_LIST"/>
					<hidden property="moduleId" value="DS"/>
					<input type="hidden" name="language_id" id="language_id" value="<%=language_Id%>"/>
					<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>"/>
					
					<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
					<input type="hidden" name="module_id" id="module_id" value="DS">

					<input type="hidden" name="p_report_id" id="p_report_id" value="">
					<input type="hidden" name="report_id" id="report_id" value=""/>
			
					<input type='hidden' name='locale' id='locale' value='<%=language_Id%>'>
					<input type='hidden' name='datepattrn' id='datepattrn' value="dd/MM/yyyy">
					<input type='hidden' name='p_language_id' id='p_language_id' value='<%=language_Id%>'>

					<input type='hidden' name='conFromDate' id='conFromDate' value=''>
					<input type='hidden' name='conToDate' id='conToDate' value=''>

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


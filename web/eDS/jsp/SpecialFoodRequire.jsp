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
	<Script Language="JavaScript" src="../../eDS/js/SpecialFoodRequire.js"></Script>
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
			String servingDate="";
			String strMtype = "";
			String strMDesc = "";
			String patient_id_length="";

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
		<%
				try
				{
				sql ="select patient_id_length from MP_PARAM where MODULE_ID='MP'";
				pstmt = conn.prepareStatement(sql);

				rst = pstmt.executeQuery();
				while(rst.next()){
					patient_id_length = rst.getString("patient_id_length");
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
		%>
		<%
		}catch(Exception e){
				  e.printStackTrace();
						}
						finally
						{
						  if(rst !=null) rst.close();
						  if(pstmt !=null) pstmt.close();
					  }
		%>
		
		<body onLoad="startClock();" onKeyDown="lockKey()">
		<form name="SpecialFoodRequire" id="SpecialFoodRequire" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
			
			<tr>
				<td  class='label'>
					<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}"/>
				</td>
				<td  class='label'><input type="text" name="servingDate" id="servingDate" id ="servingDate" maxlength="10" size="10" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"  onblur='validDateObj(this,"DMY","<%=locale%>");'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('servingDate');"><img src='../../eCommon/images/mandatory.gif' /></td>
				<td  class='label'>
					<fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/>
					&nbsp;&nbsp;
				<input type="checkbox" name="frequencyYn" id="frequencyYn" value="on">
				</td>
				     
				
			</tr>
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
					<td  class="label">
							<fmt:message key="Common.from.label" bundle="${common_labels}" />
						</td>
							<td  class="label">
							<fmt:message key="Common.to.label" bundle="${common_labels}" />
						</td>
					</tr>	
                    <tr>
		               <td  class="label">
			           <fmt:message key="eOT.servingTime.Label" bundle="${ot_labels}"/>
		               </td>
		               <td>
		            	<input type=text name="servTimeFrom" id="servTimeFrom" id="servTimeFrom" onkeypress="checkTime('fromTime');" size="5" maxlength="5"/></td>
						<td>
		            	<input type=text name="servTimeTo" id="servTimeTo" id="servTimeTo" onkeypress="checkTime('toTime');" size="5" maxlength="5"/></td>
	              </tr>
				  <tr>
						<td  class="label">
							<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}" />
								</td>
									<td>
										<select name="wardCodeFrom" id="wardCodeFrom">
											<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
											<%
												try
												{
												sql ="select nursing_unit_code,short_Desc from DS_WARDS_KITCHEN_VW  where LINKED_YN='Y' and  operating_facility_id ='"+facility_id+"'";
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
								<select name="wardCodeTo" id="wardCodeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
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
					       <td  class="label"><fmt:message  key="Common.patientId.label"bundle="${common_labels}"/>  
			             </td>
						<td class="label"><input type=text  onblur="ChangeUpperCase(this);" name='patientId' id='patientId' size="20" maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)" align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen();//searchCoderepEnc(this,p_patient_id,p_patinet_class)'></td>
						  
					   </tr>
						
						<tr>
						<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td> 
								<td class='fields'>
									<select name='rpttype' id='rpttype'>
									
											<option value='D'><fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
											<option value='K'><fmt:message key="eOT.KitchenWiseSummary.Label" bundle="${common_labels}"/>
											<option value='W'><fmt:message key="eOT.WardWiseSummary.Label" bundle="${common_labels}"/>
									</select>
								</td>
					         <%
									}
									  catch(Exception e)	  {}
									   finally
									   {
											try{
												
												if(rst!=null) rst.close();
												if(pstmt!=null) pstmt.close();

												ConnectionManager.returnConnection(conn);
											}
											catch(Exception e){
												System.err.println("Exception in Special Food Requirement List:"+e);
											}
									   }

								%>
								</tr>
					<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
					<hidden property="method"/>
					<hidden property="functionId" value="DSR_SP_FOOD_REQD"/>
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


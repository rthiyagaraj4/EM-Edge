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
	<Script Language="JavaScript" src="../../eDS/js/DietTypeMovement.js"></Script>
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
			String servingDate="";
			String strWtype = "";
			String strWDesc = "";
			String strDtype = "";
			String strDDesc = "";
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
		<form name="DietTypeMovement" id="DietTypeMovement" target="messageFrame" method="POST">
			<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
			<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
					<tr>
						<td  class="label">
							<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}" />
								</td>
									<td>
										<select name="wardCode" id="wardCode">
											<option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}" /></option>
											<%
												try
												{
												sql ="select nursing_unit_code,short_Desc from DS_WARDS_KITCHEN_VW  where LINKED_YN='Y' and  operating_facility_id ='"+facility_id+"'";
														pstmt=conn.prepareStatement(sql);
														rst = pstmt.executeQuery();
														while(rst.next()){
														strWtype = rst.getString(1);
														strWDesc =  rst.getString(2);
											%>
											<option value="<%=strWtype%>"><%=strWDesc%></option>
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
								<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;
			<input type=text   name='patientId' id='patientId' size="20" maxlength="<%=patient_id_length%>" onBlur="makeValidString(this);ChangeUpperCase(this);" onKeypress='return CheckForSpecChars(event);'align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen();'></td>
			
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
								<td>
									<input type="text" name="from" id="from" id='from' maxlength="10" size="10" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"   onblur='validDateObj(this,"DMY","<%=locale%>");'>
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('from');">
									<img src='../../eCommon/images/mandatory.gif' />
								</td>
								<td>
									<input type="text" name="to" id="to" id='to'maxlength="10" size="10" value="<%=SystemDate_display%>" onkeypress="return checkForSpecCharsforID(event);"  onblur='validDateObj(this,"DMY","<%=locale%>");'>
									<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('to');">
									<img src='../../eCommon/images/mandatory.gif' />
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
												System.err.println("Exception in Diet Type Movement List:"+e);
											}
									   }

								%>
							</tr>
						
					<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
					<hidden property="method"/>
					<hidden property="functionId" value="DSR_DIET_TYPE_MOVEMENT"/>
					<hidden property="moduleId" value="DS"/>
					<input type="hidden" name="language_id" id="language_id" value="<%=language_Id%>"/>
					<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
					<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

					<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
					<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>"/>
					
					<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
					<input type="hidden" name="module_id" id="module_id" value="DS">

					<input type="hidden" name="p_report_id" id="p_report_id" value="DSDTMOVE">
					<input type="hidden" name="report_id" id="report_id" value="DSDTMOVE"/>
			
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


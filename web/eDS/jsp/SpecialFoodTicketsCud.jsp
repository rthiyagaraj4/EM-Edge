<!DOCTYPE html>
<%@page import="eDS.Common.DlQuery"%>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
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

<script>
async function callPatientSearch(){

	var pat_id = await  PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}
</script>

</head>

<body onload="" OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
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
			String patient_id_length="";

			try{

				conn = ConnectionManager.getConnection(request);


				pstmt = conn.prepareStatement("SELECT to_char(SYSDATE,'dd/mm/yyyy') CURRENT_DATE FROM DUAL");

				rst = pstmt.executeQuery();
				while(rst.next()){
					servingDate = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
				}
				if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();

		%>
<form name="MealStatisticsReport" id="MealStatisticsReport" method="post"  target="messageFrame">
	<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
	<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
		<tr>
			<td  class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}"/>
			</td>
			<td>
				<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td  class="label">
				<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>
				<select name="frequency" id="frequency">
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="F"><fmt:message key="eOT.FreqBased.Label" bundle="${ot_labels}"/> </option>
					<option value="N"><fmt:message key="eOT.NonFreqBased.Label" bundle="${ot_labels}"/> </option>
				</select>
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
				<select name="kitchenFrom" id="kitchenFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

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
										<%} %>
					</select>
						<img src='../../eCommon/images/mandatory.gif' />
			</td>
			<td  class='label'>
				<select name="kitchenTo" id="kitchenTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
				</select>
					<img src='../../eCommon/images/mandatory.gif' />
			</td>
							<%

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



		</tr>
		<tr>
			<td  class='label'>
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td  class='label'>
					<select name="mealTypeFrom" id="mealTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
									try
									{
									sql ="select MEAL_TYPE,SHORT_DESC From  DS_MEAL_TYPE_LANG_VW where language_id ='"+locale+"' order by meal_order";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
					</select>
			</td>
			<td  class='label'>
				<select name="mealTypeTo" id="mealTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
				</select>
			</td>
							<%

									}
									  catch(Exception DCat)	  {}
									   finally
									   {
										   if(rst !=null) rst.close();
										    if(pstmt !=null) pstmt.close();
									   }

								%>

		</tr>
		<tr>
			<td  class="label">
				<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
			</td>
			<td  class='label'>
					<select name="nursingUnitFrom" id="nursingUnitFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					<%
									try
									{
										sql ="SELECT NURSING_UNIT_CODE ,SHORT_DESC  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";

											pstmt=conn.prepareStatement(sql);
											rst = pstmt.executeQuery();
											while(rst.next()){
											strCode = rst.getString(1);
											strDesc =  rst.getString(2);
								%>

							<option value="<%=strCode%>"><%=strDesc%></option>
					<%} %>
					</select>
			</td>
							<%

									}
									  catch(Exception DCat)	  {}
									   finally
									   {
										   if(rst !=null) rst.close();
										    if(pstmt !=null) pstmt.close();
									   }

								%>

			<td  class='label'>
				<select name="nursingUnitTo" id="nursingUnitTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
				</select>
			</td>
							<%

									}
									  catch(Exception DCat)	  {}
									   finally
									   {
											try{
												if(pstmt!=null) pstmt.close();
												if(rst!=null) rst.close();
												//ConnectionManager.returnConnection(conn);
											}
											catch(Exception e){
												System.err.println("Exception in SpecialFoodTicketsCUD.jsp"+e);
											}
									   }

								%>
		</tr>
			<tr>
				<td  class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
			<%	try
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
			  ConnectionManager.returnConnection(conn);
		   }
		%>
				<td>
					<input type="text" name="patientIdFrom" id="patientIdFrom" value="" maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">
					<!-- <input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="callPatientSearch()"> -->
				</td>
				</td>
				<td>
					<input type="text" name="patientIdTo" id="patientIdTo" value=""  maxlength="<%=patient_id_length%>"  onkeypress="return CheckForSpecChars(event)">
					<!-- <input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="callPatientSearch()"> -->
				</td>
				</td>
			</tr>
					<tr><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;</td></tr>
				</table>
				<input type="hidden" name="method" id="method"/>


				<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
				<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>"/>

				<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= session.getValue( "login_user" ) %>"/>

				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">

				<input type="hidden" name="p_report_id" id="p_report_id" value="DSRSTDST">
				<input type="hidden" name="report_id" id="report_id" value="DSRSTDST"/>

				<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
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
				<input type='hidden' name='nd_fr_pat_id' id='nd_fr_pat_id' >
				<input type='hidden' name='nd_to_pat_id' id='nd_to_pat_id' >
				<input type='hidden' name='p_user' id='p_user' >
				<input type='hidden' name='P_TYPE' id='P_TYPE' >
				<input type='hidden' name='chkPatientId1' id='chkPatientId1' >
				<input type='hidden' name='chkPatientId2' id='chkPatientId2' >

			</form>

		</body>
</html>


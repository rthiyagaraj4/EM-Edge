<!DOCTYPE html>
<!-- New file created against MMS-DM-CRF-0044 -->
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
function callPatientSearch(obj){

	var pat_id =  PatientSearch();
	if(pat_id != null){
		if(obj == 'from'){
			document.getElementById("patientIdFrom").value = pat_id;
		}
		else if(obj == 'to'){
			document.getElementById("patientIdTo").value = pat_id;
		}
	}

}

function loadBedNumber() {
	
	var wardFrom=document.getElementById("nursingUnitFrom").value;
	var wardTo=document.getElementById("nursingUnitTo").value;
	var facility=document.getElementById("facility_id").value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	var params = "func_mode=getBedNumbers&facility="+facility+"&wardCodeFrom="+wardFrom+"&wardCodeTo="+wardTo;
	xmlHttp.open("GET","../../eDS/jsp/DLCommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var bedNumberFrom = document.getElementById("bedNumberFrom");
	var bedNumberTo = document.getElementById("bedNumberTo");
	
	if(wardFrom	!='' || wardTo !='') {
		document.getElementById("bedNumberFrom").disabled=false;
		document.getElementById("bedNumberTo").disabled=false;
	}
	else{//56658	
		document.getElementById("bedNumberFrom").disabled=true;
		document.getElementById("bedNumberTo").disabled=true;
	}
		
	while(bedNumberFrom.length > 0){
		bedNumberFrom.remove(0);
	}
	
	while(bedNumberTo.length > 0){
		bedNumberTo.remove(0);
	}	
	var listOption1	= document.createElement('option');
	var listOption2	= document.createElement('option');
	
	listOption1.text ="-----select-----";
	listOption1.value ="";
	bedNumberFrom.add(listOption1);
	
	listOption2.text ="-----select-----";
	listOption2.value ="";
	bedNumberTo.add(listOption2);	
	
	if(retVal != null && retVal != ""){
		var retValArr = retVal.split("???");
		if(retValArr!=''){
			for(var i=0; i<retValArr.length; i++){
				var bedNumber = retValArr[i];
				var listOption1	= document.createElement('option');
				var listOption2	= document.createElement('option');
				
					listOption1.value = bedNumber;
					listOption1.text = bedNumber;
					
					listOption2.value = bedNumber;
					listOption2.text = bedNumber;					
					
					bedNumberFrom.add(listOption1);
					bedNumberTo.add(listOption2);
			}
		}
	}	
	
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
			<td align="right" class="label">
				<fmt:message key="Common.date.label" bundle="${common_labels}"/>
			</td>
			<td>
				<input type="text" name="servingDate" id="servingDate" maxlength="10" size="10" value="<%=servingDate%>" onkeypress="return checkForSpecCharsforID(event);" onblur='isValidDate(this);'>
				<img src="../../eCommon/images/CommonCalendar.gif"  name='imagemonth' onClick="return showCalendar('servingDate');">
				<img src='../../eCommon/images/mandatory.gif' />
			</td>
		</tr>
		<tr>
   			<td>
			</td>
			<td align="left" class="label">
				<fmt:message key="Common.from.label" bundle="${common_labels}"/>
			</td>
			<td align="left" class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>
		</tr>
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.Kitchen.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
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
			<td align="right" class='label'>
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
			<td align="left" class='label'>
				<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
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
			<td align="right" class='label'>
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
			<td align="right" class="label">
				<fmt:message key="eOT.WardCode.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
					<select name="nursingUnitFrom" id="nursingUnitFrom" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
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

			<td align="right" class='label'>
				<select name="nursingUnitTo" id="nursingUnitTo" onchange="loadBedNumber()"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
							<%pstmt=conn.prepareStatement(sql);
							rst = pstmt.executeQuery();
							while(rst.next()){
								strCode = rst.getString(1);
								strDesc =  rst.getString(2); %>
						<option value="<%=strCode%>"><%=strDesc%></option>
							<%} %>
				</select>
			</td>
		</tr>
		
		<tr>
			<td align="right" class="label">Bed Number</td>
<%-- 				<fmt:message key="eDS.BedNumber.Label" bundle="${ds_labels}"/> --%>
<!-- 			</td> -->
			<td align="right" class='label'>
					<select name="bedNumberFrom" id="bedNumberFrom" disabled><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
					</select>
			</td>

			<td align="right" class='label'>
				<select name="bedNumberTo" id="bedNumberTo" disabled><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
				</select>
			</td>
		</tr>
				
		<tr>
			<td align="right" class="label">
				<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
					<select name="dietTypeFrom" id="dietTypeFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
									try
									{
									sql ="SELECT DIET_TYPE,SHORT_DESC from  DS_DIET_TYPE_LANG_VW  WHERE  LANGUAGE_ID ='"+locale+"' AND EFF_STATUS='E'" ;

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
			<td align="right" class='label'>
				<select name="dietTypeTo" id="dietTypeTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
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
			<td align="right" class="label">
				<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/>
			</td>
			<td align="right" class='label'>
				<select name="mealClassFrom" id="mealClassFrom"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>

					<%
									try
									{

										sql = "SELECT MEAL_CLASS, SHORT_DESC  FROM DS_MEAL_CLASS_LANG_VW where  language_id ='"+locale+"' and EFF_STATUS='E'" ;

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
			<td align="right" class='label'>
				<select name="mealClassTo" id="mealClassTo"><option value=""><fmt:message key="eOT.select.Label" bundle="${ot_labels}"/></option>
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
					
					

										}
										catch(Exception DCat)	  {}
										   finally
										   {
												try{
													if(rst!=null) rst.close();
													if(pstmt!=null) pstmt.close();
													//ConnectionManager.returnConnection(conn);
												}
												catch(Exception e){
													System.err.println("Exception in Meal Tickets CUD:"+e);
												}
										   }
								%>
			</tr>
			<tr>
				<td align="right" class="label">
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
				</td>
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
			  ConnectionManager.returnConnection(conn);
		   }
		%>
		
				<td>
					<input type="text" name="patientIdFrom" id="patientIdFrom" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">
					<!-- <input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="callPatientSearch('from')">  -->
				</td>
				</td>
				<td>
					<input type="text" name="patientIdTo" id="patientIdTo" value=""  maxlength="<%=patient_id_length%>" onkeypress="return CheckForSpecChars(event)">
					<!-- <input align='right' type="button" class='BUTTON' name=search value='?'  class="button" onClick="callPatientSearch('to')">  -->
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
				<input type="hidden" name="p_user" id="p_user"	value="<%=session.getValue("login_user")%>"/><!--55878-->

				<input type="hidden" name="p_module_id" id="p_module_id" value="DS">
				<input type="hidden" name="module_id" id="module_id" value="DS">

				<input type="hidden" name="p_report_id" id="p_report_id" value="DSRSTDMT_NEW">
				<input type="hidden" name="report_id" id="report_id" value="DSRSTDMT_NEW"/>

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
				<input type='hidden' name='nd_fr_diet_type' id='nd_fr_diet_type' >
				<input type='hidden' name='nd_to_diet_type' id='nd_to_diet_type' >
				<input type='hidden' name='nd_fr_meal_class' id='nd_fr_meal_class' >
				<input type='hidden' name='nd_to_meal_class' id='nd_to_meal_class' >
				<input type='hidden' name='nd_fr_pat_id' id='nd_fr_pat_id' >
				<input type='hidden' name='nd_to_pat_id' id='nd_to_pat_id' >
				<input type='hidden' name='nd_from_bed_no' id='nd_from_bed_no' >
				<input type='hidden' name='nd_to_bed_no' id='nd_to_bed_no' >				
				<!--<input type='hidden' name='p_user' id='p_user' >-->
				<input type='hidden' name='P_MEAL_PLAN_SEQ_NO' id='P_MEAL_PLAN_SEQ_NO' >
				<input type='hidden' name='chkPatientId1' id='chkPatientId1' >
				<input type='hidden' name='chkPatientId2' id='chkPatientId2' >
			</form>
		</body>
</html>


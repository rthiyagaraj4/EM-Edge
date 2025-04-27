<!DOCTYPE html>
<!--
File Name		: DocumentMealServedOPHeader.jsp
File Description: Document Header frame: This is to document/acknowledge the placed order .
CRF#			: Bru-HIMS-CRF-230
Author			: Abirami
Date			: Aug-2013
-->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*"
%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%  
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 

	String locale = (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getAttribute("facility_id");
	String params = request.getQueryString() ;
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}

	String loginuser    = (String) session.getValue( "login_user" );
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");	
%>
<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eDS/js/DocumentOPMealServed.js"></script>
<script language="javascript" src="../../eDS/js/DSResourceLookUp.js"></script>
<script language="javascript" src="../../eDS/js/DSCommon.js"></script>
<script language="Javascript" src="../../eDS/js/json.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<fmt:setBundle basename="eDS.resources.Labels" var="ds_labels"/>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="loadSpeciality();hideEMSearchCriteria();">
<%
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
    String SystemDate_display = dateFormat.format(date);
	SystemDate_display = com.ehis.util.DateUtils.convertDate(SystemDate_display,"DMY","en",locale);
	Connection con=null;
	boolean isComplaintCnt = false;
	boolean isMealComplaints = false;
	try{	//Common-ICN-0071
	con = ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0685
	isComplaintCnt = CommonBean.isSiteSpecific(con,"DS","DS_NOTIFICATIONS");
	//ML-MMOH-CRF-0685
	//Added Against ML-MMOH-CRF-1125 Starts Here
	isMealComplaints = CommonBean.isSiteSpecific(con,"DS","DS_MEAL_COMPLAINTS");
	//Added Against ML-MMOH-CRF-1125 Ends Here
	}
		catch(Exception e){
			e.printStackTrace();
		}finally{
		if(con!=null)
			ConnectionManager.returnConnection(con, request);
		} //Common-ICN-0071
%>
<form name="DocumentMealServedOPForm" id="DocumentMealServedOPForm" method="post">
		<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
		<tr><td><br/></td></tr>

		<tr>
		<%-- 	<td  class=LABEL ><fmt:message key="Common.mealOrderFor.label" bundle="${ds_labels}"/></td> --%>
			<td  class=LABEL >Meal Order For</td>
			<td class="LABEL"> <input type="radio" name="mealOrderFor" id="mealOrderFor" value="OP" onclick="showSearchCriteria(this);">Out Patient</td>
			
			<td  class="LABEL">  <input type="radio" name="mealOrderFor" id="mealOrderFor" value="EM" onclick="showSearchCriteria(this);">Emergency Patient</td>
		</tr>
		
		<tr><td><br/></td></tr>
			<tr class="Row_OutPatient">
				<td colspan="1" class="LABEL">
					<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}" /></td>
				<td>
				<input type="text" name="servingdate" id="servingdate" size="10" maxlength="10" value="<%=SystemDate_display%>"	onblur='isValidDate(this);' >
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('servingdate');" >
                    <img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
				<td colspan="1" class="LABEL">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" /></td>
				<td><select name="mealType" id="mealType">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
				<td colspan="1" class="LABEL">
					<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td><select name="speciality" id="speciality">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
			</tr>
			<tr><td></td></tr>
			<tr  class="Row_OutPatient">
				<td  class=LABEL ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

				<td><select name="loctype" id="loctype" tabindex=1 onChange="enableCtrl('location', 'clinic1', location, this);"> 
					<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					</select>
				</td>
				<td  class="LABEL"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<!-- ML-MMOH-CRF-0752.7-US001 -->
				<td><input type="text" name="location" id="location" onblur="getLocn('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype.value,document.forms[0].location)"  value="" size='36' maxlength='30' disabled=true>
					<input type="hidden" name="hdnlocation" id="hdnlocation" value="">
					<input type=button class=button value='?' name='clinic1' id='clinic1' onClick="getLocn('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype.value,document.forms[0].location)" disabled=true>
				</td>
				<td></td>
			</tr>
			<tr><td></td></tr>
			<tr  class="Row_OutPatient">
				<td  class=LABEL ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				<td><SELECT name='resourceType_1' id='resourceType_1' onChange="enableCtrl('practitioner_name', 'search_pract', practitioner_name, this);">
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>
				</td>
				<td  class="LABEL"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td>
					<input type=text name='practitioner_name' id='practitioner_name'  value=''  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" size='25' maxlength='30' disabled=true>
					<input type=hidden name='practitioner' id='practitioner'  value='' size='30' maxlength='30' ></input>
					<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" disabled=true>
					<input type=hidden name='resourceType_2' id='resourceType_2'  value='' size='30' maxlength='30' >
				</TD>
				
				<td></td>
			</tr>	
			
			
			<tr class="Row_EMPatient">
				<td colspan="1" class="LABEL">
					<fmt:message key="eOT.ServingDate.Label" bundle="${ot_labels}" /></td>
				<td><input type="text" name="servingdate_EM" id="servingdate_EM" size="10" maxlength="10" value="<%=SystemDate_display%>"  
					onblur="isValidDate(this);" >
					<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('servingdate_EM');" >
                    <img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
				<td colspan="1" class="LABEL">
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}" /></td>
				<td><select name="mealType_EM" id="mealType_EM">
						<option value=''>
							<fmt:message key="Common.Select.label" bundle="${common_labels}" />
						</option>
					</select>
					<img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
				<td></td>
			</tr>
			<tr><td></td></tr>
			<tr  class="Row_EMPatient">
				<td  class=LABEL ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

				<td><select name="loctype_EM" id="loctype_EM" tabindex=1 onChange="enableCtrl('location', 'clinic1', location, this);"> 
					<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					</select>
				</td>
				<td  class="LABEL"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<!-- ML-MMOH-CRF-0752.7-US001 -->
				<td><input type="text" name="location_EM" id="location_EM" onchange="getTreatmentArea()" onblur="getLocn_EM('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype_EM.value,document.forms[0].location_EM)"  value="" size='36' maxlength='36'>
					<input type="hidden" name="hdnlocation_EM" id="hdnlocation_EM" value="">
					<input type=button class=button value='?' name='clinic1' id='clinic1' onClick="getLocn_EM('<%=loginuser%>','<%=oper_id%>','<%=facility_id%>',document.forms[0].loctype_EM.value,document.forms[0].location_EM)">
					<img src='../../eCommon/images/mandatory.gif' align='center'>
				</td>
<!-- 				<td></td> -->
			</tr>
			<tr><td></td></tr>
			<tr  class="Row_EMPatient">
				<td  class="LABEL"><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
				<td>
					<select name="priorityZone" id="priorityZone" tabindex=1 onchange="getTreatmentArea()"> 
						<%-- <option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
									<option value='ALL'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
									<option value='G'><fmt:message key="Common.Green.label" bundle="${common_labels}"/>
									<option value='R'><fmt:message key="Common.Red.label" bundle="${common_labels}"/>
									<option value='Y'><fmt:message key="Common.Yellow.label" bundle="${common_labels}"/>
									<option value='U'><fmt:message key="Common.Unassigned.label" bundle="${common_labels}"/> --%>
						
					</select>
				</td>
		 		<td  class=LABEL ><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
				<td id="td_treatmentArea">
					<select name="treatmentArea" id="treatmentArea" tabindex=1> 
						<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					</select>
				</td>
 				
<!-- 				<td></td> -->
			</tr>
									<tr><td></td></tr>
						
			<tr  class="Row_EMPatient">
				<td  class=LABEL ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				<td><SELECT name='resourceType_EM' id='resourceType_EM' onChange="enableCtrl('practitioner_name', 'search_pract', practitioner_name, this);" disabled>
					<option value=''>------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
					<option value='P'  selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
					</SELECT>
				</td>
				<td  class="LABEL"><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td>
					<input type=text name='practitioner_name_EM' id='practitioner_name_EM'  value=''  onblur="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');" size='25' maxlength='30'>
					<input type=hidden name='practitioner_EM' id='practitioner_EM'  value='' size='30' maxlength='30' ></input>
					<input type='button' class='button' value='?'  name='search_pract' id='search_pract'  onClick="callPractSearch1(this,practitioner_name,'en','<%=facility_id%>');">
<!-- 					<input type=hidden name='resourceType_2' id='resourceType_2'  value='' size='30' maxlength='30' > -->
				</TD>
				
				<td></td>
			</tr>		
			
			<tr >
			
				<td  colspan="6" align='right' style="padding: 10px;">
				<input type="button" value="<fmt:message key='Common.search.label' bundle='${common_labels}'/>" property="Select" onclick="getMealPlanDetails()" class="BUTTON" />
				</td>
			</tr>			
	</table>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='isComplaintCnt' id='isComplaintCnt' value='<%=isComplaintCnt%>' >
	<input type='hidden' name='isMealComplaints' id='isMealComplaints' id='isMealComplaints' value='<%=isMealComplaints%>' ><!-- Added Against ML-MMOH-CRF-1125 -->
</form>
</html>
			
			


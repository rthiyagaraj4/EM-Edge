<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

Connection con=null;
con=ConnectionManager.getConnection(request);
String specialityListsJsonArr			= "";
String locale							= (String)session.getAttribute("LOCALE");
String facilityID						= (String)session.getValue("facility_id");
try{
	request.setCharacterEncoding("UTF-8");
	specialityListsJsonArr				= eOA.PatientPortalBean.getSpecialityLists(con,locale,facilityID);
	JSONObject specialityListsObj		= new JSONObject(specialityListsJsonArr);
	JSONArray specialityListsArray 		= specialityListsObj.getJSONArray("results");
%>
	<head>	
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>
	<script language='javascript' src='../../eOA/patientportal/jquery.timepicker.js'></script>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eOA/patientportal/Style.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eOA/patientportal/jquery.timepicker.css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eOA/js/patientPortalConfig.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
	<form name="config_form"  id="config_form"  method="post" >
	<table cellpadding='5' cellspacing='0' width='100%' border='0'>
		<tr>
		<td class = 'label'  width = '15%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td width='85%' class='fields'>
					<select id="specialityList" name="specialityList" onchange="fnGetPractitionerList(this)">
						<option value=''>------------ Select ------------</option>
					   <%
						for(int i = 0 ; i < specialityListsArray.length() ; i++){
							String speciality_code		= specialityListsArray.getJSONObject(i).getString("speciality_code");
							String short_desc			= specialityListsArray.getJSONObject(i).getString("short_desc");%>
							<option value="<%=speciality_code%>"><%=short_desc%></option>
						<%}%>
					</select>
					<img align='center' src='../../eCommon/images/mandatory.gif'></img>
				</td>
		</tr>
		<tr>
			<td class = 'label'  width = '15%' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td width='85%' class='fields'>
				<input type="checkbox" name="isEnabled"  id="isEnabled" value='Y' checked />
			</td>
		</tr>
	
	</table>
	 <div id='divPractitionerList'  name='divPractitionerList'></div>
</form> 
 
	
<%}catch(Exception e){
	e.printStackTrace();
}finally{ 
	if(con != null) {
		ConnectionManager.returnConnection(con,request);
	}
}%>

</body>
</html>


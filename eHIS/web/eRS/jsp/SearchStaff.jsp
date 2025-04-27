<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	04 Oct 2004
-->
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.StaffDetails.label" bundle="${rs_labels}"/></title>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script language="javascript" src="../../eCommon/js/messages.js"> </script> -->
<script language="javascript" src="../js/SearchStaff.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<% 
request.setCharacterEncoding("UTF-8");
String p_mode=request.getParameter("mode")==null ? "":request.getParameter("mode");
String source ="";
    if(!p_mode.equals(""))
	 source = "../../eRS/html/SearchStaff.html" ;
	else
	{
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
 	String params = request.getQueryString();
	 source = url + params ;
	}
	String p_role_type=request.getParameter("p_role_type")==null ? "":request.getParameter("p_role_type");
	String p_staff_id=request.getParameter("p_staff_id")==null ? "":request.getParameter("p_staff_id");
	
 	String p_primary_speciality_code=request.getParameter("p_primary_speciality_code")==null ? "":request.getParameter("p_primary_speciality_code");

	String p_staff_name=request.getParameter("p_staff_name")==null ? "":request.getParameter("p_staff_name");
	String p_staff_type=request.getParameter("p_staff_type")==null ? "":request.getParameter("p_staff_type");
	String p_gender=request.getParameter("p_gender")==null ? "":request.getParameter("p_gender");
	String p_age=request.getParameter("p_age")==null ? "":request.getParameter("p_age");
	String p_empl_status=request.getParameter("p_empl_status")==null ? "":request.getParameter("p_empl_status");
	String p_facility_id=request.getParameter("p_facility_id")==null ? "":request.getParameter("p_facility_id");
	String p_position_code=request.getParameter("p_position_code")==null ? "":request.getParameter("p_position_code");
	String p_position_desc=request.getParameter("p_position_desc")==null ? "":request.getParameter("p_position_desc");
	String p_skill_code=request.getParameter("p_skill_code")==null ? "":request.getParameter("p_skill_code");
	String p_license_code=request.getParameter("p_license_code")==null ? "":request.getParameter("p_license_code");
	String p_training_code=request.getParameter("p_training_code")==null ? "":request.getParameter("p_training_code");
	String height1, height2, height3, height4;
	if(!p_mode.equals("")) {
	    height1 = "40vh";  
	    height2 = "5vh";   
	    height3 = "44vh"; 
	    height4 = "8vh";   
	} else {
	    height1 = "16vh";  
	    height2 = "76vh";  
	    height3 = "8vh";   
	    height4 = "0vh";   
	}
	%>

	<% if(!p_mode.equals("")) { %> 
	    <iframe name="commontoolbarFrame" src="<%= source %>" frameborder="0" scrolling="no" noresize style="height:<%= height1 %>;width:98vw"></iframe>
	<% } else { %> 
	    <iframe name="commontoolbarFrame" src="<%= source %>" frameborder="0" scrolling="no" noresize style="height:<%= height2 %>;width:98vw"></iframe>
	<% } %>

	<iframe name="f_query_select" src='../../eRS/jsp/SearchStaffCriteria.jsp?p_role_type=<%= p_role_type %>&p_staff_type=<%= p_staff_type %>&p_mode=<%= p_mode %>&p_primary_speciality_code=<%= p_primary_speciality_code %>&p_staff_id=<%= p_staff_id %>&p_staff_name=<%= p_staff_name %>&p_gender=<%= p_gender %>&p_age=<%= p_age %>&p_empl_status=<%= p_empl_status %>&p_facility_id=<%= p_facility_id %>&p_position_code=<%= p_position_code %>&p_position_desc=<%= p_position_desc %>&p_skill_code=<%= p_skill_code %>&p_license_code<%= p_license_code %>&p_training_code<%= p_training_code %>'  frameborder="0" scrolling="no" noresize style="height:<%= height3 %>;width:98vw"></iframe>
	<iframe name="f_query_details" src='../../eCommon/html/blank.html?p_role_type=<%= p_role_type %>&p_staff_type=<%= p_staff_type %>&p_mode=<%= p_mode %>' frameborder="0" scrolling="auto" noresize style="height:<%= height4 %>;width:98vw"></iframe>
	<iframe name="messageFrame" src='../../eCommon/jsp/error.jsp' frameborder="0" noresize scrolling="auto" style="height:<%= height4 %>;width:98vw"></iframe>

</html>


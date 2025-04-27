<!DOCTYPE html>
<html>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<% 
  String  strApplicationId = "";
  String  strFacilityId = "";
  String  strMessageType="";
  String filter_type="";
  String filter_sub_type="";
  String filter_sub1_type="";
  String filter_sub2_type="";
  String message="";
  String jspmode="";
  message =request.getParameter("message");
  strApplicationId = request.getParameter("applicationid");
  strFacilityId = request.getParameter("facilityid");
  strMessageType = request.getParameter("message_type");
  filter_type = request.getParameter("filter_type");
  filter_sub_type = request.getParameter("filter_sub_type");
  filter_sub1_type = request.getParameter("filter_sub1_type");
  filter_sub2_type = request.getParameter("filter_sub2_type");
  jspmode = request.getParameter("jspmode");
	 
%>
<script Language="JavaScript"  src="../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
function callFirst()
{
	filter_result_refresh_form.action ='../eXH/jsp/FilteringRuleQueryResult.jsp';
	filter_result_refresh_form.target="recordframe";
	filter_result_refresh_form.jspmode.value='F';
	filter_result_refresh_form.submit();

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY CLASS="MESSAGE" onLoad="callFirst();" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="filter_result_refresh_form" id="filter_result_refresh_form">
<input type='hidden' name='applicationid' id='applicationid' value='<%=strApplicationId%>'>
<input type='hidden' name='message_type' id='message_type' value='<%=strMessageType%>'>
<input type='hidden' name='facilityid' id='facilityid' value='<%=strFacilityId%>'>

<input type='hidden' name='filter_type' id='filter_type' value='<%=filter_type%>'>
<input type='hidden' name='filter_sub_type' id='filter_sub_type' value='<%=filter_sub_type%>'>
<input type='hidden' name='filter_sub1_type' id='filter_sub1_type' value='<%=filter_sub1_type%>'>
<input type='hidden' name='filter_sub2_type' id='filter_sub2_type' value='<%=filter_sub2_type%>'>
<input type='hidden' name='jspmode' id='jspmode' value='<%=jspmode%>'>
<p align="left">
<%=message%>
</p>
</form>
</BODY>
</html>


<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eSM/js/FacilitiesForUser.js' language='javascript'></SCRIPT>
	<script language="JavaScript">
	function getUsers(){
		parent.query_criteria.location.href='../../eSM/jsp/FacilityforUser_Form.jsp?label='+getLabel("Common.user.label","Common")
		parent.result.location.href='../../eCommon/html/blank.html'
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp'
	}
function getFacilities(){
		parent.query_criteria.location.href='../../eSM/jsp/FacilityforUser_Form.jsp?label='+getLabel("Common.facility.label","Common")
		parent.result.location.href='../../eCommon/html/blank.html'
    	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp'

}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<body   onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
	<form name='facilityForUserTopForm' id='facilityForUserTopForm'>
				&nbsp;<INPUT TYPE="button" class='BUTTON' name="buttonUser" id="buttonUser" value='<fmt:message key="Common.ByUser.label" bundle="${common_labels}"/>' OnCLick='getUsers()'>
			<INPUT TYPE="button" class='BUTTON' name="buttonFacility" id="buttonFacility" value='<fmt:message key="Common.ByFacility.label" bundle="${common_labels}"/>' OnCLick='getFacilities()'>
</form>
	</body>
</html>


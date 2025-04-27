<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
</head>
<script>
function showFacilities()
{  
	
	parent.frames[1].location.href = "../../eSM/jsp/FacilityforResponsibility_Form.jsp?faci=fac";
	
	parent.frames[2].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='


}



function showEntities()
{
	parent.frames[1].location.href = "../../eSM/jsp/FacilityforResponsibility_Form.jsp";
	parent.frames[2].location.href='../../eCommon/html/blank.html'
	parent.parent.frames[2].location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='
}
</script>

<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
<form name="facility_oper_module_main" id="facility_oper_module_main">
	<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'> 
		<tr>
			<td class="white"><input type="button" class="button" name="byfacility" id="byfacility" value='<fmt:message key="Common.ByFacility.label" bundle="${common_labels}"/>' onClick="showFacilities();">&nbsp;<input type="button" class="button" name="byacentity" id="byacentity" value='<fmt:message key="eSM.ByResponsibility.label" bundle="${sm_labels}"/>' onClick="showEntities();"></td>
		</tr>
	</table>
</form>
</body>
</html>


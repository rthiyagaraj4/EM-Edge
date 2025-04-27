<!DOCTYPE html>
<html>
 <head>

<%@ page import="java.util.*,java.sql.*" contentType="text/html; charset=UTF-8"%>
	  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%request.setCharacterEncoding("UTF-8");%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eBT/js/BTTransaction.js' language='javascript'></SCRIPT>

<script language='javascript'>
function closeWindow()
{
	parent.window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </head>
 

  <body onMouseDown="" onKeyDown="">
  <%
  		HttpSession httpSession = request.getSession(false);
		String strFacilityId=""+httpSession.getValue("facility_id");
		%>
 <form name="BTRRSelectionForm" id="BTRRSelectionForm"  DETAIL_BLOCK_NAME='BTRRSelectionForm' method='post' action=""> 
<table cellpadding=0 cellspacing=0 width="100%" align="center">
<tr>
<td class='label' align='left' ><b>&nbsp;&nbsp;
<select name='RRSelection' id='RRSelection' class='label' value=''>

<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />-----</option>
<option value='RN'><fmt:message key="eBT.ReservednotRequested.label" bundle="${bt_labels}" /></option>
<option value='RA'><fmt:message key="eBT.ReservedRequested.label" bundle="${bt_labels}" /></option>
<option value='RR'><fmt:message key="eBT.ReservedandorRequested.label" bundle="${bt_labels}" /></option>
</select>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name="Search" id="Search" class="BUTTON" value ='<fmt:message key="Common.search.label" bundle="${common_labels}" />'  size='21'	onClick="funBTTransactionSearch(document.forms[0])">&nbsp;&nbsp;&nbsp;


<!--<input type="button" name="Close" id="Close" class="BUTTON" value ="Close"  size='21' onClick="closeWindow()">-->
</select>
</b></td>
</tr>
	</table>
	<input type='hidden' name='PATIENT_ID' id='PATIENT_ID' value='<%=request.getParameter("patient_id")%>' RECORD_TYPE='S'>

	<input type='hidden' name='FACILITY_ID' id='FACILITY_ID' value='<%=strFacilityId%>' RECORD_TYPE='S'>

	<input type='hidden' name='CHECKBOX_SEL' id='CHECKBOX_SEL' value='' RECORD_TYPE='S'>	

	<input type='hidden' name='CHECKBOX_PRINT' id='CHECKBOX_PRINT' value='' RECORD_TYPE='S'>	

	<input type='hidden' name='PRINT_MODE' id='PRINT_MODE' value='' RECORD_TYPE='S'>

	<input type='hidden' name='FID' id='FID' value='' RECORD_TYPE='S'>
	</form>
  </body>
 </html>


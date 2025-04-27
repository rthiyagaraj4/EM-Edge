<!DOCTYPE html>
<!--
		Author	: Arvind Singh Pal
		Purpose : Created For GHL-CRF-0043 
		Date		: 16 November 2009

		-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/ViewClinicalDocument.js" language="javascript"></script>
 <%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

</head>

<script>
function closew()
  {
	  window.parent.close();
  }
</script>
<% 

	//String disabled ="";
	String disablePrev = " disabled ";
	String disableNext = "disabled";



%>

<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="frmPagination" id="frmPagination">
	<div align='right'>
		<table  cellpadding='0' cellspacing='0' >
			<tr>
			    <td align='right'>
				<table border=1 cellpadding=0 cellspacing=0 width="80%" id='tablePrevNext' style='display'>
					<tr >
					<td nowrap><img src='../../eCommon/images/iGridSPreviousNOR16.gif' id='firstPage' onclick='ViewDocPrevNext(this)' <%=disablePrev%>   /><img src='../../eCommon/images/iGridPreviousNOR16.gif' id='prevPage' onclick='ViewDocPrevNext(this)' <%=disablePrev%> /></td>
					<td id='label_cap' class='Pagination'>&nbsp;</td>
					<td nowrap><img src='../../eCommon/images/iGridNextNOR16.gif' id='nextPage' onclick='ViewDocPrevNext(this)' <%=disableNext%> /><img src='../../eCommon/images/iGridSNextNOR16.gif' id='lastPage' onclick='ViewDocPrevNext(this)' <%=disableNext%> /></td>					
				</tr>
				</table>
			</tr>
		</table>
	</div>	
	<input type="hidden" name="start" id="start" value="">
	<input type="hidden" name="end" id="end" value="">
	<input type="hidden" name="patientid" id="patientid" value="">
	<input type="hidden" name="fromdate" id="fromdate" value="">
	<input type="hidden" name="todate" id="todate" value="">
	<input type="hidden" name="indno" id="indno" value="">
	<input type="hidden" name="performed_by_id" id="performed_by_id" value="">
	<input type="hidden" name="pract_type" id="pract_type" value="">
	<input type="hidden" name="encounter_id" id="encounter_id" value="">
	<input type="hidden" name="appl_task" id="appl_task" value="">
	<input type="hidden" name="enc_id" id="enc_id" value="">	
	<input type="hidden" name="displstart" id="displstart" value="">	
</form>
</body>
</html>


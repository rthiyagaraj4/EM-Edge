<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- ****  Modified by kishor kumar n on 04/12/2008 for crf0387 applied new css grid. **** -->
		
		
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String patient_id = request.getParameter("patient_id");
	String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
%>

<script>
	var prev=0;
		function refer(ro)
		{
			prev=ro.rowIndex;
				//alert("retete "+prev);
		}
		function CallDescFrame(Obj)
		{
			var selected_val =Obj.value;

			//alert(selected_val)
			/*if(selected_val=="O")
			{
				document.getElementById("tab").width='100%'
				document.getElementById("h").style.visibility='visible'
				
				document.getElementById("cw").width='49%'
				document.getElementById("h").width='30%'
			}
			else
			{
				document.getElementById("tab").width='125%'
				document.getElementById("cw").width='40%'
				document.getElementById("h").width=''
				document.getElementById("h").style.visibility='hidden'
			}*/

			if("<%=called_from_ip%>" == "Y")	{
parent.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id=<%=patient_id%>'
			parent.PatAlertQueryAllergyClass.location.href='PatAlertQueryAllergyClass.jsp?radio_par='+selected_val+'&patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>'
			}else{
					top.content.workAreaFrame.PatAlertQueryResult.location.href='PatAlertQueryResult.jsp?patient_id=<%=patient_id%>'
			top.content.workAreaFrame.PatAlertQueryAllergyClass.location.href='PatAlertQueryAllergyClass.jsp?radio_par='+selected_val+'&patient_id=<%=patient_id%>&called_from_ip=<%=called_from_ip%>'
			}
		}
</script>
<form name="radio" id="radio">
<table align='center' width='110%' class='grid'>
	<td class='columnHeader'  colspan=2 style="background-color:#73a5ad; color: white;"><font size=1><fmt:message key="Common.Allergies.label" bundle="${common_labels}"/></font><td>
	<tr onclick='javascript:refer(this)'>
		<td class='gridData' colspan=2 >
		<input type="radio" name="allergies_radio" id="allergies_radio" class="label" value="A" onClick="CallDescFrame(this)" checked ><font size=1><fmt:message key="eCA.ActiveOnly.label" bundle="${ca_labels}"/></font>
		&nbsp&nbsp&nbsp&nbsp<input type="radio" name="allergies_radio" id="allergies_radio" class="label" value="O" onClick="CallDescFrame(this)"><font size=1><fmt:message key="Common.all.label" bundle="${common_labels}"/></font>
		</td>
	</tr>
	<!--<tr>
		<td colspan=2 width=100% >
			<table align=center width=125% height=100% border=0 cellspacing='0' cellpadding='3' id='tab'>
			<td class='columnHeadercenter'    width='40%' id='cw'><font size=1><fmt:message key="eCA.AllergicTo.label" bundle="${ca_labels}"/></font></td>
			<td class='columnHeadercenter'  ><font size=1><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
			<td class='columnHeadercenter'  id='h'  ><font size=1><fmt:message key="Common.status.label" bundle="${common_labels}"/></font></td>
			</table>
		</td>
	</tr>-->
</table>
</form>
</body>
</html>


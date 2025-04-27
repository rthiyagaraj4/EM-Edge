<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<html>
    <head>

 <%
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<title></title>

		 <script language='javascript' src='../../eCommon/js/common.js'></script>
		 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   
	<SCRIPT>
	function Next(inputString)
	{   
		var temp1=''; var increment=5;var tempRowIds = "";	
		var k = parent.frames[0].rowIDArrayProcList.length;
		
		var patient_id    =	parent.procedurelistresult.result_form.patientid.value;
		var proc_code     = parent.procedurelistresult.result_form.proccode.value;
		var service_code  = parent.procedurelistresult.result_form.servicecode.value;
		var code_set      = parent.procedurelistresult.result_form.codeset.value;
		var from_date     = parent.procedurelistresult.result_form.fromdate.value;
		var end_date      = parent.procedurelistresult.result_form.enddate.value;
		var start         = parent.procedurelistresult.result_form.startno.value;
		var end           = parent.procedurelistresult.result_form.endno.value;
		var totcount	  =	parent.procedurelistresult.result_form.count.value;
		var mode1         = parent.procedurelistresult.result_form.mode.value;
		
		if( (parseInt(k,10) - parseInt(end,10)) < 6){
			if(mode1=="first")
				increment = (parseInt(k,10) - (parseInt(end,10)-1))-2;
			else
				increment = (parseInt(k,10) - parseInt(end,10))-2;
			}
		else
			increment = 4;
				
		if(inputString=='next')
		{   
			if(mode1=="first")
				var from1=(parseInt(end,10));
			else
				var from1=(parseInt(end,10)+1);
				var to1=(parseInt(from1,10)+parseInt(increment,10));
		}
		if(inputString=='prev')
		{   
			var to1=(parseInt(start,10)-1);
			var from1=(parseInt(to1,10)-4);
		}
		
		for(var j=parseInt(from1,10);j<=parseInt(to1,10);j++)
			temp1+="'"+parent.frames[0].rowIDArrayProcList[j]+"',";
			
			
		parent.procedurelistresult.location.href="../../eCA/jsp/ProcedurelistResult.jsp?from="+from1+"&to="+to1+"&patient_id="+patient_id+"&proc_code="+proc_code+"&service_code="+service_code+"&code_set="+code_set+"&rowIDFields="+encodeURIComponent(temp1,"UTF-8")+"&from_date="+from_date+"&end_date="+end_date+"&tot="+totcount+"";
	}
	</SCRIPT>
	
	
	
	</head>
	<body class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="formProcedurelistTitle" id="formProcedurelistTitle">
			 <table width=100% align='center'>
				<tr>
					<td align='right'><a class='gridLink' style='visibility:hidden' id='prevRecs' href="javascript:Next('prev')"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>&nbsp;&nbsp;<a  class='gridLink'  style='visibility:hidden' id='nextRecs' href="javascript:Next('next')"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
				</tr>
			
			 </table>
	 
			 <table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0'>
				<tr>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.code.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.scheme.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.date.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.facility.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></font></th>
					<th class='columnHeadercenter' width='' nowrap align='left'><font size=1><fmt:message key="Common.service.label" bundle="${common_labels}"/></font></th>
				</tr>
			 </table>
		
		</form>
	</body>
</html>


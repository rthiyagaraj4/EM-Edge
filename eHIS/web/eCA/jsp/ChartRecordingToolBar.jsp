<!DOCTYPE html>
<!-- 
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
13/7/2011     101            Chowminya G      	Incident No: IN027022 - <MC module Charting - amend(replace) display issue> 
-----------------------------------------------------------------------
*/
-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String chtId= request.getParameter("chartId")==null?"":request.getParameter("chartId");
	String encounter_id= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_class= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String patient_id= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String result= request.getParameter("result")==null?"":request.getParameter("result");
	String errorAuth = request.getParameter("errorAuth")==null?"":request.getParameter("errorAuth");
	String function_from = request.getParameter("function_from")==null?"":request.getParameter("function_from");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String modifyYN = request.getParameter("modifyYN")==null?"":request.getParameter("modifyYN");
	//---[101]/start---
	String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");
	//---[101]/end---
	String disableRecBtn = "";

	if(result.equals("") && !(function_id.equals("query")))
	{
		disableRecBtn ="";
	}
	else
	{
		disableRecBtn = " disabled ";
	}
%>
<html>
	<head>

		<%

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
			<form name="F" id="F">
			    <table cellpadding=0 cellspacing=0 width="100%" height='100%' border=1><tr><td>
				<table cellpadding=0 cellspacing=0 width="100%" height='100%' border=0>
			    <tr>
				<%if(errorAuth.equals("A")){%>
					<td align='left'><input type='button' id='errorBtn' name='showErrors' id='showErrors' style='display:none' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ErrorDetails.label","ca_labels")%>' onclick='showErrosOnClick()'  class='button'></td> 
				<%}%>
				<%if(chtId.equals("GRCT")){%>
				   <td align=left>
						<input type='button' name='graph' id='graph' onclick="callNewGraph();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>'  class='button'>
				   </td>
				<%}%>
			       <td align=right>				
						<!-- <input class='button' type='button' name='print' id='print' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onclick='PrintData()' > -->
				<%
					if(!function_from.equals("SECONDARY_TRIAGE"))
					{	
				%>
						<input type='button' name='view_graph' id='view_graph' onclick="openWinForGrouping();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>'  class='button'>
				<%
					}
					if(!modifyYN.equals("N"))
					{
				%>
						<input type='button' name='record' id='record' onclick="recording();" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' <%=disableRecBtn%> class='button'>
				<%
					}
				%>
						<!-- <input type='button' name='reset' id='reset' onclick="resetForm();" value='Clear'  class='button'> -->
				        <input type='button' name='cancel' id='cancel' id='backToCon' onclick="resetForm(this,'<%=function_from%>');" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button'>
					</td>					
				</tr>
			    </table></td></tr></table>
				<input type='hidden' value='<%=encounter_id%>' name='encounter_id'>
				<input type='hidden' value='<%=patient_class%>' name='patient_class'>
				<input type='hidden' value='<%=patient_id%>' name='patient_id'>
				<input type='hidden' value='<%=chtId%>' name='chartId'>
		</form>
	</body>
</html>


<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head><title>New Procedure Tabs</title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			
	<script>
		
		
		function change_common_tab(obj)
		{  
			
			
			var qry_str= document.proceduretab_form.qry_str.value;
			
			//if(patient_id !=""){
				document.getElementById("tab").style.visibility="visible";
			if((obj=="View") )
			{	
				colorChange(obj);
				
 				/*parent.refusal_main_label.location.href = "../../eOR/jsp/RefusalOrderResultLabel.jsp?<%=request.getQueryString()%>&patient_id="+patient_id;
 				
 				*/
				parent.document.getElementById("procDetailFrame").rows="17.5%,79%,3.5%,0%,0%,0%";
				parent.document.getElementById("procTermFrame").cols="100%,0%";
				parent.document.getElementById("procPractFrame").cols="100%,0%";

				parent.proc_main_search.location.href ="../../eOR/jsp/NewProcedureSearch.jsp?"+qry_str;
				parent.proc_main_result.location.href ="../../eOR/jsp/NewProcedureQueryResult.jsp?"+qry_str; 				
				parent.proc_main_label.location.href = "../../eOR/jsp/NewProcedureLegend.jsp";
   		  		parent.proc_main_desc.location.href = "../../eCommon/html/blank.html";
   		  		parent.proc_main_butn.location.href = "../../eCommon/html/blank.html";
   		  		
			}
			else if( obj=="New" )
			{
				colorChange(obj);
				
				//parent.document.getElementById("procDetailFrame").rows="30%,15%,30%,5%,0%";
				parent.document.getElementById("procDetailFrame").rows="15%,40%,40%,5%,0%";
				parent.document.getElementById("procTermFrame").cols="50%,50%";
				parent.document.getElementById("procPractFrame").cols="50%,50%";
   		  		
				parent.proc_main_search.location.href = "../../eOR/jsp/NewProcedureAddModify.jsp?"+qry_str;
   		  		parent.proc_main_result.location.href = "../../eCommon/html/blank.html";
   		  		parent.proc_term_info.location.href = "../../eCommon/html/blank.html";
   		  		
   		  		
   		  		//parent.document.getElementById("proc_main_label").scrolling = "auto";
   		  		
   		  		parent.proc_main_label.location.href = "../../eOR/jsp/NewProcedureAddModifyPractMulti.jsp?"+qry_str;
   		  		parent.proc_main_butn.location.href = "../../eOR/jsp/NewProcedureBtn.jsp?<%=request.getQueryString()%>";
   		  		parent.proc_main_desc.location.href = "../../eOR/jsp/NewProcedureDesc.jsp?<%=request.getQueryString()%>";
   		  		parent.proc_temp_frame.location.href = "../../eCommon/html/blank.html";
		  	}
			/*}else{
				document.getElementById("tab").style.visibility="hidden";
				//alert(getOrMessage('SHD_NOT_BE_BLANK'));
				document.proceduretab_form.patientId.focus();
				parent.refusal_main_search.location.href="../../eCommon/html/blank.html";	
				parent.refusal_main_label.location.href="../../eCommon/html/blank.html";	
				parent.refusal_main_result.location.href="../../eCommon/html/blank.html";	
				
			}*/
			if(top.content)
				top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
		}

		function colorChange(obj) {
			/*if(document.proceduretab_form.all.viewRefusal){
				document.proceduretab_form.all.viewRefusal.className  = "CAFIRSTSELECTHORZ";
				alert('here');
			}if(document.proceduretab_form.all.refusalType){
				document.proceduretab_form.all.refusalType.className		= "CASECONDSELECTHORZ";
				alert('hereeeeeeeeeeeeeee');
			}*/
			if(obj=='View'){
				document.proceduretab_form.all.viewRefusal.className	= "CASECONDSELECTHORZ";
				document.proceduretab_form.all.refusalType.className	= "CAFIRSTSELECTHORZ";
				//alert('here');
			}else if(obj=='New'){
				document.proceduretab_form.all.viewRefusal.className	= "CAFIRSTSELECTHORZ";
				document.proceduretab_form.all.refusalType.className	= "CASECONDSELECTHORZ";
				//alert('hereeeeeeeeeeeeeee');
			}
		}
		function changeColor(obj,from_name)
		{
			if(from_name=="COMMON")
				cellref = document.getElementById("tab").rows(0).cells
			for(i=0; i<cellref.length; i++)
			{
				if(i!=2 && i!=3)
				 cellref[i].className = 'CAFIRSTSELECTHORZ'
			}
			obj.className = "CASECONDSELECTHORZ"
			currClass ="CASECONDSELECTHORZ";
		}
		function callOnMouseOver(obj){
		currClass = obj.className ;
		 obj.className = 'CASECONDSELECTHORZ';
		 
		}

function callOnMouseOut(obj){
	obj.className = currClass;
}
	</script>
	<STYLE TYPE="text/css"></STYLE>
 </head>
<%
	
	String encounter_id			= request.getParameter("episode_id");
	String class_name_first		= "";
	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id="+patient_id+"');</script>");
	String tab_name = (request.getParameter("tab_name")==null) ? "View":request.getParameter("tab_name");	
		
%>
<body onLoad="change_common_tab('<%=tab_name%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="proceduretab_form" id="proceduretab_form">
<table id="" cellspacing=0 cellpadding="3" border="0" width='100%'>
<tr>
	<td class="label" width='30%'>
		<table id="tab" cellspacing=0 cellpadding="1" border="0" width='100%'>
			<tr>
				<td id="viewRefusal" width='50%' class="<%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('View')">Existing Procedure</a></td>
				<td id="refusalType" width='50%' class="<%=class_name_first%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('New')">New Procedure</a></td>
			</tr>
		</table>
	</td>
	<td class="label" width='35%'></td>
	<td class="label" width='35%'></td>
</tr>
</table>
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="module_id" id="module_id" value="">
</form>
</body>
</html> 
 


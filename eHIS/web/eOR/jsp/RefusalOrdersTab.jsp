<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@page import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*" %>
 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head><title><fmt:message key="Common.OrderEntryTabs.label" bundle="${common_labels}"/></title>
 
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
	<script language="JavaScript" src="../../eOR/js/RefusalOrders.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		
		
		function change_common_tab(obj)
		{  
		 
			var patient_id = document.refusaltab_form.patientId.value;
			//alert("patient_id333="+patient_id);
			//alert("qry_str="+document.refusaltab_form.qry_str.value); 
 		
			if(patient_id !=""){
				document.getElementById("tab").style.visibility="visible";
			if((obj=="View") )
			{	//(licence_key=="ORPV") Only For Alrabha Version(Pharmacy Version) to load the Pharamacy Tab
				colorChange(obj);
				/*parent.refusal_main_label.location.href = "../../eOR/jsp/RefusalOrderResultLabel.jsp?<%=request.getQueryString()%>&patient_id="+patient_id;
 				parent.refusal_main_result.location.href = "../../eOR/jsp/RefusalOrdersViewCurrentResults.jsp?<%=request.getQueryString()%>&patient_id="+patient_id;*/
				//parent.document.getElementById("Refusal_order_main").rows="9%,15%,6%,65%";
 				parent.document.getElementById("refusal_main").style.height="11vh";
 				parent.document.getElementById("refusal_main_search").style.height="15vh";
 				parent.document.getElementById("refusal_main_label").style.height="4vh";
 				parent.document.getElementById("refusal_main_result").style.height="65vh";
 				
				//parent.refusal_main_search.location.href ="../../eOR/jsp/RefusalOrderExistingSearch.jsp?<%=request.getQueryString()%>&patient_id="+patient_id;
			
				parent.refusal_main_search.location.href ="../../eOR/jsp/RefusalOrderExistingSearch.jsp?patient_id="+patient_id;
 				
   		  		parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
   		  		parent.refusal_main_result.location.href = "../../eCommon/html/blank.html";
			}
			else if( obj=="Refusal" )
			{
				colorChange(obj);
				//parent.document.getElementById("Refusal_order_main").rows="11%,0%,0%,89%";//As this has been removed for iFrame
				parent.document.getElementById("refusal_main").style.height="11vh";
				parent.document.getElementById("refusal_main_search").style.height="0vh";
				parent.document.getElementById("refusal_main_label").style.height="0vh";
				parent.document.getElementById("refusal_main_result").style.height="62vh";

			 
				parent.refusal_main_search.location.href = "../../eCommon/html/blank.html";
   		  		parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
   		   		parent.refusal_main_result.location.href = "../../eOR/jsp/RefusalOrders.jsp?<%=request.getQueryString()%>&patient_id="+patient_id;
   		  		
			
		  	}
			}else{
				document.getElementById("tab").style.visibility="hidden";
				document.refusaltab_form.patientId.focus();
				parent.refusal_main_search.location.href="../../eCommon/html/blank.html";	
				parent.refusal_main_label.location.href="../../eCommon/html/blank.html";	
				parent.refusal_main_result.location.href="../../eCommon/html/blank.html";	
			 
				
			}
			if(top.content)
				top.content.messageFrame.location.href = "../../eCA/jsp/error1.jsp";
		}

		function colorChange(obj) {
			/*if(document.refusaltab_form.all.viewRefusal){
				document.refusaltab_form.all.viewRefusal.className  = "CAFIRSTSELECTHORZ";
				alert('here');
			}if(document.refusaltab_form.all.refusalType){
				document.refusaltab_form.all.refusalType.className		= "CASECONDSELECTHORZ";
				alert('hereeeeeeeeeeeeeee');
			}*/
			if(obj=='View'){
				//document.refusaltab_form.all.viewRefusal.className  = "CASECONDSELECTHORZ";
				document.getElementById("viewRefusal").className  = "CASECONDSELECTHORZ";
				document.getElementById("refusalType").className  = "CAFIRSTSELECTHORZ";
				//document.refusaltab_form.all.refusalType.className		= "CAFIRSTSELECTHORZ";
				//alert('here');
			}else if(obj=='Refusal'){
				//document.refusaltab_form.all.viewRefusal.className  = "CAFIRSTSELECTHORZ";
				//document.refusaltab_form.all.refusalType.className		= "CASECONDSELECTHORZ";
				document.getElementById("viewRefusal").className  = "CAFIRSTSELECTHORZ";
				document.getElementById("refusalType").className  = "CASECONDSELECTHORZ";
				//alert('hereeeeeeeeeeeeeee');
			}
		}
		function changeColor(obj,from_name)
		{
			
			if(from_name=="COMMON")
				cellref = document.getElementById("tab").rows[0].cells
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
 <% String locale = ((String)session.getAttribute("LOCALE"));	%>
<%
	
	String encounter_id			= request.getParameter("episode_id");
	String class_name_first		= "";
	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id="+patient_id+"');</script>");
	String tab_name = (request.getParameter("tab_name")==null) ? "View":request.getParameter("tab_name");	
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);
	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();
	
	

// Till here 21/05/2003
%>
<body onLoad="change_common_tab('<%=tab_name%>')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

				<!-- <body onLoad="change_common_tab('NewOrders','<%//=licence_key%>','<%//=function_from%>','ON_LOAD')"  onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->

<form name="refusaltab_form" id="refusaltab_form">
	<table id="" cellspacing=0 cellpadding="3" border="0" width='100%' align="center">
	
	<tr style="<%//=id_locn_style%>" >	
				<td  class='label' id='id_locn'   width='25%' nowrap  style=""><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' > 
					<input type='text'  name='patientId' id='patientId' value='<%= patient_id %>' nowrap onKeyPress='return CheckForSpecChars(event)' size="20" maxlength="<%= patient_id_length %>" onBlur="ChangeUpperCase(this);populatePatientDetails(this,'refusal_tab');"><input  class='button' type=button name=search value='?'   tabIndex="4" onClick="callPatientSearch1()"><img src="../../eCommon/images/mandatory.gif">
				</td>
				<td  class='label' id='short_name_id'  colspan="0" width='' nowrap align='center'><!-- Patient Name&nbsp;&nbsp; --></td>
				
				<td class="fields" width='50%'><label id="result_name" ></label></td>
							
	</tr>
</table>
	<tr>
	<td class="label">
	<table id="tab" cellspacing=0 cellpadding="3" border="0" width='30%' align="left">
	<tr>
		<td id="viewRefusal" width='50%' class="<%=class_name_first%>" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a  style='color:white;cursor:pointer' href="javascript:change_common_tab('View')"> <fmt:message key="eOR.ExistingRefusal.label" bundle="${or_labels}"/></a></td>
		<td id="refusalType" width='50%' class="<%=class_name_first%>"  onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onclick="changeColor(this,'COMMON')" nowrap><a style='color:white;cursor:pointer' href="javascript:change_common_tab('Refusal')"> <fmt:message key="eOR.NewRefusal.label" bundle="${or_labels}"/></a></td>
		</tr>
		</table>
	</td>
		<td class="label">&nbsp;</td>
		<td class="label">&nbsp;</td>
		</tr>
	
	
	</table>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	
	<input type="hidden" name="module_id" id="module_id" value="">
</form>
</body>
</html> 

 


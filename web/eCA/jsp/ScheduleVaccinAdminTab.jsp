<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String administered_date =request.getParameter("administered_date")==null?"":request.getParameter("administered_date");  //undefined
	String status =request.getParameter("status")==null?"":request.getParameter("status");  //undefined
	String loadAlrg =request.getParameter("loadAlrg")==null?"N":request.getParameter("loadAlrg");  //undefined
	String mode =request.getParameter("mode_new")==null?"":request.getParameter("mode_new");  //undefined
	String adhoc_yn =request.getParameter("adhoc_yn")==null?"N":request.getParameter("adhoc_yn");  //undefined
	String alergry_exists_yn =request.getParameter("alergry_exists_yn")==null?"N":request.getParameter("alergry_exists_yn"); 
	String hideAlrgTab =request.getParameter("hideAlrgTab")==null?"N":request.getParameter("hideAlrgTab"); 
	String order_id =request.getParameter("order_id")==null?"":request.getParameter("order_id");  //undefined
	String ord_drug_code =request.getParameter("ord_drug_code")==null?"":request.getParameter("ord_drug_code");  //undefined

	//String mode_new =request.getParameter("mode_new")==null?"N":request.getParameter("mode_new");  //undefined
	//out.println("loadAlrg ..."+loadAlrg);
	/*out.println("<br>status ..."+status);
	/*out.println("<br>alergry_exists_yn ..."+alergry_exists_yn);
	out.println("<br>adhoc_yn ..."+adhoc_yn);
	out.println("<br>ord_drug_code ..."+ord_drug_code);
	out.println("<br>order_id ..."+order_id);
	out.println("<br>mode ..."+mode);*/


	String query_string =request.getQueryString();  

	

	if(administered_date.equals("undefined"))
		{
			administered_date ="";
		}
		if(status.equals("undefined"))
		{
			status ="";
		}

 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../js/ScheduleForVacination.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<title></title>
<script>
function dfltTab()
{
	var loadAlrg =document.getElementById("loadAlrg").value;
	if(loadAlrg=='N')
	{
		document.getElementById("allergy_tab").className = "tabA";
		document.getElementById("allergy_tabspan").className = "tabAspan";
		prevTabObj="admin_tab";
	}
	else
	{
		document.getElementById("admin_tab").className = "tabA";
		document.getElementById("admin_tabspan").className = "tabAspan";	
		prevTabObj="allergy_tab";
	}
}
//parent.parent.VaccinationFrame.VaccinAdminDetailsFrame.location.href="ScheduleVaccinAdminDetails.jsp?"+query_string+"&vac_sch_ref="+vac_sch_ref+"&vaccine_id="+vaccine_id+"&dose_no="+dose_no+"&mode_new=modify&adhoc_yn="+adhoc_yn;

function tab_clickAdmin(id) 
{	
	prevTabObj="allergy_tab";
	selectTab(id);
	loadAdministerPage();
	//moveToLink(1);
}
function loadAdministerPage()
{
	var query_string =document.getElementById("query_string").value;
	var mode=document.getElementById("mode").value;
	var adhoc_yn=document.getElementById("adhoc_yn").value;
	var appl_task_id = document.vaccinAdminTabsForm.appl_task_id.value;
	if("<%=order_id%>" == "" && "<%=ord_drug_code%>" == "")
	{
		parent.VaccinAdminDetailsFrame.location.href='../../eCA/jsp/ScheduleVaccinAdminDetails.jsp?query_string='+query_string+'&mode_new='+mode+'&adhoc_yn='+adhoc_yn+'&option_id='+appl_task_id;
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	
	}else{		
		parent.VaccinAdminDetailsFrame.location.href="ScheduleVaccinMedAdminDetails.jsp?query_string="+query_string;
		parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	
	}
	
}

function tab_clickAllergy(id) 
{
	
	prevTabObj="admin_tab";
	var query_string =document.getElementById("query_string").value;
	selectTab(id);
	//moveToLink(2);
//alert('query_string...'+query_string);
	parent.VaccinAdminDetailsFrame.location.href='../../eCA/jsp/ScheduleVaccAllegyMain.jsp?query_string='+query_string;
	parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	//ScheduleVaccAllegyMain.jsp
	//callRecClinicalNotesSearch();
}
function moveToLink(LinkIndex) {
	if(LinkIndex==1)
	{
		parent.frames[1].document.getElementById("AdministerDetails").scrollIntoView();
		parent.frames[1].document.forms[0].vaccine_name.focus();
	}
	else if(LinkIndex==2)
	{
			parent.frames[1].document.getElementById("allergies").scrollIntoView();
			parent.frames[1].document.forms[0].vaccine_name1.focus();
	}
}


</script>
	
	</head>

	<form name='vaccinAdminTabsForm' id='vaccinAdminTabsForm'>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onLoad="dfltTab()" >

	<center>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr>
			<td width= "100%" class="white">
			<ul id="tablist" class="tablist" style="padding-left:0px">
				<li class="tablistitem" title='Administer Details' >
				<a onclick="tab_clickAdmin('admin_tab')" class="tabClicked" id="admin_tab" >
					<span class="tabSpanclicked" id="admin_tabspan"><fmt:message key="eCA.AdministerDetails.label" bundle="${ca_labels}"/></span>
				</a>
			</li>
			<li id='allergy' class="tablistitem" title='Allergy'>
				<a onclick="tab_clickAllergy('allergy_tab')" class="tabClicked" id="allergy_tab" readonly >
					<span class="tabSpanclicked" id="allergy_tabspan"><fmt:message key="Common.Allergy.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			</ul>
			</td>
		</tr>
	</table>
	</center>
	 <input type=hidden value='<%=query_string%>' name='query_string' id='query_string'>
	 <input type=hidden value='<%=loadAlrg%>' name='loadAlrg' id='loadAlrg'>
	 <input type=hidden value='<%=adhoc_yn%>' name='adhoc_yn' id='adhoc_yn'>
	 <input type=hidden value='<%=mode%>' name='mode' id='mode'>
	 <input type=hidden value='<%=request.getParameter("option_id")%>' name='appl_task_id' id='appl_task_id'>
	</form>
	<Script>
		<%
			if((alergry_exists_yn.equals("Y") || status.equals("C")) && hideAlrgTab.equals("N"))
			{%>
				document.getElementById("allergy").style.visibility = 'visible' ;
			<%}
			else 
			{%>
				document.getElementById("allergy").style.visibility = 'hidden' ;
			<%}
		%>	
	</script>

	</body>

	
</html>
	


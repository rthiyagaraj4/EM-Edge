<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<HTML>
<HEAD>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String  mode =  request.getParameter("mode")==null?"" :request.getParameter("mode");
String print_dept_loc1 ="";
String print_dept_loc2 = "";
String print_report_dept_loc_radio="";
String print_urg_dept_loc1 ="";
String print_urg_dept_loc2 = "";
String print_report_urg_dept_loc_radio ="";

if(mode.equals("1"))
{
		mode = "insert";
}
else
{
	mode = "update";
}


%>
<script language="JavaScript">
function setOtherLocationThis()
{
	var len = document.forms[0].print_dept_loc1;
	var len1= len.value.length;
	if(len1 != 0)
	{
		document.forms[0].print_report_dept_loc_radio[0].checked = true
		document.forms[0].print_report_dept_loc_radio[0].disabled = false
	}
	else
	{
		document.forms[0].print_report_dept_loc_radio[0].checked = false
		document.forms[0].print_report_dept_loc_radio[0].disabled = true
	}

}
function setOtherLocationThis1()
{
	var len = document.forms[0].print_dept_loc2;
	var len1= len.value.length;
	if(len1 != 0)
	{
		document.forms[0].print_report_dept_loc_radio[1].checked = true
		document.forms[0].print_report_dept_loc_radio[1].disabled = false
	}
	else
	{
		document.forms[0].print_report_dept_loc_radio[1].checked = false
		document.forms[0].print_report_dept_loc_radio[1].disabled = true
	}

}
function setOtherLocationThis3()
{
	var len = document.forms[0].print_urg_dept_loc1;
	var len1= len.value.length;
	if(len1 != 0)
	{
		document.forms[0].print_report_urg_dept_loc_radio[0].checked = true
		document.forms[0].print_report_urg_dept_loc_radio[0].disabled = false
	}
	else
	{
			document.forms[0].print_report_urg_dept_loc_radio[0].checked = false
			document.forms[0].print_report_urg_dept_loc_radio[0].disabled = true
	}

}
function setOtherLocationThis4()
{
	var len = document.forms[0].print_urg_dept_loc2;
	var len1= len.value.length;
	if(len1 != 0)
	{
		document.forms[0].print_report_urg_dept_loc_radio[1].checked = true
		document.forms[0].print_report_urg_dept_loc_radio[1].disabled = false
	}
	else
	{
			document.forms[0].print_report_urg_dept_loc_radio[1].checked = false
			document.forms[0].print_report_urg_dept_loc_radio[1].disabled = true
	}

}

function assignValue()
{



var string1 = ""
var string2 = ""
var string3 = ""
var string4 = ""
var string5 = ""
var string6 = ""


with(document.dummyform)
{
 if(print_report_dept_loc_radio[0].checked == true)
 {
		res_dept_routing_queue_dflt.value = "1"
 }
 else
 {
		res_dept_routing_queue_dflt.value = "2"
 }
 if(print_report_urg_dept_loc_radio[0].checked == true)
 {
		res_dept_stat_queue_dflt.value = "1"
 }
 else
 {
		res_dept_stat_queue_dflt.value = "2"
 }
 if(print_report_dept_loc_radio[1].checked == true)
 {
		res_dept_routing_queue_dflt.value = "2"
 }
 else
 {
		res_dept_routing_queue_dflt.value = "1"
 }
 if(print_report_urg_dept_loc_radio[1].checked == true)
 {
		res_dept_stat_queue_dflt.value = "2"
 }
 else
 {
		res_dept_stat_queue_dflt.value = "1"
 }

 string1 = print_dept_loc1.value
 string2 = print_dept_loc2.value
 string3 = res_dept_routing_queue_dflt.value
 string4 = print_urg_dept_loc1.value
 string5= print_urg_dept_loc2.value
 string6 = res_dept_stat_queue_dflt.value
}

var finalString = ""



finalString=string1+"~"+string2+"~"+string3+"~"+string4+"~"+string5+"~"+string6

		//window.returnValue = finalString;
	parent.document.getElementById('dialog-body').contentWindow.returnValue = finalString;  
	parent.document.getElementById('dialog_tag').close();
	
	//window.close();


}
</script>
<TITLE><fmt:message key="eOR.Print Results.label" bundle="${or_labels}"/></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<form name="dummyform" id="dummyform">
<input type=hidden name="finalstr" id="finalstr" value="">
			<table class= 'grid' width="100%">
<tr>
<td></td>
<td></td>
<td></td>
<td><td>
</tr>
<tr>
			<th class=columnheadercenter><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
			<th class=columnheadercenter><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></th>
			<th class=columnheadercenter><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/></th>
			<th class=columnheadercenter colspan="25%"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>---</th>

			</tr>
<tr>
<td colspan=4></td>
</tr>
<tr>
<td class='gridData'><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
<td class='gridData'>
<%
if(mode.equals("update"))
{
		
		print_dept_loc1 = request.getParameter("hidden1")==null?"" :request.getParameter("hidden1");

		print_dept_loc2 = request.getParameter("hidden2")==null?"" :request.getParameter("hidden2");

		print_report_dept_loc_radio = request.getParameter("hidden3")==null?"" :request.getParameter("hidden3");
		print_urg_dept_loc1 = request.getParameter("hidden4")==null?"" :request.getParameter("hidden4");

		print_urg_dept_loc2 = request.getParameter("hidden5")==null?"" :request.getParameter("hidden5");

		print_report_urg_dept_loc_radio = request.getParameter("hidden6")==null?"" :request.getParameter("hidden6");


}
else
{
		print_dept_loc1 = request.getParameter("print_dept_loc111")==null?"" :request.getParameter("print_dept_loc111");

		print_dept_loc2 = request.getParameter("print_dept_loc211")==null?"" :request.getParameter("print_dept_loc211");

		print_report_dept_loc_radio = request.getParameter("print_report_dept_loc_radio11")==null?"" :request.getParameter("print_report_dept_loc_radio11");
		print_urg_dept_loc1 = request.getParameter("print_urg_dept_loc111")==null?"" :request.getParameter("print_urg_dept_loc111");

		print_urg_dept_loc2 = request.getParameter("print_urg_dept_loc211")==null?"" :request.getParameter("print_urg_dept_loc211");

		print_report_urg_dept_loc_radio = request.getParameter("print_report_urg_dept_loc_radio11")==null?"" :request.getParameter("print_report_urg_dept_loc_radio11");

}

%>
<input type=text name='print_dept_loc1' id='print_dept_loc1'  size='20' maxlength='6'    onblur="setOtherLocationThis()" value="<%=print_dept_loc1%>"></td>
<td class='gridData'>
<input type=text name='print_dept_loc2' id='print_dept_loc2'  size='20' maxlength='6'    onblur="setOtherLocationThis1()" value="<%=print_dept_loc2%>"></td>
<td class='gridData'>
<input type=radio name='print_report_dept_loc_radio' id='print_report_dept_loc_radio'  value="OTHLOC_PAT_ROUTINE_QUEUE_DFLT" <%
if(print_report_dept_loc_radio.equals("1"))
			{
				out.println("checked");
			}else
				out.println("disabled");
%>><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
<td class='gridData'>
<input type=radio name='print_report_dept_loc_radio' id='print_report_dept_loc_radio'  onclick="" <%
if(print_report_dept_loc_radio.equals("2"))
			{
				out.println("checked");
			}else
				out.println("disabled");

%>><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
<input type=hidden  name="res_dept_routing_queue_dflt" id="res_dept_routing_queue_dflt" value="" ></td>
</tr>
<tr>
<td class='gridData'><fmt:message key="eOR.UrgStat.label" bundle="${or_labels}"/></td>
<td class='gridData'>
<input type=text name='print_urg_dept_loc1' id='print_urg_dept_loc1'  size='20' maxlength='6'    onblur="setOtherLocationThis3()" value="<%=print_urg_dept_loc1%>"></td>
<td class='gridData'>
<input type=text name='print_urg_dept_loc2' id='print_urg_dept_loc2'  size='20' maxlength='6'   onblur="setOtherLocationThis4()" value="<%=print_urg_dept_loc2%>"></td>
<td class='gridData'>
<input type=radio name='print_report_urg_dept_loc_radio' id='print_report_urg_dept_loc_radio' onclick="" <%

if(print_report_urg_dept_loc_radio.equals("1"))
			{
				out.println("checked");
			}else
				out.println("disabled");

%>><fmt:message key="eOR.Loc1.label" bundle="${or_labels}"/></td>
<td class='gridData'>
<input type=radio name='print_report_urg_dept_loc_radio' id='print_report_urg_dept_loc_radio' onclick="" <%
if(print_report_urg_dept_loc_radio.equals("2"))
			{
				out.println("checked");
			}else
				out.println("disabled");

%>><fmt:message key="eOR.Loc2.label" bundle="${or_labels}"/>
<input type=hidden name="res_dept_stat_queue_dflt" id="res_dept_stat_queue_dflt" value=""></td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td><td>
</tr>
<tr>
<td></td>
<td></td>
<td></td>
<td><td>
</tr>
			</table>
<br><br>
			<table align='right'>
			<tr>
				<td><input type="button" name="" id="" value="OK" onclick="assignValue()" class="Button" ></td>
</tr>
</table>
			</form>
</BODY>
</HTML>


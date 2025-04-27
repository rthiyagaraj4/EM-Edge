<!DOCTYPE html>
<%--
	FileName	: OperatorStationtabs.jsp
	
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>




      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script>

<%
request.setCharacterEncoding("UTF-8");
String oper_stn_id_mod=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");

String fac_name = request.getParameter("fac_name");

if(fac_name == null) fac_name="";

String mode = request.getParameter("mode");
if(mode == null) mode="";


%>
var prevObj = null;

function AppointmentDetails_search(obj)
{

document.getElementById('visitDet').className="FIRSTNORMAL";
document.getElementById('otherDet').className="FIRSTNORMAL";
selTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('appointment').scrollIntoView();
}

function VisitDetail_search(obj)
{

document.getElementById('apptDet').className="FIRSTNORMAL";
document.getElementById('otherDet').className="FIRSTNORMAL";
selTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('visit').scrollIntoView();
}



function other_search1(obj)
{

document.getElementById('visitDet').className="FIRSTNORMAL";
document.getElementById('apptDet').className="FIRSTNORMAL";
selTab(obj);
if(parent.parent.frames[1].frames[2]!=null)

parent.parent.frames[1].frames[2].document.getElementById('others').scrollIntoView();
}

function selTab(obj)
{

	document.getElementById(obj).className="SECONDSELECTED";
	prevObj = obj;
}
function selinpatientTab(obj)
{

	document.getElementById(obj).className="SECONDSELECTED";
	prevObj = obj;
}

function booking_search(obj)
{
	document.getElementById('trans').className="FIRSTNORMAL";
	document.getElementById('addm').className="FIRSTNORMAL";
	document.getElementById('disc').className="FIRSTNORMAL";
	document.getElementById('other').className="FIRSTNORMAL";

selinpatientTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('booking').scrollIntoView();
}

function Transfer_search(obj)
{
	document.getElementById('book').className="FIRSTNORMAL";
	document.getElementById('addm').className="FIRSTNORMAL";
	document.getElementById('disc').className="FIRSTNORMAL";
	document.getElementById('other').className="FIRSTNORMAL";
selinpatientTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('transfer').scrollIntoView();
}

function admission_search(obj)
{
	document.getElementById('book').className="FIRSTNORMAL";
	document.getElementById('trans').className="FIRSTNORMAL";
	document.getElementById('disc').className="FIRSTNORMAL";
	document.getElementById('other').className="FIRSTNORMAL";
selinpatientTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('admission').scrollIntoView();
}

function Discharge_search(obj)
{
	document.getElementById('book').className="FIRSTNORMAL";
	document.getElementById('trans').className="FIRSTNORMAL";
	document.getElementById('addm').className="FIRSTNORMAL";
	document.getElementById('other').className="FIRSTNORMAL";
selinpatientTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('discharge').scrollIntoView();
}

function others_search(obj)
{
		document.getElementById('book').className="FIRSTNORMAL";
	document.getElementById('addm').className="FIRSTNORMAL";
	document.getElementById('disc').className="FIRSTNORMAL";
	document.getElementById('trans').className="FIRSTNORMAL";
selinpatientTab(obj);
if(parent.parent.frames[1].frames[2]!=null)
parent.parent.frames[1].frames[2].document.getElementById('others').scrollIntoView();
}



 function setVal(Obj)
 {

	if(Obj.checked == true)      		
		Obj.value = 'Y';     		
	else if(Obj.checked == false)
		Obj.value = 'N';

 }

  function tab_click2(id){
	
			selectTab(id);
			tab_click(id);
			}
      
 function tab_click(objName)
    {

    if(objName=='additional_tab' || objName=='additional_tab1')
	{
			document.getElementById('addr').scrollIntoView();

			document.getElementById('book').className="SECONDSELECTED";
			document.getElementById('trans').className="FIRSTNORMAL";
			document.getElementById('addm').className="FIRSTNORMAL";
			document.getElementById('disc').className="FIRSTNORMAL";
			document.getElementById('other').className="FIRSTNORMAL";
			if(parent.parent.frames[1].frames[2]!=null)
			parent.parent.frames[1].frames[2].document.getElementById('booking').scrollIntoView();
			
			
			
	}
	else if(objName=='search_tab' || objName=='search_tab1')
	{
			document.getElementById('demo').scrollIntoView();

			document.getElementById('apptDet').className="SECONDSELECTED";
			document.getElementById('visitDet').className="FIRSTNORMAL";
			if(parent.parent.frames[1].frames[2]!=null)
			parent.parent.frames[1].frames[2].document.getElementById('appointment').scrollIntoView();
			
	}
     }

	

 


function codeArrestforScroll(e)
{
	
	alert(getMessage("WELCOME","Common"));
	return false;
}

var oper_stn_id ;
var long_desc ;
var short_desc;
var operstntype;
var eff_status;
var params;
var facility_id;
  
  var mode="<%=mode%>";
function load_op(){
	if(parent.frames[0].document.forms[0])
	{
	 oper_stn_id=parent.frames[0].document.forms[0].oper_stn_id.value;
	 long_desc=parent.frames[0].document.forms[0].long_desc.value;
	 short_desc=parent.frames[0].document.forms[0].short_desc.value;
	 operstntype=parent.frames[0].document.forms[0].operstntype.value;
	 facility_id=parent.frames[0].document.forms[0].facility.value;
	}
	 eff_status ='';
	 if(parent.frames[0].document.forms[0])
	{
	if(parent.frames[0].document.forms[0].eff_status.checked)
			eff_status='E';
else
			eff_status='D';
	}
 
 params = "oper_stn_id=<%=oper_stn_id_mod%>&oper_stn_type="+operstntype+"&eff_status="+eff_status+"&facility_id="+facility_id;
if(mode !="'m'")
	{
if(operstntype == '')
		{
		parent.parent.frames[1].frames[2].document.location.href="../../eCommon/html/blank.html";
		}else
		{
	parent.parent.frames[1].frames[2].document.location.href="../../eAM/jsp/addOperatorStationDetails.jsp?"+params ;
	setView();
		}
	}else
	{
		setTimeout("setView();",200);
		//setView();
	}


}
   
function setView()
{
	if(parent.frames[0].document.forms[0])
	{
	var optype=parent.frames[0].document.forms[0].operstntype.value;
	}
	if (optype=='I')
	{
		document.getElementById('inpat_act_tab_vw').scrollIntoView();
		
	}
	else if(optype=='O')
	{
		document.getElementById('outpat_act_tab_vw').scrollIntoView();
		
	}
}
   	</script>
   	</head>
 
<body OnMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onclick ="CodeArrest();" onSelect="codeArrestThruSelect();" onload="load_op();" >

      <%
	  try{
		 
		 String oper_stn_id="";
		 
		 String operstntype="";
		 		
		 String facilityId = request.getParameter("facility_id");
			if(facilityId == null) facilityId="";
			else
			facilityId =facilityId.trim();
		
		 
   	 	
		 oper_stn_id=request.getParameter("oper_stn_id");
		 if(oper_stn_id==null) oper_stn_id="";
		 operstntype=request.getParameter("oper_stn_type");
		
	 	
	 
		 String eff_status = request.getParameter("eff_status");
			if(eff_status == null) eff_status="";
		
	

%>
<a name= 'outpat_act_tab_vw' id= 'outpat_act_tab_vw' >

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' align='center'>
<tr>


<%	if(operstntype !=null && operstntype.equals("I")){
			%>
			
	<a name='demo' id='demo'></a>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
		<a class="tabA" id='search_tab' >
			<span class="tabAspan" id="search_tabspan"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Inpatient">
				<a onclick="tab_click2('additional_tab')" class="tabClicked" id='additional_tab' >
					<span class="tabSpanclicked" id="additional_tabspan" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
        <br>
			
			
			
			
		<%	
		 }else if(operstntype !=null && operstntype.equals("O")){ %>

<a name='demo' id='demo'></a>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
				<a onclick="tab_click2('search_tab')" class="tabClicked" id='search_tab' >
					<span class="tabSpanclicked" id="search_tabspan" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Inpatient">
				
					<span class="tabAspan" id="additional_tabspan" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
        <br>

		
			 
			 
			 
		<%	
		}else if(operstntype !=null && operstntype.equals("B")){%>

		<a name='demo' id='demo'></a>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
				<a onclick="tab_click2('search_tab')" class="tabClicked" id='search_tab' >
					<span class="tabSpanclicked" id="search_tabspan" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		<li class="tablistitem" title="Inpatient">
				<a onclick="tab_click2('additional_tab')" class="tabA" id='additional_tab' >
					<span class="tabAspan" id="additional_tabspan" ><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
		</ul>
        <br>
			
		<%
		}
   %>
   </tr>
 </table>




 <%	if((operstntype !=null && operstntype.equals("O") )|| (operstntype.equals("B"))){
			%>

<table name='outtable' id='outtable' id='out' cellspacing='0' cellpadding='0' border='1' width='50%' align='left'>
<tr>
			 <td id='apptDet' class='SECONDSELECTED'  width='5%' align=center style='cursor:pointer;'  onclick="AppointmentDetails_search('apptDet');"><font color='black'><fmt:message key="Common.AppointmentDetails.label" bundle="${common_labels}"/></font></td>
			
			 <td id='visitDet' class='FIRSTNORMAL' width='5%'  align=center style='cursor:pointer;'  onclick="VisitDetail_search('visitDet');"><font color='black'><fmt:message key="Common.VisitDetail.label" bundle="${common_labels}"/></font></td> 

			 <td id='otherDet' class='FIRSTNORMAL' width='5%'  align=center style='cursor:pointer;'  onclick="other_search1('otherDet');"><font color='black'><fmt:message key="Common.others.label" bundle="${common_labels}"/></font></td> 
	

</tr>

</table>

<% } %>

<br><br><br><br>

<a name= 'inpat_act_tab_vw' id= 'inpat_act_tab_vw'  >

<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' align='center'>
<tr>


<%	

if(operstntype !=null && operstntype.equals("I")){%>
	
		    <a name='addr' id='addr'></a>
	
			 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
				
					<span class="tabAspan" id="search_tab1span"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Inpatient">
				<a onclick="tab_click2('additional_tab1','additional_tab1')" class="tabclicked" id="additional_tab1" >
					<span class="tabspanclicked" id="additional_tab1span"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
	</ul>
<br>
	
	
	<%
		}else if(operstntype !=null && operstntype.equals("O")){%>
	
			    <a name='addr' id='addr'></a>
	
	 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
				<a onclick="tab_click2('search_tab1','search_tab1')" class="tabA" id="search_tab1" >
					<span class="tabAspan" id="search_tab1span"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Inpatient">
				
					<span class="tabspanclicked" id="additional_tab1span"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
	</ul>
<br>
	
	
	<%
		}else if(operstntype !=null && operstntype.equals("B")){%>
	
		    <a name='addr'  id='addr'></a>
	
	 <ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outpatient">
				<a onclick="tab_click2('search_tab1','search_tab1')" class="tabA" id="search_tab1" >
					<span class="tabAspan" id="search_tab1span"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Inpatient">
				<a onclick="tab_click2('additional_tab1','additional_tab1')" class="tabclicked" id="additional_tab1" >
					<span class="tabspanclicked" id="additional_tab1span"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
				</a>
			</li>
	</ul>
<br>
			
		<%
		}
   %>
</td></tr>
 </table>

<% 
if (operstntype.equals("I") || (operstntype.equals("B"))) {
			%>


<table name='intable' id='intable'  cellspacing='0' cellpadding='0' border='1' width='100%' align='center'>

<tr>
			 <td class='SECONDSELECTED' id='book' width='10%' align=center style='cursor:pointer;' nowrap onclick="booking_search('book');"><font color='black'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></font></td>
			
			 <td class='FIRSTNORMAL' id='addm' width='10%'  align=center style='cursor:pointer;' nowrap onclick="admission_search('addm');"><font color='black'><fmt:message key="Common.admission.label" bundle="${common_labels}"/></font></td> 

			 <td class='FIRSTNORMAL' id='trans' width='10%'  align=center style='cursor:pointer;' nowrap onclick="Transfer_search('trans');"><font color='black'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/></font></td> 

			 <td class='FIRSTNORMAL' id='disc' width='10%'  align=center style='cursor:pointer;' nowrap onclick="Discharge_search('disc');"><font color='black'><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/></font></td> 

			 <td class='FIRSTNORMAL' id='other' width='10%'  align=center style='cursor:pointer;' nowrap onclick="others_search('other');"><font color='black'><fmt:message key="Common.others.label" bundle="${common_labels}"/></font></td>
			 
			 
			
	</tr>
</table>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<%
	}

	 }
       catch(Exception e){
		out.println(e);
	}
%>


</body>
</html>


<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.* "%>
 <html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<SCRIPT>
function calthis(fromWh)
{	
	var sec_resorces_req=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces_req.value;
	
	var sec_resorces=top.frames[1].frames[0].frames[0].document.forms[0].sec_resorces.value;
	
	var sel_man="";
	var sel="N";
	var xarr=sec_resorces_req.split(",");
	var xarr1=sec_resorces.split(",");
	var msg="";

			for(var ik=0;ik<xarr1.length;ik++)
				{
					var arr2=xarr1[ik].replace("'","");

					arr2=arr2.replace("'","");
					if(arr2=='R' && xarr[ik]=='Y')
						msg=msg+"R,";

					if(arr2=='E' && xarr[ik]=='Y')
						msg=msg+"E,";

					if(arr2=='P' && xarr[ik]=='Y')
						msg=msg+"P,";

					if(arr2=='O' && xarr[ik]=='Y')
						msg=msg+"O,";
				}

		
		var xarr33=msg.split(",");

		var equ_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_equ.value ;
		var room_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_room.value;
		
		var oth_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_other.value;
		var pract_val = top.frames[1].frames[0].frames[0].document.forms[0].first_set_value_pract.value;
		var flgP=false;
		var flgE=false;
		var flgO=false;
		var flgR=false;
		
		
		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enE")){
			
			var ind=equ_val.indexOf('Y');
			if(equ_val=='' || (ind==-1)){
				flgE=true;
			}
		}

		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enR")){
			var ind=room_val.indexOf('Y');
			if(room_val=='' || (ind==-1)){
				flgR=true;
			}
		}

		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enP")){
			var ind=pract_val.indexOf('Y');
			if(pract_val=='' || (ind==-1)){
				flgP=true;
			}
		}
		if(top.frames[1].frames[0].frames[0].document.getElementById("sec_enO")){
			var ind=oth_val.indexOf('Y');
			if(oth_val=='' || (ind==-1)){
				flgO=true;
			}
		}
	if((flgP || flgO || flgE || flgR) && fromWh=='Confirm'){
		alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
		return false;
		parent.frames[2].document.forms[0].Insupd.disabled=true;
	}else{
		

		var final_val='';
		if(equ_val=='')
			equ_val='*';

		if(room_val=='')
			room_val='*';

		if(oth_val=='')
			oth_val='*';

		if(pract_val=='')
			pract_val='*';

		final_val='E#'+equ_val+'||'+'R#'+room_val+'||'+'O#'+oth_val+'||'+'P#'+pract_val;
		
		var seleted_values=final_val;
		top.frames[0].document.forms[0].sec_sel.value=seleted_values;
		return true;
	}
		


		
}
function callFuncs(){
	var SinMul=parent.frames[0].document.forms[0].sec_value_count.value;
	var secReses=parent.frames[0].document.forms[0].SecResCheck.value;
	 if (secReses=='Y'){
	if (SinMul=='Y'){
if (parent.frames[1].frames[0].frames[1].document.forms[0]){
if(parent.frames[1].frames[0].frames[1].validate()){
	
 if (calthis('Confirm')){
	 
parent.frames[0].validate_allocation_criteria();
 }
}else{
	
	sec_res=parent.frames[0].document.forms[0].sec_req.value;
	
	index=sec_res.indexOf('Y');
	if (index!=-1){
	alert(getMessage("ALL_MAN_RES_NT_SL","OA"));
	parent.frames[2].document.forms[0].Insupd.disabled=true;

	}else{
	parent.frames[0].validate_allocation_criteria();
	}
}
}else{
	alert(getMessage("SEC_RES_NT_SEL","OA"));
	parent.frames[2].document.forms[0].Insupd.disabled=true;
}
	}
	else if (SinMul=='N'){
		if (parent.frames[1].frames[1].document.forms[0]){
  if (parent.frames[1].frames[1].validate('Confirm')){
	
	parent.frames[0].validate_allocation_criteria();
	}
		}
	}else{
	parent.frames[0].validate_allocation_criteria();
    }
	 }else if (secReses='N'){
parent.frames[0].validate_allocation_criteria();
	 }
}
</SCRIPT>
</head>
 <% 
request.setCharacterEncoding("UTF-8");
 String fromPage=request.getParameter("fromPage")==null?"":request.getParameter("fromPage");
 if (!fromPage.equals("BookAppointment"))
 {

 %>

		<body onKeyDown = 'lockKey()'>
		<form name="recur_day_results" id="recur_day_results" method="post">
		<table cellpadding=0 cellspacing=0 width="100%">
		<tr><td class="OAQRYODD" align=middle><input type="button" value="OK" class=button onclick="parent.frames[1].validate1()">
		<input type="button" value="Cancel" class=button onclick="parent.frames[1].ret_none1()">
		</td></tr>
		</table>
		</form>
		</body>
		</html>
<%}else{
		
		String patientid=request.getParameter("patientid")==null?"":request.getParameter("patientid");
	%>
				<body onKeyDown = 'lockKey()'>
				<form name="BookApptBottom" id="BookApptBottom" method='post'>
				<table border='0' cellpadding='0' cellspacing='0' width='100%' >
					<tr>
					<td   align='left' colspan=6 width="100%"> 	
					<input type='button' name='past_visits' id='past_visits' value='Previous Encounter'  class="BUTTON" onClick='parent.frames[0].past_visits_view()' disabled
					>&nbsp;
					
				
						
						<input  type = 'button' id='other_id1' value = 'Other Appts' onclick = 'parent.frames[0].show_window("Two")'  class="BUTTON" ></input>
						<input type = 'hidden' id='OtherAppts' name='OtherAppts' id='OtherAppts' value = 'Other Appts' onclick = 'parent.frames[0].show_window("Two")'  class="BUTTON" ></input>
										
					<input type='button' id='sec' value='Secondary Resources'  class="BUTTON" style="visibility:hidden" onClick='show_second()'>
					<%if (patientid.equals("")){%>
						
						<input type='button' id='ffgh' name='clear' id='clear' value='Clear'  class="BUTTON" onClick='parent.frames[0].clearAll1()'>
					<%}%>
					&nbsp;<input type='button' name='Insupd' id='Insupd' value='Confirm Booking' onClick='callFuncs();' class="BUTTON" >&nbsp;<input type='button' name='close' id='close' value='Close'  class="BUTTON" onClick='parent.frames[0].exitval()' >
			</td>
			</TR>
   			</table>

	</form>
	</body>
<%}%>


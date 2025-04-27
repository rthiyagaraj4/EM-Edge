var flag;   
function create() { 
	f_query_add_mod.location.href ="../../eOA/jsp/BlockapptslotQueryCriteriaMain.jsp?" ;
}
function populate(){
cleared();
var u=parent.frames[0].document.forms[0].location.value;
strArray = u.split("%");
var clinic_code=strArray[0];
var clinic_type=strArray[1];
var open_to_all_pract_yn=strArray[2];
if( u.length == 0){
var n=parent.frames[0].document.forms[0].practitioner.options.length;
	for(var i=0;i<n;i++)
	{
	parent.frames[0].document.forms[0].practitioner.remove("pract");
	}
	var tp ="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	var opt=parent.frames[0].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[0].document.forms[0].practitioner.add(opt);

}
else{
HTMLVal = "<html><BODY onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eOA/jsp/RetriveResults.jsp'><input type='hidden' name='clinic_type' id='clinic_type' value='"+clinic_type+"'> "+"<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'> "+"<input type='hidden' name='clinic_code' id='clinic_code'  value='"+clinic_code+"'>  </form></BODY></HTML>";
parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.parent.frames[2].document.form1.submit();
}
}

function callSchedule()
{
var u=parent.frames[0].document.forms[0].location.value;
strArray = u.split("%");
var clinic_code=strArray[0];
var pract_id=parent.frames[0].document.forms[0].practitioner.value;
var date=parent.frames[0].document.forms[0].block_date1.value;

var clinic_type=parent.frames[0].document.forms[0].location1.value;
var res_type =parent.frames[0].document.forms[0].resourceType1.value;
var slot_appt_ctrl=parent.frames[0].document.forms[0].slot_appt_ctrl.value;
var visit_limit_rule=parent.frames[0].document.forms[0].visit_limit_rule.value;
var sys_date=parent.frames[0].document.forms[0].sys_date.value;
var sys_time=parent.frames[0].document.forms[0].sys_time.value;
var u1="../../eOA/jsp/BlockAppointmentResultsMain.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+date+"&anchor=set&to_anchor=no&clinic_type="+clinic_type+"&res_type="+res_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;
parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
//alert("u" +u1);

parent.frames[1].location.href=u1;
}

function check_mandatory(){
	parent.frames[1].location.href="../../eCommon/html/blank.html";
	var fields = new Array();
	var names = new Array ();
	if (parent.frames[0].document.getElementById("imgpract").style.visibility!='hidden'){
		fields[0]= parent.frames[0].document.forms[0].b_loc_val;
		fields[1]= parent.frames[0].document.forms[0].resource;
		fields[2]= parent.frames[0].document.forms[0].practitioner;
		fields[3]= parent.frames[0].document.forms[0].block_date1;
		fields[4]= parent.frames[0].document.forms[0].reason_for_block1;

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[0].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[5] = parent.frames[0].document.forms[0].other_remarks;
		}
		/*End ML-MMOH-CRF-1114*/

	}else{
		fields[0]= parent.frames[0].document.forms[0].b_loc_val;
		fields[1]= parent.frames[0].document.forms[0].resource;
		fields[2]= parent.frames[0].document.forms[0].block_date1;
		fields[3]= parent.frames[0].document.forms[0].reason_for_block1;

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[0].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			fields[4] = parent.frames[0].document.forms[0].other_remarks;
		}
		/*End ML-MMOH-CRF-1114*/
		}
	if(parent.frames[0].document.getElementById("imgpract").style.visibility!='hidden'){

		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourcetype.label","Common");
		names[2] = getLabel("Common.resourcename.label","Common");
		names[3] = getLabel("eOA.BlockDate.label","OA");
		names[4] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[0].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			names[5] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

	}else{
		names[0] = getLabel("Common.Location.label","Common");
		names[1] = getLabel("Common.resourcetype.label","Common");
		names[2] = getLabel("eOA.BlockDate.label","OA");
		names[3] = getLabel("Common.reason.label","Common");

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		if(parent.frames[0].document.forms[0].remarks_img.style.visibility == 'visible')
		{
			names[4] = getLabel("Common.remarks.label","Common");
		}
		/*End ML-MMOH-CRF-1114*/

		}
	if(checkFields( fields, names, parent.parent.messageFrame)){
		callSchedule();
	}else{
	}	
	parent.frames[0].document.forms[0].b_from.value = "";
	parent.frames[0].document.forms[0].b_to.value = "";
}
function apply(){
	flag=true;
	var fields = new Array();
	var names = new Array ();
	if(f_query_add_mod.document.forms[0]){
		if(f_query_add_mod.document.forms[0].name=='delete_appt_form'){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}else if(f_query_add_mod.document.forms[0].name=='query_form'){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}else if(f_query_add_mod.document.forms[0].name=='results'){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}else{
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}
	}else{
		if (f_query_add_mod.frames[0].document.getElementById("imgpract").style.visibility=='hidden'){
			fields[0]= f_query_add_mod.frames[0].document.blockappt_form.location;
			fields[1]= f_query_add_mod.frames[0].document.blockappt_form.resource;
			fields[2]= f_query_add_mod.frames[0].document.blockappt_form.block_date1;
			fields[3]= f_query_add_mod.frames[0].document.blockappt_form.b_from;
			fields[4]= f_query_add_mod.frames[0].document.blockappt_form.b_to;
			fields[5]= f_query_add_mod.frames[0].document.blockappt_form.reason_for_block1;

			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			if(f_query_add_mod.frames[0].document.blockappt_form.remarks_img.style.visibility == 'visible')
			{
				fields[6] = f_query_add_mod.frames[0].document.blockappt_form.other_remarks;
			}
			/*End ML-MMOH-CRF-1114*/

		}else{
			fields[0]= f_query_add_mod.frames[0].document.blockappt_form.location;
			fields[1]= f_query_add_mod.frames[0].document.blockappt_form.resource;
			fields[2]= f_query_add_mod.frames[0].document.blockappt_form.practitioner;
			fields[3]= f_query_add_mod.frames[0].document.blockappt_form.block_date1;
			fields[4]= f_query_add_mod.frames[0].document.blockappt_form.b_from;
			fields[5]= f_query_add_mod.frames[0].document.blockappt_form.b_to;
			fields[6]= f_query_add_mod.frames[0].document.blockappt_form.reason_for_block1;

			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			if(f_query_add_mod.frames[0].document.blockappt_form.remarks_img.style.visibility == 'visible')
			{
				fields[7] = f_query_add_mod.frames[0].document.blockappt_form.other_remarks;
			}
			/*End ML-MMOH-CRF-1114*/

		}
		if(f_query_add_mod.frames[0].document.getElementById("imgpract").style.visibility=='hidden'){
					names[0] = getLabel("Common.Location.label","Common");
					names[1] = getLabel("Common.resourcetype.label","Common");
					names[2] = getLabel("eOA.BlockDate.label","OA");
					names[3] = getLabel("eOA.BlockFromTime.label","OA");
					names[4] = getLabel("eOA.BlockToTime.label","OA");
					names[5] = getLabel("Common.reason.label","Common");

					/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
					if(f_query_add_mod.frames[0].document.blockappt_form.remarks_img.style.visibility == 'visible')
					{
						names[6] = getLabel("Common.remarks.label","Common");
					}
					/*End ML-MMOH-CRF-1114*/

		}else{
					names[0] = getLabel("Common.Location.label","Common");
					names[1] = getLabel("Common.resourceclass.label","Common");
					names[2] = getLabel("Common.resourcename.label","Common");
					names[3] = getLabel("eOA.BlockDate.label","OA");
					names[4] = getLabel("eOA.BlockFromTime.label","OA");
					names[5] = getLabel("eOA.BlockToTime.label","OA");
					names[6] = getLabel("Common.reason.label","Common");

					/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
					if(f_query_add_mod.frames[0].document.blockappt_form.remarks_img.style.visibility == 'visible')
					{
						names[7] = getLabel("Common.remarks.label","Common");
					}
					/*End ML-MMOH-CRF-1114*/
					
		}
		if(checkFields( fields, names, messageFrame)){
			var u1=f_query_add_mod.frames[0].document.blockappt_form.location.value;
			strArray3 = u1.split("%");
			var clinic_code1=strArray3[0];
			f_query_add_mod.frames[0].document.blockappt_form.block_date.value=f_query_add_mod.frames[0].document.blockappt_form.block_date1.value;
			f_query_add_mod.frames[0].document.blockappt_form.block_from_time.value=f_query_add_mod.frames[0].document.blockappt_form.b_from.value;
			f_query_add_mod.frames[0].document.blockappt_form.block_to_time.value=f_query_add_mod.frames[0].document.blockappt_form.b_to.value;
			f_query_add_mod.frames[0].document.blockappt_form.reason_for_block.value=f_query_add_mod.frames[0].document.blockappt_form.reason_code.value;
			f_query_add_mod.frames[0].document.blockappt_form.clinic.value=clinic_code1;
			f_query_add_mod.frames[0].document.blockappt_form.practitioner.value=f_query_add_mod.frames[0].document.blockappt_form.practitioner.value;
			f_query_add_mod.frames[0].document.blockappt_form.time_per_patient.value=frames[1].frames[1].document.results.document.displayresults.time_per_patient.value;
			f_query_add_mod.frames[0].document.blockappt_form.time_table_type.value=frames[1].frames[1].document.results.document.displayresults.time_table_type.value;
			f_query_add_mod.frames[0].document.blockappt_form.max_patients_per_slab.value=frames[1].frames[1].document.results.document.displayresults.max_patients_per_slab.value;
			var from_count=f_query_add_mod.frames[0].document.blockappt_form.from_count.value;
			var to_count=frames[1].frames[1].document.results.document.displayresults.to_count.value;
			//var to_count=frames(1).document.frames(1).document.frames(0).document.displayresults.to_count.value;
			var final_count="";
			if(from_count==to_count){
				final_count=1;
			}else{
				final_count=to_count-from_count;
				final_count=final_count+1;
			}
			f_query_add_mod.frames[0].document.blockappt_form.final_count.value=final_count;
			calculateSlot();
			if(f_query_add_mod.frames[0].document.blockappt_form.visit_limit_rule.value=='N'){
				f_query_add_mod.frames[0].document.blockappt_form.other_visits_value.value=final_count;
			}
			f_query_add_mod.frames[0].document.blockappt_form.action="../../servlet/eOA.BlockAppointmentServlet";
			f_query_add_mod.frames[0].document.blockappt_form.target="messageFrame";
			f_query_add_mod.frames[0].document.blockappt_form.submit();
		}
	}
}
function query(){
	f_query_add_mod.location.href ="../../eOA/jsp/queryBlockAppointmentPage.jsp";
}
function deleterecord(){
	 if(f_query_add_mod.document.forms[0]){
		 if(f_query_add_mod.document.forms[0].name=='delete_appt_form'){
			 flag=false;
			 if(confirm(getMessage('DELETE_RECORD','Common'))){
				f_query_add_mod.document.forms[0].submit();
			}else{
				messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
			}
		 }else{
			 		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		 }
	 }else{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	 }
}
function ClearMsgFrame(){
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}
function reset(){
	if (f_query_add_mod.document.forms[0]){
		if(f_query_add_mod.document.forms[0].name =="query_form"){
			f_query_add_mod.location.href ="../../eOA/jsp/queryBlockAppointmentPage.jsp";
		}
	}else{
		/*var lBox=f_query_add_mod.document.frames[0].document.blockappt_form.location; 
		var len=f_query_add_mod.document.frames[0].document.blockappt_form.location.options.length;
		lBox.remove(lBox.options[0]);
	    var opt=document.createElement('OPTION');
        while(i<= len){
		lBox.remove(lBox.options[i]);
		i+=1;
		}
		opt.value='';
		opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
		lBox.add(opt);*/
		f_query_add_mod.location.href ="../../eOA/jsp/BlockapptslotQueryCriteriaMain.jsp";
		f_query_add_mod.frames[0].document.blockappt_form.location.value="";	
		f_query_add_mod.frames[0].document.blockappt_form.block_date1.value="";
		f_query_add_mod.frames[0].document.blockappt_form.b_from.value="";
		f_query_add_mod.frames[0].document.blockappt_form.b_to.value="";
		f_query_add_mod.frames[0].document.blockappt_form.reason_for_block1.value="";
		f_query_add_mod.frames[0].document.blockappt_form.practitioner.value="";
		f_query_add_mod.frames[0].document.blockappt_form.practitioner_name.value="";
		f_query_add_mod.frames[0].document.blockappt_form.location.value="";
		f_query_add_mod.frames[0].document.blockappt_form.resource.value="";
		f_query_add_mod.frames[0].document.forms[0].search_pract.disabled=true;
		f_query_add_mod.frames[0].document.forms[0].practitioner_name.disabled=true;
		f_query_add_mod.frames[0].document.forms[0].resource.disabled=true;
		f_query_add_mod.frames[0].document.forms[0].imgpract.style.visibility ='hidden';
		f_query_add_mod.frames[0].document.blockappt_form.location1.value="";
		f_query_add_mod.frames[1].document.location.href='../../eCommon/html/blank.html'
	}
}

function onSuccess(){
	if(flag){
		reset();
	}else{
		f_query_add_mod.document.location.href="../../eOA/jsp/BlockapptslotQueryCriteriaMain.jsp?" ;
	}
}



function check_date(obj)
	{


if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
	var stdt = parent.parent.frames[1].frames[0].document.forms[0].sys_date.value;

	var obj2=convertDate(obj.value,"DMY",localeName,"en");
		if(isBefore(stdt,obj2,'DMY',"en")==false)
				{
				alert(getMessage("BLK_DT_VALIDATION","OA"));
				obj.value="";
				obj.select();	
				return false;
			}

	}

}



function cleared()
{
parent.frames[1].document.location.href='../../eCommon/html/blank.html';

}



/* This function  is added to enable and disable pract_butt based on the clinic selection and also  chk for which all clinic pract is mandatory */
        function ena_pract(Obj)
		{         
	
		  var locn=Obj.value;
		  var arr= new Array();
		  arr=locn.split("%");
		  var check = arr[3];
			document.getElementById("practitioner").value="";
			document.getElementById("practitioner_name").value="";
		
		  if (check=="X")
			document.getElementById("imgpract").style.visibility='hidden';
		  else
			document.getElementById("imgpract").style.visibility ='visible';
		 if (Obj.value!="")
			{
			document.getElementById("search_pract").disabled = false
			document.getElementById("practitioner_name").disabled=false
			}
		 else
	      {
			 document.getElementById("search_pract").disabled = true;
			 document.getElementById("practitioner_name").disabled=true;
			document.getElementById("imgpract").style.visibility ='hidden';
		  }
		}


		function locationreturn(obj)
{
	/*var n=document.forms[0].location.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].location.remove("clinic");
		
	}*/
	var locationtype = document.forms[0].location1.value;
	
	
	if(obj.value==null||obj.value==""){
	document.forms[0].resource.value="";
	document.forms[0].resource.disabled=true;
	document.forms[0].practitioner_name.value="";
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	}else{
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].resource.value="";
	document.forms[0].resource.disabled=true;
	document.forms[0].practitioner_name.value="";
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	document.forms[0].b_loc_val.disabled=false;
	document.forms[0].b_loc_search.disabled=false;
	}
	/*var opt=document.createElement("OPTION");
	opt.text=" ------------------------"+getLabel("Common.defaultSelect.label","Common")+"----------------------- ";
	opt.value="";
	document.forms[0].location.add(opt);

	//var oper_stn_id=document.forms[0].oper_stn_id.value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH locn_val=\""+obj.value+"\" steps='10' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/
document.getElementById("imgpract").style.visibility='hidden';
parent.frames[1].document.location.href='../../eCommon/html/blank.html';

}

function enablepr(obj)
{
var chk='';
var vlschk="";
vlschk=document.forms[0].identityCheckIn.value;
//var si=document.forms[0].location.options.selectedIndex-1;
var obj = document.forms[0].location1.value;
var locn_code=document.forms[0].location.value;
document.getElementById("location_code1").value= locn_code;
if (locn_code==""){
document.forms[0].resource.disabled = true;
}else{
if(obj=='D')
{
	var res=document.forms[0].resource;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	 res.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
		
		 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
	   document.forms[0].resource.disabled=false;
}else{ 
	   var res=document.forms[0].resource;
	   	   document.forms[0].resource.disabled=false;

	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   res.add(opt);
   }
}

 return obj;
/*if (si==-1){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 chk=vlschk.substr(si,1);
 document.forms[0].resource.disabled= false;
}*/

if (locn_code==""){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 document.forms[0].resource.disabled= false;
}

var val= obj.value;
var arr=val.split('%');
	
if(arr[3]=='P')
{
document.getElementById("imgpract").style.visibility='visible';
document.getElementById("resourceType").disabled=false;
}else{
	document.getElementById("imgpract").style.visibility='hidden';
	document.getElementById("resourceType").disabled=false;
	}
	
	parent.document.f_query_add_mod.document.location.href='../../eCommon/html/blank.html';
}

function validateTbs(){
var clValue=document.forms[0].location.value;
 if (!document.forms[0].practitioner_name.disabled){
document.forms[0].practitioner_name.value="";
document.forms[0].resource.value="";
document.forms[0].practitioner_name.disabled=true;
document.forms[0].search_pract.disabled=true;
}
}
function practValidate(obj){
var clinicCode=document.forms[0].location.value;
var resourceCode=document.forms[0].resource.value;
if(resourceCode=='' || resourceCode=='B')
{
	document.forms[0].practitioner_name.value="";
document.forms[0].practitioner.value="";
document.forms[0].practitioner_name.disabled=true;
document.forms[0].search_pract.disabled=true;
}else
{
	document.forms[0].practitioner_name.value="";
document.forms[0].practitioner.value="";
	document.forms[0].practitioner_name.disabled=false;
document.forms[0].search_pract.disabled=false;
}
document.getElementById("resourceType1").value=obj.value;
 	parent.frames[1].document.location.href='../../eCommon/html/blank.html';

}
function resourceOnBlur(){
	var selIn=document.forms[0].resource.options.selectedIndex;

	var valIs= document.forms[0].resource.options[selIn].value;
document.getElementById("resourceType").value=valIs;
	parent.frames[1].document.location.href='../../eCommon/html/blank.html';

}



function clearFields()
	{
	var clinic_code=document.forms[0].clinic_code.value;
	var pract_id=document.forms[0].pract_id.value;
	var appt_date=document.forms[0].appt_date.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var res_type=document.forms[0].res_type.value;	
	parent.parent.frames[0].document.forms[0].b_from.value="";
	parent.parent.frames[0].document.forms[0].b_to.value="";

	sys_date=parent.parent.frames[1].frames[0].document.forms[0].sys_date.value;
	sys_time=parent.parent.frames[1].frames[0].document.forms[0].sys_time.value;

	visit_limit_rule=parent.parent.frames[1].frames[0].document.forms[0].visit_limit_rule.value;
	slot_appt_ctrl=parent.parent.frames[1].frames[0].document.forms[0].slot_appt_ctrl.value;

parent.frames[0].document.location.href="../../eOA/jsp/BlockAppointmentResults.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+appt_date+"&clinic_type="+clinic_type+"&res_type="+res_type+"&anchor=&to_anchor=&rowNum=0&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;
	
	}


	var u1;
	var u2;
	var value1;
	var value2;
	var value3;
	var value4;
	var value5;
	var value6;
	var value7;
	var value8;
	 var value9;
	 var value10;
	 var value11;
	 var sys_date;
	 var sys_time;

	 var value12;
	 var value13;

	function row(Obj){
		u1=Obj.rowIndex;
		}

		function col(Obj)
		{
		 u2=Obj.cellIndex;
		}
	function moveNext(obj2)
	{			
		time_table_type=document.forms[0].time_table_type.value;	
		max_patients_per_slab=document.forms[0].max_patients_per_slab.value;
		var appt_ref_no_exists=false;
		var obj3;

		if(time_table_type == "2"){		
			count=eval('document.forms[0].identify_first'+obj2).value;			
			obj3 = obj2 - (count - 1);			
			for(var i=1; i <= count; i++){		
				appt_ref_no=eval('document.forms[0].o_appt_ref_no'+obj3).value;
				if(appt_ref_no != '~'){
					appt_ref_no_exists=true;
					break;
				}	
				obj3++;
			}
			if(appt_ref_no_exists){				
				alert(getMessage("APPT_EXISTS_SPEC_DUR","OA"));
				return;
			}			
			obj3 = obj2 - (count - 2 );	
			
		}else{
			obj3=u1;
		}
		
		//parent.parent.frames[0].document.forms[0].from_count.value=obj2;
		parent.parent.frames[0].document.forms[0].from_count.value=obj3;
	var len=document.getElementById("results").rows.length;
	var clinic_code=document.forms[0].clinic_code.value;
	var pract_id=parent.frames[1].document.forms[0].pract_id.value;
	var appt_date=document.forms[0].appt_date.value;

	var clinic_type=document.forms[0].clinic_type.value;
	var res_type=document.forms[0].res_type.value;


	value6= document.getElementById("results").rows[u1].cells[u2].innerText;
	value7=document.getElementById("results").rows[u1].cells[u2+1].innerText;
	//Added on 29/04/2003
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value11=document.forms[0].elements[u1-1].value;
	
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;

	visit_limit_rule=document.forms[0].visit_limit_rule.value;
	slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;


	fromtimeharray=sys_time.split(":");
	from_time=value6.split(":");
	to_displayed_time=value7.split(":");

	if(to_displayed_time == "00,00")
	{
		to_displayed_time[0] = "23";
		to_displayed_time[1] = "59";
	}

	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	var name=document.getElementById("results").rows[u1].cells[u2+2].innerText;
	var i=0;
	var to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);

	
	if(eval('document.forms[0].o_appt_ref_no'+obj2).value == "~"){
		var obj1=document.forms[0].appt_date.value;
		var sysdate=document.forms[0].sys_date.value;
		var obj_res=isBefore(obj1,sysdate,'DMY',localeName);
		if(isBefore(obj1,sysdate,'DMY',localeName)==true)
		{				
			if(value9 == "1" || value9 == "2"  )
			{
				if(( Date.parse(tohtm) < Date.parse(fromhtm) )  )
				{
					alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
				}
				else
				{
					if(name.length == 1)
					{						
						parent.parent.frames[0].document.forms[0].b_from.value=value6;
					var from_page="result" ;
					var url="../../eOA/jsp/BlockAppointmentResults.jsp?from_page='"+from_page+"'&clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+obj1+"&anchor=reset&to_anchor=yes&rowNum="+obj3+"&res_type="+res_type+"&clinic_type="+clinic_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;
					document.location.href=url;

					}
					else
					{
						alert(getMessage("CANNOT_BLOCK_SLOT","OA"));
					}
				}
			}
			if( value9 == "3")
			{
				if(( Date.parse(to_displayed) < Date.parse(fromhtm) )  )
				{
					alert(getMessage('ST_TM_LESS_SY_TM',"OA"));
				}
			}
		}
		else
		{
			if(name.length == 1)
			{
				parent.parent.frames[0].document.forms[0].b_from.value=value6;
			var from_page="result" ;			
	document.location.href="../../eOA/jsp/BlockAppointmentResults.jsp?from_page='"+from_page+"'&clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+appt_date+"&anchor=reset&to_anchor=yes&rowNum="+obj3+"&res_type="+res_type+"&clinic_type="+clinic_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;

			}
			else
			{
				alert(getMessage("CANNOT_BLOCK_SLOT","OA"));
			}
		
		}
	}else{
		alert(getMessage("APPT_EXISTS_SPEC_DUR","OA"));
		return;
	}
		
	}
	//End of addition on 29/04/2003
	


	function changeResource(){
	
var obj=document.forms[0].locn_type;
var selectedValue=obj.value;
var resource = document.forms[0].resource_type;
if (selectedValue=='D'){
 while( resource.options.length > 0) resource.remove(resource.options[0]);
     opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	 resource.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   resource.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   resource.add(opt);

   }
   else{
	   while(resource.options.length>0) resource.remove(resource.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text=getLabel("Common.practitioner.label","Common");
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text=getLabel("Common.equipment.label","Common");
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text=getLabel("Common.room.label","Common");
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text=getLabel("Common.other.label","Common");
	   resource.add(opt);
   } 



}


var u1=0;
var t=0;
function aaa(Obj){
	t1=Obj.rowIndex;
	t=t1-1;
	
	}
	function deleted()
	{

	var u=document.forms[0].elements[t].value;
	strArray = u.split("|");
	var clinic_code=strArray[0];
	var srl_no=strArray[1];
	var clinic_desc=strArray[2];
	var pract_id=strArray[3];
	var pract_name=strArray[4];
	var day=strArray[5];
	var from_time1=strArray[6];
	var to_time1=strArray[7];
	var type_desc=strArray[8];
	var date=strArray[9];
	var alcncriteria = strArray[10];
	var first_visits_blocked = strArray[11];
	var other_visits_blocked = strArray[12];
	var locntype = strArray[13];
	var resourceclass  = strArray[14];
	var locntype1 =strArray[15];
	var resource1 =strArray[16];
	var from_time=from_time1.substring(10,16);
	var to_time=to_time1.substring(10,16);
	
	var temp="clinic_code="+clinic_code+"&srl_no="+srl_no+"&clinic_desc="+clinic_desc+"&day="+day+"&from_time="+from_time1+"&to_time="+to_time1+"&type_desc="+type_desc+"&date="+date+"&alcn_criteria="+alcncriteria+"&pract_id="+pract_id+"&pract_name="+pract_name+"&first_visits_blocked="+first_visits_blocked+"&other_visits_blocked="+other_visits_blocked+"&resourceclass="+resourceclass+"&locntype="+locntype+"&locntype1="+locntype1+"&resource1="+resource1
	document.location.href="../../eOA/jsp/DeleteBlockAppointment.jsp?"+temp;
	}
	
	async function reasonlookup(obj)
{

		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		

		var sql="SELECT CONTACT_REASON_CODE code, CONTACT_REASON description FROM AM_CONTACT_REASON_lang_vw WHERE BLOCK_SCHEDULE_YN = 'Y' AND EFF_STATUS = 'E' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?)   Order by CONTACT_REASON";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = document.forms[0].reason_for_block1.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup( getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			document.forms[0].reason_for_block1.value=desc;
			document.forms[0].reason_code.value=code;
			
		}else
		{
			document.forms[0].reason_for_block1.value="";
			document.forms[0].reason_code.value="";
		}
}


function calculateSlot()
{

var fromtime= f_query_add_mod.document.top.document.blockappt_form.block_from_time.value;
var totime = f_query_add_mod.document.top.document.blockappt_form.block_to_time.value;
var timeperpatient=f_query_add_mod.document.top.document.blockappt_form.time_per_patient.value;


			var xmlDoc = ""
			var xmlHttp = new XMLHttpRequest()
			xmlStr ="<root><SEARCH steps='blockSlot' fromtime=\""+fromtime+"\" totime=\""+totime+"\" timeperpatient=\""+timeperpatient+"\"/></root>"
			
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			xmlHttp.open("POST","ServerSide.jsp",false)
			xmlHttp.send(xmlDoc)
			responseText=xmlHttp.responseText
			responseText = trimString(responseText)
			
			eval(responseText) 

			
	var total_first_visits_blocked=frames[1].document.bottom.document.results.document.displayresults.total_first_visits_blocked.value;

	var total_other_visits_blocked=frames[1].document.bottom.document.results.document.displayresults.total_other_visits_blocked.value;


	var noslots=frames[1].document.bottom.document.results.document.displayresults.noslots.value;

	var total_Blocked_slot="";

	total_Blocked_slot =parseInt(total_first_visits_blocked)+parseInt(total_other_visits_blocked)+parseInt(noslots);

	var max_patients_per_day=frames[1].document.bottom.document.results.document.displayresults.max_patients_per_day.value;
	
	
	if(total_Blocked_slot==max_patients_per_day)
	{
		f_query_add_mod.document.top.document.blockappt_form.Slot_fully_blocked.value='Y';
	}
	else
	{
		f_query_add_mod.document.top.document.blockappt_form.Slot_fully_blocked.value='N';
	}

	

}


async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	locn_type=document.forms[0].location1.value;
	var care_locn_ind=document.forms[0].location1.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=BLK_APPT_SLOTS",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		var clinic_type=rvalues[3];
		var ident_at_checkin=rvalues[4];
		document.forms[0].b_loc_val.value=desc;
		if(document.forms[0].location.value==code+"%"+clinic_type+"%"+open_to_all_pract_yn+"%"+ident_at_checkin){
		}else{
		document.forms[0].location.value=code+"%"+clinic_type+"%"+open_to_all_pract_yn+"%"+ident_at_checkin;
		enablepr(document.forms[0].location);
		validateTbs();
		}
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		enablepr(document.forms[0].location);
		validateTbs();
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
		var res=document.forms[0].resource;
	 while (res.options.length>0) res.remove(res.options[0]);
	 	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	 res.add(opt);
	 document.forms[0].resource.disabled=true;
	 validateTbs();
	}else{
	open_loc_lookup()
	}
}

function disableFields(){
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	document.forms[0].resource.disabled=true;
}


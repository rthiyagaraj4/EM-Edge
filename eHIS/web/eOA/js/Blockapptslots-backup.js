var flag;   
function create() { 
	f_query_add_mod.location.href ="../../eOA/jsp/BlockapptslotQueryCriteriaMain.jsp?oper_stn_id="+document.forms[0].oper_stn_id.value ;
}
function populate()
{
cleared();
var u=parent.frames[0].document.forms[0].location.value;
strArray = u.split("%");
var clinic_code=strArray[0];
var clinic_type=strArray[1];
var open_to_all_pract_yn=strArray[2];
if( u.length == 0){
var n=parent.frames[0].document.forms[0].pract.options.length;
	for(var i=0;i<n;i++)
	{
	parent.frames[0].document.forms[0].pract.remove("pract");
	}
	var tp =" -------Select------ ";
	var opt=parent.frames[0].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[0].document.forms[0].pract.add(opt);

}
else{
HTMLVal = "<html><BODY><form name='form1' id='form1' method='post' action='../../eOA/jsp/RetriveResults.jsp'><input type='hidden' name='clinic_type' id='clinic_type' value='"+clinic_type+"'> "+
		  "<input type='hidden' name='open_to_all_pract_yn' id='open_to_all_pract_yn' value='"+open_to_all_pract_yn+"'> "+
		  "<input type='hidden' name='clinic_code' id='clinic_code'  value='"+clinic_code+"'>  </form></BODY></HTML>";
parent.parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
parent.parent.frames[2].document.form1.submit();
}
}

function callSchedule()
{
var u=parent.frames[0].document.forms[0].location.value;
strArray = u.split("%");
var clinic_code=strArray[0];
var pract_id=parent.frames[0].document.forms[0].pract.value;
var date=parent.frames[0].document.forms[0].block_date1.value;

var clinic_type=parent.frames[0].document.forms[0].location1.value;
var res_type =parent.frames[0].document.forms[0].resource.value;
var slot_appt_ctrl=parent.frames[0].document.forms[0].slot_appt_ctrl.value;
var visit_limit_rule=parent.frames[0].document.forms[0].visit_limit_rule.value;
var sys_date=parent.frames[0].document.forms[0].sys_date.value;
var sys_time=parent.frames[0].document.forms[0].sys_time.value;

var u1="../../eOA/jsp/BlockAppointmentResultsMain.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+date+"&anchor=set&to_anchor=no&clinic_type="+clinic_type+"&res_type="+res_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;

parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';


parent.frames[1].location.href=u1;
}

function check_mandatory()
{

	
	var fields=new Array();
	if (parent.frames[0].document.getElementById("imgpract").style.visibility!='hidden')
	{
		fields[0]= parent.frames[0].document.forms[0].location;
		fields[1]= parent.frames[0].document.forms[0].resource;
		fields[2]= parent.frames[0].document.forms[0].pract;
		fields[3]= parent.frames[0].document.forms[0].block_date1;
		fields[4]= parent.frames[0].document.forms[0].reason_for_block1;
	}
	 else
		{
		fields[0]= parent.frames[0].document.forms[0].location;
		fields[1]= parent.frames[0].document.forms[0].resource;
		fields[2]= parent.frames[0].document.forms[0].block_date1;
		fields[3]= parent.frames[0].document.forms[0].reason_for_block1;
		}
	if (parent.frames[0].document.getElementById("imgpract").style.visibility!='hidden')
	{
	var names = new Array (	"Location",
							"Resource Class",	
						"Resource Name",
						"Block Date",
						"Reason ");
	}
	 else
		{

		var names = new Array (	"Location","Resource Class",
						"Block Date",
						"Reason ");
		}


	if(checkFields( fields, names, parent.parent.messageFrame))
	{

	   	callSchedule();
	}
	
	parent.frames[0].document.forms[0].b_from.value = "";
	parent.frames[0].document.forms[0].b_to.value = "";
}


function apply()
{
	flag=true;
	var fields=new Array();
    
	
//	if(f_query_add_mod.document.forms[0])
	{

	if(f_query_add_mod.document.forms[0]){
		if(f_query_add_mod.document.forms[0].name=='delete_appt_form')
		{
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}else if (f_query_add_mod.document.forms[0].name=='query_form'){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}else if (f_query_add_mod.document.forms[0].name=='results'){
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
		}
	}else{
	if (f_query_add_mod.document.frames[0].document.getElementById("imgpract").style.visibility=='hidden')
	{
		
		fields[0]= f_query_add_mod.document.frames[0].document.blockappt_form.location;
		fields[1]= f_query_add_mod.document.frames[0].document.blockappt_form.resource;
		fields[2]= f_query_add_mod.document.frames[0].document.blockappt_form.block_date1;
		fields[3]= f_query_add_mod.document.frames[0].document.blockappt_form.b_from;
		fields[4]= f_query_add_mod.document.frames[0].document.blockappt_form.b_to;
		fields[5]= f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block1;
	}
	else
	{
        
		
		fields[0]= f_query_add_mod.document.frames[0].document.blockappt_form.location;
		fields[1]= f_query_add_mod.document.frames[0].document.blockappt_form.resource;
		fields[2]= f_query_add_mod.document.frames[0].document.blockappt_form.pract;
		fields[3]= f_query_add_mod.document.frames[0].document.blockappt_form.block_date1;
		fields[4]= f_query_add_mod.document.frames[0].document.blockappt_form.b_from;
		fields[5]= f_query_add_mod.document.frames[0].document.blockappt_form.b_to;
		fields[6]= f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block1;

	}
	if (f_query_add_mod.document.frames[0].document.getElementById("imgpract").style.visibility=='hidden')
	{
		
	var names = new Array (	"Location","Resource Class",
						"Block Date",
						"Block From Time",
						"Block To Time",
						"Reason "
					);

	}
	else
	{
		
	var names = new Array (	"Location","Resource Class",
						"Resource Name",
						"Block Date",
						"Block From Time",
						"Block To Time",
						"Reason "
					);

	}

	if(checkData( fields, names, messageFrame))
	{
		
		var u1=f_query_add_mod.document.frames[0].document.blockappt_form.location.value;
		strArray3 = u1.split("%");
		var clinic_code1=strArray3[0];

		f_query_add_mod.document.frames[0].document.blockappt_form.block_date.value=f_query_add_mod.document.frames[0].document.blockappt_form.block_date1.value;
		f_query_add_mod.document.frames[0].document.blockappt_form.block_from_time.value=f_query_add_mod.document.frames[0].document.blockappt_form.b_from.value;
		f_query_add_mod.document.frames[0].document.blockappt_form.block_to_time.value=f_query_add_mod.document.frames[0].document.blockappt_form.b_to.value;
		f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block.value=f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block1.value;
		f_query_add_mod.document.frames[0].document.blockappt_form.clinic.value=clinic_code1;
		f_query_add_mod.document.frames[0].document.blockappt_form.practitioner.value=f_query_add_mod.document.frames[0].document.blockappt_form.pract.value;
		f_query_add_mod.document.frames[0].document.blockappt_form.time_per_patient.value=frames[1].document.frames[1].document.frames[0].document.displayresults.time_per_patient.value;
		alert('submit');
		f_query_add_mod.document.frames[0].document.blockappt_form.submit();
	}

	}

	}
//	else
//	{
//		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
//	}
}

function query()
{
f_query_add_mod.location.href ="../../eOA/jsp/queryBlockAppointmentPage.jsp";
}


function deleterecord(){
	 if(f_query_add_mod.document.forms[0]){
		 if(f_query_add_mod.document.forms[0].name=='delete_appt_form'){
			 flag=false;
			 if(confirm(frames[1].getMessage('DELETE_RECORD'))){
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

function reset()
{
	if(f_query_add_mod.document.forms[0])
	{

if (f_query_add_mod.document.forms[0])
{
	f_query_add_mod.document.forms[0].reset();
}
else
{
	
	var lBox=f_query_add_mod.document.frames[0].document.blockappt_form.location; 
	var len=f_query_add_mod.document.frames[0].document.blockappt_form.location.options.length;
    lBox.remove(lBox.options[0]);
    var opt=document.createElement('OPTION');
    
    while(i<= len){
		lBox.remove(lBox.options[i]);
		i+=1;
	}
	opt.value='';
    opt.text='  --Select-- ';
	lBox.add(opt);
	
f_query_add_mod.document.frames[0].document.blockappt_form.block_date1.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.b_from.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.b_to.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block1.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.pract.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.practitioner_name.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.location.value="";
f_query_add_mod.document.frames[0].document.blockappt_form.resource.value="";
f_query_add_mod.frames[0].document.forms[0].pract_butt.disabled=true;
f_query_add_mod.frames[0].document.forms[0].practitioner_name.disabled=true;
f_query_add_mod.frames[0].document.forms[0].resource.disabled=true;
f_query_add_mod.frames[0].document.forms[0].imgpract.style.visibility ='hidden';
f_query_add_mod.document.frames[0].document.blockappt_form.location1.value="";

f_query_add_mod.document.frames[1].document.location.href='../../eCommon/html/blank.html'
}
	}
	else
	{ messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';}
}

function onSuccess() 
{
	if(flag)
	{
/*		var u=f_query_add_mod.document.frames[0].document.forms[0].location.value;
		strArray = u.split("%");
		var clinic_code=strArray[0];
		var pract_id=f_query_add_mod.document.frames[0].document.forms[0].pract.value;
		var date=f_query_add_mod.document.frames[0].document.forms[0].block_date1.value;
		var u1="../../eOA/jsp/BlockAppointmentResultsMain.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+date+"&anchor=set&to_anchor=no";
		f_query_add_mod.document.frames[0].document.blockappt_form.b_from.value="";
		f_query_add_mod.document.frames[0].document.blockappt_form.b_to.value="";
		f_query_add_mod.document.frames[0].document.blockappt_form.reason_for_block1.value="";

		f_query_add_mod.document.frames[1].document.location.href=u1;*/
		reset();
	}
	else
	{
		f_query_add_mod.document.location.href="../../eOA/jsp/BlockapptslotQueryCriteriaMain.jsp?oper_stn_id="+document.forms[0].oper_stn_id.value ;
	}
}



function check_date()
	{

		var ul=blockappt_form.block_date1.value;
		if (ul)
		{

			var stdt = parent.parent.frames[1].frames[0].document.forms[0].sys_date;
			var sysdt = parent.parent.frames[1].frames[0].document.forms[0].block_date1;

			if(stdt.value.length > 0 && sysdt.value.length > 0){
				if (CheckDate(sysdt)){
					fromarray = sysdt.value.split("/");
					toarray = stdt.value.split("/");
					fromarray[1]=fromarray[1]-1;
					toarray[1]=toarray[1]-1;
					var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
					var todt = new Date(toarray[2],toarray[1],toarray[0]);
					if(Date.parse(fromdt) < Date.parse(todt)) {
						alert(getMessage("BLK_DT_VALIDATION","OA"));
						sysdt.focus();
						return false;

					}
				}else{
					sysdt.value='';
				}
			}


			
		}
	}


function checkData( fields, names, messageFrame) {
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) {
		if(trimCheck(fields[i].value)) {
			fields[i].value = trimString(fields[i].value);
		}
		else	errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
	}
	if ( errors.length != 0 ) {
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
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
			document.getElementById("pract").value="";
			document.getElementById("practitioner_name").value="";
		
		  if (check=="X")
			document.getElementById("imgpract").style.visibility='hidden';
		  else
			document.getElementById("imgpract").style.visibility ='visible';
		 if (Obj.value!="")
			{
			document.getElementById("pract_butt").disabled = false
			document.getElementById("practitioner_name").disabled=false
			}
		 else
	      {
			 document.getElementById("pract_butt").disabled = true;
			 document.getElementById("practitioner_name").disabled=true;
			document.getElementById("imgpract").style.visibility ='hidden';
		  }
		}


		function locationreturn(obj)
{
	var n=document.forms[0].location.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].location.remove("clinic");
		
	}
	var locationtype = document.forms[0].all.location1.value;
	
	
	
	document.forms[0].all.resource.value="";
	document.forms[0].all.resource.disabled=true;
	document.forms[0].all.practitioner_name.value="";
	document.forms[0].all.practitioner_name.disabled=true;
	document.forms[0].all.pract_search.disabled=true;
	var opt=document.createElement("OPTION");
	opt.text=" -------Select------ ";
	opt.value="";
	document.forms[0].location.add(opt);

	var oper_stn_id=document.forms[0].oper_stn_id.value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH locn_val=\""+obj.value+"\" oper_stn_id=\""+oper_stn_id+"\" steps='10' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)
document.getElementById("imgpract").style.visibility='hidden';
parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';
	
}

function enablepr(obj)
{
var chk='';
var vlschk="";
vlschk=document.forms[0].identityCheckIn.value;
var si=document.forms[0].location.options.selectedIndex-1;
var obj = document.forms[0].location1.value;
if(obj=='D')
{
	var res=document.forms[0].resource;
	 while (res.options.length>0) res.remove(res.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text='   ---Select---   ';
	 res.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text='Practitioner';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text='Equipment';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text='Room';
	   res.add(opt);
		 /* opt=document.createElement('OPTION');
		 opt.value='B';
		 opt.text='Bed';
		 res.add(opt);*/
		 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text='Other';
	   res.add(opt);
	   document.forms[0].resource.disabled=false;
}else{ 
	   var res=document.forms[0].resource;
	   	   document.forms[0].resource.disabled=false;

	   while(res.options.length>0) res.remove(res.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text='   ---Select---   ';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text='Practitioner';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text='Equipment';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text='Room';
	   res.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text='Other';
	   res.add(opt);
   }

 return obj;
if (si==-1){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 chk=vlschk.substr(si,1);
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
	parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';
}

function validateTbs(){
var clValue=document.forms[0].location.value;

 if (!document.forms[0].practitioner_name.disabled){
document.forms[0].practitioner_name.value="";
document.forms[0].resource.value="";
document.forms[0].practitioner_name.disabled=true;
document.forms[0].pract_search.disabled=true;
}
}
function practValidate(obj){
var clinicCode=document.forms[0].location.value;
var resourceCode=document.forms[0].resource.value;
if(resourceCode=='' || resourceCode=='B')
{
	document.forms[0].practitioner_name.value="";
document.forms[0].pract.value="";
document.forms[0].practitioner_name.disabled=true;
document.forms[0].pract_search.disabled=true;
}else
{
	document.forms[0].practitioner_name.value="";
document.forms[0].pract.value="";
	document.forms[0].practitioner_name.disabled=false;
document.forms[0].pract_search.disabled=false;
}

 	parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';

}
function resourceOnBlur(){
	var selIn=document.forms[0].resource.options.selectedIndex;

	var valIs= document.forms[0].resource.options(selIn).value;
document.getElementById("resourceType").value=valIs;
	parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';

}


	


/* Added by Suman to chk for enterable practlookup */

function callPractSearch(obj,target,resource)
{
var p_resource = resource.value
var practName_FName="";
var practName_FValue="";
var practId_FName="";

practName_FName=target.name;
practName_FValue=target.value;
practId_FName=document.forms[0].practitioner_name.name;

var sql="";
var sql2="";
var facility_id = document.forms[0].facilityid.value;
var locn=document.forms[0].location.value;
var arr= new Array();
arr=locn.split("%");
if (p_resource=='P' )
{
if(arr[2] == 'Y')
	{
sql = "Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty, 	DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner_vw b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id  and a.eff_status ='E' and a.facility_id = '"+facility_id+"' and c.facility_id = a.facility_id and c.clinic_code = '"+arr[0]+"'  and(c.speciality_code = b.primary_speciality_code or c.speciality_code in  (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) or upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))";

sql2 = "Select a.practitioner_id practitioner_id,b.practitioner_name practitioner_name, b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty, 	DECODE(b.job_title,'CC','Chief Consultant', 'CO', 'Consultant','RG',  'Registrar', 'RS', 'Resident', 'ST', 'Specialist', 'SC',  'Sr.Consultant','SR', 'Sr. Resident', 'SP', 'Sr. Specialist', 'TR','Trainee' )job_title,b.gender gender  FROM am_pract_for_facility a, am_practitioner_vw b ,op_clinic c where b.eff_status ='E' and b.practitioner_id = a.practitioner_id and a.eff_status ='E' and a.facility_id = '"+facility_id+"' and c.facility_id = a.facility_id and c.clinic_code = '"+arr[0]+"'  and(c.speciality_code = b.primary_speciality_code or c.speciality_code in  (select speciality_code from am_pract_specialities where facility_id = '"+facility_id+"' and  practitioner_id = b.practitioner_id))  and nvl(c.pract_type,b.pract_type)= b.pract_type and upper(b.pract_type) like upper(nvl(?,b.pract_type)) and upper(b.primary_speciality_code) like upper(nvl(?,b.primary_speciality_code)) and (upper(b.practitioner_id) like upper(nvl(?,b.practitioner_id)) and upper(b.practitioner_name) like upper(nvl(?,b.practitioner_name))) and decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U') like nvl(upper(?),decode(upper(b.gender),'MALE','M','FEMALE','F','UNKNOWN','U')) and upper(nvl(b.job_title,'123')) like upper(nvl(?,nvl(b.job_title,'123')))";


}
else
{

sql="SELECT a.practitioner_id practitioner_id,a.practitioner_full_name practitioner_name,b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','ChiefConsultant','CO','Consultant','RG','Registrar','RS','Resident','ST','Specialist','SC','Sr.Consultant','SR','Sr.Resident','SP','Sr.Specialist','TR','Trainee')job_title,b.gender FROM op_pract_for_clinic_vw a,am_practitioner_vw b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facility_id+"' AND a.resource_class='P' and a.clinic_code='"+arr[0]+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   OR UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name)))   AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')   LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(b.job_title,'123')) LIKE UPPER(NVL(?,NVL(b.job_title,'123')))  AND a.eff_status='E'";


sql2="SELECT a.practitioner_id practitioner_id,a.practitioner_full_name practitioner_name,b.pract_type_desc practitioner_type,b.primary_splty_short_desc primary_specialty,DECODE(b.job_title,'CC','ChiefConsultant','CO','Consultant','RG','Registrar','RS','Resident','ST','Specialist','SC','Sr.Consultant','SR','Sr.Resident','SP','Sr.Specialist','TR','Trainee')job_title,b.gender FROM op_pract_for_clinic_vw a,am_practitioner_vw b WHERE a.practitioner_id=b.practitioner_id AND a.facility_id='"+facility_id+"' AND a.resource_class='P' and a.clinic_code='"+arr[0]+"' AND UPPER(b.pract_type) LIKE UPPER(NVL(?,b.pract_type))AND UPPER(b.primary_speciality_code)  LIKE UPPER(NVL(?,b.primary_speciality_code))  AND (UPPER(a.practitioner_id)LIKE UPPER(NVL(?,a.practitioner_id))   AND UPPER(b.practitioner_name)LIKE UPPER(NVL(?,b.practitioner_name)))   AND DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U')   LIKE NVL(UPPER(?),DECODE(UPPER(b.gender),'MALE','M','FEMALE','F','Unknown','U'))   AND UPPER(NVL(b.job_title,'123')) LIKE UPPER(NVL(?,NVL(b.job_title,'123')))  AND a.eff_status='E'";


}

//var xmlDoc= new ActiveXObject( "Microsoft.XMLDom" ) ;
//var xmlHttp= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
var xmlHttp = new XMLHttpRequest();



xmlStr	="<root><SEARCH " ;
	xmlStr += " practName_FName=\"" +practName_FName + "\"";
	xmlStr += " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr += " practId_FName=\"" + practId_FName + "\"";
	xmlStr += " sql=\"" +escape(sql)+ "\"";
	xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr += " practitioner_type=\"" + "" + "\"";
	xmlStr += " specialty_code=\"" + "" + "\"";
	xmlStr += " job_title=\"" + "" + "\"";
	xmlStr += " gender=\"" + "" + "\"";


	xmlStr +=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);

}
else 
	{if(p_resource=='E' || p_resource=='O'){ // Equipment and others


		sql="select b.practitioner_id code,a.short_desc description from am_resource a,op_pract_for_clinic b where a.resource_id =b.practitioner_id and a.resource_class= '"+p_resource+"' and b.eff_status='E' and b.clinic_code='"+arr[0]+"' and a.Facility_id=b.facility_id and a.Facility_id='"+facility_id+"' and upper(b.practitioner_id) like upper(?) and upper(a.short_desc)  like upper(?) order by a.short_desc";

	//}
	
	}else if(p_resource=='R'){//Room
	
		sql="select Practitioner_id code, practitioner_short_name description from op_pract_for_clinic_vw where clinic_code='"+arr[0]+"' and Facility_id ='"+facility_id+"' and eff_status='E' and resource_class='R' and upper(practitioner_id) like upper(?) and upper(practitioner_short_name)  like upper(?) order by  practitioner_short_name";
	
	}
     
	call_common(sql);
	}


}


function call_common(sql){
	var tit				=  encodeURIComponent(getLabel("Common.resource.label","Common"));
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = document.forms[0].practitioner_name.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" )	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		
		document.forms[0].practitioner_name.value=arr[1];
		document.forms[0].pract.value=arr[0];
	
	}else{
		document.forms[0].practitioner_name.value="";
		document.forms[0].pract.value="";
	}
}


function PractLookupRetVal(retVal,objName)
{
var arr;

if (retVal != null)
		{
			arr=retVal.split("~");
			document.forms[0].pract.value=arr[0];
			document.forms[0].practitioner_name.value=arr[1];
		}
		else
		{
			document.forms[0].pract.value="";
			document.forms[0].practitioner_name.value="";

		}
}



function onblurcheck(obj,target,resource)
{
	if(target.value == "")
	{
		document.forms[0].pract.value ="";
		return;
	}
	callPractSearch(obj,target,resource)
}


/* Pract look up added by suman ends here */

function clearFields()
	{
	var clinic_code=document.forms[0].clinic_code.value;
	var pract_id=document.forms[0].pract_id.value;
	var appt_date=document.forms[0].appt_date.value;
	var clinic_type=document.forms[0].clinic_type.value;
	var res_type=document.forms[0].res_type.value;	
	parent.parent.frames[0].document.forms[0].b_from.value="";
	parent.parent.frames[0].document.forms[0].b_to.value="";

	sys_date=parent.parent.frames[1].frames[0].document.forms[0].document.forms[0].sys_date.value;
	sys_time=parent.parent.frames[1].frames[0].document.forms[0].document.forms[0].sys_time.value;

	visit_limit_rule=parent.parent.frames[1].frames[0].document.forms[0].document.forms[0].visit_limit_rule.value;
	slot_appt_ctrl=parent.parent.frames[1].frames[0].document.forms[0].document.forms[0].slot_appt_ctrl.value;

	parent.frames[0].document.location.href="../../eOA/jsp/BlockAppointmentResults.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+appt_date+"&clinic_type="+clinic_type+"&res_type="+res_type+"&anchor=&to_anchor=&rowNum=0&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;
	
	}


	function doDateCheckAlert(from,to) {
	var fromarray; var toarray;
	var fromdate = from ;
	var todate = to ;
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			fromarray[1]=fromarray[1]-1;
			toarray[1]=toarray[1]-1;

			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);
			if(Date.parse(todt) < Date.parse(fromdt)) {
				return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) { return true; } 
			
			
	}
return true;
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
	function moveNext()
	{
	var len=document.getElementById("results").rows.length;
	var clinic_code=document.forms[0].clinic_code.value;
	var pract_id=document.forms[0].pract_id.value;
	var appt_date=document.forms[0].appt_date.value;

	var clinic_type=document.forms[0].clinic_type.value;
	var res_type=document.forms[0].res_type.value;


	value6= document.getElementById("results").rows(u1).cells(u2).innerText;
	value7=document.getElementById("results").rows(u1).cells(u2+1).innerText;
	//Added on 29/04/2003
	value9=document.forms[0].P_O_TIME_TAB_TYPE.value;
	value11=document.forms[0].elements(u1-1).value;
	
	sys_date=document.forms[0].sys_date.value;
	sys_time=document.forms[0].sys_time.value;

	visit_limit_rule=document.forms[0].visit_limit_rule.value;
	slot_appt_ctrl=document.forms[0].slot_appt_ctrl.value;


	fromtimeharray=sys_time.split(":");
	from_time=value6.split(":");
	to_displayed_time=value7.split(":");
	var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
	var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	var name=document.getElementById("results").rows(u1).cells(u2+2).innerText;
	var i=0;
	var to_displayed=new Date(1,1,1,to_displayed_time[0],to_displayed_time[1],0,0);
	//alert(document.forms[0].elements(u1-3).value)
	if(document.forms[0].elements(u1-1).value == "~")
	{	
		if( doDateCheckAlert(document.forms[0].appt_date.value ,document.forms[0].sys_date.value))
		{
			
			if(value9 == "1")
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
						document.location.href="../../eOA/jsp/BlockAppointmentResults.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+appt_date+"&anchor=reset&to_anchor=yes&rowNum="+u1+"&res_type="+res_type+"&clinic_type="+clinic_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;

					}
					else
					{
						alert(getMessage("CANNOT_BLOCK_SLOT","OA"));
					}
				}
			}
			if(value9 == "2" || value9 == "3")
			{
				if(( Date.parse(to_displayed) < Date.parse(fromhtm) )  )
				{
					alert(getMessage('ST_TM_LESS_SY_TM','OA'));
				}
			}
		}
		else
		{
			if(name.length == 1)
			{
				parent.parent.frames[0].document.forms[0].b_from.value=value6;
				document.location.href="../../eOA/jsp/BlockAppointmentResults.jsp?clinic_code="+clinic_code+"&practitioner_id="+pract_id+"&Date="+appt_date+"&anchor=reset&to_anchor=yes&rowNum="+u1+"&res_type="+res_type+"&clinic_type="+clinic_type+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&sys_date="+sys_date+"&sys_time="+sys_time;

			}
			else
			{
				alert(getMessage("CANNOT_BLOCK_SLOT","OA"));
			}
		
		}
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
	 opt.text='   ---Select---   ';
	 resource.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text='Practitioner';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text='Equipment';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text='Room';
	   resource.add(opt);
	 opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text='Other';
	   resource.add(opt);

   }
   else{
	   while(resource.options.length>0) resource.remove(resource.options[0]);
	   opt=document.createElement('OPTION');
	   opt.value='';
	   opt.text='   ---Select---   ';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='P';
	   opt.text='Practitioner';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='E';
	   opt.text='Equipment';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='R';
	   opt.text='Room';
	   resource.add(opt);
	   opt=document.createElement('OPTION');
	   opt.value='O';
	   opt.text='Other';
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
	var u=document.forms[0].elements(t).value;
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
	
	


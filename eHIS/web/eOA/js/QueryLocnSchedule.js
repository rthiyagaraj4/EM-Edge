function query() {
  f_query_search.location.href = '../../eOA/jsp/QueryLocnSchedule.jsp';
  frames[2].location.href = '../../eCommon/html/blank.html';
  frames[3].location.href = '../../eCommon/html/blank.html';
}

function reset() {
	frames[1].document.forms[0].reset() ;
	frames[1].document.forms[0].location.value="";
    frames[1].document.forms[0].b_loc_val.disabled=true;
	frames[1].document.forms[0].b_loc_search.disabled=true;
	frames[1].document.forms[0].b_loc_val.value="";
	frames[1].document.forms[0].select.disabled=false;
	frames[1].document.forms[0].resource.value="";
	frames[1].document.forms[0].resource.disabled=true;
	frames[1].document.forms[0].practitioner_name.value="";
	frames[1].document.forms[0].practitioner_name.disabled=true;
	frames[1].document.forms[0].search_pract.disabled=true;
	frames[2].location.href = '../../eCommon/html/blank.html';
        frames[3].location.href = '../../eCommon/html/blank.html';
		/*var lBox=frames[1].document.forms[0].location; 
	var len=frames[1].document.forms[0].location.options.length;
    lBox.remove(lBox.options[0]);
    var opt=document.createElement('OPTION');
    
    while(i<= len){
		lBox.remove(lBox.options[i]);
		i+=1;
	}
	opt.value='';
    opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
	lBox.add(opt);*/

}

function select_click() {
	
	var resource_type	=document.query_search_form.resource.value;						
	var care_locn1	=document.query_search_form.location1.value;
	if(!(care_locn1==null) || !(care_locn1==''))
	{
	care_locn=care_locn1.substring(2,3);
	care_locn1=care_locn1.split("|");
	care_locn=care_locn1[0];
	}

	var fields = new Array ( document.query_search_form.b_loc_val, document.query_search_form.speciality);

	var names = new Array (getLabel("Common.Location.label","Common"),getLabel("Common.speciality.label","Common"));



	if(!parent.frames[1].checkFields( fields, names, parent.frames[4])){
       parent.frames[2].location.href ='../../eCommon/html/blank.html';
	}else{


		var facilityId=document.forms[0].facilityId.value;
		var clinic_code = document.query_search_form.location.value;
		clinic_code  = clinic_code.substring(2,clinic_code.length);
		var speciality = document.query_search_form.speciality.value;
		var practitioner_id = document.query_search_form.practitioner.value;
		var clinic_day_no = document.query_search_form.day.value;
		var from_date = document.query_search_form.from_date.value;
		var to_date = document.query_search_form.to_date.value;
		document.query_search_form.select.disabled=true;



		parent.frames[3].location.href = '../../eOA/jsp/QueryLocnScheduleFooter.jsp';
		parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";

		parent.frames[2].location.href = "../../eOA/jsp/QueryLocnScheduleResult.jsp?clinic_code="+clinic_code+"&care_locn="+care_locn+"&resource_type="+resource_type+"&practitioner_id="+practitioner_id+"&clinic_day_no="+clinic_day_no+"&from_date="+from_date+"&to_date="+to_date+"&facilityId="+facilityId+"&speciality="+speciality;
	}
 }

     function clear_click() {
	   document.forms[0].select.disabled=false;
       parent.frames[2].location.href ='../../eCommon/html/blank.html';
       parent.frames[3].location.href ='../../eCommon/html/blank.html';
     }
     function ena_pract(Obj)
		{         
	      document.getElementById('practitioner_name').value="";
		  document.getElementById('practitioner').value = "";
		}   
        function doDateChecked(obj,from,to) {
		  if (CheckDate(obj)){
			 
		  var fromarray; var toarray;
          	var fromdate = from.value ;
          	var todate = to.value ;
          	if(fromdate.length > 0 && todate.length > 0 ) {
          			fromarray = fromdate.split("/");
          			toarray = todate.split("/");
          			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
          			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
          			if(Date.parse(todt) < Date.parse(fromdt)) {
						obj.value='';
                        alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));
                        to.focus();
						return false;
          			}
          			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
          	}	
		  }
		// return true;
}

function frameClear(){
	obj=event.target;
	 //document.forms[0].location.selectedInex=0;
 	 document.forms[0].b_loc_val.value="";
	 document.forms[0].location.value="";
	 document.forms[0].practitioner.value="";
	 document.forms[0].resource.disabled=true;
	 document.forms[0].resource.selectedIndex=0;
	if(document.forms[0].resource.disabled==false) {
		document.forms[0].resource.selectedIndex=0;
		
	}
	if (document.forms[0].practitioner_name.disabled==false) {
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}
	document.forms[0].day.selectedIndex=0;
	document.forms[0].from_date.value="";
	document.forms[0].to_date.value="";

	var care_locn1=document.forms[0].location1.value
	care_locn1=care_locn1.split("|");
	var locations=care_locn1[0];

	parent.frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[3].location.href = '../../eCommon/html/blank.html';

	
}
function changeDay()
{
parent.frames[2].location.href = '../../eCommon/html/blank.html';
parent.frames[3].location.href = '../../eCommon/html/blank.html';
}
  
function locationreturn(obj) {

    if(obj.value==null || obj.value=="")
		{
			document.getElementById('b_loc_val').disabled=true;
			document.getElementById('b_loc_search').disabled=true;
	    }
	else{
			document.getElementById('b_loc_val').disabled=false;
			document.getElementById('b_loc_search').disabled=false;
	    }


	/*var n=document.forms[0].location.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].location.remove("clinic");
		
	}
	var care_locn1=document.forms[0].location1.value
	care_locn1=care_locn1.split("|");
	var care_locn=care_locn1[1];
	
	var locations=care_locn1[0];
	
	document.forms[0].all.resource.value="";
	document.forms[0].all.practitioner_name.value="";
	document.forms[0].all.practitioner_name.disabled=true;
	document.forms[0].all.search_pract.disabled=true;
	var opt=document.createElement("OPTION");
	opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
	opt.value="";
	document.forms[0].location.add(opt);
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH locn_val=\""+locations+"\" steps='8' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/
}  
function enablepr(obj)
{

	if (obj.value !='')
		{
		  if(document.forms[0].location.value !='' && document.forms[0].location.value !=null)
			  { 
				document.forms[0].resource.disabled = false;
			  }
		}
	else{
			  document.forms[0].resource.disabled = true;
		}
/*var chk='';
var si=document.forms[0].location.options.selectedIndex-1;*/
parent.frames[2].location.href = '../../eCommon/html/blank.html';
parent.frames[3].location.href = '../../eCommon/html/blank.html';

document.getElementById('location_code1').value= document.forms[0].location.value;

/*if (si==-1){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 document.forms[0].resource.disabled= false;
}*/
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


function practValidate(){
	parent.frames[2].location.href = '../../eCommon/html/blank.html';
	parent.frames[3].location.href = '../../eCommon/html/blank.html';

	document.getElementById('resourceType1').value=document.getElementById('resource').value;

var clinicCode=document.forms[0].location.value;
var resourceCode=document.forms[0].resource.value;
if (resourceCode !=null && resourceCode!="" && resourceCode!='B'){
if(document.forms[0].location.value !='' && document.forms[0].location.value !=null){ 
document.forms[0].practitioner_name.value="";
document.forms[0].practitioner.value="";
document.forms[0].practitioner_name.disabled=false;
document.forms[0].search_pract.disabled=false;
}}
else
{
document.forms[0].practitioner_name.value="";
document.forms[0].practitioner.value="";
document.forms[0].practitioner_name.disabled=true;
document.forms[0].search_pract.disabled=true;
 }
}
function resourceOnBlur(){
	var selIn=document.forms[0].resource.options.selectedIndex;

	var valIs= document.forms[0].resource.options[selIn].value;
document.getElementById('resourceType1').value=valIs;

}


function show_allocation_details(alcn_criteria,clinic_code,practioner_id,appt_date,time_tab_type){
var dialogHeight= "13" ;
var dialogWidth	= "32" ;
var dialogTop = "232" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
window.showModalDialog("../../eOA/jsp/SchAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id+"&time_tab_type="+time_tab_type+"&appt_date="+appt_date,arguments,features);

}



function ValidateDate_from(from,to)
{
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}
		else{
	
if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
		}
}
}


function ValidateDate_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}
		else{
	
if(from.value!="" && to.value!="" )
		{
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}
			else
				return true;
		}
		}
}
}


function chkmangif()
{
		document.getElementById('b_loc_val').disabled=true;
		document.getElementById('b_loc_search').disabled=true;
		document.getElementById('location1').disabled=true;
}

async function open_loc_lookup(){

	var location1=document.forms[0].location1.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[0];
	var care_locn_ind=location1[1];
	var speciality_code=document.forms[0].speciality.value;
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&location_val="+encodeURIComponent(location_val)+"&function_id=QRY_SCH",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=open_all_pract_yn+"$"+code;
		enablepr(document.forms[0].location);
		validateTbs();
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		enablepr(document.forms[0].location);
		validateTbs();
	}
}

function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			document.getElementById('resource').disabled=true;
	}else{
	open_loc_lookup()
	}
}


function locn_change(){
	if(document.getElementById('speciality').value!=''){
	document.getElementById('location1').disabled=false;
	var opt=document.forms[0].location1;
	opt.text = '-------'+getLabel("Common.defaultSelect.label","Common")+'-------';
	opt.value='';
	locationreturn(document.forms[0].location1);
	frameClear();
	}else{		
	var opt=document.forms[0].location1;
	opt.text = '-------'+getLabel("Common.defaultSelect.label","Common")+'-------';
	opt.value='';
	locationreturn(document.forms[0].location1);
	frameClear();
	document.getElementById('location1').disabled=true;
	}
}

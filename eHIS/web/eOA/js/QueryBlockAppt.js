function query() {
  f_query_search.location.href = '../../eOA/jsp/QueryBlockAppt.jsp';
  frames[2].location.href = '../../eCommon/html/blank.html';
  frames[3].location.href = '../../eCommon/html/blank.html';
}

function reset() {
	 parent.frames[2].frames[1].document.location.href="../../eOA/jsp/QueryBlockAppt.jsp";
	frames[2].location.href = '../../eCommon/html/blank.html';
    frames[3].location.href = '../../eCommon/html/blank.html';

}


    /*    function doDateChecked(obj,from,to) {
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
}
*/
	 function select_click() {
//commented by N Munisekhar against JD-CRF-0185 [IN041355]
		 /*
       var clinic_code = document.query_search_form.location.value;

	   	var fields = new Array ( parent.frames[1].document.forms[0].location,parent.frames[1].document.forms[0].speciality);

		var names = new Array ( getLabel("Common.Location.label","Common"),getLabel("Common.speciality.label","Common"));
		
		if(!parent.frames[1].checkFields( fields, names, parent.frames[4])){
		}*/
       //added by N Munisekhar against JD-CRF-0185 [IN041355]
		 var clinic_code = document.query_search_form.location.value
		 var flag =checkNull();
		 if(flag==true){
		   clinic_code  = clinic_code .substring(2,clinic_code.length)
		   var practitioner_id = document.query_search_form.practitioner.value;
		   var speciality = document.query_search_form.speciality.value;
		   var clinic_day_no = document.query_search_form.day.value;
		   var from_date = document.query_search_form.from_date.value;
		   var to_date = document.query_search_form.to_date.value;
			document.forms[0].select.disabled=true;	
			var locn_type=document.forms[0].location1.value;
			var facilityId=document.forms[0].facilityId.value;
			parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";
		   var resource_class=document.forms[0].resource.value;
		   parent.frames[2].location.href = "../../eOA/jsp/QueryBlockApptResult.jsp?clinic_code="+clinic_code+"&practitioner_id="+practitioner_id+"&clinic_day_no="+clinic_day_no+"&from_date="+from_date+"&to_date="+to_date+"&locn_type="+locn_type+"&resource_class="+resource_class+"&facilityId="+facilityId+"&speciality="+speciality;
		}
     }
    //added by N Munisekhar against JD-CRF-0185 [IN041355]
	 function checkNull(){
	 	var flag;
	  	var error="";
	  	var speciality =parent.frames[1].document.forms[0].speciality.value;
	  	var spe_label=getLabel("Common.speciality.label","Common");
	  	var location=parent.frames[1].document.forms[0].location.value;
		var practitioner=document.query_search_form.practitioner.value;
	  	if(speciality=="") {
	  		flag=false;
	  		error+= getMessage("SHOULD_NOT_BE_BLANK","Common").replace("{1}",spe_label)+"<br>";
	  	}
	  	if(location=="" && practitioner=="" ) {
	  		flag=false;
	  		error+= getMessage("LOCATION_RESOURCE_SHOULD_NOT_BE_BLANK","Common")+"<br>";
	  	}
	  	parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	 	if(flag==false) return false; else return true;
	  }
     function ena_pract(Obj)
		{         
	      document.getElementById('practitioner_name').value="";
		  document.getElementById('practitioner').value = "";
		}   
     function clear_click() {
       document.forms[0].select.disabled=false;
	   parent.frames[2].location.href='../../eCommon/html/blank.html' ;

     }

 function locationreturn(obj) {
	
	    parent.frames[2].location.href='../../eCommon/html/blank.html' ;
	/*var n=document.forms[0].location.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].location.remove("clinic");
		
	}*/
	if(obj.value==null||obj.value==""){
	document.getElementById('b_loc_val').value="";
	document.forms[0].location.value="";
	//document.forms[0].all.practitioner_name.value="";
	document.getElementById('b_loc_val').disabled=true;
	document.getElementById('b_loc_search').disabled=true;
     //commented by N Munisekhar against JD-CRF-0185 [IN041355]
	//document.forms[0].all.resource.value="";
	//document.forms[0].all.resource.disabled=true;
	//document.forms[0].all.practitioner_name.value="";
	//document.forms[0].all.practitioner_name.disabled=true;
	//document.forms[0].all.search_pract.disabled=true;
	}else{
	document.forms[0].location.value="";
	document.getElementById('b_loc_val').value="";
	document.getElementById('b_loc_val').disabled=false;
	document.getElementById('b_loc_search').disabled=false;
    //commented by N Munisekhar against JD-CRF-0185 [IN041355]
	//document.forms[0].all.resource.value="";
	//document.forms[0].all.resource.disabled=true;
	//document.forms[0].all.practitioner_name.value="";
	//document.forms[0].all.practitioner_name.disabled=true;
	//document.forms[0].all.search_pract.disabled=true;
	}
	/*var opt=document.createElement("OPTION");
	opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
	opt.value="";
	document.forms[0].location.add(opt);
	
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH locn_val=\""+obj.value+"\" steps='9' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/

}  
function enablepr(obj)
{
var chk='';
//var si=document.forms[0].location.options.selectedIndex-1;

document.getElementById('location_code1').value= document.forms[0].location.value;

/*if (si==-1){
 chk='';
 document.forms[0].resource.disabled = true;
 }
else{
 document.forms[0].resource.disabled= false;
}*/
if(obj.value==null||obj.value==""){
	document.forms[0].resource.disabled = true;
}else{
document.forms[0].resource.disabled= false;
}
}

function validateTbs(){
var clValue=document.forms[0].location.value;

if(document.forms[0].location.value==''){
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
}

//commented by N Munisekhar against JD-CRF-0185 [IN041355]

 //if (!document.forms[0].practitioner_name.disabled){
	//document.forms[0].practitioner_name.value="";
	//document.forms[0].resource.value="";
	//document.forms[0].practitioner_name.disabled=true;
	//document.forms[0].search_pract.disabled=true;
//}
}


function practValidate(){
//var clinicCode=document.forms[0].location.value;
var resourceCode=document.forms[0].resource.value;

document.getElementById('resourceType1').value=document.getElementById('resource').value;

if (resourceCode !=null && resourceCode!="" && resourceCode !='B'){

document.forms[0].practitioner_name.value="";
document.forms[0].practitioner.value="";
document.forms[0].practitioner_name.disabled=false;
document.forms[0].search_pract.disabled=false;
}
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


async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].location1.value;
	var care_locn_ind=document.forms[0].location1.value;
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var speciality_code=document.forms[0].speciality.value;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&speciality_code="+speciality_code+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=QRY_BLK_APPT",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_to_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=open_to_all_pract_yn+"$"+code;
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
		document.forms[0].location.value="";
		//enablepr(document.forms[0].location);
		validateTbs();
	}else{
	open_loc_lookup()
	}
}

function disableFields(){
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	document.forms[0].location1.disabled=true;
}

function locn_change(){
	if(document.forms[0].speciality.value!=''){
		document.forms[0].location1.disabled=false;
		document.forms[0].resource.disabled=false;
		var opt=document.forms[0].location1;
		opt.text = '--------'+getLabel("Common.defaultSelect.label","Common")+'--------';
		opt.value='';
		locationreturn(document.forms[0].location1);
	}else{		
		var opt=document.forms[0].location1;
		opt.text = '--------'+getLabel("Common.defaultSelect.label","Common")+'--------';
		opt.value='';
		locationreturn(document.forms[0].location1);
		document.forms[0].location1.disabled=true;
		document.forms[0].location.value='';
		document.forms[0].resource.value='';
		document.forms[0].resource.disabled=true;
		practValidate()
	}

}

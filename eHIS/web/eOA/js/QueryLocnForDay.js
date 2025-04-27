function query()
{
	frame1.location.href = '../../eOA/jsp/QueryLocnForDayCriteria.jsp';
	frame2.location.href 	= '../../eCommon/html/blank.html' ;
}

function callResult()
{
	dayno		= 	parent.frames[1].document.forms[0].bday.value ;
	loccode		=	parent.frames[1].document.forms[0].blocation.value ;
	var care_locn1		=	parent.frames[1].document.forms[0].locationType.value ;
	var speciality		=	parent.frames[1].document.forms[0].speciality.value ;
	
	if(!(care_locn1==null) || !(care_locn1=='')){
	care_locn=care_locn1.substring(2,3);
	
	}
	
	var fields = new Array (parent.frames[1].document.forms[0].b_loc_val,parent.frames[1].document.forms[0].speciality);

	var names = new Array ( getLabel("Common.Location.label","Common"),getLabel("Common.speciality.label","Common"));



	if(!parent.frames[1].checkFields( fields, names, parent.frames[3]))
	{
		parent.frame2.location.href = '../../eCommon/html/blank.html' ;
	}
	else{

	
		var resource_type		=	parent.frames[1].document.forms[0].resource.value ;
		loccode = loccode.substring(2,loccode.length)
		practcode	=	parent.frames[1].document.forms[0].practitioner.value ;
		
		parent.frames[1].document.forms[0].select.disabled=true;
		parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";


		parent.frame2.location.href = '../../eOA/jsp/QueryLocnForDayResult.jsp?dayno='+dayno+"&loccode="+loccode+"&resource_type="+resource_type+"&care_locn="+care_locn+"&practcode="+practcode+"&speciality="+speciality ;
	}
}

function reset()
{
	
	 parent.frames[2].frames[1].document.location.href="../../eOA/jsp/QueryLocnForDayCriteria.jsp "
	//frames[2].location.href 	= '../../eCommon/html/blank.html' ;
	parent.frames[2].document.location.href="../../eCommon/html/blank.html "
}

function clearAll() {
	parent.frames[1].document.forms[0].select.disabled=false;
    parent.frames[2].document.location.href="../../eCommon/html/blank.html "
}

function chkmangif()
	{
		document.getElementById('b_loc_val').disabled=true;
		document.getElementById('b_loc_search').disabled=true;
		document.getElementById('locationType').disabled=true;
	}

function populateLocations(obj){

	if(obj.value==null || obj.value=="")
		{
		document.getElementById('b_loc_val').disabled=true;
		document.getElementById('b_loc_search').disabled=true;
	    }
	else{
		document.getElementById('b_loc_val').disabled=false;
		document.getElementById('b_loc_search').disabled=false;
	    }
	/*var locationType= obj;
	var locnValue1=locationType.options(locationType.options.selectedIndex).value;
	locnValue1=locnValue1.split("|");
	var locnValue=locnValue1[0];
	var care_locn=locnValue1[1];

	if (obj.value!=''){
	
	var HTMLVal="<html><body onKeyDown = 'lockKey()'><form name='locationManForm' id='locationManForm' method='post' action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='from' id='from' value='LocationForADay'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+locnValue+"'></form></body></html>"
	parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.messageFrame.document.locationManForm.submit();
	}
	else{
	 obj1=document.forms[0].blocation;
	 var len =obj1.options.length;
	  while (len-- >= 0) obj1.remove(obj1.options[0]);
	 opt=document.createElement('OPTION');
	 opt.value='';
	 opt.text="-----------------------"+getLabel("Common.defaultSelect.label","Common")+"-----------------------";
	 obj1.add(opt);
	}*/
	
}


		function chgbuttonclr()
		{
			document.getElementById('select').style.background="navy" ;
			document.getElementById('select').style.color="white" ;
			document.getElementById('select').style.fontWeight="700" ;
			document.getElementById('select').style.borderStyle="solid" ;

			document.getElementById('clear').style.background="navy" ;
			document.getElementById('clear').style.color="white" ;
			document.getElementById('clear').style.fontWeight="700" ;
			document.getElementById('clear').style.borderStyle="solid" ;
		}




function onChangeEvents(){
 obj= document.forms[0].blocation;
 document.forms[0].practitioner_name.value='';
 document.forms[0].practitioner.value='';
 document.forms[0].resource.selectedIndex=0;
 document.forms[0].bday.selectedIndex=0;
 document.forms[0].practitioner_name.disabled=true;
 document.forms[0].search_pract.disabled=true;
 parent.frame2.location.href 	= '../../eCommon/html/blank.html' ;

 document.getElementById('location_code1').value= document.forms[0].blocation.value;
 if (obj.value!=''){
    document.forms[0].resource.disabled=false;
 }
 else 
	{
	  document.forms[0].resource.disabled=true;
	}
 }

function ena_pract(){
	obj=document.forms[0].blocation;
	document.forms[0].practitioner_name.value="";
	document.getElementById('practitioner').value = "";

	document.getElementById('resourceType1').value=document.getElementById('resource').value;
	

	if (obj.value !=''){
	
		if(document.forms[0].blocation.value !='' && document.forms[0].blocation.value !=null){ 
		
	document.forms[0].practitioner_name.disabled=false;
	document.forms[0].search_pract.disabled=false;
	}
	}
	else{
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	}
	if (obj.value =='B'){
	document.forms[0].practitioner_name.disabled=true;
	document.forms[0].search_pract.disabled=true;
	}
  document.forms[0].bday.selectedIndex=0;
  parent.frame2.location.href 	= '../../eCommon/html/blank.html' ;
}
function frameClear(){
	obj=event.target;
	 document.forms[0].b_loc_val.value="";
	 document.forms[0].practitioner.value="";
	 document.forms[0].resource.selectedIndex=0;
	if(document.forms[0].resource.disabled==false) {
		document.forms[0].resource.selectedIndex=0;
		
		
	}
	if (document.forms[0].practitioner_name.disabled==false)
	{
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
	}
	var day=document.forms[0].locationType.value
	day1=day.split("|");
	day1=day1[1];

	document.forms[0].bday.selectedIndex=0;
	parent.frame2.location.href = '../../eCommon/html/blank.html';

	
}
function clearDaySel(){
	parent.frame2.location.href 	= '../../eCommon/html/blank.html' ;
	document.forms[0].bday.selectedIndex=0;
}
function clearFrame2(){
parent.frame2.location.href 	= '../../eCommon/html/blank.html' ;
}
/****************PRACTITIONERS LOOKUP ENDS HERE*****************/


function show_allocation_details(alcn_criteria,CARE_LOCN2,resource_type,srl_no, day_no, clinic_code, practioner_id)
{
var dialogHeight= "13" ;
var dialogWidth	= "32" ;
var dialogTop = "232" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
window.showModalDialog("../../eOA/jsp/SchTTAllocationdetailsFrame.jsp?alcn_criteria="+alcn_criteria+"&CARE_LOCN2="+CARE_LOCN2+"&resource_type="+resource_type+"&srl_no="+srl_no+"&day_no="+day_no+"&clinic_code="+clinic_code+"&practioner_id="+practioner_id,arguments,features);
}


async function open_loc_lookup(){
	//alert(document.forms[0].speciality.value)

	var location1=document.forms[0].locationType.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[1];
	var care_locn_ind=location1[0];
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	var speciality_code=document.forms[0].speciality.value;
	//var dialogWidth	= "60" ;
	
	var dialogTop = "10px" ;
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&speciality_code="+speciality_code+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=CLINICS_FOR_DAY",arguments,features);
 
	if(retVal!=null){
	var rvalues=retVal.split("~");
	var code=rvalues[0];
	var desc=rvalues[1];
	var open_all_pract_yn=rvalues[2];
	document.forms[0].b_loc_val.value=desc;
	document.forms[0].blocation.value=open_all_pract_yn+"$"+code;
	ena_pract(document.forms[0].blocation);
	onChangeEvents();
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].blocation.value="";
		ena_pract(document.forms[0].blocation);
		onChangeEvents();

	}
}

function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
	}else{
	open_loc_lookup()
	}
}

function locn_change(){
	if(document.getElementById('speciality').value!=''){
	document.getElementById('locationType').disabled=false;
	var opt=document.forms[0].locationType;
	opt.text = '------'+getLabel("Common.defaultSelect.label","Common")+'------';
	opt.value='';
	populateLocations(document.forms[0].locationType);
	frameClear();
	}else{
		var opt=document.forms[0].locationType;
		opt.text = '------'+getLabel("Common.defaultSelect.label","Common")+'------';
		opt.value='';
		populateLocations(document.forms[0].locationType);
		frameClear();
		document.getElementById('locationType').disabled=true;
	}
}


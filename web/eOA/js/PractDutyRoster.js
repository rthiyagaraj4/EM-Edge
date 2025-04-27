var selected=false;
var flag="";
var flag1="";

function create() {
	flag = "create";
	f_query_add_mod.location.href = '../../eOA/jsp/PaintPractDutyRoster.jsp?oper_stn_id='+document.getElementById('oper').value ;
}

function query() {
	flag = "query";
	flag1 ="query1";
	f_query_add_mod.location.href ='../../eOA/jsp/PaintPractDutyRosterQuery.jsp?oper_stn_id='+document.getElementById('oper').value ;
}

function deleterecord(){	

	var function_name ="";
	if(parent.frames[2].frames[1].document.PractDutyRoster_form){
	

		if(parent.frames[1].frames[1]){
			

			function_name=parent.frames[2].frames[1].document.PractDutyRoster_form.function_name.value;
		}else{
			function_name=parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.function_name.value;
		}


		if(function_name== "delete"){
			if(confirm(frames[1].getMessage('DELETE_RECORD','Common'))){

				parent.frames[2].frames[1].document.PractDutyRoster_form.onduty_date.value=parent.frames[2].frames[1].document.PractDutyRoster_form.onduty_date1.value;

				

				parent.frames[2].frames[1].document.PractDutyRoster_form.submit();
				parent.frames[1].frames[1].location.href="../../eCommon/html/blank.html";
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


function apply(){
	var fields=new Array();
	if(flag=="create"){
		var checkpract = "";
		var names = "";
		if (parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.function_name.value == "insert"){
			var locnval = parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location.value;
			if(!(locnval == null || locnval == "")){
				var arrval = locnval.split("|");
				checkpract = arrval[3];
				if(checkpract == "P"){
					fields[0]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location1;
					fields[1]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location;
					fields[2]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.resource;
					fields[3]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.practitioner;
					fields[4]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_from;
					fields[5]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_to;

					names = new Array (getLabel("Common.locationtype.label","Common"),
							getLabel("Common.Location.label","Common"),
							getLabel("Common.resourcetype.label","Common"),
							getLabel("Common.resource.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common")
						);
				}else{
					fields[0]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location1;
					fields[1]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location;
					fields[2]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.resource;
					fields[3]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.practitioner;
					fields[4]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_from;
					fields[5]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_to;

					names = new Array (getLabel("Common.locationtype.label","Common"),
							getLabel("Common.Location.label","Common"),
							getLabel("Common.resourcetype.label","Common"),
							getLabel("Common.resource.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common")
						);
				}
			}else{
				fields[0]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location1;
				fields[1]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.location;
				fields[2]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.resource;
				fields[3]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.practitioner;
				fields[4]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_from;
				fields[5]= parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.eff_to;

				names = new Array (getLabel("Common.locationtype.label","Common"),
							getLabel("Common.Location.label","Common"),
							getLabel("Common.resourcetype.label","Common"),
							getLabel("Common.resource.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common")
					);
			}
		}
		if(parent.frames[2].frames[1].frames[0].checkFields( fields, names, messageFrame)){		
			/*Added by S.Sathish for IN020568 on Thursday, April 08, 2010 starts here*/
			if(parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.roster_defined.value == "N"){
				var m=getMessage('ROSTER_NOT_EXISTS','OA');					
				frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+m;
				frames[1].frames[1].location.href="../../eCommon/html/blank.html";	
				return false;
			}
			/*Ends Here*/
			if(parent.frames[2].frames[1].frames[0].document.PractDutyRoster_form.checkdtlframe.value == "YES"){
				var n = parent.frames[2].frames[1].frames[1].document.generate_date.noofrec.value;
				var dat = "";
				for(var i=0; i<n; i++){
					if(parent.frames[2].frames[1].frames[1].document.generate_date.elements[i].checked ==true){
						dat += parent.frames[2].frames[1].frames[1].document.generate_date.elements[i].value + "|";
					}
				}
				parent.frames[2].frames[1].frames[1].document.generate_date.on_duty_date.value = dat;
				var msg=parent.frames[2].frames[1].frames[0].getMessage("NO_RECORD_INSERTION","OA");
				if(parent.frames[2].frames[1].frames[1].document.generate_date.on_duty_date.value == '')
					parent.frames[2].frames[2].location.href = '../../eCommon/jsp/error.jsp?err_num='+msg+'&err_value=0' ;
				else
					parent.frames[2].frames[1].frames[1].document.generate_date.submit();
			}else{
				alert(getMessage('ROST_DATES_SEL','OA'));
				//flag="";
				parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
		}
	}else{
	  flag="";
	  parent.frames[2].frames[2].location.href="../../eCommon/jsp/error.jsp?err_num=";
	}	
}// function

function reset() {
	if(flag!="query"){
		if(parent.frames[2].frames[1].location.href.indexOf('blank.html') == -1) //Added by S.Sathish for IN020568 on Thursday, April 08, 2010
		if(parent.frames[2].frames[1].frames[0].name == "summary"){
			f_query_add_mod.location.href = '../../eOA/jsp/PaintPractDutyRoster.jsp?oper_stn_id='+document.getElementById('oper').value ;
		}else if(parent.frames[2].frames[1].location.href.indexOf('Query') == -1){//Added by S.Sathish for IN020568 on Thursday, April 08, 2010
			frames[1].frames[1].frames[0].document.forms[0].reset();
		}
	}else{
		if(frames[1].document.forms[0]){
		}else{
			if(frames[1].frames[0].document.forms[0]){
				if(frames[1].frames[0].document.forms[0].name =="query_form"){
					f_query_add_mod.location.href ='../../eOA/jsp/PaintPractDutyRosterQuery.jsp?oper_stn_id='+document.getElementById('oper').value ;
				}
			}
		}
	}
}

function onSuccess(){
	flag = "create";
	f_query_add_mod.location.href = '../../eOA/jsp/PaintPractDutyRoster.jsp?oper_stn_id='+document.getElementById('oper').value ;
}

function ClearDetail1(){
	parent.frames[1].location.href = '../../eCommon/html/blank.html' ;
	var err_num=null;
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
	document.forms[0].practitioner_name.disabled = true;
	document.forms[0].practitioner_name.value ='';
	document.forms[0].location.value = '';
	document.forms[0].resource.value = '';
	document.forms[0].resource.disabled=true;
	document.forms[0].search_pract.disabled=true;
	if (document.getElementById('roster'))	{	
		document.getElementById('roster').innerText='';
		document.getElementById('roster1').innerText='';
	}
	document.forms[0].resource.value = '';
	document.forms[0].resource.disabled=true;
}
	
function Poplocntype(pract,practitioner_name){
	var carelocn="";
	var practitionercode="";
	var locn_code = document.PractDutyRoster_form.location.value;
	var resource1 = document.PractDutyRoster_form.resource.value;
	if(!(locn_code == null || locn_code == "")){
		var arrval2 = locn_code.split("|");
		var clinic_code1 = arrval2[0];
	}
	var locations=document.PractDutyRoster_form.location1.value;
	if(!(locations == null || locations == "")){
		var arrval1 = locations.split("|");
		var clinictype1 = arrval1[0];
		carelocn = arrval1[1];
	}
	document.forms[0].Select_button.disabled=false;		
	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_code1=\""+clinic_code1+"\" resource1=\""+resource1+"\" carelocn=\""+carelocn+"\" practitionercode=\""+pract+"\" steps='12' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(unescape(responseText))	
}

			
/* This function is used for displaying the result sheet of practitioners duty roaster on selecting from and to date */
function show_details(){	   
		parent.frames[1].location.href='../../eCommon/html/blank.html' ;
		var err_num=null;
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
		var fields=new Array();
		fields[0]= document.PractDutyRoster_form.practitioner_name;
		fields[1]= document.PractDutyRoster_form.eff_from;
		fields[2]= document.PractDutyRoster_form.eff_to;
		var names = new Array (getLabel("Common.resourcename.label","Common"),
							getLabel("Common.fromdate.label","Common"),
							getLabel("Common.todate.label","Common")
			);
		var practitioner_name=document.forms[0].practitioner_name.value;
		if(checkFields( fields, names, parent.parent.frames[2])){
			/*Added by S.Sathish for IN020568 on Thursday, April 08, 2010 starts here*/
			 var roster_defined=document.PractDutyRoster_form.roster_defined.value;	
			 if(roster_defined != 'N'){
					roster_dates();
			 }else{
				var m=getMessage('ROSTER_NOT_EXISTS','OA');
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+m;
				parent.frames[1].location.href="../../eCommon/html/blank.html";	
			 }
			 /*Ends Here*/
		}
	
	

}

/* Here based on the effective from and to dates roaster dates r displayed for a practitioner onclick of select button */
function roster_dates(){
	var location1=document.PractDutyRoster_form.location1.value ;	
	if(!(location1 == null || location1 == "")){
		var arrval1 = location1.split("|");
		clinictype = arrval1[0];
		carelocn=arrval1[1];
	}
	var resource1=document.PractDutyRoster_form.resource.value ;
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num= ';
	var n = document.PractDutyRoster_form.noofdays.value ;
	var e =3;
	var days ="";
	for(var k=1; k<n; k++){
		if(eval("document.PractDutyRoster_form.day_"+k+".checked") == true)
		days += eval("document.PractDutyRoster_form.day_"+k+".value") + "|" ;
		e++;
	}
	
	if(days == ''){ //Added by S.Sathish for IN020568 on Thursday, April 08, 2010
		alert(getMessage('ATLEAST_ONE_ROSTER','OA'));			
	}

	var locncode = document.PractDutyRoster_form.location.value ;
	if(!(locncode == null || locncode == "")){
		var arrval2 = locncode.split("|");
		clinictype1 = arrval2[0];
	}
	var practid = document.PractDutyRoster_form.practitioner.value ;
	var fromdt = document.PractDutyRoster_form.eff_from.value;
	var todt = document.PractDutyRoster_form.eff_to.value;
	var url='../../eOA/jsp/addmodifyPractDutyRosterDetail.jsp?locn_code='+clinictype1+'&pract_id='+practid+'&days='+days+'&from_dt='+fromdt+'&to_dt='+todt+'&carelocn='+carelocn+'&resource1='+resource1;
	parent.frames[1].location.href='../../eOA/jsp/addmodifyPractDutyRosterDetail.jsp?locn_code='+clinictype1+'&pract_id='+practid+'&days='+days+'&from_dt='+fromdt+'&to_dt='+todt+'&carelocn='+carelocn+'&resource1='+resource1;
}

/* to chk whether location is entered else pass an alert, since location is mandatory */
function locationcheck(obj,target){	
	var locn_code = document.PractDutyRoster_form.location.value;
	var locations = document.PractDutyRoster_form.location1.value;
	if(!(locations == null || locations == "")){
		var arrval1 = locations.split("|");
		var clinictype1 = arrval1[0];
		var carelocn = arrval1[1];
	}
	var resource1 = document.PractDutyRoster_form.resource.value;
	var fromdate = document.PractDutyRoster_form.eff_from.value;
	var todate = document.PractDutyRoster_form.eff_to.value;
	if(resource1!=null){ 
		if(!(locn_code == null || locn_code == ""))	{
			var arrval = locn_code.split("|");
			locncode = arrval[0];
			opentoallpractyn = arrval[2];
			var practitioner_name = document.PractDutyRoster_form.practitioner_name.value;
			if(practitioner_name==null){
				practitioner_name=""; 
			}
			parent.frames[1].location.href='../../eCommon/html/blank.html' ;
			var err_num=null;
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
		}
	}else{					
		document.PractDutyRoster_form.location.focus();
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.Location.label","Common"));
		alert(error);
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.resourceclass.label","Common"));
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.resourcename.label","Common"));
		alert(error);
		document.forms[0].practitioner_name.value="";					
	}
}//function

function onblurlocation(obj,target){
	var locn_code = document.PractDutyRoster_form.location.value;
	var from_date = document.PractDutyRoster_form.eff_from.value;
	var to_date = document.PractDutyRoster_form.eff_to.value;
	var locations=document.PractDutyRoster_form.location1.value;
	if(!(locations == null || locations == "")){
		var arrval1 = locations.split("|");
		var clinictype1 = arrval1[0];
		var carelocn = arrval1[1];
	}
	var resource1=document.PractDutyRoster_form.resource.value;
	var practitioner_name=document.PractDutyRoster_form.practitioner_name.value;
	if(practitioner_name==null || practitioner_name==""){
		if (document.getElementById('roster')){
			document.getElementById('roster1').innerText="";
			document.getElementById('roster').innerText="";
		}
		if (document.getElementById('id')){
		}
		parent.frames[1].location.href='../../eCommon/html/blank.html' ;
		var error_num="";
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
		return;
	}
	if(!(locn_code == null || locn_code == "")){
		var arrval = locn_code.split("|");
		locncode = arrval[1];
		opentoallpractyn = arrval[2];
		parent.frames[1].location.href='../../eCommon/html/blank.html' ;
		var error_num="";
		parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
		onblurcheck(obj,target);
	}else{
		document.PractDutyRoster_form.location.focus();
		var error = getMessage('CAN_NOT_BE_BLANK','Common');
		error = error.replace('$',getLabel("Common.Location.label","Common"));
		alert(error);
		document.forms[0].practitioner_name.value="";
	}

}// function


function getLocation(Obj){
	var carelocn="";
	var locations = document.PractDutyRoster_form.location1.value;
	var oper_stn_id = document.PractDutyRoster_form.oper_stn_id.value;
	var clinictype1="";		
	document.forms[0].b_loc_val.value="";
	document.forms[0].location.value="";
	document.forms[0].resource.value="";
	document.PractDutyRoster_form.practitioner.value='';
	document.forms[0].resource.disabled=true;
	if(!(locations == null || locations == "")){
		var arrval1 = locations.split("|");
		 clinictype1 = arrval1[0];
		carelocn = arrval1[0];
	}
	document.forms[0].locationType1.value=carelocn;
	if(Obj.value==null||Obj.value==""){
		document.getElementById('b_loc_val').disabled=true;
		document.getElementById('b_loc_val').value="";
		document.getElementById('b_loc_search').disabled=true ;

	}else{
		document.getElementById('b_loc_val').disabled=false ;
		document.getElementById('b_loc_search').disabled=false ;
	}
	/*var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type1=\""+clinictype1+"\"  steps='2' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","../../eOA/jsp/ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/
}


function checkinIdentification(Obj){		
	document.forms[0].practitioner_name.value ='';
	document.forms[0].practitioner_name.disabled = true;
	document.forms[0].search_pract.disabled = true;
	document.forms[0].Select_button.disabled = true;
	document.getElementById('resource').value="";
	document.getElementById('practitioner_name').value='';	
	if (document.getElementById('roster')){
		document.getElementById('roster').innerText="";
		document.getElementById('roster1').innerText="";
	}
	parent.frames[1].location.href='../../eCommon/html/blank.html' ;
	var err_num=null;
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
	var locn_code = document.PractDutyRoster_form.location.value;
	document.getElementById('location_code1').value= locn_code;
	document.getElementById('resource').disabled=false;
	var val= Obj.value;
	var arr=val.split('|');
	if(val!=''){
		if(arr[3]=='P'){
			document.getElementById('resource').value="";
			document.getElementById('imgpract').style.visibility='visible';
			document.getElementById('resource').disabled=false;
		}else{			
			document.getElementById('resource').disabled=false;
			document.getElementById('practitioner_name').disabled=true;
			document.getElementById('imgpract').style.visibility='hidden';
		}
	}	
}	// function

		
function enable_dsiable_res(Obj){	
	var practitioner_name="";
	document.getElementById('practitioner_name').value='';
	document.getElementById('Select_button').disabled=true;
	if (document.getElementById('roster')){
		document.getElementById('roster').innerText="";
		document.getElementById('roster1').innerText="";
	}
	if(Obj.value==''){
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
		document.getElementById('Select_button').disabled=true;
		document.PractDutyRoster_form.practitioner.value="";		
	}else{
		document.getElementById('practitioner_name').disabled=false;
		document.getElementById('search_pract').disabled=false;
	}
	var resource1=document.PractDutyRoster_form.resource.value;
	var locations = document.PractDutyRoster_form.location1.value;
	var locn_code = document.PractDutyRoster_form.location.value;
	parent.frames[1].location.href = '../../eCommon/html/blank.html' ;
	var err_num=null;
	document.getElementById('resourceType1').value=Obj.value;
	document.PractDutyRoster_form.checkdtlframe.value="NO";
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num';
}// function
		
function Clear_Msg() {
	parent.parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num= ';
}



/********Date*********/


function validate_date_from(from,sys){
	if(from.value!=""){
		if(!validDateObj(from,"DMY",localeName)){
			from.value="";
			return ;
		}
		var obj1=convertDate(from.value,"DMY",localeName,"en");
		if(isBefore(sys,obj1,'DMY',"en")==false){
			alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
			from.value="";
			from.select();	
			return false;
			}else{
				return true;
		}
	}
}

function validate_date_to(to,from){
	if(to.value!=""){
		if(!validDateObj(to,"DMY",localeName)){
			to.value="";
			return ;
		}
		if(from.value!="" && to.value!="" ){
			if(isBefore(from.value,to.value,'DMY',localeName)==false){
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				to.value="";
				to.select();	
				return false;
			}else{
				return true;
			}
		}
	}
}

function compare_from(from,to){
	if(from.value!="" && to.value!="" ){
		if(isBefore(from.value,to.value,'DMY',localeName)==false){
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
			to.value="";
			to.select();	
			return false;
		}else{
			return true;
		}
	}
}
function chgbuttonclr(){
	var function_name=document.forms[0].function_name.value
	if(function_name=="insert"){
		document.getElementById('b_loc_val').disabled="true" ;
		document.getElementById('b_loc_search').disabled="true" ;
	}
}

async function open_loc_lookup(){
	var location1=document.forms[0].location1.value;	
	var location_values=location1.split("|");
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=location_values[0];
	var care_locn_ind=location_values[1];
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
	var retVal="";
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=PRACT_DUTY_ROSTER",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var ID1=rvalues[0];
		var desc=rvalues[1];
		var opentoallpractyn1=rvalues[2];
		var clinictype1=rvalues[3];
		var identatcheckin1=rvalues[4];
		var fivisit1=rvalues[5];
		var alcncriteria1=rvalues[6];
		var STime=rvalues[7];
        var ETime=rvalues[8];
		var dur=rvalues[9];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].location.value=ID1+"|"+clinictype1+"|"+opentoallpractyn1+"|"+identatcheckin1+"|"+fivisit1+"|"+alcncriteria1+"|"+STime+"|"+ETime+"|"+dur;
		document.forms[0].resource.disabled=false;			
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].location.value="";
		document.forms[0].resource.value="";
		document.forms[0].resource.disabled=true;			
	}

}
function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			document.forms[0].location.value="";
			document.forms[0].resource.value="";
			document.forms[0].resource.disabled=true;
			document.PractDutyRoster_form.checkdtlframe.value="NO";
			enable_dsiable_res(document.PractDutyRoster_form.resource);
	}else{
		open_loc_lookup()
	}
}
function clearData(){
	/*if (document.getElementById('roster')){
		document.getElementById('roster').innerText="";
		document.getElementById('roster1').innerText="";
	}
	parent.frames[1].location.href = '../../eCommon/html/blank.html';*/
	document.PractDutyRoster_form.checkdtlframe.value="NO";
	enable_dsiable_res(document.PractDutyRoster_form.resource);
}

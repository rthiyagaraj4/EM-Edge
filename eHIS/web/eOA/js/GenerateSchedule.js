
function blank_chk()
{
		parent.frames[3].location.href = '../../eCommon/jsp/error.jsp';
		var fields=new Array();
		var names = new Array ();

		fields[0]= parent.frames[1].document.forms[0].eff_from;
		fields[1]= parent.frames[1].document.forms[0].eff_to;

		names[0]=getLabel("Common.fromdate.label","Common");
		names[1]=getLabel("Common.todate.label","Common");
		if(checkFields(fields,names,parent.frames[3]))
			return true;
		else
			return false;
}

function generate_schedule()
{

//parent.frames[1].document.GenerateSchedule_form.generate.disabled=true;
if(blank_chk()){  

		var stdt = parent.frames[1].document.GenerateSchedule_form.eff_from;
		var sysdt = parent.frames[1].document.GenerateSchedule_form.sys_date.value;
		var enddt = parent.frames[1].document.GenerateSchedule_form.eff_to;
		var obj2=convertDate(enddt.value,"DMY",localeName,"en");
		if(stdt.value.length > 0 ){
			if (CheckDate(obj2)){
				fromarray = stdt.value.split("/");
				toarray = enddt.value.split("/");
				fromarray[1]=fromarray[1]-1;
				toarray[1]=toarray[1]-1;
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {
					alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
					enddt.focus();
					return false;

				}
			}else{
				enddt.value='';
			}
		}

		if(parent.frames[1].document.forms[0].all_practitioners.disabled == true){ 
			var con="";
			var k=8; //7th element
			var e=0; //pract id
			/*Above Line commented and Below Line Added for this CRF [AMRI-CRF-0236]*/
			// var k=8; 
			// var e=0;
			
			//End this CRF [AMRI-CRF-0236]
			var n = parent.frames[2].document.forms[0].nochkbox.value ;		
		for(var i=0;i<=n;i++){ 			     
			   
				//if(parent.frames[2].document.forms[0].elements[k].checked == true && parent.frames[2].document.forms[0].elements[k].name!="selected_chk"){ 
				  if(parent.frames[2].document.forms[0].elements[k].checked == true && parent.frames[2].document.forms[0].elements[k].name!="selected_chk8"){ 
                    
					if(parent.frames[2].document.forms[0].elements[e].value == 'null')
						parent.frames[2].document.forms[0].elements[e].value = '';					
					if((parent.frames[2].document.forms[0].elements[e].value).substr(0,4) == 'null' ){ 
						con+='T'+"-"+(parent.frames[2].document.forms[0].elements[e].value).substr(4,(parent.frames[2].document.forms[0].elements[e].value).length-4)+"-";  
					
					}else{   
						con+='N'+"-"+parent.frames[2].document.forms[0].elements[e].value+"-";
						
						} 
					k=k-7;
                   
					for(var j=0;j<7;j++){ //7 is the no of days
					
						if(parent.frames[2].document.forms[0].elements[k].checked == true){ 
							con += parent.frames[2].document.forms[0].elements[k].value +"-" ;
                            						
						}
						k++;
					}					
				
					
					con += "|" ; 
					
					
					
				}
				k+=9;
				e+=9;
		
			}
      
			parent.frames[1].document.forms[0].con_days.value = con;

		}else{   
			var e=10;
			var con="Y-"+"null-";
			for(var j=0; j<7; j++){				
				if(parent.frames[1].document.forms[0].elements[e].checked == true){
					con += parent.frames[1].document.forms[0].elements[e].value + "-" ;
					
				}
					e++;

			}  
			con += "|";  
			
			parent.frames[1].document.forms[0].con_days.value = con;
		

		}
		if(con == "Y-null-" || con == '')
			alert(self.getMessage("NO_RECORDS_FOR_GENE_SCH","OA"));
		else{
			parent.frames[0].location.href = '../../eCommon/jsp/process.jsp' ;
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLvalue);//
			parent.frames[1].document.forms[0].action="../../servlet/eOA.GenerateScheduleServlet";
			parent.frames[1].document.forms[0].target="messageFrame";
			parent.frames[1].document.forms[0].submit();
			parent.frames[2].location.href='../../eCommon/html/blank.html' ;
		}
	}

} //end function

function reset() {
			parent.frames[2].frames[1].location.href = '../../eOA/jsp/addmodifyGenerateSchedule.jsp' ;
			parent.frames[2].frames[2].location.href = '../../eCommon/html/blank.html' ;
}


/*function validate_date(ref) {
	var stdt = parent.frames[1].document.GenerateSchedule_form.eff_from;
	var sysdt = parent.frames[1].document.GenerateSchedule_form.sys_date.value;
	var enddt = parent.frames[1].document.GenerateSchedule_form.eff_to;

var endarray;

	if(ref == "FROM_DATE_LESS_SYSDATE" ){

		if(stdt.value.length > 0  ){

		if (CheckDate(stdt)){

				fromarray = stdt.value.split("/");
				toarray = sysdt.split("/");
				fromarray[1]=fromarray[1]-1;
				toarray[1]=toarray[1]-1;
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(fromdt) < Date.parse(todt)) {
					alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
					stdt.focus();
					stdt.value="";
					
					return false;

				}
					
			}else{
				stdt.value='';
			}
		}
	}

	if(ref == "TO_DT_GR_EQ_FM_DT" ){

		if(enddt.value.length > 0){
			if (CheckDate(enddt)){
				fromarray = stdt.value.split("/");
				toarray = enddt.value.split("/");
				fromarray[1]=fromarray[1]-1;
				toarray[1]=toarray[1]-1;
				var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
				var todt = new Date(toarray[2],toarray[1],toarray[0]);
				if(Date.parse(todt) < Date.parse(fromdt)) {
					alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
					enddt.focus();
					enddt.value="";
					return false;

				}
			}else{
				enddt.value='';
			}
		}
	}	
}*/

function onSuccess() {
	reset();
}


function locationPopulate(obj){
	if (obj.value!=''){

		locnValue=obj.options[obj.options.selectedIndex].value;
		oper_stn_id=document.forms[0].oper_stn_id.value;

		HTMLvalue="<html><body onKeyDown = 'lockKey()'><form name='populateForm' id='populateForm' action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='LBoxValue' id='LBoxValue' value='"+locnValue+"'><input name='from' id='from' type=hidden value ='GenerateSchedule'></form></body></html>";
		parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLvalue);
		parent.messageFrame.document.populateForm.submit();
	}else{ 
		var default_select=document.forms[0].default_select.value;
		obj1=document.forms[0].clinic;
		var len =obj1.options.length;
		while (len-- >= 0) obj1.remove(obj1.options[0]);
		opt=document.createElement('OPTION');
		opt.value='';
		opt.text="-------"+getLabel("Common.defaultSelect.label","Common")+"-------";
		obj1.add(opt);
	}
}


	

/*Called on change of Location */
/*Below line commented for this CRF [AMRI-CRF-0236]*/
function clearDetail(){
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.GenerateSchedule_form.all_practitioners.disabled = false;
	document.GenerateSchedule_form.all_practitioners.checked = true;
	// PractDetails();
	
}
//End AMRI-CRF-0236
function clearDetail1(obj){ 
	parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
	document.GenerateSchedule_form.all_practitioners.disabled = true;
	document.GenerateSchedule_form.all_practitioners.checked = false;
	obj=event.target;
	selIndex=obj.options.selectedIndex;

	if (document.getElementById('flipDivId')){
		document.getElementById('flipDivId').style.display='none';

	}
	document.forms[0].eff_to.value='';
	document.forms[0].eff_from.value=''
	document.forms[0].generate.disabled=true;

if(obj.value!=""){
	document.getElementById('b_loc_val').value="";
	document.getElementById('clinic').value="";
	document.getElementById('b_loc_val').disabled=false;
	document.getElementById('b_loc_search').disabled=false;
	}else{
	document.getElementById('b_loc_val').value="";
	document.getElementById('clinic').value="";
	document.getElementById('b_loc_val').disabled=true;
	document.getElementById('b_loc_search').disabled=true;
	}

}


/*Called on change of Location to show time table of the selected Location*/
function rfresh(obj){
		document.getElementById('info').innerHTML="&nbsp;";

		var arr =  new Array();


		if(obj.value !=''){
			arr = (obj.value).split("|");
			var lcode = arr[0];
			var ltype = arr[1];
			var ltxt = obj.value;
			
			var locnCode=document.forms[0].locationType.value;

			var locnObj=document.forms[0].locationType;
			var selIndex=locnObj.options.selectedIndex;
			var sys_date=document.forms[0].sys_date.value;
			//parent.frames[1].location.href='../../eOA/jsp/addmodifyGenerateSchedule.jsp?clinic_code='+lcode+'&clinic_type='+ltype+'&text='+ltxt+'&selIndex='+selIndex+'&resourceCode='+locnCode;

			var day_1 = document.forms[0].wday_1.value;			
			var day_2 = document.forms[0].wday_2.value;
			var day_3 = document.forms[0].wday_3.value;
			var day_4 = document.forms[0].wday_4.value;
			var day_5 = document.forms[0].wday_5.value;
			var day_6 = document.forms[0].wday_6.value;
			var day_7 = document.forms[0].wday_7.value;


			HTMLvalue="<html><body onKeyDown = 'lockKey()'><form name='populateForm' id='populateForm' action='../../eOA/jsp/ServerSideValidation.jsp'><input type=hidden name='clinic_code' id='clinic_code' value='"+lcode+"'><input type=hidden name='clinic_type' id='clinic_type' value='"+ltype+"'><input type=hidden name='text' id='text' value='"+ltxt+"'><input type=hidden name='selIndex' id='selIndex' value='"+selIndex+"'><input type=hidden name='resourceCode' id='resourceCode' value='"+locnCode+"'><input type=hidden name='day_1' id='day_1' value='"+day_1+"'><input type=hidden name='day_2' id='day_2' value='"+day_2+"'><input type=hidden name='day_3' id='day_3' value='"+day_3+"'><input type=hidden name='day_4' id='day_4' value='"+day_4+"'><input type=hidden name='day_5' id='day_5' value='"+day_5+"'><input type=hidden name='day_6' id='day_6' value='"+day_6+"'><input type=hidden name='day_7' id='day_7' value='"+day_7+"'><input type=hidden name='sys_date' id='sys_date' value='"+sys_date+"'><input name='from' id='from' type=hidden value ='GenerateSchedule_ref'></form></body></html>";
			

			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLvalue);
			parent.messageFrame.document.populateForm.submit();

			parent.frames[2].location.href='../../eCommon/html/blank.html' ;
			
      
//setTimeout('PractDetails()',500)  //  Added for this CRF [ AMRI-CRF-0236]


		}else{

			document.forms[0].eff_to.value='';
			document.forms[0].eff_from.value=''
			document.forms[0].all_practitioners.checked=false;
			document.forms[0].all_practitioners.disabled=true;
			document.forms[0].generate.disabled=true;

			if (document.getElementById('flipDivId')){
			   document.getElementById('flipDivId').style.display='none';
			}
			parent.frames[2].location.href='../../eCommon/html/blank.html' ;
		}
		

}


/*Funtion called to display the Practitioner's Time Table details of the selected location */
function PractDetails(obj){ 
  
	document.GenerateSchedule_form.day_1.disabled = true;
	document.GenerateSchedule_form.day_2.disabled = true;
	document.GenerateSchedule_form.day_3.disabled = true;
	document.GenerateSchedule_form.day_4.disabled = true;
	document.GenerateSchedule_form.day_5.disabled = true;
	document.GenerateSchedule_form.day_6.disabled = true;
	document.GenerateSchedule_form.day_7.disabled = true;
	document.GenerateSchedule_form.all_practitioners.disabled = true;

	var eff_from_greg=convertDate(document.forms[0].eff_from.value,"DMY",localeName,"en");
	var eff_to_greg=convertDate(document.forms[0].eff_to.value,"DMY",localeName,"en");

	if(parent.frames[1].document.GenerateSchedule_form.clinic.value == '')
	{
				//alert("Clinic cannot be blank");
	}
	else if(obj.checked == false){
	{  
	var cc = parent.frames[1].document.GenerateSchedule_form.clinic.value ;

	cc=cc.substring(0,cc.indexOf("|")); 
			var i = parent.frames[1].document.GenerateSchedule_form.no_days.value; 
			var e =6;
			var days ="";
			var n=0;

			for(var k=0; k<i; k++){
					if(document.GenerateSchedule_form.elements[e].checked ==true){
						days += document.GenerateSchedule_form.elements[e].value + "|" ;						
						e++;
						n++;
					}
			}
			
			var url='../../eOA/jsp/addmodifyGenerateScheduleDetail.jsp?nodays='+n+'&days='+days+'&clinic_code='+cc+'&wd1='+document.forms[0].wday_1.value+'&wd2='+document.forms[0].wday_2.value+'&wd3='+document.forms[0].wday_3.value+'&wd4='+document.forms[0].wday_4.value+'&wd5='+document.forms[0].wday_5.value+'&wd6='+document.forms[0].wday_6.value+'&wd7='+document.forms[0].wday_7.value+'&locationType='+document.forms[0].locationType.value+'&from_date='+eff_from_greg+'&to_date='+eff_to_greg;
			parent.frames[2].location.href=url;

	}
	 
}else if(obj.checked == true){
parent.frames[2].location.href='../../eCommon/html/blank.html' ;
}
}

async function showPractWindow(practID){   

	practID=practID.substr(0,practID.indexOf('*'));
	  
	var url     = "../../eAM/jsp/ViewPractitionerDtls.jsp?practitioner_id="+practID+"&fcall=call";
	//var dialogHeight    = "70" ;
	//var dialogWidth = "62";
	var dialogLeft="15";
	//var dialogTop="75";
	var dialogWidth = "70vw";
	var dialogHeight="70vh";
	var dialogTop="10px";
	var arguments   = "" ;
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;dialogLeft:"+dialogLeft+";";
	var reportURL   = await window.showModalDialog( url, arguments, features ) ;
}


/*******Date*******/

function validate_date_from(from,sys)
{
	
	if(from.value!="")
		{
		if(!validDateObj(from,"DMY",localeName))
		{
			from.value="";
			return ;
		}

		var obj1=convertDate(from.value,"DMY",localeName,"en");

		if(isBefore(sys,obj1,'DMY','en')==false)//localName is changed to en by Rameswar on 05-OCT-16 for Leap Year Issue
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				from.value="";
				from.select();	
				return false;
			}
			else
				return true;

		}
}



function validate_date_to(to,from)
{
	if(to.value!="")
		{
		if(!validDateObj(to,"DMY",localeName))
		{
			to.value="";
			return ;
		}

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

function compare_from(from,to)
{
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
function chgbuttonclr()
		{
			document.getElementById('b_loc_val').disabled="true" ;
			document.getElementById('b_loc_search').disabled="true" ;


		}

	
async function open_loc_lookup(){
	var location1=document.forms[0].locationType.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[0];
	var care_locn_ind=location1[0];
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogHeight= "550px" ;
	var dialogTop = "0px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=GEN_SCH",arguments,features);

	if(retVal!=null){
		var rvalues=retVal.split("~");
		var ID=rvalues[0];
		var desc=rvalues[1];
		var locntype=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].clinic.value=ID+"|"+locntype;		
		clearDetail();
        rfresh(document.forms[0].clinic);
	}else{ 
		document.forms[0].b_loc_val.value="";
		document.forms[0].clinic.value="";
		clearDetail();
		rfresh(document.forms[0].clinic);
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
	 rfresh(obj);
	}else{
	open_loc_lookup()
	}
}


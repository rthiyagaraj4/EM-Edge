function query()
{


	frames[1].location.href = '../../eOA/jsp/TransferCancelAppointmentQueryCriteria.jsp';
	frames[2].location.href = '../../eCommon/html/blank.html';
}

function callResult(){
	parent.frame2.location.href = '../../eCommon/html/blank.html' ;
	var functionid=document.forms[0].functionid.value;
	//parent.frames[1].document.forms[0].select.disabled=true;
	
	/*Below Line Added for this CRF [Bru-HIMS-CRF-0166]*/	
if(parent.frames[1].document.forms[0].resch){	
var reschedule=parent.frames[1].document.forms[0].resch.value;
}else{
var reschedule;
}
 
 /*Below line Added for this CRF Bru-HIMS-CRF-191*/
 var group_chk="";
 if(functionid!=""&&functionid=="TRANSFER_CANCEL_APPT")
 group_chk="TRANSFERCANCELAPPT";
 
 //End  Bru-HIMS-CRF-191
 
	parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
	appt_ref_no = "" ;
    patientid	= "";
	patientname	= "" ;
	gender		= "" ;
	if(document.forms[0].function_id.value==""){
		appt_ref_no = parent.frames[1].document.forms[0].b_appt_ref_no.value ;
		patientid	= parent.frames[1].document.forms[0].b_patient_id.value ;
		patientname	= parent.frames[1].document.forms[0].b_patient_name.value ;
		gender		= parent.frames[1].document.forms[0].b_gender.value ;
	}
	cliniccode	= parent.frames[1].document.forms[0].b_loc.value ;
	cliniccode = cliniccode.substring(2,cliniccode.length)
	practcode	= parent.frames[1].document.forms[0].practitioner.value ;
	apptfromdate	= parent.frames[1].document.forms[0].b_from_date.value ;
	appttodate	= parent.frames[1].document.forms[0].b_to_date.value ;
	var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value ;
	var res_type=parent.frames[1].document.forms[0].resourceType1.value ;
	var called_for=parent.frames[1].document.forms[0].called_for.value ;
	var function_id=document.forms[0].function_id.value;
	var reason_for_cancellation="";
	var chk_dur='N';


	if(document.forms[0].function_id.value==""){
		if(function_id !="BULK_CANCEL" && called_for !="Link" ){
				if(parent.frames[1].document.forms[0].sel_with.value=="A"){
					chk_dur='Y';
					var fields = new Array ( parent.frames[1].document.forms[0].b_from_date,
					parent.frames[1].document.forms[0].b_to_date);
					var names = new Array ( getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.from.label","Common"),
					getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.to.label","Common"));
				}else if(parent.frames[1].document.forms[0].sel_with.value=="W"){
					fields = new Array ( parent.frames[1].document.forms[0].b_patient_id);
					names = new Array ( getLabel("Common.patientId.label","Common"));
				}
		}else{
				chk_dur='Y';
				var fields = new Array ( parent.frames[1].document.forms[0].b_from_date,
				parent.frames[1].document.forms[0].b_to_date);
				var names = new Array ( getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.from.label","Common"),
				getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.to.label","Common"));
		}

	}else{
		chk_dur='Y';
		var fields = new Array (parent.frames[1].document.forms[0].reason_code_cancel, parent.frames[1].document.forms[0].b_from_date,
		parent.frames[1].document.forms[0].b_to_date);
		var names = new Array ( getLabel("Common.ReasonforCancellation.label","Common"),
		getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.from.label","Common"),
		getLabel("Common.apptdate.label","Common")+" "+getLabel("Common.to.label","Common"));
		reason_for_cancellation=parent.frames[1].document.forms[0].reason_for_cancellation.value;
	}

	if(!parent.frames[1].checkFields( fields, names, parent.frames[3])){
	}else{
		parent.frames[1].document.forms[0].select.disabled=true;
		parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
		var day_of_week="";
		var not_iden_pract="";
		if(function_id !="BULK_CANCEL" && called_for !="Link" ){
			not_iden_pract=parent.frames[1].document.forms[0].not_iden_pract.value
			day_of_week	=parent.frames[1].document.forms[0].day_of_week.value ;
		}
		
		var value1 = parent.frames[1].document.forms[0].b_from_date.value;
		var value2 =parent.frames[1].document.forms[0].b_to_date.value;
		var dbd=0;
		if(value1 !='' && value2 !=''){
			var day1, day2;
			var month1, month2;
			var year1, year2;
			
			day1 = value1.substring (0, value1.indexOf ("/"));
			month1 = value1.substring (value1.indexOf ("/")+1, value1.lastIndexOf ("/"));
			year1 = value1.substring (value1.lastIndexOf ("/")+1, value1.length);

			day2 = value2.substring (0, value2.indexOf ("/"));
			month2 = value2.substring (value2.indexOf ("/")+1, value2.lastIndexOf ("/"));
			year2 = value2.substring (value2.lastIndexOf ("/")+1, value2.length); 

			date1 = year1+"/"+month1+"/"+day1;
			date2 = year2+"/"+month2+"/"+day2;
			firstDate = Date.parse(date1)
			secondDate= Date.parse(date2)
			msPerDay = 24 * 60 * 60 * 1000;
			dbd = Math.round((secondDate.valueOf()-firstDate.valueOf())/ msPerDay) + 1;
		}
		    /*modified by Shanmukh for ML-MMOH-CRF-1134 on 15th-MAY-2018*/
            var isSearchDurLimitAppl=parent.frames[1].document.forms[0].isSearchDurLimitAppl.value;
			var limit=isSearchDurLimitAppl=="true"?100:10;
		    if(chk_dur=='Y' && dbd>limit){ 
			var msg=getMessage("SRCH_PER_VALID","OA");
			msg = msg.replace('$',limit);
			alert(msg);
			parent.frames[1].document.forms[0].select.disabled=false;

		}else{
		   /*Below Line Condition Added  for this CRF [Bru-HIMS-CRF-0166]*/
            if(reschedule=="Y"){	 		   
			   var url='../../eOA/jsp/RescheduleCancelAppointmentQueryResult.jsp?not_iden_pract='+not_iden_pract+"&patientid="+patientid+"&functionid="+functionid+"&patientname="+decodeURIComponent(patientname)+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for+"&function_id="+function_id+"&reason_for_cancellation="+reason_for_cancellation+"&day_of_week="+day_of_week;
			}else{ 	
			var url='../../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?not_iden_pract='+not_iden_pract+"&patientid="+patientid+"&functionid="+functionid+"&patientname="+decodeURIComponent(patientname)+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for+"&function_id="+function_id+"&reason_for_cancellation="+reason_for_cancellation+"&day_of_week="+day_of_week+"&group_chk="+group_chk+"";
			//alert(url);			
			}
			
			parent.frame2.location.href = url;
			
			
		}
	}     	
}

function reset()
{     
	var function_id= frames[1].document.forms[0].function_id.value
		var called_for=frames[1].document.forms[0].called_for.value ;
	var lBox=frames[1].document.QueryApptForPatient.b_loc; 
	frames[1].document.QueryApptForPatient.b_loc.value="";
	//var len=frames[1].document.QueryApptForPatient.b_loc.options.length;
	
    /*lBox.remove(lBox.options[0]);
  
    var i=0;
    while(i< len)
		lBox.remove(lBox.options[i++]);
	  var opt=document.createElement('OPTION');	
	opt.value='';
    opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	lBox.add(opt);*/

        frames[1].document.forms[0].reset();
		frames[1].document.forms[0].practitioner_name.disabled=true;
		frames[1].document.forms[0].search_pract.disabled=true;
		if(function_id !="BULK_CANCEL" && called_for !="Link" ){
			
		frames[1].document.getElementById('dategif').style.visibility = 'visible';
		frames[1].document.getElementById('patientMan').style.visibility = 'hidden';

		if(frames[1].document.forms[0].sel_with.value="A"){
        var sysdate=frames[1].document.forms[0].sys_date.value;
        var sysdate1=frames[1].document.forms[0].sysdate1.value;
        frames[1].document.forms[0].b_from_date.value=sysdate;
        frames[1].document.forms[0].b_to_date.value=sysdate1;
        }	
		}
	var called_for=frames[1].document.forms[0].called_for.value ;
if(function_id !="BULK_CANCEL" && called_for !="Link" )
{
		frames[1].document.forms[0].not_iden_pract.checked=false;
			frames[1].document.forms[0].not_iden_pract.disabled=false;
}
		frames[1].document.getElementById('pract_type').innerText="";
	//parent.frame1.location.href 		= '../../eOA/jsp/QueryApptForPatientCriteria.jsp';
	  frame2.location.href 		= '../../eCommon/html/blank.html' ;
}

function clearAll() {
  parent.frame2.location.href = '../../eCommon/html/blank.html' ;
 /* parent.frames[1].document.forms[0].b_appt_ref_no.value = '';
  parent.frames[1].document.forms[0].b_patient_id.value = '';
  parent.frames[1].document.forms[0].b_patient_name.value = '';
  parent.frames[1].document.forms[0].b_from_date.value = '';
  parent.frames[1].document.forms[0].b_to_date.value = '';
  parent.frames[1].document.forms[0].b_pract.value = '';
  parent.frames[1].document.forms[0].b_pract_name.value = '';
  parent.frames[1].document.forms[0].b_gender.selectedIndex = 0;
  parent.frames[1].document.forms[0].b_loc.selectedIndex = 0;
//  parent.frames[1].document.forms[0].b_pract.selectedIndex = 0; */ 	
  parent.frames[3].location.href = '../../eCommon/jsp/error.jsp'; 
}

async function patqry() {
	var pat_id= await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.forms[0].b_patient_id.value=pat_id;
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

	document.getElementById('search').style.background="navy" ;
	document.getElementById('search').style.color="white" ;
	document.getElementById('search').style.fontWeight="700" ;
	document.getElementById('search').style.borderStyle="solid" ;


}

/*Pract lookup added by suman*/

function checkBoxValue(cBox){
	if (cBox.checked == true)
		cBox.value = "Y";
	else
		cBox.value = "N";
}

function populatepract(Obj)
{

	/*var n=document.forms[0].b_loc.options.length;
	for(var i=0;i<n;i++){
		document.forms[0].b_loc.remove("clinic");
		
	}*/

	var locationtype = document.getElementById('b_loc1').value; 
	if(Obj.value==null||Obj.value=="")	{
	document.forms[0].b_loc_val.value="";
	document.forms[0].b_loc.value="";
	document.forms[0].b_loc_val.disabled=true;
	document.forms[0].b_loc_search.disabled=true;
	document.getElementById('practitioner_name').value="";
	document.getElementById('practitioner').value="";
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('practitioner').disabled=true;		
	if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){ // Added the condition for IN032044 on 29.02.2012 by Suresh M
		document.forms[0].not_iden_pract.checked=false;
		document.forms[0].not_iden_pract.disabled=true; 
		document.forms[0].not_iden_pract.value="";
	}
	parent.frames[1].document.forms[0].resourceType1.value="";  

	}else{
	document.forms[0].b_loc_val.value="";
	document.forms[0].b_loc.value="";
	document.forms[0].b_loc_val.disabled=false;
	document.forms[0].b_loc_search.disabled=false;
	document.getElementById('practitioner_name').value="";
	document.getElementById('practitioner').value="";
	document.getElementById('practitioner_name').disabled=true;
	document.getElementById('practitioner').disabled=true;
	if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
		document.forms[0].not_iden_pract.value="";
		document.forms[0].not_iden_pract.checked=false;
		document.forms[0].not_iden_pract.disabled=true;  	
	}
	
	}

	/*var opt=document.createElement("OPTION");
	opt.text="----"+getLabel("Common.defaultSelect.label","Common")+"----";
	opt.value="";
	document.forms[0].b_loc.add(opt);

	var oper_stn_id=document.forms[0].oper_stn.value;

	var xmlDoc = ""
	var xmlHttp = new XMLHttpRequest()
	xmlStr ="<root><SEARCH clinic_type=\""+Obj.value+"\" steps='S' /></root>"
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","ServerSide.jsp",false)
	xmlHttp.send(xmlDoc)
	responseText=xmlHttp.responseText
	responseText = trimString(responseText)
	eval(responseText)*/ 

	if(Obj.value=='C'){
			document.getElementById('pract_type').innerHTML=getLabel("Common.practitioner.label","Common");
			document.getElementById('practitioner').value='P';
		}else{
			document.getElementById('pract_type').innerHTML="&nbsp;";
			document.getElementById('practitioner').value='';
			
		}
	
	
	document.getElementById('pract_type').innerHTML="&nbsp;";
	document.getElementById('practitioner').value='';
	

}


function enablepract(Obj){
	
	document.getElementById('practitioner_name').disabled=false;
	document.getElementById('search_pract').disabled=false;
	document.getElementById('practitioner_name').value="";   	
	var ObjVal=Obj.value;
	var arr=ObjVal.split("$");
	var clnc_cd=arr[1];
	var specialty="";
	var clinic_type=parent.frames[1].document.forms[0].b_loc1.value;
	if(clinic_type!='C'){
		document.getElementById('pract_type').innerHTML="&nbsp;";
	}	
	if(ObjVal==''){
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=true;
		document.forms[0].search_pract.disabled=true;
		if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
		  document.forms[0].not_iden_pract.value='';
		}		
	}else{
		document.forms[0].practitioner_name.value='';
		document.forms[0].practitioner_name.disabled=false;
		document.forms[0].search_pract.disabled=false;
		if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
		  document.forms[0].not_iden_pract.value='';
		}
	}	
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH speciality=\""+specialty+"\" location=\""+ObjVal+"\" clinic_type=\""+clinic_type+"\" clinic_code1=\""+clnc_cd+"\" steps='XXX' /></root>"

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)
}




function displayToolTip(tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,patientid,book_appt_across_catg_yn,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,create_wait_list_yn,time_table_type,referral_id,practitioner_name,clinic_name,appt_category,speciality_code,rd_appt_yn,group_id) 
{    
		if (tfr_appt_yn=="N"&&canc_appt_yn=="N") alert(getMessage("TRNS_CANCEL_NOT_ALLOW_FOR_OS","OA"));
		buildTable(tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,patientid,book_appt_across_catg_yn,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,create_wait_list_yn,time_table_type,referral_id,practitioner_name,clinic_name,appt_category,speciality_code,rd_appt_yn,group_id) 

		bodwidth  = parent.parent.frames[1].document.body.offsetWidth
		bodheight = parent.parent.frames[1].document.body.offsetHeight
		//Modified against INC:49319
		var x 	  = event.clientX;
		var y 	  = event.clientY;
		
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth)
		y 	  = y + (document.getElementById('tooltiplayer').offsetHeight)

		if(x<bodwidth)
			x = event.clientX 
		else
			x = x - (document.getElementById('tooltiplayer').offsetWidth)
		if(y<bodheight)
			y = event.clientY
		else
			y = y - (document.getElementById('tooltiplayer').offsetHeight)
				
		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		document.getElementById("tooltiplayer").style.left= x-50+"px";
		document.getElementById("tooltiplayer").style.top = y+"px";
		document.getElementById("tooltiplayer").style.visibility='visible' 
		
}

function buildTable(tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,patientid,book_appt_across_catg_yn,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,create_wait_list_yn,time_table_type,referral_id,practitioner_name,clinic_name,appt_category,speciality_code,rd_appt_yn,group_id) 
{ 	

		var tab_dat  			= "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
		if(canc_appt_yn=='Y'){
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_CancelWin('"+apptrefno+"','"+cliniccode1+"','"+practitionerid+"','"+apptdate+"','"+overbookedyn+"','"+apptslabfromtime+"','"+apptslabtotime+"','"+appt_day1+"','"+forced+"','Cancel','"+locnType+"')>"+getLabel("Common.CancelAppointment.label","Common")+"</a></td>";		
			tab_dat     += "</tr>";
		}else{
		}
		if(forced=='N'){
			 if(tfr_appt_yn=='Y' && group_id==""){					
				tab_dat     += "<tr>";
				tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_TransferWin('"+encodeURIComponent(practitioner_name)+"','"+encodeURIComponent(clinic_name)+"','"+tfr_appt_across_catg_yn+"','"+apptrefno+"','"+cliniccode1+"','"+practitionerid+"','"+apptdate+"','"+overbookedyn+"','"+apptslabfromtime+"','"+apptslabtotime+"','"+appt_day1+"','"+visit_type_ind+"','"+team_id+"','"+forced+"','"+rsClass+"','"+locnType+"','"+speciality_code+"','"+appt_category+"','"+rd_appt_yn+"')>"+getLabel("Common.RescheduleAppointment.label","Common")+"</a></td>"; //this line modified by ML-MMOH-CRF-609
				tab_dat     += "</tr>";
			}
		}
		if(group_id==""){
		
			tab_dat     += "<tr>";
			tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:show_BookingWin('"+encodeURIComponent(practitioner_name)+"','"+tfr_appt_across_catg_yn+"','"+apptrefno+"','"+cliniccode1+"','"+practitionerid+"','"+apptdate+"','"+overbookedyn+"','"+apptslabfromtime+"','"+apptslabtotime+"','"+appt_day1+"','"+visit_type_ind+"','"+team_id+"','"+forced+"','"+rsClass+"','"+locnType+"','"+patientid+"','"+tfr_appt_yn+"','"+canc_appt_yn+"','"+book_appt_across_catg_yn+"','"+book_appt_yn+"','"+book_appt_wo_pid_yn+"','"+obook_appt_yn+"','"+create_wait_list_yn+"','"+time_table_type+"','"+referral_id+"','"+encodeURIComponent(clinic_name)+"','"+rd_appt_yn+"')>"+getLabel("eOA.ModifyAppointment.label","OA")+"</a></td>";		
			tab_dat     += "</tr>";
		}
	
	tab_dat     += "</table>";

	document.getElementById('t').innerHTML = tab_dat;
	
	
}





async function show_confirmation(tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime){
		var retVal = 	new String();
		var dialogHeight = "60" ;
		var dialogWidth  = "45" ;
		var dialogTop    = "45";
		var dialogLeft   = "42";
		var apptrefno 	   = apptrefno;
		var cliniccode1    = cliniccode1;
		var practitionerid = practitionerid;
		var apptdate 	   = apptdate;
		var overbookedyn   = overbookedyn;
		var apptslabfromtime    = apptslabfromtime;
		var apptslabtotime      = apptslabtotime;
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; scrolling:no; status=no";
		var arguments    = "" ;		
		retVal 	 	 = await window.showModalDialog("../../eOA/jsp/CancelTransferConfirmFrame.jsp?tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn,arguments,features);
		
		if(retVal=='cancel'){
		show_CancelWin(apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime);
		}
		else if(retVal=='transfer'){
		show_TransferWin(tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime);
		}
		else if(retVal=='closed'){
		parent.frames[2].document.location.reload();
		}
		else{
		parent.frames[2].document.location.reload();
		}

	}	
	
async function displaydet_for_sec(apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,forced,resouceClass) 
	{

		var canc_appt_yn=document.forms[0].canc_appt_yn.value;
		var retVal = 	new String();
		var dialogHeight = "38" ;
		var dialogWidth  = "75" ;
		var dialogTop    = "83";
		var dialogLeft   = "0";
		var apptrefno 	   = apptrefno;
		var cliniccode1    = cliniccode1;
		var practitionerid = practitionerid;
		var apptdate 	   = apptdate;
		var overbookedyn   = overbookedyn;
		var apptslabfromtime    = apptslabfromtime;
		var apptslabtotime      = apptslabtotime;
		
		
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		retVal 	 	 = await window.showModalDialog("../../eOA/jsp/LinkSecondaryFrame.jsp?i_from_time="+apptslabfromtime+"&i_to_time="+apptslabtotime+"&i_appt_ref_no="+apptrefno+"&i_clinic_code="+cliniccode1+"&i_practitioner_id="+practitionerid+"&appt_day1="+appt_day1+"&i_appt_date="+apptdate+"&over_booked="+overbookedyn+"&Forced="+forced+"&res_type="+resouceClass,arguments,features); 
		
		if(retVal == 'closed'){
		parent.frames[2].document.location.reload();
		}
		else{parent.frames[2].document.location.reload();}
					
	}


async function show_CancelWin(apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,forced,title,locationType) 
	{
		
		var canc_appt_yn=document.forms[0].canc_appt_yn.value;
		var retVal = 	new String();
		var dialogHeight= "100vh" ;
		var dialogTop = "0px" ;
		var dialogWidth	= "75vw" ;
		var dialogLeft   = "0";
		var apptrefno 	   = apptrefno;
		var cliniccode1    = cliniccode1;
		var practitionerid = practitionerid;
		var apptdate 	   = apptdate;
		var overbookedyn   = overbookedyn;
		var apptslabfromtime    = apptslabfromtime;
		var apptslabtotime      = apptslabtotime;
		
		
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		
		retVal 	 	 = await top.window.showModalDialog("../../eOA/jsp/CancelAppointmentFrame.jsp?i_from_time="+apptslabfromtime+"&i_to_time="+apptslabtotime+"&i_appt_ref_no="+apptrefno+"&i_clinic_code="+cliniccode1+"&i_practitioner_id="+practitionerid+"&appt_day1="+appt_day1+"&i_appt_date="+apptdate+"&over_booked="+overbookedyn+"&Forced="+forced+"&clinic_type="+locationType,arguments,features); 
		
		if(retVal == 'closed'){
		parent.frames[2].document.location.reload();
		}
		else{parent.frames[2].document.location.reload();}
					
	}
function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
}
function callOnMouseOut(obj)
{
	obj.className = currClass; 
}
function hideToolTip()
{
	document.getElementById('tooltiplayer').style.visibility = 'hidden'
}

async function show_Reference_details(appt_no2,fac_id2)
{
var dialogHeight= "23" ;
var dialogWidth	= "54" ;
var dialogTop = "190" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
await window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

async function show_BookingWin(practitioner_name,tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,patientid,tfr_appt_yn,canc_appt_yn,book_appt_across_catg_yn,book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,create_wait_list_yn,time_table_type,referral_id,clinic_name,rd_appt_yn)
{

		var retVal = 	new String();
		var dialogHeight= "100vh" ;
		var dialogTop = "83" ;
		var dialogWidth	= "75vw" ;
		var status = "no";		
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
		var visit_limit_rule=parent.frames[2].document.forms[0].visit_limit_rule.value;
		var slot_appt_ctrl=parent.frames[2].document.forms[0].slot_appt_ctrl.value;
		var capture_fin_dtls_yn=parent.frames[2].document.forms[0].capture_fin_dtls_yn.value;
		var req_id="";
		var override_no_of_slots_yn=parent.frames[2].document.forms[0].override_no_of_slots_yn.value;
		var alcn_criteria=parent.frames[2].document.forms[0].alcn_criteria.value;
		//var clinic_name=parent.frames[2].document.forms[0].clinic_name.value;
		//var practitioner_name=parent.frames[2].document.forms[0].practitioner_name.value;
		var or_catalogue_code="";
		var ca_patient_id=patientid;
		var oper_stn_id="";
		var obvisit_flag="";
		var visit_flag_OP="";
		var	value8="";
		var rule_appl_yn = document.QueryApptForPatient.rule_appl_yn.value;		
		var callurl="../../eOA/jsp/BookAppointment.jsp?from_page=modifyappt&i_clinic_code="+cliniccode1+"&i_clinic_name="+clinic_name+"&i_practitioner_id="+practitionerid+"&i_practitioner_name="+practitioner_name+"&i_appt_date="+apptdate+"&i_from_time="+apptslabfromtime+"&i_to_time="+apptslabtotime+"&i_over_booked="+value8+"&i_time_table_type="+time_table_type+"&i_patient_id="+patientid+"&book_appt_across_catg_yn="+book_appt_across_catg_yn+"&book_appt_yn="+book_appt_yn+"&book_appt_wo_pid_yn="+book_appt_wo_pid_yn+"&obook_appt_yn="+obook_appt_yn+"&tfr_appt_yn="+tfr_appt_yn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&canc_appt_yn="+canc_appt_yn+"&alcn_criteria="+alcn_criteria+"&obvisit_flag="+obvisit_flag+"&ca_patient_id="+ca_patient_id+"&clinic_type="+locnType+"&res_type="+rsClass+"&or_catalogue_code="+or_catalogue_code+"&oper_stn_id="+oper_stn_id+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&override_no_of_slots_yn="+override_no_of_slots_yn+"&req_id="+req_id+"&create_wait_list_yn="+create_wait_list_yn+"&visit_flag_OP="+visit_flag_OP+"&capture_fin_dtls_yn="+capture_fin_dtls_yn+"&apptrefno="+apptrefno+"&referral_id="+referral_id+"&visit_type_ind="+visit_type_ind+"&rule_appl_yn="+rule_appl_yn+"&rd_appt_yn="+rd_appt_yn;
		retVal = await parent.parent.frames[1].window.showModalDialog(callurl,arguments,features);
		parent.frames[2].location.reload();
		hideToolTip();
}


async function show_TransferWin(practitioner_name,clinic_name,tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,speciality_code,appt_category,rd_appt_yn)
	{
		
		var flag=true;
		var rule_appl_yn = document.QueryApptForPatient.rule_appl_yn.value;
		if(rule_appl_yn =='Y' && rsClass =='P'/*&& (appt_category == '1' || appt_category == '3')*/){			
			if(window.confirm(getMessage("RESH_APPT_PRACT_UNKNOWN","OA"))){
				flag=false;	
				ruleBasedTransfer(practitioner_name,clinic_name,tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,speciality_code);
			}
			else{
				flag=true;				
			}
		}
		if(flag == true){

		var canc_appt_yn=document.forms[0].canc_appt_yn.value;
		var alcn_criteria=document.forms[0].alcn_criteria.value;
		var retVal = 	new String();
		var dialogHeight= "100vh" ;
		var dialogTop = "0" ;
		var dialogWidth	= "75vw" ;
		var dialogLeft   = "0";
		var apptrefno 	   = apptrefno;
		var cliniccode1    = cliniccode1;
		var practitionerid = practitionerid;
		var apptdate 	   = apptdate;
		var overbookedyn   = overbookedyn;
		var apptslabfromtime    = apptslabfromtime;
		var apptslabtotime      = apptslabtotime;		
	
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
		var arguments    = "" ;		
		var url="../../eOA/jsp/TransferAppointmentFrame.jsp?alcn_criteria="+alcn_criteria+"&i_from_time="+apptslabfromtime+"&i_to_time="+apptslabtotime+"&i_appt_ref_no="+apptrefno+"&i_clinic_code="+cliniccode1+"&i_practitioner_id="+practitionerid+"&new_appt_date="+apptdate+"&i_appt_date="+apptdate+"&appt_day1="+appt_day1+"&visit_type_ind="+visit_type_ind+"&i_team_id="+team_id+"&over_booked="+overbookedyn+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&Forced="+forced+"&clinic_type="+locnType+"&res_type="+rsClass+"&practitioner_name="+practitioner_name+"&clinic_name="+clinic_name+"&rd_appt_yn="+rd_appt_yn;
		retVal 	 	 = await window.showModalDialog(url,arguments,features);




			if(retVal == 'closed'){
			parent.frames[2].document.location.reload();
			}else{
			parent.frames[2].document.location.reload();
			}
		}
					
	}

	function callDummy()
	{
	}
function hideToolTip()
{
	document.getElementById('tooltiplayer').style.visibility = 'hidden'
}


function canc_appt(){
parent.window.returnValue='cancel';
parent.window.close();
}
function trans_appt(){
parent.window.returnValue='transfer';
parent.window.close();
}
function close_win(){
parent.window.returnValue='close';
parent.window.close();
}



 	async function show_window()
	{
		var patid=document.forms[0].patientid.value;
				var retVal = 	new String();
				var dialogHeight= "11.3" ;
				var dialogWidth	= "25" ;
				var status = "no";			
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; 	scroll=no; status:" + status; 
				retVal = await window.showModalDialog("../../eOA/jsp/BookAppointmentContact.jsp?mode=1&patient_id="+patid+"&contactvals="+document.forms[0].contactvals.value+"",arguments,features);
			}
function validate_date_from(obj,obj1)
{	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		var sysdt = parent.frames[1].document.forms[0].sys_date.value;
    //var obj2=convertDate(obj.value,"DMY","en",localeName);
		var obj2=convertDate(obj.value,"DMY",localeName,localeName);
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false; 
			}
			
	}
	
		


	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj.value,obj1.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}

function validate_date_to(obj,obj1)
{	
	if(obj.value!="")
	{
	if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
			var sysdt = parent.frames[1].document.forms[0].sys_date.value;	
      //var obj2=convertDate(obj.value,"DMY","en",localeName);
			var obj2=convertDate(obj.value,"DMY",localeName,localeName);
		if(isBefore(sysdt,obj2,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
	}

	if(obj.value!="" && obj1.value!="" )
		{
	
			if(isBefore(obj1.value,obj.value,'DMY',localeName)==false)
				{
				var msg = getMessage('TO_DT_GR_EQ_FM_DT','SM');
				alert(msg);
				obj.value="";
				obj.select();					
				return false;
			}
			else
				return true;
		}


}
// called only for bulk cancel part
	async function reasonlookup()
{
		var locale=document.forms[0].locale.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";

		var sql="Select CONTACT_REASON_CODE code, CONTACT_REASON description from AM_CONTACT_REASON_LANG_VW where cancel_Appointment_Yn = 'Y' and Eff_Status = 'E' and exclude_yn <> 'Y' and language_id = '"+locale+"' and upper(CONTACT_REASON_CODE) like upper(?) and upper(CONTACT_REASON) like upper(?) Order by 1";

		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		
		argumentArray[5] = document.forms[0].reason_code_cancel.value;
	
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC ; 
		retVal = await CommonLookup(getLabel("Common.reason.label","Common"), argumentArray );
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
		
			document.forms[0].reason_code_cancel.value=desc;
			document.forms[0].reason_for_cancellation.value=code;
		
		}else
		{
			
			document.forms[0].reason_for_cancellation.value="";
			document.forms[0].reason_code_cancel.value="";
	
		}
}
function show_second(obj,obj1)
{
	if(obj.checked==true)
	{
	}else
	{

	}
}

function apply()
{

	
	var finalval="";
	var cnt=frames[2].document.forms[0].cnt.value;
	for (var i=0;i<=cnt ;i++ )
		{
			if(eval("frames[2].document.forms[0].check_val"+i))
			{
				if(eval("frames[2].document.forms[0].check_val"+i).checked ==true)
				{
				finalval+= eval("frames[2].document.forms[0].final_val"+i).value+ "$";
				}
			}

		}
		if(finalval =="")
	{
			alert(getMessage("NO_RECORD_INSERTION","OA"));
			frames[3].location.href = "../../eCommon/jsp/error.jsp?err_num=0";
	}else
	{
		frames[2].document.forms[0].final_value.value=finalval;

		frames[2].document.forms[0].action="../../servlet/eOA.AppointmentDetailsServlet";
		frames[2].document.forms[0].target="messageFrame";
		frames[2].document.QueryApptForPatient.submit();
	}
}

function onsuccess(obj,obj2,err)
	{
		//parent.frames[3].location.href = "../eCommon/jsp/error.jsp";
		if(obj2==true)
		{
			alert(getMessage("APPT_CANCELLED","OA" ));
		    cliniccode	= parent.frames[1].document.forms[0].b_loc.value ;
			cliniccode = cliniccode.substring(2,cliniccode.length)
			practcode	= parent.frames[1].document.forms[0].practitioner.value ;
			apptfromdate	= parent.frames[1].document.forms[0].b_from_date.value ;
			appttodate	= parent.frames[1].document.forms[0].b_to_date.value ;
			var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
			var clinic_type=parent.frames[1].document.forms[0].b_loc1.value ;
			var res_type=parent.frames[1].document.forms[0].resourceType1.value ;
			var called_for=parent.frames[1].document.forms[0].called_for.value ;
			var function_id=document.forms[0].function_id.value;
			patientid="";patientname="";gender="";appt_ref_no="";called_for="";
			reason_for_cancellation=parent.frames[1].document.forms[0].reason_for_cancellation.value;
			var from=parent.frames[1].document.forms[0].from.value;
				var to=parent.frames[1].document.forms[0].to.value;
				var url='../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?patientid='+patientid+"&patientname="+patientname+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for+"&function_id="+function_id+"&reason_for_cancellation="+reason_for_cancellation+"&start_index="+from+"&end_index="+to;
					parent.frame2.location.href = url;
		}else
		{
			/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] Start*/
			if(err!=null && err!="undefined")
			alert(err);
			//alert(getMessage("APPT_CANCELLED","OA" ));
			/*Added By Dharma on 26th Nov 2014 against HSA-SCF-0145 [IN:051698] End*/
			if(parent.frames[1].document.forms[0]!=null){
				parent.frames[1].document.forms[0].reset();
			}
			parent.frame2.location.href = '../eCommon/html/blank.html';
		}
	  parent.frames[3].location.href = "../eCommon/jsp/error.jsp?err_num=";
	}

function submitPrevNext(from,to,obj)
{
	var finalval="";
	parent.frames[2].document.forms[0].cnt.value=from;
	for (var i=0;i<=from ;i++ )
		{
			if(eval("parent.frames[2].document.forms[0].check_val"+i))
			{
				if(eval("parent.frames[2].document.forms[0].check_val"+i).checked ==true)
				{
				finalval+= eval("parent.frames[2].document.forms[0].final_val"+i).value+ "$";
				}
			}

		}
			cliniccode	= parent.frames[1].document.forms[0].b_loc.value ;
			cliniccode = cliniccode.substring(2,cliniccode.length)
			practcode	= parent.frames[1].document.forms[0].practitioner.value ;
			apptfromdate	= parent.frames[1].document.forms[0].b_from_date.value ;
			appttodate	= parent.frames[1].document.forms[0].b_to_date.value ;
			var oper_stn_id=parent.frames[1].document.forms[0].oper_stn.value ;
			var clinic_type=parent.frames[1].document.forms[0].b_loc1.value ;
			var res_type=parent.frames[1].document.forms[0].resourceType1.value ;
			var called_for=parent.frames[1].document.forms[0].called_for.value ;
			var function_id=document.forms[0].function_id.value;
			patientid="";patientname="";gender="";appt_ref_no="";called_for="";
			reason_for_cancellation=parent.frames[1].document.forms[0].reason_for_cancellation.value;
			parent.frames[1].document.forms[0].from.value=from;
				parent.frames[1].document.forms[0].to.value=to;
			var from=from;
			var to=to;
		if(finalval =="")
	{
			parent.frames[3].location.href="../../eCommon/jsp/error.jsp?err_num=";
			
		parent.frame2.location.href = '../../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?patientid='+patientid+"&patientname="+patientname+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for+"&function_id="+function_id+"&reason_for_cancellation="+reason_for_cancellation+"&start_index="+from+"&end_index="+to;

	}else
	{
			if(confirm(getMessage('CANCEL_SELECTED_APPTS','OA')))
	{
		parent.frames[2].document.forms[0].final_value.value=finalval;
		parent.frames[2].document.forms[0].from_part.value="prenext";
		parent.frames[2].document.forms[0].action="../../servlet/eOA.AppointmentDetailsServlet";
		parent.frames[2].document.forms[0].target="messageFrame";
		parent.frames[2].document.QueryApptForPatient.submit();
		}else
		{
			parent.frame2.location.href = '../../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?patientid='+patientid+"&patientname="+patientname+"&gender="+gender+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&oper_stn_id="+oper_stn_id+"&clinic_type="+clinic_type+"&res_type="+res_type+"&called_for="+called_for+"&function_id="+function_id+"&reason_for_cancellation="+reason_for_cancellation+"&start_index="+from+"&end_index="+to;
		}
	}
	
}

function chk_not_iden_pract_value(obj)
{
	if(obj.checked==true)
	{
		document.forms[0].not_iden_pract.value="Y";
	}else
	{
		document.forms[0].not_iden_pract.value="N";
	}
}

async function open_loc_lookup(){
	var location_val=document.forms[0].b_loc_val.value;
	var locn_type=document.forms[0].b_loc1.value;
	var care_locn_ind=document.forms[0].b_loc1.value;
	
	//var dialogTop = "60" ;
	//var dialogHeight= "37" ;
	//var dialogWidth	= "60" ;
	var dialogHeight= "400px" ;
	var dialogTop = "10px" ;
	var dialogWidth	= "700px" ;
	var status = "no";
	var arguments	= "" ;
	var tit="locn_Srch";
	var retVal="";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&function_id=TRANSFER_CANCEL_APPT&displayAll=Y",arguments,features);
	
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=decodeURIComponent(rvalues[1]);
		var open_to_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].b_loc.value=open_to_all_pract_yn+"$"+code;
		var function_id=document.forms[0].function_id.value
		var called_for=parent.frames[1].document.forms[0].called_for.value ;
		if(function_id !="BULK_CANCEL" && called_for !="Link" ){		
			if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
				if(open_to_all_pract_yn =="N"){
					document.forms[0].not_iden_pract.checked=false;
					document.forms[0].not_iden_pract.disabled=true;
				}else{		
					if(locn_type=='D'){
						document.forms[0].not_iden_pract.checked=false;
						document.forms[0].not_iden_pract.disabled=true;
					}else{          
						document.forms[0].not_iden_pract.checked=false;
						document.forms[0].not_iden_pract.disabled=false;
					}
				}
			}
		}
	enablepract(document.forms[0].b_loc);
  }else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc.value="";
		enablepract(document.forms[0].b_loc);
	}

}


function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc.value="";	
		if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
			document.forms[0].not_iden_pract.checked=false;
			document.forms[0].not_iden_pract.disabled=true;
		}
		enablepract(document.forms[0].b_loc);
	}else{ 	
		if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT'){  // Added the condition for IN032044 on 29.02.2012 by Suresh M
			if(parent.frames[1].document.forms[0].resourceType1.value=='P')	{			
				document.forms[0].not_iden_pract.disabled=false;
			}else{ 			
				document.forms[0].not_iden_pract.disabled=true;			
			}
		}
	open_loc_lookup()
	}
}

function disableFields(){
var functionid=document.forms[0].functionid.value; 

document.forms[0].b_loc_val.disabled=true
document.forms[0].b_loc_search.disabled=true
if(document.forms[0].functionid.value=='TRANSFER_CANCEL_APPT' || document.forms[0].functionid.value=='RESCHEDULE_CANCELED_APPT'){ 
document.getElementById('patientMan').style.visibility = 'hidden'; 

if(document.forms[0].sel_with.value="A"){ 
var sysdate=document.forms[0].sys_date.value;
var sysdate1=document.forms[0].sysdate1.value;
document.forms[0].b_from_date.value=sysdate;
document.forms[0].b_to_date.value=sysdate1; 
}
}
}
function CheckMandatory(obj){
	if(obj.value=="W")
	{
		document.getElementById('patientMan').style.visibility = 'visible';
		document.getElementById('dategif').style.visibility = 'hidden';
		document.forms[0].b_from_date.value="";
        document.forms[0].b_to_date.value="";
	}
  else if(obj.value=="A")
	{
		document.getElementById('patientMan').style.visibility = 'hidden';
		document.getElementById('dategif').style.visibility = 'visible';
		
        var sysdate=document.forms[0].sys_date.value;
        var sysdate1=document.forms[0].sysdate1.value;
        document.forms[0].b_from_date.value=sysdate;
        document.forms[0].b_to_date.value=sysdate1;
}
}
async function ruleBasedTransfer(practitioner_name,clinic_name,tfr_appt_across_catg_yn,apptrefno,cliniccode1,practitionerid,apptdate,overbookedyn,apptslabfromtime,apptslabtotime,appt_day1,visit_type_ind,team_id,forced,rsClass,locnType,speciality_code)
{
	
	//alert("speciality_desc-------->"+speciality_desc);
	//alert("speciality_code-------->"+speciality_code);
	
	var retVal = 	new String();
	var dialogHeight = "30" ;
	var dialogWidth  = "80" ;
	var dialogTop    = "260";	
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:" +dialogTop+ "; scrolling:no; status=no";
	var arguments    = "" ;	
	var url	= 	"../../eOA/jsp/RuleBasedTransferFrame.jsp?speciality_code="+speciality_code+"&practitioner_name="+practitioner_name+"&clinic_name="+clinic_name+"&tfr_appt_across_catg_yn="+tfr_appt_across_catg_yn+"&apptrefno="+apptrefno+"&cliniccode1="+cliniccode1+"&practitionerid="+practitionerid+"&apptdate="+apptdate+"&overbookedyn="+overbookedyn+"&apptslabfromtime="+apptslabfromtime+"&apptslabtotime="+apptslabtotime+"&appt_day1="+appt_day1+"&visit_type_ind="+visit_type_ind+"&team_id="+team_id+"&forced="+forced+"&rsClass="+rsClass+"&locnType="+locnType;
	retVal 	 	 = await window.showModalDialog(url,arguments,features);
	parent.frames[2].document.location.reload();
}


/*Below Functions Added for this CRF [Bru-HIMS-CRF-0166]*/

//included one more parameter rd_appt_yn by shanthi on 7/12/2012
function reschdisplayToolTip(apptrefno,cliniccode1,practitionerid,apptdate,from_facility_id,P_patient_id,P_locn_type,rd_appt_yn,isSlotStartMidEndAppl,ext_cncl_yn){
		  
reschbuildTable(apptrefno,cliniccode1,practitionerid,apptdate,from_facility_id,P_patient_id,P_locn_type,rd_appt_yn,isSlotStartMidEndAppl,ext_cncl_yn)		//included one more parameter rd_appt_yn by shanthi on 7/12/2012
		bodwidth  = parent.parent.frames[1].document.body.offsetWidth
		bodheight = parent.parent.frames[1].document.body.offsetHeight
		//Modified against INC:49319
		var x 	  = event.clientX
		var y 	  = event.clientY;
		
		x 	  = x + (document.getElementById('tooltiplayer').offsetWidth)
		y 	  = y + (document.getElementById('tooltiplayer').offsetHeight)

		if(x<bodwidth)
			x = event.clientX 
		else
			x = x - (document.getElementById('tooltiplayer').offsetWidth)
		if(y<bodheight)
			y = event.clientY
		else
			y = y - (document.getElementById('tooltiplayer').offsetHeight)
				
		y+=document.body.scrollTop
		x+=document.body.scrollLeft

		x=-24;
		y=y-5;
		document.getElementById("tooltiplayer").style.left= x+"px";
		document.getElementById("tooltiplayer").style.top = y+"px";	 
		document.getElementById("tooltiplayer").style.visibility='visible' 
		
}


function reschbuildTable(apptrefno,cliniccode1,practitionerid,apptdate,from_facility_id,P_patient_id,P_locn_type,rd_appt_yn,isSlotStartMidEndAppl,ext_cncl_yn)	
{ 
	

		var tab_dat  = "<table id='tooltiptable1' cellpadding=0 cellspacing=0 border='0'   class='BOX' width='100%' height='100%' align='center'>"
		
		
			tab_dat     += "<tr>";
		
            tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:bookAppt('"+apptrefno+"','"+cliniccode1+"','"+practitionerid+"','"+apptdate+"','"+from_facility_id+"','"+P_patient_id+"','"+P_locn_type+"','"+rd_appt_yn+"','"+isSlotStartMidEndAppl+"','"+ext_cncl_yn+"')>"+getLabel("Common.bookappointment.label","Common")+"</a></td>";		    	//included one more parameter rd_appt_yn by shanthi on 7/12/2012		
			tab_dat     += "</tr>";
		
		
							
				tab_dat     += "<tr>";
			
                tab_dat     += "<td class = 'PATTOOLTIPS' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a href=javascript:createWtList('"+apptrefno+"','"+cliniccode1+"','"+practitionerid+"','"+apptdate+"','"+from_facility_id+"','"+P_patient_id+"','"+P_locn_type+"')>"+getLabel("Common.CreateWaitList.label","Common")+"</a></td>";									  
				tab_dat     += "</tr>";
	
				
			
			
	
	tab_dat     += "</table>";

	document.getElementById('t').innerHTML = tab_dat;
	

	
}
async function bookAppt(apptrefno,cliniccode1,practitionerid,apptdate,from_facility_id,P_patient_id,P_locn_type,rd_appt_yn,isSlotStartMidEndAppl,ext_cncl_yn){//included one more parameter rd_appt_yn by shanthi on 7/12/2012

	if(isSlotStartMidEndAppl == "true" && ext_cncl_yn == 'Y')
	{
		alert(getMessage("CANNOT_REBOOK","OA" ));
	}else
	{

	var selectedLocnCode="";	
	var selectedPractId="";
	var splty_code	="";
	var referral_id="";
	var from_encounter_id = "";
	var callingMode="OP";
	
    var retVal = 	new String();
		var dialogHeight= "100vh" ;
		var dialogWidth = "90vw" ;
		var dialogTop 	= "0vh";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	   
		var h="i_practitioner_id="+practitionerid+"&practitioner_id="+practitionerid+"&patient_id="+P_patient_id+"&i_clinic_code="+cliniccode1+"&clinic_code="+cliniccode1+"&recall_date="+apptdate+"&location_code="+cliniccode1+"&care_locn_ind="+P_locn_type+"&specialty_code="+splty_code+"&selectedPractId="+selectedPractId+"&selectedLocnCode="+selectedLocnCode+"&referral_id="+referral_id+""+"&from_facility_id="+from_facility_id+"&from_encounter_id="+from_encounter_id+"&apptrefno="+apptrefno;	
		h=h+ "&callingMode=RSCAPPT&visit_flag_OP=Y"+"&rd_appt_yn="+rd_appt_yn;		
		//alert(h)


		retVal = await top.window.showModalDialog("../../eOA/jsp/CAOAWrapper.jsp?"+h,arguments,features);
		
		/*if (retVal != null)
		{  
			var returnVal = retVal.split("^");
			var mode = returnVal[0];
			h = returnVal[1];
			h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');					
			retVal = window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);
			
			}*/
	

		parent.frames[2].document.location.reload();
	}

}
function createWtList(apptrefno,cliniccode1,practitionerid,apptdate,from_facility_id,P_patient_id,P_locn_type){
 	
 if(apptdate !="")
{     var flag=true;	
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr	="<root><SEARCH locncode=\""+cliniccode1+"\" practid=\""+practitionerid+"\" date_val=\""+apptdate+"\" steps='validatepref_date_wait_list'/></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		eval(responseText)
		if(wtlt_Flag==1)
			{   
				var error=getMessage("WAIT_LIST_NOT_ALLW","OA");
				alert(error);
				flag=false;
			}
         if(flag){
		if(confirm(getMessage("DO_YOU_CREATE_WAIT_LIST","OA"))){
		var HTMLVal = "<html><body onKeyDown='lockKey();'><form name='rescheduleappt' id='rescheduleappt' method='post' action='../../servlet/eOA.AppointmentWtListServlet'><input type='hidden' name='Operation' id='Operation' value='Reschedule'><input type='hidden' name='apptrefno' id='apptrefno' value='"+apptrefno+"'></form></body></html>";	
		parent.frames[2].document.write(HTMLVal);		
		parent.frames[2].document.rescheduleappt.submit();		
		}
	}
	
		}
		
		

				
				
}

//End [Bru-HIMS-CRF-0166]




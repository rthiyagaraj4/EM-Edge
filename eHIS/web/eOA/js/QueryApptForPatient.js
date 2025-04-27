function callResult()
{
	var short_desc='';
    appt_ref_no = parent.frames[1].document.forms[0].b_appt_ref_no.value ;
    patientid	= parent.frames[1].document.forms[0].b_patient_id.value ;
	resource_type=parent.frames[1].document.forms[0].resourceType_1.value ;
	care_locn1	= parent.frames[1].document.forms[0].location_type.value ;
	var function_id=parent.frames[1].document.forms[0].function_id.value;
	/*below line Added for this CRF [RUT-CRF-0011]*/
	var patcat_code="";
	if(parent.frames[1].document.forms[0].pat_cat_desc.value)	
	patcat_code	= parent.frames[1].document.forms[0].pat_cat_code.value ;
	
	
//	alert(function_id)
	if(!(care_locn1==null) || !(care_locn1=='')){
	care_locn=care_locn1.substring(2,3);
	
	
	}
	cliniccode	= parent.frames[1].document.forms[0].b_loc.value ;
    cliniccode = cliniccode.substring(2,cliniccode.length)
	practcode	= parent.frames[1].document.forms[0].practitioner.value ;
	apptfromdate	= parent.frames[1].document.forms[0].b_from_date.value ;
	appttodate	= parent.frames[1].document.forms[0].b_to_date.value ;
	var patientname	= parent.frames[1].document.forms[0].patientName.value ;
	var speciality  = parent.frames[1].document.forms[0].b_speciality.value ;
	var facility	= parent.frames[1].document.forms[0].facility.value ; // Line Modified for this CRF:  Bru-HIMS-CRF-302 [IN:035020]  
	var incld_past_appts	= parent.frames[1].document.forms[0].incld_past_appts.value ;
	var oth_contact_no = parent.frames[1].document.forms[0].b_mobileno.value ;
	var order = parent.frames[1].document.forms[0].asc_desc.value ;
	var orderCriteria = parent.frames[1].document.forms[0].orderCriteria.value ;


	var names=new Array ();
	var fields=new Array ();
	
	var frmnam= parent.frames[0].name;
	if(frmnam=='commontoolbarFrame'){
		 fields = new Array ( parent.frames[1].document.forms[0].sel_with);

		 names = new Array ( getLabel("eOA.SearchWith.label","OA"));

	
		if(parent.frames[1].document.forms[0].sel_with.value=="W")
		{
			fields = new Array ( parent.frames[1].document.forms[0].b_patient_id);
			names = new Array ( getLabel("Common.patientId.label","Common"));
		}else if(parent.frames[1].document.forms[0].sel_with.value=="A")
		{
			if(parent.frames[1].document.forms[0].b_from_date.value=='' && parent.frames[1].document.forms[0].b_to_date.value=='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_from_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
			else if(parent.frames[1].document.forms[0].b_from_date.value=='' && parent.frames[1].document.forms[0].b_to_date.value!='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_from_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
			else if(parent.frames[1].document.forms[0].b_from_date.value!='' && parent.frames[1].document.forms[0].b_to_date.value=='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_to_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
		}


		
		if(!parent.frames[1].checkFields( fields, names, parent.messageFrame)){

			parent.frame2.location.href ='../../eCommon/html/blank.html';
			parent.frame3.location.href ='../../eCommon/html/blank.html';
		}else{
			


			parent.frames[1].document.forms[0].select.disabled=true;
			//parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			if(parent.frames[1].document.forms[0].b_patient_id.value !="")
			{
				var locale=parent.frames[1].document.forms[0].locale.value;
			parent.frame3.location.href ='../../eCommon/jsp/pline.jsp?Patient_Id='+patientid+'&locale='+locale;
			//parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id;
			parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id+"&patcat_code="+patcat_code+"&facility="+facility; // Added for this CRF:  Bru-HIMS-CRF-302 [IN:035020]
			
;
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}else
			{
			parent.frame3.location.href ='../../eCommon/html/blank.html';
			//parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id;
			parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id+"&patcat_code="+patcat_code+"&facility="+facility;// Added for this CRF:  Bru-HIMS-CRF-302 [IN:035020]
			
;
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			}
			
		}
	}else{
			if(parent.frames[1].document.forms[0].module_id.value =="CA" ||  parent.frames[1].document.forms[0].patient_id_ca.value =="" )
			{

				fields = new Array ( parent.frames[1].document.forms[0].sel_with);
				 names = new Array ( getLabel("eOA.SearchWith.label","OA"));

	
		if(parent.frames[1].document.forms[0].sel_with.value=="W")
		{
			if (parent.frames[1].document.forms[0].patient_id_ca.value==""||parent.frames[1].document.forms[0].patient_id_ca.value==null)
			{
				//6/2008/aug b_patient_id modified in fields array
							fields = new Array ( parent.frames[1].document.forms[0].b_patient_id);
							names = new Array (  getLabel("Common.patientId.label","Common"));
			}
		}
		
		/*else if(parent.frames[1].document.forms[0].sel_with.value=="A")
		{
			fields = new Array ( parent.frames[1].document.forms[0].b_from_date,
								parent.frames[1].document.forms[0].b_to_date);
			names = new Array (getLabel("Common.fromdate.label","Common"),
								getLabel("Common.todate.label","Common"));
		}*/
		else if(parent.frames[1].document.forms[0].sel_with.value=="A")
		{
			if(parent.frames[1].document.forms[0].b_from_date.value=='' && parent.frames[1].document.forms[0].b_to_date.value=='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_from_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
			else if(parent.frames[1].document.forms[0].b_from_date.value=='' && parent.frames[1].document.forms[0].b_to_date.value!='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_from_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
			else if(parent.frames[1].document.forms[0].b_from_date.value!='' && parent.frames[1].document.forms[0].b_to_date.value=='' )
			{
			fields = new Array ( parent.frames[1].document.forms[0].b_to_date);
								
			names = new Array ( getLabel("Common.apptdate.label","Common"));
			}
		}
				if(!parent.frames[1].checkFields( fields, names, parent.parent.messageFrame))
			{
								parent.frame2.location.href ='../../eCommon/html/blank.html';
								parent.frame3.location.href ='../../eCommon/html/blank.html';

			}
			else{
			parent.frames[1].document.forms[0].select.disabled=true;
			//parent.frames[4].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			// 6/2008/aug Message frame code appended
			var locale=parent.frames[1].document.forms[0].locale.value;
			
			parent.frame3.location.href ='../../eCommon/jsp/pline.jsp?Patient_Id='+patientid+'&locale='+locale;
			//parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id;
			
			parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id+"&patcat_code="+patcat_code+"&facility="+facility;// Added for this CRF:  Bru-HIMS-CRF-302 [IN:035020]
			
			
;

			parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp';
			
			}
			}else if( parent.frames[1].document.forms[0].patient_id_ca.value !="null" )
			{
			parent.frames[1].document.forms[0].select.disabled=true;
//			parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			
			parent.frames[2].location.href ='../../eCommon/jsp/pline.jsp?Patient_Id='+patientid;
			//parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id;
			
			parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&incld_past_appts="+incld_past_appts+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id+"&patcatcode="+patcat_code+"&facility="+facility;// Added for this CRF:  Bru-HIMS-CRF-302 [IN:035020]
			
			
;
			}else if(parent.frames[1].document.forms[0].module_id.value =="CA" && parent.frames[1].document.forms[0].patient_id_ca.value =="null" )
			{  
			parent.frames[1].document.forms[0].select.disabled=true;
			parent.parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			
			//parent.frame2.location.href = '../../eOA/jsp/QueryApptForPatientResult.jsp?patientid='+patientid+"&cliniccode="+cliniccode+"&practcode="+practcode+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&appt_ref_no="+appt_ref_no+"&speciality="+speciality+"&care_locn="+care_locn+"&resource_type="+resource_type+"&short_desc="+short_desc+"&patientname="+patientname+"&oth_contact_no="+oth_contact_no+"&order="+order+"&orderCriteria="+orderCriteria+"&function_id="+function_id;
;
			}
	}
}	

function reset()
{    
	
	var frmnam= parent.frames[0].name;
	 if(frmnam=='header')
	{
		frame1.location.href 		= '../../eOA/jsp/QueryApptForPatientCriteria.jsp' ;
		frame3.location.href= '../../eCommon/html/blank.html' ;
		frame2.location.href= '../../eCommon/html/blank.html' ;
	}else
	{
		frame1.location.href 		= '../../eOA/jsp/QueryApptForPatientCriteria.jsp' ;
		parent.frame2.location.href= '../../eCommon/html/blank.html' ;
		parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
	}
}




async function patqry() {
	var pat_id=await PatientSearch();
	if(pat_id == null) pat_id = "";
	parent.frames[1].document.forms[0].b_patient_id.value=pat_id;
	
}
function validate_date(ref) {
        var error_id;   

	if(ref == "FROM_DATE_LESS_SYSDATE" )
	{
	    from = parent.frames[1].document.forms[0].b_from_date;
	    to = parent.frames[1].document.forms[0].sys_date;
	    error_id = getMessage('FROM_DATE_LESS_SYSDATE','SM');
	    	    	    		
	}
	else if(ref == "TO_DT_GR_EQ_FM_DT")
	{
	  from = parent.frames[1].document.forms[0].b_to_date;
	  to = parent.frames[1].document.forms[0].b_from_date;
	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	}
	else if(ref == "TO_DATE_LESS_FROM")
	{
	  from = parent.frames[1].document.forms[0].b_to_date;
	  to = parent.frames[1].document.forms[0].b_from_date;

	  error_id = getMessage('TO_DT_GR_EQ_FM_DT','SM');
	}
	var fromarray;
	var toarray;
	var fromdate = eval(from).value ;
	var todate = eval(to).value ;
	if(fromdate.length > 0 && todate.length > 0 ) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		//if(Date.parse(todt) > Date.parse(fromdt)) {
if(!DateCompare4(parent.frames[1].document.forms[0].sys_date,parent.frames[1].document.forms[0].b_from_date)){
		   var invaldt =getMessage("FROM_DATE_LESS_SYSDATE",'SM') ;
		alert(invaldt);
		parent.frames[1].document.forms[0].b_from_date.focus();
		parent.frames[1].document.forms[0].b_from_date.value="";
	
		} else if(!DateCompare4(parent.frames[1].document.forms[0].b_from_date,parent.frames[1].document.forms[0].b_to_date))
		{
			var invaldt =getMessage("TO_DT_GR_EQ_FM_DT",'SM') ;
				alert(invaldt);
				from.focus();
				from.value="";
		}
	}
	return true;
}


function query(){
}



		function assign_hidden(obj){
	
		document.forms[0].practitioner.value=obj.value;
		}
		function ena_pract(Obj)
		{         
		parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
		document.getElementById('resourceType_1').value='';
		document.getElementById('practitioner_name').value='';
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
		document.getElementById('practitioner').value='';

		document.getElementById('location_code1').value= document.forms[0].b_loc.value;

		if(Obj.value==''){
			document.getElementById('resourceType_1').disabled=true;
		}else{
			document.getElementById('resourceType_1').disabled=false;
		}

		}

		function enable_dsiable_res(Obj){
			parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
			document.getElementById('practitioner').value='';
			document.getElementById('practitioner_name').value='';

			document.getElementById('resourceType1').value=document.getElementById('resourceType_1').value;

		if(Obj.value!='' && Obj.value!='B'){
		
			if(document.forms[0].b_loc.value !='' && document.forms[0].b_loc.value !=null){ 
				
			document.getElementById('practitioner_name').disabled=false;
			document.getElementById('search_pract').disabled=false;
			}
		}else{
			document.getElementById('practitioner_name').disabled=true;
			document.getElementById('search_pract').disabled=true;
		}

		}

		function populateLocations(Obj){
			if(Obj.value==null || Obj.value==""){
			document.getElementById('b_loc_val').value="";
			document.getElementById('b_loc_val').disabled=true;
			document.getElementById('b_loc_search').disabled=true;
			document.getElementById('b_loc').value="";
			ena_pract(document.forms[0].b_loc);
			}else{
			document.getElementById('b_loc_val').value="";
			document.getElementById('b_loc').value="";
			document.getElementById('b_loc_val').disabled=false;
			document.getElementById('b_loc_search').disabled=false;
			ena_pract(document.forms[0].b_loc);
			}
	
		/*parent.frames[2].location.href = '../../eCommon/html/blank.html' ;
		document.getElementById('practitioner_name').value='';
		document.getElementById('practitioner_name').disabled=true;
		document.getElementById('search_pract').disabled=true;
		document.getElementById('practitioner').value='';
	//	document.forms[0].resourceType_1.disabled=false;
		
		document.getElementById('resourceType_1').value='';
	

		var location1=document.forms[0].location_type.value;
		location1 = location1.split("|");
		locations=location1[0];

		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH clinic_type=\""+locations+"\" steps='7' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","ServerSide.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		responseText = trimString(responseText)
		eval(responseText)*/ 

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


 
	 function clearvals() {
	//	document.forms[0].reset();
		document.forms[0].select.disabled=false;
		if(parent.frames[0].name !="dummy1")
		 {
		if(parent.frames[1].document.forms[0].module_id.value!="CA")
		 {
			//reset function appended 6-2008-aug Code appended for 
		//parent.frame1.document.QueryApptForPatient.reset() ;
		parent.frame3.location.href='../../eCommon/html/blank.html' ;
		parent.frame2.location.href= '../../eCommon/html/blank.html' ;
		parent.frames[4].location.href="../../eCommon/jsp/error.jsp?err_num=";		
		 }
		 }else
		 {
			 if(parent.frames[1].document.forms[0].patient_id_ca.value !="")
			 {
			//parent.frame1.location.href 		= '../../eOA/jsp/QueryApptForPatientCriteria.jsp' ;
			parent.frame1.document.forms[0].b_appt_ref_no.value="";
				parent.frame1.document.forms[0].b_from_date.value="";
				parent.frame1.document.forms[0].b_to_date.value="";
				parent.frame1.document.forms[0].b_speciality.value="";
				parent.frame1.document.forms[0].location_type.value="";
				parent.frame1.document.forms[0].b_loc.value="";
				parent.frame1.document.forms[0].resourceType_1.value="";
				parent.frame1.document.forms[0].resourceType_1.disabled=true;
				parent.frame1.document.forms[0].practitioner_name.value="";
				parent.frame1.document.forms[0].practitioner.value="";
			parent.frame2.location.href= '../../eCommon/html/blank.html' ;
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			 }else
			 {
				 var module_id=parent.frame1.document.forms[0].module_id.value;
			parent.frame1.location.href 		= '../../eOA/jsp/QueryApptForPatientCriteria.jsp?module_id='+module_id  ;
			parent.frame2.location.href= '../../eCommon/html/blank.html' ;
					parent.frame3.location.href='../../eCommon/html/blank.html' ;

			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
			 }
		 }
		}


function show_Reference_details(appt_no2,fac_id2)
{
var dialogHeight = "20" ;
var dialogWidth	= "50" ;
var dialogTop = "160" ;
var center = "1" ;
var status="no";
var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
var arguments	= "" ;
window.showModalDialog("../../eOA/jsp/SecApptReferenceFrame.jsp?appt_no2="+appt_no2+"&fac_id2="+fac_id2,arguments,features);
}

function visman(obj)
{
	var incld_past_appts=document.forms[0].incld_past_appts;
	if(obj.value=="W")
	{
		document.getElementById('patientMan').style.visibility = 'visible';
		document.getElementById('fromdategif').style.visibility = 'hidden';
		document.getElementById('todategif').style.visibility = 'hidden';
		document.forms[0].patientName.value="";
		document.forms[0].patientName.readOnly=true;
		document.forms[0].incld_past_appts.disabled=false;
		document.forms[0].incld_past_appts.value='N';
		document.forms[0].b_from_date.value="";
        document.forms[0].b_to_date.value="";	
	}else if(obj.value=="A")
	{

		document.getElementById('fromdategif').style.visibility = 'visible';
		document.getElementById('todategif').style.visibility = 'visible';
		document.getElementById('patientMan').style.visibility = 'hidden';
		document.forms[0].patientName.readOnly=false;
		var sysdate=document.forms[0].sys_date.value;
        var sysdate1=document.forms[0].sysdate1.value;
        document.forms[0].b_from_date.value=sysdate;
        document.forms[0].b_to_date.value=sysdate1;
		if (incld_past_appts.checked==true)
		{
          incld_past_appts.checked=false;
          incld_past_appts.value='';
		}
		else
          incld_past_appts.value='';
		 document.forms[0].incld_past_appts.disabled=true;
	}else
	{
		document.getElementById('patientMan').style.visibility = 'hidden';
		document.getElementById('fromdategif').style.visibility = 'hidden';
	    document.getElementById('todategif').style.visibility = 'hidden';
	    document.forms[0].patientName.readOnly=true;
	    document.forms[0].patientName.value="";
        document.forms[0].incld_past_appts.disabled=true;
	    document.forms[0].b_from_date.value="";
        document.forms[0].b_to_date.value="";
	}
}

function chkmangif()
{

	document.getElementById('b_loc_val').disabled=true;
	document.getElementById('b_loc_search').disabled=true;
	document.getElementById('patientMan').style.visibility = 'hidden';
	document.getElementById('fromdategif').style.visibility = 'visible';
	document.getElementById('todategif').style.visibility = 'visible';
	
	if(document.forms[0].patient_id_ca.value !="" && document.forms[0].module_id.value !="")
	{
		document.forms[0].patientName.readOnly=true;
	}else if(document.forms[0].patient_id_ca.value =="" && document.forms[0].module_id.value =="CA")
	{
		document.forms[0].patientName.readOnly=false;
	}
	if(document.forms[0].sel_with.value="A"){
    var sysdate=document.forms[0].sys_date.value;
    var sysdate1=document.forms[0].sysdate1.value;
    document.forms[0].b_from_date.value=sysdate;
     document.forms[0].b_to_date.value=sysdate1;
}
}





function DateCompare_from(obj2,obj,Sys_date)
{

if(obj.value!="")
		{
		if(!validDateObj(obj,"DMY",localeName))
		{
			obj.value="";
			return ;
		}
		else{
		//var obj1=convertDate(obj.value,"DMY",localeName,"en");
		
if(obj2 =="from")
			{
			if(isBefore(Sys_date,obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("FROM_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
				return false;
			}
			else
				return true;

			}else
			{
					if(isBefore(Sys_date,obj.value,'DMY',localeName)==false)
				{
				alert(getMessage("TO_DATE_LESS_SYSDATE","SM"));
				obj.value="";
				obj.select();	
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


function ValidateDate_from(from,to)
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



	function DateCompare4(from,to)
{
	if(from.value!="" && to.value!="" )
		{
	
			if(isBefore(from.value,to.value,'DMY',localeName)==false)
				{
							
				return false;
			}
			else
				return true;
		}

}

function checkValues(obj)
{
var patientid	= parent.frames[1].document.forms[0].b_patient_id.value ;
//alert("patientid==>in Check" +patientid);
if (obj.checked==true)
{
	obj.value="Y";
}
else
{
	obj.value="N";

}

}

async function open_loc_lookup(){
	var facility = document.forms[0].facility.value; // Added for this CRF:  Bru-HIMS-CRF-302 [IN:035020]
	var location1=document.forms[0].location_type.value;
	var speciality_code=document.forms[0].b_speciality.value;
	var location_val=document.forms[0].b_loc_val.value;
	location1 = location1.split("|");
	locn_type=location1[1];
	var care_locn_ind=location1[0];
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
	retVal = await window.showModalDialog("../../eOA/jsp/OALocationlookupframe.jsp?locn_type="+locn_type+"&speciality_code="+speciality_code+"&location_val="+encodeURIComponent(location_val)+"&care_locn_ind="+care_locn_ind+"&facility="+facility+"&function_id=QRY_APPT_PAT",arguments,features);
	if(retVal!=null){
		var rvalues=retVal.split("~");
		var code=rvalues[0];
		var desc=rvalues[1];
		var open_all_pract_yn=rvalues[2];
		document.forms[0].b_loc_val.value=desc;
		document.forms[0].b_loc.value=open_all_pract_yn+"$"+code;
		ena_pract(document.forms[0].b_loc);
	}else{
		document.forms[0].b_loc_val.value="";
		document.forms[0].b_loc.value="";
		ena_pract(document.forms[0].b_loc);
	}
}

function ena_loc_lookup(obj){
		if(obj.value==null || obj.value==''){
			document.forms[0].b_loc.value="";
			ena_pract(document.forms[0].b_loc);
			document.getElementById('resourceType_1').disabled=true;
	}else{
	open_loc_lookup()
	}
}

function sort(sortVal,order)
{

 	var module_id = document.getElementById('MODULE_ID').value;	
	if(module_id == 'PH') {

		var patient_id = document.getElementById('patientid').value;
		var apptfromdate = document.getElementById('apptfromdate').value;
		var appttodate = document.getElementById('appttodate').value;		

		document.location.href = "../../eOA/jsp/QueryApptForPatientResult.jsp?patientid="+patient_id+"&apptfromdate="+apptfromdate+"&appttodate="+appttodate+"&incld_past_appts=Y&MODULE_ID=PH&orderCriteria="+sortVal+"&appt_ref_no="+order+"&orderCriteria_sensor="+sortVal; 

	} else {


	var prev=parent.frames[1].document.QueryApptForPatient.orderCriteria_sensor.value
		
	if(prev==sortVal)
	{
		var toggle=parent.frames[1].document.QueryApptForPatient.asc_desc.value;


			if(toggle.value==' asc')
				{	
			     	toggle.value=' desc';

				}
				else
				{
					toggle.value=' asc';
				}
	}

	else{
	parent.frames[1].document.QueryApptForPatient.asc_desc.value=' asc';

	}
	parent.frames[1].document.QueryApptForPatient.orderCriteria.value=sortVal;
	parent.frames[1].document.QueryApptForPatient.orderCriteria_sensor.value=sortVal;
   parent.frames[1].document.QueryApptForPatient.appt_ref_no.value=order;
	
	callResult();	
	
	parent.frames[1].document.QueryApptForPatient.orderCriteria.value='';
   	parent.frames[1].document.QueryApptForPatient.appt_ref_no.value='';

	}

}

function hideAllGifs(sortVal){


document.forms[0].apptnoGif.style.visibility='hidden';
document.forms[0].patientGif.style.visibility='hidden';
document.forms[0].patnameGif.style.visibility='hidden';
document.forms[0].genderGif.style.visibility='hidden';
document.forms[0].ageGif.style.visibility='hidden';
document.forms[0].mobileGif.style.visibility='hidden';
//document.forms[0].apptdateGif..visibility='hidden';
//document.forms[0].todateGif.style.visibility='hidden'; 
document.forms[0].durationGif.style.visibility='hidden'; 
document.forms[0].visittypeGif.style.visibility='hidden'; 
document.forms[0].locationGif.style.visibility='hidden'; 
document.forms[0].resourceGif.style.visibility='hidden'; 
document.forms[0].specialityGif.style.visibility='hidden'; 
document.forms[0].ordercatalogGif.style.visibility='hidden'; 
document.forms[0].referralidGif.style.visibility='hidden'; 
document.forms[0].apptgnGif.style.visibility='hidden'; 
document.forms[0].apptgoGif.style.visibility='hidden'; 
document.forms[0].statusGif.style.visibility='hidden'; 
document.forms[0].lastmbGif.style.visibility='hidden'; 
document.forms[0].lastmoGif.style.visibility='hidden'; 

}
function toggleGifs(sortVal, order){

if(sortVal=="apptno")
		{
			if(document.getElementById("apptnoGif")!=null)
			{
			     document.getElementById("apptnoGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].apptnoGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].apptnoGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="patientId")
		{
		     if(document.getElementById("patientGif")!=null)
			{
				document.getElementById("patientGif").style.visibility='visible';

				if(order==' asc')					
					document.forms[0].patientGif.src =  '../../eAE/images/Ascending.gif';
				else
					document.forms[0].patientGif.src = '../../eAE/images/Ascending.gif';
			}
		}
else if(sortVal=="PatientName")
		{
	        if(document.getElementById("patnameGif")!=null)
			{
				document.getElementById("patnameGif").style.visibility='visible';

				if(order==' asc')				
					document.forms[0].patnameGif.src = '../../eAE/images/Ascending.gif';
				else
					document.forms[0].patnameGif.src = '../../eAE/images/Ascending.gif';
			}
		}

else if(sortVal=="gender")
		{
			if(document.getElementById("genderGif")!=null)
			{
				document.getElementById("genderGif").style.visibility='visible';

				if(order==' asc')
					document.forms[0].genderGif.src =  '../../eAE/images/Ascending.gif';
				else
					document.forms[0].genderGif.src =  '../../eAE/images/Ascending.gif';
			}
		
		}

else if(sortVal=="age")
		{
			if(document.getElementById("ageGif")!=null)
			{
				document.getElementById("ageGif").style.visibility='visible';
			
				if(order==' asc')
					document.forms[0].ageGif.src = '../../eAE/images/Ascending.gif';
				else
					document.forms[0].ageGif.src = '../../eAE/images/Ascending.gif';
			}
		}

else if(sortVal=="MobileNo")
		{
			if(document.getElementById("mobileGif")!=null)
			{				
				document.getElementById("mobileGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].mobileGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].mobileGif.src = '../../eAE/images/Descending.gif';
			}
		}

else if(sortVal=="apptdate")
		{
	        if(document.getElementById("apptdateGif")!=null)
			{
				document.getElementById("apptdateGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].apptdateGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].apptdateGif.src = '../../eAE/images/Descending.gif';
			}
		}

else if(sortVal=="fromtime")
		{
			if(document.getElementById("fromdateGif")!=null)
			{
				document.getElementById("fromdateGif").style.visibility='visible';

				if(order==' asc')
						document.forms[0].fromdateGif.src = '../../eAE/images/Ascending.gif';
				else
						document.forms[0].fromdateGif.src = '../../eAE/images/Descending.gif';
			}
		}

else if(sortVal=="totime")
		{
			if(document.getElementById("todateGif")!=null)
			{
				document.getElementById("todateGif").style.visibility='visible';

				if(order==' asc')
						document.forms[0].todateGif.src = '../../eAE/images/Ascending.gif';
				else
						document.forms[0].todateGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="duration")
		{
			if(document.getElementById("durationGif")!=null)
			{
				document.getElementById("durationGif").style.visibilit='visible';

				if(order==' asc')
						document.forms[0].durationGif.src = '../../eAE/images/Ascending.gif';
				else
						document.forms[0].durationGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="visittype")
		{
			if(document.getElementById("visittypeGif")!=null)
			{
				document.getElementById("visittypeGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].visittypeGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].visittypeGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="Location")
		{
			if(document.getElementById("locationGif")!=null)
			{
				document.getElementById("locationGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].locationGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].locationGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="resource")
		{
			if(document.getElementById("resourceGif")!=null)
			{
				document.getElementById("resourceGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].resourceGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].resourceGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="speciality")
		{
			if(document.getElementById("specialityGif")!=null)
			{
				document.getElementById("specialityGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].specialityGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].specialityGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="ordercatalog")
		{
			if(document.getElementById("ordercatalogGif")!=null)
			{
				document.getElementById("ordercatalogGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].ordercatalogGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].ordercatalogGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="referralid")
		{
			if(document.getElementById("referralidGif")!=null)
			{
				document.getElementById("referralidGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].referralidGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].referralidGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="ApptGivenBy")
		{
			if(document.getElementById("apptgnGif")!=null)
			{
				document.getElementById("apptgnGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].apptgnGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].apptgnGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="ApptGivenOn")
		{
			if(document.getElementById("apptgoGif")!=null)
			{
				document.getElementById("apptgoGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].apptgoGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].apptgoGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="status")
		{
			if(document.getElementById("statusGif")!=null)
			{
				document.getElementById("statusGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].statusGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].statusGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="LastModifiedBy")
		{
			if(document.getElementById("lastmbGif")!=null)
			{
				document.getElementById("lastmbGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].lastmbGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].lastmbGif.src = '../../eAE/images/Descending.gif';
			}
		}
else if(sortVal=="Lastmodifiedon")
		{
			if(document.getElementById("lastmoGif")!=null)
			{
				document.getElementById("lastmoGif").style.visibility='visible';

			if(order==' asc')
					document.forms[0].lastmoGif.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].lastmoGif.src = '../../eAE/images/Descending.gif';
			}
		}		
		else if(sortVal=="Category")
		{
			if(document.getElementById("catGip")!=null)
			{
				document.getElementById("catGip").style.visibility='visible';

			if(order==' asc')
					document.forms[0].catGip.src = '../../eAE/images/Ascending.gif';
			else
					document.forms[0].catGip.src = '../../eAE/images/Descending.gif';
			}
		}
		/*Added Above else if Condition for this CRF [RUT-CRF-0011]*/
}

function show_patinstructions(appt_no2){
	var dialogHeight = "35" ;
	var dialogWidth	= "40" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	window.showModalDialog("../../eOA/jsp/OAPatientInstructionsMain.jsp?appt_refno="+appt_no2+"&from_page=view_dtls",arguments,features);
}





var global_count = 0;
function practRadClick(obj)
{
	var userId = document.getElementById('userId').value;
	var practitioner_name = document.getElementById('practitioner_name').value;
	if(obj.value=='P')
	{
		document.getElementById('practitioner').value=practitioner_name;
		document.getElementById('practitionerId').value=userId;
		document.getElementById('practitioner').readOnly = true;
		document.getElementById('search_pract').disabled = true;
		//document.getElementById("Practioner_lab").innerText= getLabel("Common.practitioner.label","COMMON");
		document.getElementById('create_type').value='P';
		//parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").style.display = 'inline';
		populateSpeciality(userId);
	}
	else if(obj.value=='O')
	{
		document.getElementById('practitioner').value='';
		document.getElementById('practitioner').readOnly = false;
		document.getElementById('search_pract').disabled = false;
		//document.getElementById("Practioner_lab").innerText= getLabel("Common.practitioner.label","COMMON");
		document.getElementById('create_type').value='O';
		document.getElementById('practitionerId').value='';
		document.getElementById('speciality_code').value='';
		document.getElementById('speciality').value='';
		//parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").style.display = 'inline';
	}

}

function getPract1(obj)
{	
 if(obj.value!='')
	{
		getPract();
	}
	else
	{
		document.forms[0].practitioner.value = "";
		document.forms[0].practitionerId.value = "";
	}

}

async function getPract(obj)
	{
		var create_type = document.forms[0].create_type.value;
		var target			= document.forms[0].practitioner;
		//var stdval          = document.forms[0].performed_by.value;
        var val				= document.forms[0].facilityid.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= "";
		
		title			= getLabel("Common.practitioner.label","COMMON");
		/*
		if(create_type=='O')
		{
			title			= getLabel("Common.practitioner.label","COMMON");
		}
		else if (create_type=='S')
		{
			title			= getLabel("Common.speciality.label","COMMON");
		}
		*/
		var locale			= document.forms[0].locale.value;
		var sql="";
       

		//var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = `E` and std_comp_result_type= `"+val+"` ";
		//if(create_type=='O')
		//{
			sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";

		/*}
		else if(create_type=='S')

		{
			sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) and upper(speciality_code) like upper(?) ";

		}*/
				
		

		//search_code="practitioner_id";
		//search_desc="practitioner_name";

		//retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title)+"&dispDescFirst=dispDescFirst",arguments,features);
		 
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );	
		var ret1=unescape(retArray);
	
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{

			document.forms[0].practitioner.value = arr[1];
		   	document.forms[0].practitionerId.value = arr[0];
			populateSpeciality(arr[0]);
			
				
		}
		else
		{
			document.forms[0].practitioner.value = "";
			document.forms[0].practitionerId.value = "";
			
		}

	}
function populateSpeciality(pract)
{
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=getSpecialty&practitionerId="+pract, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);



}


function getSpecialty1(obj)
{
	if(obj.value!="")
	{
		getSpecialty();
	}
	else
	{
		document.forms[0].speciality.value = "";
		document.forms[0].speciality_code.value = "";
	}

}

async function getSpecialty()

{

   var target			= document.forms[0].speciality;
   var retVal			=  new String();
   var title			= getLabel("Common.speciality.label","common");

   var sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";

   var argArray		= new Array();
   var namesArray		= new Array();
   var valuesArray		= new Array();
   var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		//alert("909");
		retVal      = await CommonLookup( title, argArray );
		var ret1=unescape(retVal);
	
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
     if (retVal != null && retVal != '' && retVal != "null")
		{
		document.forms[0].speciality.value = arr[1];
		document.forms[0].speciality_code.value = arr[0]
		}

    else
		{
			document.forms[0].speciality.value = "";
			document.forms[0].speciality_code.value = "";
		} 
		
	
}

function chkPatientID(obj)
{
	if(obj.value!='')
	{
		var patientId =obj.value;
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=patIDValid&patientId="+patientId, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	}
}


async function getPatient()
{
	var pat_id =  await PatientSearch();
				//alert(pat_id);
	if(pat_id != null)	document.getElementById("patientId").value = pat_id;
		document.getElementById("patientId").focus();
}
function getClinicCode1(obj)
{
	if(obj.value!='')
	{
		getClinicCode();	
	}
	else
	{

		document.forms[0].location.value = "";
		document.forms[0].location_code.value = "";

	}
}

async function getClinicCode()
{

   var target			= document.forms[0].location;
   var retVal			=  new String();
   var title			= getLabel("Common.speciality.label","common");
   var title			= "Location";

   var locn_type = document.forms[0].locn_type.value;
   var facility_id = document.forms[0].facilityid.value;
   var locale = document.forms[0].locale.value;
   var sql = "";

   //var sql="SELECT locn_code code, short_desc description FROM ca_locn_vw where locn_type ='"+locn_type+"' and facility_id = '"+facility_id+"' and upper (locn_code) like upper (?) and upper (short_desc) like upper(?)   order by 1";

   if(locn_type == 'N')
		sql = "select NURSING_UNIT_CODE code, SHORT_DESC description from ip_nursing_unit_lang_vw where FACILITY_ID = '"+facility_id+"' and LANGUAGE_ID = '"+locale+"' and upper (NURSING_UNIT_CODE) like upper (?) and upper (SHORT_DESC) like upper(?) order by 1";
   else if(locn_type == 'C')
	   sql = "select CLINIC_CODE code, SHORT_DESC description from op_clinic_lang_vw where FACILITY_ID = '"+facility_id+"' and LANGUAGE_ID = '"+locale+"' and upper (CLINIC_CODE) like upper (?) and upper (SHORT_DESC) like upper(?) order by 1 ";
   else
	{
	   alert(getMessage('LOCN_TYPE_NOT_BLNK','CA'));
	   return false;
	}

   //alert("on blur"+target.value);
   //alert("title"+title);
   //alert("here");

   var argArray		= new Array();
   var namesArray		= new Array();
   var valuesArray		= new Array();
   var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		//alert("909");
		retVal      = await CommonLookup( title, argArray );
		var ret1=unescape(retVal);
	
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
     if (retVal != null && retVal != '' && retVal != "null")
		{
		document.forms[0].location.value = arr[1];
		document.forms[0].location_code.value = arr[0]
		}

    else
		{
			document.forms[0].location.value = "";
			document.forms[0].location_code.value = "";
		} 

}

function getService1(obj)
{
	if(obj.value!='')
	{
		getService();
	}
	else
	{
		document.forms[0].service.value = "";
		document.forms[0].service_code.value = "";
	}

}

async function getService()
{

   var target			= document.forms[0].service;
   var retVal			=  new String();
  // var title			= getLabel("Common.service.label","common");
   var title			= "Service";

   var locn_type = document.forms[0].locn_type.value;
   var facility_id = document.forms[0].facilityid.value;
   var practitionerId = document.forms[0].practitionerId.value;
   var locale = document.forms[0].locale.value;

   var sql="Select DISTINCT a.SERVICE_CODE code, B.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW A, AM_SERVICE_LANG_VW B where FACILITY_ID='"+facility_id+"' and A.SERVICE_CODE like upper(?) and upper (B.SHORT_DESC) like upper (?) and PRACTITIONER_ID='"+practitionerId+"' and PATIENT_CLASS='IP' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID ='"+locale+"'";

   //alert("on blur"+target.value);
   //alert("title"+title);
   //alert("sql"+sql);
   //alert("here");

   var argArray		= new Array();
   var namesArray		= new Array();
   var valuesArray		= new Array();
   var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		//alert("909");
		retVal      = await CommonLookup( title, argArray );
		var ret1=unescape(retVal);
	
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
     if (retVal != null && retVal != '' && retVal != "null")
		{
		document.forms[0].service.value = arr[1];
		document.forms[0].service_code.value = arr[0]
		}

    else
		{
			document.forms[0].service.value = "";
			document.forms[0].service_code.value = "";
		} 

}

function clearLocn(obj)
{
	document.forms[0].location.value = "";
	document.forms[0].location_code.value = "";
	document.forms[0].locn_type_val.value = obj.value;
	
}


function showPatList()
{
	//alert('pract_rad...'+document.forms[0].pract_rad.value);
	//var pract_self =document.forms[0].pract_self.value;
	//var pract_behalf =document.forms[0].pract_behalf.value;
	//alert('pract_behalf...'+document.forms[0].pract_behalf.value);
	//var practitionerId = document.forms[0].practitionerId.value;

   if(parent.MultiTransRequestResultFrame.MultiTransRequestResultForm!=null)
   {
	   var field = '';
	   var patient_id = '';
	   var encounter_id = '';
	   var transcriber = '';
	   var notes = '';
	   var final_string = '';
	   var practitionerId = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.practitionerId.value ;
	   var bean_key = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.bean_key.value ;

	   var count = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.count.value ;
		
		for( i=1;i<=parseInt(count);++i)
		{
			field = eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.selRow"+i);
			
			var fields1 = new Array ( eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.transcriber"+i) );
			
			var names1  = new Array ( getLabel("eCA.Transcriber.label","CA"));

		//if(checkFieldsofMst( fields, names, parent.messageFrame)) 
			
			if(field.checked)
			{
				
				 patient_id		= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.patient_id"+i).value;
				 encounter_id	= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.encounter_id"+i).value;
				 transcriber	= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.transcriber"+i).value;
				 notes			= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.notes"+i).value;
			
				if(checkFieldsofMst( fields1, names1, parent.parent.messageFrame)){
			
				if(final_string=='')
				{
					final_string = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
				}
				else
				{
					final_string = final_string+"`"+patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
				}
				}
				else
				{
				return false;
				}
			
			
			}
			
			
		}
		if(final_string!='')
		{	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addToBean&practitionerId="+practitionerId+"&bean_key="+bean_key+"&final_string="+final_string, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		}

   }


	
	parent.MultiTransRequestToolbarFrame.MultiTransRequestToolbarForm.apply.disabled=true;
	var practitionerId = document.forms[0].practitionerId.value;
	var speciality_code = document.forms[0].speciality_code.value;
	var location_code = document.forms[0].location_code.value;
	var service_code = document.forms[0].service_code.value;
	var patientId = document.forms[0].patientId.value;
	var CurrentDate = document.forms[0].CurrentDate.value;
	var CurrentTime = document.forms[0].CurrentTime.value;
	var locn_type = document.forms[0].locn_type_val.value;
	var viewlist = document.forms[0].viewlist.value;
	
	var create_type = '';
	
	if(document.getElementById('pract_self').checked)
	{
		create_type ='P';
	}
	else if(document.MultiTransRequestCriteriaForm.pract_behalf.checked)
	{
		create_type ='O';
	}
	/*else if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.checked)
	{
		create_type ='S';
	}*/
	parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
	//alert('practitionerId...'+practitionerId+'....speciality_code....'+speciality_code+'....location_code...'+location_code+'...service_code....'+service_code+'...patientId...'+patientId);
	
	if(viewlist=='A'){
	var fields = new Array ( document.MultiTransRequestCriteriaForm.practitioner,document.MultiTransRequestCriteriaForm.location );
			
	var names  = new Array ( getLabel("eCA.OnBehalfOf.label","CA"),getLabel("Common.Location.label","Common"));
	}
	else
	{
		var fields = new Array ( document.MultiTransRequestCriteriaForm.practitioner );
			
		var names  = new Array ( getLabel("eCA.OnBehalfOf.label","CA"));

	}

	
	if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
	{	
	/*
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addAllToBean&patientId="+patientId+"&practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&res_mode=&create_type="+create_type+"&CurrentDate="+CurrentDate+"&CurrentTime="+CurrentTime+"&locn_type="+locn_type, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText); */
	
	
	parent.MultiTransRequestResultFrame.location.href ="../../eCA/jsp/MultiTransRequestResult.jsp?practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&patientId="+patientId+"&create_type="+create_type+"&CurrentDate="+CurrentDate+"&CurrentTime="+CurrentTime+"&locn_type="+locn_type+"&viewlist="+viewlist;
	//document.forms[0].pract_rad.disabled =true;
	
	/*
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.disabled =true;
	//document.forms[0].pract_rad.disabled =checked;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitioner.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =true;
	//document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.disabled =true; */
	//}
	/*else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}*/
	}
	else
	{
		parent.MultiTransRequestResultFrame.location.href='../../eCommon/html/blank.html';
	}
}
function scrollTitle()
{

}

function alignWidth(){
	var totalRows =  top.content.workAreaFrame.MultiTransRequestResultFrame.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = top.content.workAreaFrame.MultiTransRequestResultFrame.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) {
		top.content.workAreaFrame.MultiTransRequestResultFrame.document.getElementById("dataTitleTable").rows(0).cells(i).width=top.content.workAreaFrame.MultiTransRequestResultFrame.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}

function record()
{
	
   if(parent.MultiTransRequestResultFrame.MultiTransRequestResultForm!=null)
   {
	   var field = '';
	   var patient_id = '';
	   var encounter_id = '';
	   var transcriber = '';
	   var notes = '';
	   var final_string = '';
	   var practitionerId = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.practitionerId.value ;
	   var bean_key = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.bean_key.value ;

	   var count = parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.count.value ;
		
		for( i=1;i<=parseInt(count);++i)
		{
			field = eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.selRow"+i);
			
			if(field.checked)
			{
				 patient_id		= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.patient_id"+i).value;
				 encounter_id	= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.encounter_id"+i).value;
				 transcriber	= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.transcriber"+i).value;
				 notes			= eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.notes"+i).value;
			
				var fields1 = new Array ( eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.transcriber"+i) );
			
				var names1  = new Array ( getLabel("eCA.Transcriber.label","CA"));
			
				if(checkFieldsofMst( fields1, names1, parent.parent.messageFrame)){
				
				if(final_string=='')
				{
					final_string = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
				}
				else
				{
					final_string = final_string+"`"+patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
				}
				}
				else
				{
					return false;
				}
			
			
			}
			
			
		}
			
		
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addToBean&practitionerId="+practitionerId+"&bean_key="+bean_key+"&final_string="+final_string, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);


		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=selCount&bean_key="+bean_key, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
				
		
		//parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.submit();
   }


}
function submitPrevNext(start,last,query)
{
   
   var field = '';
   var patient_id = '';
   var encounter_id = '';
   var transcriber = '';
   var notes = '';
   var final_string = '';
   var practitionerId = document.forms[0].practitionerId.value ;
   var bean_key = document.forms[0].bean_key.value ;
   var count = document.forms[0].count.value ;
       
   for( i=1;i<=parseInt(count);++i)
	{
		field = eval("document.forms[0].selRow"+i);
		
		if(field.checked)
		{
			 patient_id		= eval("document.forms[0].patient_id"+i).value;
			 encounter_id	= eval("document.forms[0].encounter_id"+i).value;
			 transcriber	= eval("document.forms[0].transcriber"+i).value;
			 notes			= eval("document.forms[0].notes"+i).value;
		
			var fields1 = new Array ( eval("parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.transcriber"+i) );
			
			var names1  = new Array ( getLabel("eCA.Transcriber.label","CA"));
		
			if(checkFieldsofMst( fields1, names1, parent.parent.messageFrame)){
			if(final_string=='')
			{
				final_string = patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
			}
			else
			{
				final_string = final_string+"`"+patient_id+"~"+encounter_id+"~"+transcriber+"~"+notes;
			}
			}
			else
			{
				return false;
			}
		
		
		}
		
		
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addToBean&practitionerId="+practitionerId+"&bean_key="+bean_key+"&final_string="+final_string, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
	parent.MultiTransRequestResultFrame.location.href="../../eCA/jsp/MultiTransRequestResult.jsp?res_mode=Next&lower_limit="+start+"&upper_limit="+last+"&bean_key="+bean_key+"&"+query;


}

function onSuccess()
{
	
	parent.MultiTransRequestCriteriFrame.location.reload();
	parent.MultiTransRequestResultFrame.location.href='../eCommon/html/blank.html';
	parent.MultiTransRequestToolbarFrame.MultiTransRequestToolbarForm.apply.disabled=true;
}

function remFromList(obj,patient_id,encounter_id)
{
	
	var mode="";
	var practitionerId = document.forms[0].practitionerId.value ;
	var bean_key = document.forms[0].bean_key.value;
	var count =  parseInt(document.MultiTransRequestResultForm.count.value);
	
	if(obj.checked)
	{
		global_count++;
		mode="Rem";
	}
	else
	{
		global_count--;
		mode="Add";
		document.forms[0].selAll.checked=false;
	
	}
		
	if(count==parseInt(global_count))
	{
		document.forms[0].selAll.checked=true;
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=remove&practitionerId="+practitionerId+"&bean_key="+bean_key+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode="+mode, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
}
function clearPatList()
{
	parent.MultiTransRequestCriteriFrame.location.reload();
	parent.MultiTransRequestResultFrame.location.href="../../eCommon/html/blank.html";
	parent.MultiTransRequestToolbarFrame.MultiTransRequestToolbarForm.apply.disabled=true;
	
}

function patValidCheck(patientIdStatus)
 {
	
	if(patientIdStatus=="INVALID_PATIENT")
	{
		alert(getMessage('INVALID_PATIENT','MP'));
		document.getElementById("patientId").value = "";
		return false;
	}

 }

 function selectPatInPage(obj)
 {
	 var startIndex =  document.MultiTransRequestResultForm.startIndex.value;
	 var endIndex =  document.MultiTransRequestResultForm.endIndex.value;
	 var count =  parseInt(document.MultiTransRequestResultForm.count.value);
	 	
	 var chkboxObj;

	startIndex=1;
	endIndex =10;
	 	 	 
	 if(obj.checked == true)
	 {
		global_count=count;
		for(var i=parseInt(startIndex,10);i<=parseInt(endIndex,10);i++)
		{
			chkboxObj = eval("document.MultiTransRequestResultForm.selRow"+i);
			if(chkboxObj != null)
				chkboxObj.checked = true;
		}
	 }
	 else if(obj.checked == false)
	 {
		global_count=0;
		for(var i=parseInt(startIndex,10);i<=parseInt(endIndex,10);i++)
		{
			chkboxObj = eval("document.MultiTransRequestResultForm.selRow"+i);
			if(chkboxObj != null)
				chkboxObj.checked = false;
		}
	 }
	 
 }

 function locnMandatory(obj)
 {
	 if(obj.value == 'A')
	 {
		document.getElementById("loc_img").style.display='inline';
	 }
	 else
	 {
		 document.getElementById("loc_img").style.display='none';
	 }

 }
 function callfunction(flag)
 {
		
		if(flag=="false")
		{
			var errors = getMessage("ATLEAST_ONE_SELECTED","Common");
			parent.parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors+"&err_value=0" ;
						
			return false ;
		}
		else
		{
			parent.MultiTransRequestResultFrame.MultiTransRequestResultForm.submit();
		}
 }

 function getTranscriber(obj,index)
 {
	
	if(obj.value!='')
	{
		getTranscriber1(obj,index);
	}
	else
	{
		eval("document.forms[0].transcriber"+index).value = "";
		eval("document.forms[0].transcriber_desc"+index).value = "";
		//document.forms[0].practitionerId.value = "";
	}

	

 }
async  function getTranscriber1(obj,index)
 {


		
		var target			= eval("document.forms[0].transcriber_desc"+index);
		//var target			= document.forms[0].practitioner;
		
        var val				= document.forms[0].facilityid.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= "";
				
		title			= "Transcriber";
	
		var locale			= document.forms[0].locale.value;
		var sql="";
       
		
			sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";

		
		 
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = await CommonLookup( title, argArray );	
		var ret1=unescape(retArray);
			 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retArray != null && retArray !="")
		{

			eval("document.forms[0].transcriber_desc"+index).value = arr[1];
		   	eval("document.forms[0].transcriber"+index).value = arr[0];
					
				
		}
		else
		{
			eval("document.forms[0].transcriber"+index).value = "";
			eval("document.forms[0].transcriber_desc"+index).value = "";
			
		}




 }

/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413     Dinesh T    ARTEMIS - CRF
21/12/2011	  IN30050	  Dinesh T	  ARTEMIS - Updated for the patient id irrespective of the 
									  practitioners and given the additional parameter
29/12/2011	  IN30250	  Dinesh T	  ARTEMIS - Added the ipconsultation function in the patient
									  chart too
21/08/2011    IN034688	Dinesh T		Handling the billing related issue, while trying to charge consultation for more patients, charges were not posting to the billing tables
-----------------------------------------------------------------------------------------------

*/
var prevTabObj=null;
var precount=0;
prevTabObj="newList_tab";

function practRadClick(obj)
{
	var userId = document.forms[0].userId.value;
	var practitioner_name = document.forms[0].practitioner_name.value;
	if(obj.value=='P')
	{
		document.forms[0].practitioner.value=practitioner_name;
		document.forms[0].practitionerId.value=userId;
		document.forms[0].practitioner.readOnly = true;
		document.forms[0].search_pract.disabled = true;
		document.getElementById("Practioner_lab").innerText= getLabel("eCA.ConsultingPractitioner.label","CA");//IN29413
		document.forms[0].create_type.value='P';
		parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").style.display = 'inline';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality_code.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.disabled = false;
		parent.IPConsultationListCriteriaFrame.document.forms[0].search_specialty.disabled = false;
	}
	else if(obj.value=='O')
	{
		document.forms[0].practitioner.value='';
		document.forms[0].practitionerId.value='';
		document.forms[0].practitioner.readOnly = false;
		document.forms[0].search_pract.disabled = false;
		document.getElementById("Practioner_lab").innerText= getLabel("eCA.ConsultingPractitioner.label","CA");//IN29413
		document.forms[0].create_type.value='O';
		parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").style.display = 'inline';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality_code.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.disabled = false;
		parent.IPConsultationListCriteriaFrame.document.forms[0].search_specialty.disabled = false;
	}
	else if(obj.value=='S')
	{
		document.forms[0].practitioner.value='';
		document.forms[0].practitionerId.value='';
		document.forms[0].practitioner.readOnly = false;
		document.forms[0].search_pract.disabled = false;
		document.getElementById("Practioner_lab").innerText=getLabel("Common.speciality.label","COMMON");
		document.forms[0].create_type.value='S';
		parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").style.display = 'none';
		//parent.IPConsultationListTabsFrame.forms[0].existinglist_tab.style.display = 'inline';
		//speciality  search_specialty IPConsultationListCriteriaFrame
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality_code.value='';
		parent.IPConsultationListCriteriaFrame.document.forms[0].speciality.disabled = true;
		parent.IPConsultationListCriteriaFrame.document.forms[0].search_specialty.disabled = true;
	}


}

function getPract1(obj)
{
	if(obj.value!=null)
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
	var userId = document.forms[0].userId.value;
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
	if(create_type=='O')
	{
		title			= getLabel("eCA.ConsultingPractitioner.label","CA");
	}
	else if (create_type=='S')
	{
		title			= getLabel("Common.speciality.label","COMMON");
	}
	var locale			= document.forms[0].locale.value;
	var sql="";
   

	//var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = `E` and std_comp_result_type= `"+val+"` ";
	if(create_type=='O')
	{
		sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' and a.practitioner_id!='"+userId+"' ";

	}
	else if(create_type=='S')

	{
		sql="Select speciality_code code, short_desc description from am_speciality where eff_status='E' and upper(short_desc) like upper(?) and upper(speciality_code) like upper(?) ";

	}
			
	

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
	
	if(retArray != null && retArray !="")
	{
		var ret1=unescape(retArray);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}										 			  

		document.forms[0].practitioner.value = arr[1];
		document.forms[0].practitionerId.value = arr[0];
		
			
	}
	else
	{
		document.forms[0].practitioner.value = "";
		document.forms[0].practitionerId.value = "";
		
	}


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
		retVal      = await CommonLookup( title, argArray );
		
     if (retVal != null && retVal != '' && retVal != "null")
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
		document.forms[0].speciality.value = arr[1];
		document.forms[0].speciality_code.value = arr[0]
		}

    else
		{
			document.forms[0].speciality.value = "";
			document.forms[0].speciality_code.value = "";
		} 
		
	
}

function getPatient1(obj)
{
	if(obj.value!="")
	{
		getPatient();
	}
	else
	{
		document.getElementById("patientId").value=""
	}

}

async function getPatient()
{
	var pat_id =  await PatientSearch();
				
	if(pat_id != null)	document.getElementById("patientId").value = pat_id;
		document.getElementById("patientId").focus();
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	//document.getElementById(str).focus();
	document.getElementById(str).focus();");
	return flg;
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

   var sql="SELECT locn_code code, short_desc description FROM ca_locn_vw where locn_type ='"+locn_type+"' and facility_id = '"+facility_id+"' and upper (locn_code) like upper (?) and upper (short_desc) like upper(?)   order by 1";

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
		retVal      = await CommonLookup( title, argArray );
		
     if (retVal != null && retVal != '' && retVal != "null")
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
		}
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

   var sql="Select DISTINCT a.SERVICE_CODE code, B.SHORT_DESC description from CA_PRACT_BY_SPLTY_LOCN_VIEW A, AM_SERVICE_LANG_VW B where FACILITY_ID='"+facility_id+"' and upper (B.SHORT_DESC) like upper (?)and A.SERVICE_CODE like upper(?) and PRACTITIONER_ID='"+practitionerId+"' and PATIENT_CLASS='IP' AND A.SERVICE_CODE = B.SERVICE_CODE AND B.LANGUAGE_ID ='"+locale+"'";

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
		retVal      = await CommonLookup( title, argArray );
		
     if (retVal != null && retVal != '' && retVal != "null")
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
		document.forms[0].service.value = arr[1];
		document.forms[0].service_code.value = arr[0]
		}

    else
		{
			document.forms[0].service.value = "";
			document.forms[0].service_code.value = "";
		} 

}
function showPatList()
{
	var practitionerId = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;
	var patientId = document.forms[0].patientId.value;
	var bedNo = document.getElementById("bedNo").value;//IN29413
	document.forms[0].restrictSearch.value="";//IN30250

	if(patientId!='' || bedNo!='')
	{
		document.forms[0].speciality.value='';
		document.forms[0].speciality_code.value="";
		document.forms[0].location.value='';
		document.forms[0].location_code.value="";
		document.forms[0].service.value='';		 		
		document.forms[0].service_code.value="";
		document.forms[0].restrictSearch.value='Y';//IN30050
	}
	var speciality_code = document.forms[0].speciality_code.value;
	var location_code = document.forms[0].location_code.value;
	var service_code = document.forms[0].service_code.value;	
	var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	var cons_time = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.value;
	var create_type = '';
	var restrictSearch = document.forms[0].restrictSearch.value//IN30050

	if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.checked)
	{
		create_type ='P';
	}
	else if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.checked)
	{
		create_type ='O';
	}
	else if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.checked)
	{
		create_type ='S';
	}

	var fields = new Array ( parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitioner,parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date,parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time  );
	var names = new Array ( parent.IPConsultationListTopFrame.document.getElementById("Practioner_lab").innerText,///Practioner_lab document.getElementById("Practioner_lab").innerText
							getLabel("eCA.ConsultDate.label",'CA'),getLabel("Common.time.label",'Common')
							);
	
	if(checkFieldsofMst( fields, names, parent.parent.messageFrame)) 
	{	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?operation_mode=addAllToBean&patientId="+patientId+"&practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&cons_date="+cons_date+"&cons_time="+cons_time+"&res_mode=&create_type="+create_type+"&bedNo="+bedNo+"&restrictSearch="+restrictSearch, false);//IN29413,IN30050
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	
	parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&patientId="+patientId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type+"&bedNo="+bedNo+"&restrictSearch="+restrictSearch;//IN30050
	parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";//IN29413
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.disabled =true;
	//document.forms[0].pract_rad.disabled =checked;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitioner.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =true;
	//document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.disabled =true;
	}
	/*else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}*/

	

}

function loadNextPage(obj)
{
	var res_mode="";
	var beankey =parent.IPConsultationListResultFrame.IPConsultationListResultForm.bean_key.value;	
	var practitionerId = parent.IPConsultationListResultFrame.IPConsultationListResultForm.practitionerId.value;
	var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	var cons_time = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.value;
		
	var create_type = parent.IPConsultationListResultFrame.IPConsultationListResultForm.create_type.value;
	var bedNo=parent.IPConsultationListResultFrame.IPConsultationListResultForm.bedNo.value;
	var QueryString ="";

	if(obj.name=="Next")
	{
		res_mode ='Next';

		//parent.IPConsultationFrameSet.rows='12%,4%,0%,*,6%';
		parent.document.getElementById('IPConsultationListTopFrame').style.height='12vh';
		parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
		parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='0vh';
		parent.document.getElementById('IPConsultationListResultFrame').style.height='68vh';
		parent.document.getElementById('IPConsultationListToolbarFrame').style.height='7vh';
		
		//parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?res_mode="+res_mode+"&beankey="+beankey+"&practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&patientId="+patientId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type;
		parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?res_mode="+res_mode+"&beankey="+beankey+"&practitionerId="+practitionerId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type+"&bedNo="+bedNo;
		
		parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = 'none';
		parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = 'none';
		
		parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = 'none';
			
		parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = 'none';

		if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'none';

		document.forms[0].GenerateList.style.display='inline';
		document.forms[0].Back.style.display='inline';
		document.forms[0].Next.style.display='none';
	}
	else if (obj.name=="Back") //IPConsultationListCriteriaFrame
	{
		//var practitionerId = document.forms[0].practitionerId.value;
		
		res_mode ='Back';
		
		if(parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm==null)
		{
			//parent.IPConsultationFrameSet.rows='12%,4%,19%,*,6%';
			parent.document.getElementById('IPConsultationListTopFrame').style.height='12vh';
			parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
			parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='19vh';
			parent.document.getElementById('IPConsultationListResultFrame').style.height='51vh';
			parent.document.getElementById('IPConsultationListToolbarFrame').style.height='6vh';
			parent.IPConsultationListCriteriaFrame.location.href ="../../eCA/jsp/IPConsultationListCriteria.jsp";
			
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';
		}
		else
		{
			//parent.IPConsultationFrameSet.rows='12%,4%,19%,*,6%';
			parent.document.getElementById('IPConsultationListTopFrame').style.height='12vh';
			parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
			parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='21vh';
			parent.document.getElementById('IPConsultationListResultFrame').style.height='50vh';
			parent.document.getElementById('IPConsultationListToolbarFrame').style.height='6vh';
			var speciality_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.speciality_code.value;
			var location_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.location_code.value;
			var service_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.service_code.value;
			var patientId = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.patientId.value;
			
			QueryString ="&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&patientId="+patientId+"&bedNo="+bedNo;
		}
		//var practitionerId = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.practitionerId.value;
		/*var patientId = top.content.frames[3].frames[2].IPConsultationListCriteriaForm.patientId.value;
		var speciality_code = top.content.frames[3].frames[2].IPConsultationListCriteriaForm.speciality_code.value;
		var location_code = top.content.frames[3].frames[2].IPConsultationListCriteriaForm.location_code.value;
		var service_code = top.content.frames[3].frames[2].IPConsultationListCriteriaForm.service_code.value; */
		
		/*
		var speciality_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.speciality_code.value;
		var location_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.location_code.value;
		var service_code = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.service_code.value;
		var patientId = parent.IPConsultationListCriteriaFrame.IPConsultationListCriteriaForm.patientId.value;
		
		alert("HI"); */
		/*var speciality_code = document.forms[0].speciality_code.value;
		var location_code = document.forms[0].location_code.value;
		var service_code = document.forms[0].service_code.value;
		var patientId = document.forms[0].patientId.value;
		var cons_date = document.forms[0].cons_date.value;
		var cons_time = document.forms[0].cons_time.value; */

		//parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&beankey="+beankey+"&res_mode="+res_mode+"&patientId="+patientId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type;
		//parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?practitionerId="+practitionerId+"&speciality_code="+speciality_code+"&location_code="+location_code+"&service_code="+service_code+"&beankey="+beankey+"&res_mode="+res_mode+"&patientId="+patientId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type;
		parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListResult.jsp?practitionerId="+practitionerId+"&beankey="+beankey+"&res_mode="+res_mode+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type+QueryString+"&bedNo="+bedNo;

		
		parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = 'inline';
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = 'inline';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = 'inline';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = 'inline';
			if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'none';
		
		document.forms[0].GenerateList.style.display='none';
		document.forms[0].Back.style.display='none';
		document.forms[0].Next.style.display='none';
	}
}

function addToList(obj,rowCnt,pline,Admission_date_time,Specialty_code,Location_code,patient_id,encounter_id,attend_practitioner_id,splty_code)
{
	var mode="";
	var bean_key = document.forms[0].bean_key.value;
	var create_type = document.forms[0].create_type.value;
	//IN29413,starts
	var totRecords = document.getElementById("consultCnt").value;
	var totDisabled = document.getElementById("totDisabled").value;
	var totChecked = document.getElementById("totChecked").value; 
	//IN29413,ends
	if(obj.checked)
	{
		mode="Add";
		//IN29413,starts
		document.getElementById("totChecked").value=parseInt(totChecked)+1;
		
		if(document.getElementById("selectAll")!=null)
		{
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("selectAll").checked='checked';
				document.getElementById("selectAll").value='Y';
			}
			else
			{
				document.getElementById("selectAll").checked='';
				document.getElementById("selectAll").value='N';
			}
		}
		else if(document.getElementById("selectAllNext")!=null)
		{						
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("selectAllNext").checked='checked';
				document.getElementById("selectAllNext").value='Y';
			}
			else
			{
				document.getElementById("selectAllNext").checked='';
				document.getElementById("selectAllNext").value='N';
			}
		}
		//IN29413,ends
	}
	else
	{
		mode="Rem";
		//IN29413,starts
		document.getElementById("totChecked").value=parseInt(totChecked)-1;

		if(document.getElementById("selectAll")!=null)
		{
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("selectAll").checked='checked';
				document.getElementById("selectAll").value='Y';
			}
			else
			{
				document.getElementById("selectAll").checked='';
				document.getElementById("selectAll").value='N';
			}
		}
		else if(document.getElementById("selectAllNext")!=null)
		{
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("selectAllNext").checked='checked';
				document.getElementById("selectAllNext").value='Y';
			}
			else
			{
				document.getElementById("selectAllNext").checked='';
				document.getElementById("selectAllNext").value='N';
			}
		}
		//IN29413,ends
	}
	
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&pline="+encodeURIComponent(pline,"UTF-8")+"&Admission_date_time="+Admission_date_time+"&Specialty_code="+Specialty_code+"&Location_code="+Location_code+"&mode="+mode+"&bean_key="+bean_key+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&attend_practitioner_id="+attend_practitioner_id+"&create_type="+create_type+"&splty_code="+splty_code+"&operation_mode=create", false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);

}

async function apply()
{		
		var flag=false;
		var bean_key = parent.IPConsultationListResultFrame.document.forms[0].bean_key.value;
		var servMode = parent.IPConsultationListResultFrame.document.getElementById("servMode").value;//IN29413
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=validatecreate&bean_key="+bean_key, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		if(eval(responseText)!=false)
		{
			flag=true;
		}
		else
		{
			flag=false;
			alert(getMessage("PAT__NOT_BLANK","CA"));
			return false;
		}

		var cons_date = parent.IPConsultationListResultFrame.IPConsultationListResultForm.cons_date.value;
		var cons_time = parent.IPConsultationListResultFrame.IPConsultationListResultForm.cons_time.value;
		var cons_desc="";
				
		cons_date=cons_date.replace('/','');
		cons_date=cons_date.replace('/','');
		//msg = msg.replace('$$',interval);
		cons_time=cons_time.replace(':','');
		cons_desc =cons_date+cons_time;
		
		//	var target				= document.Assign_menu_form.speciality_code1;
		var retVal				=  new String();
		//var dialogTop			= "10";
		var dialogHeight		= "6" ;
		var dialogWidth			= "30" ;
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		var title=getLabel("eCA.SpecialitySearch.label","CA");
		//var sql=" select speciality_code,short_desc from am_speciality where eff_status=`E`";
		
		retVal=await window.showModalDialog("../../eCA/jsp/IPConsultationListPopUp.jsp?cons_desc="+cons_desc,arguments,features);
				
		if(retVal== undefined)
		{
		   retVal="***~~~";
		   flag=false;
		}
		if(retVal!='***~~~')
		{
			cons_desc = retVal+cons_desc;
			//flag=true;
			
		parent.IPConsultationListResultFrame.IPConsultationListResultForm.cons_list_desc.value=cons_desc;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=dupChk&cons_list_desc="+cons_desc, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		
		if(eval(responseText)!=false)
		{
			flag=true;
		}
		else
		{
			
			flag=false;
			return false;
		}
		
		if(flag)
		{
			parent.IPConsultationListResultFrame.IPConsultationListResultForm.submit();
		}
	}
}

function onSuccess1()
{
	var practitionerId = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;
	var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	var create_type = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.create_type.value;

	
	if(create_type=='S')
	{
	
		parent.IPConsultationListTopFrame.location.reload();
		parent.IPConsultationListTabsFrame.location.reload();
		parent.IPConsultationListCriteriaFrame.location.reload();
		parent.IPConsultationListResultFrame.location.href="../eCommon/html/blank.html";

		parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = 'inline';
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = 'inline';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = 'inline';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = 'inline';
			if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'none';

			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'none';
	}
	else
	{
		
	//parent.IPConsultationFrameSet.rows='12%,4%,8%,*,6%';
	parent.document.getElementById('IPConsultationListTopFrame').style.height='12vh';
	parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
	parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='9vh';
	parent.document.getElementById('IPConsultationListResultFrame').style.height='60vh';
	parent.document.getElementById('IPConsultationListToolbarFrame').style.height='7vh';
	parent.IPConsultationListCriteriaFrame.location.href ="../eCA/jsp/IPConsultationListExistListSelect.jsp?practitionerId="+practitionerId+"&cons_date="+cons_date;

	parent.IPConsultationListResultFrame.location.href="../eCommon/html/blank.html";

	
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = 'none';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = 'none';
			
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = 'none';
			if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'inline';
	
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'inline';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'inline';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'none';

	parent.IPConsultationListTabsFrame.document.getElementById("newList_tab").className="tabA";
	parent.IPConsultationListTabsFrame.document.getElementById("newList_tabspan").className="tabAspan";
	parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tab").className="tabClicked"
	parent.IPConsultationListTabsFrame.document.getElementById("existinglist_tabspan").className="tabSpanclicked" ;

	prevTabObj = "existinglist_tab";

	parent.parent.frames[5].location.href="../eCommon/html/blank.html";
	
	}

}

function onSuccess()
{
	
	parent.IPConsultationListResultFrame.location.reload();
	//callExistingList();
}
function callExistingList()
{
	var practitionerId = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;
	var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	
	//parent.IPConsultationFrameSet.rows='12%,6%,12%,*,6%';
	parent.document.getElementById('IPConsultationListTopFrame').style.height='11vh';
	parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
	parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='17vh';
	parent.document.getElementById('IPConsultationListResultFrame').style.height='56vh';
	parent.document.getElementById('IPConsultationListToolbarFrame').style.height='7vh';
	parent.IPConsultationListCriteriaFrame.location.href ="../../eCA/jsp/IPConsultationListExistListSelect.jsp?practitionerId="+practitionerId+"&cons_date="+cons_date;

		
	parent.IPConsultationListResultFrame.location.href="../../eCommon/html/blank.html";
	/*parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'inline';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'inline';
	//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'inline';*/
	if(parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1"))
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = 'none';
	if(parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1"))
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = 'none';
	if(parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2"))		
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = 'none';
	if(parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = 'none';
	if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'inline';

	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'none';
	//parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.style.display='none';
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.disabled=true;
	//parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.outerHTML='';
	//parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.innerHTML='';
	
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.disabled =true;
	//document.forms[0].pract_rad.disabled =checked;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitioner.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =true;
	//document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.disabled =true;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.disabled =true;



}
function goNewList()
{

	callNewList();

	parent.IPConsultationListTabsFrame.document.getElementById('existinglist_tab').className="tabA";
	parent.IPConsultationListTabsFrame.document.getElementById('existinglist_tabspan').className="tabAspan";
	parent.IPConsultationListTabsFrame.document.getElementById('newList_tab').className="tabClicked"
	parent.IPConsultationListTabsFrame.document.getElementById('newList_tabspan').className="tabSpanclicked" ;

	prevTabObj = "existinglist_tab";

}

function callNewList()
{
	var practitioner_id=parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;
	var cons_date=parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	var cons_time=parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.value;
	var consult_date_time=cons_date+cons_time;
	//parent.IPConsultationFrameSet.rows='12%,4%,18%,*,6%';
	parent.document.getElementById('IPConsultationListTopFrame').style.height='11vh';
	parent.document.getElementById('IPConsultationListTabsFrame').style.height='4vh';
	parent.document.getElementById('IPConsultationListCriteriaFrame').style.height='21vh';
	parent.document.getElementById('IPConsultationListResultFrame').style.height='52vh';
	parent.document.getElementById('IPConsultationListToolbarFrame').style.height='7vh';
	parent.IPConsultationListCriteriaFrame.location.href ="../../eCA/jsp/IPConsultationListCriteria.jsp?&practitioner_id="+practitioner_id+"&consult_date_time="+consult_date_time;

	parent.IPConsultationListResultFrame.location.href="../../eCommon/html/blank.html";
	
	parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat1").style.display = '';
	parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab1").style.display = '';
			
	parent.IPConsultationListToolbarFrame.document.getElementById("colour_pat2").style.display = '';
			
	parent.IPConsultationListToolbarFrame.document.getElementById("colour_patLab2").style.display = '';
	if(parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab"))	
			parent.IPConsultationListToolbarFrame.document.getElementById("cancel_ChargeLab").style.display = 'none';
	
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'none';
	//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'inline';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
	

	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.disabled =false;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.disabled =false;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.Speciality.disabled =false;
	//document.forms[0].pract_rad.disabled =checked;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitioner.disabled =false;
//Commented by Deepa on 12/24/2008 at 1:48 PM
//	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =false;

	/******************Added by Deepa on 12/24/2008 at 1:52 PM */
	if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_rad[0].checked)
		parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =true;
	else
		parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.search_pract.disabled =false;


	//document.getElementById("cons_cal").disabled =true;
	parent.IPConsultationListTopFrame.document.getElementById("cons_cal").disabled =false;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.disabled =false;
	parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.disabled =false;


}

function loadListDet(obj)
{
	
	var cons_ref_id = document.forms[0].cons_list.value;
	var status = obj.value; 
	var catalog = document.forms[0].catalog.value;
	
	var practitionerId = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;

	var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
	var cons_time = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.value;
	//var cons_time = document.forms[0].cons_time.value;
	var create_type = '';
	if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_self.checked)
	{
		create_type ='S';
	}
	else if(parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.pract_behalf.checked)
	{
		create_type ='O';
	}

	
	var beankey = practitionerId+cons_date+cons_time

	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=clearBeanUpd&bean_key="+beankey, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);

	
	
	if(status!="")
	{

		parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListExistListDetails.jsp?cons_ref_id="+cons_ref_id+"&status="+status+"&practitionerId="+practitionerId+"&cons_date="+cons_date+"&cons_time="+cons_time+"&create_type="+create_type+"&catalog="+catalog; 
		//parent.IPConsultationListResultFrame.location.href ="../../eCA/jsp/IPConsultationListExistListDetails.jsp";
	/*if(parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm)
		{
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'inline';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'inline';
	//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'inline';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
		}*/
		if(status=="C")
		{
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge.style.display = 'inline';
		}
	}
	else
	{
		parent.IPConsultationListResultFrame.location.href ="../../eCommon/html/blank.html";
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';
	//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'inline';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
	}
	parent.parent.messageFrame.location.href="../../eCommon/html/blank.html";
}

async function PrintPage()
{
		//var beankey =parent.IPConsultationListResultFrame.IPConsultationListResultForm.bean_key.value;
		var beankey =parent.IPConsultationListResultFrame.document.forms[0].bean_key.value;
		//var cons_ref_id =parent.IPConsultationListResultFrame.IPConsultationListResultForm.cons_ref_id.value;
		var cons_ref_id =parent.IPConsultationListResultFrame.document.forms[0].cons_ref_id.value;
		//var status =parent.IPConsultationListResultFrame.IPConsultationListResultForm.status.value;
		var status =parent.IPConsultationListResultFrame.document.forms[0].status.value;

		var practitionerId = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.practitionerId.value;

		var cons_date = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_date.value;
		var cons_time = parent.IPConsultationListTopFrame.document.IPConsultationListTopForm.cons_time.value;
			
		var retVal				=  new String();
		var dialogTop			= "100";
		var dialogHeight		= "90vh" ;
		var dialogWidth			= "70vw" ;
		var features			="dialogTop:"+ dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		//var title=getLabel("eCA.SpecialitySearch.label","CA");
		var title="Print";
		//var sql=" select speciality_code,short_desc from am_speciality where eff_status=`E`";
		
		//search_code="speciality_code";
		//search_desc="short_desc";
		retVal=await top.window.showModalDialog("../../eCA/jsp/IPConsultationListPrint.jsp?bean_key="+beankey+"&cons_ref_id="+cons_ref_id+"&status="+status+"&practitionerId="+practitionerId+"&cons_date="+cons_date+"&cons_time="+cons_time,arguments,features);
	
	
	
	//var url ='../../eCA/jsp/IPConsultationListPrint.jsp';
	//window.open(url,'Document','height=600,width=900,top=100,left=100,resizable=yes,scrollbars=yes' );



}
function chargeCons()
{
	var bean_key = parent.IPConsultationListResultFrame.document.forms[0].bean_key.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	document.getElementById("ChargeCons").disabled=true;//IN034688
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=validate&bean_key="+bean_key, false);
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	if(eval(responseText)!=false)
	{
		parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.submit();
	}
	else
	{
		alert(getMessage("PAT__NOT_BLANK","CA"));
		return false;
	}
}

	//
	/*var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='IPConsultationListIntermediate.jsp?&operation_mode=validate&bean_key="+bean_key+ "'></form></BODY></HTML>";
	alert(HTMLVal);
	parent.parent.messageFrame.document.write(HTMLVal);
	parent.parent.messageFrame.document.forms[0].submit(); 
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp' ;*/
	//parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.submit();
	
//}

function consListChange()
{
	parent.IPConsultationListResultFrame.location.href="../../eCommon/html/blank.html";
}

function scrollTitle()
{
	var y = top.content.workAreaFrame.IPConsultationListResultFrame.document.body.scrollTop;
	if(y == 0){
		top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("divDataTitle").style.position = 'static';
		top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("divDataTitle").style.posTop  = 0;
	}/*else{
		top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("divDataTitle").style.position = 'relative';
		top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("divDataTitle").style.posTop  = y-2;
	} */
}

function alignWidth(){
	var totalRows =  top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("dataTitleTable").rows[0].length;
	
	for(var i=0;i<temp;i++) {
		top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("dataTitleTable").rows[0].cells[i].width=top.content.workAreaFrame.IPConsultationListResultFrame.document.getElementById("dataTable").rows[counter].cells[i].offsetWidth;
	}
}
function click_ok()
{
	returnVal = document.forms[0].cons_list_desc.value;
	//parent.window.returnValue = returnVal;
	//parent.window.close();
	let dialogBody = parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = returnVal;
    
	const dialogTag = parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}
/*function chargeDet(rownum,total_amt,total_pat_payable,aproval_reqd)
{
		
		var retVal				=  new String();
		var dialogTop			= "20";
		var dialogHeight		= "30" ;
		var dialogWidth			= "80" ;
		var features			="dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc="";
		//var title=getLabel("eCA.SpecialitySearch.label","CA");
		var title= "Edit/Enter Charge Details";
		//var sql=" select speciality_code,short_desc from am_speciality where eff_status=`E`";
		
		//search_code="speciality_code";
		//search_desc="short_desc";

		total_amt = eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.total_amt_val"+rownum).value ;
		total_pat_payable = eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.toatal_pat_payable_val"+rownum).value;
		aproval_reqd = eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.aproval_reqd_val"+rownum).value ;

		alert('total_amt...'+total_amt+'...total_pat_payable...'+total_pat_payable+'...aproval_reqd_lab..'+aproval_reqd);
		
		retVal=window.showModalDialog("../../eCA/jsp/IPConsultationListChargeDetailsMain.jsp?title="+encodeURIComponent(title,"UTF-8")+"&total_amt="+total_amt+"&total_pat_payable="+total_pat_payable+"&aproval_reqd="+aproval_reqd+"&rownum="+rownum,arguments,features);

		//alert('retVal...'+retVal);
		
		if(retVal!=null)
		{
			var charges = retVal.split('~');
			eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.total_amt_val"+charges[0]).value=charges[1];
			eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.toatal_pat_payable_val"+charges[0]).value=charges[2];
			eval("parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.aproval_reqd_val"+charges[0]).value=charges[3];
			eval("parent.IPConsultationListResultFrame.document.getElementById("total_amt_lab")"+charges[0]).innerText=charges[1];
			eval("parent.IPConsultationListResultFrame.document.getElementById("toatal_pat_payable_lab")"+charges[0]).innerText=charges[2];
			eval("parent.IPConsultationListResultFrame.document.getElementById("aproval_reqd_lab")"+charges[0]).innerText=charges[3];
		}

} */


function modify()
{
	parent.IPConsultationListChargeDetailsFrame.IPConsultationListChargeDetailsForm.rate.disabled = false;

}
function AcceptCharge(obj)
{
	var rownum = parent.IPConsultationListChargeDetailsFrame.IPConsultationListChargeDetailsForm.rownum.value;

	var total_payable = parent.IPConsultationListChargeDetailsFrame.IPConsultationListChargeDetailsForm.total_payable.value;
	
	var patient_payable = parent.IPConsultationListChargeDetailsFrame.IPConsultationListChargeDetailsForm.patient_payable.value;
	
	var chk_apprReqd = parent.IPConsultationListChargeDetailsFrame.IPConsultationListChargeDetailsForm.chk_apprReqd.value;
	

	returnVal = rownum+'~'+total_payable+'~'+patient_payable+'~'+chk_apprReqd;
	//parent.window.returnValue = returnVal;
	//parent.window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
	dialogBody.contentWindow.returnValue = returnVal;
    
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();

}

function calcRate(obj,rownum)
{
	
	document.forms[0].total_payable.value=obj.value;
	document.forms[0].patient_payable.value=obj.value;
}
function calcTotal(obj,rownum)
{
	
		//alert('total...'+obj.value+'...rownum..'+rownum);
	
}
function calcPatPaid(obj,rownum)
{
	//alert('paid...'+obj.value+'...rownum..'+rownum);
}
function calcPatPay(obj,rownum)
{
	//alert('payable...'+obj.value+'...rownum..'+rownum);
}

function closeChargeWin()
{

	//window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}

function apprvlReqd(obj)
{

	if (obj.checked==true)
	{
		document.forms[0].chk_apprReqd.value ='Yes';
		//alert('appl.1.'+document.forms[0].chk_apprReqd.value);
	}
	else
	{
		document.forms[0].chk_apprReqd.value ='No';
		//alert('appl.2.'+document.forms[0].chk_apprReqd.value);

	}

}
/*  OR functions*/


//function callReviseBilling(row_value,called_from,patient_id,encounter_id,service_panel_ind,service_panel_code,episode_type,episode_id,visit_id,order_id,order_line_no)
async function callReviseBilling(i,patient_id,encounter_id,catalog_code,service_panel_code,service_panel_ind,start_date_time,episode_type,visit_id,episode_id,practitioner_id,key_line_no,order_id,order_line_no)
{
	
	//var formObj		= document.placeOrderForm;
	//var localeName			= document.placeOrderForm.localeName.value;
	//bean_id 		= formObj.bean_id.value;
	//bean_name 		= formObj.bean_name.value;
	//var practitioner_id	= document.placeOrderForm.ordering_practitioner.value;
	var key_ref		= patient_id+encounter_id+catalog_code;
	//var key_line_no	= "";
	
	/*
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
		key_ref			= patient_id+encounter_id+catalog_code;
		key_line_no		= "";
		//start_date_time = start_date_time.substr(0, (start_date_time.indexOf(" ") ) );
	}else // For New Orders or orderset
	{
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
		key_ref			= order_id;
		key_line_no		= order_line_no;
	} */
	var bean_id="Or_FutureOrder";

	//catalog_code ="BILLTEST_Y";
	/*bean_id="";
	patient_id ="";
	encounter_id ="";
	key_ref="";
	catalog_code="";
	service_panel_code="";
	service_panel_ind="";
	start_date_time="";
	episode_type="";
	visit_id="";
	episode_id="";
	practitioner_id="";
	key_line_no="";
	order_id ="";
	order_line_no="";*/

/*	alert('bean_id'+bean_id);
	alert('bean_name'+bean_name);
	alert('quantity'+quantity);
	alert('start_date_time'+start_date_time);
	alert('catalog_code'+catalog_code);
*/
//service_panel_code="VS_PNL3";
//service_panel_ind="L";

	var query_string = "title="+encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"))+"&bean_id="+bean_id+"&module_id=OR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&key="+key_ref+"&order_catalog_code="+catalog_code+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+start_date_time+"&episode_type="+episode_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&pract_staff_ind=P&pract_staff_id="+practitioner_id+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no;
	
	var retVal ;
	var dialogTop		= "360";
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "60vw" ;
	var features		= ' dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
	var arguments		= "";
	retVal	 			= await window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+query_string,arguments,features);
	
	
	if(retVal!=null && retVal != undefined)
	{
		if(retVal[0]=="Y" ment.getElementById("total_amt_val"+i).value);
			document.getElementById('toatal_pat_payable_lab'+i).innerText=retVal[2];
			document.getElementById('toatal_pat_payable_val'+i).value=retVal[2];
			document.getElementById('aproval_reqd_lab'+i).innerText= (retVal[6] == "I")?"Yes":(retVal[6] == "E"?"No":"No");
			document.getElementById('aproval_reqd_val'+i).value=(retVal[6] == "I")?"Yes":(retVal[6] == "E"?"No":"No");

		//	alert("Updated Successfully");
		/*	etArray[0]="Y";
			retArray[1]=total_payable;
			retArray[2]=patient_payable;
			retArray[3]=patient_paid;
			retArray[4]=quantity;
			retArray[5]=rate;
			retArray[6]=incl_excl_action;*/

			//loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[6],catalog_code);
			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?patientId="+patient_id+"&encounter_id="+encounter_id+"&operation_mode=UpdateBean&catalog="+catalog_code+"&total_payable="+retVal[1]+"&patient_payable="+retVal[2]+"&preapp_yn="+retVal[6], false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
		
		
		}
				
	}
	
		
	
}

function addToList1(obj,rowCnt,patient_id,encounter_id,consult_date_time,order_catalog,p_patient_class,p_episode_id,episode_visit_num,practitioner_id,source_code,source_type)
{
	var cons_ref_id = document.forms[0].cons_ref_id.value;
	var mode="";
	var bean_key = document.forms[0].bean_key.value;
	//IN29413,starts
	var totRecords = document.getElementById("consultCnt");
	var totDisabled= document.getElementById("totDisabled");
	var totChecked = document.getElementById("totChecked");
	var selectAllObj = document.getElementById("existSelAll");
	//IN29413,ends
	
	if(obj.checked)
	{
		mode="Add";		
		commonSelectAllBehave(mode,selectAllObj,totRecords,totChecked,totDisabled);//IN29413
	}
	else
	{
		mode="Rem";		
		commonSelectAllBehave(mode,selectAllObj,totRecords,totChecked,totDisabled);//IN29413
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&mode="+mode+"&bean_key="+bean_key+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&operation_mode=update&cons_ref_id="+cons_ref_id+"&consult_date_time="+consult_date_time+"&order_catalog="+order_catalog+"&p_patient_class="+p_patient_class+"&p_episode_id="+p_episode_id+"&episode_visit_num="+episode_visit_num+"&practitioner_id="+practitioner_id+"&source_code="+source_code+"&source_type="+source_type, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
}

function selectTab1(tabObj){
	
	if(prevTabObj!=null){
			//eval("document.all."+prevTabObj).className="tabA"
			//eval("document.all."+prevTabObj+"span").className="tabAspan"
			 document.getElementById(prevTabObj).className="tabA";
			 document.getElementById(prevTabObj+"span").className="tabAspan";
	}
			//eval("document.all."+tabObj).className="tabClicked"
			//eval("document.all."+tabObj+"span").className="tabSpanclicked"
			document.getElementById(tabObj).className="tabA";
			document.getElementById(tabObj+"span").className="tabAspan";
			prevTabObj=tabObj
	
}
function displayrecord(index)
{
	if(document.getElementById('chk'+index))
	{
		document.getElementById('chk'+index).className='orcancel';
	}
	if(document.getElementById('pline'+index))
	{
		document.getElementById('pline'+index).className='orcancel';
	}
	if(document.getElementById('admdate'+index))
	{
		document.getElementById('admdate'+index).className='orcancel';
	}
	if(document.getElementById('total_amt_lab'+index))
	{
		document.getElementById('total_amt_lab'+index).className='orcancel';
	}
	if(document.getElementById('toatal_pat_payable_lab'+index))
	{
		document.getElementById('toatal_pat_payable_lab'+index).className='orcancel';
	}
	if(document.getElementById('aproval_reqd_lab'+index))
	{
		document.getElementById('aproval_reqd_lab'+index).className='orcancel';
	}
	if(document.getElementById('totalamt'+index))
	{
		document.getElementById('totalamt'+index).className='orcancel';
	}
	if(document.getElementById('space'+index))
	{
		document.getElementById('space'+index).className='orcancel';
	}
	if(document.getElementById('patientamt'+index))
	{
		document.getElementById('patientamt'+index).className='orcancel';
	}
	if(document.getElementById('apprreqd'+index))
	{
		document.getElementById('apprreqd'+index).className='orcancel';
	}
	if(document.getElementById('charges'+index))
	{
		document.getElementById('charges'+index).className='orcancel';
	}
	if(document.getElementById('vespace'+index))
	{
		document.getElementById('vespace'+index).className='orcancel';
	}
	if(document.getElementById('viewedit'+index))
	{
		document.getElementById('viewedit'+index).className='orcancel';
	}
}

function loadButtons()
{
	if(parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm)
		{
		if(parent.frames[2].document.forms[0].status.value=="C")
			{			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
			}
			else
			{
				parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'inline';
			}
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'inline';
	//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'inline';
			parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
		}
}

function unloadButtons()
{
	if(parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons)	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
	if(parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge)	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge.style.display = 'none';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';
//parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'inline';
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';
}

function callfunction(size)
{
	if(parseInt(size)==0)
		return false;
}

function loadNextButton()
{	
	if(parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display!='inline')	
	{
		parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'inline';
	}
	
}

function clearPatList()
{
	var beankey =document.forms[0].bean_key.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=clearBean&bean_key="+beankey, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);

	//IN30250,starts
	//parent.IPConsultationListCriteriaFrame.location.reload();
	parent.IPConsultationListTabsFrame.location.reload();
	parent.IPConsultationListCriteriaFrame.document.getElementById("speciality").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("patientId").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("location").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("service").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("bedNo").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("speciality_code").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("location_code").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("service_code").value="";
	parent.IPConsultationListCriteriaFrame.document.getElementById("restrictSearch").value="";
	//IN30250,ends
	parent.IPConsultationListResultFrame.location.href="../../eCommon/html/blank.html";
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.GenerateList.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Back.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Next.style.display = 'none';	
}

function hideToolTip()	
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden'
}

// In Order Entry Module all the places, this method is called to display the tool tip
function showToolTip(rowcnt) 
{

 	var form = document.getElementById(document.forms[0].name);

	if(form["explanatory_text"+rowcnt])
	 	explanatory_text	= form["explanatory_text"+rowcnt].value;
	

	if(explanatory_text!=null && explanatory_text!="")
    {
		buildToolTable(explanatory_text);
 		//resizeWindow();
	}
}
function buildToolTable(val) {

	var tab_dat		= "<table id='tooltiptable1' cellpadding=3 cellspacing=0 border='0'   class='BOX' width='5' height='10' align='center'>"
		tab_dat     += "<tr>"
		tab_dat     += "<td class = 'ORMENULAYER'><B>"+val+" </B></td>"
 		tab_dat     += "</tr> "
 		tab_dat     += "</table> "
	document.getElementById("t").innerHTML = tab_dat;
		
}

function resizeWindow()
{

	 bodwidth	= document.body.offsetWidth
	 bodheight	= document.body.offsetHeight
	 var x		= event.x
	 var y		= event.y;

		x		= x + (document.getElementById("tooltiplayer").offsetWidth)
		y		= y + (document.getElementById("tooltiplayer").offsetHeight)

	 if(x<bodwidth)
		x		= event.x
	 else
		x		= x - (document.getElementById("tooltiplayer").offsetWidth*2)

	 if(y<bodheight)
	 {
		 y		= event.y
	 }
	 else {
		y		= y - (document.getElementById("tooltiplayer").offsetHeight*2)
	 }

	y	+=document.body.scrollTop
	x	+=document.body.scrollLeft

	document.getElementById("tooltiplayer").style.posLeft= x+"px";
	document.getElementById("tooltiplayer").style.posTop = y+"px";
	//document.getElementById("tooltiplayer").style.posLeft =160 ;//(8,147)in order to fix the tooltip table exactly to the orderable desc.
	document.getElementById("tooltiplayer").style.visibility='visible'
}

function dupDescCheck(code_exist)
{

	 if (code_exist=="Y")
	 {
		alert(getMessage("CONS_DESC_EXIST","CA"));
		return false;
	 }
	 else
	 {
	   return true;
	 }

}

function resetPage()
{
	//parent.IPConsultationListTopFrame.location.reload();
	//parent.IPConsultationListTabsFrame.location.reload();
	goNewList();
	parent.IPConsultationListResultFrame.location.href="../../eCommon/html/blank.html";
	prevTabObj = "existinglist_tab";
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
 
function patValidCheck(patientIdStatus)
 {
	
	if(patientIdStatus=="INVALID_PATIENT")
	{
		alert(getMessage('INVALID_PATIENT','MP'));
		document.getElementById("patientId").value = "";
		return false;
	}

 }

 function checkValidConsDate(obj)
 {
	
	var cons_back_date	= document.forms[0].cons_back_date.value;
	var current_date	= document.forms[0].current_date;
	var locale			= document.forms[0].locale.value;
	
	if(obj.value!="")
	 {
		if(parseInt(daysBetween(obj.value,current_date.value,'DMY',locale))>parseInt(cons_back_date))
		 {
			 var msg = getMessage('CONS_LT_CURRDATE','CA');
			 msg = msg.replace('$',cons_back_date );
			 alert(msg);
			obj.select();
			obj.focus();
			return false;
		 }

	 }
 }
 function cancelCharge()
 {
	 var bean_key = parent.IPConsultationListResultFrame.document.forms[0].bean_key.value;
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=validate&bean_key="+bean_key, false);
	
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	if(eval(responseText)!=false)
	{
		parent.IPConsultationListResultFrame.IPConsultationListExistListDetailsForm.submit();
	}
	else
	{
		alert(getMessage("PAT__NOT_BLANK","CA"));
		return false;
	}
}


function addToCancelList(obj,rowCnt,patient_id,encounter_id,consult_date_time,order_catalog,p_patient_class,p_episode_id,episode_visit_num,practitioner_id,source_code,source_type,order_id,order_line_num)
{
	
	var cons_ref_id = document.forms[0].cons_ref_id.value;

	var mode="";
	var bean_key = document.forms[0].bean_key.value;
	//IN29413,starts
	var totRecords = document.getElementById("consultCnt").value;
	var totDisabled = document.getElementById("totDisabled").value;
	var totChecked = document.getElementById("totChecked").value;
	//IN29413,ends

	if(obj.checked)
	{
		mode="Add";
		//IN29413,starts
		document.getElementById("totChecked").value=parseInt(totChecked)+1;
		
		if(document.getElementById("existSelAll")!=null)
		{
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("existSelAll").checked='checked';
				document.getElementById("existSelAll").value='Y';
			}
			else
			{
				document.getElementById("existSelAll").checked='';
				document.getElementById("existSelAll").value='N';
			}
		}
		//IN29413,ends
	}
	else
	{
		mode="Rem";
		//IN29413,starts
		document.getElementById("totChecked").value=parseInt(totChecked)-1;

		if(document.getElementById("existSelAll")!=null)
		{
			if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
			{
				document.getElementById("existSelAll").checked='checked';
				document.getElementById("existSelAll").value='Y';
			}
			else
			{
				document.getElementById("existSelAll").checked='';
				document.getElementById("existSelAll").value='N';
			}
		}
		//IN29413,ends
	}
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr	="<root><SEARCH " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&mode="+mode+"&bean_key="+bean_key+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&operation_mode=cancel&cons_ref_id="+cons_ref_id+"&consult_date_time="+consult_date_time+"&order_catalog="+order_catalog+"&p_patient_class="+p_patient_class+"&p_episode_id="+p_episode_id+"&episode_visit_num="+episode_visit_num+"&practitioner_id="+practitioner_id+"&source_code="+source_code+"&source_type="+source_type+"&order_id="+order_id+"&order_line_num="+order_line_num, false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
}

async function callBedSideRefferal(referral_id)
{	
	var retVal = 	new String();
	var dialogHeight= "80vh" ;
	var dialogTop = "100" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = await top.window.showModalDialog("../../eMP/jsp/ViewPatReferral.jsp?referral_id="+referral_id,arguments,features);
}

function disButtons()
{	 									
 	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.CancelCharge.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.ChargeCons.style.display = 'none';
	parent.IPConsultationListToolbarFrame.document.IPConsultationListToolbarForm.Print.style.display = 'none';	
	parent.IPConsultationListResultFrame.location.href='../../eCommon/html/blank.html';
}

function selectAllChk()//IN29413
{
	var totCheck = document.getElementById('consultCnt').value;
	
	if(document.getElementById("selectAll").checked)
	{	
		document.getElementById("selectAll").value='Y';	 
		for(i=1;i<=totCheck;i++)
		{
			var clicker = eval("document.getElementById('consultChk"+i+"')");
			if(clicker.disabled == false)
			{
				if(!clicker.checked)
				clicker.click();
				eval("document.getElementById('consultChk"+i+"')"+".checked=true");			
			}
		}
		document.getElementById("selectAll").checked='checked';
	}
	

	if(!document.getElementById("selectAll").checked)
	{	
		document.getElementById("selectAll").value='N';
		for(i=1;i<=totCheck;i++)  
		{
			var clicker = document.getElementById('consultChk'+i);
			if(clicker.disabled == false)
			{
				if(clicker.checked)
				clicker.click();
				//clicker.checked='';
				//clicker.checked='N';
				document.getElementById('consultChk'+i).checked=false;			
			}
		}
		document.getElementById("selectAll").checked='';
	} 
}

function selectAllChkNext()//IN29413
{
	var totCheck = document.getElementById('consultCntNext').value;
	
	if(document.getElementById("selectAllNext").checked)
	{	
		document.getElementById("selectAllNext").value='Y';	 
		for(i=1;i<=totCheck;i++)
		{
			var clicker = document.getElementById('consultChk'+i);
			if(clicker.disabled == false)
			{
				if(!clicker.checked)
					clicker.click();
				document.getElementById('consultChk'+i).checked=true");			
			}
		}  		
	}

	if(!document.getElementById("selectAllNext").checked)
	{	
		document.getElementById("selectAllNext").value='N';
		for(i=1;i<=totCheck;i++)  
		{
			var clicker = document.getElementById('consultChk'+i);
			if(clicker.disabled == false)
			{
				if(clicker.checked)
				clicker.click();
				document.getElementById('consultChk'+i).checked=false");			
			}
		}
		var beankey =document.forms[0].bean_key.value;
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/IPConsultationIntermediate.jsp?&operation_mode=clearBean&bean_key="+beankey, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);
	} 	 	
}

function existSelectAll()//IN29413
{
	var totCheck = document.getElementById('consultCnt').value;
	
	if(document.getElementById("existSelAll").checked)
	{	
		document.getElementById("existSelAll").value='Y';	 
		for(i=0;i<totCheck;i++)
		{
			var clicker = document.getElementById('consultChk'+i);
			if(clicker.disabled == false)
			{
				if(!clicker.checked)   //internally calls, addToList1
					clicker.click();
				document.getElementById('consultChk'+i).checked=true");			
			}
		}  		
	}

	if(!document.getElementById("existSelAll").checked)
	{	
		document.getElementById("existSelAll").value='N';
		for(i=0;i<totCheck;i++)  
		{
			var clicker = document.getElementById('consultChk'+i);
			if(clicker.disabled == false)
			{
				if(clicker.checked)
				clicker.click();
				document.getElementById('consultChk'+i).checked=false");			
			}
		}
	}
}

function commonSelectAllBehave(mode,chkObj,totRec,totChecked,totDisabled)//IN29413, new added
{
	if(mode == 'Add')
	{
		document.getElementById("totChecked").value=parseInt(totChecked.value)+1;
	
		if(parseInt(totRec.value) == parseInt(document.getElementById("totChecked").value)+parseInt(totDisabled.value))
		{
			document.getElementById("existSelAll").checked='checked';
			document.getElementById("existSelAll").value='Y';
		}
		else 
		{
			document.getElementById("existSelAll").checked='';
			document.getElementById("existSelAll").value='N';
		}

	}
	else if(mode == 'Rem')
	{
		document.getElementById("totChecked").value=parseInt(totChecked.value)-1;
		if(parseInt(totRec.value) == parseInt(document.getElementById("totChecked").value)+parseInt(totDisabled.value))
		{
			document.getElementById("existSelAll").checked='checked';
			document.getElementById("existSelAll").value='Y';
		}
		else 
		{
			document.getElementById("existSelAll").checked='';
			document.getElementById("existSelAll").value='N';
		}	
	}
}


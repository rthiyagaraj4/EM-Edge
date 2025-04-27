/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";


//this will Dyanmically populate the location type 
function populateLocation(location_type,templocale){

	var formObj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr ;

	if(formObj.location_type.value!=null || formObj.locn.value!="")
	{
	document.getElementById("mandat1").innerHTML = "&nbsp;"
	document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"	;
	}
	//else if(formObj.location_type.value==null || formObj.locn.value=="") 
	 
	clearList();
	var formObj = document.formMultiPatientOrdersHdr
	if( location_type.value == "" || location_type.value ==null )  {
		
		if(document.formMultiPatientOrdersHdr.speciality.value==""	 )
		document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
		else
		document.getElementById("mandat").innerHTML = "&nbsp;"

		document.getElementById("mandat1").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
		clearList();
	}
	var bean_id = document.formMultiPatientOrdersHdr.bean_id.value ;
	var bean_name = document.formMultiPatientOrdersHdr.bean_name.value ;
	//alert("bean_id="+bean_id);
	//alert("bean_name="+bean_name);
	//alert("locationtype"+location_type.value);
	

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
 	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	//alert("xmlstr"+xmlStr);
	xmlHttp.open( "POST", "MultiPatientOrdersValidate.jsp?bean_id="+bean_id+"&localeName="+templocale+"&bean_name="+bean_name+"&default_val=''&validate=locn_type", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	//alert(responseText);
	eval(responseText);
}
async function callSpecialityDesc(obj)
{
	if(obj.value!="")
	{
		await callSpeciality(obj);
	}
	else
	{
		document.formMultiPatientOrdersHdr.speciality_code.value="";
		if(document.formMultiPatientOrdersHdr.locn.value=="")
		{
			document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
		}
	}
}

async function callSpeciality(obj)  //Called on click of the speciality
{
		var dataNameArray  		= new Array() ;
		var dataValueArray 		= new Array() ;
  		var dataTypeArray 		= new Array() ;
  		var sql_query			= document.formMultiPatientOrdersHdr.sql_or_order_entry_speciality.value;
  		var argumentArray  		= new Array() ;
  			argumentArray[0]	= sql_query;
			argumentArray[1]	= dataNameArray ;
			argumentArray[2]	= dataValueArray ;
  			argumentArray[3]	= dataTypeArray ;
  			argumentArray[4]	= "1,2";
			argumentArray[5]	= document.formMultiPatientOrdersHdr.speciality.value ;//Target
  		retVal = await callCommonLookUpSearch(argumentArray,obj.name);
  		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal!=null && retVal!='')
  		{
  			document.formMultiPatientOrdersHdr.speciality.value 		= arr[1] ;
  			document.formMultiPatientOrdersHdr.speciality_code.value = arr[0];
		}
		else
	{
	document.formMultiPatientOrdersHdr.speciality.value 		= "";
	}
	var formObj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr ;
	
	if(document.formMultiPatientOrdersHdr.speciality.value=="")
	{
	 document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
	}

	//Commented by Arvind Singh Pal 7/22/2010
	/* else
	{
		 
		 if(formObj.location_type.value==null || formObj.locn.value==""){}
	   document.getElementById("mandat").innerHTML = "&nbsp;"   
	}
	*/
	/*if(formObj.location_type.value==null || formObj.locn.value=="")
	document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
	else
	 document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"	  */
	
}

async function callCommonLookUpSearch(argumentArray,name) // calling the Common Look Up(For Population of Practitioner and Location)
{
  		argumentArray[6]   	= CODE_LINK; // DESC_LINK ;
  		argumentArray[7]   	= CODE_DESC ; // DESC_CODE display part
  		var title			= "";
  		if(name =="location")
  			title			= "Location";
  		else if(name =="speciality")
			title			= "Speciality";
  		else
  			title			= "Practitioner";
  		return retVal = await ORCommonLookup( title, argumentArray );
} // End of Common Look Up


function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.formMultiPatientOrdersHdr.locn.add(element);
}



//this function will be called on click of search
function SearchValues()
{
	//alert();
	var formObj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr ;
	var message="";
	var location_type			=  formObj.location_type.value;
    var locn						=	formObj.locn.value;
	var patientId			    =  formObj.patientId.value;
    var bean_id					=	formObj.bean_id.value;
	var bean_name		    =	formObj.bean_name.value;
	var speciality_code		    =	formObj.speciality_code.value;
	var speciality               =	   formObj.speciality.value;
	var include_checkout_patients               =	   formObj.include_checkout_patients.value;
	  	//alert("speciality"+speciality);
		
	/*	if(speciality==null || speciality=="")
	   {

			alert("1111111");
		  message=getMessage( "LOCN_NOT_BLANK","OR");
		 top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+ message;
	   }  */

 //alert("insearch");
     
	 if((location_type==null || location_type=="") && (speciality==null || speciality==""))
	 {
		message=getMessage( "LOCN_TYPE_NOT_BLANK","OR" ) + "<BR>";
		message= message + getMessage( "LOCN_NOT_BLANK","OR") + "<BR>";
		message= message + getMessage( "SPECAILTY_SHOULD_NOT_BLANK","OR");
		parent.frameMultiPatientOrdersHdrResult.location.href="../../eCommon/html/blank.html";
		top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+ message;
	}
	
	else 
	{
		//alert();
		//&&(speciality==null || speciality=="")
			if((locn==null || locn==""))
			{
				message=getMessage( "LOCN_NOT_BLANK","OR");
				parent.frameMultiPatientOrdersHdrResult.location.href="../../eCommon/html/blank.html";
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+ message;
			}
			
			else
			{
				top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
				parent.frameMultiPatientOrdersHdrResult.location.href='../../eOR/jsp/MultiPatientOrdersHdrResult.jsp?location_type='+location_type+'&locn='+locn+'&patientId='+patientId+'&bean_id='+bean_id+'&bean_name='+bean_name+'&speciality_code='+speciality_code+'&include_checkout_patients='+include_checkout_patients;

				parent.frameMultiPatientOrdersHdrDtl.location.href="../../eOR/jsp/MultiPatientOrdersHdrDtl.jsp"
				parent.frameMultiPatientOrdersTool.location.href="../../eOR/jsp/MultiPatientOrdersTool.jsp"
			}
			//alert("here77");
		}
	   
	//alert("here80");
}




//this function is used to clear the entries of search criteria
function resetValues(){
	document.formMultiPatientOrdersHdr.reset();
	parent.frameMultiPatientOrdersHdrDtl.document.location.href="../../eCommon/html/blank.html"
	parent.frameMultiPatientOrdersHdrResult.document.location.href="../../eCommon/html/blank.html"
	parent.frameMultiPatientOrdersTool.document.location.href="../../eCommon/html/blank.html"
	top.content.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
}




//this function is used to clear the location used on change of location_type 
	function clearList( ) {
	var len = eval("document.formMultiPatientOrdersHdr.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval("document.formMultiPatientOrdersHdr.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp 		= "----------"+getLabel("Common.defaultSelect.label","Common")+"----------- " ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	eval("document.formMultiPatientOrdersHdr.locn.add(opt)") ;
}


//this is used for patient ID search
async function callPatientSearch(){
//	alert();
	var pat_id =  await PatientSearch();
	if(pat_id != null)
	document.getElementById("patientId").value = pat_id;
}


	

//this function is called on clicking the select btn on the Multipattool frame
function Select()
{
	var formObj					= parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr ;
	var location_type			= formObj.location_type.value;
	var locn					= formObj.locn.value;
	var no_of_checked		=0;

	for(i=0;i<parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.recCount.value;i++){
	val = eval("parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.chk"+i);
	if(val.checked == true)
			no_of_checked++;
	}
	if(parseInt(no_of_checked) == 0){
		alert(getMessage("CLICK_ANY_ONE_PATIENT","OR"));
		return false
	}
	parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.target=top.content.workAreaFrame.name;
	parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.submit();
	}




// this function is called on clicking of the checkbox to select all the checkboxes
// in the page where all the records getiing displayed

function clickAll(){
	if(document.formMultiPatientOrdersHdrDtl.CheckMultiOrderPatient1.checked == true){
		for(cnt=0;cnt<parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.recCount.value; cnt++){
			val = eval("parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.chk"+cnt);
			if("S"!=eval("parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.practitionerRel"+cnt).value && "F"!=eval("parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.practitionerRel"+cnt).value)
			val.checked = true;
		}
	}else{
		for(cnt=0; cnt<parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.recCount.value; cnt++){
			val = eval("parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.chk"+cnt);
			val.checked = false;
		}
	}
}

function clearChecked(){
	parent.frameMultiPatientOrdersHdrResult.document.formMultiPatientOrdersHdrResult.reset()
	parent.frameMultiPatientOrdersHdrDtl.document.formMultiPatientOrdersHdrDtl.reset()
}


//function invoked when clicked on Passed Orders hyperlink

function PassedOrders(patient_id,encounter_id,location_type,location_code,patient_class,age,sex,
date_of_birth,Visit_adm_dt,relationship_id)
{
	formobj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
    patientId = formobj.patientId.value;
    speciality_code = formobj.speciality_code.value;
    locn_type = formobj.location_type.value;
    locn_code = formobj.locn.value;
    locn_code = formobj.locn.value;
	var include_checkout_patients               =	   formobj.include_checkout_patients.value;
   	var url="../../eOR/jsp/EnterOrder.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&episode_id="+encounter_id+"&location_type="+location_type+"&location_code="+location_code+"&patient_class="+patient_class+"&visit_adm_date="+Visit_adm_dt+"&Sex="+sex+"&Age="+age+"&Dob="+date_of_birth+"&relationship_id="+relationship_id+"&p_called_from_ca=Y"+"&patientId="+patientId+"&speciality_code="+speciality_code+"&function_from=PASSED_ORDERS&locn_type="+locn_type+"&locn_code="+locn_code+"&multi_called_from=MULTI_PATIENT_ORDER&include_checkout_patients="+include_checkout_patients;
	top.content.workAreaFrame.location.href = url;
}

async function ChangeLocation(target,code)
{
	formobj=parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
    location_type=formobj.location_type.value;
	splty_code=formobj.speciality_code.value;
	locn_code=formobj.locn_code.value;
 
	if(location_type.value!=null || formobj.locn_code.value!="")
	{
		//alert();
		document.getElementById("mandat1").innerHTML = "&nbsp;"
		document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"	;
	}

	var formObj = document.formMultiPatientOrdersHdr
	if( location_type.value == "" || location_type.value ==null )  {
		
		if(document.formMultiPatientOrdersHdr.speciality.value==""	 )
		document.getElementById("mandat").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
		//commented by Channaveer B on 7/22/2010 for Sathya Sai issue
		{
		}
		/*else
		document.getElementById("mandat").innerHTML = "&nbsp;"*/

		document.getElementById("mandat1").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
		
	}
    if(location_type!='')
	{
		if(target.value!="")
		{
			await populateLocations(target,code);
		}
		else
		{
			code.value="";
		}
	}
}

async function populateLocations(target,code){

	formobj=parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
	location_type=formobj.location_type.value;

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	if(location_type!='')
	{
		localeName=formobj.localeName.value;
		var sql="";
		practitioner_id=formobj.practitioner_id.value;
		facility_id=formobj.facility_id.value;
		
		if(location_type!="P")
		{
			//dataNameArray[0] = "PRACTITIONER_ID";
		//	dataValueArray[0] = practitioner_id;
		//	dataTypeArray[0] = STRING;

		//	 dataNameArray[1] = "PRACTITIONER_ID";
	//		dataValueArray[1] = practitioner_id;
	//		dataTypeArray[1] = STRING;
			if(location_type!=null && location_type=="C")
			   location_type	= "OP";
			else if(location_type!=null && location_type=="D")
			   location_type	= "DC";
			else if(location_type!=null && location_type=="E")
			   location_type	= "EM";
			else if(location_type!=null && location_type=="N")
			   location_type	= "IP";

			dataNameArray[0] = "PATIENT_CLASS";
			dataValueArray[0] = location_type;
			dataTypeArray[0] = STRING;

			 dataNameArray[1] = "FACILITY_ID";
			dataValueArray[1] = facility_id;
			dataTypeArray[1] = STRING;

			dataNameArray[2] = "FACILITY_ID";
			dataValueArray[2] = facility_id;
			dataTypeArray[2] = STRING;  

		}

		if(location_type=="P")
		{
			sql=sql=formobj.procedure_sql.value;
			sql=sql.replace('?',"'"+localeName+"'");
		}else
		{
			sql = formobj.location_sql.value;
			for(x=0;x<5;x++)
			{
				sql=sql.replace('?',"'"+localeName+"'");
			}

			sql=sql.replace('?',"'"+practitioner_id+"'");

			
		}
		/*Added by Uma on 12/7/2010 for IN025361*/
		if(location_type!=null && location_type=="D")
		{
			sql = sql.replace("##FILTER##"," and CLINIC_TYPE='Y' ");
		}
		else if(location_type!=null && location_type=="E")
		{
			sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='E' ");
		}
		else if(location_type!=null && location_type=="C")
		{
			sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='A' ");
		}
		else
		{
			sql = sql.replace("##FILTER##"," ");
		}
		/* Ends Here*/

		//alert("practitioner_id : "+practitioner_id+"**PATIENT_CLASS  : "+location_type+"**FACILITY_ID  :  "+facility_id);
		//alert(sql)
		argumentArray[0]   = sql;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;

		if(location_type=="P")
		{
			argumentArray[4]   = "1,2";
		}
		else
		{
			argumentArray[4]   = "4,5";
		}

		argumentArray[5]   = target.value;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ;

		retVal = await CommonLookup(getLabel("Common.Location.label","Common") , argumentArray );
		var ret1=unescape(retVal);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		}
		if(retVal !=null && retVal != ""){
			code.value=arr[0];
			target.value=arr[1];
			document.getElementById("mandat1").innerHTML = "&nbsp;"
			}else{
   			target.value = "";
   			code.value = "" ;
 		}
	}
}

function ClearLocation()
{
	formobj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
    location_type = formobj.location_type.value;
	
	if(location_type!='')
	{
		formobj.location_lookup.disabled=false;
		formobj.locn_code.disabled=false;
		formobj.locn_code.value="";
		formobj.locn.value="";
		if((location_type=="C")||(location_type=="E")||(location_type=="P"))
		{
			/*formobj.all.includeCheckOutPatientsLabel.style.visibility="visible";
			formobj.all.includeCheckOutPatientsChk.style.visibility="visible";
			formobj.include_checkout_patients.checked = false;
			formobj.include_checkout_patients.value = "N";*/
			parent.frameMultiPatientOrdersHdr.document.getElementById('includeCheckOutPatientsLabel').style.visibility="visible";
			parent.frameMultiPatientOrdersHdr.document.getElementById('includeCheckOutPatientsChk').style.visibility="visible";
			formobj.include_checkout_patients.checked = false;
			formobj.include_checkout_patients.value = "N";
		}
		else
		{
			/*formobj.all.includeCheckOutPatientsLabel.style.visibility="hidden";
			formobj.all.includeCheckOutPatientsChk.style.visibility="hidden";*/
			parent.frameMultiPatientOrdersHdr.document.getElementById('includeCheckOutPatientsLabel').style.visibility="hidden";
			parent.frameMultiPatientOrdersHdr.document.getElementById('includeCheckOutPatientsChk').style.visibility="hidden";
		}
	}
	else
	{
		formobj.location_lookup.disabled=true;
		formobj.locn_code.disabled=true;
		formobj.locn_code.value="";
		formobj.locn.value="";
		document.getElementById("mandat1").innerHTML = "<img src='../../eCommon/images/mandatory.gif'>"
	}

}

function ChkCheckOutPatients(obj)
{
	formobj = parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
	if(obj.checked)
	{
		formobj.include_checkout_patients.value = "Y";
	}
	else
	{
		formobj.include_checkout_patients.value = "N";
	}
}

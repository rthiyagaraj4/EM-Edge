/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/ 
function searchPractBy(obj){ // Called on click of the Radio Button for the Query Screen.
	patient_id 		= document.formSearchPract.patient_id.value;
	encounter_id 	= document.formSearchPract.encounter_id.value;
	bean_id 		= document.formSearchPract.bean_id.value;
	bean_name 		= document.formSearchPract.bean_name.value;
	patient_class 		= document.formSearchPract.patient_class.value;
	parent.practDtlFrame.location.href="../../eOR/jsp/OrderEntrySearchPractDtl.jsp?search_by="+obj.value+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&bean_id="+bean_id+"&bean_name="+bean_name+"&patient_class="+patient_class;
} // End of searchPractBy

function setMedicalTeam(obj) // called on click of the radio button to set the value
{
	document.formPractDtl.medical_team_val.value	= obj.value;
	document.formPractDtl.practitioner_name.readOnly	= false;
	document.formPractDtl.practitioner_name.value	= "";
	document.formPractDtl.practitioner_id.value		= "";
} // End of setMedicalTeam
async function callSpeciality(obj)  //Called on click of the speciality
{
	var speciality_value=document.formPractDtl.speciality.value;
	if(document.formPractDtl.search_by.value!='')
	{
		obj.value				= '';
		var dataNameArray  		= new Array() ;
		var dataValueArray 		= new Array() ;
  		var dataTypeArray 		= new Array() ;
  		var sql_query			= document.formPractDtl.sql_or_order_entry_speciality.value;
  		var argumentArray  		= new Array() ;
		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
		argumentArray[2]	= dataValueArray ;
		argumentArray[3]	= dataTypeArray ;
		argumentArray[4]	= "1,2";
		//argumentArray[5]	= document.formPractDtl.speciality.value ;//Target
		argumentArray[5]	= speciality_value;
		retVal = await callCommonLookUpSearch(argumentArray,obj.name);
	
	var ret1=unescape(retVal);
	//alert("ret1:"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
  		if(retVal!=null && retVal!='')
  		{
  			document.formPractDtl.speciality.value 		= arr[1] ;
  			document.formPractDtl.speciality_code.value = arr[0];
			document.formPractDtl.practitioner_name.readOnly	= false;
			document.formPractDtl.practitioner_name.value		= "";
			document.formPractDtl.practitioner_id.value			= "";
  		}
	} // end of search_by
	else
	{
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
	}
} // End of the callSpeciality

async function callSearch(obj,called_on)  //Called on click of the speciality  here called_on argument value indicates C - onclick and B - onBlur
{
//	alert("fun");
   //	obj.value = '';
   if(document.formPractDtl.search_by.value!='')
  	{
  		// To Populate the Medical Team Practitioner
		if(document.formPractDtl.medical_team_val.value == "AT" || document.formPractDtl.medical_team_val.value == "OT")
		{
			await callMedicalSearch(obj,called_on);
		}else if(obj.name == "practitioner_name" && document.formPractDtl.search_by.value == "LO" && document.formPractDtl.location_type.value=='W' && document.formPractDtl.open_to_all_pract_yn.value!='Y')
		{
			await callLocationSearch(obj,called_on);
		}else if(document.formPractDtl.search_by.value == "LO" && obj.name=="practitioner_name" && document.formPractDtl.location_type.value!="W"&& ((document.formPractDtl.patient_class.value=="IP")||(document.formPractDtl.patient_class.value=="DC")))
		{
			await callLocationSearchNursing(obj,called_on);
		}else if(document.formPractDtl.search_by.value == "LO" && obj.name=="location" && document.formPractDtl.location_type.value!='W' && ((document.formPractDtl.patient_class.value=="IP")||(document.formPractDtl.patient_class.value=="DC")))
		{ // For Nursing Unit
			
			await callLocationNursing(obj,called_on);
		}
		else if(document.formPractDtl.search_by.value == "LO" && obj.name=="practitioner_name" && document.formPractDtl.location_type.value!="W"&& ((document.formPractDtl.patient_class.value=="OP")||(document.formPractDtl.patient_class.value=="AE")))
		{
			await callLocationSearch(obj,called_on);
		}else if(document.formPractDtl.search_by.value == "LO" && obj.name=="location" && document.formPractDtl.location_type.value!='W' && ((document.formPractDtl.patient_class.value=="OP")||(document.formPractDtl.patient_class.value=="AE")))
		{ // For Clinic
			await callLocationClinic(obj,called_on);
		}else if(document.formPractDtl.search_by.value == "SP" && obj.name=="speciality")
		{ // for speciality look up
			await callSpecialitySearch(obj,called_on);
		}else  if(document.formPractDtl.search_by.value == "SP" && obj.name=="practitioner_name")
		{ // for speciality practitioner lookup
			await callSpecialitySearchPract(obj,called_on);
		}else if(document.formPractDtl.search_by.value == "AL" || (document.formPractDtl.search_by.value == "LO" && obj.name=="practitioner_name" && document.formPractDtl.open_to_all_pract_yn.value=="Y" && document.formPractDtl.location_type.value=="W"))
		{
			await callPractitioner(obj,called_on); // For the All Practitioner and also for the Practitioner when the location is clinic and open_to_all_pract_yn = 'Y'
		}
	}
} // End of the callSearch

async function callMedicalSearch(obj,called_on)
{
/*	var dataNameArray 	= new Array() ;
 		dataNameArray[0] 		= "facility_id" ;
		dataNameArray[1] 		= "facility_id" ;
		dataNameArray[2] 		= "practitioner_id" ;
 		dataNameArray[3] 		= "practitioner_id" ;
 	var dataValueArray 	= new Array() ;
 		dataValueArray[0] 		= document.formPractDtl.facility_id.value ;
		dataValueArray[1] 		= document.formPractDtl.facility_id.value ;
		dataValueArray[2] 		= document.formPractDtl.practitioner_id_val.value  ;
 		dataValueArray[3] 		= document.formPractDtl.practitioner_id_val.value  ;
 	var dataTypeArray 	= new Array() ;
 		dataTypeArray[0] 		= STRING ;
	  	dataTypeArray[1] 		= STRING ;
	  	dataTypeArray[2] 		= STRING ;
 		dataTypeArray[3] 		= STRING ;
	
   	var sql_query 				= "";
   		if(document.formPractDtl.medical_team_val.value == "AT")
   			sql_query 			= document.formPractDtl.sql_or_order_entry_medical_attend_pract.value;
   		else if(document.formPractDtl.medical_team_val.value == "OT")
  			sql_query			= document.formPractDtl.sql_or_order_entry_medical_other_pract.value;
  	var argumentArray 			= new Array() ;
 		argumentArray[0]		= sql_query;
		argumentArray[1]		= dataNameArray ;
  		argumentArray[2]		= dataValueArray ;
    	argumentArray[3]		= dataTypeArray ;
    	argumentArray[4]		= "6,5";
  		argumentArray[5]		= document.formPractDtl.practitioner_name.value ;//Target
    	retVal					= callCommonLookUpSearch(argumentArray,obj.name);
    	if(retVal!=null && retVal!='')
    	{
    		document.formPractDtl.practitioner_name.value = retVal[1] ;
  			document.formPractDtl.practitioner_id.value	  = retVal[0];
    	}
	*/
		if(obj.value != '' || (called_on == 'C' && !obj.readOnly)){
		var practName_FName	= obj.name;		// object name
		var practName_FValue= encodeURIComponent(obj.value);
		//var practId_FName	= document.formPractDtl.practitioner_id_val.value;Modified for IN11116 by Uma on 6/4/2009
		var practId_FName	= document.formPractDtl.practitioner_id_value.value;
		var sql				= "";
		var sql2			= "";
		var facility_id		= document.formPractDtl.facility_id.value ;
		var count			= "";	
		var localeName = document.formPractDtl.localeName.value;
		
 		if(document.formPractDtl.medical_team_val.value == "AT") 
		{
   			sql 			= document.formPractDtl.sql_or_order_entry_medical_attend_pract.value;
   			sql2 			= document.formPractDtl.sql_or_order_entry_medical_attend_pract_sql2.value;
 		} 
		else if(document.formPractDtl.medical_team_val.value == "OT") 
		{ 
			sql				= document.formPractDtl.sql_or_order_entry_medical_other_pract_sql2.value;
			sql2			= document.formPractDtl.sql_or_order_entry_medical_other_pract.value;
  		}

		sql = sql.replace('!~localeName~!',localeName).replace('!~localeName~!',localeName);
		sql2 = sql2.replace('!~localeName~!',localeName).replace('!~localeName~!',localeName);
		//alert("sql "+sql);
		//alert(sql2);
		count			= sql.indexOf("?");   //Facility_id
		sql  			= sql.substring(0,count) + "'"+facility_id+"'"+ sql.substring(count+1)  ;
		count 			= sql.indexOf("?");   //Facility_id
		sql  			= sql.substring(0,count) + "'"+facility_id+"'"+ sql.substring(count+1)  ;
		count 			= sql.indexOf("?");   //practitioner_id
 		sql  			= sql.substring(0,count) + "'"+practId_FName+"'"+ sql.substring(count+1)  ;
		count 			= sql.indexOf("?");   //practitioner_id
 		sql  			= sql.substring(0,count) + "'"+practId_FName+"'"+ sql.substring(count+1)  ;
		
		count			= 0;
		count			= sql2.indexOf("?");   //Facility_id
		sql2  			= sql2.substring(0,count) + "'"+facility_id+"'"+ sql2.substring(count+1)  ;
		count 			= sql2.indexOf("?");   //Facility_id
		sql2  			= sql2.substring(0,count) + "'"+facility_id+"'"+ sql2.substring(count+1)  ;
		count 			= sql2.indexOf("?");   //practitioner_id
 		sql2  			= sql2.substring(0,count) + "'"+practId_FName+"'"+ sql2.substring(count+1)  ;
		count 			= sql2.indexOf("?");   //practitioner_id
 		sql2  			= sql2.substring(0,count) + "'"+practId_FName+"'"+ sql2.substring(count+1)  ;

   		var splty			= "";

		await  commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty); //Call the common lookup 	
		}
} // End of callMedicalSearch

async function commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty) 
{
	//facility_id		= facilityID;
	// here not needed job_title , gender, practitioner_type, specialty-code
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	xmlStr			="<root><SEARCH " ;
	xmlStr			+= " practName_FName=\"" +practName_FName + "\"";
	xmlStr			+= " practName_FValue=\"" + practName_FValue + "\"";
	xmlStr			+= " sql=\"" +escape(sql)+ "\"";
	xmlStr			+= " sqlSec=\"" +escape(sql2)+ "\"";
	xmlStr			+= " practitioner_type=\"" + "" + "\"";
	xmlStr			+= " specialty_code=\"" + splty+ "\"";
	xmlStr			+= " job_title=\"" + "" + "\"";
	xmlStr			+= " gender=\"" + "" + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp", false ) ;
	xmlHttp.send(xmlDoc);
	responseText	= xmlHttp.responseText;
	responseText	= trimString(responseText);
	eval(await practSearch(practName_FName,practName_FValue,splty,responseText));
} // End of PractitionerLookUp
async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "82vh" ;
	var dialogWidth	= "65vw" ;
		
	if(responseText =="true") {        	
	    dialogWidth="70.5";
	}
	
	var status = "no";
	var arguments	= "" ;
	var tit="Pract Search";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	var sqlArray= new Array();
	//var objName="<%=practName_FName%>";
	var objName=practName_FName;
    arguments='';
	
	//retVal = window.showModalDialog("<%=request.getContextPath()%>/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+"<%=practName_FValue%>"+"&practitioner_type="+"<%=practitioner_type%>"+"&primary_specialty="+"<%=specialty_code%>"+"&job_title="+"<%=job_title%>"+"&gender="+"<%=gender%>",arguments,features);
	
	retVal = await top.window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}
function PractLookupRetVal(retVal,target)
{
 	if(retVal != null && retVal != "")
		{
			arr=retVal.split("~");
			document.formPractDtl.practitioner_id_val.value=arr[0];
			document.formPractDtl.practitioner_id.value=arr[0];
			document.formPractDtl.practitioner_name.value = arr[1]
				
 		}
		else
		{
			//document.formPractDtl.practitioner_id_val.value="";
			document.formPractDtl.practitioner_id.value="";
			document.formPractDtl.practitioner_name.value="";
			document.formPractDtl.practitioner_name.focus();
		}
 }


async function callLocationSearch(obj,called_on)
{
	/*var dataNameArray 			= new Array() ;
		dataNameArray[0] 		= "facility_id" ;
		dataNameArray[1] 		= "clinic_code" ;
	var dataValueArray 	= new Array() ;
		dataValueArray[0] 		=  document.formPractDtl.facility_id.value;
		dataValueArray[1] 		=  document.formPractDtl.location_code.value;
  	var dataTypeArray 			= new Array() ;
 		dataTypeArray[0] 		= STRING ;
	  	dataTypeArray[1] 		= STRING ;
	var sql_query				= document.formPractDtl.sql_or_order_entry_location_pract.value;
	var argumentArray 			= new Array() ;
		argumentArray[0]		= sql_query;
		argumentArray[1]		= dataNameArray ;
	  	argumentArray[2]		= dataValueArray ;
    	argumentArray[3]		= dataTypeArray ;
		argumentArray[4]		= "4,3";
		argumentArray[5]		= document.formPractDtl.practitioner_name.value ; //Target
		retVal					= callCommonLookUpSearch(argumentArray,obj.name);
    	if(retVal!=null && retVal!='')
    	{
    		document.formPractDtl.practitioner_name.value = retVal[1] ;
  			document.formPractDtl.practitioner_id.value	  = retVal[0];
    	}
		*/
		if(obj.value != '' || (called_on == 'C' && !obj.readOnly)){
 		var practName_FName	= obj.name;		// object name
		var practName_FValue= encodeURIComponent(obj.value);
		var practId_FName	= document.formPractDtl.practitioner_id_val.value;
	
		var sql				= document.formPractDtl.sql_or_order_entry_location_pract.value;
		var sql2			= document.formPractDtl.sql_or_order_entry_location_pract_sql2.value;
		
		var facility_id		= document.formPractDtl.facility_id.value ;
		var location_code	= document.formPractDtl.location_code.value;
		var localeName = document.formPractDtl.localeName.value;
		var  count			= "";	
		sql = sql.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
		sql2 = sql2.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
		//alert(sql);
		//alert(sql2);
 		count			= sql.indexOf("?");   //Facility_id
		sql  			= sql.substring(0,count) + "'"+facility_id+"'"+ sql.substring(count+1)  ;
		count 			= sql.indexOf("?");   //clinic_code
		sql  			= sql.substring(0,count) + "'"+location_code+"'"+ sql.substring(count+1)  ;
		
		count			= 0;
		count			= sql2.indexOf("?");   //Facility_id
		sql2  			= sql2.substring(0,count) + "'"+facility_id+"'"+ sql2.substring(count+1)  ;
		count 			= sql2.indexOf("?");   //clinic_code
		sql2  			= sql2.substring(0,count) + "'"+location_code+"'"+ sql2.substring(count+1)  ;

 		var splty			= "";
		await commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty); //Call the common LookuP
		}
} // End of callLocationSearch

async function callLocationSearchNursing(obj,called_on)
{
	/*var dataNameArray 			= new Array() ;
		dataNameArray[0] 		= "nursing_unit_code" ;
	var dataValueArray 			= new Array() ;
		dataValueArray[0] 		=  document.formPractDtl.location_code.value;
  	var dataTypeArray 			= new Array() ;
 		dataTypeArray[0] 		= STRING ;
	var sql_query				= document.formPractDtl.sql_or_order_entry_location_nu_pract.value;
	var argumentArray 			= new Array() ;
		argumentArray[0]		= sql_query;
		argumentArray[1]		= dataNameArray ;
	  	argumentArray[2]		= dataValueArray ;
    	argumentArray[3]		= dataTypeArray ;
		argumentArray[4]		= "3,2";
  		argumentArray[5]		= document.formPractDtl.practitioner_name.value ; //Target
		retVal					= callCommonLookUpSearch(argumentArray,obj.name);
    	if(retVal!=null && retVal!='')
    	{
    		document.formPractDtl.practitioner_name.value = retVal[1] ;
  			document.formPractDtl.practitioner_id.value	  = retVal[0];
    	}
	*/if(obj.value != '' || (called_on == 'C' && !obj.readOnly)){
		var practName_FName	= obj.name;		// object name
		var practName_FValue= obj.value;
		var practId_FName	= document.formPractDtl.practitioner_id_val.value;
		var facility_id		= document.formPractDtl.facility_id.value ;
		var sql				= document.formPractDtl.sql_or_order_entry_location_nu_pract.value;
		var sql2			= document.formPractDtl.sql_or_order_entry_location_nu_pract_sql2.value;
		
 		var location_code	= document.formPractDtl.location_code.value;
		var  count	= sql.indexOf("?");   //nursing_unit_code
		sql  				= sql.substring(0,count) + "'"+location_code+"'"+ sql.substring(count+1)  ;
		count			= sql.indexOf("?");   //Facility_id
		sql  			    = sql.substring(0,count) + "'"+facility_id+"'"+ sql.substring(count+1)  ;
		
		count				= 0;
		count				= sql2.indexOf("?");   //nursing_unit_code
		sql2  				= sql2.substring(0,count) + "'"+location_code+"'"+ sql2.substring(count+1) ;
		count			    = sql2.indexOf("?");   //Facility_id
		sql2  			    = sql2.substring(0,count) + "'"+facility_id+"'"+ sql2.substring(count+1)  ;

   		var splty			= "";

		await commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty); //Call the common 
	}
} // end of callLocationSearchNursing

async function callSpecialitySearch(obj,called_on)
{
	var dataNameArray 			= new Array() ;
	var dataValueArray 			= new Array() ;
	var dataTypeArray 			= new Array() ;
	var sql_query				= document.formPractDtl.sql_or_order_entry_speciality.value;
	var argumentArray 			= new Array() ;
	argumentArray[0]	= sql_query;
	argumentArray[1]    = dataNameArray ;
	argumentArray[2]    = dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]		= "1,2";
	argumentArray[5]		= document.formPractDtl.practitioner_name.value ; //Target
	retVal					= await callCommonLookUpSearch(argumentArray,obj.name);
		
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal!=null && retVal!='')
	{
		document.formPractDtl.practitioner_name.value = arr[1] ;
		document.formPractDtl.practitioner_id.value	  = arr[0];
		document.formPractDtl.practitioner_name.readOnly	= false;
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
	}else{
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
	}
} // End of callSpecialitySearch

async function callSpecialitySearchPract(obj,called_on)
{
/*	var dataNameArray 			= new Array() ;
		dataNameArray[0] 		= "facility_id" ;
		dataNameArray[1] 		= "facility_id" ;
		dataNameArray[2] 		= "speciality_code" ;
	var dataValueArray 			= new Array() ;
		dataValueArray[0] 		=  document.formPractDtl.facility_id.value;
		dataValueArray[1] 		=  document.formPractDtl.facility_id.value;
		dataValueArray[2] 		=  document.formPractDtl.speciality_code.value;
  	var dataTypeArray 			= new Array() ;
 		dataTypeArray[0] 		= STRING ;
 		dataTypeArray[1] 		= STRING ;
 		dataTypeArray[2] 		= STRING ;
 	var sql_query				= document.formPractDtl.sql_or_order_entry_speciality_pract.value;
 	var argumentArray 			= new Array() ;
 		argumentArray[0]		= sql_query;
		argumentArray[1]		= dataNameArray ;
	  	argumentArray[2]		= dataValueArray ;
    	argumentArray[3]		= dataTypeArray ;
    	argumentArray[4]		= "5,4";
  		argumentArray[5]		= document.formPractDtl.practitioner_name.value ;//Target
  		retVal					= callCommonLookUpSearch(argumentArray,obj.name);
    	if(retVal!=null && retVal!='')
    	{
    		document.formPractDtl.practitioner_name.value = retVal[1] ;
  			document.formPractDtl.practitioner_id.value	  = retVal[0];
    	}
*/
if(obj.value != '' || (called_on == 'C' && !obj.readOnly)){
	var practName_FName	= obj.name;		// object name
	var practName_FValue= encodeURIComponent(obj.value);
	var localeName = document.formPractDtl.localeName.value;
	var practId_FName	= document.formPractDtl.practitioner_id_val.value;
	var sql				= document.formPractDtl.sql_or_order_entry_pract.value;
	var sql2			= document.formPractDtl.sql_or_order_entry_pract_sql2.value;
	sql = sql.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
	sql2 = sql2.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
	//alert(sql);
	//alert(sql2);
 	var splty			=  document.formPractDtl.speciality_code.value;
	await commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty); //Call the common 
	}
} // End of callSpecialitySearchPract

async function callPractitioner(obj,called_on)
{
	/*var dataNameArray 		= new Array() ;
	var dataValueArray 		= new Array() ;
  	var dataTypeArray 		= new Array() ;
 	var sql_query			= document.formPractDtl.sql_or_order_entry_pract.value;
 	var argumentArray 		= new Array() ;
 		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
	  	argumentArray[2]	= dataValueArray ;
    	argumentArray[3]	= dataTypeArray ;
    	argumentArray[4]	= "2,1";
  		argumentArray[5]	= document.formPractDtl.practitioner_name.value ;//Target
  	retVal					= callCommonLookUpSearch(argumentArray,obj.name);
    if(retVal!=null && retVal!='')
    {
    	document.formPractDtl.practitioner_name.value = retVal[1] ;
  		document.formPractDtl.practitioner_id.value	  = retVal[0];
    }
	*/
	if(obj.value != '' || (called_on == 'C' && !obj.readOnly)){
	var practName_FName	= obj.name;		// object name
	var practName_FValue= encodeURIComponent(obj.value);
	var localeName = document.formPractDtl.localeName.value;
	var practId_FName	= document.formPractDtl.practitioner_id_val.value;
	var sql				= document.formPractDtl.sql_or_order_entry_pract.value;
	
	var sql2			= document.formPractDtl.sql_or_order_entry_pract_sql2.value;
	sql = sql.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
	sql2 = sql2.replace("!~localeName~!",localeName).replace("!~localeName~!",localeName);
 	
   //	alert(sql);
   	//alert(sql2);
	var splty			= "";
	await commonPractitionerLookUp(practName_FName,practName_FValue,sql,sql2,splty); //Call the common 
	}
} // End of callPractitioner

async function callLocationNursing(obj,called_on)
{
	document.formPractDtl.location_code.value = "";

 	var dataNameArray 		= new Array() ;
	var dataValueArray 		= new Array() ;
  	var dataTypeArray 		= new Array() ;
	sql_query				= document.formPractDtl.sql_or_order_entry_location_nu.value;
	sql_query					= sql_query.replace('?',"'"+document.formPractDtl.localeName.value+"'");
	var argumentArray 		= new Array() ;
 		argumentArray[0]	= sql_query;
		argumentArray[1]	= dataNameArray ;
	  	argumentArray[2]	= dataValueArray ;
    	argumentArray[3]	= dataTypeArray ;
    	argumentArray[4]	= "1,2";
  		argumentArray[5]	= document.formPractDtl.location.value ;//Target
  		retVal				= await callCommonLookUpSearch(argumentArray,obj.name);
		
	var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
    	if(retVal!=null && retVal!='')
    	{
    		document.formPractDtl.location.value = arr[1] ;
  			document.formPractDtl.location_code.value	  = arr[0];
			document.formPractDtl.practitioner_name.readOnly	= false;
			document.formPractDtl.practitioner_name.value		= "";
			document.formPractDtl.practitioner_id.value			= "";
    	}else{
			document.formPractDtl.practitioner_name.readOnly	= true;
			document.formPractDtl.practitioner_name.value		= "";
			document.formPractDtl.practitioner_id.value			= "";
		}
} // End of callLocationNursing

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
  		return retVal = await ORCommonLookup1( title, argumentArray );
} // End of Common Look Up
//
async function ORCommonLookup1(title, pArgumentArray) {
    var retVal = new String();
    var dialogHeight= "65vh" ;
    var dialogWidth = "50vw" ;
    var status = "no";

    var xmlDoc = "" ;
    var xmlHttp = new XMLHttpRequest() ;

    xmlStr ="<root><SEARCH " ;
    xmlStr +=" /></root>" ;

    //alert(pArgumentArray)

    firstCodeVal = "" ;
    firstDescVal = "" ;
    xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

    //alert(formQueryString(pArgumentArray,0))
    xmlHttp.open( "GET", "../../eOR/jsp/OrCommonLookupResult.jsp?title="+escape(title)+"&callFrom=0&" + formQueryString(pArgumentArray,0) , false ) ;
    xmlHttp.send( xmlDoc ) ;
    responseText=xmlHttp.responseText ;

    eval(responseText) ;

    if(firstCodeVal == "")
    {
        var dialogUrl       = "../../eOR/jsp/OrCommonLookup.jsp?title="+escape(title) ;
        var dialogArguments = pArgumentArray ;
        var dialogFeatures  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
        var returnVal = await top.window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);

        if( returnVal == null || returnVal == "" )
            return "";
        else
            return returnVal.split("\"") ;
     }
     else
     {
         if(pArgumentArray[7] == CODE_DESC )
         {
            var temp = firstCodeVal
            firstCodeVal = firstDescVal
            firstDescVal = temp
         }
          returnVal = firstCodeVal + "\"" + firstDescVal

         return returnVal.split("\"") ;
     }
}
//
 // Function called in the addnl. search in the text box if the user clicks the enter key,
 function populateValues(){
	if(window.event.keyCode==13) {    // if it is an enter key, then populate a
 	 	additionalSearch();   // Call the additionalSearch Function
	}
}

function additionalSearch() // on click of the search button in the addnl. search
{
	
  	var result = true;
	function_from       = parent.criteriaMainFrame.addlSearchCriteriaForm.function_from.value
	var medico_legal_yn =  parent.parent.frames[0].document.getElementById("medico_legal_yn").value;
	var callingFrom = parent.parent.frames[0].document.getElementById("callingFrom").value;
	if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value=='Y' && parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.value== "")
	{
		result = false;
		alert(getMessage('ORDER_CATEGORY','OR'));
	}
	else if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value=='Y' && parent.criteriaMainFrame.addlSearchCriteriaForm.order_type_yn.value=="Y")
	{
		if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.value=="")
		{
			result = false;
			alert(getMessage('ORDER_TYPE','OR'));
		}
	}
	else if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.value=="" && parent.criteriaMainFrame.addlSearchCriteriaForm.orderable_text.value=="" && parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_value.value=="")
	{
		if(parent.criteriaMainFrame.addlSearchCriteriaForm.orderable_text.value=="")
		{
			result = false;
			alert(getMessage('DESC_NOT_BLANK','OR'));
		}
	}
	else if (parent.criteriaMainFrame.addlSearchCriteriaForm.order_type_yn.value=="Y" && parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.value=="")
	{
			result = false;
			alert(getMessage('ORDER_TYPE','OR'));
	}
	if(result)
	{
		if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value == "Y" && parent.criteriaMainFrame.addlSearchCriteriaForm.order_type_yn.value == "Y")
		{
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.disabled 	= true;
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.disabled 		= true;
		}
		else if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value =="N" && parent.criteriaMainFrame.addlSearchCriteriaForm.order_type_yn.value =="N" && function_from!="EXTERNAL_ORDER")
		{
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.disabled 	= false;
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.disabled 	= false;
		}
		else if(function_from!="EXTERNAL_ORDER")
		{
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.disabled 	= true;
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.disabled 		= false;
		}

		if(parent.criteriaMainFrame.addlSearchCriteriaForm.ammend_called_from.value=="existing_order")
			parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.disabled=true;
		var Applicability_yn = "";
		if( parent.criteriaMainFrame.addlSearchCriteriaForm.ApplicableCatalogs)
		{
			Applicability_yn = parent.criteriaMainFrame.addlSearchCriteriaForm.ApplicableCatalogs.value;
		}

		order_category 		= parent.criteriaMainFrame.addlSearchCriteriaForm.order_category.value;

		//Added by Uma on 1/21/2011 for IN026035
		if(parent.criteriaMainFrame.addlSearchCriteriaForm)
		{
			if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_type_desc.value=="")
			{
				parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.value = "";
			}
		}

		order_type			= parent.criteriaMainFrame.addlSearchCriteriaForm.order_type.value;
		activity_type		= parent.criteriaMainFrame.addlSearchCriteriaForm.activity_type.value;
		order_catalog_nature= parent.criteriaMainFrame.addlSearchCriteriaForm.order_catalog_nature.value;
		orderable_text		= parent.criteriaMainFrame.addlSearchCriteriaForm.orderable_text.value;
		criteria			= parent.criteriaMainFrame.addlSearchCriteriaForm.criteria.value;
		restrict_by			= parent.criteriaMainFrame.addlSearchCriteriaForm.restrict_by.value;
		bean_id   			= parent.criteriaMainFrame.addlSearchCriteriaForm.bean_id.value
		bean_name 			= parent.criteriaMainFrame.addlSearchCriteriaForm.bean_name.value
 		var order_dispaly_verticalYN 		= parent.criteriaMainFrame.addlSearchCriteriaForm.order_dispaly_verticalYN.value  // IN038787
 		// call the bean method if checked or unchecked
		storeCheckedValues("orderSetResultForm","YES");
		// Enabled the rapid_orders button
		if(parent.criteriaMainFrame.addlSearchCriteriaForm.rapid_orders)
			parent.criteriaMainFrame.addlSearchCriteriaForm.rapid_orders.disabled = false
		parent.criteriaMainFrame.addlSearchCriteriaForm.search.disabled = true;
		/*Modified by Uma on 8/24/2009 for PMG20089 CRF-641 added prev_applicability_yn*/
		//IN030279 Start
		//parent.criteriaDetailFrame.location.href = "../../eOR/jsp/OrderEntryResultMain.jsp?order_type="+order_type+"&order_category="+order_category+"&activity_type="+activity_type+"&order_catalog_nature="+order_catalog_nature+"&orderable_text="+encodeURIComponent(orderable_text)+"&criteria="+criteria+"&restrict_by="+restrict_by+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_from="+function_from+"&priv_applicability_yn="+Applicability_yn;
		
		// IN038787 Start.
		//parent.criteriaDetailFrame.location.href = "../../eOR/jsp/OrderEntryResultMain.jsp?order_type="+order_type+"&order_category="+order_category+"&activity_type="+activity_type+"&order_catalog_nature="+order_catalog_nature+"&orderable_text="+encodeURIComponent(orderable_text)+"&criteria="+criteria+"&restrict_by="+restrict_by+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_from="+function_from+"&priv_applicability_yn="+Applicability_yn+"&medico_legal_yn="+medico_legal_yn+"&callingFrom="+callingFrom;
		parent.criteriaDetailFrame.location.href = "../../eOR/jsp/OrderEntryResultMain.jsp?order_type="+order_type+"&order_category="+order_category+"&activity_type="+activity_type+"&order_catalog_nature="+order_catalog_nature+"&orderable_text="+encodeURIComponent(orderable_text)+"&criteria="+criteria+"&restrict_by="+restrict_by+"&bean_id="+bean_id+"&bean_name="+bean_name+"&function_from="+function_from+"&priv_applicability_yn="+Applicability_yn+"&medico_legal_yn="+medico_legal_yn+"&callingFrom="+callingFrom+"&order_dispaly_verticalYN="+order_dispaly_verticalYN; //IN038787
		// IN038787 End.
		//IN030279 End.
		/*parent.criteriaMainFrame.document.addlSearchCriteriaForm.method	  =  "POST";
		parent.criteriaMainFrame.document.addlSearchCriteriaForm.target	  = 'criteriaDetailFrame'
		parent.criteriaMainFrame.document.addlSearchCriteriaForm.action   = "../../eOR/jsp/OrderEntryResultMain.jsp";
		parent.criteriaMainFrame.document.addlSearchCriteriaForm.submit();
		*/
	}
} // End of additionalSearch

function clearAdditionalSearch()  // on click of the clear button in the addnl. search
{
	// Since the population of the order type and the activity type, on click of the clear button,
	// it has to be called the population again  that is why it has been reloaded instead of reseting
	
	document.location.reload();
 	/*
		if(!document.addlSearchCriteriaForm.order_category.disabled)
	{
		document.addlSearchCriteriaForm.order_category.disabled = false;
		document.addlSearchCriteriaForm.order_category.value    = "";
	}

	if(!document.addlSearchCriteriaForm.order_type.disabled)
	{
		document.addlSearchCriteriaForm.order_type.disabled		 = false;
		document.addlSearchCriteriaForm.order_type.value   		 = "";
	}
	document.addlSearchCriteriaForm.activity_type.value   		 = "";
	
	document.addlSearchCriteriaForm.restrict_by.checked     	 = false;
	document.addlSearchCriteriaForm.order_catalog_nature.value	 = "";
	document.addlSearchCriteriaForm.orderable_text.value	 	 = "";
	document.addlSearchCriteriaForm.criteria.value	 			 = "C";

	//document.addlSearchCriteriaForm.reset();
	document.addlSearchCriteriaForm.document.getElementById("order_type_mand").style.visibility = "hidden";  // Hide the gif for the order_type
	//document.addlSearchCriteriaForm.order_category.disabled = false;
	//document.addlSearchCriteriaForm.order_type.disabled 	= false;
	if(parent.criteriaMainFrame.addlSearchCriteriaForm.rapid_orders)
		parent.criteriaMainFrame.addlSearchCriteriaForm.rapid_orders.disabled = true
 	if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value!='Y')
		document.getElementById("order_text").innerHTML="&nbsp;&nbsp;<input type=\"text\" name=\"orderable_text\" value = '' size=\"25\" maxlength=\"40\" onKeyPress='populateValues()'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>";
   */
	if(parent.criteriaDetailFrame.resultHdrFrame)
		parent.criteriaDetailFrame.resultHdrFrame.location.href = "../../eCommon/html/blank.html"
	if(parent.criteriaDetailFrame.resultListFrame)
		parent.criteriaDetailFrame.resultListFrame.location.href = "../../eCommon/html/blank.html"
	if(parent.criteriaDetailFrame.resultDtlFrame)
		parent.criteriaDetailFrame.resultDtlFrame.location.href = "../../eCommon/html/blank.html"
} // End of clearAdditionalSearch

 // To populate the Order Type List box, based upon the order - category in addn'. search
function populateOrderType( obj ) {
		// It has to be fired even if it is null
		document.getElementById("order_text").innerHTML="<input type=\"text\" name=\"orderable_text\" id=\"orderable_text\" value = '' size=\"15\" maxlength=\"40\" onKeyPress='populateValues()'><select name='criteria' id='criteria'><option value='C'>"+getLabel("Common.contains.label","Common")+"</option><option value='S'>"+getLabel("Common.startsWith.label","Common")+"</option><option value='E'>"+getLabel("Common.endsWith.label","Common")+"</option></select>";
		var bean_id 			= document.addlSearchCriteriaForm.bean_id.value ;
		var bean_name 			= document.addlSearchCriteriaForm.bean_name.value ;
		var localeName			= document.addlSearchCriteriaForm.localeName.value;
		var order_category_yn 	= document.addlSearchCriteriaForm.order_category_yn.value;
		var order_type_yn  		= document.addlSearchCriteriaForm.order_type_yn.value;
		 var xmlDoc = ""; 
	var xmlHttp = new XMLHttpRequest();

		xmlStr			= "<root><SEARCH " ;
		xmlStr 			+= obj.name+"=\""+ obj.value +"\" " ;
		xmlStr 			+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category_yn="+order_category_yn+"&order_type_yn="+order_type_yn+"&func_mode=ORDER_TYPE_POPULATE&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;

		eval( responseText ) ;
	if(obj.value=='')
	{
		
		if(parent.criteriaMainFrame.addlSearchCriteriaForm.order_category_yn.value!='Y')
		document.getElementById("order_text").innerHTML="<input type=\"text\" name=\"orderable_text\" id=\"orderable_text\" value = '' size=\"15\" maxlength=\"40\" onKeyPress='populateValues()'>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img><select name='criteria' id='criteria'><option value='C'>"+getLabel("Common.contains.label","Common")+"</option><option value='S'>"+getLabel("Common.startsWith.label","Common")+"</option><option value='E'>"+getLabel("Common.endsWith.label","Common")+"</option></select>";
		}
} // End of populateOrderType

// To clear the list box
function clearOrderList( docObj,form_name ) {
	var len = eval(form_name+".order_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(form_name+".order_type.remove(\"order_type\")") ;
	}
	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(form_name+".order_type.add(opt)") ;
} // End of clearOrderList

// To add in the List box
function addOrderList(form_name,code,value) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  code ;
	element.text 	= value ;
	form_name = eval(form_name+".order_type");
	form_name.add(element);
	//form_name.order_type.add(element);
} // End of addOrderList

// To add the values in the activity_type List box
function addActivityOrderList(form_name,code,value) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  code ;
	element.text 	= value ;
	form_name = eval(form_name+".activity_type");
	form_name.add(element);
} // End of addActivityOrderList

// To clear the list box of the activity_type
function clearActivityList( docObj,form_name ) {
	var len = eval(form_name+".activity_type.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(form_name+".activity_type.remove(\"activity_type\")") ;
	}
	var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
	var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	eval(form_name+".activity_type.add(opt)") ;
} // End of clearActivityList

// To populate the order_type in the tick sheets
function populateOrder(obj)
{

	if( obj.value == "" )
	{
	    document.tickSheetForm.reset();
	    parent.criteriaDetailFrame.location.href		="../../eCommon/html/blank.html"
		parent.criteriaTickSheetsFrame.location.href	="../../eCommon/html/blank.html"
	}
	// It has to be fired even if the value is not there
	var bean_id 			= document.tickSheetForm.bean_id.value ;
	var localeName			= document.tickSheetForm.localeName.value;

	var bean_name 			= document.tickSheetForm.bean_name.value ;
	var order_category_yn 	= document.tickSheetForm.order_category_yn.value;
	var order_category 		= document.tickSheetForm.order_category.value;

	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	xmlStr					= "<root><SEARCH " ;
	xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
	xmlStr 					+=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category_yn="+order_category_yn+"&order_category="+order_category+"&func_mode=TICK_SHEET_ORDER_TYPE_POPULATE&localeName="+localeName, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;
} // End of populateOrder

// To populate the tick sheets in the tick sheet tab(on load of the form)
function populateTickSheetId(obj)
{
   	if(obj.value!="")
  	{
  		var bean_id 			= document.tickSheetForm.bean_id.value ;
		var bean_name 			= document.tickSheetForm.bean_name.value ;
		var order_category_yn 	= document.tickSheetForm.order_category_yn.value;
		var order_type_yn 		= document.tickSheetForm.order_type_yn.value;
		var order_category 		= document.tickSheetForm.order_category.value;
	    var localeName			= document.tickSheetForm.localeName.value;

		//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		//var xmlDoc 				="";
		var xmlHttp 			= new XMLHttpRequest();
		xmlStr					= "<root><SEARCH " ;
		xmlStr 					+= obj.name+"=\""+ obj.value +"\" " ;
		xmlStr 					+=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id=" + bean_id + "&bean_name="+ bean_name +"&order_category_yn="+order_category_yn+"&order_type_yn="+order_type_yn+"&order_category="+order_category+"&func_mode=TICK_SHEET_POPULATE&localeName="+localeName, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
} // End of populateTickSheetId

function setOrderType(form_name,pre_sel_order_type_yn) // Set the order type yn to check whether it has to be made mandatory or not
{
 	if(form_name=='addlSearchCriteriaForm')
		document.addlSearchCriteriaForm.order_type_yn.value = pre_sel_order_type_yn;
	else if(form_name=='imageSearchForm') // When called from the Image Screen
		document.imageSearchForm.order_type_yn.value 			= pre_sel_order_type_yn;
	else if(form_name=='careSetSearchForm') // When called from the Care Set Search Screen
		document.careSetSearchForm.order_type_yn.value 			= pre_sel_order_type_yn
	else
		document.tickSheetForm.order_type_yn.value 			= pre_sel_order_type_yn;
	if(pre_sel_order_type_yn=="Y")
		document.getElementById("order_type_mand").style.visibility = "visible";
	else
		document.getElementById("order_type_mand").style.visibility = "hidden";

} // End of setOrderType


// When priority is changed in the header all the values in the priority(Line Level) should be changed
function setAllPriorities(object)
{
	var selIndex 	= object.selectedIndex;
	changeLineLevelPriorites(selIndex);
} // End of setAllPriorities
// change all the line level priorities
function changeLineLevelPriorites(selIndex){
	var listArr	 		= parent.placeOrderDetailFrame.document.getElementsByTagName("select");
	var priority_name	= "";
	for (y=0;y<listArr.length;y++){
 		if (listArr[y].name.indexOf("priority") != -1){
			priority_name = listArr[y].name;
			var priority = eval("parent.placeOrderDetailFrame.document.placeOrderForm."+priority_name+".value");
 			listArr[y].selectedIndex = selIndex;
			if(listArr[y].selectedIndex==-1) { // then put the priority back 
				eval("parent.placeOrderDetailFrame.document.placeOrderForm."+priority_name+".value=priority");
			} 
		} // End of listArr[y]
	 } // End of y
	 skipAuthIndicator();//IN048467 
} // End of changeLineLevelPriorites

// When priority is changed, in the line level,and if all the priorities are same in the line, the header will also should remain the same
// For Order Priority to set
function setOrderPriority(key,catcode,id)
{
		var value=eval("document.placeOrderForm."+key+id).value;
	 	var totalCount		= parseInt(eval("document.placeOrderForm.total_rows.value;"))
		var function_name     = document.placeOrderForm.function_name.value;
		var totalCounting	= parseInt(eval("totalCount - 1;"));

		var flag 			= true;	var flag1 				= true;
		var count 			= 0;
		
		skipAuthIndicator();//IN048467 - HSA-CRF-0150
		while(count <= totalCounting){
			if(eval("document.placeOrderForm.priority"+count))
			{	
				var firstOrder = eval("document.placeOrderForm.priority"+count+".value;");
				
				//var lastOrder = eval("document.placeOrderForm.priority"+totalCounting+".value;");
				for(i=1;i<totalCount;i++)
				{
					
					if(eval("document.placeOrderForm.priority"+i) && firstOrder != (eval("document.placeOrderForm.priority"+i+".value;")))
					{
						flag = false;
						break;
					} // End of if
				} // End of For
				if(eval("document.placeOrderForm.priority"+totalCounting))
				{
					var lastOrder = eval("document.placeOrderForm.priority"+totalCounting+".value;");
					if(lastOrder != firstOrder)
					{
						flag1 = false;
					} // End of if
				} // End of If
			} // End of if
			count++;
			}
		if(flag)
		{
			if(flag1)
		    {
		     	(eval("parent.criteriaMainFrame.document.placeOrderHeaderForm.priority.value=firstOrder;"))
				if(parent.criteriaMainFrame.document.getElementById('priority_id')) //For Rapid Preview Purpose
					changePriority(parent.criteriaMainFrame.document.placeOrderHeaderForm.priority.value); // For Rapid Preview Purpose,To change the header
		    }
		}
		setValue(key+catcode,value);
} // End of setOrderPriority



 async function showHTMLCalendar(id, date_format, time_format,isModal) {
      
	// Take the element object of the date field
    //var el = document.getElementById(id);
	var el= id;
    var args     = new Array(el, date_format, time_format)
	//if(isModal)
	//{
			await showInModal1(args)
			//return false
	//}
 }
 async function showInModal1(args,timeSet,difference)
	{
			var  enableFlag=false;
			var dialogHeight= "47vh" ;
			var dialogWidth	= "21vw" ;
			var status = "no";
			//var arguments = "";
			var features	=  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:no; status:" + status;
			var  dateValue=await window.showModalDialog('../../eCommon/jsp/CommonStaticCalenderGlad.jsp?timeSet='+timeSet+'&difference='+difference+"&locn=eOR",args, features);
			
		/*	var serverTime="";
			if( (timeSet=="dd/mm/yyyy") || (timeSet=="dd/mm/y") || (timeSet=="mm/y") )
			{
					serverTime=""
			}
			else 
			{
				Dt = new Date();
				serverTime=Dt.getHours()+':'+Dt.getMinutes();
			}
			
			var formatedDate=null;*/
			var formatedDate = dateValue;


	/*		if(serverTime.length==0)
				formatedDate= dateValue;
			else
				formatedDate= dateValue+" "+serverTime;
			//var formatedDate= dateValue+" "+serverTime*/


			if(formatedDate==undefined)
			{
					 args.value= "";
			}
			else
			{
					args.value =formatedDate;
			}

			parent.criteriaMainFrame.document.placeOrderHeaderForm.order_date_time_calendar.value=args.value;
			//args.focus();
			enableFlag=false;
    }
async function changeAllStartDateTime(){ 
	display_id = parent.criteriaMainFrame.document.getElementById('order_date_time_calendar');
	await showHTMLCalendar(display_id ,null,'hh:mm',true);// call the Calendar Interface, to display the Calendar, and it will set the date to the hidden field
	// from the hidden field take the existing date, since order_date_time will not change
	var order_date_time = parent.criteriaMainFrame.document.getElementById('order_date_time_calendar').value;
	//showCommonCalendar(parent.criteriaMainFrame.document.placeOrderHeaderForm.all.order_date_time_id); // id of the text box,where it has to put the date back

	changeDateTime(parent.criteriaMainFrame.document.getElementById('order_date_time_calendar'),"")
	//if(changeDateTime(parent.criteriaMainFrame.document.placeOrderHeaderForm.order_date_time_calendar,"")==false)
	//	document.placeOrderHeaderForm.order_date_time_calendar.value = order_date_time_calendar;
}

// Function to check for the Date and time in the Place order header
// And if the entered date and time is valid change it for all in the line
function changeDateTime(obj,order_category)
{
	var CDate=getCurrentDate("DMYHM",parent.criteriaMainFrame.document.getElementById('localeName').value);
	var start_date_time = "";
	if(parent.criteriaMainFrame.document.getElementById('order_date_time_calendar'))
	{
		start_date_time = parent.criteriaMainFrame.document.getElementById('order_date_time_calendar').value;
	}
	else 
	{
		start_date_time = parent.criteriaMainFrame.document.getElementById('order_date_time').value;
	}
   var Currentdatefloor=CDate.substring(0,10);
	var Startdatefloor=start_date_time.substring(0,10);
	if(start_date_time.length==16)
	{
		if(!(isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			start_date_time=start_date_time.substring(0,11)+"00:00";
		}
		else
		{	
			start_date_time=start_date_time.substring(0,11)+CDate.substring(11);
		}
	}
			
	//var start_date_time = parent.criteriaMainFrame.document.placeOrderHeaderForm.order_date_time_calendar.value
	if(validateDateWithTime(obj)==true)
	{
		//Addded by Uma on 3/24/2010 for IN019999
		if(parent.placeOrderDetailFrame.document.placeOrderForm)
		{
			var total_rows			= parseInt(parent.placeOrderDetailFrame.document.getElementById('total_rows').value);

			// Change all the lines
			for(i=0;i<total_rows;i++)
			{
				if(parent.placeOrderDetailFrame.document.getElementById('start_date_time'+i))
				{
					// If it is an Order Set, then add the time frame included before and then display
					if(order_category=="CS")
					{
						start_time = parent.placeOrderDetailFrame.document.getElementById('start_time'+i).value;

						var date 		= start_date_time.split(" ");
						datearray 		= date[0].split("/");
						minarray 		= date[1].split(":");
						dt 				= new Date(datearray[2],datearray[1]-1,datearray[0],minarray[0],minarray[1])

						var hrs 	 	= dt.getHours();
						hrs 		 	= parseInt(hrs) + parseInt(start_time);
						date 		 	= dt.setHours(hrs);
						date		 	= new Date(date);
						dtString	 	= buildDate(date,i); // i is the row
						start_date_time = dtString;
					}
					// For Rapid Preview -- Start
					if(parent.placeOrderDetailFrame.document.getElementById('start_date_time_href_id'+i)) {
						eval("parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time_href_id"+i+".innerHTML=\"&nbsp;<font size='1'><a class='gridLink' href=javascript:changeLineLevelDateTime('start_date_time_id"+i+"','"+i+"') title='OrderDateTime'>"+start_date_time+"</font>\" ");
					}
					// For Rapid Preview  --End 
						 parent.placeOrderDetailFrame.document.getElementById('start_date_time'+i).value=start_date_time;
						var catcode 		= parent.placeOrderDetailFrame.document.getElementById('catalog_code'+i).value;
						var appt_reqd_yn 		= parent.placeOrderDetailFrame.document.getElementById('appt_reqd_yn'+i).value;
						var localename 		= parent.placeOrderDetailFrame.document.getElementById('localeName').value;
						var sysdate		= parent.placeOrderDetailFrame.document.getElementById('sys_date').value;

						
						var obj=parent.placeOrderDetailFrame.document.getElementById('start_date_time'+i);	
						
						checkWithCurrentDate(obj,i,sysdate,localename,catcode,"schedule",appt_reqd_yn);
						setValue1("start_date_time"+catcode,start_date_time);
						var duration_code 		= parent.placeOrderDetailFrame.document.getElementById('duration_code'+i).value;
						var duration_value 		=parent.placeOrderDetailFrame.document.getElementById('duration_value'+i).value;
						var start_date_time 	= parent.placeOrderDetailFrame.document.getElementById('start_date_time'+i).value;
						if(duration_code!='' && duration_value!='')
							parent.parent.calculateEndDateTime(start_date_time,duration_code,duration_value,i,"apply");
				} // end of if
			} // End of i (for)
			// For Amend Orders
			var amend_total_rows	= parseInt(parent.placeOrderDetailFrame.document.getElementById('amend_total_rows').value);
			// Change all the lines
			for(i=0;i<amend_total_rows;i++)
			{
				if(parent.placeOrderDetailFrame.document.getElementById('amend_start_date_time'+i) )
				{
					if(parent.placeOrderDetailFrame.document.getElementById('amend_start_date_time'+i).readOnly && parent.placeOrderDetailFrame.document.getElementById('amend_order_category'+i).value=="RD"){
						continue;
					}
					var sysdate		= parent.placeOrderDetailFrame.document.placeOrderForm.sys_date.value;
					var amend_appt_reqd_yn = parent.placeOrderDetailFrame.document.getElementById('amend_appt_reqd_yn'+i).value;	parent.placeOrderDetailFrame.document.getElementById('amend_start_date_time'+i).value=start_date_time;
						checkWithCurrentDate(obj,i,sysdate,localename,catcode,"schedule",amend_appt_reqd_yn);
						var amd_catcode 		= parent.placeOrderDetailFrame.document.getElementById('amend_catalog_code'+i).value;
						setValue1("amend_start_date_time"+amd_catcode,start_date_time);
						
						var duration_code 		= parent.placeOrderDetailFrame.document.getElementById('amend_duration_code'+i).value;
						var duration_value 		= parent.placeOrderDetailFrame.document.getElementById('amend_duration_value'+i).value;
						
						var start_date_time 	= parent.placeOrderDetailFrame.document.getElementById('amend_start_date_time'+i).value;
						
						if(duration_code!='' && duration_value!='')
							parent.parent.calculateEndDateTime(start_date_time,duration_code,duration_value,i,"applyAMEND");
						
				}
					
			}
		
			return true;
		}
		else
		{
			return false;
		}
	} // End of validateDateWithTime(obj)==true
	else
	{
	return false;
	}
} // End of changeDateTime

function setValue1(key,value)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var bean_id=parent.placeOrderDetailFrame.document.placeOrderForm.bean_id.value;
	var bean_name=parent.placeOrderDetailFrame.document.placeOrderForm.bean_name.value;
	var func_mode="Tempvalues";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " key=\""+ key +"\" " ;
	xmlStr += " value=\""+ value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

// Function to Validate the Date and Time in the Place order screen and to change the end date time if the duration is not null
function checkStartDateTime(obj,i,CDate,localeName,str,catcode)
{
	eval("document.placeOrderForm.schedule_mandatorily_yn"+i+".value='N'");
	var currentdate=getCurrentDate("DMYHM",localeName);
	var Currentdatefloor=currentdate.substring(0,10);
	var Startdatefloor=obj.value.substring(0,10);
	/*if(obj.value.length==16)
	{
		if(!(isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			obj.value=obj.value.substring(0,11)+"00:00";
		}
		else
		{	
			obj.value=obj.value.substring(0,11)+currentdate.substring(11);
		}
	}*/
	eval("document.placeOrderForm.end_date_time"+i+".value=''");
	if(validateDateWithTime(obj)==true)
	{  // if duration is not null, then change the date in the end_date_time
		var appt_reqd_yn 		= eval("document.placeOrderForm.appt_reqd_yn"+i+".value");
		checkWithCurrent(obj,i,CDate,localeName,catcode,appt_reqd_yn);
		var duration_code 		= eval("document.placeOrderForm.duration_code"+i+".value");
		var duration_value 		= eval("document.placeOrderForm.duration_value"+i+".value");
		var catalog_code 		= eval("document.placeOrderForm.catalog_code"+i+".value");
		if(duration_value!='' && duration_code!='')
			calculateEndDateTime(obj.value,duration_code,duration_value,i,'');

		removeSchedule(i, catalog_code ); // To remove the Schedule Frequency
		setValue(str,obj.value);

	}
}
// Function to Validate the Date and Time in the Place order screen and to change the end date time if the duration is not null
function checkStartDateTimes(obj,i,CDate,localeName,str,catcode)
{
	eval("document.placeOrderForm.schedule_mandatorily_yn"+i+".value='N'");
	var currentdate=getCurrentDate("DMYHM",localeName);
	var Currentdatefloor=currentdate.substring(0,10);
	var Startdatefloor=obj.value.substring(0,10);
	if(obj.value.length==16)
	{
		if((isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			if(obj.value.substring(11)=="00:00")
				obj.value=obj.value.substring(0,11)+currentdate.substring(11);
		}
	}
}

function checkStartDateTim(obj,i,CDate,localeName,str,catcode)
{
	eval("document.placeOrderForm.end_date_time"+i+".value=''");	
	if(validateDateWithTime(obj)==true)
	{  // if duration is not null, then change the date in the end_date_time
		var appt_reqd_yn 		= eval("document.placeOrderForm.appt_reqd_yn"+i+".value");
		checkWithCurrent(obj,i,CDate,localeName,catcode,appt_reqd_yn);
		var duration_code 		= eval("document.placeOrderForm.duration_code"+i+".value");
		var duration_value 		= eval("document.placeOrderForm.duration_value"+i+".value");
		var catalog_code 		= eval("document.placeOrderForm.catalog_code"+i+".value");
		if(duration_value!='' && duration_code!='')
			calculateEndDateTime(obj.value,duration_code,duration_value,i,'');

		removeSchedule(i, catalog_code ); // To remove the Schedule Frequency
		setValue(str,obj.value);

	}
}

function showCalendarValidate(id,a,b,str,catcode)
{
	var flg = showCalendar(id,a,b);
	parent.placeOrderDetailFrame.document.placeOrderForm.start_date_time
	setValue(str+catcode,document.getElementById(id).value);
	var start_date_time=parent.placeOrderDetailFrame.document.getElementById(id).value;
	var currentdate=getCurrentDate("DMYHM",localeName);
	var Currentdatefloor=currentdate.substring(0,10);
	var Startdatefloor=start_date_time.substring(0,10);
	if(start_date_time.length==16)
	{
		if(!(isAfter(Currentdatefloor,Startdatefloor,"DMY",localeName)))
		{
			start_date_time=start_date_time.substring(0,11)+"00:00";
		}
		else
		{	
			start_date_time=start_date_time.substring(0,11)+currentdate.substring(11);
		}
		eval("parent.placeOrderDetailFrame.document.placeOrderForm."+id).value=start_date_time;
	}
	
	return flg;
}

// Function to Validate the Date and Time in the Place Order Header and Result Screen
function validateDateWithTime(obj)
 {

  	if(obj.value.length > 0)
  	{
		//var sysdate    = parent.placeOrderDetailFrame.document.placeOrderForm.sys_date.value;
		var future_order_date    = parent.criteriaMainFrame.document.placeOrderHeaderForm.future_order_date.value;
		//future_order_date="10/06/2008 00:21";
		var past_order_date   	 = parent.criteriaMainFrame.document.placeOrderHeaderForm.past_order_date.value;
		var visit_adm_date   	 = parent.criteriaMainFrame.document.placeOrderHeaderForm.visit_adm_date.value;
		var order_date		   	 = parent.criteriaMainFrame.document.placeOrderHeaderForm.order_date_time.value;
		var start_date 			 = obj.value;
		var localeName           = parent.criteriaMainFrame.document.placeOrderHeaderForm.localeName.value;

		
		
		// Entered date should not be less than visit_adm_date
		//if(!validDateObj(obj,"DMYHM",localeName))
   		//if(!doDateTimeChk(obj))
		var temp=validDateObj(obj,"DMYHM",localeName);		
		if(temp!=false && temp!=undefined)
		{   			
			if(doDatetimeCheckAlert(visit_adm_date,start_date)	)			
			//if(!isAfter(visit_adm_date,start_date,'DMYHM',localeName))
			{   

				alert(getMessage("ADMDATE_LESS_DATE","OR"));
				if(obj.type != "hidden"){
					obj.focus();
					obj.select();
				}
				return false;
   			}
			else
			{	// Entered Date should not be less than Ordered Date/Time
				/*if(doDatetimeCheckAlert(order_date,start_date)	)
				{
					alert(getOrMessage("START_ORDER_DATE_TIME"));
					if(obj.type != "hidden"){
						obj.focus();
						obj.select();
					}
					return false;
   				} // Entered Date should not be greater than future Ordered Date
				*/
 				if(doDatetimeCheckAlert(past_order_date,start_date)	)
   				
				//if(!isAfter(past_order_date,start_date,'DMYHM',localeName))
				{
   					alert(getMessage("BACK_DATE_TIME","OR"));
					if(obj.type != "hidden"){
	   					obj.focus();
   		    			obj.select();
					}
   					return false;
   				} // Entered Date should not be greater than future Ordered Date
   				else if(doDatetimeCheckAlert(start_date,future_order_date)	)
				
				//else if(!isAfter(start_date,future_order_date,'DMYHM',localeName))
				{
					alert(getMessage("FUTURE_DATE_TIME","OR"));
					if(obj.type != "hidden"){
						obj.focus();
					  	obj.select();
					}
					return false;
   				}
   				else return true;
       		}
       } // End of else
   }
   else
   {
	/*	if(obj.name.indexOf("order_date_time")!=-1)
			column_mess = "Order Date and Time";
		else
		 	column_mess = "Start Date and Time";
  		var mess = getOrMessage("CANNOT_BE_BLANK");
  		mess = mess.replace("@",column_mess);
  		alert(mess);
		if(obj.type != "hidden"){
	  		obj.focus();
  			obj.select();
		}
		return false;
	*/
  }
} // End of validateDateWithTime

function doDatetimeCheckAlert(from,to)
 {
	var fromarray;
	var toarray;
	var fromDt;
	var fromdate = from;
	var todate = to;
	if(fromdate.length > 0 && todate.length > 0 )
	{
	  	fromDt = fromdate.split(" ");
	  	fromarray = fromDt[0].split("/");

	  	toDt = todate.split(" ");
	  	toarray = toDt[0].split("/");

		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if(Date.parse(todt) == Date.parse(fromdt))
		{
			fromTime = fromDt[1];
			toTime   = toDt[1];

			if(toTime < fromTime)
			{
				return true;
			}
		}

		if(Date.parse(todt) < Date.parse(fromdt))
		{
			return true;
		}
		else
		{
			if(Date.parse(todt) >= Date.parse(fromdt))
			return false;
		}

	}
} // End of doDatetimeCheckAlert

// Cosign Required or not (Access , click of the hyperlink)
// When the Cosign is required, User has to confirm
function CheckCosign(cosign_reqd)
{
	if (cosign_reqd){
		var yes = window.confirm(getMessage("COSIGN_REQD_CONFIRM","OR"));
		if (yes){
			HideCosignLink();   // change the html text
			var imgArr = "";
			if(parent.criteriaMainFrame)
				imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
			for(var p=0;p<imgArr.length;p++){
				if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Authorization")==-1 && imgArr[p].src.indexOf("Authorized")==-1 && imgArr[p].src.indexOf("SpecialApproval")==-1  && imgArr[p].src.indexOf("SpecialApproval_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
					imgArr[p].src = "../../eOR/images/Cosign.gif";
			}
			document.getElementById("cosigned").value = "true";
		}
	}else{

		document.getElementById("cosigned").value = "false";
		//ShowLink();
	}
} // End of CheckCosign
function HideCosignLink()
{
	document.getElementById("cosignId").innerHTML="<b>"+getLabel("Common.Cosigned.label","COMMON")+"</b>"
	if(document.getElementById("textcosignimg")) 
		document.getElementById("textcosignimg").src="../../eOR/images/Cosign.gif"
} // End of HideCosignLink
function hideCosign()
{
	if(parent.criteriaMainFrame.document.getElementById("hdg"))
		parent.criteriaMainFrame.document.getElementById("hdg").innerHTML				= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("cosignId"))
		parent.criteriaMainFrame.document.getElementById("cosignId").innerHTML 		= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("imageCosignId"))
		parent.criteriaMainFrame.document.getElementById("imageCosignId").innerHTML	= "&nbsp";
} // End of hideCosign

// Special Approval Required or not (Access , click of the hyperlink)
// When the Authorization for Special Approval is required, User has to confirm
function CheckSpecialApproval(special_approval_reqd)
{
	if (special_approval_reqd){
		var yes = window.confirm(getMessage("SPECIAL_APPROVAL_REQD_CONFIRM","OR"));
		if (yes){
			HideSpecialApprovalLink();   // change the html text
			var imgArr = "";
			if(parent.criteriaMainFrame)
				imgArr = parent.placeOrderDetailFrame.document.getElementsByTagName("img");
			for(var p=0;p<imgArr.length;p++){
				if(imgArr[p].src.indexOf("mandatory")==-1 && imgArr[p].src.indexOf("Flex_blue")==-1 && imgArr[p].src.indexOf("Flex_red")==-1  && imgArr[p].src.indexOf("Authorization")==-1 && imgArr[p].src.indexOf("Authorized")==-1  && imgArr[p].src.indexOf("Cosign")==-1 && imgArr[p].src.indexOf("Cosign_click")==-1 && imgArr[p].src.indexOf("SecondaryOrder")==-1 && imgArr[p].src.indexOf("CommonCalendar")==-1)
					imgArr[p].src = "../../eOR/images/SpecialApproval_click.gif";
			}
			document.getElementById("special_approved").value = "true";
		}
	}else{

		document.getElementById("special_approved").value = "false";
		//ShowLink();
	}
}
function HideSpecialApprovalLink()
{
	document.getElementById("specialId").innerHTML="<b>"+getLabel("Common.Approved.label","COMMON")+"</b>"
	if(document.getElementById("textspecialimg"))
		document.getElementById("textspecialimg").src="../../eOR/images/SpecialApproval_click.gif"

} // End of HideSpecialApprovalLink
function hideSpecialApproval()
{
	if(parent.criteriaMainFrame.document.getElementById("hdg"))
		parent.criteriaMainFrame.document.getElementById("hdg").innerHTML				= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("specialId"))
		parent.criteriaMainFrame.document.getElementById("specialId").innerHTML 		= "&nbsp";
	if(parent.criteriaMainFrame.document.getElementById("imageSpecialId"))
		parent.criteriaMainFrame.document.getElementById("imageSpecialId").innerHTML	= "&nbsp";
} // End of hideSpecialApproval

function setCatalogCode(obj,frame_name,module_id) // Method called to keep track of the checkbox (catalog_code)
{
	var count=0;
 	if(frame_name!=null){
		check_box_length 	= frame_name.check_box_val.length;//Global Variable in(OrderEntryGlobal.js) --> this js file is included in OrderEntryTab.jsp 
		if(obj.checked==true)
		{
			if(check_box_length>0)
			{
				for(i=0;i<check_box_length;i++)
				{			
					if(frame_name.check_box_val[i]==obj.name){
						count++;						
					}
				}
			}
			if(count>0){}
			else{			
			frame_name.check_box_val[check_box_length] = obj.name;
			}			
		}
		else if(obj.checked==false)   //If it is unchecked
		{
			for(i=0;i<check_box_length;i++)
			{
				if(frame_name.check_box_val[i]==obj.name)
				//frame_name.check_box_val[i] = "@@";
				delete(frame_name.check_box_val[i]); // Remove the value from the Array
			}
		}
		if(module_id=="PH") // When called from Pharmacy to Update the global variable with the catalog code
		{
			frame_name.check_box_val[check_box_length] = obj; //Passing the Durg code into the Array
		}
	} // End of if frame_name
} // End of setCatalogCode
// Method called by PH Module to delete the consolidated catalog code , when they cancel the drug
function deleteCatalogCode(catalog_code,frame_name,module_id)
{
	check_box_length 	= frame_name.check_box_val.length;//Global Variable in OrderEntryTab.jsp
	if(module_id == "PH")
	{
		for(i=0;i<check_box_length;i++)
		{
			if(frame_name.check_box_val[i]==catalog_code)
				delete(frame_name.check_box_val[i]); // Remove the value from the Array
		}
	}
} // End of deleteCatalogCode

function setCopyCatalogCode(catalog_code){
	var frame_name		= parent.tabFrame;
	catalog_code		= catalog_code.split(",");
	if(frame_name)
	{
		for(i=0;i<catalog_code.length;i++)
		{
			frame_name.check_box_val[frame_name.check_box_val.length] = catalog_code[i];
		}
	} // End of if frame_name
} // End of setCopyCatalogCode

async function AmendDisplaySchedule(code,row_value,facility_id)
{
	
	// Since it is for Amend function, it is just for viewing, pass the mode=2
	bean_id 		= document.placeOrderForm.bean_id.value;
 	bean_name 		= document.placeOrderForm.bean_name.value;	
	var visit_adm_date="";
	var future_order_date="";
	var past_order_date="";
	var called_from="";
 	var freq_code		= eval("document.placeOrderForm.amend_frequency_code"+row_value);
 	start_date_time	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_start_date_time"+row_value+".value");
	
	duration	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_value"+row_value+".value");
	pr_duration_type	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_duration_code"+row_value+".value");	
	quantity	    = eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_quantity"+row_value+".value");	
	if(freq_code.value.indexOf("~")!=-1){
	var freq_code1=freq_code.value.split("~~");
	freq_code=freq_code1[0];}
 	

	var retVal;
 	var dialogTop   = "260";
 	//var dialogHeight= "35" ;
 	//var dialogWidth = "50" ;
	var dialogHeight	= "24" ;
	var dialogWidth		= "50" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";
	
 	retVal 			= await window.showModalDialog("../../eOR/jsp/ScheduleFrequency.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&code="+code+"&row_value="+row_value+"&facility_id="+facility_id+"&freq_code="+freq_code+	"&start_time_day_param="+start_date_time+"&visit_adm_date="+visit_adm_date+"&future_order_date="+future_order_date+"&past_order_date="+past_order_date+"&called_from="+called_from+"&module_id=OR&mode=2&pr_duration="+duration+"&pr_duration_type="+pr_duration_type+"&split_qty="+quantity,arguments,features);

	
 } // End of AmendDisplaySchedule

// Call the Revise Billing Related Informations . if present
async function callReviseBilling(row_value,called_from,patient_id,encounter_id,service_panel_ind,service_panel_code,episode_type,episode_id,visit_id,order_id,order_line_no)
{
	var formObj		= document.placeOrderForm;
	//var localeName			= document.placeOrderForm.localeName.value;
	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value;
	locale=formObj.localeName.value;
	var practitioner_id	= document.placeOrderForm.ordering_practitioner.value;
	var key_ref		= "";
	var key_line_no	= "";
	
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		if(locale!="en")
		{
			start_date_time	= convertDate(eval("document.placeOrderForm.start_date_time"+row_value+".value"),'DMYHM',locale,"en");
		}
		else
		{
			start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		}
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
		key_ref			= patient_id+encounter_id+catalog_code;
		key_line_no		= "";
		//start_date_time = start_date_time.substr(0, (start_date_time.indexOf(" ") ) );
	}
	//Added For Order Set Billing Changes  by Uma 2/6/2009
	else if(called_from=="ORDER_SET") 
	{
		start_date_time	= document.placeOrderForm.sys_date.value;
		catalog_code	    = document.placeOrderForm.care_set_catalog_code.value;
		quantity				= "1";
		key_ref			= patient_id+encounter_id+catalog_code;
		key_line_no		= "";
	}
	else if(called_from=="ORDER_SET_AMEND") 
	{
		start_date_time	= document.placeOrderForm.bill_dateString.value;
		catalog_code	    = document.placeOrderForm.order_set_catalog_code.value;
		quantity	    = document.placeOrderForm.order_qty.value;
		key_ref			= order_id;
		key_line_no		=order_line_no;
	}
	else // For New Orders or orderset Ends 
	{
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		if(locale!="en")
		{
			start_date_time	= convertDate(eval("document.placeOrderForm.amend_start_date_time"+row_value+".value"),'DMYHM',locale,"en");
		}
		else
		{
			start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		}
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
		key_ref			= order_id;
		key_line_no		= order_line_no;
	}
	
	var query_string = "title="+encodeURIComponent(getLabel("eBL.EDIT_ENTER_CHARGE_DETAILS.label","BL"))+"&bean_id="+bean_id+"&module_id=OR&patient_id="+patient_id+"&encounter_id="+encounter_id+"&key="+key_ref+"&order_catalog_code="+catalog_code+"&service_panel_code="+service_panel_code+"&service_panel_ind="+service_panel_ind+"&service_date="+start_date_time+"&episode_type="+episode_type+"&visit_id="+visit_id+"&episode_id="+episode_id+"&pract_staff_ind=P&pract_staff_id="+practitioner_id+"&key_line_no="+key_line_no+"&order_id="+order_id+"&order_line_no="+order_line_no;

	var retVal ;
	var dialogTop		= "100";
	var dialogHeight	= "88vh" ;
	var dialogWidth		= "76vw" ;
	var features		= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
	var arguments		= "";
	retVal	 			= await top.window.showModalDialog("../../eBL/jsp/BLEnterEditChargeDtlMain.jsp?"+query_string,arguments,features);
	
	
	if(retVal!=null && retVal != undefined)
	{
		

		if(retVal[0]=="Y")
		{
		/*	etArray[0]="Y";
			retArray[1]=total_payable;
			retArray[2]=patient_payable;
			retArray[3]=patient_paid;
			retArray[4]=quantity;
			retArray[5]=rate;
			retArray[6]=incl_excl_action;*/

			loadRevisedBillDtls(row_value,called_from,retVal[1],retVal[2],retVal[3],retVal[8],catalog_code);
			
		}
				
	}
	
		
	
} // End of callBilling

function reviseBillingchrgs(row_value,called_from) //Called when qty is changed in the "Place order screen"
{
	var formObj		= document.placeOrderForm;		
	var order_id	= "";
	var order_line_no= "";
	var fpp_yn ="";//IN068314
	var fpp_category ="";//IN068314
	var localeName	= formObj.localeName.value;
	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value; 	

	if(called_from=="NEW_ORDER")
	{
		if(eval("document.placeOrderForm.billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.billing_call_yn"+row_value).value == '')
			return false;
		
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");	
		if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value))//IN068314//IN072721
			fpp_yn		= eval("document.placeOrderForm.fpp_yn"+row_value+".value");	//IN068314
		if(null!=eval("document.placeOrderForm.fpp_category"+row_value) && undefined!=eval("document.placeOrderForm.fpp_category"+row_value))//IN068314//IN072721
			fpp_category		= eval("document.placeOrderForm.fpp_category"+row_value+".value");//IN068314	
	}
	else if(called_from == "OP_NEW_ORDER")	  //IN28273
	{
		if(eval("document.placeOrderForm.billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.billing_call_yn"+row_value).value == '')
			return false;
		
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
		if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value))//IN068314//IN072721
			fpp_yn		= eval("document.placeOrderForm.fpp_yn"+row_value+".value");	//IN068314
		if(null!=eval("document.placeOrderForm.fpp_category"+row_value) && undefined!=eval("document.placeOrderForm.fpp_category"+row_value))//IN068314//IN072721
			fpp_category		= eval("document.placeOrderForm.fpp_category"+row_value+".value");//IN068314	
	}
	else if( called_from=="ORDER_SET")//IN072524 Starts
	{
		if(eval("document.placeOrderForm.billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.billing_call_yn"+row_value).value == ''){
			if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value) && !"Y"==eval("document.placeOrderForm.fpp_yn"+row_value+".value"))//IN068314//IN072721
			return false;
		}
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.hdr_order_catalog_code"+row_value+".value"); 
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");	
		if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value))//IN068314//IN072721
			fpp_yn		= eval("document.placeOrderForm.fpp_yn"+row_value+".value");	//IN068314
		if(null!=eval("document.placeOrderForm.fpp_category"+row_value) && undefined!=eval("document.placeOrderForm.fpp_category"+row_value))//IN068314//IN072721
			fpp_category		= eval("document.placeOrderForm.fpp_category"+row_value+".value");//IN068314	
		
	}//IN072524 Ends
	else if( called_from=="ORDER_SET_AMEND" )////10503 Starts
	{
		quantity		= eval("document.placeOrderForm.order_qty.value");
		start_date_time	= eval("document.placeOrderForm.bill_dateString.value");
		catalog_code	= eval("document.placeOrderForm.care_set_catalog_code.value"); 
		cat_desc		= eval("document.placeOrderForm.care_set_catalog_desc.value");	
		order_id		= eval("document.placeOrderForm.order_set_orderid.value");
		order_line_no	= eval("document.placeOrderForm.order_set_orderlineno.value");
		if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value))//IN068314//IN072721
			fpp_yn		= eval("document.placeOrderForm.fpp_yn"+row_value+".value");	//IN068314
		if(null!=eval("document.placeOrderForm.fpp_category"+row_value) && undefined!=eval("document.placeOrderForm.fpp_category"+row_value))//IN068314//IN072721
			fpp_category		= eval("document.placeOrderForm.fpp_category"+row_value+".value");//IN068314	
		
	}//10503 Ends
	else // For New Orders or orderset
	{
	
		if(eval("document.placeOrderForm.amend_billing_call_yn"+row_value).value == 'N' || eval("document.placeOrderForm.amend_billing_call_yn"+row_value).value == ''){
			if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value) && !"Y"==eval("document.placeOrderForm.fpp_yn"+row_value+".value"))//IN068314//IN072721
				return false;
		}
		
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
		order_id		= eval("document.placeOrderForm.amend_order_id"+row_value+".value");
		order_line_no	= eval("document.placeOrderForm.amend_order_line_num"+row_value+".value");
		if(null!=eval("document.placeOrderForm.fpp_yn"+row_value) && undefined!=eval("document.placeOrderForm.fpp_yn"+row_value) )//IN068314//IN072721
			fpp_yn		= eval("document.placeOrderForm.fpp_yn"+row_value+".value");	//IN068314
		if(null!=eval("document.placeOrderForm.fpp_category"+row_value) && undefined!=eval("document.placeOrderForm.fpp_category"+row_value) )//IN068314//IN072721
			fpp_category		= eval("document.placeOrderForm.fpp_category"+row_value+".value");//IN068314	
	}	
	if(start_date_time!="" && quantity!="" && catalog_code!="")
	{
		//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlHttp = new XMLHttpRequest();
		//IN045080 - Start
		var func_mode="GETREVISEDBILLINGDETAILS";
		xmlStr ="<root><SEARCH " ;
		xmlStr += " quantity=\""+ quantity +"\" " ;
		xmlStr += " catalog_code=\""+ escape(catalog_code) +"\" " ;
		xmlStr += " start_date_time=\""+ start_date_time +"\" " ;
		xmlStr += " cat_desc=\""+ escape(cat_desc) +"\" " ;
		xmlStr += " order_id=\""+ order_id +"\" " ;
		xmlStr += " order_line_no=\""+ order_line_no +"\" " ;
		xmlStr += " row_value=\""+ row_value +"\" " ;
		xmlStr += " localeName=\""+ localeName +"\" " ;
		xmlStr += " called_from=\""+ called_from +"\" " ;
		xmlStr += " fpp_yn=\""+ fpp_yn +"\" " ;//IN068314
		xmlStr += " fpp_category=\""+ fpp_category +"\" " ;//IN068314
		xmlStr += " function_name=\""+ eval("document.placeOrderForm.function_name.value") +"\" " ;//IN073309
		xmlStr +=" /></root>" ;
		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		//IN045080 - End
		//Commentted IN045080
	/*	xmlHttp.open("POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&start_date_time="+start_date_time+"&cat_desc="+escape(cat_desc)+"&order_id="+order_id+"&order_line_no="+order_line_no+"&row_value="+row_value+"&called_from="+called_from+"&localeName="+localeName+"&func_mode="+func_mode, false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);*/
	} 
}
//function loadRevisedBillDtls(row_value,called_from,actual_amt,pat_payable_amt,pat_paid_amt,inc_excl_actn,catcode){//IN068314
function loadRevisedBillDtls(row_value,called_from,actual_amt,pat_payable_amt,pat_paid_amt,inc_excl_actn,catcode,err_text){//IN068314

	if(called_from=="NEW_ORDER")
	{
		setValue("actual_"+catcode,actual_amt);
		setValue("payable_"+catcode,pat_payable_amt);
		setValue("included_"+catcode,(inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":""));
		document.getElementById('actual_'+row_value).innerText	= actual_amt;
		document.getElementById('payable_'+row_value).innerText	= pat_payable_amt;
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(document.getElementById('included_'+row_value))
		{
			document.getElementById('included_'+row_value).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
		
	}
	else if(called_from == "OP_NEW_ORDER")	//IN28273
	{
		setValue("actual_"+catcode,actual_amt);
		setValue("payable_"+catcode,pat_payable_amt);
		setValue("included_"+catcode,(inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":""));
		document.getElementById('actual_'+row_value).innerText	= actual_amt;
		document.getElementById('payable_'+row_value).innerText	= pat_payable_amt;
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(document.getElementById('included_'+row_value))
		{
			document.getElementById('included_'+row_value).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
	}
	//Added For Order Set Billing Changes by Uma 2/6/2009
	else if((called_from=="ORDER_SET")||(called_from=="ORDER_SET_AMEND"))
	{
		setValue("actual_"+catcode,actual_amt);
		setValue("payable_"+catcode,pat_payable_amt);
		setValue("included_"+catcode,(inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":""));
		document.getElementById('actual_'+catcode).innerText		= actual_amt;
		document.getElementById('payable_'+catcode).innerText		= pat_payable_amt;
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(document.getElementById('included_'+catcode))
		{
			document.getElementById('included_'+catcode).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
	}
	/*else if(called_from=="ORDER_SET_LEVEL")//IN072524 Starts	//IN073712 Starts
	{
		setValue("actual_"+catcode,actual_amt);
		setValue("payable_"+catcode,pat_payable_amt);
		setValue("included_"+catcode,(inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":""));
		eval("document.getElementById("actual_")"+catcode).innerText		= actual_amt;
		eval("document.getElementById("payable_")"+catcode).innerText		= pat_payable_amt;
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(eval("document.getElementById("included_")"+catcode))
		{
			eval("document.getElementById("included_")"+catcode).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
	}*///IN072524 Ends	//IN073712 Ends
	else
	{
		setValue("amend_actual_"+catcode,actual_amt);
		setValue("amend_payable_"+catcode,pat_payable_amt);
		setValue("amend_included_"+catcode,(inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":""));
		document.getElementById('amend_actual_'+row_value).innerText		= actual_amt;
		document.getElementById('amend_payable_'+row_value).innerText		= pat_payable_amt;
		//eval("document.getElementById("paid_")"+row_value).innerText	= pat_paid_amt;
		if(document.getElementById('amend_included_'+row_value))
		{
			document.getElementById('amend_included_'+row_value).innerText	= (inc_excl_actn == "I")?"Yes":(inc_excl_actn == "E"?"No":"");
		}
	document.getElementById('amend_actual_value'+row_value).value=actual_amt;
	
	}
	showBillingTable();
	//IN072524 Starts
	if(called_from=="ORDER_SET" || called_from=="ORDER_SET_AMEND")	//IN073712//11244 Starts//10503
	{
		if(!err_text==""){
			alert(err_text);
			parent.criteriaDetailFrame.document.getElementById("recordApply").disabled=true;
		}
		else{
			parent.criteriaDetailFrame.document.getElementById("recordApply").disabled=false;
		}
	}
	else{//IN072524 Ends
	//IN068314 Starts
	if(!err_text==""){
		alert(err_text);
		billchecking(catcode);
		displaycolor(row_value);
		if(null!=document.getElementById("FinBill"+row_value) && undefined!=document.getElementById("FinBill"+row_value))//IN068314//IN072721
			document.getElementById("FinBill"+row_value).value = "Billing";//IN072558
	}else{
		billcheckingfpp(catcode);
		displaycolorfpp(row_value);
		if(null!=document.getElementById("FinBill"+row_value) && undefined!=document.getElementById("FinBill"+row_value))//IN068314//IN072721
			document.getElementById("FinBill"+row_value).value = "";//IN072558
	}
	//IN068314 Ends
	}//IN072524
	
	
	

}
//IN068314 Starts
function dispvieweditbilldtls(index,patientid,encounter_id,ser_panel_ind,ser_panel_code,episode_type,episode_id,visit_id,function_name,called_from,order_id,order_line_no){//IN073309// Added called_from for IN073712//11244//10503
	
//	var order_id ="";//10503
//	var order_line_no ="";//10503
	
	
	//IN073712 Starts
	if("ORDER_SET"==called_from){
		 if(undefined!=document.getElementById("ordersetlevel"))
			document.getElementById("ordersetlevel").innerHTML="<font class='label' size='1'><a class='gridLink' href='javascript:callReviseBilling(\""+index+"\",\"ORDER_SET\",\""+patientid+"\",\""+encounter_id+"\",\""+ser_panel_ind+"\",\""+ser_panel_code+"\",\""+episode_type+"\",\""+episode_id+"\",\""+visit_id+"\",\""+order_id+"\",\""+order_line_no+"\")' title='Charge Details'> "+getLabel("eOR.View/Edit.label","eOR")+"</font>" ;		
	}
	if( "ORDER_SET_AMEND"==called_from){//10503
		 if(undefined!=document.getElementById("ordersetlevel")){
			 document.getElementById("ordersetlevel").innerHTML="<font class='label' size='1'><a class='gridLink' href='javascript:callReviseBilling(\"1\",\"ORDER_SET_AMEND\",\""+patientid+"\",\""+encounter_id+"\",\""+ser_panel_ind+"\",\""+ser_panel_code+"\",\""+episode_type+"\",\""+episode_id+"\",\""+visit_id+"\",\""+order_id+"\",\""+order_line_no+"\")' title='Charge Details'> "+getLabel("eOR.View/Edit.label","eOR")+"</font>" ;
		 }//10503	
	}
	//IN073712 ENDS
	//if("NEW_ORDER"==function_name  && eval("document.getElementById("order")"+index)&&eval("document.getElementById("order")"+index).style!=undefined){//IN073309//IN073712
	if("NEW_ORDER"==called_from  && document.getElementById('order'+index)&&document.getElementById('order'+index).style!=undefined){//IN073309//IN073712
		
			document.getElementById('order'+index).innerHTML="<td  id='order"+index+"' ><a class='gridLink' href='javascript:callReviseBilling(\""+index+"\",\"NEW_ORDER\",\""+patientid+"\",\""+encounter_id+"\",\""+ser_panel_ind+"\",\""+ser_panel_code+"\",\""+episode_type+"\",\""+episode_id+"\",\""+visit_id+"\",\""+order_id+"\",\""+order_line_no+"\")' title='Charge Details'> "+getLabel("eOR.View/Edit.label","eOR")+" </td>" ;
	
	}
	
	if("AMEND_ORDER"==called_from ){//IN073309//IN073712//10503
		
		document.getElementById('order'+index).innerHTML="<font class='label' size='1'><a class='gridLink' href='javascript:callReviseBilling(\""+index+"\",\"AMEND_ORDER\",\""+patientid+"\",\""+encounter_id+"\",\""+ser_panel_ind+"\",\""+ser_panel_code+"\",\""+episode_type+"\",\""+episode_id+"\",\""+visit_id+"\",\""+order_id+"\",\""+order_line_no+"\")' title='Charge Details'> "+getLabel("eOR.View/Edit.label","eOR")+" </font>" ;
		
		
	}
	if("PREVIEW"==function_name && document.getElementById('order2'+index)&& document.getElementById('order2'+index).style!=undefined ){//IN073309 Starts
		
		document.getElementById('order2'+index).innerHTML="<td  id='order2"+index+"' ><a class='gridLink' href='javascript:callReviseBilling(\""+index+"\",\"NEW_ORDER\",\""+patientid+"\",\""+encounter_id+"\",\""+ser_panel_ind+"\",\""+ser_panel_code+"\",\""+episode_type+"\",\""+episode_id+"\",\""+visit_id+"\",\""+order_id+"\",\""+order_line_no+"\")' title='Charge Details'> "+getLabel("eOR.View/Edit.label","eOR")+" </td>" ;
		
	}//IN073309 Ends
	
	
}
//IN068314 Ends
//to calulate the total billing charges for the select orderables.
function showBillingTable(){
	
	var bill_show	 = false;
	var actual_amt	 = 0.0;
	var payable_amt	 = 0.0;

	for(var i=0;i<document.placeOrderForm.amend_total_rows.value;i++){
		var amend_billing_call_yn = eval("document.placeOrderForm.amend_billing_call_yn"+i).value ;
		
		if(amend_billing_call_yn =="Y"){
			bill_show = true;
			var temp_act = document.getElementById('amend_actual_'+i).innerText;
			var temp_pay = document.getElementById('amend_payable_'+i).innerText;
			
			actual_amt	 += parseFloat(eval(temp_act));
			payable_amt	 += parseFloat(eval(temp_pay));
			

		}

	}
	
	for(var i=0;i<document.placeOrderForm.total_rows.value;i++){
		var billing_call_yn = eval("document.placeOrderForm.billing_call_yn"+i).value ;
		
		if(billing_call_yn =="Y"){
			bill_show = true;
			var temp_act = document.getElementById('actual_'+i).innerText;
			var temp_pay = document.getElementById('payable_'+i).innerText;
			
			actual_amt	 += parseFloat(eval(temp_act));
			payable_amt	 += parseFloat(eval(temp_pay));
			

		}

	}
	
	if(bill_show){
		parent.criteriaDetailFrame.document.getElementById("billing_dtl").style.visibility  = "visible" ;
		actual_amt	 += "";
		payable_amt	 += "";
		if(actual_amt.indexOf(".") == -1)
			actual_amt	 += ".0";
		else
			actual_amt = Number((actual_amt)).toFixed(1);//Live - Start added else condition

		if(payable_amt.indexOf(".") == -1)
			payable_amt	 += ".0";
		else 
			payable_amt = Number((payable_amt)).toFixed(1);//Live - End added else condition
		
		parent.criteriaDetailFrame.document.getElementById("actual_").innerText	  = actual_amt;
		parent.criteriaDetailFrame.document.getElementById("payable_").innerText	  = payable_amt;


	}else{
		parent.criteriaDetailFrame.document.getElementById("billing_dtl").style.visibility  = "hidden";
		parent.criteriaDetailFrame.document.getElementById("actual_").value	  = "0.0";
		parent.criteriaDetailFrame.document.getElementById("payable_").value	  = "0.0";  
	}
}


// Call the Billing Related Informations . if present
function callBilling(row_value,called_from)
{
	var formObj		= document.placeOrderForm;
	//var localeName			= document.placeOrderForm.localeName.value;

	

	bean_id 		= formObj.bean_id.value;
	bean_name 		= formObj.bean_name.value;
	if(called_from=="NEW_ORDER")
	{
		quantity		= eval("document.placeOrderForm.quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.cat_desc"+row_value+".value");
	}
	else // For New Orders or orderset
	{
		quantity		= eval("document.placeOrderForm.amend_quantity"+row_value+".value");
		start_date_time	= eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
		catalog_code	= eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		cat_desc		= eval("document.placeOrderForm.amend_cat_desc"+row_value+".value");
	}


	if(start_date_time!="" && quantity!="" && catalog_code!="")
	{
		//var xmlDoc	= new ActiveXObject("Microsoft.XMLDom");
		//var xmlHttp	= new ActiveXObject("Microsoft.XMLHTTP");
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&quantity="+quantity+"&catalog_code="+escape(catalog_code)+"&start_date_time="+start_date_time+"&cat_desc="+escape(cat_desc)+"&func_mode=GETBILLINGDETAILS", false);
		xmlHttp.send(xmlDoc);
		responseText = xmlHttp.responseText;
		eval(responseText);
	} 
} // End of callBilling
async function loadBillingDetails(day_type_code,day_type_desc,time_type_code,time_type_desc,base_qty,base_rate,addl_factor,base_charge_amt,gross_charge_amt,disc_amt,net_charge_amt,disc_perc,pat_gross_charge_amt,pat_disc_amt,pat_net_charge_amt,cust_gross_charge_amt,cust_disc_amt,cust_net_charge_amt,split_ind,curr_availed,credit_auth_ref, catalog_code, cat_desc,serv_panel_ind,serv_panel_code,service_panel_name,error_text)
{
	if(error_text!=null && error_text!="")
	{
		alert(error_text);
	}
	else
	{
		var query_string = "insind="+escape(split_ind)+"&baseqty="+base_qty+"&basechargeamt="+base_charge_amt+"&grosschargeamt="+gross_charge_amt+"&discountper="+disc_perc+"&discountamt="+disc_amt+"&daytypecode="+escape(day_type_code)+"&daytypedesc="+escape(day_type_desc)+"&timetypecode="+time_type_code+"&timetypedesc="+time_type_desc+"&addlfactor="+addl_factor+"&patgrosschargeamt="+pat_gross_charge_amt+"&patdiscamt="+pat_disc_amt+"&patnetamt="+pat_net_charge_amt+"&custgrosschargeamt="+cust_gross_charge_amt+"&custdiscamt="+cust_disc_amt+"&custnetamt="+cust_net_charge_amt+"&ordercatalogcode="+escape(catalog_code)+"&ordercatalogdesc="+escape(cat_desc)+"&netchargeamt="+net_charge_amt+"&blngrule="+escape(serv_panel_ind)+"&blngservcode="+escape(serv_panel_code)+"&blngservdesc="+escape(service_panel_name)
		var retVal;
		var dialogTop   = "260";
		var dialogHeight= "37.5" ;
		var dialogWidth = "50" ;
		var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
		var arguments	= "";
		retVal 			= await window.showModalDialog("../../eBL/jsp/BLBillDetailsMain.jsp?"+query_string,arguments,features);
	} // End of Else
} // End of loadBillingDetails

async function viewSecondaryOrders(row_value, patient_class)
{
	// Since it is for Amend function, it is just for viewing, pass the mode=2
	bean_id 		= document.placeOrderForm.bean_id.value;
 	bean_name 		= document.placeOrderForm.bean_name.value;
    var start_date_time         = "";
    var priority                = "";
    var pri_order_catalog_code  = "";
 	if (eval("document.placeOrderForm.start_date_time"+row_value)) {
        start_date_time		    = eval("document.placeOrderForm.start_date_time"+row_value+".value");
        priority                = eval("document.placeOrderForm.priority"+row_value+".value");
        pri_order_catalog_code  = eval("document.placeOrderForm.catalog_code"+row_value+".value");
		sec_order_catalog_type  = eval("document.placeOrderForm.sec_tasks_type"+row_value+".value");
    } else if (eval("document.placeOrderForm.amend_start_date_time"+row_value)) {
        start_date_time		   = eval("document.placeOrderForm.amend_start_date_time"+row_value+".value");
        priority                = eval("document.placeOrderForm.amend_priority"+row_value+".value");
        pri_order_catalog_code  = eval("document.placeOrderForm.amend_catalog_code"+row_value+".value");
		sec_order_catalog_type  = eval("document.placeOrderForm.amend_sec_tasks_type"+row_value+".value");
    }

    var retVal;
 	var dialogTop   = "260";
 	var dialogHeight= "24" ;
 	var dialogWidth = "35" ;
 	var features	= 'Width:' + dialogWidth +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:'+dialogTop +'; scroll=no; status=no';
 	var arguments	= "";

 	var qryString = "";
 	qryString += "bean_id="+bean_id+"&bean_name="+bean_name+"&start_date_time="+start_date_time;
 	qryString += "&pri_order_catalog_code="+pri_order_catalog_code+"&priority="+priority+"&patient_class="+patient_class+"&sec_order_catalog_type="+sec_order_catalog_type;
 	retVal 			= await window.showModalDialog("../../eOR/jsp/OrderEntrySecondaryOrdersFrameset.jsp?"+qryString,arguments,features);
 } // End of viewSecondaryOrders

 async function viewDuplicate(order_id){
	var order_category	= "";
	if(order_id!=null && order_id!="")
		order_category	= order_id.substring(0,2);

	var dialogHeight	= "37.5" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "100";
	var dialogLeft		= "11" ;
	var title			= "";
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments		= "";
	var finalString		= "from=line&colval1=View&colval=View&orderId="+order_id+"&ord_cat="+ order_category;
  	var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
}

function amenddate(count,amenddate,locale,value,amendcatcode,onload,facilityId)
{
	checkAmendStartDateTime(document.getElementById('amend_start_date_time_id'+count),count,amenddate,locale,value,amendcatcode,onload,facilityId);
}

function checkWithCurrentDate(obj,index,currentDate,localeName,catcode,called_from,appt_reqd_yn)
{
	var Future_date="";

	var Round_Off_Start_Time="";
	if((appt_reqd_yn=='')||(appt_reqd_yn=='N'))
	{
	   if(parent.placeOrderDetailFrame.document.placeOrderForm.billing_call_yn+index && parent.placeOrderDetailFrame.document.getElementById('bill_now_'+index))  
		{
			Future_date=parent.placeOrderDetailFrame.document.getElementById('future_date'+index).value;
			var Currentdateforfloor=currentDate.substring(0,10);
			var Futuredateforfloor=Future_date.substring(0,10);
			if(!(isAfter(Currentdateforfloor,Futuredateforfloor,"DMY",localeName)))
			{
				Round_Off_Start_Time=parent.placeOrderDetailFrame.document.getElementById('round_off_start_time'+index).value;
				if(Round_Off_Start_Time=="Y")
				{
					Future_date=Future_date.substring(0,11)+"00:00";
					parent.placeOrderDetailFrame.document.getElementById('future_date'+index).value=Future_date;
				}
			}	
		}
		else if(parent.placeOrderDetailFrame.document.placeOrderForm.amend_billing_call_yn+index &&parent.placeOrderDetailFrame.document.getElementById('amend_bill_now_'+index))
		{
		   Future_date=parent.placeOrderDetailFrame.document.getElementById('amend_future_date'+index).value;
			var Currentdateforfloor=currentDate.substring(0,10);
			var Futuredateforfloor=Future_date.substring(0,10);
			if(!(isAfter(Currentdateforfloor,Futuredateforfloor,"DMY",localeName)))
			{ 			Round_Off_Start_Time=parent.placeOrderDetailFrame.document.getElementById('amend_round_off_start_time'+index).value;
			   if(Round_Off_Start_Time=="Y")
				{
					Future_date=Future_date.substring(0,11)+"00:00";
					parent.placeOrderDetailFrame.document.getElementById('amend_future_date'+index).value=Future_date;
				}
			}
		}
		else
		{
		   Future_date=currentDate;
		}
	}



	if((!(isAfter(Future_date,obj.value,"DMYHM",localeName)))||(Future_date==(obj.value)))
	{
		if(called_from!="schedule")
		{
			if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.schedule_mandatorily_yn"+index))
			{
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.schedule_mandatorily_yn"+index+".value='N'");
			}
			else if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_schedule_mandatorily_yn"+index))
			{
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_schedule_mandatorily_yn"+index+".value='N'");
			}
		}
		if((appt_reqd_yn=='')||(appt_reqd_yn=='N'))
		{
			if(parent.placeOrderDetailFrame.document.placeOrderForm.billing_call_yn+index && parent.placeOrderDetailFrame.document.placeOrderForm.billing_call_yn+index.value=="Y" )
			{
				parent.placeOrderDetailFrame.document.getElementById('bill_now_').style.visibility="visible";
				setValueforlegend("bill_now_"+catcode,"visible");
		 

		  
				if (eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check_Df"+index).value == 'Y')
				{		
					setValueforlegend("bill_now"+catcode,"Y");
					setValueforlegend("bill_now_check_Df"+catcode,"Y");
					setValueforlegend("bill_now_check"+catcode+"chk","Checked");
		 			eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index).value='Y';
				  	eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check"+index).checked=true;
				}
				else
				{
					setValueforlegend("bill_now"+catcode,"");
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index).value=''; 
					setValueforlegend("bill_now_"+catcode,"hidden");
					parent.placeOrderDetailFrame.document.getElementById('bill_now_'+index).style.visibility="hidden";
				}
			}

			else if((eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_billing_call_yn"+index) && eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_billing_call_yn"+index).value=="Y"))
			{
				parent.placeOrderDetailFrame.document.getElementById('amend_bill_now_'+index).style.visibility="visible";
				setValueforlegend("amend_bill_now_"+catcode,"visible");
		 

		  
			 if (eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check_Df"+index).value == 'Y')
			{
					setValueforlegend("amend_bill_now"+catcode,"Y");
					setValueforlegend("amend_bill_now_check_Df"+catcode,"Y");
					setValueforlegend("amend_bill_now_check"+catcode+"chk","Checked");
		 			eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index).value='Y';
				  eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check"+index).checked=true;
		  }
		 else
		 {
			setValueforlegend("amend_bill_now"+catcode,"");
			eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index).value=''; 
			setValueforlegend("amend_bill_now_"+catcode,"hidden");
		parent.placeOrderDetailFrame.document.getElementById('amend_bill_now_'+index).style.visibility="hidden";
		 }
	  }
      else
	{	


		
		 if((eval("parent.placeOrderDetailFrame.document.placeOrderForm.billing_call_yn"+index) && eval("parent.placeOrderDetailFrame.document.placeOrderForm.billing_call_yn"+index).value == "Y" ))   
		{
			parent.placeOrderDetailFrame.document.getElementById('bill_now_'+index).style.visibility="hidden";
			setValueforlegend("bill_now_"+catcode,"hidden");
			//if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check_Df"+index))
			//{
				//eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check_Df"+index+".value='N'");
			//}
			//eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index).value=eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check_Df"+index).value;
			if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check_Df"+index).value=="Y")
			{
				setValueforlegend("bill_now_check"+catcode+"chk","Checked");
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check"+index).checked=true;
			}
			else
			{
				setValueforlegend("bill_now_check"+catcode+"chk","UnChecked");
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now_check"+index).checked=false;
			}
			if(parent.placeOrderDetailFrame.document.getElementById('bill_now_'+index).style.visibility=="hidden")
			{
				if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index))
				{
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index+".value='N'");
				}
			}
			else
			{
				if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index))
				{
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.bill_now"+index+".value='Y'");
				}
			}
		}

		else if((eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_billing_call_yn"+index) && eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_billing_call_yn"+index).value == "Y")	)
		{
			parent.placeOrderDetailFrame.document.getElementById('amend_bill_now_'+index).style.visibility="hidden";
			setValueforlegend("amend_bill_now_"+catcode,"hidden");
			//if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check_Df"+index))
			//{
				//eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check_Df"+index+".value='N'");
			//}
			//eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index).value=eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check_Df"+index).value;
			if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check_Df"+index).value=="Y")
			{
				setValueforlegend("amend_bill_now_check"+catcode+"chk","Checked");
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check"+index).checked=true;
			}
			else
			{
				setValueforlegend("amend_bill_now_check"+catcode+"chk","UnChecked");
				eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now_check"+index).checked=false;
			}
			if(parent.placeOrderDetailFrame.document.getElementById('amend_bill_now_'+index).style.visibility=="hidden")
			{
				if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index))
				{
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index+".value='N'");
				}
			}
			else
			{
				if(eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index))
				{
					eval("parent.placeOrderDetailFrame.document.placeOrderForm.amend_bill_now"+index+".value='Y'");
				}
			}
		}
	  }
	}
  }
}

function setValueforlegend(key,value)
{
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	formobj=parent.placeOrderDetailFrame.document.placeOrderForm;
	
	var bean_id=formobj.bean_id.value;
	var bean_name=formobj.bean_name.value;
	var func_mode="Tempvalues";
	xmlStr ="<root><SEARCH " ;
	xmlStr += " key=\""+ key +"\" " ;
	xmlStr += " value=\""+ value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "OrderEntryValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&func_mode="+func_mode,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText );
}

function populateordertypeSearch(target,code,called_from)
{
	if(called_from=='addlSearchCriteriaForm')
	{
		 formobj=document.addlSearchCriteriaForm;
	}else if(called_from=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(called_from=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(called_from=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}

	if(trimString(target.value).length>0)
	{
		callordertypeSearch(target,code,called_from);
	}
	else
	{
		if(target.value=="")
		{
			code.value="";
			formobj.activity_type.value="";
			formobj.activity_type_desc.value="";
		}
		if(called_from=="imageSearchForm")
		{
			imageSearch();
	 	}
		else if(called_from == "careSetSearchForm")  //Added by Archana on 6/10/2010  for IN022017.
	    {
			populateOrderTypeCareSet(document.careSetSearchForm.order_category);
			if(parent.criteriaDetailFrame)
		      parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	        if(parent.criteriaButtonFrame)
		     parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
	    }
		
	}
	/*if(target.value=="")
	{
		code.value="";
	}*/
}
function getOrderTypeCode(objCode)
{
	if(objCode.name=="order_type_desc")
	{
		
		orderType_code(objCode)
	}
}
function orderType_code(objCode)
{   
	var order_category;
	var localeName;
	var orderTypevalue = objCode.value;
	
    if(objCode.name == "order_type_desc")
	{	
	   if(objCode.value !="")
		{
		 formobj=document.addlSearchCriteriaForm;
		 order_category = formobj.order_category.value;
		 localeName = formobj.localeName.value;
			var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eOR/jsp/OrderTypeLookupIntermediate.jsp'><input type='hidden' name='orderTypevalue' id='orderTypevalue' value='"+orderTypevalue+"'><input type=hidden name='selFunVal' id='selFunVal' value='OrderType'><input type=hidden name='order_category' id='order_category' value='"+order_category+"'><input type=hidden name='localeName' id='localeName' value='"+localeName+"'></form></body></html>";
		   parent.frames[2].document.write(HTMLVal);
		   parent.frames[2].document.tempform1.submit(); 
		}
        else
			return false;
     }
    
}
async function callFunction3(sql,title,targetDesc,targetCode)
     {
          var argArray		= new Array();
          var namesArray		= new Array();
          var valuesArray		= new Array();
          var datatypesArray	= new Array();
		
		   argArray[0] = sql;
		   argArray[1] = namesArray;
		   argArray[2] = valuesArray;
		   argArray[3] = datatypesArray;
		   argArray[4] = "1,2";
		   argArray[5] = targetDesc.value;
		   argArray[6] = DESC_LINK;
		   argArray[7] = CODE_DESC;
		   retVal = await CommonLookup( title, argArray );
		   var ret1=unescape(retVal);
		   var arr=ret1.split(",");
		   if(arr[1]==undefined) 
		   {
			   arr[0]="";	
			   arr[1]="";	
		   } 
		   if (retVal != null && retVal != '' && retVal != "null")
		   {
			   targetDesc.value = arr[1];
			   targetCode.value = arr[0];
		   }
		   else
		   {
			   targetDesc.value = "";
			   targetCode.value = "";
		   } 
		   //return retVal;
       }
async function callordertypeSearch(target,code,called_from)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();

	if(called_from=='addlSearchCriteriaForm')
	{
		 formobj=document.addlSearchCriteriaForm;
	}else if(called_from=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(called_from=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(called_from=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}
	
	dataNameArray[0] 	= "order_category" ;	
	dataValueArray[0] 	= formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	
	var localeName= formobj.localeName.value;
	var sql=formobj.order_type_sql.value;
	
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="2,3";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.OrderType.label","Common"),argumentArray);
	
	var ret1=unescape(retval);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retval !=null && retval != "")
	{
		 code.value=arr[0];
		 target.value=arr[1];
	}
	else
	{
   		target.value = "";
   		code.value = "" ;
	 }

	if(called_from=="imageSearchForm")
	{
		imageSearch();
	}	
	formobj.activity_type.value="";
	formobj.activity_type_desc.value="";

	if(called_from=="careSetSearchForm")
	{
		populateOrderTypeCareSet(document.careSetSearchForm.order_category);
		if(parent.criteriaDetailFrame)
		  parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	   if(parent.criteriaButtonFrame)
		parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
	}
}

function populateActivitySearch(target,code,called_from)
{
	if(trimString(target.value).length>0)
	{
			callActivitySearch(target,code,called_from);
	}
	else
	{
		if(target.value=="")
		{
			code.value="";
		}
		if(called_from=="imageSearchForm")
		{
			imageSearch();
		}
		else if(called_from=="careSetSearchForm") //Added by Archana on 6/10/2010  for IN022017.
	    {
			populateActivityCareSet(document.careSetSearchForm.activity_type);
			if(parent.criteriaDetailFrame)
		   parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	      if(parent.criteriaButtonFrame)
		  parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
	    }
		
	}
	/*if(target.value=="")
	{
		code.value="";
	}*/
}

async function callActivitySearch(target,code,called_from)
{
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	if(called_from=='addlSearchCriteriaForm')
	{
		 formobj=document.addlSearchCriteriaForm;
	}else if(called_from=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(called_from=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(called_from=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}
	
	localeName=formobj.localeName.value;
	
	dataNameArray[0] 	= "order_category" ;
	dataValueArray[0] 	=formobj.order_category.value;
 	dataTypeArray[0] 	= STRING ;
	dataNameArray[1] 	= "order_type_code" ;	
	dataValueArray[1] 	= formobj.order_type.value;
 	dataTypeArray[1] 	= STRING ;
	
	var sql=formobj.activity_sql.value;
	
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="3,4";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("eOR.ActivityType.label","OR"),argumentArray);
var ret1=unescape(retval);

		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retval !=null && retval != "")
	{
		code.value=arr[0];
		target.value=arr[1];
				
	}
	else
	{
 		target.value = "";
   		code.value = "" ;
	 }
	if(called_from=="imageSearchForm")
	{
		imageSearch();
	}
	else if(called_from=="careSetSearchForm")
	{
		populateActivityCareSet(document.careSetSearchForm.activity_type);
		if(parent.criteriaDetailFrame)
		  parent.criteriaDetailFrame.location.href = "../../eCommon/html/blank.html"
	   if(parent.criteriaButtonFrame)
		 parent.criteriaButtonFrame.location.href = "../../eCommon/html/blank.html"
	}
}

function clearvalues(called_from)
{
	if(called_from=='addlSearchCriteriaForm')
	{
		 formobj=document.addlSearchCriteriaForm;
	}else if(called_from=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(called_from=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(called_from=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}
		
		formobj.order_type.value="";
		formobj.order_type_desc.value="";
		formobj.activity_type.value="";
		formobj.activity_type_desc.value="";
		if(formobj.order_category.value=="")
		{
			formobj.order_type_desc.disabled=true;
			formobj.ordertypesearch.disabled=true;
			if(called_from=="imageSearchForm"){
				formobj.activity_type_desc.disabled=true;//IN069027
				formobj.search.disabled=true;//IN069027
			}
		}else
		{
			formobj.order_type_desc.disabled=false;
			formobj.ordertypesearch.disabled=false;
			if(called_from=="imageSearchForm"){
				formobj.activity_type_desc.disabled=false;//IN069027
				formobj.search.disabled=false;//IN069027
			}
		}
	
}

function clearactivityvalues(called_from)
{
	if(called_from=='addlSearchCriteriaForm')
	{
		 formobj=document.addlSearchCriteriaForm;
	}else if(called_from=='tickSheetForm')
	{
		formobj=document.tickSheetForm;
	}else if(called_from=="careSetSearchForm")
	{
		formobj=document.careSetSearchForm;
	}else if(called_from=="imageSearchForm")
	{
		formobj=document.imageSearchForm;
	}
	
		formobj.activity_type.value="";
		formobj.activity_type_desc.value="";
	
}

function clearDurationList( docObj,form_name,row ) 
{
	if(eval(form_name+".duration_code"+row).options)
	{
		var len = eval(form_name+".duration_code"+row+".options.length") ;
		for(var i=0;i<len;i++)
		{
			eval(form_name+".duration_code"+row+".remove(\"order_type\")") ;
		}
		var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
		opt.text 	= tp ;
		opt.value 	= "" ;
		eval(form_name+".duration_code"+row+".add(opt)") ;
	}
} // End of clearOrderList

// To add in the List box
function addDurationList(form_name,code,value,row) 
{
	if(eval(form_name+".duration_code"+row).options)
	{
		var element 	= document.createElement('OPTION') ;
		element.value =trimString(code);
		element.text 	=trimString(value);
		form_name = eval(form_name+".duration_code"+row);
		form_name.add(element);
	}
}

function clearAmendDurationList( docObj,form_name,row ) 
{
	if(eval(form_name+".amend_duration_code"+row).options)
	{
		var len = eval(form_name+".amend_duration_code"+row+".options.length") ;
		for(var i=0;i<len;i++)
		{
			eval(form_name+".amend_duration_code"+row+".remove(\"order_type\")") ;
		}
		var tp 		= " --- "+getLabel("Common.defaultSelect.label","Common")+" ---";
		var opt  	= eval(docObj+".createElement(\"OPTION\")") ;
		opt.text 	= tp ;
		opt.value 	= "" ;
		eval(form_name+".amend_duration_code"+row+".add(opt)") ;
	}
} // End of clearOrderList

// To add in the List box
function addAmendDurationList(form_name,code,value,row) 
{
	if(eval(form_name+".amend_duration_code"+row).options)
	{
		var element 	= document.createElement('OPTION') ;
		element.value =trimString(code);
		element.text 	=trimString(value);
		form_name = eval(form_name+".amend_duration_code"+row);
		form_name.add(element);
	}
}
function alignHeading()
{
	if(parent.OrderEntrySecondaryOrdersHeader.document.getElementById("tableheader")!=null)
	{
				parent.OrderEntrySecondaryOrdersHeader.document.getElementById("tableheader").width =	eval(document.getElementById("tableresult").offsetWidth);
				for (j=0; j < document.getElementById("tableresult").rows[0].cells.length; j++) 
				{
					var wid=eval(document.getElementById("tableresult").rows[0].cells[j].offsetWidth);
					
					if(parent.OrderEntrySecondaryOrdersHeader.document.getElementById("tableheader").rows[0].cells[j] != null)
					{
						parent.OrderEntrySecondaryOrdersHeader.document.getElementById("tableheader").rows[0].cells[j].width=wid;
					}
				}
	}
		
}
function moveFrame()
{
	var temp=document.body.scrollLeft;
	scrollValue=temp;

	if(parent.OrderEntrySecondaryOrdersHeader.location.href.indexOf(".jsp") != -1)
	{
		parent.OrderEntrySecondaryOrdersHeader.document.body.scrollLeft=temp;
	}
}

async function callLocationClinic(obj,called_on)
{
	document.formPractDtl.location_code.value = "";

 	var dataNameArray 	= new Array() ;
	var dataValueArray 	= new Array() ;
  	var dataTypeArray 		= new Array() ;
	sql_query					= document.formPractDtl.sql_or_order_entry_location_clinics.value;
	sql_query					= sql_query.replace('?',"'"+document.formPractDtl.localeName.value+"'");
	var argumentArray 	= new Array() ;
	argumentArray[0]		= sql_query;
	argumentArray[1]		= dataNameArray ;
	argumentArray[2]		= dataValueArray ;
	argumentArray[3]		= dataTypeArray ;
	argumentArray[4]		= "1,2";
	argumentArray[5]		= document.formPractDtl.location.value ;//Target
	retVal							= await callCommonLookUpSearch(argumentArray,obj.name);
		
	var ret1=unescape(retVal);
	alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal!=null && retVal!='')
	{
		document.formPractDtl.location.value = arr[1] ;
		document.formPractDtl.location_code.value	  = arr[0];
		document.formPractDtl.practitioner_name.readOnly	= false;
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
	}
	else
	{
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
	}
} // End of callLocationClinic
function callSpecialitySplSearch(obj,code)
{
	if(obj.value!="")
	{
		callSpeciality(obj);
	}
	else
	{
		code.value="";		
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.pract_search.readOnly	= true;
	}
}
function callLocSearch(obj,code)
{
	if(obj.value!="")
	{
		callSearch(obj);
	}
	else
	{
		code.value = "";
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.pract_search.readOnly	= true;
	}
}
function clearPractForLocn()
{
	if((document.formPractDtl.search_by.value == "LO" && document.formPractDtl.location.value=="")||(document.formPractDtl.search_by.value == "SP" && document.formPractDtl.speciality.value==""))
	{
		document.formPractDtl.practitioner_name.value		= "";
		document.formPractDtl.practitioner_id.value			= "";
		document.formPractDtl.practitioner_name.readOnly	= true;
		document.formPractDtl.pract_search.readOnly	= true;
	}
}function callOnModal(obj,search_by)
	{
		var err_message = "";
		if(obj.name =="ok")
		{
			if(search_by=="LO")
			{
				if(document.formPractDtl.location_type!="W")
				{
					if(document.formPractDtl.location_code.value=="")
					{
						err_message += getMessage("RESULT_REPORTING_LOCN_BLANK","OR")+"\n";
					}
				}
				else
				{
					if(document.formPractDtl.location_code_val.value=="")
					{
						err_message += getMessage('RESULT_REPORTING_LOCN_BLANK','OR')+"\n";
					}
				}
			}
			else if(search_by=="SP")
			{
				if(document.formPractDtl.speciality_code.value=="")
				{
					err_message += getMessage('SPECIALITY_NOT_BLANK','CA')+"\n";
				}
			}
			if(document.formPractDtl.practitioner_id.value!=''&&document.formPractDtl.practitioner_name.value!='')
			{
				//parent.returnValue = obj.name+"~"+document.formPractDtl.practitioner_id.value+"~"+document.formPractDtl.practitioner_name.value+"~"+escape(document.formPractDtl.order_mode_value.value);
				//parent.window.close();
				 //const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
	parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=obj.name+"~"+document.formPractDtl.practitioner_id.value+"~"+document.formPractDtl.practitioner_name.value+"~"+escape(document.formPractDtl.order_mode_value.value);
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
 
			}
			else
			{
				err_message += getMessage('PRACT_NOT_BLANK','OR');
				alert(err_message);
			}
		}
		else
		{
				parent.returnValue = obj.name+"~"+document.formPractDtl.practitioner_id.value+"~"+escape(document.formPractDtl.practitioner_name.value)+"~"+escape(document.formPractDtl.order_mode_value.value);
				//parent.window.close();
				 //const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close();
			parent.parent.document.querySelectorAll('#dialog-body')[parent.parent.document.querySelectorAll('#dialog-body').length-1].contentWindow.returnValue=obj.name+"~"+document.formPractDtl.practitioner_id.value+"~"+escape(document.formPractDtl.practitioner_name.value)+"~"+escape(document.formPractDtl.order_mode_value.value);
			parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();	
		}
	}
	/*Added by Uma on 8/24/2009 for PMG20089 CRF-641*/
	function SetApplicability(obj)
	{
		if(obj.checked)
		{
			obj.value = "Y";
		}
		else
		{
			obj.value = "N";
		}
	}
/* End Here*/
/* Added By Arvind Modified by Uma on 3/15/2010 for IN019656*/

function checkFrameMembers(orderSetVal, panelVal, individualVal)
{
	var formobj = parent.document.getElementById("sectionFrame");
	if(formobj!=null)
	{
		if (individualVal == '' && orderSetVal == '' && panelVal != '')
		{
			formobj.rows="0%,100%,0%";
		}
		else if (individualVal == '' && orderSetVal != '' && panelVal == '')
		{
			formobj.rows="100%,0%,0%";
		}
		else if (individualVal != '' && orderSetVal == '' && panelVal == '')
		{
			formobj.rows="0%,0%,100%";
		}
		else if (individualVal == '' && orderSetVal != '' && panelVal != '')
		{
			formobj.rows="50%,50%,0%";
		}
		else if (individualVal != '' && orderSetVal == '' && panelVal != '')
		{
			formobj.rows="0%,50%,50%";
		}
		else if (individualVal != '' && orderSetVal != '' && panelVal == '')
		{
			formobj.rows="50%,0%,50%";
		}
	}
	if (individualVal == '' && orderSetVal == '' && panelVal == '')
	{
		alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
	}	
	
}

function chkBackSpace()
{
	whichCode = event.keyCode;

	if (whichCode == 8)
	{		
		event.returnValue = false;
		return false;
	}

}
//[IN038776] Start.
async function showScreeningServices(){
	
	var bean_id 		= "";var chk_box_val_group = "";
	var bean_name 		= "";var chk_box_val_atomic = "";var chk_box_val_profile = "";
	var tab_frame_name 	= "";
	var check_box_value	= "";
	var form_obj 		= new Array();
	var requestStr=document.addlSearchCriteriaForm.query_string.value;
	requestStr=requestStr.replace("&function_from=","");
	
			
	var p_operating_facility_id	=	document.addlSearchCriteriaForm.facility_id.value;
	var p_patient_id			=	document.addlSearchCriteriaForm.patient_id.value;
	var p_episode_type			=	document.addlSearchCriteriaForm.ca_patient_class.value;
	var p_episode_id			=	(document.addlSearchCriteriaForm.encounter_id.value).substring(0, 8);
	var p_visit_id				=	document.addlSearchCriteriaForm.ca_patient_visit_id.value;	
	
	var dialogHeight	= "23.5" ;
	var dialogWidth		= "50" ;
	var dialogTop		= "230";
	var dialogLeft		= "350" ;
	var title			= "";
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var arguments		= "";
	var finalString		= "";
  	var retVals = await window.showModalDialog("../../eBL/jsp/ScreeningServiceApplciable.jsp?p_patient_id="+p_patient_id+"&p_episode_type="+p_episode_type+"&p_episode_id="+p_episode_id+"&p_visit_id="+p_visit_id,arguments,features);
	
	
	if(retVals>0){
			
			if(parent.parent.DetailFrame)
			{
				if(parent.parent.DetailFrame.criteriaPlaceOrderFrame)
				if(parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame==null )
					return;  // If the frame is not there..
			}			

			if(parent.parent.DetailFrame)
			{
				if(parent.parent.DetailFrame.criteriaPlaceOrderFrame)
					if((parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)!=undefined)
						if(parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val)
							if(parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.check_box_val.value!="Y")
								return ;
			}
			

			if(parent.parent.DetailFrame)
			{
				if(parent.parent.DetailFrame.criteriaPlaceOrderFrame)
				{
					if(parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm)
					{
						bean_id 			= parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_id.value ;
						bean_name 			= parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm.bean_name.value ;
						form_obj[0]			= parent.parent.DetailFrame.criteriaPlaceOrderFrame.placeOrderDetailFrame.document.placeOrderForm;
					}			
				}
				tab_frame_name		= parent.parent.tabFrame // frame reference for the tab frame (OrderEntryTab.jsp)
			}		
			
			
			//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			var xmlHttp = new XMLHttpRequest();
			xmlStr					= "<root><SEARCH " ;
			xmlStr 			+=" /></root>" ;
			
			var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "../../eOR/jsp/OrderEntryStoreValues.jsp?"+requestStr+"&function_from=SCRENING_SERVICES", false ) ;//IN030469
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval( responseText ) ;
			if(parent.parent.DetailFrame)
			{
				var activity_type_code= parent.parent.tabFrame.document.formTab.exist_activity_type_code.value;
				var activity_type_desc=parent.parent.tabFrame.document.formTab.exist_activity_type_desc.value;
				
				var  query_string		= buildQueryString();				
				query_string = query_string.replace("&function_from=","&function_from=SCRENING_SERVICES");	
				parent.parent.DetailFrame.location.href = "../../eOR/jsp/OrderEntryFrameSet.jsp?tab_name="+"PlaceOrder"+query_string+"&activity_type_code="+activity_type_code+"&activity_type_desc="+activity_type_desc;
			}
			
			if(parent.parent.tabFrame){
				parent.parent.tabFrame.document.formTab.flag.value = "PlaceOrder";
			}else if(parent.parent.parent.tabFrame)
				parent.parent.parent.tabFrame.document.formTab.flag.value = "PlaceOrder";
			
	}
}//[IN038776] End.
/* End Here */


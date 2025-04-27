/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/9/2011	  IN27198		 Dinesh T	 Changed the lines to solve the preview window issue which goes																	 behind the editor screen in the refusal in the Record Refusal																	 function
29/3/2012	  IN32036		 Dinesh T	 Improper "Practitioner name" display  in thai language
24/09/2012    IN034904       Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal
16/11/2012    IN036055       Chowminya G    In task list ? patient chart and task list ? homepage, Pat name not correct in thai
09/01/2013	  IN036697		 Ramesh G		System is not allowing the user to Confirm the Consent Note for 
											the Patient name with special characters other than $.
16/03/2013    IN037395		Chowminya G   error in consent form with max thai patient name 	
22/07/2013    IN041421      Chowminya G   Special characters -record consent "Internal Server Error"										
19/08/2013	  IN038797	   Karthi L		To include the field (Filter) of "Speciality" in the function of "Pending Consent" in Practitioner's homepage									
04/09/2013	  IN043035	   Karthi L		There is a refresh issue upon recording a pending consent of a speciality
11/09/2013	  IN043179	   Karthi L		Refresh problem in Record Consent screen.	
18/09/2013	  IN043437	   Karthi L		By selecting Specialty having Special characters we get wrong message prompt.
--------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------

02/08/2016	  IN032140	     Raja S		Unable to save Consent Details when Practitioner name with Special characters
14/03/2018	  IN066781		Vijayakumar K										ARYU-SCF-0063 [IN:066781]
05/07/2013	  45066			Ramesh Goli											ML-MMOH-SCF-2436
---------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var invalidCode = "" ;
var qry_string = "";
var foundflag="notfound";
var flagtest="checked";
var recflag="notrecorded";
var brflag="0";
var altmsg = "";

function recordDetailsHdr(totcatalogs)
{
	for (i=0;i<parseInt(totcatalogs);i++ )
	{
	var total_consents_available=eval("parent.multi_detail.document.multiple_consent_form.tot_consents_avail"+i).value;
	var total_consents_req=eval("parent.multi_detail.document.multiple_consent_form.total_consents_req"+i).value;
	var consent_type=eval("parent.multi_detail.document.multiple_consent_form.consent_type"+i).value;
	var order_catalog_desc=eval("parent.multi_detail.document.multiple_consent_form.order_catalog_desc"+i).value;
	var before=parseInt(eval("parent.multi_detail.document.multiple_consent_form.befOrder"+i).value);
	var after=parseInt(eval("parent.multi_detail.document.multiple_consent_form.befRegn"+i).value);
	
	/*if(consent_type=="V")
	{*///changed for SRR20056-SCF-2009  Id:  3736 ********05/06/2008*
	var BO=0;
	var BR=0;
	var TOT=0;
	var totrec=0;
	var checkcnt=0;
	var AVAL=0;
	BO=parseInt(BO);
	BR=parseInt(BR);
	AVAL=parseInt(AVAL);
	TOT=parseInt(TOT);

	AVAL=parseInt(total_consents_available);
		
	before=parseInt(before);
	after=parseInt(after);
	totrec=BO+BR;	
	for(j=0;parseInt(totrec)>j;j++)
	{
		if(eval("parent.multi_detail.document.multiple_consent_form.default_chk"+i+j).value=="Y")
		checkcnt++;
		if(eval("parent.multi_detail.document.multiple_consent_form.temp_consent_desc"+i+j).value==null || eval("parent.multi_detail.document.multiple_consent_form.temp_consent_desc"+i+j).value=="")
		{
			altmsg = getMessage("NO_OF_CONSENT_RECORDED_BEFOR_BEFOR_ORDER_REALEASE_AND_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT_CAT","OR");
			altmsg = altmsg.replace("$$",order_catalog_desc);	
			alert(altmsg);
			return;	
		}
	}
		
	if(AVAL==0)
	AVAL=parseInt(total_consents_req);
	for(k=0;AVAL>k;k++)
	{
		if(eval("parent.multi_detail.document.multiple_consent_form.default_chk"+i+k).value=="Y")
		{
			if(eval("parent.multi_detail.document.multiple_consent_form.consent_form_stage"+i+k).value=="A")
				BO++;
			else
				BR++;
		}
	}
	
	if(checkcnt>parseInt(total_consents_req))
	{
		altmsg = getMessage("NO_OF_CONSENTS_TO_BE_RECORD_ARE_MORE_THAN_REQUIRED_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;		
	}
	if(TOT>parseInt(totrec))
	{
		altmsg = getMessage("CONSENTS_RECORD_MORE_THAN_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;
	}
	
	if(BO>before)
	{
	    altmsg = getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;
	}

	if(BR>after)
	{
		altmsg = getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;	
	}
	TOT=BO+BR;
	
	if(TOT<parseInt(totrec))
	{
		altmsg = getMessage("CONSENTS_RECORD_LESS_THAN_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;
	}
	else if(BO<before)
	{
		altmsg = getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_LESS_THAN_SPEC_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;	
	}	
	else if(BR<after)
	{
		altmsg = getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT_CAT","OR");
		altmsg = altmsg.replace("$$",order_catalog_desc);	
		alert(altmsg);
		return;	
	}

	//}//changed for SRR20056-SCF-2009  Id:  3736 ********05/06/2008*
		
	}
	var formObjHeader=parent.multi_detail.document.multiple_consent_form;
	eval(formApply(formObjHeader,OR_CONTROLLER));
	alert(message);
	//window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}

function recordDetails(totrec)
{
	var total_consents_available=eval(parent.multi_detail.document.multiple_consent_form.total_consents_available.value);
	var before=parseInt(parent.multi_detail.document.multiple_consent_form.befOrder.value);
	var after=parseInt(parent.multi_detail.document.multiple_consent_form.befRegn.value);
	var BO=0;
	var BR=0;
	var TOT=0;
	BO=parseInt(BO);
	BR=parseInt(BR);
	TOT=parseInt(TOT);
	AVAL=parseInt(total_consents_available);
	before=parseInt(before);
	after=parseInt(after);
	if(AVAL==0)
	AVAL=parseInt(totrec);
	for(i=0;AVAL>i;i++)
	{
		if(eval("parent.multi_detail.document.multiple_consent_form.consent_chk"+i).checked)
		{
			if(eval("parent.multi_detail.document.multiple_consent_form.consent_form_stage"+i).value=="A" && eval("parent.multi_detail.document.multiple_consent_form.consent_desc"+i).value!="")
			{
			BO++;
			}
		else if(eval("parent.multi_detail.document.multiple_consent_form.consent_desc"+i).value!="")
			{
			BR++;
			}
		}
	}
	TOT=BO+BR;
	if(TOT>parseInt(totrec))
	{
		alert(getMessage("CONSENTS_RECORD_MORE_THAN_COUNT","OR"));
		return;
	}
	if(BO>before)
	{
		alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_MORE_THAN_SPEC_COUNT","OR"));
		return;
	}
	if(BR>after)
	{
		alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_MORE_THAN_SPEC_COUNT","OR"));
		return;
	}
	 if(TOT<parseInt(totrec))
	{
		alert(getMessage("CONSENTS_RECORD_LESS_THAN_COUNT","OR"));
		return;
	}
	else if(BR<after)
	{
		alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REGISTRATION_LESS_THAN_SPEC_COUNT","OR"));
		return;
	}
	else if(BO<before)
	{
		alert(getMessage("NO_OF_CONSENT_RECORDED_BEFOR_ORDER_REALEASE_LESS_THAN_SPEC_COUNT","OR"));
		return;
	}	
	var formObjHeader=parent.multi_detail.document.multiple_consent_form;
	eval(formApply(formObjHeader,OR_CONTROLLER));	
	alert(message);
	//window.close();
	const dialogTag = parent.parent.document.getElementById('dialog_tag');    
	dialogTag.close();
}

function checkDefaultYn(index,obj,type)
{
	var errors="";
	if(eval("document.multiple_consent_form.consent_chk"+index).checked)
		eval("document.multiple_consent_form.default_chk"+index).value="Y";
	else
	eval("document.multiple_consent_form.default_chk"+index).value="N";
	
	if(eval("document.multiple_consent_form.consent_desc"+index))
	{
		
		if(eval("document.multiple_consent_form.consent_desc"+index).value!="")
		{
			
			if(eval("document.multiple_consent_form.consent_chk"+index).checked)
				eval("document.multiple_consent_form.default_chk"+index).value="Y";
			else
				eval("document.multiple_consent_form.default_chk"+index).value="N";
		}
		else
		{
			
			eval("document.multiple_consent_form.default_chk"+index).value="N";
			errors = errors + getMessage("ASSIGN_CONSENT_FORM_TO_RECORD","OR");
			alert(errors) ;
			obj.checked=false;
		}
	}
	//if(obj.checked)
	//{
		checkValidate(index,type);
	//}
}

function changeValue(obj,index,type)
{
	eval("document.multiple_consent_form.consent_form_stage"+index).value=obj.value;
	checkValidate(index,type);
}
function checkValidate(index,type)
{
	
	var viewBy=document.multiple_consent_form.viewBy.value;
	if(viewBy=="header")
	{
		var cindex=Math.floor(index/10);
	
		for(var i=0;i<parseInt(index%10);i++)
		{
			if(eval("document.multiple_consent_form.consent_form_id"+index).value==eval("document.multiple_consent_form.consent_form_id"+cindex+i).value)
			{
				
				alert(getMessage("DUPLICATE_CONSENTS_NOT_ALLOWED","OR"));
				eval("document.multiple_consent_form.consent_form_id"+index).value=document.multiple_consent_form.temp_consent_form_id.value;
				eval("document.multiple_consent_form.consent_desc"+index).value=document.multiple_consent_form.temp_consent_desc.value;
				return;
			}
		}
		var catalogIndex=Math.floor(parseInt(index)/10);
		var ord_catalog_code=eval("document.multiple_consent_form.ord_catalog_code"+catalogIndex).value;
		var consent_form_id=eval("document.multiple_consent_form.consent_form_id"+index).value;
		var consent_form_stage=eval("document.multiple_consent_form.consent_form_stage"+index).value;
		var order_sequence=eval("document.multiple_consent_form.order_sequence"+index).value;
		var default_chk=eval("document.multiple_consent_form.default_chk"+index).value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var bean_id=document.forms[0].bean_id.value;
		var bean_name=document.forms[0].bean_name.value;
		var modeQuery="update_hdr";
		xmlStr ="<root><SEARCH " ;
		xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
		xmlStr += " consent_form_id=\""+ consent_form_id +"\" " ;
		xmlStr += " catalogIndex=\""+ catalogIndex +"\" " ;
		xmlStr += " consent_form_stage=\""+ consent_form_stage +"\" " ;
		xmlStr += " order_sequence=\""+ order_sequence +"\" " ;
		xmlStr += " default_chk=\""+ default_chk +"\" " ;
		xmlStr += " ord_catalog_code=\""+ ord_catalog_code +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ExistingOrderMultipleConsentValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		/*if(eval("document.multiple_consent_form.dupilcate"+catalogIndex).value!="false" && type=="VR" && eval("document.multiple_consent_form.consent_form_id"+index).value!="")
		{
			
			alert(getMessage("DUPLICATE_CONSENTS_NOT_ALLOWED","OR"));
			eval("document.multiple_consent_form.consent_form_id"+index).value=document.multiple_consent_form.temp_consent_form_id.value;
			eval("document.multiple_consent_form.consent_desc"+index).value=document.multiple_consent_form.temp_consent_desc.value;
		}*/
	}
	else
	{		
		for(var i=0;i<parseInt(index,10);i++)
		{
	
			if(eval("document.multiple_consent_form.consent_form_id"+index).value==eval("document.multiple_consent_form.consent_form_id"+i).value)
			{
				
				alert(getMessage("DUPLICATE_CONSENTS_NOT_ALLOWED","OR"));
				eval("document.multiple_consent_form.consent_form_id"+index).value=document.multiple_consent_form.temp_consent_form_id.value;
	
				eval("document.multiple_consent_form.consent_desc"+index).value=document.multiple_consent_form.temp_consent_desc.value;
				return;
			}
		}
		var ord_catalog_code=document.multiple_consent_form.ord_catalog_code.value;
		var consent_form_id=eval("document.multiple_consent_form.consent_form_id"+index).value;
		var consent_form_stage=eval("document.multiple_consent_form.consent_form_stage"+index).value;
		var order_sequence=eval("document.multiple_consent_form.order_sequence"+index).value;
		var default_chk=eval("document.multiple_consent_form.default_chk"+index).value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var bean_id=document.forms[0].bean_id.value;
		var bean_name=document.forms[0].bean_name.value;
		var modeQuery="update";
		xmlStr ="<root><SEARCH " ;
		xmlStr += " QUERYMODE=\""+ modeQuery +"\" " ;
		xmlStr += " consent_form_id=\""+ consent_form_id +"\" " ;
		xmlStr += " consent_form_stage=\""+ consent_form_stage +"\" " ;
		xmlStr += " order_sequence=\""+ order_sequence +"\" " ;
		xmlStr += " default_chk=\""+ default_chk +"\" " ;
		xmlStr += " ord_catalog_code=\""+ ord_catalog_code +"\" " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ExistingOrderMultipleConsentValidate.jsp?bean_id="+bean_id+"&bean_name="+bean_name,false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
	/*if(document.multiple_consent_form.dupilcate.value!="false" && type=="VR" && eval("document.multiple_consent_form.consent_form_id"+index).value!="")
	{
	
		alert(getMessage("DUPLICATE_CONSENTS_NOT_ALLOWED","OR"));
		eval("document.multiple_consent_form.consent_form_id"+index).value=document.multiple_consent_form.temp_consent_form_id.value;
		eval("document.multiple_consent_form.consent_desc"+index).value=document.multiple_consent_form.temp_consent_desc.value;
	}*/

	}
	
}

function Windowclose()
{
	//window.close();
	toCloseTopShowModal();
}

function checkStage(totalconsents,index)
{
	var viewBy=document.multiple_consent_form.viewBy.value;
	if(viewBy=="header")
	{
		var catalogIndex=Math.floor(parseInt(index)/10);
		var BO=parseInt(eval("document.multiple_consent_form.befOrder"+catalogIndex).value);
		var BR=parseInt(eval("document.multiple_consent_form.befRegn"+catalogIndex).value);
		var ord_catalog_code=eval("document.multiple_consent_form.ord_catalog_code"+catalogIndex).value;
		var BO1=0;
		var BR1=0;
		var i=0;
		i=parseInt(i);
		BO1=parseInt(BO1);
		BR1=parseInt(BR1);
		for(i=0;i<parseInt(totalconsents);i++)
		{
			if(eval("document.multiple_consent_form.consent_stage"+catalogIndex+i+".value")=="A")
				BO1++;
			else if(eval("document.multiple_consent_form.consent_stage"+catalogIndex+i+".value")=="R")
				BR1++;
		}
		if(!(BO1==BO && BR1==BR))
		{
			if(BO1>BO)
			{
				alert(getMessage("BEFORE_ORDER_RELEASE_CANNOT_BE_MORE_THAN","OR")+BO);
				eval("document.multiple_consent_form.consent_stage"+index).value="R"
				eval("document.multiple_consent_form.consent_form_stage"+index).value="R"
			}
			else if(BR1>BR)
			{
				alert(getMessage("BEFORE_ORDER_REGISTRATION_CANNOT_BE_MORE_THAN","OR")+BR);
				eval("document.multiple_consent_form.consent_stage"+index).value="A"
				eval("document.multiple_consent_form.consent_form_stage"+index).value="A"
			}
		}
	}
	else
	{
		var BO=parseInt(document.multiple_consent_form.befOrder.value);
		var BR=parseInt(document.multiple_consent_form.befRegn.value);
		var tot_consents_avail=parseInt(document.multiple_consent_form.total_consents_available.value);
		var BO1=0;
		var BR1=0;
		var i=0;
		i=parseInt(i);
		tot_consents_avail=tot_consents_avail+1;
		BO1=parseInt(BO1);
		BR1=parseInt(BR1);

		for(i=0;i<parseInt(totalconsents);i++)
		{
			if(eval("document.multiple_consent_form.consent_stage"+i+".value")=="A")
				BO1++;
			else if(eval("document.multiple_consent_form.consent_stage"+i+".value")=="R")
				BR1++;
		}
		if(!(BO1==BO && BR1==BR))
		{
			if(BO1>BO)
			{
				alert(getMessage("BEFORE_ORDER_RELEASE_CANNOT_BE_MORE_THAN","OR")+BO);
				eval("document.multiple_consent_form.consent_stage"+index).value="R"
				eval("document.multiple_consent_form.consent_form_stage"+index).value="R"
			}
			else if(BR1>BR)
			{
				alert(getMessage("BEFORE_ORDER_REGISTRATION_CANNOT_BE_MORE_THAN","OR")+BR);
				eval("document.multiple_consent_form.consent_stage"+index).value="A"
				eval("document.multiple_consent_form.consent_form_stage"+index).value="A"
			}
		}

	}
}



async function show_consent_lookup(target,index)
{
	var viewBy=document.multiple_consent_form.viewBy.value;
	if(viewBy=="header")
	{
		var catalogIndex=Math.floor(parseInt(index)/10);
		eval("document.multiple_consent_form.dupilcate"+catalogIndex).value="false";
	}
	else
	{
		document.multiple_consent_form.dupilcate.value="false";
	}
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=document.multiple_consent_form.localeName.value;
	argumentArray[0]=document.multiple_consent_form.consent_sql.value;
	argumentArray[0]=argumentArray[0].replace('?',"'"+localeName+"'");
	
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	if(target.value=="?")
	{
		argumentArray[5]= "";
	}
	else
	{
		argumentArray[5]=target.value;
	}
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=await CommonLookup(getLabel("Common.Consent.label","COMMON"),argumentArray);
	if(retval !=null && retval != "")
	{
		var ret1=unescape(retval);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.multiple_consent_form.temp_consent_form_id.value=eval("document.multiple_consent_form.consent_form_id"+index).value;
		document.multiple_consent_form.temp_consent_desc.value=eval("document.multiple_consent_form.consent_desc"+index).value;
		document.multiple_consent_form.temp_temp_consent_desc.value=eval("document.multiple_consent_form.temp_consent_desc"+index).value;
		eval("document.multiple_consent_form.consent_form_id"+index).value=arr[0];
		eval("document.multiple_consent_form.consent_desc"+index).value=arr[1];
		eval("document.multiple_consent_form.temp_consent_desc"+index).value=arr[1];
		checkValidate(index,"VR");
	}
}

function before_show_consent_lookup(target,index)
{
	 var tempdesc=eval("document.multiple_consent_form.temp_consent_desc"+index).value
		
	if((target.value != tempdesc) || target.value=="") 
	{
		show_consent_lookup(target,index);
	}
}

async function callConsent(order_id, order_line_num,consent_ref_id,RecordBy,RecordedDate,LastRecordedBy,LastRecordedDate,consent_name,consentid) {	
	if(document.multiple_consent_form.report_type.value=="C" ) // for consent orders
	{
		var bean_id				= "ReprintFormsBean";
 		var bean_name			= "eOR.ReprintFormsBean";
		var report_type			= "C";
 		var dialogHeight		= '37.5';
		var dialogWidth			= '50';
		var dialogTop			= '100';
		var dialogLeft			= '100' ;
		
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var finalString="&bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&consent_ref_id="+consent_ref_id+"&RecordBy="+RecordBy+"&RecordedDate="+RecordedDate+"&LastRecordedBy="+LastRecordedBy+"&LastRecordedDate="+LastRecordedDate+"&consent_name="+consent_name+"&consentid="+consentid+"&function_from=EXISTING_CONSENT_DETAILS"+"&report_type=C";
		var retVals				=  await window.showModalDialog("../../eOR/jsp/ReprintPreviewFrameSet.jsp?"+finalString,arguments,features);
	}
}
function populateLocation(location_type){
	if(location_type.value == "C"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.clinic.label","Common")
	} else if(location_type.value == "W"){
		document.getElementById("id_locn").innerHTML = getLabel("Common.nursingUnit.label","Common")
	} else if(location_type.value == "D"){
		document.getElementById("id_locn").innerHTML = getLabel("eCA.DayCareUnits.label","CA")
	} else if(location_type.value == "E"){
		document.getElementById("id_locn").innerHTML = getLabel("eCA.EmergencyUnits.label","CA")
	} else if(location_type.value == "R"){
		document.getElementById("id_locn").innerHTML = getLabel("eOR.referralunits.label","OR")
	} else {
		document.getElementById("id_locn").innerHTML = getLabel("Common.Location.label","Common")
	}


	var formObj = document.consent_order;
	var localeName=document.consent_order.localeName.value;
	if( location_type.value == "" ) {
		clearList("document")
	}
	var bean_id = document.consent_order.bean_id.value ;

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += location_type.name+"=\""+ location_type.value +"\" " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=ord_cat", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText )


}

async function populateLoaction(target){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	
	
	location_type	  = document.consent_order.location_type.value
	// Decode the value and then pass as a value to the query
	if(location_type!=null && location_type=="C")
	   location_type	= "OP";
	else if(location_type!=null && location_type=="D")
	   location_type	= "DC";
	else if(location_type!=null && location_type=="E")
	   location_type	= "EM";
	else if(location_type!=null && location_type=="W")
	   location_type	= "IP";
 	dataNameArray[0] = "PATIENT_CLASS";
	dataValueArray[0] = location_type;
	dataTypeArray[0] = STRING;
	
	dataNameArray[1] = "FACILITY_ID";
	dataValueArray[1] = document.consent_order.facility_id.value;
	dataTypeArray[1] = STRING;

	dataNameArray[2] = "FACILITY_ID";
	dataValueArray[2] = document.consent_order.facility_id.value;
	dataTypeArray[2] = STRING;  
	var localeName=document.consent_order.localeName.value;
	var sql=document.consent_order.location_sql.value;

	for(var x=0;x<5;x++)
	{
		sql=sql.replace('?',"'"+localeName+"'");
	}
	sql=sql.replace('?',"'"+document.consent_order.practitioner_id.value+"'");
	
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
	/*Ends Here*/

	argumentArray[0]=sql;
	//argumentArray[0]   =document.consent_order.location_sql.value

	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "4,5";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal = await CommonLookup( getLabel("Common.Location.label","Common"),argumentArray );

	if(retVal != null && retVal != ""){
		var ret1=unescape(retVal);
	 	var arr =ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		document.consent_order.locn.value=arr[0];
		target.value = arr[1];
	}else{
		
		target.value=getLabel("Common.all.label","Common");
		document.consent_order.locn.value = "";
	}
}

function addLocationList(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.consent_order.locn.add(element);
}

function clearList( docObj ) {
	var len = eval(docObj+".consent_order.locn.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".consent_order.locn.remove(\"atc_class_l2_code\")") ;
	}
	var tp = getLabel("Common.all.label","Common");
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".consent_order.locn.add(opt)") ;
}


//this fucntion is used to clear the entries of search criteria
function resetValues(){
	document.consent_order.reset();
	document.getElementById("locn").value = '';
	document.getElementById("speciality_code").value='';
	document.getElementById("id_locn").innerHTML = getLabel("Common.patientId.label","Common");
	parent.ConsentOrderBottom.document.location.href="../../eCommon/html/blank.html";

}

function consent(){
	var locn_type = parent.parent.parent.frames[0].document.consent_order.location_type.value
	var locn = parent.parent.parent.frames[0].document.consent_order.locn.value
	var patientId=parent.parent.parent.frames[0].document.consent_order.patientId.value
	var period_from=parent.parent.parent.frames[0].document.consent_order.period_from.value
	var period_to=parent.parent.parent.frames[0].document.consent_order.period_to.value
 qry_string = "../jsp/ConsentOrdersBottom.jsp?location_type="+locn_type+"&locn="+locn+"&patientId="+patientId+"&period_from="+period_from+"&period_to="+period_to;

	var no_of_checked = 0;
	var formObj = parent.ConsentOrdersBottomRight1.document.consent_order_dtl
	//var localeName=document.consent_order.localeName.value;
	var bean_id = formObj.bean_id.value
	var bean_name = formObj.bean_name.value
     for(cnt=0; cnt<formObj.total_recs.value; cnt++){
		val = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+cnt);
		patient_class = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.patient_class"+cnt);
		priority = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.priority"+cnt);
		ord_id = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.ord_id"+cnt);
		ord_typ_code = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.ord_typ_code"+cnt);
  		if(val.checked == true)
			no_of_checked++;
	}

	if(parseInt(no_of_checked) == 0){
		alert(getMessage('CLICK_ANY_ONE','OR'));
		return false
	}
		//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
		var xmlHttpp = new XMLHttpRequest();
		//var xmlDocs = "";
		xmlStr ="<root><SEARCH " ;
		
		xmlStr = "";
		xmlStr ="<root><SEARCH " ;
        xmlStr +=" /></root>" ;
        //xmlDocs.loadXML( xmlStr ) ;
		var xmlDocs = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttpp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=fing_values", false ) ;

		xmlHttpp.send( xmlDocs ) ;
		responseText=xmlHttpp.responseText ;
        var fingurePrnYN = '';
		eval(responseText);
 		if (fingurePrnYN == 'Y') {
		  var oledb_con_string = document.forms[0].oledb_con_string.value;
          if (verifyTheFinger(oledb_con_string)) {
    		eval(responseText);
			eval(formApply( parent.ConsentOrdersBottomRight1.document.consent_order_dtl,OR_CONTROLLER)) ;
			top.frames[1].frames[3].location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			}
		}
		else  // submit directly 
			eval(formApply( parent.ConsentOrdersBottomRight1.document.consent_order_dtl,OR_CONTROLLER)) ;
	 	
		if (top.content && !top.dialogArray.length) {
			
				
			if( invalidCode != "" && invalidCode!=null){ //"OR_STATUS_CHANGED"
				parent.ConsentOrdersBottomRight1.document.getElementById("status"+invalidCode).className="orcancel";
				alert(message,"Common");
				return false;
			}else
				top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		} else {
			/*if( getMessage(message,"OR") != "" && getMessage(message,"OR")!=null)
					message = getMessage(message,"OR");
			else{
				var index =0;
				index = message.lastIndexOf(".");
				message = message.substring(0,index);
			}*/
		
			if(message!="" && message!=null)
    		alert(message);
    		window.close();
			
		}
 		if(result) {
			// added for IN043035 - Start
			if(parent.parent.parent.ConsentOrderTop.document.consent_order.specialty != null) { //added for 43179
				if(parent.parent.parent.ConsentOrderTop.document.consent_order.specialty.value != null) {
					parent.parent.parent.ConsentOrderTop.document.consent_order.specialty.value ="";
				}
			}
			if(parent.parent.parent.ConsentOrderTop.document.consent_order.speciality_code != null) { //added for 43179			
				if(parent.parent.parent.ConsentOrderTop.document.consent_order.speciality_code.value != null) {
					parent.parent.parent.ConsentOrderTop.document.consent_order.speciality_code.value ="";
				}
			}
			// End
			qryString = '&mode=print';
			//callPrinting(qry_string);
			parent.parent.parent.frames[1].location.href=qry_string
 			//onSuccess();
		}/*else{
			alert(message)
		}*/
}

function assignResult(_result, _message, _flag, _code){
	result = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _code ;

}

function onSuccess() {
	
        //qryString = 'mode=print';
        //callPrinting(qry_string);
		parent.parent.parent.frames[1].location.href=qry_string
}

//need to b changed
async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,encounter_id,patient_class,order_type_code,location_type,location_code,priority){
		var dialogTop   = "100";
		var dialogLeft   = "100";
		var dialogHeight= "37.5" ;
		var dialogWidth = "50" ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&order_type_code="+order_type_code+"&location_type="+location_type+"&location_code="+location_code+"&priority="+priority;
		if(colval1=="Refusal") {
			parent.parent.parent.frames[1].location.href = "RefusalOrderFrameset.jsp?"+finalString;
		}
		else 
		{
			var retVals = await window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
		//if(colval1=="Refusal")
		//		parent.parent.parent.frames[1].location.reload();
}

//this is used for patient ID search
async function callPatientSearch(){

	var pat_id =  await PatientSearch();
if(pat_id != null)

	document.getElementById("patientId").value = pat_id;
}



function callReprinting(order_id,patient_class,location_type,location_code) {
	var qryString = "mode=reprint" + "&order_id=" + order_id + "&patient_class=" + patient_class + "&location_type=" + location_type + "&location_code=" + location_code;
	//callPrinting(qryString);
}

function clearConsentChecked(){
	//parent.ConsentOrdersBottomRight1.document.consent_order_dtl.reset()commented for multi consent
	
	 /*Modified by kishore kumar N on 30-Oct-09  for CRF 15741*/
		var qryString = parent.ConsentOrdersBottomRight1.consent_order_dtl.qryString.value
		parent.ConsentOrdersBottomRight1.document.location.href = '../../eOR/jsp/ConsentOrdersBottomRightDtl.jsp?'+qryString;
}


function checkSpl( val ) 
{
	var result = "" ;
	var ch = "" ;

	/*re = /\n/g;
	val = val.replace(re,"\""); */
	
	var re = new RegExp("&","g");
	//re = /&/g;
	val = val.replace(re, "&amp;");

	re.compile("\"","g");
	val = val.replace(re,"&quot;");
	
	re.compile("<", "g");
	//re = /</g;
	val = val.replace(re, "&lt;");
	
	re.compile(">", "g");
	//re = />/g;
	val = val.replace(re, "&gt;");
	/*re = /\"/g;
	val = val.replace(re, "&quot;");*/
	re.compile("'", "g");
	//re = /\'/g;
	val = val.replace(re, "&apos;");	
   return val;	
}

// called on click of the Preview in the Record Consent function in CA
async function previewEditor()
{	

	// Set it in the bean
	var bean_id					= parent.editor_button.document.editorButtonForm.bean_id.value;
	var bean_name				= parent.editor_button.document.editorButtonForm.bean_name.value;
	var consent_form_id			= parent.editor_button.document.editorButtonForm.consent_form_id.value;
	var index					= parent.editor_button.document.editorButtonForm.index.value;
	var task_categ				= parent.editor_button.document.editorButtonForm.task_categ.value;//Chowminya
	
	var count					= "1";
	var patient_name			= parent.consent_details.document.formConsentDetails.patient_name.value 
	var Practioner_name			= parent.consent_details.document.formConsentDetails.Practioner_name.value
	var reln_box				= parent.consent_details.document.formConsentDetails.reln_box.value
	var dat_time				= parent.consent_details.document.formConsentDetails.dat_time.value
	var remarks					= parent.consent_details.document.formConsentDetails.remarks.value
	var practitioner_id			= parent.consent_details.document.formConsentDetails.practitionerId.value
	var new_consent_format_id		= parent.consent_orderable.document.formConsentOrderable.new_consent_format_id.value
	var new_consent_format_label	= parent.consent_orderable.document.formConsentOrderable.new_consent_format_label.value
	var self				= "";

	if(parent.consent_details.document.formConsentDetails.self[0].checked)
		self				= "y";
	else 
		self				= "n";
	
	//IN066781 start			
	if(parent.editor.RTEditor0.document.body != null)
	{
		modifyEmptyTD(parent.editor.RTEditor0.document.body);
		if(parent.editor.RTEditor0.document.body.firstChild.nodeName == 'ADDRESS')
		{
			while(parent.editor.RTEditor0.document.body.firstChild.innerHTML == '')
			{
				parent.editor.RTEditor0.document.body.removeChild(parent.editor.RTEditor0.document.body.firstChild);
			}
		}
	}
	//IN066781 ends
	//ML-MMOH-SCF-2436 Start.
	var  consentValue=(parent.editor.RTEditor0.document.body.innerHTML).replace("<ADDRESS>",'');
		consentValue=consentValue.replace("<SCRIPT language=javascript src=",'');
		consentValue=consentValue.replace("../../eCommon/js/ValidateControl.js",'');
		consentValue=consentValue.replace("></SCRIPT>",'');
		consentValue=consentValue.replace("</ADDRESS>",'');
		consentValue=consentValue.replace("\"",'').replace("\"",'');
		consentValue=consentValue.replace(/^\s+|\s+$/g, '');
		
	if(consentValue==''){		
		alert(getMessage("CONSENTS_FORM_LOADING","OR"));
		return false;
	}
	//ML-MMOH-SCF-2436 End.
	//var xmlDoc 				= new ActiveXObject( "Microsoft.XMLDom" ) ;
	//var xmlHttp 			= new ActiveXObject( "Microsoft.XMLHTTP" ) ;
	var xmlHttp = new XMLHttpRequest();
	//var xmlDoc = "";
	xmlStr					= "<root><SEARCH " ;
	xmlStr					+= "bean_id=\"" +bean_id +"\" ";
	xmlStr					+= "bean_name=\"" +bean_name +"\" ";
	xmlStr					+= "index=\"" +index +"\" ";
	xmlStr					+= "consent_form_id0=\"" +consent_form_id +"\" ";
	xmlStr					+= "consent_form_text0=\""+checkSpl(parent.editor.RTEditor0.document.body.innerHTML) +"\" ";
	xmlStr					+= "patient_name=\""+encodeURIComponent(patient_name) +"\" "; 
//	xmlStr					+= "practitioner_name=\""+Practioner_name +"\" "; // Commented for IN032140 
	xmlStr					+= "practitioner_name=\""+checkSpl(Practioner_name) +"\" "; // IN032140 ,Added Special character check to Prac Name.
	xmlStr					+= "practitioner_id=\""+practitioner_id +"\" "; 
	xmlStr					+= "reln_box=\""+reln_box+"\" "; 
	xmlStr					+= "dat_time=\""+dat_time+"\" "; 
	xmlStr					+= "remarks=\""+remarks +"\" "; 
	xmlStr					+= "self=\""+self+"\" "; 	
	xmlStr					+= "count=\"" +count +"\" ";
	xmlStr					+= "task_categ=\"" +task_categ +"\" ";//Chowminya
	xmlStr 					+=" /></root>" ;
	var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "ConsentNotesValidate.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval( responseText ) ;

	
	var fields =  parent.consent_details.document.formConsentDetails.patient_name
	var names =  getLabel("Common.name.label","Common");
	if(checkFieldLocal( fields, names))
	{
		fields =  parent.consent_details.document.formConsentDetails.dat_time
		names  =  getLabel("eOR.ConsentedDateandTime.label","OR");	
		if(checkFieldLocal( fields, names))
		{
			fields =  parent.consent_details.document.formConsentDetails.Practioner_name
			names =   getLabel("eOR.ObtainedByPractitioner.label","OR");
			if(checkFieldLocal( fields, names))
			{
				await openPreview(index, consent_form_id, new_consent_format_id, new_consent_format_label,open_preview,task_categ);//IN27198
				window.parent.close();
			}
		}
	}
}

function checkFieldLocal( field, name ) {
    var errors = '' ;
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
		errors = errors + getMessage("CAN_NOT_BE_BLANK","Common");
		errors = errors.replace('$',name);
        alert(errors) ;
        field.focus();
        return false ;
    }
}
function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".period_from")
	var toDate = eval("document."+from+".period_to")
	var formObj = parent.ConsentOrderTop.document.consent_order;

	//if(chckDate2(obj)){ // removed on 16/02/2007 while doing thai date validations
		if(validDateObj(obj,"DMY",localeName)){// function in DateUtils.js added for thai date validations
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js		
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	}else
	{
		parent.ConsentOrderTop.document.consent_order.period_to.value=parent.ConsentOrderTop.document.consent_order.temp_last_week_date.value;
	}
}
function populateValues(){
	
	if (top.content) {
	top.content.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+'';
	}
	var formObj = parent.ConsentOrderTop.document.consent_order;
	var fromDate = formObj.period_from;
	var toDate = formObj.period_to;
	
	if(!trimCheck(fromDate.value)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK","SM"));
		parent.ConsentOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(toDate.value)){
		alert(getMessage("TO_DT_NOT_BLANK","SM"));
		parent.ConsentOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false
	}
	//if(doDateCheckOR(fromDate,toDate) == 1) {// this function is available in eOR/js/orCommonFunctions.js// removed on 16/02/2007 while doing thai date validations
		if(!isAfter(toDate.value,fromDate.value,"DMY",formObj.localeName.value)){//this function is available in eCommon/js/DateUtils.js
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		parent.ConsentOrderBottom.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

	/*
		Added by kishore kumar N on 02-05-2010,
		Validating date for better tuning.
	*/

	var ptID = formObj.patientId.value;
	var locale = formObj.localeName.value;

	if(ptID == '' && !dateRangeValidation(fromDate, toDate, locale, '7', 'DMY'))
	{
		parent.ConsentOrderBottom.location.href = "../../eCommon/html/blank.html";
		alert(getMessage("VALIDATE_DATE_ON_SEARCH", "OR"))
	}
	else
	{
		document.consent_order.search_btn.disabled = true;
		document.consent_order.action="ConsentOrdersBottom.jsp";
		document.consent_order.target="ConsentOrderBottom";
		document.consent_order.submit();
	}
	/*
		ends here.
	*/
}
//this one need to b changed 
async function showPreview(index,consent_form_id, new_consent_format_id, new_consent_format_label)
{
		details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
  		details_link.style.visibility = "visible";
		var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
		val.checked=true;
		val.value="y"; //set it so that it can be inserted inthe table.
		
		var bean_id				= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_id.value;
 		var bean_name			= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_name.value;
	
 		var dialogHeight		= '48.75';
		var dialogWidth			= '65';
		var dialogTop			= '30';
		var dialogLeft			= '100' ;
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  await window.showModalDialog("../../eOR/jsp/ConsentPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+escape(consent_form_id)+"&new_consent_format_id="+escape(new_consent_format_id)+"&new_consent_format_label="+escape(new_consent_format_label),arguments,features);  		
}

function chckDate(Object2,focusflag)
{
	var localeName = parent.ConsentOrderTop.document.consent_order.localeName.value
if(!validDateObj(Object2,"DMY",localeName))
	{
	 parent.ConsentOrderTop.document.consent_order.period_from.value= parent.ConsentOrderTop.document.consent_order.temp_curr_week_date.value;
	}
}

var window_obj;
var win_close = 0;
var ret_inter;

function displayDetails(i,open_ed)		 //On using the checkbox in the Record consent function in CA
{  
	if (top.content)
	{
		top.content.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
	var pract_id=parent.ConsentOrdersBottomRight1.document.consent_order_dtl.practitioner_id.value;
	var cnt = i;
	var val = eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+cnt);
	var details_link = document.getElementById('details'+cnt);
	flagtest = "checked";

	if(val.checked == false)
	{
		clearConsents(i,'chckbox')
		if(flagtest=="notchecked")
		return false;
	}

	if(!eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+cnt) || eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+cnt).value == "")
	{
		alert(getMessage("ATLEAST_ONE_CONSENT_FORM_SHOULD_BE_SELECTED_OR_DEFINED","OR"));
		val.checked = false;
		return false;
	}

	if(!chkEligible(eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+cnt),cnt))
	{
		val.checked = false;
		if(!open_ed)
			return false;
		else
			open_ed = false;
	}
	
	if(!val.checked && open_ed) 
		val.checked = true;
	
	val.checked = true;
	
	if(val.checked == true)
	{
		val.checked = false; //remove the check , only if he clicks the preview, make this as check
		details_link.style.visibility = "hidden";  // display will be done in showPreview
		var dialogHeight ='30'
		var dialogWidth = '65' ;
		var dialogTop	= '129';
		var dialogLeft = '11';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';
		var arguments = "";
		var bean_id= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_id.value
		var bean_name= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_name.value;
		var patient_name=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.patient_name"+cnt);
		var pat_name_def=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.patient_name"+cnt);
		var order_pract_name=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.order_pract_name"+cnt);
		var practitioner_name= document.consent_order_dtl.practitioner_name.value;
		var curr_sys_date = document.consent_order_dtl.curr_sys_date.value;
		var patientdetails= eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.patientdetails"+cnt).value;
		var ord_id=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.ord_id"+cnt).value;
		var patient_id=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.pat_id"+cnt).value;
		var encounter_id=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.encount_id"+cnt).value;
		var consent_form_id= "";

		if(eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+cnt))
			consent_form_id=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+cnt).value;
		var ord_line_num=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.ord_line_num"+cnt).value;
		var index=i;
		//window_obj = window.open("../../eOR/jsp/ConsentDetailsFrameset.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&practitioner_name="+encodeURIComponent(practitioner_name,'UTF-8')+"&patient_name="+encodeURIComponent(patient_name.value,'UTF-8')+"&order_pract_name="+escape(order_pract_name.value)+"&curr_sys_date="+escape(curr_sys_date)+"&patientdetails="+patientdetails+"&ord_id="+ord_id+"&flag="+flag+"&pract_id="+pract_id+"&index="+index+"&pat_name_def="+pat_name_def.value+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&consent_frm_id="+consent_form_id+"&ord_line_num="+ord_line_num,"modify_editor"+index,"height=580,width=775,top=70,left=100,status=no,toolbar=no,menubar=no,location=no");//IN32036 //Commentted -[IN036055]
		window_obj = window.open("../../eOR/jsp/ConsentDetailsFrameset.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&practitioner_name="+encodeURIComponent(practitioner_name,'UTF-8')+"&curr_sys_date="+escape(curr_sys_date)+"&ord_id="+escape(ord_id)+"&pract_id="+pract_id+"&index="+index+"&patient_id="+escape(patient_id)+"&encounter_id="+escape(encounter_id)+"&consent_frm_id="+escape(consent_form_id)+"&ord_line_num="+ord_line_num+"&patientdetails="+encodeURIComponent(patientdetails,'UTF-8')+"&patient_name="+encodeURIComponent(patient_name.value,'UTF-8')+"&pat_name_def="+escape(pat_name_def.value)+"&order_pract_name="+escape(order_pract_name.value)+"&flag="+flag,"modify_editor"+index,"height=580,width=775,top=70,left=100,status=no,toolbar=no,menubar=no,location=no");//IN32036 //--[IN036055] //IN037395 Changed the order of param
		/*if(window_obj.onblur)
			window.focus();*/
		win_close	= 0; 
		ret_inter	= setInterval("showConsentDtls("+i+");", 500);		
	}
	else if(val.checked == false)
	{
		clearConsents(i,'checkbox')
	} 
}

function showConsentDtls(index)	   //Gets the Consent form id, after the 500 milliseconds
{
	if(window_obj.closed && win_close == 0)
	{
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		var bean_id = "Or_ConsentOrders";
		var consent_id = "";
		var action = "SHOW_DETAILS";
		xmlStr	= "<root><SEARCH " ;
		xmlStr	+= "index=\"" +index +"\" ";
		xmlStr	+= "action=\"" +action +"\" ";
		xmlStr	+=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&validate=GET_CONSENT_FORM_ID", false ) ;
		xmlHttp.send(xmlDoc);
		//alert(xmlHttp.responseText);
		eval(xmlHttp.responseText );

		if(consent_id !=null && consent_id !="" && consent_id !="null")
		{
			if( !eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+index) || (eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.consent_form_id"+index).value == consent_id))
			{
				var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
				var details_link=document.getElementById('details'+index);
				//alert(details_link);
				val.checked = true;
				val.value = 'y';
				details_link.style.visibility = "visible";
			} 
		}
		clearInterval(ret_inter);
	}
	else if(window_obj.closed && win_close == 1)
		clearInterval(ret_inter);
}

async function openPreview(index, consent_form_id, new_consent_format_id, new_consent_format_label,open_preview,task_categ)//Chowminya
{

	if(consent_form_id!=null && consent_form_id!="" && index!=null && index!="") 
	{
		win_close = 1;
		await showPreview(index, consent_form_id, new_consent_format_id, new_consent_format_label,open_preview,task_categ)//Chowminya
	}
}
//--[IN034904] - Passing P/m consentLinenum
async function callMenuFunctions(colval1,colval,orderId,sex,patient_id,encounter_id,patient_class,order_type_code,location_type,location_code,priority,ord_line_num,consentLinenum){
		var dialogHeight ='85vh' ;
		var dialogWidth = '60vw' ;
		var dialogTop	= '100';
		var dialogLeft = '100' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=no; status=no';

		var arguments = "";
		//var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&order_type_code="+order_type_code+"&location_type="+location_type+"&location_code="+location_code+"&priority="+priority+"&ord_line_num="+ord_line_num;
		var finalString	= "colval1="+colval1+ "&colval=" +encodeURIComponent(unescape(colval))+"&orderId="+ orderId+"&sex="+ sex+"&patient_id="+ patient_id+"&encounter_id="+encounter_id+"&patient_class="+patient_class+"&order_type_code="+order_type_code+"&location_type="+location_type+"&location_code="+location_code+"&priority="+priority+"&ord_line_num="+ord_line_num+"&consentLinenum="+consentLinenum;
		if(colval1=="Refusal") 
		{
			parent.parent.parent.frames[1].location.href = "RefusalOrderFrameset.jsp?"+finalString;
		}
		else 
		{
			var retVals = await top.window.showModalDialog("../../eOR/jsp/ExistingOrderTasks.jsp?"+finalString,arguments,features);
		}
		//if(colval1=="Refusal")
		//		parent.parent.parent.frames[1].location.reload();
}

async function showPreview(index,consent_form_id, new_consent_format_id, new_consent_format_label,open_preview,task_categ)//Chowminya
{	

		var bean_id				= "";
		var bean_name			= "";
	
		if(parent.ConsentOrdersBottomRight1)
		{
			details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
			details_link.style.visibility = "visible";
			var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
			val.checked=true;
			val.value="y"; //set it so that it can be inserted inthe table.			
			var bean_id				= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_id.value;
			var bean_name			= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_name.value;
		}
		else
		{
			//IN27198,starts
			//bean_id			= document.link_existing_consent.bean_id.value;
 			//bean_name			= document.link_existing_consent.bean_name.value; 
			bean_id	 = "Or_ConsentOrders" ;
			bean_name = "eOR.ConsentOrders";
			//IN27198,ends
		}
				
		if(!open_preview) // in order to not to show the preview dialog onclick of enabled gif
		{
			return false;
		}
 		var dialogHeight		= '90vh';
		var dialogWidth			= '85vw';
		var dialogTop			= '30';
		var dialogLeft			= '100' ;
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  await window.showModalDialog("../../eOR/jsp/ConsentPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+escape(consent_form_id)+"&new_consent_format_id="+escape(new_consent_format_id)+"&new_consent_format_label="+escape(new_consent_format_label),arguments,features); 		  
}

function focusPreviewFrameset(){
	parent.preview.focus();
	//document.editor_preview.focus();
}
async function showConsentReview(consent_form_id,consent_form_label,order_id,order_line_num,consent_ref_id)
{
		var bean_id				= "";
		var bean_name			= "";
		if(parent.ConsentOrdersBottomRight1){
			bean_id		= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_id.value;
			bean_name	= parent.ConsentOrdersBottomRight1.document.consent_order_dtl.bean_name.value;
		}else{
			bean_id		= document.link_existing_consent.bean_id.value;  
			bean_name	= document.link_existing_consent.bean_name.value;
		}	

 		var dialogHeight		= '94vh';
		var dialogWidth			= '60vw';
		var dialogTop			= '0px';
		var dialogRight			= '70vh' ;
 		var title				= ''
		var	arguments			= "";	
		var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogRight:'+dialogRight+';dialogTitle:'+title+'; scroll=yes; status=no';
		var retVals				=  await top.window.showModalDialog("../../eOR/jsp/ConsentPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&consent_form_id="+escape(consent_form_id)+"&consent_form_label="+escape(consent_form_label)+"&order_id="+order_id+"&order_line_num="+order_line_num+"&consent_ref_id="+consent_ref_id,arguments,features);
 		
}
var consented_array = new Array();

function chkConsented(obj,index){
	
	var recd_consent_id = eval("document.consent_order_dtl.recd_consent_id"+index).value ;
	if(recd_consent_id.indexOf("~")){
		var consented_array = recd_consent_id.split("~");
		for(var i=0;i<consented_array.length;i++){
			if(obj.value !="" && obj.value == consented_array[i]){
				recflag="recorded";
				//alert("APP-OR0280 Consent Form Selected is Already Recorded");
				alert(getMessage("CONSENT_FORM_SELECTED_IS_ALREADY_RECORDED","OR"));
				//obj.value = "";
				//obj.selectedIndex		= 0;
				defaultSelect(index);
				return false;
			}
			else
			{
				recflag="notrecorded";
			}
		}
	}
}
function chkEligible(obj,index){
	if( eval("document.consent_order_dtl.noteligible_consent_id"+index)){
		var noteligible_consent_id = eval("document.consent_order_dtl.noteligible_consent_id"+index).value ;
		if(noteligible_consent_id.indexOf("~") != -1){
			var noteligible_array = noteligible_consent_id.split("~");
			for(var i=0;i<noteligible_array.length;i++){
				if(obj.value == noteligible_array[i]){
					
					alert(getMessage("YOU_ARE_NOT_ELIGIBLE_TO_RECORD_THIS_CONSENT","OR"));
					defaultSelect(index);
					return false;

				}
			}
		}
	}

	return true;
}
function defaultSelect(index){
	foundflag="notfound";
	if(document.getElementById('consent_form_id'+index) && document.getElementById('consent_form_id'+index).type == "select-one"){
		if(document.forms[0].name == "consent_order_dtl"){
			for(var j=0; j<document.getElementById('consent_form_id'+index).options.length; j++)
			{
				if(document.getElementById('consent_form_id'+index).options[j].style.backgroundColor == "" && document.getElementById('consent_form_id'+index).options[j].value!= ""){
					document.getElementById('consent_form_id'+index).options[j].selected = true;
					foundflag="found";
					break;
				}
			}
			if(foundflag=="notfound")
			{
					document.getElementById('consent_form_id'+index).options[0].selected = true;
			}
		}else{
			for(var j=0; j<document.getElementById('consent_form_id'+index).options.length; j++)
			{
				if(document.getElementById('consent_form_id'+index).options[j].style.backgroundColor != "" ){
					document.getElementById('consent_form_id'+index).options[j].selected = true;
					break;
				}else{
					if(document.getElementById('consent_form_id'+index).options[j].selected ){
						document.getElementById('consent_form_id'+index).options[j].selected = true;
						break;
					}else if( j == (document.getElementById('consent_form_id'+index).options.length)-1){
						document.getElementById('consent_form_id'+index).selectedIndex = 1;
					}

				}
			}	

		}
	}
}
function defaultChk(total_recs){

	total_recs = parseInt(eval(total_recs));
	var chk_bool = true;

	for(var i=0;i<total_recs;i++){
		if(eval("document.multiple_consent_form.consent_chk"+i).checked){
			chk_bool = false;
			break;
		}else
			chk_bool = true;
	}

	if(chk_bool){
		for(var i=0;i<total_recs;i++){
			if(eval("document.multiple_consent_form.form_dflt_chk"+i).value == 'Y'){
				eval("document.multiple_consent_form.consent_chk"+i).checked = true;
			}
		}

	}



}
async function linkConsents(patient_id, encounter_id, facility_id, index){

	//var dialogHeight		= '19';
	var dialogHeight		= '27';
	var dialogWidth			= '35';
	var dialogTop			= '250';//267
	var dialogLeft			= '225' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=no; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	var consent_form_id		=  "";
	var new_consent_format_label =  "";
	var buttn_label = "Orders";
	var link_ref_no = "";
	var link_ref	= "";
	var link_ref_det	= "";
	var consent_form_id	= "";
	var total_recs  = 0;
	if(document.forms[0].name == "consent_order_dtl"){
		buttn_label = "Consent";
		bean_id		= document.consent_order_dtl.bean_id.value;
		bean_name	= document.consent_order_dtl.bean_name.value;
		total_recs	= document.consent_order_dtl.total_recs.value;
		link_ref	= eval("document.consent_order_dtl.link_ref"+index).value;
		link_ref_no	= eval("document.consent_order_dtl.link_ref_no"+index).value;
		link_ref_det	= eval("document.consent_order_dtl.link_ref_det"+index).value;
		if(eval("document.consent_order_dtl.consent_form_id"+index))
		consent_form_id	= eval("document.consent_order_dtl.consent_form_id"+index).value;
	}
	
	var dflt_cnt =0;
	var link_current = "";
	var str= "";
	for(var i =0;i<total_recs;i++){
		
		if(patient_id == eval("document.consent_order_dtl.pat_id"+i).value && eval("document.consent_order_dtl.consent_form_id"+i) && consent_form_id == eval("document.consent_order_dtl.consent_form_id"+i).value  && eval("document.consent_order_dtl.link_ref_no"+i).value == "" && index != i){
			if(eval("document.consent_order_dtl.chk"+i).checked){
				str += (i+1)+"¶"+eval("document.consent_order_dtl.ord_catalog_desc"+i).value+"¶"+eval("document.consent_order_dtl.consent_form_id"+i).value+"¶"+"¥";
				dflt_cnt++;
			}
		}
	}
	
	if(dflt_cnt >0 && link_ref_no =="")
		link_current = "YES";
	else
		link_current = "NO";

		
	var retVal				=  await window.showModalDialog("../../eOR/jsp/LinkConsent.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&consent_form_id="+consent_form_id+"&link_current="+link_current+"&link_ref="+link_ref+"&link_ref_no="+link_ref_no+"&link_ref_det="+link_ref_det+"&current_link="+str,arguments,features);
	
	if(retVal != null && retVal != undefined){
		
		if (retVal[0] != "")
		{
		
			eval("document.consent_order_dtl.link_ref_no"+index).value = retVal[0];       
			eval("document.consent_order_dtl.link_ref"+index).value	 = retVal[1];      
			
			if(retVal[1] == 'E'){
				eval("document.consent_order_dtl.link_ref_det"+index).value = retVal[2];
			}else
				eval("document.consent_order_dtl.link_ref_det"+index).value = "";
			details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
			details_link.style.visibility = "visible";
			var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
			val.disabled=true;
			val.checked=true;
			val.value="y"; //set it so that it can be inserted inthe table.
			if (retVal[1] == 'C')
			{
				eval("document.consent_order_dtl.link_consent"+index).title = "Linked with Current Consent Srl. No."+retVal[0];

				details_link.href = "javascript:showPreview('"+(eval(retVal[0])-1)+"','"+eval("document.consent_order_dtl.consent_form_id"+(eval(retVal[0])-1)).value+"', '', '',true)" ;
				
			}else{
				eval("document.consent_order_dtl.link_consent"+index).title = "Linked with Existing Consent Ref. No."+retVal[0];
				
				var exs_ref = retVal[2].split("~");
				details_link.href = "javascript:showConsentReview('"+eval("document.consent_order_dtl.consent_form_id"+index).value+"','','"+exs_ref[0]+"', '"+exs_ref[1]+"', '"+eval("document.consent_order_dtl.link_ref_no"+index).value+"')" ;
				
			}
			
		}else{
			details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
			details_link.style.visibility = "hidden";
			details_link.href = "javascript:displayDetails("+index+",false)";
			var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
			val.disabled=false;
			val.checked=false;
			val.value=""; //set it so that it can be inserted inthe table.
			eval("document.consent_order_dtl.link_consent"+index).title = "Link Consent";

		}
		
	}

}
function linkConsent(obj){
	document.getElementById("encounter_header").style.visibility = "hidden";
	if(obj == "Existing"){
		document.getElementById("encounter_link").style.visibility = "visible";
		callExistingConsent();
		//existingConsentList.document.location.href = "../../eCommon/html/blank.html";
	}else{
		document.getElementById("encounter_link").style.visibility = "hidden";
		if(document.LinkConsentForm.qry_string.value == "")
			existingConsentList.document.location.href = "../../eCommon/html/blank.html";
		else{
			document.getElementById("encounter_header").style.visibility = "visible";
			existingConsentList.document.location.href = document.LinkConsentForm.qry_string.value;
		}
	}

	
}
function callExistingConsent(){

	var patient_id = document.LinkConsentForm.patient_id.value;
	var encounter_id = "";
	if( document.LinkConsentForm.encounter.value == "C" )
		encounter_id = document.LinkConsentForm.encounter_id.value;
	else	
		encounter_id = "";	// to include consents of all encounters for the patient
	var facility_id = document.LinkConsentForm.facility_id.value;
	var consent_form_id = document.LinkConsentForm.consent_form_id.value;
	var period_from = document.LinkConsentForm.period_from.value;
	var period_to = document.LinkConsentForm.period_to.value;
	var link_ref_no = document.LinkConsentForm.link_ref_no.value;
	var link_ref_det = document.LinkConsentForm.link_ref_det.value;
	
	if(!trimCheck(period_from)){
		alert(getMessage("FROM_DATE_CANNOT_BE_BLANK"));
		existingConsentList.document.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(!trimCheck(period_to)){
		alert(getMessage("TO_DT_NOT_BLANK"));
		existingConsentList.document.location.href = "../../eCommon/html/blank.html"
		return false
	}

	if(doDateCheckOR(document.LinkConsentForm.period_from,document.LinkConsentForm.period_to) == 1) {
		alert(getMessage("TO_DT_GR_EQ_FM_DT"));
		existingConsentList.document.location.href = "../../eCommon/html/blank.html"
		return false ;
	}

    document.getElementById("encounter_header").style.visibility = "visible";
	
	existingConsentList.document.location.href = "../../eOR/jsp/LinkExistingConsent.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&consent_form_id="+consent_form_id+"&period_from="+period_from+"&period_to="+period_to+"&link_ref_no="+link_ref_no+"&link_ref_det="+link_ref_det;

}
function chkSingleConsent(consent_ref_no,order_id,order_line_num,index){

	var total_recs = document.link_existing_consent.total_recs.value; 
	document.link_existing_consent.link_ref_no.value = consent_ref_no;
	document.link_existing_consent.link_ref_det.value = order_id+"~"+order_line_num+"~";
	
	for(var i=0;i<total_recs;i++){
		if(eval("document.link_existing_consent.chk"+i).checked && i!=index)
			eval("document.link_existing_consent.chk"+i).checked = false;
	}

}
function closeWindow(){
	var retVal	 = new Array;
	var link_ref = "";
	if(existingConsentList.document.link_existing_consent){
		retVal[0]	 = existingConsentList.document.link_existing_consent.link_ref_no.value;
		if(document.LinkConsentForm.link_ref[1].checked)
			retVal[2] = existingConsentList.document.link_existing_consent.link_ref_det.value;
		else
			retVal[2] = "";
	}else{
		retVal[0]	 = "";
		retVal[2]	 = "";
	}
	if(document.LinkConsentForm.link_ref[0].checked)
		link_ref = document.LinkConsentForm.link_ref[0].value
	else
		link_ref = document.LinkConsentForm.link_ref[1].value
	
	retVal[1]	 = link_ref;
	
	var confirm_val = false;
	if(retVal[0] == "")
		var confirm_val = window.confirm("APP-OR0280 You Haven't Selected Any Consent to be Linked");
	else
		confirm_val = true;

	if (confirm_val)
	{
		//window.returnValue = retVal ;
		//window.close()
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = retVal;
		const dialogTag = parent.parent.document.getElementById('dialog_tag');    
		dialogTag.close();
	}	
}

var open_preview = true;
async function storeEditor(){
	open_preview = false;
	await previewEditor();

}
function clearValues(){

	if(existingConsentList.document.link_existing_consent){
		var total_recs = existingConsentList.document.link_existing_consent.total_recs.value; 
		existingConsentList.document.link_existing_consent.link_ref_no.value = "";
		for(var i=0;i<total_recs;i++){
			//if(eval("document.link_existing_consent.chk"+i).checked && i!=index)
				eval("existingConsentList.document.link_existing_consent.chk"+i).checked = false;
		}
	}

}
function callreset(){
	document.LinkConsentForm.reset();
	
	if(existingConsentList.document.link_existing_consent)
		existingConsentList.document.link_existing_consent.reset();
	
}
function showLinkConsent(patient_id,consent_form_id,index){
	var total_recs = 0;
	total_recs = document.consent_order_dtl.total_recs.value;
	for(var i =0;i<total_recs;i++){
		if(patient_id == eval("document.consent_order_dtl.pat_id"+i).value && consent_form_id == eval("document.consent_order_dtl.consent_form_id"+i).value && index != i){
				
		}
	}

}

function clearConsents(index,from)
{
	var formObj = parent.ConsentOrdersBottomRight1.document.consent_order_dtl
	var bean_id = formObj.bean_id.value
	var bean_name = formObj.bean_name.value
	var clear_link = false;
	
	if(document.getElementById('details'+index).style.visibility == 'visible')
	{
		if(from=="checkbox")
		{
			validate = "CLEAR_CONSENT";
			eval("formObj.details"+index).style.visibility = 'hidden'
			eval("formObj.chk"+index).checked=false;
			eval("formObj.chk"+index).value=""; 
			//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			var xmlHttpp = new XMLHttpRequest();
			//var xmlDocs = "";
			xmlStr	  ="<root><SEARCH " ;
			xmlStr	 += "index=\"" +index +"\" ";
			xmlStr	 += "from=\"" +from +"\" ";
			//xmlStr	 += "action=\"\" ";
			xmlStr 	 += " /></root>" ;
			//xmlDocs.loadXML( xmlStr ) ;
			var xmlDocs = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttpp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;
			xmlHttpp.send( xmlDocs ) ;
			responseText=xmlHttpp.responseText ;
			eval(responseText);
		}
		else
		{
			for(cnt=0; cnt<formObj.total_recs.value; cnt++)
			{
				if ( eval("document.consent_order_dtl.pat_id"+index).value == eval("document.consent_order_dtl.pat_id"+cnt).value && eval("formObj.link_ref_no"+cnt))
				{
					if(index == eval(eval("formObj.link_ref_no"+cnt).value)-1 && cnt != index)
					{
						clear_link = true;
						break;
					}
				}
			}

			var confirm_win;

			if(from != "Text")
			{
				if(clear_link)
					confirm_win = window.confirm("APP-OR0288 Changing the Consent Form will Clear the Linked Consents Too"); 
				else
					confirm_win = window.confirm("APP-OR0287 Changing the Consent Form will Clear the Existing Content ");
			}
			else
				confirm_win = true;

			if(confirm_win)
			{
				if(clear_link)
				{				
					for(cnt=0; cnt<formObj.total_recs.value; cnt++)
					{
						if ( eval("document.consent_order_dtl.pat_id"+index).value == eval("document.consent_order_dtl.pat_id"+cnt).value && eval("formObj.link_ref_no"+cnt) && eval("formObj.link_ref_no"+cnt).value != "")
						{
							//var link_form_id = eval("formObj.consent_form_id"+cnt).value;
							if(index == eval(eval("formObj.link_ref_no"+cnt).value)-1 &&  cnt != index)
							{
								eval("formObj.details"+cnt).style.visibility = "hidden";
								eval("formObj.chk"+cnt).checked = false;
								eval("formObj.chk"+cnt).disabled = false;
								eval("formObj.chk"+cnt).value=""; 
								eval("formObj.link_ref"+cnt).value=""; 
								eval("formObj.link_ref_no"+cnt).value=""; 
								eval("formObj.link_ref_det"+cnt).value=""; 
							}
						}
					}
				}	

				validate = "CLEAR_CONSENT";
				eval("formObj.details"+index).style.visibility = 'hidden'
				eval("formObj.chk"+index).checked=false;
				eval("formObj.chk"+index).value=""; 
			}
			else
			{
				validate = "GET_CONSENT_FORM_ID";
				eval("formObj.details"+index).style.visibility = 'visible'
				eval("formObj.chk"+index).checked=true;
				eval("formObj.chk"+index).value="y"; 
			}	

			//var xmlDocs = new ActiveXObject( "Microsoft.XMLDom" ) ;
			//var xmlHttpp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			var xmlHttpp = new XMLHttpRequest();
			//var xmlDocs = "";
			xmlStr	  ="<root><SEARCH " ;
			xmlStr	 += "index=\"" +index +"\" ";
			xmlStr	 += "from=\"" +from +"\" ";
			//xmlStr	 += "action=\"\" ";
			xmlStr 	 += " /></root>" ;
			//xmlDocs.loadXML( xmlStr ) ;
			var xmlDocs = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttpp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&validate="+validate, false ) ;
			xmlHttpp.send( xmlDocs ) ;
			responseText=xmlHttpp.responseText ;
			eval(responseText);
		}
	}
}

function setConsentId(consent_form_id, index){

	
	if(document.getElementById('consent_form_id'+index) && document.getElementById('consent_form_id'+index).type == "select-one"){
		for(var j=0; j<document.getElementById('consent_form_id'+index).options.length; j++)
		{
			if(document.getElementById('consent_form_id'+index).options[j].value == consent_form_id){
				document.getElementById('consent_form_id'+index).options[j].selected = true;
				break;
			}
		}
	}

}

function callDummy(i,from)
{
	
	var cnt= i;
	var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+cnt);
	val.value = 'n';
	var details_link=eval("document.getElementById('details')"+cnt);
	details_link.style.visibility = "hidden";
	flagtest="notchecked";
	return false;
}
function noPermission()
{
	alert(getMessage("YOU_ARE_NOT_ELIGIBLE_TO_RECORD_THIS_CONSENT","OR"))
		//return false;
}
function noPermission1(i)
{
	eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+i).checked=false;
	alert(getMessage("YOU_ARE_NOT_ELIGIBLE_TO_RECORD_THIS_CONSENT","OR"));
	
}
function reccheck(obj,index)
{
	
	var co_bo_cnt=eval("document.consent_order_dtl.con_bo_cnt"+index).value ;
	var co_br_cnt=eval("document.consent_order_dtl.con_br_cnt"+index).value ;
	var co_rbo_cnt=eval("document.consent_order_dtl.con_rbo_cnt"+index).value ;
	var co_rbr_cnt=eval("document.consent_order_dtl.con_rbr_cnt"+index).value ;
	var co_id=eval("document.consent_order_dtl.con_id"+index).value ;
	var co_stage=eval("document.consent_order_dtl.con_stage"+index).value ;
	var recd_consent_id = eval("document.consent_order_dtl.recd_consent_id"+index).value ;
	
if(recflag=="notrecorded")
{
	if(co_id.indexOf("~"))
		{
			var co_id_array = co_id.split("~");
			if(co_stage.indexOf("~"))
			var co_stage_array = co_stage.split("~");
			for(var i=0;i<co_id_array.length;i++)
			{	
				if(obj.value == co_id_array[i])
				{
					if(co_stage_array[i]=='A')
					{
						if(co_bo_cnt==co_rbo_cnt)
						{
							alert(getMessage("CONSENT_FOR_BEFORE_RELEASE","OR"));
							//brflag="1";
							defaultSelect(index);
							return false;
						}
					}else if(co_stage_array[i]=='R')
					{
						if(co_br_cnt==co_rbr_cnt)
						{
							alert(getMessage("CONSENT_FOR_BEFORE_REGISTERATION","OR"));
							defaultSelect(index);
							return false;
						}
					}
				}
			}
		}
	}
}

async function show_consent_window(target,index,order_id,order_line_num)
{
	var retVal =    new String();
	//var dialogHeight= "27.22" ;
	var dialogHeight= "900vh" ;
	var dialogWidth = "800vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	retVal = await window.showModalDialog("ExistingOrderMultipleConsentFrames.jsp?order_id="+order_id+"&order_line_num="+order_line_num,arguments,features);

	if(retVal != null)
	{
		var arr = new Array();
		retcode = retVal.split("&");
		eval("document.multiple_consent_form.consent_form_id"+index).value=retcode[0];
		eval("document.multiple_consent_form.consent_desc"+index).value=retcode[1];
		eval("document.multiple_consent_form.temp_consent_desc"+index).value=retcode[1];
		checkValidate(index,"VR");
		
	}
}

async function before_show_consent_window(target,index,order_id,order_line_num)
{
	if(target.value!="")
	{
		var retVal =    new String();
		var dialogHeight= "900vh" ;
		var dialogWidth = "800vw" ;
		var status = "no";
		var arguments = "";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		var consent_desc="document.multiple_consent_form.consent_desc"+index.value;
		retVal = await window.showModalDialog("ExistingOrderMultipleConsentFrames.jsp?order_id="+order_id+"&order_line_num="+order_line_num+"&consent_desc="+consent_desc,arguments,features);

		if(retVal != null)
		{
			var arr = new Array();
			retcode = retVal.split("&");
			eval("document.multiple_consent_form.consent_form_id"+index).value=retcode[0];
			eval("document.multiple_consent_form.consent_desc"+index).value=retcode[1];
			eval("document.multiple_consent_form.temp_consent_desc"+index).value=retcode[1];
			checkValidate(index,"VR");
			
		}
		else
		{
			eval("document.multiple_consent_form.consent_form_id"+index).value="";
			eval("document.multiple_consent_form.consent_desc"+index).value="";
			eval("document.multiple_consent_form.temp_consent_desc"+index).value="";
		}
	}
	else
	{
		eval("document.multiple_consent_form.consent_form_id"+index).value="";
		eval("document.multiple_consent_form.consent_desc"+index).value="";
		eval("document.multiple_consent_form.temp_consent_desc"+index).value="";
	}
}

function getDescrip(getCode)
{
 			getval = eval("document.refOrderableresult.catalog_desc"+getCode+".value");
 			//window.returnValue=getCode+"&"+getval;
			//window.close();
			let dialogBody = parent.parent.document.getElementById('dialog-body');
			dialogBody.contentWindow.returnValue = getCode+"&"+getval;
			const dialogTag = parent.parent.document.getElementById('dialog_tag');    
			dialogTag.close();  
}

async function callMultipleConsents(catalog_code,catalog_desc,order_id,order_line_num,order_category,index){
	var dialogHeight		= '80vh';
	var dialogWidth			= '68vw';
	var dialogTop			= '50';
	var dialogLeft			= '100' ;
	var title				= ''
	var	arguments			= "";	
	var	features			= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth + ';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	var bean_id				=  "";
	var bean_name			=  "";
	var consent_form_id		=  "";
	var new_consent_format_label =  "";
	var buttn_label = "Orders";
	
	if(document.forms[0].name == "consent_order_dtl"){
		buttn_label = "Consent";
		bean_id		= document.consent_order_dtl.bean_id.value;
		bean_name	= document.consent_order_dtl.bean_name.value;
		if(document.getElementById('details'+index).style.visibility == 'visible')
			consent_form_id	= eval("document.consent_order_dtl.consent_form_id"+index).value;
	}else{
		bean_id		= document.placeOrderForm.bean_id.value;
		bean_name	= document.placeOrderForm.bean_name.value;
	}
	
	if( catalog_desc.indexOf("(") != -1)		
		catalog_desc = catalog_desc.substring(1,(catalog_desc.length-1));
	
	global_index			= index;
	global_form_id			= consent_form_id;	

	var order_type_code="";
	var retVals				=  await top.window.showModalDialog("../../eOR/jsp/ExistingOrderMultipleConsentFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&index="+index+"&consent_form_id="+"&order_catalog_code="+catalog_code+"&order_catalog_desc="+encodeURIComponent(catalog_desc)+"&order_id="+order_id+"&order_line_num="+order_line_num+"&order_category="+order_category+"&order_type_code="+order_type_code+"&viewBy=line",arguments,features);
	//Added encode IN041421
	var type ="";
	if(document.forms[0].name == "consent_order_dtl" && retVals == "RELOAD" ){
		
		if(document.getElementById('consent_form_id'+index) && document.getElementById('consent_form_id'+index).type == "select-one" ){
			clearList(global_index);
			type = document.getElementById('consent_form_id'+index).type ;
		}
	
		var consent_id ="",consent_desc ="",noteligible_consent_id="";

		//var xmlDoc  = new ActiveXObject( "Microsoft.XMLDom" ) ;
		//var xmlHttp = new XMLHttpRequest() ;
		var xmlHttp = new XMLHttpRequest();
		//var xmlDoc = "";

		xmlStr ="<root><SEARCH " ;
		xmlStr += "order_catalog_code=\""+ catalog_code+"\" " ;
		xmlStr += "order_id=\""+ order_id+"\" " ;
		xmlStr += "order_line_num=\""+ order_line_num+"\" " ;
		xmlStr += "type=\""+ type+"\" " ;
		xmlStr +=" /></root>" ;

		var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "ConsentOrdersValidate.jsp?bean_id=" + bean_id + "&validate=MULTI_CONSENT", false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText )
		
		if(eval("document.consent_order_dtl.noteligible_consent_id"+global_index)){
			eval("document.consent_order_dtl.noteligible_consent_id"+global_index).value = noteligible_consent_id ;
		}

		if (!document.getElementById('consent_form_id'+index) ||(document.getElementById('consent_form_id'+index) && document.getElementById('consent_form_id'+index).type != "select-one"))
		{
			
			if (document.getElementById('consent_form_id'+index) && document.getElementById('consent_form_id'+index).value != consent_id)
			{
				clearConsents(global_index,'Text');
				var details_link=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.details"+index);
				details_link.style.visibility = "hidden";
				var val=eval("parent.ConsentOrdersBottomRight1.document.consent_order_dtl.chk"+index);
				val.checked=false;
				val.value=""; 
			}
			
			eval("document.getElementById('multi_consent')"+global_index).innerHTML = "<font size=1><BR><A class='gridLink' HREF='javascript:displayDetails(\""+global_index+"\")' title='Consent to be Recorded'>"+consent_desc+"</A></font><input type='hidden' name='consent_form_id"+global_index+"' id='consent_form_id"+global_index+"' value='"+consent_id+"'><input type='hidden' name='noteligible_consent_id"+global_index+"' id='noteligible_consent_id"+global_index+"' value='"+noteligible_consent_id+"'>";
		}
		//eval("document.getElementById("link_consent")"+global_index).style.visibility = "visible";
		eval("document.getElementById('multi_label')"+global_index).innerText =getLabel("eOR.Redefine.label","OR");
		
		alignHeading();
		
	}
	 
	/*Modified by kishore kumar N on 30-Oct-09  for CRF 15741*/
	 var qryString = parent.ConsentOrdersBottomRight1.consent_order_dtl.qryString.value
		parent.ConsentOrdersBottomRight1.document.location.href = '../../eOR/jsp/ConsentOrdersBottomRightDtl.jsp?'+qryString;
	/* ends here.*/
 }
//added for BRU-HIMS-CRF-359 [IN038797]

function getSpecialty1(obj)
{	
	if (obj.value != "") {
		var oldValFlag = false;
		if(document.consent_order.Splcode_desc_hid.value != document.consent_order.specialty.value)
			oldValFlag = true;
		if(oldValFlag)
		{
			getSpecialty();
		}
		else
		{	
			if(obj.value == "" || obj.value == null) {
			
				document.consent_order.speciality_code.value = "";
				
			}	
		}
	}
	else {
		
		document.consent_order.speciality_code.value = "";
	}
}
async function getSpecialty()
{
		var target			= document.consent_order.specialty;
		var stdval          = document.consent_order.speciality_code.value;
		var facilityid      = document.consent_order.facility_id.value;
		var locale			= document.consent_order.localeName.value;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Specialty.label","Common");
		
		var sql="select a.SPECIALITY_CODE code, a.SHORT_DESC description from AM_SPECIALITY_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"'" ;
		sql = sql + " and upper(a.SPECIALITY_CODE) like upper(?) and upper(a.SHORT_DESC) like upper(?) order by 2";

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
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var ret1=unescape(retVal);
			var arr=ret1.split(",");
			if(arr[1]==undefined) { 
			arr[1]="";
			arr[0]="";
			}
		   	document.consent_order.specialty.value = arr[1];
		   	document.consent_order.speciality_code.value = arr[0];
			document.consent_order.Splcode_desc_hid.value = document.consent_order.specialty.value; // added for IN043437

			if(arr[0] == "*ALL" || arr[0] == "ALL") {
				document.consent_order.speciality_code.value = "";
			}
		}
		else
		{
			document.consent_order.specialty.value = "";
			document.consent_order.speciality_code.value = "";
			document.consent_order.Splcode_desc_hid.value = ""; // added for IN043437

		} 
}
 
//IN066781 starts
function modifyEmptyTD(obj)
{
	var bodyElement = obj.childNodes;
	var i;
	for(i=0;i<bodyElement.length;i++)
	{
		if (bodyElement[i].nodeType === Node.ELEMENT_NODE) {
		var cells = bodyElement[i].getElementsByTagName('td');
		if(cells != null || cells != undefined)
		{
			for(var tdElement = 0;tdElement < cells.length ;tdElement++)
			{
				if(cells[tdElement].innerHTML == '')
				{
					cells[tdElement].innerHTML = '&nbsp';
				}
			}
		}
	}
}
}
//IN066781 ends


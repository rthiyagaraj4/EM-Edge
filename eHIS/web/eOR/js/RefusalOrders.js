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
14/9/2011	  IN27550		 Dinesh T	 Changed the lines to solve the preview window issue which goes											 behind the editor screen in the refusal in the Record Refusal											 function
12/12/2011    IN029211       Chowminya G    Incident No: IN029211 - <?Record Refusal? of order set then view ?Existing Refusal? system show only 1 order with multiple line> 
24/09/2012    IN034904       Chowminya G     CRF-CA- Bru-HIMS-CRF-121/03-The Order is not Cancelled after we Record Refusal	
04/12/2012	  IN031304 		 Karthi L	  Add location code to search order catalog with the other condition only when rd_appt_yn = 'Y'(IN035976)
01/08/2013    IN042027		 Chowminya G  Catalog Name Does Not Display In Refusal Form For Catalogs Which Does Not Have A Consent Attached
14/08/2013	  IN042244		 Karthi L	   Refusal Editor window -  'Editor Preview' window is opened but not displayed on top of the screen and it is displayed behind the 'Refusal Editor' window	
19/11/2013	  IN032882		Vijayakumar K	REGRESSION: System shows blank window and Query caused no records message 2 times in record refusal.
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name        	Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/07/2015	  IN037506		 Karthi													[SRR20056-SCF-9400 ] Record Refusal - Log in Thai 
26/03/2018	  IN07786		Vijayakumar K										OR-Common-Record Refusal [IN:007786] 
---------------------------------------------------------------------------------------------------------------
*/ 
var message = "" ;
var getorderdate="";
var getenid="";
var getadmindate1="";
var a1;
var get_curr_sys_date;
var function_id="";
var flag="";
var getlineno="";
var store_ordid_linenum=new Array();
var count=0;
var getresult;
var store_ordid_check=new Array();
var store_ordid_name=new Array();
var store_ord_line_num="";
var store_ordid_name1=new Array();
var store_ordid_check1=new Array();
var ordid;
var mycounter=0;
var checkpatientId;
var resultGlobal;
var textSelected = "false";
var resultScrnDisplay = false;
var chkConsent = "";
var flgEncounter = "";
var open_preview=true;
var not_proceed="";


async  function callPatientSearch(){
	var pat_id =await  PatientSearch();

if(pat_id != null)
	{
			document.getElementById("patientId").value = pat_id;
			var frmObj=document.formRefusalOrders;
			populatePatientAgeValue(frmObj.patientId,'refusal');
			populateResultScreen(frmObj.patientId);
	}
}
async function callPatientSearch1(){
	var pat_id =await  PatientSearch();

if(pat_id != null)
	{
			document.getElementById("patientId").value = pat_id;
			var frmObj=document.refusaltab_form;
			frmObj.patientId.onblur();
			//populatePatientAgeValue(frmObj.patientId,'refusal');
			//populateResultScreen(frmObj.patientId);
	}
}

function displayOrderNonOrder()
{
		var frmObj		= document.formRefusalOrders;

		getOrderValue=eval(frmObj.refeusal_type);
		

if(getOrderValue.value=="O")
	{
		ordlabel.innerHTML=getLabel("Common.Orderable.label","COMMON");
		ordtext.innerHTML="<input type='text' name='orderable' id='orderable' size=50 value='' nowrap  readonly><input type='button' name='buttonOrderable' id='buttonOrderable' value='?' class='button' onClick='callRefusalOrderOrderable(orderable)' disabled><img src='../../eCommon/images/mandatory.gif'>";

	}
else if(getOrderValue.value=="N")
	{
		ordlabel.innerHTML=getLabel("eOR.NonOrderable.label","OR");
		ordtext.innerHTML="<input type='text' name='NonOrderable' id='NonOrderable' value='' nowrap size='50'><img src='../../eCommon/images/mandatory.gif'>";

	}
	else
	{
		ordlabel.innerHTML="";
		ordtext.innerHTML="";
	}

}
function displayOrderNonOrder1()
{
		var frmObj		= document.formRefusalOrders;

		getOrderValue=eval(frmObj.refeusal_type1);
		

if(getOrderValue.value=="O")
	{
		ordlabel.innerHTML=getLabel("Common.Orderable.label","COMMON");
		ordtext.innerHTML="<input type='text' name='orderable' id='orderable' size=50 value='' nowrap  readonly><input type='button' name='buttonOrderable' id='buttonOrderable' value='?' class='button' onClick='callRefusalOrderOrderable(orderable)' disabled><img src='../../eCommon/images/mandatory.gif'>";

	}
else if(getOrderValue.value=="N")
	{
		ordlabel.innerHTML=getLabel("eOR.NonOrderable.label","OR");
		ordtext.innerHTML="<input type='text' name='NonOrderable' id='NonOrderable' value='' nowrap size='50'><img src='../../eCommon/images/mandatory.gif'>";

	}
	else
	{
		ordlabel.innerHTML="";
		ordtext.innerHTML="";
	}

}

function displayOrderNonOrderDefault()
{
		var frmObj		= document.formRefusalOrders;

		//getOrderValue=eval(frmObj.refeusal_type);
		getOrderValue=eval(frmObj.refeusal_type1);
		

if(getOrderValue.value=="O")
	{
		ordlabel.innerHTML=getLabel("Common.Orderable.label","COMMON");
		ordtext.innerHTML="<input type='text' name='orderable' id='orderable' size=50 value='' nowrap  readonly><input type='button' name='buttonOrderable' id='buttonOrderable' value='?' class='button' onClick='callRefusalOrderOrderable(orderable)' ><img src='../../eCommon/images/mandatory.gif'>";

	}
else if(getOrderValue.value=="N")
	{
		ordlabel.innerHTML=getLabel("eOR.NonOrderable.label","OR");
		ordtext.innerHTML="<input type='text' name='NonOrderable' id='NonOrderable' value='' nowrap size='50'><img src='../../eCommon/images/mandatory.gif'>";

	}
	else
	{
		ordlabel.innerHTML="";
		ordtext.innerHTML="";
	}

}
function displayOrderNonOrderDefault1()
{
		var frmObj		= document.formRefusalOrders;

		getOrderValue=eval(frmObj.refeusal_type1);
		

if(getOrderValue.value=="O")
	{
		ordlabel.innerHTML=getLabel("Common.Orderable.label","COMMON");
		ordtext.innerHTML="<input type='text' name='orderable' id='orderable' size=50 value='' nowrap  readonly><input type='button' name='buttonOrderable' id='buttonOrderable' value='?' class='button' onClick='callRefusalOrderOrderable(orderable)' ><img src='../../eCommon/images/mandatory.gif'>";

	}
else if(getOrderValue.value=="N")
	{
		ordlabel.innerHTML=getLabel("eOR.NonOrderable.label","OR");
		ordtext.innerHTML="<input type='text' name='NonOrderable' id='NonOrderable' value='' nowrap size='50'><img src='../../eCommon/images/mandatory.gif'>";

	}
	else
	{
		ordlabel.innerHTML="";
		ordtext.innerHTML="";
	}

}


function clearScreen()
{
		var frmObj		= document.formRefusalOrders;
		document.location.reload();
		for(i=0;i<frmObj.length;i++)
		{
			frmObj.elements[i].disabled=false;
			
		}
		frmObj.search1.disabled = true;
		frmObj.search11.disabled = true;

		parent.refusal_main_label.location.href="../../eCommon/html/blank.html";
		parent.refusal_main_result.location.href ="../../eCommon/html/blank.html";
		frmObj.record.style.visibility='visible';
		frmObj.patientId.value="";
		frmObj.encounterid.value="";
		//frmObj.refeusal_type.value="";
		frmObj.refeusal_type1.value="";
		frmObj.refusal_form.value = "";
		frmObj.neworderid.value="";
		refusal_text.innerHTML="";
		ordlabel.innerHTML="";
		ordtext.innerHTML="";
		frmObj.reason.value="";
		showCurrDate();

		if(get_curr_sys_date!=undefined)
				frmObj.datetime.value=get_curr_sys_date;
		frmObj.practitioner.value="";
		document.getElementById("result_name").innerHTML="";

}


function show_practitioner_code_window(target)
{
 	if(target.value == "" || target.value == " " || target.value == null)
	{
		
	}
	else
	{
 
		show_practitioner_code_window1(target);
 		/*var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0]   = formRefusalOrders.practitioner_code_sql.value;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ; 

		retVal = await CommonLookup( "Practitioner", argumentArray );

		if(retVal != null && retVal != "")
		{
			document.formRefusalOrders.practitionerId.value=retVal[0];
			target.value = retVal[1];
		}
		else
		{
			target.value = "";
			document.formRefusalOrders.practitioner.focus();
		}*/
	}
}

function show_practitioner_code_window1(target)
{
 /* 		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0]   = formRefusalOrders.practitioner_code_sql.value;
		argumentArray[1]   = dataNameArray ;
		argumentArray[2]   = dataValueArray ;
		argumentArray[3]   = dataTypeArray ;
		argumentArray[4]   = "1,2";
		argumentArray[5]   = target.value ;
		argumentArray[6]   = CODE_LINK ;
		argumentArray[7]   = CODE_DESC ; 

		retVal = await CommonLookup( "Practitioner", argumentArray );

		if(retVal != null && retVal != "")
		{
			document.formRefusalOrders.practitionerId.value=retVal[0];
			target.value = retVal[1];
		}
		else
		{
			target.value = "";
			document.formRefusalOrders.refusal_form.focus();
		}
*/	 

 		//practName_FValue	= document.formRefusalOrders.practitionerId.value;
		var sql				= document.formRefusalOrders.practitioner_code_sql.value;
	
		var localeName     =	document.formRefusalOrders.localeName.value;
		var sql2			= document.formRefusalOrders.practitioner_code_sql2.value;
		sql = sql.replace("!~locale~!",localeName);
		sql2 = sql2.replace("!~locale~!",localeName);
		var splty			= "";
		var facility_id		= "";



		for(var x=0;x<3;x++)
	{
	sql=sql.replace('?',"'"+localeName+"'");
	sql2=sql2.replace('?',"'"+localeName+"'");
	}
		
		//facility_id		= facilityID;
 		// here not needed job_title , gender, practitioner_type, specialty-code
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " practName_FName=\"" +target.name + "\"";
		xmlStr += " practName_FValue=\"" + encodeURIComponent(target.value) + "\"";
		xmlStr += " sql=\"" +escape(sql)+ "\"";
		xmlStr += " sqlSec=\"" +escape(sql2)+ "\"";
		xmlStr += " practitioner_type=\"" + "" + "\"";
		xmlStr += " specialty_code=\"" + splty+ "\"";
		xmlStr += " gender=\"" + "" + "\"";
		xmlStr += " job_title=\"" + "" + "\"";
		xmlStr +=" /></root>" ;
 		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eAM/jsp/callGeneralPractitionerSearch.jsp?", false ) ;
		xmlHttp.send(xmlDoc);
		responseText	= xmlHttp.responseText;
		responseText	= trimString(responseText);
 		//eval(responseText);
		eval(practSearch(encodeURIComponent(target.name),encodeURIComponent(target.value),splty,responseText));	
 
		 
}
async function practSearch(practName_FName,practName_FValue,splty,responseText) {
	var retVal = 	new String();
	var dialogTop = "10px" ;
	var dialogHeight= "450px" ;
	var dialogWidth	= "700px" ;
		
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
	
	retVal = await window.showModalDialog("../../eAM/jsp/GeneralPractitionerSearch.jsp?pract_name="+practName_FValue+"&practitioner_type="+"\""+"&primary_specialty="+splty+"&job_title="+"\""+"&gender="+"\"",arguments,features);
	PractLookupRetVal(retVal,objName);
}

function PractLookupRetVal(retVal,target)
{
    	if(retVal != null && retVal != "")
		{
			arr=retVal.split("~");
			document.formRefusalOrders.practitionerId.value=arr[0];
			document.formRefusalOrders.practitioner.value = arr[1]
 		}
		else
		{
			document.formRefusalOrders.practitioner.value="";
			document.formRefusalOrders.practitioner.focus();
		}
 }

function recordOrders(target)
{
	
		var frmObj		= document.formRefusalOrders;
		if(target == 'consent')
		{
			frmObj.refeusal_type = frmObj.refeusal_type1;
			frmObj.refeusal_type.value = frmObj.refeusal_type1.value;
		}
		message = "";
		checkpatientId=	frmObj.patientId.value;
		
		checkencounterid=frmObj.encounterid.value;
		//checkrefeusal_type=frmObj.refeusal_type.value;
		checkrefeusal_type=frmObj.refeusal_type1.value;
		//checkreason=frmObj.reason.value;
		//frmObj.reason.value = escape(frmObj.reason.value);
		checkrefusaldate=frmObj.datetime.value;
		checkpractitioner=frmObj.practitioner.value;
 				var fields = new Array(frmObj.patientId,frmObj.refeusal_type,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
				var names = new Array ( getLabel("Common.patientId.label","Common"),getLabel("eOR.RefusalType.label","OR"),getLabel("Common.reason.label","Common"),getLabel("eOR.RefusalDateTime.label","OR"),getLabel("Common.practitioner.label","Common"),getLabel("eOR.RefusalID.label","OR"));
				if(target == 'consent')
				{
					checkrefeusal_type = "O";////
					var fields = new Array ( frmObj.patientId,frmObj.refeusal_type1,frmObj.orderable1,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					
					//var fields = new Array ( frmObj.patientId,frmObj.refeusal_type1,frmObj.orderable1,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					var names = new Array ( getLabel("Common.patientId.label","Common"),getLabel("eOR.RefusalType.label","OR"),getLabel("Common.Orderable.label","COMMON"),getLabel("Common.reason.label","Common"),getLabel("eOR.RefusalDateTime.label","OR"),getLabel("Common.practitioner.label","Common"),getLabel("eOR.RefusalID.label","OR"));
					checkorderable_and_non = frmObj.orderable1.value;///
				}
				else
				{
					if(frmObj.refeusal_type1.value==""){
					alert(getMessage("REFUSAL_TYPE","OR"));
					return false;
					}
 		
				if(checkrefeusal_type=="O")
				{
					//var fields = new Array ( frmObj.patientId,frmObj.refeusal_type,frmObj.orderable,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					var fields = new Array ( frmObj.patientId,frmObj.refeusal_type1,frmObj.orderable,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					var names = new Array ( getLabel("Common.patientId.label","Common"),getLabel("eOR.RefusalType.label","OR"),getLabel("Common.Orderable.label","COMMON"),getLabel("Common.reason.label","Common"),getLabel("eOR.RefusalDateTime.label","OR"),getLabel("Common.practitioner.label","Common"),getLabel("eOR.RefusalID.label","OR"));
									
					checkorderable_and_non=frmObj.orderable.value;
				}
				else if(checkrefeusal_type=="N")
				{
					//var  fields = new Array ( frmObj.patientId,frmObj.refeusal_type,frmObj.NonOrderable,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					var  fields = new Array ( frmObj.patientId,frmObj.refeusal_type1,frmObj.NonOrderable,frmObj.reason,frmObj.datetime,frmObj.practitioner,frmObj.refusal_form);
					var names = new Array ( getLabel("Common.patientId.label","Common"),getLabel("eOR.RefusalType.label","OR"),getLabel("eOR.NonOrderable.label","OR"),getLabel("Common.reason.label","Common"),getLabel("eOR.RefusalDateTime.label","OR"),getLabel("Common.practitioner.label","Common"),getLabel("eOR.RefusalID.label","OR"));
					checkorderable_and_non=frmObj.NonOrderable.value;
				}
				else
				{
					checkorderable_and_non="";
				}
				}
				var nameArray = new Array(7);
				var isError = "N";
				var isCompleted = "N";
				for(var i=0;i<fields.length;i++)
				{
					if(checkField1( fields[i], names[i] ))
					{
						if( i == (fields.length - 1))
						{
							isCompleted = "Y";
						}
					} 
					else
					{
						isError = "Y";
						nameArray[i] = names[i];
					}
				
					if( isError == "N" && isCompleted == "Y" && i == fields.length-1)
						{
						//	if(textSelected == "false")
						//	{
						//		showRefusalDesc();
						//	}
 							if(target != 'consent') 
							{
								if((frmObj.order_Line_num.value!="") && (frmObj.order_Line_num.value!=undefined) &&(frmObj.order_Line_num.value!=null) && (frmObj.neworderid.value!="") && (frmObj.neworderid.value!=undefined) &&(frmObj.neworderid.value!=null) )
								{
									var bean_id = frmObj.bean_id.value ;
									var order_line_num = frmObj.order_Line_num.value ;
									var ord_id = frmObj.neworderid.value ;
									var order_line_number=trimString(order_line_num).split(":$#");
									var count = order_line_number.length - 1; //--[IN029211]
									document.formRefusalOrders.ordercode.value = ""; //--[IN029211]
									for(var k=0;k<count;k++) //For loop to get all the code values
									{
										order_line_num=order_line_number[k];
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest() ;
										xmlStr ="<root><SEARCH " ;
										
									
										xmlStr +=" /></root>" ;
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id +"&order_line_num="+order_line_num+ "&ord_id="+ord_id+"&validate=ord_cat_code", false ) ;
										xmlHttp.send( xmlDoc ) ;
										responseText=xmlHttp.responseText ;
										eval(responseText );
										}

									}
							}
  
							var bean_id = frmObj.bean_id.value ;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest() ;							
							xmlStr ="<root><SEARCH " ;				
							xmlStr +=" /></root>" ;
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id+"&validate=refusal_Content", false ) ;
							xmlHttp.send( xmlDoc ) ;
							responseText=xmlHttp.responseText ;
							eval(responseText );
	 			
							if(not_proceed!="false")
							{														
								eval( formApply(frmObj ,OR_CONTROLLER ) );							
							
								if(message != null && message != "" && message != " ")
								{
									if(message.indexOf("<br>") != -1)
									{
										message = message.replace("<br>","");
									}
								}							
								alert(message); ///////////////changed
							}
							
							if(resultGlobal) 
							{
								if(target == 'consent') {
									
									//parent.parent.parent.workAreaFrame.location.reload();
									//parent.parent.workAreaFrame.location.reload();
									if(parent.refusal_main)	parent.refusal_main.location.href="../../eOR/jsp/RefusalOrdersTab.jsp?patient_id="+frmObj.patientId.value;
									else{
									parent.parent.ConsentOrderTop.document.consent_order.submit();
									//parent.parent.parent.workAreaFrame.location.reload();
									//IN032882 starts
									//if(window != null || window != undefined){
										//window.close();
									//}
									const dialogTag = parent.parent.document.getElementById("dialog_tag");    
									dialogTag.close();
									//IN032882 ends
									}
								}
								else 
                                {
									//onSuccess();
 
									if(parent.refusal_main)	   parent.refusal_main.location.href="../../eOR/jsp/RefusalOrdersTab.jsp?patient_id="+frmObj.patientId.value;
									
								}
								//callPrinting();
							}
						}
						
				}
				
			if(isError == "Y")
			{
				for(var j=0;j<nameArray.length;j++)
				{
					
					if(nameArray[j] == null || nameArray[j] == "undefined")
					{
					}
					else
					{
					message += getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(nameArray[j])))+"\n";

					//message = message + "APP-000001 " + nameArray[j] + " cannot be blank..." + "\n";
					}
				}
				if(message != "" && message != " " && message != null)
					alert(message);
				
			}
}
function checkField1( field, name ) 
{
    if( trimCheck(field.value) )
    {
        field.value = trimString(field.value);
        return true;
    }
    else
    {
        field.focus();
        return false ;
    }
}

function onSuccess()
{
	var frmObj		= document.formRefusalOrders;
	parent.refusal_main_label.location.href="../../eOR/jsp/RefusalOrderResultLabel.jsp";
	parent.refusal_main_result.location.href="../../eOR/jsp/RefusalOrderResult.jsp?patient_id="+frmObj.patientId.value;
	parent.refusal_main_orders.location.href="../../eOR/jsp/RefusalOrders.jsp?mode=1&function_id="+function_id;
}
function assignResult(_result, _message, _flag){

	resultGlobal = _result ;
	message  = _message ;
	flagGlobal = _flag ;

}
function callDisable(){
	
	var ord_cat=document.RefusalOrderableSearch.ordercategory.value;
	var ord_type=document.RefusalOrderableSearch.typecode.value;
	if(ord_cat !="")
		document.RefusalOrderableSearch.ordercategory.disabled= true;
	else
		document.RefusalOrderableSearch.ordercategory.disabled= false;
		
	if(ord_type != "")
		document.RefusalOrderableSearch.typecode.disabled= true;
	else
		document.RefusalOrderableSearch.typecode.disabled= false;

}

async function callRefusalOrderOrderable(target)
{

	var searchText = target.value;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "100" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
// Pass a parameter p_clinic_code & p_speciality_code , if needed,FROM AM for Waiting List...
// When from OP, for Wing RD/OT (operation Theatre), parameter will be passed is p_wing_code & p_service_code
	var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&called_from=generic_atc&mode="+MODE_INSERT,arguments,features);

 if(retVal != undefined)
	{
		storeVal=retVal.split("&");
		
		document.formRefusalOrders.ordercode.value=storeVal[0];
		document.formRefusalOrders.orderable.value = storeVal[1];
	}
	else
	{
		document.formRefusalOrders.orderable.value = "";
		document.formRefusalOrders.ordercode.value = "";
	}
}

async  function callRefusalOrderOrderable1(target)
{
	var searchText = target.value;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "10px" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
// Pass a parameter p_clinic_code & p_speciality_code , if needed,FROM AM for Waiting List...
// When from OP, for Wing RD/OT (operation Theatre), parameter will be passed is p_wing_code & p_service_code
	var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderOrderableFrameSet.jsp?searchText="+encodeURIComponent(searchText)+"&called_from=generic_atc&mode="+MODE_INSERT,arguments,features);

if(retVal != undefined)
	{
		storeVal=retVal.split("&");

		document.refusalsearch_form.catalog_code.value=storeVal[0];
		document.refusalsearch_form.catalog_desc.value = storeVal[1];
	}
	else
	{
		document.refusalsearch_form.catalog_desc.value = "";
		document.refusalsearch_form.catalog_code.value = "";
	}
}
function callRefusal(obj){
	if(obj.value == 'N'){
		document.refusalsearch_form.catalog_desc.value = "";
		document.refusalsearch_form.catalog_desc.disabled = true;
		document.refusalsearch_form.catalog_lookup.disabled = true;
	}else{
		document.refusalsearch_form.catalog_desc.disabled = false;
		document.refusalsearch_form.catalog_lookup.disabled = false;
	}
		
	
}

function populateExistingValues(){
	
	var qryStr	= document.refusalsearch_form.qry_str.value;
	var view	= document.refusalsearch_form.view.value;
	var refusal_type	= document.refusalsearch_form.refusal_type.value;
	var order_by	= document.refusalsearch_form.order_by.value;
	var from_dt	= document.refusalsearch_form.date_from.value;
	var to_dt	= document.refusalsearch_form.date_to.value;
	var ord_cat_code	= document.refusalsearch_form.catalog_code.value;
	if(document.refusalsearch_form.catalog_desc.value == "")
		ord_cat_code="";
	document.refusalsearch_form.search.disabled = true;
	parent.refusal_main_label.location.href = "../../eOR/jsp/RefusalOrderResultLabel.jsp?"+qryStr;
 	//parent.refusal_main_orders1.location.href = "../../eOR/jsp/RefusalOrdersViewCurrentResults.jsp?"+qryStr+"&from_dt="+from_dt+"&to_dt="+to_dt+"&ord_cat_code="+ord_cat_code+"&view="+view+"&refusal_type="+refusal_type+"&order_by="+order_by;
 	parent.refusal_main_result.location.href = "../../eOR/jsp/RefusalOrdersViewCurrentResults.jsp?"+qryStr+"&from_dt="+from_dt+"&to_dt="+to_dt+"&ord_cat_code="+ord_cat_code+"&view="+view+"&refusal_type="+refusal_type+"&order_by="+order_by;

}
function clearSearchValues(){

	document.refusalsearch_form.reset();
	parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
    parent.refusal_main_result.location.href =  "../../eCommon/html/blank.html";

}

function populateOrderCodes(ordercategory)
{
		var frmObj		= document.RefusalOrderableSearch;
		var tmplocale   = frmObj.templocale.value;
		if( ordercategory.value == "" ) 
		{
			clearList("document");
			clearActivityList("document");
		}
		var bean_id = frmObj.bean_id.value ;
		order_type	= frmObj.typecode.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += ordercategory.name+"=\""+ ordercategory.value +"\" " ;
		xmlStr += "order_type=\""+ order_type +"\" " ;

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id +"&localeName="+tmplocale+ "&default_val=''&validate=ref_ord", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		makeResultBlank();
}


function populateActivity(ordertype)
{
 				var frmObj		= document.RefusalOrderableSearch;
				var tmplocale   =frmObj.templocale.value;
 				clearActivityList("document");
 		var bean_id		= frmObj.bean_id.value ;
		order_category	= frmObj.ordercategory.value ;
		order_type		= ordertype.value ;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr += "order_category=\""+ order_category +"\" " ;
		xmlStr += "order_type=\""+ order_type +"\" " ;

		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id +"&localeName="
		+tmplocale+"&default_val=''&validate=ref_order_type", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );
		makeResultBlank();

}

function clearList( docObj ) {
		var frmObj		= document.RefusalOrderableSearch;
	
	var len = frmObj.typecode.options.length;
	for(var i=0;i<len;i++)
	{
		frmObj.typecode.remove("typecode");
	}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("frmObj.typecode.add(opt)") ;
}

function clearActivityList( docObj ) {
		var frmObj		= document.RefusalOrderableSearch;
	
	var len = frmObj.activity_type.options.length;
	for(var i=0;i<len;i++)
	{
		frmObj.activity_type.remove("activity_type");
	}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "" ;
		eval("frmObj.activity_type.add(opt)") ;
}
function addLocationList(code,value) {

		var frmObj		= document.RefusalOrderableSearch;
		var element = document.createElement('OPTION') ;
		element.value =  code ;
		element.text = value ;
		frmObj.typecode.add(element);
	
}
function addActivityTypeList(code,value) {

		var frmObj		= document.RefusalOrderableSearch;
		var element = document.createElement('OPTION') ;
		element.value =  code ;
		element.text = value ;
		frmObj.activity_type.add(element);
	
}

function searchResult1()
{
	var frmObj	= document.RefusalOrderableSearch;
	order_category=frmObj.ordercategory.value;
	type_code=frmObj.typecode.value;
	type_desc=frmObj.typecode[frmObj.typecode.selectedIndex].text;
	activity_type=frmObj.activity_type.value;
	activity_desc=frmObj.activity_type[frmObj.activity_type.selectedIndex].text;	
	//Added by Uma on 3/12/2010 for IN019490
	var practitionerId = frmObj.practitionerId.value;
	var locn_code = frmObj.locn_Code.value; // added for IN031304
	var rd_appt_yn = frmObj.rd_appt_yn.value; // added for IN031304
	if(frmObj.search_by[0].checked)
	{
		search_by="D";
	}
	else
	{
		search_by="C";
	}
	description_code=frmObj.search_criteria.value
	search_text=frmObj.search_text.value;
	var called_from = frmObj.called_from.value;  

	var p_clinic_code		= frmObj.p_clinic_code.value;			
	var p_speciality_code	= frmObj.p_speciality_code.value;			
	var p_wing_code			= frmObj.p_wing_code.value;			
	var p_service_code		= frmObj.p_service_code.value;			
	var CallingModule		= frmObj.CallingModule.value;			
//	var table_name = frmObj.table_name.value;  
//parent.refusal_resultframe1.location.href = "../../eOR/jsp/RefusalOrderOrderableResult.jsp?order_category="+order_category+"&type_code="+type_code+"&activity_type="+activity_type+"&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&p_clinic_code="+escape(p_clinic_code)+"&p_speciality_code="+escape(p_speciality_code)+"&p_wing_code="+escape(p_wing_code)+"&p_service_code="+escape(p_service_code)+"&type_desc="+encodeURIComponent(type_desc)+"&activity_desc="+activity_desc+"&CallingModule="+CallingModule+"&practitionerId="+practitionerId;		//commented for IN031304 
	parent.refusal_resultframe1.location.href = "../../eOR/jsp/RefusalOrderOrderableResult.jsp?order_category="+order_category+"&type_code="+type_code+"&activity_type="+activity_type+"&search_by="+search_by+"&description_code="+description_code+"&search_text="+encodeURIComponent(search_text)+"&called_from="+called_from+"&p_clinic_code="+escape(p_clinic_code)+"&p_speciality_code="+escape(p_speciality_code)+"&p_wing_code="+escape(p_wing_code)+"&p_service_code="+escape(p_service_code)+"&type_desc="+encodeURIComponent(type_desc)+"&activity_desc="+activity_desc+"&CallingModule="+CallingModule+"&practitionerId="+practitionerId+"&locn_code="+locn_code+"&rd_appt_yn="+rd_appt_yn;		//IN031304 

}



function populatePatientAgeValue(getpatientId,target)
{
		var frmObj		= document.formRefusalOrders;
		//var localeName  = document.formRefusalOrders.localeName.value;
		var localeName  = document.getElementById("localeName").value;

		chkConsent = target;
		if( getpatientId.value == "" ) 
		{
				
				document.getElementById("result_name").innerHTML="";
		}
		else
		{
			var bean_id = frmObj.bean_id.value ;
			
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += getpatientId.name+"=\""+ getpatientId.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=pat_det&localeName="+localeName, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText );
			
			//frmObj.reason.value = "";
			showCurrDate();
			 if(!getpatientId.readOnly)
			{
				frmObj.reason.value = "";
				frmObj.refusal_form.value = "";
				refusal_text.innerHTML="";
			}
			
			if(frmObj.NonOrderable)
				frmObj.NonOrderable.value = "";
 
			store_ord_line_num="";
 			if(target != 'consent')
			{
				if(frmObj.order_Line_num)
					frmObj.order_Line_num.value = "";

				frmObj.neworderid.value="";
				
				if(frmObj.orderable)
					frmObj.orderable.value = "";

				frmObj.refeusal_type.value = "";
				frmObj.encounterid.value="";

				
				
				document.getElementById("ordlabel").innerHTML="";
				document.getElementById("ordtext").innerHTML="";

			}
			else
			{
				frmObj.refeusal_type1.value = "O";
				frmObj.refeusal_type1.disabled = true;
				frmObj.orderable1.readOnly = true;
				frmObj.orderable.readOnly = true;
			}
			

		}
		
}
function populatePatientDetails(getpatientId,target)
{
		var frmObj		= document.refusaltab_form;
		var localeName  = document.refusaltab_form.localeName.value;
		chkConsent = target;
		if( getpatientId.value == "" ) 
		{
			document.getElementById("short_name_id").innerHTML="";
			document.getElementById("result_name").innerHTML="";
			document.getElementById("tab").style.visibility="hidden";
			parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
			parent.refusal_main_search.location.href = "../../eCommon/html/blank.html";
   			//parent.refusal_main_orders1.location.href = "../../eCommon/html/blank.html";
   			parent.refusal_main_result.location.href = "../../eCommon/html/blank.html";
		}
		else
		{
			var bean_id = frmObj.bean_id.value ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += getpatientId.name+"=\""+ getpatientId.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=pat_details&localeName="+localeName, false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText );
			var qry_str = frmObj.qry_str.value;
			var patient_id = frmObj.patientId.value;
			if(patient_id != ""){
				change_common_tab('View');
			//parent.refusal_main_search.location.href ="../../eOR/jsp/RefusalOrderExistingSearch.jsp?"+qry_str+"&patient_id="+patient_id;
			
			}
		//	showCurrDate();
			
		}
		
		
}
function addPatientList1(getPatientName,getdate,localeName)
{
	 
	 var convert;
     var parpatient;

	var patientarray=getPatientName.split("<b>");
	var parlength=	patientarray.length;
	var par1array;
	par1array=patientarray[1].split("</b>");



if(localeName!='en')
{
	if(par1array[0].indexOf("-")!=-1)
	{
		parpatient=par1array[0].split("-");
		convert=parpatient[1].substring(2,parpatient[1].length);
		var toalert	=convertDate(convert,'DMYHMS',"en",localeName);
		par1array[0]=parpatient[0].concat("-").concat(parpatient[1].substring(0,2)).concat(toalert);
	}
}





	var sex=patientarray[2].split("/");
	if(sex[0]=='F')
	{
		sex[0]=getLabel("Common.female.label","Common") ;
	}
	else if(sex[0]=='M')
	{
		sex[0]=getLabel("Common.male.label","Common") ;
	}
	if(trimString(par1array[1])=='Sex/Age :')
	{
		 var patientname1=patientarray[0].concat("<b>").concat(par1array[0]).concat("&nbsp;&nbsp;").concat("</b>").concat(getLabel("eOR.SexAge.label","OR")).concat("<b>").concat(sex[0]).concat("/").concat(sex[1]).concat(patientarray[3]).concat("</b>");
 	}

		getorderdate=getdate;
		document.getElementById("short_name_id").innerHTML=getLabel("Common.PatientName.label","COMMON");
		document.getElementById("result_name").innerHTML="&nbsp;&nbsp;"+patientname1;
 	
		var frmObj		= document.refusaltab_form;
//frmObj.search1.disabled=false;
//frmObj.search11.disabled=false;

}
function callClear1()
{
 	var frmObj		= document.refusaltab_form;
	
			frmObj.patientId.value="";

			document.getElementById("short_name_id").innerHTML="";
			document.getElementById("result_name").innerHTML="";
	//		frmObj.encounterid.value="";
	//		frmObj.refeusal_type.value="";
	//		frmObj.neworderid.value="";
	//		document.getElementById("ordlabel").innerHTML="";
	//		document.getElementById("ordtext").innerHTML="";
	//		frmObj.reason.value="";
			
			
			document.getElementById("tab").style.visibility="hidden";
	
			parent.refusal_main_label.location.href = "../../eCommon/html/blank.html";
			parent.refusal_main_search.location.href = "../../eCommon/html/blank.html";
   			//parent.refusal_main_orders1.location.href = "../../eCommon/html/blank.html";
   			parent.refusal_main_result.location.href = "../../eCommon/html/blank.html";
			
	//		parent.refusal_main_result.location.href="../../eCommon/html/blank.html";

		
   		message = getMessage('INVALID_PATIENT','OR');
		alert(message);
		frmObj.patientId.focus();
	


}
function addPatientList(getPatientName,getdate)
{
		var patientarray=getPatientName.split("<b>");
	var parlength=	patientarray.length;
	var par1array;
	par1array=patientarray[1].split("</b>");
	var sex=patientarray[2].split("/");
	if(sex[0]=='F')
	{
		sex[0]=getLabel("Common.female.label","Common") ;
	}
	else if(sex[0]=='M')
	{
		sex[0]=getLabel("Common.male.label","Common") ;
	}
	if(trimString(par1array[1])=='Sex/Age :')
	{
		 var patientname1=patientarray[0].concat("<b>").concat(par1array[0]).concat("&nbsp;&nbsp;").concat("</b>").concat(getLabel("eOR.SexAge.label","OR")).concat("<b>").concat(sex[0]).concat("/").concat(sex[1]).concat(patientarray[3]).concat("</b>");
 	}
		getorderdate=getdate;
		document.getElementById("result_name").innerHTML="&nbsp;&nbsp;"+patientname1;
		var frmObj		= document.formRefusalOrders;

frmObj.search1.disabled=false;
frmObj.search11.disabled=false;

}
async function viewDetails(bean_id,bean_name,order_id,order_line_num,patient_id,srl_no,report_type){
	var dialogHeight= "80vh" ;
	var dialogWidth	= "80vw" ;
	var dialogTop = "10" ;
	var dialogLeft = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal = await top.window.showModalDialog("../../eOR/jsp/ReprintPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&report_type="+report_type+"&patient_id="+patient_id+"&srl_no="+srl_no,arguments,features);
	//var retval="../../eOR/jsp/ReprintPreviewFrameSet.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&order_id="+order_id+"&order_line_num="+order_line_num+"&report_type="+report_type ;

}

function callClear()
{
 
	var frmObj		= document.formRefusalOrders;
	
			frmObj.patientId.value="";
			
			document.getElementById("result_name").innerHTML="";

			frmObj.encounterid.value="";
			frmObj.refeusal_type.value="";
			frmObj.neworderid.value="";
			document.getElementById("ordlabel").innerHTML="";
			document.getElementById("ordtext").innerHTML="";
			frmObj.reason.value="";
			parent.refusal_main_label.location.href="../../eCommon/html/blank.html";	
			parent.refusal_main_result.location.href="../../eCommon/html/blank.html";

			
		message = getMessage('INVALID_PATIENT','OR');
		alert(message);
		frmObj.patientId.focus();
	


}


function getDescrip(getCode,count)
{
	//var getCode = encodeURIComponent(getCode);
	var temp=getCode+count;	
	var CallingModule=document.refOrderableresult.CallingModule.value;	
	if(CallingModule=="OR")
	{
		getval = eval("document.refOrderableresult.catalog_desc"+count+".value");
		var returnVal	=	new Array();
		var order_type_code=document.getElementById("order_type_code").value;
		var order_type_desc=document.getElementById("order_type_desc").value;
		var activity_code=document.getElementById("activity_code").value;
		var activity_desc=document.getElementById("activity_desc").value;

		/*var order_type_code=document.refOrderableresult.order_type_code.value;
		var order_type_desc=document.refOrderableresult.order_type_desc.value;
		var activity_code=document.refOrderableresult.activity_code.value;
		var activity_desc=document.refOrderableresult.activity_desc.value;*/
		returnVal[0]=getCode;
		returnVal[1]=getval;
		returnVal[2]=order_type_code;		
		returnVal[3]=order_type_desc;
		returnVal[4]=activity_code;
		returnVal[5]=activity_desc;
		//window.returnValue=returnVal; 				
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = returnVal;
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();  
	}
	else
	{
		getval = eval("document.refOrderableresult.catalog_desc"+count+".value");
		//window.returnValue=getCode+"&"+getval;
		//window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');	
		dialogBody.contentWindow.returnValue = getCode+"&"+getval;
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close();  
	}
	
}
	
function resetFormSearch(frmObj)
{
		var qry_str= document.RefusalOrderableSearch.qry_str.value;
 		//parent.parent.refusal_searchframe1.location.href = "../../eOR/jsp/RefusalOrderOrderableSearch.jsp?"+qry_str;
		frmObj.reset();
		frmObj.search_text.value = "";
				
		/*		frmObj.reset();
				frmObj.search_text.value = "";
				n=frmObj.ordercategory.length
				clearList("document");
				clearActivityList("document");
				
		for(i=0;i<n;i++)
		{
				var element = document.createElement('OPTION') ;
				element.value=frmObj.ordercategory[i].value;
				element.text=frmObj.ordercategory[i].text;
				if(element.value!="" && element.text!="All")
				frmObj.typecode.add(element);
		}*/

	parent.refusal_resultframe1.location.href = "../../eCommon/html/blank.html";

}

function ValidateDateTime1 (from,to)
{
		var a=  from.split(" ");
		splitdate=a[0];
		splittime=a[1];
		var splitdate1 =splitdate.split("/");
		var splittime1= splittime.split(":");
		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
 		if(to!="" && to!=null) {
			a=  to.split(" ");
			splitdate=a[0];

			splittime=a[1];
			
			splitdate1 = splitdate.split("/");
			splittime1 = splittime.split(":");
			var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
			if(Date.parse(to_date) <= Date.parse(from_date))
			{
			   return true;
			}
			else
			{
				return false;
			}
		} 
		else
			return true;
}
function ValidateDateTime3 (from,to)
{
		var a=  from.split(" ");
		splitdate=a[0];
		splittime=a[1];
		var splitdate1 =splitdate.split("/");
		var splittime1= splittime.split(":");
		var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))
		a=  to.split(" ");

		splitdate=a[0];

		splittime=a[1];

		splitdate1 = splitdate.split("/");
		splittime1 = splittime.split(":");
        var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))

     if(Date.parse(to_date) > Date.parse(from_date))////
    {
       return true;
    }
    else
	{
	   return false;
	}
}

function displayVisitDate(encounterid,visit_admin_time)
{
			alert(getMessage("FROM_VISIT","OR")+visit_admin_time);
}
async  function patientEncounterDetail(getPatientId,target)
{
	if(target == 'refusal')
	{
		var dialogHeight= "60vh" ;
		var dialogWidth	= "60vw" ;
		var dialogTop = "10px" ;
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderEncounterFrameSet.jsp?called_from=generic_atc&mode="+MODE_INSERT+"&patientId="+getPatientId,arguments,features);
				
		if(retVal != undefined && retVal != null)
		{
			var temp = retVal.split('$');
			var frmObj		= document.formRefusalOrders;
			frmObj.encounterid.value=temp[0];
			frmObj.admissionDate.value=temp[1];
		}
	}
	else
	{
		
		var frmObj		= document.formRefusalOrders;
		var pat_id = frmObj.patientId.value;
		var enc_id = frmObj.encounterid.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersEncounterValidate.jsp?patient_id="+pat_id+"&encounter_id="+enc_id, false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		//eval(responseText);
		
	}
}

async function patientOrderDetails(get_patientId)
{
	
	var frmObj		= document.formRefusalOrders;
	var dialogHeight= "90vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop = "10px" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	var retVal = await window.showModalDialog("../../eOR/jsp/RefusalOrderIDResultsFrameSet.jsp?called_from=generic_atc&mode="+MODE_INSERT+"&patientid="+get_patientId+"&orderid="+frmObj.neworderid.value+"&linenum="+frmObj.order_Line_num.value,arguments,features);
	if(retVal != null && retVal != undefined)
	{
		retVal1=retVal.split('/');
		
		flgEncounter = retVal1[0];

		frmObj.neworderid.value=retVal1[1];
		frmObj.hidd_ord_id.value=retVal1[1];	
		frmObj.order_Line_num.value=retVal1[2];
		
		if( flgEncounter == "true" )
		{
			//frmObj.order_Line_num.value=retVal1[3] + "/" + retVal1[4];
			
			if(retVal1[5] != null && retVal1[5] != 'null')
				frmObj.encounterid.value = retVal1[5];	
			else
				frmObj.encounterid.value = "";				
		
			frmObj.patient_class.value = retVal1[6];
		
			frmObj.order_type_code.value = retVal1[7];
		
			frmObj.location_code.value = retVal1[8];
		
			frmObj.location_type.value = retVal1[9];
		
			frmObj.priority.value = retVal1[10];
		}
		else
		{
			//frmObj.order_Line_num.value=retVal1[3];
			
			if(retVal1[4] != null && retVal1[4] != 'null')
				frmObj.encounterid.value = retVal1[4];	
			else
				frmObj.encounterid.value = "";				
		
			frmObj.patient_class.value = retVal1[5];
		
			frmObj.order_type_code.value = retVal1[6];
		
			frmObj.location_code.value = retVal1[7];
		
			frmObj.location_type.value = retVal1[8];
		
			frmObj.priority.value = retVal1[9];
			frmObj.ordercode.value = retVal1[10];
			
		}
		
	
		if(frmObj.neworderid.value != null && frmObj.neworderid.value != '' && frmObj.neworderid.value != ' ')
		{
			//frmObj.refeusal_type.value = "O";
			//displayOrderNonOrder();
			frmObj.refeusal_type1.value = "O";
			displayOrderNonOrder1();
			if( flgEncounter == "true" )
			{
				frmObj.orderable.value = retVal1[3] + "/" + retVal1[4];
			}
			else
			{
				frmObj.orderable.value = retVal1[3];
			}
			//frmObj.refeusal_type.disabled = true;
			frmObj.refeusal_type1.disabled = true;
			
		}
	}
}

function displayEncounterDetails(getEncounterId,getadminDate)
{
	
	parent.window.returnValue = getEncounterId +"$"+ getadminDate ;
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
function chckDate(Object2,focusflag)
{
	var localeName=document.refusalsearch_form.localeName.value
//if(CheckDate(Object2,focusflag)==false)//this removed for thai date conversion
 if(validDateObj(Object2,"DMY",localeName)==false)
	{
	document.refusalsearch_form.date_from.value=document.refusalsearch_form.temp_last_month_date.value;
	} 
}
async function checkDate(ref_datetime,localeName)
{   


if(validDateObj(ref_datetime,"DMYHM",localeName))
	{



	ref_datetime.value = trimString(ref_datetime.value);
	if(ref_datetime.value == "" || ref_datetime.value == " " || ref_datetime.value == null)
	{

	}
	else

	{

	var frmObj		= document.formRefusalOrders;
	if(chkConsent == 'consent')
		await patientEncounterDetail(frmObj.patientId.value,chkConsent);

	getvisit_admin_date=ref_datetime.value;
	getOrdDate=getorderdate;

	getCurrDate=ref_datetime.value;

	getDate=getCurrDate.split(" ");
	getTableDate=getOrdDate.split(" ");
	get_curr_sys_date=frmObj.curr_sys_date.value;


	if(getvisit_admin_date != "" ||  getvisit_admin_date != null)
	//if(validDateObj(getCurrDate,"DMY",localeName))
	{	
		if(getDate.length == 2)
		{
			if(getDate[0]!="" && getDate[1]!="" && getvisit_admin_date!="")
			{
				if(validDateObj(ref_datetime,"DMYHM",localeName))//SRR20056-SCF-9400 
				//if(checkDt(getDate[0])==true && chkTime(getDate[1])==true)
				{
							if(!ValidateDateTime1(getCurrDate,getOrdDate)==true )//this line commented for thai date conversions
							
							
							//if(!isAfter(getOrdDate,getCurrDate,"DMYHM",localeName))
							{
									message = getMessage('REFUSAL_LESS_REGN_DATE_TIME','OR');
									alert(message);
									frmObj.datetime.focus();
							}
							else if(ValidateDateTime3(getCurrDate,getvisit_admin_date))
							//else if(!isAfter(getCurrDate,getvisit_admin_date,"DMYHM",localeName))
							{
								
									message = getMessage('REFUSAL_LESS_VISIT_DATE_TIME','OR');
									alert(message);
									frmObj.datetime.focus();
							}
							else if(!ValidateDateTime2(get_curr_sys_date,getCurrDate)==true)
							//else if(!isAfter(get_curr_sys_date,getCurrDate,"DMYHM",localeName))
							{
									message = getMessage('REFUSAL_LESS_SYS_DATE_TIME','OR');
									alert(message);
									frmObj.datetime.value="";
									frmObj.datetime.focus();
							}
				}
				else
				{

					message = getMessage("INVALID_DATE_TIME_FMT","OR")
					alert(message);
					frmObj.datetime.focus();
				}
			}

			else
			{
			   if(!ValidateDateTime2(get_curr_sys_date,getCurrDate)==true)

			   //if(!isAfter(get_curr_sys_date,getCurrDate,"DMYHM",localeName))
				{
					message = getMessage('REFUSAL_LESS_SYS_DATE_TIME','OR');
					alert(message);
					frmObj.datetime.value="";
					frmObj.datetime.focus();
				}
			}	
		}// getDate length check condition
		else
		{
			message = getMessage("INVALID_DATE_TIME_FMT","OR")
			alert(message);
		
			frmObj.datetime.value = "";
			frmObj.datetime.focus();
		}
   }
  
  }
	}
	else
	{
		//document.formRefusalOrders.datetime.value=document.formRefusalOrders.temp_curr_sys_date.value;
		document.getElementById("datetime").value=document.getElementById("temp_curr_sys_date").value;
		
	}


}
//This is to check with sysdate.
function ValidateDateTime2 (from,to)
{
     var a=  from.split(" ");
     splitdate=a[0];
     splittime=a[1];
     var splitdate1 =splitdate.split("/");
     var splittime1= splittime.split(":");
     var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));
     a=  to.split(" ");
	 splitdate=a[0];
	 splittime=a[1];
     splitdate1 =splitdate.split("/");
     splittime1= splittime.split(":");
     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]));
	 if(Date.parse(to_date) > Date.parse(from_date))
    {
        return false;
    }
    else{
        return true;
	}

}


function checky_n(getid,getorderid)
{
	var frmObj=	document.orderidresult;
	
	var frmObj1	= document.formRefusalOrders;
	var localeName = document.orderidresult.localeName.value;
	var bean_id = frmObj.bean_id.value;
	var bean_name = frmObj.bean_name.value;
	getval=getid.name;
	var n=frmObj.store_n.value;
	store_ordid_linenum[count]=getorderid;			
	count++;
	getresult=getorderid.split(':$#');
	getorderid=getresult[0];
	var str = "",str1="",str2,str3,str4 =""; //--[IN029211] - Start //--[IN034904] 
	str1 = getid.value;
	str2=str1.split(':$#');
	str = str2[2];
	str3 = getresult[0];
	str4 = getresult[2]; //--[IN034904]
	//--[IN029211] - End
 	if(getid.checked == true)
	{	
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		//xmlHttp.open( "POST", "RefusalOrdersTemp.jsp?str="+str+"&str1="+str1+"&str3="+str3+"&bean_id="+bean_id+"&bean_name="+bean_name+"&checked=Y&ret_bean_val=N&localeName="+localeName,false ) ;
		xmlHttp.open( "POST", "RefusalOrdersTemp.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&checked=Y&ret_bean_val=N&localeName="+localeName+"&str="+encodeURIComponent(str)+"&str1="+encodeURIComponent(str1)+"&str3="+encodeURIComponent(str3),false ) ;

		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
			
	}
	else
	{	
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersTemp.jsp?bean_id="+bean_id+"&bean_name="+bean_name+"&checked=N&ret_bean_val=N&str="+encodeURIComponent(str)+"&str1="+encodeURIComponent(str1)+"&str3="+encodeURIComponent(str3),false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval( responseText ) ;
	}
	
	for(i=1;i<=n;i++)
	{
		getval1=eval("frmObj.s_"+i);
		if(getval1 != null )
		{
			if(getid.checked==true)
			{
				mycounter=mycounter+1;
				get_n1=getval1.length;
				value1=getval1.value;
				getval11=value1.split(':');
				getval112=value1.split(':$#'); //--[IN034904]
				getresult=getval11[0];
				getresult1=getval112[10]; //--[IN034904]- Start
				if((str4 == getresult1) && (getorderid==getresult))
				{
					getval1.checked=true;
				} //--[IN034904] - end
				if(! (getorderid==getresult))
				{	
					getval1.checked=false; //--[IN034904]
					getval1.disabled=true;
					flag=true;
				}
			}else
			{
				mycounter=mycounter-1;
				
				for(j=1;j<=n;j++)
				{
					getval2=eval("frmObj.s_"+j);
					value2=getval2.value;
					getval22=value2.split('&');
					getresult=getval22[0];
					getval112=value2.split(':$#');
					getresult11=getval112[0];
					getresult1=getval112[10];
					//--Modified - Start [IN034904]
					if(!(getorderid==getresult11 && getval2.checked==true) && mycounter<=1)
					{
						getval2.disabled=false;
					}
					else if((str4 == getresult1) &&  (getorderid==getresult11))
					{
						getval2.checked=false;
					}//--Modified - End [IN034904]
					else
					{
						break;
					}
				}
								
								flag=false;	
							}
			}


	}

}

function SubmitLink(from, to) {
		var frmObj=document.orderidresult;
		var localeName=document.orderidresult.localeName.value;
		count=0;
			for(j=0;j<frmObj.length;j++)
				{
						getval=eval("frmObj.s_"+j);
						if(getval != null)
								{
									if(getval.checked==true)
										{
											store_ordid_name[count]=getval.name;
											store_ordid_check[count]=getval.value;
											count=count+1;
										 }
								}
				}
	
	
	      var bean_id = frmObj.bean_id.value ;
	      var xmlDoc = "" ;
		  var xmlHttp = new XMLHttpRequest() ;

		  xmlStr ="<root><SEARCH " ;
		
	for(i=0;i<store_ordid_check.length;i++)
	{
		  xmlStr += "s_"+i+"=\""+ store_ordid_check[i]+"\" " ;
	}
		 
		  xmlStr +=" /></root>" ;
	      xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	      xmlHttp.open("POST", "../../eOR/jsp/RefusalOrderIDValidate.jsp?bean_id="+frmObj.bean_id.value+"&bean_name="+frmObj.bean_name.value+"&validate=ord_id_res&localeName="+localeName, false);
		  xmlHttp.send( xmlDoc ) ;
		  responseText=xmlHttp.responseText ;
		  eval(responseText);
		  document.QueryForm.from.value = from;
	      document.QueryForm.to.value = to;
		  document.QueryForm.submit();
}


function forClear1()
{

			var frmObj=document.orderidresult;
			var localeName=document.orderidresult.localeName.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST", "../../eOR/jsp/RefusalOrderIDValidate.jsp?bean_id=refusalOrdersBean&validate=ord_id_clear&localeName="+localeName, false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;					
			eval(responseText);
}


function displayOrderId()
{
			var frmObj=document.orderidresult;
			var bean_id = frmObj.bean_id.value;
			var bean_name = frmObj.bean_name.value;
			//var localeName=frmObj.localeName.value;
			var frmObj1	= document.formRefusalOrders;
			store_ord_line_num="";
			var store_desc = "";
			count=0;
			var str = "";
			var chk_boolean=false;
			for(j=0;j<frmObj.length;j++){

				getval=eval("frmObj.s_"+j);
				
				if(getval != null)
				{
				if(getval.checked == true ){
					chk_boolean = true;
					break;
				}
				}

			}
 			for(j=0;j<frmObj.length;j++)
				{
						getval=eval("frmObj.s_"+j);
						if(getval != null)
						{
							if(getval.checked==true )
							{
								store_ordid_name1[count]=getval.name;
								store_ordid_check1[count]=getval.value;
								splitting_ordno=store_ordid_check1[count].split(':$#');

								store_desc += splitting_ordno[2] + ",";

								store_ord_line_num+=splitting_ordno[1]+":$#";
								count=count+1;
							}else{
			
							}
						}
	
				}
 				if(!chk_boolean){
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest() ;
					xmlStr ="<root><SEARCH " ;
					xmlStr +=" /></root>" ;
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "RefusalOrdersTemp.jsp?&bean_id="+bean_id+"&bean_name="+bean_name+"&ret_bean_val=Y",false ) ;
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText ;
					//var store_ordid_check1_temp=new Array();
					eval( responseText ) ;
					for(var i=0;i<store_ordid_check1.length;i++){
					splitting_ordno=store_ordid_check1[i].split(':$#');

					store_desc += splitting_ordno[2] + ",";

					store_ord_line_num+=splitting_ordno[1]+":$#";
					}

				}
			if(store_ordid_check1.length>0)
				{
						ordid=store_ordid_check1[0].split(':$#');
  						if(store_desc.charAt(0) == ',')
							store_desc = store_desc.substring(1,store_desc.length - 2);
						else
							store_desc = store_desc.substring(0,store_desc.length - 1);

					if(store_desc.indexOf('/') != -1)
					{
						flgEncounter = "true";
					}

					//window.returnValue = flgEncounter+"/"+ordid[0]+"/"+store_ord_line_num+"/"+store_desc+"/"+splitting_ordno[3]+"/"+splitting_ordno[4]+"/"+splitting_ordno[5]+"/"+splitting_ordno[6]+"/"+splitting_ordno[7]+"/"+splitting_ordno[8]+"/"+splitting_ordno[9];
					//window.close();
					let dialogBody = parent.parent.document.getElementById('dialog-body');
					dialogBody.contentWindow.returnValue = flgEncounter+"/"+ordid[0]+"/"+store_ord_line_num+"/"+store_desc+"/"+splitting_ordno[3]+"/"+splitting_ordno[4]+"/"+splitting_ordno[5]+"/"+splitting_ordno[6]+"/"+splitting_ordno[7]+"/"+splitting_ordno[8]+"/"+splitting_ordno[9];
					const dialogTag = parent.parent.document.getElementById("dialog_tag");    
					dialogTag.close();  
					
				}
	
}
function addOrderId(ind,value){
	store_ordid_check1[ind]= value;
}

function populateResultScreen(patient_id)
{
	resultScrnDisplay = true;
	if(patient_id.value !="")
	{
			parent.refusal_main_label.location.href="../../eOR/jsp/RefusalOrderResultLabel.jsp";	
			parent.refusal_main_result.location.href="../../eOR/jsp/RefusalOrderResult.jsp?patient_id="+patient_id.value;
			var frmObj		= document.formRefusalOrders;
			if(frmObj.refeusal_type != null)
				frmObj.refeusal_type.disabled = false;
			if(frmObj.orderable != null)
				frmObj.orderable.readOnly = false;
			if(frmObj.buttonOrderable != null)
				frmObj.buttonOrderable.disabled = false;
			message = "";

	}
	else
	{
	}
}

function OrderResultLink(order_catalog_dec1,refused_date_time1,practitioner_name1,refused_reason1,encounter_id1,patient_class1,refusal_type1,refused_pract_id1,order_id1,order_line_num1,patient_id,patient_name_age,refusal_form_id,srl_no)
{
	
		
	var frmObj=parent.refusal_main_orders.document.formRefusalOrders;
	
	var strReas = unescape(refused_reason1);
	var len = strReas.length;
	var ch = "";
	for(var k=0;k<len;k++)
	{
		ch = strReas.charAt(k);
		if(ch == "+")
			strReas = strReas.replace("+","");
	}
	frmObj.reason.value= strReas;	//parent.refusal_main_orders.location.href="../../eOR/jsp/RefusalOrders.jsp?mode=1&function_id="+function_id+"&reason="+refused_reason1+"&patient_id="+patient_id+"&encounter_id="+encounter_id1+"&orderId="+order_id1+"&datetime="+refused_date_time1+"&refusal_type="+refusal_type1;
	
	frmObj.patientId.value	=patient_id;
	if(encounter_id1!="null")
	{
	frmObj.encounterid.value=encounter_id1;
	}
	else
	{
	frmObj.encounterid.value="";
	}
	if(order_id1 !="null")
	{
	frmObj.neworderid.value=order_id1;
	}
	else
	{
		frmObj.neworderid.value="";
	}
	parent.refusal_main_orders.result_name.innerHTML="&nbsp;&nbsp;"+patient_name_age;
	if(refusal_type1=="O")
	{
		frmObj.refeusal_type.value="O";
		parent.refusal_main_orders.ordlabel.innerHTML=getLabel("Common.Orderable.label","COMMON");
		parent.refusal_main_orders.ordtext.innerHTML="<input type='text' name='orderable' id='orderable' value='"+order_catalog_dec1+"' size=50  nowrap ><input type='button' value='?' class='button' onClick='callRefusalOrderOrderable()'><img src='../../eCommon/images/mandatory.gif'>";
	}
	else if(refusal_type1=="N")
	{
		frmObj.refeusal_type.value="N";
		parent.refusal_main_orders.ordlabel.innerHTML=getLabel("eOR.NonOrderable.label","OR");
		parent.refusal_main_orders.ordtext.innerHTML="<input type='text' name='NonOrderable' id='NonOrderable' value='"+order_catalog_dec1+"' nowrap size='50'><img src='../../eCommon/images/mandatory.gif'>";

	}
	
	
	frmObj.datetime.value=refused_date_time1;
	frmObj.practitioner.value=practitioner_name1;
	

	for(i=0;i<frmObj.length;i++)
	{
		if(frmObj.elements[i].name=="record")
		{
			frmObj.elements[i].style.visibility='hidden';
		}
		else if(frmObj.elements[i].name=="clear")
		{
				frmObj.elements[i].disabled=false;
		}
		else if(frmObj.elements[i].name=="reason")
		{
			frmObj.elements[i].disabled=false;
			frmObj.elements[i].readOnly = true;
		}
		else
		{
		frmObj.elements[i].disabled=true;
		}
		
	}
	
	if(refusal_form_id == null)
		frmObj.refusal_form.selectedIndex = '0';
	else
		frmObj.refusal_form.value = refusal_form_id;


	if(frmObj.refusal_form.value == "")
	{
		frmObj.all.refusal_text.innerHTML="";
	}
	else
	{
		var target = "true";
		frmObj.all.refusal_text.innerHTML="<a class='gridLink' href=\"javascript:showRefusalDesc1(\'"+target+"\',\'"+patient_id+"\',\'"+srl_no+"\');\">Refusal Text</a>";
	}
	
}


async function resultOrderComments(getOrdResComments)
{

	var dialogHeight= "26vh" ;
	var dialogWidth	= "36vw" ;
	var dialogTop = "10" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";
	var retVal = await top.window.showModalDialog("../../eOR/jsp/RefusalOrderComments.jsp?comments="+getOrdResComments,arguments,features);


}
function allowDateFormat(){
var key = window.event.keyCode;

if( ! ( (( key>=48 ) && ( key<=58 ) ) || (key == 47)|| (key == 32)) ) {
   return false;
}
}

function spcheck()
{

var frmObj=document.formRefusalOrders;
a=checkMaxLimit(frmObj.reason,500);
if(a == false)
{
	frmObj.reason.focus();
}
}
function showRefusalText(target)
{
	textSelected = "false";
	if(target.value == "")
	{
		refusal_text.innerHTML="";
	}
	else
	{
		//refusal_text.innerHTML="<a class='gridLink' href='javascript:showRefusalDesc()'>"+getLabel("eOR.RefusalText.label","OR")+"</a>"; //Line Commented for Incident IN27550 
		refusal_text.innerHTML='';//Line added for Incident IN27550
		showRefusalDesc();
	}
}
function showRefusalDesc1(target,patient_id,srl_no)
{	
	/*var id = document.formRefusalOrders.refusal_form.value;
	var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "";

	var retVal = window.showModalDialog("RefusalOrderDesc.jsp?id="+id+"&target="+target+"&textSelected=&patient_id="+patient_id+"&srl_no="+srl_no,arguments,features);
	*/

	var id = document.formRefusalOrders.refusal_form.value;
 	 
	var bean_id		= document.formRefusalOrders.bean_id.value;
	var bean_name   = document.formRefusalOrders.bean_name.value;

	var encounter_id   = document.formRefusalOrders.encounterid.value;
	var order_id   = document.formRefusalOrders.neworderid.value;
	var orderable   = "";
	if(document.formRefusalOrders.orderable)
		orderable   = document.formRefusalOrders.orderable.value;
	else  if(document.formRefusalOrders.orderable1)
		orderable   = document.formRefusalOrders.orderable1.value;

 	//textSelected   = "true";
	//  Open the Window
	window.open("../../eOR/jsp/RefusalDetailsFrameset.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&qry=''&id="+escape(id)+"&target="+target+"&textSelected="+"&patient_id="+patient_id+"&srl_no="+srl_no+"&encounter_id="+encounter_id+"&order_id="+order_id+"&orderable="+escape(orderable),"modify_editor","height=580,width=775,top=70,left=100,status=no,toolbar=no,menubar=no,location=no");

	//textSelected = "true";
}
function showRefusalDesc()
{
	var id = document.formRefusalOrders.refusal_form.value;
 	var content = document.formRefusalOrders.consent_content.value;

	/*var dialogHeight= "30" ;
	var dialogWidth	= "50" ;
	var dialogTop = "60" ;
	var center = "1" ;
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	
	var retVal = window.showModalDialog("RefusalOrderDesc.jsp?id="+id+"&target=&textSelected="+textSelected,arguments,features);
	*/
	var bean_id		= document.formRefusalOrders.bean_id.value;
	var bean_name   = document.formRefusalOrders.bean_name.value;
	var encounter_id   = document.formRefusalOrders.encounterid.value;
	var order_id   = document.formRefusalOrders.neworderid.value;
	var patientId   = document.formRefusalOrders.patientId.value;
	var orderable   = "";
 	if(document.formRefusalOrders.orderable)
		orderable   = document.formRefusalOrders.orderable.value;
	else if(document.formRefusalOrders.orderable1)
		orderable   = document.formRefusalOrders.orderable1.value;
 	var ordercode   = document.formRefusalOrders.ordercode.value;//IN042027
 	
  	//textSelected   = "true";
	//  Open the Window
	 
	var newWindow =	window.open("../../eOR/jsp/RefusalDetailsFrameset.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&qry=''&id="+escape(id)+"&target=&textSelected="+textSelected+"&patient_id="+patientId+"&encounter_id="+encounter_id+"&order_id="+order_id+"&orderable="+escape(orderable)+"&ordercode="+escape(ordercode),"modify_editor","height=550,width=1175,top=50,left=20,status=no,toolbar=no,menubar=no,location=no");
		//IN042027 included ordercode
		
		 let checkWindowClosed = setInterval(function() {
		      if (newWindow.closed) {
		        clearInterval(checkWindowClosed);
		        // Trigger the function when the window is closed
		        setChildwindowStatus('onunload');
		      }
		    }, 1000);
		  
}
function setChildwindowStatus(obj)
{
	if (obj == "onload")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;			
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=refusalOrdersBean&win_status=onload&validate=WIN_STATUS", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );		
	}else if (obj == "onunload")
	{
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlStr ="<root><SEARCH " ;			
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=refusalOrdersBean&win_status=onunload&validate=WIN_STATUS", false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText ;
		eval(responseText );		
	}
}

/*
function setContent(id,content)
{
	//alert(content.value);
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;

	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

	xmlHttp.open( "GET", "RefusalOrderDescTemp.jsp?id="+id+"&content="+content.value, false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;

	eval(responseText);
	return true;
}
*/
function setContent()
{
	
	/*textSelected = "true";
	var vals=document.formRefusalText.consent_form_text.value;
		if(vals==""){
			alert("APP-000001 Consent Notes cannot be blank...");
			return false;
	}
	
	var formObj = document.formRefusalText;
	eval(formApply(formObj,"RefusalOrderDescTemp.jsp"));
		window.close();
	*/

 	var RTEText = parent.editor_button.document.formRefusalText.RTEText.value;

	if(parent.editor && parent.editor.RTEditor0)
	{
		parent.editor.RTEditor0.document.designMode = "On";
		parent.editor.RTEditor0.document.body.focus();
		parent.editor.RTEditor0.document.body.innerHTML = "";
		parent.editor.RTEditor0.document.execCommand("formatBlock","", "Address");
		if(RTEText!="")
		{
			parent.editor.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd",RTEText);
		}
	}
	
	  	//parent.editor.RTEditor0.document.body.innerHTML = RTEText;
}

async function previewEditor(){


	id				= document.formRefusalText.id.value
	bean_id			= document.formRefusalText.bean_id.value
	bean_name		= document.formRefusalText.bean_name.value
	consent_form_id		= document.formRefusalText.consent_form_id.value
 	 
	//IN07786 start			
	if(parent.editor.RTEditor0.document.body != null)
	{
		modifyEmptyTD(parent.editor.RTEditor0.document.body);
		if(parent.editor.RTEditor0.document.body.firstElementChild.nodeName == 'ADDRESS')
		{
			while(parent.editor.RTEditor0.document.body.firstElementChild.innerHTML == '')
			{
				parent.editor.RTEditor0.document.body.removeChild(parent.editor.RTEditor0.document.body.firstElementChild);
			}
		}
	}
	//IN07786 ends
 		
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
		xmlStr		="<root><SEARCH " ;
		xmlStr		+= "bean_id=\"" +bean_id+"\" ";
		xmlStr		+= "bean_name=\"" +bean_name+"\" ";
		xmlStr		+= "consent_form_id=\"" +consent_form_id+"\" ";
		xmlStr		+= "consent_form_text=\"" +checkSpl(parent.editor.RTEditor0.document.body.innerHTML)+"\" ";

		xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RefusalOrderDescTemp.jsp", false ) ;
	//xmlHttp.open( "GET", "RefusalOrderDescTemp.jsp", false ) ;
	xmlHttp.send( xmlDoc ) ;
 	responseText=xmlHttp.responseText;	
	
	eval(responseText);
 	//window.parent.opener.preview(id, bean_id, bean_name,open_preview);//IN042244
	await preview(id, bean_id, bean_name,open_preview);
	
}	

async function storeEditor(){
	open_preview = false;
	await previewEditor();
	window.parent.close();
}

async function preview(id, bean_id, bean_name,open_preview){

	if(!open_preview) // in order to not to show the preview dialog onclick of enabled gif
			return false;
	var dialogHeight	= '75vh' ;
	var dialogWidth		= '90vw' ;
	var dialogTop		= '30';
	var dialogLeft		= '100' ;
	var title			= ''
	var features		= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=auto; status=no';
	var retVals			=  await window.showModalDialog("../../eOR/jsp/RefusalOrdersPreviewFrameSet.jsp?bean_id="+escape(bean_id)+"&bean_name="+escape(bean_name)+"&id="+escape(id),arguments,features);
}


function focusFrame(){
 	parent.preview.focus();
}
function setContentReason()
{
	 
	var formObj = document.formRefusalOrders;
	eval(formApply(formObj,"RefusalOrderDescTemp.jsp"));
		window.close();
}
function showCurrDate()
{	
	
	var localeName=document.formRefusalOrders.localeName.value;
	var currDate = new Date();
	var date = currDate.getDate();
	var mon = currDate.getMonth();
	mon = mon+1;
	var year = currDate.getYear();
	var hour = currDate.getHours();
	if(hour >= 24)
		hour = hour - 24;
	var min = currDate.getMinutes();
	if(date <10)
		date = "0"+date;
	if(mon <10)
		mon = "0"+mon;
	if(hour <10)
		hour = "0"+hour;
	if(min < 10)
		min = "0"+min;
	var convert1= date + "/" + mon + "/" + year + " " + hour + ":" + min;
	document.formRefusalOrders.datetime.value=convertDate(convert1,'DMYHM',"en",localeName)
}

function makeDisable()
{
	if(!resultScrnDisplay)
	{
		var frmObj		= document.formRefusalOrders;
		if(frmObj.encounterid != null)
			frmObj.encounterid.readOnly = true;
		if(frmObj.neworderid != null)
			frmObj.neworderid.disabled = true;
		if(frmObj.search1 != null)
			frmObj.search1.disabled = true;
		if(frmObj.search11 != null)
			frmObj.search11.disabled = true;
		if(frmObj.orderable != null)
			frmObj.orderable.readOnly = false;
		if(frmObj.buttonOrderable != null)
			frmObj.buttonOrderable.disabled = false;
	}
}

function closeWindow()
{

	if(message != null && message != "" && message != " " && message != 'null')
	{

	}
	else
	{
		window.close();
	}
}

function clearScreen1(target)
{
	if(target =='consent') {
			//parent.parent.parent.workAreaFrame.location.reload();
			if(parent.workAreaFrame)
			parent.workAreaFrame.location.reload();
			else if(parent.parent.workAreaFrame)
			parent.parent.workAreaFrame.location.reload();
			else if(parent.parent.parent.workAreaFrame)
			parent.parent.parent.workAreaFrame.location.reload();
			else //if(parent.parent.parent.parent.document)
			parent.parent.parent.parent.document.location.reload();
			
		
	}
	else 
	{
		var frmObj		= document.formRefusalOrders;
		parent.refusal_main_label.location.href="../../eCommon/html/blank.html";
		parent.refusal_main_result.location.href ="../../eCommon/html/blank.html";
		frmObj.record.style.visibility='visible';

		frmObj.refusal_form.value = "";
		refusal_text.innerHTML="";
		frmObj.reason.value="";
		showCurrDate();

		if(get_curr_sys_date!=undefined)
				frmObj.datetime.value=get_curr_sys_date;
		frmObj.practitioner.value="";
	} 
	
}

function setVisitAdminDate(date)
{

		
		
	 var frmObj		= document.formRefusalOrders;

	frmObj.admissionDate.value = date;

}

//this is used to call printing
/*function callPrinting() {
    var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr +=" /></root>" ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "RefusalFormPrinting.jsp", false ) ;

	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
	eval(responseText);
}
*/

function populateSearch(){
 		if(window.event.keyCode==13){
 		searchResult1();
	}
}
function onLoadRefusalOrders(){
if(document.formRefusalOrders.patientId.value!="")
	document.formRefusalOrders.patientId.focus();
else
	document.formRefusalOrders.encounterid.focus();

}
function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
	var localeName = eval("document."+from+".localeName")

	//if(CheckDate(obj)){ //  this method is from ValidateControl.js
 if(validDateObj(obj,"DMY",localeName.value))
	{
		//if(doDateCheckOR(fromDate,toDate) == 1) { // this function is available in eOR/js/orCommonFunctions.js
		
		if(!isAfter(toDate.value,fromDate.value,'DMY',localeName.value)){	
			
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); // this message available in messages.js of ecommon/js
			obj.focus()
			return false
		}
	
	}
	else
		{
		document.refusalsearch_form.date_to.value=document.refusalsearch_form.temp_curr_sys_date.value;


		}

	
	
}
function populatePatientAgeValue1(getpatientId,target)
{
		var frmObj		= document.refusaltab_form;
		chkConsent = target;
		if( getpatientId.value == "" ) 
		{
				
				document.getElementById("result_name").innerHTML="";
		}
		else
		{
			var bean_id = frmObj.bean_id.value ;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr += getpatientId.name+"=\""+ getpatientId.value +"\" " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST", "RefusalOrdersValidate.jsp?bean_id=" + bean_id + "&default_val=''&validate=pat_det", false ) ;
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText ;
			eval(responseText );
			
			frmObj.reason.value = "";
			showCurrDate();
			frmObj.refusal_form.value = "";
			refusal_text.innerHTML="";
			
			if(frmObj.NonOrderable)
				frmObj.NonOrderable.value = "";
 
			store_ord_line_num="";
 			if(target != 'consent')
			{
				if(frmObj.order_Line_num)
					frmObj.order_Line_num.value = "";

				frmObj.neworderid.value="";
				
				if(frmObj.orderable)
					frmObj.orderable.value = "";

				frmObj.refeusal_type.value = "";
				frmObj.encounterid.value="";

				
				
				document.getElementById("ordlabel").innerHTML="";
				document.getElementById("ordtext").innerHTML="";

			}
			else
			{
				frmObj.refeusal_type1.value = "O";
				frmObj.refeusal_type1.disabled = true;
				frmObj.orderable1.readOnly = true;
				frmObj.orderable.readOnly = true;
			}
			

		}
		
}

function addcatalogcode(cat_code)
{
	if((document.formRefusalOrders.ordercode.value==null)||(document.formRefusalOrders.ordercode.value==""))
	{
		document.formRefusalOrders.ordercode.value=cat_code;
	}else //added else to get all the code values //--[IN029211]
	{
		var code_str = document.formRefusalOrders.ordercode.value;
		document.formRefusalOrders.ordercode.value= code_str+","+cat_code ;
	}
}

async function callRefusalOrderOrderables(target)
{
	
	if(trimString(target.value).length>0)
	{
		
			await callRefusalOrderOrderable1(target);
		
	}
	if(target.value=="")
	{
		document.refusalsearch_form.catalog_code.value="";
	}

}
function consent_content(exists)
{
	if(exists=="false")
	{
		alert(getMessage("REFUSAL_CONTENT_IS_NOT_CONFIRMED_CONFIRM_BEFORE_CONTINUE","OR"));
		not_proceed="false";
	}
	else
	{
		not_proceed="";
	}
}
function makeResultBlank()
{
	parent.refusal_resultframe1.location.href =  "../../eCommon/html/blank.html";
}
//IN07786 starts
function modifyEmptyTD(obj)
{
	var bodyElement = obj.childNodes;
	var i;
	for(i=0;i<bodyElement.length;i++)
	{
 
		//var cells = bodyElement[i].getElementsByTagName('td');
		if (bodyElement[i].nodeType === Node.ELEMENT_NODE) {
			var cells = bodyElement[i].getElementsByTagName('td');
			if(cells != null || cells != undefined)
			{
				for(var tdElement = 0;tdElement < cells.length ;tdElement++)
				{
					if(cells[tdElement].innerHTML == '')
					{
						cells[tdElement].innerHTML = '&nbsp;'
					}
				}
			}
		}
	}
}
//IN07786 ends


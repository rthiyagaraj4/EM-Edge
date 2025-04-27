/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var bean_id = "";
var bean_name = "";
var xmlDom;
var xmlHttp;

function reset() {
	f_query_add_mod.document.formReportPackLabel.reset();
}



function run()
{

		var formObj	=	parent.f_query_add_mod.document.formReportPackLabel;
		var messageFrame	=	parent.messageFrame;
			// add the data mandatory validation
			var fields= new Array (formObj.p_fm_doc_date1,formObj.p_to_doc_date1);  
			var names= new Array (getLabel("Common.fromdate.label","Common"),getLabel("Common.todate.label","Common")); 
			if(checkFields(fields,names,messageFrame) ) {

				if( isValidFromToField(formObj.p_fm_doc_type, formObj.p_to_doc_type,STRING, "Doc Type" ,messageFrame )  )
				{
					if( isValidFromToField( formObj.P_fm_doc_no,formObj.P_to_doc_no,LONG, "Doc No" ,messageFrame )  )
							if(isValidFromToField(formObj.p_fm_doc_date1,formObj.p_to_doc_date1 ,DATE,"Doc Date"  ,messageFrame))
								if ( isValidFromToField(formObj.P_fm_group_code,formObj.P_to_group_code, STRING, "Group Code" , messageFrame )  )
									if( isValidFromToField( formObj.P_fm_tray_no,formObj.P_to_tray_no,LONG, "Tray No" ,messageFrame )  ){
									formObj.p_fm_doc_date.value=convertDate(formObj.p_fm_doc_date1.value,'DMY',formObj.locale.value,"en");
									formObj.p_to_doc_date.value=convertDate(formObj.p_to_doc_date1.value,'DMY',formObj.locale.value,"en");

									var days_between  = daysBetween(formObj.p_fm_doc_date.value, formObj.p_to_doc_date.value, 'DMY', formObj.locale.value);

									if(days_between<=89) { //90 days
										parent.f_query_add_mod.document.formReportPackLabel.submit(); // Report can be executed
									} else {
										alert(getMessage("SS_DATE_DIFFERENCE","SS"));

									}
								}
			
				}		
			} 
}

async function searchCodeDocumentType(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formReportPackLabel.p_facility_id.value;
	dataTypeArray  [0]=STRING
	argumentArray[0] = document.formReportPackLabel.SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.formReportPackLabel.locale.value;
	dataTypeArray  [1]=STRING
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.documenttype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	}
}

async function searchGroup( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formReportPackLabel.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportPackLabel.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 var arr=ret1.split(",");
			if(arr[1]==undefined) 
			{
				arr[0]="";	
				arr[1]="";	
			}
		
		obj.value = arr[0];
	}
}


//ML-MMOH-CRF-1821 - STARTS
function checkToDate(obj,format,locale)
{
	var from = document.formReportPackLabel.p_fm_doc_date1;
	if(obj.value !="")
	{
		if(CheckDate(obj))
		{
			if(!doDateCheckAlert(from,obj))
			{
				alert(getMessage("TO_DATE_EQUAL_GREATER_FROM_DATE","PH"));
				obj.select();
				obj.focus();
				return false;
			}
		}
	}
}



function CheckFromDate(obj,format,locale)
{
	if(obj.value !="")
	{
		if(CheckDate(obj))
		{
			/*if(isBeforeNow(obj.value,format,locale))
			{
				return true;
			}
			else
			{
				var label=getLabel("Common.DateRange.label","COMMON");
				var msg = getMessage("DATE_NOT_GREATER_SYSDATE","COMMON");
				msg = msg.replace('$$',label);
				alert(msg);
				obj.select();
				obj.focus();
				return false;
			}*/
		}
	}
}

//ML-MMOH-CRF-1821 - ENDS

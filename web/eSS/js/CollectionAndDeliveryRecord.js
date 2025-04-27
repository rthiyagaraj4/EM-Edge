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
	f_query_add_mod.document.formCollectionAndDeliveryRecord.reset();
}

function run()
{
   f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
   var formObj=f_query_add_mod.document.formCollectionAndDeliveryRecord;


					formObj.p_fm_date.value=convertDate(formObj.p_fm_date.value,'DMY',formObj.p_language_id.value,"en");

					formObj.p_to_date.value=convertDate(formObj.p_to_date.value,'DMY',formObj.p_language_id.value,"en");

				if(formObj.p_fm_date.value != "" && formObj.p_to_date.value != "" ){
		  if(!isBefore(formObj.p_fm_date.value,formObj.p_to_date.value,"DMY",'en'.value)) {
         alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
         formObj.p_to_date.focus();
          return ;	
        } 
	  }

	   if(formObj.p_fm_date.value == ""){
	   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
      formObj.p_fm_date.focus();
      return ;	
	   }

	   if(formObj.p_to_date.value == ""){
		   alert(getMessage("TO_DATE_NOT_BLANK", "SS"));
	       formObj.p_to_date.focus();
	       return ;	
		   }

	  

			   formObj.submit();


		}

//function run()
//{
//   var formObj=f_query_add_mod.document.formLogSheetForAutoclavePlasma;
//  
//	if (isValidFromToField(formObj.p_load_fm, formObj.p_load_to, LONG, "Load No", messageFrame)) 
//		//if (isValidFromToField(formObj.p_fm_date, formObj.p_to_date, DATE, "Autoclave Date", messageFrame)) 
//					formObj.p_fm_date.value=convertDate(formObj.p_fm_date.value,'DMY',formObj.p_language_id.value,"en");
//					formObj.p_to_date.value=convertDate(formObj.p_to_date.value,'DMY',formObj.p_language_id.value,"en");
//					  if(formObj.p_fm_date.value != "" && formObj.p_to_date.value != "" ){
//						  if(!isBefore(formObj.p_fm_date.value,formObj.p_to_date.value,"DMY",'en'.value)) {
//				          alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
//				          formObj.p_to_date.focus();
//				           return ;	
//				         } 
//					  }
//					   if(formObj.p_fm_date.value == ""){
//					   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
//				       formObj.p_fm_date.focus();
//				       return ;	
//					   }
//					   
//					   if(formObj.p_to_date.value == ""){
//						   alert(getMessage("TO_DATE_NOT_BLANK", "SS"));
//					       formObj.p_to_date.focus();
//					       return ;	
//						   }alert(5555);
//			formObj.submit();
//
//
//}
async function searchGroup( obj ) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.formCollectionAndDeliveryRecord.SQL_SS_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID";
	dataValueArray [0]=document.formCollectionAndDeliveryRecord.p_language_id.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
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
async function searchCodeStore(obj) {
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="p_facility_id";
	dataValueArray [0]=document.formCollectionAndDeliveryRecord.p_facility_id.value;
	dataTypeArray  [0]=STRING;

	argumentArray[0] = document.formCollectionAndDeliveryRecord.SQL_SS_STORE_LOOKUP.value;
	
	dataNameArray  [1]="LANGUAGE_ID";
	dataValueArray [1]=document.formCollectionAndDeliveryRecord.p_language_id.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues = await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
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

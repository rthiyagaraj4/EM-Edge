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
	f_query_add_mod.document.WasherTosiAndSoniCheckLog.reset();
}


function searchCodeAutoclaveWashingUnitCode( obj) {
	
	//var result		=	false ;
	//var message		=	"" ;
//	var flag		=	"" ;
    var function_id = "";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		
		
        argumentArray[0] = document.forms[0].SQL_SS_AUTO_WASH_UNIT_LOOK_WASHTYPE.value;
		dataNameArray  [0]="LANGUAGE_ID";
		dataValueArray [0]=document.forms[0].locale.value;
		dataTypeArray  [0]=STRING;
		dataNameArray  [1]="facility_id";  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
		dataValueArray [1]=document.forms[0].p_facility_id.value;
		dataTypeArray  [1]=STRING;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		//argumentArray[4] = "2,3";
		argumentArray[4] = "3,4";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;

		returnedValues = CommonLookup(getLabel("eSS.AutoclaveWashUnit.label","ss"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			obj.value = returnedValues[0];
		}
	}

	function searchCodeAutoclaveWashingTest( obj) {
		
	//var result		=	false ;
	//var message		=	"" ;
	//var flag		=	"" ;
	  var function_id = "";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		
		
        argumentArray[0] = document.forms[0].SQL_SS_AUTO_WASH_UNIT_LOOK_TESTTYPE.value;
		dataNameArray  [0]="LANGUAGE_ID";
		dataValueArray [0]=document.forms[0].locale.value;
		dataTypeArray  [0]=STRING;
		dataNameArray  [1]="facility_id";  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
		dataValueArray [1]=document.forms[0].p_facility_id.value;
		dataTypeArray  [1]=STRING;
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
		//argumentArray[4] = "2,3";
		argumentArray[4] = "3,4";
		argumentArray[5] = obj.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;

		returnedValues = CommonLookup(getLabel("eSS.AutoclaveWashTest.label","ss"), argumentArray );
		if((returnedValues != null) && (returnedValues != "") )  {
			obj.value = returnedValues[0];
		}
	}

	function run()
	{
	   var formObj=f_query_add_mod.document.WasherTosiAndSoniCheckLog;
	  
	   
						formObj.p_fm_date.value=convertDate(formObj.p_fm_date1.value,'DMY',formObj.p_language_id.value,"en");
						
						formObj.p_to_date.value=convertDate(formObj.p_to_date1.value,'DMY',formObj.p_language_id.value,"en");
						
					if(formObj.p_fm_date1.value != "" && formObj.p_to_date1.value != "" ){
			  if(!isBefore(formObj.p_fm_date.value,formObj.p_to_date.value,"DMY",'en'.value)) {
	         alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
	         formObj.p_to_date1.focus();
	          return ;	
	        } 
		  }
					
		   if(formObj.p_fm_date1.value == ""){
		   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
	      formObj.p_fm_date1.focus();
	      return ;	
		   }
		   
		   if(formObj.p_to_date1.value == ""){
			   alert(getMessage("TO_DATE_NOT_BLANK", "SS"));
		       formObj.p_to_date1.focus();
		       return ;	
			   }
		   
		   if (isValidFromToField(formObj.p_auto_clave_wash_unit_fm, formObj.p_auto_clave_wash_unit_to, STRING, "Autoclave Wash Unit", messageFrame))
		    
			   if (isValidFromToField(formObj.p_test_code_fm, formObj.p_test_code_to, STRING, "Autoclave Wash Test", messageFrame))
				
				   formObj.submit();
		   	    
		   	 
			}
			

		           		// formObj.submit();
	


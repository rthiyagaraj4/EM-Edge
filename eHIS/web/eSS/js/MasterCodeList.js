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

function reset() 
{
	//alert(parent.frames[2].frames[1].frames[0].name);
	parent.frames[2].frames[1].frames[0].document.forms[0].master_code.value="";
	parent.frames[2].frames[1].frames[0].loadPage();
//	parent.f_query_add_mod.document.MasterCodeListFrame.reset();
	//parent.parent.MasterCodeListFrame.document.MasterCodeListFrame.reset();
}

function loadPage()
{
	parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
	if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_STERILIZATION_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportSterilizationType.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_SURGERY_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportSurgeryType.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_SERVICE_LOCATION")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportServiceLocation.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_AUTOCLAVE_WASH_UNIT")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportAutoclaveWashUnit.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_AUTOCLAVE_WASH_TEST")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportAutoclaveWashTest.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_WRITE_OFF_REASON")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportWriteOffReason.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_USAGE_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportUsageType.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_SUB_CLASSIFICATION")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportSubClassification.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_STER_PROCESS_STAGE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportSterProcessStage.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_WASHING_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportWashingType.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_STAT_GROUP")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportStatGroup.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_STORE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportStore.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_ITEM")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportItem.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_GROUP")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportGroup.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_STERILIZATION_COST")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportSterilizationCost.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_ALTERNATE_GROUP")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportAlternateGroup.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_GROUP_FOR_STORE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportGroupForStore.jsp'
	}
	else if(parent.MasterCodeListFrame.document.MasterCodeListFrame.master_code.value=="SS_TRN_DOC_TYPE")
	{
		parent.MasterCodePages.document.location.href='../../eSS/jsp/ReportTrnDocType.jsp'
	}
	else
	{
		parent.MasterCodePages.document.location.href='../../eCommon/html/blank.html'
	}
}

function run()
{
	var formObj;
/*			var formObj	=	f_query_add_mod.document.formFinalizedReturnReport;
	if (isValidFromToField(formObj.Fr_store_code, formObj.To_store_code, STRING, "Return From", messageFrame)) 
		if (isValidFromToField(formObj.Fr1_store_code, formObj.To1_store_code, STRING, "Return To", messageFrame)) 
			if (isValidFromToField(formObj.p_frm_doc_type_code, formObj.p_to_doc_type_code, STRING, "Document Type", messageFrame)) 
				if (isValidFromToField(formObj.p_frm_doc_no, formObj.p_to_doc_no, LONG, "Document No", messageFrame)) 
					if (isValidFromToField(formObj.p_frm_doc_date, formObj.p_to_doc_date, DATE, "Document Date", messageFrame)) 
						formObj.submit();
*/
		if(f_query_add_mod.MasterCodePages.document.formReportSterilizationType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportSterilizationType;
			//if( CheckString("Sterilization Type" , f_query_add_mod.MasterCodePages.document.formReportSterilizationType.p_from_code,f_query_add_mod.MasterCodePages.document.formReportSterilizationType.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Sterilization Type", messageFrame)) 
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportSurgeryType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportSurgeryType;
		//	if( CheckString("Surgery Type" , f_query_add_mod.MasterCodePages.document.formReportSurgeryType.p_from_code,f_query_add_mod.MasterCodePages.document.formReportSurgeryType.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Surgery Type", messageFrame)) 
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportServiceLocation)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportServiceLocation
	//		if( CheckString("Service Location" , f_query_add_mod.MasterCodePages.document.formReportServiceLocation.p_from_code,f_query_add_mod.MasterCodePages.document.formReportServiceLocation.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Service Location", messageFrame)) 
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingUnit)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingUnit;
//			if( CheckString("Autoclave Washing Unit" , f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingUnit.p_from_code,f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingUnit.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Autoclave Wash Unit", messageFrame))
				if (isValidFromToField(formObj.p_from_service_code, formObj.p_to_service_code, STRING, "Service Location", messageFrame))
					formObj.submit();
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingTest)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingTest;
	//		if( CheckString("Autoclave Washing Test" , f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingTest.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportAutoclaveWashingTest.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Autoclave Wash Test", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportWriteOffReason)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportWriteOffReason;
//			if( CheckString("Write Off Reason" , f_query_add_mod.MasterCodePages.document.formReportWriteOffReason.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportWriteOffReason.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Write Off Reason", messageFrame))
			{
				formObj.submit();
			}
		}
	else if(f_query_add_mod.MasterCodePages.document.formReportUsageType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportUsageType;
//			if( CheckString("Usage Type" , f_query_add_mod.MasterCodePages.document.formReportUsageType.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportUsageType.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Usage Type", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportSubClassification)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportSubClassification
//			if( CheckString("Sub Classification" , f_query_add_mod.MasterCodePages.document.formReportSubClassification.p_from_code,f_query_add_mod.MasterCodePages.document.formReportSubClassification.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Sub Classification", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportSterProcessStage)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportSterProcessStage;
			//if( CheckString("Sterilization Process" , f_query_add_mod.MasterCodePages.document.formReportSterProcessStage.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportSterProcessStage.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Sterilization Process Stage", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportWashingType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportWashingType;
//			if( CheckString("Washing Type" , f_query_add_mod.MasterCodePages.document.formReportWashingType.Fr_washing_type,f_query_add_mod.MasterCodePages.document.formReportWashingType.To_washing_type, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Washing Type", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportStatGroup)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportStatGroup;
			//if( CheckString("Statistical Type" , f_query_add_mod.MasterCodePages.document.formReportStatGroup.p_from_code,f_query_add_mod.MasterCodePages.document.formReportStatGroup.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Statistical Group", messageFrame))
			{
				formObj.submit();
			}
		}
		else if(f_query_add_mod.MasterCodePages.document.formReportStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportStore;

			if (formObj.p_report_type.value=="1")
				 formObj.p_report_id.value="SSBSTORE";
			else
				 formObj.p_report_id.value="SSBSTRDT";

			//if( CheckString("Store" , f_query_add_mod.MasterCodePages.document.formReportStore.p_fm_store_code,f_query_add_mod.MasterCodePages.document.formReportStore.p_to_store_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_store_code, formObj.p_to_store_code, STRING, "Store", messageFrame))
			{
				//if( CheckString("Department" , f_query_add_mod.MasterCodePages.document.formReportStore.p_fm_dept_code,f_query_add_mod.MasterCodePages.document.formReportStore.p_to_dept_code, messageFrame )  )
				if (isValidFromToField(formObj.p_fm_dept_code, formObj.p_to_dept_code, STRING, "Department", messageFrame))
				{

				formObj.submit();
				}
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportItem)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportItem;
			if (formObj.p_report_type.value=="1")
				 formObj.p_report_id.value="SSBITEMS";
			else
				 formObj.p_report_id.value="SSBITMDT";
			
		//	if( CheckString("Item" , f_query_add_mod.MasterCodePages.document.formReportItem.Fr_item_code,f_query_add_mod.MasterCodePages.document.formReportItem.To_item_code, messageFrame )  )
			if (isValidFromToField(formObj.p_from_code, formObj.p_to_code, STRING, "Item", messageFrame))
			{
				formObj.submit();
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportGroup)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportGroup;
		//	if( CheckString("Group" , f_query_add_mod.MasterCodePages.document.formReportGroup.p_fm_group_code,f_query_add_mod.MasterCodePages.document.formReportGroup.p_to_group_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_group_code, formObj.p_to_group_code, STRING, "Group Code", messageFrame))
			{
//				if( CheckString("Item Class" , f_query_add_mod.MasterCodePages.document.formReportGroup.p_fm_item_class_code,f_query_add_mod.MasterCodePages.document.formReportGroup.p_to_item_class_code, messageFrame )  )
                  //Added by Rabbani #inc no:40147(ML-BRU-SCF-0854) on 21-MAY-2013
                 if (formObj.p_report_type.value=="1")
				 formObj.p_report_id.value="SSBGROUP";
			     else
				 formObj.p_report_id.value="SSBGRPDT";
				 //ends
				if (isValidFromToField(formObj.p_fm_item_class_code, formObj.p_to_item_class_code, STRING, "Item Class", messageFrame))
				{
				formObj.submit();
				}
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportSterilizationCost)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportSterilizationCost;
//			if( CheckString("Sterilization Cost" , f_query_add_mod.MasterCodePages.document.formReportSterilizationCost.p_fm_sterile_type,f_query_add_mod.MasterCodePages.document.formReportSterilizationCost.p_to_sterile_type, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_sterile_type, formObj.p_to_sterile_type, STRING, "Sterilization Type", messageFrame))
			{
				//if( CheckString("Group" , f_query_add_mod.MasterCodePages.document.formReportSterilizationCost.p_fm_group_code,f_query_add_mod.MasterCodePages.document.formReportSterilizationCost.p_to_group_code, messageFrame )  )
				if (isValidFromToField(formObj.p_fm_group_code, formObj.p_to_group_code, STRING, "Group Code", messageFrame))
				{
					formObj.submit();
				}
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportAlternateGroup)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportAlternateGroup;
			//if( CheckString("Alternate Group" , f_query_add_mod.MasterCodePages.document.formReportAlternateGroup.p_fm_code,f_query_add_mod.MasterCodePages.document.formReportAlternateGroup.p_to_code, messageFrame )  )
			if (isValidFromToField(formObj.p_fm_code, formObj.p_to_code, STRING, "Group", messageFrame))
			{
				formObj.submit();
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportGroupForStore)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportGroupForStore;
			//if( CheckString("Store" , f_query_add_mod.MasterCodePages.document.formReportGroupForStore.P_fm_store_code,f_query_add_mod.MasterCodePages.document.formReportGroupForStore.P_to_store_code, messageFrame )  )
				if (isValidFromToField(formObj.P_fm_store_code, formObj.P_to_store_code, STRING, "Store Code", messageFrame))
			//if( CheckString("Group" , f_query_add_mod.MasterCodePages.document.formReportGroupForStore.P_fm_group_code,f_query_add_mod.MasterCodePages.document.formReportGroupForStore.P_to_group_code, messageFrame )  )
				if (isValidFromToField(formObj.P_fm_group_code, formObj.P_to_group_code, STRING, "Group Code", messageFrame))
			//	{
					formObj.submit();
//				}
//			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportTrnDocType)
		{
			formObj=f_query_add_mod.MasterCodePages.document.formReportTrnDocType;
			//if( CheckString("Document Type" , f_query_add_mod.MasterCodePages.document.formReportTrnDocType.P_fm_code,f_query_add_mod.MasterCodePages.document.formReportTrnDocType.P_to_code, messageFrame )  )
			if (isValidFromToField(formObj.P_fm_code, formObj.P_to_code, STRING, "Document Type Code", messageFrame))
			{
				formObj.submit();
			}
		}
			else if(f_query_add_mod.MasterCodePages.document.formReportUserAccessForStore)
		{
/*			if( CheckString("Document Type" , f_query_add_mod.MasterCodePages.document.formReportTrnDocType.p_from_code,f_query_add_mod.MasterCodePages.document.formReportUserAccessForStore.p_to_code, messageFrame )  )
			{
				
				f_query_add_mod.MasterCodePages.document.formReportUserAccessForStore.submit();
			}
*/
		}
}


async function searchCodeDocumentType(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.formPackingCheckReport.p_facility_id.value;
	dataTypeArray  [0]=STRING

	argumentArray[0] = document.formPackingCheckReport.SQL_SS_DOC_TYPE_ROF_LIST_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.documenttype.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		 var ret1=unescape(returnedValues);
		 	arr=ret1.split(","); 
		obj.value = arr[0];
	} 
}

async function searchCodeSterilizationType( objCode ) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
    /*
	dataNameArray  [0]="facility_id"
	dataValueArray [0]=document.forms[0].p_facility_id.value;
	dataTypeArray  [0]=STRING
     */
	// var language_id=document.formReportSterilizationType.locale.value;
	argumentArray[0] = document.formReportSterilizationType.SQL_SS_STERILIZATION_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.formReportSterilizationType.locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	
	argumentArray[5] = objCode.value;
	
	argumentArray[6] = CODE_LINK;
	
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.SterilizationType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		 var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				objCode.value = arr[0];
		//obj.value = returnedValues[0];
		
   } 
}

async function searchCodeItemClass( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.item.label", "Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		arr=ret1.split(",");  
		obj.value = arr[0];

	} 
}
async function searchCodeSurgeryType( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_SURGERY_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;

	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.SurgeryType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeServiceLocation( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_SERVICE_LOCATION_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eSS.ServiceLocation.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeAutoclaveWashingUnitCode( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_AUTOCLAVE_WASH_UNIT_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	dataNameArray  [1]="facility_id"  //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
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

	returnedValues = await CommonLookup(getLabel("eSS.AutoclaveWashUnit.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeAutoclaveWashingTest( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_AUTOCLAVE_WASH_TEST_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	
	dataNameArray  [1]="facility_id"   //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	dataValueArray [1]=document.forms[0].p_facility_id.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,3";
	argumentArray[4] = "3,4";//Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.AutoclaveWashTest.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeWriteOffReason( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_WRITE_OFF_REASON_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] =obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.WriteoffReason.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeUsageType( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_USAGE_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.UsageType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeSubClassification( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_SUB_CLASSIFICATION_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup(getLabel("eSS.SubClassification.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeSterProcessStage( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_STER_PROCESS_STAGE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.SterilizationProcessStage.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		 var ret1=unescape(returnedValues);
		 	arr=ret1.split(","); 
		obj.value = arr[0];
		
	} 
}
async function searchCodeWashingType( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_WASHING_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eSS.WashingType.label","ss") , argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeStatGroup( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_STAT_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("eSS.StatisticalGroup.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeItem( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_ITEM_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.item.label", "Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeGroup(obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	//var p_group_code = "";
	var p_surgery_type = document.getElementById("P_Surgery_Type").value;

	//argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_REPORT.value;
	//Added against KDAH_CRF-0247
	if(p_surgery_type == ""){
		argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_REPORT.value;
	}else{
		argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_FOR_CSSD_GROUP_SURG_TYPE_REPORT.value;
	}
	//Added ends
			
	dataNameArray  [0]="p_group_code";
	dataValueArray [0]=document.forms[0].p_group_code.value;
	dataTypeArray  [0]=STRING;
	//Added ends
	dataNameArray  [1]="LANGUAGE_ID";
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	if(p_surgery_type != ""){
	dataNameArray  [2]="p_surgery_type";
	dataValueArray [2]=p_surgery_type;
	dataTypeArray  [2]=STRING;
	}
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	//argumentArray[4] = "2,3";
	if(p_surgery_type == ""){
	argumentArray[4] = "3,4";
	}else{
	argumentArray[4] = "4,5";
	}
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup( getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeGroup1( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	
	argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
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
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeSterilizationCost( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_STERILIZATION_TYPE_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"
	dataValueArray [0]=document.forms[0].locale.value;
	dataTypeArray  [0]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("eSS.Sterilization.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeTrnDocType( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.forms[0].SQL_SS_TRN_DOC_TYPE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("eSS.TRNDocType.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeDept( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_DEPT_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.department.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeDeptForFacility( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	dataNameArray[0]  = "operating_facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;
	argumentArray[0] = document.forms[0].SQL_SS_DEPT_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues = await CommonLookup(getLabel("Common.department.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

async function searchCodeAlternateGroup( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	argumentArray[0] = document.forms[0].SQL_SS_ALTERNATE_GROUP_LOOKUP.value;
	dataNameArray  [0]="LANGUAGE_ID"	
	dataValueArray [0]=document.forms[0].locale.value;
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
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}
async function searchCodeUserMaster( obj, objDesc ) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_USER_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup(getLabel("Common.user.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");   
		objCode.value = arr[1];
		objDesc.value = arr[0];
		
	} 
}
async function searchCodeUser( objCode, objDesc ) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_USER_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup( getLabel("Common.user.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");   
		objCode.value = arr[0];
		objDesc.value = arr[1];
	} 
}
async function searchCodeStore( obj) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.forms[0].SQL_SS_STORE_LOOKUP.value;
	dataNameArray  [1]="LANGUAGE_ID"
	dataValueArray [1]=document.forms[0].locale.value;
	dataTypeArray  [1]=STRING;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "3,4";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues =await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
//		objCode.value = returnedValues[1];
	} 
}

async function searchCodeStoreMaster( objCode, objDesc ) {
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	
	dataNameArray[0]  = "facility_id";
	dataValueArray[0]  = document.forms[0].p_facility_id.value;
	dataTypeArray[0] = STRING;

	argumentArray[0] = document.forms[0].SQL_SS_STORE_LOOKUP.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,3";
	argumentArray[5] = objDesc.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;
	

	returnedValues =await CommonLookup( getLabel("eSS.Store.label","ss"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");   
		objCode.value = arr[1];
		objDesc.value = arr[0];
	} 
}
async function searchCodeGroupMaster( obj) {

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();

	argumentArray[0] = document.forms[0].SQL_SS_GROUP_LOOKUP_FOR_REPORT.value;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = CODE_DESC;

	returnedValues =await CommonLookup(getLabel("Common.Group.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");  
				obj.value = arr[0];
	} 
}

//Added against KDAH-CRF-0247
async function callSurgeryTypeSearchWindow(code) {

	retVal = await window.showModalDialog("../../eSS/jsp/SurgeryTypeSearchFrame.jsp?&typed_text="+code.value ,"", "dialogHeight:500px; dialogWidth:800px; center:0; status: no; dialogLeft :0px; dialogTop :0px;");
	if (retVal !=undefined) {
		code.value = retVal[0];
	}
}

function ModifySearch(code1,desc1,code2,desc2) {
    
	var retVal = code1 + "~" + desc1 + "~" + code2 + "~" + desc2 ;
    top.window.returnValue = retVal.split("~"); ;
    top.close();
}//Added ends

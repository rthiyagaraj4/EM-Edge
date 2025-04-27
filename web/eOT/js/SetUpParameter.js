/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply()
{	
		var fields = new Array (f_query_add_mod.document.forms[0].oper_code_scheme);
		var operation_code_scheme=getLabel("eOT.OperationCodeScheme.Label","OT");
		var names = new Array ( operation_code_scheme);

		if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
}

function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/SetUpParameterAddModify.jsp?mode=modify';
	else
         f_query_add_mod.location.reload();

}

function reset()
{
	f_query_add_mod.document.forms[0].reset();
}

function setCheckValue()
{
	if(document.forms[0].oper_num_date_prefix_yn.checked==true)
		document.forms[0].oper_num_date_prefix_yn.value="Y";
	else
		document.forms[0].oper_num_date_prefix_yn.value="N";
}
function setCheckValue1()
{
	if(document.forms[0].build_anaesthesia_into_cr_yn.checked==true)
		document.forms[0].build_anaesthesia_into_cr_yn.value="Y";
	else
		document.forms[0].build_anaesthesia_into_cr_yn.value="N";
}
//CRF-004 Authorize Slots for Booking - Rajesh V
function setCheckValueSlots()
{
	if(document.forms[0].schedule_restrict_yn.checked==true)
		document.forms[0].schedule_restrict_yn.value="Y";
	else
		document.forms[0].schedule_restrict_yn.value="N";
}
//CRF-004 Authorize Slots for Booking - Rajesh V
async function searchOperativeRecordNoteType(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("eOT.OperativeRecordsNoteType.Label","OT");	
	//var sql="SELECT NOTE_TYPE_DESC DESCRIPTION, NOTE_TYPE CODE FROM	 CA_NOTE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D')='E' AND UPPER(NOTE_TYPE_DESC) LIKE UPPER(?) AND UPPER(NOTE_TYPE) LIKE UPPER(?) ORDER BY 1"; //Commented By MuthuN against 36894
	/* Below Query is Modified by MuthuN against 36894 */
	var sql="SELECT a.NOTE_TYPE_DESC DESCRIPTION, a.NOTE_TYPE CODE FROM	 CA_NOTE_TYPE_LANG_VW a, ca_note_group b WHERE a.LANGUAGE_ID='"+locale+"' AND NVL(a.EFF_STATUS,'D')='E' AND UPPER(a.NOTE_TYPE_DESC) LIKE UPPER(?) AND UPPER(a.NOTE_TYPE) LIKE UPPER(?) AND a.note_group_id = b.note_group AND b.appl_task_id = 'OT_NOTES' ORDER BY 1";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
	}else{
		target.value="";
		obj.value="";
	}
 }

async function callDialog(param)
{
	var dialogTop			= "40";
	var dialogHeight		= "10";
	var dialogWidth			= "40";
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no";
	var arguments			= "";
	retVal=await window.showModalDialog("../../eOT/jsp/OTGeneralSearchFrames.jsp?"+param,arguments,features);
	return retVal;
}


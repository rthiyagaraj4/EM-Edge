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
		var fields = new Array (f_query_add_mod.document.forms[0].pre_anes_note_type,f_query_add_mod.document.forms[0].intra_anes_note_type, f_query_add_mod.document.forms[0].post_anes_note_type, f_query_add_mod.document.forms[0].intra_anaesthesia_chart_id,f_query_add_mod.document.forms[0].post_anaesthesia_chart_id );
		var preAnaesthesiaNoteType=getLabel("eOT.PreAnaesthesiaNoteType.Label","OT");
		//var intraAnaesthesiaNotes=getLabel("eOT.IntraAnaesthesiaNotes.Label","OT");
		var intraAnaesthesiaNotes=getLabel("eOT.IntraAnaesthesiaNoteType.Label","OT");
	//	var postAnaesthesiaNotes=getLabel("eOT.PostAnaesthesiaNotes.Label","OT");
		var postAnaesthesiaNotes=getLabel("eOT.PostAnaesthesiaNoteType.Label","OT");
		var intraAnaesthesiaChartID=getLabel("eOT.IntraAnaesthesiaChartID.Label","OT");
		var postAnaesthesiaChartID=getLabel("eOT.PostAnaesthesiaChartID.Label","OT");
		var names = new Array ( preAnaesthesiaNoteType, intraAnaesthesiaNotes, postAnaesthesiaNotes,intraAnaesthesiaChartID, postAnaesthesiaChartID);

		if(checkFieldsofMst(fields, names, messageFrame)) 
			{	
				f_query_add_mod.document.forms[0].submit();
			}
}
function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOT/jsp/AnaesthSetUpParamAddModify.jsp?mode=modify';
	else
         f_query_add_mod.location.reload();
}
function reset()
{
	f_query_add_mod.document.forms[0].reset();
}
async function searchNoteType(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.NoteType.label","common")+" "+getLabel("Common.search.label","common");
	//var sql="SELECT NOTE_TYPE_DESC DESCRIPTION, NOTE_TYPE CODE FROM CA_NOTE_TYPE_LANG_VW where NVL(EFF_STATUS,'D')='E' AND UPPER(NOTE_TYPE_DESC) LIKE UPPER(?) AND UPPER(NOTE_TYPE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1"; //Commented By MuthuN against 36894
	/* Below Query is Modified by MuthuN against 36894 */
	var sql="SELECT NOTE_TYPE_DESC DESCRIPTION, NOTE_TYPE CODE FROM CA_NOTE_TYPE_LANG_VW a, ca_note_group b where NVL(a.EFF_STATUS,'D')='E' AND UPPER(a.NOTE_TYPE_DESC) LIKE UPPER(?) AND UPPER(a.NOTE_TYPE) LIKE UPPER(?) AND a.LANGUAGE_ID='"+locale+"' AND a.note_group_id = b.note_group AND b.appl_task_id = 'OT_NOTES' ORDER BY 1";
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

 async function searchChartId(obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.ChartID.label","Common")+" "+getLabel("Common.search.label","common");
	var sql="SELECT SHORT_DESC DESCRIPTION, CHART_ID CODE FROM CA_CHART_LANG_VW where NVL(EFF_STATUS,'D')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(CHART_ID) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 1";
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

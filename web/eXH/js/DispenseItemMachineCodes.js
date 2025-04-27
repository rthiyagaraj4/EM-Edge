function create()
{	 	 
	var mode = "Insert";
	f_query_add_mod.location.href = "../../eXH/jsp/ItemForAutoDispenserMain.jsp?mode=" + mode + "&function_id=ccc";
		
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

}

//********************************************************************************************
//  function apply method
//********************************************************************************************
function apply()
{
	//window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";

	
	if(parent.content.f_query_add_mod.queue_frame != null) {

	var formObj1 = parent.content.f_query_add_mod.queue_frame.document.forms[0];
	var mode = formObj1.document.getElementById("mode").value;
	//alert("mode in apply :: "+mode);
	if( parent.content.f_query_add_mod.queue_frame != null) {
	
		var formObj = parent.content.f_query_add_mod.queue_frame.document.forms[0];
		
		//alert("formObj.."+formObj);
		var totrecords = formObj.document.getElementById("dispItemsMachineCodesListTable").rows.length-1;
		//alert("totrecords.."+totrecords);			
		for( index= 1 ; index<= parseInt(totrecords);index++)
		{	
			var selectflag = eval("f_query_add_mod.queue_frame.document.formDispItemsForMachineCodesList.selectBox"+index);
			var hidSelectflag = eval("f_query_add_mod.queue_frame.document.formDispItemsForMachineCodesList.hid_selectBox"+index);

			//alert (index+" ::: selectflag :::"+selectflag);
			
			hidSelectflag.value = 0;

			if (selectflag.checked == true)
			{
				hidSelectflag.value = 1;
			}
			
		}

		
		formObj.method='post';
		formObj.action="../../servlet/eXH.XHDispItemsForMachineCodeServlet?totalRecords="+totrecords+"&mode="+mode;
		formObj.target ="messageFrame";
		formObj.submit();
	}
	else {
			var error = "";
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
			return false;
		}
	}
	
	
	window.commontoolbarFrame.document.location.reload();	
	
}
function onSuccess()
	{	
     parent.f_query_add_mod.location.reload();
	}


//********************************************************************************************
//  function query method
//********************************************************************************************
function query()
{
	
	//alert("Query");
	window.f_query_add_mod.location.href="../../eXH/jsp/DispItemsForMachineCodesQueryCriteria.jsp";
	window.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
}
//********************************************************************************************
// function GetMachineLookup
//********************************************************************************************
function GetMachineLookup(target){
	
	var locale=	this.document.forms[0].locale.value;
	var mode=this.document.forms[0].mode.value;
	
			
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var tit= getLabel("eXH.Machine.label","common");	
	

	
	sql = "SELECT MACHINE_CODE code, long_desc description FROM XH_DISP_MACHINE_CODES WHERE UPPER(MACHINE_CODE) like UPPER(?) AND UPPER(long_desc) LIKE UPPER(?) ORDER BY 2";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	//alert("retVal"+retVal);

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		document.forms[0].machine.value=arr[0];
	}
	else
	{
	}
}

//********************************************************************************************
// function GetFacilityLookup
//********************************************************************************************
function GetFacilityLookup(target){
	
	var locale=	this.document.forms[0].locale.value;
	var mode=this.document.forms[0].mode.value;
	
			
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var tit= getLabel("eXH.FacilityID.label","common");	
	

	
	sql = " SELECT FACILITY_ID CODE, FACILITY_NAME DESCRIPTION FROM SM_FACILITY_PARAM WHERE UPPER(FACILITY_ID) like UPPER(?) AND UPPER(FACILITY_NAME) LIKE UPPER(?) ORDER BY 2";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	//alert("retVal"+retVal);

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		document.forms[0].facility.value=arr[0];
	}
	else
	{
	}
}

//********************************************************************************************
// function GetItemLookup
//********************************************************************************************
function GetItemLookup(target){
	
	var locale=	this.document.forms[0].locale.value;
	var mode=this.document.forms[0].mode.value;
	
			
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var tit= getLabel("eXH.item.label","common");	
	
	sql = "SELECT ITEM_CODE CODE, LONG_DESC DESCRIPTION FROM MM_ITEM WHERE UPPER(ITEM_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 2";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		document.forms[0].item.value=arr[0];
	}
	else
	{
	}
}

function checkForFacility(facility_id){
	var flag;
 	var error="";
	var facilityId = facility_id.value;
	var facilityId_label = getLabel("eXH.FacilityID.label","Common");

	if(facilityId=="") {
 		flag=false;
 		//error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",facilityId_label)+"<br>";
		alert( error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",facilityId_label));
 	}
	//alert(error);
	//parent.parent.messageFrame.location.href ='../../eCommon/jsp/error.jsp?err_num='+error;
	if(flag==false) return false; else return true;
}

//********************************************************************************************
// function GetMachineLocnLookup
//********************************************************************************************
function GetMachineLocnLookup(target, facility_id){
	//alert("facility_id.."+facility_id.value);

	var flag = checkForFacility(facility_id);

	if(flag==true){
	
	var locale=	this.document.forms[0].locale.value;
	var mode=this.document.forms[0].mode.value;
	
			
	var sql="";			
	var retVal			= new String();
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var tit= getLabel("eXH.DispLocnCode.label","common");	
	
	//sql = " SELECT DISP_LOCN_CODE CODE, LONG_DESC DESCRIPTION FROM PH_DISP_LOCN WHERE FCILITY_ID = '"+facility_id.value+"' AND UPPER(DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) ORDER BY 2 ";

	sql = " SELECT DISP_LOCN_CODE CODE, LONG_DESC DESCRIPTION FROM PH_DISP_LOCN WHERE UPPER(DISP_LOCN_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) AND FACILITY_ID = '"+facility_id.value+"' ORDER BY 2 ";
	
	argumentArray[0]	= sql;
	argumentArray[1]	= dataNameArray ;
	argumentArray[2]	= dataValueArray ;
	argumentArray[3]	= dataTypeArray ;
	argumentArray[4]	= "1,2";
	argumentArray[5]	=target.value;
	argumentArray[6]	= DESC_LINK;
	argumentArray[7]	= DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	

	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		
		document.forms[0].disp_location.value=arr[0];
	}
	else
	{
	}
	}
}

//*************************************************
// function	validatecheckbox
//*************************************************
function validatecheckbox(obj) {
	if(obj.checked==true) 	obj.value="Y";
	else  obj.value="N";

}
//*************************************************
// function	updateSingle
//*************************************************
function addForm() {
	var flag = checkNull();
	if(flag==true){
		var class_val ="";
		var required_Duplicate_Check = 0;
		var totalRows = parent.frames[2].document.getElementById("listContentTable").rows.length;
		var formObj = parent.frames[2];
		var rowCount = document.forms[0].rowCount.value;
		var item_slr = document.forms[0].srlNo.value;
		var item_Desc = document.getElementById("itemType").options[document.getElementById('itemType').selectedIndex].text;
		var item_Type = document.forms[0].itemType.value;
		var item_desc = document.forms[0].itemDesc.value;
		var item_Code = document.forms[0].itemCode.value;
		var item_Qty = document.forms[0].itemQty.value;
		var spl_Food_Item_Yn = "N";
		var freq_Yn = "N";
	}
}

//**************************************************************
// function reset
//**************************************************************
function reset(){
	
	
	if(window.f_query_add_mod.document.forms[0])
    {
	 window.f_query_add_mod.document.forms[0].reset();
	}
	else{
		create();
	}
	
	
	
		
		
}
//***********************************************
// getItemDetails
//***********************************************

function getItemDetails(facility, disp_locn, machine, item, high_alert_drug, pack_only_exp, rowCount){
	
		parent.action_frame.document.forms[0].facility_id.value = facility;
		parent.action_frame.document.forms[0].disp_locn.value = disp_locn;
		parent.action_frame.document.forms[0].machine_code.value = machine;
		parent.action_frame.document.forms[0].item_desc.value = item;
		parent.action_frame.document.forms[0].high_alert_yn.value = high_alert_drug;
		parent.action_frame.document.forms[0].pack_only_yn.value = pack_only_exp;
		parent.action_frame.document.forms[0].rowCount.value = rowCount;
		if(high_alert_drug=='Y'){
		 parent.action_frame.document.forms[0].high_alert_yn.checked = true;
		}else {
			parent.action_frame.document.forms[0].high_alert_yn.checked = false;
		}

		if(pack_only_exp=='Y'){
		 parent.action_frame.document.forms[0].pack_only_yn.checked = true;
		}else {
			parent.action_frame.document.forms[0].pack_only_yn.checked = false;
		}
		 

		parent.action_frame.document.forms[0].facility_id.disabled = true;
		parent.action_frame.document.forms[0].disp_locn.disabled = true;
		//parent.action_frame.document.forms[0].machine_code.disabled = true;
		parent.action_frame.document.forms[0].item_desc.disabled = true;
		
		
}
function getItemApply(){
	//alert("getItemApply");
}

function reloadQueueFrame(){
	//alert("reloadQueueFrame"); 
	parent.queue_frame.document.location.href='../../eXH/jsp/DispItemsForMachineCodesList.jsp';
//	parent.queue_frame.location.reload();
	parent.action_frame.location.reload(); 
	//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	//alert("end reloadQueueFrame"); 
}


//*************************************************
// function	updateSingle
//*************************************************
function checkNull(){
	var flag;
 	var error="";
	var facilityId = document.forms[0].facility_id.value;
	var facilityId_label = getLabel("eXH.FacilityID.label","Common");
	var dispLocn = document.forms[0].disp_locn.value;
	var dispLocn_label = getLabel("eXH.DispLocnCode.label","Common");
	var machine = document.forms[0].machine_code.value;
	var machine_label = getLabel("eXH.Machine.label","Common");
	var item = document.forms[0].item_desc.value;
	var item_label = getLabel("eXH.item.label","Common");

	if(facilityId=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",facilityId_label)+"<br>";
 	}
 	if(dispLocn=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",dispLocn_label)+"<br>";
 	}

	if(machine=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",machine_label)+"<br>";
 	}
 	if(item=="") {
 		flag=false;
 		error+= getMessage("CAN_NOT_BE_BLANK","Common").replace("$",item_label)+"<br>";
 	}
	parent.parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp?err_num='+error;
	if(flag==false) return false; else return true;


}

//**************************************************************************************/
 // function enableAlways
//**************************************************************************************/
function enableAlways(){
	//alert("enableAlways..");
	arrObj = document.forms[0].elements;
	alert("enableAlways in arrObj.."+arrObj+"..length.."+arrObj.length);
	for(var j=0;j<arrObj.length;j++) {
		if(arrObj[j].type=="hidden"){
//			alert("hddn elmnt Nm : "+arrObj[j].name);
			arrObj[j].disabled=false;
		}
		else {
			switch(arrObj[j].name){
				case "ove":
				case "hidden_proc_srt_cmd":
				arrObj[j].disabled=false;break;
				 }
		}
	}
}
//***********************************************************
// function reloadList
//***********************************************************
function callListPage(){
	parent.queue_frame.location.reload();
	var errorPage = "../../eCommon/jsp/error.jsp";
	var formObject = document.formDispItemsForMachineCodesTab;
	var facilityId = document.formDispItemsForMachineCodesTab.facility_id.value;
	var dispLocn = document.formDispItemsForMachineCodesTab.disp_locn.value;
	var machine = document.formDispItemsForMachineCodesTab.machine_code.value;
	var item = document.formDispItemsForMachineCodesTab.item_desc.value;
	alert("facility_Id.."+facilityId+"..dispLocn.."+dispLocn+"..machine.."+machine+"..item.."+item);

	parent.queue_frame.document.location.href='../../eXH/jsp/DispItemsForMachineCodesList.jsp?functionID='+document.forms[0].functionID.value+'&module_id='+document.forms[0].mainModule_id.value;
	parent.action_frame.location.reload(); 
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
}

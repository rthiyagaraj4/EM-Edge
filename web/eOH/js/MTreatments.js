

function create()
{
	commontoolbarFrame.document.forms[0].apply.disabled=false;
	f_query_add_mod.location.href='../../eOH/jsp/MTreatmentsAddModify.jsp?mode=insert';
}



 function getTreatmentLookUp(obj,target){	
	var locale = document.forms[0].locale.value;
	var retVal =    new String();					 
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.MTreatmentsForm;
	var order_catalog_desc = frmObj.order_catalog_desc.value;
	
	if (tit_flag="Order Catalog Search"){
	
	sql="SELECT SHORT_DESC DESCRIPTION, ORDER_CATALOG_CODE CODE FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND ORDER_CATEGORY = 'OH' AND ORDER_CATALOG_NATURE = 'S' AND EFF_STATUS = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL ORDER BY 1";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = order_catalog_desc;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit_flag, argumentArray );
	if(retVal != null && retVal != "" ){
		/*var ret1=unescape(retVal);
		//arr=retVal;
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];*/
		obj.value = retVal[0];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
		target.value=retVal[1];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
	}else{
		target.value="";
		obj.value="";	
	}
 }
 function getNotesLookUp(obj,target){	
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.MTreatmentsForm;
	var progress_note_group_desc = frmObj.progress_note_group_desc.value;
	var tit_flag=getLabel("eOH.ProgressNotes.Label","OH");
	//if (tit_flag="Order Catalog Search"){
	
	//sql="SELECT SHORT_DESC DESCRIPTION, ORDER_CATALOG_CODE CODE FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND ORDER_CATEGORY = 'OH' AND ORDER_CATALOG_NATURE = 'S' AND EFF_STATUS = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL ORDER BY 1";
	//sql="SELECT NOTE_TYPE_DESC DESCRIPTION,NOTE_TYPE CODE FROM   CA_NOTE_TYPE_LANG_VW WHERE  NOTE_GROUP_ID IN (SELECT NOTE_GROUP_ID FROM CA_NOTE_GROUP WHERE  APPL_TASK_ID ='PROGRESS_NOTES') AND    EFF_STATUS ='E' AND    LANGUAGE_ID ='"+locale+"' AND UPPER(NOTE_TYPE_DESC) LIKE UPPER(?) AND UPPER(NOTE_TYPE) LIKE UPPER(?)  ORDER BY 1";
	sql="SELECT NOTE_GROUP_DESC DESCRIPTION,NOTE_GROUP CODE  FROM CA_NOTE_GROUP_LANG_VW WHERE  APPL_TASK_ID ='PROGRESS_NOTES' AND EFF_STATUS ='E' AND LANGUAGE_ID ='"+locale+"' AND UPPER(NOTE_GROUP_DESC) LIKE UPPER(?) AND UPPER(NOTE_GROUP) LIKE UPPER(?)ORDER BY 1";
	//}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = progress_note_group_desc;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retVal = await CommonLookup( tit_flag, argumentArray );
	if(retVal != null && retVal != "" ){
		/*var ret1=unescape(retVal);
		//arr=retVal;
		arr=ret1.split(",");
		obj.value = arr[0];
		target.value=arr[1];*/
		obj.value = retVal[0];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
		target.value=retVal[1];//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
	}else{
		target.value="";
		obj.value="";	
	}
 }
function query()    
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MTreatmentQueryCriteria.jsp';
}

function reset(){
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		try{
			var formobj = window.parent.frames[1].frames[1].frames[1].document.forms[0];
			var mainformobj = window.parent.frames[1].frames[1].frames[0].document.forms[0];
			if (formobj != null)
				window.parent.frames[1].frames[1].frames[1].location.reload();
			else if(mainformobj != null)
				window.parent.frames[1].frames[1].frames[0].location.reload();
			else
				commontoolbarFrame.location.reload();
		}
		catch(failed){
		}
	}
	else{
		//f_query_add_mod.location.reload();	
		/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
		if(f_query_add_mod.document.location.href.indexOf("MTreatmentQueryResult.jsp") != -1){
			  return false;
		}
		else{
			 f_query_add_mod.document.location.reload();
		}
	}
}

async function apply(){	

	var frm=f_query_add_mod.document.forms[0];
	
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var mode=frm.mode.value;
		var fields = new Array (f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_desc,f_query_add_mod.document.forms[0].trmt_category_code,f_query_add_mod.document.forms[0].order_catalog_desc);
		var code_title=getLabel("eOH.TreatmentCode.Label","OH");
		var trmt_category_desc_title = getLabel("eOH.TreatmentDescription.Label","Common");
		var order_catalog_title = getLabel("Common.CatalogCrossReference.label","Common");
		var trmtcategorytype_title = getLabel("Common.TreatmentCategory.label","Common");
		var link_status = frm.link_status;
	   // var names = new Array ( code_title,trmt_category_desc_title,trmtcategorytype_title,order_catalog_title,trmtcategorytype_title);
        if (link_status.checked==true){
			if(mode=="insert"){
				var names = new Array ( code_title,trmt_category_desc_title,trmtcategorytype_title,order_catalog_title);
				var fields = new Array (f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_desc,f_query_add_mod.document.forms[0].trmt_category_code,f_query_add_mod.document.forms[0].order_catalog_desc);
			}else{
				var names = new Array ( code_title,trmt_category_desc_title,trmt_category_desc_title);
				var fields = new Array (f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_desc,f_query_add_mod.document.forms[0].trmt_category_code);
			}
		}else{
			if(mode=="insert"){
				var names = new Array ( code_title,trmt_category_desc_title,trmt_category_desc_title);
				var fields = new Array (f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_desc,f_query_add_mod.document.forms[0].trmt_category_code);
			}else{
				var names = new Array ( code_title,trmt_category_desc_title,trmt_category_desc_title);
				var fields = new Array (f_query_add_mod.document.forms[0].trmt_code,f_query_add_mod.document.forms[0].trmt_desc,f_query_add_mod.document.forms[0].trmt_category_code);
			}
		}
		if(checkFieldsofMst( fields, names, messageFrame)){	
	
			var fields1 = new Array (f_query_add_mod.document.forms[0].trmt_code);
			var names1 = new Array (code_title);
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";	
			
			if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page)){
			
			if (link_status.checked==false && mode=="insert"){
					//var confirm_value=confirm(getMessage("APP-OT0118","OT")); //commented by sridevi joshi on 09/01/2009 bcoz the legend was from OT
					var confirm_value=confirm(getMessage("APP-OH00029","OH"));
					if(confirm_value==true || confirm_value=="true"){
						var trmt_code=frm.trmt_code.value;
						var trmt_desc=frm.trmt_desc.value;
						
						//trmt_desc = escape(trmt_desc);
						
						var trmt_category_code=frm.trmt_category_code.value;
						var order_catalog_code=frm.order_catalog_code.value;
						var dialogHeight = "80vh" ;
						var dialogWidth  = "80vw" ;
						//var dialogWidth  		= window.screen.availWidth;
						var dialogTop    = "10";
						var dialogLeft   = "50";
						var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
						var url="../../eOR/jsp/OrderSet.jsp";
						/*
							OrderSet.jsp
							Parameters
							==========
								order_set_code
								long_desc
								short_desc
								module_id
								order_category
								mode 
							=========
						*/
						var ord_params = "?mode=1&long_desc="+trmt_desc+"&short_desc="+trmt_desc+"&order_set_code="+trmt_code+"&module_id=OH&order_category=OH&order_type=&sql_setting=&sql_auth_level=";
						url=url+ord_params;
						var arguments    = "" ;
						var retVal=await top.window.showModalDialog(url,arguments,features);
						if(retVal=="Y"){
							frm.order_catalog_code.value = trmt_code;
							f_query_add_mod.document.forms[0].submit();
							onSuccess();
						}
						else{//Added by Sridevi Joshi for IN014111 on 290909
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
							return;
						}
					}else{
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
						return;
					}
				}else{								
					f_query_add_mod.document.forms[0].submit();
				}
			}
		}
	}
}

function onSuccess(){
	//commontoolbarFrame.document.forms[0].apply.disabled=false;
	var delay = function() { onSuccess1(); };

         setTimeout(delay,500);
}

function onSuccess1()
{

if(f_query_add_mod != null){
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href='../../eOH/jsp/MTreatmentsAddModify.jsp?mode=insert';
		else
			f_query_add_mod.location.reload();
	}
}


function setCheckValue(){
	if(document.forms[0].eff_status.checked==true)
		document.forms[0].eff_status.value="E";
	else
		document.forms[0].eff_status.value="D";
}

function setCheckValueforMultiTasks(){
	if(document.forms[0].multiple_task_yn.checked==true){
		document.forms[0].multiple_task_yn.value="Y";
	}
	else{
		var trmt_code = document.forms[0].trmt_code.value;
		//To check whether multiple tasks are associated withis trmt
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "treatment_code="+trmt_code;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=getCountForTrmtTasks&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		retVal = localTrimString(retVal);

		if(retVal > 1){
			alert(getMessage("APP-OH000120","OH"));
			document.forms[0].multiple_task_yn.checked=true;
			document.forms[0].multiple_task_yn.value="Y";
			return;
		}else{
			document.forms[0].multiple_task_yn.value="N";
		}
	}
}

function setLinkValue()
{  
	if(document.forms[0].link_status.checked==false)
		document.forms[0].link_status.value="E";
	else {
		document.forms[0].link_status.value="D";

	}
	link_ena_dis();
}


function link_ena_dis(){
	var formObj = document.forms[0];
	if (formObj.link_status.checked==true){
		formObj.treatment_lookup.disabled=false;
		formObj.order_catalog_desc.readOnly=false;
		//formObj.order_type.value="";
		//formObj.order_type.disabled=true;
		//formObj.img1.src="../../eCommon/images/Blank1.gif";		
		formObj.img2.src="../../eCommon/images/mandatory.gif";			
	}else if (formObj.link_status.checked==false){
		formObj.treatment_lookup.disabled=true;
		formObj.order_catalog_desc.readOnly=true;
		formObj.order_catalog_code.value="";
		formObj.order_catalog_desc.value="";
		//formObj.order_type.disabled=false;
		//formObj.img1.src="../../eCommon/images/mandatory.gif";
		formObj.img2.src="../../eCommon/images/Blank1.gif";		
	}
}



function AssignDBValue(){
	var obj = document.forms[0];
    var mode = document.forms[0].mode.value;
	var trmt_category_code = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_category_code="+document.forms[0].trmt_category_code1.value;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=getTrmtCategoryType&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(mode == "modify"){
		if(obj.trmt_category_code.DB_VALUE == "" ){
			obj.trmt_category_code.value = "";
		}
		else{
			obj.trmt_category_code.value = obj.trmt_category_code.DB_VALUE
		}
		if (retVal!="CROWN"){
			document.getElementById("crown_appl").style.visibility = 'hidden';
			document.getElementById("crown_applicable_yn").style.visibility = 'hidden';
		}

	}
	//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
	//Added so that crwon_applicable and inlay_onlay fields are seen only when a Crown trmt is selected.
	if(mode == "insert"){
	    document.getElementById("crown_appl").style.visibility = 'hidden';
		document.getElementById("crown_applicable_yn").style.visibility = 'hidden';
		//document.getElementById("inlay_onlay").style.visibility = 'hidden';
		//document.getElementById("inlay_onlay_yn").style.visibility = 'hidden';
	}
	//End
}

/*
function AssignDBValue(){
	var obj = document.forms[0];
	var mode = document.forms[0].mode.value;
	if(mode == "modify"){
		if(obj.trmt_category_code.DB_VALUE == "" ){
			obj.trmt_category_code.value = "";
		}
		else{
			obj.trmt_category_code.value = obj.trmt_category_code.DB_VALUE
		}

		if(obj.trmt_category_code.DB_VALUE == "" ){
			obj.trmt_category_code.value = "";
		}
		else{
			obj.trmt_category_code.value = obj.trmt_category_code.DB_VALUE
		}
	
	}
}
*/
function populateConditionTypes(obj){
	var formObj = document.forms[0];
	var	trmt_category_code_obj = formObj.trmt_category_code;
	
	if(obj!=null && obj!=""){
		//Clear the Existing (if any) List of Treatment Types
		clearTreatmentTypesList(trmt_category_code_obj);

		// get the Treatment Types for the selected Splty Module Id
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "splty_module_id="+splty_module_id;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","MCommonValidation.jsp?func_mode=populateConditionTypes&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		// add the list of Treatment Types for the selected Splty Module Id
		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				addTreatmentTypesList(trmt_category_code_obj,code_desc_arr[0],code_desc_arr[1]);
			}
		}
	}
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

//Added by Sharon Crasta on 1/19/2010 for SRR20056-CRF-0442(IN010838)
function setCheckValueforCrownAppl(){
	if(document.forms[0].crown_applicable_yn.checked == true){
		document.forms[0].crown_applicable_yn.value = "Y";
	}
	else{
		document.forms[0].crown_applicable_yn.value = "N";
	}
}

/*function setCheckValueforInlayOnlay(){
	if(document.forms[0].inlay_onlay_yn.checked == true){
		document.forms[0].inlay_onlay_yn.value = "Y";
	}
	else{
		document.forms[0].inlay_onlay_yn.value = "N";
	}
}*/

function trmtTypeChange(obj){
	var trmt_category_code = obj.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "trmt_category_code="+trmt_category_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MCommonValidation.jsp?func_mode=getTrmtCategoryType&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	retVal = localTrimString(retVal);
	if(retVal != "CROWN"){
		document.getElementById("crown_appl").style.visibility = 'hidden';
		document.getElementById("crown_applicable_yn").style.visibility = 'hidden';
		document.getElementById("crown_applicable_yn").checked = false;

		//document.getElementById("inlay_onlay").style.visibility = 'hidden';
		//document.getElementById("inlay_onlay_yn").style.visibility = 'hidden';

	 }else{
		document.getElementById("crown_appl").style.visibility = 'visible';
		document.getElementById("crown_applicable_yn").style.visibility = 'visible';
		document.getElementById("crown_applicable_yn").checked = true;
		//document.getElementById("inlay_onlay").style.visibility = 'visible';
		//document.getElementById("inlay_onlay_yn").style.visibility = 'visible';
	 
	 }
		
}
//End

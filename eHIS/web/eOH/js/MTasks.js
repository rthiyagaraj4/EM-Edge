
function create()
{
	f_query_add_mod.location.href='../../eOH/jsp/MTasksAddModify.jsp?mode=insert';
}

function getTreatmentLookUp(obj,target){

	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.MTasksForm;
	var order_catalog_desc = frmObj.order_catalog_desc.value;

	if (tit_flag="Order Catalog Search"){

		sql="SELECT SHORT_DESC DESCRIPTION, ORDER_CATALOG_CODE CODE FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND ORDER_CATEGORY='OH' AND ORDER_CATALOG_NATURE = 'A' AND EFF_STATUS = 'E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL ORDER BY 1";
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
		target.value=retVal[1]//Added by Sridevi Joshi on 5/24/2010 during IN021549 changes
	}else{
		target.value="";
		obj.value="";
	}
 }

function query()
{
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MTasksQueryCriteria.jsp';
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
		if(f_query_add_mod.document.location.href.indexOf("MTasksQueryResult.jsp") != -1){
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
		var code_title=getLabel("eOH.TaskCode.Label","OH");
		var order_catalog_title=getLabel("Common.CatalogCrossReference.label","Common");
		var task_desc_title = getLabel("eOH.TaskDescription.Label","Common");
		var link_status = frm.link_status;
	    var eff_status=frm.eff_status.value;
	    

		if (link_status.checked==true && mode=="insert"){
			var names = new Array ( code_title,task_desc_title,order_catalog_title);
			var fields = new Array (f_query_add_mod.document.forms[0].task_code,f_query_add_mod.document.forms[0].task_desc,f_query_add_mod.document.forms[0].order_catalog_desc);
		}else{
			var names = new Array ( code_title,task_desc_title);
			var fields = new Array (f_query_add_mod.document.forms[0].task_code,f_query_add_mod.document.forms[0].task_desc);
		}
			if(checkFieldsofMst( fields, names, messageFrame)){

				var fields1 = new Array (f_query_add_mod.document.forms[0].task_code);
				var names1 = new Array (code_title);
				var error_page = "../../eCommon/jsp/MstCodeError.jsp";
				var msg = getMessage("APP-OH000185","OH");
				var msg_arr = msg.split("##");
			if (f_query_add_mod.SpecialCharCheck(fields1,names1,messageFrame,"M",error_page)){
				var task_code=frm.task_code.value;
				var task_desc=frm.task_desc.value;
				var order_catalog_code=frm.order_catalog_code.value;
				// check for the link checkbox. if value is N, then call the order catalog window.
				// example OperationsProcedures.js
						if (link_status.checked==false && mode=="insert"){
							var confirm_value=confirm(getMessage("APP-OH00030","OH"));
							if(confirm_value==true || confirm_value=="true"){
								var dialogHeight = "80vh" ;
								var dialogWidth  = "80vw" ;
								var dialogTop    = "10";
								var dialogLeft   = "50";
								var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
								var url="../../eOR/jsp/OROrderCatalog.jsp";
								
								var ord_params = "?mode=1&long_desc="+task_desc+"&short_desc="+task_desc+"&order_catalog_code="+task_code+"&module_id=OH&order_category=OH&order_type=&sql_setting=&sql_auth_level=";
								url=url+ord_params;
								var arguments    = "" ;
								var retVal=await top.window.showModalDialog(url,arguments,features);
								if(retVal == "Y"){//Added by Sridevi Joshi for IN014111 on 290909
								    if (eff_status=="D"){//added by parul on 25/05/2010 for IN021288 (if task status is disable on that case order catalog also should be disable)
										var eff_status_title=getLabel("Common.Disabled.label","Common");
										var params1 = "order_catalog_code="+task_code+"&eff_status="+eff_status;
										var xmlDoc = "" ;
										var xmlHttp = new XMLHttpRequest();
										var params = "";
										var xmlStr ="<root><SEARCH ";
										xmlStr +=" /></root>";
										xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
										xmlHttp.open("POST","CommonValidation.jsp?func_mode=updateOROrderCatalog&"+params1,false);
										xmlHttp.send(xmlDoc);
										var ret_cat = trimString(xmlHttp.responseText);
										if (ret_cat!=0){
											alert(msg_arr[0]+""+eff_status_title+""+msg_arr[1]);
										}
								    }	//end parul
									f_query_add_mod.document.forms[0].submit();
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
							//added by parul on 25/05/2010 for IN021288( on modify mode if status is changed on that case catalog also wl be getting changed for that msg should be fire )
							var eff_status_text="";
							if (eff_status=="E"){
								eff_status_text=getLabel("Common.enabled.label","Common");
							}else if (eff_status=="D"){
								eff_status_text=getLabel("Common.Disabled.label","Common");
							}
							var params2 = "task_code="+task_code;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=chkEffStatusForTask&"+params2,false);
							xmlHttp.send(xmlDoc);
							var ret_status = trimString(xmlHttp.responseText);
							ret_status = localTrimString(ret_status);
						
							var params1 = "order_catalog_code="+order_catalog_code+"&eff_status="+eff_status;
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "";
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=updateOROrderCatalog&"+params1,false);
							xmlHttp.send(xmlDoc);
							var ret_cat = trimString(xmlHttp.responseText);
							if (ret_cat!=0){
								if (mode=="insert" && eff_status=="D"){//insert mode when we are selectng order_catalog_code from lookup
									alert(msg_arr[0]+""+"Disabled"+""+msg_arr[1]);
								}else if(mode!="insert" && (ret_status!=eff_status)){ //modify mode
									alert(msg_arr[0]+""+eff_status_text+""+msg_arr[1]);
								}
							}//end by parul
						
							
							f_query_add_mod.document.forms[0].submit();
						}
			}
		}
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MTasksAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function setCheckValue(obj){
	var OR_error=0;
	if(obj == "eff_status"){
		if(document.forms[0].eff_status.checked==true){
			document.forms[0].eff_status.value="E";
		}else{
			document.forms[0].eff_status.value="D";
		}
		
	}
	else if(obj == "ext_perm_loc"){
		if(document.forms[0].ext_perm_loc.checked==true){
			document.forms[0].ext_perm_loc.value="Y";
			document.forms[0].ext_perm_loc1.value="Y";
			var note_type_label = getLabel("Common.NoteType.label","Common");
			var default_select_label = getLabel("eOH.DefaultSelect.Label","OH");
			document.getElementById("note_type_label_id").innerHTML=note_type_label;
			document.getElementById("note_type_id").innerHTML='<select name="oh_note_type" id="oh_note_type"><option value="">'+default_select_label+'</option></select>';
			
			clear_list(document.forms[0].oh_note_type); 
			optSel	= document.createElement("OPTION");
			optSel.text = getLabel("eOH.DefaultSelect.Label","OH");
			optSel.value= ''; 
			document.forms[0].oh_note_type.add(optSel);

			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateCANoteType&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(retVal.length>1){
				var retVal_arr = retVal.split("~");
				for(k=0;k<retVal_arr.length-1;k++){
					var code_desc_arr = retVal_arr[k].split("##")
					var element 	= document.createElement('OPTION') ;
					element.value 	= code_desc_arr[0];
					element.text 	= code_desc_arr[1];
					document.forms[0].oh_note_type.add(element);
				}
			}
		}else{
			document.forms[0].ext_perm_loc.value="N";
			document.forms[0].ext_perm_loc1.value="Y";
			document.getElementById("note_type_id").innerHTML = "";
			document.getElementById("note_type_label_id").innerHTML = "";
		}
	}
}

function AssignDBValue(){
	var obj = document.forms[0];
	var mode = obj.mode.value;
	var ext_perm_loc = obj.ext_perm_loc1.value;
	if(mode == "modify" && ext_perm_loc=="Y"){
		if(obj.oh_note_type.DB_VALUE == "" ){
			obj.oh_note_type.value = "";
		}
		else{
			obj.oh_note_type.value = obj.oh_note_type.DB_VALUE
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
		formObj.img2.src="../../eCommon/images/mandatory.gif";
	}
	else if (formObj.link_status.checked==false){
		formObj.treatment_lookup.disabled=true;
		formObj.order_catalog_desc.readOnly=true;
		formObj.order_catalog_code.value="";
		formObj.order_catalog_desc.value="";
		formObj.img2.src="../../eCommon/images/Blank1.gif";
	}
}

function clear_list(obj){
	while(obj.options.length > 0){
		obj.remove(obj.options[0]);
	}
}

function localTrimString(sInString) {
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}


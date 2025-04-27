/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function create()
{
	f_query_add_mod.location.href='../../eOT/jsp/OperationsProceduresAddModify.jsp?mode=insert';
}

async function apply(){	
	var formObj = f_query_add_mod.document.forms[0]; 
	var operationCode=getLabel("eOT.OperationCode.Label","OT");
	var longdescription=getLabel("Common.longdescription.label","Common");
	var shortdescription=getLabel("Common.shortdescription.label","Common");
	var operationType=getLabel("eOT.OperationType.Label","OT");
	var catalogCrossReference=getLabel("Common.CatalogCrossReference.label","Common");
	var speciality=getLabel("Common.speciality.label","Common");
	var duration_label=getLabel("Common.duration.label","Common");
	var order_type=getLabel("Common.OrderType.label","Common");
	var frm=f_query_add_mod.document.forms[0];
	if(frm.mode.value=="modify"){
		var fields = new Array (formObj.oper_code,formObj.long_desc,formObj.short_desc,formObj.oper_type_desc,formObj.duration,formObj.speciality_desc);

		var names = new Array (operationCode,longdescription,shortdescription,operationType,duration_label,speciality);
		if (checkDuration_1()){
			if (checkCategory()){
				if(checkFieldsofMst( fields, names, messageFrame)) {						
						f_query_add_mod.document.forms[0].submit();
						//onSuccess();
				}
			}else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
				return;
			}
		}else {
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
				return;
		}
	}else{
		//var fields = new Array (f_query_add_mod.document.forms[0].oper_code,f_query_add_mod.document.forms[0].long_desc,f_query_add_mod.document.forms[0].short_desc,f_query_add_mod.document.forms[0].oper_type_code,f_query_add_mod.document.forms[0].order_catalog_code ,f_query_add_mod.document.forms[0].duration);
		//var names = new Array (longdescription,shortdescription,operationType,catalogCrossReference,duration);
		var fields = new Array (formObj.oper_code,formObj.long_desc,formObj.short_desc,formObj.oper_type_desc,formObj.duration,formObj.speciality_desc);
			var names = new Array (operationCode,longdescription,shortdescription,operationType,duration_label,speciality);
			
		if (checkDuration_1()){			
			if (checkCategory()){
				if(checkFieldsofMst( fields, names, messageFrame)) {					
					// check for the catalog creation
					var mode =formObj.mode.value;
					var mandatory_flag = validateCatalogLink();
					if(mandatory_flag==false)
						return false;
					if(mode=="insert" && mandatory_flag==true){
						var link_status = formObj.link_status;
						if (link_status.checked==false){
							var confirm_value=confirm(getMessage("APP-OT0118","OT"));
							if(confirm_value==true || confirm_value=="true"){
								var oper_code=formObj.oper_code.value;
								var oper_long_desc=formObj.long_desc.value; // encode uri
								var oper_short_desc=formObj.short_desc.value; // encode uri
								var order_type=formObj.order_type.value;
								var dialogHeight = "90vh" ;
								var dialogWidth  = "90vw" ;
								//var dialogWidth  		= window.screen.availWidth;
								var dialogTop    = "10";
								var dialogLeft   = "0";
								var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
								var url="../../eOR/jsp/OROrderCatalog.jsp"
								var ord_params = "?mode=1&order_catalog_code="+oper_code+"&long_desc="+encodeURIComponent(oper_long_desc)+"&short_desc="+encodeURIComponent(oper_short_desc)+"&module_id=OT&order_category=OT&sql_order_type="+order_type+"&order_type="+order_type+"&sql_setting=&sql_auth_level=";
								url=url+ord_params;
								var arguments    = "" ;
								var retVal=await window.showModalDialog(url,arguments,features);
								f_query_add_mod.document.forms[0].submit();
								//onSuccess();
							}else{
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
								return;
							}
						}else{
								f_query_add_mod.document.forms[0].submit();
								//onSuccess();
						}
					}
				}
			}else{
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
				return;
			}
		}else {
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+"";
			return;
		}
	}
}


function validateCatalogLink(){
	var formObj=f_query_add_mod.document.forms[0];
	var order_type_value=getLabel("Common.OrderType.label","Common");
	var catalog_corss_ref=getLabel("Common.CatalogCrossReference.label","Common");
	var link_status = formObj.link_status;
	var mandatory_flag = true;
	var err_txt="";
	var err_msg=getMessage("CANNOT_BE_BLANK","OT");
	var msgArry=err_msg.split("&");
	if(link_status.checked==false){
		if(formObj.order_type.value=="" || formObj.order_type.value==null){
			err_txt=msgArry[0]+ order_type_value + msgArry[1];
			mandatory_flag = false;
		}
	}else if(link_status.checked==true){
		if(formObj.order_catalog_desc.value=='' || formObj.order_catalog_desc.value==null){
			err_txt=msgArry[0]+catalog_corss_ref+ msgArry[1];
			mandatory_flag = false;
		} 
	}
	if(mandatory_flag==false){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_txt;
	}
	return mandatory_flag;
}

function onSuccess()
{
	var formObj = f_query_add_mod.document.forms[0];
	if(formObj.mode.value!="insert"){
        var oper_code = formObj.oper_code.value;
		f_query_add_mod.location.href="../../eOT/jsp/OperationsProceduresAddModify.jsp?mode=modify&oper_code="+oper_code;
	}	else {
		f_query_add_mod.location.href="../../eOT/jsp/OperationsProceduresAddModify.jsp?mode=insert";
	}
	var err_txt = getMessage("RECORD_INSERTED","SM");
}


/*function reset()
{
	f_query_add_mod.document.forms[0].reset();
}*/

function reset() {
	if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperationsProceduresAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("OperationsProcedures.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
	}else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("OperProcQueryCriteria.jsp") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
	}
}

function query()    
{
	//commontoolbarFrame.document.forms[0].apply.disabled=true;  //Commented Against GHL-SCF-1519
	f_query_add_mod.location.href='../../eOT/jsp/OperProcQueryCriteria.jsp';
}


async function searchlkp(title_flag,tit,obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";

	if (title_flag=="Operation Type Search")
	{
		sql="SELECT SHORT_DESC DESCRIPTION, OPER_TYPE CODE  FROM OT_OPER_TYPE where NVL(STATUS,'D')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) ORDER BY 1";
	}
	if (title_flag=="Checklist Search")
	{
		sql="SELECT DESCRIPTION DESCRIPTION, CHECKLIST_CODE CODE   FROM	  OT_CHECKLIST_HDR where NVL(STATUS,'D')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CHECKLIST_CODE) LIKE UPPER(?) ORDER BY 1";
		
	}
	if (title_flag=="Swab / Instrument Template Search")
	{
		sql="SELECT DESCRIPTION DESCRIPTION, TEMPLATE_ID CODE   FROM	   OT_SWAB_INSTR_TMPL_HDR  where NVL(STATUS,'D')='E' AND UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(TEMPLATE_ID) LIKE UPPER(?) ORDER BY 1";
	}
	if (title_flag=="Category Search")
	{//alert(document.forms[0].speciality_code.value);
		 if (document.forms[0].speciality_code.value=="" )
		{
			
			//alert("Catalog Cross Reference has to be entered");
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var catalogCrossReference=getLabel("Common.CatalogCrossReference.label","Common");
				alert(msgArray[0]+catalogCrossReference+msgArray[1]);
			return false;
		} 
		sql="SELECT LONG_DESC DESCRIPTION, OPER_CAT_CODE CODE FROM OT_OPER_CATEGORY  where NVL(STATUS,'D')='E' AND OPER_GROUP_CODE ='"+ document.forms[0].speciality_code.value+ "' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) ORDER BY 1";
	}

	if (title_flag=="Sub Category Search")
	{
		if (document.forms[0].speciality_code.value=="" ){
			
			//alert("Catalog Cross Reference has to be entered");
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var catalogCrossReference=getLabel("Common.CatalogCrossReference.label","Common");
			 alert(msgArray[0]+catalogCrossReference+msgArray[1]);
			return false;
		}
		if (document.forms[0].oper_cat_desc.value=="" ){
			
			//alert("Category has to be entered");
			var msg = getMessage("CANNOT_BE_BLANK","OT");
			var msgArray = msg.split("&");
			var category1=getLabel("Common.category1.label","Common");
			 alert(msgArray[0]+category1+msgArray[1]);
			return false;
		}
		sql="SELECT LONG_DESC DESCRIPTION, OPER_SUB_CAT_CODE CODE   FROM	  OT_OPER_SUB_CATEGORY  where NVL(STATUS,'D')='E' AND OPER_GROUP_CODE ='"+ document.forms[0].speciality_code.value+ "' AND OPER_CAT_CODE ='"+document.forms[0].oper_cat_code.value+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) ORDER BY 1";
	
	}
		//`alert(sql);
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
			if (title_flag=="Category Search"){
				 document.forms[0].oper_sub_cat_code.value = "";
				 document.forms[0].oper_sub_cat_desc.value = "";
			}
	}else{
		target.value="";
		obj.value="";
			if (title_flag=="Category Search"){
				 document.forms[0].oper_sub_cat_code.value = "";
				 document.forms[0].oper_sub_cat_desc.value = "";
			}
	}
 }

async function searchOperlkp(obj,target){
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("eOT.OperationCode.Label","OT");;
	var sql="";
	var frmObj=document.forms[0];
	var diag_code=frmObj.diag_code_scheme.value;
	//ICD10PCS','ICD9CMP','CPT4','OTH
/*Added by Suma on 02/03/2010 for site issue*/
if (diag_code=="ICD9CM") //ICD 9CM
	{
		
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD9CM' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}else if (diag_code=="ICD10TM") //ICD10TM
	{
		
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD10TM' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}else if (diag_code=="ICD9CMD") //ICD9CMD
	{
		
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD9CMD' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}else if (diag_code=="ICD10") //ICD10
	{
	
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD10' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}else if (diag_code=="ICD9") //ICD9
	{
		
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD9' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}/*Added by Suma ends here*/
	else if (diag_code=="ICD9CMP") //ICD 9CMP
	{
		//sql="SELECT SHORT_DESC DESCRIPTION, DIAG_CODE CODE FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME = '2' AND RECORD_TYPE = 'D' AND  UPPER(substr(SHORT_DESC, 1, 40)) LIKE UPPER(?) AND UPPER(DIAG_CODE) LIKE UPPER(?) ORDER BY 1";
		sql= "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE    FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD9CMP' AND EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";

	}
	else if (diag_code=="CPT4") //CPT 4
	{		
		//sql = "SELECT SHORT_DESC DESCRIPTION, CPT_CODE CODE FROM MR_CPT_CODE WHERE UPPER(substr(SHORT_DESC, 1, 40)) LIKE UPPER(?) AND UPPER(CPT_CODE) LIKE UPPER(?) ORDER BY 1";
		sql = "SELECT SHORT_DESC DESCRIPTION,TERM_CODE CODE   FROM MR_TERM_CODE WHERE TERM_SET_ID ='CPT4' AND  EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";
	}
	else if (diag_code=="ICD10PCS") //ICD 10 PCS
	{		
		//sql="SELECT SHORT_DESC DESCRIPTION, DIAG_CODE CODE FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME = '1' AND RECORD_TYPE IS NULL AND UPPER(substr(SHORT_DESC, 1, 40)) LIKE UPPER(?) AND UPPER(DIAG_CODE) LIKE UPPER(?) ORDER BY 1";
		sql= "SELECT  SHORT_DESC DESCRIPTION,TERM_CODE CODE  FROM MR_TERM_CODE WHERE TERM_SET_ID ='ICD10PCS' AND  EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";
	}else if (diag_code=="OTH") //ICD 10 PCS
	{		
		//sql="SELECT SHORT_DESC DESCRIPTION, DIAG_CODE CODE FROM MR_ICD_CODE WHERE DIAG_CODE_SCHEME = '1' AND RECORD_TYPE IS NULL AND UPPER(substr(SHORT_DESC, 1, 40)) LIKE UPPER(?) AND UPPER(DIAG_CODE) LIKE UPPER(?) ORDER BY 1";
		sql= "SELECT  SHORT_DESC DESCRIPTION,TERM_CODE CODE  FROM MR_TERM_CODE WHERE TERM_SET_ID ='OTH' AND  EFF_STATUS='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(TERM_CODE) LIKE UPPER(?)";
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] =target.value//target.value;
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
		target.value=arr[1].substring(0,60);
		frmObj.short_desc.value=arr[1].substring(0,30);
	}else{
		frmObj.short_desc.value="";
		target.value="";
		obj.value="";
	}
 }

async function searchOrderCatlkp(tit_flag,tit,obj,target){
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.forms[0];
	var speciality_code = frmObj.speciality_code.value;
	if (tit_flag="Order Catalog Search")
	{
		//modified for specialities on 28/06
		//sql="SELECT SHORT_DESC DESCRIPTION, ORDER_CATALOG_CODE CODE FROM OR_ORDER_CATALOG_LANG_VW where LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY = 'OT' AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL AND NVL(EFF_STATUS,'D')='E' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) ORDER BY 1";

		sql="SELECT SHORT_DESC DESCRIPTION, ORDER_CATALOG_CODE CODE FROM OR_ORDER_CATALOG_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ORDER_CATEGORY = 'OT' AND CONTR_MOD_ID IS NULL AND CONTR_MSR_PANEL_ID IS NULL AND NVL(EFF_STATUS,'E')='E' AND ORDER_TYPE_CODE IN (SELECT ORDER_TYPE_CODE FROM OT_SPECIALITY_ORDER_TYPES WHERE SPECIALITY_CODE = '"+speciality_code+"') AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ORDER_CATALOG_CODE) LIKE UPPER(?) ORDER BY 1";
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		//arr=retVal;
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		obj.value = arr[0];
		target.value=arr[1];
		frmObj.type.value="appt_time";
		getDtls();
	}else{
		target.value="";
		obj.value="";	
	}
 }

function getDtls(){
	var formObj = document.OperProcForm;
	var rec_count = "";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var url="OperationsProceduresDtls.jsp?type="+formObj.type.value+"&order_catalog_code="+formObj.order_catalog_code.value+"&oper_code="+formObj.oper_code.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",url,false);
		xmlHttp.send(xmlDoc);
		retVal=xmlHttp.responseText;
		retVal=trimString(retVal);
		if(retVal!="undefined"){
			if (formObj.type.value=="appt_time"){
				var val_arr = retVal.split("::");
				formObj.duration.value = val_arr[0];
				formObj.duration_db_value.value = val_arr[0];
			   	formObj.order_type_code.value = val_arr[1];
			   	formObj.speciality_code.value = val_arr[2];
			   	formObj.speciality_desc.value = val_arr[3];
				formObj.instr_in_english.value = val_arr[4]=="null"?"":val_arr[4];
				formObj.instr_in_local.value   = val_arr[5]=="null"?"":val_arr[5];
				rec_count = val_arr[6];
				if (rec_count > 0){
					//alert("Order Catalog Code is Duplicated");
					alert(getMessage("CODE_ALREADY_EXISTS","Common"));
					formObj.order_catalog_code.value  = "";
					formObj.order_catalog_desc.value  = "";
					formObj.duration.value ="";
					formObj.duration_db_value.value = "";
					formObj.order_type_code.value  = "";
					formObj.speciality_code.value  = "";
					formObj.speciality_desc.value  = "";
					formObj.instr_in_english.value = "";
					formObj.instr_in_local.value   = "";
					return false;
				}
			}
		}
}

function getDtlsForQuery(){
	var formObj = document.OperProcForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var url="OperationsProceduresDtls.jsp?type="+formObj.type.value+"&order_catalog_code="+formObj.order_catalog_code.value+"&oper_code="+formObj.oper_code.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",url,false);
	xmlHttp.send(xmlDoc);
	retVal=xmlHttp.responseText;
	retVal=trimString(retVal);
	if(retVal!="undefined"){
		var val_arr = retVal.split("::");
		formObj.instr_in_english.value = val_arr[4]=="null"?"":val_arr[4];
		formObj.instr_in_local.value   = val_arr[5]=="null"?"":val_arr[5];
	}
}
function checkVal(obj)
{
	if(document.forms[0].side_appl.checked==true){
		document.forms[0].side_appl.value="Y";
	    document.forms[0].side_appl1.value="Y";
	}
	else{
		document.forms[0].side_appl.value="N";
	    document.forms[0].side_appl1.value="N";
	}
}

function setCheckValue()
{
	if(document.forms[0].status.checked==true)
		document.forms[0].status.value="E";
	else {
		document.forms[0].status.value="D";
	}
	check_ena_dis();
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

function checkDuration(){
  if (parent.frames[1].document.forms[0].duration.value=="00:00")
  {
	  //alert("Duration should be entered");
	  var msg = getMessage("CANNOT_BE_BLANK","OT");
	  var msgArray = msg.split("&");
  	  var duration=getLabel("Common.duration.label","Common");
	 alert(msgArray[0]+duration+msgArray[1]);

	  return false;
  }				
  return true;
}

function checkDuration_1(){
  if (f_query_add_mod.document.forms[0].duration.value=="00:00")
  {
	  var msg = getMessage("APP-OT0183","OT");
	  var msgArray = msg.split("#");
	  var duration=getLabel("Common.duration.label","Common");
	  alert(msg);
	  return false;
  }				
  return true;
}

function checkCategory(){
	var oper_cat_code = f_query_add_mod.document.forms[0].oper_cat_code.value=="null"?"":f_query_add_mod.document.forms[0].oper_cat_code.value;
	var oper_sub_cat_code = f_query_add_mod.document.forms[0].oper_sub_cat_code.value=="null"?"":f_query_add_mod.document.forms[0].oper_sub_cat_code.value;
	var mode = f_query_add_mod.document.forms[0].mode.value;
//	alert(mode)
	if (mode=="modify")
	{
		var db_oper_cat_code=f_query_add_mod.document.forms[0].db_oper_cat_code.value;
		var oper_cat_desc=f_query_add_mod.document.forms[0].oper_cat_desc.value;
//		alert("DB cat code==="+db_oper_cat_code);
//		alert("Cat code==="+oper_cat_desc);
/*		if (db_oper_cat_code!="") {
			if (oper_cat_desc==""){
				//alert("Operation Category cannot be null");
				var msg = getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = msg.split("&");
				var operationCategory=getLabel("eOT.OperationCategory.Label","OT");
				alert(msgArray[0]+ operationCategory +msgArray[1]);
				parent.frames[1].frames[1].document.forms[0].oper_cat_code.value = "";
				parent.frames[1].frames[1].document.forms[0].oper_sub_cat_code.value = "";
				parent.frames[1].frames[1].document.forms[0].oper_sub_cat_desc.value = "";
			    return false;
			}
		}*/

	}	
		  if ((oper_cat_code=="") && (oper_sub_cat_code!=""))  {
			 f_query_add_mod.document.forms[0].oper_sub_cat_code.value = "";
			 f_query_add_mod.document.forms[0].oper_sub_cat_desc.value = "";
		  }	 

		  if ((oper_cat_code!="") && (oper_sub_cat_code=="")) {
			  //alert("Operation Sub Category cannot be null.");
				var msg = getMessage("CANNOT_BE_BLANK","OT");
				var msgArray = msg.split("&");
				var operationSubCategory=getLabel("eOT.OperationSubCategory.Label","OT");
				alert(msgArray[0]+ operationSubCategory +msgArray[1]);
				return false;
		  }
  return true;
}

function callOR(){
if (document.forms[0].link_status.checked==true){
		
    }
}

function link_ena_dis(){
	var formObj = document.forms[0];
	if (formObj.link_status.checked==true){
		formObj.ordercat.disabled=false;
		formObj.order_catalog_desc.readOnly=false;
		formObj.order_type.value="";
		formObj.order_type.disabled=true;
		formObj.img1.src="../../eCommon/images/Blank1.gif";		
		formObj.img2.src="../../eCommon/images/mandatory.gif";			
	}else if (formObj.link_status.checked==false){
		formObj.ordercat.disabled=true;
		formObj.order_catalog_desc.readOnly=true;
		formObj.order_catalog_code.value="";
		formObj.order_catalog_desc.value="";
		formObj.order_type.disabled=false;
		formObj.img1.src="../../eCommon/images/mandatory.gif";
		formObj.img2.src="../../eCommon/images/Blank1.gif";		
	}
}


function check_ena_dis(){
	var formObj = document.forms[0];
	var mode = formObj.mode.value;
	if (formObj.status.checked==true){
		formObj.speciality_desc.disabled=false;
		formObj.duration.readOnly=false;
		formObj.long_desc.readOnly=false;
		formObj.short_desc.readOnly=false;
		formObj.oper_type_desc.disabled=false;
//		formObj.oper_type_desc.readOnly=false;
		formObj.opertype.disabled=false;
		formObj.splty.disabled=false;		
		formObj.side_appl.disabled=false;
		formObj.pre_op_check_list_desc.disabled=false;
		formObj.prechk.disabled=false;
		formObj.post_op_check_list_desc.disabled=false;
		formObj.postchk.disabled=false;
		formObj.swab_instr_tmpl_desc.disabled=false;
		formObj.swab.disabled=false;
		if(formObj.oper_cat_desc!=null)
			formObj.oper_cat_desc.readOnly=false;
		if(formObj.catg!=null)
			formObj.catg.disabled=false;
		if(formObj.oper_sub_cat_desc!=null)
			formObj.oper_sub_cat_desc.readOnly=false;
		if(formObj.subcatg!=null)
			formObj.subcatg.disabled=false;
	}
	else if (formObj.status.checked==false){
		formObj.speciality_desc.disabled=true;
		formObj.duration.readOnly=true;
		formObj.long_desc.readOnly=true;
		formObj.short_desc.readOnly=true;
		formObj.oper_type_desc.disabled=true;
		formObj.opertype.disabled=true;
		formObj.splty.disabled=true;		
		formObj.side_appl.disabled=true;
		formObj.pre_op_check_list_desc.disabled=true;
//		formObj.pre_op_check_list_desc.readOnly=true;
		formObj.prechk.disabled=true;
		formObj.post_op_check_list_desc.disabled=true;
		formObj.postchk.disabled=true;
		formObj.swab_instr_tmpl_desc.disabled=true;
		formObj.swab.disabled=true;
		if(formObj.oper_cat_desc!=null)
			formObj.oper_cat_desc.readOnly=true;
		if(formObj.catg!=null)
			formObj.catg.disabled=true;
		if(formObj.oper_sub_cat_desc!=null)
			formObj.oper_sub_cat_desc.readOnly=true;
		if(formObj.subcatg!=null)
			formObj.subcatg.disabled=true;

	}
	if(mode=="modify"){
		formObj.speciality_desc.disabled=true;
		formObj.splty.disabled=true;
	}
}


function searchDiagCodeScheme(obj){		
		var frmObj=document.forms[0];
		//var splty_code=document.forms[0].speciality_code.value;
		//alert(splty_code);
		var sql="SELECT DECODE( NVL(DIAG_CODE_SCHEME,'X'),'X', (SELECT OPER_CODE_SCHEME FROM OT_PARAM), DIAG_CODE_SCHEME ) FROM OT_SPECIALITIES WHERE SPECIALITY_CODE = '"+obj+"' ";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root></root>";
		var param="flag=MED_SER&sql="+sql;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST", "../../servlet/eOT.CommonQueryServlet?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal.length!=0){
			frmObj.diag_code_scheme_desc.value=retVal;
			frmObj.diag_code_scheme.value=retVal;
			if(retVal=="OTH"){// In case of User Defined, enable the oper code field
				frmObj.oper_code.value="";
				frmObj.short_desc.value="";
				frmObj.long_desc.value="";
				frmObj.oper_code.readOnly=false;
				frmObj.opercode.disabled=true;
			}else{
				frmObj.oper_code.value="";
				frmObj.short_desc.value="";
				frmObj.long_desc.value="";
				frmObj.oper_code.readOnly=true;
				frmObj.opercode.disabled=false;
			}
		}  else {
			frmObj.diag_code_scheme.value=frmObj.oper_code_scheme.value;
			frmObj.diag_code_scheme_desc.value=frmObj.oper_code_scheme_desc.value;			
			frmObj.oper_code.value="";
			frmObj.short_desc.value="";
			frmObj.long_desc.value="";
			frmObj.oper_code.readOnly=false;
			frmObj.opercode.disabled=true;
		}
		//alert(retVal);
		//return retVal;

}

async function searchSpeciality(speciality_desc,speciality_code){
	var frmObj=document.forms[0];
	var locale = document.forms[0].locale.value;
	var result		=	false ;
	var message		=	"" ;
	var flag		=	"" ;
	var function_id = "";
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql="SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE and upper(A.SHORT_DESC) like upper(?) and upper(A.SPECIALITY_CODE) like upper(?) order by 2";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = speciality_desc.value;
	//alert("obj.value"+obj.value);
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(getLabel("Common.speciality.label","Common"), argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		speciality_code.value = arr[0];
		speciality_desc.value = arr[1];
		//searchDiagCodeScheme(returnedValues[0]);
		searchOrderType(arr[1])
		defaultProcCodeScheme(arr[0]);
	}
	else
	{
		speciality_desc.value = '';
		speciality_code.value ='';	
		frmObj.diag_code_scheme.value="";
		frmObj.diag_code_scheme_desc.value="";
	} 
}

function clearValues(){
	var formObj=document.forms[0];
	formObj.speciality_desc.value = '';
	formObj.speciality_code.value ='';	
	formObj.diag_code_scheme.value='';
	formObj.diag_code_scheme_desc.value='';
	formObj.oper_code.value="";
	formObj.short_desc.value="";
	formObj.long_desc.value="";
	formObj.oper_code.readOnly=false;
	formObj.opercode.disabled=true;
	clearStatusList(formObj.order_type);
}

//function for retreiving Speciality code for ordertype parameter


function searchOrderType(obj){
	
	var frmObj=document.forms[0];
	var confirm_formObj = document.OperProcForm;
	var speciality_code = confirm_formObj.speciality_code.value;
	var order_type_obj=confirm_formObj.order_type;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="OperationsProcedureValidation.jsp?func_mode=getOrderTypes&speciality_code="+speciality_code ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	resTxt=trimString(xmlHttp.responseText);
	var order_type_arr = resTxt.split("~");
	clearStatusList(frmObj.order_type);
    var arr_length= order_type_arr.length;
	for(i=0;i<arr_length-1;i++){
	var code_desc_arr = order_type_arr[i].split("##");	
		addStatusList(order_type_obj,code_desc_arr[0],code_desc_arr[1]);
	}

}

//added by rajesh for CRF 303.1 for defaulting the Procedure coding scheme
function defaultProcCodeScheme(obj){

	var frmObj=document.forms[0];
	var confirm_formObj = document.OperProcForm;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="OTCommonValidation.jsp?func_mode=defaultProcCodeScheme&speciality_code="+obj ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	resTxt=trimString(xmlHttp.responseText);
	var diag_code_desc = resTxt.split(",");
	if(resTxt.length!=0){
		var val=resTxt.split(",");
			if(val[0]=="OTH"){// In case of User Defined, enable the oper code field
				frmObj.oper_code.value="";
				frmObj.short_desc.value="";
				frmObj.long_desc.value="";
				frmObj.oper_code.readOnly=false;
				frmObj.opercode.disabled=true;
			}else{
				frmObj.oper_code.value="";
				frmObj.short_desc.value="";
				frmObj.long_desc.value="";
				frmObj.oper_code.readOnly=true;
				frmObj.opercode.disabled=false;
			}
		}  else {
			frmObj.diag_code_scheme.value=frmObj.oper_code_scheme.value;
			frmObj.diag_code_scheme_desc.value=frmObj.oper_code_scheme_desc.value;			
			frmObj.oper_code.value="";
			frmObj.short_desc.value="";
			frmObj.long_desc.value="";
			frmObj.oper_code.readOnly=false;
			frmObj.opercode.disabled=true;
		}
	confirm_formObj.diag_code_scheme.value=diag_code_desc[0];
	confirm_formObj.diag_code_scheme_ot_param.value=diag_code_desc[0];
	confirm_formObj.diag_code_scheme_desc.value=diag_code_desc[1];
}

async function callOrderCatalog(){
	var frmObj=document.forms[0];
	var mode =frmObj.mode.value;
	var oper_code=frmObj.oper_code.value;
	var oper_long_desc=frmObj.long_desc.value;
	var oper_short_desc=frmObj.short_desc.value;
	var order_type=frmObj.order_type.value;
	dialogHeight = "5" ;
	var dialogWidth  = "20" ;
	var dialogTop    = "300";
	var dialogLeft   = "300";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var url="../../eOR/jsp/OROrderCatalog.jsp"
	var ord_params = "?mode=1&order_catalog_code="+oper_code+"&long_desc="+oper_long_desc+"&short_desc="+oper_short_desc+"&module_id=OT&order_category=OT&sql_order_type="+order_type+"&sql_setting=&sql_auth_level=";
	url=url+ord_params;
	var retVal=await window.showModalDialog(url,features);
}



// To clear the list box
function clearStatusList( target_search_obj) {
	var len = target_search_obj.options.length;
	for(var i=0;i<len;i++){
		eval("target_search_obj.remove(\"order_type_text\")") ;
	}
	var tp 		= "-----------Select-----------" ;
	var opt  	= eval("document.createElement(\"OPTION\")") ;
	opt.text 	= tp ;
	opt.value 	= "" ;
	target_search_obj.add(opt) ;
} // End of clearOrderList

function addStatusList(obj,value,desc) {
	var element 	= document.createElement('OPTION') ;
	element.value 	=  value ;
	element.text 	= desc ;
	obj.add(element);	
	//form_name.order_type.add(element);
} // End of addOrderList
function isValidTime(obj){
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
		if(arr_time.length!=2  ){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}

		if(  isNaN(arr_time[0]) || isNaN(arr_time[1]) ){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
			
		if(arr_time[0]==0 && arr_time[1]==0 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			cal_error(getMessage("INVALID_TIME_FMT","SM"),obj);
		}

		if(arr_time[0]<0 || arr_time[0]>23 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT")+"\n";
		}
		if(arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
			err_text+=getMessage("APP-OT0041","OT");
			
		}
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}
	return true
}


function cal_error (str_message,obj) {
//	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}



function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
//Function: TO Restrict the Special Chars::	
//Added against ML-BRU-SCF-1401
function restrictSpecialChars_op(event){
		var strCheck = '"';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true ;
	}
//Added against ML-BRU-SCF-1401
function validateDuration(obj){
var formObj = document.OperProcForm;
	var duration=formObj.duration.value
	var splt_dur=duration.split(":");
if(duration!=''){
/*	if(duration=="00:00"){
		alert("APP-OT0131 Duration Should Be Greater Than 00:00");
		obj.focus();
		return;
	}*/
	if(duration.length!="5"){
		//alert(getMessage("APP-OT0040","OT"));
		alert(getMessage("APP-OT0130","OT"));
		formObj.duration.value="";
		formObj.duration.select();
	//	formObj.duration.focus()
		return;
	}

}
	if(duration!=''){
	if(splt_dur[0].length!=2 ||splt_dur[1].length!=2 ){
		alert(getMessage("APP-OT0130","OT"));
		formObj.duration.value="";
		formObj.duration.select();
//		formObj.duration.focus()
		return;
	}
}

	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2){
			//cal_error("Invalid Time format! Allowed Format is HH24:MI",obj);
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[1]=='' || arr_time[0]==''){
		cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[0]<0 || arr_time[0]>23 ){
			//err_text+= "Invalid Hours! Allowed Hours 00 - 23\n";
			err_text+=getMessage("APP-OT0040","OT")+"\n";
		}
		if(arr_time[1]<0 || arr_time[1]>59 ){
			//err_text+= "Invalid Minutes! Allowed Mins 00 - 59";
			err_text+=getMessage("APP-OT0041","OT")+"\n";
		}
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}

	return true
}

	function cal_error (str_message,obj) {
	alert (str_message);
	obj.value="";
	obj.select();
	return null;
}


function CheckForSpecChars(event)
{
    var strCheck = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}


function create(){
	f_query_add_mod.location.href='../../eOH/jsp/MTrmtCatTypeForComplicationsAddModify.jsp?mode=insert';
}

function apply(){	
	var frm=f_query_add_mod.document.forms[0];
	if(frm == null){
		commontoolbarFrame.location.reload();
	}
	else if(frm != null){
		var fields = new Array (f_query_add_mod.document.forms[0].complication_code);    
	    var complication_code_title=getLabel("eOH.ComplicationCode.Label","OH");
		var names = new Array ( complication_code_title);
		if(checkFieldsofMst( fields, names, messageFrame)){			
			var error_page = "../../eCommon/jsp/MstCodeError.jsp";
			var formObj = f_query_add_mod.document.forms[0];
			var row_count = formObj.row_count.value;
			var chk_count = 0;
			for(i = 1;i<=row_count;i++){
				if(eval("formObj.chk_"+i).checked == true){
					eval("formObj.chk_"+i).value = "Y";
					chk_count++;
				}else{
					eval("formObj.chk_"+i).value = "N";
				}
			}
			if(chk_count=="0"){
				var err_msg = getMessage("APP-OH00065","OH");
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+err_msg;
				return;
			}
			if(chk_count!="0"){
				f_query_add_mod.document.forms[0].submit();
			}
		}
	}
}

function onSuccess(){
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eOH/jsp/MTrmtCatTypeForComplicationsAddModify.jsp?mode=insert';
	else
        f_query_add_mod.location.reload();
}

function reset(){
	//f_query_add_mod.location.reload();
	/* Added by Sridevi Joshi on 6/9/2010 for IN021926*/
	if(f_query_add_mod.document.location.href.indexOf("MTrmtCatTypeForComplicationsQueryResult.jsp") != -1){
		  return false;
	}
	else{
		 f_query_add_mod.document.location.reload();
	}
}

function query(){
	commontoolbarFrame.document.forms[0].apply.disabled=true;
	f_query_add_mod.location.href='../../eOH/jsp/MTrmtCatTypeForComplicationsQueryCriteria.jsp';
	
}

function AssignDBValue(){
	var obj = document.forms[0];
	var mode = document.forms[0].mode.value;
	if(mode == "modify"){
		
		if(obj.trmt_category_type.DB_VALUE == "" ){
			obj.trmt_category_type.value = "";
		}
		else{
			obj.trmt_category_type.value = obj.trmt_category_type.DB_VALUE
				
		}
		
	}
}

function getComplicationLookUp(obj,target){
	//alert(obj.value)
	//alert(target.value)
	var locale = document.forms[0].locale.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var sql="";
	var frmObj=document.MComplicationsForm;
	var complication_desc = frmObj.complication_desc.value;

    if (tit_flag="Complication Search"){
	    sql="SELECT COMPLICATION_CODE CODE, COMPLICATION_DESC DESCRIPTION FROM OH_COMPLICATION_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND UPPER(COMPLICATION_DESC) LIKE UPPER(?) AND UPPER(COMPLICATION_CODE) LIKE UPPER(?) ORDER BY 1";	
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = complication_desc;
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


 function assignValue(obj,row){
	var formObj = document.forms[0];
	//var trmt_category_type_code = eval("formObj.trmt_category_type_code_"+row);
	if(obj.checked==true)
		obj.value="Y";	
	else
		obj.value = "N";
}

function getTreatment(obj){
	//refreshing MessageFrame when select complications
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";

	var formObj = document.MComplicationsForm;
	var complication_code = formObj.complication_code.value;
	var row_count=formObj.row_count.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "complication_code="+complication_code;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","MTrmtCatTypeForComplicationsValidation.jsp?func_mode=populateTreatment&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	if(retVal.length >1){
		var retVal_arr=retVal.split("##");
        for(i=0;i<retVal_arr.length-1;i++){
	         var trmt_category_type= retVal_arr[i];
	         for( j=1;j<=row_count;j++){
	            var  trmt  =eval("formObj.trmt_category_type_code_"+j).value;
			       if(trmt_category_type==trmt){
					 eval("formObj.chk_"+j).checked=true;
				}
			}
        }
	}
}



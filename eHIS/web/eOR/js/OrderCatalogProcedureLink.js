/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
///////////////// Global Variable declaration ////////////////////////////////
var function_id = "" ;
var result = false;
var message = "" ;
var function_id = "" ;
var resultGlobal = false;
var messageGlobal = "" ;
var flagGlobal = true;
var detailDocUpdate=null;
var invalidCode			=null;
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;

/*Declaration ends here*/
/*****************initialization**************/
function intialiseGlobal(){
function_id = "" ;
resultGlobal = false;
messageGlobal = "" ;
flagGlobal = true;
}
/*********************Header Handle*****************************/
function getHandleHeader(){


if(parent.parent.f_query_add_mod.f_query_add_mod_header == null)
	 return false;
else{
	 headerDoc	     =parent.parent.f_query_add_mod.f_query_add_mod_header.document ;
	 formObjHeader   =headerDoc.OrderCatalogProcedureLinkHeader ;
}
}

/**********************Detail Handle**********************************/
function getHandleDetail(){


if(parent.parent.f_query_add_mod.f_query_add_mod_detail == null)
	 return false;
 detailDoc		 =parent.parent.f_query_add_mod.f_query_add_mod_detail.document ;
 formObjDetail	 =detailDoc.OrderCatalogProcedureLinkDetail ;

}
/***************************************/

function resetColorCode(obj)
{
//alert();
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail;
	arrPKFieldNames[0]	=	"proc_code";
	resetDuplicateClass( formObj, arrPKFieldNames,0, obj );
}
/********************Create function*************************************/

function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogProcedureLinkAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
}

/***************************************/

function query()
{
		f_query_add_mod.location.href='../../eOR/jsp/OrderCatalogProcedureLinkQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
}
/***************************delete record********************************/
function deleterecord(){
//	alert("in delete");
	
	if (! checkIsValidForProceed() || f_query_add_mod.f_query_add_mod_header.document.forms[0].mode.value == '1') {
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	var formObj=f_query_add_mod.f_query_add_mod_header.OrderCatalogProcedureLinkUpdate;
	var mode = formObj.mode.value ;
	//alert("mode="+mode);
	
	if(mode == '1' ){//no action
		var message  = getMessage("NOT_VALID_DELETE","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
		
	}
	
	else 
	
    //formObj.mode.value = "0"; //set mode to delete
	//alert("formObj.mode.value="+formObj.mode.value);
	var confirm_val= window.confirm(getMessage("DELETE_CONFIRM","OR"));
	if(confirm_val){
	formObj.mode.value = "0"; //set mode to delete
	eval(formApply(formObj,OR_CONTROLLER));
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;	
	if(resultGlobal){//	onSuccess();
	create();
	intialiseGlobal();	
	}	
	}else
	
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	
}
/***************************************/
function checkIsValidForProceed()
{
 var url =f_query_add_mod.location.href;
 url = url.toLowerCase();
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}
/***************************************/
function apply(){
	
	//alert("1");
	if (!checkIsValidForProceed()){
		//alert(f_query_add_mod.location.href);
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}


	// local variable of the function apply this only function using for modify and insert
	var flag1		= true;
	var flag2		= true;
	var flag		= true ;
	var msgID		= "";
	var msgDesc		= "";
	var arrIDS		= new Array();
	var arrIDesc	= new Array();
	var size =0;
 
	
// if(f_query_add_mod.f_query_add_mod_detail!=null){

if(f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail!=null)
{
	if(f_query_add_mod.f_query_add_mod_header.document.forms[0].mode.value==MODE_INSERT ){
		f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.order_catalog_code.value = f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkHeader.order_catalog_code.value;
		
		var fields = new Array (f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.order_catalog_code);
		var names = new Array ( getLabel("Common.ordercatalog.label","Common"));
	
		if(checkFieldsofMst( fields, names, messageFrame)) {
				
			/*for(i = 0 ; i < 10 ; i++){
				
				var flds=new Array(eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code"+i));
				var name=new Array("Term Code");
				if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
					return false
				}
			}	*/
			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();

			//arrFieldName[0]		=	"term_set";
			arrFieldName[0]			=	"term_set_desc";
			//arrFieldName[1]		=	"default_yn";

			//arrLegends[0]			=	"Term Set";
			arrLegends[0]			=	"Term Code";
			//arrLegends[1]			=	"Default";

			//arrPKFieldNames[0]	=	"term_set";
			arrPKFieldNames[0]		=	"term_set_desc";

		resetDuplicateClass(f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail, arrPKFieldNames );
		
			var	result1	=	validateMandatoryFields(f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail,arrFieldName,arrLegends,arrPKFieldNames);
			
		//var	result1 = true;
		if(result1) {
			
			if(!chkDulplicateProcedureLink())
				return false;

			for(k=0;k<10;k++){
			
			if(eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code"+k).value!=null && eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code"+k).value!="" )
			{
				var fields1 = new Array (eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set"+k));
				var names1	= new Array ( getLabel("Common.TermSet.label","COMMON"));
				if(checkFieldsofMst( fields1, names1, messageFrame))					
					commontoolbarFrame.document.location.reload();
				else
					return false;
			}					
			}
			
       eval(formApply(f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail,OR_CONTROLLER));
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;

			if(resultGlobal) {
					onSuccess();
			}else if(invalidCode != "" && invalidCode != "null"){
				if(invalidCode.indexOf(":")!=-1)
					invalidCode=invalidCode.substring(3, invalidCode.length);

				var invalidCd_arr = invalidCode.split(",");
				invalidCode ="";
				var frmObjDetail = f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail;

				for (var c=0;c<invalidCd_arr.length;c++ )
				{
					for(k=0;k<10;k++){
						if(eval("frmObjDetail.term_set_code"+k).value!="" )
						{
							if(eval("frmObjDetail.term_set_code"+k).value ==invalidCd_arr[c])			
								invalidCode += eval("frmObjDetail.term_set_desc"+k).value+", ";
						}					
					}
				}

				messageGlobal = messageGlobal.substring(0,(messageGlobal.lastIndexOf(".")));
				invalidCode = invalidCode.substring(0,(invalidCode.length - 2));
				//showDuplicates(f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail,arrPKFieldNames,invalidCode,"0",messageFrame );

				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+	messageGlobal+": "+invalidCode;
				}
			} // end of if result
		}  // end of chk field
	}
}else{
			eval(formApply(f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkUpdate ,OR_CONTROLLER));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=  "+ messageGlobal;

			if(resultGlobal) {
				onSuccess();
			}		
	 }  // end of else 

}
/**************************************/
function assignResult(_result , _message, _flag, invCode){
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;

}

/***************************************/
function chkDulplicateProcedureLink(){
//alert("8");
	//Chk whether detail form present or not
//	if(parent.frames[1].location.href.indexOf(".jsp") != -1){
	
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1){
	return true;
	}
	//getHandleHeader();
	//getHandleDetail();


	var ProcedureLinkArrayLocal  = new Array();
	var ProcedureLinkArrayLocal_desc  = new Array();
	var arrLocalLen = 0;

	
	 //Construct arrLocal array for the Page
	for(i=0;i<10;i++){
		//alert("9");

		var obj  = eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code" +i) ;
		//alert("code"+obj.value);
		if(obj.value != "" && obj.value != null ){
			ProcedureLinkArrayLocal[i] = obj.value ;
			ProcedureLinkArrayLocal_desc[i] = eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_desc" +i).value ;
			//alert("desc"+eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_desc" +i).value);
			if(ProcedureLinkArrayLocal_desc[i] ==""){ eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code" +i).value="";
//		alert("second"+eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_code" +i).value);
			ProcedureLinkArrayLocal[i] = "";}
		}else{
			ProcedureLinkArrayLocal[i] = "";
			ProcedureLinkArrayLocal_desc[i] = "";
		}
	}


	arrLocalLen = ProcedureLinkArrayLocal.length ;
//alert("ActivityTypeArrayLocal="+ActivityTypeArrayLocal);
//alert("arrLocalLen="+arrLocalLen);

	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;
	var dup_desc ="";

	for(k=0;k<(ProcedureLinkArrayLocal.length-1);k++)
	{
		//alert("10");
		var chk = ProcedureLinkArrayLocal[k] ;

		if(chk != "" && chk != null )
		{
			//alert("11");
				for(h=k+1;h<ProcedureLinkArrayLocal.length;h++)
				{
						//alert("333333333331");
					if(chk==ProcedureLinkArrayLocal[h])
					{
						chkDuplicate = true ;
						eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_desc" +k).className   =   "DUPLICATE";
						eval("f_query_add_mod.f_query_add_mod_detail.document.OrderCatalogProcedureLinkDetail.term_set_desc" +h).className   =   "DUPLICATE";
						dup_desc += ProcedureLinkArrayLocal_desc[h] + ", ";
					}
				}
		}

	}
	dup_desc = dup_desc.substring(0,(dup_desc.length - 2))
	if(chkDuplicate == true)
	{ 
//alert("12");
		
		var message  =getMessage("DUPLICATE_CODE_EXISTS","OR") + " : " 
		//alert("APP-OR0005 Duplicate values are passed");
		//var message = getOrMessage("SEQ_TICK_SHEET_SECTION_CHK") ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message+dup_desc;
		return false ;
	}
//alert("13");

	return true;

}//End of Duplicate Function
/***************************************/
function onSuccess(){

		formReset ();

}
/***************************************/
function formReset () {

	f_query_add_mod.location.reload();
}
/***************************************/

function reset(){
	
	var url = f_query_add_mod.location.href;

	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) ){
		
		return true;
	}
	if(url.indexOf("query") != -1){
		f_query_add_mod.document.forms[0].reset();
		return true;
	}
	
	if(url.indexOf(".jsp") != -1 ){
		if(f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkUpdate !=null)
		f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkUpdate.reset();

		else if(f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkHeader !=null)
		f_query_add_mod.f_query_add_mod_header.document.OrderCatalogProcedureLinkHeader.reset();

		f_query_add_mod.f_query_add_mod_detail.location.reload();
	}
	
}
/***********show_window for Order Catalog*************/
function before_show_order_catalog_window(target,code){
getHandleHeader();
if(formObjHeader!=null){
	if(target.value != document.getElementById("temp_order_catalog").value) {
		if(target.value!="")
			show_order_catalog_window(target,code);
		else{
		target.value="";
		code.value="";
		document.getElementById("temp_order_catalog").value="";
	}
}
}
}
async function show_order_catalog_window(target,code){
	getHandleHeader();
if(formObjHeader!=null){
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.getElementById("order_catalog_sql").value;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal =await CommonLookup( getLabel("Common.ordercatalog.label","Common"), argumentArray );
	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}
	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
	  document.getElementById("temp_order_catalog").value=arr[1];
    }
}
}

/***********show_window for Procedure*************/
async function show_term_set_desc_window(target,code,i) {
	//alert("show_term_set_desc_window");
  	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;

	getHandleDetail();
	
	//dataNameArray[0] 	= "term_set_id" ;		 
 	//dataValueArray[0] 	= eval("formObjDetail.all.term_set")+i.value;
 	//dataValueArray[0] 	= trimString(eval("formObjDetail.all.term_set"+i).value);
 	//dataTypeArray[0] 	= STRING ;
	termcode=	trimString(eval(document.getElementById("term_set" + i)).value);
	
 	argumentArray[0]   = "select TERM_CODE code,SHORT_DESC description from mr_term_Code where term_set_id like '"+termcode+"' and PROCEDURE_YN = 'Y' and SELECT_YN = 'Y' and eff_Status = 'E' and upper(TERM_CODE) LIKE  UPPER(?) AND UPPER(SHORT_dESC) LIKE UPPER(?)  order by 2";
	
	argumentArray[1]   = dataNameArray ;
 	argumentArray[2]   = dataValueArray ;
 	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value ;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;
  	retVal =await CommonLookup( getLabel("Common.TermCode.label","COMMON"), argumentArray );
  	var ret1=unescape(retVal);
	 var arr=ret1.split(",");
		if(arr[1]==undefined) 
		{
			arr[0]="";	
			arr[1]="";	
		}

	if(retVal != null && retVal != "")
	{
	  code.value=arr[0];
	  target.value=arr[1];
	  
    }else
	{
		target.value="";
		target.focus();
	}
}
/***********populateTermSet value**************/
function populateTermSet(obj,j){
	getHandleDetail();
	eval(document.getElementById("term_set_desc"+j)).value="";
	
	for(var i=0;i<10;i++){
		if(eval(document.getElementById("term_set_desc"+i)).value=="")
		{
			eval(document.getElementById("term_set"+i)).value=obj.value;

		}
	}

}
/***********default_yn value**************/
function defaultYnValue(obj){
if (obj.checked==true)
obj.value="Y";
else
	obj.value="N"
//alert("ddddd="+obj.value);
return obj;

}

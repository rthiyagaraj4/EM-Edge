var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
function create() {
	f_query_add_mod.location.href="../../eMM/jsp/ViewCostDetailsforUserAdd.jsp?function_id="+function_id+"&mode="+MODE_INSERT; 
}
function query() {
	
	f_query_add_mod.location.href="../../eMM/jsp/ViewCostDetailsforUserQueryCriteria.jsp?function_id="+function_id ;
}
function check_Status(obj)
	{

	if(obj.checked==true)
		obj.value="Y";
	else{
		
		if(obj.checked==false)
		obj.value="N";
		
		}
		
		
}
function set_Status(obj)
	{

	if(obj.checked==true)
		obj.value="Y";
	else{
		
		if(obj.checked==false)
		obj.value="N";
		
		}
		
}
function assignResult( _result, _message, _flag) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
	//invalidCode	=	_invalidCode;
}	
function Modify(obj)
{
	
	
	var user_id							=	obj.cells[0].innerText;
	var user_name						=	obj.cells[1].innerText;
	var view_cost_details_yn			=	obj.cells[2].innerText;
	
	document.location.href	=	"../../eMM/jsp/ViewCostDetailsforUserModify.jsp?mode="+MODE_MODIFY+"&user_id="+user_id+"&user_name="+user_name+"&view_cost_details_yn="+view_cost_details_yn;
}
function apply()
{
		var formObj					=		f_query_add_mod.document.formViewCostAddModify;
		var mode					=		formObj.mode.value;
		if(mode==("2"))
		{
			
			var errorPage	= "../../eCommon/jsp/error.jsp" ;	
			var responseText=formApply(formObj, MM_CONTROLLER );			
			eval( responseText ) ;		
			messageFrame.location.href = errorPage+"?err_num="+ message ;	
			if( result ) 
			{
				//onSuccess();
				//f_query_add_mod.document.formViewCostAddModify.reset();
			}
			
		}
		else
		{
			
			applyOnInsert(formObj);
		}
}
function applyOnInsert(formObj)
{
	/*	alert(formObj.name);
		var totalRecords				=		formObj.totalRecords.value;
		for(var i=0;i<totalRecords;i++)
		{
			
			//var user_id				=		eval("f_query_add_mod.document.formViewCostDetailsModify.user_name_"i)+.value;
			var user					=		eval("formObj.user_id"+i).value;
		
			if(user!="")
			{
					alert("user"+user);
				var user_name				=		eval("formObj.user_name"+i).value;	
				var view_cost_details		=		eval("formObj.view_cost_details_yn"+i).value;
				var fields	=	new Array	(eval("formObj.user_id"+i));
				var names	=	new Array	("userid");
				var errorPage	= "../../eCommon/jsp/error.jsp" ;	
				alert("fields---"+fields);
				var blankObject 	= null ;
				blankObject  = checkMMFields( fields, names, messageFrame,errorPage) ;
				alert("blankObject---"+blankObject);
				if(blankObject==true)
				{
					alert("blankObject--enters-"+blankObject);
					eval( formApply(formObj, MM_CONTROLLER ) ) ;
					alert("blankObject-after-"+blankObject);
					messageFrame.location.href = errorPage+"?err_num="+ message ;	
					if( result ) 
					{
						onSuccess();
					}
				}
				
			}
			else{
			alert("else---");
				return;
			}
			
		}*/
	var arrFieldName				=	new Array();
	var arrLegends					=	new Array();
	var arrPKFieldNames				=	new Array();

	arrFieldName[0]					=	"user_id";	
	arrLegends[0]					=	getLabel("Common.userid.label","Common");
	arrPKFieldNames[0]				=	"user_id";	

	var formObj						=	f_query_add_mod.document.formViewCostAddModify;
	var errorPage					= "../../eCommon/jsp/error.jsp" ;	
	var totalRecords				=		formObj.totalRecords.value;
	messageFrame.location.href = errorPage+"?err_num="+ message ;	
	var startIndex      =   0;
	if(formObj.mode.value==MODE_INSERT)
	{	
		

		var	canProceed	=	validateMMSTMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,startIndex, messageFrame, errorPage );
		
		if(canProceed)
		{
			responseText=formApply( formObj, MM_CONTROLLER ) ;
			eval( responseText) ;
			messageFrame.location.href	=	 "../../eCommon/jsp/error.jsp?err_num="+ message;
			if( result ) 
			{
				onSuccess();
			}
			else 
			{
				return;
			}
		}
	}
}
function onSuccess()
{
	
		f_query_add_mod.document.formViewCostAddModify.reset();
		
}
function setStatus(obj)
{
	if(obj.checked==true)
		obj.value="Y";
	else
		obj.value="N";
	
	return obj.value;
}
function reset()
{
	f_query_add_mod.document.formViewCostAddModify.reset();
}
function searchCode(obj,index) 
{
	var argumentArray  =	new Array() ;
	var dataNameArray  =	new Array() ;
	var dataValueArray =	new Array() ;
	var dataTypeArray  =	new Array() ;

	var sql			   =	"SELECT appl_user_id code,	appl_user_name  description              FROM	   sm_appl_user_lang_vw sm_appl_user  where   language_id = '"+document.forms[0].p_language_id.value+"'  AND      eff_status='E'  AND appl_user_id	 like    UPPER(?)  AND  UPPER(appl_user_name)	  like  UPPER(?) ";
	
	argumentArray[0]   =	sql;
	argumentArray[1]   =	dataNameArray ;
	argumentArray[2]   =	dataValueArray ;
	argumentArray[3]   =	dataTypeArray ;
	argumentArray[4]   =	"1,2"; 
	argumentArray[5]   =	obj.value
	argumentArray[6]   =	DESC_LINK ;
	argumentArray[7]   =	DESC_CODE ; 

	returnedValues	   =		CommonLookup( getLabel("Common.user.label","Common"), argumentArray );	
	
	if(returnedValues != null && returnedValues != "" )  {
	
		obj.value	   =		returnedValues[0];
		//eval("document.forms[0].user_id"+index).disabled=true;
		eval("document.forms[0].user_name"+index).value=returnedValues[1];
		//eval("document.forms[0].user_name"+index).disabled=true;
		
	} 
		
}


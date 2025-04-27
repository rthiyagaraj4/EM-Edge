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
var  formObjDetailUpdate=null	;
var invalidCode			=null;
var headerDoc			=null;
var detailDoc			=null;
var formObjHeader		=null;
var formObjDetail		=null;

/////////////////Declaration ends here////////////////////////////////////
/*********************Header Handle*****************************/
function getHandleHeader()
{
	if(f_query_add_mod.f_query_add_mod_header == null)
		 return false;
	headerDoc	     =f_query_add_mod.f_query_add_mod_header.document ;
	 formObjHeader   =headerDoc.formTickSheetSectionheader ;
}
///////////////////////////////////////////////////////////////////////////////////
function create() 
{
	f_query_add_mod.location.href = '../../eOR/jsp/SectionForTickSheetAddModifyMultiple.jsp?mode=1&function_id=Tick_Sheet_Section';
}
////////////////////////////////////////////////////////////////////////////////
function query() 
{
	f_query_add_mod.location.href='../../eOR/jsp/SectionForTickSheetQueryCriteria.jsp';
}
///////////////////////////////////////////////////////////////////////////////
function resetColorCode(obj)
{
	var arrPKFieldNames	=	new Array();
	var arrPKFieldNames1	=	new Array();
	var formObj			=	parent.f_query_add_mod_detail.document.tick_sheet_section_dtl;
	arrPKFieldNames[0]	=	"tick_sheet_section_sec";
	arrPKFieldNames1[0]	=	"seq_no";
	resetDuplicateClass( formObj, arrPKFieldNames,0, obj );
	resetDuplicateClass( formObj, arrPKFieldNames1,0, obj );
}
///////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////////////////////
function checkIsValidForProceed()
{
 var url = f_query_add_mod.location.href;
 url = url.toLowerCase();//http://dsg13:8887/ehis/eor/jsp/SectionForTickSheetAddModifyMultiple.jsp?mode=1&function_id=Tick_Sheet_Section'
 if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
  return true;
 else
  return false;
}
/////////////////////////////////////////////////////////////////////////////////
// function for apply the data to the data base and do some mandatory validation at client side also
async function apply() 
{
	if (!checkIsValidForProceed())
	{
		var message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	// local variable of the function apply this only function using for modify and insert
	var flag1=true;
	var flag2=true;
	var flag	= true ;
	var msgID		= ""   ;
	var msgDesc		= ""   ;
	var arrIDS		= new Array();
	var arrIDesc		= new Array();
	var size =0;	
	if(f_query_add_mod.f_query_add_mod_detail.document.tick_sheet_section_dtl.mode.value==MODE_INSERT )
	{
		var fields = new Array ( f_query_add_mod.f_query_add_mod_header.document.formTickSheetSectionheader.order_category,f_query_add_mod.f_query_add_mod_header.document.formTickSheetSectionheader.tick_sheet);
		var names = new Array ( getLabel("Common.OrderCategory.label","Common"),getLabel("eOR.TickSheet.label","OR")	);
		if(checkFieldsofMst( fields, names, messageFrame)) 
		{
			var formObjH = f_query_add_mod.f_query_add_mod_header.document.formTickSheetSectionheader;
			var formObj = f_query_add_mod.f_query_add_mod_detail.document.tick_sheet_section_dtl;
			formObj.order_category_id.value = formObjH.order_category.value;
			formObj.tick_sheet_id.value = formObjH.tick_sheet.value;			
			for(i = 0 ; i < 10 ; i++)
			{
				var flds=new Array(eval("formObj.tick_sheet_section_sec"+i));
				var name=new Array(getLabel("Common.code.label","Common"));
				if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp"))
				{
					return false
				}
			}			
			/*********************************CODE FOR CHK DUPLICATES ends*************************/
			var arrFieldName		=	new Array();
			var arrLegends			=	new Array();
			var arrPKFieldNames		=	new Array();
			arrFieldName[0]			=	"tick_sheet_section_sec";
			arrFieldName[1]			=	"tick_sheet_section_dsec";
			arrFieldName[2]			=	"seq_no";
			arrLegends[0]			=	getLabel("Common.code.label","Common");
			arrLegends[1]			=	getLabel("Common.description.label","Common");
			arrLegends[2]			=	getLabel("eOR.SequenceNumber.label","OR");
			arrPKFieldNames[0]		=	"tick_sheet_section_sec";			
			resetDuplicateClass(formObj, arrPKFieldNames );	
			var	result1	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames);
			if(result1) 
			{
				if(!chkDulplicateSeqNo())
					return false;	  
				eval(formApply(formObj,OR_CONTROLLER));
				messageFrame.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num="+ messageGlobal;
				if(resultGlobal) 
				{
					onSuccess();
				}
				else if(invalidCode != "" && invalidCode != "null")
				{
					if(invalidCode.indexOf(":")!=-1)
					{
						invalidCode = invalidCode.substring((invalidCode.indexOf(":")+1), invalidCode.length);
					}
					showDuplicates(formObj,arrPKFieldNames,invalidCode,"0",messageFrame );
				}
			}
		}
	}
	//////////////////code for modify operation /////////////////////////////////////////////////
	else 
	{		
		
		var fields = new Array ( f_query_add_mod.f_query_add_mod_detail.document.tick_sheet_section_dtl.seq_no,f_query_add_mod.f_query_add_mod_detail.document.tick_sheet_section_dtl.description);
		var names = new Array ( getLabel("eOR.SequenceNumber.label","OR"),getLabel("eOR.SectionDesc.label","OR"));
		if(checkFieldsofMst( fields, names, messageFrame))
		{
			
			eval(f_query_add_mod.f_query_add_mod_detail.document.tick_sheet_section_dtl ,OR_CONTROLLER);
			
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=  "+ messageGlobal;
			if(resultGlobal) 
			{
				onSuccess();
			}
		}
	}// else modify ends here
}//function apply ends here
////////////////////////////////////////////////////////////////////////
function onSuccess()
{
		formReset ();
}
////////////////////////////////////////////////////////////////
function formReset () 
{
	f_query_add_mod.location.reload();
	//f_query_add_mod.f_query_add_mod_detail.tick_sheet_section_dtl.reset();
//	f_query_add_mod.f_query_add_mod_header.formTickSheetSectionheader.reset();
//	f_query_add_mod.f_query_add_mod_detail.location.reload();
//	f_query_add_mod.f_query_add_mod_header.location.reload();
}
/////////////////////////////////
function reset()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")!= -1) &&(url.indexOf("blank")!= -1) )
	{
		return true;
	}
	if(url.indexOf("query") != -1)
	{
		f_query_add_mod.document.forms[0].reset();
		return true;
	}
	if(url.indexOf(".jsp") != -1)
	{
		f_query_add_mod.f_query_add_mod_header.document.forms[0].reset();
		f_query_add_mod.f_query_add_mod_detail.document.forms[0].reset();
	}
}
//////////////////////////////////////////////////////////////////////
function assignResult(_result , _message, _flag, invCode)
{
	resultGlobal = _result ;
	messageGlobal  = _message ;
	flagGlobal = _flag ;
	invalidCode=invCode;
}
	  /*
function beforePost(str)
	{
		alert(str);
	}
	   */
///////////////////////////////////////////////////////////////////////////
function addTickSheet2List(code,value)
{
	var element = document.createElement('OPTION') ;
	element.value = code ;
	element.text  = value ;
	document.formTickSheetSectionheader.tick_sheet.add(element);
}
/////////////////////////////////////////////////////////////////////////////

function clearTickSheetSectionList( docObj ) 
{
	var len = eval(docObj+".formTickSheetSectionheader.tick_sheet.options.length") ;
	for(var i=0;i<len;i++)
	{
		eval(docObj+".formTickSheetSectionheader.tick_sheet.remove(\"tick_sheet\")") ;
	}
	var tp = "          --- "+getLabel("Common.defaultSelect.label","Common")+" ---          " ;
	var opt = eval(docObj+".createElement(\"OPTION\")") ;
	opt.text = tp ;
	opt.value = "" ;
	eval(docObj+".formTickSheetSectionheader.tick_sheet.add(opt)") ;
}

////////////////////////////////////////////////////////////////////////////////

function fillTickSheetSection(OrderCategory) 
{
	if(OrderCategory.value == "" ) 
	{
		parent.f_query_add_mod_header.location.reload();
		return ;
	}
	var OrdrCategoryValue = OrderCategory.value ;
	var bean_id = document.formTickSheetSectionheader.bean_id.value ;
	var localeName = document.formTickSheetSectionheader.localeName.value ;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr ="<root><SEARCH " ;
	xmlStr += OrderCategory.name+"=\""+ OrderCategory.value +"\" " ;
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SectionForTickSheetFillTickSheet.jsp?bean_id=Or_SectionForTickSheet&fill=OrderCategory&localeName="+localeName,false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ; 
	eval( responseText ) ;
}
//////////////////////////////////////////////////////////////////////////////
function resetLower()
{
	getHandleDetail();
	if((formObjDetail!="null") && !(formObjDetail==null))
	formObjDetail.reset();
}
/**********************Detail Handle**********************************/
function getHandleDetail()
{
	detailDoc		 =f_query_add_mod.f_query_add_mod_detail.document ;
	formObjDetail	 =detailDoc.tick_sheet_section_dtl ;
}
///////////////////////////////////////////////////////////////////////////////
/*
function fillUpdate(formObj){
//		alert("fillUpdate");
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;

	xmlStr ="<root><SEARCH " ;
	xmlStr += formObj.order_category.name+"=\""+ formObj.order_category.value +"\" " ;
	xmlStr += formObj.tick_sheet_id.name+"=\""+ formObj.tick_sheet_id.value +"\" " ;
	xmlStr += formObj.section_code.name+"=\""+ formObj.section_code.value +"\" " ;
	xmlStr +=" /></root>" ;
	alert(xmlStr);
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST", "SectionForTickSheetFillUpdate.jsp?bean_id=Or_TickSheetForSection",false ) ;
	xmlHttp.send( xmlDoc ) ;
	responseText=xmlHttp.responseText ;
//	alert(responseText);
	eval( responseText ) ;
}
*/
function AssignDesc(desc1,eff_status1)
{
	getHandleDetail();
	if(eff_status1=="E")
	{
		formObjDetail.eff_status.value="E";
		formObjDetail.eff_status.checked=true;
		formObjDetail.description.value=desc1;
		formObjDetail.description.disabled=false;
	//formObjDetail.description.focus();
	}
	else
	{
		formObjDetail.description.disabled=true;
		formObjDetail.eff_status.value="D";
		formObjDetail.eff_status.focus();
		formObjDetail.eff_status.checked=false;
//	alert("the value of eff_status  ::"+formObjDetail.eff_status.value);
	//alert("the value of section desc ::"+	formObjDetail.description.value);
	}
}

function checkPositiveNumber(obj) 
{
  var obj_value = obj.value;    // checks for positive number greater than zero
   var obj_length = obj_value.length;
	if(obj.value == "")
	{
		return true;
	}
	if(obj != null )
	{

		if(obj_value > 0)
		{
			return true;
		}
		else
		{
			alert(getMessage("ONLY_POSITIVE_NUM",'OR'));
			obj.value= ""
			obj.focus();
			return false;
		}
	}
	else
	{
		return true;
	}
}

/********************Check Duplicate Sequence Number function******************************/
function chkDulplicateSeqNo()
{
	//Chk whether detail form present or not
//	if(parent.frames[1].location.href.indexOf(".jsp") != -1){	
	if(f_query_add_mod.f_query_add_mod_detail.location.href.indexOf(".jsp") == -1)
	{
		return true;
	}
	getHandleDetail();
	getHandleHeader();
	var SqnArrayLocal  = new Array()
	var arrLocalLen = 0;	
	 //Construct arrLocal array for the Page
	for(i=0;i<10;i++)
	{
		var obj  = eval("formObjDetail.seq_no" +i) ;		
		if(obj.value != "" && obj.value != null )
			SqnArrayLocal[i] = obj.value ;
		else
			SqnArrayLocal[i] = "";
	}
	arrLocalLen = SqnArrayLocal.length ;
	//CODE FOR CHK DUPLICATES on Local Page
	var chkDuplicate = false ;
	for(k=0;k<(SqnArrayLocal.length-1);k++)
	{
		var chk = SqnArrayLocal[k] ;
		if(chk != "" && chk != null )
		{
			for(h=k+1;h<SqnArrayLocal.length;h++)
			{
				if(parseInt(chk) == parseInt(SqnArrayLocal[h]))
				chkDuplicate = true ;
			}
		}
	}
	if(chkDuplicate == true)
	{
//		var message  ="APP-OR0005 Duplicate values are passed";
		var message = getMessage("SEQ_TICK_SHEET_SECTION_CHK","OR") ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}
	return true;
}//End of Duplicate Function

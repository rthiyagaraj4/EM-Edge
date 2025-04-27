/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id		= "" ;
var	result			= false;
var	flag			= "" ;
var	message			= "" ;
var isCreate = "N";
var isQuery = "N";
var isApplied = "N";
var atleastOne = false;


//var mode = "1";
function create()
{
	f_query_add_mod.location.href='../../eOR/jsp/ChartVerticalAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
	isCreate = "Y";
	isQuery = "N";
}

function query()
{
	f_query_add_mod.location.href='../../eOR/jsp/ChartVerticalQueryCriteria.jsp?mode='+MODE_MODIFY+"&function_id="+function_id ;
	isQuery = "Y";
	isCreate = "N";
}

function reset()
{
	if(isCreate == "Y")
	{
		f_query_add_mod.location.href='../../eOR/jsp/ChartVerticalAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
		message = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		isCreate = "Y";
		isQuery = "N";
	}
	else
	{
		if(isQuery == "Y")
		{
		if(checkIsValidForReset())
			{
				var wholeString = f_query_add_mod.frmChartVertical.wholeString.value;
				var wholeStringArray = wholeString.split("$");
				var mode = wholeStringArray[0];
				var chart_result_type = wholeStringArray[1];
				var chart_vertical_code = wholeStringArray[2];
				var long_description = wholeStringArray[3];
				var short_description = wholeStringArray[4];
				var seq_no = wholeStringArray[5];
				var discr_msr_id = wholeStringArray[6];
				var copy_prev	= wholeStringArray[7];
				var temp	= wholeStringArray[8];

				var copy_prev = wholeStringArray[7];
				f_query_add_mod.location.href = "../../eOR/jsp/ChartVerticalAddModify.jsp?mode="+mode+"&"+"chart_result_type="+chart_result_type+ "&" + "chart_vertical_code="+chart_vertical_code+"&"+"long_description="+long_description+"&"+"short_description="+short_description+"&"+"seq_no="+seq_no+"&"+"discr_msr_id="+discr_msr_id+"&"+"prev="+copy_prev+"&temp="+temp;
			}
			else
			{
				f_query_add_mod.document.forms[0].reset();
				//f_query_add_mod.location.href = "../../eOR/jsp/ChartVerticalQueryCriteria.jsp?function_id="+function_id;
			}
		}
	}
}
function deleterecord()
{
}
function apply()
{
	
	if (! checkIsValidForProceed() )
    {
			message  = getMessage("NOT_VALID","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
	}
	var frmObj = f_query_add_mod.document.frmChartVertical;

	if(frmObj.mode.value == MODE_INSERT)
	{
			var frmObj = f_query_add_mod.document.frmChartVertical;
		var noOfRecords = frmObj.noOfRecords.value;
		var discr_msr_desc_atleastOne=false;
		var long_flag= false;
		var short_flag= false;

		var fields = new Array ( frmObj.result_type);
		var names = new Array ( getLabel("eOR.resultmatrix.label","OR"));
		if(!checkFieldsofMst( fields, names, messageFrame)) {
			 return false;
		}
		/*for(i = 0 ; i < 10 ; i++){
			var flds=new Array(eval("frmObj.code"+i));
			var name=new Array("Code");
			if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
				eval("frmObj.code"+i).focus();
				eval("frmObj.code"+i).select();
				return false
			}
		}*/
		var arrFieldName		=	new Array();
		var arrLegends			=	new Array();
		var arrPKFieldNames		=	new Array();
	 
		arrFieldName[0]			=	"code";
		arrFieldName[1]			=	"long_desc";
		arrFieldName[2]			=	"short_desc";
		arrFieldName[3]			=	"seq_no";
		
		
		arrLegends[0]			=	encodeURIComponent(getLabel("eOR.Coded.label","OR"));
		arrLegends[1]			=	encodeURIComponent(getLabel("Common.longdescription.label","Common"));
		arrLegends[2]			=	encodeURIComponent(getLabel("Common.shortdescription.label","Common"));
		arrLegends[3]			=	encodeURIComponent(getLabel("eOR.SequenceNo.label","OR"));
		
		
		arrPKFieldNames[0]		=	"code";


		
		var arrFieldName1		=	new Array();
		var arrLegends1			=	new Array();
		var arrPKFieldNames1		=	new Array();
		arrFieldName1[0]		=	"seq_no";
		arrLegends1[0]			=	getLabel("Common.SequenceNo.label","Common");
		arrPKFieldNames1[0]		=	"seq_no";
	
		resetDuplicateClass( frmObj, arrPKFieldNames );
		resetDuplicateClass( frmObj, arrPKFieldNames1 );
		//var	result1	=	validateMandatoryFields(frmObj,arrFieldName,arrLegends,arrPKFieldNames);
		var startIndex="0";
		var objMessageFrame=messageFrame;
		var errorPage="";

		var	result1	=	validateMandatoryFields(frmObj,arrFieldName,arrLegends,arrPKFieldNames,startIndex, objMessageFrame, errorPage);
		
		if(result1)
		{ 
			var result2			=	validateSeqDupno(frmObj,arrFieldName1,arrLegends1,arrPKFieldNames1,startIndex, objMessageFrame, errorPage);
			if(result2)
			{
				if(eval("frmObj.result_type").value != '')
				{
					for(var k=0;k<noOfRecords;k++)
					{
						if(eval("frmObj.code"+k).value != '' && eval("frmObj.long_desc"+k).value != '' && eval("frmObj.short_desc"+k).value != '' && eval("frmObj.seq_no"+k).value != '')
						{
							if(trimCheck(eval("frmObj.long_desc"+k).value)){
								long_flag= true;
							}else
							{
								long_flag= false;
								break;
							}
							if(trimCheck(eval("frmObj.short_desc"+k).value))
								short_flag= true;
							else
							{
								short_flag= false;
								break;
							}
							if(long_flag && short_flag)
								atleastOne = true;
							if (eval("frmObj.discr_msr_desc"+k).value != '' && eval("frmObj.discr_msr_desc"+k).value != null && eval("frmObj.discr_msr_desc"+k).value != "" )
							{
								discr_msr_desc_atleastOne = true;
							}
						}
					}
				}
			/*	else
				{
					message = getOrMessage("RESULT_TYPE_BLANK");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return;
				} */
				if(!long_flag)
				{
					message =getMessage("LONG_DESC_NOT_BLANK","MP");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return false;
				}
				else if(!short_flag)
				{
					message = getMessage("SHORT_DESC_NOT_BLANK","MP");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return false;
				}
				if(atleastOne)
				{
					frmObj.mode.value = "1";
					// added by kavitha k on 19.11.2004
					//for(var k=0;k<noOfRecords;k++)
					//{
						//if (eval("frmObj.discr_msr_desc"+k).value != '' && eval("frmObj.discr_msr_desc"+k).value != null && eval("frmObj.discr_msr_desc"+k).value != "" )
						//{
						//	 discr_msr_desc_atleastOne = true;
						//}
					//}
					if (discr_msr_desc_atleastOne == false)
					{ 
						var discr_msr_desc_msg = getMessage("ATLEAST_ONE_DISCR_MEASURE","OR");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ discr_msr_desc_msg;
						discr_msr_desc_msg = "";
						return false;
					}
					// end of added by kavitha k on 19.11.2004
					eval( formApply( frmObj,OR_CONTROLLER) );				
					if( result )
					{
						atleastOne = false;
						if(message == "DUPLICATE_CODE_EXISTS")
						{
							message = getMessage(message,"common");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						}
						else
						{
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							f_query_add_mod.location.href='../../eOR/jsp/ChartVerticalAddModify.jsp?mode='+MODE_INSERT+"&function_id="+function_id ;
						}
						return true ;
						isCreate = "Y";
						isQuery = "N";
					}
					else
					{
						if(message == "DUPLICATE_CODE_EXISTS")
						{
							message = getMessage(message,"common");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							message = "";
						}
						else
						{
							message = "";
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						}
					}
				}
				else		
				{	
					message = getMessage("ATLEAST_ONE_RECORD_ENTERED","common");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return;
				}
			}
		}
	}
	else
	{ 
		var	fields = new Array (frmObj.long_desc,frmObj.short_desc,frmObj.seq_no);
		var	names =	new	Array (getLabel("Common.longdescription.label","Common"),getLabel("Common.shortdescription.label","Common"),getLabel("eOR.SequenceNo.label","OR"));
		if(!f_query_add_mod.checkFieldsofMst(fields,names, messageFrame))
			return;
		var mode = frmObj.mode.value;
		var chart_result_type = frmObj.result_type.value;//////
		var temp = frmObj.chart_result_type.value;
		var chart_vertical_code = frmObj.code.value;
		var long_desc = frmObj.long_desc.value;
		var short_desc = frmObj.short_desc.value;
		var seq_no = frmObj.seq_no.value;
		var discr_msr_desc = frmObj.discr_msr_desc.value;
		var copy_prev = frmObj.copy_prev.value;

		frmObj.mode.value = "2";
		/*var flds=new Array(frmObj.long_desc,frmObj.short_desc);
		var name=new Array("LongDescription","Short Description");
		if(!SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
			return false
		}*/
		eval(formApply( frmObj,OR_CONTROLLER) );
		//alert("result="+result);
		if( result )
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//alert("long_desc="+long_desc);
			//alert("short_desc="+short_desc);
			f_query_add_mod.location.href="../../eOR/jsp/ChartVerticalAddModify.jsp?mode="+mode+"&chart_result_type="+chart_result_type+"&chart_vertical_code="+chart_vertical_code+"&long_description="+encodeURIComponent(long_desc)+"&short_description="+encodeURIComponent(short_desc)+"&seq_no="+seq_no+"&temp="+temp+"&discr_msr_id="+discr_msr_desc+"&prev="+copy_prev;
			isQuery = "Y";
			isCreate = "N";
			return true ;
		}else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			return false ;
		}
	}
}
function onSuccess()
{
		f_query_add_mod.location.href="../../eOR/jsp/ChartVerticalAddModify.jsp?mode="+mode+"&function_id="+function_id ;

	isCreate = "Y";
	isQuery = "N";
}
function assignResult( _result,	_message, _flag ) {
	result	= _result ;
	message	= _message	;
	flag	= _flag;
}

function checkIsValidForProceed()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
	  return true;
	 else
	  return false;
}

function checkIsValidForReset()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("addmodify.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}

function CheckForNumbers(target)
{

	var frmObj = document.frmChartVertical;
	if ( trimCheck(target.value) && isNaN(target.value) == false && target.value >0)
	{
		return true;
	}
	else
	{
		if(target.value == "0")
		{
			message = getMessage("SEQ_NO_NOT_ZERO","OR");

			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			target.value="";
		}
		else
		{
			if(target.value == "")
			{
				message	= "";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				return true;
			}
			else
			{
				message	= getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM");

				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				target.focus();
				target.value="";
			}
		}
	}
}

function checkActive(target)
{

	if(target.checked == false)
	{
		target.value = "D";
		target.checked = false;
	}
	else
	{
		target.value = "E";
		target.checked = true;
	}

}

function checkCopyPrev(target)
{

	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}

}

function checkForSpecial(target)
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if(strCheck.indexOf(key) == -1)
	{
		message		 = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM");

		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return;
	}
	else
	{
		message = "";
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
}

function checkIsValidForReset()
{
	 var url = f_query_add_mod.location.href;
	 url = url.toLowerCase();
	 if( url.indexOf("addmodify.jsp") != -1 )
		{
			return true;
		}
	 else
		{
 		 	return false;
		}
}

function searchForDiscreteMeasure( target )
{
	var index = (target.name).charAt((target.name).length-1);
			var frmObj=document.frmChartVertical;

	if(target.value == "" || target.value == " " || target.value == null)
	{
		eval("frmObj.copy_prev"+index).checked = false;
		eval("frmObj.copy_prev"+index).disabled = false;
		eval("frmObj.copy_prev"+index).value = "N";
	}
	else
	{
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;

		argumentArray[0] = frmObj.SQL_OR_CHART_RESULT_TYPE_DISCR_MSR.value;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target.value;
		argumentArray[6] = CODE_LINK ;//CODE_LINK
		argumentArray[7] = CODE_DESC ;//CODE_DESC

		retVal = CommonLookup(getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );

		/*if(retVal != null && retVal != "" )
		{
			eval("frmObj.discr_msr_id"+index).value = retVal[0];
			target.value = retVal[1];

		}else
		{
			target.value = "";
			eval("frmObj.copy_prev"+index).checked = false;
			eval("frmObj.copy_prev"+index).disabled = true;
			eval("frmObj.copy_prev"+index).value = "N";
		}
		if(target.value != null && target.value != "")
		{
			eval("frmObj.copy_prev"+index).disabled = false;
			eval("frmObj.copy_prev"+index).enabled = true;
		}*/
		
		//Modified on 17th Aug 2004 by Subhash.Y

		if(retVal != null && retVal != "" )
		{
			eval("frmObj.discr_msr_id"+index).value = retVal[0];
			target.value = retVal[1];

			eval("frmObj.copy_prev"+index).checked = false;
			eval("frmObj.copy_prev"+index).disabled = true;
			eval("frmObj.copy_prev"+index).value = "N";

		}else
		{
			target.value = "";
			/*eval("frmObj.copy_prev"+index).checked = false;
			eval("frmObj.copy_prev"+index).disabled = true;
			eval("frmObj.copy_prev"+index).value = "N";*/
		}
		/*if(target.value != null && target.value != "")
		{
			eval("frmObj.copy_prev"+index).disabled = false;
			eval("frmObj.copy_prev"+index).enabled = true;
		}*/
	}
}

async function searchForDiscreteMeasure1( target )
{
	var index = (target.name).charAt((target.name).length-1);

	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var frmObj=document.frmChartVertical;

	argumentArray[0] = frmObj.SQL_OR_CHART_RESULT_TYPE_DISCR_MSR.value;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;//CODE_LINK
	argumentArray[7] = CODE_DESC ;//CODE_DESC

	retVal = await CommonLookup(getLabel("Common.DiscreteMeasure.label","Common"), argumentArray );
var ret1=unescape(retVal);
	//alert("ret1"+ret1);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	/*if(retVal != null && retVal != "" )
	{
		eval("frmObj.discr_msr_id"+index).value = retVal[0];
		target.value = retVal[1];
	}else
	{
		target.value = "";
		eval("frmObj.copy_prev"+index).disabled = true;
	}
	if(target.value != null && target.value != "")
	{
		eval("frmObj.copy_prev"+index).disabled = false;
		eval("frmObj.copy_prev"+index).enabled= true;
	}
	*/
	if(retVal != null && retVal != "" )
	{
		eval("frmObj.discr_msr_id"+index).value = arr[0];
		target.value = arr[1];
		
		eval("frmObj.copy_prev"+index).checked = false;
		eval("frmObj.copy_prev"+index).disabled = true;
		eval("frmObj.copy_prev"+index).value = "N";

	}else
	{
		target.value = "";
		//eval("frmObj.copy_prev"+index).disabled = true;
	}
	/*if(target.value != null && target.value != "")
	{
		eval("frmObj.copy_prev"+index).disabled = false;
		eval("frmObj.copy_prev"+index).enabled= true;
	}*/

}
function resetLower()
{
	var frmObj = parent.f_query_add_mod.document.frmChartVertical;
	var noOfRecords = frmObj.noOfRecords.value;
	if(eval("frmObj.result_type").value != '')
	{
		for(var k=0;k<noOfRecords;k++)
		{
			eval("frmObj.code"+k).value='';
			eval("frmObj.long_desc"+k).value='';
			eval("frmObj.short_desc"+k).value='';
			eval("frmObj.seq_no"+k).value='';
			eval("frmObj.discr_msr_desc"+k).value='';
			eval("frmObj.eff_status"+k).checked= true;
			eval("frmObj.copy_prev"+k).checked=false;
			
		}
	}
	message = "";
	parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
}

function resetColorCode(obj)
{
    obj.className   =   "";
}
/****************************************************************************/
function validateSeqDupno( formObj, arrFieldName1, arrLegends1, arrPKFieldNames1, startIndex, objMessageFrame, errorPage )
{
    /**
      * Initialize default values
      */
    if(startIndex==null)        startIndex      =   0;

    if(objMessageFrame==null)   objMessageFrame =   messageFrame;
	else messageFrame = objMessageFrame
//    else                        objMessageFrame =   null;
    if(errorPage==null)         errorPage       =   "../../eCommon/jsp/MstCodeError.jsp";

    var fields              =   new Array();
    var names               =   new Array();
    var masterCodes         =   new Array();
    var arrPKFields         =   null;

    var notNullIndex        =   0;
    var currRowIndex        =   0;
    var masterIndex         =   0;
    var pkIndex             =   0;
    var uniqueFields        =   "";

    var totalRecords        =   formObj.totalRecords.value;
    var totalColumns        =   arrFieldName1.length;
    var totalPKColumns      =   arrPKFieldNames1.length;
    totalRecords            =   parseFloat(totalRecords) + parseFloat(startIndex);
    //alert("totalRecords : "+totalRecords);
    //alert("totalColumns : "+totalColumns);
    //alert("totalPKColumns : "+totalPKColumns);

    /**
      * Identify the rows and respective columns in the form, which has some values entered.
      */
    for( var rowIndex=startIndex; rowIndex<totalRecords; rowIndex++ )
    {
        var isNotNull       =   false;
        for( var colIndex=0; colIndex<totalColumns; colIndex++ )
        {
            current_field   =   eval("formObj."+arrFieldName1[colIndex]+rowIndex);
			//alert("current_field--"+current_field);
            if( trimString(current_field.value)!="")
            {
                isNotNull       =   true;
                break;
            }
        }
//        alert("isNotNull : "+isNotNull);
        if(isNotNull)
        {
            currRowIndex                =   rowIndex + 1;
            arrPKFields                 =   new Array();
            pkIndex                     =   0;

            for( var colIndex=0; colIndex<totalColumns; colIndex++ )
            {
                current_field           =   eval("formObj."+arrFieldName1[colIndex]+rowIndex);
                if( (uniqueFields.indexOf(arrFieldName1[colIndex])==-1) && (trimString(current_field.value)=="") )
                {
                    fields [ notNullIndex ]     =   current_field;
                    names  [ notNullIndex++ ]   =   arrLegends1[colIndex]; // + " #" + currRowIndex; //" %23" + currRowIndex;
                    uniqueFields                +=  current_field.name + " " ;
                }

                if( colIndex < totalPKColumns )
                {
                    pk_field            =   eval("formObj."+arrPKFieldNames1[colIndex]+rowIndex);
                    if( current_field.name == pk_field.name )
                    {
                        arrPKFields[pkIndex++]  =   pk_field;
                    }
                }
            }
            masterCodes [ masterIndex++ ]   =   arrPKFields;
        }
    }

    /**
      * Check for the duplicating primary key columns by calling the returnDuplicates function.
      */

    var arrDuplicate        =   returnDuplicates(masterCodes);
	
    /**
      * The first index of the array will contain duplicating primary keys seperated by a delimiter ", ".
      */
    var duplicateCodes      =   arrDuplicate[0];

    /**
      * The second index of the array will contain duplicating primary key fields as an Array.
      */
    var duplicateField      =   arrDuplicate[1];

    /**
      * The third index of the array will contain duplicating primary key fields description
      * seperated by the delimeter ", " in the case of a input type is a select item.
      */
    var duplicateCodesValue =   arrDuplicate[2];

    if(duplicateCodesValue==null)   duplicateCodesValue = "";

    //alert("duplicateCodesValue : "+duplicateCodesValue);
    var inputType           =   "text";
    var duplicateValue      =   "";

    /**
      * Check for the duplicate primary key fields and if any, display the error message and
      * mark the first duplicating primary key fields using the css class "DUPLICATE".
      */
    if(duplicateCodes!="")
    {
        var duplicateCode       =   "";
        var firstIndex          =   duplicateCodes.indexOf(",");

        if(firstIndex==-1)
        {
            firstIndex          =   duplicateCodes.length;
        }

        var firstDuplicate      =   duplicateCodes.substring(0,firstIndex);
        var startingIndex       =   0;

        for(var i=0; i<duplicateField.length; i++)
        {
            duplicatePKFields   =   duplicateField[i];

            for(var pkIndex=0; pkIndex<duplicatePKFields.length; pkIndex++)
            {
                if( (pkIndex%totalPKColumns) < totalPKColumns )
                {
                    duplicateCode += duplicatePKFields[pkIndex].value + ":";
                }

                if( (pkIndex%totalPKColumns) == (totalPKColumns-1) )
                {
                    duplicateCode   =   duplicateCode.substring(0,duplicateCode.length-1);

                    if(firstDuplicate==duplicateCode)
                    {
                        for(var j=startingIndex; j<=pkIndex; j++)
                        {
                            if( (pkIndex-startingIndex)<=totalPKColumns )
                            {
                                duplicatePKFields[j].className = "DUPLICATE";
                            }
                        }
                        startingIndex   =   pkIndex;
                    }
                    duplicateCode   =   "";
                }
            }
        }

        duplicatePKFields   =   duplicateField[0];

        var error_msg       =   getMessage("SEQ_NO_EXISTS","OR") + " : " ;
	    if( inputType == "text" )
        {
            error_msg       +=  duplicateCodes;
        }
        displayErrorMessage(error_msg,objMessageFrame,'',null,errorPage);
        duplicatePKFields[0].focus();
        return false;
	}
	else
	{ 
		return true;
	}
}

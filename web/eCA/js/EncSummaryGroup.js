/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
18/07/2013     		1   		Sethuraman      Created for Adding encounter Summary Groups/Sub-Groups 
-------------------------------------------------------------------------------------------------------------------------------------
*/
function create()
{	
	f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupAddModify.jsp?mode=insert';
}

function query()
{	
	f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupQueryCriteria.jsp';
}

function apply()
{
	var mode = f_query_add_mod.document.forms[0].mode;
	var image_url = "";
	var image_name = "";


	var fields = new Array (f_query_add_mod.document.forms[0].es_group_type,
							f_query_add_mod.document.forms[0].es_group_code,
							f_query_add_mod.document.forms[0].es_group_desc							
						);

	var names = new Array ( f_query_add_mod.getLabel("Common.GroupType.label",'common'),
							f_query_add_mod.getLabel("Common.code.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common')							
						);
	
	image_url = f_query_add_mod.document.forms[0].es_group_image_url.value;
	var filesplit = image_url.split("\\");
	var length = filesplit.length;	

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{	
		if(mode != null)
		{			
			f_query_add_mod.document.forms[0].es_group_type1.value= f_query_add_mod.document.forms[0].es_group_type.value;
			f_query_add_mod.document.forms[0].es_group_code1.value= f_query_add_mod.document.forms[0].es_group_code.value;
			f_query_add_mod.document.forms[0].es_group_desc1.value= f_query_add_mod.document.forms[0].es_group_desc.value;
			f_query_add_mod.document.forms[0].es_group_remarks1.value= f_query_add_mod.document.forms[0].es_group_remarks.value;
			f_query_add_mod.document.forms[0].es_group_image_url1.value= f_query_add_mod.document.forms[0].es_group_image_url.value;
			f_query_add_mod.document.forms[0].es_group_status1.value= f_query_add_mod.document.forms[0].es_group_status.value;					
			f_query_add_mod.document.forms[0].es_image_name.value = filesplit[length-1];			
		}	
		f_query_add_mod.document.summgroup_form.submit();	
	}
 }


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{			
		f_query_add_mod.location.href='../../eCA/jsp/EncSummGroupAddModify.jsp?mode=update&es_group_flag='+f_query_add_mod.document.forms[0].es_group_flag1.value+'&es_group_type='+f_query_add_mod.document.forms[0].es_group_type.value+'&es_group_code='+f_query_add_mod.document.forms[0].es_group_code.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

	f_query_add_mod.location.reload();

}
function checkForMode(objCheck)
{	
	if(objCheck.checked== true)
	{
		document.forms[0].es_group_status1.value='E';
	}
	else
	{
		document.forms[0].es_group_status1.value='D';
	}	
}

function checkForMinus(obj)
{
	if(obj.value != '')
	{
		if(obj.value.indexOf("-") > -1)
		{
			alert(getMessage("POSITIVE_NUMBER_ALLOWED","CA"));
			obj.select();
			return false;
		}
		if(parseInt(obj.value,10)  == 0)
		{
				alert(getMessage("INVALID_POSITIVE_NUMBER","Common"));
				obj.select();
				return false;
		}
	}	
}


function checkdefaultdesc()
{		
    var text_value  =   document.forms[0].es_group_desc.value;
    while(text_value.indexOf('"')!=-1)
    {
        text_value = text_value.replace('"',"'");
    }
    document.forms[0].es_group_desc.value = text_value;
}

function checkForMaxCharacter(objTextArea)
{
	if(objTextArea.value != '')
	{
		if(objTextArea.value.length > 200)
		{
			return false;
		}
		else
			return true;
	}
}

function CheckForSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_ ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function ChangeUpperCase(Object) 
{
    var objectfield = Object ;
    objectfield.value = objectfield.value.toUpperCase();
}

function CheckForNums(event){
    var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function chkMaxLenForLongTest(textarea_name,maxLen)
{	
	if (maxLen == undefined || maxLen == null || maxLen == "")
	{
		maxLen = 3000;
	}
	
	var textArea	 = eval("document.forms[0]."+textarea_name);
	var val	 = textArea.value;
	var valLength	 = val.length;	
	if (parseInt(valLength)  > maxLen)
	{		
		var msg = getMessage("REMARKS_CANNOT_EXCEED",'COMMON');
		msg = msg.replace("$","Constructed Parameter list");
		msg = msg.replace("#",maxLen);
		alert(msg);
		textArea.focus();
		return false;
	}
	
}

function chopText(elem,limit)
{	
	if(elem.value.length>limit){
	elem.value=elem.value.substring(0,limit);
	var msg = getMessage('ONLY_MAX_CHARS','CA');
	msg=msg.replace('$$','200');
	alert(msg);
	}
}

function mainGroupType(obj){
	
	var groupType = obj.value;
	
	if (groupType == 'UG')
	{
		document.summgroup_form.groupCode_srch.disabled = true;
	}
	else
	{
		document.summgroup_form.groupCode_srch.disabled = false;
	}	
	
}
function showImageWindow(imageObject){
	if(imageObject.name=='es_group_image_url')
	{
		var target  = document.forms[0].es_group_image_url;
		
		if((target.value) == "null" || (target.value ==""))
		{
			document.getElementById("refimage").style.display="none";
			return false;			
		}
		else
		{
			showImage();
		}
	}
	else if(imageObject.name=='image_button')
	{		
		showImage();
	}


}
function showImage(){
	

	var target	= document.forms[0].es_group_image_url;
	if(!(target.value =="" || target.value ==null))
	{
      document.getElementById("refimage").style.display="inline";
	}
	else
	{
		document.getElementById("refimage").style.display="none";
	}
	var search_code="es_group_image_url1";
	var search_desc="es_group_image_url";		
	var sql="select image_ref code, image_ref_desc description from ca_note_image_list where eff_status='E' and upper(image_ref) like upper(?) and upper(image_ref_desc) like upper(?) order by 2";
	var title = getLabel("Common.ImageURL.label","common");
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title,argArray );
	if(retArray != null && retArray !="")	
	{
		document.forms[0].es_group_image_url.value = retArray[1];
		document.forms[0].es_group_image_url1.value = retArray[0];
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforImage' id='tempformforImage' method='post' action='../../eCA/jsp/ImageForSectionIntermediate.jsp'><input type=hidden name='image_ref' id='image_ref' value='"+retArray[0]+"'></form></body></html>";
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempformforImage.submit();
	}
	else
	{
		document.forms[0].es_group_image_url.value="";
		document.forms[0].es_group_image_url1.value="";			
		target.focus();
	}
}

function checkApplicable(obj)
{

	document.summgroup_form.es_group_flag1.value = obj.value;	
}

function getGroupCode(objCode, language)
{		
	var groupType = document.summgroup_form.es_group_type.value;
	if(objCode.name=='es_group_code')
	{
		if (!(groupType == "UG"))
		{
			groupCodeSearch(objCode, language);
		}		
	}
	
	if(objCode.name == "groupCode_srch")
	{		
		if (!(groupType == "UG"))
		{
			if(document.summgroup_form.flag.value=='false')
				return false;
			else			
				callGroupCodeType(language);
		}
	}			
}

function groupCodeSearch(objCode,language)
{
	var groupType = document.summgroup_form.es_group_type.value;
	var groupCode = objCode.value;
	
	if(groupCode == '')
	{
		document.summgroup_form.flag.value='true';
		return false;
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';	
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' " +
				"language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<body  onKeyDown='lockKey()' class=MESSAGE><form name='tempform' id='tempform' method='post' action='EncSummGroupIntermediate.jsp'>" +
				"<input type=hidden name='groupType' id='groupType' value='"+groupType+"'>" +
						"<input type=hidden name='groupCode' id='groupCode' value='"+groupCode+"'></form></body></html>";
		parent.BlankFrame.document.write(HtmlVal);
		parent.BlankFrame.document.tempform.submit();
	}
	setTimeout("reloadFrames()",50);
}

function callGroupCodeType(language)
{
	var dialogTop	= "40";
	var dialogHeight	= "10" ;
	var dialogWidth= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc	= "";
	var sql = "";
	var groupType = document.summgroup_form.es_group_type.value;
	
	/*Changes expected here*/
	
	/*	
	if (groupType == "LBIN")
	{
		sql = "SELECT test_code code, long_desc description FROM rl_test_code where group_test_yn  = 'Y' and upper(test_code) like upper(?) and  upper(long_desc) like upper(?) ORDER BY  long_desc";		
	}
	if (groupType == "RDIN")
	{
		sql = "SELECT exam_code code, long_desc description FROM rd_exams where group_exam_yn  = 'Y' and upper(exam_code) like upper(?) and  upper(long_desc) like upper(?) ORDER BY  long_desc";		
	}
	*/
	
	sql = "select event_code code, short_desc description from cr_event_hist_rec_vw where hist_rec_type = '"+groupType+"' and language_id = '"+language+"' and upper(event_code) like upper(?) and  upper(short_desc) like upper(?) order by  short_desc";
	
	var title = getLabel("Common.GroupSubFlag.label","Common");
	var target = document.summgroup_form.es_group_code;
	target.value = "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();

	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;

	retArray = CommonLookup( title, argArray );

	if(retArray != null && retArray !="")	
	{
			document.summgroup_form.es_group_desc.value = retArray[1];
			document.summgroup_form.es_group_code.value = retArray[0];
	}
	else
	{
			document.summgroup_form.es_group_desc.value = '';
			document.summgroup_form.es_group_code.value = '';
	}

	setTimeout("reloadFrames()",50);
}

function callGroupCodeType1(sql,title,target)
{	
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
	return retArray;
}


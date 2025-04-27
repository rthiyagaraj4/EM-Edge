function create()
{
	templateParsingFrame.location.href='../../eCA/jsp/CASectionTemplateParsing.jsp?selopt=A';	

	}
function reset()
	{
		templateParsingFrame.location.href='../../eCA/jsp/CASectionTemplateParsing.jsp?selopt=A';	

	}
function apply()
	{	
		if(templateParsingFrame.document.TemplateParsingForm != null)
		{
			if(templateParsingFrame.document.TemplateParsingForm.select_mode.value != 'A')
			{
				if(templateParsingFrame.document.TemplateParsingForm.select_mode.value == 'N' && templateParsingFrame.document.TemplateParsingForm.selcode.value == '')
				{
					var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
					msg = msg.replace("$", getLabel("Common.notes.label",'Common'));
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
					return false;	
				}
				else if(templateParsingFrame.document.TemplateParsingForm.select_mode.value == 'S' && templateParsingFrame.document.TemplateParsingForm.selcode.value == '')
				{
					var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
					msg = msg.replace("$", getLabel("Common.Section.label",'Common'));
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
					return false;	
				}
				else if(templateParsingFrame.document.TemplateParsingForm.select_mode.value == 'P' && templateParsingFrame.document.TemplateParsingForm.select_code.value == '')
				{
					var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
					msg = msg.replace("$", getLabel("Common.speciality.label",'Common'));
					messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
					return false;	
				}
				else
				{
					templateParsingFrame.document.TemplateParsingForm.method ='post'
					templateParsingFrame.document.TemplateParsingForm.action = '../../servlet/eCA.CASectionParsingTemplateServlet';
					//f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					//f_query_add_mod.document.forms[0].target="messageFrame";
					templateParsingFrame.document.TemplateParsingForm.submit();
				}
			}
			else
			{
				templateParsingFrame.document.TemplateParsingForm.method ='post'
				templateParsingFrame.document.TemplateParsingForm.action ='../../servlet/eCA.CASectionParsingTemplateServlet'
				templateParsingFrame.document.TemplateParsingForm.submit();
			}
		}
		else
		{ 
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'; 
			return false; 
		}
	}
function Change_mode(obj)
	{
	if(obj.value == "N")
		parent.templateParsingFrame.document.TemplateParsingForm.select_mode.value='N';
	else if(obj.value == "S")
		parent.templateParsingFrame.document.TemplateParsingForm.select_mode.value='S';
	else if(obj.value == "P")
		parent.templateParsingFrame.document.TemplateParsingForm.select_mode.value='P';
	else
		{
		parent.templateParsingFrame.document.TemplateParsingForm.select_mode.value='A';
       	}

	
	parent.templateParsingFrame.location.href='../../eCA/jsp/CASectionTemplateParsing.jsp?mode=Update&selopt='+document.TemplateParsingForm.select_mode.value;

	}

function callOnOk()
{
	parent.templateParsingToolbarFrame.document.TemplateParsingToolbarForm.submit();
	parent.window.close();
}
	
function setSelCode(obj)
{
  parent.templateParsingFrame.document.TemplateParsingForm.select_code.value=obj.value;
}
function setFromCode(obj)
{
  parent.templateParsingFrame.document.TemplateParsingForm.from_section.value=obj.value;
  
}
function setToCode(obj)
{
  parent.templateParsingFrame.document.TemplateParsingForm.to_section.value=obj.value;
  
}
function onSuccess()
{
	//templateParsingFrame.templateParsingMainFrame.rows = "10,*,10";
	//templateParsingFrame.location.href='../../eCA/jsp/CASectionTemplateParsing.jsp?selopt=A';	
	//templateParsingFrame.location.href='../../eCommon/html/blank.html';	
	//templateParsingFrame.location.reload();
//	messageFrame.location.reload();
}

//for 's'
function getSections(selcode,sectionObject,obj)
{
	if(obj.name=='selcodedesc')
	{
		var target  = document.TemplateParsingForm.selcodedesc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			getSection(selcode,sectionObject);
		}
	}
	else if(obj.name=='selcode_desc_search')
	{
			getSection(selcode,sectionObject);
			//getSection(selcode,selcodedesc
	}
}

//for 's'
async function getSection(sectionSearchCode, sectionSearchDesc)
{
		sectionSearchCode.disabled = true ;
		var target =  document.TemplateParsingForm.selcodedesc;
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
	
		var title			= getLabel('Common.Section.label','COMMON');

		var sql = "SELECT SEC_HDG_CODE code, SEC_HDG_DESC description FROM CA_SECTION_HDG where CONTENT_TYPE ='T' and TEMPLATE_FORMAT is not null and upper( SEC_HDG_CODE) like upper(?) and  upper( SEC_HDG_DESC) like upper(?)";

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
		retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
		var ret1=unescape(retArray);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		} 
		
		if(retArray != null && retArray !="")	
		{
			document.TemplateParsingForm.selcodedesc.value = arr[1];
			document.TemplateParsingForm.selcode.value = arr[0];
		}
		else
		{
			document.TemplateParsingForm.selcodedesc.value = '';
			document.TemplateParsingForm.selcode.value = '';
			//target.focus();
		}
}


//for 'a'-fromsection
async function getFromSection(selcode,sectionObject,obj)
{
	if(obj.name=='fromsectiondesc')
	{
		var target  = document.TemplateParsingForm.fromsectiondesc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await getFromSect(selcode,sectionObject);
		}
	}
	else if(obj.name=='fromsection_desc_search')
	{
			await getFromSect(selcode,sectionObject);
		//getFromSect(fromsection,fromsectiondesc
	}
}
/*function getSectionas(fromsection, fromsectiondesc)
{
		fromsection.disabled = true ;
		var target =  document.TemplateParsingForm.fromsectiondesc;
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
	
		var title			= getLabel('Common.Section.label','COMMON');

		var sql = "SELECT SEC_HDG_CODE code, SEC_HDG_DESC description FROM CA_SECTION_HDG where CONTENT_TYPE ='T' and TEMPLATE_FORMAT is not null and upper( SEC_HDG_CODE) like upper(?) and  upper( SEC_HDG_DESC) like upper(?)";

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
		
		if(retArray != null && retArray !="")	
		{
			document.forms[0].fromsectiondesc.value = retArray[1];
			document.forms[0].fromsection.value = retArray[0];
		}
		else
		{
			document.forms[0].fromsectiondesc.value = '';
			document.forms[0].fromsection.value = '';
			//target.focus();
		}
}*/

//for 'a'-fromsection
async function getFromSect(sectionSearchCode, sectionSearchDesc)
{
		sectionSearchCode.disabled = true ;
		var target =  document.TemplateParsingForm.fromsectiondesc;
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
	
		var title			= getLabel('Common.Section.label','COMMON');

		var sql = "SELECT SEC_HDG_CODE code, SEC_HDG_DESC description FROM CA_SECTION_HDG where CONTENT_TYPE ='T' and TEMPLATE_FORMAT is not null and upper( SEC_HDG_CODE) like upper(?) and  upper( SEC_HDG_DESC) like upper(?)";

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
		retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.TemplateParsingForm.fromsectiondesc.value = arr[1];
			document.TemplateParsingForm.fromsection.value = arr[0];
		}
		else
		{
			document.TemplateParsingForm.fromsectiondesc.value = arr[1];
			document.TemplateParsingForm.fromsection.value = arr[0];
			//target.focus();
		}
}


function CheckForSpecialChar(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


//for 'a'-tosection
async function getToSection(tosection, tosectiondesc,obj)
{
if(obj.name=='tosectiondesc')
	{
		var target  = document.TemplateParsingForm.tosectiondesc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			await getToSect(tosection,tosectiondesc);
		}
	}
	else if(obj.name=='tosection_desc_search')
	{
			await getToSect(tosection,tosectiondesc);
	}
}

//for 'a'-tosection
async function getToSect(tosection, tosectiondesc)
{
		tosection.disabled = true ;
		var target =  document.TemplateParsingForm.tosectiondesc;
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
	
		var title			= getLabel('Common.Section.label','COMMON');

		var sql = "SELECT SEC_HDG_CODE code, SEC_HDG_DESC description FROM CA_SECTION_HDG where CONTENT_TYPE ='T' and TEMPLATE_FORMAT is not null and upper( SEC_HDG_CODE) like upper(?) and  upper( SEC_HDG_DESC) like upper(?)";

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
		retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
		if(retArray != null && retArray !="")	
		{
			document.TemplateParsingForm.tosectiondesc.value = arr[1];
			document.TemplateParsingForm.tosection.value = arr[0];
		}
		else
		{
			document.TemplateParsingForm.tosectiondesc.value = arr[1];
			document.TemplateParsingForm.tosection.value = arr[0];
			//target.focus();
		}
}

function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	
}
//for 'N'
function getNote(noteObject)
{
	if(noteObject.name=='selcodedesc')
	{
		var target  = document.TemplateParsingForm.selcodedesc;
		
		if((target.value) == "null" || (target.value ==""))
		{
			return false;			
		}
		else
		{
			getNotes();
		}
	}
	else if(noteObject.name=='selcode_desc_search')
	{
		getNotes();
	}
}

//for 'N'
async function getNotes()
{
		TemplateParsingForm.selcode.disabled = true ;
		var target = document.TemplateParsingForm.selcodedesc;
		var i = 0;
		var retVal			=  new String();
		
		var search_desc	= "";
		var title			= getLabel('Common.notes.label','COMMON');

		var sql = "SELECT DISTINCT A.NOTE_TYPE code,A.NOTE_TYPE_DESC description FROM CA_NOTE_TYPE A,CA_NOTE_SECTION B,CA_SECTION_HDG C  WHERE A.NOTE_TYPE = B.NOTE_TYPE AND B.SEC_HDG_CODE = C.SEC_HDG_CODE AND C.CONTENT_TYPE ='T' and C.TEMPLATE_FORMAT IS NOT NULL and upper( A.NOTE_TYPE) like upper(?) and  upper( A.NOTE_TYPE_DESC) like upper(?)";
		
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
		retArray = await CommonLookup( encodeURIComponent(title,"UTF-8"), argArray );
		var ret1=unescape(retArray);
	 	arr=ret1.split(",");
	 	if(arr[1]==undefined) 
 		{
	 		arr[0]="";	
	 		arr[1]="";	
 		} 
		
		if(retArray != null && retArray !="")	
		{
			document.forms[0].selcodedesc.value = arr[1];
			document.forms[0].selcode.value = arr[0];
		}
		else
		{
			document.forms[0].selcodedesc.value = '';
			document.forms[0].selcode.value = '';			

		}
}

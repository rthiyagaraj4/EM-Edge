/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
14/08/2012		IN034340		Dinesh T		For retaining the copy paste content format from MS Document	
19/08/2014	  	IN050582 		Nijitha S		MO-GN-5452	
---------------------------------------------------------------------------------------------------------------
*/
function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/AddModifyTextBlock.jsp';
}
function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/QueryCriteriaTextBlock.jsp';
}
function checkRecord(obj)
{
	if(obj.value=="" || obj.value=="null")
	{
		document.forms[0].flagService.value='true'
		document.forms[0].service.value="";
	}
	
	var chkprevservice = document.forms[0].chkprevservice.value.toUpperCase();

	if(obj.value!="" && chkprevservice!=obj.value.toUpperCase())
	{
				document.forms[0].chkprevservice.value = obj.value;
				HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='TextBlockSearch.jsp'><input type=hidden name='serviceid' id='serviceid' value='"+obj.value+"'> </form></body></html>"
				top.content.master_pages.messageFrame.document.write(HTMLVal);
				top.content.master_pages.messageFrame.document.tempForm.submit();
	}
}

function checkPrac(obj)
{
	if(obj.value=="" || obj.value=="null")
	{
		document.forms[0].practitioner.value="";
		document.forms[0].flagPractitioner.value='true'
	}

	var chkprevpract = document.forms[0].chkprevpract.value.toUpperCase();

	if(obj.value!="" && chkprevpract!=obj.value.toUpperCase())
	{
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown='lockKey()' class=MESSAGE><form name='tempForm' id='tempForm' method='post' action='PractictionerSearch.jsp'><input type=hidden name='pracid' id='pracid' value='"+obj.value+"'> </form></body></html>"
	
		top.content.master_pages.messageFrame.document.write(HTMLVal);
		top.content.master_pages.messageFrame.document.tempForm.submit();
	}
}

function checkMaxLimit1(obj,maxSize)	
{
	var len  = obj.value;
	var errorMessage = "";

	if ( len.length >= maxSize )
	{	
		errorMessage = getMessage("ONLY_MAX_CHARS",'CA');
		errorMessage = errorMessage.replace('$$',maxSize);
		alert(errorMessage);
		event.returnValue = false;
		obj.focus();
	}	
}	

function chklim(obj,maxSize)	
{
	var errorMessage = "";
	var len  = obj.value;

	if ( obj.value.length >= maxSize )
	{
		errorMessage = getMessage("ONLY_MAX_CHARS",'CA');
		errorMessage = errorMessage.replace('$$',maxSize);
		alert(errorMessage);
		obj.focus();
	 }
}

async function getServiceCode()
{
		var target			= document.forms[0].service_desc;
		var title			=getLabel("Common.service.label",'common');

		var sql="SELECT service_code code, short_desc description FROM am_service where eff_status='E' and upper(service_code) like upper(?) and  upper(short_desc) like upper(?) order by 2";

		search_code="service_code";
		search_desc="short_desc";
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
	   retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	  if(retArray != null && retArray != '' && retArray != "null")
	   {
		 document.forms[0].service_desc.value = arr[1];
		 document.forms[0].service.value = arr[0];
	   }
	    else
		{
			document.forms[0].service_desc.value=arr[1];
			document.forms[0].service.value=arr[0];
		}

}
	

async function getNoteType()
{
		var search_desc="";
		var target			= document.forms[0].Note_Type_Desc;
		var title			= getLabel("Common.NoteType.label",'common');

		var sql="SELECT note_type code, note_type_desc description FROM ca_note_type where eff_status='E' and upper(note_type) like upper(?) and  upper(note_type_desc) like upper(?) order by 2"; 

		search_code="note_type";
	    search_desc="note_type_desc";

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
	   retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retArray != null && retArray != '' && retArray != "null")
	   {
		 document.forms[0].Note_Type_Desc.value = arr[1];
		 document.forms[0].notetype.value = arr[0];
	   }
	    else
		{
			document.forms[0].Note_Type_Desc.value= arr[1];
			document.forms[0].notetype.value= arr[0];
		}		
		enableonDisableSection(document.forms[0].Note_Type_Desc);
}
	

function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}	

async function getSection()
{ 
		var notetype=document.forms[0].notetype.value;
		var target			= document.forms[0].Note_Type_Desc;
		var search_desc="";
		var target			= document.forms[0].Section_desc;
		var title			= getLabel("Common.Section.label",'common');
        if( notetype=="")
	    {
		var sql="SELECT sec_hdg_code code, sec_hdg_desc description FROM ca_section_hdg where eff_status='E' AND content_type in('F','R') and sec_hdg_code like upper(?) and  upper(sec_hdg_desc) like upper(?) order by 2 ";
	    }
	    else
	    {
		var sql="SELECT ia.sec_hdg_code code, ia.sec_hdg_desc  description FROM ca_section_hdg ia, ca_note_section ib where ia.eff_status='E' AND ia.content_type in('F','R') AND  ib.NOTE_TYPE='"+notetype+"'  AND ia.sec_hdg_code=ib.SEC_HDG_CODE and ia.sec_hdg_code like upper(?) and  upper(ia.sec_hdg_desc) like upper(?) order by 2"; 
	    } 

		search_code="sec_hdg_code";
	    search_desc="sec_hdg_desc";

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
	   retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retArray != null && retArray != '' && retArray != "null")
	   {
		 document.forms[0].Section_desc.value = arr[1];
		 document.forms[0].section.value = arr[0];
	   }
	    else
		{
			document.forms[0].Section_desc.value=arr[1];
			document.forms[0].section.value=arr[0];
		}
}
	
function enableDisableResetSection(chkprev,chkafter)
{		
		if(f_query_add_mod.document.forms[0].mode.value=="insert")
		{
			if(chkprev==true )
			{
				f_query_add_mod.document.forms[0].Note_Type_Desc.disabled=false;
				f_query_add_mod.document.forms[0].notetype_desc_search.disabled=false;
			}	
			//alert(f_query_add_mod.document.forms[0].Note_Type_Desc.disabled);
			//if(f_query_add_mod.document.forms[0].Note_Type_Desc.disabled==false)
			//{
				if((f_query_add_mod.document.forms[0].Note_Type_Desc.value) == "null" || (f_query_add_mod.document.forms[0].Note_Type_Desc.value ==""))
				{			
					f_query_add_mod.document.forms[0].Section_desc.value='';
					f_query_add_mod.document.forms[0].section.value=''			
					f_query_add_mod.document.forms[0].Section_desc.disabled=true;
					f_query_add_mod.document.forms[0].section_desc_search.disabled=true;
				}
				else
				{			
					f_query_add_mod.document.forms[0].Section_desc.disabled=false;
					f_query_add_mod.document.forms[0].section_desc_search.disabled=false;
				}
			//}
		}
		else if(f_query_add_mod.document.forms[0].mode.value=="modify")
		{	
			if(chkprev==true && chkafter==true)
			{
				f_query_add_mod.document.forms[0].Note_Type_Desc.disabled=true;
				f_query_add_mod.document.forms[0].notetype_desc_search.disabled=true;
			}
			else if(chkprev==false && chkafter==true)
			{
				f_query_add_mod.document.forms[0].Note_Type_Desc.disabled=true;
				f_query_add_mod.document.forms[0].notetype_desc_search.disabled=true;
			}
			else if(chkprev==true && chkafter==false)
			{
				f_query_add_mod.document.forms[0].Note_Type_Desc.disabled=false;
				f_query_add_mod.document.forms[0].notetype_desc_search.disabled=false;
			}
			
			if((f_query_add_mod.document.forms[0].Note_Type_Desc.value) == "null" || (f_query_add_mod.document.forms[0].Note_Type_Desc.value ==""))
			{			
				f_query_add_mod.document.forms[0].Section_desc.value='';
				f_query_add_mod.document.forms[0].section.value=''			
				f_query_add_mod.document.forms[0].Section_desc.disabled=true;
				f_query_add_mod.document.forms[0].section_desc_search.disabled=true;
			}
			else
			{			
				f_query_add_mod.document.forms[0].Section_desc.disabled=false;
				f_query_add_mod.document.forms[0].section_desc_search.disabled=false;
			}
		}
		

}

function enableDisableInterSection(obj)
{
	if((obj.value) == "null" || (obj.value ==""))
		{			
			parent.f_query_add_mod.document.forms[0].Section_desc.value='';
			parent.f_query_add_mod.document.forms[0].section.value=''			
			parent.f_query_add_mod.document.forms[0].Section_desc.disabled=true;
			parent.f_query_add_mod.document.forms[0].section_desc_search.disabled=true;
		}
		else
		{			
			parent.f_query_add_mod.document.forms[0].Section_desc.disabled=false;
			parent.f_query_add_mod.document.forms[0].section_desc_search.disabled=false;
		}

}
function enableDisableSection(obj)
{
	if((obj.value) == "null" || (obj.value ==""))
		{			
			document.forms[0].Section_desc.value='';
			document.forms[0].section.value=''			
			document.forms[0].Section_desc.disabled=true;
			document.forms[0].section_desc_search.disabled=true;
		}
		else
		{			
			document.forms[0].Section_desc.disabled=false;
			document.forms[0].section_desc_search.disabled=false;
		}

}
function enableonDisableSection(obj)
{		
			document.forms[0].Section_desc.value='';
			document.forms[0].section.value=''	
			if((obj.value) == "null" || (obj.value ==""))
			{		
				document.forms[0].Section_desc.disabled=true;
				document.forms[0].section_desc_search.disabled=true;
			}
			else
			{			
				document.forms[0].Section_desc.disabled=false;
				document.forms[0].section_desc_search.disabled=false;
			}	
}


async function checkBlurClickPractitioner(objCode)
{
	if(objCode.name=='practitioner_desc')
	{		
		if(objCode.value==''||objCode.value==null)
			return false;
		else
		{	
			await getPractitionerId();			
			/*var descriptionval=objCode.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type=hidden name='selFunVal' id='selFunVal' value='Practitioner'></form></body></html>";
			parent.blankFrame.document.write(HTMLVal);				
			if(parent.blankFrame.document.tempform1)
				parent.blankFrame.document.tempform1.submit();*/
		}
	}

	else if(objCode.name == "practitioner_desc_search")
	{
		await getPractitionerId();
	}
}

function practitioner(objCode)
{
	
	var practitionercode = objCode.value;

	if(practitionercode == '')
	{
		document.forms[0].flagPractitioner.value='true';
		return false
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='practitionercode' id='practitionercode' value='"+practitionercode+"'><input type=hidden name='selFunVal' id='selFunVal' value='Practitioner'></form></body></html>";

        parent.blankFrame.document.write(HTMLVal);
	    parent.blankFrame.document.tempform1.submit(); 
		
    }
}

async function checkBlurClickService(objCode)
{	
	if(objCode.name=='service_desc')
	{
		if(objCode.value==""||objCode.value==null)
			return false;
		else
		{
			//getServiceCode();	
			var descriptionval=objCode.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type=hidden name='selFunVal' id='selFunVal' value='Service'></form></body></html>";
			parent.blankFrame.document.write(HTMLVal);				
			if(parent.blankFrame.document.tempform1)
				parent.blankFrame.document.tempform1.submit(); 
			
		}
	}
	else if(objCode.name == "service_desc_search")
	{
			await getServiceCode();
    }
}

function service(objCode)
{
	var servicecode = objCode.value;

	if(servicecode == '')
	{
		document.forms[0].flagService.value='true';
		return false
	}
	else
	{		
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='servicecode' id='servicecode' value='"+servicecode+"'><input type=hidden name='selFunVal' id='selFunVal' value='Service'></form></body></html>";

        parent.blankFrame.document.write(HTMLVal);
	    parent.blankFrame.document.tempform1.submit(); 

    }
}
//<!  Updated By Arvind @ 26-12-06---------------------------------------------------------------------->>
async function  checkBlurClickNoteType(objCode)
{
	if(objCode.name=='Note_Type_Desc')
	{
		if(objCode.value==''||objCode.value==null)
		{
			document.forms[0].notetype.value='';
			document.forms[0].flagNoteType.value='true';
			document.forms[0].Section_desc.value='';
			document.forms[0].section.value=''			
			document.forms[0].Section_desc.disabled=true;
			document.forms[0].section_desc_search.disabled=true;
			return false;
		}
		else
		{
			await getNoteType();
			/*var descriptionval=objCode.value;
			parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
	        var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='description' id='description' value='"+descriptionval+"'><input type=hidden name='selFunVal' id='selFunVal' value='NoteType'></form></body></html>";
			parent.blankFrame.document.write(HTMLVal);				
			if(parent.blankFrame.document.tempform1)
				parent.blankFrame.document.tempform1.submit();*/
		}
	}
	else if(objCode.name == "notetype_desc_search")
	{
		await getNoteType();
    }
}

function notetype(objCode)
{
	var notetypecode = objCode.value;	

	if(notetypecode == '')
	{
		document.forms[0].notetype.value='';
		document.forms[0].flagNoteType.value='true';
		document.forms[0].Section_desc.value='';
		document.forms[0].section.value=''			
		document.forms[0].Section_desc.disabled=true;
		document.forms[0].section_desc_search.disabled=true;
		return false
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='notetypecode' id='notetypecode' value='"+notetypecode+"'><input type=hidden name='selFunVal' id='selFunVal' value='NoteType'></form></body></html>";

        parent.blankFrame.document.write(HTMLVal);
	    parent.blankFrame.document.tempform1.submit(); 

    }
	
}
//Added  by Arvind @ 26-12-06
async function checkBlurClickSection(objCode)
{
	if(objCode.name=='Section_desc')
	{
		if(objCode.value==''||objCode.value==null)
			return false;
		else
			await getSection();
	}
		
	if(objCode.name == "section_desc_search")
	{
		await getSection();
	}
}

function section(objCode)
{
	var sectioncode = objCode.value;
	var notetype=document.forms[0].notetype.value;

	if(sectioncode == '')
	{
		document.forms[0].flagSection.value='true';
		return false
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/TextBlockIntermediate.jsp'><input type='hidden' name='sectioncode' id='sectioncode' value='"+sectioncode+"'><input type='hidden' name='notetype' id='notetype' value="+notetype+"><input type=hidden name='selFunVal' id='selFunVal' value='Section'></form></body></html>";

        parent.blankFrame.document.write(HTMLVal);
	    parent.blankFrame.document.tempform1.submit(); 

    }
}


async function getPractitionerId()
{
		var search_desc="";
		var target			= document.forms[0].practitioner_desc;
		var title= getLabel("Common.practitioner.label",'common');
		var sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and upper(practitioner_id) like upper(?) and  upper(practitioner_name) like upper(?) order by 2"; 

		search_code="practitioner_id";
		search_desc="practitioner_name";

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
	   retArray = await CommonLookup( title, argArray );
		var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if (retArray != null && retArray != '' && retArray != "null")
	   {
		 document.forms[0].practitioner_desc.value = arr[1];
		 document.forms[0].practitioner.value = arr[0];
	   }
	    else
		{
			document.forms[0].practitioner_desc.value=arr[1];
			document.forms[0].practitioner.value=arr[0];
		}
}
	
function enableDisable(obj)
{
	if(obj.checked)
	{
		document.forms[0].Section_desc.value='';
		document.forms[0].section.value=''
		document.forms[0].Note_Type_Desc.value='';
		document.forms[0].notetype.value='';
		document.forms[0].Section_desc.disabled=true;
		document.forms[0].Note_Type_Desc.disabled=true;
		document.forms[0].notetype_desc_search.disabled=true;
		document.forms[0].section_desc_search.disabled=true;

	}
	else
	{
		
		document.forms[0].Note_Type_Desc.disabled=false;
		document.forms[0].notetype_desc_search.disabled=false;		
		if((document.forms[0].Note_Type_Desc.value)== "null" || (document.forms[0].Note_Type_Desc.value ==""))
		{
			document.forms[0].Section_desc.disabled=true;
			document.forms[0].section_desc_search.disabled=true;
		}else{
			document.forms[0].Section_desc.disabled=false;
			document.forms[0].section_desc_search.disabled=false;
		}
	}
}

function apply()
{	
	if(f_query_add_mod.document.Textblock_form.service_desc.value==null || f_query_add_mod.document.Textblock_form.service_desc.value=="")
		f_query_add_mod.document.Textblock_form.service.value=f_query_add_mod.document.Textblock_form.service_desc.value;
	if(f_query_add_mod.document.Textblock_form.practitioner_desc.value==null || f_query_add_mod.document.Textblock_form.practitioner_desc.value=="")
		f_query_add_mod.document.Textblock_form.practitioner.value=f_query_add_mod.document.Textblock_form.practitioner_desc.value;
	if(f_query_add_mod.document.Textblock_form.Note_Type_Desc.value==null || f_query_add_mod.document.Textblock_form.Note_Type_Desc.value=="")
		f_query_add_mod.document.Textblock_form.notetype.value=f_query_add_mod.document.Textblock_form.Note_Type_Desc.value;
	if(f_query_add_mod.document.Textblock_form.Section_desc.value==null || f_query_add_mod.document.Textblock_form.Section_desc.value=="")
		f_query_add_mod.document.Textblock_form.section.value=f_query_add_mod.document.Textblock_form.Section_desc.value;
	if(f_query_add_mod.document.Textblock_form != null)
		{			
			if(f_query_add_mod.document.Textblock_form.text_type_id.value=="T"){
				var fields = new Array ( f_query_add_mod.document.Textblock_form.text_blk_id,
						 f_query_add_mod.document.Textblock_form.text_block
						   );
				var names = new Array (	f_query_add_mod.getLabel("Common.identification.label",'common'),
						f_query_add_mod.getLabel("Common.TextBlock.label",'COMMON'));
			
			}else if (f_query_add_mod.document.Textblock_form.text_type_id.value=="E"){
				var fields = new Array ( f_query_add_mod.document.Textblock_form.text_blk_id,
						 f_query_add_mod.document.Textblock_form.textBlockEditorContent
						   );
				var names = new Array (	f_query_add_mod.getLabel("Common.identification.label",'common'),
						f_query_add_mod.getLabel("Common.TextBlock.label",'COMMON'));				
			
			}
			/* [IN033180]
				var fields = new Array ( f_query_add_mod.document.Textblock_form.text_blk_id,
						 f_query_add_mod.document.Textblock_form.text_block
						   );
			var names = new Array (	f_query_add_mod.getLabel("Common.identification.label",'common'),
						f_query_add_mod.getLabel("Common.TextBlock.label",'COMMON'));
			*/
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
			{			
				var fields1 = new Array (f_query_add_mod.document.Textblock_form.text_blk_id );
				var names1  = new Array (f_query_add_mod.getLabel("eCA.TextBlockID.label",'CA'));

				if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
				{
					//[IN033180]
					if(f_query_add_mod.document.Textblock_form.text_type_id.value=="T"){						
						f_query_add_mod.document.Textblock_form.textBlockEditorContent.value="";
					}else if (f_query_add_mod.document.Textblock_form.text_type_id.value=="E"){								
						f_query_add_mod.document.Textblock_form.text_block.value="";
						f_query_add_mod.document.Textblock_form.procedure_yn.value="N";
					}
					f_query_add_mod.document.Textblock_form.submit();
				}	
			}
			
		}
	else
		{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
		}
}


function onSuccess()
{	
	
	//if(f_query_add_mod.document.forms[0].mode.value=="insert")
	//	f_query_add_mod.location.href='../../eCA/jsp/AddModifyTextBlock.jsp';

	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyTextBlock.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="modify")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/AddModifyTextBlock.jsp?mode=modify&text_blk_id='+f_query_add_mod.document.forms[0].text_blk_id.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';
}

function reset()
{
	if(f_query_add_mod.document.forms[0] != null)
	{		 
		var chkprev=f_query_add_mod.document.forms[0].procedure_yn.checked;
		//alert(f_query_add_mod.document.forms[0].mode.value)
		//alert(chkprev);
		f_query_add_mod.document.forms[0].reset();
		var chkafter=f_query_add_mod.document.forms[0].procedure_yn.checked;
		//alert(chkafter);
		enableDisableResetSection(chkprev,chkafter);
		
	}
}

//Function for TextBlockSearch.jsp-end


//Function for PractictionerSearch.jsp-start

function callfunctionforpract()
{
		var target			=parent.frames[1].document.forms[0].practitioner_desc;
		var serviceVal   = parent.frames[1].document.forms[0].practitioner_desc.value;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight	= "10" ;
		var dialogWidth= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title			= getLabel("Common.practitioner.label",'common');
		var sql="SELECT practitioner_id code, practitioner_name description FROM am_practitioner where eff_status='E' and  upper(practitioner_name) like upper(?) and practitioner_id like upper(?) "
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();

		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retArray = CommonLookup( title, argArray );
		if(retArray != null && retArray !="")	{
			parent.frames[1].document.forms[0].practitioner_desc.value = retArray[1];
			parent.frames[1].document.forms[0].practitioner.value = retArray[0];

			parent.frames[1].document.forms[0].chkprevpract.value = retArray[1];
		}else{
			parent.frames[1].document.forms[0].practitioner_desc.value = "";
			parent.frames[1].document.forms[0].practitioner.value = "";
		}
	parent.frames[1].document.forms[0].practitioner_desc_search.disabled=false;
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
}


//Function for PractictionerSearch.jsp-end


function CheckForSpecialCharacter(ObjText)
{
	var key = window.event.keyCode
		if(((key >=33)&&(key <=47))||((key >=58)&&(key <=64))||(key == 32)||((key >=91)&&(key <=96))||((key >=123)&&(key <=126))||((key >=145)&&(key <=146)))
			return false
		return true
}

function CheckForSpecCharsWithSpaceBlur(ObjText)
{
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*& ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function resetValues()
{
   parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
   enableDisableSection(document.forms[0].Note_Type_Desc);
}
function setValue()
{
	document.forms[0].flagService.value='false';
}

function setValue1()
{
	document.forms[0].flagPractitioner.value='false';
}
function setValue2()
{
	document.forms[0].flagNoteType.value='false';
}
function setValue3()
{
	document.forms[0].flagSection.value='false';
}
function callFunction(sql,title,target)
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

	retArray = CommonLookup(title, argArray );
	return retArray;
 }
 //[IN033180] Start.
 function chageTextBlock(){
	var tempTT=document.forms[0].text_type_id.value;
	if(tempTT=="T"){
		document.getElementById("TB").style.display = '';
		document.getElementById("AP").style.display = '';
		document.getElementById("TE").style.display = 'none';
	}else if(tempTT=="E"){
		document.getElementById("TB").style.display = 'none';
		document.getElementById("AP").style.display = 'none';
		document.getElementById("TE").style.display = '';
	}

}
async function openEditorWindow(){
	var dialogHeight	= '400px' ;//'32' ;
	var dialogWidth		= '690px' ; //'50' ;
	var dialogTop		= '30px';
	var dialogLeft		= '30px' ;
	var title			= '';
	var argument		= '';
	var features		= 'dialogheight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+';dialogTitle:'+title+'; scroll=yes; status=no';
	
	var retValues			= await window.showModalDialog("../../eCA/jsp/TextBlockEditorFrameSet.jsp?call_from=Text_Block",arguments,features);	
	
	if(retValues!=null){
		//retValues=retValues.replace(/\"/g,"'");//IN034340
		var xmlDoc 		= "";
		var xmlHttp 	= new XMLHttpRequest();	
		editorContent = checkSpl(retValues);//IN034340
		xmlStr ="<root><SEARCH " ;
		xmlStr += " out_data=\""+editorContent+ "\" ";//IN034340
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST", "TextBlockEditorController.jsp" , false ) ;
		xmlHttp.send( xmlDoc ) ;
		responseText=xmlHttp.responseText;
		document.Textblock_form.textBlockEditorContent.value=trimString(responseText);
	}
}
function checkSpl( val ) 
{
	var result = "" ;
	var ch = "" ;

	/*re = /\n/g;
	val = val.replace(re,"\""); */
	
	var re = new RegExp("&","g");
	//re = /&/g;
	val = val.replace(re, "&amp;");

	re.compile("\"","g");
	val = val.replace(re,"#DQ#");//IN034340
	
	re.compile("<", "g");
	//re = /</g;
	val = val.replace(re, "&lt;");
	
	re.compile(">", "g");
	//re = />/g;
	val = val.replace(re, "&gt;");
	/*re = /\"/g;
	val = val.replace(re, "&quot;");*/
	re.compile("'", "g");
	//re = /\'/g;
	val = val.replace(re, "&apos;");	
   return val;	
}
//[IN033180] End.
//IN050582 Starts
function enabledstatus_disp(obj)
{
	if(obj.checked)
	{
		document.forms[0].eff_status.value='E';
		document.forms[0].eff_status_disp.checked=true;
	}
	else
	{
		document.forms[0].eff_status.value='D';
		document.forms[0].eff_status_disp.checked=false;
	}
}
//IN050582 Ends


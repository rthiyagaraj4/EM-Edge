function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/PrintHeaderImageListAddModify.jsp?mode=insert';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/PrintHeaderImageListQurery.jsp';
}


function apply()
{
	var fields = new Array (
							f_query_add_mod.document.forms[0].note_type,
							f_query_add_mod.document.forms[0].note_type_desc,
							f_query_add_mod.document.forms[0].file_type
							);

	var names = new Array (
							 f_query_add_mod.getLabel("Common.identification.label",'COMMON'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							 f_query_add_mod.getLabel("Common.FileName.label",'common')
							);
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{			
		
		var mode				=	f_query_add_mod.document.forms[0].mode.value;
					
		var fields1 = new Array (f_query_add_mod.document.forms[0].note_type);
		var names1 = new Array (f_query_add_mod.getLabel("Common.identification.label",'COMMON'));
				
		if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
		{
			f_query_add_mod.document.forms[0].submit();		
		}
	}

}

// Added on 12/11/2002 -- To delete an record	
function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
				{
					f_query_add_mod.document.NoteType_form.mode.value='delete';
					f_query_add_mod.document.NoteType_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
} 	


function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
	f_query_add_mod.location.href='../../eCA/jsp/PrintHeaderImageListAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	       f_query_add_mod.location.reload();
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}


function reset()
{
	/*

		if(f_query_add_mod.document.forms[0]!=null){
	if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"|| f_query_add_mod.document.forms[0].mode.value=="update")
			
				f_query_add_mod.location.href='../../eCA/jsp/NoteTypeAddModify.jsp';
	}
	else
		f_query_add_mod.location.href='../../eCA/jsp/NoteTypeQueryCriteria.jsp';
}
*/
if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.document.forms[0].doc_link_note.disabled=true; 
}

		

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}



function setFocusOnFirst()
	{
	  if(document.forms[0].mode.value == "insert")
		 document.forms[0].note_type.focus();

	}
function Change_status(obj)
{
	if(obj.checked== true)
		{
			document.forms[0].enabled1.value='E'
		}
		else
		{
			document.forms[0].enabled1.value='D'
		}
}

/*function getDisclaimerCode()
{
	var target			= document.forms[0].disclaimer_desc;
	var retVal			=  new String();
	var dialogTop	= "40";
	var dialogHeight		= "10" ;
	var dialogWidth	= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var search_desc			= "";
	var title			= "Disclaimer";
	var sql="SELECT DISCLIMER_CODE, DISCLIMER_DESC FROM CA_DISCLIMER_TEXT ";

	var disclaimer_code="DISCLIMER_CODE";
	var disclaimer_desc="DISCLIMER_DESC";
	retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&disclaimer_code="+disclaimer_code+"&disclaimer_desc="+disclaimer_desc+"&title="+title+"&dispDescFirst=dispDescFirst",arguments,features);
	alert(retVal);
	var arr=new Array();
	if (retVal != null && retVal != '' && retVal != "null")
	{

		var retVal=unescape(retVal);

		arr=retVal.split("::");
		document.forms[0].disclaimer_desc.value=arr[0];
		document.forms[0].disclaimer_code.value=arr[1];
		document.forms[0].disclaimer_desc_desc.focus();
	}
	else
	{
		document.forms[0].disclaimer_desc.value="";
		document.forms[0].disclaimer_code.value="";
		target.focus();
	}
}*/

/*function getDisclaimertext(obj)
{
	var desc=obj.value;
	//alert("desc"+desc);
	if(document.forms[0].disclaimer_desc.options.selectedIndex!=0)
	{
	document.getElementById("disclaimer").style.visibility = 'visible';
	}
	else if(document.forms[0].disclaimer_desc.options.selectedIndex==0)
	{
		document.getElementById("disclaimer").style.visibility = 'hidden';
	}
}

function showText()
{
	
	var rem=document.forms[0].disclaimer_desc.value;
	//alert(rem);
	//var dialogHeight ='8' ;
	//var dialogWidth = '27' ;
	var dialogHeight ='12' ;
	var dialogWidth = '30' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			= window.showModalDialog("../../eCA/jsp/NoteTypeDisclaimerView.jsp?rem='"+rem+"'",arguments,features);
	
}

function doClose()
{
	window.close();
}

//function disclaimerView()
//{
	//var mode=document.forms[0].mode.value;
	//var effstatus=document.forms[0].eff_status1.value;
	
	//alert(confidential_yn);
	//if(mode=='update' && (document.forms[0].disclaimer_desc.options.value!=''))
	//if(mode=='update' && effstatus=='E')
	//{
		//document.getElementById("disclaimer").style.visibility = 'visible';	
	//}
//}

function getNoteGroup(obj)
{
var notegroup = obj.value
var HTMLVal="<html><body><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeIntermediate.jsp'><input type='hidden' name='notegroup' id='notegroup' value="+notegroup+"></form></body></html>";

		 parent.frames[3].document.write(HTMLVal);
	    parent.frames[3].document.tempform1.submit(); 
}



function chkDocLink(obj)
{


	if(obj.checked)
	{
		document.NoteType_form.doc_link_note.value = 'Y'
	}
	else
	{
		document.NoteType_form.doc_link_note.value = 'N'
	}
}

function OnConfChange(obj)
{
	if(obj.checked)
	{
		document.NoteType_form.conf_yn.value = 'Y'
	}
	else
	{
		document.NoteType_form.conf_yn.value = 'N'
	}

}

function getNoteGroup1()
{
	    var target			= document.NoteType_form.note_group_desc;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("eCA.NoteGroup.label","CA");
		//var sql="select NOTE_GROUP,NOTE_GROUP_DESC from ca_note_group where EFF_STATUS = 'E' ";
		var sql="SELECT note_group, note_group_desc FROM ca_note_group where eff_status=`E`";

		search_code="note_group";
		search_desc="note_group_desc";
		retVal=window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
		   	document.NoteType_form.note_group_desc.value=arr[0];
			document.NoteType_form.note_group_id.value=arr[1];
			document.NoteType_form.note_group_desc.focus();
		}
		else
		{
    		document.NoteType_form.note_group_desc.value="";
			document.NoteType_form.note_group_id.value="";
			target.focus();
		}
		
		
		
		if (document.NoteType_form.note_group_id.value=='*REFERRAL' || document.NoteType_form.note_group_id.value=='*DISSUMMPH')
		{
			  document.NoteType_form.doc_link_note.disabled=false;
		}
		else
	   {
			document.NoteType_form.doc_link_note.checked=false;
			document.NoteType_form.doc_link_note.disabled=true;
	   }
}*/


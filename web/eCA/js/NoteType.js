/*
---------------------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
---------------------------------------------------------------------------------------------------------
?             100         ?           created
04/03/2013	IN037676	Dinesh T	Signing the addendum is controlled by the note type parameter
14/08/2015	IN052376	Ramesh G	MMS-RY-CRF-0012 [IN:052376]
---------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
26/08/2016	  IN059489		 Raja S											Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


function create()
{
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=insert';	
	//f_query_add_mod.location.href='../../eCA/jsp/AutoCompleteText.jsp?mode=insert';
}

function query()
{
	f_query_add_mod.location.href='../../eCA/jsp/NoteTypeQueryCriteria.jsp';
}


function apply()
{
	if(f_query_add_mod.document.NoteType_form != null)
	{
		var fields = new Array (
							f_query_add_mod.document.forms[0].note_type,
							f_query_add_mod.document.forms[0].note_type_desc,
							f_query_add_mod.document.forms[0].note_group_id,
							f_query_add_mod.document.forms[0].event_class,
							f_query_add_mod.document.forms[0].publish_level,
							f_query_add_mod.document.forms[0].ammendment_type
							);

		var names = new Array (
							f_query_add_mod.getLabel("Common.code.label",'common'),
							f_query_add_mod.getLabel("Common.description.label",'common'),
							f_query_add_mod.getLabel("eCA.NoteGroup.label",'CA'),
							f_query_add_mod.getLabel("Common.Class.label",'common'),
							f_query_add_mod.getLabel("eCA.PublishLevel.label",'CA'),
							f_query_add_mod.getLabel("eCA.AmendmentType.label",'CA')
							);
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
			var license_rights		=	f_query_add_mod.document.forms[0].license_rights.value;
			var created_notes		=	f_query_add_mod.document.forms[0].created_notes.value;
			var created_tot_notes	=   f_query_add_mod.document.forms[0].created_tot_notes.value;
			var event_class			=	f_query_add_mod.document.forms[0].event_class;
			var mode				=	f_query_add_mod.document.forms[0].mode.value;

			if(license_rights=="BASIC")
			{
				if(created_notes.indexOf(event_class.value)!=-1 && (mode=="insert")){
					var msg = getMessage("MORE_THAN_ONE_NOT_ALLOWED","CA");
					event_class.focus();
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}
				if(eval(created_tot_notes)>=4 )
					{
						var msg = getMessage("MORE_THAN_FOUR_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
				}
			}
			
			if(license_rights=="MINI")
			{
				var created_ip_notes=f_query_add_mod.document.forms[0].created_ip_notes.value;
				var created_op_notes=f_query_add_mod.document.forms[0].created_op_notes.value;
				var ip_checked=f_query_add_mod.document.forms[0].inpatient_yn;
				var op_checked=f_query_add_mod.document.forms[0].outpatient_yn;
				var status_check=f_query_add_mod.document.forms[0].status_check.value;

				if(mode=="insert")
				{
					if(eval(created_ip_notes)>=2 && ip_checked.checked)
					{
						var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
					}
					else if(eval(created_op_notes)>=2  && op_checked.checked)
					{
						var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
					}
					else if(eval(created_notes)>=4 )
					{
						var msg = getMessage("MORE_THAN_FOUR_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
					}
				}
				else if(mode=="update")
				{
					if(((status_check=='I' || status_check=='N') && op_checked.checked) && eval(created_op_notes)>=2)
					{
						var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
					}
					else if(((status_check=='O' || status_check=='N') && ip_checked.checked) && eval(created_ip_notes)>=2)
					{
						var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED","CA");
						messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
						return false;
					}
				}

				if(mode != null)
				{
					if(mode.value=='update')
					{
						f_query_add_mod.document.forms[0].note_groupid_update.value= f_query_add_mod.document.forms[0].note_group_id.value

					}
				}
				/*if(eval(created_notes)>=2 && (mode=="insert")){
					var msg = getMessage("MORE_THAN_TWO_NOT_ALLOWED");
					
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
					return false;
				}*/
			}
			var fields1 = new Array (f_query_add_mod.document.forms[0].note_type);
			var names1 = new Array (f_query_add_mod.getLabel("Common.code.label",'common'));
			
			if(!(f_query_add_mod.document.forms[0].inpatient_yn.checked))
				f_query_add_mod.document.forms[0].inpatient_yn.value = 'N' ;
			else
				f_query_add_mod.document.forms[0].inpatient_yn.value = 'Y' ;


			if(!(f_query_add_mod.document.forms[0].outpatient_yn.checked))
				f_query_add_mod.document.forms[0].outpatient_yn.value = 'N' ;
			else
				f_query_add_mod.document.forms[0].outpatient_yn.value = 'Y' ;


			if(!(f_query_add_mod.document.forms[0].serv_facl_spec_yn.checked))
				f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'N' ;
			else
				f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'Y' ;

			if(!(f_query_add_mod.document.forms[0].doc_link_note.checked))
				f_query_add_mod.document.forms[0].doc_link_note.value = 'N' ;
			else
				f_query_add_mod.document.forms[0].doc_link_note.value = 'Y' ;

			if(!(f_query_add_mod.document.forms[0].serv_facl_spec_yn.checked))
				f_query_add_mod.document.forms[0].serv_facl_spec_yn.value = 'D' ;
			
			if(f_query_add_mod.document.forms[0].DC.checked==true)
			{
				f_query_add_mod.document.forms[0].DC.value = 'Y' ;
			}
			else
			{
				f_query_add_mod.document.forms[0].DC.value = 'N' ;
			}
					if(f_query_add_mod.document.forms[0].EM.checked==true)
			{
				f_query_add_mod.document.forms[0].EM.value = 'Y' ;
			}
			else
			{
				f_query_add_mod.document.forms[0].EM.value = 'N' ;
			}
			

			if(f_query_add_mod.document.forms[0].patient.checked==true)
			{
				
				f_query_add_mod.document.forms[0].patient.value = 'Y' ;
			}
			else
			{
				
				f_query_add_mod.document.forms[0].patient.value = 'N' ;
			}


			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.forms[0].submit();		

			}
		}
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
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
		f_query_add_mod.location.href='../../eCA/jsp/NoteTypeAddModify.jsp?mode=insert';
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
f_query_add_mod.location.reload();
	//f_query_add_mod.document.forms[0].doc_link_note.disabled=true; 
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

function getDisclaimertext(obj)
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

async function showText()
{
	
	var rem=document.forms[0].disclaimer_desc.value;
	//alert(rem);
	//var dialogHeight ='8' ;
	//var dialogWidth = '27' ;
	var dialogHeight ='300px' ;
	var dialogWidth = '500px' ;
	var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	retVal 			=await window.showModalDialog("../../eCA/jsp/NoteTypeDisclaimerView.jsp?rem='"+rem+"'",arguments,features);
	
}

function doClose()
{
	const dialogTag = parent.document.getElementById("dialog_tag");
	dialogTag.close();
	//window.close();
}

function disclaimerView()
{
	var mode=document.forms[0].mode.value;
	var effstatus=document.forms[0].eff_status1.value;
	
	//alert(confidential_yn);
	if(mode=='update' && (document.forms[0].disclaimer_desc.value!=''))
	//if(mode=='update' && effstatus=='E')
	{
		document.getElementById("disclaimer").style.visibility = 'visible';	
	}
	if(mode=='update' && (document.forms[0].note_header_desc.value!=''))
	{
		document.getElementById("note").style.visibility = 'visible';	
	}
	if(mode=='update' && (document.forms[0].report_header_desc.value!=''))
	{
		document.getElementById("report").style.visibility = 'visible';	
	}
	if(mode=='update' && (document.forms[0].footer_header_desc.value!=''))
	{
		document.getElementById("footer").style.visibility = 'visible';	
	}
}

function getNoteGroup(obj)
{
var notegroup = obj.value
var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeIntermediate.jsp'><input type='hidden' name='notegroup' id='notegroup' value="+notegroup+"></form></body></html>";

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

function chkPrintHeader(obj)
{
	var elem = document.getElementById('txtLogoHeader'); //[IN032210]
	if(obj.checked)
	{
		document.NoteType_form.print_logo_header.value = 'Y'
		elem.style.display = ''		//[IN032210]
	}
	else
	{
		document.NoteType_form.print_logo_header.value = 'N'
		elem.style.display = 'none' //[IN032210]
	}
}
//[IN032210] Start
function chkPrintTxtHeader(obj)
{		
	if(obj.checked)
		document.NoteType_form.print_txtlogo_header.value = 'Y'
	else
		document.NoteType_form.print_txtlogo_header.value = 'N'
}
//[IN032210] End

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

async function getNoteGroup1()
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
		retVal=await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(title,"UTF-8")+"&dispDescFirst=dispDescFirst",arguments,features);
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
		
		
		
		/*if (document.NoteType_form.note_group_id.value=='*REFERRAL' || document.NoteType_form.note_group_id.value=='*DISSUMMPH')
		{
			  document.NoteType_form.doc_link_note.disabled=false;
		}
		else
	   {
			document.NoteType_form.doc_link_note.checked=false;
			document.NoteType_form.doc_link_note.disabled=true;
	   }*/

	   var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypeIntermediate.jsp'><input type='hidden' name='notegroup' id='notegroup' value="+document.NoteType_form.note_group_id.value+"></form></body></html>";

		parent.frames[3].document.write(HTMLVal);
	    parent.frames[3].document.tempform1.submit(); 
}


async function  callFunctionButton()
{

	//var sql = "SELECT note_group, note_group_desc FROM ca_note_group where eff_status='E' and upper(note_group) like upper(?) and  upper(note_group_desc) like upper(?) order by 2";

	var sql = "SELECT note_group code, note_group_desc description FROM ca_note_group where eff_status='E' and upper(note_group) like upper(?) and  upper(note_group_desc) like upper(?) order by 2";
	
	var title = getLabel("eCA.NoteGroup.label","CA");
	var target			= document.NoteType_form.note_group_desc;
	target.value='';
	
	
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
	retArray = await CommonLookup( title, argArray );
	
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		} 
			
	if(retArray != null && retArray !="")	
	{
		document.NoteType_form.note_group_desc.value = arr[1];
		document.NoteType_form.note_group_id.value = arr[0];
		//setDocNote(retArray[0]);
		setDocNote(arr[0]);		
	} 
	document.NoteType_form.flag.value='true'
}


async function showText1(chk)
{
	//var rem=document.forms[0].note_header_desc.value;
	//var rem=document.forms[0].footer_header_desc.value;
	var dialogHeight ='70vh' ;//30
	var dialogWidth = '50vw' ;//40
	var arguments			= "" ;
	var action_url		=	'../../eCA/jsp/CASectionTemplateMain.jsp';
	if(chk=="report")
	{
		var title			= getLabel("eCA.ReportHeader.label","CA");
		var report_header_desc=document.forms[0].report_header_desc.value;
	    var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		action_url			+=	"?title="+encodeURIComponent(title,"UTF-8")+"&sec_hdg_code="+report_header_desc+"&operation_mode=TemplateView";
	    retVal			=	await window.showModalDialog(action_url,arguments,features);
	}
	else if(chk=="note")
	{
		var title			= getLabel("eCA.NoteHeader.label","CA");
		var note_header_desc=document.forms[0].note_header_desc.value;
	    var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		action_url			+=	"?title="+encodeURIComponent(title,"UTF-8")+"&sec_hdg_code="+note_header_desc+"&operation_mode=TemplateView";
	    retVal			=	await window.showModalDialog(action_url,arguments,features);
	}
	else if(chk=="footer")
	{
		var title			= getLabel("eCA.NoteFooter.label","CA");
		var footer_header_desc=document.forms[0].footer_header_desc.value;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		action_url			+=	"?title="+encodeURIComponent(title,"UTF-8")+"&sec_hdg_code="+footer_header_desc+"&operation_mode=TemplateView";
	    retVal			=	await window.showModalDialog(action_url,arguments,features);
	}
}

function getHeaderView(obj)
{
	var desc=obj.value;
	var mode=document.forms[0].mode.value;

	if(mode=='update' && (document.forms[0].note_header_desc.options.selectedIndex!=0))
	{
		document.getElementById("note").style.visibility = 'visible';	
	}
	else if(document.forms[0].note_header_desc.options.selectedIndex==0)
	{
		document.getElementById("note").style.visibility = 'hidden';
	}
	if(mode=='update' && (document.forms[0].report_header_desc.options.selectedIndex!=0))
	{
		document.getElementById("report").style.visibility = 'visible';	
	}
	else if(document.forms[0].report_header_desc.options.selectedIndex==0)
	{
		document.getElementById("report").style.visibility = 'hidden';
	}
	if(mode=='update' && (document.forms[0].footer_header_desc.options.selectedIndex!=0))
	{
		document.getElementById("footer").style.visibility = 'visible';	
	}
	else if(document.forms[0].footer_header_desc.options.selectedIndex==0)
	{
		document.getElementById("footer").style.visibility = 'hidden';
	}
}

//function showText2()
//{
	
	//var dialogHeight ='12' ;
	//var dialogWidth = '30' ;
	//var arguments			= "" ;
	//var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	//retVal 			= window.showModalDialog("../../eCommon/html/blank.html",arguments,features);
	
//}
//function showText3()
//{
	
	//var dialogHeight ='12' ;
	//var dialogWidth = '30' ;
	//var arguments			= "" ;
	//var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
	//retVal 			= window.showModalDialog("../../eCommon/html/blank.html",arguments,features);
	
//}

async function getNoteCode(objCode)
{
	
	if(objCode.name=='note_group_desc')
	{
		note_group_id(objCode)
	}

	if(objCode.name == "note_desc_search")
	{
		
		if(document.NoteType_form.flag.value=='false')
			return false
		else

			await callFunctionButton()
	}
			
}


 function note_group_id(objCode)
{
	var notegroup = objCode.value
	if(notegroup == '')
	{
		document.NoteType_form.flag.value='true'
		return false
	}
	else
	{
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';

        var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='tempform1' id='tempform1' method='post' action='../../eCA/jsp/NoteTypePopulateNoteGroup.jsp'><input type='hidden' name='notegroup' id='notegroup' value="+notegroup+"></form></body></html>";
        parent.frames[2].document.write(HTMLVal);
	    parent.frames[2].document.tempform1.submit(); 

    }
}




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
	
}
function setValue()
{
	document.NoteType_form.flag.value='false'
}


async function callFunction(sql,title,target)
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
	retArray = await CommonLookup(title, argArray );
	return retArray;
 }

 function setDocNote(noteGrp)
 {	 
	 //var license_rights = document.forms[0].license_rights.value;
	 var license_rights = parent.f_query_add_mod.document.NoteType_form.license_rights.value;	
	 if(license_rights != 'BASIC')
	 {
		 parent.messageFrame.location.href = '../../eCA/jsp/NoteTypeDocLinked.jsp?noteGrp='+noteGrp+'&license_rights='+license_rights;
	 }
 }

 //IN037676, starts
 function signAddendumOnClick()
 {
	l_sign_addendum = document.getElementById("sign_addendum_yn").checked;

	if(l_sign_addendum)
		document.getElementById("sign_addendum_yn").value = "Y"; 
	else
		document.getElementById("sign_addendum_yn").value = "N";

 }
 //IN037676, ends
 //IN052376 Start.
 async function openPrintNoteTemplate(){
	
	var Obj =document.NoteType_form;
	
	var dialogTop		=	"20px" ;//80
	var dialogHeight	=	"700px" ;//40
	var dialogWidth		=	"900px" ;//60
	var status			=	"no";
	var features		=	"";
	var arguments		=	"" ;
	features	= "dialogHeight:" + dialogHeight +"; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=yes; status:" + status;
	var title		="Print Note Layout";
	var action_url = "../../eCA/jsp/RecPrintNoteLayout.jsp?note_type="+Obj.note_type.value+"&title="+title;
	var returnValue= await window.showModalDialog(action_url,arguments,features);
	
}
//IN052376 End.
//IN059489  starts 
function checkForModeMark(objCheck)
{
	var mode = document.forms[0].mode.value;
	if(objCheck.checked== true)
		document.forms[0].water_mark.value='Y'
	else
		document.forms[0].water_mark.value='N'
}
//IN059489 ends


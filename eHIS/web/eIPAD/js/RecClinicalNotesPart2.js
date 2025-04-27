/* 
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100         ?           	created
21/12/2011    	IN29476     Dinesh T    	Unable to forward the resulted notes to practitioners, included										  the status '5' in the qry
09/07/2012    	IN033511	Chowminya G		When Login Thai and view existing note ?Print? button disappear
10/07/2012	  	IN033786	Ramesh G	  	Canned Text>Some Text missing in Preview
09/08/2012		IN034401	Dinesh T		Html code displays when canned text selected in the Record Clinical Notes function
20/09/2012		IN035306	Dinesh T		Practitioners are not listed across the facilities
04/12/2012		IN032060	Ramesh G		MO-CRF-20059[All the notes which are documented through OT slate when modified 
											by the user who has got privilege to Author and modify these notes and the note 
											type set up is amend original section the system does not store the original note 
											content which was modified. ]
02/01/2013		IN036899	Ramesh G		The ?Status? is not updated in the search tab after the transaction is completed.
03/01/2013		IN037054	Chowminya G		Note Recorded cannot be modified in Lab and CA
06/02/2013		IN037675	Dinesh T		IN037675
20/02/2013 		INO38029    Nijitha S		CRF-CA- CHL-CRF-0044/01- Clinical Notes Widget->Cannot Modify or update Note
27/02/2013		IN038176	DineshT		Privilege level setup with sign is not working		
04/03/2013		IN037676	Dinesh T		Signing the addendum is controlled by the note type parameter
11/03/2013		IN038537	Dinesh T		Issue: System is allowing the Practitioner to Sign the Addendum, which was recorded by other Practitioner from ?Review Notes? function.
15/03/2013		IN038493	NijithaS			CRF-CA- CHL-CRF-0011/04- Social History Widget->While Modifying a image Linked Section we get script error
11/10/2013		IN044211	Ramesh G		Formula in Clinical Notes Not Correct
13/11/2013		IN044955	Ramesh G		When recording the OT Recovery notes script errors
-------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------------------------
24/03/2014	IN047878		Ramesh G	24/03/2014		Akbar S			Secondary Triage->Assessment->Record Clinical Notes->Note marked as Error can be 
																		modified and status is updated wrongly.
02/06/2014	IN037701		Nijitha										SKR-CRF-0036
16/09/2014	IN049625		Ramesh G	16/09/2014		Sunil K V		Clinical Notes Content Missing.User  has entered all the data in the clinical notes and have signed off the note.														
15/12/2014	IN052359		Rames G		15/12/2014		Akbar S			The defined defaulted value does not auto populated when new row is added in grid component.
																		Refer to attached screen shots.
-------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var practArry = new Array(); // to implement auto complete functionality
var prev_val = ""; // to implement auto complete functionality
var prev_count = 0; // to implement auto complete functionality
var firstCodeVal = "" ;
var firstDescVal = "" ;
var continueYN = "";//IN037676
//this function is used to get the correct frame reference
//use  Reference whenever u want to refer the message frame 
function getMessageFrame()
{
	if(undefined!=top.content && top.content!=null){//IN037701
		return top.content.messageFrame;
	}else{
		return top.messageframe;
	}
}
var messageFrameReference = getMessageFrame();
//------------------------------------------------
//this function is called in addendum when u come for modification only
//and called from RecClinicalNotesToolbar.jsp
function getCannedTextFromAddendum()
{
	var service_code		=	document.RecClinicalNotesToolbarForm.service_code.value;
	var note_type			=	document.RecClinicalNotesToolbarForm.note_type.value;
	var retArray			=	"";
	var dialogHeight	=	"20" ;
	var dialogWidth		=	"40" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var param			=	"";
	var action_url		=	'../../eCA/jsp/RecClinicalNotesCannedTextMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	action_url			+=	"?service_code="+service_code+"&note_type="+note_type;
	parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
	retArray			=	window.showModalDialog(action_url,arguments,features);

	var arrTextBlockID;	//=	new Array();
	var arrTextBlock;	//=	new Array();
	
	if( retArray != null )
	{
		arrTextBlockID	=	retArray[0];
		arrTextBlock	=	retArray[1];
		
		var text_blk='';
		for (var i=0; i<arrTextBlock.length; i++)
		{
			var text_blk_id		=	arrTextBlockID[i];
			text_blk			+=	arrTextBlock[i]+"\n";
			
		}
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",text_blk );
	}
	else
	{
		parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
	}
}
//***********************************************************
function getCannedText()
{
	var image_linked_yn = "N";
	
	if(!(checkForMandatoryFields()))
		return false;

	var url =  parent.RecClinicalNotesSecDetailsFrame.location.href;

	if( (url.indexOf('/eCA/jsp/RecClinicalNotesEditorsFrame.jsp')!= -1) )
		image_linked_yn = "Y";


	var service_code ="";
	var note_type = "";
	var sec_hdg_code = "";
	//IN038493 Starts
	//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;//IN038493
	if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm)
	{
		var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	}
	else
	{
		var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	}
	//IN038493 Ends
	service_code	= Obj.service_code.value;
	note_type		= Obj.note_type.value;
	sec_hdg_code	= Obj.prev_sec_hdg_code.value;
	
	if(checkIsNull(Obj.service_code))
		return false;

	var retArray			=	"";
	var dialogHeight	=	"37.5" ;
	var dialogWidth		=	"50" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var search_code		=	"";
	var search_desc		=	"";
	var title			=	"";
	var param			=	"";
	var action_url		=	'../../eCA/jsp/RecClinicalNotesCannedTextMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	action_url			+=	"?service_code="+service_code+"&note_type="+note_type+"&sec_hdg_code="+sec_hdg_code;

	retArray			=	window.showModalDialog(action_url,arguments,features);
	var arrTextBlockID;	//=	new Array();
	var arrTextBlock;	//=	new Array();
	var selectRadio; //[IN033180]
	if( retArray != null )
	{
		arrTextBlockID	=	retArray[0];
		arrTextBlock	=	retArray[1];
		selectRadio		=	retArray[2]; //[IN033180]
		var text_blk='';

		for (var i=0; i<arrTextBlock.length; i++)
		{
			var text_blk_id		=	arrTextBlockID[i];
			text_blk			+=	arrTextBlock[i]+"\n";
		}
		
		if(image_linked_yn == 'Y')
		{
			//IN034401,starts
			//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();
			//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("paste","",text_blk );
			if("T"==selectRadio)
			{
				parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();
				parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("paste","",text_blk );
			}
			else if("E"==selectRadio)
			{				
				var doc = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.selection;
				var len = doc.createRange().text.length;

				if(len>0)
				{
					doc.createRange().pasteHTML(text_blk);
				}
				else
				{	
					var temp_text = (parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerHTML);
					
					temp_text = temp_text.replace( /<ADDRESS\s*[^>]*>\s*&nbsp;\s*<\/ADDRESS>/gi, "" ) ;
					temp_text = temp_text.replace( /<PRE\s*[^>]*>\s*&nbsp;\s*<\/PRE>/gi, "" ) ;
					temp_text = temp_text.replace( /<P\s*[^>]*>\s*&nbsp;\s*<\/P>/gi, "" ) ;
					
					var out_text = temp_text+text_blk;					
					out_text = out_text.replace("<PRE>","");
					out_text = out_text.replace("</PRE>","");
					parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();
					parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerHTML = out_text;					
				}				
			}
			//IN034401,ends
		}
		else
		{
			//parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
			//parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",text_blk );
			//[IN033180] Start.
			if("T"==selectRadio){
				parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
				parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",text_blk );
			}else if("E"==selectRadio){
				
				var doc = parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.selection;
				var len = doc.createRange().text.length;
				 if(len>0){
					doc.createRange().pasteHTML(text_blk);
				}else{	
					//[IN033786] Start
					//var temp_text = (parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.innerHTML).replace("<ADDRESS>","");
					//var out_text = "<ADDRESS> "+temp_text+text_blk+"</ADDRESS>";
					var temp_text = (parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.innerHTML);
					
					temp_text = temp_text.replace( /<ADDRESS\s*[^>]*>\s*&nbsp;\s*<\/ADDRESS>/gi, "" ) ;
					temp_text = temp_text.replace( /<PRE\s*[^>]*>\s*&nbsp;\s*<\/PRE>/gi, "" ) ;
					temp_text = temp_text.replace( /<P\s*[^>]*>\s*&nbsp;\s*<\/P>/gi, "" ) ;
					
					var out_text = temp_text+text_blk;					
					out_text = out_text.replace("<PRE>","");
					out_text = out_text.replace("</PRE>","");
					//[IN033786] End.
					parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
					parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.innerHTML = out_text;					
				}				
			}
			//[IN033180] End.
			
		}
	}
	else
	{
		if(image_linked_yn == 'Y')
			parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();
		else
			parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
	}
}
/*******************************************************/
function getChiefComplaints()
{
	if(!(checkForMandatoryFields()))
		return false;


	var patient_id		= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
	var encounter_id	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;

	var url =  parent.RecClinicalNotesSecDetailsFrame.location.href;

	var image_linked_yn = "N";

	if( (url.indexOf('/eCA/jsp/RecClinicalNotesEditorsFrame.jsp')!= -1) )
		image_linked_yn = "Y";

	var service_code		= "";
	var note_type			= "";
	var sec_hdg_code		= "";
	var child_sec_hdg_code	= "";
	//IN038493 Starts
	//var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	if(null!=top.content.workAreaFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame  && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document && null!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm)
	{
		var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	}
	else
	{
		var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	}
	//IN038493 Ends

	service_code		= Obj.service_code.value;
	note_type			= Obj.note_type.value;
	sec_hdg_code		= Obj.prev_sec_hdg_code.value;
	child_sec_hdg_code	= Obj.prev_child_sec_hdg_code.value;


	if(checkIsNull(Obj.service_code))
		return false;

	var retArray			=	"";
	var dialogHeight	=	"20" ;
	var dialogWidth		=	"42" ;
	var status			=	"no";
	var arguments		=	"" ;
	var sql				=	"";
	var search_code		=	"";
	var search_desc		=	"";
	var title			=	"";
	var param			=	"";
	var action_url		=	'../../eCA/jsp/RecClinicalNotesChiefComplaintMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;

	//Instead of passing the parameter as 'service_code.value' only 'service_code' is passed by Archana Dhal on 6/17/2010 related to IN022163.
	
	action_url			+=	"?patient_id="+patient_id+"&encounter_id="+encounter_id+"&service_code="+service_code+"&note_type="+note_type+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code;

	retArray			=	window.showModalDialog(action_url,arguments,features);

	var arrTextBlockID;	//=	new Array();
	var arrTextBlock;	//=	new Array();
	if( retArray != null )
	{		
		arrTextBlockID	=	retArray[0];
		arrTextBlock	=	retArray[1];

		var text_blk='';

		for (var i=0; i<arrTextBlock.length; i++)
		{
			var text_blk_id		=	arrTextBlockID[i];
			text_blk			+=	arrTextBlock[i]+"\n";			
		}	
		
		if(image_linked_yn == 'Y')
		{
			parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();		
			parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.execCommand("paste","",text_blk );
		}
		else
		{
			parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();		
			parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.execCommand("paste","",text_blk );
		}
	}
	else
	{
		if(image_linked_yn == 'Y')
			parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.focus();	
		else
			parent.RecClinicalNotesSecDetailsFrame.RTEditor0.document.body.focus();
	}
}
/*******************************/
//shaiju
function setValues(obj)
{
	
	if(obj.value=='P')
	{
		document.forms[0].forwarded_clinician_id.value="";
		document.getElementById("practitioner").style.display	= 'inline';
		document.getElementById("img_mand").style.display	= 'none';
		splty_id.selectOption(0);		
		splty_id.unSelectOption();		
		splty_id.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
		document.forms[0].pract_id.value = "";
		document.forms[0].speciality_id.value = '';
		document.forms[0].action_comment.value = '';
		prev_val = "";		
		practArry = new Array();
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " speciality_id=\"\" ";
		xmlStr += " note_type=\"" + document.forms[0].note_type.value + "\" ";
		xmlStr += " clinician_id=\"" + document.forms[0].clinician_id.value + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesForwardToPract.jsp", false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		responseText = trimString(responseText);
		eval(responseText);

		//IN037675, starts
		if(document.getElementById("prac_level").value == 'A')
		{
			document.getElementById("pracLevelFacility").style.display = 'none';
			document.getElementById("specLevelFacility").style.display = 'none';
		}
		else if(document.getElementById("prac_level").value == 'F')
		{
			document.getElementById("pracLevelFacility").style.display = 'inline';
			document.getElementById("specLevelFacility").style.display = 'none';
		}
		else if(document.getElementById("prac_level").value == 'P')
		{
			document.getElementById("pracLevelFacility").style.display = 'inline';
			document.getElementById("specLevelFacility").style.display = 'none';
		}		
		//IN037675, ends

		//addPract();
	}
	else if(obj.value=='S')
	{
		document.forms[0].forwarded_clinician_id.value="";
		document.forms[0].pract_id.value = "";
		document.getElementById("practitioner").style.display	= 'none';
		document.getElementById("img_mand").style.display	= 'inline';
		splty_id.selectOption(0);
		splty_id.unSelectOption();
		splty_id.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
		document.forms[0].speciality_id.value = '';
		document.forms[0].action_comment.value = '';
		prev_val = "";
	
		//IN037675, starts
		if(document.getElementById("spec_level").value == 'A')
		{
			document.getElementById("pracLevelFacility").style.display = 'none';
			document.getElementById("specLevelFacility").style.display = 'none';
		}
		else if(document.getElementById("spec_level").value == 'F')
		{
			document.getElementById("pracLevelFacility").style.display = 'none';
			document.getElementById("specLevelFacility").style.display = 'inline';
		}
		else if(document.getElementById("spec_level").value == 'P')
		{
			document.getElementById("pracLevelFacility").style.display = 'none';
			document.getElementById("specLevelFacility").style.display = 'inline';
		}
		//IN037675, ends

	}
	document.forms[0].forward_mode.value=obj.value;
}

//shaiju

function speciality_change(obj)
{
	if(obj.getSelectedValue() != '' && obj.getSelectedValue() != null)
	{
		obj.setComboValue(obj.getSelectedValue());
		if(obj.getSelectedValue() != prev_val)
		{
			prev_count++;
			prev_val = obj.getSelectedValue();
			var forward_mode = document.forms[0].forward_mode.value;
			
			document.forms[0].speciality_id.value = obj.getSelectedValue();
			firstCodeVal = "" ;
			firstDescVal = "" ;
			document.forms[0].forwarded_clinician_id.value = "";
			document.forms[0].pract_id.value = "";
			if(forward_mode == 'P')
			{
				document.forms[0].pract_id.value = "";
				
				practArry = new Array();

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += "speciality_id=\"" + document.forms[0].speciality_id.value + "\" ";
				xmlStr += "note_type=\"" + document.forms[0].note_type.value + "\" ";
				xmlStr += "clinician_id=\"" + document.forms[0].clinician_id.value + "\" ";
				xmlStr +="/></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesForwardToPract.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
				//addPract();
			}
		}
	}
	else
	{
		if(obj.getSelectedValue() != prev_val && prev_count > 0)
		{
			prev_count++;
			prev_val = obj.getSelectedValue();
			var forward_mode = document.forms[0].forward_mode.value;

			document.forms[0].speciality_id.value = "";
			obj.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");

			if(forward_mode == 'P')
			{
				document.forms[0].pract_id.value = "";
				practArry = new Array();

				var xmlDoc="";
				var xmlHttp = new XMLHttpRequest();
				xmlStr	="<root><SEARCH " ;
				xmlStr += "speciality_id=\"\" ";
				xmlStr += "note_type=\"" + document.forms[0].note_type.value + "\" ";
				xmlStr += "clinician_id=\"" + document.forms[0].clinician_id.value + "\" ";
				xmlStr +=" /></root>" ;
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesForwardToPract.jsp", false ) ;
				xmlHttp.send(xmlDoc);
				responseText=xmlHttp.responseText;
				responseText = trimString(responseText);
				eval(responseText);
				//addPract();
			}
		}
		else
		{
			obj.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
		}
	}
}

function addPract()
{
	forwarded_clinician_id.clearAll();
	var id = "";
	var value = "";

	if((practArry.length) == 0)
	{
		id = "";
		value = " ";
		forwarded_clinician_id.addOption([[id,value]]);
		forwarded_clinician_id.unSelectOption();
		forwarded_clinician_id.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
	}
	else
	{
		id = "*ALL";
		value = "       ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ";
		forwarded_clinician_id.addOption([[id,value]]);

		for(var j=0;j<practArry.length;j++)
		{
			var pract_dtls = practArry[j].split("~");
			id = pract_dtls[0];
			value = pract_dtls[1];
			forwarded_clinician_id.addOption([[id,value]]);
		}
		forwarded_clinician_id.unSelectOption();
		forwarded_clinician_id.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
	}
}

function pract_change(obj)
{
	if(obj.getSelectedValue() == null || obj.getSelectedValue() == '')
	{
		document.forms[0].pract_id.value = "";
		obj.setComboText("        ----- "+getLabel("Common.defaultSelect.label",'COMMON')+" -----      ");
	}
	else
	{
		document.forms[0].pract_id.value = obj.getSelectedValue();
		if(obj.getSelectedValue() != '*ALL')
			obj.setComboValue(obj.getSelectedValue());
	}
}

function delSelect(obj)
{
	obj.deleteOption("*ALL");
	if(obj.optionsArr[0].text == 'ALL')
	{
		obj.deleteOption("ALL");
		var id = "";
		var value = " ";
		obj.addOption([[id,value]]);
	}

	if(obj.getSelectedValue() == null || obj.getSelectedValue() == '')
	{
		obj.setComboText("");
		obj.DOMelem_input.select();
	}
}

function delSelect1(obj)
{
	if(obj.getSelectedValue() == null || obj.getSelectedValue() == '')
		obj.setComboText("");
	else
		obj.setComboValue(obj.getSelectedValue());
}

function getForwardTo(operation_mode)
{
	var note_type	=	"",		query_string	=	"";

	if(operation_mode==null) operation_mode = "";
	
	if( (operation_mode=="Forward") || (operation_mode=="SignOnModify")|| (operation_mode=="ModifyAddendum")|| (operation_mode=="ModifySection"))
	{
		note_type = parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].note_type;

	}//Added By Sridhar Reddy On 03/02/2011 to Fix IN:026290
	else if (operation_mode=="Update" || operation_mode=="UpdateRecord" || operation_mode=="Record" || operation_mode=="Sign")
	{
		note_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;
	}//End
	else if(operation_mode=="")
	{
		note_type = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type;
	}

	if(operation_mode!="MarkAsError")
	{		
		if(checkIsNull(note_type))
			return false;		
		query_string	=	"&note_type="+note_type.value;
	}

	var returnArray		=	new Array();
	var dialogHeight	=	"15" ;
	var dialogWidth		=	"30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesForward.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//returnArray		=	window.open(action_url,arguments,features);
	action_url			+=	"?operation_mode="+operation_mode+query_string;
	returnArray			=	window.showModalDialog(action_url,arguments,features);
	if (returnArray != null)
	{
		if(operation_mode=="Forward")
		{
			var forward_to = returnArray[2];
			if(forward_to=='')
			{
				forward_to = 'P';
			}
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forwarded_clinician_id.value	=	returnArray[0];
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action_comment.value			=	returnArray[1];
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forward_mode.value	=	forward_to;
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].operation_mode.value			=	"Forward";		
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forwardToFac.value			= returnArray[3];//IN037675
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].method	=	'POST';
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
			var confirm_flag = confirm(getMessage("CONF_FWD",'CA'));

			if(confirm_flag==true)
			{
				parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].submit();
			}
		}
		else if( operation_mode=="SignOnModify" )
		{
			return returnArray;
		}
		else
		{
			return returnArray;
		}
	}
	else
	{		
		//Added By Sridhar Reddy On 03/02/2011 to Fix IN:026290
		if (parent.RecClinicalNotesHeaderFrame != null)
		{
			if (parent.RecClinicalNotesHeaderFrame.document.forms[0].operation_mode != null)
			{				
				parent.RecClinicalNotesHeaderFrame.document.forms[0].operation_mode.value = operation_mode;
			}
		}
		//End
		returnArray = null;
		if(operation_mode=="") disableButtons(false,operation_mode);
	}
}

function callOnCancel()
{
	var confirmFlag;
	
	confirmFlag = confirm(getMessage("TEMP_MANDATORY",'CA'));

	if(confirmFlag)
		checkRemoveTemplate("Y");	
	else
		parent.frameSetIdMessage.rows='*%,0%';
	//showNotes('tblrowid0','sectionView');
	
	expandSectionFrames();


}
/*
function callOnClear()
{

	var confirmFlag=confirm("APP-CA155 This Operation will remove the Section Content from the Note");
	if(confirmFlag){

		template_mode		=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.template_mode;
		template_mode.value	=	"RemoveTemplate";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";	
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesTemplateCtrl.jsp";	
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
		expandSectionFrames();
		showProcessingTable(false);
		//alert(parent.RecClinicalNotesSectionFrame.name);
		
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.synchFlag.value = "0";

//		if(parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm != null)
//			parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.synchFlag.value = "0";
	}
}
*/
function doDatetimeCheckAlert(to,from) 
{
	var fromarray; var toarray;
	var fromdate = from;
	var todate = to;
	if(fromdate.length > 0 && todate.length > 0 ) 
	{
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt = new Date(toarray[2],toarray[1],toarray[0]);
		
		if(Date.parse(todt) < Date.parse(fromdt)) 
		{
			return false;
		}
		else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}
	return true;
}

function closeCannedTextWindow()
{
	var text_blk_id = "", text_blk = "", block_id = "";
	var text_block=""; //37274
	var returnArray		= new Array();
	var arrTextBlockID	= new Array();
	var arrTextBlock	= new Array();
	//to put some value in the clipboard
	if(document.forms[0].select!=null)
	{
		var clipBoardVal=document.forms[0].select.createTextRange();
		clipBoardVal.select();
		clipBoardVal.execCommand("copy","","");
		//document.RecClinicalNotesHeaderForm.body.focus();
	}
	//ends here	

	var totalBlocks	=	parent.RecClinicalNotesCTFrame.document.forms[0].totalBlocks.value;
	var  selectRadio= getRadioCheckedValue('r1'); //[IN033180]
	var selectIndex = 0;
	for(var i=0; i<totalBlocks; i++)
	{
		block_id		=	eval("parent.RecClinicalNotesCTFrame.document.forms[0].block_id"+i);
		if(block_id.checked==true)
		{
			text_block_id		=	eval("parent.RecClinicalNotesCTFrame.document.forms[0].text_blk_id"+i).value;
			//[IN033180] text_block			=	eval("parent.RecClinicalNotesCTFrame.document.getElementById("text_blk")"+i).innerText;
			//[IN033180] Start
			if("T"==selectRadio)
				text_block			=	eval("parent.RecClinicalNotesCTFrame.document.getElementById("text_blk")"+i).innerText;
			else if ("E"==selectRadio)
				text_block			=	eval("parent.RecClinicalNotesCTFrame.document.getElementById("text_blk")"+i).innerHTML;
			//[IN033180] End
			arrTextBlockID[selectIndex]	=	text_block_id; 
			arrTextBlock[selectIndex]	=	(text_block); 			
			selectIndex++;
		}
	}
	text_block = text_block.replace("<PRE>","");
	text_block = text_block.replace("</PRE>","");
	returnArray[0] = arrTextBlockID;
	returnArray[1] = arrTextBlock;
	returnArray[2] = selectRadio; //[IN033180]
	window.returnValue = returnArray;
	window.close();
}
/*
function checkIsValidDate()
{
	// sys_date_time is added by arul on 2003
	var event_date_time = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;
	var visit_adm_date	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date;
	var sys_date_time	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time;

	if(checkIsNull(event_date_time))
	{
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
		return false;
	}

	if (!CheckDateNew(event_date_time) )
		return false;

	if(!(doDateTimeChk(event_date_time)) )
	{
		
		event_date_time.focus();
		event_date_time.select();
		msg = getCAMessage("INVALID_DATE_TIME");
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
		return false;
	}
	

	var action_url = '../../eCA/jsp/NewRecClinicalNotesCheckDate.jsp';

	// sys_date_time is added by arul on 8th March 2003
	var HTMLVal="<html><body><form name='CheckDateTempForm' id='CheckDateTempForm' method='get' action='"+action_url+"'>"+
	"<input type='hidden' name='event_date_time' id='event_date_time' value='"+event_date_time.value+"'>"+
	"<input type='hidden' name='visit_adm_date' id='visit_adm_date' value='"+visit_adm_date.value+"'>"+
	"<input type='hidden' name='sys_date_time' id='sys_date_time' value='"+sys_date_time.value+"'>"+
	"</form></body></html>";
	messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	messageFrameReference.document.CheckDateTempForm.submit();
	return true;
}
*/
/*
function checkIsValidDate()
{
	
	var event_date_time = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;
	
	var visit_adm_date	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.visit_adm_date;
	var sys_date_time	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time;
	var days_backdate	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.days_backdate;

	if(checkIsNull(event_date_time))
	{
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
		return false;
	}

	if (!CheckDateNew(event_date_time) )
		return false;

	if(!(doDateTimeChk(event_date_time)) )
	{
		event_date_time.focus();
		event_date_time.select();
		msg = getMessage("INVALID_DATE_TIME","CA");
		messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp?err_num='+msg;
		return false;
	}
	
	var eventdate = event_date_time.value.split(" ");
	var sysdate=sys_date_time.value.split(" ");
	var event_date = eventdate[0].split("/");
	var event_date_min=eventdate[1].split(":");
	var event_date_min1_conv=event_date_min[0]*60*60*1000;
	var event_date_min2_conv=event_date_min[1]*60*1000;
	var event_min_total=event_date_min1_conv+event_date_min2_conv;
	var sys_date=sysdate[0].split("/");
	var sys_date_min=sysdate[1].split(":");
	var sys_date_min1_conv=sys_date_min[0]*60*60*1000;
	var sys_date_min2_conv=sys_date_min[1]*60*1000;
	var sys_min_total=sys_date_min[0]*60*60*1000+sys_date_min[1]*60*1000;

	var eventdatetime = new Date(event_date[2],event_date[1],event_date[0]);
	var sysdatetime= new Date(sys_date[2],sys_date[1],sys_date[0]);
	//alert(Date.parse(eventdatetime)-days_backdate.value);

	var event=Date.parse(eventdatetime)+event_min_total;
	var sys= Date.parse(sysdatetime)+sys_min_total; 
	var back=(days_backdate.value*24*60*60*1000);
		//alert(event);
		//alert(sys);
		//alert(sys-back);
	if(!((event >(sys-back))&&(event < sys)))
	{
		
		messageFrameReference.location.href = "../../eCommon/jsp/error.jsp";
		var msg =getMessage("INVALID_NOTES_DATE","CA");
		alert(msg);
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.value = sys_date_time.value;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';	
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.select();

		return false;
	}
	else
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';		
		messageFrameReference.location.href = "../../eCommon/jsp/error.jsp";

		return true;
	}
	

	
	
	var action_url = '../../eCA/jsp/RecClinicalNotesCheckDate.jsp';

	// sys_date_time is added by arul on 8th March 2003
	var HTMLVal="<html><body><form name='CheckDateTempForm' id='CheckDateTempForm' method='get' action='"+action_url+"'>"+
	"<input type='hidden' name='event_date_time' id='event_date_time' value='"+event_date_time.value+"'>"+
	"<input type='hidden' name='visit_adm_date' id='visit_adm_date' value='"+visit_adm_date.value+"'>"+
	"<input type='hidden' name='sys_date_time' id='sys_date_time' value='"+sys_date_time.value+"'>"+
	"</form></body></html>";
	messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	messageFrameReference.document.CheckDateTempForm.submit();
	
	return true;
	
	
	
	
}*/

function checkIsValidDate(event_date_time,visit_adm_date,days_backdate,sys_date_time,format,locale)
{	
	var sys_back_interval = minusDate(sys_date_time, format, locale, days_backdate, "d");
	if(!(event_date_time.value == "" ))
		{
		
			if(!doDateTimeChk(event_date_time))
			{
				
				alert(getMessage("INVALID_DATE_TIME","CA"));
				document.forms[0].event_date_time.select();
				document.forms[0].event_date_time.focus();
				return false;
			}
			if(!(isBeforeNow(event_date_time.value,format,locale) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				event_date_time.select();
				event_date_time.focus();
				return false;
				
			}
			else
				{ 
					if(!(isAfter(sys_back_interval,event_date_time.value, format, locale)))
					{
						if (!(isBefore(event_date_time.value,visit_adm_date, format, locale)))
						{
							return true;
						}else{
							top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.value = visit_adm_date;
							top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';	
							alert(getMessage("DATE_NOT_GREATER_VISIADMIN","CA")); 							
							return false;
						}
						
					}
					else
					{
						top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.value = sys_date_time;
						top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';	
						alert(getMessage("INVALID_NOTES_DATE","CA")); 
						return false;
					}
								
				}
			
		
		}
		
}
/*
function showCalendarValidateForRecTime(str)
{
	var sys_date_time	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time;
	var flg = showCalendar(str,null,'hh:mm');
	
	if(!document.getElementById("CACalanderFun"))
		eval("document.all."+str+".focus();");

	var event_date_time = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.event_date_time;
	var days_backdate	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.days_backdate;

	var eventdate = event_date_time.value.split(" ");
	var sysdate=sys_date_time.value.split(" ");
	var event_date = eventdate[0].split("/");
	var event_date_min=eventdate[1].split(":");
	var event_date_min1_conv=event_date_min[0]*60*60*1000;
	var event_date_min2_conv=event_date_min[1]*60*1000;
	var event_min_total=event_date_min1_conv+event_date_min2_conv;
	var sys_date=sysdate[0].split("/");
	var sys_date_min=sysdate[1].split(":");
	var sys_date_min1_conv=sys_date_min[0]*60*60*1000;
	var sys_date_min2_conv=sys_date_min[1]*60*1000;
	var sys_min_total=sys_date_min[0]*60*60*1000+sys_date_min[1]*60*1000;

	var eventdatetime = new Date(event_date[2],event_date[1],event_date[0]);
	var sysdatetime= new Date(sys_date[2],sys_date[1],sys_date[0]);
	//alert(Date.parse(eventdatetime)-days_backdate.value);

	var event=Date.parse(eventdatetime)+event_min_total;
	var sys= Date.parse(sysdatetime)+sys_min_total; 
	var back=(days_backdate.value*24*60*60*1000);
		//alert(event);
		//alert(sys);
		//alert(sys-back);
	if(!((event >(sys-back))&&(event < sys)))
	{
		
		messageFrameReference.location.href = "../../eCommon/jsp/error.jsp";
		var msg =getMessage("INVALID_NOTES_DATE","CA");
		alert(msg);
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.value = sys_date_time.value;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';	
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time.select();

		return false;
	}
	else
	{
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.forms[0].event_date_time_flag.value = 'T';		
		messageFrameReference.location.href = "../../eCommon/jsp/error.jsp";

		return true;
	}

//	return checkIsValidDate();
	return flg;
}*/

function showCalendarValidateForRecTime(str)
{
	var sys_date_time	= parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.sys_date_time;
	var flg = showCalendar(str,null,'hh:mm');
	
	if(!document.getElementById("CACalanderFun"))
		eval("document.all."+str+".focus();");

	return flg;
}


function callMeOnClickSearchResult(facility_id, note_type, accession_num, performed_by_id, operations_allowed, amendment_type, privilege_type, tblrow_id)
{
	changeRowColor(tblrow_id,7,1,"");
	var query_string = parent.parent.RecClinicalNotesTabsFrame.document.forms[0].query_string.value;
	
	var retArray		=	new Array();
	var dialogHeight	=	"25" ;
	var dialogWidth		=	"80" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?facility_id="+facility_id+"&note_type="+note_type+"&accession_num="+accession_num+"&performed_by_id="+performed_by_id+"&operations_allowed="+operations_allowed;
	action_url			+=	"&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&"+query_string;
	retArray			=	window.showModalDialog(action_url,arguments,features);

	if(retArray==null) retArray = "";
	if(!(retArray==null))
	{
		if ( retArray.length > 0 )
		{
			var note_type		=	retArray[0];
			var accession_num	=	retArray[1];
			var operation_mode	=	retArray[2];

			query_string += "&note_type="+note_type+"&accession_num="+accession_num+"&operation_mode="+operation_mode; 
			query_string += "&amendment_type="+amendment_type+"&privilege_type="+privilege_type;

			parent.parent.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;
		} // end of if ( retArray.length > 0 )
	} // end of if(!(retArray==null))
	window.location.reload();
	//alert(parent.frames[0].name);
	//parent.frames[0].location.reload();
}

function showDetails(vals)
{
	var arr = vals.split("~");
	var episodetype = parent.details_f1.document.forms[0].episode_type.value;
	var histtype1 = parent.details_f1.document.forms[0].history_type.value;
	var eventclass1 = parent.details_f1.document.forms[0].event_class.value;
	var eventgroup1 = parent.details_f1.document.forms[0].event_group.value;
	var eventitem1 = parent.details_f1.document.forms[0].event_item.value;

	var eventdate	= arr[1]==null?"":arr[1];
	var datatype = arr[0]==null?"":arr[0];
	histtype		= arr[2]==null?"":arr[2];
	eventclass	= arr[3]==null?"":arr[3];
	eventgroup= arr[4]==null?"":arr[4];
	eventitem	= arr[5]==null?"":arr[5];

	if(histtype == '') histtype = histtype1;
	if(eventclass == '') eventclass = eventclass1;
	if(eventgroup == '') eventgroup = eventgroup1;
	if(eventitem == '') eventitem = eventitem1;
	var params = '?patient_id='+patientid+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&view_by='+viewby+'&event_date='+eventdate+'&from_date='+fromdate+'&to_date='+todate;

	if(datatype == "TXT")
		parent.details_f2.location.href = '../../eCA/jsp/EncountersDetailsFrame.jsp'+params
	else
	{
		enablePrint(datatype);
		parent.details_f2.location.href = '../../eCA/jsp/EncountersDetailsDisplay.jsp'+params
	}
}

function closeForwardWindow()
{
	var operation_mode			=	parent.criteria.document.forms[0].operation_mode;
	var forwarded_clinician_id	=	parent.criteria.document.forms[0].pract_id;
	var forwarded_speciality_id	=	parent.criteria.document.forms[0].speciality_id;
	var action_comment			=	parent.criteria.document.forms[0].action_comment;
	var alertMsg                =   "" ;
	var forward_to				= parent.criteria.document.forms[0].forward_mode.value;
	//IN037675, starts
	var forward_to_fac_id = '';

	//if(operation_mode.value == 'Forward' || operation_mode.value == '' || operation_mode.value == 'Record')
	if(operation_mode.value == 'Forward' || operation_mode.value == '' || operation_mode.value == 'Record' || operation_mode.value == 'SignOnModify')
	{
		if(forward_to == 'P')
			forward_to_fac_id		= parent.criteria.document.forms[0].forwardToFac.value;
		else
			forward_to_fac_id		= parent.criteria.document.forms[0].forwardToFac1.value;
	}
	//IN037675, ends
	

	if(operation_mode.value!="MarkAsError" && operation_mode.value!="ModifyAddendum" && operation_mode.value!="ModifySection")
	{
		if(operation_mode.value == "Forward")
		{
			if(checkIsNull(forwarded_clinician_id)&& (forward_to=='P' || forward_to==''))
			{	
				alertMsg=getMessage("SHOULD_NOT_BE_BLANK","Common");
				alertMsg=alertMsg.replace("{1}",getLabel('Common.practitioner.label','Common'));
							//alertMsg = getMessage("PERFORMED_NOT_BLANK","CA");
							alertMsg+="...\n";
			}
			else if (checkIsNull(forwarded_speciality_id) && forward_to=='S')
			{
				
				alertMsg=getMessage("SHOULD_NOT_BE_BLANK","Common");
				alertMsg=alertMsg.replace("{1}",getLabel('Common.speciality.label','Common'));
				alertMsg+="...\n";
				//alertMsg = "APP-CA00001 Specialitity cannot be blank...\n" ;//to be changed
				
			}
		}
		else
		{
			if(checkIsNull(forwarded_clinician_id))
			{	
				alertMsg = getMessage("SHOULD_NOT_BE_BLANK","Common");
				alertMsg = alertMsg.replace("{1}",getLabel('Common.practitioner.label','Common'));
				alertMsg+="...\n";
			}
		}
		if(checkIsNull(action_comment))
		{
			alertMsg += getMessage("SHOULD_NOT_BE_BLANK","Common");
			alertMsg = alertMsg.replace("{1}",getLabel('eCA.Subject.label','CA'));
		}
	}
	else
	{
		if(checkIsNull(action_comment))
		{
			alertMsg += getMessage("SHOULD_NOT_BE_BLANK","Common");
			alertMsg = alertMsg.replace("{1}",getLabel('Common.remarks.label','COMMON'));
		}
	}
	if(alertMsg != "")
	{
		alert(alertMsg);
		/*if(alertMsg.indexOf("Practitioner")!=-1)
			forwarded_clinician_id.focus();
		else if (alertMsg.indexOf("Specialitity")!=-1)
			forwarded_speciality_id.focus();
		else
			action_comment.focus();*/
		return false;
	}
	var returnArray		=	new Array();
	if(operation_mode.value!="MarkAsError" && operation_mode.value!="ModifyAddendum" && operation_mode.value!="ModifySection")
	{
		if (forward_to=='P' || forward_to=='')
		{
			returnArray[0]		=	forwarded_clinician_id.value;
		}
		else if (forward_to=='S')
		{
			returnArray[0]		=	forwarded_speciality_id.value;
		}
		
		//returnArray[0]		=	forwarded_clinician_id.value;
		
		
		returnArray[1]		=	action_comment.value;
		returnArray[2]		=	forward_to;
		returnArray[3]		=	forward_to_fac_id;//IN037675
	}
	else
	{
		returnArray[0]		=	action_comment.value;
		
	}
	parent.window.returnValue = returnArray;
	parent.window.close();
}

function callMeOnDelete()
{
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].operation_mode.value			=	"Delete";		

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;	
	if( function_id=="SPCL_NOTE"  || function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	else
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;

	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].method	=	'POST';
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
	var confirm_flag = confirm(getMessage("DELETE_NOTE","CA"));
	if(confirm_flag==true)
	{
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].submit();
	}
}

function callMeOnError()
{
	var returnArray = getForwardTo('MarkAsError');
	if(returnArray==null)
	{
		return false;
	}
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].operation_mode.value			=	"MakeAsError";		
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action_comment.value			=	returnArray[0];		

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;
	if( function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	else
	{
		if(top.content==null)
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;
		else
			parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	}

	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].method	=	'POST';
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
	var confirm_flag = confirm(getMessage("CONF_MARKERROR",'CA'));
	if(confirm_flag==true)
	{
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].submit();
	}
}

function callMeOnUpdate()
{
	
	// new 
	//var patient_line		=	document.forms[0].patient_line.value;
	var performed_by_name	=	document.forms[0].performed_by_name.value;
	var visit_adm_date		=	document.forms[0].visit_adm_date.value;
			var specialty_name		=	document.forms[0].specialty_name.value;
			//var function_id			=	document.forms[0].function_id.value;
			var episode_type		=	document.forms[0].episode_type.value;
			var title				=	document.forms[0].note_header_desc.value;
			var lastModifiedBy		=	document.forms[0].lastModifiedBy.value;
			var encounter_id		=	document.forms[0].encounter_id.value;
			var patient_id			=	document.forms[0].patient_id.value;
			var patient_name		=	document.forms[0].patient_name.value;
			var patient_age			=	document.forms[0].patient_age.value;
			var patient_sex			=	document.forms[0].patient_sex.value;
			var locationDesc		=	document.forms[0].locationDesc.value;
			var patient_class		=	document.forms[0].patient_class.value;
			var event_date_time		=	document.forms[0].event_date_time.value;
			var dischargeDateTime	=	document.forms[0].dischargeDateTime.value;
			var printDateTime		=	document.forms[0].printDateTime.value;
			var location_code		=	document.forms[0].location_code.value;
			var attending_practitioner		=	document.forms[0].attending_practitioner.value;
			var performed_by_desc		=	document.forms[0].performed_by_desc.value;
			var speciality_code		=	document.forms[0].speciality_code.value;
			var appl_task_id		=	document.forms[0].appl_task_id.value;//IN037054



	// new

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;
	var note_type		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].note_type.value;
	var accession_num	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].accession_num.value;
	var doc_linked_note_yn	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].doc_linked_note_yn.value;
	var sec_count	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].sec_count.value;

	var operation_mode	=	"Update";

	//if( function_id=="SPCL_NOTE" || function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" ) //|| function_id=="NOTIFIABLEFORM"  //IN032060
	//if( function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES")//IN032060
	if( function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || (function_id =="SPCL_NOTE" && appl_task_id !="OT_NOTES")) //IN037054
	{
		var amendment_type	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].amendment_type.value;
		var privilege_type	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].privilege_type.value;
		var query_string	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].query_string.value;
		query_string += "&note_type="+note_type+"&accession_num="+accession_num+"&operation_mode="+operation_mode+"&doc_linked_note_yn="+doc_linked_note_yn+"&sec_count="+sec_count; 
		query_string += "&amendment_type="+amendment_type+"&privilege_type="+privilege_type;
		top.content.workAreaFrame.location.href = '../../eCA/jsp/RecClinicalNotes.jsp?'+query_string;

	}
	else
	{		
		//var retArray	=	new Array(note_type,accession_num,operation_mode,sec_count);
		var retArray	=	new Array(note_type,accession_num,operation_mode,sec_count,visit_adm_date,dischargeDateTime,performed_by_name,locationDesc,event_date_time,title,location_code,attending_practitioner,performed_by_desc,specialty_name,speciality_code);
		parent.window.returnValue = retArray;
		parent.window.close();

	}
}

function callMeOnReview()
{
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].operation_mode.value	=	"Review";		

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;
	if(function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	else
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;

	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].method	=	'POST';
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';
	var confirm_flag = confirm(getMessage("CONF_REVIEW",'CA'));
	if(confirm_flag==true)
	{
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].submit();
	}
}

function callMeOnSign()
{
	var privilege_type = parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].privilege_type.value;
	var forwarded_clinician_id	=	"";
	var action_comment			=	"";
	var forward_fac_id = "";//IN038176
	if(privilege_type=="2")
	{
		var returnArray	=	getForwardTo("SignOnModify");
		if(returnArray==null)
		{
			return false;
		}
		forwarded_clinician_id	=	returnArray[0];
		action_comment			=	returnArray[1];
		forward_fac_id = returnArray[3];//IN038176
	}
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forwarded_clinician_id.value	=	forwarded_clinician_id;	
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forwardToFac.value			= forward_fac_id;//IN038176
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].forward_mode.value = "P";//IN038176
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action_comment.value			=	action_comment;		
	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].operation_mode.value			=	"SignOnModify";		

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;
	
	if(function_id=="SPCL_NOTE"  || function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM")
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	messageFrameReference.name;
	else
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].target	=	top.frames[1].name;

		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].method	=	'POST';
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].action	=	'../../servlet/eCA.RecClinicalNotesServlet';

	var alert_msg = "";
	if(privilege_type=="2")
	{
		alert_msg = getMessage("CONF_FWD",'CA');
	}
	else
	{
		alert_msg = getMessage("CONF_SIGN",'CA');
	}

	var confirm_flag = confirm(alert_msg);
	if(confirm_flag==true)
	{
		var oledb_con_string = document.forms[0].oledb_con_string.value;		
		if(document.forms[0].figer_print_auth_yn.value=="Y")
		{
			if(!verifyTheFinger(oledb_con_string))
			{
				return false;
			}
		}
		parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].submit();
	}
}

function callMeOnModify()
{
	
	var note_type		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].note_type.value;
	var accession_num	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].accession_num.value;
	var amendment_type	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].amendment_type.value;

	var performed_by_name	=	document.forms[0].performed_by_name.value;
	var visit_adm_date		=	document.forms[0].visit_adm_date.value;
	var specialty_name		=	document.forms[0].specialty_name.value;

	//var function_id			=	document.forms[0].function_id.value;
	var episode_type		=	document.forms[0].episode_type.value;
	var title				=	document.forms[0].note_header_desc.value;
	var lastModifiedBy		=	document.forms[0].lastModifiedBy.value;
	var encounter_id		=	document.forms[0].encounter_id.value;
	var patient_id			=	document.forms[0].patient_id.value;
	var patient_name		=	document.forms[0].patient_name.value;
	var patient_age			=	document.forms[0].patient_age.value;
	var patient_sex			=	document.forms[0].patient_sex.value;
	var locationDesc		=	document.forms[0].locationDesc.value;
	var patient_class		=	document.forms[0].patient_class.value;
	var event_date_time		=	document.forms[0].event_date_time.value;
	var dischargeDateTime	=	document.forms[0].dischargeDateTime.value;
	var printDateTime		=	document.forms[0].printDateTime.value;
	var location_code		=	document.forms[0].location_code.value;
	var attending_practitioner		=	document.forms[0].attending_practitioner.value;
	var performed_by_desc		=	document.forms[0].performed_by_desc.value;
	var speciality_code		=	document.forms[0].speciality_code.value;
	var appl_task_id		=	document.forms[0].appl_task_id.value;//IN037054
  
	var operation_mode	=	"";
	
	if(amendment_type=="A")
		operation_mode	=	"ModifyAddendum";
	else
		operation_mode	=	"ModifySection";	

	var function_id		=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].function_id.value;
	
	//if(function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM" || (function_id =="SPCL_NOTE" ) //IN032060
	//if(function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM"  ) //IN032060
	if(function_id=="SIGN_NOTES" || function_id=="REVIEW_NOTES" || function_id=="NOTIFIABLE_FORM" || (function_id =="SPCL_NOTE" && appl_task_id !="OT_NOTES")) //IN037054
	{		
		var privilege_type	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].privilege_type.value;
		var query_string = "&note_type="+note_type+"&accession_num="+accession_num+"&operation_mode="+operation_mode; 
		query_string += "&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&rec_flag='N'";
		var avail_query_string	=	parent.RecClinicalNotesSearchToolbarFrame.document.forms[0].query_string.value;
		query_string += avail_query_string;
		validateAddendumRecords(accession_num,note_type);//IN038537

		//IN038537, starts
		if(continueYN != 'Y')
		{
			alert(getMessage('CA_SIGN_OTH_ADDENDUM','CA'));
			return false;
		}
		//IN038537, ends
		top.content.workAreaFrame.location.href = '../../eCA/jsp/RecClinicalNotes.jsp?'+query_string;
	}
	else
	{		
		validateAddendumRecords(accession_num,note_type);//IN037676


		//IN037676, starts
		if(continueYN != 'Y')
		{
			alert(getMessage('CA_SIGN_OTH_ADDENDUM','CA'));
			return false;
		}
		//IN037676, ends

		var returnArray = getForwardTo(operation_mode);
	
		if(returnArray != null)
		{
			var action_comment = returnArray[0];			
			var retArray	=	new Array(note_type,accession_num,operation_mode,amendment_type,visit_adm_date,dischargeDateTime,performed_by_name,locationDesc,event_date_time,title,location_code,attending_practitioner,performed_by_desc,specialty_name,speciality_code);					

			if(returnArray[0] != null)
				//retArray[retArray.length] = encodeURIComponent(action_comment,"UTF-8");
				retArray[retArray.length] = action_comment ;
			parent.window.returnValue = retArray;
			parent.window.close();
			
		}
	}
}

function makeMeScrollYes()
{
	parent.scrolling = "auto";
}

function callMeOnLinkDocs()
{
	var	curr_sec_hdg_code			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.curr_sec_hdg_code;
	
	var	curr_child_sec_hdg_code		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.curr_child_sec_hdg_code;
	var	prev_sec_hdg_code		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_sec_hdg_code.value;
	var	prev_child_sec_hdg_code		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_child_sec_hdg_code.value;
	
	var appl_task_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;
	var	multi_sec_hdg_code			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_sec_hdg_code.value;
	var	multi_child_sec_hdg_code			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.multi_child_sec_hdg_code.value;
	
	var	curr_section_type			=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_sec_type.value;
	var	curr_result_link_type		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_sec_result_link_type.value;
	var	curr_image_linked_yn		=	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.prev_image_linked_yn.value;

	
	if(appl_task_id=="PAT_MEDICAL_REPORT")
	{
		showLinkDocuments(multi_sec_hdg_code,curr_section_type,multi_child_sec_hdg_code,curr_section_type,curr_result_link_type,curr_image_linked_yn);	
	}
	else
	{
		showLinkDocuments(prev_sec_hdg_code,curr_section_type,prev_child_sec_hdg_code,curr_section_type,curr_result_link_type,curr_image_linked_yn);
		//showLinkDocuments(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code,curr_section_type,curr_result_link_type,curr_image_linked_yn);
	}
}

function showRTEditor()
{	
	var	note_type		=	"";
	var retVal			=	"";
	var dialogHeight	=	"25";
	var dialogWidth		=	"70";
	var dialogTop		=	"170";
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesRTEditorMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	window.open(action_url,null,"height=200,width=400,top=170,status=yes,toolbar=no,menubar=no,location=no");
}

function showSectionTemplate(curr_sec_hdg_code,curr_section_type,curr_child_sec_hdg_code, template_title,patient_id,episode_id)
{
	var arguments		=	"" ;
	
	var action_url		=	'../../eCA/jsp/RecClinicalNotesTemplateMain.jsp';
	action_url			+=	"?curr_sec_hdg_code="+curr_sec_hdg_code+"&curr_section_type="+curr_section_type+"&curr_child_sec_hdg_code="+curr_child_sec_hdg_code+"&template_title="+template_title+"&operation_mode=&patient_id="+patient_id+"&episode_id="+episode_id;
	parent.RecClinicalNotesSecDetailsFrame.location.href	= action_url;
	parent.EditorTitleFrame.location.href = "../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title="+encodeURIComponent(template_title,"UTF-8");
}

function cancelOperation()
{


}

function callCheckTime(timeObj)
{
	if(checkIsNull(timeObj)) 
	{
		return false;
	}

	if(chkTime(timeObj.value)==false)
	{
		var msg =getMessage("INVALID_TIME_FMT","CA");
		//var msg = "APP-CA00021 Invalid time format";
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+msg;
		timeObj.select();
		timeObj.focus();
		return false;
	}
	else
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	}
}

function callCheckDateTime(dateTimeObj)
{	
	
	if(checkIsNull(dateTimeObj)) 
	{
		return false;
	}

	/*if(doDateTimeChk(dateTimeObj)==false)
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		dateTimeObj.select();
		dateTimeObj.focus();
		return false;
	}
	else
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	}*/
	    
	if(doDateTimeChk(dateTimeObj)==false)
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		dateTimeObj.select();
		dateTimeObj.focus();
		return false;
	}		
	else
	{
		var dateArray=dateTimeObj.value.split(" ");			
		var timeArray=dateArray[0].split("/");
		if((parseInt(timeArray[2],10)==0)||(parseInt(timeArray[1],10)==0)||(parseInt(timeArray[0],10)==0))
		{
			messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
			dateTimeObj.select();
			dateTimeObj.focus();
			return false;
		}
		else
		{
			messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
		}
	}
	
}

/**
  * Included on 22nd July 2002 for checking the number range between the minimum and maximum range.
  */
function checkValidRange(numObj, grid_min_max_id)
{	
	//alert( "grid_min_max_id#####"+grid_min_max_id	 );
	/*if(CheckNum(numObj)==false)
		return false;*/ // commented by Deepa on 4/30/2009 at 2:11 PM for IN010261.
	
	if(isNaN(numObj.value))
	{
		//alert(getMessage("NUM_ALLOWED", "SM"));
		//numObj.select();
		//numObj.focus();
		numObj.value = "";
		return false;
	}
	
	if(checkIsNull(numObj))
		return false;
	var min_max_obj;
	var	min_max_value	=	"",	min_num_value	=	0,	max_num_value	=	0;
	var min_max_array	=	new Array();	
	min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numObj.name);
	if(grid_min_max_id != null)
	{		
		var temp_obj = eval("document.all." + grid_min_max_id);		
		if(temp_obj.length == null)
			min_max_value	=	temp_obj.value;
		else
			min_max_value	=	temp_obj(0).value;
	}
	else
	{	
		min_max_value	=	min_max_obj.value;
	}
	min_max_array	=	min_max_value.split("|");
	min_num_value	=	min_max_array[0];
	max_num_value	=	min_max_array[1];		
	entered_value	=	numObj.value;
	if(entered_value=="") entered_value = "0";
	if(parseFloat(max_num_value)==0) return false;

	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
		msg=msg.replace('(1)',min_num_value);
		msg=msg.replace('(2)',max_num_value);
		alert(msg);

		numObj.select();
		numObj.focus();
		return false;
	}
}

function checkValidRange1(numObj,numhidObj,minDigit,decDigit,short_desc_alert)
{	
	if(isNaN(numObj.value))
	{
		numObj.value = "";
		return false;
	}
	
	var val = numObj.value;

	if(val.indexOf(".") != -1)
	{
		var str = val.substring(val.indexOf(".")+1, val.length);
		
		if (parseInt(decDigit) != 0 && (str.length) > parseInt(decDigit) )
		{	
			var msg = getMessage('VARIABLE_DEC_DIGIT','CA');
			msg = msg.replace('@',decDigit);
			alert(msg);
			numObj.value = '';
			numObj.focus();
			return;
		}
	}
	
	if ( val != null && val != '')
	{
		var val1 = val;
						
		if(val1.indexOf(".") >= 0)
		{
			val1 = val1.substr(0, val1.indexOf("."));
		}
		if(val1.length < eval(minDigit))
		{
			var message_alert=getMessage("MINIMUM_DIGITS","CA");
			message_alert = message_alert.replace('$',short_desc_alert);
			alert(message_alert+' '+minDigit);						
			numObj.value = '';
			numObj.focus();
			return;
		}
	}

	if(checkIsNull(numObj))
		return false;
	var min_max_obj;
	var	min_max_value	=	"",	min_num_value	=	0,	max_num_value	=	0;
	var min_max_array	=	new Array();	
	//min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numObj.name);
//	min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numhidObj);
	min_max_obj	=	eval("document.RecClinicalNotesTemplateForm.min_max" + numhidObj);
	if (min_max_obj.length > 1 )	
		min_max_value	=	min_max_obj[0].value;
	else
		min_max_value	=	min_max_obj.value;	
	
	min_max_array	=	min_max_value.split("|");
	min_num_value	=	min_max_array[0];
	max_num_value	=	min_max_array[1];		
	entered_value	=	numObj.value;
	if(entered_value=="") entered_value = "0";
	if(parseFloat(max_num_value)==0) return false;

	if( parseFloat(entered_value)<parseFloat(min_num_value) || parseFloat(entered_value)>parseFloat(max_num_value) )
	{
		var msg = getMessage("MIN_MAX_VALUE_RANGE","CA");
		msg=msg.replace('(1)',min_num_value);
		msg=msg.replace('(2)',max_num_value);
		alert(msg);

		numObj.select();
		numObj.focus();
		return false;
	}
}

function allowValidNumberLocal(fld, e, maxInt, deci)
{
    var count=fld.value.length;//ok
    var whichCode = (window.Event) ? e.which : e.keyCode;//ok
	var minusOccurance = fld.value.indexOf('-');
	var plusOccurance = fld.value.indexOf('+');
	if(minusOccurance != -1 || plusOccurance != -1)
	{
		maxInt++;
		fld.setAttribute("maxLength",maxInt);
	}
	else
	{
		fld.setAttribute("maxLength",maxInt);
	}
	if((whichCode == 45 && count>0) || (whichCode == 43 && count>0))
	{
		return false
	}

    if(count >= maxInt)
    {
		return false;
    }
	
	//you donot require this just var strCheck = '.0123456789' for deci > 0
	//strCheck = '0123456789' for deci=0
	      var strCheck = '.0123456789-+';

    if (parseInt(deci)==0)//For Only Nos 0 - 9
        strCheck = '0123456789-+';

    var fldvalue=fld.value;
    var whichCode = (window.Event) ? e.which : e.keyCode;
    if (whichCode == 13) return true;  // Enter
    var pointCount=0;

    for(var i=0;i<fldvalue.length;i++)
    {
        if(fldvalue.charAt(i)=='.') pointCount++;
    }

    if (pointCount>0 && whichCode == 46) return false;

    var fldValue    =   fld.value;
    var dotIndex    =   fldValue.indexOf(".");
    var fldLength   =   fldValue.length;
	var count = 0;
    if(dotIndex!=-1){
       /* if( fldLength > (parseInt(dotIndex)+parseInt(deci)) )
			return false;*/
	}


	key = String.fromCharCode(whichCode);  // Get key value from key code

	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	else if((key == "-" && fldValue.indexOf(key) != -1) || (key == "+" && fldValue.indexOf(key) != -1) )
	{
		if(fldValue.indexOf(key) != 1 )
			return false
	}
    return true;
}

function CheckMaximumLength(comp_prompt,comp_id,max_length,messageFrame)
{	
	messageFrame = messageFrameReference;
	comp_prompt	=	comp_prompt.replace("+"," ");	
	if(max_length=='' || max_length==0) return false;
	if(!(CheckMaxLen(comp_prompt,comp_id,max_length,messageFrame)))
	{
		comp_id.select();
		comp_id.focus();
		return false;
	}
}

function checkGridMatrix()
{
	//alert("checkGridMatrix");
	var i = 0;
	var grid_names = new Array();
	var final_grid_names_string = "";
	var final_rows_string = "";	
	var grid_component_ids = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_component_ids.value;
	var gridwise_details = "";
	//alert(grid_component_ids);
	if(grid_component_ids != "")
	{
		gridwise_details = grid_component_ids.split("|");
		for(i=0;i<gridwise_details.length;i++)
		{
			if(i > 0 )
			{
				final_grid_names_string += "|";
				final_rows_string += "|";
			}
			var component_wise_details = gridwise_details[i].split("~");
			var grid_name = component_wise_details[0];
			final_grid_names_string += grid_name;
			grid_names[grid_names.length] = grid_name;
			var grid_obj = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all." + grid_name);
			final_rows_string += (grid_obj.rows.length-2);
			//alert("final_rows_string" +final_rows_string);
			if(!checkMandatoryFieldsGrid(grid_name))
			{
				//alert("All the mandatory values in " + grid_name + " have not been entered...");
				return false;
			}
		}
	}

	//
	var matrix_names = parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names.value;
	
	var matrix_name_temp = matrix_names.split("|");
	if(matrix_names != "")
	{
		for(var i=0;i<matrix_name_temp.length;i++)
		{
			var matrix_mandatory_names = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_mandatory_fields_" + matrix_name_temp[i] + ".value");
			//alert("matrix_mandatory_names=" + matrix_mandatory_names);
			var component_collection = matrix_mandatory_names.split("|");
			for(var j=0;j<component_collection.length;j++)
			{
				//alert(component_collection[j]);
				if(component_collection[j] != "")
				{
					var comp_temp = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + component_collection[j]);
					if(comp_temp.type == "checkbox")
						comp_temp.value = comp_temp.checked?"Y":"";
					if(comp_temp.value == "")
					{
						//alert("All the mandatory values in " + matrix_name_temp[i] + " have not been entered...");
						return false;
					}
				}
			}
		}
	}
	
//	var HTMLval = "<input type=\"hidden\" name=\"no_of_rows\" value = \"" + final_rows_string + "\">";	
	
//alert("final_rows_string====="+final_rows_string);	
	parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.no_of_rows.value = final_rows_string;
//	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.insertAdjacentHTML('afterbegin', HTMLval);	
	
	return true;
}
function checkMandatoryFieldsGrid(grid_name)
{
	var i = 0;
	var mandatory_fields = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_" + grid_name).value;
	var mandatory_fields_array = mandatory_fields.split("|");
	//alert(mandatory_fields_array);
	if(mandatory_fields_array == "")
		return true;
	for(i=0;i<mandatory_fields_array.length;i++)
	{
		//alert(mandatory_fields_array[i]);
		if(mandatory_fields_array[i] != "")
		{
			var components = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.all." + mandatory_fields_array[i]);
			//alert(mandatory_fields_array[i] + "=" + components.length );
			if(components.length != null)
			{
				for(iii=0;iii<components.length;iii++)
				{
					//alert(iii + "=" + components[iii].value);
					if(components[iii].value == "")
						return false;				
				}
			}
			else
			{
				if(components.type == "checkbox")
					components.value = components.checked?"Y":"";
				if(components.value == "")
					return false;
			}
		}
	}	
	return true;
}
function recordTemplateDetails()
{


	//calling the function for calculating the values for formula component if any 
	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.callForLoadingFormulaResults();
	//-------------------------------------------------------------
	if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields != null)
	{
		
		var mandatory_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields.value;
		
		var mandatory_names		=	escape(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_names.value);
		mandatory_names=unescape(mandatory_names);
		var	list_item_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.list_item_fields.value;
		//alert(mandatory_fields);
		//alert(mandatory_names);
		var	fields		=	new	Array();
		var	names		=	new	Array();
		if(mandatory_fields.length>0)
		{
			var arr_mandatory_fields	=	mandatory_fields.split("|");
			var arr_mandatory_names		=	mandatory_names.split("|");

			for(var i=0; i<arr_mandatory_fields.length; i++)
			{
				//alert("arr_mandatory_fields["+i+"] : "+arr_mandatory_names[i]);
				fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]);
				names[i]	=	arr_mandatory_names[i];
			}

			if(checkFields(fields,names,messageFrameReference)==false)
			{
				settingsForMandatoryFieldsNotEntered();
				return false;
			}
		}
		//added on 1/5/2004 to take care of the mandatory fields from the paragraph
		//taking into mind that maximum of 20 paragraphs r there in the template	
		if(!checkGridMatrix())
		{
			//var temp_error =getMessage("","CA");
			var temp_error = getMessage("MANDATORY_FOR_GC","CA");
			messageFrameReference.document.location.href="../../eCA/jsp/CAError.jsp?err_num=" + temp_error;
			settingsForMandatoryFieldsNotEntered();
			return false;
		}
		for(var k=0;k<20;k++)
		{
			var str = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_para"+k);
			if(str!=null)
			{
				if(str.value!="")
				{
					var arr = str.value.split("~");
					var paraCompNames = arr[0]; //comp name and srl no (can be many saparated by |)
					var suffixToBeAttached = arr[1];//para name and para count (will be only one)
					if(paraCompNames.length>0)
					{
						var arr_mandatory_fields	=	paraCompNames.split("|");
						for(var i=0; i<arr_mandatory_fields.length; i++)
						{
							if(arr_mandatory_fields[i] != "")				
							fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]+suffixToBeAttached);
							//alert(fields[i].value);
						}

						if(checkParaFields(fields,names,messageFrameReference)==false)
						{
							settingsForMandatoryFieldsNotEntered();
							return false;

						}
					}
				}
			}
			else
			{
				break;
			}
		}
		//added for template containing the disbled components
/*		
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.target = "RecClinicalNotesSecTempControlFrame";
		//alert('submitting from recordTemplateDetails');
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesTemplateCtrl.jsp";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
		*/
	}
//	ResetTemplateToolbar();
	return true;
}

function isValidOperation(obj)
{
	//alert("obj.type : "+obj.type);
	//alert("obj.name : "+obj.name);
	if(obj.type=="checkbox")
	{
		var chkBoxObj	=	eval("document.forms[0]."+obj.name+"_chkBox");
		if(chkBoxObj.disabled == true)
		{
			window.event.returnValue = false;
			return false;
		}
	}
	else if(obj.type=="select-one")
	{

		var selectObj	=	eval("document.forms[0]."+obj.name+"_dflt");
		if(selectObj.disabled == true)
		{
			obj.value = selectObj.value;
			return false;
		}
	}
}

function checkRemoveTemplate(check)
{
	var confirmFlag;
	if(check=="Y")
		confirmFlag = true;
	else
		
	//confirmFlag = confirm(getMessage("","CA"));
	confirmFlag = confirm(getMessage("TEMP_MANDATORY",'CA'));

	if(confirmFlag)
	{
		template_mode		=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.template_mode;
		
		var Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	
		var prev_sec_hdg_code_val		= Obj.curr_sec_hdg_code.value;
		var prev_sec_content_type_val	= Obj.curr_sec_content_type.value;
		var prev_child_sec_hdg_code_val	= Obj.curr_child_sec_hdg_code.value;
		var prev_child_sec_content_type_val = Obj.curr_child_sec_content_type.value;
		var note_type						= Obj.note_type.value;

		if(template_mode!=null && template_mode.value=="Insert")
			template_mode.value	=	"RemoveTemplate";
	
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.method = "POST";
		parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.action = "../../eCA/jsp/RecClinicalNotesSectionControl.jsp?prev_sec_hdg_code="+prev_sec_hdg_code_val+"&prev_sec_content_type="+prev_sec_content_type_val+"&prev_child_sec_hdg_code="+prev_child_sec_hdg_code_val+"&prev_child_sec_content_type="+prev_child_sec_content_type_val+"&mode=sectionCancelView&note_type="+note_type;
		//parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.submit();
	}else{
		parent.frameSetIdMessage.rows='*%,0%';
	
	}
		/*		
			else 
			{
				parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.reset();
			}
	
		}
		*/
}


function showSearchResults()
{
	//if(checkPeriodFromTo()==false)
	//{
	//	return false;
	//}
	//alert("HAI##");
	var query_string		=	document.forms[0].query_string.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time		=	document.forms[0].to_date_time.value;
	var status					=	document.forms[0].status.value;
	var filter					=	document.forms[0].filter.value;
	var note_type			=	document.forms[0].note_type.value;
	var note_group			=	document.forms[0].note_group.value;
	var other_unsigned_yn		=	document.forms[0].other_unsigned_yn.value;
	//added for new text boxes.... shaiju
	var performed_by=document.forms[0].performed_by_code.value
	var med_anc=document.forms[0].med_anc_code.value
	var ref_no=document.forms[0].ref_no.value


	//alert("query_string	: "+query_string);
	query_string		+=	"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&status="+ status+"&filter="+ filter+"&note_type="+note_type +"&note_group="+note_group+"&other_unsigned_yn="+other_unsigned_yn+"&performed_by="+performed_by+"&med_anc="+med_anc+"&ref_no="+ref_no;
	parent.RecClinicalNotesSrchResultFrame.location.href = "../../eCA/jsp/RecClinicalNotesSearchResult.jsp?"+query_string;
}

/*function checkPeriodFromTo()
{
	
	var from_date_time	=	document.forms[0].from_date_time;
	var to_date_time	=	document.forms[0].to_date_time;
	if(checkIsNull(from_date_time) && checkIsNull(to_date_time) ) 
	{
		return true;
	}

	if(checkIsNull(from_date_time)==false)
	if(!doDateTimeChk(from_date_time))
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		from_date_time.select();
		from_date_time.focus();
		return false;
	}
    if(checkIsNull(to_date_time)==false)
	if(!doDateTimeChk(to_date_time)) 
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("INVALID_DATE_TIME","CA");
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(checkIsNull(to_date_time)==false)
	if(checkDateWithCurrentDate(to_date_time.value))
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("FROM_DATE_GREATER_SYSDATE","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	if(!checkIsNull(to_date_time) && !checkIsNull(from_date_time))
	if(!ValidateDateTime(from_date_time,to_date_time))
	{
		messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp?err_num="+getMessage("TO_DT_GR_EQ_FM_DT","CA");		
		to_date_time.select();
		to_date_time.focus();
		return false;
	}
	
	
	//alert("outside");
	messageFrameReference.location.href = "../../eCA/jsp/CAError.jsp";
	return true;
}*/

function dateZeroCheck(DateObj)
{

	var dateTime = DateObj.value;
	var dateArray =dateTime.split(" ");
	var date =dateArray[0].split("/");
	
	if(date[0]==0||date[1]==0||date[2]==0)
	{
		alert(getMessage("DAY_MON_YEAR_ZERO","CA"));
		DateObj.select();
		DateObj.focus();
		return false;
	}
	return true;


}


function checkPeriodFromTo(from,to,format,locale)
{	
	//var from = document.forms[0].from_date_time;
	//var to = document.forms[0].to_date_time;
	//var locale = document.forms[0].locale.value;
	var currDate = getCurrentDate(format,locale);
 	if(from.value !="")
	{
		if(!validDateObj(from,format,locale))
		{
			//alert(getMessage("INVALID_DATE_TIME","CA"));
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
		if(!isBeforeNow(from.value,"DMYHM",locale))
		{
			alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
	}

	if(to.value !="")
	{
		if(!validDateObj(to,format,locale))
		{
			//alert(getMessage("INVALID_DATE_TIME","CA"));
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
		if(!dateZeroCheck(to))
		{
			return false;
		}
		if(!isBeforeNow(to.value,"DMYHM",locale))
		{
			alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"));
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
		
	}

	if(from.value !="" && to.value !="" )
	{
		if(!isBetween(from.value,currDate,to.value,"DMYHM",locale))
		{	
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
	}
	return true;
}

function checkFields( fields, names, messageFrame) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{		
		if (fields[i] != undefined && fields[i] != null)
		{
			if(trimCheck(fields[i].value)) 
			{
				fields[i].value = trimString(fields[i].value);
			}
			else
			{				
				errors = errors +getMessage("CAN_NOT_BE_BLANK","COMMON")+"<br>";
				errors=errors.replace('$',names[i] );				
			}
		}		
 	}
	if ( errors.length != 0 ) 
	{
		messageFrame.document.location.href="../../eCA/jsp/CAError.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}
function checkParaFields( fields, names, messageFrame) 
{
	var errors = "" ;
	for( var i=0; i<fields.length; i++ ) 
	{
		if (fields[i] != undefined && fields[i] != null)
		{
			if(trimCheck(fields[i].value)) 
			{
				fields[i].value = trimString(fields[i].value);
			}
			else
			{			
				errors = "APP-000001 Enter all mandatory fields";
				break;
			}
		}
	}
	if ( errors.length != 0 ) 
	{
		messageFrame.document.location.href="../../eCA/jsp/CAError.jsp?err_num="+errors ;
		return false ;
	}
	return true ;
}

function changeEditorTitle(editor_title,image_linked_yn)
{	
	parent.EditorTitleFrame.location.href = "../../eCA/jsp/RecClinicalNotesEditorTitle.jsp?editor_title="+encodeURIComponent(editor_title,"UTF-8")+"&image_linked_yn="+image_linked_yn;
}


/**
  * included for avoiding script error in exceptional cases by arul on 12th November 2002
  */
//function returnData(){}

//when called from discharged summary
//include note_status in parameters for [IN033511]
//IN036899 Start.
//function callMeOnClickSearchResultDis(facility_id, note_type, accession_num, performed_by_id, operations_allowed, amendment_type, privilege_type,tblrow_id,service_code,authorised_by,modified_by,doc_linked_note_yn,sec_count,speciality_code,res_encounter_id,status_display_text,note_status)
//function callMeOnClickSearchResultDis(facility_id, note_type, accession_num, performed_by_id, operations_allowed, amendment_type, privilege_type,tblrow_id,service_code,authorised_by,modified_by,doc_linked_note_yn,sec_count,speciality_code,res_encounter_id,status_display_text,note_status,appl_task_id,function_id)
//CIS-CA-1490 Start
function callMeOnClickSearchResultDis(facility_id, note_type, accession_num, performed_by_id, operations_allowed, amendment_type, privilege_type,tblrow_id,service_code,authorised_by,modified_by,doc_linked_note_yn,sec_count,speciality_code,res_encounter_id,status_display_text,note_status,appl_task_id,function_id,p_called_from)
//CIS-CA-1490 End
//IN036899 End.
{	
	changeRowColor(tblrow_id,9,1,"");		
	//IN037701 Starts
	var query_string_spc = "";
	var p_called_from = "";
	if(document.getElementById("p_called_from"))
		p_called_from = document.getElementById("p_called_from").value;
    if(document.getElementById("p_notes_view"))
		var p_notes_view = document.getElementById("p_notes_view").value;
	//var query_string = document.forms[0].query_string.value;
	var query_string = "";
	if(undefined!= document.forms[0].query_string){
		query_string = document.forms[0].query_string.value;
	}else{
		query_string = document.getElementById("query_string").value;
		 query_string_spc = query_string;
	}
	//IN037701 Ends
	
	var retArray		=	new Array();
	var dialogHeight	=	"37.5" ;
	var dialogWidth		=	"50" ;
	var status			=	"no";
	var arguments		=	"" ;
	var visit_adm_date	=	"";
	var dischargeDateTime	=	"";
	var performed_by_name	="";
	var location_name	=	"";
	var event_date_time	=	"";
	var title	=	"";
	var location_code	=	"";
	var attending_practitioner	=	"";
	var performed_by_desc	=	"";
	var speciality_code1	=	"";
	var specialty_name	=	"";
	var action_url		=	'../../eCA/jsp/RecClinicalNotesSearchMain.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	action_url			+=	"?facility_id="+facility_id+"&note_type="+note_type+"&accession_num="+accession_num+"&performed_by_id="+performed_by_id+"&operations_allowed="+operations_allowed+"&service_code="+service_code+"&doc_linked_note_yn="+doc_linked_note_yn+"&sec_count="+sec_count+"&speciality_code="+speciality_code+"&res_encounter_id="+res_encounter_id+"&status_display_text="+status_display_text+"&note_status="+note_status;
	action_url			+=	"&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&authority="+authorised_by+"&modified_by="+modified_by+"&"+query_string;
	//IN049625 Start. 	
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr += " accession_num=\"" + accession_num + "\" ";
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesReBuildIntermediate.jsp?"+query_string, false ) ;
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
	//IN049625 End.
	retArray			=	window.showModalDialog(action_url,arguments,features);
	if(retArray==null) retArray = "";
	var operation_mode="";
	if(!(retArray==null))
	{
		if ( retArray.length > 0 )
		{				
			var note_type		=	retArray[0];
			var accession_num	=	retArray[1];
			operation_mode	=	retArray[2];		
			
			if (operation_mode == "Update")
			{	
				visit_adm_date	=	retArray[4];
				dischargeDateTime	=	retArray[5];
				performed_by_name	=	retArray[6];
				location_name	=	retArray[7];
				event_date_time	=	retArray[8];
				title	=	retArray[9];
				location_code	=	retArray[10];
				attending_practitioner	=	retArray[11];
				performed_by_desc	=	retArray[12];
				specialty_name	=	retArray[13];
				speciality_code1	=	retArray[14];

			}else if ((operation_mode == "ModifySection")||(operation_mode == "ModifyAddendum"))
			{
				visit_adm_date	=	retArray[4];
				dischargeDateTime	=	retArray[5];
				performed_by_name	=	retArray[6];
				location_name	=	retArray[7];
				event_date_time	=	retArray[8];
				title	=	retArray[9];
				location_code	=	retArray[10];
				attending_practitioner	=	retArray[11];
				performed_by_desc	=	retArray[12];
				specialty_name	=	retArray[13];
				speciality_code1	=	retArray[14];
			}
// Array(note_type,accession_num,operation_mode,sec_count,visit_adm_date,dischargeDateTime,performed_by_name,locationDesc,event_date_time,title);
			/*var patient_line		=	document.forms[0].patient_line.value;
			var performed_by_name	=	document.forms[0].performed_by_name.value;
			var visit_adm_date		=	document.forms[0].visit_adm_date.value;
			var specialty_name		=	document.forms[0].specialty_name.value;
			var function_id			=	document.forms[0].function_id.value;
			var episode_type		=	document.forms[0].episode_type.value;
			var title				=	document.forms[0].note_header_desc.value;
			var lastModifiedBy		=	document.forms[0].lastModifiedBy.value;
			var encounter_id		=	document.forms[0].encounter_id.value;
			var patient_id			=	document.forms[0].patient_id.value;
			var patient_name		=	document.forms[0].patient_name.value;
			var patient_age			=	document.forms[0].patient_age.value;
			var patient_sex			=	document.forms[0].patient_sex.value;
			var locationDesc		=	document.forms[0].locationDesc.value;
			var patient_class		=	document.forms[0].patient_class.value;
			var event_date_time		=	document.forms[0].event_date_time.value;
			var dischargeDateTime	=	document.forms[0].dischargeDateTime.value;
			var printDateTime		=	document.forms[0].printDateTime.value; */
		//	var note_type			=	document.forms[0].note_type.value;

			query_string += "&note_type="+note_type+"&accession_num="+accession_num+"&operation_mode="+operation_mode; 
			query_string += "&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&service_code="+service_code+"&authority="+authorised_by+"&modified_by="+modified_by+"&doc_linked_note_yn="+doc_linked_note_yn+"&sec_count="+sec_count+"&rec_flag='N'";
			
			query_string += "&visit_adm_date="+visit_adm_date+"&dischargeDateTime="+dischargeDateTime+"&performed_by_pract="+performed_by_name+"&location_desc="+location_name+"&performed_date="+event_date_time+"&attending_practitioner="+attending_practitioner+"&location_code="+location_code+"&performed_by_pract="+performed_by_desc+"&speciality_name="+specialty_name+"&speciality_code="+speciality_code;
			
	
			if((operation_mode != "Update" || operation_mode != "ModifySection") && retArray[4] != null)				
				/*********MODIFIED BY Deepa on 10/1/2009 at 11:34 AM for IN014963 ********************/
					//query_string += "&action_comment=" + escape(retArray[4]);
					query_string += "&action_comment=" + encodeURIComponent(retArray[retArray.length-1],"UTF-8");
				/****************************************************************************/
//			parent.parent.RecClinicalNotesTabsFrame.document.getElementById("img_rcnSearch").src = '../../eCA/images/Search_click.gif';
//			parent.parent.RecClinicalNotesTabsFrame.document.getElementById("img_rcnAdd").src = '../../eCA/images/Add.gif';
			//IN037701 Starts
			//parent.parent.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;
			if(!"CA_SPC" == p_called_from)
			{
				parent.parent.RecClinicalNotesFrame.location.href = '../../eCA/jsp/RecClinicalNotesMain.jsp?'+query_string;
			}
			else
			{	
				query_string = query_string_spc+"&note_type="+note_type+"&accession_num="+accession_num+"&operation_mode="+operation_mode+"&p_soc_his=&p_called_from=CA_SPC&called_from=CA_SPC&p_notes_view="+p_notes_view;
				query_string += "&amendment_type="+amendment_type+"&privilege_type="+privilege_type+"&service_code="+service_code+"&authority="+authorised_by+"&modified_by="+modified_by+"&doc_linked_note_yn="+doc_linked_note_yn+"&sec_count="+sec_count+"&rec_flag='N'";
				var action_url1 ="../../eCA/jsp/RecClinicalNotesMain.jsp?"+query_string;
				var title1 = "";
				var dialogHeight	= "39" ;
				var dialogWidth		= "60" ;
				var status			= "no";
				var scroll			= "no";
				var dialogTop		= "100";
				var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
				window.showModalDialog(action_url1, title1, features);
			}
			//IN037701 Ends
			
		} // end of if ( retArray.length > 0 )
	} // end of if(!(retArray==null))
	//IN036899 Start.
	//window.location.reload();
	//if(function_id=="SPCL_NOTE" && appl_task_id=="OT_NOTES" && operation_mode==""){CIS-CA-1490
	//if((function_id=="SPCL_NOTE" && appl_task_id=="OT_NOTES" && operation_mode=="") || ("CA_CLINICIAN_WIDGET"==p_called_from || "CA_REFFERAL_WIDGET"==p_called_from && operation_mode=="")){//CIS-CA-1490//INO38029
	if((function_id=="SPCL_NOTE" && appl_task_id=="OT_NOTES" && operation_mode=="") || ("CA_CLINICIAN_WIDGET"==p_called_from && operation_mode=="" ) || ("CA_REFFERAL_WIDGET"==p_called_from && operation_mode=="")){//CIS-CA-1490//INO38029
		window.close();
	}else{
	 // IN047878 Start.
	 //window.location.reload();
	 window.location.href = window.location.href;
	 // IN047878 End.
	}
	//IN036899 End.
}
function showErrorRemarks(acc_no,facility_id)
{
	var dialogHeight	=	"8" ;
	var dialogWidth		=	"30" ;
	var status			=	"no";
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesShowErrorRemarks.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	//returnArray		=	window.open(action_url,arguments,features);
	action_url			+=	"?accession_num="+acc_no+"&facility_id="+facility_id;
	returnArray			=	window.showModalDialog(action_url,arguments,features);
}

function showCalendarValidate(str){
	var flg = showCalendar(str,null,'hh:mm');
	eval("document.all."+str+".focus();");
	return flg;
}

function templateCalendarValidate(str,chkYN)
{
	  
	var obj_name = "";
	if(str.indexOf("(") != -1)
	{
		obj_name = str.substring(0, str.indexOf("("));
		
	}
	else
		obj_name = str;	
	

	if(eval("document.all." + obj_name + ".length") == null)
		str = obj_name;

	var flg = "";
	if(chkYN == "N"){
		flg = showCalendar(str);
	}else if(chkYN == "Y"){
		flg = showCalendar(str,null,'hh:mm');
	}

	if(!document.getElementById("CACalanderFun"))
		eval("document.all."+str+".focus();");

	  return flg;
	
}
function checkDateWithCurrentDate(toDateTime)
{
	var toDate = toDateTime.split(" ");
	var toarray = toDate[0].split("/");
	var enteredDate = new Date(toarray[2],toarray[1],toarray[0]);

	var today = new Date();
	var date= today.getDate();
	var month = today.getMonth() + 1;
	var year = today.getYear();
	today = new Date(year,month,date);
	if(enteredDate > today)
	{
		return true;
	}
	return false;
}

function callMeOnLoad()
{	
	
	operation_mode	=	document.forms[0].operation_mode.value;
	
	if(operation_mode!="Update" && operation_mode!="ModifySection" )
	{
		
		//if(document.forms[0].note_type.length == 2 || document.forms[0].note_type.length == 1)
		if(document.forms[0].note_type.length == 1)
			setTimeout("callNoteSectionRoutine();",500);
	}

	if(operation_mode == "ModifyAddendum")
	{
		if(parent.RecClinicalNotesToolbarFrame.document.forms[0])
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].sign,true);

		if(parent.RecClinicalNotesToolbarFrame.document.forms[0])
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].btn_Print,true);
	}

	if(operation_mode == "ModifySection")
	{		
		if(parent.RecClinicalNotesToolbarFrame.document.forms[0] && parent.RecClinicalNotesToolbarFrame.document.forms[0].record) 			
			setToolBarButtons(parent.RecClinicalNotesToolbarFrame.document.forms[0].record,false);
		
	} 

}

function makeActive(operationMode)
{
	if(operationMode=="ModifyAddendum"){
		document.getElementById("notes_view").style.color = 'BLUE';				
	}
	else{
		document.getElementById("notes_view").style.color = 'WHITE';				
	}
}

function compressSectionFrames()
{	
	
	if(parent.RecClinicalNotesSecDetailsFrame.location.href.indexOf("/blank.html")==-1)
	{			
		parent.frameSetIdSection.cols='4%,96%,0%';
		
		parent.RecClinicalNotesSectionFrame.document.getElementById("tb1").style.display="none";
		parent.RecClinicalNotesSectionFrame.document.getElementById("tbl_section").style.display="none";
		parent.RecClinicalNotesSectionFrame.document.getElementById("sectionLineTable").style.display="inline";
		//checking in case of Addendum -----increasing the width of the textarea
		if(parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm!=null)
		{
//[IN032064]			parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.cols="105";
		}
		if( (parent.RecClinicalNotesSecDetailsEditorFrame)!=null && (parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame)!=null && (parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0)!=null) {
			parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerHTML=removeHyperLink(parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0);
		}
	}
}

//Functions for the file name RecClinicalNotesSection.jsp-end



//Functions for the file name RecClinicalNotesEditorTitle.jsp-start

var viewShown = "";
function arrangeView(obj)
{
	if(obj.value == getLabel("eCA.ShowImage.label","Ca"))
	{
		parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor.cols = "0%,100%";

		obj.value = getLabel("eCA.ShowEditor.label","CA");
		viewShown = 'Image';
	}
	else if(obj.value == getLabel("eCA.ShowEditor.label","CA"))
	{
		parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor.cols = "100%,0%";
		obj.value = getLabel("eCA.ShowImage.label","Ca");
		viewShown = 'Editor';
	}
	document.RecClinicalNotesEditorTitleForm.button2.value = getLabel("eCA.ShowBoth.label","Ca");
}
function arrageForViewingBoth(obj)
{
	document.RecClinicalNotesEditorTitleForm.button1.value = getLabel("eCA.ShowEditor.label","CA");
	document.RecClinicalNotesEditorTitleForm.button2.value =getLabel("eCA.ShowImage.label","Ca");

	if(viewShown != 'Both')
	{
		parent.RecClinicalNotesSecDetailsFrame.frameSetIDPainterEditor.cols = "50%,50%";
		viewShown = 'Both';
	}
	else
		arrangeView(obj);
}

//Functions for the file name RecClinicalNotesEditorTitle.jsp-end


//Functions for the file name RecClinicalNotesLink.jsp-start

function returnData()
{
	//to put some value in the clipboard
	if(document.forms[0].select!=null)
	{
		var clipBoardVal=document.forms[0].select.createTextRange();

		clipBoardVal.select();
		clipBoardVal.execCommand("copy","","");
		//document.RecClinicalNotesHeaderForm.body.focus();
	}
	//ends here	
	var datecount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalDateCount.value;
	var hist_rec_type = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].hist_rec_type.value;
	//alert(hist_rec_type);
	if((hist_rec_type=="DIAG")||(hist_rec_type=="MEDN"))
	{
		var returnValue = "";
		var eventcount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalEventCount.value;
		for(var i=0;i<eventcount;i++)
		{
			var d = eval("parent.RecClinicalNotesLinkDocsFrame.document.forms[0].checkBoxEventCode_"+i+"");

			if(d.checked == true)
			{
				returnValue	+=	trimString( (eval("parent.RecClinicalNotesLinkDocsFrame.document.getElementById("tblrow_id")"+i).cells(0).innerText))+"\n";
			}
		}
		//alert(returnValue);
		parent.window.returnValue=returnValue;
		parent.window.close();
		return;
	}
	else
	{
		var datecount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalDateCount.value;
		var eventclasscount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalEventClassCount.value;
		var eventgroupcount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalEventGroupCount.value;
		var eventcount = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].totalEventCount.value;
		var datevalues = '';
		var eventclassvalues = '';
		var eventgroupvalues = '';
		var eventvalues = '';
		var accnum = '';
		var data_type_values = "";
		var datatypes				=	"";
		var contr_sys_ids			=	"";
		var contr_sys_event_codes	=	"";
		//added on 12/10/2003 for reducing the time taken by the for loop if the data is huge
		var selected_events = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].selected_events.value;
		var splitted_events_names = selected_events.split("~");
		for(var i=0;i<splitted_events_names.length-1;i++)
		{
			var d = eval("parent.RecClinicalNotesLinkDocsFrame.document.forms[0]."+splitted_events_names[i]);
			if(d.checked == true)
			{
				var vals = d.value;
				var arr = vals.split("~");
				var accessionnum			=	arr[0]==null?"":arr[0];
				var datatype				=	arr[1]==null?"":arr[1];
				var contr_sys_id			=	arr[3]==null?"":arr[3];
				var contr_sys_event_code	=	arr[4]==null?"":arr[4];

				datatypes					+=	datatype+"','";
				accnum						+=	accessionnum+"','";
				contr_sys_ids				+=	contr_sys_id+"','";
				contr_sys_event_codes		+=	contr_sys_event_code+"','";
			}
		}
		accnum					=	accnum.substring(0,accnum.lastIndexOf(",")-1);
		datatypes				=	datatypes.substring(0,datatypes.lastIndexOf(",")-1);
		contr_sys_ids			=	contr_sys_ids.substring(0,contr_sys_ids.lastIndexOf(",")-1);
		contr_sys_event_codes	=	contr_sys_event_codes.substring(0,contr_sys_event_codes.lastIndexOf(",")-1);

		//alert("datatypes : "+datatypes);
		//alert("accnum : "+accnum);
		//alert("contr_sys_ids : "+contr_sys_ids);
		//alert("contr_sys_event_codes : "+contr_sys_event_codes);

		var patientid = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].patient_id.value;
		var histtype = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].hist_rec_type.value;
		//var datatype = parent.RecClinicalNotesLinkDocsFrame.document.forms[0].data_type.value;
		//alert("data_type : "+datatype);
		document.forms[0].hist_type.value=histtype;
		document.forms[0].accession_num.value=escape(accnum);
		document.forms[0].from.value='CN';
		document.forms[0].data_type.value=escape(datatypes);
		document.forms[0].contr_sys_id.value=escape(contr_sys_ids);
		document.forms[0].contr_sys_event_code.value=escape(contr_sys_event_codes);
		//parent.RecClinicalNotesLinkDocsViewFrame.location.href = "../../eCA/jsp/EncountersDocDisplay.jsp?hist_type="+histtype+"&accession_num="+escape(accnum)+"&from=CN&data_type="+datatypes+"&contr_sys_id="+contr_sys_ids+"&contr_sys_event_code="+contr_sys_event_codes;
		document.RecClinicalNotesLinkForm.submit();
	}
}

//Functions for the file name RecClinicalNotesLink.jsp-end



//Functions for the file name RecClinicalNotesPrevNotesSearchCriteria.jsp -start


function showSearchData()
{
	//if(checkPeriodFromTo()==false)
	//{
	//	return false;
	//}
	var query_string	=	document.forms[0].query_string.value;
	var from_date_time	=	document.forms[0].from_date_time.value;
	var to_date_time	=	document.forms[0].to_date_time.value;
	var status			=	document.forms[0].status.value;
	var note_type		=	document.forms[0].note_type.value;
	var note_group		=	document.forms[0].note_group.value;
	//alert("from_date_time	: "+from_date_time);
	//alert("to_date_time	: "+to_date_time);
	//query_string = query_string.replace("&note_type=","&f=");
	query_string = query_string.replace(/&note_type/g,"&f=");
	query_string = query_string.replace(/&from_date_time/g,"&f=");
	query_string = query_string.replace(/&to_date_time/g,"&f=");
	query_string = query_string.replace(/&status/g,"&f=");
	
	query_string		+=	"&from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&status="+status+"&note_type="+note_type+"&note_group="+note_group;
	
	parent.RecClinicalNotesPrevNotesSearchDetailFrame.location.href = "../../eCA/jsp/RecClinicalNotesPrevNotesSearchDetail.jsp?"+query_string;
	parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href = "../../eCA/jsp/blank.jsp";

}
function switchToNote()
{
	top.opener.top.focus()
}


//Functions for the file name RecClinicalNotesPrevNotesSearchCriteria.jsp -end

//Functions for the file name RecClinicalNotesCannedText.jsp -start

async function showLongDesc(text_blk_name)
{	
   //var long_desc=eval("document.all."+text_blk_name+".innerText");
   //[IN033180] var long_desc=eval("document.all."+text_blk_name+".innerText");
   var long_desc=eval("document.all."+text_blk_name+".innerHTML"); //[IN033180]
   //alert(long_desc)
   if(long_desc!='' && long_desc!=null)
   {
	var dialogHeight1 ='20' ;
	var dialogWidth = '45' ;
	var features = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	var arguments;
		arguments = long_desc;
	retVal = await window.showModalDialog('../../eCA/jsp/RecClinicalNotesCannedTextViewDescMain.jsp?title_name=Description',arguments,features);	
	
   }
}
//[IN033786] Start
async function showLongDesc_new(textType,text_blk_id,locale,service_code,login_user_id,note_type,sec_hdg_code)
{	  
	var dialogHeight1 ='20' ;
	var dialogWidth = '45' ;
	var features = 'dialogHeight:' + dialogHeight1 + '; dialogWidth:' + dialogWidth +'; scroll=auto; status=no';
	var query_string="&textType="+textType+"&text_blk_id="+text_blk_id+"&locale="+locale+"&service_code="+service_code+"&login_user_id="+login_user_id+"&note_type="+note_type+"&sec_hdg_code="+sec_hdg_code;
	var arguments="";
		
	retVal = await window.showModalDialog('../../eCA/jsp/RecClinicalNotesCannedTextViewDescMain.jsp?title_name=Description'+query_string,arguments,features);	

}
//[IN033786] End
//Functions for the file name RecClinicalNotesCannedText.jsp -end
//Functions for the file name RecClinicalNotesTabs.jsp -start

function showClinicalNotesInModal()
{
	var retVal			=	"";
	var dialogTop		=	"80" ;
	var dialogHeight	=	"30" ;
	var dialogWidth		=	"80" ;
	var arguments		=	"" ;
	var action_url		=	'../../eCA/jsp/RecClinicalNotesModal.jsp';
	var features		=	"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:no;";
	var operation_mode	=	document.forms[0].operation_mode.value;
	var function_id		=	document.forms[0].function_id.value;
	var query_string	=	document.forms[0].query_string.value;
	action_url			+=	"?operation_mode="+operation_mode+"&function_id="+function_id;
	action_url			+=	"&"+query_string;
	//alert(query_string);
	retVal				=	window.showModalDialog(action_url,arguments,features);
}

//Functions for the file name RecClinicalNotesTabs.jsp -end

function populateNoteTypesForGroup(note_group_obj, patient_class,call_from)
{
	var note_type_obj	= "";
	var appl_task_id		= "";
	var filter_by		= "";
	var speciality_list = "";
	if (call_from == 'Header')
	{	
		var note_type_obj	= document.RecClinicalNotesHeaderForm.note_type;
		var appl_task_id		= document.RecClinicalNotesHeaderForm.appl_task_id.value;
		var filter_by		= document.RecClinicalNotesHeaderForm.filter_by.value;
		var speciality_list		= document.RecClinicalNotesHeaderForm.speciality_list.value;
		var p_event_class_widget		= document.RecClinicalNotesHeaderForm.p_event_class_widget.value;//IN037701
	}else if (call_from == 'Prev_Notes')
	{
		var note_type_obj	= document.RecClinicalNotesPrevNotesCriteriaForm.note_type;
		var appl_task_id		= document.RecClinicalNotesPrevNotesCriteriaForm.appl_task_id.value;				
	}
		var len = note_type_obj.options.length;
	for(var i=0;i<len-1;i++)
		note_type_obj.options.remove(1);
	var note_group = note_group_obj.value;
	//alert(note_group );
	var action_url = "../../eCA/jsp/RecClinicalNotesPopulateNoteGroup.jsp";
	var HTMLVal="<html><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()'><form name='RecClinicalNotesNoteGroupForm' id='RecClinicalNotesNoteGroupForm' method='get' action='"+action_url+"'>"+
	"<input type='hidden' name='note_group' id='note_group' value='"+note_group+"'>"+
	"<input type='hidden' name='patient_class' id='patient_class' value='" + patient_class + "'>"+		
	"<input type='hidden' name='appl_task_id' id='appl_task_id' value='" + appl_task_id + "'>"+		
	"<input type='hidden' name='filter_by' id='filter_by' value='" + filter_by + "'>"+		
	"<input type='hidden' name='speciality_list' id='speciality_list' value='" + speciality_list + "'>"+		
	"<input type='hidden' name='call_from' id='call_from' value='" + call_from + "'>"+		
	"<input type='hidden' name='p_event_class_widget' id='p_event_class_widget' value='" + 	p_event_class_widget + "'>"+
	"</form></body></html>";//IN037701
	messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
	messageFrameReference.document.RecClinicalNotesNoteGroupForm.submit();
}
//this function is called from the template. dont delete this function thinking that it has not been called form any of the JSPs. 
//deleting this function will not help in liking standard values to the template components.
function callMeForStandardLinking()
{	 
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		var patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		var speciality_code = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_code.value;
		if(patient_id != "")
		{
			/* added  on 5/10/05 for matrix component for linking the standard components */

				var matrix_std_values = "";
				var matrix_std_component_information = "";
				
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names!=null)
			{
				var matrix_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names.value;
	
				var matrix_std_values = "";
				var matrix_std_component_information = "";
				var matrix_name_temp = matrix_names.split("|");

				if(matrix_names != "")
				{
					for(var i=0;i<matrix_name_temp.length;i++)
					{
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i])!=null)
						{
							matrix_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i] + ".value");

							if(matrix_std_component_information == "")
								matrix_std_component_information = matrix_std_values;
							else
								matrix_std_component_information += "~"+matrix_std_values;
						}
					}
				}
			}
			// ends here
			
			// added on 06/10/05 for Grid Component for linking the standard cmponent

			var grid_std_values = "";
			var grid_std_component_information = "";
			
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names!=null)
			{
			var grid_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names.value;

			var grid_name_temp = grid_names.split("|");
			
			if(grid_names != "")
				{
					for(var i=0;i<grid_name_temp.length;i++)
					{
							
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i])!=null)
						{
							grid_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i]+".value");
							
							if(grid_std_component_information == "")
								grid_std_component_information = grid_std_values;
							else
								grid_std_component_information += "~"+grid_std_values;
						}
					}
				}
			}
			// ends here

			//shaiju chg starts 
			var emb_std_values = "";
			var emb_std_component_information ="";
			
			
			//new
			
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.paragraph_names!=null)
			{
				var paragraph_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.paragraph_names.value;

				var paragraph_names_temp = paragraph_names.split("|");
			
				if(paragraph_names != "")
				{
					for(var i=0;i<paragraph_names_temp.length;i++)
					{
							
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i])!=null && eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i]+".value")!= "" ) 
						
						{
							
							emb_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i]+".value");
							
							var emb_std_values_tmp = emb_std_values.split("~");
								for (var q=0;q<emb_std_values_tmp.length;++q )
								{
									if(emb_std_component_information == "")
											emb_std_component_information = emb_std_values_tmp[q]+paragraph_names_temp[i];
									else
											emb_std_component_information += "~"+emb_std_values_tmp[q]+paragraph_names_temp[i];

								}
							
						}
					}
				}
			}
			
			
			var std_component_information = document.RecClinicalNotesTemplateForm.std_component_information.value;
			
				
			if(std_component_information != ""){
				if(emb_std_component_information!="")
					std_component_information += "~"+ emb_std_component_information ;
				
				if(matrix_std_component_information!="")
					std_component_information += "~"+ matrix_std_component_information ;
				if(grid_std_component_information!="")
					std_component_information += "~" + grid_std_component_information;
				//else
						//std_component_information += grid_std_component_information;
			}
			else{
				
				if(emb_std_component_information!="")
					std_component_information += emb_std_component_information ;
				
				if(matrix_std_component_information!="")
					if(std_component_information != "")
							std_component_information += "~"+ matrix_std_component_information ;
					else {
						std_component_information += matrix_std_component_information ;
						}
				if(grid_std_component_information!="")

					if(std_component_information != "")
							std_component_information += "~" + grid_std_component_information;
					else {
						std_component_information +=  grid_std_component_information;
						}


				/*
				
				std_component_information = matrix_std_component_information;

				if(matrix_std_component_information!="" && grid_std_component_information!="")
					std_component_information += "~" +grid_std_component_information;
				else
					std_component_information += grid_std_component_information;

				if(std_component_information==""){std_component_information=emb_std_component_information ;}
			*/
			}
			
			var action_url = '../../eCA/jsp/RecClinicalNotesStdCompLinking.jsp?std_component_information=' + escape(std_component_information) + "&patient_id=" + patient_id+"&encounter_id="+encounter_id+'&speciality_code='+speciality_code;	
			messageFrameReference.document.location = action_url;
			//alert("action_url"+action_url);
		}
	}
}
//IN052359 Start.
function callMeForStandardLinking_New(rowId)
{	
	if(parent.parent.RecClinicalNotesHeaderFrame != null)
	{
		var patient_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;
		var encounter_id = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		var speciality_code = parent.parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.speciality_code.value;
		if(patient_id != "")
		{			
				var matrix_std_values = "";
				var matrix_std_component_information = "";
				
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names!=null)
			{
				var matrix_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_names.value;
	
				var matrix_std_values = "";
				var matrix_std_component_information = "";
				var matrix_name_temp = matrix_names.split("|");

				if(matrix_names != "")
				{
					for(var i=0;i<matrix_name_temp.length;i++)
					{
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i])!=null)
						{
							matrix_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.matrix_std_component_information_"+matrix_name_temp[i] + ".value");

							if(matrix_std_component_information == "")
								matrix_std_component_information = matrix_std_values;
							else
								matrix_std_component_information += "~"+matrix_std_values;
						}
					}
				}
			}			
			var grid_std_values = "";
			var grid_std_component_information = "";
			
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names!=null)
			{
			var grid_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_names.value;

			var grid_name_temp = grid_names.split("|");
			
			if(grid_names != "")
				{
					for(var i=0;i<grid_name_temp.length;i++)
					{
							
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i])!=null)
						{
							grid_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.grid_std_component_information_"+grid_name_temp[i]+".value");
							
							if(grid_std_component_information == "")
								grid_std_component_information = grid_std_values;
							else
								grid_std_component_information += "~"+grid_std_values;
						}
					}
				}
			}
			
			var emb_std_values = "";
			var emb_std_component_information ="";
			
			
			if(parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.paragraph_names!=null)
			{
				var paragraph_names = parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.paragraph_names.value;

				var paragraph_names_temp = paragraph_names.split("|");
			
				if(paragraph_names != "")
				{
					for(var i=0;i<paragraph_names_temp.length;i++)
					{
							
						if(eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i])!=null && eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i]+".value")!= "" ) 
						
						{
							
							emb_std_values = eval("parent.parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.para_std_component_information"+paragraph_names_temp[i]+".value");
							
							var emb_std_values_tmp = emb_std_values.split("~");
								for (var q=0;q<emb_std_values_tmp.length;++q )
								{
									if(emb_std_component_information == "")
											emb_std_component_information = emb_std_values_tmp[q]+paragraph_names_temp[i];
									else
											emb_std_component_information += "~"+emb_std_values_tmp[q]+paragraph_names_temp[i];

								}
							
						}
					}
				}
			}
			
			
			var std_component_information = document.RecClinicalNotesTemplateForm.std_component_information.value;
			
				
			if(std_component_information != ""){
				if(emb_std_component_information!="")
					std_component_information += "~"+ emb_std_component_information ;
				
				if(matrix_std_component_information!="")
					std_component_information += "~"+ matrix_std_component_information ;
				if(grid_std_component_information!="")
					std_component_information += "~" + grid_std_component_information;
				
			}
			else{
				
				if(emb_std_component_information!="")
					std_component_information += emb_std_component_information ;
				
				if(matrix_std_component_information!="")
					if(std_component_information != "")
							std_component_information += "~"+ matrix_std_component_information ;
					else {
						std_component_information += matrix_std_component_information ;
						}
				if(grid_std_component_information!="")

					if(std_component_information != "")
							std_component_information += "~" + grid_std_component_information;
					else {
						std_component_information +=  grid_std_component_information;
						}				
			}
			var action_url = '../../eCA/jsp/RecClinicalNotesStdCompLinking.jsp?std_component_information=' + escape(std_component_information) + "&patient_id=" + patient_id+"&encounter_id="+encounter_id+'&speciality_code='+speciality_code+'&rowId='+rowId+'&flag=addrow';	
			messageFrameReference.document.location = action_url;
			
		}
	}
}
//IN052359 End.
function recordTemplateDetailsforBypassingTempCtrl()
{
	//calling the function for calculating the values for formula component if any 
	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.callForLoadingFormulaResults();
	//-------------------------------------------------------------
	if(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields != null)
	{
		var mandatory_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields.value;
		var mandatory_names		=	escape(parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_names.value);
		mandatory_names=unescape(mandatory_names);
		var	list_item_fields	=	parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.list_item_fields.value;
		//alert(mandatory_fields);
		//alert(mandatory_names);
		var	fields		=	new	Array();
		var	names		=	new	Array();
		if(mandatory_fields.length>0)
		{
			var arr_mandatory_fields	=	mandatory_fields.split("|");
			var arr_mandatory_names		=	mandatory_names.split("|");

			for(var i=0; i<arr_mandatory_fields.length; i++)
			{
				//alert("arr_mandatory_fields["+i+"] : "+arr_mandatory_names[i]);
				fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]);
				names[i]	=	arr_mandatory_names[i];
			}

			if(checkFields(fields,names,messageFrameReference)==false)
			{
				return false;
			}
		}
		//added on 1/5/2004 to take care of the mandatory fields from the paragraph
		//taking into mind that maximum of 20 paragraphs r there in the template	
		if(!checkGridMatrix())
		{
			//var temp_error =getMessage("","CA");
			var temp_error = getMessage("MANDATORY_FOR_GC","CA");
			messageFrameReference.document.location.href="../../eCA/jsp/CAError.jsp?err_num=" + temp_error;
			return false;
		}
		for(var k=0;k<20;k++)
		{
			var str = eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.mandatory_fields_para"+k);
			if(str!=null)
			{
				if(str.value!="")
				{
					var arr = str.value.split("~");
					var paraCompNames = arr[0]; //comp name and srl no (can be many saparated by |)
					var suffixToBeAttached = arr[1];//para name and para count (will be only one)
					if(paraCompNames.length>0)
					{
						var arr_mandatory_fields	=	paraCompNames.split("|");
						for(var i=0; i<arr_mandatory_fields.length; i++)
						{
							if(arr_mandatory_fields[i] != "")				
							fields[i]	=	eval("parent.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm."+arr_mandatory_fields[i]+suffixToBeAttached);
							//alert(fields[i].value);
						}

						if(checkParaFields(fields,names,messageFrameReference)==false)
							return false;
					}
				}
			}
			else{
				break;
			}
		}
	}
	return true;
}


function getConfirmation()
{
	//var ConfirmFlag =  confirm(getMessage("","CA"));
	var ConfirmFlag =  confirm(getMessage("OPRN_NOT_PRESERVE_VALUE",'CA'));

	if(ConfirmFlag)
	{
		setBlankFile();
		ResetTemplateToolbar();
	}
	
	return;
}

// Only for Pritn Preview
function changeEditorTitleForPrev(editor_title)
{	
	var operation_mode = opener.parent.RecClinicalNotesSecControlFrame.document.forms[0].operation_mode.value;
	var image_linked_yn = "";
	if(operation_mode != "ModifyAddendum")
	{
		image_linked_yn = (opener.parent.RecClinicalNotesSectionFrame.document==null?"":opener.parent.RecClinicalNotesSectionFrame.document.RecClinicalNotesSectionForm.image_linked_yn.value);
	}
	//alert(image_linked_yn);

	if(editor_title=="Notes View")
	{
		var editor_reqd_yn	=	opener.parent.parent.RecClinicalNotesTabsFrame.document.forms[0].editor_reqd_yn.value;
		if(editor_reqd_yn=="Y")		editor_title	=	editor_title;
		else						editor_title	=	editor_title;
	}
	if(opener.parent.EditorTitleFrame.location!=null)
	{
		var qryString = "?editor_title="+encodeURIComponent(escape(editor_title),"UTF-8");
		if(operation_mode != "ModifyAddendum")
		{
			if(image_linked_yn != "")
			{
	//			alert('it is not an empty string1');
				qryString += "&image_linked_yn=" + image_linked_yn;
			}
		}
		//alert(qryString);
		opener.parent.EditorTitleFrame.location.href = "../../eCA/jsp/RecClinicalNotesEditorTitle.jsp" + qryString;
	}
}

function CheckDateNew(Object2,focusflag) {
	var datefield = Object2;
    if (ChkDateNew(Object2) == false) {
//        alert(getMessage("INVALID_DATE_FMT","CA"));
		
        if(focusflag == null)
        {
            datefield.select();
            datefield.focus();
        }
        return false;
    }
    else {
        return true;
    }
}

function ChkDateNew(Object3) {
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    var datefield = Object3;
    var strDateArray = new Array();
	var strYearArray = new Array();

    strDate = datefield.value;
    if (strDate.length == 0) return true;

if(Object3.value.indexOf('.') > 0) return false;

    strDateArray = strDate.split("/");
    if (strDateArray.length != 3) {
        return false;
    }
    else {
        strDay = strDateArray[0];
        strMonth = strDateArray[1];
        strYearArray = strDateArray[2].split(" ");
		strYear = strYearArray[0];
    }

    if (strYear.length < 4 || strYear.length > 4) return false;

    if (isNaN(strDay)==true) return false;
    if (isNaN(strMonth)==true) return false;
    if (isNaN(strYear)==true) return false;

    if (strYear < 1800) return false;

        if (strMonth>12 || strMonth<1)  return false;

    if ((strMonth == 1 || strMonth == 3 || strMonth == 5 || strMonth == 7 || strMonth == 8 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) return false;

    if ((strMonth == 4 || strMonth == 6 || strMonth == 9 || strMonth == 11) && (strDay > 30 || strDay < 1)) return false;

    if (strMonth == 2) {
        if (strDay < 1) return false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) return false;
        }
        else {
            if (strDay > 28) return false;
        }
    }
    return true;
}

var discr_range = new Array(); 
var i=0; 

function displaytt(obj)
{
	var desc_sh;
	
	var norm_range = getLabel("eCA.NormalRange.label","CA");
	var crit_range = getLabel("Common.Critical.label","Common")+" "+getLabel("Common.Range.label","Common");

 	for (var j=0;j<discr_range.length;++j  )
	{
 
		desc_sh =discr_range[j].split("$");
	
		
		if (desc_sh[0]==obj.name)
			{
				obj.title= norm_range+' : '+desc_sh[1]+' ~ '+desc_sh[2]+'  '+crit_range+' : '+desc_sh[3]+' ~ '+desc_sh[4] ;
			}
		
	}
		
}


function checkRec(obj)
  {
	
	if (obj.value!= "")
	{
		getServiceCode3();
		
	}
	else
	{
		document.forms[0].performed_by.value = "";
		document.forms[0].performed_by_code.value = "";
	}
  }

function checkRec2(obj)
  {
	
	if (obj.value!= "")
	{
		getServiceCode4();
	}
	else
	{
		document.forms[0].med_anc.value = "";
		document.forms[0].med_anc_code.value = "";
	}
  }

function getServiceCode3()
	{	
		var target			= document.forms[0].performed_by;
		var stdval          = document.forms[0].performed_by.value;
        var val				= document.forms[0].facilityid.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","COMMON");
		var locale			= document.forms[0].locale.value;
		
        var sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";

		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "2,1";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		retArray = CommonLookup( title, argArray );	
		
		if(retArray != null && retArray !="")
		{

			document.forms[0].performed_by.value = retArray[1];
		   	document.forms[0].performed_by_code.value = retArray[0];
			
		}
		else
		{
			document.forms[0].performed_by.value = "";
			document.forms[0].performed_by_code.value = "";
			
		}
	}
function getServiceCode4()
	{
		var target			= document.forms[0].med_anc;
		var stdval          = document.forms[0].med_anc.value;
		var retVal			=  new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.service.label",'COMMON');
		var locale			= document.forms[0].locale.value;

		var sql="SELECT service_code code, short_desc description from am_service_lang_vw where eff_status='E' and upper(short_desc) like upper(?) and service_code like UPPER(?) and language_id = '"+locale+"' ";
			
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
			
		if(retArray != null && retArray !="")
		{
			document.forms[0].med_anc.value = retArray[1];
			document.forms[0].med_anc_code.value = retArray[0];
		}
		else
		{
		document.forms[0].med_anc.value = "";
		document.forms[0].med_anc_code.value = "";
		}
   }

function getFormulaResult(current_item)

{  
	//alert(current_item.name);
	
/* var firstComponent;
 var secondComponent;
 if (document.RecClinicalNotesTemplateForm.systemDate99999A != null)
 { firstComponent = document.RecClinicalNotesTemplateForm.systemDate99999A.value;}
 if (document.RecClinicalNotesTemplateForm.C_LMP13 != null)
 { secondComponent = document.RecClinicalNotesTemplateForm.C_LMP13.value;}
 if (firstComponent != null && secondComponent != null)
  { var messageFrameReference = getMessageFrame(); 
	  if(messageFrameReference != null) 
		{	
			var HTML = '<form name="DateFormulaComputationForm" id="DateFormulaComputationForm" 	action="../../eCA/jsp/RecClinicalNotesComputeDateFormula.jsp" >'; 
			HTML += '<input type="hidden" name = "firstComponent" value = "' + firstComponent + '">'; 
			HTML += '<input type="hidden" name = "secondComponent" value = "' + secondComponent + '">'; 
			HTML += '<input type="hidden" name = "formulaResultUnit" value = "Days">'; 
			HTML += '<input type="hidden" name = "formulaCompID" value = "C_MC01GESTNAGE20~N~Days~MINUS%C_EDD14~D~Weeks~PLUS">'; 
			HTML += '<input type="hidden" name = "mcOnBlur" value = "Y">'; 
			HTML += '<input type="hidden" name = "formula_result_type" value = "">'; 
			HTML += '<input type="hidden" name = "formula_operator" value = "MINUS">'; 
			HTML += '</form>'; 
			messageFrameReference.document.body.insertAdjacentHTML('afterbegin', HTML); messageFrameReference.document.DateFormulaComputationForm.submit(); 
		 }
  }*/
}

function allowMaximumCharacters(obj)
{
	if(obj.value.length > 4000)
	{
		var msg = getMessage('ONLY_MAX_CHARS','CA');
		msg=msg.replace('$$','4000');
		alert(msg);
		obj.focus();
		return false;
	}
	else return true;
}

function roundNumber(number,decimal_points)
{
	if(number==undefined ) number=0;  //IN044955
	if(!decimal_points) return Math.round(number); 
	if(number == 0)
	{
		var decimals = '';
		for(var i=0;i<decimal_points;i++) decimals += '0';
		return '0.'+decimals;
	}
	//var exponent = Math.pow(10,decimal_points);//IN044211
	//var num = Math.round((number * exponent)).toString();//IN044211
	//return num.slice(0,-1*decimal_points) + '.' + num.slice(-1*decimal_points);	//IN044211
	return number.toFixed(decimal_points);//IN044211
}



function emailText()
{
	var patient_id = document.RecClinicalNotesSearchToolbarForm.patient_id.value;
	var encounter_id = document.RecClinicalNotesSearchToolbarForm.encounter_id.value;
	var enc_id = document.RecClinicalNotesSearchToolbarForm.enc_id.value;
	var accession_num = document.RecClinicalNotesSearchToolbarForm.accession_num.value;
	
//	if(encounter_id == '' || encounter_id == null || encounter_id == undefined) encounter_id = enc_id;

/*	if(enc_id == "" || enc_id == null) enc_id = "0";
	encounter_id = enc_id;  */	



	var messageFrameName = getMessageFrame();
	document.forms[0].method = 'post';
	document.forms[0].action = '../../eCA/jsp/RecClinicalNotesLinkMultiHistEmailDetails.jsp?patient_id='+patient_id+'&encounter_id='+encounter_id+'&accession_num='+accession_num;
	document.forms[0].target = messageFrameName.name;
	document.forms[0].submit();
}

// Added by Sridhar Reddy On 04/11/2009 PMG20089-CRF-0789
function loadFilterFunction(obj)
{
	if(obj.value != '')
	{			
			parent.CommonToolbar.filter_by.style.display = 'inline';
			var optlength = parent.CommonToolbar.filter.options.length;
			for (var i=0; i<optlength; i++)
			{
				parent.CommonToolbar.filter.options.remove("filter");
			}

			
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/CAMainFunctionFilterCriteria.jsp?function_id="+arr[0], false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText);
			eval(responseText);
			//alert(responseText);
			/*var HTMLVal="<html><body><form name='CAMainFunctionFilterForm' id='CAMainFunctionFilterForm' method='post' action='../../eCA/jsp/CAMainFunctionFilterCriteria.jsp'>"+
			"<input type='hidden' name='function_id' id='function_id' value='"+arr[0]+"'>"+
			"</form></body></html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin', HTMLVal);
			parent.messageFrame.document.CAMainFunctionFilterForm.submit(); */
		
		if(arr[1] == 'EX')
		{
			if(arr[3].indexOf("http://") == -1)
				arr[3] = "http://"+arr[3];
			window.open(arr[3],null,"height=570,width=1050,top=0,left=0,resizable=yes,status=yes,toolbar=yes,menubar=yes,location=yes");
		}
		else
		{
			top.content.CommonToolbar.displayFunctionName(arr[2]);
			var qs = document.refForm.queryString.value;
			
			//alert('arr[3]....'+arr[3]+'....option_id..'+arr[0]+'...qs...'+qs+'.....');
			if(arr[3].indexOf("?") != -1)
				top.content.workAreaFrame.location.href=arr[3]+'&option_id='+arr[0]+'&'+qs;
				//top.content.workAreaFrame.location.href=arr[3]+'&option_id='+arr[0]+'&'+qs+'&default_yn=Y';
			else
				top.content.workAreaFrame.location.href=arr[3]+'?option_id='+arr[0]+'&'+qs;
				//top.content.workAreaFrame.location.href=arr[3]+'?option_id='+arr[0]+'&'+qs+'&default_yn=Y';

		}
		obj.value = '';
	}
}
// End.

//Added by Sridhar Reddy on 01/12/2009 PMG20089-CRF-0789
function validateFromAndToDates(from,to,format,locale)
{		
	var currDate = getCurrentDate(format,locale);
 	if(from.value !="")
	{
		if(!validDateObj(from,format,locale))
		{			
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}
		
		/*if(!isBeforeNow(from.value,"DMYHM",locale))
		{
			alert(getMessage("FROM_DATE_GREATER_SYSDATE","CA"));
			document.forms[0].from_date_time.select();
			document.forms[0].from_date_time.focus();
			return false;
		}*/
		
	}

	if(to.value !="")
	{
		if(!validDateObj(to,format,locale))
		{			
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
		if(!dateZeroCheck(to))
		{
			return false;
		}
	/*	if(!isBeforeNow(to.value,"DMYHM",locale))
		{
			alert(getMessage("DATE_TIME_GREATER_SYSDATE","CA"));
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}*/
		
	}

	if(from.value !="" && to.value !="" )
	{
		if(!isBefore(from.value,to.value,"DMYHM",locale))
		{	
			alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
			document.forms[0].to_date_time.select();
			document.forms[0].to_date_time.focus();
			return false;
		}
	}
	return true;
}
// Added by Sridhar Reddy on 12/10/2010 to Fix the incident IN024111
function restrictPercentile(event)
{	
	if ((event.keyCode == 37))
			return false;		
	
	return true;

}
// Added by Sridhar Reddy on 07/02/2011 to Fix the incident IN026291
function populatePractitioner1(obj)
{
	if (obj.value != "")
	{
		populatePractitioner();
	}else{					
		obj.value = "";
		firstCodeVal ="";
		firstDescVal="";
		document.forms[0].forwarded_clinician_id.value = "";
		document.forms[0].pract_id.value = "";
	}	
}
function populatePractitioner()
{		
		var sql= "";
		var note_type			= document.RecClinicalNotesForwardForm.note_type.value;
		var clinician_id          = document.RecClinicalNotesForwardForm.clinician_id.value;
		var facility_id      = document.RecClinicalNotesForwardForm.facility_id.value;
		var locale			= document.RecClinicalNotesForwardForm.locale.value;
		var speciality_id			= document.RecClinicalNotesForwardForm.speciality_id.value;
		var target			= document.RecClinicalNotesForwardForm.forwarded_clinician_id;
       
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.practitioner.label","Common");
		//IN30050,starts
		var privRange = "";
		operation_mode = document.getElementById("operation_mode").value;
		privRange = "('3','4')";
		if((operation_mode == 'Forward'))
			privRange = "('3','4','5')";
		//IN30050,ends
		if (speciality_id=="")
		{
			//sql="select  distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where ib.note_type = '"+note_type+"' and ib.privilege_type in "+privRange+" and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and  a.practitioner_id=ia.func_role_id and b.language_id =  '"+locale+"' and a.facility_id ='"+facility_id+"' and b.practitioner_id = a.practitioner_id and a.practitioner_id != '"+clinician_id+"' and a.eff_status = 'E' and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2";//IN29476,IN30050
			sql="select  distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where ib.note_type = '"+note_type+"' and ib.privilege_type in "+privRange+" and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and  a.practitioner_id=ia.func_role_id and b.language_id =  '"+locale+"' and b.practitioner_id = a.practitioner_id and a.practitioner_id != '"+clinician_id+"' and a.eff_status = 'E' and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2";//IN035306
		}else{
			
			//sql = "select distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where b.language_id ='"+locale+"' and a.facility_id =  '"+facility_id+"' and b.practitioner_id = a.practitioner_id and a.practitioner_id != '"+clinician_id+"' and a.practitioner_id =ia.func_role_id and ib.note_type = '"+note_type+"' and ib.privilege_type in "+privRange+" and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and ( b.primary_speciality_code =  '"+speciality_id+"' or exists ( select 1 from am_pract_specialities where facility_id = a.facility_id and practitioner_id = a.practitioner_id and speciality_code =  '"+speciality_id+"' )) and a.eff_status = 'E' and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2 ";//IN29476,IN30050
			sql = "select distinct a.practitioner_id code, b.practitioner_name description from am_pract_for_facility a, am_practitioner_lang_vw b, ca_note_type_for_resp ib, sm_appl_user ia, sm_resp_for_user ic where b.language_id ='"+locale+"' and b.practitioner_id = a.practitioner_id and a.practitioner_id != '"+clinician_id+"' and a.practitioner_id =ia.func_role_id and ib.note_type = '"+note_type+"' and ib.privilege_type in "+privRange+" and ia.appl_user_id = ic.appl_user_id and ic.resp_id = ib.resp_id and ia.eff_status = 'E' and ( b.primary_speciality_code =  '"+speciality_id+"' or exists ( select 1 from am_pract_specialities where facility_id = a.facility_id and practitioner_id = a.practitioner_id and speciality_code =  '"+speciality_id+"' )) and a.eff_status = 'E' and upper (a.practitioner_id) like upper (?) and upper (b.practitioner_name) like upper (?) order by 2 ";//IN035306
		}
		
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		argArray[0] = sql;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
			document.forms[0].forwarded_clinician_id.value =retVal[1];
			document.forms[0].pract_id.value = retVal[0];		   	
		}
		else
		{
			document.forms[0].forwarded_clinician_id.value = "";
			document.forms[0].pract_id.value = "";
		} 
}
/*  
function populatePractitioner()
{
		var sql= "";
		var note_type			= document.RecClinicalNotesForwardForm.note_type.value;
		var clinician_id          = document.RecClinicalNotesForwardForm.clinician_id.value;		
		var speciality_id			= document.RecClinicalNotesForwardForm.speciality_id.value;
		var search_text			= document.RecClinicalNotesForwardForm.forwarded_clinician_id.value;
		alert("speciality_id   "+speciality_id);
       if (search_text != "")
		{
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr ="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "GET", "../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?callFrom=0&note_type="+note_type+"&clinician_id="+clinician_id+"&speciality_id="+speciality_id+"&search_text="+encodeURIComponent(search_text,"UTF-8"), false);
			xmlHttp.send( xmlDoc ) ;
			responseText=xmlHttp.responseText;
			responseText = trimString(responseText)
			responseText =trimString(responseText.substring(46,responseText.length));
			eval(responseText) ;
		}
		 if(firstCodeVal == "")
		{
			var retVal			= new String();
			var dialogTop		= "40";
			var dialogHeight	= "10" ;
			var dialogWidth		= "40" ;
			var dialogFeatures		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
			var arguments		= "" ;
			var search_desc		= "";
			var dialogUrl       = "../../eCA/jsp/RecClinicalNotesForwardPractLookup.jsp?note_type="+note_type+"&clinician_id="+clinician_id+"&speciality_id="+speciality_id+"&search_text="+encodeURIComponent(search_text,"UTF-8");
			retVal = window.showModalDialog(dialogUrl, dialogArguments, dialogFeatures);		
		
			if (retVal != null)
			{			
				document.forms[0].forwarded_clinician_id.value =trimString(retVal[1]);
				document.forms[0].pract_id.value = trimString(retVal[0]);		   	
			}
			else
			{
				document.forms[0].forwarded_clinician_id.value = "";
				document.forms[0].pract_id.value = "";
			} 
		}else{			
			document.forms[0].forwarded_clinician_id.value =trimString(firstDescVal);
			document.forms[0].pract_id.value = trimString(firstCodeVal);
		}
}*/
function chk_spl_char()
{
	var text_val=document.forms[0].search_text.value;
	if (text_val != "" && text_val !=undefined)
	{
		if(text_val.indexOf("#") !=-1)
		{
			 alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		  document.forms[0].search_text.value="";	
		}
	}
	
}
function allow_nosplchars( val ) {

	var text_val=val.value;
	if(text_val.indexOf("#") !=-1)
	{
		alert(getMessage("CANNOT_BE_SPECIAL_CHAR","Common"));
		val.value="";
	}
}
function onClickSearch() {
	var speciality_id = document.CriteriaForm.speciality_id.value;
	var clinician_id= document.CriteriaForm.clinician_id.value;
	var note_type= document.CriteriaForm.note_type.value;	
	var search_text= document.CriteriaForm.search_text.value;
	
	for (i=0;i< document.CriteriaForm.search_by.length;i++ )
	{
		if (document.CriteriaForm.search_by[i].checked)
		{
			var search_by= document.CriteriaForm.search_by[i].value;
		}
	}
	
	var search_criteria= document.CriteriaForm.search_criteria.value;
	var urlParams = "speciality_id="+speciality_id+"&clinician_id="+ clinician_id+"&note_type="+ note_type+"&search_text="+ encodeURIComponent(search_text,"UTF-8")+"&search_by="+ search_by+"&search_criteria="+ search_criteria;
	
	var url = "../../eCA/jsp/RecClinicalNotesForwardPractResult.jsp?"+urlParams;	
    parent.lookup_detail.location.href = url;	
}
function resetForm( formObj )
{
    formObj.reset();
	 formObj.Search.disabled=false;
    parent.lookup_detail.location.href = "../../eCommon/html/blank.html";

}
function returnPractitioner(code,description)
{
	var retVal = new Array();
	retVal[0] = trimString(code);
	retVal[1] = trimString(description);
	window.returnValue = retVal;
	window.close();
}
//[IN033180] Start.
function getRadioCheckedValue(radio_name)
{
   var oRadio = parent.RecClinicalNotesCTFrame.document.forms[0].elements[radio_name];
 
   for(var i = 0; i < oRadio.length; i++)
   {
      if(oRadio[i].checked)
      {
         return oRadio[i].value;
      }
   }
 
   return '';
}
//[IN033180] End.
//End

//IN037676, starts
function validateAddendumRecords(accession_num,note_type)
{ 
	var xmlDoc="";
	var xmlHttp = new XMLHttpRequest();
	task = 'ADDENDUM_EXISTS_CHECK';
	flag = "dummy";
	validate = "dummy";
	xmlStr	="<root><SEARCH " ;
	xmlStr += " task=\"" + task + "\" ";
	xmlStr += " validate=\"" + validate + "\" ";
	xmlStr += " flag=\"" + flag + "\" ";
	xmlStr += " accessnum=\""+ accession_num + "\"";
	xmlStr += " noteType=\""+ note_type + "\"";
	xmlStr +=" /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eCA/jsp/RecClinicalNotesValidate.jsp?validate=Y&task="+task+"&accessnum="+accession_num+"&noteType="+note_type, false) ;
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText;
	responseText = trimString(responseText);
	eval(responseText);
}
//IN037676, ends


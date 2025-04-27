//function assignSectionAddendum(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,operation_mode,AmendMode,RecordMode) //IN071264
function assignSectionAddendum(curr_sec_hdg_code,curr_child_sec_hdg_code,editor_title,operation_mode,AmendMode,RecordMode,autosave)//IN071264
{
	//alert("in assignSectionAddendum.....operation_mode."+operation_mode+"....AmendMode..."+AmendMode);
	messageFrameReference.location.href = '../../eCA/jsp/CAError.jsp';
	//IN037701 Starts
	/*var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.record_mode.value=RecordMode; //[IN033677]*/
	var Obj = "";
	if(undefined!= top.content && undefined!= top.content.workAreaFrame && undefined!=top.content.workAreaFrame.RecClinicalNotesFrame && undefined!=top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame && undefined != top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm )
	{
		Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
		top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.record_mode.value=RecordMode;
	}
	else{
		Obj = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.record_mode.value=RecordMode;
	}
	//IN037701 Ends
	var note_type			=	Obj.note_type.value;
	var patient_id			=	Obj.patient_id.value;
	var hdr_amendment_type	=	Obj.amendment_type;
	var url					=	parent.RecClinicalNotesSecDetailsFrame.location.href;
	
	var section_content = "";
	var prev_sec_hdg_code					=		Obj.prev_sec_hdg_code.value;
	var prev_child_sec_hdg_code				=		Obj.prev_child_sec_hdg_code.value;
	if(AmendMode!="Preview"){  //[IN040265]
		Obj.prev_sec_hdg_code.value				=		curr_sec_hdg_code;			
		Obj.prev_child_sec_hdg_code.value		=		curr_child_sec_hdg_code;
	}  //[IN040265]
	var encounter_id						=		Obj.encounter_id.value;
	var episode_type						=		Obj.episode_type.value;
	var patient_class						=		Obj.patient_class.value;

	if( url.indexOf('/eCA/jsp/RecClinicalNotesAddendumHeader.jsp')!=-1 )
	{
//		var txtRange			=	parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.value;	[IN032064]
		//var txtRange			=	removeHyperLink (parent.RecClinicalNotesRTEditorFrame.RTEditor0);	//[IN032064] //[IN033869]
		var txtRange			=	removeHyperLink (parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0);	//[IN033869]
		
		section_content	=	txtRange;
		if (parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content)
		{
			parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content.value = txtRange;
		}
		
//		parent.RecClinicalNotesSecDetailsFrame.document.RecClinicalNotesAddendumHeaderForm.txtAddendum.value = "";  	[IN032064]
		if(AmendMode!="Preview" && autosave!="Y" && autosave!="SD"){//IN071264		
		//parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0.document.body.innerHTML="";
		parent.RecClinicalNotesSecDetailsEditorFrame.RecClinicalNotesRTEditorFrame.RTEditor0.contentDocument.body.innerHTML="";
		}//[IN032064] //[IN033869]
		
	}
	else
	{
		section_content	=	"";
	}
	//IN071264 Starts
	if("Y"==autosave){
		operation_mode = "AutoSaveUpdate";
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value = "AutoSaveUpdate";
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode_as.value = operation_mode;
	}
	if("SD" == autosave){
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode.value = "SaveDraftUpdate";
		parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.operation_mode_as.value = operation_mode;
		operation_mode = "SaveDraftUpdate";
	}
	//IN071264 Ends
	
	//[IN038711] Start.
	//var action_url = '../../eCA/jsp/RecClinicalNotesSectionAddendumControl.jsp?curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&patient_id='+patient_id+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&ammend_mode='+AmendMode+'&record_mode='+RecordMode+'&encounter_id='+encounter_id+'&episode_type='+episode_type+'&patient_class='+patient_class;
	var action_url = '../../eCA/jsp/RecClinicalNotesSectionAddendumControl.jsp?curr_sec_hdg_code='+curr_sec_hdg_code+'&curr_child_sec_hdg_code='+curr_child_sec_hdg_code+'&editor_title='+encodeURIComponent(editor_title,"UTF-8")+'&operation_mode='+operation_mode+'&note_type='+note_type+'&patient_id='+patient_id+'&prev_sec_hdg_code='+prev_sec_hdg_code+'&prev_child_sec_hdg_code='+prev_child_sec_hdg_code+'&ammend_mode='+AmendMode+'&record_mode='+RecordMode+'&encounter_id='+encounter_id+'&episode_type='+episode_type+'&patient_class='+patient_class;
	//[IN038711] End.
	//	+'&section_content='+section_content;

	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.target =	parent.RecClinicalNotesSecControlFrame.name;

	//parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.section_content.value = section_content;
	
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.action	=	action_url;
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.method	=	'post';	
	parent.RecClinicalNotesSecControlFrame.document.RecClinicalNotesSecControlForm.submit();
	return true;
}

//**********for switching between the windows in Notes Preview Button
function getPreNotes()
{
	//alert();
	var refrence;	

		if(top.content.CommonToolbar==null) {
			if (parent.RecClinicalNotesToolbarFrame == null)
				reference=top.opener.top.content.CommonToolbar;				
			else
				reference =parent.RecClinicalNotesToolbarFrame;
				
		}
		else
			reference=top.content.CommonToolbar;	

		
	
	if(reference.previewWindowObjectReference!=null)
	{
		if(reference.previewWindowObjectReference.closed)
		{
			reference.previewWindowObjectReference = null;
		}
	}
	if(reference.previewWindowObjectReference == null)
	{	
		var qs = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.query_string.value;
		qs=qs.replace(/[$'%]/g, " ");//ML-MMOH-SCF-3073 
		var selectedNoteType = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_type.value;
		var appl_task_id = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.appl_task_id.value;
		var selectedNoteGroup = parent.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.note_group.value;
		var title = "";
		//alert("appl_task_id"+appl_task_id);
		if(selectedNoteType!="")
		{
			qs+="&parent_note_type="+selectedNoteType+"&parent_note_group="+selectedNoteGroup;
		}
		var action_url		=	'../../eCA/jsp/RecClinicalNotesPrevNotesMain.jsp?';
		//action_url			+=	qs;
		action_url			+=	qs+"&prev_notes=Y";//IN043031
		
		reference.previewWindowObjectReference	=	window.open(action_url,title,"height=592.5,width=790,top=80,left=100,status=NO,toolbar=no,menubar=no,location=no");
		
		//parent.RecClinicalNotesToolbarFrame.focus();
		/*
		var dialogHeight= "41.5";
		var dialogWidth	= "50";
		var dialogTop		= "140";
		var dialogLeft		= "0";
		var status = "no";
		var arguments	= "";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogTop:"+ dialogTop+ "; dialogLeft:"+ dialogLeft +" ; scroll=no; status:" + status;
		*/
		//var features =  "";// "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;

		//var arguments ="";


		//retVal = window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&event_desc="+eventdesc+"&from=B&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code,arguments,features);
		/*reference.previewWindowObjectReference = window.showModalDialog(action_url,arguments,features);*/
		
	}
	else
	{
		reference.previewWindowObjectReference.focus();		
	}	
}
//********************

//Functions for the file name RecClinicalNotesTree.jsp-start

function showDetails(vals,check)
{
	//alert("vals : "+vals);
	//alert(document.forms[0].selected_events.value);
	var arr = vals.split("~");
	/*var patientid		= document.forms[0].patient_id.value;
	var accessionnum= escape(arr[0])==null?"":escape(arr[0]);
	var datatype		= arr[1]==null?"":arr[1];
	var histtype		= arr[2]==null?"":arr[2];
	var eventdatetime	= arr[3]==null?"":arr[3];
	var eventclass	= arr[4]==null?"":arr[4];
	var eventgroup= arr[5]==null?"":arr[5];
	var eventitem	= arr[6]==null?"":arr[6];*/
	var patientid				=	document.forms[0].patient_id.value;
	var accessionnum			=	escape(arr[0])==null?"":escape(arr[0]);
	var datatype				=	arr[1]==null?"":arr[1];
	var histtype				=	arr[2]==null?"":arr[2];
	var contr_sys_id			=	arr[3]==null?"":arr[3];
	var contr_sys_event_code	=	arr[4]==null?"":arr[4];
	var eventdatetime			=	arr[5]==null?"":arr[5];
	var eventclass				=	arr[6]==null?"":arr[6];
	var eventgroup				=	arr[7]==null?"":arr[7];
	var eventitem				=	arr[8]==null?"":arr[8];
		
	
	document.forms[0].data_type.value=datatype;
	var params = '?patient_id='+patientid+'&hist_type='+histtype+'&event_class='+eventclass+'&event_group='+eventgroup+'&event_item='+eventitem+'&event_date='+eventdatetime+'&data_type='+datatype+'&contr_sys_id='+contr_sys_id+'&contr_sys_event_code='+contr_sys_event_code;

	if(check!='Heading')
	{
		params+='&accession_num='+accessionnum;
	}
	if(datatype == "TXT" && check!="Heading")
	{
		
		parent.RecClinicalNotesLinkDocsViewFrame.location.href = "../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&from=B&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code;		
	}
	else
	{	
		parent.RecClinicalNotesLinkDocsViewFrame.location.href = '../../eCA/jsp/RecClinicalNotesDisplay.jsp'+params;		
	}
}
function OnCheckBoxClick(obj)
{
	var name=obj.name;
	var val=document.forms[0].selected_events.value;
	if(obj.checked)
	{
		if(val.indexOf(name)==-1)
			val+=name+"~";
	}
	else
	{
		//alert("previous:"+val);
		if(val.indexOf(name)!=-1)
			val=val.replace(name+"~","");
		//alert("new:"+val);
	}
	document.forms[0].selected_events.value=val;
}
function CheckAllCode(groupCode,eventDate,eventClass,obj,classIndex,eventTime,index)
{
	if(index==null)
		index=0;
	var cbObject=null;
	if(obj.checked)
	{
		//alert("calling OnCheckBoxClick"+eventDate+classIndex+eventClass+groupCode+index);
		while((cbObject=eval("document.forms[0].a"+eventDate+classIndex+eventClass+groupCode+eventTime+index))!=null)
		{
			cbObject.checked=true;
			eventTime = cbObject.title;
			//alert("inside while");
			//alert("calling OnCheckBoxClick"+eventDate+eventClass+groupCode+index);
			OnCheckBoxClick(cbObject);
			index++;
		}
		return eventTime;
	}
	else
	{
		while((cbObject=eval("document.forms[0].a"+eventDate+classIndex+eventClass+groupCode+eventTime+index))!=null)
		{
			//alert(index);
			cbObject.checked=false;
			eventTime = cbObject.title;
			OnCheckBoxClick(cbObject);
			index++;
		}
		return eventTime;
	}
}//CheckAllGroup('_','27k02k2004','CLI4',this,0) a27k02k20040CLI4_17c260
function CheckAllGroup(groupCode,eventDate,eventClass,obj,classIndex)
{
	//alert('CheckAllGroup');
	var index=0;
	var cbObject=null;
	if(obj.checked)
	{
		//alert("previous values  with "+eventDate+eventClass+groupCode)
		curTime=obj.title;
		CheckAllCode("_",eventDate,eventClass,obj,classIndex,curTime);
		while((cbObject=eval("document.forms[0].a"+eventDate+classIndex+eventClass+index))!=null)
		{
			curTime=cbObject.title;
			curGroupCode=cbObject.value;//a11k12k20035EMSVANTENATAL12c340
			cbObject.checked=true;//a11k12k20035EMSV_10c571
			//cbObject.disabled=true;
			//alert("calling CheckAllCode with "+eventDate+eventClass+curGroupCode);
			lastEventTime = CheckAllCode(curGroupCode,eventDate,eventClass,cbObject,classIndex,curTime);
			//the case in which there is no group heading for the first set of events   
			//the case in which there is no group heading for the subsequent or last set of events in the same class
			CheckAllCode("_",eventDate,eventClass,obj,classIndex,lastEventTime,index);
			//----------------------------------------------------------------------
			groupCode=curGroupCode;
			index++;					
		}
						
	}
	else
	{
		curTime=obj.title;
		CheckAllCode("_",eventDate,eventClass,obj,classIndex,curTime);
		while((cbObject=eval("document.forms[0].a"+eventDate+classIndex+eventClass+index))!=null)
		{
			curTime=cbObject.title;
			curGroupCode=cbObject.value;
			cbObject.checked=false;
			//cbObject.disabled=false;
			lastEventTime = CheckAllCode(curGroupCode,eventDate,eventClass,cbObject,classIndex,curTime);
			CheckAllCode("_",eventDate,eventClass,obj,classIndex,lastEventTime,index);
			groupCode=curGroupCode;
			index++;
		}
		

	}
	
}
function CheckAllClass(groupCode,eventDate,eventClass,obj)
{
	var index=0;
	var cbObject=null;
	if(obj.checked)
	{
		
		while((cbObject=eval("document.forms[0].a"+eventDate+index))!=null)
		{
			//alert('into while');
			cbObject.checked=true;
			//cbObject.disabled=true;
			var arr = cbObject.value.split("~");
			var curClassCode=arr[0];
			var curGroupCode=arr[1];
			//alert("calling CheckAllGroup with "+eventDate+curClassCode+curGroupCode);
			CheckAllGroup(curGroupCode,eventDate,curClassCode,cbObject,index);
			eventClass=curClassCode;
			groupCode=curGroupCode;
			index++;
			
		}
		//alert("calling again CheckAllGroup with "+eventDate+eventClass+groupCode);
		//CheckAllGroup(groupCode,eventDate,eventClass,obj);
		
	}
	else
	{
		while((cbObject=eval("document.forms[0].a"+eventDate+index))!=null)
		{
			cbObject.checked=false;
			//cbObject.disabled=false;
			var arr = cbObject.value.split("~");
			var curClassCode=arr[0];
			var curGroupCode=arr[1];
			CheckAllGroup(groupCode,eventDate,curClassCode,cbObject,index);
			eventClass=curClassCode;
			groupCode=curGroupCode;
			index++;
		}
		//CheckAllGroup(groupCode,eventDate,eventClass,obj);
		
		

	}
	
}


//Functions for the file name RecClinicalNotesTree.jsp-end


//Functions for the file name RecClinicalNotesDisplay.jsp-start


function showPopUp(obj,encdtls)
{
	var data = ''
	for(var i=0;i<encdtls.length;i++)
			encdtls=encdtls.replace('$','</br>');
	data = encdtls+"<br>";
	if(document.getElementById("encDetailsLayer") != null)
	{
			var tabdata ="<table cellpadding=3 cellspacing=0 border=0 align=center ><tr><td class=OAYELLOW>";
			tabdata+=data;				
			tabdata += "</td></tr></table>";
			document.getElementById("encDetailsLayer").innerHTML = tabdata; 
			document.getElementById("encDetailsLayer").style.top  = obj.offsetTop;
			document.getElementById("encDetailsLayer").style.left  =obj.offsetLeft+50 ;
			document.getElementById("encDetailsLayer").style.visibility='visible' ;
	}
	else
		  hidePopUp();
	}
function hidePopUp()
{
	if(document.getElementById("encDetailsLayer") != null)
		document.getElementById("encDetailsLayer").style.visibility='hidden' ;
}

async function showDocDetails(datatype,histtype,accessionnum,eventdesc,contr_sys_id,contr_sys_event_code)
{
	//alert(datatype);
	//alert(histtype);
	accessionnum=escape(accessionnum);
	//alert(eventdesc);
	if(parent.DisplayResult!=null)
	{
		parent.DisplayResult.location.href = "../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&event_desc="+eventdesc+"&from=A&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code;
	}
	else
	{
		var win_height		= "23";
		var win_width		= "37";
		var	win_scroll_yn	= "no";
		if(histtype=='CLNT')
		{
			win_scroll_yn = 'auto';
		}
		
		var dialogHeight = win_height ;
		var dialogWidth = win_width ;
		var dialogTop = "122";
		var status = "no";
		var scroll = win_scroll_yn;
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;

		retVal =await window.showModalDialog("../../eCA/jsp/EncountersDocDisplay.jsp?data_type="+datatype+"&hist_type="+histtype+"&accession_num="+accessionnum+"&event_desc="+eventdesc+"&from=B&contr_sys_id="+contr_sys_id+"&contr_sys_event_code="+contr_sys_event_code,arguments,features);
		
	}
}
//**********added to show comments in saparate dialog box-----for showing the short Text
async function ShowComments(resultStr)
	{
		var comments;
		var retVal;
		var dialogHeight ='9' ;
		var dialogWidth = '30' ;
		var features 	= 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; scroll=no; status=no';
		retVal 			=await window.showModalDialog('../../eCA/jsp/ResComments.jsp?resultStr='+resultStr,arguments,features);
	}
//***********************************************
//for showing the long text in case of NUM
async function getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)
{

	var win_height		= "28";
	var win_width		= "50";
	var win_scroll_yn	= "yes";

	if(Histrectype != 'CLNT'){
		win_height		= "23";
		win_width		= "37";
		win_scroll_yn	= "no";
	}

	var retVal = new String();
	//var dialogHeight = "28" ;
	//var dialogWidth = "50" ;

	var dialogHeight = win_height ;
	var dialogWidth = win_width ;
	var dialogTop = "122";
	var status = "no";
	var scroll = win_scroll_yn;
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:"+ status + "; scroll:"+ scroll+";dialogTop :" + dialogTop;
	var arguments	= Accessionnum ;

	Accessionnum	=	escape(Accessionnum);
	retVal = await window.showModalDialog("../../eCA/jsp/FlowSheetText.jsp?Histrectype="+Histrectype+"&Contrsysid="+Contrsysid+"&Accessionnum="+Accessionnum+"&Contrsyseventcode="+Contrsyseventcode,arguments,features);
}


//Functions for the file name RecClinicalNotesDisplay.jsp-end


//Functions for the file name RecClinicalNotesPrevNotesSearchDetail.jsp -start


function scrollTitle(){
  var x = document.body.scrollTop;
  if(x == 0){
   document.getElementById("divTitleTable").style.position = 'static';
   document.getElementById("divTitleTable").style.posTop  = 0;
  }else{
	document.getElementById("divTitleTable").style.position = 'relative';
	document.getElementById("divTitleTable").style.posTop  = x-2;

  }

}
var reOrder='';
var scrollLeft='';
function callForOrderBy(obj){
	//alert(obj);
	//alert(reOrder);
	document.forms[0].orderBy.value=obj;
	document.forms[0].reOrder.value=reOrder;
	document.forms[0].submit();

}
function changeColor(object){
	//scrollLeft=document.body.scrollLeft;
	if(object.style.color=='yellow'){
		reOrder='1';
		object.style.color='pink';
		return;
	}
	if(object.style.color=='pink'){
		reOrder='2';
		object.style.color='yellow';
		return;
	}
	reOrder='1';
	for(i=0;i<document.anchors.length;i++){
		document.anchors(i).style.color='white';

	}
	object.style.color='pink';
}
function alignUnitsAndData(){
	if(document.getElementById("tb1").rows!=null){
		var totalRows =  document.getElementById("tb1").rows.length-1;
		var temp = document.getElementById("titleTable").rows(0).cells.length;
		//alert(temp);
		//alert(totalRows);
		for(var i=0;i<temp;i++) {
			document.getElementById("titleTable").rows[0].cells[i].width=document.getElementById("tb1").rows[totalRows].cells[i].offsetWidth;
		}
	}
}


//Functions for the file name RecClinicalNotesPrevNotesSearchDetail.jsp -end


function call_notes(accession_num)
{

	//parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href = '../../eCA/jsp/ViewClinicalNoteNoteContentDeatail.jsp?accession_num='+accession_num+'&no_modal='+no_modal+'&note_group='+note_group+'&statustxt='+statustxt+'&fun=VCN&called_function_id='+called_function_id; 
	no_modal = "Y";
	parent.RecClinicalNotesPrevNotesSearchNotesDetailFrame.location.href = '../../eCA/jsp/RecClinicalNotesPrevNotesSearchNotesDetail.jsp?accession_num='+accession_num+'&no_modal='+no_modal; 

}
async function getTransReq()
{
	var Obj = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm;
	
	var note_type			=	Obj.note_type.value;
	var patient_id			=	Obj.patient_id.value;
	var encounter_id		=	Obj.encounter_id.value;
	var performed_by_id		=	Obj.performed_by_id.value;
	var speciality_code		=	Obj.speciality_code.value;
	var patient_class		=	Obj.patient_class.value;

	var retVal = 	new String();
	var dialogHeight= "67vh" ;
	var dialogTop = "150" ;
	var dialogWidth	= "50vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var retVal = await window.showModalDialog("../../eCA/jsp/RecClinicalNotesTransReqPopupMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&note_type="+note_type+"&performed_by_id="+performed_by_id+"&speciality_code="+speciality_code+"&patient_class"+patient_class,arguments,features);
}

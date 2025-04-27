function recordProgression(){
	//var queryString = parent.matFrame.tempmaternityMenu.queryString.value;
	
	var ProgressNotes = parent.matcycleframe.matconsscycle.ProgressNotes.value;
	if(ProgressNotes==''||ProgressNotes==null)
	{
		alert(getMessage("NOTE_NOT_SELECTED","CA"));
		return false;
	}
	parent.matcycleframe.matconsscycle.queryString.value = parent.parent.matFrame.maternityeventframe.tempmaternityMenu.queryString.value;
	parent.matcycleframe.matconsscycle.mode.value='NEW'
	parent.matcycleframe.document.matconsscycle.action='../../servlet/eCA.ProgressNotesServlet';
	parent.matcycleframe.document.matconsscycle.target='messageFrame';
	parent.matcycleframe.document.matconsscycle.method='post';
	parent.matcycleframe.document.matconsscycle.submit();
}

function callfunction(){
	//top.content.CommonToolbar.ShowMenu.style.display='none';
	//top.content.CommonToolbar.HideMenu.style.display='inline';
}

function loadeventselect(selObj){
	var module_id = document.tempmaternityMenu.module_id.value;
	var patient_id = document.tempmaternityMenu.patient_id.value;
	var progression_no = document.tempmaternityMenu.progression_select.value;
	
	if(selObj.value != '')
	{
		var obj=document.tempmaternityMenu.progression_select.value
		
		if(obj!=0)
		{
			parent.maternitytreeframe.location.href = '../../eCA/jsp/ProgressNotesMenu.jsp?'+'sel_progression_no='+progression_no+'&'+document.tempmaternityMenu.queryString.value;
			
			top.content.workAreaFrame.location.href = '../../eCommon/html/blank.html'
			//parent.parent.workAreaFrame.location.href = '../../eCA/jsp/CycleFrame.jsp?module_id='+module_id+'&patient_id='+patient_id+'&cycle_no='+progression_no;
		}
	}
	else
	{
		loadeventscycle('');
	}
}


function loadeventscycle(NewEvent){
	var queryString = document.tempmaternityMenu.queryString.value;
	//alert("queryString"+queryString);
	parent.parent.workAreaFrame.location.href = '../../eCA/jsp/ProgressNotesMain.jsp?NewEvent='+NewEvent+'&'+queryString+'&new_cycle=N';
	parent.parent.matFrame.maternitytreeframe.location.href = '../../eCommon/html/blank.html';
}

function chkNoteStatus(obj)
{

	var progression_ref = document.forms[0].progression_ref.value;
	var patient_id = "";
	
	if(obj.value=='C')
	{
		var answer = confirm(getMessage("PROGRESSION_CLOSE","CA"));
		//var answer = confirm('This will close the progression.Do you want to continue ? ');
		
		if(answer)
		{
			var xmlDoc="";
			var xmlHttp = new XMLHttpRequest();
			xmlStr	="<root><SEARCH " ;
			xmlStr +=" /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open( "POST","../../eCA/jsp/ProgressNotesIntermediate.jsp?patient_id="+patient_id+"&mode=NTstat&progression_ref="+progression_ref, false);
			xmlHttp.send(xmlDoc);
			responseText=xmlHttp.responseText;
			responseText = eval(responseText);
		}
	
	}

}

function close_progression(status)
{

	if(status=='Y')
	{
		parent.workAreaFrame.matconsscycle.queryString.value = parent.matFrame.maternityeventframe.tempmaternityMenu.queryString.value ;	
		parent.workAreaFrame.matconsscycle.mode.value='CLOSE';	
		parent.workAreaFrame.matconsscycle.action='../../servlet/eCA.ProgressNotesServlet';
		parent.workAreaFrame.matconsscycle.target='messageFrame';
		parent.workAreaFrame.matconsscycle.method='post';
		parent.workAreaFrame.matconsscycle.submit();
		
	}
	else
	{
		
		alert(getMessage("PROGRESS_NOTE_NOT_SIGNED","CA"));
		//alert('Please Sign All the notes before Closing the progression...');
		// All the notes recorded Under the progression are not Signed.Can't proceed.
		//Unsigned notes exists.can't close the progression.

	}


}

function viewProgression(progression_ref,access_yn)
{
	
	if(access_yn=='Y'){
		parent.parent.workAreaFrame.location.href = '../../eCA/jsp/ProgressNotesView.jsp?progression_ref='+progression_ref+'&level=PN';
	}
	else
	{
		parent.parent.workAreaFrame.location.href = '../../eCA/jsp/ProgressNotesAccessMsg.jsp';
	}
}

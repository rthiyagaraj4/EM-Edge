function clear_result()
{
	var note_type=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].note_type.value;
	top.content.workAreaFrame.PhysicainNoteResult.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.PhysicainNoteResultDetails.document.location.href = '../../eCommon/html/blank.html'; 
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].from_date.value="";
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].to_date.value="";
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].note_type.value="";
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].performed_by.value="";
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].status.value="";
	top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].med_anc.value="";
	if(top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi)
	  top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi.checked=true;
}

function search_result()
{

	top.content.workAreaFrame.PhysicainNoteResultDetails.document.location.href = '../../eCommon/html/blank.html'; 
		
	var note_type=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].note_type.value;
	var from_date=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].from_date.value;
	var to_date=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].to_date.value;

	var performed_by=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].performed_by.value;
	var med_anc=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].med_anc.value;
	var status=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].status.value;
	var p_event_class=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].p_event_class.value;
	var patient_id=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].patient_id.value;
	var episode_id=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].episode_id.value;
	var visit_id=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].visit_id.value;
	var episode_type=top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].episode_type.value;
	var from_query="Y";

	if(!doDateCheckFrom(top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].to_date,top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].from_date))
		return ;

	var cur_epi=''; 
	if(top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi)
	{
		if(top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi.checked ==true){
			top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi.value='Y';
		}
		else{
			top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi.value='N';
		}
		if(top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi)
			  cur_epi = top.content.workAreaFrame.PhysicainNoteQuery.document.forms[0].cur_epi.value;
	}		  
	top.content.workAreaFrame.PhysicainNoteResult.document.location.href = '../../eCA/jsp/PhysicianNotesResult.jsp?patient_id='+patient_id+'&note_type='+note_type+'&p_event_class='+p_event_class+'&episode_type='+episode_type+'&visit_id='+visit_id+'&episode_id='+episode_id+'&cur_epi='+cur_epi+'&from_query='+from_query+'&performed_by='+performed_by+'&med_anc='+med_anc+'&status='+status+'&from_date='+from_date+'&to_date='+to_date; 
	top.content.messageFrame.location.href = '../../eCommon/jsp/error.jsp';
}

async function call_details(accession_num)
{ 
	accession_num=accession_num;
	var retVal = 	""; //new String();
	var dialogTop="10px";
	var dialogHeight= "90vh" ;
	var dialogWidth	= "80vw" ;
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogTop:" + dialogTop + "; dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll:auto; status:" + status;
	retVal = await top.window.showModalDialog('../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num='+accession_num,arguments,features);
}

function call_notes(accession_num)
{
	accession_num=accession_num;
	var no_modal="Y";
	top.content.workAreaFrame.PhysicainNoteResultDetails.document.location.href = '../../eCA/jsp/PhysicianNotesDetailsFrame.jsp?accession_num='+accession_num+'&no_modal='+no_modal; 
}

function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}




//functions for the file name PhysicianNotesResult.jsp-start

function scrollTitle()
{
  var y = parent.PhysicainNoteResult.document.body.scrollTop;

  if(y == 0){
	parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.position = 'static';
	parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.posTop  = 0;
  }else{
	parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.position = 'relative';
	parent.PhysicainNoteResult.document.getElementById("divDataTitle").style.posTop  = y-2;
  }

}


function alignWidth()
{
	var totalRows =  parent.PhysicainNoteResult.document.getElementById("dataTable").rows.length;
	var counter = totalRows-1;
	var temp = parent.PhysicainNoteResult.document.getElementById("dataTitleTable").rows(0).cells.length;
	for(var i=0;i<temp;i++) 
	{
	parent.PhysicainNoteResult.document.getElementById("dataTitleTable").rows(0).cells(i).width=parent.PhysicainNoteResult.document.getElementById("dataTable").rows(counter).cells(i).offsetWidth;
	}
}

//functions for the file name PhysicianNotesResult.jsp-end

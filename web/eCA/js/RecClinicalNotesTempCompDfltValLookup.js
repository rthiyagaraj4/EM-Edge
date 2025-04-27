/*
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
11/04/2017  IN061905       	DineshT     25/4/2016		Ramesh G   		The Scoring functionality In Notes should work in the similar manner as in Charts i.e on selection of individual variable, the score gets automatically calculated.
17/11/2021	21099			Ramesh Goli	17/11/2021		Ramesh G		Subject: Popup message dialog cannot display prompt message in Thai language.	
--------------------------------------------------------------------------------------------------------------------------------
*/
async function openDefaultLookUp(compPrompt,comp_type,comp_name,hist_rec_type,event_code,old_hist_time_frame_val,old_hist_time_frame_unit)
{
//if(top.content!=null)
//{

	var prev_val = eval("document.forms[0]."+comp_name+".value");
	var pat_id = "";
	var enc_id = "";

	if(top.content!=null)
	{
		if(top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame != null)
		{
			pat_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.patient_id.value;

			enc_id = top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesHeaderFrame.document.RecClinicalNotesHeaderForm.encounter_id.value;
		}
	}

	if(pat_id != '')
	{
		var dialogHeight= "50vh" ;
		var dialogWidth	= "50vw";
		var dialogTop	= "150";
		var dialogLeft	= "250";
		var arguments	= "" ;
		var retVal = "";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+" ;dialogLeft="+dialogLeft+";scroll=auto; status:no ";
		// 21099 Start.
		//retVal = window.showModalDialog("../../eCA/jsp/RecClinicalNotesTempCompDfltValLookupMain.jsp?patient_id="+pat_id+"&encounter_id="+enc_id+"&hist_rec_type="+hist_rec_type+"&event_code="+event_code+"&old_hist_time_frame_val="+old_hist_time_frame_val+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&comp_name="+comp_name+"&compPrompt="+compPrompt,arguments,features);
		retVal = await top.window.showModalDialog("../../eCA/jsp/RecClinicalNotesTempCompDfltValLookupMain.jsp?patient_id="+pat_id+"&encounter_id="+enc_id+"&hist_rec_type="+hist_rec_type+"&event_code="+event_code+"&old_hist_time_frame_val="+old_hist_time_frame_val+"&old_hist_time_frame_unit="+old_hist_time_frame_unit+"&comp_name="+comp_name+"&compPrompt="+encodeURI(compPrompt),arguments,features);
		// 21099 End.
		if(retVal!="" && retVal!=null && retVal.length!=null ){
			var split_val = retVal.split("~");
			var date = split_val[0].split(" ");
			if(comp_type=="H")
				eval("document.forms[0]."+comp_name).value=split_val[1];
			else if(comp_type =="D")
				eval("document.forms[0]."+comp_name).value=date[0];
			else if(comp_type =="I")
			{
				eval("document.forms[0]."+comp_name).value=split_val[1];
				eval("document.forms[0]."+comp_name).onblur();//IN061905
			}
			else if(comp_type =="E")
				eval("document.forms[0]."+comp_name).value=split_val[0];
			else if(comp_type =="T")
				eval("document.forms[0]."+comp_name).value=date[1];
			else if(comp_type =="N")
			{
				eval("document.forms[0]."+comp_name).value=split_val[1];
				eval("document.forms[0]."+comp_name).onblur();//IN061905
			}
		}
		else
		{
			eval("document.forms[0]."+comp_name).value=prev_val;
		}
	}// end of  if pat_id != ''
	else
	{
		alert(getMessage("CHK_IN_TRANS","CA"));
	}// end of else pat_id != ''
//}
}

function ShowHistoryValue(eventDateTime,value)
{
	var ret_val = eventDateTime+"~"+value
	window.returnValue = ret_val;
	window.close();
}

function closeWin()
{
	window.returnValue = "";
	window.close();
}

function staticTitle()
{
	var scrollXY = document.body.scrollTop;	
	document.getElementById("tableTitle").style.position = 'relative';
	document.getElementById("tableTitle").style.posTop  = parseInt(scrollXY) - 2;
}
